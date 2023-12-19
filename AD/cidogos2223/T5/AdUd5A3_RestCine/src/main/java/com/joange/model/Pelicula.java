package com.joange.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;

@Entity
@Table(name="Pelicula")
@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Pelicula implements Serializable {

	//utilizado para serializar y deserializar objetos
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)	
		Long idPelicula;
		
		@Column
		String titulo;
		
		@Column
		int anyo;
		
		@ManyToOne(fetch = FetchType.EAGER)		// al obtener Pelicula obtengo director
		@Cascade(CascadeType.SAVE_UPDATE)
		@JoinColumn(name = "idDirector", nullable = false)	//toda pelicula tiene director
		//@JsonIgnore
		Director director;

}
