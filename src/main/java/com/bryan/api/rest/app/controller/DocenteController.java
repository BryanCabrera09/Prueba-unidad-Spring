package com.bryan.api.rest.app.controller;

import com.bryan.api.rest.app.entity.Docente;
import com.bryan.api.rest.app.service.IDocenteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/docente")
public class DocenteController {

	@Autowired
	IDocenteService docenteService;

	@GetMapping("/listar")
	public ResponseEntity<List<Docente>> obtenerLista() {

		try {
			return new ResponseEntity<>(docenteService.findByAll(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Docente> getById(@PathVariable("id") Integer id) {
		try {
			return new ResponseEntity<>(docenteService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/crear")
	public ResponseEntity<Docente> crear(@RequestBody Docente d) {

		try {
			return new ResponseEntity<>(docenteService.save(d), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id) {
		try {
			docenteService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Error al elminar el docente");
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/actualizar/{id}")
	public ResponseEntity<Docente> actualizarUsuario(@PathVariable Integer id, @RequestBody Docente d) {
		Docente Docente = docenteService.findById(id);
		if (Docente == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			try {
				Docente.setNombre(d.getNombre());
				Docente.setAsignaturas(d.getAsignaturas());
				Docente.setCelular(d.getCelular());
				Docente.setApellido(d.getApellido());
				Docente.setEmail(d.getEmail());
				return new ResponseEntity<>(docenteService.save(Docente), HttpStatus.CREATED);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}

	}
}
