/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModels.DongSP;
import java.util.ArrayList;

/**
 *
 * @author forre
 */
public interface IDongSP {

    public ArrayList SelectDongSP();

    public void InsertDongSP(DongSP dongSP);

    public void DeleteDongSP(String id);

    public void UpdateDongSP(String ma, String hoten, String id);
}
