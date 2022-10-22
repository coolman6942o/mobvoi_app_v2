package r1;

import android.os.Handler;
import android.os.Looper;
import androidx.work.p;
import g0.e;
/* compiled from: DefaultRunnableScheduler.java */
/* loaded from: classes.dex */
public class a implements p {

    /* renamed from: a  reason: collision with root package name */
    private final Handler f33286a = e.a(Looper.getMainLooper());

    @Override // androidx.work.p
    public void a(long j10, Runnable runnable) {
        this.f33286a.postDelayed(runnable, j10);
    }

    @Override // androidx.work.p
    public void b(Runnable runnable) {
        this.f33286a.removeCallbacks(runnable);
    }
}
