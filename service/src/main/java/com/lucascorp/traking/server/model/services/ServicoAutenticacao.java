package com.lucascorp.traking.server.model.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lucascorp.traking.server.model.repository.MonitoramentoRepositorio;


@Service
public class ServicoAutenticacao implements UserDetailsService {

	@Autowired private MonitoramentoRepositorio usuarioRepositorio;

	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return usuarioRepositorio.findOneByLogin(login);
	}
	
	

}
