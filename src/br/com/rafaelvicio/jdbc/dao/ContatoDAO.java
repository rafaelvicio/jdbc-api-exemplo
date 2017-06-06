package br.com.rafaelvicio.jdbc.dao;


import br.com.rafaelvicio.jdbc.ConnectionFactory;
import br.com.rafaelvicio.jdbc.modelo.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    public ResultSet getLista(){
        PreparedStatement stmt = this.conection.prepareStatement("select * from contatos");
        ResultSet rs = stmt.executeQuery();

        List<Contato> contatos = new ArrayList<>();

        while (rs.next()){

            // Criando o objeto Contato
            Contato contato = new Contato();
            contato.setNome(rs.getString("nome"));
            contato.setEmail(rs.getString("email"));
            contato.setEndereco(rs.getString("endereco"));

            //montando a data através do Calendar
            Calendar data = Calendar.getInstance();
            data.setTime(rs.getDate("dataNascimento"));
            contato.setDataNascimento(data);

            //adiciona o objeto á lista
            contatos.add(contato);
        }

        rs.close();
        stmt.close();

        return contatos;
    }
}
