/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModels.ChiTietSP;
import java.math.BigDecimal;
import java.util.ArrayList;
import repository.ChiTietSPRepository;
import viewModels.ChitietSPViewModel;

/**
 *
 * @author forre
 */
public class ChiTietSpService implements IChiTietSP{
    ChiTietSPRepository chitiet = new ChiTietSPRepository();
    @Override
    public ArrayList Select() {
      ArrayList<ChiTietSP> chiTietSPs =  chitiet.SelectChiTietSP();
      ArrayList<ChitietSPViewModel> chitietSPViewModels = new ArrayList<>();
      for(ChiTietSP ds:chiTietSPs){
          ChitietSPViewModel chitietSPViewModel = new ChitietSPViewModel(ds.getId(),
                  ds.getIdSp()
                  , ds.getIdNsx()
                  , ds.getIdMS()
                  , ds.getIdDongSP(), ds.getNamBH()
                  , ds.getMoTa(), 
                  ds.getSoLgTon()
                  , ds.getGiaNhap(),
                  ds.getGiaBan());
          chitietSPViewModels.add(chitietSPViewModel);
      }
      return  chitietSPViewModels;
    }

    @Override
    public void Inser(ChiTietSP chiTietSP) {
       chitiet.InSertChitietSp(chiTietSP);
    }

    @Override
    public void Delete(String id) {
        chitiet.deleteChiTietSP(id);
    }

    @Override
    public void Update(int NamBH, String moTa, int soluong, BigDecimal gianhap, BigDecimal giaBan, String id) {
       chitiet.UpdateChiTietSP(NamBH, moTa, soluong, gianhap, giaBan, id);
    }
    
}
