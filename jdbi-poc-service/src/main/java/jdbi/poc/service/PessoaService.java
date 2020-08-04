package jdbi.poc.service;

import java.util.Set;

import jdbi.poc.dto.base.MessageApiDTO;
import jdbi.poc.dto.pessoa.PessoaDTO;
import jdbi.poc.service.exception.BusinessException;

/**
 * @author ygor.satiro
 * Classe de interface de serviços
 */

public interface PessoaService {

	/**
	 * Consultar Pessoa cadastrados em memory database (H2) - All
	 * 
	 * @return {@link Set<PessoaDTO>} - Pessoa em memory database
	 * @throws BusinessException 
	 */
	public Set<PessoaDTO> retrievePessoa();

	/**
	 * Consultar Pessoa por ID
	 * 
	 * @return {@link PessoaDTO} - Pessoa em memory database por ID
	 * @throws BusinessException 
	 */
	public PessoaDTO retrievePessoaById(Long id);

	
	/**
	 * Criar Pessoa a partir de dados inseridos
	 * 
	 * @return {@link MessageApiDTO} - Retorno com mensagem estática e ID gerado para item criado
	 * @throws BusinessException 
	 */
	public MessageApiDTO createPessoa(PessoaDTO dto);

}
