package com.huawei.hianalytics.mn.no.pq;

import android.text.TextUtils;
import com.huawei.hianalytics.mn.no.mn.no;
/* loaded from: classes.dex */
public class mn {

    /* renamed from: mn  reason: collision with root package name */
    private static mn f13591mn = new mn();

    /* renamed from: no  reason: collision with root package name */
    private final Object f13592no = new Object();

    /* renamed from: op  reason: collision with root package name */
    private String f13593op;

    public static mn mn() {
        return f13591mn;
    }

    private String op() {
        return no.mn().mn(no.mn.AES).mn(com.huawei.hianalytics.mn.no.st.no.mn().op(), com.huawei.hianalytics.mn.no.uv.mn.no(com.huawei.hianalytics.mn.mn.no.a(), "global_v2", "common_prop", ""));
    }

    private void pq() {
        com.huawei.hianalytics.mn.no.uv.mn.mn(com.huawei.hianalytics.mn.mn.no.a(), "global_v2", "common_prop", no.mn().mn(no.mn.AES).no(com.huawei.hianalytics.mn.no.st.no.mn().op(), this.f13593op));
    }

    public void mn(String str) {
        synchronized (this.f13592no) {
            this.f13593op = str;
            pq();
        }
    }

    public String no() {
        String str;
        synchronized (this.f13592no) {
            if (TextUtils.isEmpty(this.f13593op)) {
                this.f13593op = op();
            }
            str = this.f13593op;
        }
        return str;
    }
}
