/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry;
import java.awt.Desktop;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author LENOVO
 */
public class pembayaran extends javax.swing.JFrame {
    model model = new model();
java.util.Date tglsekarang = new java.util.Date();
    private final SimpleDateFormat smpdtfmt = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    private final String tanggal = smpdtfmt.format(tglsekarang);
    private Statement st;
    private Connection con;
    private ResultSet rs;
    public DefaultTableModel tabmodel;
    public DefaultTableModel tabmodel2;
    public DefaultTableModel tbldata;


    private Object displaytext;
    private void koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/db_laundry", "root", "");
            st = (Statement) con.createStatement();
            System.out.println("berhasil");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("koneksi gagal" + e.getMessage());
        }
    }
    String hasil;
    /**
     * Creates new form pembayaran
     */
    public pembayaran() throws SQLException {
        initComponents();
        koneksi();
        judul();
        tampildata();
        judul1();
        tampildata1();
        tgl.setText(tanggal);
    }
    
    /**
     *
     * @throws SQLException
     */
    public void tampildata(){
        try{
           st = con.createStatement();
           tabmodel.getDataVector().removeAllElements();
           tabmodel.fireTableDataChanged();
           rs = st.executeQuery("SELECT * FROM tbl_pesan");
           while(rs.next()){
                Object[] data = {
                    rs.getString("no_antrian"),
                    rs.getString("nama"),
                    rs.getString("no_telp"),
                    rs.getString("alamat"),
                    rs.getString("jns_pewangi"),
                    rs.getString("jml_pakaian"),
                    rs.getString("harga"),
                    rs.getString("tanggal")
                };                
                tabmodel.addRow(data);
    }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    
    private void judul(){
        Object[] judul = {"No Antrian","Nama", "No Telepon", "Alamat", "Jenis Pewangi", "Jumlah", "Harga", "Tanggal"};
        tabmodel = new DefaultTableModel(null, judul);
        tbl_beli.setModel(tabmodel);
    }
    
    public void tampildata1(){
        try {
            st = con.createStatement();
            tabmodel2.getDataVector().removeAllElements();
            tabmodel2.fireTableDataChanged();
            rs = st.executeQuery("SELECT * FROM tbl_ambil");
            while (rs.next()) {                
                Object[] data = {
                    rs.getString("no_antrian"),
                    rs.getString("nama"),
                    rs.getString("no_telp"),
                    rs.getString("alamat"),
                    rs.getString("jns_pewangi"),
                    rs.getString("jml_pakaian"),
                    rs.getString("harga"),
                    rs.getString("tanggal"),
                    rs.getString("total"),
                    rs.getString("bayar"),
                    rs.getString("kembali")};
                tabmodel2.addRow(data);
            }
    } catch (Exception e) {
            e.printStackTrace();
    }
    }
    
    private void judul1(){ 
        Object[] judul = {"Nomor Antrian","Nama","No Telepon","Alamat","Jenis Pewangi","Jumlah","Harga","Tanggal","Total","Bayar","Kembalian"};
        tabmodel2 = new DefaultTableModel(null,judul);
        tabel2.setModel(tabmodel2);
}
    
    private void reset()
     { 
        tf_no_antrian.setText(""); 
        tgl.setText("");
        tf_nama.setText("");
        cbb_jns_pewangi.setSelectedIndex(-1); 
        tf_jml_pakaian.setText("");
        cbb_jns_pewangi.setSelectedItem("");
        tf_nama.setText("");
        tf_no_telp.setText("");
        tf_alamat.setText("");
        ttanggal.setText("");
        tf_harga.setText("");
        totall.setText("");
        bayar.setText("");
        kembalian.setText("");
        tf_no_antrian.requestFocus();
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tf_no_antrian = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tf_nama = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel2 = new javax.swing.JTable();
        Report = new javax.swing.JButton();
        kembali = new javax.swing.JButton();
        selesai = new javax.swing.JButton();
        tgl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bayar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        kembalian = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        totall = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_beli = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        tf_no_telp = new javax.swing.JTextField();
        tf_alamat = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tf_jml_pakaian = new javax.swing.JTextField();
        tf_harga = new javax.swing.JTextField();
        ttanggal = new javax.swing.JTextField();
        cbb_jns_pewangi = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(0, 255, 204));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("No Antrian");

        tf_no_antrian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_no_antrianKeyReleased(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Nama");

        tabel2.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel2);

        Report.setBackground(new java.awt.Color(0, 255, 204));
        Report.setForeground(new java.awt.Color(255, 255, 255));
        Report.setText("REPORT");
        Report.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ReportMouseClicked(evt);
            }
        });
        Report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportActionPerformed(evt);
            }
        });

        kembali.setBackground(new java.awt.Color(0, 255, 204));
        kembali.setForeground(new java.awt.Color(255, 255, 255));
        kembali.setText("KEMBALI");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        selesai.setBackground(new java.awt.Color(0, 255, 204));
        selesai.setForeground(new java.awt.Color(255, 255, 255));
        selesai.setText("SELESAI");
        selesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selesaiActionPerformed(evt);
            }
        });

        tgl.setText("jLabel13");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Bayar");

        bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                bayarKeyReleased(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kembalian");

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Total");

        tbl_beli.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_beli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_beliMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_beli);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("No Telepon");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Alamat");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Jenis Pewangi");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Jumlah");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Harga");

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Tanggal");

        cbb_jns_pewangi.setForeground(new java.awt.Color(255, 255, 255));
        cbb_jns_pewangi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih", "Cair", "Bubuk" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(119, 119, 119)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 495, Short.MAX_VALUE)
                        .addComponent(jScrollPane1))
                    .addComponent(Report))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_alamat, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(tf_nama)
                            .addComponent(tf_no_antrian)
                            .addComponent(tf_no_telp))
                        .addGap(85, 85, 85)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbb_jns_pewangi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(tf_jml_pakaian, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(ttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(tf_harga, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(83, 83, 83))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(tgl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(selesai)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(kembali)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(totall, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(28, 28, 28))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_no_antrian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(totall, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbb_jns_pewangi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13)
                    .addComponent(bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tf_jml_pakaian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_no_telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(kembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tf_harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15)
                    .addComponent(ttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selesai))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Report)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kembali)
                    .addComponent(tgl))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Perpetua Titling MT", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("AMBIL DISINI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(jLabel3)
                .addGap(35, 220, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(210, 210, 210))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(5, 5, 5)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportActionPerformed
        // TODO add your handling code here:
        if(Desktop.isDesktopSupported()){
            try{
                Desktop.getDesktop().browse(new URL("http://localhost:82/Laporanjava/laporan.php").toURI());
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_ReportActionPerformed

    private void selesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selesaiActionPerformed
        int a,b;
        a = Integer.parseInt(totall.getText());
        b = Integer.parseInt(bayar.getText());
        if (b < a) {
            JOptionPane.showMessageDialog(null, "Uang Anda Kurang");
        }else{
        String sql = "no_antrian ='"+ tf_no_antrian.getText() +"',nama='"+tf_nama.getText()+"',no_telp='"+tf_no_telp.getText()+"',alamat='"+ tf_alamat.getText() +"',jns_pewangi='"+cbb_jns_pewangi.getSelectedItem()+"',jml_pakaian='"+tf_jml_pakaian.getText()+"',harga='"+tf_harga.getText()+"',tanggal='"+ttanggal.getText()+"',total='"+totall.getText()+"',bayar='"+bayar.getText()+"',kembali='"+kembalian.getText()+"'";
        if (model.hapus("tbl_pesan", "no_antrian", tf_no_antrian.getText())) {
            if (model.simpan("tbl_ambil", sql)) {
                JOptionPane.showMessageDialog(null, "Berhasil");
                tampildata();
                tampildata1();
                if(Desktop.isDesktopSupported()){
                    try{
                        Desktop.getDesktop().browse(new URL("http://localhost:82/Laporanjava/struk.php?id="+ tf_no_antrian.getText()).toURI());
                } catch(Exception e){
                        e.printStackTrace();
                }
        }
                reset();
            }else{
                JOptionPane.showMessageDialog(null, "gagal simpan");
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Gagal Hapus");
        }
        }
      

          
    }//GEN-LAST:event_selesaiActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
        new home().setVisible(true);
        dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void ReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ReportMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_ReportMouseClicked

    private void tabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel2MouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tabel2MouseClicked

    private void tf_no_antrianKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_no_antrianKeyReleased
        if (!tf_no_antrian.getText().equals("")) {
            try {
                st = con.createStatement();
                rs = st.executeQuery("select * from tbl_pesan where no_antrian ='"+tf_no_antrian.getText()+"'");
                if (rs.next()) {
                    tf_nama.setText(rs.getString("nama"));
                    tf_no_telp.setText(rs.getString("no_telp"));
                    tf_alamat.setText(rs.getString("alamat"));
                    cbb_jns_pewangi.setSelectedItem(rs.getString("jns_pewangi"));
                    tf_jml_pakaian.setText(rs.getString("jml_pakaian"));
                    tf_harga.setText(rs.getString("harga"));
                    ttanggal.setText(rs.getString("tanggal"));
                    totall.setText(rs.getString("harga"));
                }else{
                    tf_nama.setText("");
                    tf_no_telp.setText("");
                    tf_alamat.setText("");
                    cbb_jns_pewangi.setSelectedItem("");
                    tf_jml_pakaian.setText("");
                    tf_harga.setText("");
                    ttanggal.setText("");
                    totall.setText("");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_tf_no_antrianKeyReleased

    private void bayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayarKeyReleased
        if (Integer.parseInt(totall.getText())>Integer.parseInt(bayar.getText())) {
            kembalian.setText("Uang Kurang!");
        }else{
            Integer kembali = Integer.parseInt(bayar.getText())-Integer.parseInt(totall.getText());
            kembalian.setText(kembali.toString());
        }
    }//GEN-LAST:event_bayarKeyReleased

    private void tbl_beliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_beliMouseClicked
            tf_no_antrian.setText(tabmodel.getValueAt(tbl_beli.getSelectedRow(), 0) + "");
        tf_nama.setText(tabmodel.getValueAt(tbl_beli.getSelectedRow(), 1) + "");
        tf_no_telp.setText(tabmodel.getValueAt(tbl_beli.getSelectedRow(), 2) + "");
        tf_alamat.setText(tabmodel.getValueAt(tbl_beli.getSelectedRow(), 3) + "");
        cbb_jns_pewangi.setSelectedItem(tabmodel.getValueAt(tbl_beli.getSelectedRow(), 4) + "");
        tf_jml_pakaian.setText(tabmodel.getValueAt(tbl_beli.getSelectedRow(), 5) + "");
        tf_harga.setText(tabmodel.getValueAt(tbl_beli.getSelectedRow(), 6) + "");
        ttanggal.setText(tabmodel.getValueAt(tbl_beli.getSelectedRow(), 7) + "");
        

    }//GEN-LAST:event_tbl_beliMouseClicked

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
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pembayaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new pembayaran().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(pembayaran.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Report;
    private javax.swing.JTextField bayar;
    private javax.swing.JComboBox<String> cbb_jns_pewangi;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton kembali;
    private javax.swing.JTextField kembalian;
    private javax.swing.JButton selesai;
    private javax.swing.JTable tabel2;
    private javax.swing.JTable tbl_beli;
    private javax.swing.JTextField tf_alamat;
    private javax.swing.JTextField tf_harga;
    private javax.swing.JTextField tf_jml_pakaian;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_no_antrian;
    private javax.swing.JTextField tf_no_telp;
    private javax.swing.JLabel tgl;
    private javax.swing.JTextField totall;
    private javax.swing.JTextField ttanggal;
    // End of variables declaration//GEN-END:variables

//    private void judul() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private void tampildata() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private void judul1() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private void tampildata1() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
