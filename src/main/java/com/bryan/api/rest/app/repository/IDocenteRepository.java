package com.bryan.api.rest.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bryan.api.rest.app.entity.Docente;

public interface IDocenteRepository extends JpaRepository<Docente, Integer> {

	@Query(value = "Select * from docente d where d.nombre = d.nombre", nativeQuery = true)
	public Docente buscarDocente(String nombre);
}
