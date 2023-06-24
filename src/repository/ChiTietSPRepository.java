/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.ConnectionSQL;
import domainModels.ChiTietSP;
import domainModels.HoaDon;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author forre
 */
public class ChiTietSPRepository {

    public void InSertChitietSp(ChiTietSP chiTietSP) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "insert into  ChiTietSP values(?,?,?,?,?,?,?,?,?,?)";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            UUID id = UUID.randomUUID();
            stm.setString(1, id.toString());
            stm.setString(2, chiTietSP.getIdSp());
            stm.setString(3, chiTietSP.getIdNsx());
            stm.setString(4, chiTietSP.getIdMS());
            stm.setString(5, chiTietSP.getIdDongSP());
            stm.setInt(6, chiTietSP.getNamBH());
            stm.setString(7, chiTietSP.getMoTa());
            stm.setInt(8, chiTietSP.getSoLgTon());
            stm.setBigDecimal(9, chiTietSP.getGiaNhap());
            stm.setBigDecimal(10, chiTietSP.getGiaBan());

            stm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionSQL.closeJDBC(cone, stm, null);
        }

    }

    public ArrayList<ChiTietSP> SelectChiTietSP() {

        ArrayList<ChiTietSP> chiTietSPs = new ArrayList<>();
        Connection cone = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "select *  from ChiTietSP";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                ChiTietSP chiTietSP = new ChiTietSP();
                chiTietSP.setId(rs.getString("id"));
                chiTietSP.setIdSp(rs.getString("idSP"));
                chiTietSP.setIdNsx(rs.getString("idNSX"));
                chiTietSP.setIdMS(rs.getString("idMauSac"));
                chiTietSP.setIdDongSP(rs.getString("idDongSp"));
                chiTietSP.setNamBH(rs.getInt("NamBH"));
                chiTietSP.setMoTa(rs.getString("mota"));
                chiTietSP.setSoLgTon(rs.getInt("soluongton"));
                chiTietSP.setGiaNhap(rs.getBigDecimal("GiaNhap"));
                chiTietSP.setGiaBan(rs.getBigDecimal("GiaBan"));
                chiTietSPs.add(chiTietSP);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionSQL.closeJDBC(cone, stm, rs);
        }
        return chiTietSPs;
    }

    public void deleteChiTietSP(String id) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "delete from ChiTietSP where id=?";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            stm.setString(1, id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionSQL.closeJDBC(cone, stm, null);
        }
    }

    public void UpdateChiTietSP( int NamBH,String moTa,int soluong,BigDecimal gianhap,BigDecimal giaBan,String id  ) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "Update ChiTietSP  set NamBH=?,Mota=?,soLuongton=?,GiaNhap=?,GiaBan=? where id=?";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);

            stm.setInt(1, NamBH);
            stm.setString(2,  moTa);
            stm.setInt(3,soluong );
            stm.setBigDecimal(4, gianhap);
            stm.setBigDecimal(5,giaBan);
            stm.setString(6, id);
            stm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionSQL.closeJDBC(cone, stm, null);
        }
    }
}
