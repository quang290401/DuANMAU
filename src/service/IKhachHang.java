/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModels.KhachHang;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author forre
 */
public interface IKhachHang {
    public ArrayList SelectKH();

    public void InsertKH(KhachHang khachHang);

    public void DeleteKH(String id);

    public void UpdateKH(String ma, String ten, String dem, String ho, Date ngSinh, String sdt, String diachi, String thanhpho, String quocGia, String mk, String id);
}
