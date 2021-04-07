/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.controllers;

import com.google.gson.Gson;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import ni.edu.uni.programacion.backend.dao.implementation.JsonVehicleDaoImpl;
import ni.edu.uni.programacion.backend.pojo.Vehicle;
import ni.edu.uni.programacion.backend.pojo.VehicleSubModel;
import ni.edu.uni.programacion.views.panels.PnlShow;

/**
 *
 * @author Usuario
 */
public class PnlVehicleShowController {

    private PnlShow pnlShow;
    
    
    private DefaultTableModel model;
    private Gson gson;
    private JsonVehicleDaoImpl jvdao;
    private List<Vehicle> list = new ArrayList<Vehicle>();

    public PnlVehicleShowController(PnlShow pnlShow) throws FileNotFoundException {
        this.pnlShow = pnlShow;
        initcomponent();
    }
    private void initcomponent () throws FileNotFoundException {
    model=(DefaultTableModel) pnlShow.getTblShow().getModel();
    jvdao = new JsonVehicleDaoImpl();
    pnlShow.getBtnShow().addActionListener((e) ->{
        try {
            btnShowAllActionListener(e);
        } catch (IOException ex) {
            Logger.getLogger(PnlVehicleShowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        });
    pnlShow.getTxtSearch().addKeyListener(new KeyAdapter()
        {
            public void keyReleased(final KeyEvent e)
            {
                TableRowSorter TFilter = new TableRowSorter(pnlShow.getTblShow().getModel());
                String s = pnlShow.getTxtSearch().getText();
                
                pnlShow.getTxtSearch().setText(s);
                
                FilterTabe(pnlShow.getCmbSearch().getSelectedIndex(), TFilter);
            }
        });
        
    }
    private void FilterTabe(int a, TableRowSorter filter)
    {
        filter.setRowFilter(RowFilter.regexFilter(pnlShow.getTxtSearch().getText(), a));
        pnlShow.getTblShow().setRowSorter(filter);
    }
    private void btnShowAllActionListener(ActionEvent e) throws IOException{
        list = (List<Vehicle>) jvdao.getAll();
        while (list.size() > pnlShow.getTblShow().getRowCount())
        {
            model.addRow(new Object[]{});
        }

        for (int i = 0; i < list.size(); i++) 
        {
            pnlShow.getTblShow().setValueAt((i + 1), i, 0);
            pnlShow.getTblShow().setValueAt(list.get(i).getStockNumber(), i, 1);
            pnlShow.getTblShow().setValueAt(list.get(i).getYear(), i, 2);
            pnlShow.getTblShow().setValueAt(list.get(i).getMake(), i, 3);
            pnlShow.getTblShow().setValueAt(list.get(i).getModel(), i, 4);
            pnlShow.getTblShow().setValueAt(list.get(i).getStyle(), i, 5);
            pnlShow.getTblShow().setValueAt(list.get(i).getVin(), i, 6);
            pnlShow.getTblShow().setValueAt(list.get(i).getExteriorColor(), i, 7);
            pnlShow.getTblShow().setValueAt(list.get(i).getInteriorColor(), i, 8);
            pnlShow.getTblShow().setValueAt(list.get(i).getMiles(), i, 9);
            pnlShow.getTblShow().setValueAt(list.get(i).getPrice(), i, 10);
            pnlShow.getTblShow().setValueAt(list.get(i).getTransmission().toString(), i, 11);
            pnlShow.getTblShow().setValueAt(list.get(i).getEngine(), i, 12);
            pnlShow.getTblShow().setValueAt(list.get(i).getImage(), i, 13);
             
        }
        pnlShow.getBtnShow().setText("Mostrar Todo");
    }
    
    }
    
    


