package gn;

import com.bjleisen.iface.sdk.apdu.LeisenIfaceConfig;
import com.mobvoi.wear.util.LogCleaner;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes2.dex */
public class j {
    public static int a(String str, String str2) {
        if (str == null || str2 == null || str.equals("") || str2.equals("")) {
            return -1;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT, Locale.US);
        return (int) ((simpleDateFormat.parse(str).getTime() - simpleDateFormat.parse(str2).getTime()) / LogCleaner.ONE_DAY);
    }
}
