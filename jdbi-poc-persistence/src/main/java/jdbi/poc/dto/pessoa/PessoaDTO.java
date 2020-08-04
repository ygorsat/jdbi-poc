package jdbi.poc.dto.pessoa;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author ygor.satiro
 * DTO unificado para operações de CRUD com Pessoa
 */

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class PessoaDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7670708210807830644L;
	
	private Long id;	
	
	@Size(max = 250, message = "Nome deve ter até {max} caracteres.")
	@NotNull(message = "Nome é obrigatório.")
	private String nome;

	@Size(max = 250, message = "Número Documento deve ter até {max} caracteres.")
	@NotNull(message = "Número Documento é obrigatório.")
	private String numeroDocumento;
	
	@Size(max = 14, message = "Telefone Contato deve ter até {max} caracteres.")
	@NotNull(message = "Telefone Contato é obrigatório.")
	private String telefoneContato;


}
