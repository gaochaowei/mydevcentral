/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktop.swing;

import desktop.util.CommonUtils;
import java.util.Date;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author Gao.chao.wei
 */
public class DateConverter extends Converter<Date, String> {

    public static DateConverter instance = new DateConverter();

    public String convertForward(Date date) {
        System.out.println("convertForward");
        return CommonUtils.format(date);
    }

    public Date convertReverse(String arg) {
        System.out.println("convertReverse");
        return CommonUtils.parse(arg);
    }
}
