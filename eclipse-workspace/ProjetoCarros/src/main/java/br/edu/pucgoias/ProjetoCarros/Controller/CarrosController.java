package br.edu.pucgoias.ProjetoCarros.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.pucgoias.ProjetoCarros.Model.Carros;
import br.edu.pucgoias.ProjetoCarros.Repository.CarroRepository;

@RestController
@RequestMapping("/carros")
public class CarrosController {
	
	@Autowired
	private CarroRepository carroRepository ;
	
	@PostMapping("/")
	public Carros carros(@RequestBody Carros carros) 
	{
		return this.carroRepository.save(carros);	
	}
	
	@PutMapping("/")
	public Carros carrosAltera(@RequestBody Carros carros)
	{
		return this.carroRepository.save(carros);
	}
	
	@GetMapping("/lista")
	public List<Carros> lista(){
		return this.carroRepository.findAll();
	}
	
	@GetMapping("/MaiorQue/{id}")
	public List<Carros> carroMaiorQue(@PathVariable("id") Long id){
		
		return this.carroRepository.findByIdGreaterThan(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Carros> carroPorId(@PathVariable("id") Long id){
		return this.carroRepository.findById(id);
	}
	
	
	@GetMapping("/listaModelo/{modelo}")
	public List<Carros> carroPorNome(@PathVariable("modelo") String modelo){
		return this.carroRepository.findByModelo(modelo);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Long> carroDetele(@PathVariable("id") Long id){
		carroRepository.deleteById(id);
		return null ;
	}	
	
}
