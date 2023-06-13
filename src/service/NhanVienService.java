/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModels.NhanVien;
import java.sql.Date;
import java.util.ArrayList;
import repository.NhanVienRepository;
import viewModels.NhanVienViewModels;

/**
 *
 * @author forre
 */
public class NhanVienService implements INhanVien{
    NhanVienRepository nhanVienRepository = new NhanVienRepository();

    @Override
    public void InsertNhanVien(NhanVien nhanVien) {
       nhanVienRepository.InsertNhanVien(nhanVien);
    }

    @Override
    public ArrayList SelectNV() {
        ArrayList<NhanVien>nhanViens = nhanVienRepository.SelectNhanVien();
        ArrayList<NhanVienViewModels>ds = new ArrayList<>();
        for(NhanVien nv:nhanViens){
            NhanVienViewModels nvw = new NhanVienViewModels(nv.getId(), nv.getMa(), nv.getTen()
                    , nv.getTenDem(), nv.getHo(), nv.getGioiTinh(), nv.getNgaySinh()
                    , nv.getDiaChi(), nv.getSoDienThoai(), nv.getMatKhau(), nv.getIdCuaHang(), nv.getIdChucVu(), nv.getIdGuiBaoCao(), nv.getTrangThai());
            ds.add(nvw);
        }
       return ds;
    }

    @Override
    public void DeleteNV(String id) {
        nhanVienRepository.DeleteNhanVien(id);    }

 

    @Override
    public void UpdateNV(String ma, String ten, String tenDem, String ho, String gioiTinh, java.util.Date ngaySinh, String diaChi, String sdt, String matKhau, String idCh, String idCV,String idbc, int trangThai, String id) {
        nhanVienRepository.UpdateNhanVien(ma, ten, tenDem, ho, gioiTinh, (Date) ngaySinh, diaChi, sdt, matKhau, idCh, idCV, idbc, trangThai, id);
    }
    
}
