package com.bryan.api.rest.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "asignatura")
public class Asignatura implements Serializable {

	private static final long serialVersionUID = -2603665038000923436L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_asignatura")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "carrera")
	private String carrera;

	@Column(name = "hora_ini")
	@Temporal(TemporalType.DATE)
	private Date hora_ini;

	@Column(name = "hora_fin")
	@Temporal(TemporalType.DATE)
	private Date hora_fin;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "id_docente", referencedColumnName = "id_docente")
	private Docente docente;
}
