package p9;

import r9.b;
import r9.e;
/* compiled from: DefaultIdGenerator.java */
/* loaded from: classes2.dex */
public class a implements b.c {
    @Override // r9.b.c
    public int a(String str, String str2, boolean z10) {
        if (z10) {
            return e.K(e.n("%sp%s@dir", str, str2)).hashCode();
        }
        return e.K(e.n("%sp%s", str, str2)).hashCode();
    }

    @Override // r9.b.c
    public int b(int i10, String str, String str2, boolean z10) {
        return a(str, str2, z10);
    }
}
