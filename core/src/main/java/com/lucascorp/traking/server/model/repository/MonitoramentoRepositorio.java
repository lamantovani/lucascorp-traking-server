package com.lucascorp.traking.server.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lucascorp.traking.server.entity.Monitoramento;


@Repository
public interface MonitoramentoRepositorio extends CrudRepository<Monitoramento, Long> {
	
	@Query("SELECT p FROM Monitoramento p WHERE p.usuario.login = ?")
	public Monitoramento findOneByLogin(String login);

}
