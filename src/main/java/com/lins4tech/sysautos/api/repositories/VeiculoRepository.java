package com.lins4tech.sysautos.api.repositories;

import com.lins4tech.sysautos.api.entities.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long>, VeiculoRepositoryCustom {

    Optional<Veiculo> findByLojaIdAndPlaca(Long lojaId, String placa);
    Optional<Veiculo> findByLojaIdAndRenavam(Long lojaId, String renavam);
    Optional<Veiculo> findByLojaIdAndChassis(Long lojaId, String chassis);

}
