package com.huawei.hianalytics.mn.no.st;

import android.text.TextUtils;
import com.huawei.hianalytics.mn.no.mn.no;
import com.huawei.hianalytics.mn.no.qr.mn;
/* loaded from: classes.dex */
public class no {

    /* renamed from: mn  reason: collision with root package name */
    private static no f13618mn;

    /* renamed from: no  reason: collision with root package name */
    private String f13619no;

    /* renamed from: op  reason: collision with root package name */
    private String f13620op;

    public static no mn() {
        if (f13618mn == null) {
            pq();
        }
        return f13618mn;
    }

    private boolean mn(String str) {
        mn.no("RootKeyManager", "refresh sp aes key");
        String no2 = com.huawei.hianalytics.mn.no.mn.no.mn().mn(no.mn.AES).no(rs(), str);
        if (TextUtils.isEmpty(no2)) {
            mn.no("RootKeyManager", "refreshLocalKey(): encrypted key is empty");
            return false;
        }
        com.huawei.hianalytics.mn.no.uv.mn.mn(com.huawei.hianalytics.mn.mn.no.a(), "Privacy_MY", "PrivacyData", no2);
        com.huawei.hianalytics.mn.no.uv.mn.mn(com.huawei.hianalytics.mn.mn.no.a(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
        return true;
    }

    private static synchronized void pq() {
        synchronized (no.class) {
            if (f13618mn == null) {
                f13618mn = new no();
            }
        }
    }

    private String qr() {
        String no2 = com.huawei.hianalytics.mn.no.uv.mn.no(com.huawei.hianalytics.mn.mn.no.a(), "Privacy_MY", "PrivacyData", "");
        com.huawei.hianalytics.mn.no.mn.no mn2 = com.huawei.hianalytics.mn.no.mn.no.mn();
        if (TextUtils.isEmpty(no2)) {
            String no3 = mn2.no(no.mn.AES);
            mn(no3);
            return no3;
        }
        no.mn mnVar = no.mn.AES;
        String mn3 = mn2.mn(mnVar).mn(rs(), no2);
        if (!TextUtils.isEmpty(mn3)) {
            return mn3;
        }
        String no4 = mn2.no(mnVar);
        mn(no4);
        return no4;
    }

    private String rs() {
        if (TextUtils.isEmpty(this.f13620op)) {
            this.f13620op = new mn().mn();
        }
        return this.f13620op;
    }

    public void no() {
        String no2 = com.huawei.hianalytics.mn.no.mn.no.mn().no(no.mn.AES);
        if (mn(no2)) {
            this.f13619no = no2;
        }
    }

    public String op() {
        if (TextUtils.isEmpty(this.f13619no)) {
            this.f13619no = qr();
        }
        return this.f13619no;
    }
}
