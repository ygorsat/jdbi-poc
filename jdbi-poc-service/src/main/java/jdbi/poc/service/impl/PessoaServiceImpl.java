package jdbi.poc.service.impl;

import static jdbi.poc.service.constants.ServiceConstants.ENTITY_POST;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jdbi.poc.dto.base.MessageApiDTO;
import jdbi.poc.dto.pessoa.PessoaDTO;
import jdbi.poc.persistence.PessoaDAO;
import jdbi.poc.service.PessoaService;
import jdbi.poc.service.exception.BusinessException;
import jdbi.poc.service.util.ResponseUtil;

/**
 * @author ygor.satiro
 * Classe de implementação das regras de negócio (camada de serviços)
 */
@Service
public class PessoaServiceImpl implements PessoaService {	

	@Autowired
	private PessoaDAO pessoaDAO;
	
	@Override
	public PessoaDTO retrievePessoaById(Long id) {
		return pessoaDAO.find(id)
			   .orElseThrow(() -> new BusinessException("Pessoa não encontrada com ID informado."));
	
	}

	@Override
	public Set<PessoaDTO> retrievePessoa() {
		Set<PessoaDTO> dto = pessoaDAO.findAll();
	
		if(dto.isEmpty()) {
			throw new BusinessException("Não foram encontrados registros para Pessoa na base de dados.");
		}
		return dto;
	}

	@Override
	public MessageApiDTO createPessoa(PessoaDTO dto) {		
		dto.setId(pessoaDAO.getSequence());
		
		return ResponseUtil.mountResponse(pessoaDAO.save(dto), ENTITY_POST);
	}


}
