/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModels.NhaSanXuat;
import domainModels.SanPham;
import java.util.ArrayList;
import repository.SanPhamRepository;
import viewModels.NhaSanXuatViewModel;
import viewModels.SanPhamViewModels;

/**
 *
 * @author forre
 */
public class SanPhamservice implements ISanPham{
    SanPhamRepository sp =new SanPhamRepository();

    @Override
    public ArrayList SelectSanPham() {
            ArrayList<SanPham> sanPhams = sp.SelectSanPham();
        ArrayList<SanPhamViewModels> ds = new ArrayList<>();
        for (SanPham kh : sanPhams) {
            SanPhamViewModels view = new SanPhamViewModels(kh.getId(), kh.getMa(), kh.getTen());
            ds.add(view);
        }

        return ds;
        
    }

    @Override
    public void InsertSanPham(SanPham sanPham) {
       sp.InsertSanPham(sanPham);
    }

    @Override
    public void DeleteSanPham(String id) {
      sp.DeleteSanPham(id);
    }

    @Override
    public void UpdateSanPham(String ma, String hoten, String id) {
      sp.UpdateSanPham(ma, hoten, id);
    }
    
}
