package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private j<?, ?> f9467a;

    /* renamed from: b  reason: collision with root package name */
    private Object f9468b;

    /* renamed from: c  reason: collision with root package name */
    private List<p> f9469c = new ArrayList();

    private final byte[] a() throws IOException {
        byte[] bArr = new byte[b()];
        c(h.z(bArr));
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public final l clone() {
        Object clone;
        l lVar = new l();
        try {
            List<p> list = this.f9469c;
            if (list == null) {
                lVar.f9469c = null;
            } else {
                lVar.f9469c.addAll(list);
            }
            Object obj = this.f9468b;
            if (obj != null) {
                if (obj instanceof n) {
                    clone = (n) ((n) obj).clone();
                } else if (obj instanceof byte[]) {
                    clone = ((byte[]) obj).clone();
                } else {
                    int i10 = 0;
                    if (obj instanceof byte[][]) {
                        byte[][] bArr = (byte[][]) obj;
                        byte[][] bArr2 = new byte[bArr.length];
                        lVar.f9468b = bArr2;
                        while (i10 < bArr.length) {
                            bArr2[i10] = (byte[]) bArr[i10].clone();
                            i10++;
                        }
                    } else if (obj instanceof boolean[]) {
                        clone = ((boolean[]) obj).clone();
                    } else if (obj instanceof int[]) {
                        clone = ((int[]) obj).clone();
                    } else if (obj instanceof long[]) {
                        clone = ((long[]) obj).clone();
                    } else if (obj instanceof float[]) {
                        clone = ((float[]) obj).clone();
                    } else if (obj instanceof double[]) {
                        clone = ((double[]) obj).clone();
                    } else if (obj instanceof n[]) {
                        n[] nVarArr = (n[]) obj;
                        n[] nVarArr2 = new n[nVarArr.length];
                        lVar.f9468b = nVarArr2;
                        while (i10 < nVarArr.length) {
                            nVarArr2[i10] = (n) nVarArr[i10].clone();
                            i10++;
                        }
                    }
                }
                lVar.f9468b = clone;
            }
            return lVar;
        } catch (CloneNotSupportedException e10) {
            throw new AssertionError(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b() {
        if (this.f9468b == null) {
            int i10 = 0;
            for (p pVar : this.f9469c) {
                i10 += h.n(pVar.f9557a) + 0 + pVar.f9558b.length;
            }
            return i10;
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(h hVar) throws IOException {
        if (this.f9468b == null) {
            for (p pVar : this.f9469c) {
                hVar.m(pVar.f9557a);
                hVar.A(pVar.f9558b);
            }
            return;
        }
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(p pVar) throws IOException {
        List<p> list = this.f9469c;
        if (list != null) {
            list.add(pVar);
            return;
        }
        Object obj = this.f9468b;
        if (obj instanceof n) {
            byte[] bArr = pVar.f9558b;
            g c10 = g.c(bArr, 0, bArr.length);
            int p10 = c10.p();
            if (p10 == bArr.length - h.i(p10)) {
                this.f9468b = ((n) this.f9468b).c(c10);
                this.f9469c = null;
                return;
            }
            throw zzacd.a();
        }
        boolean z10 = obj instanceof n[];
        Collections.singletonList(pVar);
        throw null;
    }

    public final boolean equals(Object obj) {
        List<p> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f9468b == null || lVar.f9468b == null) {
            List<p> list2 = this.f9469c;
            if (list2 != null && (list = lVar.f9469c) != null) {
                return list2.equals(list);
            }
            try {
                return Arrays.equals(a(), lVar.a());
            } catch (IOException e10) {
                throw new IllegalStateException(e10);
            }
        } else if (this.f9467a != lVar.f9467a) {
            return false;
        } else {
            throw null;
        }
    }

    public final int hashCode() {
        try {
            return Arrays.hashCode(a()) + 527;
        } catch (IOException e10) {
            throw new IllegalStateException(e10);
        }
    }
}
