/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import domainModels.CuaHang;
import java.util.ArrayList;
import repository.CuaHangRepoSitory;
import viewModels.CuaHangViewModel;

/**
 *
 * @author forre
 */
public class CuaHangService implements ICuaHang{
    CuaHangRepoSitory cuaHangripo = new CuaHangRepoSitory();
     @Override
    public ArrayList SelectCH() {
        ArrayList<CuaHang> cuaHangs = cuaHangripo.SelectCuaHang();
        ArrayList<CuaHangViewModel> ds = new ArrayList<>();
        for (CuaHang cH : cuaHangs) {
            CuaHangViewModel cHW = new CuaHangViewModel(cH.getId(), cH.getMa(), cH.getTen(), cH.getDiaChi(), cH.getThanhPho(), cH.getQuocGia());
            ds.add(cHW);
        }

        return ds;
    }

    @Override
    public void InsertCH(CuaHang cuaHang) {
        cuaHangripo.InsertCuaHang(cuaHang);
    }

    @Override
    public void DeleteCH(String id) {
        cuaHangripo.DeleteCuaHang(id);
    }

    @Override
    public void UpdateCH(String ma, String ten, String diaChi, String thanhPho, String quocGia, String id) {
        cuaHangripo.UpdateCuaHang(ma, ten, diaChi, thanhPho, quocGia, id);
    }
}
