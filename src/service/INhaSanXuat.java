/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModels.ChucVu;
import domainModels.NhaSanXuat;
import java.util.ArrayList;

/**
 *
 * @author forre
 */
public interface INhaSanXuat {
         public ArrayList SelectNhaSX();

    public void InsertNhaSX(NhaSanXuat nhaSanXuat);

    public void DeleteNSX(String id);

    public void UpdateNSX(String ma, String hoten, String id);
}
