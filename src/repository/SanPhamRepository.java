/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.ConnectionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import domainModels.SanPham;

/**
 *
 * @author forre
 */
public class SanPhamRepository {
      public ArrayList<SanPham> SelectSanPham() {
        Connection cone = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        String sql = " select id,ma,ten from SanPham ";
        try {

            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham();
                sanPham.setId(rs.getString("id"));
                sanPham.setMa(rs.getString("ma"));
                sanPham.setTen(rs.getString("ten"));
                sanPhams.add(sanPham);
            }
            return sanPhams;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionSQL.closeJDBC(cone, stm, rs);
        }
        return null;
    }

    public void InsertSanPham(SanPham sanPham) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "insert into SanPham values ( ?,?,?)";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            UUID id = UUID.randomUUID();
            stm.setString(1, id.toString());
            stm.setString(2, sanPham.getMa());
            stm.setString(3, sanPham.getTen());
            stm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            ConnectionSQL.closeJDBC(cone, stm, null);

        }

    }

    public void DeleteSanPham(String id) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "delete from SanPham where id=?";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            stm.setString(1, id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            ConnectionSQL.closeJDBC(cone, stm, null);
        
        }
    }

    public void UpdateSanPham(String ma, String hoten, String id) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "update  SanPham set ma=?,ten =? where id =?";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            stm.setString(1, ma);
            stm.setString(2, hoten);
            stm.setString(3, id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            ConnectionSQL.closeJDBC(cone, stm, null);
        
        }
    }
}
