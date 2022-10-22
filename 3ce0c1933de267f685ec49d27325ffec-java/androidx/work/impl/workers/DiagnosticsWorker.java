package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.k;
import java.util.List;
import java.util.concurrent.TimeUnit;
import r1.i;
import y1.g;
import y1.h;
import y1.p;
import y1.q;
import y1.t;
/* loaded from: classes.dex */
public class DiagnosticsWorker extends Worker {

    /* renamed from: g  reason: collision with root package name */
    private static final String f4887g = k.f("DiagnosticsWrkr");

    public DiagnosticsWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private static String s(p pVar, String str, Integer num, String str2) {
        return String.format("\n%s\t %s\t %s\t %s\t %s\t %s\t", pVar.f36689a, pVar.f36691c, num, pVar.f36690b.name(), str, str2);
    }

    private static String t(y1.k kVar, t tVar, h hVar, List<p> list) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(String.format("\n Id \t Class Name\t %s\t State\t Unique Name\t Tags\t", Build.VERSION.SDK_INT >= 23 ? "Job Id" : "Alarm Id"));
        for (p pVar : list) {
            Integer num = null;
            g c10 = hVar.c(pVar.f36689a);
            if (c10 != null) {
                num = Integer.valueOf(c10.f36676b);
            }
            sb2.append(s(pVar, TextUtils.join(",", kVar.b(pVar.f36689a)), num, TextUtils.join(",", tVar.b(pVar.f36689a))));
        }
        return sb2.toString();
    }

    @Override // androidx.work.Worker
    public ListenableWorker.a r() {
        WorkDatabase n10 = i.j(a()).n();
        q M = n10.M();
        y1.k K = n10.K();
        t N = n10.N();
        h J = n10.J();
        List<p> f10 = M.f(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List<p> j10 = M.j();
        List<p> s10 = M.s(200);
        if (f10 != null && !f10.isEmpty()) {
            k c10 = k.c();
            String str = f4887g;
            c10.d(str, "Recently completed work:\n\n", new Throwable[0]);
            k.c().d(str, t(K, N, J, f10), new Throwable[0]);
        }
        if (j10 != null && !j10.isEmpty()) {
            k c11 = k.c();
            String str2 = f4887g;
            c11.d(str2, "Running work:\n\n", new Throwable[0]);
            k.c().d(str2, t(K, N, J, j10), new Throwable[0]);
        }
        if (s10 != null && !s10.isEmpty()) {
            k c12 = k.c();
            String str3 = f4887g;
            c12.d(str3, "Enqueued work:\n\n", new Throwable[0]);
            k.c().d(str3, t(K, N, J, s10), new Throwable[0]);
        }
        return ListenableWorker.a.c();
    }
}
