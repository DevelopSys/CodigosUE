package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Director")
@Data @AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Director implements Serializable{
	
	//utilizado para serializar y deserializar objetos
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idDirector;
	
	@Column
	String nombre;
	
	@Column
	int anyoNacimiento;

	@OneToMany (mappedBy = "director")
	List<Pelicula> listaPeliculas;

}
