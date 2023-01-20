package com.bryan.api.rest.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.bryan.api.rest.app.entity.Docente;
import com.bryan.api.rest.app.repository.IDocenteRepository;

@Service
public class DocenteServiceImpl extends GenericServiceImpl<Docente, Integer> implements IDocenteService {

	@Autowired
	IDocenteRepository docenteRepository;

	@Override
	public CrudRepository<Docente, Integer> getDao() {
		return docenteRepository;
	}

	public Docente buscarDocente(String nombre) {

		return docenteRepository.buscarDocente(nombre);
	}
}
