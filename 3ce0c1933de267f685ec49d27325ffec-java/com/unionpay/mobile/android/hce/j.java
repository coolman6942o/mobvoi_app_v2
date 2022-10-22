package com.unionpay.mobile.android.hce;

import android.os.Bundle;
import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f23410a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(f fVar) {
        this.f23410a = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        Bundle d10;
        Handler handler;
        Handler handler2;
        Handler handler3;
        int unused;
        int unused2;
        f fVar = this.f23410a;
        str = fVar.f23390l;
        unused = this.f23410a.f23384f;
        unused2 = this.f23410a.f23386h;
        d10 = fVar.d(str);
        f.k(this.f23410a);
        handler = this.f23410a.f23402y;
        if (handler != null) {
            handler2 = this.f23410a.f23402y;
            handler3 = this.f23410a.f23402y;
            if (d10 == null) {
                d10 = null;
            }
            handler2.sendMessage(handler3.obtainMessage(2001, d10));
        }
    }
}
