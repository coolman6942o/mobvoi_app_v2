package com.mobvoi.sleep.data.pojo;

import com.mobvoi.health.common.data.pojo.ActivityType;
import com.mobvoi.health.common.data.pojo.MotionType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import qf.c;
import yj.d;
import yj.e;
/* loaded from: classes2.dex */
public class SleepRecord {

    /* renamed from: a  reason: collision with root package name */
    public String f20737a;

    /* renamed from: b  reason: collision with root package name */
    public final String f20738b;

    /* renamed from: c  reason: collision with root package name */
    public final String f20739c;

    /* renamed from: d  reason: collision with root package name */
    public final long f20740d;

    /* renamed from: e  reason: collision with root package name */
    public long f20741e;

    /* renamed from: f  reason: collision with root package name */
    public final int f20742f;

    /* renamed from: g  reason: collision with root package name */
    public final int f20743g;

    /* renamed from: h  reason: collision with root package name */
    public final float f20744h;

    /* renamed from: i  reason: collision with root package name */
    public final float f20745i;

    /* renamed from: j  reason: collision with root package name */
    public final float f20746j;

    /* renamed from: k  reason: collision with root package name */
    public String f20747k;

    /* renamed from: l  reason: collision with root package name */
    private final List<e> f20748l;

    /* renamed from: m  reason: collision with root package name */
    private final List<yj.b> f20749m;

    /* renamed from: n  reason: collision with root package name */
    private final Map<TimeType, Long> f20750n;

    /* renamed from: o  reason: collision with root package name */
    private d f20751o;

    /* renamed from: p  reason: collision with root package name */
    private final yj.b f20752p;

    /* renamed from: q  reason: collision with root package name */
    private final yj.b f20753q;

    /* loaded from: classes2.dex */
    public enum TimeType {
        InBed,
        InSleep,
        FallAsleep,
        Awake,
        Rem,
        LightSleep,
        DeepSleep
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f20754a;

