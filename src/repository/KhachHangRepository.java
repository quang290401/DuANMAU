/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.ConnectionSQL;
import domainModels.KhachHang;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author forre
 */
public class KhachHangRepository {

    public ArrayList<KhachHang> SlectKhachHang() {
        ArrayList<KhachHang> khachHangs = new ArrayList<>();
        Connection cone = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String sql = "select *from khachhang";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setId(rs.getString("id"));
                khachHang.setMa(rs.getString("ma"));
                khachHang.setTen(rs.getString("ten"));
                khachHang.setTenDem(rs.getString("tendem"));
                khachHang.setHo(rs.getString("ho"));
                khachHang.setNgaySinh(rs.getDate("NgaySinh"));
                khachHang.setsDT(rs.getString("sdt"));
                khachHang.setDiaChi(rs.getString("DiaChi"));
                khachHang.setThanhPho(rs.getString("thanhPho"));
                khachHang.setQuocGia(rs.getString("QuocGia"));
                khachHang.setMatKhau(rs.getString("matKhau"));

                khachHangs.add(khachHang);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            ConnectionSQL.closeJDBC(cone, stm, rs);

        }
        return khachHangs;
    }

    public void Inser(KhachHang khachHang) {
        Connection cone = null;
        PreparedStatement stm = null;
        StringBuilder sql = new StringBuilder();
        sql.append("insert into  khachhang values")
                .append("(?,?,?,?,?,?,?,?,?,?,?)");

        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql.toString());
            UUID id = UUID.randomUUID();
            stm.setString(1, id.toString());
            stm.setString(2, khachHang.getMa());
            stm.setString(3, khachHang.getTen());
            stm.setString(4, khachHang.getTenDem());
            stm.setString(5, khachHang.getHo());
            stm.setDate(6, (Date) khachHang.getNgaySinh());
            stm.setString(7, khachHang.getsDT());
            stm.setString(8, khachHang.getDiaChi());
            stm.setString(9, khachHang.getThanhPho());
            stm.setString(10, khachHang.getQuocGia());
            stm.setString(11, khachHang.getMatKhau());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            ConnectionSQL.closeJDBC(cone, stm, null);
        }

    }

    public void Delete(String id) {
        Connection cone = null;
        PreparedStatement stm = null;
        StringBuilder sql = new StringBuilder();
        sql.append("Delete from khachhang where id=")
                .append("(?)");
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql.toString());
            stm.setString(1, id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            ConnectionSQL.closeJDBC(cone, stm, null);
        }

    }

    public void Update(String ma, String ten, String dem, String ho, Date ngSinh, String sdt, String diachi, String thanhpho, String quocGia, String mk, String id) {
        Connection cone = null;
        PreparedStatement stm = null;
        StringBuilder sql = new StringBuilder();
        sql.append("update  khachhang set ")
                .append("ma=?,ten=?,tendem=?,ho=?,ngaysinh=?,Sdt=?,diachi=?,thanhpho=?,quocgia=?,matkhau=? ").append("where id=?");

        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql.toString());
            stm.setString(1, ma);
            stm.setString(2, ten);
            stm.setString(3, dem);
            stm.setString(4, ho);
            stm.setDate(5, ngSinh);
            stm.setString(6, sdt);
            stm.setString(7, diachi);
            stm.setString(8, thanhpho);
            stm.setString(9, quocGia);
            stm.setString(10, mk);
            stm.setString(11, id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            ConnectionSQL.closeJDBC(cone, stm, null);
        }

    }

}
