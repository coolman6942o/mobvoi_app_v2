package com.mobvoi.health.companion.heartrate.ui;

import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.health.common.data.pojo.MotionType;
import com.mobvoi.health.companion.heartrate.ui.b;
import com.mobvoi.health.companion.heartrate.ui.c;
import com.mobvoi.health.companion.noise.a;
import com.mobvoi.health.companion.oxygen.a;
import com.mobvoi.health.companion.pressure.a;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import xf.g;
/* compiled from: AnalysisDetailData.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final long f18265a;

    /* renamed from: b  reason: collision with root package name */
    public static final long f18266b;

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        f18265a = timeUnit.toMillis(30L);
        f18266b = timeUnit.toMillis(60L);
    }

    public static com.mobvoi.health.companion.oxygen.a d(long j10, List<qf.a> list, int i10) {
        int i11 = i10;
        if (list == null || list.size() == 0) {
            return null;
        }
        int i12 = 0;
        int e10 = (int) list.get(0).e();
        Calendar calendar = Calendar.getInstance();
        int firstDayOfWeek = calendar.getFirstDayOfWeek();
        HashMap hashMap = new HashMap();
        Iterator<qf.a> it = list.iterator();
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = e10;
        float f10 = 0.0f;
        int i17 = 0;
        while (it.hasNext()) {
            qf.a next = it.next();
            it = it;
            float e11 = next.e();
            if (e11 > 0.0f) {
                i14 = i14;
                i15 = i15;
                calendar.setTimeInMillis(next.f33129e);
                if (i11 == 1) {
                    i15 = (int) ((next.f33129e - j10) / f18266b);
                } else if (i11 == 2) {
                    i15 = o(firstDayOfWeek, calendar.get(7));
                } else if (i11 == 3) {
                    i15 = calendar.get(5) - 1;
                }
                i12++;
                f10 += e11;
                if (e11 >= e10) {
                    e10 = (int) e11;
                    i14 = i15;
                }
                if (e11 <= i16) {
                    i16 = (int) e11;
                    i13 = i15;
                }
                if (hashMap.containsKey(Integer.valueOf(i15))) {
                    a.b bVar = (a.b) hashMap.get(Integer.valueOf(i15));
                    if (e11 > bVar.f18424a) {
                        bVar.f18424a = e11;
                    }
                    if (e11 < bVar.f18425b) {
                        bVar.f18425b = e11;
                    }
                } else {
                    hashMap.put(Integer.valueOf(i15), new a.b(e11, e11, i15));
                }
                if (e11 < 80.0f) {
                    i17++;
                }
            }
            i11 = i10;
        }
        a.C0215a aVar = new a.C0215a();
        aVar.f18422f = Math.round(f10 / i12);
        aVar.f18420d = e10;
        aVar.f18421e = i16;
        aVar.f18423g = i17;
        aVar.f18419c = i13;
        aVar.f18418b = i14;
        aVar.f18417a = list.get(i12 - 1).f33129e;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            arrayList.add((a.b) entry.getValue());
        }
        return new com.mobvoi.health.companion.oxygen.a(j10, aVar, arrayList);
    }

    public static b e(long j10, List<qf.a> list, int i10) {
        if (list == null || list.size() == 0) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        int firstDayOfWeek = calendar.getFirstDayOfWeek();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        char c10 = 0;
        int i11 = 0;
        for (qf.a aVar : list) {
            float[] f10 = aVar.f();
            int i12 = (int) f10[c10];
            int i13 = (int) f10[1];
            long j11 = aVar.f33129e;
            calendar.setTimeInMillis(j11);
            if (i10 == 1) {
                i11 = (int) ((aVar.f33129e - j10) / f18265a);
            } else if (i10 == 2) {
                i11 = o(firstDayOfWeek, calendar.get(7));
            } else if (i10 == 3) {
                i11 = calendar.get(5) - 1;
            }
            if (i12 == 1) {
                if (hashMap.containsKey(Integer.valueOf(i11))) {
                    b.a aVar2 = (b.a) hashMap.get(Integer.valueOf(i11));
                    if (aVar2 != null && !aVar2.f18269a.contains(Integer.valueOf(i13))) {
                        aVar2.f18269a.add(Integer.valueOf(i13));
                    }
                } else {
                    b.a aVar3 = new b.a(1, j11, i11);
                    aVar3.f18269a.add(Integer.valueOf(i13));
                    hashMap.put(Integer.valueOf(i11), aVar3);
                }
            } else if (i12 == 2) {
                if (hashMap2.containsKey(Integer.valueOf(i11))) {
                    b.a aVar4 = (b.a) hashMap2.get(Integer.valueOf(i11));
                    if (aVar4 != null && !aVar4.f18269a.contains(Integer.valueOf(i13))) {
                        aVar4.f18269a.add(Integer.valueOf(i13));
                    }
                } else {
                    b.a aVar5 = new b.a(2, j11, i11);
                    aVar5.f18269a.add(Integer.valueOf(i13));
                    hashMap2.put(Integer.valueOf(i11), aVar5);
                }
            }
            c10 = 0;
        }
        ng.b bVar = ng.b.f31244a;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            ((b.a) entry.getValue()).f18270b = m(((b.a) entry.getValue()).f18269a);
            arrayList.add((b.a) entry.getValue());
        }
        Collections.sort(arrayList, bVar);
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            ((b.a) entry2.getValue()).f18270b = m(((b.a) entry2.getValue()).f18269a);
            arrayList2.add((b.a) entry2.getValue());
        }
        Collections.sort(arrayList2, bVar);
        return new b(j10, arrayList, arrayList2);
    }

    public static c.b f(List<rh.b> list, List<g> list2) {
        if (list == null || list.size() == 0) {
            return null;
        }
        int size = list.size();
        float f10 = list.get(0).f33519b;
        int i10 = 0;
        float f11 = f10;
        float f12 = 0.0f;
        float f13 = 0.0f;
        for (int i11 = 0; i11 < size; i11++) {
            rh.b bVar = list.get(i11);
            float f14 = bVar.f33519b;
            f12 += f14;
            if (f14 > f10) {
                f10 = f14;
            }
            if (f14 < f11) {
                f11 = f14;
            }
            if (list2 != null && list2.size() > 0) {
                for (g gVar : list2) {
                    long j10 = gVar.f36540a;
                    f10 = f10;
                    long j11 = bVar.f33518a;
                    if (j10 <= j11 && gVar.f36541b >= j11) {
                        float f15 = bVar.f33519b;
                        if (f15 > 0.0f) {
                            f13 += f15;
                            i10++;
                        }
                    }
                }
            }
            f10 = f10;
        }
        c.b bVar2 = new c.b();
        bVar2.f18293e = i10 > 0 ? Math.round(f13 / i10) : 0;
        bVar2.f18294f = Math.round(f12 / size);
        bVar2.f18291c = f10;
        bVar2.f18292d = f11;
        return bVar2;
    }

    public static void g(c cVar, long j10, long j11, int i10) {
        ArrayList arrayList;
        List<qf.a> h10 = ig.b.J().z().h(DataType.HeartHealth, j10, j11);
        if (h10 != null && h10.size() > 0) {
            Collections.sort(h10, ng.a.f31243a);
            HashMap hashMap = new HashMap();
            int i11 = -1;
            Calendar calendar = Calendar.getInstance();
            int firstDayOfWeek = calendar.getFirstDayOfWeek();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            ArrayList arrayList5 = new ArrayList();
            for (qf.a aVar : h10) {
                float[] f10 = aVar.f();
                if (f10 == null || f10.length != 2) {
                    arrayList = arrayList4;
                } else {
                    int i12 = (int) f10[0];
                    int i13 = (int) f10[1];
                    ArrayList arrayList6 = arrayList4;
                    ArrayList arrayList7 = arrayList5;
                    calendar.setTimeInMillis(aVar.f33129e);
                    if (i10 == 1) {
                        i11 = calendar.get(11);
                    } else if (i10 == 2) {
                        i11 = o(firstDayOfWeek, calendar.get(7));
                    } else if (i10 == 3) {
                        i11 = calendar.get(5) - 1;
                    }
                    List list = (List) hashMap.get(Integer.valueOf(i12));
                    if (list == null) {
                        list = new ArrayList();
                        hashMap.put(Integer.valueOf(i12), list);
                    }
                    int i14 = i11;
                    list.add(new rh.a(i12, aVar.f33129e, i13, i14));
                    rh.a aVar2 = new rh.a(i12, aVar.f33129e, i13, i14);
                    if (i12 == 1) {
                        arrayList = arrayList6;
                        arrayList5 = arrayList7;
                        arrayList2.add(aVar2);
                    } else if (i12 == 2) {
                        arrayList = arrayList6;
                        arrayList5 = arrayList7;
                        arrayList.add(aVar2);
                    } else if (i12 != 3) {
                        if (i12 == 4) {
                            arrayList3.add(aVar2);
                        }
                        arrayList = arrayList6;
                        arrayList5 = arrayList7;
                    } else {
                        arrayList5 = arrayList7;
                        arrayList5.add(aVar2);
                        arrayList = arrayList6;
                    }
                }
                arrayList4 = arrayList;
            }
            cVar.f18274d = hashMap;
            cVar.f18275e = n(arrayList2, 1);
            cVar.f18276f = n(arrayList3, 4);
            cVar.f18277g = n(arrayList4, 2);
            cVar.f18278h = n(arrayList5, 3);
        }
    }

    public static com.mobvoi.health.companion.noise.a h(long j10, List<qf.a> list, int i10) {
        Iterator it;
        if (list == null || list.size() == 0) {
            return null;
        }
        a.C0214a aVar = new a.C0214a();
        Calendar calendar = Calendar.getInstance();
        int firstDayOfWeek = calendar.getFirstDayOfWeek();
        HashMap hashMap = new HashMap();
        int size = list.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            qf.a aVar2 = list.get(i12);
            calendar.setTimeInMillis(aVar2.f33129e);
            if (i10 == 1) {
                i11 = (int) ((aVar2.f33129e - j10) / f18265a);
            } else if (i10 == 2) {
                i11 = o(firstDayOfWeek, calendar.get(7));
            } else if (i10 == 3) {
                i11 = calendar.get(5) - 1;
            }
            if (hashMap.containsKey(Integer.valueOf(i11))) {
                ((List) hashMap.get(Integer.valueOf(i11))).add(aVar2);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(aVar2);
                hashMap.put(Integer.valueOf(i11), arrayList);
            }
        }
        float f10 = 100.0f;
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = hashMap.entrySet().iterator();
        int i13 = 0;
        float f11 = 0.0f;
        float f12 = 0.0f;
        while (it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it2.next();
            int intValue = ((Integer) entry.getKey()).intValue();
            List<qf.a> list2 = (List) entry.getValue();
            if (list2 == null || list2.size() <= 0) {
                it = it2;
            } else {
                float f13 = 0.0f;
                float f14 = 0.0f;
                int i14 = 0;
                for (qf.a aVar3 : list2) {
                    float[] f15 = aVar3.f();
                    it2 = it2;
                    if (f15 != null && f15.length > 0) {
                        float f16 = f13;
                        for (int i15 = 0; i15 < f15.length; i15++) {
                            float f17 = f15[i15];
                            f11 += f17;
                            i13++;
                            if (i15 == 0 && i14 == 0) {
                                f14 = f17;
                                f16 = f14;
                            }
                            if (f17 > f16) {
                                f16 = f17;
                            }
                            if (f17 < f14) {
                                f14 = f17;
                            }
                        }
                        f13 = f16;
                    }
                    i14++;
                }
                it = it2;
                if (f13 > f12) {
                    f12 = f13;
                }
                if (f14 < f10) {
                    f10 = f14;
                }
                arrayList2.add(new a.b(f13, f14, intValue));
            }
            it2 = it;
        }
        aVar.f18369d = i13 > 0 ? f11 / i13 : 0.0f;
        aVar.f18368c = Math.round(f10);
        aVar.f18367b = Math.round(f12);
        aVar.f18366a = list.get(size - 1).f33129e;
        return new com.mobvoi.health.companion.noise.a(j10, arrayList2, aVar);
    }

    public static com.mobvoi.health.companion.pressure.a i(long j10, List<qf.a> list, int i10) {
        int i11;
        List<qf.a> list2 = list;
        if (list2 == null || list.size() == 0) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        int firstDayOfWeek = calendar.getFirstDayOfWeek();
        HashMap hashMap = new HashMap();
        int size = list.size();
        float e10 = list2.get(0).e();
        float f10 = 0.0f;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        float f11 = e10;
        while (i12 < size) {
            qf.a aVar = list2.get(i12);
            float e11 = aVar.e();
            int i18 = i12;
            int i19 = i13;
            calendar.setTimeInMillis(aVar.f33129e);
            if (i10 == 1) {
                i11 = (int) ((aVar.f33129e - j10) / f18265a);
            } else {
                if (i10 == 2) {
                    i17 = o(firstDayOfWeek, calendar.get(7));
                } else if (i10 == 3) {
                    i17 = calendar.get(5) - 1;
                }
                i11 = i17;
            }
            if (hashMap.containsKey(Integer.valueOf(i11))) {
                a.b bVar = (a.b) hashMap.get(Integer.valueOf(i11));
                if (e11 > bVar.f18483a) {
                    bVar.f18483a = e11;
                }
            } else {
                hashMap.put(Integer.valueOf(i11), new a.b(e11, i11));
            }
            if (e11 > e10) {
                e10 = e11;
            }
            if (e11 < f11) {
                f11 = e11;
            }
            f10 += e11;
            if (e11 >= 75.0f) {
                i16++;
            } else if (e11 >= 50.0f && e11 < 75.0f) {
                i15++;
            } else if (e11 < 25.0f || e11 >= 50.0f) {
                i13 = i19 + 1;
                i12 = i18 + 1;
                list2 = list;
                i17 = i11;
            } else {
                i14++;
            }
            i13 = i19;
            i12 = i18 + 1;
            list2 = list;
            i17 = i11;
        }
        int[] iArr = {i13, i14, i15, i16};
        a.C0216a aVar2 = new a.C0216a();
        double d10 = size;
        aVar2.f18479e = (int) rg.b.a(iArr, d10, 0, 0);
        aVar2.f18480f = (int) rg.b.a(iArr, d10, 1, 0);
        aVar2.f18481g = (int) rg.b.a(iArr, d10, 2, 0);
        aVar2.f18482h = (int) rg.b.a(iArr, d10, 3, 0);
        aVar2.f18476b = Math.round(e10);
        aVar2.f18477c = Math.round(f11);
        aVar2.f18478d = new BigDecimal(f10 / size).setScale(0, 4).intValue();
        aVar2.f18475a = list.get(size - 1).f33129e;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            arrayList.add((a.b) entry.getValue());
        }
        return new com.mobvoi.health.companion.pressure.a(j10, aVar2, arrayList);
    }

    public static c j(List<rh.b> list, List<g> list2, long j10, long j11, int i10) {
        int i11;
        c.b f10;
        if (list == null || list.size() <= 0) {
            return new c(j10);
        }
        c.a aVar = new c.a();
        int size = list.size();
        int i12 = 0;
        float f11 = list.get(0).f33519b;
        float f12 = f11;
        float f13 = 0.0f;
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            float f14 = list.get(i14).f33519b;
            if (f14 > 0.0f) {
                f13 += f14;
                i13++;
                if (f14 > f11) {
                    f11 = f14;
                }
                if (f14 < f12) {
                    f12 = f14;
                }
            }
        }
        aVar.f18280b = f11;
        aVar.f18281c = f12;
        k(aVar, list, list2);
        aVar.f18284f = i13 > 0 ? Math.round(f13 / i13) : 0;
        aVar.f18279a = list.get(size - 1).f33518a;
        List<qf.a> h10 = ig.b.J().z().h(DataType.HeartRateWarning, j10, j11);
        if (h10 == null || h10.size() <= 0) {
            i11 = 0;
        } else {
            i11 = 0;
            for (qf.a aVar2 : h10) {
                int e10 = (int) aVar2.e();
                if (e10 == 17) {
                    i11++;
                } else if (e10 == 18) {
                    i12++;
                }
            }
        }
        aVar.f18285g = i12;
        aVar.f18286h = i11;
        HashMap hashMap = new HashMap();
        int i15 = -1;
        Calendar calendar = Calendar.getInstance();
        int firstDayOfWeek = calendar.getFirstDayOfWeek();
        for (rh.b bVar : list) {
            calendar.setTimeInMillis(bVar.f33518a);
            if (i10 == 1) {
                i15 = calendar.get(11);
            } else if (i10 == 2) {
                i15 = o(firstDayOfWeek, calendar.get(7));
            } else if (i10 == 3) {
                i15 = calendar.get(5) - 1;
            }
            float f15 = aVar.f18280b;
            float f16 = bVar.f33519b;
            if (f15 == f16) {
                aVar.f18287i = i15;
            }
            if (aVar.f18281c == f16) {
                aVar.f18288j = i15;
            }
            List list3 = (List) hashMap.get(Integer.valueOf(i15));
            if (list3 == null) {
                list3 = new ArrayList();
            }
            list3.add(bVar);
            hashMap.put(Integer.valueOf(i15), list3);
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : hashMap.entrySet()) {
            List list4 = (List) entry.getValue();
            int intValue = ((Integer) entry.getKey()).intValue();
            if (!(list4 == null || (f10 = f(list4, list2)) == null)) {
                f10.f18295g = intValue;
                arrayList.add(f10);
            }
        }
        Collections.sort(arrayList, ng.c.f31245a);
        return new c(j10, arrayList, aVar);
    }

    public static void k(c.a aVar, List<rh.b> list, List<g> list2) {
        int i10 = 0;
        if (list == null || list.size() == 0 || list2 == null || list2.size() == 0) {
            aVar.f18282d = false;
            return;
        }
        int size = list.size();
        int i11 = 0;
        float f10 = 0.0f;
        for (int i12 = 0; i12 < size; i12++) {
            rh.b bVar = list.get(i12);
            for (g gVar : list2) {
                long j10 = gVar.f36540a;
                long j11 = bVar.f33518a;
                if (j10 <= j11 && gVar.f36541b >= j11) {
                    float f11 = bVar.f33519b;
                    if (f11 > 0.0f) {
                        f10 += f11;
                        i11++;
                    }
                }
            }
        }
        aVar.f18282d = true;
        if (i11 > 0) {
            i10 = Math.round(f10 / i11);
        }
        aVar.f18283e = i10;
    }

    public static List<g> l(List<qf.a> list, long j10, long j11) {
        LinkedList linkedList = new LinkedList();
        if (!(list == null || list.size() == 0)) {
            MotionType motionType = null;
            long j12 = 0;
            for (qf.a aVar : list) {
                float[] f10 = aVar.f();
                MotionType from = f10.length > 0 ? MotionType.from((int) f10[0]) : MotionType.Unknown;
                MotionType from2 = f10.length > 1 ? MotionType.from((int) f10[1]) : MotionType.Unknown;
                long j13 = aVar.f33128d;
                if (from == MotionType.Static) {
                    long j14 = aVar.f33129e;
                    if (j14 <= j10) {
                        j14 = j10;
                    }
                    linkedList.add(new g(j14, j13 < j11 ? j13 : j11));
                }
                motionType = from2;
                j12 = j13;
            }
            if (motionType == MotionType.Static && j11 > j12) {
                linkedList.add(new g(j12, j11));
            }
        }
        return linkedList;
    }

    public static float m(List<Integer> list) {
        float f10 = 0.0f;
        if (list.size() == 0) {
            return 0.0f;
        }
        for (Integer num : list) {
            f10 += num.intValue();
        }
        return f10 / list.size();
    }

    private static List<rh.a> n(List<rh.a> list, int i10) {
        int i11;
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            HashMap hashMap = new HashMap();
            for (rh.a aVar : list) {
                int i12 = aVar.f33517d;
                if (hashMap.containsKey(Integer.valueOf(i12))) {
                    rh.a aVar2 = (rh.a) hashMap.get(Integer.valueOf(i12));
                    if (i10 != 1) {
                        if (i10 == 2) {
                            int i13 = aVar.f33516c;
                            if (i13 > aVar2.f33516c) {
                                aVar2.f33516c = i13;
                                aVar2.f33515b = aVar.f33515b;
                            }
                        } else if (i10 == 3 && (i11 = aVar.f33516c) < aVar2.f33516c) {
                            aVar2.f33516c = i11;
                            aVar2.f33515b = aVar.f33515b;
                        }
                    }
                } else {
                    hashMap.put(Integer.valueOf(i12), aVar);
                }
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                arrayList.add((rh.a) entry.getValue());
            }
        }
        return arrayList;
    }

    public static int o(int i10, int i11) {
        if (i10 == 1) {
            int i12 = i11 - 1;
            if (i12 == 0) {
                i12 = 7;
            }
            return i12 - 1;
        }
        int i13 = i11 - i10;
        if (i13 < 0) {
            return 6;
        }
        return i13;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int p(b.a aVar, b.a aVar2) {
        int i10 = aVar.f18271c;
        int i11 = aVar2.f18271c;
        if (i10 < i11) {
            return -1;
        }
        return i10 > i11 ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int q(qf.a aVar, qf.a aVar2) {
        long j10 = aVar.f33129e;
        long j11 = aVar2.f33129e;
        if (j10 < j11) {
            return 1;
        }
        return j10 > j11 ? -1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int r(c.b bVar, c.b bVar2) {
        int i10 = bVar.f18295g;
        int i11 = bVar2.f18295g;
        if (i10 < i11) {
            return -1;
        }
        return i10 > i11 ? 1 : 0;
    }
}
