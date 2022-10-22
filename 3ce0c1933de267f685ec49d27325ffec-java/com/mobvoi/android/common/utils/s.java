package com.mobvoi.android.common.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;
/* compiled from: WeakHandler.java */
/* loaded from: classes2.dex */
public class s extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<a> f15455a;

    /* compiled from: WeakHandler.java */
    /* loaded from: classes2.dex */
    public interface a {
        void handleMessage(Message message);
    }

    public s(a aVar) {
        this.f15455a = new WeakReference<>(aVar);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar = this.f15455a.get();
        if (aVar != null) {
            aVar.handleMessage(message);
        }
    }

    public s(a aVar, Looper looper) {
        super(looper);
        this.f15455a = new WeakReference<>(aVar);
    }
}
