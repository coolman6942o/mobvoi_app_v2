package com.google.firebase.iid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ j f12495a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(j jVar, Looper looper) {
        super(looper);
        this.f12495a = jVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.f12495a.e(message);
    }
}
