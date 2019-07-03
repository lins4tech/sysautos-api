package com.lins4tech.sysautos.api.repositories.impl;

import com.lins4tech.sysautos.api.entities.EntradaVeiculo;
import com.lins4tech.sysautos.api.entities.VendaVeiculo;
import com.lins4tech.sysautos.api.enums.StatusVeiculoEnum;
import com.lins4tech.sysautos.api.repositories.EntradaVeiculoRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EntradaVeiculoRepositoryCustomImpl implements EntradaVeiculoRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<EntradaVeiculo> searchByVeiculoAndStatus(Long lojaId, Long veiculoId, StatusVeiculoEnum statusVeiculoEnum) {
        Map<String, Object> parameters = new HashMap<>();
        String queryStr = "SELECT ev FROM EntradaVeiculo ev WHERE ev.loja.id = :lojaId AND ev.veiculo.id = :veiculoId AND ev.status = :status";
        parameters.put("lojaId", lojaId);
        parameters.put("veiculoId", veiculoId);
        parameters.put("status", statusVeiculoEnum);

        Query query =  entityManager.createQuery(queryStr);
        for(Map.Entry<String, Object> p : parameters.entrySet()) {
            query.setParameter(p.getKey(), p.getValue());
        }
        return query.getResultList();
    }
}
