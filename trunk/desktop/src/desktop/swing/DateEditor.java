/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.swing;

import desktop.util.CommonUtils;
import java.awt.Color;
import java.awt.Component;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Gao.chao.wei
 */
public class DateEditor extends DefaultCellEditor {

    public static DateEditor instance = new DateEditor(new JTextField());

    private JTextField textField;

    public DateEditor(final JTextField textField) {
        super(textField);
        this.textField = textField;
    }

    @Override
    public Object getCellEditorValue() {
        System.out.println("DateEditor.getCellEditorValue... "+textField.getText());
//        return CommonUtils.parse(textField.getText());
        return "Sep 4, 2009";
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
            Object value,
            boolean isSelected,
            int row,
            int column) {
         System.out.println("DateEditor.getTableCellEditorComponent... "+textField.getText());
        textField = (JTextField) super.getTableCellEditorComponent(table, value, isSelected, row, column);
        textField.setText(CommonUtils.format((Date) value));
        textField.setBackground(Color.yellow);
        textField.setBorder(BorderFactory.createEmptyBorder());
        return textField;
    }
}
