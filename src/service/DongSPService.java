/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModels.DongSP;
import java.util.ArrayList;
import repository.DongSPRepository;
import viewModels.DongSPViewModel;

/**
 *
 * @author forre
 */
public class DongSPService implements IDongSP{
    
    DongSPRepository dongSP = new DongSPRepository();
    @Override
    public ArrayList SelectDongSP() {
        ArrayList<DongSP> dongSPs = dongSP.SelectDongSP();
        ArrayList<DongSPViewModel> dongSPViewModels = new ArrayList<>();
        for(DongSP dSP :dongSPs){
            DongSPViewModel dongSPViewModel = new DongSPViewModel(dSP.getId(),dSP.getMa(),dSP.getTen());
            dongSPViewModels.add(dongSPViewModel);
        }
        return dongSPViewModels;
    }

    @Override
    public void InsertDongSP(DongSP dongSP) {    
     this.dongSP.InsertDongSP(dongSP);
    }

    @Override
    public void DeleteDongSP(String id) {
        dongSP.DeleteDongSP(id);
    }

    @Override
    public void UpdateDongSP(String ma, String hoten, String id) {
       dongSP.UpdateDongSP(ma, hoten, id);
    }

 
    
}
