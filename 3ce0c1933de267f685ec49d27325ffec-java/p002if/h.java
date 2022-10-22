package p002if;

import android.content.Context;
import bf.c;
import df.a;
import df.d;
import df.e;
import ef.r;
import ef.u;
import hf.k;
import hf.l;
import hf.m;
import hf.n;
import hf.o;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import p002if.a;
import retrofit2.Call;
/* compiled from: NetQueryClient.java */
/* renamed from: if.h  reason: invalid package */
/* loaded from: classes2.dex */
public class h extends a implements l, k {

    /* renamed from: d  reason: collision with root package name */
    private o<n> f28258d;

    /* renamed from: e  reason: collision with root package name */
    private String f28259e;

    /* renamed from: f  reason: collision with root package name */
    private int f28260f;

    /* renamed from: g  reason: collision with root package name */
    private String f28261g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f28262h;

    public h(Context context, c cVar, int i10, String str) {
        super(context, cVar);
        this.f28260f = i10;
        this.f28261g = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ r o(String str, df.c cVar) {
        List<e> list = cVar.sportRecords;
        if (list != null && !list.isEmpty()) {
            for (e eVar : list) {
                String str2 = eVar.motionId;
                if (str2 != null && str2.equals(str)) {
                    return new r(a.h(eVar, this.f28259e), a.f(eVar, this.f28260f));
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ n p(m mVar, df.c cVar) {
        List<e> list = cVar.sportRecords;
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (e eVar : list) {
                u h10 = a.h(eVar, this.f28259e);
                if (h10.h()) {
                    arrayList.add(h10);
                }
            }
        }
        return new n(mVar, arrayList);
    }

    @Override // hf.p
    public String a() {
        return this.f28261g;
    }

    @Override // hf.k
    public void c(final String str, o<r> oVar) {
        Call<df.c> call;
        com.mobvoi.android.common.utils.k.i("fit.net.client", "requestDetails for %s", str);
        if (this.f28262h) {
            call = j().c(str);
        } else {
            call = j().e(str);
        }
        call.enqueue(l(oVar, new a.b() { // from class: if.g
            @Override // p002if.a.b
            public final Object a(d dVar) {
                r o10;
                o10 = h.this.o(str, (df.c) dVar);
                return o10;
            }
        }));
    }

    @Override // hf.l
    public void f(final m mVar) {
        Call<df.c> call;
        com.mobvoi.android.common.utils.k.i("fit.net.client", "requestSummary, %s", mVar);
        Date date = mVar.f27843a;
        long currentTimeMillis = date == null ? System.currentTimeMillis() : date.getTime();
        Date date2 = mVar.f27844b;
        long time = date2 == null ? 0L : date2.getTime();
        if (this.f28262h) {
            call = j().d(currentTimeMillis, time, mVar.f27845c, null, true);
        } else {
            call = j().f(currentTimeMillis, time, mVar.f27845c, null, true);
        }
        call.enqueue(l(this.f28258d, new a.b() { // from class: if.f
            @Override // p002if.a.b
            public final Object a(d dVar) {
                n p10;
                p10 = h.this.p(mVar, (df.c) dVar);
                return p10;
            }
        }));
    }

    @Override // hf.l
    public void h(o<n> oVar) {
        this.f28258d = oVar;
    }

    public void q(String str, boolean z10) {
        this.f28259e = str;
        this.f28262h = z10;
    }
}
