package com.huawei.hianalytics.mn.no.pq;

import android.text.TextUtils;
import com.huawei.hianalytics.mn.mn.no;
import com.huawei.hianalytics.mn.no.b.pq;
import com.huawei.hianalytics.mn.no.mn.no;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes.dex */
public class st {

    /* renamed from: mn  reason: collision with root package name */
    private static st f13603mn = new st();

    /* renamed from: no  reason: collision with root package name */
    private mn f13604no = new mn();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class mn {

        /* renamed from: mn  reason: collision with root package name */
        String f13605mn;

        /* renamed from: no  reason: collision with root package name */
        String f13606no;

        /* renamed from: op  reason: collision with root package name */
        String f13607op;
        long pq = 0;

        mn() {
        }

        void mn(long j10) {
            st.this.f13604no.pq = j10;
        }

        void mn(String str) {
            st.this.f13604no.f13605mn = str;
        }

        void no(String str) {
            st.this.f13604no.f13606no = str;
        }

        void op(String str) {
            st.this.f13604no.f13607op = str;
        }
    }

    public static st mn() {
        return f13603mn;
    }

    private String rs() {
        InputStream inputStream;
        Throwable th2;
        try {
            inputStream = no.a().getResources().getAssets().open("hianalytics_njjn");
            try {
                try {
                    String mn2 = pq.mn(inputStream);
                    pq.mn((Closeable) inputStream);
                    return mn2;
                } catch (IOException unused) {
                    com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "read pubKey error,the file is corrupted");
                    pq.mn((Closeable) inputStream);
                    return null;
                }
            } catch (Throwable th3) {
                th2 = th3;
                pq.mn((Closeable) inputStream);
                throw th2;
            }
        } catch (IOException unused2) {
            inputStream = null;
        } catch (Throwable th4) {
            th2 = th4;
            inputStream = null;
            pq.mn((Closeable) inputStream);
            throw th2;
        }
    }

    public void no() {
        long qr = qr();
        if (qr == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            String rs = rs();
            if (TextUtils.isEmpty(rs)) {
                com.huawei.hianalytics.mn.no.qr.mn.op("hmsSdk", "get rsa pubkey config error");
                return;
            }
            String no2 = com.huawei.hianalytics.mn.no.mn.no.mn().no(no.mn.AES);
            String no3 = com.huawei.hianalytics.mn.no.mn.no.mn().mn(no.mn.RSA).no(rs, no2);
            this.f13604no.mn(rs);
            this.f13604no.mn(currentTimeMillis);
            this.f13604no.no(no2);
            this.f13604no.op(no3);
            return;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (currentTimeMillis2 - qr > 43200000) {
            String str = this.f13604no.f13605mn;
            String no4 = com.huawei.hianalytics.mn.no.mn.no.mn().no(no.mn.AES);
            String no5 = com.huawei.hianalytics.mn.no.mn.no.mn().mn(no.mn.RSA).no(str, no4);
            this.f13604no.mn(currentTimeMillis2);
            this.f13604no.no(no4);
            this.f13604no.op(no5);
        }
    }

    public String op() {
        return this.f13604no.f13606no;
    }

    public String pq() {
        return this.f13604no.f13607op;
    }

    public long qr() {
        return this.f13604no.pq;
    }
}
