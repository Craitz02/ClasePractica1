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
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
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
public class PnlVehicleShowController implements Observer{

   private PnlShow pnlShow;
    private JsonVehicleDaoImpl jsonVehicleDaoImpl;
    private DefaultTableModel tblViewModel;
    private List<Vehicle> vehicles;
    private String[] HEADERS = new String[]{"StockNumber", "Year", "Make", "Model", "Style",
        "Vin", "Exterior color", "Interior color", "Miles", "Price", "Transmission", "Engine", "Image", "Status"};
    private TableRowSorter<DefaultTableModel> tblRowSorter;

    public PnlVehicleShowController(PnlShow pnlShow)
    {
        this.pnlShow = pnlShow;
        initComponent();
    }

    private void initComponent() 
    {
        try 
        {
            jsonVehicleDaoImpl = new JsonVehicleDaoImpl();

            loadTable();

            pnlShow.getTxtSearch().addKeyListener(new KeyAdapter()
            {
                @Override
                public void keyTyped(KeyEvent e)
                {
                    txtFinderKeyTyped(e);
                }
            });

        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(PnlVehicleShowController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(PnlVehicleShowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void txtFinderKeyTyped(KeyEvent e)
    {
        RowFilter<DefaultTableModel, Object> rf = null;
        rf = RowFilter.regexFilter(pnlShow.getTxtSearch().getText(), 0, 1, 2, 3, 4, 5, 6, 7, 8);
        tblRowSorter.setRowFilter(rf);
    }

    private void loadTable() throws IOException
    {
        tblViewModel = new DefaultTableModel(getData(), HEADERS);
        tblRowSorter = new TableRowSorter<>(tblViewModel);

        pnlShow.getTblShow().setModel(tblViewModel);
        pnlShow.getTblShow().setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        pnlShow.getTblShow().setRowSorter(tblRowSorter);
    }

    private Object[][] getData() throws IOException
    {
        vehicles = jsonVehicleDaoImpl.getAll().stream().collect(Collectors.toList());
        Object data[][] = new Object[vehicles.size()][vehicles.get(0).asArray().length];

        IntStream.range(0, vehicles.size()).forEach(i ->
        {
            data[i] = vehicles.get(i).asArray();
        });
        
        return data;
    }

    public List<Vehicle> getVehicles()
    {
        return vehicles;
    }
    
    @Override
    public void update(Observable o, Object o1) {
       
       
    }

}
