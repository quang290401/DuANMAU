 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import domainModels.ChiTietSP;
import domainModels.DongSP;
import domainModels.MauSac;
import domainModels.NhaSanXuat;
import domainModels.SanPham;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import repository.DongSPRepository;
import repository.MauSacRepository;
import repository.NhaSanXuatrepository;
import repository.SanPhamRepository;
import service.ChiTietSpService;
import viewModels.ChitietSPViewModel;

/**
 *
 * @author forre
 */
public class ChiTietSPView extends javax.swing.JFrame {

    /**
     * Creates new form ChiTietSPView
     */
    SanPhamRepository sanPhamRepository = new SanPhamRepository();
    NhaSanXuatrepository nhaSanXuatrepository = new NhaSanXuatrepository();
    MauSacRepository mauSacRepository = new MauSacRepository();
    DongSPRepository dongSPRepository = new DongSPRepository();
    ChiTietSpService chiTietSpService = new ChiTietSpService();

    public ChiTietSPView() {
        initComponents();
        this.LoadTable();
        this.loadDanhMuc();
        this.loadDanhMuc2();
        this.loadDanhMuc3();
        this.loadDanhMuc4();
    }

    private void loadDanhMuc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) CbbIDSP.getModel();
        // xoa du lieu cu
        model.removeAllElements();
        model.addElement(null);
        // đỗ dưc liệu mới vào
        ArrayList<SanPham> sanPhams = sanPhamRepository.SelectSanPham();
        model.addAll(sanPhams);

        CbbIDSP.setModel(model);

        // cấu hình chuyên ngành mặc định
        CbbIDSP.setSelectedIndex(0);
    }

    private void loadDanhMuc2() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) CbbIDNSX.getModel();
        // xoa du lieu cu
        model.removeAllElements();
        model.addElement(null);
        // đỗ dưc liệu mới vào
        ArrayList<NhaSanXuat> nhaSanXuats = nhaSanXuatrepository.SelectNhaSanXuat();
        model.addAll(nhaSanXuats);

        CbbIDNSX.setModel(model);

        // cấu hình chuyên ngành mặc định
        CbbIDNSX.setSelectedIndex(0);
    }

    private void loadDanhMuc3() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbIdMS.getModel();
        // xoa du lieu cu
        model.removeAllElements();
        model.addElement(null);
        // đỗ dưc liệu mới vào
        ArrayList<MauSac> mauSacs = mauSacRepository.SelectMauSac();
        model.addAll(mauSacs);

        cbbIdMS.setModel(model);

        // cấu hình chuyên ngành mặc định
        cbbIdMS.setSelectedIndex(0);
    }

    private void loadDanhMuc4() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) CbbIDDongSP.getModel();
        // xoa du lieu cu
        model.removeAllElements();
        model.addElement(null);
        // đỗ dưc liệu mới vào
        ArrayList<DongSP> dongSPs = dongSPRepository.SelectDongSP();
        model.addAll(dongSPs);

        CbbIDDongSP.setModel(model);

        // cấu hình chuyên ngành mặc định
        CbbIDDongSP.setSelectedIndex(0);
    }

    public void LoadTable() {
        DefaultTableModel dtm = (DefaultTableModel) TblChiTietSP.getModel();
        ArrayList<ChitietSPViewModel> chitietSPViewModels = chiTietSpService.Select();
        dtm.setRowCount(0);
        for (ChitietSPViewModel ds : chitietSPViewModels) {
            Object row[] = {ds.getId(), ds.getIdSp(), ds.getIdNsx(), ds.getIdMS(), ds.getIdDongSP(),
                 ds.getNamBH(), ds.getMoTa(), ds.getSoLgTon(), ds.getGiaNhap(), ds.getGiaBan()};
            dtm.addRow(row);
        }
    }

    private ChiTietSP GetFrom() {
        SanPham idSP = (SanPham) CbbIDSP.getSelectedItem();
        String idSPham = null;
        if (idSP != null) {
            idSPham = idSP.getId();
        }
        NhaSanXuat idNSX = (NhaSanXuat) CbbIDNSX.getSelectedItem();
        String idNhaSX = null;
        if (idNSX != null) {
            idNhaSX = idNSX.getId();
        }
        MauSac idMS = (MauSac) cbbIdMS.getSelectedItem();
        String idMauSac = null;
        if (idMS != null) {
            idMauSac = idMS.getId();
        }
        DongSP idDSP = (DongSP) CbbIDDongSP.getSelectedItem();
        String idDongSP = null;
        if (idDSP != null) {
            idDongSP = idDSP.getId();
        }
        String NamBh = txtNamBH.getText();
        String MoTa = txtMoTa.getText();
        String soLuongton = TxtSoLuongTon.getText();
        String giaNhap = txtGiaNhap.getText();
        String giaBan = TxtGiaBan.getText();
        Integer NamBh2 = Integer.valueOf(NamBh);
        Integer soLuongton2 = Integer.valueOf(soLuongton);
        Double giaN = Double.valueOf(giaNhap);
        BigDecimal giaNhap2 = BigDecimal.valueOf(giaN);
        Double giaB = Double.valueOf(giaBan);
        BigDecimal giaBan2 = BigDecimal.valueOf(giaB);
        ChiTietSP chiTietSP = new ChiTietSP(idSPham, idNhaSX, idMauSac, idDongSP, NamBh2, MoTa, soLuongton2, giaNhap2, giaBan2);
        return chiTietSP;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        TxtId = new javax.swing.JTextField();
        txtNamBH = new javax.swing.JTextField();
        txtMoTa = new javax.swing.JTextField();
        TxtSoLuongTon = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        TxtGiaBan = new javax.swing.JTextField();
        CbbIDSP = new javax.swing.JComboBox<>();
        CbbIDNSX = new javax.swing.JComboBox<>();
        cbbIdMS = new javax.swing.JComboBox<>();
        CbbIDDongSP = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblChiTietSP = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id");

        jLabel2.setText("Id SP");

        jLabel3.setText("id NSX");

        jLabel4.setText("id MS");

        jLabel5.setText("id DongSP");

        jLabel6.setText("NamBH");

        jLabel7.setText("Mô tả");

        jLabel8.setText("Số Lượng tồn");

        jLabel9.setText("Giá Nhập");

        jLabel10.setText("Giá bán");

        CbbIDSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CbbIDNSX.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbIdMS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        CbbIDDongSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        TblChiTietSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "id SP", "id NhaSX", "id MauSac", "id DongSP", "NamBH", "MoTa", "Số Lượng tồn", "Giá Nhập", "Giá Bán"
            }
        ));
        TblChiTietSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TblChiTietSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TblChiTietSP);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TxtId)
                    .addComponent(CbbIDNSX, 0, 110, Short.MAX_VALUE)
                    .addComponent(CbbIDSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbIdMS, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CbbIDDongSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel8))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNamBH)
                    .addComponent(txtMoTa)
                    .addComponent(TxtSoLuongTon)
                    .addComponent(txtGiaNhap)
                    .addComponent(TxtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                .addGap(44, 44, 44))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6)
                    .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMoTa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbbIDSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8)
                    .addComponent(TxtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbbIDNSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbIdMS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(TxtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CbbIDDongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        ChiTietSP p = GetFrom();
        if (p == null) {
            return;
        }
        chiTietSpService.Inser(p);
        this.LoadTable();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        String id = TxtId.getText();
        chiTietSpService.Delete(id);
        this.LoadTable();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void TblChiTietSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TblChiTietSPMouseClicked
        int row = TblChiTietSP.getSelectedRow();
        String id = TblChiTietSP.getValueAt(row, 0).toString();
        this.TxtId.setText(id);
    }//GEN-LAST:event_TblChiTietSPMouseClicked

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        String NamBh = txtNamBH.getText();
        String moTa = txtMoTa.getText();
        String soluong = TxtSoLuongTon.getText();
        String giaNhap = txtGiaNhap.getText();
        String giaBan = TxtGiaBan.getText();
        Integer NamBh2 = Integer.valueOf(NamBh);
        Integer sL = Integer.valueOf(soluong);
        Double giaN = Double.valueOf(giaNhap);
        BigDecimal giaNhap2 = BigDecimal.valueOf(giaN);
        Double giaB = Double.valueOf(giaBan);
        BigDecimal giaBan2 = BigDecimal.valueOf(giaB);
        String id = TxtId.getText();
        chiTietSpService.Update(NamBh2, moTa, sL, giaNhap2, giaBan2, id);
        this.LoadTable();


    }//GEN-LAST:event_btnSuaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChiTietSPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietSPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietSPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietSPView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietSPView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbbIDDongSP;
    private javax.swing.JComboBox<String> CbbIDNSX;
    private javax.swing.JComboBox<String> CbbIDSP;
    private javax.swing.JTable TblChiTietSP;
    private javax.swing.JTextField TxtGiaBan;
    private javax.swing.JTextField TxtId;
    private javax.swing.JTextField TxtSoLuongTon;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbIdMS;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtMoTa;
    private javax.swing.JTextField txtNamBH;
    // End of variables declaration//GEN-END:variables
}
