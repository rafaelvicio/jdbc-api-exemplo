package br.com.rafaelvicio.jdbc.teste;

import br.com.rafaelvicio.jdbc.ConnectionFactory;

import java.sql.Connection;
import java.util.Calendar;

public class JDBCInsere {

    public static void main(String[] args) {
        // Connectando
        Connection connection = new ConnectionFactory().getConnection();

        // Cria um preparedStatement
        String sql = "insert into contatos (nome, email, endereco, dataNascimento) values (?, ?, ?, ?)";
        preparedStatement stmt = connection.prepareStatement(sql);

        // Preenchendo os valores
        stmt.setString(1, "Rafael");
        stmt.setString(2, "JDBC");
        stmt.setString(3, "Brasilia");
        stmt.setString(4, new java.sql.Date(Calendar.getInstance().getTime()));

        //executando
        stmt.execute();
        stmt.close();

        System.out.println("Gravado!");

        //fechando conexão
        connection.close();
    }
}
