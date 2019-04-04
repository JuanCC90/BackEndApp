package BackEnd.backprueba1;

import java.io.File;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PeliculaRepository extends CrudRepository<Pelicula, Long> {
	/*@Query("select p from Pelicula p where (:id is null or p.id like CONCAT ('%',:id,'%')) "
			+ "and (:nombre is null or UPPER(p.nombre) like CONCAT ('%',UPPER(:nombre),'%')) "
			+ "and (:anio is null or p.anio like CONCAT ('%',:anio,'%')) "
			+ "and (:premios is null or p.premios like CONCAT ('%',UPPER(:premios), '%'))")*/
	@Query("select p from Pelicula p where (:id is null or p.id like CONCAT ('%',:id,'%')) and (:nombre is null or p.nombre like CONCAT ('%',UPPER(:nombre),'%'))"
			+ "and (:anio is null or p.anio like CONCAT ('%',:anio,'%')) and (:premios ir null or p.premios like CONCAT('%',UPPER(:premios),'%')) ")
	List<Pelicula> findByNombre(@Param("id") long id, @Param("nombre") String nombre, @Param("anio") String anio, @Param("premios") long premios);
	
	
	Pelicula getById(long id);
	
	List<Pelicula> findAll();
	
	
	Pelicula findById(long id);
	
	
	Pelicula deleteById(long id);
	
}
