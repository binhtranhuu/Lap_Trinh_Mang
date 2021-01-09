/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.view;

import client.controller.Controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import model.Student;

/**
 *
 * @author tranb
 */
public class Main extends javax.swing.JFrame implements ActionListener, MouseListener {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        btnSearch.addActionListener(this);
        btnAdd.addActionListener(this);
        table.addMouseListener(this);
        loadStudents();
    }
    
    public void loadTable(ArrayList<Student> listStudent){
        DefaultTableModel m =(DefaultTableModel) table.getModel();
        m.setRowCount(0);
        for(Student s :listStudent){
            Vector v = new Vector();
            v.add(s.getMa());
            v.add(s.getTen());
            v.add(s.getKhoa());
            v.add(s.getNgaysinh());
            v.add(s.getQuequan());
            m.addRow(v);
        }
    }
    public void loadStudents(){
        Controller con = new Controller();
        con.getListStudent();
        loadTable((ArrayList<Student>) con.receive());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSearch.setText("Search");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ma", "ten", "khoa", "ngaysinh", "quequan"
            }
        ));
        jScrollPane1.setViewportView(table);

        btnAdd.setText("Add");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch)
                        .addGap(18, 18, 18)
                        .addComponent(btnAdd))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch)
                    .addComponent(btnAdd))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if(btn.equals(btnSearch)){
            String key = txtSearch.getText();
            Controller con = new Controller();
            loadTable(con.search(key));
        } else {
            Add add = new Add(this);
            add.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int row = table.rowAtPoint(e.getPoint());
        int ma = (int)table.getValueAt(row, 0);
        String ten = (String)table.getValueAt(row, 1);
        String khoa = (String)table.getValueAt(row, 2);
        String ngaysinh = (String)table.getValueAt(row, 3);
        String quequan = (String)table.getValueAt(row, 4);
        
        Student s = new Student(ma, ten, khoa, ngaysinh, quequan);
        
        Edit edit = new Edit(s, this);
        edit.setVisible(true);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}