/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.swing;

import desktop.util.CommonUtils;
import java.util.Date;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Gao.chao.wei
 */
public class DateRenderer extends DefaultTableCellRenderer {

    public DateRenderer() {
        super();
    }

    @Override
    public void setValue(Object value) {
        String text = "";
        if (value != null) {
            if (value instanceof Date) {
                text = CommonUtils.format((Date) value);
            } else {
                text = value.toString();
            }
        }
        setText(text);
    }
}
