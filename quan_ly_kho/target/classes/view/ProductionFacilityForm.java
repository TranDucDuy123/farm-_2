/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.BCrypt;
import controller.SearchAccount;
import controller.SearchFarm;
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

/**
 *
 * @author Admin
 */
public class ProductionFacilityForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form AccountForm
     */
   // Model table cho farm
   private DefaultTableModel tblModel;
    private ArrayList<ProductionFacility> facilities = (ArrayList<ProductionFacility>) ProductionFacilityDAO.getInstance().selectAll();

    public ProductionFacilityForm() {
        initComponents();
        UIManager.put("Table.showVerticalLines", true);
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        tblFacility.setDefaultEditor(Object.class, null); // Không cho chỉnh sửa trực tiếp trong bảng
        initTable();
        loadDataToTable(facilities);
    }

    // Phương thức khởi tạo bảng
    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"ID", "Tên cơ sở", "Địa chỉ", "Huyện", "Xã", "Người liên hệ", "Số điện thoại"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblFacility.setModel(tblModel);
    }
    // Phương thức load dữ liệu `ProductionFacility` vào bảng
    public void loadDataToTable(ArrayList<ProductionFacility> facilities) {
        try {
            tblModel.setRowCount(0); // Xóa các dòng cũ trong bảng
            for (ProductionFacility facility : facilities) {
                tblModel.addRow(new Object[]{
                    facility.getFacilityId(),
                    facility.getFacilityName(),
                    facility.getAddress(),
                    getDistrictName(facility.getDistrictId()),  // Lấy tên huyện theo districtId
                    getCommuneName(facility.getCommuneId()),    // Lấy tên xã theo communeId
                    facility.getContactPerson(),
                    facility.getContactPhone()
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Phương thức lấy thông tin huyện từ districtId
    private String getDistrictName(int districtId) {
        // Gọi phương thức từ DistrictDAO để lấy tên huyện
        return DistrictDAO.getInstance().getDistrictNameById(districtId);
    }

    // Phương thức lấy thông tin xã từ communeId
    private String getCommuneName(int communeId) {
        // Gọi phương thức từ CommuneDAO để lấy tên xã
        return CommuneDAO.getInstance().getCommuneNameById(communeId);
    }

    // Phương thức lấy cơ sở sản xuất được chọn từ bảng
    public ProductionFacility getFacilitySelect() {
        int i_row = tblFacility.getSelectedRow();
        if (i_row >= 0) {
            int facilityId = (int) tblFacility.getValueAt(i_row, 0); // Lấy `facility_id` từ cột đầu tiên
            return ProductionFacilityDAO.getInstance().selectById(facilityId);
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
        cbxLuachon = new javax.swing.JComboBox<>();
        txtSearch = new javax.swing.JTextField();
        btnreset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFacility = new javax.swing.JTable();

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

        cbxLuachon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Tên Farm", "Huyện", "Xã" }));
        cbxLuachon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxLuachonActionPerformed(evt);
            }
        });
        jPanel3.add(cbxLuachon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 130, 40));

        txtSearch.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtSearchInputMethodTextChanged(evt);
            }
        });
        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtSearchPropertyChange(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        jPanel3.add(txtSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 320, 40));

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

        tblFacility.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFacility.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tblFacility.setGridColor(new java.awt.Color(204, 204, 204));
        tblFacility.setShowGrid(true);
        jScrollPane1.setViewportView(tblFacility);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 1150, 620));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        AddProductionFacility form;
        form = new AddProductionFacility(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
        form.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAccountActionPerformed
         if (tblFacility.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn cơ sở cần chỉnh sửa!");
        } else {
            UpdateProductionFacility updateFacilityDialog = new UpdateProductionFacility(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
            updateFacilityDialog.setVisible(true);
        }
    }//GEN-LAST:event_btnEditAccountActionPerformed

    private void btnDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAccountActionPerformed
        if (tblFacility.getSelectedRow() == -1) {
             JOptionPane.showMessageDialog(this, "Vui lòng chọn cơ sở cần xóa!");
         } else {
             int facilityId = (int) tblFacility.getValueAt(tblFacility.getSelectedRow(), 0); // Cột `facility_id` là cột đầu tiên

             int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa cơ sở này?", "Xác nhận xóa cơ sở", JOptionPane.YES_NO_OPTION);
             if (confirm == JOptionPane.YES_OPTION) {
                 try {
                     int result = ProductionFacilityDAO.getInstance().delete(facilityId);
                     if (result > 0) {
                         JOptionPane.showMessageDialog(this, "Xóa cơ sở thành công!");
                         loadDataToTable((ArrayList<ProductionFacility>) ProductionFacilityDAO.getInstance().selectAll());
                     } else {
                         JOptionPane.showMessageDialog(this, "Không thể xóa cơ sở này!");
                     }
                 } catch (Exception e) {
                     JOptionPane.showMessageDialog(this, "Lỗi khi xóa cơ sở: " + e.getMessage());
                 }
             }
         }
    }//GEN-LAST:event_btnDeleteAccountActionPerformed

    private void exportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportExcelActionPerformed
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("ProductionFacility");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblFacility.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblFacility.getColumnName(i));
                }
                for (int j = 0; j < tblFacility.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblFacility.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (tblFacility.getValueAt(j, k) != null) {
                            cell.setCellValue(tblFacility.getValueAt(j, k).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_exportExcelActionPerformed

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtSearchPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSearchPropertyChange

    private void txtSearchInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSearchInputMethodTextChanged
        // TODO add your handling code here: 
    }//GEN-LAST:event_txtSearchInputMethodTextChanged

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        loadDataToTable((ArrayList<ProductionFacility>) ProductionFacilityDAO.getInstance().selectAll());
    }//GEN-LAST:event_btnresetActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
         // Lấy lựa chọn tìm kiếm từ combobox
        String searchOption = (String) cbxLuachon.getSelectedItem();
        String searchContent = txtSearch.getText();
        ArrayList<ProductionFacility> result = new ArrayList<>();

        // Thực hiện tìm kiếm dựa trên lựa chọn
        switch (searchOption) {
            case "Tất cả":
                // Tìm kiếm theo từ khóa chung
                result = (ArrayList<ProductionFacility>) SearchProductionFacility.getInstance().searchByKeyword(searchContent);
                break;
            case "Tên cơ sở":
                // Tìm kiếm theo tên cơ sở
                result = (ArrayList<ProductionFacility>) SearchProductionFacility.getInstance().searchByName(searchContent);
                break;
            case "Huyện":
                try {
                    // Tìm kiếm theo ID huyện
                    int districtId = Integer.parseInt(searchContent);
                    result = (ArrayList<ProductionFacility>) SearchProductionFacility.getInstance().searchByDistrictId(districtId);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "ID huyện phải là số!");
                }
                break;
            case "Xã":
                try {
                    // Tìm kiếm theo ID xã
                    int communeId = Integer.parseInt(searchContent);
                    result = (ArrayList<ProductionFacility>) SearchProductionFacility.getInstance().searchByCommuneId(communeId);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "ID xã phải là số!");
                }
                break;
            default:
                JOptionPane.showMessageDialog(this, "Vui lòng chọn một tùy chọn tìm kiếm hợp lệ!");
        }

        // Load kết quả tìm kiếm vào bảng nếu không bị null
        if (result != null && !result.isEmpty()) {
            loadDataToTable(result);
        } else {
            tblModel.setRowCount(0); // Xóa dữ liệu bảng nếu không có kết quả
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnEditAccount1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditAccount1ActionPerformed
        if (tblFacility.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn cơ sở cần chỉnh sửa!");
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, "Bạn có muốn chỉnh sửa cơ sở này?", "Chỉnh sửa", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                int row = tblFacility.getSelectedRow();
                int facilityId = (int) tblFacility.getValueAt(row, 0); // `facilityId` là cột đầu tiên
                ProductionFacility facilityToEdit = ProductionFacilityDAO.getInstance().selectById(facilityId);

                String newFacilityName = JOptionPane.showInputDialog(this, "Nhập tên cơ sở mới:", facilityToEdit.getFacilityName());
                if (newFacilityName == null || newFacilityName.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Tên cơ sở không được để trống!");
                    return;
                }

                String newAddress = JOptionPane.showInputDialog(this, "Nhập địa chỉ cơ sở mới:", facilityToEdit.getAddress());
                if (newAddress == null || newAddress.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Địa chỉ không được để trống!");
                    return;
                }

                String newContactPerson = JOptionPane.showInputDialog(this, "Nhập tên người liên hệ mới:", facilityToEdit.getContactPerson());
                String newContactPhone = JOptionPane.showInputDialog(this, "Nhập số điện thoại mới:", facilityToEdit.getContactPhone());

                facilityToEdit.setFacilityName(newFacilityName);
                facilityToEdit.setAddress(newAddress);
                facilityToEdit.setContactPerson(newContactPerson);
                facilityToEdit.setContactPhone(newContactPhone);

                try {
                    ProductionFacilityDAO.getInstance().update(facilityToEdit);
                    JOptionPane.showMessageDialog(this, "Cập nhật cơ sở thành công!");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Cập nhật cơ sở không thành công!");
                }

                loadDataToTable((ArrayList<ProductionFacility>) ProductionFacilityDAO.getInstance().selectAll());
            }
        }
    }//GEN-LAST:event_btnEditAccount1ActionPerformed

    private void cbxLuachonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxLuachonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxLuachonActionPerformed

    public void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDeleteAccount;
    private javax.swing.JButton btnEditAccount;
    private javax.swing.JButton btnEditAccount1;
    private javax.swing.JButton btnreset;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxLuachon;
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
    public javax.swing.JTable tblFacility;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    void loadDataToTable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
