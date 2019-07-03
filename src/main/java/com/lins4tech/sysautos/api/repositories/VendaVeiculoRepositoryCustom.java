package com.lins4tech.sysautos.api.repositories;

import com.lins4tech.sysautos.api.entities.VendaVeiculo;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import java.util.Optional;

//@NamedQueries({
//        @NamedQuery(
//                name = "VendaVeiculoRepository.searchByEntradaVeiculo",
//                query = "SELECT v FROM VendaVeiculo v WHERE v.entradaVeiculo.loja.id = :lojaId AND v.entradaVeiculo.id = :entradaVeiculoId"),
//        @NamedQuery(
//                name = "ClienteRepository.findByLojaId",
//                query = "SELECT v FROM VendaVeiculo v WHERE v.entradaVeiculo.loja.id = :lojaId"
//        )
//})
public interface VendaVeiculoRepositoryCustom {
    Optional<VendaVeiculo> searchByEntradaVeiculo(Long lojaId, Long entradaVeiculoId);
}
