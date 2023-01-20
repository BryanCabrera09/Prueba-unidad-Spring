package com.bryan.api.rest.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bryan.api.rest.app.entity.Asignatura;
import com.bryan.api.rest.app.service.IAsignaturaService;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/asignatura")
public class AsignaturaController {

	@Autowired
	IAsignaturaService asignaturaService;

	@GetMapping("/listar")
	public ResponseEntity<List<Asignatura>> obtenerLista() {
		return new ResponseEntity<>(asignaturaService.findByAll(), HttpStatus.OK);
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Asignatura> getById(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(asignaturaService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/crear")
	public ResponseEntity<Asignatura> crear(@RequestBody Asignatura c) {
		return new ResponseEntity<>(asignaturaService.save(c), HttpStatus.CREATED);
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Asignatura> eliminar(@PathVariable Integer id) {
		asignaturaService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Asignatura> actualizarUsuario(@PathVariable Integer id, @RequestBody Asignatura a) {
		Asignatura Asignatura = asignaturaService.findById(id);
		if (Asignatura == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				Asignatura.setNombre(a.getNombre());
				Asignatura.setCarrera(a.getCarrera());
				Asignatura.setDocente(a.getDocente());
				Asignatura.setHora_ini(a.getHora_ini());
				Asignatura.setHora_fin(a.getHora_fin());
				return new ResponseEntity<>(asignaturaService.save(Asignatura), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}

	}
}
