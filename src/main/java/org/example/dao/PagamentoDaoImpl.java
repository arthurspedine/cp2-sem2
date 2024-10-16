package org.example.dao;

import org.example.model.Pagamento;

import java.sql.*;

public class PagamentoDaoImpl implements PagamentoDao {

    private final Connection connection;

    public PagamentoDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long create(Pagamento pagamento) {
        String sql = "INSERT INTO t_seg_pagamento (id_contratacao, valor, dt_pagamento) VALUES (?, ?, ?)";
        try {
             PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"id"});
             pstmt.setLong(1, pagamento.getContratacao());
             pstmt.setDouble(2, pagamento.getValor());
             pstmt.setDate(3, Date.valueOf(pagamento.getDataPagamento()));
             pstmt.executeUpdate();
             ResultSet rs = pstmt.getGeneratedKeys();
             if (rs.next()) {
                 return rs.getLong(1);
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Pagamento findById(Long id) {
        String sql = "SELECT * FROM t_seg_pagamento WHERE id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Pagamento(
                        rs.getLong("id"),
                        rs.getLong("id_contratacao"),
                        rs.getDouble("valor"),
                        rs.getDate("dt_pagamento").toLocalDate()
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(Pagamento pagamento) {

    }

    @Override
    public void delete(Long id) {

    }
}
