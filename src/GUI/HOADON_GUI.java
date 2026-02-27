/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import Connect.SQLServerProvider;
import java.util.Calendar;
import DAO.DAO_HOADON;
import DAO.DAO_HANGHOA;
import Entity.HOADON;
import DAO.DAO_HOADON_CT;
import DAO.DAO_KHACHHANG;
import DAO.DAO_NHANVIEN;
import Entity.HANGHOA;
import Entity.HOADON_CT;
import Entity.NHANVIEN;
import Entity.KHACHHANG;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/*
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
*/
/**
 *
 * @author Victus
 */
public class HOADON_GUI extends javax.swing.JFrame {
//String dateString = "2024-05-12"; 
//java.sql.Date sqlDate = java.sql.Date.valueOf(dateString);

    /**
     * Creates new form HOADON_GUI
     */
    private String tenNhanVien;
 private JTextField txtMaNV;

    /**
     *
     * @param tenNV
     * @param maNV
     */
    public HOADON_GUI(String tenNV, String maNV) {
        initComponents();
//         this.tenNhanVien = tenNV;
//        
//        txtTenNV.setText(tenNV);
//        txtTenNV = new javax.swing.JTextField();
//        txtTenNV.setEditable(false);
         this.tenNhanVien = tenNV;

        txtTenNV.setText(tenNV);
        txtTenNV.setEditable(false);

        txtMaNV = new JTextField(maNV);
        txtMa.setText(maNV);
        txtMa.setEditable(false);
        
        setDefaultCloseOperation(HOADON_GUI.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        HienThi_hoadon();
        ngayban();
            txtmahd.enable(false);
            txtthanhtien.enable(false);
            txttongtien.enable(false);
            txtngayban.enable(false);
            txtDienThoai.enable(false);
            txtgiamgia.enable(false);
            //txtTenNV.enable(false);
        load_cbomahang();
       // load_cbomanhanvien();
        load_cbomakhachhang();
          //--------- xoa dong tren bang
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteMenuItem = new JMenuItem("Xóa");
        deleteMenuItem.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
           //   xoaHD();
          }
      });
    popupMenu.add(deleteMenuItem);
    dshoadon.setComponentPopupMenu(popupMenu);
    }
     private ArrayList<HANGHOA> dshh;
     private ArrayList<NHANVIEN> dsnv;
     private ArrayList<KHACHHANG> dskh;
     private int maHangChon;
       private int maNVChon;
       private int maKHChon;

    private HOADON_GUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    private void load_cbomahang(){
      dshh =DAO_HANGHOA.getHANGHOA();
        for(HANGHOA hh:dshh)
//            cbomahang.addItem(String.valueOf(l.getMAHANG()));
            cbomahang.addItem(hh.getTENHANG());
    }
