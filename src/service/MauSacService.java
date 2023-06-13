/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModels.MauSac;
import java.util.ArrayList;
import repository.MauSacRepository;
import viewModels.MauSacViewModel;

/**
 *
 * @author forre
 */
public class MauSacService implements IMauSac{
    MauSacRepository  mauSacRepository = new MauSacRepository();
    @Override
    public ArrayList Select() {
       ArrayList<MauSac>mauSacs = mauSacRepository.SelectMauSac();
       ArrayList<MauSacViewModel> MS = new ArrayList<>();
       for(MauSac ds:mauSacs){
           MauSacViewModel msW = new MauSacViewModel(ds.getId(), ds.getMa(), ds.getTen());
           MS.add(msW);
       }
       return  MS;
    }

    @Override
    public void InsertMS(MauSac mauSac) {
       mauSacRepository.InsertMauSac(mauSac);
    }

    @Override
    public void DeleteMS(String id) {
        mauSacRepository.DeleteMauSac(id);
    }

    @Override
    public void UpdateMS(String ma, String ten, String id) {
    mauSacRepository.UpdateMauSac(ma, ten, id);
    }
    
}
