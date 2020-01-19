package j_4_11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static  String getCurrTime()
    {
        return  new SimpleDateFormat("HH:mm:ss").format(new Date());
    }


}
