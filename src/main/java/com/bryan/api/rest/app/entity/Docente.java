package com.bryan.api.rest.app.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "docente")
public class Docente implements Serializable {

	private static final long serialVersionUID = 6165904436830660558L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_docente")
    private Integer id;

    @Column(name = "nombre_doc")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "celular")
    private String celular;

    @Column(name = "email")
    private String email;
    
    @OneToMany(mappedBy = "docente")
    private List<Asignatura> asignaturas;
}
