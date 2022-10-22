package org.greenrobot.eventbus;

import android.os.Looper;
/* compiled from: MainThreadSupport.java */
/* loaded from: classes3.dex */
public interface g {

    /* compiled from: MainThreadSupport.java */
    /* loaded from: classes3.dex */
    public static class a implements g {

        /* renamed from: a  reason: collision with root package name */
        private final Looper f32484a;

        public a(Looper looper) {
            this.f32484a = looper;
        }

        @Override // org.greenrobot.eventbus.g
        public j a(c cVar) {
            return new e(cVar, this.f32484a, 10);
        }

        @Override // org.greenrobot.eventbus.g
        public boolean b() {
            return this.f32484a == Looper.myLooper();
        }
    }

    j a(c cVar);

    boolean b();
}
