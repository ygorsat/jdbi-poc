package jdbi.poc.dto.base;

import java.util.Arrays;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * @author ygor.satiro
 * DTO base para retorno de mensagens padronizadas para as operações Pessoa
 */
@Data
@JsonInclude(Include.NON_NULL)
public class MessageApiDTO {
	
	private List<Long> id;
    private Integer status;
    private String mensagem;
    private List<String> erros;
 
    public MessageApiDTO(Integer status, String mensagem, List<String> erros) {
        super();
        this.status = status;
        this.mensagem = mensagem;
        this.erros = erros;
    }
    public MessageApiDTO(Integer status, List<String> erros) {
        super();
        this.status = status;        
        this.erros = erros;
    }
    
    public MessageApiDTO(Integer status, String mensagem, String erro) {
        super();
        this.status = status;
        this.mensagem = mensagem;
        erros = Arrays.asList(erro);
    }
    public MessageApiDTO(Integer status, String mensagem) {
        super();
        this.status = status;
        this.mensagem = mensagem;

    }
    public MessageApiDTO(Long id, Integer status, String mensagem) {
        super();
        this.id = Arrays.asList(id);
        this.status = status;
        this.mensagem = mensagem;

    }
    
    public MessageApiDTO(List<Long> ids, Integer status, String mensagem) {
        super();
        this.id = ids;
        this.status = status;
        this.mensagem = mensagem;

    }
	public MessageApiDTO() {}
}