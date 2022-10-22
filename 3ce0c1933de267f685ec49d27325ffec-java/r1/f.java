package r1;

import android.content.Context;
import android.os.Build;
import androidx.work.a;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemjob.SystemJobService;
import androidx.work.k;
import java.util.List;
import t1.b;
import y1.p;
import y1.q;
import z1.d;
/* compiled from: Schedulers.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f33304a = k.f("Schedulers");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e a(Context context, i iVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            b bVar = new b(context, iVar);
            d.a(context, SystemJobService.class, true);
            k.c().a(f33304a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            return bVar;
        }
        e c10 = c(context);
        if (c10 != null) {
            return c10;
        }
        androidx.work.impl.background.systemalarm.f fVar = new androidx.work.impl.background.systemalarm.f(context);
        d.a(context, SystemAlarmService.class, true);
        k.c().a(f33304a, "Created SystemAlarmScheduler", new Throwable[0]);
        return fVar;
    }

    public static void b(a aVar, WorkDatabase workDatabase, List<e> list) {
        if (list != null && list.size() != 0) {
            q M = workDatabase.M();
            workDatabase.e();
            try {
                List<p> g10 = M.g(aVar.h());
                List<p> s10 = M.s(200);
                if (g10 != null && g10.size() > 0) {
                    long currentTimeMillis = System.currentTimeMillis();
                    for (p pVar : g10) {
                        M.d(pVar.f36689a, currentTimeMillis);
                    }
                }
                workDatabase.B();
                if (g10 != null && g10.size() > 0) {
                    p[] pVarArr = (p[]) g10.toArray(new p[g10.size()]);
                    for (e eVar : list) {
                        if (eVar.a()) {
                            eVar.f(pVarArr);
                        }
                    }
                }
                if (s10 != null && s10.size() > 0) {
                    p[] pVarArr2 = (p[]) s10.toArray(new p[s10.size()]);
                    for (e eVar2 : list) {
                        if (!eVar2.a()) {
                            eVar2.f(pVarArr2);
                        }
                    }
                }
            } finally {
                workDatabase.i();
            }
        }
    }

    private static e c(Context context) {
        try {
            e eVar = (e) Class.forName("androidx.work.impl.background.gcm.GcmScheduler").getConstructor(Context.class).newInstance(context);
            k.c().a(f33304a, String.format("Created %s", "androidx.work.impl.background.gcm.GcmScheduler"), new Throwable[0]);
            return eVar;
        } catch (Throwable th2) {
            k.c().a(f33304a, "Unable to create GCM Scheduler", th2);
            return null;
        }
    }
}
