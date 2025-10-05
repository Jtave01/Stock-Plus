package br.com.stockplus.connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    public static Connection getConnection() throws SQLException {

        try(InputStream input = ConnectionUtil.class.getClassLoader().getResourceAsStream("application.properties");
        ) {
            Properties props = new Properties();
            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String password = props.getProperty("db.password");


            return DriverManager.getConnection(url, user, password);

        }catch (Exception e){
            throw new SQLException("Erro ao se conectar ao banco", e);
        }


    }
}
