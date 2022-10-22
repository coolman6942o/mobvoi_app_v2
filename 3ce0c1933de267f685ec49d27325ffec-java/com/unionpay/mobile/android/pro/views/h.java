package com.unionpay.mobile.android.pro.views;

import android.content.Context;
import com.unionpay.mobile.android.nocard.views.l;
import com.unionpay.mobile.android.pro.pboc.engine.b;
import com.unionpay.mobile.android.utils.k;
/* loaded from: classes2.dex */
public class h extends l {
    public h(Context context) {
        super(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033 A[Catch: all -> 0x0048, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0016, B:10:0x0028, B:12:0x0033, B:13:0x003b, B:14:0x003f, B:15:0x0046), top: B:20:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003b A[Catch: all -> 0x0048, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0016, B:10:0x0028, B:12:0x0033, B:13:0x003b, B:14:0x003f, B:15:0x0046), top: B:20:0x0001 }] */
    @Override // com.unionpay.mobile.android.nocard.views.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void v() {
        boolean z10;
        b y10;
        synchronized (this) {
            k.c("uppay-pro", "checkAndGetSDCardsList +++");
            if (!"00".equalsIgnoreCase(this.f23639a.I.f23863c) && !"95".equalsIgnoreCase(this.f23639a.I.f23863c)) {
                z10 = false;
                y10 = y();
                i iVar = new i(this);
                if (y10 == null) {
                    y().a(iVar, z10);
                } else {
                    iVar.a(null);
                }
                k.c("uppay-pro", "checkAndGetSDCardsList ---");
            }
            z10 = true;
            y10 = y();
            i iVar2 = new i(this);
            if (y10 == null) {
            }
            k.c("uppay-pro", "checkAndGetSDCardsList ---");
        }
    }

    public b y() {
        return null;
    }
}
