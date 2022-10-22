package si;

import android.util.Log;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.util.LogCleaner;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
/* compiled from: ArtySelectCalendarAdapter.java */
/* loaded from: classes2.dex */
public class h {
    private a A;

    /* renamed from: e  reason: collision with root package name */
    private int f34937e;

    /* renamed from: f  reason: collision with root package name */
    private int f34938f;

    /* renamed from: g  reason: collision with root package name */
    private int f34939g;

    /* renamed from: h  reason: collision with root package name */
    private int f34940h;

    /* renamed from: j  reason: collision with root package name */
    List<Long> f34942j;

    /* renamed from: k  reason: collision with root package name */
    List<d> f34943k;

    /* renamed from: l  reason: collision with root package name */
    List<Long> f34944l;

    /* renamed from: m  reason: collision with root package name */
    List<Long> f34945m;

    /* renamed from: n  reason: collision with root package name */
    protected List<Long> f34946n;

    /* renamed from: o  reason: collision with root package name */
    protected List<b> f34947o;

    /* renamed from: p  reason: collision with root package name */
    List<b> f34948p;

    /* renamed from: q  reason: collision with root package name */
    List<b> f34949q;

    /* renamed from: r  reason: collision with root package name */
    List<b> f34950r;

    /* renamed from: w  reason: collision with root package name */
    private List<String> f34955w;

    /* renamed from: x  reason: collision with root package name */
    private List<String> f34956x;

    /* renamed from: y  reason: collision with root package name */
    private List<String> f34957y;

    /* renamed from: z  reason: collision with root package name */
    private List<String> f34958z;

    /* renamed from: a  reason: collision with root package name */
    private int f34933a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f34934b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f34935c = -1;

    /* renamed from: d  reason: collision with root package name */
    private int f34936d = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f34941i = 0;

    /* renamed from: s  reason: collision with root package name */
    private int f34951s = 0;

    /* renamed from: t  reason: collision with root package name */
    private int f34952t = 0;

    /* renamed from: u  reason: collision with root package name */
    private int f34953u = 0;

    /* renamed from: v  reason: collision with root package name */
    private Calendar f34954v = Calendar.getInstance();

    /* compiled from: ArtySelectCalendarAdapter.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(c cVar);
    }

    /* compiled from: ArtySelectCalendarAdapter.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f34959a = 0;

        /* renamed from: b  reason: collision with root package name */
        public int f34960b = 0;

