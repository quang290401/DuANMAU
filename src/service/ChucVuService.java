/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModels.ChucVu;
import java.util.ArrayList;
import repository.ChucVuRepository;
import viewModels.ChucVuViewModels;

/**
 *
 * @author forre
 */
public class ChucVuService implements IChucVu{
    ChucVuRepository chucVuRepository = new ChucVuRepository();
     @Override
    public ArrayList SelectCV() {
        ArrayList<ChucVuViewModels> ds = new ArrayList<>();
        ArrayList<ChucVu> chucVus = chucVuRepository.SelectChucVu();
        for (ChucVu cv : chucVus) {
            ChucVuViewModels CvW = new ChucVuViewModels(cv.getId(), cv.getMa(), cv.getHoTen());
            ds.add(CvW);
        }
        return ds;
    }

    @Override
    public void InsertCV(ChucVu chucVu) {
        chucVuRepository.InsertChucVu(chucVu);
    }

    @Override
    public void DeleteCV(String ma) {
        chucVuRepository.DeleteChucVu(ma);
    }

    @Override
    public void UpdateCV(String ma, String hoten, String id) {
        chucVuRepository.UpdateChucVu(ma, hoten, id);
    }

}
