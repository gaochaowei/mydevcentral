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
public class DateConverter extends Converter {

    public static DateConverter instance = new DateConverter();

    public Object convertForward(Object date) {
        System.err.println("DateConverter.convertForward...."+date);
        System.err.println("----->"+CommonUtils.format((Date)date));
        return CommonUtils.format((Date)date);
    }

    public Object convertReverse(Object arg) {
        System.err.println("DateConverter.convertReverse...."+arg);
        System.err.println("----->"+CommonUtils.parse(String.valueOf(arg)));
        return CommonUtils.parse(String.valueOf(arg));
    }
}
