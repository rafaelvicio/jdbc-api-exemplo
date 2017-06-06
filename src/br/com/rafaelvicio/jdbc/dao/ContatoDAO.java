package br.com.rafaelvicio.jdbc.dao;


import br.com.rafaelvicio.jdbc.ConnectionFactory;
import br.com.rafaelvicio.jdbc.modelo.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

public class ContatoDAO {

    private Connection conection;

    public ContatoDAO(){
        this.conection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Contato contato){

        String sql = "insert into contatos (nome, email, endereco, dataNascimento) values (?, ?, ?, ?)";

        try {
            // Prepared statement para inserção
            PreparedStatement stmt = conection.prepareStatement(sql);

            //seta os valores
            stmt.setString(1, "Rafael");
            stmt.setString(2, "JDBC");
            stmt.setString(3, "Brasilia");
            stmt.setString(4, new Date(contato.getDataNascimento().getTimeInMillis());

            //executa
            stmt.execute();
            stmt.close();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
