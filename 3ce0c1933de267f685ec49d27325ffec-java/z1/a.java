package z1;

import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import androidx.work.m;
import java.util.LinkedList;
import java.util.UUID;
import r1.c;
import r1.e;
import r1.f;
import r1.i;
import y1.q;
/* compiled from: CancelWorkRunnable.java */
/* loaded from: classes.dex */
public abstract class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final c f37209a = new c();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CancelWorkRunnable.java */
    /* renamed from: z1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0542a extends a {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f37210b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ UUID f37211c;

        C0542a(i iVar, UUID uuid) {
            this.f37210b = iVar;
            this.f37211c = uuid;
        }

        /* JADX WARN: Finally extract failed */
        @Override // z1.a
        void g() {
            WorkDatabase n10 = this.f37210b.n();
            n10.e();
            try {
                a(this.f37210b, this.f37211c.toString());
                n10.B();
                n10.i();
                f(this.f37210b);
            } catch (Throwable th2) {
                n10.i();
                throw th2;
            }
        }
    }

    /* compiled from: CancelWorkRunnable.java */
    /* loaded from: classes.dex */
    class b extends a {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ i f37212b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f37213c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f37214d;

        b(i iVar, String str, boolean z10) {
            this.f37212b = iVar;
            this.f37213c = str;
            this.f37214d = z10;
        }

        /* JADX WARN: Finally extract failed */
        @Override // z1.a
        void g() {
            WorkDatabase n10 = this.f37212b.n();
            n10.e();
            try {
                for (String str : n10.M().l(this.f37213c)) {
                    a(this.f37212b, str);
                }
                n10.B();
                n10.i();
                if (this.f37214d) {
                    f(this.f37212b);
                }
            } catch (Throwable th2) {
                n10.i();
                throw th2;
            }
        }
    }

    public static a b(UUID uuid, i iVar) {
        return new C0542a(iVar, uuid);
    }

    public static a c(String str, i iVar, boolean z10) {
        return new b(iVar, str, z10);
    }

    private void e(WorkDatabase workDatabase, String str) {
        q M = workDatabase.M();
        y1.b E = workDatabase.E();
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            WorkInfo.State m10 = M.m(str2);
            if (!(m10 == WorkInfo.State.SUCCEEDED || m10 == WorkInfo.State.FAILED)) {
                M.b(WorkInfo.State.CANCELLED, str2);
            }
            linkedList.addAll(E.a(str2));
        }
    }

    void a(i iVar, String str) {
        e(iVar.n(), str);
        iVar.l().l(str);
        for (e eVar : iVar.m()) {
            eVar.d(str);
        }
    }

    public m d() {
        return this.f37209a;
    }

    void f(i iVar) {
        f.b(iVar.h(), iVar.n(), iVar.m());
    }

    abstract void g();

    @Override // java.lang.Runnable
    public void run() {
        try {
            g();
            this.f37209a.a(m.f4893a);
        } catch (Throwable th2) {
            this.f37209a.a(new m.b.a(th2));
        }
    }
}
