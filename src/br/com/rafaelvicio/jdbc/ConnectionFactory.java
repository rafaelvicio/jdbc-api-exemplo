package br.com.rafaelvicio.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection getConnection(){
        System.out.printLn("Conectado ao banco");
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "");

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}
