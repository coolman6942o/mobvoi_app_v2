package r1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.work.WorkerParameters;
import androidx.work.a;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.k;
import androidx.work.m;
import androidx.work.o;
import androidx.work.r;
import androidx.work.s;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import s1.b;
import z1.e;
import z1.h;
/* compiled from: WorkManagerImpl.java */
/* loaded from: classes.dex */
public class i extends r {

    /* renamed from: j  reason: collision with root package name */
    private static i f33317j = null;

    /* renamed from: k  reason: collision with root package name */
    private static i f33318k = null;

    /* renamed from: l  reason: collision with root package name */
    private static final Object f33319l = new Object();

    /* renamed from: a  reason: collision with root package name */
    private Context f33320a;

    /* renamed from: b  reason: collision with root package name */
    private a f33321b;

    /* renamed from: c  reason: collision with root package name */
    private WorkDatabase f33322c;

    /* renamed from: d  reason: collision with root package name */
    private a2.a f33323d;

    /* renamed from: e  reason: collision with root package name */
    private List<e> f33324e;

    /* renamed from: f  reason: collision with root package name */
    private d f33325f;

    /* renamed from: g  reason: collision with root package name */
    private e f33326g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f33327h;

    /* renamed from: i  reason: collision with root package name */
    private BroadcastReceiver.PendingResult f33328i;

    static {
        k.f("WorkManagerImpl");
    }

    public i(Context context, a aVar, a2.a aVar2) {
        this(context, aVar, aVar2, context.getResources().getBoolean(o.f4896a));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0016, code lost:
        r4 = r4.getApplicationContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (r1.i.f33318k != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
        r1.i.f33318k = new r1.i(r4, r5, new a2.b(r5.l()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002e, code lost:
        r1.i.f33317j = r1.i.f33318k;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(Context context, a aVar) {
        synchronized (f33319l) {
            i iVar = f33317j;
            if (!(iVar == null || f33318k == null)) {
                throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
            }
        }
    }

    @Deprecated
    public static i i() {
        synchronized (f33319l) {
            i iVar = f33317j;
            if (iVar != null) {
                return iVar;
            }
            return f33318k;
        }
    }

    public static i j(Context context) {
        i i10;
        synchronized (f33319l) {
            i10 = i();
            if (i10 == null) {
                Context applicationContext = context.getApplicationContext();
                if (applicationContext instanceof a.c) {
                    d(applicationContext, ((a.c) applicationContext).a());
                    i10 = j(applicationContext);
                } else {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
            }
        }
        return i10;
    }

    private void p(Context context, a aVar, a2.a aVar2, WorkDatabase workDatabase, List<e> list, d dVar) {
        Context applicationContext = context.getApplicationContext();
        this.f33320a = applicationContext;
        this.f33321b = aVar;
        this.f33323d = aVar2;
        this.f33322c = workDatabase;
        this.f33324e = list;
        this.f33325f = dVar;
        this.f33326g = new e(workDatabase);
        this.f33327h = false;
        if (Build.VERSION.SDK_INT < 24 || !applicationContext.isDeviceProtectedStorage()) {
            this.f33323d.b(new ForceStopRunnable(applicationContext, this));
            return;
        }
        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
    }

    @Override // androidx.work.r
    public m b(List<? extends s> list) {
        if (!list.isEmpty()) {
            return new g(this, list).a();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }

    public m e(UUID uuid) {
        z1.a b10 = z1.a.b(uuid, this);
        this.f33323d.b(b10);
        return b10.d();
    }

    public List<e> f(Context context, a aVar, a2.a aVar2) {
        return Arrays.asList(f.a(context, this), new b(context, aVar, aVar2, this));
    }

    public Context g() {
        return this.f33320a;
    }

    public a h() {
        return this.f33321b;
    }

    public e k() {
        return this.f33326g;
    }

    public d l() {
        return this.f33325f;
    }

    public List<e> m() {
        return this.f33324e;
    }

    public WorkDatabase n() {
        return this.f33322c;
    }

    public a2.a o() {
        return this.f33323d;
    }

    public void q() {
        synchronized (f33319l) {
            this.f33327h = true;
            BroadcastReceiver.PendingResult pendingResult = this.f33328i;
            if (pendingResult != null) {
                pendingResult.finish();
                this.f33328i = null;
            }
        }
    }

    public void r() {
        if (Build.VERSION.SDK_INT >= 23) {
            t1.b.b(g());
        }
        n().M().t();
        f.b(h(), n(), m());
    }

    public void s(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (f33319l) {
            this.f33328i = pendingResult;
            if (this.f33327h) {
                pendingResult.finish();
                this.f33328i = null;
            }
        }
    }

    public void t(String str) {
        u(str, null);
    }

    public void u(String str, WorkerParameters.a aVar) {
        this.f33323d.b(new h(this, str, aVar));
    }

    public void v(String str) {
        this.f33323d.b(new z1.i(this, str, true));
    }

    public void w(String str) {
        this.f33323d.b(new z1.i(this, str, false));
    }

    public i(Context context, a aVar, a2.a aVar2, boolean z10) {
        this(context, aVar, aVar2, WorkDatabase.D(context.getApplicationContext(), aVar2.c(), z10));
    }

    public i(Context context, a aVar, a2.a aVar2, WorkDatabase workDatabase) {
        Context applicationContext = context.getApplicationContext();
        k.e(new k.a(aVar.j()));
        List<e> f10 = f(applicationContext, aVar, aVar2);
        p(context, aVar, aVar2, workDatabase, f10, new d(context, aVar, aVar2, workDatabase, f10));
    }
}
