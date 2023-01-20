package com.bryan.api.rest.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.bryan.api.rest.app.entity.Asignatura;
import com.bryan.api.rest.app.repository.IAsignaturaRepository;

@Service
public class AsignaturaServiceImpl extends GenericServiceImpl<Asignatura, Integer> implements IAsignaturaService {

	@Autowired
	IAsignaturaRepository asignaturaRepository;

	@Override
	public CrudRepository<Asignatura, Integer> getDao() {
		return asignaturaRepository;
	}

	public Asignatura buscarAsignatura(String nombre) {

		return asignaturaRepository.buscarAsignatura(nombre);
	}
}
