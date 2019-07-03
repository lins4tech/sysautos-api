package com.lins4tech.sysautos.api.services;

import com.lins4tech.sysautos.api.entities.EntradaVeiculo;
import com.lins4tech.sysautos.api.entities.Veiculo;
import com.lins4tech.sysautos.api.entities.VeiculoApiProcob;
import com.lins4tech.sysautos.api.entities.VendaVeiculo;
import com.lins4tech.sysautos.api.enums.StatusVeiculoEnum;
import com.lins4tech.sysautos.api.vos.VeiculoInfoVO;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface VeiculoService {

    EntradaVeiculo saveEntradaVeiculo(EntradaVeiculo entradaVeiculo);

    VendaVeiculo saveVendaVeiculo(VendaVeiculo vendaVeiculo);

    Boolean deleteEntradaVeiculo(Long entradaVeiculoId);

    EntradaVeiculo findEntradaVeiculoById(Long id);

    Veiculo findById(Long id);

    Veiculo findByLojaIdAndPlaca(Long lojaId, String placa);

    Veiculo findByLojaIdAndRenavam(Long lojaId, String renavam);

    Veiculo findByLojaIdAndChassis(Long lojaId, String chassis);

    VendaVeiculo findVendaVeiculoByEntradaVeiculo(EntradaVeiculo entradaVeiculo);

    Boolean deleteVendaVeiculo(Long vendaVeiculoId);

    List<VeiculoInfoVO> find(Long lojaId, StatusVeiculoEnum statusVeiculoEnum, String placa, String modelo, String marca, Integer anoFabricacao, Integer anoModelo, String renavam, String chassis, PageRequest pageRequest);

    List<EntradaVeiculo> findEntradaVeiculoByLojaAndVeiculoAndStatus(Long lojaId, Long veiculoId, StatusVeiculoEnum statusVeiculoEnum);

    VeiculoApiProcob findVeiculoApiProcobByPlaca(String placa);

    VeiculoApiProcob saveVeiculoApiProcob(VeiculoApiProcob veiculoApiProcob);
}
