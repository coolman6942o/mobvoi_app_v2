package com.mobvoi.mcuwatch.ui.menstrualcycle.data;

import aj.a;
import android.text.format.DateFormat;
import com.bjleisen.iface.sdk.apdu.LeisenIfaceConfig;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.mcuwatch.engine.f;
import com.mobvoi.mcuwatch.engine.u;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.i;
/* compiled from: PeriodData.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f19786a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static final long f19787b = TimeUnit.DAYS.toMillis(1);

    private b() {
    }

    public final Date a(Date date, int i10, int i11) {
        i.f(date, "date");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(i10, i11);
        Date time = calendar.getTime();
        i.e(time, "cal.time");
        return time;
    }

    public final List<Date> b(long j10, long j11, long j12, int i10) {
        return c(a(new Date(j10), 5, i10), j11, j12);
    }

    public final List<Date> c(Date expectPoint, long j10, long j11) {
        i.f(expectPoint, "expectPoint");
        ArrayList arrayList = new ArrayList();
        Date a10 = a(expectPoint, 5, -14);
        Date a11 = a(a10, 5, -5);
        Date a12 = a(a10, 5, 4);
        long time = a11.getTime();
        long time2 = a10.getTime();
        long time3 = a12.getTime();
        long j12 = (time2 - time) / f19787b;
        if (1 <= j12) {
            long j13 = 1;
            while (true) {
                j13++;
                if (j10 <= time && time <= j11) {
                    arrayList.add(new Date(time));
                }
                time += f19787b;
                if (j13 == j12) {
                    break;
                }
            }
        }
        long j14 = ((time3 - time2) / f19787b) + 1;
        if (1 <= j14) {
            long j15 = 1;
            while (true) {
                j15++;
                if (j10 <= time2 && time2 <= j11) {
                    arrayList.add(new Date(time2));
                }
                time2 += f19787b;
                if (j15 == j14) {
                    break;
                }
            }
        }
        return arrayList;
    }

    public final void d() {
        a aVar = a.f215a;
        boolean g10 = aVar.g();
        long e10 = aVar.e();
        f.m(u.f19202a, g10, DateFormat.format(LeisenIfaceConfig.CARD_DATE_FORMAT, e10).toString(), aVar.c(), aVar.b());
    }

    public final List<Date> e(long j10, int i10, long j11, long j12) {
        ArrayList arrayList = new ArrayList();
        if (i10 <= 0) {
            return arrayList;
        }
        int i11 = 0;
        do {
            boolean z10 = true;
            i11++;
            if (j11 > j10 || j10 > j12) {
                z10 = false;
            }
            if (z10) {
                arrayList.add(new Date(j10));
            }
            j10 += TimeUnit.DAYS.toMillis(1L);
        } while (i11 < i10);
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:78:0x0215  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final a f(Date monthDate, nk.a periodCycle) {
        boolean z10;
        long j10;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        long j11;
        List<Date> e10;
        long j12;
        i.f(monthDate, "monthDate");
        i.f(periodCycle, "periodCycle");
        long j13 = 1;
        long time = bh.b.c(monthDate).getTime() - 1;
        long time2 = bh.b.b(monthDate).getTime();
        long j14 = (time2 - time) / f19787b;
        if (0 <= j14) {
            long j15 = time;
            long j16 = 0;
            while (true) {
                j16 += j13;
                long j17 = f19787b;
                int c10 = (int) ((j15 - periodCycle.c()) / j17);
                if (c10 > 0 && c10 % periodCycle.a() == 0 && j15 - periodCycle.c() >= j17) {
                    k.c("www", "dayMillis = %s,menstruationStart = %s", Long.valueOf(j15), Long.valueOf(periodCycle.c()));
                    j10 = j15;
                    z10 = true;
                    break;
                }
                j15 += j17;
                if (j16 == j14) {
                    j10 = j15;
                    z10 = false;
                    break;
                }
                j13 = 1;
            }
        } else {
            z10 = false;
            j10 = time;
        }
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        long c11 = periodCycle.c();
        if (!(time <= c11 && c11 < time2) || a(new Date(periodCycle.c()), 5, periodCycle.b()).getTime() >= time2) {
            arrayList = arrayList5;
            arrayList2 = arrayList6;
        } else {
            arrayList = arrayList5;
            arrayList2 = arrayList6;
            arrayList2.addAll(b(periodCycle.c(), time, time2, periodCycle.a()));
        }
        if (z10) {
            List<Date> e11 = e(j10, periodCycle.b(), time, time2);
            if (e11 == null || !(!e11.isEmpty())) {
                j11 = j10;
                arrayList3 = arrayList;
            } else {
                arrayList.addAll(e11);
                long time3 = e11.get(0).getTime();
                long time4 = e11.get(e11.size() - 1).getTime();
                if (!(time <= time4 && time4 < time2) || time4 <= time3) {
                    j11 = j10;
                    arrayList3 = arrayList;
                    j12 = time3;
                } else {
                    j11 = j10;
                    arrayList3 = arrayList;
                    j12 = time3;
                    arrayList2.addAll(b(time3, time, time2, periodCycle.a()));
                }
                arrayList2.addAll(c(new Date(j12), time, time2));
            }
            long j18 = j11;
            Date date = new Date(j18);
            long j19 = time2 - j18;
            if (j19 > 0) {
                long j20 = 1;
                long millis = (j19 / TimeUnit.DAYS.toMillis(1L)) / periodCycle.a();
                if (1 <= millis) {
                    long j21 = j18;
                    long j22 = 1;
                    while (true) {
                        j22 += j20;
                        ArrayList arrayList7 = arrayList2;
                        Date a10 = a(new Date(j21), 5, periodCycle.a());
                        if (time2 < a10.getTime()) {
                            arrayList4 = arrayList7;
                            break;
                        }
                        arrayList4 = arrayList7;
                        long j23 = j21;
                        List<Date> e12 = e(a10.getTime(), periodCycle.b(), time, time2);
                        if (e12 != null && (!e12.isEmpty())) {
                            arrayList3.addAll(e12);
                            long time5 = e12.get(0).getTime();
                            long time6 = e12.get(e12.size() - 1).getTime();
                            if ((time <= time6 && time6 < time2) && time6 > time5) {
                                arrayList4.addAll(b(time5, time, time2, periodCycle.a()));
                            }
                        }
                        j21 = j23 + f19787b;
                        if (j22 == millis) {
                            date = a10;
                            break;
                        }
                        arrayList2 = arrayList4;
                        date = a10;
                        j20 = 1;
                    }
                    if (time > periodCycle.c()) {
                        long j24 = f19787b;
                        long b10 = periodCycle.b() - (periodCycle.a() - ((date.getTime() - time) / j24));
                        if (b10 > 0 && b10 < periodCycle.b() && time - periodCycle.c() > periodCycle.a() * j24 && (e10 = e(time, (int) b10, time, time2)) != null && (!e10.isEmpty())) {
                            arrayList3.addAll(e10);
                        }
                    }
                }
            }
            arrayList4 = arrayList2;
            if (time > periodCycle.c()) {
            }
        } else {
            arrayList3 = arrayList;
            arrayList4 = arrayList2;
        }
        a aVar = new a(periodCycle);
        aVar.f(arrayList3);
        aVar.g(arrayList4);
        return aVar;
    }
}
