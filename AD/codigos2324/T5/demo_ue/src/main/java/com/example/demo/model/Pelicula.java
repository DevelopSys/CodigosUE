package com.example.demo.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


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
		
		@ManyToOne(fetch = FetchType.LAZY)		// al obtener Pelicula obtengo director
		@Cascade(CascadeType.SAVE_UPDATE)
		@JoinColumn(name = "idDirector", nullable = false)	//toda pelicula tiene director
		//@JsonIgnore
		Director director;

}