//     private void load_cbomanhanvien(){
//      dsnv =DAO_NHANVIEN.getNHANVIEN();
//        for(NHANVIEN nv:dsnv)
//            cboMaNV.addItem(nv.getTenNhanVien());
//    }
      private void load_cbomakhachhang(){
      dskh = DAO_KHACHHANG.getKHACHHANG();
        for(KHACHHANG kh: dskh)
            cboMaKH.addItem(kh.getTenKhachHang());
    }
     
    private void ngayban()
    {
        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todayDateStr = dateFormat.format(today);
        java.sql.Date todayDate = java.sql.Date.valueOf(todayDateStr);
        txtngayban.setText(todayDateStr);
    }
    private void taomahd() throws SQLException
    {
       
        Date currentDate = new Date();
        
        // Lấy các thành phần của ngày hiện tại (ngày, tháng, năm)
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1; 
        int year = calendar.get(Calendar.YEAR) % 100; 
        
        // Định dạng ngày, tháng, năm thành chuỗi XX, YY, ZZ
        String ngay = String.format("%02d", day);
        String thang = String.format("%02d", month);
        String nam = String.format("%02d", year);
        int stt=DAO_HOADON.demsoluonghdtrongngay();
        String maHoaDon = "HD" + ngay + thang + nam +stt;
            txtmahd.setText(maHoaDon);
    }
    private void HienThi_hoadon(){
        DefaultTableModel  dtm = new DefaultTableModel();
        String[] tieude = {"Mã hóa đơn", "Ngày bán","Mã nhân viên","Mã khách hàng","Tổng tiền"};
        dtm.setColumnIdentifiers(tieude);
        ArrayList<HOADON> dshd = DAO_HOADON.getHOADON();
        
        for(HOADON hd:dshd){
            Vector<Object> vec = new Vector<Object>();
                vec.add(hd.getMaHoaDon());
                vec.add(hd.getNgayBan());
                
                vec.add(hd.getMaNhanVien());
                vec.add(hd.getMaKhachHang());
                vec.add(hd.getTongTien());
              
            dtm.addRow(vec);
        }
        dshoadon.setModel(dtm);
  
     }
   public void hienthi_ct_hoadon(){
             
        
        DefaultTableModel  dtm2 = new DefaultTableModel();
        String[] tieude2 = {"Mã hóa đơn","Mã hàng", "Số lượng","Đơn giá","Giảm giá","Thành tiền"};
        dtm2.setColumnIdentifiers(tieude2);
        ArrayList<HOADON_CT> cthd = DAO_HOADON_CT.getHOADON_CT(txtmahd.getText());
        
        for(HOADON_CT hdct:cthd){
            Vector<Object> vec2 = new Vector<Object>();
            vec2.add(hdct.getMaHoDon());
                vec2.add(hdct.getMaHang());
                vec2.add(hdct.getSoLuong());
                vec2.add(String.format("%.2f", hdct.getDonGia())); 
            vec2.add(String.format("%.2f", hdct.getGiamGia()));
            vec2.add(String.format("%.2f", hdct.getThanhTien()));
            dtm2.addRow(vec2);
        }
        dscthoadon.setModel(dtm2);
    }
     private void xoaHD() {
    int row = dshoadon.getSelectedRow();
    if (row >= 0) {
        String maHangHoa = dshoadon.getValueAt(row, 0).toString();
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sản phẩm này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                boolean result = DAO_HOADON.xoaHOADON(maHangHoa);
                if (result) {
                    JOptionPane.showMessageDialog(this, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Không thể xóa sản phẩm", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
                HienThi_hoadon();
            } catch (SQLException ex) {
                Logger.getLogger(HOADON_GUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "Lỗi khi xóa sản phẩm", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
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

        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dshoadon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtmahd = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtngayban = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txttongtien = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtthanhtien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtdongia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtsl = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtgiamgia = new javax.swing.JTextField();
        btnluuhd = new javax.swing.JButton();
        btnthemhd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        dscthoadon = new javax.swing.JTable();
        cbomahang = new javax.swing.JComboBox<>();
        btnClear = new javax.swing.JButton();
        btnInHD = new javax.swing.JButton();
        cboMaKH = new javax.swing.JComboBox<>();
        txtDienThoai = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        txtMa = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 255));
        jLabel10.setText("Hóa đơn bán hàng");

        dshoadon.setBackground(new java.awt.Color(204, 204, 255));
        dshoadon.setModel(new javax.swing.table.DefaultTableModel(
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
        dshoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dshoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dshoadon);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Mã hóa đơn");

        txtmahd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Ngày bán");

        txtngayban.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Mã NV");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Mã KH");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Tổng tiền");

        txttongtien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txttongtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttongtienActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Thành tiền");

        txtthanhtien.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtthanhtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtthanhtienActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setText("Tên hàng");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Đơn giá");

        txtdongia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setText("Số lượng");

        txtsl.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Giảm giá");

        txtgiamgia.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        txtgiamgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgiamgiaActionPerformed(evt);
            }
        });

        btnluuhd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnluuhd.setForeground(new java.awt.Color(102, 102, 255));
        btnluuhd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save_1.png"))); // NOI18N
        btnluuhd.setText("Lưu");
        btnluuhd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnluuhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnluuhdActionPerformed(evt);
            }
        });

        btnthemhd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnthemhd.setForeground(new java.awt.Color(102, 102, 255));
        btnthemhd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add.png"))); // NOI18N
        btnthemhd.setText("Tạo hóa đơn");
        btnthemhd.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnthemhd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemhdActionPerformed(evt);
            }
        });

        dscthoadon.setBackground(new java.awt.Color(204, 204, 255));
        dscthoadon.setModel(new javax.swing.table.DefaultTableModel(
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
        dscthoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dscthoadonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(dscthoadon);

        cbomahang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        cbomahang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbomahangActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        btnClear.setForeground(new java.awt.Color(102, 102, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/update.png"))); // NOI18N
        btnClear.setText("Tạo mới \nchi tiết hóa đơn\n");
        btnClear.setToolTipText("");
        btnClear.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnInHD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnInHD.setForeground(new java.awt.Color(102, 102, 255));
        btnInHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/luu(1).png"))); // NOI18N
        btnInHD.setText("In hóa đơn");
        btnInHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInHDActionPerformed(evt);
            }
        });

        cboMaKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));
        cboMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaKHActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Điện thoại");

        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setText("Tên NV");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnthemhd, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnluuhd, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(81, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(40, 40, 40))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbomahang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtmahd, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtngayban, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txttongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtdongia, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtthanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel11))
                                        .addGap(40, 40, 40))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                                .addComponent(txtsl, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                .addComponent(txtgiamgia, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                                .addComponent(cboMaKH, 0, 145, Short.MAX_VALUE)
                                .addComponent(txtDienThoai))
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(379, 379, 379))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnInHD, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(txtmahd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtngayban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cboMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txttongtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txtDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(txtsl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbomahang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtdongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtgiamgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtthanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnluuhd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnthemhd, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnInHD, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dshoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dshoadonMouseClicked
     
      int row = dshoadon.getSelectedRow();
    txtmahd.setText(dshoadon.getValueAt(row, 0) + ""); 
    txtngayban.setText((String) dshoadon.getValueAt(row, 1));
    

    
  // cboMaNV.setSelectedIndex((int) dshoadon.getValueAt(row, 2));
     cboMaKH.setSelectedIndex((int) dshoadon.getValueAt(row, 3));
      
    txttongtien.setText(dshoadon.getValueAt(row, 4) + ""); 
    hienthi_ct_hoadon();
    }//GEN-LAST:event_dshoadonMouseClicked

    private void txttongtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttongtienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttongtienActionPerformed

    private void txtthanhtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtthanhtienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtthanhtienActionPerformed

    private void txtgiamgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgiamgiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgiamgiaActionPerformed

    private void btnluuhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnluuhdActionPerformed
     
      try {                                         
      
        String mahd = txtmahd.getText();

        if (DAO_HOADON.ktkhoachinh(mahd)) {
        
            luucthd();
            return;
        }
 
        String ngayban = txtngayban.getText();

       
        String manvstr = txtMaNV.getText(); 
        
     
        if (manvstr.isEmpty() || !manvstr.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "Mã nhân viên không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int manv = Integer.parseInt(manvstr);

       
        int makhstr = DAO_HOADON.layMaKh(cboMaKH.getSelectedItem().toString()); 
        int makh = makhstr; 

        boolean khachHangTonTai = false;
        for (KHACHHANG kh : dskh) {
            if (kh.getMaKhachHang() == makh) {
                khachHangTonTai = true;
                break;
            }
        }

        if (!khachHangTonTai) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng không hợp lệ", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return; 
        }

        HOADON hd = new HOADON();
        hd.setMaHoaDon(mahd);
        hd.setMaKhachHang(makh);
        hd.setMaNhanVien(manv);
        hd.setNgayBan(ngayban);

 
        DAO_HOADON.themHOADON(hd);

     
        JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);

      
        HienThi_hoadon();

    } catch (SQLException ex) {
        Logger.getLogger(HOADON_GUI.class.getName()).log(Level.SEVERE, null, ex);
    }
   
    }//GEN-LAST:event_btnluuhdActionPerformed
    private int laySoLuongTon(int maHang) throws SQLException {
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        String query = "SELECT HH.SOLUONG - ISNULL(SUM(CTHD.SOLUONG), 0) AS TON "
                     + "FROM HANGHOA HH LEFT JOIN CHITIETHOADON CTHD ON HH.MAHANG = CTHD.MAHANG "
                     + "WHERE HH.MAHANG = " + maHang + " GROUP BY HH.SOLUONG";
        ResultSet rs = provider.executeQuery(query);
        int tonKho = 0;
        if (rs.next()) {
            tonKho = rs.getInt("TON");
        }
        provider.close();
        return tonKho;
    }

     private void luucthd() {
    String mahd = txtmahd.getText();
    String mahang = Integer.toString(maHangChon);
    String soluong = txtsl.getText();
    String dongia = Double.toString(DAO_HOADON_CT.getGiaHangHoa(maHangChon));
    String giamgia = txtgiamgia.getText(); 
 
    //double giamgia = Double.parseDouble(txtgiamgia.getText().trim()); // Lấy giá trị giảm giá từ txtgiamgia

    int MH = Integer.parseInt(mahang);
    int SL = Integer.parseInt(soluong);
    double DG = Double.parseDouble(dongia);
    double GG = Double.parseDouble(giamgia);
   // double GG = giamgia;

    try {
//        if (isMaHangExists(mahang)) {
//            JOptionPane.showMessageDialog(this, "Mã hóa đơn đã tồn tại trong bảng chi tiết hóa đơn", "Thông báo", JOptionPane.WARNING_MESSAGE);
//            return; 
//        }
        
        int tonKho = laySoLuongTon(MH);
        if (tonKho == 0) {
            JOptionPane.showMessageDialog(this, "Hết hàng", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (SL > tonKho) {
            JOptionPane.showMessageDialog(this, "Số lượng không đủ. Số lượng còn lại: " + tonKho, "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            HOADON_CT cthd = new HOADON_CT();
            cthd.setMaHoDon(mahd);
            cthd.setDonGia(DG);
            cthd.setGiamGia(GG);
            cthd.setMaHang(MH);
            cthd.setSoLuong(SL);
            DAO_HOADON_CT.themHOADON_CT(cthd);
            JOptionPane.showMessageDialog(this, "Thêm chi tiết hóa đơn thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            HienThi_hoadon();
            hienthi_ct_hoadon();
        }
    } catch (SQLException ex) {
        Logger.getLogger(HOADON_GUI.class.getName()).log(Level.SEVERE, null, ex);
    }
}
private boolean isMaHangExists(String mahang) {
    boolean tontai = false;
    SQLServerProvider provider = new SQLServerProvider();
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {
        conn = (Connection) provider.getConnection();
        String query = "SELECT COUNT(*) FROM CHITIETHOADON WHERE MAHANG = ?";
        ps = conn.prepareStatement(query);
        ps.setString(1, mahang);
        rs = ps.executeQuery();
        
        if (rs.next()) {
            int count = rs.getInt(1);
            if (count > 0) {
                tontai = true; // Mã hàng đã tồn tại
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(HOADON_GUI.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(HOADON_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    return tontai;
}



    private void btnthemhdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemhdActionPerformed
        try {
            // TODO add your handling code here:
            taomahd();
            ngayban();
        } catch (SQLException ex) {
            Logger.getLogger(HOADON_GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnthemhdActionPerformed

    private void dscthoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dscthoadonMouseClicked
        // TODO add your handling code here:
         int row = dscthoadon.getSelectedRow();
        txtmahd.setText(dscthoadon.getValueAt(row, 0) + ""); 
        txtsl.setText(dscthoadon.getValueAt(row, 2) + ""); 
        txtdongia.setText(dscthoadon.getValueAt(row, 3) + ""); 
        txtgiamgia.setText(dscthoadon.getValueAt(row, 4) + ""); 
        txtthanhtien.setText(dscthoadon.getValueAt(row, 5)+ "");
        
       
        cbomahang.setSelectedIndex((int) dscthoadon.getValueAt(row, 1)-1);
    }//GEN-LAST:event_dscthoadonMouseClicked

    private void cbomahangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbomahangActionPerformed
        // TODO add your handling code here:
         int selectedIndex = cbomahang.getSelectedIndex();
         HANGHOA selectedHangHoa = dshh.get(selectedIndex);
          maHangChon = selectedHangHoa.getMAHANG();
    String tenHangChon = selectedHangHoa.getTENHANG();
        System.out.println(maHangChon);
          txtdongia.setText(Double.toString(DAO_HOADON_CT.getGiaHangHoa(maHangChon)));

    
    }//GEN-LAST:event_cbomahangActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
    txtgiamgia.setText("");
    txtsl.setText("");
    txtthanhtien.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnInHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInHDActionPerformed
        // TODO add your handling code here:
        /*
        if(txtmahd.getText().length()<=0)
            return;
        if(dshoadon.getRowCount()<=0)
            return;
        try{
            Hashtable map= new Hashtable();
            //D:\CN Java\DaAn_test\BT_End_Mon\src\Report\rpHoaDon.jrxml
            //JasperReport rpt= JasperCompileManager.compileReport("D:\\CN Java\\DoAn\\lan4\\BT_End_Mon\\src\\Report\\rpHoaDon.jrxml");
             JasperReport rpt= JasperCompileManager.compileReport("src/Report/rpHoaDon.jrxml");
            map.put("sMaHD",txtmahd.getText());
            SQLServerProvider provider = new SQLServerProvider();
            java.sql.Connection conn = provider.open(); 
            JasperPrint p = JasperFillManager.fillReport(rpt, map, conn); 
            JasperViewer.viewReport(p,false);

            
        }catch(JRException | SQLException ex){
            Logger.getLogger(HOADON_GUI.class.getName()).log(Level.SEVERE,null, ex);
        }
        */
    }//GEN-LAST:event_btnInHDActionPerformed

    private void cboMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaKHActionPerformed
        // TODO add your handling code here:
     int selectedIndex = cboMaKH.getSelectedIndex();

    KHACHHANG selectedKH = dskh.get(selectedIndex);

    String sdt = DAO_HOADON.laySdtKh(selectedIndex);
    txtDienThoai.setText(sdt);
    
     
   if(selectedIndex != 0)
        txtgiamgia.setText("5");
    else
        txtgiamgia.setText("");
   
   
////    
//    String mahd = txtmahd.getText();
//    
//    try {
//      
//        double giamGia = DAO_HOADON_CT.getGiamGia(mahd);
//     
//        txtgiamgia.setText(String.valueOf(giamGia));
//    } catch (SQLException ex) {
//        ex.printStackTrace();
//      
//    }

    }//GEN-LAST:event_cboMaKHActionPerformed

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

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
            java.util.logging.Logger.getLogger(HOADON_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HOADON_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HOADON_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HOADON_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HOADON_GUI().setVisible(true);
            
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnInHD;
    private javax.swing.JButton btnluuhd;
    private javax.swing.JButton btnthemhd;
    private javax.swing.JComboBox<String> cboMaKH;
    private javax.swing.JComboBox<String> cbomahang;
    private javax.swing.JTable dscthoadon;
    private javax.swing.JTable dshoadon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtDienThoai;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtdongia;
    private javax.swing.JTextField txtgiamgia;
    private javax.swing.JTextField txtmahd;
    private javax.swing.JTextField txtngayban;
    private javax.swing.JTextField txtsl;
    private javax.swing.JTextField txtthanhtien;
    private javax.swing.JTextField txttongtien;
    // End of variables declaration//GEN-END:variables
}
