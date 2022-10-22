package z1;

import android.os.Build;
import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import androidx.work.WorkInfo;
import androidx.work.d;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.k;
import androidx.work.m;
import androidx.work.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import r1.c;
import r1.e;
import r1.f;
import r1.g;
import r1.i;
import y1.a;
import y1.j;
import y1.p;
import y1.q;
/* compiled from: EnqueueRunnable.java */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: c  reason: collision with root package name */
    private static final String f37215c = k.f("EnqueueRunnable");

    /* renamed from: a  reason: collision with root package name */
    private final g f37216a;

    /* renamed from: b  reason: collision with root package name */
    private final c f37217b = new c();

    public b(g gVar) {
        this.f37216a = gVar;
    }

    private static boolean b(g gVar) {
        boolean c10 = c(gVar.g(), gVar.f(), (String[]) g.l(gVar).toArray(new String[0]), gVar.d(), gVar.b());
        gVar.k();
        return c10;
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01e1 A[LOOP:7: B:123:0x01db->B:125:0x01e1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x020a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0159  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean c(i iVar, List<? extends s> list, String[] strArr, String str, ExistingWorkPolicy existingWorkPolicy) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        long j10;
        int i10;
        boolean z14;
        y1.b bVar;
        i iVar2 = iVar;
        String[] strArr2 = strArr;
        long currentTimeMillis = System.currentTimeMillis();
        WorkDatabase n10 = iVar.n();
        boolean z15 = strArr2 != null && strArr2.length > 0;
        if (z15) {
            z12 = true;
            z11 = false;
            z10 = false;
            for (String str2 : strArr2) {
                p n11 = n10.M().n(str2);
                if (n11 == null) {
                    k.c().b(f37215c, String.format("Prerequisite %s doesn't exist; not enqueuing", str2), new Throwable[0]);
                    return false;
                }
                WorkInfo.State state = n11.f36690b;
                z12 &= state == WorkInfo.State.SUCCEEDED;
                if (state == WorkInfo.State.FAILED) {
                    z10 = true;
                } else if (state == WorkInfo.State.CANCELLED) {
                    z11 = true;
                }
            }
        } else {
            z12 = true;
            z11 = false;
            z10 = false;
        }
        boolean z16 = !TextUtils.isEmpty(str);
        if (z16 && !z15) {
            List<p.b> e10 = n10.M().e(str);
            if (!e10.isEmpty()) {
                if (existingWorkPolicy == ExistingWorkPolicy.APPEND || existingWorkPolicy == ExistingWorkPolicy.APPEND_OR_REPLACE) {
                    y1.b E = n10.E();
                    List arrayList = new ArrayList();
                    for (p.b bVar2 : e10) {
                        if (!E.d(bVar2.f36707a)) {
                            WorkInfo.State state2 = bVar2.f36708b;
                            bVar = E;
                            z12 = (state2 == WorkInfo.State.SUCCEEDED) & z12;
                            if (state2 == WorkInfo.State.FAILED) {
                                z10 = true;
                            } else if (state2 == WorkInfo.State.CANCELLED) {
                                z11 = true;
                            }
                            arrayList.add(bVar2.f36707a);
                        } else {
                            bVar = E;
                        }
                        E = bVar;
                    }
                    if (existingWorkPolicy != ExistingWorkPolicy.APPEND_OR_REPLACE || (!z11 && !z10)) {
                        z14 = z10;
                    } else {
                        q M = n10.M();
                        for (p.b bVar3 : M.e(str)) {
                            M.a(bVar3.f36707a);
                        }
                        arrayList = Collections.emptyList();
                        z14 = false;
                        z11 = false;
                    }
                    strArr2 = (String[]) arrayList.toArray(strArr2);
                    z15 = strArr2.length > 0;
                    z10 = z14;
                } else {
                    if (existingWorkPolicy == ExistingWorkPolicy.KEEP) {
                        for (p.b bVar4 : e10) {
                            WorkInfo.State state3 = bVar4.f36708b;
                            if (state3 == WorkInfo.State.ENQUEUED || state3 == WorkInfo.State.RUNNING) {
                                return false;
                            }
                            while (r3.hasNext()) {
                            }
                        }
                    }
                    a.c(str, iVar2, false).run();
                    q M2 = n10.M();
                    for (p.b bVar5 : e10) {
                        M2.a(bVar5.f36707a);
                    }
                    z13 = true;
                    for (s sVar : list) {
                        p c10 = sVar.c();
                        if (!z15 || z12) {
                            if (!c10.d()) {
                                c10.f36702n = currentTimeMillis;
                            } else {
                                j10 = currentTimeMillis;
                                c10.f36702n = 0L;
                                i10 = Build.VERSION.SDK_INT;
                                if (i10 < 23 && i10 <= 25) {
                                    g(c10);
                                } else if (i10 <= 22 && h(iVar2, "androidx.work.impl.background.gcm.GcmScheduler")) {
                                    g(c10);
                                }
                                if (c10.f36690b == WorkInfo.State.ENQUEUED) {
                                    z13 = true;
                                }
                                n10.M().c(c10);
                                if (z15) {
                                    for (String str3 : strArr2) {
                                        n10.E().c(new a(sVar.a(), str3));
                                    }
                                }
                                for (String str4 : sVar.b()) {
                                    n10.N().a(new y1.s(str4, sVar.a()));
                                }
                                if (!z16) {
                                    n10.K().a(new j(str, sVar.a()));
                                }
                                iVar2 = iVar;
                                currentTimeMillis = j10;
                            }
                        } else if (z10) {
                            c10.f36690b = WorkInfo.State.FAILED;
                        } else if (z11) {
                            c10.f36690b = WorkInfo.State.CANCELLED;
                        } else {
                            c10.f36690b = WorkInfo.State.BLOCKED;
                        }
                        j10 = currentTimeMillis;
                        i10 = Build.VERSION.SDK_INT;
                        if (i10 < 23) {
                        }
                        if (i10 <= 22) {
                            g(c10);
                        }
                        if (c10.f36690b == WorkInfo.State.ENQUEUED) {
                        }
                        n10.M().c(c10);
                        if (z15) {
                        }
                        while (r0.hasNext()) {
                        }
                        if (!z16) {
                        }
                        iVar2 = iVar;
                        currentTimeMillis = j10;
                    }
                    return z13;
                }
            }
        }
        z13 = false;
        while (r7.hasNext()) {
        }
        return z13;
    }

    private static boolean e(g gVar) {
        List<g> e10 = gVar.e();
        boolean z10 = false;
        if (e10 != null) {
            boolean z11 = false;
            for (g gVar2 : e10) {
                if (!gVar2.j()) {
                    z11 |= e(gVar2);
                } else {
                    k.c().h(f37215c, String.format("Already enqueued work ids (%s).", TextUtils.join(", ", gVar2.c())), new Throwable[0]);
                }
            }
            z10 = z11;
        }
        return b(gVar) | z10;
    }

    private static void g(p pVar) {
        androidx.work.b bVar = pVar.f36698j;
        String str = pVar.f36691c;
        if (str.equals(ConstraintTrackingWorker.class.getName())) {
            return;
        }
        if (bVar.f() || bVar.i()) {
            d.a aVar = new d.a();
            aVar.c(pVar.f36693e).e("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
            pVar.f36691c = ConstraintTrackingWorker.class.getName();
            pVar.f36693e = aVar.a();
        }
    }

    private static boolean h(i iVar, String str) {
        try {
            Class<?> cls = Class.forName(str);
            for (e eVar : iVar.m()) {
                if (cls.isAssignableFrom(eVar.getClass())) {
                    return true;
                }
            }
        } catch (ClassNotFoundException unused) {
        }
        return false;
    }

    public boolean a() {
        WorkDatabase n10 = this.f37216a.g().n();
        n10.e();
        try {
            boolean e10 = e(this.f37216a);
            n10.B();
            return e10;
        } finally {
            n10.i();
        }
    }

    public m d() {
        return this.f37217b;
    }

    public void f() {
        i g10 = this.f37216a.g();
        f.b(g10.h(), g10.n(), g10.m());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (!this.f37216a.h()) {
                if (a()) {
                    d.a(this.f37216a.g().g(), RescheduleReceiver.class, true);
                    f();
                }
                this.f37217b.a(m.f4893a);
                return;
            }
            throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", this.f37216a));
        } catch (Throwable th2) {
            this.f37217b.a(new m.b.a(th2));
        }
    }
}
