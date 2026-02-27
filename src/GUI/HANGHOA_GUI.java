/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.DAO_HANGHOA;
import static DAO.DAO_HANGHOA.layMaLoai;
import static DAO.DAO_HANGHOA.layMaNCC;
import DAO.DAO_KHACHHANG;
import DAO.DAO_LOAI;
import DAO.DAO_NHACC;
import DAO.DAO_NHACC;
import Entity.NHACC;
import Entity.HANGHOA;
import Entity.LOAI;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author Douers
 */
public class HANGHOA_GUI extends javax.swing.JFrame {
    /**
     * Creates new form HANGHOA
     */
    ViewSelectedRow viewSelectedRow;
     String selectedImagePath=""; 
    
    public HANGHOA_GUI() {
        initComponents();
        setDefaultCloseOperation(HANGHOA_GUI.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        HienThi();
        txtMa.setEditable(false);
        load_cbb_loai();
        load_cbb_nhacc();
        
        dsHangHoa.getColumnModel().getColumn(5).setCellRenderer(new MyTableCellRenderer());
         //--------- xoa dong tren bang
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteMenuItem = new JMenuItem("Xóa");
        deleteMenuItem.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
              xoaHangHoa();
          }
      });
    popupMenu.add(deleteMenuItem);
    dsHangHoa.setComponentPopupMenu(popupMenu);
    }
     
    
    public void load_cbb_loai(){
         ArrayList<LOAI> dsL = DAO_LOAI.getLOAI();
        for(LOAI l:dsL){
            cbbLoai.addItem(l.getTenLoai());
            
        }
    }
   
    public void load_cbb_nhacc() {
    // Khởi tạo jcboTenHang nếu chưa được khởi tạo
    if (jcboTenHang == null) {
        jcboTenHang = new JComboBox<>();
    }
    ArrayList<NHACC> dsNhaccs = DAO_NHACC.getNHACC();
    for (NHACC l : dsNhaccs) {
        jcboTenHang.addItem(l.getTenNhacc());
    }
}

    
    public void HienThi() {
       DefaultTableModel dtm = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int column) {
                if (column == 5) { 
                    return ImageIcon.class;
                } else {
                    return Object.class;
                }
            }
        };

        String[] tieude = {"Mã Hàng", "Tên Hàng", "Số Lượng", "Giá Nhập", "Giá Xuất", "Ảnh", "Ghi Chú", "Loại", "Nhà cung cấp"};
        dtm.setColumnIdentifiers(tieude);

        ArrayList<HANGHOA> dsHH = DAO_HANGHOA.getHANGHOA();
        for (HANGHOA hh : dsHH) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(hh.getMAHANG());
            vec.add(hh.getTENHANG());
            vec.add(hh.getSOLUONG());
            vec.add(hh.getDONGIANHAP());
            vec.add(hh.getDONGIAXUAT());

            if (hh.getANH() != null && !hh.getANH().isEmpty()) {
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(hh.getANH()).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
                 imageIcon.setDescription(hh.getANH());
                vec.add(imageIcon);
            } else {
                vec.add(null);
            }
            vec.add(hh.getGHICHU());
            vec.add(hh.getLOAI());
            vec.add(hh.getNHACC());
            dtm.addRow(vec);
        }

        dsHangHoa.setModel(dtm);
        TableColumn imageColumn = dsHangHoa.getColumnModel().getColumn(5);
        imageColumn.setPreferredWidth(60);
        dsHangHoa.setRowHeight(60);
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

        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dsHangHoa = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtGiaNhap = new javax.swing.JTextField();
        txtGiaXuat = new javax.swing.JTextField();
        txtGhichu = new javax.swing.JTextField();
        btnClear = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        cbbLoai = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jcboTenHang = new javax.swing.JComboBox<>();
        jLabelImage = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnBrowserImage = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnTim = new javax.swing.JButton();
        txtTimkiem = new javax.swing.JTextField();

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        dsHangHoa.setBackground(new java.awt.Color(204, 255, 204));
        dsHangHoa.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        dsHangHoa.setModel(new javax.swing.table.DefaultTableModel(
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
        dsHangHoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dsHangHoaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dsHangHoa);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Hàng Hóa", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Tên Loại");

        txtMa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Mã Hàng");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Số Lượng");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Tên Hàng");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Giá Nhập");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Giá Xuất");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Ghi Chú");

        txtTen.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtSoLuong.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtGiaNhap.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtGiaXuat.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtGhichu.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnClear.setForeground(new java.awt.Color(0, 153, 0));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/clear.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCapNhat.setForeground(new java.awt.Color(0, 153, 0));
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(0, 153, 0));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem.setForeground(new java.awt.Color(0, 153, 0));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        cbbLoai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cbbLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Tên nhà cc:");

        jcboTenHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcboTenHangActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Ảnh");

        btnBrowserImage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnBrowserImage.setForeground(new java.awt.Color(0, 204, 0));
        btnBrowserImage.setText("Browser Image");
        btnBrowserImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowserImageActionPerformed(evt);
            }
        });

        btnView.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnView.setForeground(new java.awt.Color(102, 102, 255));
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtGhichu, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtGiaXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jcboTenHang, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnBrowserImage)
                                    .addComponent(btnClear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(19, 19, 19)))))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtGiaXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtGhichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcboTenHang, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBrowserImage)
                        .addGap(18, 18, 18)
                        .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelImage, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnCapNhat))
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 153, 0));
        jLabel10.setText("Thông Tin Hàng Hóa");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm Kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 0, 18))); // NOI18N

        btnTim.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnTim.setForeground(new java.awt.Color(0, 204, 0));
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
                .addGap(96, 96, 96))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap(250, Short.MAX_VALUE)
                    .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(btnTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1065, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
            .addGroup(layout.createSequentialGroup()
                .addGap(341, 341, 341)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel10)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed

         DefaultTableModel dtm = new DefaultTableModel() {
        @Override
        public Class<?> getColumnClass(int column) {
            if (column == 5) { 
                return ImageIcon.class;
            } else {
                return Object.class;
            }
        }
    };

    String[] tieude = {"Mã Hàng", "Tên Hàng", "Số Lượng", "Giá Nhập", "Giá Xuất", "Ảnh", "Ghi Chú", "Loại", "Nhà cc"};
    dtm.setColumnIdentifiers(tieude);

    if (txtTimkiem.getText().isEmpty()) {
        HienThi();
    } else {
        ArrayList<HANGHOA> dsPB = DAO_HANGHOA.timKiemHANGHOATheoTen(txtTimkiem.getText());
        dtm.setRowCount(0);
        for (HANGHOA hh : dsPB) {
            Vector<Object> vec = new Vector<Object>();
            vec.add(hh.getMAHANG());
            vec.add(hh.getTENHANG());
            vec.add(hh.getSOLUONG());
            vec.add(hh.getDONGIANHAP());
            vec.add(hh.getDONGIAXUAT());

            ImageIcon imageIcon = new ImageIcon(new ImageIcon(hh.getANH()).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
            vec.add(imageIcon);

            vec.add(hh.getGHICHU());
            vec.add(hh.getLOAI());
            vec.add(hh.getNHACC());
            dtm.addRow(vec);
        }
        dsHangHoa.setModel(dtm);

        
        TableColumn imageColumn = dsHangHoa.getColumnModel().getColumn(5);
        imageColumn.setCellRenderer(new MyTableCellRenderer());
        imageColumn.setPreferredWidth(60);

        dsHangHoa.setRowHeight(60);
    }
       
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtMa.setText("");
        txtTen.setText("");
        txtSoLuong.setText("");
        txtGiaNhap.setText("");
        txtGiaXuat.setText("");
        txtGhichu.setText("");
        
        jLabelImage.setIcon(null); 
        selectedImagePath = ""; 
    
        txtTimkiem.setText("");
        if(txtTimkiem.getText().isEmpty())
            HienThi();
    }//GEN-LAST:event_btnClearActionPerformed
      private void xoaHangHoa() {
    int row = dsHangHoa.getSelectedRow();
    if (row >= 0) {
        String maHangHoa = dsHangHoa.getValueAt(row, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sản phẩm này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                boolean result = DAO_HANGHOA.xoaHANGHOA(maHangHoa);
                if (result) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể xóa sản phẩm", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
                HienThi();
            } catch (SQLException ex) {
                Logger.getLogger(HANGHOA_GUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Lỗi khi xóa sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
    }
}
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        /*String mahh = txtMa.getText();
        try {
            DAO_HANGHOA.xoaHANGHOA(mahh);
        } catch (SQLException ex) {
            Logger.getLogger(HANGHOA_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "XOa  thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
       HienThi();
       
        txtTimkiem.setText("");
        txtMa.setText("");
        txtTen.setText("");
        txtSoLuong.setText("");
        txtGiaNhap.setText("");
        txtGiaXuat.setText("");
        txtAnh.setText("");
        txtGhichu.setText("");
        */
        String mahh = txtMa.getText();

    // Hiển thị hộp thoại xác nhận
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa hàng hóa này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                boolean result = DAO_HANGHOA.xoaHANGHOA(mahh);
                if (result) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể xóa hàng hóa", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
                HienThi();

              txtTimkiem.setText("");
            txtMa.setText("");
            txtTen.setText("");
            txtSoLuong.setText("");
            txtGiaNhap.setText("");
            txtGiaXuat.setText("");
            jLabelImage.setText("");
            txtGhichu.setText("");
            } catch (SQLException ex) {
                Logger.getLogger(HANGHOA_GUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Lỗi khi xóa sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Loại không bị xóa", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int mahh = Integer.parseInt(txtMa.getText());
        String tenhh = txtTen.getText();
        String soluong = txtSoLuong.getText();
        String gianhap = txtGiaNhap.getText();
        String giaxuat = txtGiaXuat.getText();
        String anh;

        
        if (selectedImagePath.isEmpty()) {
            int row = dsHangHoa.getSelectedRow();
            ImageIcon currentIcon = (ImageIcon) dsHangHoa.getValueAt(row, 5);
            anh = currentIcon.getDescription();
        } else {
            anh = selectedImagePath;
        }

        String ghichu = txtGhichu.getText();
        String loai = cbbLoai.getSelectedItem().toString();
        String nhacc = jcboTenHang.getSelectedItem().toString();

        int soLuong = Integer.parseInt(soluong);
        double giaNhap = Double.parseDouble(gianhap);
        double giaXuat = Double.parseDouble(giaxuat);

        HANGHOA hh = new HANGHOA();
        hh.setMAHANG(mahh);
        hh.setTENHANG(tenhh);
        hh.setSOLUONG(soLuong);
        hh.setDONGIANHAP(giaNhap);
        hh.setDONGIAXUAT(giaXuat);
        hh.setANH(anh);
        hh.setGHICHU(ghichu);
        hh.setLOAI(loai);
        hh.setNHACC(nhacc);

        try {
            DAO_HANGHOA.capNhatHANGHOA(hh);
        } catch (SQLException ex) {
            Logger.getLogger(HANGHOA_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        HienThi();

    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
      // TODO add your handling code here:
        //int mahh = Integer.parseInt(txtMa.getText());
        
        String tenhh = txtTen.getText();
        String soluong = txtSoLuong.getText();
        String gianhap = txtGiaNhap.getText();
        String giaxuat = txtGiaXuat.getText();
        String anh = selectedImagePath;
        String ghichu = txtGhichu.getText();
        String loai = cbbLoai.getSelectedItem().toString();
        String nhacc = jcboTenHang.getSelectedItem().toString();
        
        if (tenhh.isEmpty() || soluong.isEmpty()|| gianhap.isEmpty()|| giaxuat.isEmpty()|| anh.isEmpty()|| ghichu.isEmpty()|| loai.isEmpty()|| nhacc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không để thông tin trống!");
            return;
        }
        int soLuong = Integer.parseInt(soluong);
        double giaNhap = Double.parseDouble(gianhap);
        double giaXuat = Double.parseDouble(giaxuat);
        DecimalFormat df = new DecimalFormat("#,###");
        String giaNhapFormatted = df.format(giaNhap);
        String giaXuatFormatted = df.format(giaXuat);

        HANGHOA hh = new HANGHOA();
        hh.setTENHANG(tenhh);
        hh.setSOLUONG(soLuong);
        hh.setDONGIANHAP(giaNhap);
        hh.setDONGIAXUAT(giaXuat);
        hh.setANH(anh);
        hh.setGHICHU(ghichu);
        hh.setLOAI(loai);
        hh.setNHACC(nhacc);

        try {
            DAO_HANGHOA.themHANGHOA(hh);
        } catch (SQLException ex) {
            Logger.getLogger(HANGHOA_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Thêm hàng mới vào bảng
        DefaultTableModel dtm = (DefaultTableModel) dsHangHoa.getModel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(anh).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
        dtm.addRow(new Object[]{null, tenhh, soLuong, giaNhap, giaXuat, imageIcon, ghichu, loai, nhacc});
        JOptionPane.showMessageDialog(this, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnThemActionPerformed

    private void dsHangHoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dsHangHoaMouseClicked
       int row = dsHangHoa.getSelectedRow();
        txtMa.setText(dsHangHoa.getValueAt(row, 0) + "");
        txtTen.setText((String)dsHangHoa.getValueAt(row, 1));
        txtSoLuong.setText(dsHangHoa.getValueAt(row, 2) + "");
        txtGiaNhap.setText(dsHangHoa.getValueAt(row, 3) + "");
        txtGiaXuat.setText(dsHangHoa.getValueAt(row, 4) + "");

        Object imageValue = dsHangHoa.getValueAt(row, 5);
        if (imageValue instanceof ImageIcon) {
            jLabelImage.setIcon((ImageIcon) imageValue);
            selectedImagePath = ((ImageIcon) imageValue).getDescription();
        } else if (imageValue instanceof JLabel) {
            ImageIcon icon = (ImageIcon) ((JLabel) imageValue).getIcon();
            jLabelImage.setIcon(icon);
            selectedImagePath = icon.getDescription();
        } else {
            jLabelImage.setText((String) dsHangHoa.getValueAt(row, 5));
        }

        txtGhichu.setText((String)dsHangHoa.getValueAt(row, 6));

        int maloai = layMaLoai((String)dsHangHoa.getValueAt(row, 7)) - 1;
        cbbLoai.setSelectedIndex(maloai);

        int manhacc = layMaNCC((String)dsHangHoa.getValueAt(row, 8)) - 1;
        jcboTenHang.setSelectedIndex(manhacc);
        
        
    }//GEN-LAST:event_dsHangHoaMouseClicked

    private void cbbLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLoaiActionPerformed

    private void jcboTenHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcboTenHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcboTenHangActionPerformed

    private void btnBrowserImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowserImageActionPerformed
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
            Image image = ii.getImage().getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_SMOOTH);
            jLabelImage.setIcon(new ImageIcon(image));
            selectedImagePath = selectedIangeFath; 
        }
        
    }//GEN-LAST:event_btnBrowserImageActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) dsHangHoa.getModel();

        if (viewSelectedRow == null) {
            viewSelectedRow = new ViewSelectedRow();
        }

        viewSelectedRow.setVisible(true);
        viewSelectedRow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        int selectedRowForNewJframe = dsHangHoa.getSelectedRow();
        if (selectedRowForNewJframe == -1) {
            viewSelectedRow.jLabel1NoSelectedRowMessage.setText("No Row Selected!!..");
        } else {
            viewSelectedRow.jLabel1NoSelectedRowMessage.setText(null);
            System.out.println("Selected row value: " + selectedRowForNewJframe);

            String newMa = model.getValueAt(selectedRowForNewJframe, 0).toString();
            String newTen = model.getValueAt(selectedRowForNewJframe, 1).toString();
            String newSL = model.getValueAt(selectedRowForNewJframe, 2).toString();
            String newGiaNhap = model.getValueAt(selectedRowForNewJframe, 3).toString();
            String newGiaBan = model.getValueAt(selectedRowForNewJframe, 4).toString();

            ImageIcon newImageIcon = (ImageIcon) model.getValueAt(selectedRowForNewJframe, 5);

            String newGhiChu = model.getValueAt(selectedRowForNewJframe, 6).toString();
            String newLoai = model.getValueAt(selectedRowForNewJframe, 7).toString();
            String newNhaCC = model.getValueAt(selectedRowForNewJframe, 8).toString();

            // size ảnh
            Image newImageSize = newImageIcon.getImage().getScaledInstance(
                viewSelectedRow.jLabelImageView.getWidth(), 
                viewSelectedRow.jLabelImageView.getHeight(), 
                Image.SCALE_SMOOTH
            );

            viewSelectedRow.jTextFieldMaView.setText(newMa);
            viewSelectedRow.jTextFieldTenView.setText(newTen);
            viewSelectedRow.jTextFieldSLView.setText(newSL);
            viewSelectedRow.jTextFieldGiaNhapView.setText(newGiaNhap);
            viewSelectedRow.jTextFieldGiaXuatView.setText(newGiaBan);
            viewSelectedRow.jLabelImageView.setIcon(new ImageIcon(newImageSize));
            viewSelectedRow.jTextFieldGhiChuView.setText(newGhiChu);
            viewSelectedRow.jTextFieldLoaiView.setText(newLoai);
            viewSelectedRow.jTextFieldNhaCCView.setText(newNhaCC);
        }
       
    }//GEN-LAST:event_btnViewActionPerformed

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
            java.util.logging.Logger.getLogger(HANGHOA_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HANGHOA_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HANGHOA_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HANGHOA_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HANGHOA_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowserImage;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbbLoai;
    private javax.swing.JTable dsHangHoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcboTenHang;
    private javax.swing.JTextField txtGhichu;
    private javax.swing.JTextField txtGiaNhap;
    private javax.swing.JTextField txtGiaXuat;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTimkiem;
    // End of variables declaration//GEN-END:variables
byte[] photo=null;
String filename=null;
}
