package com.lins4tech.sysautos.api.services.impl;

import com.lins4tech.sysautos.api.entities.EntradaVeiculo;
import com.lins4tech.sysautos.api.entities.Veiculo;
import com.lins4tech.sysautos.api.entities.VeiculoApiProcob;
import com.lins4tech.sysautos.api.entities.VendaVeiculo;
import com.lins4tech.sysautos.api.enums.StatusVeiculoEnum;
import com.lins4tech.sysautos.api.repositories.EntradaVeiculoRepository;
import com.lins4tech.sysautos.api.repositories.VeiculoRepository;
import com.lins4tech.sysautos.api.repositories.VendaVeiculoRepository;
import com.lins4tech.sysautos.api.services.VeiculoService;
import com.lins4tech.sysautos.api.vos.VeiculoInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    private static final Logger log = LoggerFactory.getLogger(VeiculoServiceImpl.class);

    @Autowired
    private EntradaVeiculoRepository entradaVeiculoRepository;

    @Autowired
    private VendaVeiculoRepository vendaVeiculoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Override
    public EntradaVeiculo saveEntradaVeiculo(EntradaVeiculo entradaVeiculo) {
        return entradaVeiculoRepository.save(entradaVeiculo);
    }

    @Override
    public VendaVeiculo saveVendaVeiculo(VendaVeiculo vendaVeiculo) {
        return vendaVeiculoRepository.save(vendaVeiculo);
    }

    @Override
    public List<VeiculoInfoVO> find(Long lojaId, StatusVeiculoEnum statusVeiculoEnum, String placa, String modelo, String marca, Integer anoFabricacao, Integer anoModelo, String renavam, String chassis, PageRequest pageRequest) {
        log.info("Consultando Veículos");
        return veiculoRepository.find(lojaId, statusVeiculoEnum, placa, modelo, marca, anoFabricacao, anoModelo, renavam, chassis, pageRequest);
    }

    @Override
    public Veiculo findByLojaIdAndPlaca(Long lojaId, String placa) {
        return veiculoRepository.findByLojaIdAndPlaca(lojaId, placa).orElse(null);
    }

    @Override
    public Veiculo findByLojaIdAndRenavam(Long lojaId, String renavam) {
        return veiculoRepository.findByLojaIdAndRenavam(lojaId, renavam).orElse(null);
    }

    @Override
    public Veiculo findByLojaIdAndChassis(Long lojaId, String chassis) {
        return veiculoRepository.findByLojaIdAndChassis(lojaId, chassis).orElse(null);
    }

    @Override
    public Boolean deleteEntradaVeiculo(Long entradaVeiculoId) {
        log.info("Excluindo uma EntradaVeiculo: {}", entradaVeiculoId);
        EntradaVeiculo entradaVeiculo =  entradaVeiculoRepository.findById(entradaVeiculoId).orElse(null);
        if(entradaVeiculo != null) {
            Long idVeiculo = entradaVeiculo.getVeiculo().getId();
            Veiculo veiculo = veiculoRepository.findById(idVeiculo).orElse(null);
            //Excluir VendaVeiculo
            VendaVeiculo vendaVeiculo = findVendaVeiculoByEntradaVeiculo(entradaVeiculo);
            if(vendaVeiculo != null) {
                vendaVeiculoRepository.deleteById(vendaVeiculo.getId());
            }
            //Excluir EntradaVeiculo
            entradaVeiculoRepository.deleteById(entradaVeiculoId);
            List<EntradaVeiculo> entradas = entradaVeiculoRepository.findByVeiculo(veiculo);
            //Excluir Veiculo se não houver nenhuma entrada.
            if(entradas == null || entradas.size() == 0) {
                veiculoRepository.deleteById(veiculo.getId());
            }
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteVendaVeiculo(Long vendaVeiculoId) {
        log.info("Excluindo uma VendaVeiculo: {}", vendaVeiculoId);
        VendaVeiculo vendaVeiculo = vendaVeiculoRepository.findById(vendaVeiculoId).orElse(null);
        if(vendaVeiculo != null) {
            vendaVeiculoRepository.deleteById(vendaVeiculoId);
            EntradaVeiculo entradaVeiculo = vendaVeiculo.getEntradaVeiculo();
            entradaVeiculo.setStatus(StatusVeiculoEnum.NA_LOJA);
            entradaVeiculoRepository.save(entradaVeiculo);
            return true;
        }
        return false;
    }

    @Override
    public Veiculo findById(Long id) {
        log.info("FindById VeiculoId: {}", id);
        return veiculoRepository.findById(id).orElse(null);
    }

    @Override
    public VendaVeiculo findVendaVeiculoByEntradaVeiculo(EntradaVeiculo entradaVeiculo) {
        return vendaVeiculoRepository.searchByEntradaVeiculo(entradaVeiculo.getLoja().getId(), entradaVeiculo.getId()).orElse(null);
    }

    @Override
    public EntradaVeiculo findEntradaVeiculoById(Long id) {
        log.info("findEntradaVeiculoById EntradaVeiculoId: {}", id);
        return entradaVeiculoRepository.findById(id).orElse(null);
    }

    @Override
    public List<EntradaVeiculo> findEntradaVeiculoByLojaAndVeiculoAndStatus(Long lojaId, Long veiculoId, StatusVeiculoEnum statusVeiculoEnum) {
        log.info("findEntradaVeiculoByLojaAndVeiculoAndStatus LojaId: {}, VeiculoId: {}, Status: {}", lojaId, veiculoId, statusVeiculoEnum.name());
        return entradaVeiculoRepository.searchByVeiculoAndStatus(lojaId, veiculoId, statusVeiculoEnum);
    }

    @Override
    public VeiculoApiProcob findVeiculoApiProcobByPlaca(String placa) {
        return veiculoRepository.findVeiculoApiProcobByPlaca(placa).orElse(null);
    }

    @Override
    public VeiculoApiProcob saveVeiculoApiProcob(VeiculoApiProcob veiculoApiProcob) {
        return veiculoRepository.saveVeiculoApiProcob(veiculoApiProcob);
    }
}
