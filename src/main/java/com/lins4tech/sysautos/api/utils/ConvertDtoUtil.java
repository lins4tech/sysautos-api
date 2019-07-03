package com.lins4tech.sysautos.api.utils;

import com.lins4tech.sysautos.api.dtos.*;
import com.lins4tech.sysautos.api.entities.*;
import com.lins4tech.sysautos.api.enums.StatusVeiculoEnum;
import com.lins4tech.sysautos.api.procob.cliente.*;
import com.lins4tech.sysautos.api.procob.veiculo.VeiculoApiProcobJson;
import com.lins4tech.sysautos.api.vos.VeiculoInfoVO;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ConvertDtoUtil {

    public static List<VeiculoInfoDto> parseListVeiculoInfoVoToListVeiculoInfoDto(List<VeiculoInfoVO> vos) {
        List<VeiculoInfoDto> dtos = new ArrayList<>();
        for(VeiculoInfoVO vo : vos) {
            VeiculoInfoDto dto = new VeiculoInfoDto();
            BeanUtils.copyProperties(vo, dto);
            dtos.add(dto);
        }
        return dtos;
    }

    public static EntradaVeiculo parseEntradaVeiculoSaveDtoToEntradaveiculo(EntradaVeiculoSaveDto dto, Loja loja, Veiculo veiculo, Cliente cliente) {
        EntradaVeiculo entradaVeiculo = new EntradaVeiculo();
        BeanUtils.copyProperties(dto, entradaVeiculo);
        entradaVeiculo.setLoja(loja);
        entradaVeiculo.setVeiculo(veiculo);
        entradaVeiculo.setCliente(cliente);
        entradaVeiculo.setDataEntrada(dto.getDataEntrada());
        entradaVeiculo.setStatus(StatusVeiculoEnum.NA_LOJA);
        entradaVeiculo.setFerramentas(dto.getFerramentas());
        entradaVeiculo.setOpcionais(dto.getOpcionais());
        return entradaVeiculo;

    }

    public static VendaVeiculo parseVendaVeiculoSaveDtoToVendaVeiculo(VendaVeiculoSaveDto dto, EntradaVeiculo entradaVeiculo, Cliente cliente) {
        VendaVeiculo vendaVeiculo = new VendaVeiculo();
        vendaVeiculo.setCliente(cliente);
        vendaVeiculo.setEntradaVeiculo(entradaVeiculo);
        vendaVeiculo.setDataVenda(dto.getDataVenda());
        vendaVeiculo.setObservacao(dto.getObservacao());
        vendaVeiculo.setValorTotal(dto.getValorTotal());
        return vendaVeiculo;
    }

    public static VeiculoApiProcobDto parseVeiculoApiProcobToDto(VeiculoApiProcob veiculoApiProcob) {
        VeiculoApiProcobDto dto = new VeiculoApiProcobDto();
        BeanUtils.copyProperties(veiculoApiProcob, dto);
        return dto;
    }

    public static VeiculoApiProcob parseVeiculoApiProcobDtoToEntity(VeiculoApiProcobDto dto) {
        VeiculoApiProcob entity = new VeiculoApiProcob();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }

    public static VeiculoApiProcob parseVeiculoApiProcobJsonToEntity(VeiculoApiProcobJson veiculoApiProcobJson) {
        VeiculoApiProcobDto dto = parseVeiculoApiProcobJsonToDto(veiculoApiProcobJson);
        return parseVeiculoApiProcobDtoToEntity(dto);
    }

    public static VeiculoApiProcobDto parseVeiculoApiProcobJsonToDto(VeiculoApiProcobJson veiculoApiProcobJson) {
        VeiculoApiProcobDto dto = new VeiculoApiProcobDto();
        dto.setAnoFabricacao(Integer.valueOf(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getAnoFabricacao()));
        dto.setAnoModelo(Integer.valueOf(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getAnoModelo()));
        dto.setCapacidadePassgeiro(Integer.valueOf(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getCapacidadePassgeiro()));
        dto.setChassi(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getChassi());
        dto.setCilindradas(Integer.valueOf(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getCilindradas()));
        dto.setCombustivel(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getCombustivel());
        dto.setDataUltimaAtualizacao(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getDataUltimaAtualizacao());
        dto.setMarca(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getMarca());
        dto.setModelo(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getModelo());
        dto.setMunicipio(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getMunicipio());
        dto.setNumeroMotor(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getNumeroMotor());
        dto.setPlaca(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getPlaca());
        if(!StringUtils.isEmpty(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getPotencia())) {
            dto.setPotencia(Integer.valueOf(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getPotencia()));
        }
        dto.setProcedencia(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getProcedencia());
        dto.setRenavam(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getRenavam());
        dto.setSituacaoChassi(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getSituacaoChassi());
        dto.setSituacaoVeiculo(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getSituacaoVeiculo());
        dto.setTipoVeiculo(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getTipoVeiculo());
        dto.setUfPlaca(veiculoApiProcobJson.getVeiculoContentApiProcobJson().getAgregados().getUf());
        return dto;
    }


    public static ClienteApiProcobDto parseClienteApiProcobJsonToDto(ClienteApiProcobJson json) {
        ClienteApiProcobDto dto = new ClienteApiProcobDto();
        dto.setCpfCnpj(json.getContent().getClienteContentDadosGerais().getConteudo().getDocumento());
        dto.setDataNascimento(json.getContent().getClienteContentDadosGerais().getConteudo().getDataNascimento());
        dto.setNome(json.getContent().getClienteContentDadosGerais().getConteudo().getNome());
        dto.setObito(json.getContent().getClienteContentDadosGerais().getConteudo().getObito());
        dto.setSexo(json.getContent().getClienteContentDadosGerais().getConteudo().getSexo());
        dto.setSituacaoReceita(json.getContent().getClienteContentDadosGerais().getConteudo().getSituacaoReceita());
        dto.setSituacaoReceitaData(json.getContent().getClienteContentDadosGerais().getConteudo().getSituacaoReceitaData());
        dto.setTipo(json.getContent().getClienteContentDadosGerais().getConteudo().getTipoDocumento());
        dto.setUf(json.getContent().getClienteContentDadosGerais().getConteudo().getUf());
        ClienteContentEnderecosApiProcobJson enderecosApiProcobJson = json.getContent().getEnderecos();
        if(enderecosApiProcobJson != null && enderecosApiProcobJson.getEnderecos() != null && !enderecosApiProcobJson.getEnderecos().isEmpty()) {
            ClienteContentEnderecoConteudoApiProcobJson enderecoConteudo = enderecosApiProcobJson.getEnderecos().get(0);
            dto.setEndereco(enderecoConteudo.getEndereco());
            dto.setCidade(enderecoConteudo.getCidade());
            dto.setBairro(enderecoConteudo.getBairro());
            dto.setUfEndereco(enderecoConteudo.getUf());
            dto.setComplemento(enderecoConteudo.getComplemento());
            dto.setCep(enderecoConteudo.getCep());
        }
        ClienteContentEmailsApiProcobJson emailsApiProcobJson = json.getContent().getEmails();
        if(emailsApiProcobJson != null && emailsApiProcobJson.getEmails() != null && !emailsApiProcobJson.getEmails().isEmpty()) {
            ClienteContentEmailConteudoApiProcobJson emailConteudo = emailsApiProcobJson.getEmails().get(0);
            dto.setEmail(emailConteudo.getEmail());
        }
        return dto;
    }

    public static ClienteApiProcobDto parseClienteApiProcobToDto(ClienteApiProcob entity) {
        ClienteApiProcobDto dto = new ClienteApiProcobDto();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    public static ClienteApiProcob parseClienteApiProcobDtoToEntity(ClienteApiProcobDto dto) {
        ClienteApiProcob entity = new ClienteApiProcob();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
