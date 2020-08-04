package jdbi.poc.service.configuration;

import java.util.List;

import javax.sql.DataSource;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.spi.JdbiPlugin;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import jdbi.poc.persistence.PessoaDAO;

@Configuration
public class JdbiConfiguration {
	
    @Bean
    public Jdbi jdbi(DataSource ds, List<JdbiPlugin> jdbiPlugins, List<RowMapper<?>> rowMappers) {        
        TransactionAwareDataSourceProxy proxy = new TransactionAwareDataSourceProxy(ds);        
        Jdbi jdbi = Jdbi.create(proxy);
        jdbiPlugins.forEach(plugin -> jdbi.installPlugin(plugin));
        rowMappers.forEach(mapper -> jdbi.registerRowMapper(mapper));       
        return jdbi;
    }
    
    @Bean
    public JdbiPlugin sqlObjectPlugin(DataSource dataSource) {
    	return new SqlObjectPlugin();
    }
    
    @Bean
    public PessoaDAO pessoaDAO(Jdbi jdbi) {
    	return jdbi.onDemand(PessoaDAO.class);
    }
}
