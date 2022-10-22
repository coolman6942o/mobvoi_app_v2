package pk;

import ef.a;
import java.util.ArrayList;
import java.util.List;
/* compiled from: CalConvertImpl.java */
/* loaded from: classes2.dex */
public class g implements i<g0, List<a>> {
    @Override // pk.i
    public /* synthetic */ String a() {
        return h.d(this);
    }

    @Override // pk.i
    public /* synthetic */ String b() {
        return h.b(this);
    }

    @Override // pk.i
    public /* synthetic */ long c(long j10) {
        return h.a(this, j10);
    }

    /* renamed from: d */
    public List<a> convert(g0 g0Var) {
        List a10 = g0Var.a();
        int size = a10.size();
        ArrayList arrayList = new ArrayList(size);
        long b10 = g0Var.b();
        long c10 = g0Var.c();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new a(c((i10 * b10) + c10), ((Float) a10.get(i10)).floatValue()));
        }
        return arrayList;
    }

    @Override // pk.i
    public /* synthetic */ String getDeviceId() {
        return h.c(this);
    }

    @Override // pk.i
    public /* synthetic */ String getWwid() {
        return h.e(this);
    }
}
