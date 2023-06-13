/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModels.MauSac;
import java.util.ArrayList;

/**
 *
 * @author forre
 */
public interface IMauSac {
    public ArrayList Select();
    public void InsertMS(MauSac mauSac);
    public void DeleteMS(String id);
    public void UpdateMS(String ma,String ten,String id);
    
}
