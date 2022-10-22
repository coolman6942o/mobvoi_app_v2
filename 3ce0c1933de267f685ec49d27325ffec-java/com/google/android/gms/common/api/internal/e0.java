package com.google.android.gms.common.api.internal;

import a7.e;
import android.content.Context;
import b6.g;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.c;
import java.util.ArrayList;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e0 extends l0 {

    /* renamed from: b  reason: collision with root package name */
    private final Map<a.f, d0> f8591b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ b0 f8592c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(b0 b0Var, Map<a.f, d0> map) {
        super(b0Var, null);
        this.f8592c = b0Var;
        this.f8591b = map;
    }

    @Override // com.google.android.gms.common.api.internal.l0
    public final void a() {
        c cVar;
        boolean z10;
        Context context;
        w0 w0Var;
        e eVar;
        e eVar2;
        w0 w0Var2;
        Context context2;
        Context context3;
        boolean z11;
        cVar = this.f8592c.f8519d;
        g gVar = new g(cVar);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (a.f fVar : this.f8591b.keySet()) {
            if (fVar.o()) {
                z11 = this.f8591b.get(fVar).f8547c;
                if (!z11) {
                    arrayList.add(fVar);
                }
            }
            arrayList2.add(fVar);
        }
        int i10 = -1;
        int i11 = 0;
        if (arrayList.isEmpty()) {
            int size = arrayList2.size();
            while (i11 < size) {
                Object obj = arrayList2.get(i11);
                i11++;
                context3 = this.f8592c.f8518c;
                i10 = gVar.b(context3, (a.f) obj);
                if (i10 == 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList.size();
            while (i11 < size2) {
                Object obj2 = arrayList.get(i11);
                i11++;
                context2 = this.f8592c.f8518c;
                i10 = gVar.b(context2, (a.f) obj2);
                if (i10 != 0) {
                    break;
                }
            }
        }
        if (i10 != 0) {
            ConnectionResult connectionResult = new ConnectionResult(i10, null);
            w0Var2 = this.f8592c.f8516a;
            w0Var2.l(new f0(this, this.f8592c, connectionResult));
            return;
        }
        z10 = this.f8592c.f8528m;
        if (z10) {
            eVar = this.f8592c.f8526k;
            if (eVar != null) {
                eVar2 = this.f8592c.f8526k;
                eVar2.b();
            }
        }
        for (a.f fVar2 : this.f8591b.keySet()) {
            d0 d0Var = this.f8591b.get(fVar2);
            if (fVar2.o()) {
                context = this.f8592c.f8518c;
                if (gVar.b(context, fVar2) != 0) {
                    w0Var = this.f8592c.f8516a;
                    w0Var.l(new g0(this, this.f8592c, d0Var));
                }
            }
            fVar2.j(d0Var);
        }
    }
}
