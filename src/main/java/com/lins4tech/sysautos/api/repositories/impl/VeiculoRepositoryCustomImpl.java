package com.lins4tech.sysautos.api.repositories.impl;

import com.lins4tech.sysautos.api.entities.VeiculoApiProcob;
import com.lins4tech.sysautos.api.enums.StatusVeiculoEnum;
import com.lins4tech.sysautos.api.repositories.VeiculoRepositoryCustom;
import com.lins4tech.sysautos.api.vos.VeiculoInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Pageable;

import java.util.*;

@Repository
@Transactional(readOnly = true)
public class VeiculoRepositoryCustomImpl implements VeiculoRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<VeiculoInfoVO> find(Long lojaId, StatusVeiculoEnum statusVeiculoEnum, String placa, String modelo, String marca, Integer anoFabricacao, Integer anoModelo, String renavam, String chassis, Pageable pageable) {

        Map<String, Object> parameters = new HashMap<>();
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT ")
                .append("ev.id AS id_entrada_veiculo, ")
                .append("v.id AS id_veiculo, ")
                .append("vv.id AS id_venda_veiculo, ")
                .append("ev.loja_id AS id_loja, ")
                .append("v.placa AS placa, ")
                .append("v.chassis AS chassis, ")
                .append("v.renavam AS renavam, ")
                .append("v.modelo AS modelo, ")
                .append("v.marca AS marca, ")
                .append("v.cor AS cor, ")
                .append("v.combustivel AS combustivel, ")
                .append("v.motor AS motor, ")
                .append("v.ano_modelo AS ano_modelo, ")
                .append("v.ano_fabricacao AS ano_fabricacao, ")
                .append("ev.valor_compra AS valor_compra, ")
                .append("ev.valor_venda AS valor_para_venda, ")
                .append("vv.valor_total AS valor_total_venda, ")
                .append("ev.ferramentas AS ferramentas, ")
                .append("ev.opcionais AS opcionais, ")
                .append("ev.data_entrada AS data_entrada_veiculo, ")
                .append("vv.data_venda AS data_venda_veiculo, ")
                .append("ev.status AS status ");

        sbQuery.append("FROM entrada_veiculo ev ")
                .append("INNER JOIN veiculo v ON v.id = ev.veiculo_id ")
                .append("LEFT JOIN venda_veiculo vv ON vv.entrada_veiculo_id = ev.id ");

        sbQuery.append("WHERE ev.loja_id = :lojaId ");

        parameters.put("lojaId", lojaId);

        if(statusVeiculoEnum != null) {
            sbQuery.append("AND ev.status = :status ");
            parameters.put("status", statusVeiculoEnum.name());
        }

        if(placa != null){
            sbQuery.append("AND v.placa = :placa ");
            parameters.put("placa", placa);
        }

        if(renavam != null){
            sbQuery.append("AND v.renavam = :renavam ");
            parameters.put("renavam", renavam);
        }

        if(chassis != null){
            sbQuery.append("AND v.chassis = :chassis ");
            parameters.put("chassis", chassis);
        }

        if(modelo != null){
            sbQuery.append("AND v.modelo = :modelo ");
            parameters.put("modelo", modelo);
        }

        if(marca != null){
            sbQuery.append("AND v.marca = :marca ");
            parameters.put("marca", marca);
        }

        if(anoFabricacao != null){
            sbQuery.append("AND v.ano_fabricacao = :anoFabricacao ");
            parameters.put("anoFabricacao", anoFabricacao);
        }

        if(anoModelo != null){
            sbQuery.append("AND v.ano_modelo = :anoModelo ");
            parameters.put("anoModelo", anoModelo);
        }

        if(pageable != null && !pageable.getSort().isEmpty()) {
            Sort.Order order = pageable.getSort().iterator().next();
            if(order != null) {
                sbQuery.append(" ORDER BY v.".concat(order.getProperty()).concat(order.getDirection().isDescending()? " DESC" : " ASC"));
            }
        } else {
            sbQuery.append(" ORDER BY ev.id DESC");
        }


        TypedQuery<VeiculoInfoVO> query = (TypedQuery<VeiculoInfoVO>) entityManager.createNativeQuery(sbQuery.toString(), VeiculoInfoVO.class);
        for(Map.Entry<String, Object> p : parameters.entrySet()) {
            query.setParameter(p.getKey(), p.getValue());
        }
        if(pageable != null) {
            query.setFirstResult(pageable.getPageNumber());
            query.setMaxResults(pageable.getPageSize());
        }
        List<VeiculoInfoVO> results = query.getResultList();

        return results;
    }

//    private List<VeiculoInfoVO> convertToVeiculoInfoVO( List<Object[]> results) {
//        List<VeiculoInfoVO> vos = new ArrayList<>();
//        for(Object[] obj : results) {
//            new VeiculoInfoVO(obj[0], obj[1], obj[2],obj[2],obj[2],obj[2],obj[2],obj[2],obj[2],obj[2],obj[2],obj[2],obj[2],obj[2],obj[2],obj[2],obj[2],obj[2],obj[2],obj[2],obj[2], obj[2]);
//        }
//    }

    @Override
    public Optional<VeiculoApiProcob> findVeiculoApiProcobByPlaca(String placa) {
        Map<String, Object> parameters = new HashMap<>();
        StringBuilder sbQuery = new StringBuilder();
        sbQuery.append("SELECT v FROM VeiculoApiProcob v WHERE v.placa = :placa");
        Query query = entityManager.createQuery(sbQuery.toString());
        query.setParameter("placa", placa);
        return query.getResultList().stream().findFirst();
    }

    @Override
    @Transactional()
    public VeiculoApiProcob saveVeiculoApiProcob(VeiculoApiProcob veiculoApiProcob) {
        return entityManager.merge(veiculoApiProcob);
    }
}
