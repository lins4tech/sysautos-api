package com.lins4tech.sysautos.api.repositories;


import com.lins4tech.sysautos.api.entities.VeiculoApiProcob;
import com.lins4tech.sysautos.api.enums.StatusVeiculoEnum;
import com.lins4tech.sysautos.api.vos.VeiculoInfoVO;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface VeiculoRepositoryCustom {

    @Transactional(readOnly = true)
    List<VeiculoInfoVO> find(Long lojaId, StatusVeiculoEnum statusVeiculoEnum, String placa, String modelo, String marca, Integer anoFabricacao, Integer anoModelo, String renavam, String chassis, Pageable pageable);

    @Transactional(readOnly = true)
    Optional<VeiculoApiProcob> findVeiculoApiProcobByPlaca(String placa);

    @Transactional
    VeiculoApiProcob saveVeiculoApiProcob(VeiculoApiProcob veiculoApiProcob);
}

