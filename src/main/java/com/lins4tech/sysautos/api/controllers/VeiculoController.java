package com.lins4tech.sysautos.api.controllers;

import com.lins4tech.sysautos.api.dtos.EntradaVeiculoSaveDto;
import com.lins4tech.sysautos.api.dtos.VeiculoApiProcobDto;
import com.lins4tech.sysautos.api.dtos.VeiculoInfoDto;
import com.lins4tech.sysautos.api.dtos.VendaVeiculoSaveDto;
import com.lins4tech.sysautos.api.entities.*;
import com.lins4tech.sysautos.api.enums.StatusVeiculoEnum;
import com.lins4tech.sysautos.api.procob.veiculo.VeiculoApiProcobJson;
import com.lins4tech.sysautos.api.services.ClienteService;
import com.lins4tech.sysautos.api.services.LojaService;
import com.lins4tech.sysautos.api.services.VeiculoService;
import com.lins4tech.sysautos.api.utils.ConvertDtoUtil;
import com.lins4tech.sysautos.api.vos.VeiculoInfoVO;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/api/veiculo")
@CrossOrigin(origins = "*")
public class VeiculoController {

    private static final Logger log = LoggerFactory.getLogger(VeiculoController.class);

    private static final String procobAuthorization = "bGV1cmltYXIubGluc0BnbWFpbC5jb206TXVkYXIyODA3";

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private LojaService lojaService;

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/findVeiculo", method = RequestMethod.GET)
    public ResponseEntity<List<VeiculoInfoDto>> findVeiculo(
            @RequestParam(value = "lojaId") Long lojaId,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "placa", required = false) String placa,
            @RequestParam(value = "modelo", required = false) String modelo,
            @RequestParam(value = "marca", required = false) String marca,
            @RequestParam(value = "anoFabricacao", required = false) Integer anoFabricacao,
            @RequestParam(value = "anoModelo", required = false) Integer anoModelo,
            @RequestParam(value = "renavam", required = false) String renavam,
            @RequestParam(value = "chassis", required = false) String chassis,
            @RequestParam(value = "pag", defaultValue = "0") Integer pag,
            @RequestParam(value = "ord", defaultValue = "nomeCompleto") String ord,
            @RequestParam(value = "dir", defaultValue = "DESC") String dir,
            @RequestParam(value = "size", defaultValue = "30") Integer size) {

        PageRequest pageRequest = PageRequest.of(pag, size, Sort.Direction.valueOf(dir), ord);
        log.info("Chamada ao VeiculoController.findVeiculo - LojaId = {}", lojaId);


        StatusVeiculoEnum statusVeiculo = null;
        if(status != null) {
            statusVeiculo = StatusVeiculoEnum.valueOf(status);
        }

        List<VeiculoInfoVO> veiculoInfoVOs = veiculoService.find(lojaId, statusVeiculo, placa, modelo, marca, anoFabricacao, anoModelo, renavam, chassis, pageRequest);

        return new ResponseEntity<>(ConvertDtoUtil.parseListVeiculoInfoVoToListVeiculoInfoDto(veiculoInfoVOs), HttpStatus.OK);
    }

    @RequestMapping(value = "/findVeiculoByPlacaProcobApi", method = RequestMethod.GET)
    public ResponseEntity<VeiculoApiProcobDto> findVeiculoByPlacaProcobApi(
            @RequestParam(value = "lojaId") Long lojaId,
            @RequestParam(value = "placa") String placa) {

        log.info("Chamada ao VeiculoController.findVeiculoByPlacaProcobApi - LojaId = {}, Placa = {}", lojaId, placa);

        if(placa == null || placa.length() < 7) {
            return null;
        }

        VeiculoApiProcob veiculoApiProcob = veiculoService.findVeiculoApiProcobByPlaca(placa);
        if(veiculoApiProcob == null) { //A placa nunca foi consultada.
            //https://api.procob.com/veiculos/v2/V0001?placa=MOS8086&agregados=SIM

            ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
            RestTemplate restTemplate = new RestTemplate(requestFactory);
            HttpHeaders headers = new HttpHeaders();
//            headers.add("Authorization", "Basic " + procobAuthorization);
            headers.add("Authorization", "Basic " + "c2FuZGJveEBwcm9jb2IuY29tOlRlc3RlQXBp");
            HttpEntity<String> request = new HttpEntity<>(headers);

            List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
            MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
            converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
            messageConverters.add(converter);
            restTemplate.setMessageConverters(messageConverters);
            String url = "https://api.procob.com/veiculos/v2/V0001?agregados=SIM&placa=" + placa;
            ResponseEntity<VeiculoApiProcobJson> response = restTemplate.exchange(url, HttpMethod.GET, request, VeiculoApiProcobJson.class);
            if(response.getBody().getCode().equals("000") || response.getBody().getCode().equals("009")) {
                VeiculoApiProcob entity = ConvertDtoUtil.parseVeiculoApiProcobJsonToEntity(response.getBody());
                entity.setDataUltimaConsulta(new Date());
                veiculoService.saveVeiculoApiProcob(entity);
                return new ResponseEntity<>(ConvertDtoUtil.parseVeiculoApiProcobToDto(entity), HttpStatus.OK);
            }else{
                return null;
            }
        }
        return new ResponseEntity<>(ConvertDtoUtil.parseVeiculoApiProcobToDto(veiculoApiProcob), HttpStatus.OK);
    }

    @RequestMapping(value = "/findVeiculoByPlaca", method = RequestMethod.GET)
    public ResponseEntity<VeiculoInfoDto> findVeiculoByPlaca(
            @RequestParam(value = "lojaId") Long lojaId,
            @RequestParam(value = "placa") String placa) {

        log.info("Chamada ao VeiculoController.findVeiculoByPlaca - LojaId = {}, Placa = {}", lojaId, placa);

        if(placa == null || placa.length() < 7) {
            return null;
        }

        List<VeiculoInfoVO> listVO = veiculoService.find(lojaId, null, placa, null, null, null, null, null, null, null);
        if(listVO != null && !listVO.isEmpty()) {
            List<VeiculoInfoDto> listDTO = ConvertDtoUtil.parseListVeiculoInfoVoToListVeiculoInfoDto(listVO);
            return new ResponseEntity<>(listDTO.get(0), HttpStatus.OK);
        }
        return null;
    }

    @RequestMapping(value = "/saveEntradaVeiculo", method = RequestMethod.POST)
    public ResponseEntity<EntradaVeiculoSaveDto> saveEntradaVeiculo(@RequestBody @Valid EntradaVeiculoSaveDto entradaVeiculoDto) throws Exception {
        log.info("Chamada ao VeiculoController.saveEntradaVeiculo - LojaId = {}", entradaVeiculoDto.getLojaId());

        validateSaveEntradaVeiculo(entradaVeiculoDto);

        Loja loja = lojaService.findById(entradaVeiculoDto.getLojaId());
        if(loja == null) {
            throw new Exception("Loja não cadastrada. lojaId = " + entradaVeiculoDto.getLojaId());
        }

        Cliente cliente = clienteService.findById(entradaVeiculoDto.getClienteId());
        if(cliente == null) {
            throw new Exception("Cliente não cadastrado. clienteId = " + entradaVeiculoDto.getClienteId());
        }

        Veiculo veiculo = entradaVeiculoDto.getVeiculoId() != null ? veiculoService.findById(entradaVeiculoDto.getVeiculoId()) : null;
        if(veiculo == null) {
            veiculo = new Veiculo();
            veiculo.setAnoFabricacao(entradaVeiculoDto.getAnoFabricacao());
            veiculo.setAnoModelo(entradaVeiculoDto.getAnoModelo());
            veiculo.setChassis(entradaVeiculoDto.getChassis());
            veiculo.setCombustivel(entradaVeiculoDto.getCombustivel());
            veiculo.setCor(entradaVeiculoDto.getCor());
            veiculo.setLoja(loja);
            veiculo.setMarca(entradaVeiculoDto.getMarca());
            veiculo.setModelo(entradaVeiculoDto.getModelo());
            veiculo.setMotor(entradaVeiculoDto.getMotor());
            veiculo.setPlaca(entradaVeiculoDto.getPlaca());
            veiculo.setRenavam(entradaVeiculoDto.getRenavam());
        }

        EntradaVeiculo entradaVeiculo = ConvertDtoUtil.parseEntradaVeiculoSaveDtoToEntradaveiculo(entradaVeiculoDto, loja, veiculo, cliente);

        veiculoService.saveEntradaVeiculo(entradaVeiculo);

        return new ResponseEntity<>(entradaVeiculoDto, HttpStatus.OK);
    }


    @RequestMapping(value = "/saveVendaVeiculo", method = RequestMethod.POST)
    public ResponseEntity<VendaVeiculoSaveDto> saveVendaVeiculo(@RequestBody VendaVeiculoSaveDto vendaVeiculoSaveDto) throws Exception {
        log.info("Chamada ao VeiculoController.saveVendaVeiculo - entradaVeiculoId = {}", vendaVeiculoSaveDto.getEntradaVeiculoId());

        EntradaVeiculo entradaVeiculo = veiculoService.findEntradaVeiculoById(vendaVeiculoSaveDto.getEntradaVeiculoId());
        if(entradaVeiculo == null) {
            throw new Exception("Veículo não encontrado. entradaVeiculoId = " + entradaVeiculo.getId());
        }
        if(!entradaVeiculo.getStatus().equals(StatusVeiculoEnum.NA_LOJA)) {
            throw new Exception("O veículo já foi vendido. entradaVeiculoId = " + entradaVeiculo.getId());
        }
        Cliente cliente = clienteService.findById(vendaVeiculoSaveDto.getClienteId());
        if(cliente == null) {
            throw new Exception("Cliente não cadastrado. ClienteId = " + cliente.getId());
        }
        VendaVeiculo vendaVeiculo = ConvertDtoUtil.parseVendaVeiculoSaveDtoToVendaVeiculo(vendaVeiculoSaveDto, entradaVeiculo, cliente);
        veiculoService.saveVendaVeiculo(vendaVeiculo);
        return new ResponseEntity<>(vendaVeiculoSaveDto, HttpStatus.OK);

    }

    @RequestMapping(value = "/entradaVeiculo/{id}", method = RequestMethod.DELETE)
    public Boolean deleteEntradaVeiculo(@PathVariable("id") Long entradaVeiculoId) {
        return veiculoService.deleteEntradaVeiculo(entradaVeiculoId);
    }

    @RequestMapping(value = "/vendaVeiculo/{id}", method = RequestMethod.DELETE)
    public Boolean deleteVendaVeiculo(@PathVariable("id") Long vendaVeiculoId) {
        return veiculoService.deleteVendaVeiculo(vendaVeiculoId);
    }


    private void validateSaveEntradaVeiculo(EntradaVeiculoSaveDto dto) throws Exception {
        if(dto.getLojaId() == null) {
            throw new Exception("validateSaveEntradaVeiculo - LojaId não pode ser NULL.");
        }
        if(dto.getClienteId() == null) {
            throw new Exception("validateSaveEntradaVeiculo - ClienteId não pode ser NULL.");
        }

        if(dto.getEntradaVeiculoId() == null) { // IF Entrada de veiculo é nova
            if(dto.getVeiculoId() == null) { // IF veiculo é novo
                checkPlacaAndRenavamAndChassis(dto);
            } else { //IF veículo já foi cadastrado.
                List<EntradaVeiculo> entradas = veiculoService.findEntradaVeiculoByLojaAndVeiculoAndStatus(dto.getLojaId(), dto.getVeiculoId(), StatusVeiculoEnum.NA_LOJA);
                if(entradas != null && !entradas.isEmpty()) {
                    throw new Exception("validateSaveEntradaVeiculo - Não é possível cadastrar um veículo que já está na loja. VeiculoId: " + dto.getVeiculoId());
                }

            }
        } else { // IF Entrada de Veiculo é para UPDATE
            if(dto.getVeiculoId() == null) { // IF o Veiculo foi mudado para um novo
                checkPlacaAndRenavamAndChassis(dto);
            } else {
                EntradaVeiculo entradaVeiculoInDB = veiculoService.findEntradaVeiculoById(dto.getEntradaVeiculoId());
                if (!entradaVeiculoInDB.getVeiculo().getId().equals(dto.getVeiculoId())) { //IF mudou o veiculo
                    List<EntradaVeiculo> entradas = veiculoService.findEntradaVeiculoByLojaAndVeiculoAndStatus(dto.getLojaId(), dto.getVeiculoId(), StatusVeiculoEnum.NA_LOJA);
                    if (entradas != null && !entradas.isEmpty()) {
                        throw new Exception("validateSaveEntradaVeiculo - Não é possível cadastrar um veículo que já está na loja. VeiculoId: " + dto.getVeiculoId());
                    }
                } else { //IF não mudou o veiculo.
                    if (!entradaVeiculoInDB.getVeiculo().getPlaca().equals(dto.getPlaca())
                            || !entradaVeiculoInDB.getVeiculo().getRenavam().equals(dto.getRenavam())
                            || !entradaVeiculoInDB.getVeiculo().getChassis().equals(dto.getChassis())) { //IF mudou a placa e/ou renavam e/ou chassis
                        checkPlacaAndRenavamAndChassis(dto);
                    }
                }
            }
        }
    }

    private void checkPlacaAndRenavamAndChassis(EntradaVeiculoSaveDto dto) throws Exception {
        if(veiculoService.findByLojaIdAndPlaca(dto.getLojaId(), dto.getPlaca()) != null) {
            throw new Exception("validateSaveEntradaVeiculo - Já existe um veículo cadastrado com essa placa: " + dto.getPlaca());
        }
        if(veiculoService.findByLojaIdAndRenavam(dto.getLojaId(), dto.getRenavam()) != null) {
            throw new Exception("validateSaveEntradaVeiculo - Já existe um veículo cadastrado com esse renavam: " + dto.getRenavam());
        }
        if(veiculoService.findByLojaIdAndChassis(dto.getLojaId(), dto.getChassis()) != null) {
            throw new Exception("validateSaveEntradaVeiculo - Já existe um veículo cadastrado com esse chassis: " + dto.getChassis());
        }
    }



}
