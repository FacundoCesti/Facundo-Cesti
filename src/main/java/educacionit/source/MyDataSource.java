package educacionit.source;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class MyDataSource {
	private static HikariConfig config = new HikariConfig();
    private static HikariDataSource ds;
    
    static {
        config.setJdbcUrl( "jdbc:h2:mem:testdb;INIT=RUNSCRIPT FROM 'classpath:eduit.sql'" );
        config.setUsername( "sa" );
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        config.setDriverClassName("org.h2.Driver");
        ds = new HikariDataSource( config );
    }

   

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
