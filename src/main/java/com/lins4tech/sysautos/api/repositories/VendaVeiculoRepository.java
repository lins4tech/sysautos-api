package com.lins4tech.sysautos.api.repositories;

import com.lins4tech.sysautos.api.entities.EntradaVeiculo;
import com.lins4tech.sysautos.api.entities.VendaVeiculo;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@NamedQueries({
        @NamedQuery(
                name = "VendaVeiculoRepository.searchByEntradaVeiculo",
                query = "SELECT v FROM VendaVeiculo v WHERE v.entradaVeiculo.loja.id = :lojaId AND v.entradaVeiculo.id = :entradaVeiculoId"),
        @NamedQuery(
                name = "ClienteRepository.findByLojaId",
                query = "SELECT v FROM VendaVeiculo v WHERE v.entradaVeiculo.loja.id = :lojaId"
        )
})
public interface VendaVeiculoRepository extends JpaRepository<VendaVeiculo, Long>, VendaVeiculoRepositoryCustom {


}
