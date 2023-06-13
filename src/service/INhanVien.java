/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModels.NhanVien;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author forre
 */
public interface INhanVien {
     public void InsertNhanVien(NhanVien nhanVien);

    public ArrayList SelectNV();

    public void DeleteNV(String id);

    public void UpdateNV(String ma, String ten, String tenDem, String ho, String gioiTinh, Date ngaySinh, String diaChi,
            String sdt, String matKhau, String idCh, String idCV, String idbc,int trangThai,String id);
}
