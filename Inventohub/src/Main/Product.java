
package Main;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class Product extends javax.swing.JFrame {

    public Product() {
        initComponents();
        refresh_table();
        report_table();
    }
    
private void refresh_table(){
    DefaultTableModel model;
    model = (DefaultTableModel) inventoryTable.getModel();
    model.setRowCount(0);
    int num_prod = 0;
    float num_damage = 0;
    try {
        File products = new File("src/Database/inventory.txt");
        Scanner in = new Scanner(products);

        while(in.hasNext()) {
            float item = 0;
            float damage = 0;
            String[] data = in.nextLine().split(",");
            num_prod++;
            damage = Float.parseFloat(data[6]);
            model.addRow(data);

            num_damage += damage;
        }
        
    } catch (FileNotFoundException ex) {

    } 
       totalNumVal.setText(Integer.toString(num_prod));
       totalItemLabel.setText(Integer.toString(num_prod));
       Double roundedD = Math.round(num_damage * 1000)/1000.0;
       totalDamagedLabel.setText(Double.toString(roundedD));
       
    }
    
private void report_table(){
    DefaultTableModel model;
    model = (DefaultTableModel) outTable.getModel();
    model.setRowCount(0);
    int numP = 0;
    float numProfit = 0;
    try{
        String path =  "src/Database/StockOut.txt";
        File products = new File(path);
        Scanner in = new Scanner(products);
         while(in.hasNext()) {
            float profit = 0;
            String[] data = in.nextLine().split(",");
            numP++;
            model.addRow(data);
            profit = Float.parseFloat(data[6]);
            numProfit += profit;
         }
    Double roundedProf = Math.round(numProfit * 1000)/1000.0;
    totalProfitLabel.setText("P"+Double.toString(roundedProf));
        
    }catch (FileNotFoundException ex) {

    }
    TotalOutProducts.setText(Integer.toString(numP));
    TotalProfit.setText(Float.toString(numProfit));
 }

private void search_name(String name){
        
    DefaultTableModel model;
    model = (DefaultTableModel) inventoryTable.getModel();
    model.setRowCount(0);
    try {
        String path = "src/Database/Inventory.txt";
        File products = new File(path);
        Scanner in = new Scanner(products);

        while(in.hasNext()) {
            String[] data = in.nextLine().split(",");
            if (data[1].substring(0,name.length()).equalsIgnoreCase(name) || data[1].startsWith(name)){
                model.addRow(data);
                clear_text();
            }
        } 
    } catch (FileNotFoundException ex) {

    }
    clear_text();
 }
 
 int randomNum(){
      int min = 1000;
      int max = 100000;
      
      int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
        
        
    }
 private Integer check_U(String name){
     int u=0;
     
     for (int i = 0; i < inventoryTable.getRowCount(); i++) {
        String newName = (inventoryTable.getModel().getValueAt(i, 1).toString());
        if (newName.equals(name) ){
            u = 1;
            
        }
        
    }

   return  u;
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        Side_Menu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dashboardTab = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        transactionTab = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inventoryTab = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        reportsTab = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        historyTab = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        aboutTab = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        logOutTab = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        Mainmenu = new javax.swing.JPanel();
        Summary = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        totalItemPanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        totalItemLabel = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        totalProfitPanel = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        totalProfitLabel = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        totalDamagedPanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        totalDamagedLabel = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        Inventory = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        SearchBar = new javax.swing.JTextField();
        search = new javax.swing.JLabel();
        totalNumberofProducts = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        totalNumVal = new javax.swing.JLabel();
        scrollpane = new javax.swing.JScrollPane();
        inventoryTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        productInfo = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        ID = new javax.swing.JLabel();
        Category = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Damage = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        Stocks = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        Name1 = new javax.swing.JTextField();
        CapitalperUnit = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Sales = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        damageButton = new javax.swing.JButton();
        ADDPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        AddID = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        AddPrice = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        AddSize = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        AddName = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        AddCapital = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        AddStocks = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        addItemButton = new javax.swing.JButton();
        EDITPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        EditID = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        EditPrice = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        EditSize = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        EditName = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        EditCapital = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        EditStocks = new javax.swing.JTextField();
        editbackButton = new javax.swing.JButton();
        EditItemButton = new javax.swing.JButton();
        DELETEPanel = new javax.swing.JPanel();
        deleteCont = new javax.swing.JPanel();
        deleteBoxPanel = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        DeleteID = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        DeletePrice = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        DeleteSize = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        DeleteCapital = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        DeleteStocks = new javax.swing.JTextField();
        deleteBackButton = new javax.swing.JButton();
        DeleteItemButton = new javax.swing.JButton();
        DeleteName = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        DeleteDamage = new javax.swing.JTextField();
        ConfirmDel = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        conDelBtn = new javax.swing.JButton();
        conCnlBtn = new javax.swing.JButton();
        About = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        Damaged = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        DamagedID = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        DamagedStocks = new javax.swing.JTextField();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        DamagedSize = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        DamagedPrice = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        DamagedItem = new javax.swing.JTextField();
        DmCnlbtn = new javax.swing.JButton();
        DamageEnter = new javax.swing.JButton();
        DamagedName = new javax.swing.JTextField();
        ReportsPanel = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        searchPanel1 = new javax.swing.JPanel();
        SearchBar1 = new javax.swing.JTextField();
        search1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outTable = new javax.swing.JTable();
        jLabel60 = new javax.swing.JLabel();
        TotalOutProducts = new javax.swing.JTextField();
        TotalProfit = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        Account = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        oldPasswordTextField = new javax.swing.JPasswordField();
        jLabel48 = new javax.swing.JLabel();
        newPasswordTextField = new javax.swing.JPasswordField();
        jLabel68 = new javax.swing.JLabel();
        confirmPassword = new javax.swing.JPasswordField();
        changePassword = new javax.swing.JButton();

        jPanel4.setBackground(new java.awt.Color(0, 146, 65));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Side_Menu.setBackground(new java.awt.Color(0, 146, 65));
        Side_Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/mainlogo.png"))); // NOI18N
        Side_Menu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 280));

        dashboardTab.setBackground(new java.awt.Color(0, 146, 65));
        dashboardTab.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                dashboardTabMouseDragged(evt);
            }
        });
        dashboardTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardTabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboardTabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dashboardTabMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("DASHBOARD");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/dashboardicon.png"))); // NOI18N

        javax.swing.GroupLayout dashboardTabLayout = new javax.swing.GroupLayout(dashboardTab);
        dashboardTab.setLayout(dashboardTabLayout);
        dashboardTabLayout.setHorizontalGroup(
            dashboardTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashboardTabLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        dashboardTabLayout.setVerticalGroup(
            dashboardTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardTabLayout.createSequentialGroup()
                .addGroup(dashboardTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(dashboardTabLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2)))
                .addGap(12, 12, 12))
        );

        Side_Menu.add(dashboardTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 320, 50));

        transactionTab.setBackground(new java.awt.Color(0, 146, 65));
        transactionTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionTabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transactionTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transactionTabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                transactionTabMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TRANSACTION");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/transactionicon.png"))); // NOI18N
        jLabel5.setText("jLabel3");

        javax.swing.GroupLayout transactionTabLayout = new javax.swing.GroupLayout(transactionTab);
        transactionTab.setLayout(transactionTabLayout);
        transactionTabLayout.setHorizontalGroup(
            transactionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transactionTabLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        transactionTabLayout.setVerticalGroup(
            transactionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transactionTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );

        Side_Menu.add(transactionTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 320, -1));

        inventoryTab.setBackground(new java.awt.Color(0, 146, 65));
        inventoryTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventoryTabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inventoryTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inventoryTabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                inventoryTabMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("INVENTORY");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/inventoryicon.png"))); // NOI18N
        jLabel7.setText("jLabel3");

        javax.swing.GroupLayout inventoryTabLayout = new javax.swing.GroupLayout(inventoryTab);
        inventoryTab.setLayout(inventoryTabLayout);
        inventoryTabLayout.setHorizontalGroup(
            inventoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inventoryTabLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        inventoryTabLayout.setVerticalGroup(
            inventoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inventoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6))
        );

        Side_Menu.add(inventoryTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 320, -1));

        reportsTab.setBackground(new java.awt.Color(0, 146, 65));
        reportsTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportsTabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportsTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportsTabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                reportsTabMousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("REPORTS");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/reports.png"))); // NOI18N
        jLabel9.setText("jLabel3");

        javax.swing.GroupLayout reportsTabLayout = new javax.swing.GroupLayout(reportsTab);
        reportsTab.setLayout(reportsTabLayout);
        reportsTabLayout.setHorizontalGroup(
            reportsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportsTabLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        reportsTabLayout.setVerticalGroup(
            reportsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8))
        );

        Side_Menu.add(reportsTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 320, -1));

        historyTab.setBackground(new java.awt.Color(0, 146, 65));
        historyTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                historyTabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                historyTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                historyTabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                historyTabMousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("ACCOUNT");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/history.png"))); // NOI18N
        jLabel11.setText("jLabel3");

        javax.swing.GroupLayout historyTabLayout = new javax.swing.GroupLayout(historyTab);
        historyTab.setLayout(historyTabLayout);
        historyTabLayout.setHorizontalGroup(
            historyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, historyTabLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap(147, Short.MAX_VALUE))
        );
        historyTabLayout.setVerticalGroup(
            historyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(historyTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10))
        );

        Side_Menu.add(historyTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 480, 320, -1));

        aboutTab.setBackground(new java.awt.Color(0, 146, 65));
        aboutTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aboutTabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aboutTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aboutTabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                aboutTabMousePressed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("ABOUT");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/about.png"))); // NOI18N
        jLabel13.setText("jLabel3");

        javax.swing.GroupLayout aboutTabLayout = new javax.swing.GroupLayout(aboutTab);
        aboutTab.setLayout(aboutTabLayout);
        aboutTabLayout.setHorizontalGroup(
            aboutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aboutTabLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(171, Short.MAX_VALUE))
        );
        aboutTabLayout.setVerticalGroup(
            aboutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aboutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12))
        );

        Side_Menu.add(aboutTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 320, -1));

        logOutTab.setBackground(new java.awt.Color(0, 146, 65));
        logOutTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutTabMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logOutTabMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logOutTabMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logOutTabMousePressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("LOG OUT");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/log out.png"))); // NOI18N
        jLabel15.setText("jLabel3");

        javax.swing.GroupLayout logOutTabLayout = new javax.swing.GroupLayout(logOutTab);
        logOutTab.setLayout(logOutTabLayout);
        logOutTabLayout.setHorizontalGroup(
            logOutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logOutTabLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(107, 107, 107))
        );
        logOutTabLayout.setVerticalGroup(
            logOutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logOutTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel14))
        );

        Side_Menu.add(logOutTab, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 320, -1));

        getContentPane().add(Side_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 700));

        Mainmenu.setLayout(new java.awt.CardLayout());

        Summary.setBackground(new java.awt.Color(255, 255, 255));
        Summary.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        jLabel17.setText("DASHBOARD");
        Summary.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 350, 60));

        totalItemPanel.setBackground(new java.awt.Color(0, 146, 65));
        totalItemPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 233, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Total No. of Items");
        totalItemPanel.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 233, 200, -1));

        totalItemLabel.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        totalItemLabel.setForeground(new java.awt.Color(255, 233, 0));
        totalItemLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalItemLabel.setText("0");
        totalItemPanel.add(totalItemLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 170, 188, -1));

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Items.png"))); // NOI18N
        totalItemPanel.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 163, 140));

        Summary.add(totalItemPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 200, 260));

        jPanel3.setBackground(new java.awt.Color(0, 146, 65));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Summary.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        totalProfitPanel.setBackground(new java.awt.Color(0, 146, 65));
        totalProfitPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 233, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Total Profit");
        totalProfitPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 233, 200, -1));

        totalProfitLabel.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        totalProfitLabel.setForeground(new java.awt.Color(255, 233, 0));
        totalProfitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalProfitLabel.setText("0");
        totalProfitPanel.add(totalProfitLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 170, 188, -1));

        jLabel70.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Profit (1).png"))); // NOI18N
        totalProfitPanel.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 163, 140));

        Summary.add(totalProfitPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        totalDamagedPanel.setBackground(new java.awt.Color(0, 146, 65));
        totalDamagedPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 233, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Total No. of Damaged");
        totalDamagedPanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 233, 200, -1));

        totalDamagedLabel.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        totalDamagedLabel.setForeground(new java.awt.Color(255, 233, 0));
        totalDamagedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalDamagedLabel.setText("0");
        totalDamagedPanel.add(totalDamagedLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 188, -1));

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Damage.png"))); // NOI18N
        totalDamagedPanel.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 163, 140));

        Summary.add(totalDamagedPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, -1, -1));

        Mainmenu.add(Summary, "card2");

        SearchBar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        SearchBar.setText("Search");
        SearchBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchBarMouseClicked(evt);
            }
        });
        SearchBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBarActionPerformed(evt);
            }
        });
        SearchBar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchBarKeyReleased(evt);
            }
        });

        search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N

        javax.swing.GroupLayout searchPanelLayout = new javax.swing.GroupLayout(searchPanel);
        searchPanel.setLayout(searchPanelLayout);
        searchPanelLayout.setHorizontalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanelLayout.createSequentialGroup()
                .addComponent(SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        searchPanelLayout.setVerticalGroup(
            searchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchBar)
            .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel21.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel21.setText("Total No. of Products:");

        totalNumVal.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        totalNumVal.setText("0");

        javax.swing.GroupLayout totalNumberofProductsLayout = new javax.swing.GroupLayout(totalNumberofProducts);
        totalNumberofProducts.setLayout(totalNumberofProductsLayout);
        totalNumberofProductsLayout.setHorizontalGroup(
            totalNumberofProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(totalNumberofProductsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalNumVal)
                .addContainerGap())
        );
        totalNumberofProductsLayout.setVerticalGroup(
            totalNumberofProductsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalNumberofProductsLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(totalNumVal))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, totalNumberofProductsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel21)
                .addGap(16, 16, 16))
        );

        scrollpane.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                scrollpaneAncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        scrollpane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scrollpaneMouseClicked(evt);
            }
        });

        inventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "NAME", "CATEGORY", "CAPITAL PER UNIT", "STOCKS", "SALES PER UNIT", "DAMAGE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        inventoryTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventoryTableMouseClicked(evt);
            }
        });
        scrollpane.setViewportView(inventoryTable);
        if (inventoryTable.getColumnModel().getColumnCount() > 0) {
            inventoryTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        productInfo.setBackground(new java.awt.Color(0, 146, 65));

        jLabel22.setBackground(new java.awt.Color(0, 146, 65));
        jLabel22.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("PRODUCT INFORMATION");

        javax.swing.GroupLayout productInfoLayout = new javax.swing.GroupLayout(productInfo);
        productInfo.setLayout(productInfoLayout);
        productInfoLayout.setHorizontalGroup(
            productInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(450, Short.MAX_VALUE))
        );
        productInfoLayout.setVerticalGroup(
            productInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, productInfoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(productInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, -1));

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel23.setText("Available Stocks: ");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 130, 30));

        ID.setBackground(new java.awt.Color(153, 153, 153));
        ID.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        ID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 160, 30));

        Category.setBackground(new java.awt.Color(153, 153, 153));
        Category.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        Category.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(Category, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 160, 30));

        jLabel24.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel24.setText("Category:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        Damage.setBackground(new java.awt.Color(153, 153, 153));
        Damage.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        Damage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(Damage, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 160, 30));

        jLabel25.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel25.setText("Damage:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 70, -1));

        jLabel26.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel26.setText("Item ID:");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, 30));

        Stocks.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        Stocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StocksActionPerformed(evt);
            }
        });
        Stocks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                StocksKeyReleased(evt);
            }
        });
        jPanel1.add(Stocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 150, 30));

        jLabel27.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel27.setText("Item Name:");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 100, 30));

        Name1.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        Name1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Name1KeyReleased(evt);
            }
        });
        jPanel1.add(Name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 150, 30));

        CapitalperUnit.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        CapitalperUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapitalperUnitActionPerformed(evt);
            }
        });
        CapitalperUnit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CapitalperUnitKeyReleased(evt);
            }
        });
        jPanel1.add(CapitalperUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 150, 30));

        jLabel28.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel28.setText("Capital/Unit:");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 100, 30));

        jLabel29.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        jLabel29.setText("Sales/Unit:");
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 170, 130, 30));

        Sales.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        Sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalesActionPerformed(evt);
            }
        });
        Sales.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SalesKeyReleased(evt);
            }
        });
        jPanel1.add(Sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 150, 30));

        deleteButton.setBackground(new java.awt.Color(0, 146, 65));
        deleteButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("DELETE");
        deleteButton.setEnabled(false);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 110, 30));

        addButton.setBackground(new java.awt.Color(0, 146, 65));
        addButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("ADD");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        jPanel1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 110, 30));

        editButton.setBackground(new java.awt.Color(0, 146, 65));
        editButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("EDIT");
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        jPanel1.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 110, 30));

        damageButton.setBackground(new java.awt.Color(0, 146, 65));
        damageButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        damageButton.setForeground(new java.awt.Color(255, 255, 255));
        damageButton.setText("DAMAGE");
        damageButton.setEnabled(false);
        damageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                damageButtonActionPerformed(evt);
            }
        });
        jPanel1.add(damageButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 110, 30));

        javax.swing.GroupLayout InventoryLayout = new javax.swing.GroupLayout(Inventory);
        Inventory.setLayout(InventoryLayout);
        InventoryLayout.setHorizontalGroup(
            InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InventoryLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollpane)
                    .addGroup(InventoryLayout.createSequentialGroup()
                        .addComponent(searchPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalNumberofProducts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        InventoryLayout.setVerticalGroup(
            InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventoryLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(InventoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(searchPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totalNumberofProducts, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Mainmenu.add(Inventory, "card3");

        ADDPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(0, 146, 65));

        jLabel30.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("ADD ITEM");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, -1));

        jLabel31.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel31.setText("Item ID:");
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 80, 20));

        AddID.setEditable(false);
        AddID.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel2.add(AddID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 280, 30));

        jLabel32.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel32.setText("Price per Unit:");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 130, 30));

        AddPrice.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        AddPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AddPriceKeyReleased(evt);
            }
        });
        jPanel2.add(AddPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 280, 30));

        jLabel33.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel33.setText("Item Name:");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 110, 30));

        AddSize.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        AddSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Size", "Small", "Medium", "Large" }));
        jPanel2.add(AddSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 280, 30));

        jLabel34.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel34.setText("Size:");
        jPanel2.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 110, 30));

        AddName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        AddName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AddNameKeyReleased(evt);
            }
        });
        jPanel2.add(AddName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 280, 30));

        jLabel35.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel35.setText("Capital:");
        jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 110, 30));

        AddCapital.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        AddCapital.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AddCapitalKeyReleased(evt);
            }
        });
        jPanel2.add(AddCapital, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 280, 30));

        jLabel36.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel36.setText("Stocks:");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 110, 30));

        AddStocks.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        AddStocks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                AddStocksKeyReleased(evt);
            }
        });
        jPanel2.add(AddStocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 280, 30));

        backButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        jPanel2.add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 140, 50));

        addItemButton.setBackground(new java.awt.Color(0, 146, 65));
        addItemButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        addItemButton.setForeground(new java.awt.Color(255, 255, 255));
        addItemButton.setText("Add Item");
        addItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemButtonActionPerformed(evt);
            }
        });
        jPanel2.add(addItemButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 140, 50));

        ADDPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 570, 400));

        Mainmenu.add(ADDPanel, "card4");

        EDITPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(0, 146, 65));

        jLabel37.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("EDIT ITEM");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, -1));

        jLabel38.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel38.setText("Item ID:");
        jPanel7.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 80, 20));

        EditID.setEditable(false);
        EditID.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel7.add(EditID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 280, 30));

        jLabel39.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel39.setText("Price per Unit:");
        jPanel7.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 130, 30));

        EditPrice.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel7.add(EditPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 280, 30));

        jLabel40.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel40.setText("Item Name:");
        jPanel7.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 110, 30));

        EditSize.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        EditSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Size", "Small", "Medium", "Large" }));
        jPanel7.add(EditSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 280, 30));

        jLabel41.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel41.setText("Size:");
        jPanel7.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 110, 30));

        EditName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        EditName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EditNameKeyReleased(evt);
            }
        });
        jPanel7.add(EditName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 280, 30));

        jLabel42.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel42.setText("Capital:");
        jPanel7.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 110, 30));

        EditCapital.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        EditCapital.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EditCapitalKeyReleased(evt);
            }
        });
        jPanel7.add(EditCapital, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 280, 30));

        jLabel43.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel43.setText("Stocks:");
        jPanel7.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 110, 30));

        EditStocks.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        EditStocks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                EditStocksKeyReleased(evt);
            }
        });
        jPanel7.add(EditStocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 280, 30));

        editbackButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        editbackButton.setText("Back");
        editbackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbackButtonActionPerformed(evt);
            }
        });
        jPanel7.add(editbackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 140, 50));

        EditItemButton.setBackground(new java.awt.Color(0, 146, 65));
        EditItemButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        EditItemButton.setForeground(new java.awt.Color(255, 255, 255));
        EditItemButton.setText("Edit Item");
        EditItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditItemButtonActionPerformed(evt);
            }
        });
        jPanel7.add(EditItemButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 140, 50));

        EDITPanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 570, 400));

        Mainmenu.add(EDITPanel, "card5");

        DELETEPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deleteCont.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        deleteBoxPanel.setBackground(new java.awt.Color(255, 255, 255));
        deleteBoxPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel18.setBackground(new java.awt.Color(0, 146, 65));

        jLabel49.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("DELETE ITEM");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel49)
                .addContainerGap())
        );

        deleteBoxPanel.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, -1));

        jLabel50.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel50.setText("Item ID:");
        deleteBoxPanel.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 80, 20));

        DeleteID.setEditable(false);
        DeleteID.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        DeleteID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteIDActionPerformed(evt);
            }
        });
        deleteBoxPanel.add(DeleteID, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 280, 30));

        jLabel51.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel51.setText("Price per Unit:");
        deleteBoxPanel.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 130, 30));

        DeletePrice.setEditable(false);
        DeletePrice.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        deleteBoxPanel.add(DeletePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 280, 30));

        jLabel62.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel62.setText("Item Name:");
        deleteBoxPanel.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 110, 30));

        jLabel63.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel63.setText("Size:");
        deleteBoxPanel.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 110, 30));

        DeleteSize.setEditable(false);
        DeleteSize.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        deleteBoxPanel.add(DeleteSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 280, 30));

        jLabel64.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel64.setText("Capital:");
        deleteBoxPanel.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 110, 30));

        DeleteCapital.setEditable(false);
        DeleteCapital.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        deleteBoxPanel.add(DeleteCapital, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 280, 30));

        jLabel65.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel65.setText("Stocks:");
        deleteBoxPanel.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 110, 30));

        DeleteStocks.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        DeleteStocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteStocksActionPerformed(evt);
            }
        });
        DeleteStocks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DeleteStocksKeyReleased(evt);
            }
        });
        deleteBoxPanel.add(DeleteStocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 280, 30));

        deleteBackButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        deleteBackButton.setText("Back");
        deleteBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBackButtonActionPerformed(evt);
            }
        });
        deleteBoxPanel.add(deleteBackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 140, 50));

        DeleteItemButton.setBackground(new java.awt.Color(0, 146, 65));
        DeleteItemButton.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        DeleteItemButton.setForeground(new java.awt.Color(255, 255, 255));
        DeleteItemButton.setText("Delete Item");
        DeleteItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteItemButtonActionPerformed(evt);
            }
        });
        deleteBoxPanel.add(DeleteItemButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 340, 140, 50));

        DeleteName.setEditable(false);
        DeleteName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        deleteBoxPanel.add(DeleteName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 280, 30));

        jLabel66.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel66.setText("Damage:");
        deleteBoxPanel.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 130, 30));

        DeleteDamage.setEditable(false);
        DeleteDamage.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        deleteBoxPanel.add(DeleteDamage, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 280, 30));

        deleteCont.add(deleteBoxPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 410));

        jPanel9.setBackground(new java.awt.Color(0, 146, 65));

        jLabel67.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel67.setText("Are you sure you want to delete the item?");

        conDelBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        conDelBtn.setText("Delete");
        conDelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conDelBtnActionPerformed(evt);
            }
        });

        conCnlBtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        conCnlBtn.setText("Cancel");
        conCnlBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conCnlBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(conDelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(conCnlBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel67)
                .addGap(48, 48, 48)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(conDelBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conCnlBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ConfirmDelLayout = new javax.swing.GroupLayout(ConfirmDel);
        ConfirmDel.setLayout(ConfirmDelLayout);
        ConfirmDelLayout.setHorizontalGroup(
            ConfirmDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfirmDelLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ConfirmDelLayout.setVerticalGroup(
            ConfirmDelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ConfirmDelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        deleteCont.add(ConfirmDel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 410));

        DELETEPanel.add(deleteCont, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, 410));

        Mainmenu.add(DELETEPanel, "card6");

        About.setBackground(new java.awt.Color(255, 255, 255));
        About.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel52.setBackground(new java.awt.Color(0, 146, 65));
        jLabel52.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 146, 65));
        jLabel52.setText("InventoHub");
        About.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, -1, -1));

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/About (1).png"))); // NOI18N
        About.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 470, 390));

        Mainmenu.add(About, "card7");

        Damaged.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBackground(new java.awt.Color(0, 146, 65));

        jLabel53.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel53.setText("DAMAGED ITEM");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, -1));

        jLabel54.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel54.setText("Item ID:");
        jPanel11.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 80, 20));

        DamagedID.setEditable(false);
        DamagedID.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel11.add(DamagedID, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 230, 30));

        jLabel55.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel55.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel55.setText("Price per Unit:");
        jPanel11.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 130, 30));

        DamagedStocks.setEditable(false);
        DamagedStocks.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel11.add(DamagedStocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, 230, 30));

        jLabel56.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel56.setText("Item Name:");
        jPanel11.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, 110, 30));

        jLabel57.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel57.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel57.setText("Size:");
        jPanel11.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 110, 30));

        DamagedSize.setEditable(false);
        DamagedSize.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel11.add(DamagedSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 230, 30));

        jLabel58.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel58.setText("Enter Damaged Item:");
        jPanel11.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 200, 30));

        DamagedPrice.setEditable(false);
        DamagedPrice.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel11.add(DamagedPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 230, 30));

        jLabel59.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel59.setText("Stocks:");
        jPanel11.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 110, 30));

        DamagedItem.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        DamagedItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DamagedItemMouseClicked(evt);
            }
        });
        DamagedItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DamagedItemActionPerformed(evt);
            }
        });
        DamagedItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DamagedItemKeyReleased(evt);
            }
        });
        jPanel11.add(DamagedItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 390, 30));

        DmCnlbtn.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        DmCnlbtn.setText("Cancel");
        DmCnlbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DmCnlbtnActionPerformed(evt);
            }
        });
        jPanel11.add(DmCnlbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 140, 50));

        DamageEnter.setBackground(new java.awt.Color(0, 146, 65));
        DamageEnter.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        DamageEnter.setForeground(new java.awt.Color(255, 255, 255));
        DamageEnter.setText("Enter");
        DamageEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DamageEnterActionPerformed(evt);
            }
        });
        jPanel11.add(DamageEnter, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 140, 50));

        DamagedName.setEditable(false);
        DamagedName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel11.add(DamagedName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 230, 30));

        Damaged.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 570, 440));

        Mainmenu.add(Damaged, "card8");

        ReportsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 48)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 146, 65));
        jLabel16.setText("STOCK OUT");
        ReportsPanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        SearchBar1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        SearchBar1.setText("Search");
        SearchBar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchBar1MouseClicked(evt);
            }
        });
        SearchBar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchBar1ActionPerformed(evt);
            }
        });
        SearchBar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchBar1KeyReleased(evt);
            }
        });

        search1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N

        javax.swing.GroupLayout searchPanel1Layout = new javax.swing.GroupLayout(searchPanel1);
        searchPanel1.setLayout(searchPanel1Layout);
        searchPanel1Layout.setHorizontalGroup(
            searchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanel1Layout.createSequentialGroup()
                .addComponent(SearchBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        searchPanel1Layout.setVerticalGroup(
            searchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchBar1)
            .addComponent(search1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        ReportsPanel.add(searchPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        outTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Item Name", "Size", "Quantity", "Price", "Total", "Profit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(outTable);

        ReportsPanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 670, 320));

        jLabel60.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel60.setText("Total Products:");
        ReportsPanel.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, -1, 40));

        TotalOutProducts.setEditable(false);
        TotalOutProducts.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        ReportsPanel.add(TotalOutProducts, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 530, 240, 40));

        TotalProfit.setEditable(false);
        TotalProfit.setFont(new java.awt.Font("Verdana", 0, 24)); // NOI18N
        ReportsPanel.add(TotalProfit, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 580, 240, 40));

        jLabel61.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel61.setText("Total Profit:");
        ReportsPanel.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 580, -1, 40));

        Mainmenu.add(ReportsPanel, "card9");

        Account.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 146, 65));
        jLabel45.setText("My Account");
        Account.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, 42));

        jLabel46.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 146, 65));
        jLabel46.setText("Username");
        Account.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, -1, -1));

        usernameTextField.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });
        Account.add(usernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 312, 40));

        jLabel47.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(0, 146, 65));
        jLabel47.setText("Old Password");
        Account.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, -1, -1));

        oldPasswordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldPasswordTextFieldActionPerformed(evt);
            }
        });
        Account.add(oldPasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 310, 40));

        jLabel48.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 146, 65));
        jLabel48.setText("New Password");
        Account.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 140, 44));

        newPasswordTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newPasswordTextFieldActionPerformed(evt);
            }
        });
        Account.add(newPasswordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 310, 40));

        jLabel68.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(0, 146, 65));
        jLabel68.setText("Confirm Password");
        Account.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 172, 44));

        confirmPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmPasswordActionPerformed(evt);
            }
        });
        Account.add(confirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, 312, 40));

        changePassword.setBackground(new java.awt.Color(0, 146, 65));
        changePassword.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        changePassword.setForeground(new java.awt.Color(255, 255, 255));
        changePassword.setText("Change Password");
        changePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordActionPerformed(evt);
            }
        });
        Account.add(changePassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 480, -1, 50));

        Mainmenu.add(Account, "card10");

        getContentPane().add(Mainmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 0, 690, 700));

        setSize(new java.awt.Dimension(1023, 725));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardTabMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardTabMouseDragged
        
    }//GEN-LAST:event_dashboardTabMouseDragged

    private void dashboardTabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardTabMousePressed
        dashboardTab.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_dashboardTabMousePressed

    private void dashboardTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardTabMouseEntered
        dashboardTab.setBackground(new java.awt.Color(255,233,0));
    }//GEN-LAST:event_dashboardTabMouseEntered

    private void dashboardTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardTabMouseExited
        dashboardTab.setBackground(new java.awt.Color(0, 146, 65));
    }//GEN-LAST:event_dashboardTabMouseExited

    private void scrollpaneAncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_scrollpaneAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_scrollpaneAncestorMoved

    private void StocksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StocksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StocksActionPerformed

    private void SalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SalesActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(DELETEPanel);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(ADDPanel);
        Mainmenu.repaint();
        Mainmenu.revalidate();
        backButton.setEnabled(false);
        
        int num = randomNum();
        AddID.setText(Integer.toString(num));
        
        if (ID.getText().equals("")){
            AddName.setText(Name1.getText());
            AddCapital.setText(CapitalperUnit.getText());
            AddStocks.setText(Stocks.getText());
            AddPrice.setText(Sales.getText());
        }else{
        AddName.setText("");
        AddCapital.setText("");
        AddStocks.setText("");
        AddPrice.setText(""); 
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(EDITPanel);
        Mainmenu.repaint();
        Mainmenu.revalidate();
        editbackButton.setEnabled(false);
    }//GEN-LAST:event_editButtonActionPerformed

    private void damageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_damageButtonActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Damaged);
        Mainmenu.repaint();
        Mainmenu.revalidate();
        DamageEnter.setEnabled(false);
    }//GEN-LAST:event_damageButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Inventory);
        Mainmenu.repaint();
        Mainmenu.revalidate();
        clear_text();
    }//GEN-LAST:event_backButtonActionPerformed

    private void addItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemButtonActionPerformed
       
        
        if (AddName.getText().isEmpty() || AddCapital.getText().isEmpty() || AddStocks.getText().isEmpty() || AddPrice.getText().isEmpty()) { 
            JOptionPane.showMessageDialog(null, "Please enter all necessary fields!");  
        }else{
    
        String cate="";

            if ("Small".equals(AddSize.getSelectedItem().toString())){
                   cate = "Small";
                    addItemButton.setEnabled(true);
                }else if ("Medium".equals(AddSize.getSelectedItem().toString())){
                    cate = "Medium";
                     addItemButton.setEnabled(true);
                }else if ("Large".equals(AddSize.getSelectedItem().toString())){
                    cate = "Large";
                     addItemButton.setEnabled(true);
                }else {
                      addItemButton.setEnabled(false);
                }
            
        String addID = AddID.getText();
            String addName = AddName.getText();
            String addCap = AddCapital.getText();
            String addStocks = AddStocks.getText();
            String addSales = AddPrice.getText();
            float capital = Float.parseFloat(addCap);
            float sales = Float.parseFloat(addSales);

            if (capital > sales){
                JOptionPane.showMessageDialog(null, "Sales Price must be higher than Capital");  
                return;  
            }

                try {
                    Add add = new Add(addID,addName,cate,addCap,addStocks,addSales);
                } catch (IOException ex) {
                    Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
                }

            Mainmenu.removeAll();
            Mainmenu.repaint();
            Mainmenu.revalidate();
            Mainmenu.add(Inventory);
            Mainmenu.repaint();
            Mainmenu.revalidate();
            refresh_table();
            clear_text();
            editButton.setEnabled(false);
            damageButton.setEnabled(false);
            deleteButton.setEnabled(false);

    }
    }//GEN-LAST:event_addItemButtonActionPerformed

    private void editbackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbackButtonActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Inventory);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_editbackButtonActionPerformed

    private void EditItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditItemButtonActionPerformed
        String categ = "";
        if ("Small".equals(EditSize.getSelectedItem().toString())){
                   categ = "Small";
                    EditItemButton.setEnabled(true);
                }else if ("Medium".equals(EditSize.getSelectedItem().toString())){
                    categ = "Medium";
                     EditItemButton.setEnabled(true);
                }else if ("Large".equals(EditSize.getSelectedItem().toString())){
                    categ = "Large";
                     EditItemButton.setEnabled(true);
                }else {
                      EditItemButton.setEnabled(false);
                }
        
        float capital = Float.parseFloat(EditCapital.getText());
        float sales = Float.parseFloat(EditPrice.getText());

       if (capital > sales){
                JOptionPane.showMessageDialog(null, "Sales Price must be higher than Capital");  
                return;  
       }
       int row = inventoryTable.getSelectedRow();
       String id, name, price, quan, cap,damage;          // gets the input(s) from each of the textfields
        id = EditID.getText();
        name = EditName.getText();
        cap = EditCapital.getText();
        price = EditPrice.getText();
        quan = EditStocks.getText();
       damage = Damage.getText();
       
       if(row >= 0) {                         
           inventoryTable.getModel().setValueAt(id, row, 0);     // sets the 
           inventoryTable.getModel().setValueAt(name, row, 0); 
           inventoryTable.getModel().setValueAt(categ, row, 0); 
           inventoryTable.getModel().setValueAt(cap, row, 0);
           inventoryTable.getModel().setValueAt(quan, row, 0); 
           inventoryTable.getModel().setValueAt(price, row, 0); 
           inventoryTable.getModel().setValueAt(damage, row, 0); 
        }
       Edit edit = new Edit(id, name, categ, cap, quan,price,damage, row);
