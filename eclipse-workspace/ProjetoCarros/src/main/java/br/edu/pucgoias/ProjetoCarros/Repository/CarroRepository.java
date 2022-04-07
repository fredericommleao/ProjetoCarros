package br.edu.pucgoias.ProjetoCarros.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.pucgoias.ProjetoCarros.Model.Carros;

public interface CarroRepository extends JpaRepository<Carros, Long> {
	
	@Query("SELECT u from Carros u where u.id >:id")
	public List<Carros> buscaTodosMaiorque(@Param("id") Long id);
	
	public List<Carros> findByIdGreaterThan(Long id);
	
	public List<Carros> findByModelo(String modelo);
	
}
