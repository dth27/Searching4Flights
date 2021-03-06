
package view;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableModel;

//import java.util.

/**
 *
 * @author Dottedsocks
 */
public class mainWindow extends javax.swing.JFrame {
    int numberofPpl;  //to keep track of how many people need a ticket  
    /**
     * initializes mainWindow
     */
    public mainWindow() {
        initComponents();

        jResultPanel.setVisible(false);
        jTableResults.setVisible(false);
        jBacktoSearch.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLeitarPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jToWhere = new javax.swing.JComboBox<>();
        jFromWhere = new javax.swing.JComboBox<>();
        jAmount = new javax.swing.JComboBox<>();
        searchButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jResultPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResults = new javax.swing.JTable();
        jBacktoSearch = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        jLeitarPanel.setBackground(new java.awt.Color(51, 51, 51));
        jLeitarPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLeitarPanel.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Marion", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("The Icelandic Flight Search Engine");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);

        jScrollPane2.setBackground(new java.awt.Color(51, 51, 51));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setFont(new java.awt.Font("Marion", 0, 13)); // NOI18N

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(51, 51, 51));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("Created by Group 3F\nFor HBV401G\nSpring 2017");
        jTextArea1.setBorder(null);
        jTextArea1.setCaretColor(new java.awt.Color(51, 51, 51));
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel5.setText("Number of passengers:");

        jToWhere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose airport", "Akureyri", "Reykjavík", "Egilsstaðir", "Hólmavík", "Höfn", "Ísafjörður" }));

        jFromWhere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose airport", "Akureyri", "Reykjavík", "Egilsstaðir", "Hólmavík", "Höfn", "Ísafjörður" }));
        jFromWhere.setToolTipText("");

        jAmount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        searchButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        searchButton.setText("Find your flight!");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel2.setText("Choose date (dd/mm/yyyy):");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel3.setText("From:");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLabel4.setText("To:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToWhere, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jFromWhere, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(53, 53, 53))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(searchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jToWhere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFromWhere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/Flugleiðir - Uppfært.png"))); // NOI18N
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jLeitarPanelLayout = new javax.swing.GroupLayout(jLeitarPanel);
        jLeitarPanel.setLayout(jLeitarPanelLayout);
        jLeitarPanelLayout.setHorizontalGroup(
            jLeitarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitarPanelLayout.createSequentialGroup()
                .addGroup(jLeitarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLeitarPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jLeitarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jLeitarPanelLayout.createSequentialGroup()
                        .addGroup(jLeitarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLeitarPanelLayout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLeitarPanelLayout.createSequentialGroup()
                                .addGap(303, 303, 303)
                                .addComponent(jLabel7)))
                        .addGap(0, 160, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jLeitarPanelLayout.setVerticalGroup(
            jLeitarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLeitarPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jResultPanel.setBackground(new java.awt.Color(51, 51, 51));

        jTableResults.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTableResults.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jTableResults.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableResults.setEnabled(false);
        jTableResults.setOpaque(false);
        jTableResults.setRowHeight(20);
        jTableResults.setSelectionBackground(new java.awt.Color(51, 153, 255));
        jTableResults.setSelectionForeground(new java.awt.Color(102, 204, 255));
        jTableResults.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jTableResults.setShowHorizontalLines(false);
        jScrollPane1.setViewportView(jTableResults);

        jBacktoSearch.setText("Back to Search");

        jLabel6.setFont(new java.awt.Font("Marion", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Available flights");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jResultPanelLayout = new javax.swing.GroupLayout(jResultPanel);
        jResultPanel.setLayout(jResultPanelLayout);
        jResultPanelLayout.setHorizontalGroup(
            jResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jResultPanelLayout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jResultPanelLayout.createSequentialGroup()
                .addContainerGap(67, Short.MAX_VALUE)
                .addGroup(jResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jResultPanelLayout.createSequentialGroup()
                        .addComponent(jBacktoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(375, 375, 375))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jResultPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 854, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))))
        );
        jResultPanelLayout.setVerticalGroup(
            jResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jResultPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addComponent(jBacktoSearch)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLeitarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(jResultPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLeitarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jResultPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * getters and setters for the control class
 * @return 
 */

public String getDateChooser(){
    Date date = jDateChooser2.getDate();
    
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    String d = sdf.format(date);
    return d;
}       
        
public JButton getSearchButton(){
    return searchButton;
}
public JButton getBackSearchButton(){
    return jBacktoSearch;
}
public JTable getJTable(){
    return jTableResults;
}
public String getFromWhere(){
    String fromWhere = jFromWhere.getSelectedItem().toString();
    return fromWhere;
}
public String getToWhere(){
    String toWhere = jToWhere.getSelectedItem().toString();
    return toWhere;
}
public int getNumberofPass(){
    numberofPpl = Integer.valueOf(jAmount.getSelectedItem().toString());
    return numberofPpl;
}


/**
 * creates view for the result from the search.
 * @param model 
 */
public void createResultView(TableModel model){
    jTableResults.setModel(model);
    jResultPanel.setVisible(true);
    jBacktoSearch.setVisible(true);
    jLeitarPanel.setVisible(false);
    jTableResults.setVisible(true);
    //
}

/**
 * resets the view 
 * -So that the user can enter a new search
 */
public void resetView(){
        jResultPanel.setVisible(false);
        jAmount.setSelectedIndex(0);
        jToWhere.setSelectedIndex(0);
        jFromWhere.setSelectedIndex(0);
        jLeitarPanel.setVisible(true);  
        jDateChooser2.setDate(null);
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jAmount;
    private javax.swing.JButton jBacktoSearch;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JComboBox<String> jFromWhere;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jLeitarPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jResultPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableResults;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JComboBox<String> jToWhere;
    private javax.swing.JButton searchButton;
    // End of variables declaration//GEN-END:variables
}
