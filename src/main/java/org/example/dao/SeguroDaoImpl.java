package org.example.dao;

import org.example.model.ISeguro;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SeguroDaoImpl implements SeguroDao{


    private final Connection connection;
    public SeguroDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(ISeguro seguro) {
        String sql = "INSERT INTO T_SEG_SEGURO(valor, tipo) VALUES (?,?)";


        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, seguro.getValor());
            pstmt.setString(2, seguro.getTipo());

            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(ISeguro seguro) {
        String sql = "UPDATE T_SEG_SEGURO SET valor = ?, tipo = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, seguro.getValor());
            pstmt.setString(2, seguro.getTipo());
            pstmt.setInt(3, seguro.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    @Override
    public void delete(ISeguro seguro) {
        String sql = "DELETE FROM T_SEG_SEGURO WHERE id = ?";

        try{
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, seguro.getId());
            pstm.executeUpdate();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }


    }
}
