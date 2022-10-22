package fh;

import com.mobvoi.health.common.data.pojo.HeartRateLevel;
import ef.p;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import we.d;
import xf.h;
/* compiled from: HeartRateAnalyzer.java */
/* loaded from: classes2.dex */
public class a extends d<h> {

    /* renamed from: c  reason: collision with root package name */
    private int f27029c = 0;

    @Override // we.d, we.a, we.b
    public List<h> a(Iterable<p> iterable) {
        ArrayList arrayList;
        int i10;
        double d10;
        int i11;
        ArrayList arrayList2 = new ArrayList();
        for (p pVar : iterable) {
            long j10 = pVar.f25951a;
            if (j10 > 0 && (i11 = pVar.f25955e) > 0) {
                arrayList2.add(new h(j10, i11, HeartRateLevel.levelOf(i11, this.f27029c)));
            }
        }
        if (arrayList2.isEmpty() || arrayList2.size() <= 160) {
            return arrayList2;
        }
        int i12 = 1;
        int i13 = 0;
        long j11 = ((h) arrayList2.get(arrayList2.size() - 1)).f36542a - ((h) arrayList2.get(0)).f36542a;
        double d11 = j11 / 160;
        double d12 = 20000;
        if (d11 < d12) {
            d11 = d12;
        }
        double d13 = j11;
        int i14 = d13 % d11 == 0.0d ? (int) (d13 / d11) : ((int) (d13 / d11)) + 1;
        double d14 = ((h) arrayList2.get(0)).f36542a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        double d15 = d14;
        while (i12 <= i14) {
            double d16 = (i12 * d11) + d14;
            int i15 = i13;
            while (true) {
                if (i15 >= arrayList2.size()) {
                    arrayList = arrayList2;
                    i10 = i14;
                    d10 = d11;
                    break;
                }
                h hVar = (h) arrayList2.get(i15);
                arrayList = arrayList2;
                i13 = i13;
                long j12 = hVar.f36542a;
                d10 = d11;
                if (j12 > d16 || j12 < d15) {
                    i10 = i14;
                    if (j12 > d16) {
                        i13 = i15;
                        break;
                    }
                } else if (linkedHashMap.containsKey(Double.valueOf(d16))) {
                    h hVar2 = (h) linkedHashMap.get(Double.valueOf(d16));
                    float f10 = hVar.f36543b;
                    if (f10 > hVar2.f36543b) {
                        hVar2.f36543b = f10;
                    }
                    i10 = i14;
                } else {
                    i10 = i14;
                    linkedHashMap.put(Double.valueOf(d16), new h((long) d16, hVar.f36543b, hVar.f36544c));
                }
                i15++;
                arrayList2 = arrayList;
                d11 = d10;
                i14 = i10;
            }
            i12++;
            d15 = d16;
            arrayList2 = arrayList;
            d11 = d10;
            i14 = i10;
        }
        ArrayList arrayList3 = new ArrayList();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList3.add((h) entry.getValue());
        }
        return arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: i */
    public h f(double d10, double d11) {
        int round = (int) Math.round(d11);
        return new h((long) (d10 * 1000.0d), round, HeartRateLevel.levelOf(round, this.f27029c));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: j */
    public h c(h hVar, long j10, p pVar) {
        int i10 = pVar.f25955e;
        if (i10 >= 0) {
            return new h(pVar.f25951a, i10, HeartRateLevel.levelOf(i10, this.f27029c));
        }
        return null;
    }

    public void k(int i10) {
        this.f27029c = i10;
    }
}
