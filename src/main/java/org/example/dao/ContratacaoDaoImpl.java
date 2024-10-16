package org.example.dao;

import org.example.model.Contratacao;
import org.example.model.StatusContratacao;

import java.sql.*;
import java.util.List;

public class ContratacaoDaoImpl implements ContratacaoDao {

    private final Connection connection;

    public ContratacaoDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long create(Contratacao contratacao) {
        String sql = "INSERT INTO t_seg_contratacao (id_cliente, id_seguro, dt_contratacao, status) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"id"});
            pstmt.setLong(1, contratacao.getCliente());
            pstmt.setLong(2, contratacao.getSeguro());
            pstmt.setDate(3, Date.valueOf(contratacao.getDataContratacao()));
            pstmt.setString(4, contratacao.getStatus().getDescricao());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            while (rs.next()) {
                return rs.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Contratacao> findAll() {
        return List.of();
    }

    @Override
    public Contratacao findById(Long id) {
        String sql = "SELECT * from t_seg_contratacao WHERE id = ?";
        Contratacao contratacao = null;
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                contratacao = new Contratacao(
                        rs.getLong("id"),
                        rs.getLong("id_cliente"),
                        rs.getLong("id_seguro"),
                        rs.getDate("dt_contratacao").toLocalDate(),
                        StatusContratacao.valueOf(rs.getString("status").toUpperCase())
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return contratacao;
    }


    @Override
    public void delete(Contratacao contratacao) {
        String sql = "UPDATE t_seg_contratacao SET status = ? WHERE id = ?";

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, StatusContratacao.INATIVO.getDescricao());
            pstmt.setLong(2, contratacao.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
