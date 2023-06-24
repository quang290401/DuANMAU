/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModels.HoaDon;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author forre
 */
public interface IHoaDon {
    public void InsertHoaDon(HoaDon hoaDon);
    public ArrayList SelectHD();
    public void deleteHD(String id);
     public void UpdateHD(String ma,Date ngTao,Date ngThanhToan,Date ngShip,Date ngNhan,int tinhTrang,String tenNgNhan,String diaChi,String Sdt,String id);
}
