package BackEnd.backprueba1;

import java.io.File;
import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@ManagedBean
@SessionScoped
@Entity
@Named
public class Pelicula implements Serializable {
	
	//Entorno:
	@Id
	/*
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_generator")
	@SequenceGenerator(name="id_generator", sequenceName = "id_generator_seq", initialValue=50, allocationSize=1)
	@Column(name="id", nullable=false)*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private String anio;
	private long premios;
	/* aqui va el atributo pdf mirar tutorial hibernate*/
	
	
	//Constructores:
	
	protected Pelicula() {	
	}
	
	public Pelicula(String nombre, String anio, long premios) {
		this.nombre=nombre;
		this.anio=anio;
		this.premios=premios;
	}
	
	//Metodos-Funciones:
	
	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getAnio() {
		return this.anio;
	}
	
	public void setAnio(String anio) {
		this.anio=anio;
	}
	
	public long getPremios() {
		return this.premios;
	}
	
	public void setPremios(long premios) {
		this.premios=premios;
	}
	
	
	
	@Override
	public String toString() {
		return String.format(
				"Peliculas[nId=%d, nombre='%s', anio='%s', premios='%d']",
				id,nombre,anio,premios);
	}
	
	
	
	

}
