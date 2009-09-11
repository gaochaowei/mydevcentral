/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.swing;

import desktop.util.CommonUtils;
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

    private JTextField textField;

    public DateEditor() {
        this(new JTextField());
    }

    public DateEditor(final JTextField textField) {
        super(textField);
        this.textField = textField;
    }

    @Override
    public Object getCellEditorValue() {
        return CommonUtils.parse(textField.getText());
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
            Object value,
            boolean isSelected,
            int row,
            int column) {
        textField = (JTextField) super.getTableCellEditorComponent(table, value, isSelected, row, column);
        textField.setText(CommonUtils.format((Date) value));
        textField.setBorder(BorderFactory.createEmptyBorder());
        return textField;
    }
}
