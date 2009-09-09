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

    public static DateRenderer instance = new DateRenderer();

    public DateRenderer() {
        super();
    }

    @Override
    public void setValue(Object value) {
        System.out.println("DateRenderer.setValue... "+value);
        String text = "";
        if (value != null) {
            if (value instanceof Date) {
                text = CommonUtils.format((Date) value);
            } else {
                text = value.toString();
            }
        }
        System.out.println("----->"+text);
        setText(text);
    }
}
