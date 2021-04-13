/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.programacion.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
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

    public void initcomponent() {
        root = new DefaultMutableTreeNode("Accounting", true);
        treemodel = new DefaultTreeModel(root);

        frmTree.getTreeAcount().setModel(treemodel);
        frmTree.getTreeAcount().setExpandsSelectedPaths(true);
        frmTree.getBtnAdd().addActionListener((e) -> {
            BtnAddActionListener(e);
        });
        frmTree.getBtnRemove().addActionListener((e) -> {
            BtnRemoveActionListener(e);
        });
        frmTree.getTreeAcount().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                treeAccountMouseListener(e);
            }
        });

    }

    public void BtnAddActionListener(ActionEvent e) {
        DefaultMutableTreeNode node = getSelectedNode();

        String accountname = JOptionPane.showInputDialog(null, "Account Name", "Input Dialog", JOptionPane.INFORMATION_MESSAGE);
        int childCount = node.getChildCount();
        DefaultMutableTreeNode child = new DefaultMutableTreeNode(accountname);
        treemodel.insertNodeInto(child, node, childCount);

    }

    public void BtnRemoveActionListener(ActionEvent e) {

        DefaultMutableTreeNode node = getSelectedNode();
        if (node == null || node.isRoot()) {
            return;
        }
    }

    private void treeAccountMouseListener(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            Component c = frmTree.getTreeAcount().getComponentAt(e.getX(), e.getY());
            if (node==null){
            return;
            }
            frmTree.getPmnTree().show(frmTree.getTreeAcount(), e.getX(), e.getY());
            
        }
    }

    private DefaultMutableTreeNode getSelectedNode() {
        TreePath treePath = frmTree.getTreeAcount().getSelectionPath();
        if (treePath == null) {
            return null;
        }

        return (DefaultMutableTreeNode) treePath.getLastPathComponent();
    }

}
