/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import dao.AnimalQuarantineDAO;
import dao.CommuneDAO;
import dao.DistrictDAO;
import dao.FarmDAO;
import dao.ProductionFacilityDAO;
import dao.SanPhamDAO;
import dao.TestingFacilityDAO;
import dao.VeterinaryAgencyDAO;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.AnimalQuarantine;
import model.Commune;
import model.District;
import model.Farm;
import model.ProductionFacility;
import model.SanPham;
import model.TestingFacility;
import model.VeterinaryAgency;


/**
 *
 * @author Admin
 */
public class AddAnimalQuarantine extends javax.swing.JDialog {
    private AnimalQuarantineForm owner;  // Form cha để cập nhật lại dữ liệu sau khi thêm mới

    public AddAnimalQuarantine(javax.swing.JInternalFrame parent, javax.swing.JFrame owner, boolean modal) {
        super(owner, modal);
        this.owner = (AnimalQuarantineForm) parent;  // Thay đổi từ VeterinaryAgencyForm sang AnimalQuarantineForm
        initComponents();
        setLocationRelativeTo(null);
        cbxType.removeAllItems(); // Xóa tất cả các mục hiện tại (nếu có)
        cbxType.addItem("Chọn loại"); // Thêm mục mặc định
        cbxType.addItem("Gia súc");
        cbxType.addItem("Gia cầm");
        cbxType.addItem("Khác");
    }

    private AddAnimalQuarantine(JFrame jFrame, boolean b) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    // Phương thức lấy dữ liệu từ form nhập liệu
    private AnimalQuarantine getQuarantineFromInput() {
        String locationName = txtLocationName.getText().trim();
        String address = txtAddress.getText().trim();
        String type = cbxType.getSelectedItem().toString();
        String capacityStr = txtCapacity.getText().trim();
        String status = jRadioButton1.isSelected() ? "In Use" : "Available";

        // Kiểm tra dữ liệu nhập
        if (locationName.isEmpty() || address.isEmpty() || capacityStr.isEmpty() || type.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        int capacity;
        try {
            capacity = Integer.parseInt(capacityStr);
            if (capacity <= 0) {
                JOptionPane.showMessageDialog(this, "Sức chứa phải là số dương!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Sức chứa phải là số nguyên hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return new AnimalQuarantine(locationName, address, type, capacity, status);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAddProduct = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        txtLocationName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCapacity = new javax.swing.JTextField();
        cbxType = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thêm sản phẩm mới");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Địa Chỉ");

        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        jLabel4.setText("Loại");

        btnAddProduct.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        btnAddProduct.setForeground(new java.awt.Color(255, 255, 255));
        btnAddProduct.setText("Thêm sản phẩm");
        btnAddProduct.setBorder(null);
        btnAddProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProductActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(255, 0, 0));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Huỷ bỏ");
        btnCancel.setBorder(null);
        btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        jLabel5.setText("Name");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Hoạt động");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Dừng");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Trạng thái");

        jLabel17.setText("Sức chứa");

        txtCapacity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCapacityActionPerformed(evt);
            }
        });

        cbxType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCapacity, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocationName, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jRadioButton2))
                    .addComponent(cbxType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocationName, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(4, 4, 4)
                .addComponent(cbxType, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jRadioButton2))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 380, 410));

        jPanel2.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("THÊM KHU TẠM GIỮ  MỚI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProductActionPerformed
        AnimalQuarantine newQuarantine = getQuarantineFromInput();
        if (newQuarantine != null) {
            int result = AnimalQuarantineDAO.getInstance().insert(newQuarantine);
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Thêm khu tạm giữ mới thành công!");
                owner.loadDataToTable((ArrayList<AnimalQuarantine>) AnimalQuarantineDAO.getInstance().selectAll());
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Lỗi khi thêm khu tạm giữ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAddProductActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void txtCapacityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCapacityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCapacityActionPerformed

    /**
     * @param args the command line arguments
     */
//    public String createIdPC() {
//        ArrayList<SanPham> mtAll = SanPhamDAO.getInstance().selectAll();
//        ArrayList<SanPham> pcAll = new ArrayList<SanPham>();
//        for (SanPham sanPham : mtAll) {
//            if (sanPham.getMaSP().contains("PC")) {
//                pcAll.add(sanPham);
//            }
//        }
//        int i = pcAll.size();
//        String check ="check";
//        while(check.length()!=0){
//            i++;
//            for (SanPham sanPham : pcAll) {
//                if(sanPham.getMaSP().equals("PC"+i)){
//                    check="";
//                }
//            }
//            if(check.length()==0){
//                check ="check";
//            } else {
//                check = "";
//            }
//        }
//        return "PC" + i;
//    }

    public String createIdLT() {
        ArrayList<SanPham> spAll = SanPhamDAO.getInstance().selectAll();
        ArrayList<SanPham> sp = new ArrayList<SanPham>();
        for (SanPham sanPham : spAll) {
            if (sanPham.getMaSP().contains("SP")) {
               sp.add(sanPham);
            }
        }
        int i = sp.size();
        String check ="check";
        while(check.length()!=0){
            i++;
            for (SanPham sanPham : sp) {
                if(sanPham.getMaSP().equals("SP"+i)){
                    check="";
                }
            }
            if(check.length()==0){
                check ="check";
            } else {
                check = "";
            }
        }
        return "SP" + i;
    }

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
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddAnimalQuarantine dialog = new AddAnimalQuarantine(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduct;
    private javax.swing.JButton btnCancel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JTextField txtLocationName;
    // End of variables declaration//GEN-END:variables
}