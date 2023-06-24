/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.ConnectionSQL;
import domainModels.DongSP;
import domainModels.MauSac;
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
public class DongSPRepository {
          public ArrayList SelectDongSP (){
        Connection cone = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<DongSP> dongSPs = new ArrayList<>();
        String sql = " select id,ma,ten from DongSP ";
        try {

            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                DongSP dongSP = new DongSP();
                dongSP.setId(rs.getString("id"));
                dongSP.setMa(rs.getString("ma"));
                dongSP.setTen(rs.getString("ten"));
                dongSPs.add(dongSP);
            }
            return dongSPs;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionSQL.closeJDBC(cone, stm, rs);
        }
        return null;
    }

    public void InsertDongSP(DongSP dongSP) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "insert into DongSP values ( ?,?,?)";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            UUID id = UUID.randomUUID();
            stm.setString(1, id.toString());
            stm.setString(2, dongSP.getMa());
            stm.setString(3, dongSP.getTen());
            stm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            ConnectionSQL.closeJDBC(cone, stm, null);

        }

    }

    public void DeleteDongSP(String ma) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "delete from DongSP where id=?";
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

    public void UpdateDongSP(String ma, String hoten, String id) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "update  DongSP set ma=?,ten =? where id =?";
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
