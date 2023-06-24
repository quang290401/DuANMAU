/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.ConnectionSQL;
import domainModels.HoaDon;
import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author forre
 */
public class HoaDonRepository {

    public void InsertHoaDon(HoaDon hoaDon) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "insert into  HoaDon values(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            UUID id = UUID.randomUUID();
            stm.setString(1, id.toString());
            stm.setString(2, hoaDon.getIdKH());
            stm.setString(3, hoaDon.getIdNV());
            stm.setString(4, hoaDon.getMa());
            stm.setDate(5, (Date) hoaDon.getNgayTao());
            stm.setDate(6, (Date) hoaDon.getNgayThanhToan());
            stm.setDate(7, (Date) hoaDon.getNgayShip());
            stm.setDate(8, (Date) hoaDon.getNgayNhan());
            stm.setInt(9, hoaDon.getTinhTrang());
            stm.setString(10, hoaDon.getTenNguoiNhan());
            stm.setString(11, hoaDon.getDiaChi());
            stm.setString(12, hoaDon.getSoDienThoai());
            stm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionSQL.closeJDBC(cone, stm, null);
        }

    }

    public ArrayList<HoaDon> SelectHoaDon() {
        ArrayList<HoaDon> hoaDons = new ArrayList<>();
        Connection cone = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "select *  from HoaDon";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(rs.getString("id"));
                hoaDon.setIdKH(rs.getString("idKH"));
                hoaDon.setIdNV(rs.getString("idNV"));
                hoaDon.setMa(rs.getString("ma"));
                hoaDon.setNgayTao(rs.getDate("ngaytao"));
                hoaDon.setNgayThanhToan(rs.getDate("ngayThanhtoan"));
                hoaDon.setNgayShip(rs.getDate("ngayShip"));
                hoaDon.setNgayNhan(rs.getDate("ngayNhan"));
                hoaDon.setTinhTrang(rs.getInt("tinhtrang"));
                hoaDon.setTenNguoiNhan(rs.getString("tenNguoinhan"));
                hoaDon.setDiaChi(rs.getString("diachi"));
                hoaDon.setSoDienThoai(rs.getString("sdt"));
                hoaDons.add(hoaDon);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionSQL.closeJDBC(cone, stm, rs);
        }
        return hoaDons;
    }

    public void deleteHoaDon(String id) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "delete from hoadon where id=?";
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

    public void UpdateHD(String ma, java.util.Date ngTao, java.util.Date ngThanhToan, java.util.Date ngShip, java.util.Date ngNhan,
            int tinhTrang, String tenNgNhan, String diaChi, String Sdt, String id) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "Update HoaDon  set ma=?,ngayTao=?,ngayThanhtoan=?,ngayShip=?,ngaynhan=?,tinhtrang=?,tennguoinhan=?,diachi=?,sdt=? where id=?";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);

            stm.setString(1, ma);
            stm.setDate(2, (Date) ngTao);
            stm.setDate(3, (Date) ngThanhToan);
            stm.setDate(4, (Date) ngShip);
            stm.setDate(5, (Date) ngNhan);
            stm.setInt(6, tinhTrang);
            stm.setString(7, tenNgNhan);
            stm.setString(8, diaChi);
            stm.setString(9, Sdt);
            stm.setString(10, id);
            stm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionSQL.closeJDBC(cone, stm, null);
        }
    }

}
