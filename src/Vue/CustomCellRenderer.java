/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author acassard
 */
public class CustomCellRenderer extends DefaultTableCellRenderer {   
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
       Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
       if (isSelected) {
           c.setBackground(table.getSelectionBackground());
       }
       else if (table.getValueAt(row, 5) != null && table.getValueAt(row, 5).equals("masqué")) {           
           c.setBackground(Color.LIGHT_GRAY); // Modifier la couleur de la cellule
       } else {
           c.setBackground(table.getBackground());
       }
       return c;
   }
}
