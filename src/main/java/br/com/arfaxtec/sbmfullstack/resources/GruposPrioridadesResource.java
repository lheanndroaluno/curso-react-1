package br.com.arfaxtec.sbmfullstack.resources;

import java.util.List;

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

import br.com.arfaxtec.sbmfullstack.domain.GruposPrioridades;
import br.com.arfaxtec.sbmfullstack.repository.GruposPrioridadesRepository;

@RestController
@RequestMapping("/gruposPrioridades")
public class GruposPrioridadesResource {
	
	@Autowired
	private GruposPrioridadesRepository gpreRepository;

	/**
	 * Método para inserir dados, sem retorno
	 * @param gp
	 
	@PostMapping
	public void inserir(@RequestBody GruposPrioridades gp) {
		gpreRepository.save(gp);
	}
	*/
	
	/**
	 * Método para inserir dados, com retorno
	 * @param gp
	 */
	@PostMapping
	public GruposPrioridades inserirGP(@RequestBody GruposPrioridades gp) {
		return gpreRepository.save(gp);
	}
	
	/**
	 * Método para listar todos os grupos prioritários
	 * @return
	 */
	@GetMapping
	public List<GruposPrioridades> listarTodos(){
		return gpreRepository.findAll();
	}
	
	@PutMapping("/{codigo}")
	public GruposPrioridades atualizar(
			@PathVariable ("codigo") Long codigo, 
			@RequestBody GruposPrioridades gp) {
		
		return gpreRepository.findById(codigo).map(
				record -> {
					record.setNome(gp.getNome());
					record.setDescricao(gp.getDescricao());
					return gpreRepository.save(record);
				}).orElse(null); 

	}
	
	@GetMapping("/{codigo}")
	public GruposPrioridades buscarPeloGP(@PathVariable ("codigo") Long codigo) {
		return gpreRepository.findById(codigo).orElse(null);
	}
	
	/*
	@DeleteMapping("/{codigo}")
	public ResponseEntity<GruposPrioridades> excluir(@PathVariable ("codigo") Long codigo){
		gpreRepository.deleteById(codigo);
		return ResponseEntity.noContent().build();
		
	}
	*/
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<GruposPrioridades> excluirGP(@PathVariable ("codigo") Long codigo){
		gpreRepository.deleteById(codigo);
		return ResponseEntity.ok().body(null);
		
	}
}
