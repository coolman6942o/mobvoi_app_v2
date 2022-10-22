package i6;

import android.os.Process;
/* loaded from: classes.dex */
final class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f28104a;

    /* renamed from: b  reason: collision with root package name */
    private final int f28105b;

    public d(Runnable runnable, int i10) {
        this.f28104a = runnable;
        this.f28105b = i10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.f28105b);
        this.f28104a.run();
    }
}
