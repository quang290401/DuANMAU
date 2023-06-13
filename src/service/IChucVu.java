/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModels.ChucVu;
import java.util.ArrayList;

/**
 *
 * @author forre
 */
public interface IChucVu {
      public ArrayList SelectCV();

    public void InsertCV(ChucVu chucVu);

    public void DeleteCV(String id);

    public void UpdateCV(String ma, String hoten, String id);
}
