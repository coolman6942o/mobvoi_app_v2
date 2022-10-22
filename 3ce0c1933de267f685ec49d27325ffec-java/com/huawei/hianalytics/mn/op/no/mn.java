package com.huawei.hianalytics.mn.op.no;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hianalytics.mn.no.mn.no;
import java.util.UUID;
/* loaded from: classes.dex */
public class mn {

    /* renamed from: no  reason: collision with root package name */
    private static mn f13634no;

    /* renamed from: mn  reason: collision with root package name */
    private Context f13635mn;

    /* renamed from: com.huawei.hianalytics.mn.op.no.mn$mn  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0176mn extends no {

        /* renamed from: mn  reason: collision with root package name */
        String f13636mn;

        /* renamed from: no  reason: collision with root package name */
        String f13637no;

        public C0176mn(String str, String str2) {
            this.f13636mn = str;
            this.f13637no = str2;
        }

        @Override // com.huawei.hianalytics.mn.op.no.no
        public String mn() {
            return com.huawei.hianalytics.mn.mn.mn.no(this.f13636mn, this.f13637no);
        }

        @Override // com.huawei.hianalytics.mn.op.no.no
        public String mn(String str) {
            return no.mn().mn(str);
        }

        @Override // com.huawei.hianalytics.mn.op.no.no
        public String no() {
            return com.huawei.hianalytics.mn.mn.mn.mn(this.f13636mn, this.f13637no);
        }

        @Override // com.huawei.hianalytics.mn.op.no.no
        public String op() {
            return com.huawei.hianalytics.mn.mn.mn.pq(this.f13636mn, this.f13637no);
        }

        @Override // com.huawei.hianalytics.mn.op.no.no
        public int pq() {
            int i10 = 0;
            int i11 = (com.huawei.hianalytics.mn.mn.mn.tu(this.f13636mn, this.f13637no) ? 4 : 0) | 0;
            if (com.huawei.hianalytics.mn.mn.mn.st(this.f13636mn, this.f13637no)) {
                i10 = 2;
            }
            return i11 | i10 | (com.huawei.hianalytics.mn.mn.mn.a(this.f13636mn, this.f13637no) ? 1 : 0);
        }
    }

    public static mn mn() {
        mn mnVar;
        synchronized (mn.class) {
            if (f13634no == null) {
                f13634no = new mn();
            }
            mnVar = f13634no;
        }
        return mnVar;
    }

    public com.huawei.hianalytics.mn.op.mn.mn mn(String str, String str2) {
        return new C0176mn(str, str2).mn(this.f13635mn);
    }

    public String mn(boolean z10) {
        if (!z10) {
            return "";
        }
        String st = com.huawei.hianalytics.mn.mn.no.st();
        if (TextUtils.isEmpty(st)) {
            st = com.huawei.hianalytics.mn.no.uv.mn.no(this.f13635mn, "global_v2", "uuid", "");
            if (TextUtils.isEmpty(st)) {
                st = UUID.randomUUID().toString().replace("-", "");
                com.huawei.hianalytics.mn.no.uv.mn.mn(this.f13635mn, "global_v2", "uuid", st);
            }
            com.huawei.hianalytics.mn.mn.no.mn(st);
        }
        return st;
    }

    public void mn(Context context) {
        if (this.f13635mn == null) {
            this.f13635mn = context;
        }
    }

    public Pair<String, String> no(String str, String str2) {
        if (!com.huawei.hianalytics.mn.mn.mn.rs(str, str2)) {
            return new Pair<>("", "");
        }
        String e10 = com.huawei.hianalytics.mn.no.op.mn.mn.mn().op().e();
        String f10 = com.huawei.hianalytics.mn.no.op.mn.mn.mn().op().f();
        if (!TextUtils.isEmpty(e10) && !TextUtils.isEmpty(f10)) {
            return new Pair<>(e10, f10);
        }
        Pair<String, String> st = op.st(this.f13635mn);
        com.huawei.hianalytics.mn.no.op.mn.mn.mn().op().c((String) st.first);
        com.huawei.hianalytics.mn.no.op.mn.mn.mn().op().d((String) st.second);
        return st;
    }

    public String op(String str, String str2) {
        return pq.no(str, str2);
    }

    public String pq(String str, String str2) {
        return com.huawei.hianalytics.mn.no.no.no.mn(this.f13635mn, str, str2);
    }

    public String qr(String str, String str2) {
        return com.huawei.hianalytics.mn.no.no.no.no(this.f13635mn, str, str2);
    }

    public String rs(String str, String str2) {
        return pq.mn(str, str2);
    }
}
