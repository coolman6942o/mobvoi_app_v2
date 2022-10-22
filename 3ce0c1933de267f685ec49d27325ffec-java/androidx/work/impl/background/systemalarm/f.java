package androidx.work.impl.background.systemalarm;

import android.content.Context;
import androidx.work.k;
import r1.e;
import y1.p;
/* compiled from: SystemAlarmScheduler.java */
/* loaded from: classes.dex */
public class f implements e {

    /* renamed from: b  reason: collision with root package name */
    private static final String f4811b = k.f("SystemAlarmScheduler");

    /* renamed from: a  reason: collision with root package name */
    private final Context f4812a;

    public f(Context context) {
        this.f4812a = context.getApplicationContext();
    }

    private void b(p pVar) {
        k.c().a(f4811b, String.format("Scheduling work with workSpecId %s", pVar.f36689a), new Throwable[0]);
        this.f4812a.startService(b.f(this.f4812a, pVar.f36689a));
    }

    @Override // r1.e
    public boolean a() {
        return true;
    }

    @Override // r1.e
    public void d(String str) {
        this.f4812a.startService(b.g(this.f4812a, str));
    }

    @Override // r1.e
    public void f(p... pVarArr) {
        for (p pVar : pVarArr) {
            b(pVar);
        }
    }
}
