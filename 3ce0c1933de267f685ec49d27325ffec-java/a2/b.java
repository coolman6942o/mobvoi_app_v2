package a2;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import z1.g;
/* compiled from: WorkManagerTaskExecutor.java */
/* loaded from: classes.dex */
public class b implements a2.a {

    /* renamed from: a  reason: collision with root package name */
    private final g f76a;

    /* renamed from: b  reason: collision with root package name */
    private final Handler f77b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private final Executor f78c = new a();

    /* compiled from: WorkManagerTaskExecutor.java */
    /* loaded from: classes.dex */
    class a implements Executor {
        a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            b.this.d(runnable);
        }
    }

    public b(Executor executor) {
        this.f76a = new g(executor);
    }

    @Override // a2.a
    public Executor a() {
        return this.f78c;
    }

    @Override // a2.a
    public void b(Runnable runnable) {
        this.f76a.execute(runnable);
    }

    @Override // a2.a
    public g c() {
        return this.f76a;
    }

    public void d(Runnable runnable) {
        this.f77b.post(runnable);
    }
}
