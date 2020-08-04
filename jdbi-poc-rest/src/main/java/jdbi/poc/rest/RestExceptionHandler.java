package jdbi.poc.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jdbi.poc.dto.base.MessageApiDTO;
import jdbi.poc.service.exception.BusinessException;

/**
 * @author ygor.satiro
 * Controller Advice para interceptação e tratamento de erros lançados pela aplicação
 */

@ControllerAdvice
public class RestExceptionHandler {

	private static final String ERRO_GENERICO = "Erro desconhecido. Favor verificar os logs da aplicação.";
	
	@ExceptionHandler(BusinessException.class)
	protected ResponseEntity<MessageApiDTO> handleNegocioException(BusinessException ex) {
		return buildResponseEntity(new MessageApiDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()), (HttpStatus.INTERNAL_SERVER_ERROR), ex);
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<MessageApiDTO> handleGenericException(Exception ex) {
		return buildResponseEntity(new MessageApiDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), ERRO_GENERICO, ex.getCause() != null ? ex.getCause().getMessage() : ex.getMessage()), (HttpStatus.INTERNAL_SERVER_ERROR), ex);
	}
	
	@ExceptionHandler(BindException.class)
	protected ResponseEntity<MessageApiDTO> handleBindException(BindException ex) {
		List<String> erros = ex.getBindingResult().getFieldErrors().stream().map(item -> item.getDefaultMessage())
				.collect(Collectors.toList());
		return buildResponseEntity(new MessageApiDTO(HttpStatus.BAD_REQUEST.value(), erros), HttpStatus.BAD_REQUEST, ex);

	}
	private ResponseEntity<MessageApiDTO> buildResponseEntity(MessageApiDTO mensagemErro, HttpStatus httpStatus, Exception e) {
		e.printStackTrace();
		return new ResponseEntity<>(mensagemErro, httpStatus);
	}
}

