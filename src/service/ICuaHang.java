/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModels.CuaHang;
import java.util.ArrayList;

/**
 *
 * @author forre
 */
public interface ICuaHang {
     public ArrayList SelectCH();

    public void InsertCH(CuaHang cuaHang);

    public void DeleteCH(String id);

    public void UpdateCH(String ma, String ten, String diaChi, String thanhPho, String quocGia, String id);

}