        public String toString() {
            return "DayPosition{start=" + this.f34959a + ", end=" + this.f34960b + '}';
        }
    }

    /* compiled from: ArtySelectCalendarAdapter.java */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f34961a;

        /* renamed from: b  reason: collision with root package name */
        public long f34962b;

        /* renamed from: c  reason: collision with root package name */
        public String f34963c;

        /* renamed from: d  reason: collision with root package name */
        public int f34964d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f34965e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f34966f;
    }

    /* compiled from: ArtySelectCalendarAdapter.java */
    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public long f34967a = 0;

        /* renamed from: b  reason: collision with root package name */
        public long f34968b = 0;
    }

    public h() {
        o();
    }

    private boolean c(boolean z10) {
        int i10 = this.f34936d;
        if (i10 == 0 && !z10) {
            Log.d("WeekCalendarAdapter", "Scroll to the head");
            return false;
        } else if (i10 != this.f34940h - 1 || !z10) {
            if (z10) {
                this.f34936d = i10 + 1;
            } else {
                this.f34936d = i10 - 1;
            }
            return true;
        } else {
            Log.d("WeekCalendarAdapter", "Scroll to the end");
            return false;
        }
    }

    private boolean d(boolean z10) {
        int i10 = this.f34934b;
        if (i10 == 0 && !z10) {
            Log.d("WeekCalendarAdapter", "Scroll to the head");
            return false;
        } else if (i10 != this.f34938f - 1 || !z10) {
            if (z10) {
                this.f34934b = i10 + 1;
            } else {
                this.f34934b = i10 - 1;
            }
            return true;
        } else {
            Log.d("WeekCalendarAdapter", "Scroll to the end");
            return false;
        }
    }

    private boolean e(boolean z10) {
        int i10 = this.f34933a;
        if (i10 == 0 && !z10) {
            Log.d("WeekCalendarAdapter", "Scroll to the head");
            return false;
        } else if (i10 != this.f34937e - 1 || !z10) {
            if (z10) {
                this.f34933a = i10 + 1;
            } else {
                this.f34933a = i10 - 1;
            }
            return true;
        } else {
            Log.d("WeekCalendarAdapter", "Scroll to the end");
            return false;
        }
    }

    private boolean f(boolean z10) {
        int i10 = this.f34935c;
        if (i10 == 0 && !z10) {
            Log.d("WeekCalendarAdapter", "Scroll to the head");
            return false;
        } else if (i10 != this.f34939g - 1 || !z10) {
            if (z10) {
                this.f34935c = i10 + 1;
            } else {
                this.f34935c = i10 - 1;
            }
            return true;
        } else {
            Log.d("WeekCalendarAdapter", "Scroll to the end");
            return false;
        }
    }

    private void g() {
        List<String> list = this.f34958z;
        if (list != null) {
            list.clear();
        } else {
            this.f34958z = new ArrayList();
        }
        List<b> list2 = this.f34950r;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        for (int i10 = 0; i10 < list2.size(); i10++) {
            calendar.setTimeInMillis(this.f34946n.get(list2.get(i10).f34959a).longValue());
            String format = simpleDateFormat.format(Long.valueOf(calendar.getTimeInMillis()));
            calendar.setTimeInMillis(this.f34946n.get(list2.get(i10).f34960b).longValue());
            int i11 = calendar.get(2);
            if (i11 < 5) {
                calendar.set(2, 5);
            } else if (i11 > 6 && i11 < 11) {
                calendar.set(2, 11);
            }
            String format2 = simpleDateFormat.format(Long.valueOf(calendar.getTimeInMillis()));
            List<String> list3 = this.f34958z;
            list3.add(format + " - " + format2);
        }
    }

    private void h() {
        List<String> list = this.f34957y;
        if (list != null) {
            list.clear();
        } else {
            this.f34957y = new ArrayList();
        }
        List<Long> list2 = this.f34944l;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy", Locale.ENGLISH);
        for (int i10 = 0; i10 < list2.size(); i10++) {
            calendar.setTimeInMillis(list2.get(i10).longValue());
            this.f34957y.add(simpleDateFormat.format(calendar.getTime()));
        }
    }

    private String j() {
        return this.f34958z.get(this.f34936d);
    }

    private String k() {
        return this.f34956x.get(this.f34934b);
    }

    private String l() {
        return this.f34955w.get(this.f34933a);
    }

    private String m() {
        return this.f34957y.get(this.f34935c);
    }

    private void o() {
        int i10;
        int i11;
        this.f34942j = new ArrayList();
        this.f34946n = new ArrayList();
        this.f34943k = new ArrayList();
        this.f34944l = new ArrayList();
        this.f34947o = new ArrayList();
        this.f34948p = new ArrayList();
        this.f34949q = new ArrayList();
        this.f34950r = new ArrayList();
        this.f34945m = new ArrayList();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        Calendar n10 = n();
        d dVar = new d();
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        b bVar5 = new b();
        dVar.f34967a = n10.getTimeInMillis();
        while (n10.before(calendar)) {
            n10.set(11, 0);
            n10.set(12, 0);
            n10.set(13, 0);
            n10.set(14, 0);
            this.f34946n.add(Long.valueOf(n10.getTimeInMillis()));
            int size = this.f34946n.size() - 1;
            int i12 = n10.get(7);
            if (1 == i12) {
                dVar = new d();
                dVar.f34967a = n10.getTimeInMillis();
                bVar = new b();
                bVar.f34959a = size;
            } else if (7 == i12) {
                dVar.f34968b = n10.getTimeInMillis();
                this.f34943k.add(dVar);
                bVar.f34960b = size;
                this.f34947o.add(bVar);
            }
            int i13 = n10.get(6);
            k.h("WeekCalendarAdapter", " initDayList dayOfYear = " + i13 + " maxDay = " + n10.getActualMaximum(6));
            if (1 == i13) {
                bVar3 = new b();
                bVar3.f34959a = size;
            } else if (n10.getActualMaximum(6) == i13) {
                bVar3.f34960b = size;
                this.f34949q.add(bVar3);
                this.f34944l.add(Long.valueOf(n10.getTimeInMillis()));
            }
            int i14 = n10.get(1);
            if (this.f34951s != i14) {
                this.f34951s = i14;
                this.f34954v.set(1, i14);
                this.f34954v.set(2, 5);
                Calendar calendar2 = this.f34954v;
                calendar2.set(5, calendar2.getActualMaximum(5));
                this.f34952t = this.f34954v.get(6);
                k.h("WeekCalendarAdapter", " firstHalfYearMax = " + this.f34952t);
                this.f34954v.set(2, 6);
                Calendar calendar3 = this.f34954v;
                calendar3.set(5, calendar3.getActualMinimum(5));
                this.f34953u = this.f34954v.get(6);
                k.h("WeekCalendarAdapter", " secondHalfYearMin = " + this.f34953u);
                i11 = 1;
            } else {
                i11 = 1;
            }
            if (i11 == i13) {
                bVar4 = new b();
                bVar4.f34959a = size;
            } else if (this.f34952t == i13) {
                bVar4.f34960b = size;
                this.f34950r.add(bVar4);
                this.f34945m.add(Long.valueOf(n10.getTimeInMillis()));
            }
            if (this.f34953u == i13) {
                bVar5 = new b();
                bVar5.f34959a = size;
            } else if (n10.getActualMaximum(6) == i13) {
                bVar5.f34960b = size;
                this.f34950r.add(bVar5);
                this.f34945m.add(Long.valueOf(n10.getTimeInMillis()));
            }
            int i15 = n10.get(5);
            if (1 == i15) {
                bVar2 = new b();
                bVar2.f34959a = size;
            } else if (n10.getActualMaximum(5) == i15) {
                bVar2.f34960b = size;
                this.f34948p.add(bVar2);
                this.f34942j.add(Long.valueOf(n10.getTimeInMillis()));
            }
            n10.add(6, 1);
        }
        if (dVar.f34968b == 0) {
            Calendar calendar4 = Calendar.getInstance();
            calendar4.setTimeInMillis(calendar.getTimeInMillis());
            calendar4.setFirstDayOfWeek(1);
            calendar4.set(7, 7);
            dVar.f34968b = calendar4.getTimeInMillis();
            this.f34943k.add(dVar);
        }
        if (bVar.f34960b == 0) {
            i10 = 1;
            bVar.f34960b = this.f34946n.size() - 1;
            this.f34947o.add(bVar);
        } else {
            i10 = 1;
        }
        if (bVar2.f34960b == 0) {
            bVar2.f34960b = this.f34946n.size() - i10;
            this.f34948p.add(bVar2);
            Calendar calendar5 = Calendar.getInstance();
            calendar5.setTimeInMillis(calendar.getTimeInMillis());
            calendar5.set(5, calendar5.getActualMaximum(5));
            this.f34942j.add(Long.valueOf(calendar5.getTimeInMillis()));
        }
        if (bVar3.f34960b == 0) {
            bVar3.f34960b = this.f34946n.size() - 1;
            this.f34949q.add(bVar3);
            this.f34944l.add(Long.valueOf(calendar.getTimeInMillis()));
        }
        if (bVar4.f34960b == 0) {
            bVar4.f34960b = this.f34946n.size() - 1;
            this.f34950r.add(bVar4);
            this.f34945m.add(Long.valueOf(calendar.getTimeInMillis()));
        }
        if (bVar5.f34960b == 0) {
            bVar5.f34960b = this.f34946n.size() - 1;
            this.f34950r.add(bVar5);
            this.f34945m.add(Long.valueOf(calendar.getTimeInMillis()));
        }
        this.f34937e = this.f34943k.size();
        this.f34938f = this.f34942j.size();
        this.f34939g = this.f34944l.size();
        int size2 = this.f34945m.size();
        this.f34940h = size2;
        this.f34933a = this.f34937e - 1;
        this.f34934b = this.f34938f - 1;
        this.f34935c = this.f34939g - 1;
        this.f34936d = size2 - 1;
        r();
        p();
        h();
        g();
    }

    private void p() {
        List<String> list = this.f34956x;
        if (list != null) {
            list.clear();
        } else {
            this.f34956x = new ArrayList();
        }
        List<Long> list2 = this.f34942j;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM", Locale.ENGLISH);
        for (int i10 = 0; i10 < list2.size(); i10++) {
            calendar.setTimeInMillis(list2.get(i10).longValue());
            this.f34956x.add(simpleDateFormat.format(calendar.getTime()));
        }
    }

    private void r() {
        List<d> list = this.f34943k;
        List<String> list2 = this.f34955w;
        if (list2 != null) {
            list2.clear();
        } else {
            this.f34955w = new ArrayList();
        }
        StringBuilder sb2 = new StringBuilder();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM d", Locale.ENGLISH);
        for (int i10 = 0; i10 < list.size(); i10++) {
            d dVar = list.get(i10);
            calendar.setTimeInMillis(dVar.f34967a);
            sb2.append(simpleDateFormat.format(calendar.getTime()));
            sb2.append("-");
            calendar.setTimeInMillis(dVar.f34968b);
            sb2.append(simpleDateFormat.format(calendar.getTime()));
            this.f34955w.add(sb2.toString());
            sb2.setLength(0);
        }
    }

    public void a(int i10) {
        this.f34941i = i10;
        this.A.a(i(false));
    }

    public void b(boolean z10) {
        boolean z11;
        int i10 = this.f34941i;
        if (i10 == 0) {
            z11 = e(z10);
        } else if (i10 == 1) {
            z11 = d(z10);
        } else if (i10 != 2) {
            z11 = i10 != 3 ? false : f(z10);
        } else {
            z11 = c(z10);
        }
        if (z11) {
            this.A.a(i(z10));
        }
    }

    public c i(boolean z10) {
        c cVar = new c();
        int i10 = this.f34941i;
        cVar.f34964d = i10;
        cVar.f34966f = z10;
        if (i10 == 0) {
            cVar.f34963c = l();
            cVar.f34961a = this.f34946n.get(this.f34947o.get(this.f34933a).f34959a).longValue();
            cVar.f34962b = this.f34946n.get(this.f34947o.get(this.f34933a).f34960b).longValue() + LogCleaner.ONE_DAY;
        } else if (i10 == 1) {
            cVar.f34963c = k();
            cVar.f34961a = this.f34946n.get(this.f34948p.get(this.f34934b).f34959a).longValue();
            cVar.f34962b = this.f34946n.get(this.f34948p.get(this.f34934b).f34960b).longValue() + LogCleaner.ONE_DAY;
            this.f34942j.get(this.f34934b).longValue();
        } else if (i10 == 2) {
            cVar.f34963c = j();
            long longValue = this.f34946n.get(this.f34950r.get(this.f34936d).f34959a).longValue();
            this.f34954v.setTimeInMillis(longValue);
            if (this.f34954v.get(2) < 6) {
                cVar.f34965e = true;
            } else {
                cVar.f34965e = false;
            }
            cVar.f34961a = longValue;
            cVar.f34962b = this.f34946n.get(this.f34950r.get(this.f34936d).f34960b).longValue() + LogCleaner.ONE_DAY;
        } else if (i10 == 3) {
            cVar.f34963c = m();
            cVar.f34961a = this.f34946n.get(this.f34949q.get(this.f34935c).f34959a).longValue();
            cVar.f34962b = this.f34946n.get(this.f34949q.get(this.f34935c).f34960b).longValue() + LogCleaner.ONE_DAY;
        }
        return cVar;
    }

    public Calendar n() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, 2015);
        calendar.set(2, 6);
        calendar.set(5, 1);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar;
    }

    public void q(a aVar) {
        this.A = aVar;
    }
}
