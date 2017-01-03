package cn.edu.hdu.ssd.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 
 * 
 * @author Pi Chen
 * @version ssd V1.0.0, 2016年12月10日
 * @see
 * @since ssd V1.0.0
 */
public class StringUtils
{
    public static String replaceBlank(String str)
    {
        String dest = "";
        if (str != null)
        {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
}
