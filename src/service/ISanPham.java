/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import domainModels.NhaSanXuat;
import domainModels.SanPham;
import java.util.ArrayList;

/**
 *
 * @author forre
 */
public interface ISanPham {

    public ArrayList SelectSanPham();

    public void InsertSanPham(SanPham sanPham);

    public void DeleteSanPham(String id);

    public void UpdateSanPham(String ma, String hoten, String id);
}
