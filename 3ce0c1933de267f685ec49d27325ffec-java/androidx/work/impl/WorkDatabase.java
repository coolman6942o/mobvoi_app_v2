package androidx.work.impl;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.g0;
import androidx.work.impl.a;
import i1.c;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import r1.h;
import y1.e;
import y1.k;
import y1.n;
import y1.q;
import y1.t;
/* loaded from: classes.dex */
public abstract class WorkDatabase extends RoomDatabase {

    /* renamed from: n  reason: collision with root package name */
    private static final long f4747n = TimeUnit.DAYS.toMillis(1);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements c.AbstractC0307c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f4748a;

        a(Context context) {
            this.f4748a = context;
        }

        @Override // i1.c.AbstractC0307c
        public c a(c.b bVar) {
            c.b.a a10 = c.b.a(this.f4748a);
            a10.c(bVar.f28015b).b(bVar.f28016c).d(true);
            return new j1.c().a(a10.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends RoomDatabase.b {
        b() {
        }

        @Override // androidx.room.RoomDatabase.b
        public void c(i1.b bVar) {
            super.c(bVar);
            bVar.g();
            try {
                bVar.l(WorkDatabase.H());
                bVar.L();
            } finally {
                bVar.Y();
            }
        }
    }

    public static WorkDatabase D(Context context, Executor executor, boolean z10) {
        RoomDatabase.a aVar;
        if (z10) {
            aVar = g0.c(context, WorkDatabase.class).c();
        } else {
            aVar = g0.a(context, WorkDatabase.class, h.d());
            aVar.f(new a(context));
        }
        return (WorkDatabase) aVar.g(executor).a(F()).b(androidx.work.impl.a.f4757a).b(new a.h(context, 2, 3)).b(androidx.work.impl.a.f4758b).b(androidx.work.impl.a.f4759c).b(new a.h(context, 5, 6)).b(androidx.work.impl.a.f4760d).b(androidx.work.impl.a.f4761e).b(androidx.work.impl.a.f4762f).b(new a.i(context)).b(new a.h(context, 10, 11)).b(androidx.work.impl.a.f4763g).e().d();
    }

    static RoomDatabase.b F() {
        return new b();
    }

    static long G() {
        return System.currentTimeMillis() - f4747n;
    }

    static String H() {
        return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + G() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
    }

    public abstract y1.b E();

    public abstract e I();

    public abstract y1.h J();

    public abstract k K();

    public abstract n L();

    public abstract q M();

    public abstract t N();
}
