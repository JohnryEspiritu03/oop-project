package Main;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class POS extends javax.swing.JFrame {

    public POS() {
        initComponents();
        refresh_table();
    }
    
    private void refresh_table(){
    DefaultTableModel model;
    model = (DefaultTableModel) InvTable.getModel();
    model.setRowCount(0);
    int num_prod = 0; 
    try {
        String path = System.getProperty("user.dir") + "\\src\\DataBase\\Inventory.txt";
        File products = new File(path);
        Scanner dataIn = new Scanner(products);


        while(dataIn.hasNext()) {
            String[] data = dataIn.nextLine().split(",");
            num_prod++;
            model.addRow(data);
        } 
    } catch (FileNotFoundException ex) {

    } 
       numProd.setText(Integer.toString(num_prod));
    }
    
    private void dataTo_file(){
    
    String capt = "";
    DefaultTableModel model2;
    model2 = (DefaultTableModel) InvTable.getModel();
    float newProfit = 0;
    String categ = "";
    System.out.println("table"+ table.getRowCount());
    for ( int row = 0; row < table.getRowCount(); row++){
               String ItemCode = table.getModel().getValueAt(row,0).toString();
               String ItemName = table.getModel().getValueAt(row,1).toString();
               String Quantity = table.getModel().getValueAt(row,2).toString();
               String Price = table.getModel().getValueAt(row,3).toString(); 
               String Total = table.getModel().getValueAt(row,4).toString();
               
        
        for (int i = 0; i < InvTable.getRowCount();i++){
           String codeID = InvTable.getModel().getValueAt(i, 0).toString();
           if (codeID.startsWith(ItemCode) ){ 
               capt = (InvTable.getModel().getValueAt(i, 3).toString());
               categ = (InvTable.getModel().getValueAt(i, 2).toString());
            

           }
        }
        newProfit = Float.parseFloat(Total) - (Float.parseFloat(Quantity)* Float.parseFloat(capt));
        Double roundProfit = Math.round(newProfit * 1000)/1000.0;
        String profit = Double.toString(roundProfit);
        try {        
            Transaction transac = new Transaction(ItemCode,ItemName,categ,Quantity,Price,Total,profit);
        } catch (IOException ex) {
            Logger.getLogger(Transaction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    public void getAllDataTo_Print() {
    //Date
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate = DateFor.format(date);
        //Time
        DateFormat TimeFormat = new SimpleDateFormat("hh:mm a");
    	String TimeString = TimeFormat.format(new Date()).toString();
    
    int count = 0;
    printTextArea.setFont(new Font("Monospaced",Font.PLAIN,12));
    printTextArea.setText("    ---------------------------------------------------------\n"
                + "                            INVENTOHUB                         \n"
                + "                      Bicol University-Main                   \n"
                + "                          LEGAZPI ALBAY                       \n"
                + "                     www.facebook.com/INVENTOHUB\n"
                + "    ---------------------------------------------------------\n"
                + "    Date:"+stringDate+"                      Time:"+TimeString+"\n"
                + "    ---------------------------------------------------------\n"
                + "    Item Name          Quantity       Price      Total\n\n");
      
               for ( int row = 0; row < table.getRowCount(); row++){
//               String ItemCode = table.getModel().getValueAt(row,0).toString();
               String ItemName = table.getModel().getValueAt(row,1).toString();
               String Quantity = table.getModel().getValueAt(row,2).toString();
               String Price = table.getModel().getValueAt(row,3).toString(); 
               String Total = table.getModel().getValueAt(row,4).toString();
               count++;
//               
                if (ItemName.length() >= 16){
    printTextArea.append("    " + ItemName.toUpperCase() +"    "+Quantity+" \t       "+Price+"\t  "+ Total+"\n");              
                }else if (ItemName.length() < 16 && ItemName.length() >= 8) {
    printTextArea.append("    " + ItemName.toUpperCase() +"\t"+Quantity+" \t       "+Price+"\t  "+ Total+"\n");                
                }else {
    printTextArea.append("    " + ItemName.toUpperCase() +"\t\t"+Quantity+" \t       "+Price+"\t  "+ Total+"\n");                 
                }
    
//                  +"  "+ Quantity+"Kg\t\tPrice @" + Price+"/kg\t= Php" + Total +"\n\n");
            
               }
    printTextArea.append(
                        "    ---------------------------------------------------------\n"
                        +"    Total quantity: \t\t\t  " + count +"\n"
                        +"    Total amount  : \t\t\t" + "P "+total1.getText() +"\n"
                        +"    Cash          : \t\t\t" + "P "+amountt.getText() +"\n"
                        +"    Change        : \t\t\t" + "P "+changee.getText() +"\n"
                        +"    ---------------------------------------------------------\n\n\n"
                        +"    *********************************************************\n"
                        +"                      THANK YOU COME AGAIN!\n"
                        +"    *********************************************************\n"
    );
            
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainMenu = new javax.swing.JPanel();
        TransacPanel = new javax.swing.JPanel();
        sidebuttons = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_items = new javax.swing.JButton();
        btn_avl_stocks = new javax.swing.JButton();
        btn_logout = new javax.swing.JButton();
        scrollpane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        container = new javax.swing.JPanel();
        compute = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        item_input1 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        totalamount = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        number = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        btn_removecart = new javax.swing.JToggleButton();
        btn_addcart = new javax.swing.JToggleButton();
        btn_process = new javax.swing.JToggleButton();
        confirmBox = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        total1 = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        amountt = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        changee = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        btn_process1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        code = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        stocks = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Stocks = new javax.swing.JPanel();
        sidebuttons1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btn_items2 = new javax.swing.JButton();
        btn_avl_stocks2 = new javax.swing.JButton();
        btn_logout2 = new javax.swing.JButton();
        scrollpane1 = new javax.swing.JScrollPane();
        InvTable = new javax.swing.JTable();
        searchPanel1 = new javax.swing.JPanel();
        SearchBar = new javax.swing.JTextField();
        search1 = new javax.swing.JLabel();
        numProd = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Receipts = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        printTextArea = new javax.swing.JTextArea();
        jbutton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainMenu.setLayout(new java.awt.CardLayout());

        sidebuttons.setBackground(new java.awt.Color(0, 146, 65));
        sidebuttons.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/mainlogo.png"))); // NOI18N
        sidebuttons.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 404, -1, -1));

        btn_items.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_items.setForeground(new java.awt.Color(0, 146, 65));
        btn_items.setText("Cashier");
        btn_items.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_itemsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_itemsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_itemsMouseExited(evt);
            }
        });
        btn_items.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_itemsActionPerformed(evt);
            }
        });
        sidebuttons.add(btn_items, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 81, 237, 53));

        btn_avl_stocks.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_avl_stocks.setForeground(new java.awt.Color(0, 146, 65));
        btn_avl_stocks.setText("Summary of Stocks");
        btn_avl_stocks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_avl_stocksMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_avl_stocksMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_avl_stocksMouseExited(evt);
            }
        });
        btn_avl_stocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_avl_stocksActionPerformed(evt);
            }
        });
        sidebuttons.add(btn_avl_stocks, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 152, 237, 53));

        btn_logout.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_logout.setForeground(new java.awt.Color(0, 146, 65));
        btn_logout.setText("Back");
        btn_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_logoutMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_logoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_logoutMouseExited(evt);
            }
        });
        btn_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logoutActionPerformed(evt);
            }
        });
        sidebuttons.add(btn_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 223, 237, 53));

        table.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product Name", "Quantity", "Price", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        scrollpane.setViewportView(table);

        container.setLayout(new java.awt.CardLayout());

        compute.setBackground(new java.awt.Color(0, 146, 65));

        jLabel29.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Item:");

        item_input1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        item_input1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                item_input1MouseClicked(evt);
            }
        });
        item_input1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_input1ActionPerformed(evt);
            }
        });
        item_input1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                item_input1KeyReleased(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Total Amount:");

        totalamount.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        totalamount.setText("0");
        totalamount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalamountActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Quantity:");

        number.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        number.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                numberMouseClicked(evt);
            }
        });
        number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberActionPerformed(evt);
            }
        });
        number.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                numberKeyReleased(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Total:");

        total.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        btn_removecart.setBackground(new java.awt.Color(0, 153, 0));
        btn_removecart.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_removecart.setForeground(new java.awt.Color(255, 255, 255));
        btn_removecart.setText("Remove from cart");
        btn_removecart.setEnabled(false);
        btn_removecart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_removecartMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_removecartMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_removecartMouseExited(evt);
            }
        });

        btn_addcart.setBackground(new java.awt.Color(0, 153, 0));
        btn_addcart.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_addcart.setForeground(new java.awt.Color(255, 255, 255));
        btn_addcart.setText("Add to cart");
        btn_addcart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addcartMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addcartMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addcartMouseExited(evt);
            }
        });
        btn_addcart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addcartActionPerformed(evt);
            }
        });

        btn_process.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_process.setText("PROCESS");
        btn_process.setEnabled(false);
        btn_process.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_processActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout computeLayout = new javax.swing.GroupLayout(compute);
        compute.setLayout(computeLayout);
        computeLayout.setHorizontalGroup(
            computeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(computeLayout.createSequentialGroup()
                .addGroup(computeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(computeLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(computeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(computeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(computeLayout.createSequentialGroup()
                                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(computeLayout.createSequentialGroup()
                                    .addGroup(computeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(68, 68, 68)
                                    .addGroup(computeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(item_input1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(computeLayout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalamount, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(computeLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btn_removecart)
                        .addGap(63, 63, 63)
                        .addComponent(btn_addcart, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 47, Short.MAX_VALUE))
            .addGroup(computeLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(btn_process, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        computeLayout.setVerticalGroup(
            computeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(computeLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(computeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30)
                    .addComponent(totalamount, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(computeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(item_input1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(computeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(18, 18, 18)
                .addGroup(computeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(computeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_removecart, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_addcart, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_process, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        container.add(compute, "card2");

        confirmBox.setBackground(new java.awt.Color(36, 52, 7));
        confirmBox.setForeground(new java.awt.Color(255, 255, 255));

        jLabel33.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Total:");

        total1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Amount:");

        amountt.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        amountt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                amounttFocusLost(evt);
            }
        });
        amountt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                amounttKeyReleased(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Change:");

        changee.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        back.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        btn_process1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_process1.setText("PROCESS");
        btn_process1.setEnabled(false);
        btn_process1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_process1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout confirmBoxLayout = new javax.swing.GroupLayout(confirmBox);
        confirmBox.setLayout(confirmBoxLayout);
        confirmBoxLayout.setHorizontalGroup(
            confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmBoxLayout.createSequentialGroup()
                .addGroup(confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(confirmBoxLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(total1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(amountt, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changee, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, confirmBoxLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(btn_process1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        confirmBoxLayout.setVerticalGroup(
            confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(confirmBoxLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(amountt, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changee, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(confirmBoxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_process1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        container.add(confirmBox, "card3");

        jPanel3.setBackground(new java.awt.Color(0, 146, 65));

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Product Information");

        jLabel7.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ID");

        code.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Name");

        name.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        price.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Price");

        stocks.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Stocks");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(code, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                            .addComponent(name)
                            .addComponent(price)
                            .addComponent(stocks))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(38, 38, 38)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(code, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stocks, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TransacPanelLayout = new javax.swing.GroupLayout(TransacPanel);
        TransacPanel.setLayout(TransacPanelLayout);
        TransacPanelLayout.setHorizontalGroup(
            TransacPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TransacPanelLayout.createSequentialGroup()
                .addComponent(sidebuttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TransacPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollpane)
                    .addGroup(TransacPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        TransacPanelLayout.setVerticalGroup(
            TransacPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebuttons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(TransacPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(scrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TransacPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(TransacPanelLayout.createSequentialGroup()
                        .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        MainMenu.add(TransacPanel, "card4");

        sidebuttons1.setBackground(new java.awt.Color(0, 146, 65));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/mainlogo.png"))); // NOI18N

        btn_items2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_items2.setForeground(new java.awt.Color(0, 146, 65));
        btn_items2.setText("Cashier");
        btn_items2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_items2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_items2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_items2MouseExited(evt);
            }
        });
        btn_items2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_items2ActionPerformed(evt);
            }
        });

        btn_avl_stocks2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        btn_avl_stocks2.setForeground(new java.awt.Color(0, 146, 65));
        btn_avl_stocks2.setText("Summary of Stocks");
        btn_avl_stocks2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_avl_stocks2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_avl_stocks2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_avl_stocks2MouseExited(evt);
            }
        });
        btn_avl_stocks2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_avl_stocks2ActionPerformed(evt);
            }
        });

        btn_logout2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        btn_logout2.setForeground(new java.awt.Color(0, 146, 65));
        btn_logout2.setText("Back");
        btn_logout2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_logout2MouseClicked(evt);
            }
        });
        btn_logout2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logout2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sidebuttons1Layout = new javax.swing.GroupLayout(sidebuttons1);
        sidebuttons1.setLayout(sidebuttons1Layout);
        sidebuttons1Layout.setHorizontalGroup(
            sidebuttons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidebuttons1Layout.createSequentialGroup()
                .addGroup(sidebuttons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidebuttons1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(sidebuttons1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(sidebuttons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_items2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_avl_stocks2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_logout2, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        sidebuttons1Layout.setVerticalGroup(
            sidebuttons1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidebuttons1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(btn_items2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_avl_stocks2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_logout2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        InvTable.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        InvTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Size", "Capital", "Stocks", "Sales", "Damage"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollpane1.setViewportView(InvTable);

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

        search1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/search.png"))); // NOI18N

        javax.swing.GroupLayout searchPanel1Layout = new javax.swing.GroupLayout(searchPanel1);
        searchPanel1.setLayout(searchPanel1Layout);
        searchPanel1Layout.setHorizontalGroup(
            searchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchPanel1Layout.createSequentialGroup()
                .addComponent(SearchBar, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );
        searchPanel1Layout.setVerticalGroup(
            searchPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SearchBar)
            .addComponent(search1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        numProd.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        numProd.setText("0");

        jLabel21.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel21.setText("Total No. of Products:");

        javax.swing.GroupLayout StocksLayout = new javax.swing.GroupLayout(Stocks);
        Stocks.setLayout(StocksLayout);
        StocksLayout.setHorizontalGroup(
            StocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StocksLayout.createSequentialGroup()
                .addComponent(sidebuttons1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(StocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(StocksLayout.createSequentialGroup()
                        .addComponent(searchPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numProd))
                    .addComponent(scrollpane1, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        StocksLayout.setVerticalGroup(
            StocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidebuttons1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(StocksLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(StocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(StocksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(numProd, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, StocksLayout.createSequentialGroup()
                            .addComponent(jLabel21)
                            .addGap(16, 16, 16))))
                .addGap(36, 36, 36)
                .addComponent(scrollpane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MainMenu.add(Stocks, "card3");

        Receipts.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        printTextArea.setColumns(20);
        printTextArea.setRows(5);
        jScrollPane1.setViewportView(printTextArea);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 580));

        Receipts.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 410, 580));

        jbutton1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jbutton1.setText("Print");
        jbutton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton1ActionPerformed(evt);
            }
        });
        Receipts.add(jbutton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 630, -1, 40));

        MainMenu.add(Receipts, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 1206, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1031, 707));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_itemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_itemsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_itemsActionPerformed

    private void btn_avl_stocksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_avl_stocksActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_avl_stocksActionPerformed

    private void btn_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_logoutActionPerformed

    private void btn_items2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_items2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_items2ActionPerformed

    private void btn_avl_stocks2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_avl_stocks2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_avl_stocks2ActionPerformed

    private void btn_logout2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logout2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_logout2ActionPerformed

    private void jbutton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton1ActionPerformed
        DefaultTableModel model;
    model = (DefaultTableModel) table.getModel();
    model.setRowCount(0);
    changee.setText("");
    totalamount.setText("");
    total1.setText("");
    amountt.setText("");
    
    MainMenu.removeAll();
    MainMenu.repaint();
    MainMenu.revalidate();
    MainMenu.add(TransacPanel);
    MainMenu.repaint();
    MainMenu.revalidate();
    container.removeAll();
    container.repaint();
    container.revalidate();
    container.add(compute);
    container.repaint();
    container.revalidate();
    
    Toolkit tkp = printTextArea.getToolkit();
    PrintJob pjp = tkp.getPrintJob(this, null, null);
    Graphics g = pjp.getGraphics();
    printTextArea.print(g);
    g.dispose();
    pjp.end();
    }//GEN-LAST:event_jbutton1ActionPerformed

    private void item_input1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_input1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_item_input1ActionPerformed

    private void totalamountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalamountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalamountActionPerformed

    private void numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numberActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void btn_itemsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_itemsMouseClicked
        MainMenu.removeAll();
        MainMenu.repaint();
        MainMenu.revalidate();
        MainMenu.add(TransacPanel);
        MainMenu.repaint();
        MainMenu.revalidate();
    }//GEN-LAST:event_btn_itemsMouseClicked

    private void btn_itemsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_itemsMouseEntered
        btn_items.setBackground(new java.awt.Color(51,255,51));
        btn_items.setForeground(new java.awt.Color(0,153,0));
        btn_items.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,0), 2));
    }//GEN-LAST:event_btn_itemsMouseEntered

    private void btn_itemsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_itemsMouseExited
        btn_items.setBackground(new java.awt.Color(0,153,0));
        btn_items.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btn_itemsMouseExited

    private void btn_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseClicked
        Product toProduct = new Product();
        toProduct.show();
        dispose();
    }//GEN-LAST:event_btn_logoutMouseClicked

    private void btn_logoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseEntered
        btn_logout.setBackground(new java.awt.Color(51,255,51));
        btn_logout.setForeground(new java.awt.Color(0,153,0));
        btn_logout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,0), 2));
    }//GEN-LAST:event_btn_logoutMouseEntered

    private void btn_logoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logoutMouseExited
        btn_logout.setBackground(new java.awt.Color(0,153,0));
        btn_logout.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btn_logoutMouseExited

    private void btn_avl_stocksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_avl_stocksMouseClicked
        MainMenu.removeAll();
        MainMenu.repaint();
        MainMenu.revalidate();
        MainMenu.add(Stocks);
        MainMenu.repaint();
        MainMenu.revalidate();
    }//GEN-LAST:event_btn_avl_stocksMouseClicked

    private void btn_avl_stocksMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_avl_stocksMouseEntered
        btn_avl_stocks.setBackground(new java.awt.Color(51,255,51));
        btn_avl_stocks.setForeground(new java.awt.Color(0,153,0));
        btn_avl_stocks.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,0), 2));
    }//GEN-LAST:event_btn_avl_stocksMouseEntered

    private void btn_avl_stocksMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_avl_stocksMouseExited
        btn_avl_stocks.setBackground(new java.awt.Color(0,153,0));
        btn_avl_stocks.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btn_avl_stocksMouseExited

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int row = table.getSelectedRow();
        code.setText(table.getModel().getValueAt(row,0).toString());
        name.setText(table.getModel().getValueAt(row,1).toString());
        item_input1.setText(table.getModel().getValueAt(row,1).toString());
        number.setText(table.getModel().getValueAt(row,2).toString());
        price.setText(table.getModel().getValueAt(row,3).toString());
        total.setText(table.getModel().getValueAt(row,4).toString());
    
        for (int i = 0; i < InvTable.getRowCount();i++){
            String id = (InvTable.getModel().getValueAt(i, 0).toString());
            if (id.equals(table.getModel().getValueAt(row,0).toString())){
                stocks.setText(InvTable.getModel().getValueAt(i, 4).toString());
            }   
        }
        btn_removecart.setEnabled(true);
      number.setEditable(true);
    }//GEN-LAST:event_tableMouseClicked

    private void btn_removecartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_removecartMouseExited
        btn_removecart.setBackground(new java.awt.Color(0,153,0));
        btn_removecart.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btn_removecartMouseExited

    private void btn_removecartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_removecartMouseEntered
        btn_removecart.setBackground(new java.awt.Color(51,255,51));
        btn_removecart.setForeground(new java.awt.Color(0,153,0));
        btn_removecart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,0), 2));
    }//GEN-LAST:event_btn_removecartMouseEntered

    private void btn_removecartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_removecartMouseClicked
        if (!(code.getText()).isEmpty()){
        DefaultTableModel model;
        model = (DefaultTableModel) table.getModel();
        int row = table.getSelectedRow();
        if(table.getSelectedRow() != -1) {
               // remove selected row from the model
               float gtotal = Float.parseFloat(totalamount.getText());
               float subT = Float.parseFloat(total.getText());
               totalamount.setText(Float.toString(gtotal - subT));
               model.removeRow(row);
               
               float newquan = (Float.parseFloat(stocks.getText())) + Float.parseFloat(number.getText());
               String capt = "";
                DefaultTableModel model2 = (DefaultTableModel) InvTable.getModel();
                Object objquant = newquan;
                for (int i = 0; i < InvTable.getRowCount();i++){
                       String codeID = InvTable.getModel().getValueAt(i, 0).toString();
                       if (codeID.startsWith(code.getText()) ){
                           InvTable.getModel().setValueAt(objquant, i, 4);
                           String id = (InvTable.getModel().getValueAt(i, 0)).toString();
                           String namee = (InvTable.getModel().getValueAt(i, 1).toString());
                           String cate = (InvTable.getModel().getValueAt(i, 2).toString());
                           capt = (InvTable.getModel().getValueAt(i, 3).toString());
                           String quant = (InvTable.getModel().getValueAt(i, 4).toString());
                           String pricee = (InvTable.getModel().getValueAt(i, 5).toString());
                           String damage = (InvTable.getModel().getValueAt(i, 6).toString());
                           
                           Edit edit = new Edit (id,namee,cate,capt,quant,pricee,damage,i);


                       }
                    
                }
               
               code.setText("");
               name.setText("");
               price.setText("");
               stocks.setText("");
               item_input1.setText("");
               number.setText("");
               total.setText("");
        }
    }
    if(Float.parseFloat(totalamount.getText()) != 0){
       btn_process.setEnabled(true); 
    }else{
        btn_process.setEnabled(false); 
    } 
    
    }//GEN-LAST:event_btn_removecartMouseClicked

    private void numberKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_numberKeyReleased
        String stocksT = "";
        for (int i = 0; i < InvTable.getRowCount();i++){
           String sName = InvTable.getModel().getValueAt(i, 0).toString();
           if (sName.startsWith(code.getText()) ){
               stocksT = (InvTable.getModel().getValueAt(i, 4).toString());
               
           }
        }
        
        if (number.getText().isEmpty()){
            total.setText("");
            stocks.setText(stocksT);
        }
        else if (!number.getText().isEmpty()){ // check if input is number
            float fvalue;
            try {
                fvalue = Float.parseFloat(number.getText());  
            } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Plese input the Quantity in Kilogram"); 
            number.setText("");
            return;
            }
            
            float q = Float.parseFloat(number.getText());
            float s = Float.parseFloat(stocksT);
            float p = Float.parseFloat(price.getText());
            float newStocks = s-q;
            Double rounded = Math.round(newStocks * 1000)/1000.0;
            stocks.setText(Double.toString(rounded));
            
            if (newStocks < 0){         //check if out of stock
                JOptionPane.showMessageDialog(null, "Insufficient Balance!");
                    number.setText("");
                    total.setText("");
                    item_input1.setText("");
                    stocks.setText(stocksT);
                    return;

            }

            if(number.getText().equals("")){
                        total.setText("");
                        stocks.setText(stocksT);
            }
            else{

                float total2 = p * q;
                Double newTotal = Math.round(total2 * 1000)/1000.0;
                total.setText(Double.toString(newTotal));
            }
        }
    }//GEN-LAST:event_numberKeyReleased

    private void btn_processActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_processActionPerformed
        container.removeAll();
        container.repaint();
        container.revalidate();
        container.add(confirmBox);
        container.repaint();
        container.revalidate();
        total1.setText(totalamount.getText());
    }//GEN-LAST:event_btn_processActionPerformed

    private void item_input1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_item_input1KeyReleased
        if (item_input1.getText().equals("")){
        name.setText("");
        code.setText("");
        price.setText("");
        stocks.setText("");
        number.setText("");
        total.setText("");
    }else{
        for (int i = 0; i < InvTable.getRowCount();i++){
           String sName = InvTable.getModel().getValueAt(i, 1).toString();
           if (sName.startsWith(item_input1.getText()) || sName.substring(0, item_input1.getText().length()).equalsIgnoreCase(item_input1.getText())){
               code.setText(InvTable.getModel().getValueAt(i, 0).toString());
               name.setText(InvTable.getModel().getValueAt(i, 1).toString());
               price.setText(InvTable.getModel().getValueAt(i, 5).toString());
               stocks.setText(InvTable.getModel().getValueAt(i, 4).toString());
               number.setEnabled(true);
               number.setEditable(true);
           }
        }
       
        
    }
    }//GEN-LAST:event_item_input1KeyReleased

    private void btn_process1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_process1ActionPerformed
        MainMenu.removeAll();
        MainMenu.repaint();
        MainMenu.revalidate();
        MainMenu.add(Receipts);
        MainMenu.repaint();
        MainMenu.revalidate();
        dataTo_file();
        getAllDataTo_Print();
    }//GEN-LAST:event_btn_process1ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        container.removeAll();
    container.repaint();
    container.revalidate();
    container.add(compute);
    container.repaint();
    container.revalidate();
    }//GEN-LAST:event_backActionPerformed

    private void btn_addcartMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addcartMouseExited
        btn_addcart.setBackground(new java.awt.Color(0,153,0));
        btn_addcart.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btn_addcartMouseExited

    private void btn_addcartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addcartMouseEntered
        btn_addcart.setBackground(new java.awt.Color(51,255,51));
        btn_addcart.setForeground(new java.awt.Color(0,153,0));
    }//GEN-LAST:event_btn_addcartMouseEntered

    private void btn_addcartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addcartMouseClicked
        if (number.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "No Input");
        return;
    }else{    
    DefaultTableModel model;
    model = (DefaultTableModel) table.getModel();
    float gTotal = 0;
    
        if (table.getRowCount() == 0){
            gTotal += Float.parseFloat(total.getText());
            String [] data = {code.getText(),name.getText(),number.getText(),price.getText(),total.getText()};
            model.addRow(data);
        }else{
            
            ArrayList<String> items = new ArrayList<>(); //
            for(int i = 0; i < table.getRowCount();i++){
                String id =    table.getModel().getValueAt( i, 0).toString();
                String nam =    table.getModel().getValueAt( i, 1).toString();
                String quan =     table.getModel().getValueAt( i, 2).toString();
                String pric =    table.getModel().getValueAt( i, 3).toString();
                String subT =    table.getModel().getValueAt( i, 4).toString();
                float sT = Float.parseFloat(subT);
                gTotal +=  sT;
                String data = (id+","+nam+","+quan+","+pric+","+subT);
                items.add(data);
            }
            int u = 0;
            for (int i = 0; i < items.size(); i++){
                model.setRowCount(i);
                String data = items.get(i);
                String dataT[];
                dataT = data.split(",");
                
                if (data.startsWith(code.getText())){ // if the product is already in the table
                    
                    float quan = Float.parseFloat(dataT[2]) + Float.parseFloat(number.getText()) ;
                    float subT = Float.parseFloat(dataT[4]) + Float.parseFloat(total.getText());
                    gTotal += Float.parseFloat(total.getText());
                    String [] newData = {code.getText(),name.getText(),Float.toString(quan),price.getText(),Float.toString(subT)};
                    model.addRow(newData);
                    u = 1;
                }else {
                    model.addRow(dataT);
                }
            
            }
            if (u == 0){ // if product is not in the table
                    gTotal += Float.parseFloat(total.getText());
                    
                    String [] nData = {code.getText(),name.getText(),number.getText(),price.getText(),total.getText()};
                    model.addRow(nData);
            }

        }
        String capt = "";
        DefaultTableModel model2;
        model2 = (DefaultTableModel) InvTable.getModel();
        Object newStock = stocks.getText();
        System.out.println(stocks.getText() + " "+InvTable.getRowCount() );
        for (int i = 0; i < InvTable.getRowCount();i++){
               String codeID = InvTable.getModel().getValueAt(i, 0).toString();
               if (codeID.startsWith(code.getText()) ){
                   InvTable.getModel().setValueAt(newStock, i, 4);
                   String id = (InvTable.getModel().getValueAt(i, 0)).toString();
                   String namee = (InvTable.getModel().getValueAt(i, 1).toString());
                   String cate = (InvTable.getModel().getValueAt(i, 2).toString());
                   capt = (InvTable.getModel().getValueAt(i, 3).toString());
                   String quant = (InvTable.getModel().getValueAt(i, 4).toString());
                   String pricee = (InvTable.getModel().getValueAt(i, 5).toString());
                   String damage = (InvTable.getModel().getValueAt(i, 6).toString());
                   Edit edit = new Edit (id,namee,cate,capt,quant,pricee,damage,i); // to edit the quantity


               }
            }
        
               
    Double roundedTotal = Math.round(gTotal * 1000)/1000.0;
    code.setText("");
    name.setText("");
    number.setText("");
    price.setText("");
    total.setText("");
    item_input1.setText("");
    stocks.setText("");
    totalamount.setText(Double.toString(roundedTotal));
    item_input1.setFocusable(true);
    number.setEditable(false);
    number.setEnabled(false);
    }
    btn_process.setEnabled(true);
    }//GEN-LAST:event_btn_addcartMouseClicked

    private void btn_items2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_items2MouseClicked
        MainMenu.removeAll();
        MainMenu.repaint();
        MainMenu.revalidate();
        MainMenu.add(TransacPanel);
        MainMenu.repaint();
        MainMenu.revalidate();
    }//GEN-LAST:event_btn_items2MouseClicked

    private void btn_items2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_items2MouseEntered
        btn_items2.setBackground(new java.awt.Color(51,255,51));
    btn_items2.setForeground(new java.awt.Color(0,153,0));
    btn_items2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,0), 2));
    }//GEN-LAST:event_btn_items2MouseEntered

    private void btn_items2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_items2MouseExited
        btn_items2.setBackground(new java.awt.Color(0,153,0));
    btn_items2.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btn_items2MouseExited

    private void btn_logout2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_logout2MouseClicked
        Product toProduct = new Product();
        toProduct.show();
        dispose();    
    }//GEN-LAST:event_btn_logout2MouseClicked

    private void btn_avl_stocks2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_avl_stocks2MouseClicked
       MainMenu.removeAll();
    MainMenu.repaint();
    MainMenu.revalidate();
    MainMenu.add(Stocks);
    MainMenu.repaint();
    MainMenu.revalidate();
    }//GEN-LAST:event_btn_avl_stocks2MouseClicked

    private void btn_avl_stocks2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_avl_stocks2MouseEntered
        btn_avl_stocks2.setBackground(new java.awt.Color(51,255,51));
    btn_avl_stocks2.setForeground(new java.awt.Color(0,153,0));
    btn_avl_stocks2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,153,0), 2));
    }//GEN-LAST:event_btn_avl_stocks2MouseEntered

    private void btn_avl_stocks2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_avl_stocks2MouseExited
        btn_avl_stocks2.setBackground(new java.awt.Color(0,153,0));
    btn_avl_stocks2.setForeground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btn_avl_stocks2MouseExited

    private void SearchBarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchBarMouseClicked
        SearchBar.setText("");
    }//GEN-LAST:event_SearchBarMouseClicked

    private void SearchBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchBarActionPerformed
       refresh_table();
    }//GEN-LAST:event_SearchBarActionPerformed

    private void item_input1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_item_input1MouseClicked
        item_input1.setText("");
    }//GEN-LAST:event_item_input1MouseClicked

    private void numberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numberMouseClicked
        number.setText("");
        total.setText("");
    }//GEN-LAST:event_numberMouseClicked

    private void amounttKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amounttKeyReleased
        if(!amountt.getText().isEmpty()){
        float amnt =0;
        try{
        amnt = Float.parseFloat(amountt.getText());
        }catch(NumberFormatException w){
            JOptionPane.showMessageDialog(null, "Invalid Input");
            amountt.setText("");
            amountt.setFocusable(true);
            return;
        }
        float totall = Float.parseFloat(total1.getText());
        float chng = amnt - totall;
        Double roundedChange = Math.round(chng * 1000)/1000.0;
        
        changee.setText(Double.toString(roundedChange));
           if (chng >= 0 ){
              btn_process1.setEnabled(true);
           }else{
              btn_process1.setEnabled(false); 
           }
        }else{
            changee.setText("");
            amountt.setText("");
        }
    }//GEN-LAST:event_amounttKeyReleased

    private void amounttFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_amounttFocusLost
        if (Float.parseFloat(changee.getText()) < 0 ){
           JOptionPane.showMessageDialog(null, "Amount is not enough");
           amountt.setText("");
           changee.setText("");
           amountt.setFocusable(true);
           return;
        }
    }//GEN-LAST:event_amounttFocusLost

    private void btn_addcartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addcartActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_addcartActionPerformed

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
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new POS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable InvTable;
    private javax.swing.JPanel MainMenu;
    private javax.swing.JPanel Receipts;
    private javax.swing.JTextField SearchBar;
    private javax.swing.JPanel Stocks;
    private javax.swing.JPanel TransacPanel;
    private javax.swing.JTextField amountt;
    private javax.swing.JButton back;
    private javax.swing.JToggleButton btn_addcart;
    private javax.swing.JButton btn_avl_stocks;
    private javax.swing.JButton btn_avl_stocks2;
    private javax.swing.JButton btn_items;
    private javax.swing.JButton btn_items2;
    private javax.swing.JButton btn_logout;
    private javax.swing.JButton btn_logout2;
    private javax.swing.JToggleButton btn_process;
    private javax.swing.JButton btn_process1;
    private javax.swing.JToggleButton btn_removecart;
    private javax.swing.JTextField changee;
    private javax.swing.JTextField code;
    private javax.swing.JPanel compute;
    private javax.swing.JPanel confirmBox;
    private javax.swing.JPanel container;
    private javax.swing.JTextField item_input1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbutton1;
    private javax.swing.JTextField name;
    private javax.swing.JLabel numProd;
    private javax.swing.JTextField number;
    private javax.swing.JTextField price;
    private javax.swing.JTextArea printTextArea;
    private javax.swing.JScrollPane scrollpane;
    private javax.swing.JScrollPane scrollpane1;
    private javax.swing.JLabel search1;
    private javax.swing.JPanel searchPanel1;
    private javax.swing.JPanel sidebuttons;
    private javax.swing.JPanel sidebuttons1;
    private javax.swing.JTextField stocks;
    private javax.swing.JTable table;
    private javax.swing.JTextField total;
    private javax.swing.JTextField total1;
    private javax.swing.JTextField totalamount;
    // End of variables declaration//GEN-END:variables
}
