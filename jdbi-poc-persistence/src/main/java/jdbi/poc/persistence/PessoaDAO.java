package jdbi.poc.persistence;

import java.util.Optional;
import java.util.Set;

import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;
import org.springframework.stereotype.Repository;

import jdbi.poc.dto.pessoa.PessoaDTO;
import jdbi.poc.persistence.mapper.PessoaDTOMapper;
import jdbi.poc.sql.log.factory.LogSqlFactory;

/**
 * @author ygor.satiro
 * Classe para DAO (Data Acess Object) da Pessoa
 */
@Repository
@LogSqlFactory
public interface PessoaDAO {
	
	/**
	 * Salvar em Pessoa
	 * 
	 * @return {@link Long} - ID da Pessoa persistida
	 */
	@GetGeneratedKeys
    @SqlUpdate("INSERT INTO pessoa(id, nome, numeroDocumento, telefoneContato) VALUES(:id, :nome, :numeroDocumento, :telefoneContato)")
	public Long save(@BindBean PessoaDTO p);

	/**
	 * Remover Pessoa por ID informado
	 * 
	 * @return {@link Boolean} - TRUE para sucesso ao remover
	 */
	@SqlQuery("delete from pessoa where id = :id")
	public boolean removePessoa(@Bind("id") Long id);
	
	/**
	 * Recuperar Pessoa por ID informado
	 * 
	 * @return {@link Optional<Pessoa}
	 */
	@SqlQuery("select * from pessoa where id = :id")
	@UseRowMapper(PessoaDTOMapper.class)
	public Optional<PessoaDTO> find(@Bind("id") Long id);

	/**
	 * Recuperar todos as Pessoas em base de dados.
	 * 
	 * @return {@link Iterable<Pessoa>}
	 */
	@SqlQuery("select * from pessoa")
	@UseRowMapper(PessoaDTOMapper.class)
	Set<PessoaDTO> findAll();
	
	@SqlQuery("select nextval('pessoa_seq')")
	Long getSequence();

}
