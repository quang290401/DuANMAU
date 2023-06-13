/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.sql.*;
import common.ConnectionSQL;
import domainModels.ChucVu;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author forre
 */
public class ChucVuRepository {

    public ArrayList<ChucVu> SelectChucVu() {
        Connection cone = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<ChucVu> chucVus = new ArrayList<>();
        String sql = " select id,ma,ten from ChucVu ";
        try {

            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                ChucVu chucVu = new ChucVu();
                chucVu.setId(rs.getString("id"));
                chucVu.setMa(rs.getString("ma"));
                chucVu.setHoTen(rs.getString("ten"));
                chucVus.add(chucVu);
            }
            return chucVus;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionSQL.closeJDBC(cone, stm, rs);
        }
        return null;
    }

    public void InsertChucVu(ChucVu chucVu) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "insert into ChucVu values ( ?,?,?)";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            UUID id = UUID.randomUUID();
            stm.setString(1, id.toString());
            stm.setString(2, chucVu.getMa());
            stm.setString(3, chucVu.getHoTen());
            stm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            ConnectionSQL.closeJDBC(cone, stm, null);

        }

    }

    public void DeleteChucVu(String ma) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "delete from chucvu where ma=?";
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

    public void UpdateChucVu(String ma, String hoten, String id) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "update  chucvu set ma=?,ten =? where id =?";
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
