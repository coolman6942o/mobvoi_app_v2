package pk;

import com.mobvoi.android.common.utils.k;
import com.mobvoi.ticwear.youngwatch.data.LSSleepStatus;
import com.mobvoi.wear.util.LogCleaner;
import eg.c;
import java.util.ArrayList;
/* compiled from: SleepConvertImpl.java */
/* loaded from: classes2.dex */
public class k0 implements i<r0, v> {
    private long e(long j10) {
        return c.a(j10).getTimeInMillis();
    }

    private long f(long j10, int i10) {
        return e(j10) + (i10 * 60 * 1000);
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

    /* JADX WARN: Removed duplicated region for block: B:38:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0204 A[SYNTHETIC] */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public v convert(r0 r0Var) {
        long j10;
        int i10;
        if (r0Var == null) {
            return null;
        }
        v vVar = new v();
        vVar.f32840f = r0Var.a();
        vVar.f32839e = r0Var.b();
        vVar.f32837c = r0Var.e();
        vVar.f32838d = r0Var.h();
        int i11 = 1;
        char c10 = 0;
        if (r0Var.c() > r0Var.g()) {
            long f10 = (f(r0Var.d(), r0Var.c()) - LogCleaner.ONE_DAY) / 1000;
            vVar.f32835a = f10;
            k.c("SleepConvertImpl", "开始时间大于结束时间：%d", Long.valueOf(f10));
        } else {
            long f11 = f(r0Var.d(), r0Var.c()) / 1000;
            vVar.f32835a = f11;
            k.c("SleepConvertImpl", "开始时间小于结束时间：%d", Long.valueOf(f11));
        }
        k.c("SleepConvertImpl", "睡眠的起始时间是：%d", Long.valueOf(vVar.f32835a));
        long f12 = f(r0Var.d(), r0Var.g()) / 1000;
        vVar.f32836b = f12;
        k.c("SleepConvertImpl", "睡眠的结束时间是：%d", Long.valueOf(f12));
        int[] i12 = r0Var.i();
        int[] f13 = r0Var.f();
        int[] j11 = r0Var.j();
        int length = i12.length;
        ArrayList<w> arrayList = new ArrayList<>();
        int i13 = 0;
        while (i13 < length) {
            w wVar = new w();
            int i14 = f13[i13];
            int i15 = i12[i13];
            if (i15 == 0) {
                wVar.f32843a = LSSleepStatus.LSSleepStatusDeep;
            } else if (i15 == i11) {
                wVar.f32843a = LSSleepStatus.LSSleepStatusLight;
            } else if (i15 == 2) {
                wVar.f32843a = LSSleepStatus.LSSleepStatusAwake;
            }
            if (j11[c10] <= 1000 && j11[c10] - f13[c10] >= 0) {
                wVar.f32844b = f(r0Var.d(), j11[i13] - f13[i13]) / 1000;
                k.c("SleepConvertImpl", "《睡眠时间点的结束时间是：%d", Long.valueOf(f(r0Var.d(), j11[i13])));
                wVar.f32845c = f(r0Var.d(), j11[i13]) / 1000;
            } else if (j11[i13] >= r0Var.c()) {
                long f14 = f(r0Var.d(), j11[i13] - f13[i13]);
                j10 = LogCleaner.ONE_DAY;
                long j12 = (f14 - LogCleaner.ONE_DAY) / 1000;
                wVar.f32844b = j12;
                wVar.f32845c = j12 + (f13[i13] * 60);
                i10 = 1;
                Object[] objArr = new Object[i10];
                c10 = 0;
                objArr[0] = Long.valueOf(wVar.f32844b);
                k.c("SleepConvertImpl", "睡眠中的开始时间是：%d", objArr);
                Object[] objArr2 = new Object[i10];
                objArr2[0] = Long.valueOf(wVar.f32845c);
                k.c("SleepConvertImpl", "睡眠中的结束时间是：%d", objArr2);
                if (wVar.f32844b < wVar.f32845c) {
                }
                i13++;
                i11 = 1;
            } else if (i13 == 0) {
                wVar.f32844b = (f(r0Var.d(), j11[i13]) - ((f13[i13] * 60) * 1000)) / 1000;
                wVar.f32845c = f(r0Var.d(), j11[i13]) / 1000;
            } else {
                int i16 = i13 - 1;
                if (j11[i16] > r0Var.c()) {
                    wVar.f32844b = (f(r0Var.d(), j11[i16]) - LogCleaner.ONE_DAY) / 1000;
                    wVar.f32845c = f(r0Var.d(), j11[i13]) / 1000;
                } else {
                    wVar.f32844b = f(r0Var.d(), j11[i13] - f13[i13]) / 1000;
                    k.c("SleepConvertImpl", "《睡眠时间点的结束时间是：%d", Long.valueOf(f(r0Var.d(), j11[i13])));
                    wVar.f32845c = f(r0Var.d(), j11[i13]) / 1000;
                }
                i10 = 1;
                j10 = LogCleaner.ONE_DAY;
                Object[] objArr3 = new Object[i10];
                c10 = 0;
                objArr3[0] = Long.valueOf(wVar.f32844b);
                k.c("SleepConvertImpl", "睡眠中的开始时间是：%d", objArr3);
                Object[] objArr22 = new Object[i10];
                objArr22[0] = Long.valueOf(wVar.f32845c);
                k.c("SleepConvertImpl", "睡眠中的结束时间是：%d", objArr22);
                if (wVar.f32844b < wVar.f32845c) {
                    arrayList.add(wVar);
                }
                i13++;
                i11 = 1;
            }
            i10 = 1;
            j10 = LogCleaner.ONE_DAY;
            Object[] objArr32 = new Object[i10];
            c10 = 0;
            objArr32[0] = Long.valueOf(wVar.f32844b);
            k.c("SleepConvertImpl", "睡眠中的开始时间是：%d", objArr32);
            Object[] objArr222 = new Object[i10];
            objArr222[0] = Long.valueOf(wVar.f32845c);
            k.c("SleepConvertImpl", "睡眠中的结束时间是：%d", objArr222);
            if (wVar.f32844b < wVar.f32845c) {
            }
            i13++;
            i11 = 1;
        }
        vVar.f32841g = arrayList;
        return vVar;
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
