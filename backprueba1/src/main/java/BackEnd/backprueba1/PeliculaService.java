package BackEnd.backprueba1;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@ApplicationScoped
@Service
@Transactional
public class PeliculaService {

	// Entorno:
	@Autowired
	private PeliculaRepository pelisRepo;

	// Metodos:
	public List<PeliculaDTO> getAll() {
		ModelMapper mapper = new ModelMapper();
		List<PeliculaDTO> peliculas = new ArrayList<>();
		for (Pelicula p : pelisRepo.findAll()) {
			PeliculaDTO dto = mapper.map(p, PeliculaDTO.class);
			peliculas.add(dto);
		}
		return peliculas;
	}

	public List<PeliculaDTO> setPelicula(PeliculaDTO pelicula) {
		ModelMapper mapper = new ModelMapper();
		Pelicula peli = mapper.map(pelicula, Pelicula.class);
		pelisRepo.save(peli);
		List<PeliculaDTO> peliculas = new ArrayList<>();
		for (Pelicula p : pelisRepo.findAll()) {
			PeliculaDTO dto = mapper.map(p, PeliculaDTO.class);
			peliculas.add(dto);
		}
		return peliculas;
	}

	public PeliculaDTO buscar(Long id) {
		ModelMapper mapper = new ModelMapper();
		Pelicula peli = pelisRepo.findById(id).get();
		PeliculaDTO dto = mapper.map(peli, PeliculaDTO.class);
		return dto;
	}
	
	public List<PeliculaDTO> mejorBuscar(long id, String nombre, String anio, long premios) {
		ModelMapper mapper = new ModelMapper();
		List<Pelicula> peli = new ArrayList<>();
		peli = pelisRepo.findByNombre(id, nombre, anio, premios);
		List<PeliculaDTO> pelis = new ArrayList<>();
		for(Pelicula p:peli) {
			pelis.add(mapper.map(p,PeliculaDTO.class));
		}
		return pelis;
	}
	

	public PeliculaDTO actualizaPelicula(PeliculaDTO nuevaPeli, long id) {
		ModelMapper mapper = new ModelMapper();
		nuevaPeli.setId(id);
		Pelicula entidad = mapper.map(nuevaPeli, Pelicula.class);
		return mapper.map(pelisRepo.save(entidad), PeliculaDTO.class);
	}

	public void borraPelicula(long id) {
		pelisRepo.deleteById(id);		
	}
	
	
	

}
