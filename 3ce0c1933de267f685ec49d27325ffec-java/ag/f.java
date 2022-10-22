package ag;

import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.wear.lpa.LpaConstants;
import java.util.Locale;
import yf.c;
/* compiled from: DataSetSearch.java */
/* loaded from: classes2.dex */
public class f extends c {
    public Long time_from;
    public Long time_to;
    public Integer type;

    public String toString() {
        Locale locale = Locale.getDefault();
        Object[] objArr = new Object[5];
        Integer num = this.type;
        objArr[0] = num == null ? LpaConstants.VALUE_NULL : DataType.from(num.intValue());
        objArr[1] = this.time_from;
        objArr[2] = this.time_to;
        objArr[3] = this.wwid;
        objArr[4] = this.device_id;
        return String.format(locale, "DataSetSearch %s [%d, %d) > wwid: %s, deviceId %s", objArr);
    }
}
