package jdbi.poc.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jdbi.poc.dto.base.MessageApiDTO;
import jdbi.poc.dto.pessoa.PessoaDTO;
import jdbi.poc.service.PessoaService;

/**
 * @author ygor.satiro
 * Controller JDBI
 */
@RestController
@Api(value = "Pessoa Controller") 
@RequestMapping("pessoa")
@CrossOrigin
public class PessoaController {
	
	@Autowired
	private PessoaService service;	
	
	@GetMapping
	@ApiOperation(value = "Operação para consultar todas as Pessoas sem filtro", produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = PessoaDTO.class, message = "Sucesso"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public Set<PessoaDTO> retrievePessoa() {
		return service.retrievePessoa();
	}
	
	@GetMapping("{id}")
	@ApiOperation(value = "Operação para consultar Pessoa por ID", produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = PessoaDTO.class, message = "Sucesso"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public PessoaDTO retrievePessoaById(@PathVariable Long id) {
		return service.retrievePessoaById(id);
	}
	
	@PostMapping
	@ApiOperation(value = "Operação para Cadastrar Pessoa", produces = APPLICATION_JSON_VALUE)
	@ApiResponses(value = {
			@ApiResponse(code = 200, response = MessageApiDTO.class, message = "Sucesso"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 500, message = "Internal Server Error")
	})
	public MessageApiDTO createPessoa(@RequestBody @Valid PessoaDTO dto) {
		return service.createPessoa(dto);
	}

}
