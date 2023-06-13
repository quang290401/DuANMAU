/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModels.HoaDon;
import java.util.ArrayList;
import repository.HoaDonRepository;
import viewModels.HoaDonViewModel;

/**
 *
 * @author forre
 */
public class HoaDonService implements IHoaDon{
    HoaDonRepository hoaDonRipository = new HoaDonRepository();
    @Override
    public void InsertHoaDon(HoaDon hoaDon) {
       hoaDonRipository.InsertHoaDon(hoaDon);
    }

    @Override
    public ArrayList SelectHD() {
      ArrayList<HoaDon> hoaDons = hoaDonRipository.SelectHoaDon();
      ArrayList<HoaDonViewModel> hoaDonViewModels = new ArrayList<>();
      for(HoaDon hd:hoaDons){
          HoaDonViewModel view = new HoaDonViewModel(hd.getId()
                  , hd.getIdKH()
                  , hd.getIdNV()
                  , hd.getMa()
                  , hd.getNgayTao()
                  , hd.getNgayThanhToan()
                  , hd.getNgayShip()
                  , hd.getNgayNhan()
                  , hd.getTinhTrang(),
                  hd.getTenNguoiNhan()
                  , hd.getDiaChi()
                  , hd.getSoDienThoai());
          hoaDonViewModels.add(view);
      }
      return hoaDonViewModels;
    }
    
}
