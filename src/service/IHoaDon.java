/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModels.HoaDon;
import java.util.ArrayList;

/**
 *
 * @author forre
 */
public interface IHoaDon {
    public void InsertHoaDon(HoaDon hoaDon);
    public ArrayList SelectHD();
}
