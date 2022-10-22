package z1;

import android.content.Context;
import androidx.work.WorkInfo;
import androidx.work.e;
import androidx.work.f;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.futures.c;
import androidx.work.k;
import com.google.common.util.concurrent.j;
import java.util.UUID;
import y1.q;
/* compiled from: WorkForegroundUpdater.java */
/* loaded from: classes.dex */
public class l implements f {

    /* renamed from: a  reason: collision with root package name */
    private final a2.a f37248a;

    /* renamed from: b  reason: collision with root package name */
    final x1.a f37249b;

    /* renamed from: c  reason: collision with root package name */
    final q f37250c;

    /* compiled from: WorkForegroundUpdater.java */
    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f37251a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ UUID f37252b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f37253c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Context f37254d;

        a(c cVar, UUID uuid, e eVar, Context context) {
            this.f37251a = cVar;
            this.f37252b = uuid;
            this.f37253c = eVar;
            this.f37254d = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!this.f37251a.isCancelled()) {
                    String uuid = this.f37252b.toString();
                    WorkInfo.State m10 = l.this.f37250c.m(uuid);
                    if (m10 == null || m10.isFinished()) {
                        throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                    l.this.f37249b.a(uuid, this.f37253c);
                    this.f37254d.startService(androidx.work.impl.foreground.a.a(this.f37254d, uuid, this.f37253c));
                }
                this.f37251a.p(null);
            } catch (Throwable th2) {
                this.f37251a.q(th2);
            }
        }
    }

    static {
        k.f("WMFgUpdater");
    }

    public l(WorkDatabase workDatabase, x1.a aVar, a2.a aVar2) {
        this.f37249b = aVar;
        this.f37248a = aVar2;
        this.f37250c = workDatabase.M();
    }

    @Override // androidx.work.f
    public j<Void> a(Context context, UUID uuid, e eVar) {
        c t10 = c.t();
        this.f37248a.b(new a(t10, uuid, eVar, context));
        return t10;
    }
}
