/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import common.ConnectionSQL;
import domainModels.NhanVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author forre
 */
public class NhanVienRepository {

    public void InsertNhanVien(NhanVien nhanVien) {
        Connection cone = null;
        PreparedStatement stm = null;
        StringBuilder sql = new StringBuilder();
        sql.append("insert into  NhanVien values")
                .append("(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql.toString());
            UUID id = UUID.randomUUID();

            stm.setString(1, id.toString());
            stm.setString(2, nhanVien.getMa());
            stm.setString(3, nhanVien.getTen());
            stm.setString(4, nhanVien.getTenDem());
            stm.setString(5, nhanVien.getHo());
            stm.setString(6, nhanVien.getGioiTinh());
            stm.setDate(7, (Date) nhanVien.getNgaySinh());
            stm.setString(8, nhanVien.getDiaChi());
            stm.setString(9, nhanVien.getSoDienThoai());
            stm.setString(10, nhanVien.getMatKhau());
            stm.setString(11, nhanVien.getIdCuaHang());
            stm.setString(12, nhanVien.getIdChucVu());
            stm.setString(13, nhanVien.getIdGuiBaoCao());
            stm.setInt(14, nhanVien.getTrangThai());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            ConnectionSQL.closeJDBC(cone, stm, null);
        }
    }

    public ArrayList<NhanVien> SelectNhanVien() {
        ArrayList<NhanVien> nhanViens = new ArrayList<>();
        Connection cone = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        String Sql = "select *from NhanVien";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(Sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getString("id"));
                nhanVien.setMa(rs.getString("ma"));
                nhanVien.setTen(rs.getString("Ten"));
                nhanVien.setTenDem(rs.getString("tenDem"));
                nhanVien.setHo(rs.getString("Ho"));
                nhanVien.setGioiTinh(rs.getString("GioiTinh"));
                nhanVien.setNgaySinh(rs.getDate("NgaySinh"));
                nhanVien.setDiaChi(rs.getString("DiaChi"));
                nhanVien.setSoDienThoai(rs.getString("SDT"));
                nhanVien.setMatKhau(rs.getString("MatKhau"));
                nhanVien.setIdCuaHang(rs.getString("idCH"));
                nhanVien.setIdChucVu(rs.getString("idCV"));
                nhanVien.setIdGuiBaoCao(rs.getString("idGuiBC"));
                nhanVien.setTrangThai(rs.getInt("TrangThai"));
                nhanViens.add(nhanVien);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            ConnectionSQL.closeJDBC(cone, stm, rs);
        }
        return nhanViens;
    }

    public void DeleteNhanVien(String id) {

        Connection cone = null;
        PreparedStatement stm = null;

        String Sql = "Delete nhanvien where id=?";
        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(Sql);
            stm.setString(1, id);
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            ConnectionSQL.closeJDBC(cone, stm, null);
        }

    }

    public void UpdateNhanVien(String ma, String ten, String tenDem, String ho, String gioiTinh, Date ngaySinh, String diaChi,
            String sdt, String matKhau, String idCh, String idCV, String idBc, int trangThai, String id) {
        Connection cone = null;
        PreparedStatement stm = null;
        StringBuilder sql = new StringBuilder();
        sql.append("update  NhanVien set ma=?,ten=?,tenDem=?,ho=?,gioitinh=?,ngaySinh=?,diaChi=?,sdt=?,matkhau=?,idCh=?,idCV=?,idGuiBc =?,trangthai=? where id=? ");

        try {
            cone = ConnectionSQL.GetConnetion();
            stm = cone.prepareStatement(sql.toString());
                    
            stm.setString(1, ma);
            stm.setString(2, ten);
            stm.setString(3, tenDem);
            stm.setString(4, ho);
            stm.setString(5, gioiTinh);
            stm.setDate(6, (Date) ngaySinh);
            stm.setString(7, diaChi);
            stm.setString(8, sdt);
            stm.setString(9, matKhau);
            stm.setObject(10,idCh==null||idCh.trim().isEmpty()?null: UUID.fromString(idCh));
            stm.setObject(11,idCV==null||idCV.trim().isEmpty()?null: UUID.fromString(idCV));
            stm.setObject(12, idBc == null || idBc.trim().isEmpty() ? null : UUID.fromString(idBc));

            stm.setInt(13, trangThai);
            stm.setString(14, id);
            stm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            ConnectionSQL.closeJDBC(cone, stm, null);
        }
    }
}
// private void loadDanhMuc() {
//        DefaultComboBoxModel model = (DefaultComboBoxModel) CbbIdCh.getModel();
//        // xoa du lieu cu
//        model.removeAllElements();
//        model.addElement(null);
//        // đỗ dưc liệu mới vào
//        ArrayList<CuaHangViewModel> cuaHangs = ch.SelectCH();
//        model.addAll(cuaHangs);
//
//        CbbIdCh.setModel(model);
//
//        // cấu hình chuyên ngành mặc định
//        CbbIdCh.setSelectedIndex(0);
//    }