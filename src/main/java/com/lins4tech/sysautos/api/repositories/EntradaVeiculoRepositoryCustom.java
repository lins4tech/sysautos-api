package com.lins4tech.sysautos.api.repositories;

import com.lins4tech.sysautos.api.entities.EntradaVeiculo;
import com.lins4tech.sysautos.api.enums.StatusVeiculoEnum;

import java.util.List;

public interface EntradaVeiculoRepositoryCustom {
    List<EntradaVeiculo> searchByVeiculoAndStatus(Long lojaId, Long veiculoId, StatusVeiculoEnum statusVeiculoEnum);
}
