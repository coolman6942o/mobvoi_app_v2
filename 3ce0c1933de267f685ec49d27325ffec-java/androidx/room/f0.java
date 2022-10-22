package androidx.room;

import androidx.room.RoomDatabase;
import i1.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QueryInterceptorStatement.java */
/* loaded from: classes.dex */
public final class f0 implements f {

    /* renamed from: a  reason: collision with root package name */
    private final f f4213a;

    /* renamed from: b  reason: collision with root package name */
    private final RoomDatabase.e f4214b;

    /* renamed from: c  reason: collision with root package name */
    private final String f4215c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Object> f4216d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final Executor f4217e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(f fVar, RoomDatabase.e eVar, String str, Executor executor) {
        this.f4213a = fVar;
        this.f4214b = eVar;
        this.f4215c = str;
        this.f4217e = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        this.f4214b.a(this.f4215c, this.f4216d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        this.f4214b.a(this.f4215c, this.f4216d);
    }

    private void n(int i10, Object obj) {
        int i11 = i10 - 1;
        if (i11 >= this.f4216d.size()) {
            for (int size = this.f4216d.size(); size <= i11; size++) {
                this.f4216d.add(null);
            }
        }
        this.f4216d.set(i11, obj);
    }

    @Override // i1.f
    public long D0() {
        this.f4217e.execute(new Runnable() { // from class: androidx.room.d0
            @Override // java.lang.Runnable
            public final void run() {
                f0.this.h();
            }
        });
        return this.f4213a.D0();
    }

    @Override // i1.d
    public void K(int i10, long j10) {
        n(i10, Long.valueOf(j10));
        this.f4213a.K(i10, j10);
    }

    @Override // i1.d
    public void P(int i10, byte[] bArr) {
        n(i10, bArr);
        this.f4213a.P(i10, bArr);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f4213a.close();
    }

    @Override // i1.d
    public void l0(int i10) {
        n(i10, this.f4216d.toArray());
        this.f4213a.l0(i10);
    }

    @Override // i1.d
    public void m(int i10, String str) {
        n(i10, str);
        this.f4213a.m(i10, str);
    }

    @Override // i1.f
    public int r() {
        this.f4217e.execute(new Runnable() { // from class: androidx.room.e0
            @Override // java.lang.Runnable
            public final void run() {
                f0.this.i();
            }
        });
        return this.f4213a.r();
    }

    @Override // i1.d
    public void y(int i10, double d10) {
        n(i10, Double.valueOf(d10));
        this.f4213a.y(i10, d10);
    }
}
