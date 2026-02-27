/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import Connect.SQLServerProvider;
import DAO.DAO_HANGHOA;
import DAO.DAO_NHANVIEN;
import Entity.NHANVIEN;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Douers
 */
public class NHANVIEN_GUI extends javax.swing.JFrame {
ViewNhanVien viewSelectedRowNhanVien;
 String selectedImagePath=""; 
    /**
     * Creates new form NHANVIEN
     */
    public NHANVIEN_GUI() {
        initComponents();
        setDefaultCloseOperation(NHANVIEN_GUI.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        HienThi();
        txtMa.setEditable(false);
        dsNhanVien.getColumnModel().getColumn(6).setCellRenderer(new NHANVIEN_GUI.MyTableCellRenderer());
          //--------- xoa dong tren bang
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteMenuItem = new JMenuItem("Xóa");
        deleteMenuItem.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
              xoaNhanVien();
          }
      });
    popupMenu.add(deleteMenuItem);
    dsNhanVien.setComponentPopupMenu(popupMenu);

    }
     NHANVIEN_GUI(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     private void HienThi(){
        DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 6) { 
                    return ImageIcon.class;
                } else {
                    return Object.class;
                }
            }
        };
   String[] tieude = {"Mã Nhân Viên", "Tên Nhân Viên","Điện Thoại", "Địa Chỉ", "Ngày Sinh", "Giới Tính", "Ảnh Nhân viên"};
        dtm.setColumnIdentifiers(tieude);
        ArrayList<NHANVIEN> dsHH = DAO_NHANVIEN.getNHANVIEN();
        
        for(NHANVIEN hh:dsHH){
            Vector<Object> vec = new Vector<>();
                vec.add(hh.getMaNhanvien());
                vec.add(hh.getTenNhanVien());
                vec.add(hh.getDienThoai());
                vec.add(hh.getDiaChi());
                vec.add(hh.getNgaySinh());
                vec.add(hh.getGioiTinh());
                if (hh.getAnhNhanVien()!= null && !hh.getAnhNhanVien().isEmpty()) {
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(hh.getAnhNhanVien()).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                 imageIcon.setDescription(hh.getAnhNhanVien());
                vec.add(imageIcon);
            } else {
                vec.add(null);
            }
            dtm.addRow(vec);
        }
        dsNhanVien.setModel(dtm);
        TableColumn imageColumn = dsNhanVien.getColumnModel().getColumn(6);
        imageColumn.setPreferredWidth(60);
        dsNhanVien.setRowHeight(60);
     }
       class MyTableCellRenderer implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            if (value instanceof ImageIcon) {
                JLabel label = new JLabel((ImageIcon) value);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                return label;
            } else {
                return new JLabel(value != null ? value.toString() : "");
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        dsNhanVien = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnTim = new javax.swing.JButton();
        txtTimkiem = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtGioiTinh = new javax.swing.JTextField();
        txtDienThoai = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNgaySinh = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        BtnInNV = new javax.swing.JButton();
        jLabelImageNhanVien = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnBrowseNhanVien = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dsNhanVien.setBackground(new java.awt.Color(255, 204, 204));
        dsNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        dsNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dsNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dsNhanVien);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        btnTim.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTim.setForeground(new java.awt.Color(255, 153, 51));
        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        txtTimkiem.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimkiem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTim)
                .addGap(4, 4, 4))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTim))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin loại", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Mã Nhân Viên");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Tên Nhân Viên");

        txtMa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtTen.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 153, 51));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCapNhat.setForeground(new java.awt.Color(255, 153, 51));
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 153, 51));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Giới Tính");

        txtGioiTinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        txtDienThoai.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Điện Thoại");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Địa Chỉ");

        txtDiaChi.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Ngày Sinh");

        txtNgaySinh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 153, 51));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        BtnInNV.setFont(new java.awt.Font("Tahoma", 3, 15)); // NOI18N
        BtnInNV.setForeground(new java.awt.Color(255, 153, 102));
        BtnInNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/luu(1).png"))); // NOI18N
        BtnInNV.setText("In");
        BtnInNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnInNVActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 102, 0));
        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnBrowseNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBrowseNhanVien.setForeground(new java.awt.Color(255, 0, 102));
        btnBrowseNhanVien.setText("Browse");
        btnBrowseNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseNhanVienActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Ảnh");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(55, 55, 55)
                        .addComponent(txtNgaySinh))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtMa))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel4))
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtGioiTinh, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTen)
                            .addComponent(txtDienThoai))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBrowseNhanVien)
                            .addComponent(jButton1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelImageNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnInNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBrowseNhanVien)
                        .addGap(11, 11, 11)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabelImageNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(BtnInNV, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 153, 0));
        jLabel10.setText("Thông Tin Nhân Viên");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(233, 233, 233)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dsNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsNhanVienMouseClicked
       int row = dsNhanVien.getSelectedRow();
        txtMa.setText(dsNhanVien.getValueAt(row, 0) + "");
        txtTen.setText((String)dsNhanVien.getValueAt(row, 1));
        txtDienThoai.setText((String)dsNhanVien.getValueAt(row, 2));
        txtDiaChi.setText((String)dsNhanVien.getValueAt(row, 3));
        txtNgaySinh.setText((String)dsNhanVien.getValueAt(row, 4));
        txtGioiTinh.setText((String)dsNhanVien.getValueAt(row, 5));
         Object imageValue = dsNhanVien.getValueAt(row, 6);
        if (imageValue instanceof ImageIcon) {
            jLabelImageNhanVien.setIcon((ImageIcon) imageValue);
            selectedImagePath = ((ImageIcon) imageValue).getDescription();
        } else if (imageValue instanceof JLabel) {
            ImageIcon icon = (ImageIcon) ((JLabel) imageValue).getIcon();
            jLabelImageNhanVien.setIcon(icon);
            selectedImagePath = icon.getDescription();
        } else {
            jLabelImageNhanVien.setText((String) dsNhanVien.getValueAt(row, 6));
        }

    }//GEN-LAST:event_dsNhanVienMouseClicked

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
       DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public Class<?> getColumnClass(int column) {
            if (column == 6) { 
                return ImageIcon.class;
            } else {
                return Object.class;
            }
        }
    };
      String[] tieude = {"Mã Nhân Viên", "Tên Nhân Viên","Điện Thoại", "Địa Chỉ", "Ngày Sinh", "Giới Tính","Ảnh nhân viên"};
        dtm.setColumnIdentifiers(tieude);

        if(txtTimkiem.getText().isEmpty())
        HienThi();
        else{
            ArrayList<NHANVIEN> dsPB = DAO_NHANVIEN.timKiemNHANVIENTheoTen(txtTimkiem.getText());
            dtm.setRowCount(0);
            for(NHANVIEN hh:dsPB){
                Vector<Object> vec = new Vector<>();
                vec.add(hh.getMaNhanvien());
                vec.add(hh.getTenNhanVien());
                vec.add(hh.getDienThoai());
                vec.add(hh.getDiaChi());
                vec.add(hh.getNgaySinh());
                vec.add(hh.getGioiTinh());
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(hh.getAnhNhanVien()).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                vec.add(imageIcon);
                
                dtm.addRow(vec);
            }
            dsNhanVien.setModel(dtm); 
             TableColumn imageColumn = dsNhanVien.getColumnModel().getColumn(6);
            imageColumn.setCellRenderer(new NHANVIEN_GUI.MyTableCellRenderer());
            imageColumn.setPreferredWidth(60);
            dsNhanVien.setRowHeight(60);
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtTimkiem.setText("");
        txtMa.setText("");
        txtTen.setText("");
        txtDiaChi.setText("");
        txtDienThoai.setText("");
        txtGioiTinh.setText("");
        txtNgaySinh.setText("");
        jLabelImageNhanVien.setIcon(null); 
        selectedImagePath = ""; 
        
        if(txtTimkiem.getText().isEmpty())
        HienThi();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int mahh = Integer.parseInt(txtMa.getText());
        String tenhh = txtTen.getText();
        String dienthoaihh = txtDienThoai.getText();
        String gioitinhhh = txtGioiTinh.getText();
        String diachihh = txtDiaChi.getText();
        String ngaysinhhh = txtNgaySinh.getText();
         String anh;

        
        if (selectedImagePath.isEmpty()) {
            int row = dsNhanVien.getSelectedRow();
            ImageIcon currentIcon = (ImageIcon) dsNhanVien.getValueAt(row, 6);
            anh = currentIcon.getDescription();
        } else {
            anh = selectedImagePath;
        }

        NHANVIEN hh = new NHANVIEN();
        hh.setMaNhanvien(mahh);
        hh.setTenNhanVien(tenhh);
        hh.setDienThoai(dienthoaihh);
        hh.setDiaChi(diachihh);
        hh.setNgaySinh(ngaysinhhh);
        hh.setGioiTinh(gioitinhhh);
        hh.setAnhNhanVien(anh);

        try {
            DAO_NHANVIEN.capNhatNHANVIEN(hh);
        } catch (SQLException ex) {
            Logger.getLogger(NHANVIEN_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Cập nhật  thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        HienThi();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
       String tennv = txtTen.getText();
        String dienthoainv = txtDienThoai.getText();
        String diachinv = txtDiaChi.getText();
        String ngaysinhnv = txtNgaySinh.getText();
        String gioitinhnv = txtGioiTinh.getText();
        String anhnv = selectedImagePath;
        
        if (tennv.isEmpty() || dienthoainv.isEmpty()|| diachinv.isEmpty()|| ngaysinhnv.isEmpty()|| gioitinhnv.isEmpty()|| anhnv.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để thông tin trống!");
            return;
        }
        NHANVIEN hh = new NHANVIEN();
        //hh.setMaLoai(mahh);
        hh.setTenNhanVien(tennv);
        hh.setDiaChi(diachinv);
        hh.setDienThoai(dienthoainv);
        hh.setGioiTinh(gioitinhnv);
        hh.setNgaySinh(ngaysinhnv);
        hh.setAnhNhanVien(anhnv);
        
        try {
            DAO_NHANVIEN.themNHANVIEN(hh);
        } catch (SQLException ex) {
            Logger.getLogger(NHANVIEN_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultTableModel dtm = (DefaultTableModel) dsNhanVien.getModel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(anhnv).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        dtm.addRow(new Object[]{null,tennv ,diachinv,dienthoainv,gioitinhnv,ngaysinhnv, imageIcon});
        JOptionPane.showMessageDialog(this, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnThemActionPerformed
   private void xoaNhanVien() {
    int row = dsNhanVien.getSelectedRow();
    if (row >= 0) {
        String manv = dsNhanVien.getValueAt(row, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                boolean result = DAO_NHANVIEN.xoaNHANVIEN(manv);
                if (result) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể xóa nhân viên", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
                HienThi();
            } catch (SQLException ex) {
                Logger.getLogger(NHANVIEN_GUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Lỗi khi xóa nhân viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
    }
    }
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
         String manhanvien = txtMa.getText();

    // Hiển thị hộp thoại xác nhận
    int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa Nhân viên này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        try {
            boolean result = DAO_NHANVIEN.xoaNHANVIEN(manhanvien);
            if (result) {
                JOptionPane.showMessageDialog(this, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Không thể xóa Nhân viên", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
            HienThi();

         txtTimkiem.setText("");
        txtMa.setText("");
        txtTen.setText("");
        txtDiaChi.setText("");
        txtDienThoai.setText("");
        txtGioiTinh.setText("");
        txtNgaySinh.setText("");
        jLabelImageNhanVien.setText("");
        } catch (SQLException ex) {
            Logger.getLogger(NHANVIEN_GUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Lỗi khi xóa Nhân viên", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        // Người dùng nhấn No hoặc đóng hộp thoại
        JOptionPane.showMessageDialog(this, "Nhân viên không bị xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void BtnInNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnInNVActionPerformed
        // TODO add your handling code here:
        if(txtMa.getText().length()<=0)
            return;
        if(dsNhanVien.getRowCount()<=0)
            return;
        try{
           
            //D:\CN Java\DaAn_test\BT_End_Mon\src\Report\rpHoaDon.jrxml
            //JasperReport rpt= JasperCompileManager.compileReport("D:\\CN Java\\DoAn\\lan4\\BT_End_Mon\\src\\Report\\rpHoaDon.jrxml");
             JasperReport rpt= JasperCompileManager.compileReport("src/Report/rpNhanVien.jrxml");
           
            SQLServerProvider provider = new SQLServerProvider();
            java.sql.Connection conn = provider.open(); 
            Statement stat=conn.createStatement();
            String sql="select*from nhanvien";
            ResultSet rs=stat.executeQuery(sql);
            JRResultSetDataSource rsDatasource=new JRResultSetDataSource(rs);
            JasperPrint p = JasperFillManager.fillReport(rpt, new HashMap(), rsDatasource); 
            JasperViewer.viewReport(p,false);

            
        }catch(JRException | SQLException ex){
            Logger.getLogger(HOADON_GUI.class.getName()).log(Level.SEVERE,null, ex);
        }
    }//GEN-LAST:event_BtnInNVActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) dsNhanVien.getModel();

        if (viewSelectedRowNhanVien == null) {
            viewSelectedRowNhanVien = new ViewNhanVien();
        }

        viewSelectedRowNhanVien.setVisible(true);
        viewSelectedRowNhanVien.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        int selectedRowForNewJframe = dsNhanVien.getSelectedRow();
        if (selectedRowForNewJframe == -1) {
            viewSelectedRowNhanVien.jLabelNoSelectNV.setText("No Row Selected!!..");
        } else {
            viewSelectedRowNhanVien.jLabelNoSelectNV.setText(null);
            System.out.println("Selected row value: " + selectedRowForNewJframe);

            String newMa = model.getValueAt(selectedRowForNewJframe, 0).toString();
            String newTen = model.getValueAt(selectedRowForNewJframe, 1).toString();
            String newDT = model.getValueAt(selectedRowForNewJframe, 2).toString();
            String newDc = model.getValueAt(selectedRowForNewJframe, 3).toString();
            String newNgaySinh = model.getValueAt(selectedRowForNewJframe, 4).toString();
            String newGT = model.getValueAt(selectedRowForNewJframe, 5).toString();
            ImageIcon newImageIconNV = (ImageIcon) model.getValueAt(selectedRowForNewJframe, 6);

           
           

            // size ảnh
            Image newImageSize = newImageIconNV.getImage().getScaledInstance(
                viewSelectedRowNhanVien.jLabelImageNhanVienView.getWidth(), 
                viewSelectedRowNhanVien.jLabelImageNhanVienView.getHeight(), 
                Image.SCALE_SMOOTH
            );

            viewSelectedRowNhanVien.txtMaView.setText(newMa);
            viewSelectedRowNhanVien.txtTenView.setText(newTen);
            viewSelectedRowNhanVien.txtDTView.setText(newDT);
            viewSelectedRowNhanVien.txtDCView.setText(newDc);
            viewSelectedRowNhanVien.txtNgaySinhView.setText(newNgaySinh);
            viewSelectedRowNhanVien.txtGTView.setText(newGT);
            viewSelectedRowNhanVien.jLabelImageNhanVienView.setIcon(new ImageIcon(newImageSize));
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnBrowseNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseNhanVienActionPerformed
        // TODO add your handling code here:
        JFileChooser browseImageFile = new JFileChooser("D:\\CSDL\\BT_End_Mon\\src\\images");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGE", "png", "jpg", "jpeg");
        browseImageFile.addChoosableFileFilter(fnef);
        int showOpenDialogue = browseImageFile.showOpenDialog(null);
        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseImageFile.getSelectedFile();
            String selectedIangeFath = selectedImageFile.getAbsolutePath();
            JOptionPane.showMessageDialog(null, selectedIangeFath);
            ImageIcon ii = new ImageIcon(selectedIangeFath);
            Image image = ii.getImage().getScaledInstance(jLabelImageNhanVien.getWidth(), jLabelImageNhanVien.getHeight(), Image.SCALE_SMOOTH);
            jLabelImageNhanVien.setIcon(new ImageIcon(image));
            selectedImagePath = selectedIangeFath; 
        }
        
    }//GEN-LAST:event_btnBrowseNhanVienActionPerformed

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
            java.util.logging.Logger.getLogger(NHANVIEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NHANVIEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NHANVIEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NHANVIEN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new NHANVIEN_GUI().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnInNV;
    private javax.swing.JButton btnBrowseNhanVien;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JTable dsNhanVien;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelImageNhanVien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
}
