package ag;

import com.mobvoi.health.common.data.pojo.ActivityType;
import com.mobvoi.wear.lpa.LpaConstants;
import java.util.Locale;
/* compiled from: DataSessionSearch.java */
/* loaded from: classes2.dex */
public class c extends yf.c {
    public Integer activity;
    public Long time_from;
    public Long time_to;

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        Integer num = this.activity;
        objArr[0] = num == null ? LpaConstants.VALUE_NULL : ActivityType.from(num.intValue());
        objArr[1] = this.time_from;
        objArr[2] = this.time_to;
        objArr[3] = this.wwid;
        objArr[4] = this.device_id;
        return String.format(locale, "DataSessionSearch %s [%d, %d) > wwid: %s, deviceId %s", objArr);
    }
}