//            try {
//                String pathDB = System.getProperty("user.dir") + "\\src\\DB\\Data.txt";
//                File f = new File(pathDB);
//                String rtemp = Edit_Id.getText();
//                Scanner read = new Scanner(f);
//                
//                String temp1 = "";
//                String store = "";
//                String store1 = "";
//                
//                while (!temp1.startsWith(rtemp)) {
//                    temp1 = read.nextLine();
//                    if (!temp1.startsWith(rtemp)) {
//                        store += temp1 + "\n";
//                    }
//                }
//                while (read.hasNextLine()) {
//                    store1 += read.nextLine() + "\n";
//                }
//                
//                
//                
//                
//                String data = (Edit_Id.getText() + "," +EditName.getText() +","+categ+","+EditCapital.getText()+","+EditStocks.getText()+","+EditPrice.getText()+","+Damage.getText()+"\n");
//                FileWriter output;
//                output = new FileWriter(f);
//                output.write(store);
//                output.write(data);
//                output.write(store1);
//                output.close();
//
//
//
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
//            } 
//        catch (IOException ex) {
//            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
//        }
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Inventory);
        Mainmenu.repaint();
        Mainmenu.revalidate();
        refresh_table();
        clear_text();
        editButton.setEnabled(false);
        damageButton.setEnabled(false);
        deleteButton.setEnabled(false);
    }//GEN-LAST:event_EditItemButtonActionPerformed

    private void DmCnlbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DmCnlbtnActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Inventory);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_DmCnlbtnActionPerformed

    private void DamageEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DamageEnterActionPerformed
        float d = Float.parseFloat(DamagedItem.getText());
        float q = Float.parseFloat(Stocks.getText());
        float newQ = q - d ;
        //Double rounded = Math.round(newQ * 1000)/1000.0;
        //if (rounded >= 0){
            
        DefaultTableModel model2;
        model2 = (DefaultTableModel) inventoryTable.getModel();
        
        for (int i = 0; i < inventoryTable.getRowCount();i++){
               String codeID = inventoryTable.getModel().getValueAt(i, 0).toString();
               if (codeID.startsWith(DamagedID.getText()) ){
                   String id = (inventoryTable.getModel().getValueAt(i, 0)).toString();
                   String namee = (inventoryTable.getModel().getValueAt(i, 1).toString());
                   String cate = (inventoryTable.getModel().getValueAt(i, 2).toString());
                   String capt = (inventoryTable.getModel().getValueAt(i, 3).toString());
                   String quant = (inventoryTable.getModel().getValueAt(i, 4).toString());
                   String pricee = (inventoryTable.getModel().getValueAt(i, 5).toString());
                   String damage = (inventoryTable.getModel().getValueAt(i, 6).toString());
                   String newDamage = Float.toString(d + Float.parseFloat(damage) );
                   String newQuant = Float.toString(Float.parseFloat(quant)- d);
                   Edit edit = new Edit (id,namee,cate,capt,newQuant,pricee,newDamage,i);


               }
            }

        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Inventory);
        Mainmenu.repaint();
        Mainmenu.revalidate();
        refresh_table();
        clear_text();
        editButton.setEnabled(false);
        damageButton.setEnabled(false);
        deleteButton.setEnabled(false);
    
        //else{
        //JOptionPane.showMessageDialog(this, "Enter a valid Number",
                                   //"Invalid Input", JOptionPane.ERROR_MESSAGE);       
    //}
                                             

    }//GEN-LAST:event_DamageEnterActionPerformed

    private void inventoryTabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryTabMousePressed
        inventoryTab.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_inventoryTabMousePressed

    private void inventoryTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryTabMouseEntered
        inventoryTab.setBackground(new java.awt.Color(255,233,0));
    }//GEN-LAST:event_inventoryTabMouseEntered

    private void inventoryTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryTabMouseExited
        inventoryTab.setBackground(new java.awt.Color(0, 146, 65));
    }//GEN-LAST:event_inventoryTabMouseExited

    private void transactionTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionTabMouseEntered
        transactionTab.setBackground(new java.awt.Color(255,233,0));
    }//GEN-LAST:event_transactionTabMouseEntered

    private void transactionTabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionTabMousePressed
        transactionTab.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_transactionTabMousePressed

    private void transactionTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionTabMouseExited
        transactionTab.setBackground(new java.awt.Color(0, 146, 65));
    }//GEN-LAST:event_transactionTabMouseExited

    private void reportsTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsTabMouseEntered
        reportsTab.setBackground(new java.awt.Color(255,233,0));
    }//GEN-LAST:event_reportsTabMouseEntered

    private void reportsTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsTabMouseExited
        reportsTab.setBackground(new java.awt.Color(0, 146, 65));
    }//GEN-LAST:event_reportsTabMouseExited

    private void reportsTabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsTabMousePressed
        reportsTab.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_reportsTabMousePressed

    private void historyTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyTabMouseEntered
        historyTab.setBackground(new java.awt.Color(255,233,0));
    }//GEN-LAST:event_historyTabMouseEntered

    private void historyTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyTabMouseExited
        historyTab.setBackground(new java.awt.Color(0, 146, 65));
    }//GEN-LAST:event_historyTabMouseExited

    private void historyTabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyTabMousePressed
        historyTab.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_historyTabMousePressed

    private void aboutTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutTabMouseEntered
        aboutTab.setBackground(new java.awt.Color(255,233,0));
    }//GEN-LAST:event_aboutTabMouseEntered

    private void aboutTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutTabMouseExited
        aboutTab.setBackground(new java.awt.Color(0, 146, 65));
    }//GEN-LAST:event_aboutTabMouseExited

    private void aboutTabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutTabMousePressed
        aboutTab.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_aboutTabMousePressed

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseEntered

    private void logOutTabMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutTabMouseEntered
        logOutTab.setBackground(new java.awt.Color(255,233,0));
    }//GEN-LAST:event_logOutTabMouseEntered

    private void logOutTabMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutTabMouseExited
        logOutTab.setBackground(new java.awt.Color(0, 146, 65));
    }//GEN-LAST:event_logOutTabMouseExited

    private void logOutTabMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutTabMousePressed
        logOutTab.setBackground(new java.awt.Color(102,102,102));
    }//GEN-LAST:event_logOutTabMousePressed

    private void inventoryTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryTabMouseClicked
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Inventory);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_inventoryTabMouseClicked

    private void dashboardTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardTabMouseClicked
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Summary);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_dashboardTabMouseClicked

    private void transactionTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionTabMouseClicked
        new POS().setVisible(true);
        dispose();
    }//GEN-LAST:event_transactionTabMouseClicked

    private void reportsTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsTabMouseClicked
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(ReportsPanel);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_reportsTabMouseClicked

    private void aboutTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aboutTabMouseClicked
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(About);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_aboutTabMouseClicked

    private void deleteBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBackButtonActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Inventory);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_deleteBackButtonActionPerformed

    private void DeleteItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteItemButtonActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(ConfirmDel);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_DeleteItemButtonActionPerformed

    private void conDelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conDelBtnActionPerformed
        try {
                String pathDB = "src/Database/Inventory.txt";
                File f = new File(pathDB);
                String rtemp = ID.getText();
                Scanner read = new Scanner(f);
                
                String temp1 = "";
                String store = "";
                String store1 = "";
                
                while (!temp1.startsWith(rtemp)) {
                    temp1 = read.nextLine();
                    if (!temp1.startsWith(rtemp)) {
                        store += temp1 + "\n";
                    }
                }
                while (read.hasNextLine()) {
                    store1 += read.nextLine() + "\n";
                }
                FileWriter output;
                output = new FileWriter(f);
                output.write(store);
                output.write(store1);
                output.close();



            } catch (FileNotFoundException ex) {
                Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
            } 
        catch (IOException ex) {
            Logger.getLogger(Product.class.getName()).log(Level.SEVERE, null, ex);
        }
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Inventory);
        Mainmenu.repaint();
        Mainmenu.revalidate();
        refresh_table();
        clear_text();
        editButton.setEnabled(false);
        damageButton.setEnabled(false);
        deleteButton.setEnabled(false);
                                         
    }//GEN-LAST:event_conDelBtnActionPerformed

    private void conCnlBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conCnlBtnActionPerformed
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(DELETEPanel);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_conCnlBtnActionPerformed

    private void SearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBarActionPerformed
        refresh_table();
    }//GEN-LAST:event_SearchBarActionPerformed

    private void scrollpaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrollpaneMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_scrollpaneMouseClicked

    private void inventoryTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryTableMouseClicked
        int row = inventoryTable.getSelectedRow();
        ID.setText(inventoryTable.getModel().getValueAt(row,0).toString());
        Name1.setText(inventoryTable.getModel().getValueAt(row,1).toString());
        Category.setText(inventoryTable.getModel().getValueAt(row,2).toString());
        CapitalperUnit.setText(inventoryTable.getModel().getValueAt(row,3).toString());
        Stocks.setText(inventoryTable.getModel().getValueAt(row,4).toString());
        Sales.setText(inventoryTable.getModel().getValueAt(row,5).toString());
        Damage.setText(inventoryTable.getModel().getValueAt(row,6).toString());
       
        EditID.setText(inventoryTable.getModel().getValueAt(row,0).toString());
        EditName.setText(inventoryTable.getModel().getValueAt(row,1).toString());
        
        EditCapital.setText(inventoryTable.getModel().getValueAt(row,3).toString());
        EditStocks.setText(inventoryTable.getModel().getValueAt(row,4).toString());
        EditPrice.setText(inventoryTable.getModel().getValueAt(row,5).toString());
        
        DeleteID.setText(inventoryTable.getModel().getValueAt(row,0).toString());
        DeleteName.setText(inventoryTable.getModel().getValueAt(row,1).toString());
        DeleteSize.setText(inventoryTable.getModel().getValueAt(row,2).toString());
        DeletePrice.setText(inventoryTable.getModel().getValueAt(row,3).toString());
        DeleteCapital.setText(inventoryTable.getModel().getValueAt(row,4).toString());
        DeleteStocks.setText(inventoryTable.getModel().getValueAt(row,5).toString());
        DeleteDamage.setText(inventoryTable.getModel().getValueAt(row,6).toString());
        
        DamagedID.setText(inventoryTable.getModel().getValueAt(row,0).toString());
        DamagedName.setText(inventoryTable.getModel().getValueAt(row,1).toString());
        DamagedSize.setText(inventoryTable.getModel().getValueAt(row,2).toString());
        DamagedPrice.setText(inventoryTable.getModel().getValueAt(row,3).toString());
        DamagedStocks.setText(inventoryTable.getModel().getValueAt(row,4).toString());
        
   
    editButton.setEnabled(true);
    damageButton.setEnabled(true);
    deleteButton.setEnabled(true);
    }//GEN-LAST:event_inventoryTableMouseClicked

    private void CapitalperUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapitalperUnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CapitalperUnitActionPerformed

    private void DeleteIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteIDActionPerformed

    private void SearchBarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBarKeyReleased
        search_name(SearchBar.getText());
        clear_text();
    }//GEN-LAST:event_SearchBarKeyReleased

    private void SearchBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchBarMouseClicked
        SearchBar.setText("");
    }//GEN-LAST:event_SearchBarMouseClicked

    private void Name1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Name1KeyReleased
        String none = "";
        if(( Name1.getText().equals(none)) && (CapitalperUnit.getText().equals(none)) && (Stocks.getText().equals(none)) && (Sales.getText().equals(none))){
           addButton.setEnabled(false);
        }else{
          addButton.setEnabled(true);  
        }
    }//GEN-LAST:event_Name1KeyReleased

    private void CapitalperUnitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CapitalperUnitKeyReleased
        String none = "";
        if(( Name1.getText().equals(none)) && (CapitalperUnit.getText().equals(none)) && (Stocks.getText().equals(none)) && (Sales.getText().equals(none))){
           addButton.setEnabled(false);
        }else{
          addButton.setEnabled(true);  
        }
    }//GEN-LAST:event_CapitalperUnitKeyReleased

    private void StocksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_StocksKeyReleased
        String none = "";
        if(( Name1.getText().equals(none)) && (CapitalperUnit.getText().equals(none)) && (Stocks.getText().equals(none)) && (Sales.getText().equals(none))){
           addButton.setEnabled(false);
        }else{
          addButton.setEnabled(true);  
        }
    }//GEN-LAST:event_StocksKeyReleased

    private void SalesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SalesKeyReleased
        String none = "";
        if(( Name1.getText().equals(none)) && (CapitalperUnit.getText().equals(none)) && (Stocks.getText().equals(none)) && (Sales.getText().equals(none))){
           addButton.setEnabled(false);
        }else{
          addButton.setEnabled(true);  
        }
    }//GEN-LAST:event_SalesKeyReleased

    private void AddNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddNameKeyReleased
        if (!AddName.getText().isEmpty()){
        int u = check_U(AddName.getText());
            System.out.println(u);
        if (u !=0){
            String[] options = { "Back to Inventory","Input New Product"};
            var choice = JOptionPane.showOptionDialog(null, "Product is already in the list!", "Error", 
                                                              0, 2, null, options, options[0]);
            if (choice == 0) {
                Mainmenu.removeAll();
                Mainmenu.repaint();
                Mainmenu.revalidate();
                Mainmenu.add(Inventory);
                Mainmenu.repaint();
                Mainmenu.revalidate();
                refresh_table();
                clear_text();
                editButton.setEnabled(false);
                damageButton.setEnabled(false);
                deleteButton.setEnabled(false);
            }
            if (choice == 1) {
              AddName.setText("");
              AddCapital.setText("");
              AddStocks.setText("");
              AddPrice.setText("");
              AddSize.setSelectedItem("Select Size");
            }

        }
    }
    }//GEN-LAST:event_AddNameKeyReleased

    private void AddPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddPriceKeyReleased
        if (!AddPrice.getText().isEmpty()){
            
        float fvalue;
            try {
                fvalue = Float.parseFloat(AddPrice.getText());  
            } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Plese input the Sales Price of Product"); 
            AddPrice.setText("");
            return;
            }
         
    }  
    }//GEN-LAST:event_AddPriceKeyReleased

    private void AddStocksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddStocksKeyReleased
        if (!AddStocks.getText().isEmpty()){
        String addStocks = AddStocks.getText();
        try{
        float stocks = Float.parseFloat(addStocks);
        if ((stocks ) > 10000){
                JOptionPane.showMessageDialog(null, "Insufficient Storage!");
                AddStocks.setText("");
                return;
            }
        }
         catch (NumberFormatException b) {
                JOptionPane.showMessageDialog(null, "Plese input the Number of Stocks in Kilo"); 
                AddStocks.setText("");
                return;
        }
    }
    }//GEN-LAST:event_AddStocksKeyReleased

    private void AddCapitalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AddCapitalKeyReleased
        if (!AddCapital.getText().isEmpty()){
            
        float fvalue;
            try {
                fvalue = Float.parseFloat(AddCapital.getText());  
            } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Plese input the Capital Price of Product"); 
            AddCapital.setText("");
            return;
            }
         
        }    
    }//GEN-LAST:event_AddCapitalKeyReleased

    private void EditNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EditNameKeyReleased
        if (!EditName.getText().isEmpty()){
        int u = check_U(EditName.getText());
            System.out.println(u);
        if (u !=0){
            String[] options = { "Back to Inventory","Input New Product"};
            var choice = JOptionPane.showOptionDialog(null, "Product is already in the list!", "Error", 
                                                              0, 2, null, options, options[0]);
            if (choice == 0) {
                Mainmenu.removeAll();
                Mainmenu.repaint();
                Mainmenu.revalidate();
                Mainmenu.add(Inventory);
                Mainmenu.repaint();
                Mainmenu.revalidate();
                refresh_table();
                clear_text();
                editButton.setEnabled(false);
                damageButton.setEnabled(false);
                deleteButton.setEnabled(false);
            }
            if (choice == 1) {
              EditName.setText("");
              
            }

        }
    }
    }//GEN-LAST:event_EditNameKeyReleased

    private void EditCapitalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EditCapitalKeyReleased
        if (!EditCapital.getText().isEmpty()){
            
        float fvalue;
            try {
                fvalue = Float.parseFloat(EditCapital.getText());  
            } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Plese input the Capital Price of Product"); 
            EditCapital.setText("");
            return;
            }
         
        }
    }//GEN-LAST:event_EditCapitalKeyReleased

    private void EditStocksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_EditStocksKeyReleased
        if (!EditStocks.getText().isEmpty()){
        String addStocks = EditStocks.getText();
        try{
        float stocks = Float.parseFloat(addStocks);
        if ((stocks ) > 10000){
                JOptionPane.showMessageDialog(null, "Insufficient Storage!");
                EditStocks.setText("");
                return;
            }
        }
         catch (NumberFormatException b) {
                JOptionPane.showMessageDialog(null, "Plese input the Number of Stocks in Kilo"); 
                EditStocks.setText("");
                return;
        }
    }
    }//GEN-LAST:event_EditStocksKeyReleased

    private void DamagedItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DamagedItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DamagedItemActionPerformed

    private void DamagedItemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DamagedItemKeyReleased
        if (DamagedItem.getText().isEmpty()){
           DamageEnter.setEnabled(false);
    }else{
        float fvalue;
            try {
                fvalue = Float.parseFloat(DamagedItem.getText());  
            } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Plese input the number of damage in kilo"); 
            DamagedItem.setText("");
            return;
            }
            
        float stocks = Float.parseFloat(DamagedStocks.getText());
        float dm = Float.parseFloat(DamagedItem.getText());
        if (stocks < dm){
            JOptionPane.showMessageDialog(null, "Invalid Input");
            DamagedItem.setText("");
            return;
        }
        else{
            DamageEnter.setEnabled(true);
        }
    }
    }//GEN-LAST:event_DamagedItemKeyReleased

    private void DamagedItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DamagedItemMouseClicked
        DamagedItem.setText("");
    }//GEN-LAST:event_DamagedItemMouseClicked

    private void SearchBar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchBar1ActionPerformed

    private void SearchBar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchBar1MouseClicked
        SearchBar1.setText("");
    }//GEN-LAST:event_SearchBar1MouseClicked

    private void SearchBar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchBar1KeyReleased
        DefaultTableModel table = (DefaultTableModel)outTable.getModel();
        String search = SearchBar1.getText();

        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(table);
        outTable.setRowSorter(tr);
    
        tr.setRowFilter(RowFilter.regexFilter(search));
    }//GEN-LAST:event_SearchBar1KeyReleased

    private void DeleteStocksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteStocksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteStocksActionPerformed

    private void DeleteStocksKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DeleteStocksKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_DeleteStocksKeyReleased

    private void historyTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_historyTabMouseClicked
        Mainmenu.removeAll();
        Mainmenu.repaint();
        Mainmenu.revalidate();
        Mainmenu.add(Account);
        Mainmenu.repaint();
        Mainmenu.revalidate();
    }//GEN-LAST:event_historyTabMouseClicked

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void oldPasswordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldPasswordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldPasswordTextFieldActionPerformed

    private void newPasswordTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newPasswordTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newPasswordTextFieldActionPerformed

    private void confirmPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmPasswordActionPerformed

    private void changePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordActionPerformed
        String username = usernameTextField.getText ();
        String oldPass = oldPasswordTextField.getText ();
        String newPass = newPasswordTextField.getText ();
        String confirmPass = confirmPassword.getText ();

        if (oldPass.equals(newPass)) {
            JOptionPane.showMessageDialog (null, "Error: Your new password must be different from your previous password.");
        }
        else if (newPass.equals("")) {
            JOptionPane.showMessageDialog (null, "Password cannot be empty");
        }
        else if (newPass.length()<8) {
            JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long");
        }
        else if (confirmPass.equals("")) {
            JOptionPane.showMessageDialog (null, "Password cannot be empty");
        }
        else if (newPass.equals(confirmPass)== false){
            JOptionPane.showMessageDialog(null, "Error: Password confirmation failed. Make sure the passwords in both fields are identical.");
        }
        else {
            try{
                File account = new File("src/Database/Accounts.txt");
                account.createNewFile();

                FileWriter writer = new FileWriter("src/Database/Accounts.txt");
                writer.write(usernameTextField.getText()+"\n");
                writer.write(newPasswordTextField.getPassword());
                writer.close();
                JOptionPane.showMessageDialog(null, "Password changed.");

                oldPasswordTextField.setText("");
                newPasswordTextField.setText ("");
                confirmPassword.setText("");

            }catch(IOException e){
                JOptionPane.showMessageDialog(null, "There were troubles changing your password.");
            }
        }
    }//GEN-LAST:event_changePasswordActionPerformed

    private void logOutTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutTabMouseClicked
        new LoginAccount().setVisible(true);
        dispose();
    }//GEN-LAST:event_logOutTabMouseClicked

    private void clear_text(){
        ID.setText("");
        Name1.setText("");
        Category.setText("");
        CapitalperUnit.setText("");
        Stocks.setText("");
        Sales.setText("");
        Damage.setText("");
    
        AddID.setText("");
        AddName.setText("");
        AddSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Small", "Medium", "Large" }));
        AddCapital.setText("");
        AddStocks.setText("");
        AddPrice.setText("");
    
        EditID.setText("");
        EditName.setText("");
        EditSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Category", "Small", "Medium", "Large" }));
        EditCapital.setText("");
        EditStocks.setText("");
        EditPrice.setText("");
    
        DeleteID.setText("");
        DeleteName.setText("");
        DeleteSize.setText("");
        DeleteCapital.setText("");
        DeleteStocks.setText("");
        DeletePrice.setText("");
        DeleteDamage.setText("");
    
        DamagedID.setText("");
        DamagedName.setText("");
        DamagedSize.setText("");
        DamagedPrice.setText("");
        DamagedStocks.setText("");
        DamagedItem.setText("");
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
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Product.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Product().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ADDPanel;
    private javax.swing.JPanel About;
    private javax.swing.JPanel Account;
    private javax.swing.JTextField AddCapital;
    private javax.swing.JTextField AddID;
    private javax.swing.JTextField AddName;
    private javax.swing.JTextField AddPrice;
    private javax.swing.JComboBox<String> AddSize;
    private javax.swing.JTextField AddStocks;
    private javax.swing.JTextField CapitalperUnit;
    private javax.swing.JLabel Category;
    private javax.swing.JPanel ConfirmDel;
    private javax.swing.JPanel DELETEPanel;
    private javax.swing.JLabel Damage;
    private javax.swing.JButton DamageEnter;
    private javax.swing.JPanel Damaged;
    private javax.swing.JTextField DamagedID;
    private javax.swing.JTextField DamagedItem;
    private javax.swing.JTextField DamagedName;
    private javax.swing.JTextField DamagedPrice;
    private javax.swing.JTextField DamagedSize;
    private javax.swing.JTextField DamagedStocks;
    private javax.swing.JTextField DeleteCapital;
    private javax.swing.JTextField DeleteDamage;
    private javax.swing.JTextField DeleteID;
    private javax.swing.JButton DeleteItemButton;
    private javax.swing.JTextField DeleteName;
    private javax.swing.JTextField DeletePrice;
    private javax.swing.JTextField DeleteSize;
    private javax.swing.JTextField DeleteStocks;
    private javax.swing.JButton DmCnlbtn;
    private javax.swing.JPanel EDITPanel;
    private javax.swing.JTextField EditCapital;
    private javax.swing.JTextField EditID;
    private javax.swing.JButton EditItemButton;
    private javax.swing.JTextField EditName;
    private javax.swing.JTextField EditPrice;
    private javax.swing.JComboBox<String> EditSize;
    private javax.swing.JTextField EditStocks;
    private javax.swing.JLabel ID;
    private javax.swing.JPanel Inventory;
    private javax.swing.JPanel Mainmenu;
    private javax.swing.JTextField Name1;
    private javax.swing.JPanel ReportsPanel;
    private javax.swing.JTextField Sales;
    private javax.swing.JTextField SearchBar;
    private javax.swing.JTextField SearchBar1;
    private javax.swing.JPanel Side_Menu;
    private javax.swing.JTextField Stocks;
    private javax.swing.JPanel Summary;
    private javax.swing.JTextField TotalOutProducts;
    private javax.swing.JTextField TotalProfit;
    private javax.swing.JPanel aboutTab;
    private javax.swing.JButton addButton;
    private javax.swing.JButton addItemButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton changePassword;
    private javax.swing.JButton conCnlBtn;
    private javax.swing.JButton conDelBtn;
    private javax.swing.JPasswordField confirmPassword;
    private javax.swing.JButton damageButton;
    private javax.swing.JPanel dashboardTab;
    private javax.swing.JButton deleteBackButton;
    private javax.swing.JPanel deleteBoxPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JPanel deleteCont;
    private javax.swing.JButton editButton;
    private javax.swing.JButton editbackButton;
    private javax.swing.JPanel historyTab;
    private javax.swing.JPanel inventoryTab;
    private javax.swing.JTable inventoryTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel logOutTab;
    private javax.swing.JPasswordField newPasswordTextField;
    private javax.swing.JPasswordField oldPasswordTextField;
    private javax.swing.JTable outTable;
    private javax.swing.JPanel productInfo;
    private javax.swing.JPanel reportsTab;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JLabel search;
    private javax.swing.JLabel search1;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JPanel searchPanel1;
    private javax.swing.JLabel totalDamagedLabel;
    private javax.swing.JPanel totalDamagedPanel;
    private javax.swing.JLabel totalItemLabel;
    private javax.swing.JPanel totalItemPanel;
    private javax.swing.JLabel totalNumVal;
    private javax.swing.JPanel totalNumberofProducts;
    private javax.swing.JLabel totalProfitLabel;
    private javax.swing.JPanel totalProfitPanel;
    private javax.swing.JPanel transactionTab;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
