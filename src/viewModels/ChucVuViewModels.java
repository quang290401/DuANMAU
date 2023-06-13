/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewModels;

import domainModels.KhachHang;

/**
 *
 * @author forre
 */
public class ChucVuViewModels {
    private String id;
    private String ma;
    private String hoTen;
  

    public ChucVuViewModels() {
        
    }

    public ChucVuViewModels(String id, String ma, String hoTen) {
        this.id = id;
        this.ma = ma;
        this.hoTen = hoTen;
      
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

  @Override
    public String toString(){
        return ""+hoTen;
    }

   
    
}