        static {
            int[] iArr = new int[MotionType.values().length];
            f20754a = iArr;
            try {
                iArr[MotionType.Rem.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20754a[MotionType.LightSleep.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20754a[MotionType.DeepSleep.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20754a[MotionType.Awake.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private String f20755a;

        /* renamed from: b  reason: collision with root package name */
        private String f20756b;

        /* renamed from: c  reason: collision with root package name */
        private String f20757c;

        /* renamed from: e  reason: collision with root package name */
        private long f20759e;

        /* renamed from: f  reason: collision with root package name */
        private long f20760f;

        /* renamed from: i  reason: collision with root package name */
        private int f20763i;

        /* renamed from: j  reason: collision with root package name */
        private float f20764j;

        /* renamed from: k  reason: collision with root package name */
        private float f20765k;

        /* renamed from: l  reason: collision with root package name */
        private float f20766l;

        /* renamed from: p  reason: collision with root package name */
        private yj.b f20770p;

        /* renamed from: q  reason: collision with root package name */
        private yj.b f20771q;

        /* renamed from: d  reason: collision with root package name */
        private String f20758d = "unknown";

        /* renamed from: g  reason: collision with root package name */
        private int f20761g = 0;

        /* renamed from: h  reason: collision with root package name */
        private boolean f20762h = false;

        /* renamed from: m  reason: collision with root package name */
        private final List<e> f20767m = new ArrayList();

        /* renamed from: n  reason: collision with root package name */
        private final List<yj.b> f20768n = new ArrayList();

        /* renamed from: o  reason: collision with root package name */
        private final Map<TimeType, Long> f20769o = new HashMap();

        public b(String str) {
            this.f20755a = str;
        }

        private void G() {
            long x10 = x(TimeType.InBed);
            int round = x10 > 0 ? Math.round(((((((float) x(TimeType.DeepSleep)) * 1.25f) + (((float) x(TimeType.LightSleep)) * 0.75f)) + (((float) x(TimeType.Rem)) * 0.7f)) * 100.0f) / ((float) x10)) : 0;
            if (round > 100) {
                round = 100;
            }
            this.f20763i = round;
        }

        private void H() {
            long x10 = x(TimeType.InBed);
            this.f20763i = x10 > 0 ? Math.round((((float) x(TimeType.InSleep)) * 100.0f) / ((float) x10)) : 0;
        }

        private void I(MotionType motionType, long j10) {
            int i10 = a.f20754a[motionType.ordinal()];
            if (i10 == 1) {
                r(TimeType.Rem, j10);
                r(TimeType.InSleep, j10);
                r(TimeType.InBed, j10);
            } else if (i10 == 2) {
                r(TimeType.LightSleep, j10);
                r(TimeType.InSleep, j10);
                r(TimeType.InBed, j10);
            } else if (i10 != 3) {
                r(TimeType.Awake, j10);
                r(TimeType.InBed, j10);
            } else {
                r(TimeType.DeepSleep, j10);
                r(TimeType.InSleep, j10);
                r(TimeType.InBed, j10);
            }
        }

        private void r(TimeType timeType, long j10) {
            D(timeType, x(timeType) + j10);
        }

        private Long w(TimeType timeType) {
            return this.f20769o.get(timeType);
        }

        private long x(TimeType timeType) {
            Long w10 = w(timeType);
            if (w10 == null) {
                return 0L;
            }
            return w10.longValue();
        }

        public b A(List<yj.b> list) {
            this.f20768n.clear();
            this.f20768n.addAll(list);
            float f10 = 0.0f;
            if (list.isEmpty()) {
                this.f20764j = 0.0f;
            } else {
                float f11 = Float.MAX_VALUE;
                float f12 = 0.0f;
                for (yj.b bVar : list) {
                    float f13 = bVar.value;
                    f10 += f13;
                    if (f13 > f12) {
                        f12 = f13;
                    }
                    if (f13 < f11) {
                        f11 = f13;
                    }
                }
                this.f20764j = f10 / list.size();
                this.f20765k = f11;
                this.f20766l = f12;
            }
            return this;
        }

        public b B(yj.b bVar) {
            this.f20770p = bVar;
            return this;
        }

        public b C(boolean z10) {
            this.f20762h = z10;
            return this;
        }

        public b D(TimeType timeType, long j10) {
            this.f20769o.put(timeType, Long.valueOf(j10));
            return this;
        }

        public b E(yj.b bVar) {
            this.f20771q = bVar;
            return this;
        }

        public b F(long j10) {
            this.f20759e = j10;
            return this;
        }

        public b J(String str) {
            this.f20756b = str;
            return this;
        }

        public b q(e eVar) {
            if (this.f20759e != 0) {
                this.f20767m.add(eVar);
                I(eVar.depth, eVar.toTime - Math.max(eVar.fromTime, this.f20759e));
                if (this.f20758d.equals("band")) {
                    G();
                } else {
                    H();
                }
                return this;
            }
            throw new IllegalStateException("Start time not set, can't add point");
        }

        public SleepRecord s() {
            return new SleepRecord(this);
        }

        public b t(String str) {
            this.f20757c = str;
            return this;
        }

        public b u(String str) {
            this.f20758d = str;
            return this;
        }

        public b v(long j10) {
            this.f20760f = j10;
            return this;
        }

        public b y(float f10) {
            this.f20764j = f10;
            return this;
        }

        public b z(int i10) {
            this.f20761g = i10;
            return this;
        }
    }

    public SleepRecord(b bVar) {
        this.f20737a = bVar.f20755a;
        this.f20738b = bVar.f20756b;
        this.f20739c = bVar.f20757c;
        this.f20740d = bVar.f20759e;
        this.f20741e = bVar.f20760f;
        this.f20742f = bVar.f20761g;
        boolean unused = bVar.f20762h;
        this.f20743g = bVar.f20763i;
        this.f20744h = bVar.f20764j;
        this.f20745i = bVar.f20765k;
        this.f20746j = bVar.f20766l;
        this.f20748l = bVar.f20767m;
        this.f20749m = bVar.f20768n;
        this.f20750n = bVar.f20769o;
        this.f20752p = bVar.f20770p;
        this.f20753q = bVar.f20771q;
    }

    private long c() {
        long j10 = this.f20740d;
        for (int size = this.f20748l.size() - 1; size >= 0; size--) {
            e eVar = this.f20748l.get(size);
            if (eVar.depth.isSleep()) {
                return eVar.toTime;
            }
        }
        return j10;
    }

    public List<e> a() {
        return this.f20748l;
    }

    public List<yj.b> b() {
        return this.f20749m;
    }

    public yj.b d() {
        return this.f20752p;
    }

    public Long e(TimeType timeType) {
        return this.f20750n.get(timeType);
    }

    public d f() {
        return this.f20751o;
    }

    public long g(TimeType timeType) {
        Long e10 = e(timeType);
        if (e10 == null) {
            return 0L;
        }
        return e10.longValue();
    }

    public long h() {
        long j10 = this.f20741e;
        return j10 > 0 ? j10 : c();
    }

    public yj.b i() {
        return this.f20753q;
    }

    public void j(d dVar) {
        this.f20751o = dVar;
    }

    public c k() {
        c cVar = new c();
        cVar.f33133i = this.f20737a;
        cVar.f33126b = this.f20738b;
        cVar.f33127c = ActivityType.AutoSleep.typeCode;
        String str = this.f20739c;
        if (str == null) {
            str = "";
        }
        cVar.f33125a = str;
        cVar.f33129e = this.f20740d;
        cVar.f33128d = this.f20741e;
        cVar.f33131g = this.f20742f;
        return cVar;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "SleepRecord id %s, wwid %s [%s, %s)", this.f20737a, this.f20738b, com.mobvoi.android.common.utils.d.a(this.f20740d), com.mobvoi.android.common.utils.d.a(this.f20741e));
    }
}
