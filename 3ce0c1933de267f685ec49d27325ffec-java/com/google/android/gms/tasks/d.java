package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Executor f10150a = new a();

    /* renamed from: b  reason: collision with root package name */
    static final Executor f10151b = new r();

    /* loaded from: classes.dex */
    private static final class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f10152a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f10152a.post(runnable);
        }
    }
}
