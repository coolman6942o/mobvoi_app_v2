package z1;

import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.k;
import r1.d;
import y1.q;
/* compiled from: StopWorkRunnable.java */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: d  reason: collision with root package name */
    private static final String f37231d = k.f("StopWorkRunnable");

    /* renamed from: a  reason: collision with root package name */
    private final r1.i f37232a;

    /* renamed from: b  reason: collision with root package name */
    private final String f37233b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f37234c;

    public i(r1.i iVar, String str, boolean z10) {
        this.f37232a = iVar;
        this.f37233b = str;
        this.f37234c = z10;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z10;
        WorkDatabase n10 = this.f37232a.n();
        d l10 = this.f37232a.l();
        q M = n10.M();
        n10.e();
        try {
            boolean h10 = l10.h(this.f37233b);
            if (this.f37234c) {
                z10 = this.f37232a.l().n(this.f37233b);
            } else {
                if (!h10 && M.m(this.f37233b) == WorkInfo.State.RUNNING) {
                    M.b(WorkInfo.State.ENQUEUED, this.f37233b);
                }
                z10 = this.f37232a.l().o(this.f37233b);
            }
            k.c().a(f37231d, String.format("StopWorkRunnable for %s; Processor.stopWork = %s", this.f37233b, Boolean.valueOf(z10)), new Throwable[0]);
            n10.B();
        } finally {
            n10.i();
        }
    }
}
