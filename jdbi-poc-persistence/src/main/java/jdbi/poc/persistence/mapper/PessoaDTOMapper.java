package jdbi.poc.persistence.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import jdbi.poc.dto.pessoa.PessoaDTO;

public class PessoaDTOMapper implements RowMapper<PessoaDTO>{

	@Override
	public PessoaDTO map(ResultSet rs, StatementContext ctx) throws SQLException {
		return PessoaDTO.builder()
				.id(rs.getLong("id"))
				.nome(rs.getString("nome"))
				.numeroDocumento(rs.getString("numeroDocumento"))
				.telefoneContato(rs.getString("telefoneContato")).build();
	}
	
	
}
