package sa;

import com.mobvoi.android.common.json.JsonBean;
/* compiled from: TimeZoneRequestBean.java */
/* loaded from: classes2.dex */
public class n implements JsonBean {
    public String accountId;
    public String timeZone;
    public String wwid;

    public n(String str, String str2, String str3) {
        this.wwid = str;
        this.accountId = str2;
        this.timeZone = str3;
    }
}
