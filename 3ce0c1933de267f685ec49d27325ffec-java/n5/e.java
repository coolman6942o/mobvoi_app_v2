package n5;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
/* compiled from: Executors.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static final Executor f31034a = new a();

    /* renamed from: b  reason: collision with root package name */
    private static final Executor f31035b = new b();

    /* compiled from: Executors.java */
    /* loaded from: classes.dex */
    class a implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f31036a = new Handler(Looper.getMainLooper());

        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f31036a.post(runnable);
        }
    }

    /* compiled from: Executors.java */
    /* loaded from: classes.dex */
    class b implements Executor {
        b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    public static Executor a() {
        return f31035b;
    }

    public static Executor b() {
        return f31034a;
    }
}
