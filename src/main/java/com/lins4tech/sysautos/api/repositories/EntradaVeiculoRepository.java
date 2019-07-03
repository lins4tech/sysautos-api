package com.lins4tech.sysautos.api.repositories;


import com.lins4tech.sysautos.api.entities.EntradaVeiculo;
import com.lins4tech.sysautos.api.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EntradaVeiculoRepository extends JpaRepository<EntradaVeiculo, Long>, EntradaVeiculoRepositoryCustom {

    @Transactional(readOnly = true)
    List<EntradaVeiculo> findByVeiculo(Veiculo veiculo);
}

