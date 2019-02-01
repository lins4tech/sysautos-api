package com.lins4tech.sysautos.api.repositories.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.lins4tech.sysautos.api.entities.Cliente;
import com.lins4tech.sysautos.api.enums.TipoClienteEnum;
import com.lins4tech.sysautos.api.repositories.ClienteRepositoryCustom;

@Repository
@Transactional(readOnly = true)
public class ClienteRepositoryCustomImpl implements ClienteRepositoryCustom{
	
	@PersistenceContext
    EntityManager entityManager;

	@Override
	public List<Cliente> findCliente(Long lojaId, String nome, String email, String cpfCnpj, TipoClienteEnum tipo, Pageable pageable) {
		Map<String, Object> parameters = new HashMap<>();
		StringBuilder sbQuery = new StringBuilder();
		sbQuery.append("SELECT c FROM Cliente c WHERE c.loja.id = :lojaId ");
		parameters.put("lojaId", lojaId);
		if(!StringUtils.isEmpty(nome)) {
			sbQuery.append(" AND c.nomeCompleto LIKE '%' || :nomeCompleto || '%' ");
			parameters.put("nomeCompleto", nome);
		}
		if(!StringUtils.isEmpty(email)) {
			sbQuery.append(" AND c.email LIKE '%' || :email || '%' ");
			parameters.put("email", email);
		}
		
		if(!StringUtils.isEmpty(cpfCnpj)) {
			sbQuery.append(" AND c.cpfCnpj LIKE '%' || :cpfCnpj || '%' ");
			parameters.put("cpfCnpj", cpfCnpj);
		}
		
		if(tipo != null) {
			sbQuery.append(" AND c.tipoClienteEnum = :tipo ");
			parameters.put("tipo", tipo);
		}
		if(pageable != null && !pageable.getSort().isEmpty()) {
			Order order = pageable.getSort().iterator().next();
			if(order != null) {
				sbQuery.append(" ORDER BY c.".concat(order.getProperty()).concat(order.getDirection().isDescending()? " DESC" : " ASC"));
			}
		}
		
		TypedQuery<Cliente> query = entityManager.createQuery(sbQuery.toString(), Cliente.class);
		for(Map.Entry<String, Object> p : parameters.entrySet()) {
			query.setParameter(p.getKey(), p.getValue());
		}
		if(pageable != null) {
			query.setFirstResult(pageable.getPageNumber());
			query.setMaxResults(pageable.getPageSize());
		}
		
		
		return query.getResultList();
	}

}
