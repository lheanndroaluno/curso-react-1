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

import br.com.arfaxtec.sbmfullstack.domain.Pessoa;
import br.com.arfaxtec.sbmfullstack.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	/**
	 * Injetar
	 * chamando a pessoaRepository para acessar o banco de dados
	 */
	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping
	public List<Pessoa> listarTodos(){
		return pessoaRepository.findAll();//retorna todas as pessoas cadastradas no banco
	}
	
	@PostMapping
	public Pessoa inserirPessoa(@RequestBody Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}
	
	/**
	 * Método atualizar
	 * @param codigo
	 * @param pessoa
	 * @return
	 */
	@PutMapping("/{codigo}")
	public Pessoa atualizar(@PathVariable ("codigo") Long codigo, @RequestBody Pessoa pessoa){
		return pessoaRepository.findById(codigo).map(
				record -> {
					record.setNome(pessoa.getNome());
					record.setCpf(pessoa.getCpf());
					record.setTelefone(pessoa.getTelefone());
					record.setEmail(pessoa.getEmail());
					record.setIdade(pessoa.getIdade());
					record.setDataNascimento(pessoa.getDataNascimento());
					return pessoaRepository.save(record);
				}).orElse(null);
	}
	
	@GetMapping("/{codigo}")
	public Pessoa buscarPeloCodigo(@PathVariable Long codigo) {
		return pessoaRepository.findById(codigo).orElse(null);
	}
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo){
		pessoaRepository.deleteById(codigo);
		return ResponseEntity.noContent().build();
	}
}
