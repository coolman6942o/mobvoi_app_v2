package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ListenableWorker;
import androidx.work.impl.utils.futures.c;
import com.google.common.util.concurrent.j;
/* loaded from: classes.dex */
public abstract class Worker extends ListenableWorker {

    /* renamed from: f  reason: collision with root package name */
    c<ListenableWorker.a> f4685f;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Worker.this.f4685f.p(Worker.this.r());
            } catch (Throwable th2) {
                Worker.this.f4685f.q(th2);
            }
        }
    }

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.ListenableWorker
    public final j<ListenableWorker.a> p() {
        this.f4685f = c.t();
        c().execute(new a());
        return this.f4685f;
    }

    public abstract ListenableWorker.a r();
}
