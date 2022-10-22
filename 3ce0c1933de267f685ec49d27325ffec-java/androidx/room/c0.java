package androidx.room;

import i1.d;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: QueryInterceptorProgram.java */
/* loaded from: classes.dex */
public final class c0 implements d {

    /* renamed from: a  reason: collision with root package name */
    private List<Object> f4199a = new ArrayList();

    private void d(int i10, Object obj) {
        int i11 = i10 - 1;
        if (i11 >= this.f4199a.size()) {
            for (int size = this.f4199a.size(); size <= i11; size++) {
                this.f4199a.add(null);
            }
        }
        this.f4199a.set(i11, obj);
    }

    @Override // i1.d
    public void K(int i10, long j10) {
        d(i10, Long.valueOf(j10));
    }

    @Override // i1.d
    public void P(int i10, byte[] bArr) {
        d(i10, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Object> c() {
        return this.f4199a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // i1.d
    public void l0(int i10) {
        d(i10, null);
    }

    @Override // i1.d
    public void m(int i10, String str) {
        d(i10, str);
    }

    @Override // i1.d
    public void y(int i10, double d10) {
        d(i10, Double.valueOf(d10));
    }
}
