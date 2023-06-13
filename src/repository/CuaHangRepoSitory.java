/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.ConnectionSQL;
import domainModels.CuaHang;
import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author forre
 */
public class CuaHangRepoSitory {

    public ArrayList SelectCuaHang() {

        Connection cone = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        ArrayList<CuaHang> cuaHangs = new ArrayList<>();
        String sql = "select id,ma,ten,diachi,thanhpho,quocgia from cuahang";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                CuaHang cuaHang = new CuaHang();
                cuaHang.setId(rs.getString("id"));
                cuaHang.setMa(rs.getString("ma"));
                cuaHang.setTen(rs.getString("ten"));
                cuaHang.setDiaChi(rs.getString("DiaChi"));
                cuaHang.setThanhPho(rs.getString("ThanhPho"));
                cuaHang.setQuocGia(rs.getString("QuocGia"));
                cuaHangs.add(cuaHang);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            ConnectionSQL.closeJDBC(cone, stm, rs);
        }
        return cuaHangs;
    }

    public void InsertCuaHang(CuaHang cuaHang) {
        Connection cone = null;
        PreparedStatement stm = null;

        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement("insert into CuaHang values (?,?,?,?,?,?)");
            UUID id = UUID.randomUUID();
            stm.setString(1, id.toString());
            stm.setString(2, cuaHang.getMa());
            stm.setString(3, cuaHang.getTen());
            stm.setString(4, cuaHang.getDiaChi());
            stm.setString(5, cuaHang.getDiaChi());
            stm.setString(6, cuaHang.getQuocGia());
            stm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            ConnectionSQL.closeJDBC(cone, stm, null);
        }
    }

    public void DeleteCuaHang(String id) {
        Connection cone = null;
        PreparedStatement stm = null;
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement("delete  CuaHang where id = ?");
            stm.setString(1, id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            ConnectionSQL.closeJDBC(cone, stm, null);
        }

    }

    public void UpdateCuaHang(String ma, String ten, String diaChi, String thanhpho, String quocGia, String id) {
        Connection cone = null;
        PreparedStatement stm = null;
        String sql = "update  CuaHang set ma=?,ten =?,diachi=?,thanhpho=?,quocGia=? where id =?";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql);
            stm.setString(1, ma);
            stm.setString(2, ten);
            stm.setString(3, diaChi);
            stm.setString(4, thanhpho);
            stm.setString(5, quocGia);
            stm.setString(6, id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionSQL.closeJDBC(cone, stm, null);

        }
    }

}
