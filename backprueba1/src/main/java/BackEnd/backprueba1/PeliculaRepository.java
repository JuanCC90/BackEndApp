package BackEnd.backprueba1;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PeliculaRepository extends CrudRepository<Pelicula, Long> {
	@Query("select p from Pelicula p where (:id is null and p.id like CONCAT ('%',:id,'%')) or (:nombre is null and UPPER(p.nombre) like CONCAT ('%',UPPER(:nombre),'%')) or (:anio is null and p.anio like CONCAT ('%',:anio,'%')) or (:premios is null and p.premios like CONCAT ('%',UPPER(:premios), '%'))")
	List<Pelicula> findByNombre(@Param("id") long id, @Param("nombre") String nombre, @Param("anio") String anio, @Param("premios") long premios);
	
	
	Pelicula getById(long id);
	
	List<Pelicula> findAll();
	
	
	Pelicula findById(long id);
	
	
	Pelicula deleteById(long id);
	
}
