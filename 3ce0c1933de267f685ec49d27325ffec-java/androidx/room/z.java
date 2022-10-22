package androidx.room;

import android.database.Cursor;
import android.database.SQLException;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.room.RoomDatabase;
import i1.b;
import i1.e;
import i1.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QueryInterceptorDatabase.java */
/* loaded from: classes.dex */
public final class z implements b {

    /* renamed from: a  reason: collision with root package name */
    private final b f4344a;

    /* renamed from: b  reason: collision with root package name */
    private final RoomDatabase.e f4345b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f4346c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(b bVar, RoomDatabase.e eVar, Executor executor) {
        this.f4344a = bVar;
        this.f4345b = eVar;
        this.f4346c = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        this.f4345b.a("END TRANSACTION", Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(String str) {
        this.f4345b.a(str, new ArrayList(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(String str, List list) {
        this.f4345b.a(str, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(String str) {
        this.f4345b.a(str, Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(e eVar, c0 c0Var) {
        this.f4345b.a(eVar.d(), c0Var.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(e eVar, c0 c0Var) {
        this.f4345b.a(eVar.d(), c0Var.c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W() {
        this.f4345b.a("TRANSACTION SUCCESSFUL", Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        this.f4345b.a("BEGIN EXCLUSIVE TRANSACTION", Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x() {
        this.f4345b.a("BEGIN DEFERRED TRANSACTION", Collections.emptyList());
    }

    @Override // i1.b
    public Cursor D(final e eVar, CancellationSignal cancellationSignal) {
        final c0 c0Var = new c0();
        eVar.c(c0Var);
        this.f4346c.execute(new Runnable() { // from class: androidx.room.v
            @Override // java.lang.Runnable
            public final void run() {
                z.this.V(eVar, c0Var);
            }
        });
        return this.f4344a.f0(eVar);
    }

    @Override // i1.b
    public void L() {
        this.f4346c.execute(new Runnable() { // from class: androidx.room.s
            @Override // java.lang.Runnable
            public final void run() {
                z.this.W();
            }
        });
        this.f4344a.L();
    }

    @Override // i1.b
    public void M(final String str, Object[] objArr) throws SQLException {
        final ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(objArr));
        this.f4346c.execute(new Runnable() { // from class: androidx.room.y
            @Override // java.lang.Runnable
            public final void run() {
                z.this.O(str, arrayList);
            }
        });
        this.f4344a.M(str, arrayList.toArray());
    }

    @Override // i1.b
    public void N() {
        this.f4346c.execute(new Runnable() { // from class: androidx.room.r
            @Override // java.lang.Runnable
            public final void run() {
                z.this.x();
            }
        });
        this.f4344a.N();
    }

    @Override // i1.b
    public Cursor U(final String str) {
        this.f4346c.execute(new Runnable() { // from class: androidx.room.x
            @Override // java.lang.Runnable
            public final void run() {
                z.this.Q(str);
            }
        });
        return this.f4344a.U(str);
    }

    @Override // i1.b
    public void Y() {
        this.f4346c.execute(new Runnable() { // from class: androidx.room.q
            @Override // java.lang.Runnable
            public final void run() {
                z.this.E();
            }
        });
        this.f4344a.Y();
    }

    @Override // i1.b
    public String a() {
        return this.f4344a.a();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4344a.close();
    }

    @Override // i1.b
    public Cursor f0(final e eVar) {
        final c0 c0Var = new c0();
        eVar.c(c0Var);
        this.f4346c.execute(new Runnable() { // from class: androidx.room.u
            @Override // java.lang.Runnable
            public final void run() {
                z.this.T(eVar, c0Var);
            }
        });
        return this.f4344a.f0(eVar);
    }

    @Override // i1.b
    public void g() {
        this.f4346c.execute(new Runnable() { // from class: androidx.room.t
            @Override // java.lang.Runnable
            public final void run() {
                z.this.w();
            }
        });
        this.f4344a.g();
    }

    @Override // i1.b
    public boolean isOpen() {
        return this.f4344a.isOpen();
    }

    @Override // i1.b
    public List<Pair<String, String>> j() {
        return this.f4344a.j();
    }

    @Override // i1.b
    public void l(final String str) throws SQLException {
        this.f4346c.execute(new Runnable() { // from class: androidx.room.w
            @Override // java.lang.Runnable
            public final void run() {
                z.this.I(str);
            }
        });
        this.f4344a.l(str);
    }

    @Override // i1.b
    public boolean q0() {
        return this.f4344a.q0();
    }

    @Override // i1.b
    public f s(String str) {
        return new f0(this.f4344a.s(str), this.f4345b, str, this.f4346c);
    }

    @Override // i1.b
    public boolean x0() {
        return this.f4344a.x0();
    }
}
