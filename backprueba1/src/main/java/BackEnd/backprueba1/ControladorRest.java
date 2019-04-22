package BackEnd.backprueba1;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import FrontEnd.frontprueba1.PeliculaDTO;

@RestController
public class ControladorRest {

	//Entorno:
	@Autowired
	private PeliculaService peliServi;
	

	
	//Metodos:
	@RequestMapping("/AllPelis")		//Metodo devuelve todos los elementos(Peliculas) de la BD
	public List<PeliculaDTO> getAll(){
		return peliServi.getAll();
	}
	
	
	@PostMapping("/Pelicula/post")		//Metodo para añadir elemento(Pelicula) a la BD
	public List<PeliculaDTO> nuevaPeli(@RequestBody PeliculaDTO newPeli){
		List<PeliculaDTO> peliculas= peliServi.setPelicula(newPeli);
		return peliculas;
	}
	
	@GetMapping("Pelicula/get/{id}")   //Metodo para buscar elemento(Pelicula) por Id
	public PeliculaDTO busqueda(@PathVariable("id") Long id) {
		return peliServi.buscar(id);
		
	}
	
	
	 @GetMapping("Pelicula/busca")
	public List<PeliculaDTO> buscar(@RequestParam("id") long id, @RequestParam("nombre") String nombre, @RequestParam("anio") String anio, @RequestParam("premios") long premios){
		 List<PeliculaDTO> peliculas = peliServi.mejorBuscar(id, nombre, anio, premios);
		 return peliculas;
	 }
	
	
	@PutMapping("/Pelicula/put/{id}")	//Metodo para actualizar elemento(Pelicula) por Id
	public PeliculaDTO actualizarPeli(@RequestBody PeliculaDTO nuevaPeli, @PathVariable Long id){
		return peliServi.actualizaPelicula(nuevaPeli, id);
	}
	
	
	
	@DeleteMapping("/Pelicula/Delete/{id}")		//Metodo para borrar elementos(Peliculas) por Id
	public void borrarPelicula(@PathVariable long id){
		peliServi.borraPelicula(id);
		
	}
	/*
	@PostMapping("/Pelicula/Enviar/{archivo}")
	public ResponseEntity<?> subirArchivo(@RequestParam("archivo") MultipartFile file){
		if(file.isEmpty()) {
			return new ResponseEntity <Object>("Seleccione un archivo", HttpStatus.OK);
		}
		
		try {
			peliServi.guardaArchivo(file);
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		return new ResponseEntity<Object> ("Archivo subido correctamente", HttpStatus.OK);
	}
	
	*/
	

	
	

	
}

