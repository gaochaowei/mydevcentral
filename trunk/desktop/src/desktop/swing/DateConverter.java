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
        System.out.println("DateConverter.convertForward...."+date);
        System.out.println("----->"+CommonUtils.format(date));
        return CommonUtils.format(date);
    }

    public Date convertReverse(String arg) {
        System.out.println("DateConverter.convertReverse...."+arg);
        System.out.println("----->"+CommonUtils.parse(arg));
        return CommonUtils.parse(arg);
    }
}
