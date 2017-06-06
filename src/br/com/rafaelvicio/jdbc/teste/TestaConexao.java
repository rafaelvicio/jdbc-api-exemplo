package br.com.rafaelvicio.jdbc.teste;


import br.com.rafaelvicio.jdbc.ConnectionFactory;

import java.sql.Connection;

public class TestaConexao {

    public static void main(String[] args) {
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
    }

}
