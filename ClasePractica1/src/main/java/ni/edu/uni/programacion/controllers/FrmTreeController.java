/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.controllers;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import ni.edu.uni.programacion.views.FrmTree;

/**
 *
 * @author Sistemas-09
 */
public class FrmTreeController {
    private FrmTree frmTree;
    private DefaultTreeModel treemodel;
    private DefaultMutableTreeNode root;

    public FrmTreeController(FrmTree frmTree) {
        this.frmTree = frmTree;
        initcomponent();
    }
    
    
    public void initcomponent(){
        root= new DefaultMutableTreeNode("Accounting", true);
        treemodel= new DefaultTreeModel(root);
        
        frmTree.getTreeAcount().setModel(treemodel);
        frmTree.getBtnAdd().addActionListener((e)->{
            BtnAddActionListener(e);
        });
        
    }
    public void BtnAddActionListener(ActionEvent e){
        TreePath treePath = frmTree.getTreeAcount().getSelectionPath();
        if(treePath==null){
        return;
        }
        
        DefaultMutableTreeNode node =(DefaultMutableTreeNode)treePath.getLastPathComponent();
        
        String accountname= JOptionPane.showInputDialog(null,"Account Name","Input Dialog",JOptionPane.INFORMATION_MESSAGE);
        int childCount = node.getChildCount();
        DefaultMutableTreeNode child= new DefaultMutableTreeNode(accountname);
        treemodel.insertNodeInto(child, node, childCount);
        
        
    }

    
}
