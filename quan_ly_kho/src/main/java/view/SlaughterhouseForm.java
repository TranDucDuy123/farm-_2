/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.BCrypt;
import controller.SearchAccount;
import controller.SearchFarm;
import controller.SearchFarmCertificate;
import controller.SearchLivestockHealth;
import controller.SearchOrganization;
import controller.SearchProductionFacility;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.Account;
import dao.AccountDAO;
import dao.CommuneDAO;
import dao.DistrictDAO;
import dao.FarmDAO;
import dao.ProductionFacilityDAO;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JFrame;
import model.Farm;
import model.NhaCungCap;
import model.ProductionFacility;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import controller.SearchProductionFacility;
import controller.SearchSlaughterhouse;
import dao.FarmCertificateDAO;
import dao.LivestockHealthDAO;
import dao.OrganizationDAO;
import dao.SlaughterhouseDAO;
import java.awt.event.KeyEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import model.Slaughterhouse;

/**
 *
 * @author Admin
 */
public class SlaughterhouseForm extends javax.swing.JInternalFrame {
   // Model table cho Slaughterhouse
    private DefaultTableModel tblModel;
    private ArrayList<Slaughterhouse> slaughterhouseList;

    public SlaughterhouseForm() {
        initComponents();
        UIManager.put("Table.showVerticalLines", true);
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);

        tblSlaughterhouse.setDefaultEditor(Object.class, null); // Không cho chỉnh sửa trực tiếp trong bảng
        initTable();

        // Thêm các tùy chọn tìm kiếm vào ComboBox
        searchSlaughterhouseComboBox.addItem("Tất cả");
        searchSlaughterhouseComboBox.addItem("Tên");
        searchSlaughterhouseComboBox.addItem("Loại");
        searchSlaughterhouseComboBox.addItem("Địa chỉ");
        searchSlaughterhouseComboBox.addItem("Trạng thái");

