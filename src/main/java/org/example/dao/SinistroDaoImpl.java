package org.example.dao;

import oracle.jdbc.proxy.annotation.Pre;
import org.example.model.Sinistro;
import org.example.model.StatusSinistro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SinistroDaoImpl implements SinistroDao{

    private final Connection connection;
    public SinistroDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Long create(Sinistro sinistro) {
        String sql = "insert into t_seg_sinistro (id_contratacao, descricao, status, valor) values(?,?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql, new String[] {"id"});
            pstmt.setLong(1, sinistro.getContratacao());
            pstmt.setString(2, sinistro.getDescricao());
            pstmt.setString(3, sinistro.getStatus().getDescricao());
            pstmt.setDouble(4, sinistro.getValor());

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
    public List<Sinistro> findAll() {
        return List.of();
    }

    @Override
    public Sinistro findById(Long id) {
        String sql = "select * from t_seg_sinistro where id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setLong(1, id);
            pstmt.executeQuery();
            ResultSet rs = pstmt.getResultSet();
            if (rs.next()) {
                return new Sinistro(
                        rs.getLong("id"),
                        rs.getLong("id_contratacao"),
                        rs.getString("descricao"),
                        StatusSinistro.valueOf(rs.getString("status").toUpperCase()),
                        rs.getDouble("valor")
                        );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(Sinistro sinistro) {
        String sql = "UPDATE t_seg_sinistro SET status = ? where id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, sinistro.getStatus().getDescricao());
            pstmt.setLong(2, sinistro.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Sinistro sinistro) {

    }
}
