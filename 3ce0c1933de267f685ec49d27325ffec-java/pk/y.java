package pk;

import android.app.Application;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.health.common.data.pojo.SportType;
import ef.p;
import ef.r;
import ef.u;
import eg.k;
import java.util.ArrayList;
import java.util.List;
/* compiled from: McuConvertImpl.java */
/* loaded from: classes2.dex */
class y implements i<List<x0>, List<r>> {
    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int f(p pVar, p pVar2) {
        return (int) (pVar.f25952b - pVar2.f25952b);
    }

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

    /* renamed from: e */
    public List<r> convert(List<x0> list) {
        int i10;
        String str;
        Application e10 = b.e();
        ArrayList arrayList = new ArrayList();
        String b10 = b();
        String deviceId = getDeviceId();
        int i11 = 1;
        int size = list.size() - 1;
        while (true) {
            if (size < 0) {
                break;
            }
            x0 x0Var = list.get(size);
            long b11 = k.b(x0Var.j());
            long b12 = k.b(x0Var.i());
            long c10 = q.c(e10, "test", "timestamp", 0L);
            String str2 = "McuConvertImpl";
            if (b12 < c10) {
                Object[] objArr = new Object[i11];
                objArr[0] = Long.valueOf(c10);
                com.mobvoi.android.common.utils.k.c(str2, "skip : lastDataTimestamp %s", objArr);
                break;
            }
            ef.q qVar = new ef.q();
            byte[] c11 = q.b(e10).c(x0Var.b());
            int g10 = x0Var.g();
            ArrayList arrayList2 = new ArrayList();
            e10 = e10;
            if (c11 != null) {
                int i12 = 0;
                while (i12 < c11.length) {
                    p pVar = new p();
                    size = size;
                    int i13 = c11[i12] & 255;
                    pVar.f25955e = i13;
                    c11 = c11;
                    if (i13 > 250 || i13 <= 40) {
                        i10 = g10;
                        str = str2;
                    } else {
                        i10 = g10;
                        str = str2;
                        long j10 = g10 * 1000 * i12;
                        pVar.f25952b = b11 + j10;
                        pVar.f25951a = j10;
                        arrayList2.add(pVar);
                    }
                    i12++;
                    str2 = str;
                    g10 = i10;
                }
            }
            int i14 = size;
            String str3 = str2;
            List<p> f10 = com.mobvoi.ticwear.youngwatch.data.b.c().f(b11, b12);
            if (f10 != null && f10.size() > 0) {
                arrayList2.addAll(f10);
            }
            arrayList2.sort(x.f32848a);
            qVar.a(arrayList2);
            u uVar = new u(a());
            SportType a10 = z.a(x0Var.h());
            uVar.f25985d = a10;
            uVar.f25989h = b11;
            uVar.f25990i = b12;
            uVar.f25982a = b10;
            uVar.f25983b = deviceId;
            if (a10 == SportType.OutdoorBike) {
                uVar.f25992k = com.mobvoi.ticwear.youngwatch.data.b.c().e();
                com.mobvoi.android.common.utils.k.h(str3, " convert summary.distance = " + uVar.f25992k);
            } else {
                uVar.f25992k = (int) (x0Var.e() * 1000.0f);
            }
            uVar.f25991j = b12 - b11;
            uVar.f25995n = x0Var.f();
            uVar.f25993l = x0Var.d();
            uVar.f25994m = x0Var.c();
            arrayList.add(new r(uVar, qVar));
            size = i14 - 1;
            i11 = 1;
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
