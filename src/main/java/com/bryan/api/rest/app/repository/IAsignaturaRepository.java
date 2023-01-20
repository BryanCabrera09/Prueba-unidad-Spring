package com.bryan.api.rest.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bryan.api.rest.app.entity.Asignatura;

public interface IAsignaturaRepository extends JpaRepository<Asignatura, Integer> {

	@Query(value = "Select * from asignatura a where a.nombre = a.nombre", nativeQuery = true)
	public Asignatura buscarAsignatura(String nombre);
}
