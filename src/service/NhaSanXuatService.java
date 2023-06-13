/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModels.KhachHang;
import domainModels.NhaSanXuat;
import java.util.ArrayList;
import repository.NhaSanXuatrepository;
import viewModels.KhachHangViewModels;
import viewModels.NhaSanXuatViewModel;

/**
 *
 * @author forre
 */
public class NhaSanXuatService implements INhaSanXuat{
     NhaSanXuatrepository nhsx = new NhaSanXuatrepository();
    @Override
    public ArrayList SelectNhaSX() {
        ArrayList<NhaSanXuat> nhaSanXuats = nhsx.SelectNhaSanXuat();
        ArrayList<NhaSanXuatViewModel> ds = new ArrayList<>();
        for (NhaSanXuat kh : nhaSanXuats) {
            NhaSanXuatViewModel view = new NhaSanXuatViewModel(kh.getId(), kh.getMa(), kh.getTen());
            ds.add(view);
        }

        return ds;
    }

    @Override
    public void InsertNhaSX(NhaSanXuat nhaSanXuat) {
      nhsx.InsertNhaSanXuat(nhaSanXuat);
    }

    @Override
    public void DeleteNSX(String id) {
           nhsx.DeleteNhaSanXuat(id);
    }

    @Override
    public void UpdateNSX(String ma, String hoten, String id) {
        nhsx.UpdateNhaSanXuat(ma, hoten, id);
    }
    
}
