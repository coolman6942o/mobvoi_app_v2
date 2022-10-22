package com.mobvoi.mcuwatch.engine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import cn.a0;
import cn.l;
import cn.u;
import cn.w;
import cn.x;
import cn.y;
import cn.z;
import com.bjleisen.iface.sdk.apdu.LeisenIfaceConfig;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.ticwear.youngwatch.data.PacketProfile;
import com.mobvoi.ticwear.youngwatch.data.PedometerData;
import eg.c;
import eg.k;
import en.o;
import gg.g;
import gn.h;
import io.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
import kotlin.text.b;
import pk.c0;
import pk.h0;
import pk.r0;
import pk.x0;
import qg.a;
/* compiled from: UTEMcuWatchDataHelper.kt */
/* loaded from: classes2.dex */
public final class v {

    /* renamed from: a  reason: collision with root package name */
    public static final v f19226a = new v();

    /* renamed from: b  reason: collision with root package name */
    private static c0 f19227b = new c0();
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static o f19228c;

    /* renamed from: d  reason: collision with root package name */
    private static g f19229d;

    private v() {
    }

    private final byte[] a(int... iArr) {
        int length = iArr.length;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = (byte) iArr[i10];
        }
        return bArr;
    }

    private final g b(byte[] bArr, int i10, int i11) {
        int a10;
        int a11;
        String str;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        g gVar = new g();
        int i12 = i11 * i10;
        n nVar = n.f30086a;
        String format = String.format("%x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i12 + 0])}, 1));
        i.e(format, "java.lang.String.format(format, *args)");
        a10 = b.a(16);
        String format2 = String.format("%x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i12 + 1])}, 1));
        i.e(format2, "java.lang.String.format(format, *args)");
        a11 = b.a(16);
        String valueOf = String.valueOf((Integer.parseInt(format, a10) * 16 * 16) + Integer.parseInt(format2, a11));
        String format3 = String.format("%02d", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i12 + 2])}, 1));
        i.e(format3, "java.lang.String.format(format, *args)");
        String format4 = String.format("%02d", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i12 + 3])}, 1));
        i.e(format4, "java.lang.String.format(format, *args)");
        String format5 = String.format("%02d", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i12 + 4])}, 1));
        i.e(format5, "java.lang.String.format(format, *args)");
        int i13 = i12 + 5;
        String format6 = String.format("%02d", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i13])}, 1));
        i.e(format6, "java.lang.String.format(format, *args)");
        if (i11 == 15) {
            i13 = i12 + 6;
            str = String.format("%02d", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i13])}, 1));
            i.e(str, "java.lang.String.format(format, *args)");
        } else {
            str = "00";
        }
        gVar.f27466a = k.b(valueOf + format3 + format4 + format5 + format6 + str);
        String format7 = String.format("%x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i13 + 1])}, 1));
        i.e(format7, "java.lang.String.format(format, *args)");
        a12 = b.a(16);
        gVar.f27467b = Integer.parseInt(format7, a12);
        String format8 = String.format("%x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i13 + 2])}, 1));
        i.e(format8, "java.lang.String.format(format, *args)");
        a13 = b.a(16);
        gVar.f27468c = Integer.parseInt(format8, a13);
        String format9 = String.format("%x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i13 + 3])}, 1));
        i.e(format9, "java.lang.String.format(format, *args)");
        a14 = b.a(16);
        gVar.f27469d = Integer.parseInt(format9, a14);
        String format10 = String.format("%x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i13 + 4])}, 1));
        i.e(format10, "java.lang.String.format(format, *args)");
        a15 = b.a(16);
        gVar.f27470e = Integer.parseInt(format10, a15);
        String format11 = String.format("%x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i13 + 5])}, 1));
        i.e(format11, "java.lang.String.format(format, *args)");
        a16 = b.a(16);
        gVar.f27471f = Integer.parseInt(format11, a16);
        String format12 = String.format("%x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i13 + 6])}, 1));
        i.e(format12, "java.lang.String.format(format, *args)");
        a17 = b.a(16);
        gVar.f27472g = Integer.parseInt(format12, a17);
        String format13 = String.format("%x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i13 + 7])}, 1));
        i.e(format13, "java.lang.String.format(format, *args)");
        a18 = b.a(16);
        gVar.f27473h = Integer.parseInt(format13, a18);
        String format14 = String.format("%x", Arrays.copyOf(new Object[]{Byte.valueOf(bArr[i13 + 8])}, 1));
        i.e(format14, "java.lang.String.format(format, *args)");
        a19 = b.a(16);
        gVar.f27474i = Integer.parseInt(format14, a19);
        return gVar;
    }

    private final long c(long j10) {
        return c.a(j10).getTimeInMillis();
    }

    public final void d(Context ctx) {
        i.f(ctx, "ctx");
        o b10 = o.b(ctx.getApplicationContext());
        i.e(b10, "getInstance(ctx.applicationContext)");
        f19228c = b10;
    }

    public final void e(Context context, byte[] data, int i10) {
        i.f(context, "context");
        i.f(data, "data");
        ArrayList arrayList = new ArrayList();
        int length = data.length / i10;
        int i11 = length - 1;
        g b10 = b(data, i11, i10);
        g gVar = f19229d;
        if (gVar != null) {
            if (gVar == null) {
                i.u("latestArtyDataInfo");
                throw null;
            } else if (i.b(b10, gVar)) {
                return;
            }
        }
        int i12 = 0;
        if (length > 0) {
            while (true) {
                int i13 = i12 + 1;
                g b11 = b(data, i12, i10);
                if (i12 == i11) {
                    f19229d = b11;
                }
                arrayList.add(b11);
                if (i13 >= length) {
                    break;
                }
                i12 = i13;
            }
        }
        if (arrayList.size() > 0) {
            f19227b.c(arrayList, PacketProfile.ARTY_INFO_DATA);
        }
        q.h(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "arty_mills", k.d(System.currentTimeMillis(), LeisenIfaceConfig.CARD_DATE_FORMAT));
    }

    public final void f() {
        String d10 = q.d(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "oxygen_mills", "20200603");
        if (TextUtils.equals(d10, "20200603")) {
            d10 = h.c(-5);
        }
        long a10 = k.a(d10);
        while (a10 < System.currentTimeMillis()) {
            o oVar = f19228c;
            Integer num = null;
            if (oVar != null) {
                List<cn.k> h10 = oVar.h(d10);
                a10 += 86400000;
                String d11 = k.d(a10, LeisenIfaceConfig.CARD_DATE_FORMAT);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("queryOxygenInfo 加了一次数据,lastSyncTempTime：");
                sb2.append((Object) d11);
                sb2.append("   oxygenInfoList ");
                if (h10 != null) {
                    num = Integer.valueOf(h10.size());
                }
                sb2.append(num);
                com.mobvoi.android.common.utils.k.a("UTEMcuWatchDataHelper", sb2.toString());
                if (h10 != null && h10.size() > 0) {
                    ArrayList arrayList = new ArrayList(h10.size());
                    for (cn.k kVar : h10) {
                        int c10 = kVar.c();
                        long c11 = k.c(kVar.d());
                        com.mobvoi.android.common.utils.k.a("UTEMcuWatchDataHelper", "queryOxygenInfo [i]" + c10 + "     time[i]:" + ((Object) kVar.d()));
                        arrayList.add(new a(c11, (float) c10));
                    }
                    f19227b.c(arrayList, PacketProfile.BLOOD_OXYGEN_DATA);
                }
                d10 = d11;
            } else {
                i.u("mySQLOperate");
                throw null;
            }
        }
        q.h(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "oxygen_mills", k.d(System.currentTimeMillis(), LeisenIfaceConfig.CARD_DATE_FORMAT));
    }

    public final void g() {
        long j10;
        String d10 = q.d(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "rate_mills", "20200603");
        if (TextUtils.equals(d10, "20200603")) {
            d10 = h.c(-5);
        }
        long a10 = k.a(d10);
        while (a10 < System.currentTimeMillis()) {
            o oVar = f19228c;
            if (oVar != null) {
                List<l> e10 = oVar.e(d10);
                long j11 = a10 + 86400000;
                String d11 = k.d(j11, LeisenIfaceConfig.CARD_DATE_FORMAT);
                if (e10 == null || e10.size() <= 0) {
                    j10 = j11;
                } else {
                    int size = e10.size();
                    int[] iArr = new int[size];
                    long[] jArr = new long[size];
                    ArrayList arrayList = new ArrayList();
                    int i10 = 0;
                    if (size > 0) {
                        while (true) {
                            int i11 = i10 + 1;
                            iArr[i10] = e10.get(i10).b();
                            int c10 = e10.get(i10).c();
                            e10 = e10;
                            j10 = j11;
                            jArr[i10] = (c(k.a(e10.get(i10).a())) + ((c10 * 60) * 1000)) / 1000;
                            com.mobvoi.android.common.utils.k.a("UTEMcuWatchDataHelper", "timeArray[i]" + jArr[i10] + "     rateValue[i]:" + iArr[i10]);
                            arrayList.add(new h0(jArr[i10], iArr[i10]));
                            if (i11 >= size) {
                                break;
                            }
                            i10 = i11;
                            j11 = j10;
                        }
                    } else {
                        j10 = j11;
                    }
                    f19227b.c(arrayList, PacketProfile.HEART_RATE_DATA);
                }
                d10 = d11;
                a10 = j10;
            } else {
                i.u("mySQLOperate");
                throw null;
            }
        }
        q.h(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "rate_mills", k.d(System.currentTimeMillis(), LeisenIfaceConfig.CARD_DATE_FORMAT));
    }

    public final void h() {
        String d10 = q.d(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "sleep_mills", "20200603");
        if (TextUtils.equals(d10, "20200603")) {
            d10 = h.c(-5);
        }
        long a10 = k.a(d10);
        while (a10 < System.currentTimeMillis()) {
            o oVar = f19228c;
            if (oVar != null) {
                cn.q k10 = oVar.k(d10);
                long j10 = 86400000;
                a10 += j10;
                String d11 = k.d(a10, LeisenIfaceConfig.CARD_DATE_FORMAT);
                if (k10 != null && k10.i() > 0) {
                    r0 r0Var = new r0();
                    r0Var.k(k10.a());
                    r0Var.l(k10.b());
                    r0Var.m(k10.c());
                    r0Var.o(k10.d());
                    r0Var.q(k10.f());
                    r0Var.r(k10.g());
                    r0Var.t(k10.i());
                    r0Var.p(k10.e());
                    r0Var.u(k10.j());
                    r0Var.s(k10.h());
                    r0Var.n(a10 - j10);
                    com.mobvoi.android.common.utils.k.a("UTEMcuWatchDataHelper", r0Var.toString());
                    f19227b.c(r0Var, PacketProfile.SLEEP_DATA);
                }
                d10 = d11;
            } else {
                i.u("mySQLOperate");
                throw null;
            }
        }
        q.h(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "sleep_mills", k.d(a10 - 604800000, LeisenIfaceConfig.CARD_DATE_FORMAT));
        q.h(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "last_sync_sleep_mills", k.d(System.currentTimeMillis(), "yyyyMMddHHmm"));
    }

    public final void i() {
        List<u> list;
        String d10 = q.d(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "sport_mode_mills", "20200603");
        if (TextUtils.equals(d10, "20200603")) {
            d10 = h.c(-5);
        }
        long a10 = k.a(d10);
        while (a10 < System.currentTimeMillis()) {
            o oVar = f19228c;
            if (oVar != null) {
                List<u> m10 = oVar.m(d10);
                a10 += 86400000;
                String d11 = k.d(a10, LeisenIfaceConfig.CARD_DATE_FORMAT);
                if (m10 != null && m10.size() > 0) {
                    int i10 = 0;
                    com.mobvoi.android.common.utils.k.c("UTEMcuWatchDataHelper", "运动模式请求的返回数据个数是：%d", Integer.valueOf(m10.size()));
                    ArrayList arrayList = new ArrayList();
                    long b10 = k.b(m10.get(0).w());
                    long c10 = q.c(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "sync_sport_max_start_time", 0L);
                    int size = m10.size() - 1;
                    if (size >= 0) {
                        while (true) {
                            int i11 = i10 + 1;
                            u uVar = m10.get(i10);
                            long b11 = k.b(uVar.w());
                            if (b11 <= c10) {
                                list = m10;
                            } else {
                                if (b11 > b10) {
                                    b10 = b11;
                                }
                                x0 a11 = ai.a.a(uVar);
                                list = m10;
                                com.mobvoi.android.common.utils.k.a("UTEMcuWatchDataHelper", i.n("translateInfo:", a11));
                                arrayList.add(a11);
                            }
                            if (i11 > size) {
                                break;
                            }
                            i10 = i11;
                            m10 = list;
                        }
                    }
                    q.g(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "sync_sport_max_start_time", b10);
                    if (arrayList.size() > 0) {
                        f19227b.c(arrayList, PacketProfile.SPORTS_STATUS_DATA);
                    }
                }
                d10 = d11;
            } else {
                i.u("mySQLOperate");
                throw null;
            }
        }
        q.h(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "sport_mode_mills", k.d(System.currentTimeMillis(), LeisenIfaceConfig.CARD_DATE_FORMAT));
    }

    public final void j(long j10) {
        String str;
        long j11;
        long j12;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        long j13;
        long j14;
        ArrayList arrayList4;
        String str2;
        long j15;
        long j16;
        Iterator it;
        int i10;
        long j17;
        long j18;
        long j19;
        ArrayList arrayList5;
        Iterator it2;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        String d10 = q.d(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "step_mills", "20200603");
        if (TextUtils.equals(d10, "20200603")) {
            d10 = h.c(-1);
        }
        long a10 = k.a(d10);
        while (a10 < System.currentTimeMillis()) {
            o oVar = f19228c;
            if (oVar != null) {
                w j20 = oVar.j(d10);
                o oVar2 = f19228c;
                if (oVar2 != null) {
                    List<u> sportModesInfo = oVar2.m(d10);
                    long j21 = a10 + 86400000;
                    String d11 = k.d(j21, LeisenIfaceConfig.CARD_DATE_FORMAT);
                    if (!(j20 == null && sportModesInfo == null)) {
                        ArrayList arrayList9 = new ArrayList();
                        if (j20 != null || sportModesInfo == null) {
                            ArrayList arrayList10 = new ArrayList();
                            ArrayList<x> i11 = j20.i();
                            if (i11 == null) {
                                j11 = j21;
                                str = d11;
                                arrayList2 = arrayList9;
                                arrayList = arrayList10;
                                j12 = 0;
                            } else {
                                Iterator it3 = i11.iterator();
                                long j22 = 0;
                                while (it3.hasNext()) {
                                    x xVar = (x) it3.next();
                                    PedometerData pedometerData = new PedometerData();
                                    int i12 = xVar.f6375a;
                                    j21 = j21;
                                    long a11 = k.a(j20.a()) + ((xVar.f6376b - 60) * 60 * 1000);
                                    ArrayList<z> k10 = j20.k();
                                    if (k10 == null) {
                                        arrayList3 = arrayList10;
                                        j14 = 0;
                                        j13 = 0;
                                    } else {
                                        Iterator it4 = k10.iterator();
                                        j14 = 0;
                                        j13 = 0;
                                        while (it4.hasNext()) {
                                            z zVar = (z) it4.next();
                                            it4 = it4;
                                            if (zVar.c() < xVar.f6376b || zVar.c() >= xVar.f6376b + 60) {
                                                arrayList8 = arrayList10;
                                            } else {
                                                arrayList8 = arrayList10;
                                                j13 = k.a(j20.a()) + (zVar.a() * 60 * 1000);
                                                j14 = k.a(j20.a()) + (zVar.b() * 60 * 1000);
                                                if (j13 > j10) {
                                                    j13 = j10;
                                                }
                                            }
                                            arrayList10 = arrayList8;
                                        }
                                        arrayList3 = arrayList10;
                                        m mVar = m.f28349a;
                                    }
                                    ArrayList<y> j23 = j20.j();
                                    if (j23 == null) {
                                        str2 = d11;
                                        arrayList4 = arrayList9;
                                        j16 = 0;
                                        j15 = 0;
                                    } else {
                                        Iterator it5 = j23.iterator();
                                        j16 = 0;
                                        j15 = 0;
                                        while (it5.hasNext()) {
                                            y yVar = (y) it5.next();
                                            it5 = it5;
                                            d11 = d11;
                                            if (yVar.e() < xVar.f6376b || yVar.e() >= xVar.f6376b + 60) {
                                                arrayList7 = arrayList9;
                                            } else {
                                                arrayList7 = arrayList9;
                                                j15 = k.a(j20.a()) + (yVar.a() * 60 * 1000);
                                                j16 = k.a(j20.a()) + (yVar.d() * 60 * 1000);
                                                if (j15 > j10) {
                                                    j15 = j10;
                                                }
                                            }
                                            arrayList9 = arrayList7;
                                        }
                                        str2 = d11;
                                        arrayList4 = arrayList9;
                                        m mVar2 = m.f28349a;
                                    }
                                    long j24 = j14 < j16 ? j14 : j16;
                                    long j25 = j13 < j15 ? j15 : j13;
                                    if (j14 == j13) {
                                        j24 = j16;
                                    } else if (j16 == j15) {
                                        j24 = j14;
                                    }
                                    long j26 = a11 + 3600000;
                                    if (sportModesInfo == null) {
                                        it = it3;
                                        arrayList5 = arrayList3;
                                        j19 = 0;
                                        j18 = 0;
                                        j17 = 0;
                                        i10 = 0;
                                    } else {
                                        long j27 = j26;
                                        j18 = 0;
                                        j17 = 0;
                                        i10 = 0;
                                        for (Iterator it6 = sportModesInfo.iterator(); it6.hasNext(); it6 = it2) {
                                            it3 = it3;
                                            u uVar = (u) it6.next();
                                            long b10 = k.b(uVar.w());
                                            long b11 = k.b(uVar.u());
                                            int i13 = (b10 > a11 ? 1 : (b10 == a11 ? 0 : -1));
                                            if (i13 < 0 || b10 >= j26) {
                                                it2 = it6;
                                                arrayList6 = arrayList3;
                                            } else {
                                                if (j27 > b10) {
                                                    j27 = b10;
                                                }
                                                if (j18 < b11) {
                                                    j18 = b11;
                                                }
                                                i10 += uVar.k();
                                                it2 = it6;
                                                arrayList6 = arrayList3;
                                                arrayList6.add(uVar);
                                            }
                                            if (b11 >= a11 && b11 < j26 && i13 < 0) {
                                                j17 = b11;
                                            }
                                            arrayList3 = arrayList6;
                                        }
                                        it = it3;
                                        arrayList5 = arrayList3;
                                        m mVar3 = m.f28349a;
                                        j26 = j27;
                                        j19 = 0;
                                    }
                                    if (j18 > j19) {
                                        pedometerData.j(i12 + i10);
                                        if (j24 >= j26) {
                                            j24 = j26;
                                        }
                                        pedometerData.i(j24);
                                        if (pedometerData.d() < j17) {
                                            pedometerData.i(j17 + 1);
                                        }
                                        if (j25 < j18) {
                                            j25 = j18;
                                        }
                                        pedometerData.h(j25 - pedometerData.d());
                                    } else {
                                        pedometerData.j(i12);
                                        pedometerData.i(j24);
                                        if (pedometerData.d() < j17) {
                                            pedometerData.i(j17 + 1);
                                        }
                                        pedometerData.h(j25 - j24);
                                    }
                                    if (j22 < pedometerData.d() + pedometerData.c()) {
                                        j22 = pedometerData.d() + pedometerData.c();
                                    }
                                    m mVar4 = m.f28349a;
                                    ArrayList arrayList11 = arrayList4;
                                    arrayList11.add(pedometerData);
                                    com.mobvoi.android.common.utils.k.a("UTEMcuWatchDataHelper", pedometerData.toString());
                                    arrayList9 = arrayList11;
                                    arrayList10 = arrayList5;
                                    d11 = str2;
                                    it3 = it;
                                }
                                j11 = j21;
                                str = d11;
                                arrayList2 = arrayList9;
                                arrayList = arrayList10;
                                m mVar5 = m.f28349a;
                                j12 = j22;
                            }
                            if (!(sportModesInfo == null || sportModesInfo.isEmpty())) {
                                if (true ^ arrayList.isEmpty()) {
                                    sportModesInfo.removeAll(arrayList);
                                }
                                i.e(sportModesInfo, "sportModesInfo");
                                for (u uVar2 : sportModesInfo) {
                                    PedometerData pedometerData2 = new PedometerData();
                                    pedometerData2.j(uVar2.k());
                                    pedometerData2.i(k.b(uVar2.w()));
                                    pedometerData2.h(k.b(uVar2.u()) - pedometerData2.d());
                                    if (j12 < pedometerData2.d() + pedometerData2.c()) {
                                        j12 = pedometerData2.d() + pedometerData2.c();
                                    }
                                    m mVar6 = m.f28349a;
                                    arrayList2.add(pedometerData2);
                                }
                            }
                            PedometerData pedometerData3 = new PedometerData();
                            pedometerData3.f((float) Math.floor(j20.b()));
                            pedometerData3.g((int) (j20.c() * 1000));
                            pedometerData3.i(k.a(j20.a()));
                            pedometerData3.h(j12 - pedometerData3.d());
                            m mVar7 = m.f28349a;
                            arrayList2.add(pedometerData3);
                            f19227b.c(arrayList2, PacketProfile.DAILY_MEASUREMENT_DATA);
                            a10 = j11;
                            d10 = str;
                        } else {
                            for (u uVar3 : sportModesInfo) {
                                PedometerData pedometerData4 = new PedometerData();
                                pedometerData4.j(uVar3.k());
                                pedometerData4.f(uVar3.h());
                                pedometerData4.g((int) (uVar3.j() * 1000));
                                pedometerData4.i(k.b(uVar3.w()));
                                pedometerData4.h(k.b(uVar3.u()) - pedometerData4.d());
                                m mVar8 = m.f28349a;
                                arrayList9.add(pedometerData4);
                            }
                            f19227b.c(arrayList9, PacketProfile.DAILY_MEASUREMENT_DATA);
                        }
                    }
                    j11 = j21;
                    str = d11;
                    a10 = j11;
                    d10 = str;
                } else {
                    i.u("mySQLOperate");
                    throw null;
                }
            } else {
                i.u("mySQLOperate");
                throw null;
            }
        }
        q.h(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "step_mills", k.d(System.currentTimeMillis(), LeisenIfaceConfig.CARD_DATE_FORMAT));
    }

    public final void k() {
        String d10 = q.d(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "temperature_mills", "20200603");
        if (TextUtils.equals(d10, "20200603")) {
            d10 = h.c(-5);
        }
        long a10 = k.a(d10);
        while (a10 < System.currentTimeMillis()) {
            o oVar = f19228c;
            if (oVar != null) {
                List<a0> n10 = oVar.n(d10);
                a10 += 86400000;
                String d11 = k.d(a10, LeisenIfaceConfig.CARD_DATE_FORMAT);
                if (n10 != null && n10.size() > 0) {
                    ArrayList arrayList = new ArrayList(n10.size());
                    for (a0 a0Var : n10) {
                        float d12 = a0Var.d();
                        long c10 = k.c(a0Var.g());
                        com.mobvoi.android.common.utils.k.a("UTEMcuWatchDataHelper", "bodyTemperature " + d12 + "     time:" + ((Object) a0Var.g()));
                        arrayList.add(new ih.a(c10, d12));
                    }
                    f19227b.c(arrayList, PacketProfile.TEMPERATURE_DATA);
                }
                d10 = d11;
            } else {
                i.u("mySQLOperate");
                throw null;
            }
        }
        q.h(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "temperature_mills", k.d(System.currentTimeMillis(), LeisenIfaceConfig.CARD_DATE_FORMAT));
    }

    public final void l() {
        int a10;
        int a11;
        String d10 = q.d(com.mobvoi.android.common.utils.b.e(), "sync_mcu_fitness", "arty_mills", "20200603");
        if (TextUtils.equals(d10, "20200603")) {
            d10 = h.c(-5);
        }
        long a12 = k.a(d10);
        if (a12 < System.currentTimeMillis()) {
            String timeStamp = k.d(a12, "yyyyMMddHHmm");
            i.e(timeStamp, "timeStamp");
            String substring = timeStamp.substring(0, 4);
            i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int parseInt = Integer.parseInt(substring);
            String substring2 = timeStamp.substring(4, 6);
            i.e(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int parseInt2 = Integer.parseInt(substring2);
            String substring3 = timeStamp.substring(6, 8);
            i.e(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int parseInt3 = Integer.parseInt(substring3);
            String substring4 = timeStamp.substring(8, 10);
            i.e(substring4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int parseInt4 = Integer.parseInt(substring4);
            String substring5 = timeStamp.substring(10, 12);
            i.e(substring5, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int parseInt5 = Integer.parseInt(substring5);
            n nVar = n.f30086a;
            String format = String.format("%04X", Arrays.copyOf(new Object[]{Integer.valueOf(parseInt)}, 1));
            i.e(format, "java.lang.String.format(format, *args)");
            Objects.requireNonNull(format, "null cannot be cast to non-null type java.lang.String");
            String substring6 = format.substring(0, 2);
            i.e(substring6, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            a10 = b.a(16);
            int parseInt6 = Integer.parseInt(substring6, a10);
            String format2 = String.format("%04X", Arrays.copyOf(new Object[]{Integer.valueOf(parseInt)}, 1));
            i.e(format2, "java.lang.String.format(format, *args)");
            Objects.requireNonNull(format2, "null cannot be cast to non-null type java.lang.String");
            String substring7 = format2.substring(2, 4);
            i.e(substring7, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            a11 = b.a(16);
            f.N(u.f19202a, a(164, parseInt6, Integer.parseInt(substring7, a11), parseInt2, parseInt3, parseInt4, parseInt5), 1);
        }
    }

    public final void m(String calendar) {
        i.f(calendar, "calendar");
        o oVar = f19228c;
        if (oVar != null) {
            cn.m i10 = oVar.i(calendar);
            ArrayList arrayList = new ArrayList();
            if (i10 != null) {
                arrayList.add(i10);
            }
            f19227b.c(arrayList, PacketProfile.HEART_RATE_DATA);
            return;
        }
        i.u("mySQLOperate");
        throw null;
    }
}
