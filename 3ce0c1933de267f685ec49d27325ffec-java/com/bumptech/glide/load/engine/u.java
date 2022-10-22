package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import t4.c;
/* compiled from: ResourceRecycler.java */
/* loaded from: classes.dex */
class u {

    /* renamed from: a  reason: collision with root package name */
    private boolean f8054a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f8055b = new Handler(Looper.getMainLooper(), new a());

    /* compiled from: ResourceRecycler.java */
    /* loaded from: classes.dex */
    private static final class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((c) message.obj).b();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(c<?> cVar) {
        if (this.f8054a) {
            this.f8055b.obtainMessage(1, cVar).sendToTarget();
        } else {
            this.f8054a = true;
            cVar.b();
            this.f8054a = false;
        }
    }
}
