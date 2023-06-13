/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModels.KhachHang;
import java.sql.Date;
import java.util.ArrayList;
import repository.KhachHangRepository;
import viewModels.KhachHangViewModels;

/**
 *
 * @author forre
 */
public class KhachHangService implements IKhachHang{
    
    KhachHangRepository khachHangripo = new KhachHangRepository();
     @Override
    public ArrayList SelectKH() {
        ArrayList<KhachHang> khachHangs = khachHangripo.SlectKhachHang();
        ArrayList<KhachHangViewModels> ds = new ArrayList<>();
        for (KhachHang kh : khachHangs) {
            KhachHangViewModels khW = new KhachHangViewModels(kh.getId(), kh.getMa(), kh.getTen(), kh.getTenDem(), kh.getHo(), kh.getNgaySinh(), kh.getsDT(), kh.getDiaChi(), kh.getThanhPho(), kh.getQuocGia(), kh.getMatKhau());
            ds.add(khW);
        }

        return ds;

    }

    @Override
    public void InsertKH(KhachHang khachHang) {
        khachHangripo.Inser(khachHang);
    }

    @Override
    public void DeleteKH(String id) {
        khachHangripo.Delete(id);
    }
     @Override
    public void UpdateKH(String ma, String ten, String dem, String ho, Date ngSinh, String sdt, String diachi, String thanhpho, String quocGia, String mk, String id) {
        khachHangripo.Update(ma, ten, dem, ho, ngSinh, sdt, diachi, thanhpho, quocGia, mk, id);
    }
}
