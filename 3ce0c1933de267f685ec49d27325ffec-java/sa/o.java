package sa;

import com.mobvoi.android.common.json.JsonBean;
import h8.c;
/* compiled from: TimeZoneResponseBean.java */
/* loaded from: classes2.dex */
public class o implements JsonBean {
    @c("errCode")
    public int errCode;
    @c("errMsg")
    public String errMsg;

    public boolean a() {
        return this.errCode == 0;
    }

    public String toString() {
        return "TimeZoneResponseBean{errCode=" + this.errCode + ", errMsg='" + this.errMsg + "'}";
    }
}