        // Tải dữ liệu từ DAO
        slaughterhouseList = (ArrayList<Slaughterhouse>) SlaughterhouseDAO.getInstance().selectAll();
        loadDataToTable(slaughterhouseList);
    }
     // Phương thức khởi tạo bảng
    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{
            "ID", "Tên lò mổ", "Địa chỉ", "Số điện thoại", "Loại", "Sức chứa", "Trạng thái"
        };
        tblModel.setColumnIdentifiers(headerTbl);
        tblSlaughterhouse.setModel(tblModel);
    }

     public void loadDataToTable(ArrayList<Slaughterhouse> slaughterhouseList) {
        try {
            tblModel.setRowCount(0); // Xóa các dòng cũ trong bảng
            for (Slaughterhouse slaughterhouse : slaughterhouseList) {
                tblModel.addRow(new Object[]{
                    slaughterhouse.getId(),
                    slaughterhouse.getName(),
                    slaughterhouse.getAddress(),
                    slaughterhouse.getPhone(),
                    slaughterhouse.getType(),
                    slaughterhouse.getCapacity(),
                    slaughterhouse.getStatus()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     // Phương thức lấy Slaughterhouse được chọn từ bảng
    public Slaughterhouse getSlaughterhouseSelected() {
        int i_row = tblSlaughterhouse.getSelectedRow();
        if (i_row >= 0) {
            int slaughterhouseId = (int) tblSlaughterhouse.getValueAt(i_row, 0); // Lấy `id` từ cột đầu tiên
            return SlaughterhouseDAO.getInstance().selectById(slaughterhouseId);
        }
        return null; // Nếu không chọn dòng nào
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnDeleteAccount = new javax.swing.JButton();
        btnEditAccount = new javax.swing.JButton();
        btnEditAccount1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        exportExcel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        searchSlaughterhouseComboBox = new javax.swing.JComboBox<>();
        searchSlaughterhouseTextField = new javax.swing.JTextField();
        btnreset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSlaughterhouse = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("THÊM TÀI KHOẢN");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Họ và tên");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên đăng nhập");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mật khẩu");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Vai trò");

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Thêm tài khoản");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jTextField1)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jComboBox1, 0, 269, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar1.setRollover(true);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_40px.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdd);

        btnDeleteAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_40px.png"))); // NOI18N
        btnDeleteAccount.setText("Xoá");
        btnDeleteAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteAccount.setFocusable(false);
        btnDeleteAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDeleteAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAccountActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDeleteAccount);

        btnEditAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_40px.png"))); // NOI18N
        btnEditAccount.setText("Sửa");
        btnEditAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditAccount.setFocusable(false);
        btnEditAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAccountActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEditAccount);

        btnEditAccount1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-update-left-rotation-40.png"))); // NOI18N
        btnEditAccount1.setText("Đặt lại");
        btnEditAccount1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditAccount1.setFocusable(false);
        btnEditAccount1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditAccount1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditAccount1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditAccount1ActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEditAccount1);
        jToolBar1.add(jSeparator1);

        exportExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_spreadsheet_file_40px.png"))); // NOI18N
        exportExcel.setText("Xuất Excel");
        exportExcel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exportExcel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exportExcel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportExcelActionPerformed(evt);
            }
        });
        jToolBar1.add(exportExcel);

        jPanel2.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 400, 90));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.add(searchSlaughterhouseComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 130, 40));
        jPanel3.add(searchSlaughterhouseTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 320, 40));

        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_reset_25px_1.png"))); // NOI18N
        btnreset.setText("Làm mới");
        btnreset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        jPanel3.add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 170, 40));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 720, 90));

        jScrollPane1.setBorder(null);

        tblSlaughterhouse.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên Cơ Sở", "Địa chỉ", "Huyện", "Xã", "Người liên hệ", "Số diện thoại"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblSlaughterhouse.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblSlaughterhouse.setGridColor(new java.awt.Color(204, 204, 204));
        tblSlaughterhouse.setShowGrid(true);
        jScrollPane1.setViewportView(tblSlaughterhouse);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1150, 620));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        AddSlaughterhouse a = new AddSlaughterhouse(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAccountActionPerformed
        if (tblSlaughterhouse.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn cơ sở cần chỉnh sửa!");
        } else {
            UpdateSlaughterhouse updateFacilityDialog = new UpdateSlaughterhouse(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
            updateFacilityDialog.setVisible(true);
        }
    }//GEN-LAST:event_btnEditAccountActionPerformed

    private void btnDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAccountActionPerformed
       if (tblSlaughterhouse.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn lò mổ cần xóa!");
        } else {
            int slaughterhouseId = (int) tblSlaughterhouse.getValueAt(tblSlaughterhouse.getSelectedRow(), 0); // Lấy `slaughterhouse_id` từ cột đầu tiên

            int confirm = JOptionPane.showConfirmDialog(this, 
                    "Bạn có chắc chắn muốn xóa lò mổ này?", 
                    "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                try {
                    int result = SlaughterhouseDAO.getInstance().delete(slaughterhouseId);
                    if (result > 0) {
                        JOptionPane.showMessageDialog(this, "Xóa lò mổ thành công!");
                        loadDataToTable((ArrayList<Slaughterhouse>) SlaughterhouseDAO.getInstance().selectAll());
                    } else {
                        JOptionPane.showMessageDialog(this, "Không thể xóa lò mổ này!");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lỗi khi xóa lò mổ: " + e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnDeleteAccountActionPerformed

    private void exportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportExcelActionPerformed
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setDialogTitle("Chọn nơi lưu file Excel");
            int userSelection = jFileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File saveFile = jFileChooser.getSelectedFile();

                // Đảm bảo file có đuôi .xlsx
                if (!saveFile.toString().toLowerCase().endsWith(".xlsx")) {
                    saveFile = new File(saveFile.toString() + ".xlsx");
                }

                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Slaughterhouse");

                // Tạo hàng tiêu đề
                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblSlaughterhouse.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblSlaughterhouse.getColumnName(i));
                }

                // Nạp dữ liệu từ bảng vào file Excel
                for (int j = 0; j < tblSlaughterhouse.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblSlaughterhouse.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (tblSlaughterhouse.getValueAt(j, k) != null) {
                            cell.setCellValue(tblSlaughterhouse.getValueAt(j, k).toString());
                        }
                    }
                }

                // Ghi dữ liệu ra file Excel
                try (FileOutputStream out = new FileOutputStream(saveFile)) {
                    wb.write(out);
                }

                JOptionPane.showMessageDialog(this, "Xuất file Excel thành công: " + saveFile.getAbsolutePath());
                openFile(saveFile.toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi khi xuất file Excel: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_exportExcelActionPerformed
        private void openFile(String filePath) {
            try {
                File file = new File(filePath);
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Không thể mở file: " + e.getMessage());
            }
        }
    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
         loadDataToTable((ArrayList<Slaughterhouse>) SlaughterhouseDAO.getInstance().selectAll());
    }//GEN-LAST:event_btnresetActionPerformed
    

    private void btnEditAccount1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAccount1ActionPerformed
       
    }//GEN-LAST:event_btnEditAccount1ActionPerformed

    private void triggerSearch() {
        String searchOption = searchSlaughterhouseComboBox.getSelectedItem().toString();
        String keyword = searchSlaughterhouseTextField.getText().trim();
        ArrayList<Slaughterhouse> result = new ArrayList<>();

        switch (searchOption) {
            case "Tất cả":
                result = (ArrayList<Slaughterhouse>) SlaughterhouseDAO.getInstance().selectAll();
                break;
            case "Tên":
                result = (ArrayList<Slaughterhouse>) SearchSlaughterhouse.getInstance().searchByName(keyword);
                break;
            case "Loại":
                result = (ArrayList<Slaughterhouse>) SearchSlaughterhouse.getInstance().searchByType(keyword);
                break;
            case "Trạng thái":
                result = (ArrayList<Slaughterhouse>) SearchSlaughterhouse.getInstance().searchByStatus(keyword);
                break;
            case "Địa chỉ":
                result = (ArrayList<Slaughterhouse>) SearchSlaughterhouse.getInstance().searchByAddress(keyword);
                break;
            case "Từ khóa":
                result = (ArrayList<Slaughterhouse>) SearchSlaughterhouse.getInstance().searchByKeyword(keyword);
                break;
        }

        loadDataToTable(result);
    }
    // Thêm lắng nghe thay đổi trong ô nhập tìm kiếm
    private void initSearchEvent() {
        searchSlaughterhouseTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                triggerSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (searchSlaughterhouseTextField.getText().trim().isEmpty()) {
                    loadDataToTable((ArrayList<Slaughterhouse>) SlaughterhouseDAO.getInstance().selectAll());
                } else {
                    triggerSearch();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                triggerSearch();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDeleteAccount;
    private javax.swing.JButton btnEditAccount;
    private javax.swing.JButton btnEditAccount1;
    private javax.swing.JButton btnreset;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton exportExcel;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JComboBox<String> searchSlaughterhouseComboBox;
    private javax.swing.JTextField searchSlaughterhouseTextField;
    public javax.swing.JTable tblSlaughterhouse;
    // End of variables declaration//GEN-END:variables

    void loadDataToTable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
