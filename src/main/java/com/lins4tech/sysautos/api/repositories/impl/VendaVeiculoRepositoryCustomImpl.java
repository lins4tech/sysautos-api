package com.lins4tech.sysautos.api.repositories.impl;

import com.lins4tech.sysautos.api.entities.VendaVeiculo;
import com.lins4tech.sysautos.api.enums.StatusVeiculoEnum;
import com.lins4tech.sysautos.api.repositories.VendaVeiculoRepositoryCustom;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
@Repository
@Transactional(readOnly = true)
public class VendaVeiculoRepositoryCustomImpl implements VendaVeiculoRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Optional<VendaVeiculo> searchByEntradaVeiculo(Long lojaId, Long entradaVeiculoId) {
        Map<String, Object> parameters = new HashMap<>();
        String queryStr = "SELECT v FROM VendaVeiculo v WHERE v.entradaVeiculo.loja.id = :lojaId AND v.entradaVeiculo.id = :entradaVeiculoId";

        Query query =  entityManager.createQuery(queryStr);
        for(Map.Entry<String, Object> p : parameters.entrySet()) {
            query.setParameter(p.getKey(), p.getValue());
        }
        return query.getResultList().stream().findFirst();
    }
}
