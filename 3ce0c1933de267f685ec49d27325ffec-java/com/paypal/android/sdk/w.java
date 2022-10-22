package com.paypal.android.sdk;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class w extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f22039a;

    public w(t tVar) {
        this.f22039a = new WeakReference(tVar);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        t tVar = (t) this.f22039a.get();
        if (tVar != null) {
            tVar.h(message);
        }
    }
}
