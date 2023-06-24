/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModels.ChiTietSP;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *
 * @author forre
 */
public interface IChiTietSP {
    public ArrayList Select();
    public void Inser(ChiTietSP chiTietSP);
    public void Delete(String id);
    public void Update( int NamBH,String moTa,int soluong,BigDecimal gianhap,BigDecimal giaBan,String id  );
        
    
}
