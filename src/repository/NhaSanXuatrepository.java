/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.ConnectionSQL;
import domainModels.ChucVu;
import domainModels.NhaSanXuat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author forre
 */
public class NhaSanXuatrepository {
      public ArrayList SelectNhaSanXuat() {
        Connection cone = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<NhaSanXuat> nhaSanXuats = new ArrayList<>();
        String sql = " select id,ma,ten from NSX ";
        try {

            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                NhaSanXuat nhaSanXuat = new NhaSanXuat();
                nhaSanXuat.setId(rs.getString("id"));
                nhaSanXuat.setMa(rs.getString("ma"));
                nhaSanXuat.setTen(rs.getString("ten"));
                nhaSanXuats.add(nhaSanXuat);
            }
            return nhaSanXuats;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionSQL.closeJDBC(cone, stm, rs);
        }
        return null;
    }

    public void InsertNhaSanXuat(NhaSanXuat nhaSanXuat) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "insert into NSX values ( ?,?,?)";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            UUID id = UUID.randomUUID();
            stm.setString(1, id.toString());
            stm.setString(2, nhaSanXuat.getMa());
            stm.setString(3, nhaSanXuat.getTen());
            stm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            ConnectionSQL.closeJDBC(cone, stm, null);

        }

    }

    public void DeleteNhaSanXuat(String ma) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "delete from NSX where ma=?";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            stm.setString(1, ma);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            ConnectionSQL.closeJDBC(cone, stm, null);
        
        }
    }

    public void UpdateNhaSanXuat(String ma, String hoten, String id) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "update  NSX set ma=?,ten =? where id =?";
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
