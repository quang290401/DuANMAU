/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.ConnectionSQL;
import domainModels.ChucVu;
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
public class MauSacRepository {
      public ArrayList SelectMauSac (){
        Connection cone = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<MauSac> mauXacs = new ArrayList<>();
        String sql = " select id,ma,ten from Mausac ";
        try {

            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                MauSac mauXac = new MauSac();
                mauXac.setId(rs.getString("id"));
                mauXac.setMa(rs.getString("ma"));
                mauXac.setTen(rs.getString("ten"));
                mauXacs.add(mauXac);
            }
            return mauXacs;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionSQL.closeJDBC(cone, stm, rs);
        }
        return null;
    }

    public void InsertMauSac(MauSac mauSac) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "insert into MauSac values ( ?,?,?)";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            UUID id = UUID.randomUUID();
            stm.setString(1, id.toString());
            stm.setString(2, mauSac.getMa());
            stm.setString(3, mauSac.getTen());
            stm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            ConnectionSQL.closeJDBC(cone, stm, null);

        }

    }

    public void DeleteMauSac(String ma) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "delete from MauSac where id=?";
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

    public void UpdateMauSac(String ma, String hoten, String id) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "update  MauSac set ma=?,ten =? where id =?";
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
