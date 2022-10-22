package ef;

import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.fitness.core.data.pojo.SessionMode;
import com.mobvoi.fitness.core.data.pojo.SportDataType;
import com.mobvoi.health.common.data.pojo.SportType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import yf.e;
/* compiled from: SportSummary.java */
/* loaded from: classes2.dex */
public class u {
    public static final Comparator<u> I = t.f25981a;
    public static final Comparator<u> J = s.f25980a;
    public int A;
    public float B;
    public int C;
    public SessionMode D;
    public SportType E;
    public final List<x> F;
    public String G;
    public int H;

    /* renamed from: a  reason: collision with root package name */
    public String f25982a;

    /* renamed from: b  reason: collision with root package name */
    public String f25983b;

    /* renamed from: c  reason: collision with root package name */
    public String f25984c;

    /* renamed from: d  reason: collision with root package name */
    public SportType f25985d;

    /* renamed from: e  reason: collision with root package name */
    public float f25986e;

    /* renamed from: f  reason: collision with root package name */
    public SportDataType f25987f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f25988g;

    /* renamed from: h  reason: collision with root package name */
    public long f25989h;

    /* renamed from: i  reason: collision with root package name */
    public long f25990i;

    /* renamed from: j  reason: collision with root package name */
    public long f25991j;

    /* renamed from: k  reason: collision with root package name */
    public int f25992k;

    /* renamed from: l  reason: collision with root package name */
    public float f25993l;

    /* renamed from: m  reason: collision with root package name */
    public int f25994m;

    /* renamed from: n  reason: collision with root package name */
    public int f25995n;

    /* renamed from: o  reason: collision with root package name */
    public int f25996o;

    /* renamed from: p  reason: collision with root package name */
    public float f25997p;

    /* renamed from: q  reason: collision with root package name */
    public float f25998q;

    /* renamed from: r  reason: collision with root package name */
    public float f25999r;

    /* renamed from: s  reason: collision with root package name */
    public float f26000s;

    /* renamed from: t  reason: collision with root package name */
    public float f26001t;

    /* renamed from: u  reason: collision with root package name */
    public float f26002u;

    /* renamed from: v  reason: collision with root package name */
    public int f26003v;

    /* renamed from: w  reason: collision with root package name */
    public int f26004w;

    /* renamed from: x  reason: collision with root package name */
    public int f26005x;

    /* renamed from: y  reason: collision with root package name */
    public int f26006y;

    /* renamed from: z  reason: collision with root package name */
    public final List<Long> f26007z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SportSummary.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26008a;

        static {
            int[] iArr = new int[SportDataType.values().length];
            f26008a = iArr;
            try {
                iArr[SportDataType.Duration.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26008a[SportDataType.Distance.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26008a[SportDataType.SwimDistance.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26008a[SportDataType.Calorie.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26008a[SportDataType.Steps.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26008a[SportDataType.Group.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26008a[SportDataType.SwimTrips.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public u(String str) {
        this.f25984c = str;
        this.f25982a = "__invalidate_account__";
        this.f25983b = null;
        this.f25985d = SportType.Unknown;
        this.f25986e = -1.0f;
        this.f25988g = false;
        this.f25989h = -1L;
        this.f25990i = -1L;
        this.f25991j = -1L;
        this.f25992k = -1;
        this.f25993l = -1.0f;
        this.f25994m = -1;
        this.f25995n = -1;
        this.f25996o = -1;
        this.f25997p = -2.14748365E9f;
        this.f25998q = 2.14748365E9f;
        this.f25999r = -1.0f;
        this.f26000s = -1.0f;
        this.f26001t = -1.0f;
        this.f26007z = new ArrayList();
        this.A = -1;
        this.B = -1.0f;
        this.C = -1;
        this.f26003v = -1;
        this.f26004w = -1;
        this.f26005x = -1;
        this.f26006y = -1;
        this.f26002u = -1.0f;
        this.D = SessionMode.UNKNOWN;
        this.E = null;
        this.G = null;
        this.F = new ArrayList();
        this.H = 0;
    }

    private static float d(u uVar) {
        int i10;
        SportDataType sportDataType = uVar.f25987f;
        float f10 = uVar.f25986e;
        if (sportDataType == null || sportDataType == SportDataType.Unknown) {
            return -1.0f;
        }
        float f11 = 0.0f;
        if (f10 <= 0.0f) {
            return -1.0f;
        }
        switch (a.f26008a[sportDataType.ordinal()]) {
            case 1:
                f11 = (float) uVar.f25991j;
                break;
            case 2:
                i10 = uVar.f25992k;
                f11 = i10;
                break;
            case 3:
                f11 = uVar.A * uVar.B;
                break;
            case 4:
                f11 = uVar.f25993l;
                break;
            case 5:
                i10 = uVar.f25995n;
                f11 = i10;
                break;
            case 6:
                i10 = e.a(uVar.f26007z);
                f11 = i10;
                break;
            case 7:
                f11 = uVar.B;
                break;
        }
        return (f11 * 100.0f) / f10;
    }

    public static String e(List<Long> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder(list.get(0).toString());
        if (list.size() > 1) {
            for (int i10 = 1; i10 < list.size(); i10++) {
                sb2.append(",");
                sb2.append(list.get(i10));
            }
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int i(u uVar, u uVar2) {
        String str;
        String str2 = uVar.f25984c;
        if (str2 != null && (str = uVar2.f25984c) != null) {
            return str2.compareTo(str);
        }
        if (!k.j()) {
            k.d("fit.data.summary", "Cannot compare invalid summary will null sportId");
            return uVar.f25984c == null ? 1 : -1;
        }
        throw new IllegalArgumentException("Cannot compare invalid summary will null sportId");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int j(u uVar, u uVar2) {
        return Long.compare(uVar2.f25989h, uVar.f25989h);
    }

    public static List<Long> k(String str) {
        if (str == null || str.trim().isEmpty()) {
            return Collections.emptyList();
        }
        String[] split = str.trim().split(",");
        ArrayList arrayList = new ArrayList(split.length);
        try {
            for (String str2 : split) {
                arrayList.add(Long.valueOf(Long.parseLong(str2)));
            }
        } catch (Exception e10) {
            k.r("fit.data.summary", "Error when split group string", e10, new Object[0]);
        }
        return arrayList;
    }

    public float c() {
        return d(this);
    }

    public boolean f() {
        float f10 = this.f26002u;
        return f10 >= 10.0f && f10 <= 70.0f;
    }

    public boolean g() {
        SportType sportType = this.f25985d;
        return sportType == SportType.BandAutoWalking || sportType == SportType.BandRunning;
    }

    public boolean h() {
        SportType sportType = this.f25985d;
        if (!(sportType == null || sportType == SportType.Unknown || TextUtils.isEmpty(this.f25984c))) {
            long j10 = this.f25989h;
            long j11 = e.f37076a;
            if (j10 > j11) {
                long j12 = this.f25990i;
                if (j12 > j11 && j12 > j10) {
                    return true;
                }
            }
        }
        return false;
    }

    public void l(List<x> list) {
        int size;
        if (!this.F.isEmpty() && (size = this.F.size()) <= list.size()) {
            for (int i10 = 0; i10 < size; i10++) {
                list.get(i10).f26017e = this.F.get(i10).f26017e;
            }
        }
        this.F.clear();
        this.F.addAll(list);
        this.G = x.a(this.F);
    }

    public void m(i iVar) {
        SportType b10 = iVar.b();
        SportType sportType = this.E;
        if (b10 != sportType) {
            k.s("fit.data.summary", "update HiitTypeTimes but type is different, C %s, E %s", sportType, iVar.b());
        } else if (!this.F.isEmpty()) {
            List<x> list = this.F;
            list.get(list.size() - 1).f26017e = iVar.a();
        }
    }

    public void n(u uVar) {
        SportType sportType = uVar.f25985d;
        if (!(sportType == null || sportType == SportType.Unknown)) {
            this.f25985d = sportType;
        }
        float f10 = uVar.f25986e;
        if (f10 > 0.0f) {
            this.f25986e = f10;
        }
        SportDataType sportDataType = uVar.f25987f;
        if (sportDataType != null) {
            this.f25987f = sportDataType;
        }
        long j10 = uVar.f25989h;
        if (j10 > 0) {
            this.f25989h = j10;
        }
        long j11 = uVar.f25990i;
        if (j11 > 0) {
            this.f25990i = j11;
        }
        long j12 = uVar.f25991j;
        if (j12 >= 0) {
            this.f25991j = j12;
        }
        int i10 = uVar.f25992k;
        if (i10 >= 0) {
            this.f25992k = i10;
        }
        float f11 = uVar.f25993l;
        if (f11 >= 0.0f) {
            this.f25993l = f11;
        }
        int i11 = uVar.f25994m;
        if (i11 > 0) {
            this.f25994m = i11;
        }
        int i12 = uVar.f25995n;
        if (i12 >= 0) {
            this.f25995n = i12;
        }
        int i13 = uVar.f25996o;
        if (i13 >= 0) {
            this.f25996o = i13;
        }
        this.f25997p = uVar.f25997p;
        this.f25998q = uVar.f25998q;
        float f12 = uVar.f25999r;
        if (f12 >= 0.0f) {
            this.f25999r = f12;
        }
        float f13 = uVar.f26000s;
        if (f13 >= 0.0f) {
            this.f26000s = f13;
        }
        this.f26001t = uVar.f26001t;
        this.f26003v = uVar.f26003v;
        this.f26004w = uVar.f26004w;
        this.f26005x = uVar.f26005x;
        if (this.f26002u <= 0.0f) {
            this.f26002u = uVar.f26002u;
        }
        if (!uVar.f26007z.isEmpty()) {
            this.f26007z.clear();
            this.f26007z.addAll(uVar.f26007z);
        }
        int i14 = uVar.A;
        if (i14 > 0) {
            this.A = i14;
        }
        float f14 = uVar.B;
        if (f14 > 0.0f) {
            this.B = f14;
        }
        int i15 = uVar.C;
        if (i15 >= 0) {
            this.C = i15;
        }
        int i16 = uVar.f26006y;
        if (i16 >= 0) {
            this.f26006y = i16;
        }
        SessionMode sessionMode = uVar.D;
        if (sessionMode != SessionMode.UNKNOWN) {
            this.D = sessionMode;
        }
        String str = uVar.G;
        if (str != null) {
            this.G = str;
        }
        SportType sportType2 = uVar.E;
        if (sportType2 != null) {
            this.E = sportType2;
        }
        if (!uVar.F.isEmpty()) {
            this.F.clear();
            this.F.addAll(uVar.F);
        }
        int i17 = uVar.H;
        if (i17 >= 0) {
            this.H = i17;
        }
    }

    public String toString() {
        return "SportSummary{accountId='" + this.f25982a + "', sportId='" + this.f25984c + "', type=" + this.f25985d + ", targetValue=" + this.f25986e + ", targetType=" + this.f25987f + ", startTimestamp=" + this.f25989h + ", stopTimestamp=" + this.f25990i + ", duration=" + this.f25991j + ", distance=" + this.f25992k + ", calorie=" + this.f25993l + ", heartRate=" + this.f25994m + ", steps=" + this.f25995n + ", strideFreq=" + this.f25996o + ", maxElevation=" + this.f25997p + ", minElevation=" + this.f25998q + ", cumulativeUp=" + this.f25999r + ", cumulativeDown=" + this.f26000s + ", score=" + this.f26001t + ", groups=" + this.f26007z + ", swimPoolLength=" + this.A + ", swimTrips=" + this.B + ", swimStroke=" + this.C + ", sessionMode=" + this.D + ", lapTime=" + this.f26003v + ", lapCount=" + this.f26004w + ", lapDistance=" + this.f26005x + ", extra=" + this.G + '}';
    }

    public u(u uVar) {
        this.f25984c = uVar.f25984c;
        this.f25982a = uVar.f25982a;
        this.f25983b = uVar.f25983b;
        this.f25985d = uVar.f25985d;
        this.D = uVar.D;
        this.f25986e = uVar.f25986e;
        this.f25987f = uVar.f25987f;
        this.f25988g = uVar.f25988g;
        this.f25989h = uVar.f25989h;
        this.f25990i = uVar.f25990i;
        this.f25991j = uVar.f25991j;
        this.f25992k = uVar.f25992k;
        this.f25993l = uVar.f25993l;
        this.f25994m = uVar.f25994m;
        this.f25995n = uVar.f25995n;
        this.f25996o = uVar.f25996o;
        this.f25997p = uVar.f25997p;
        this.f25998q = uVar.f25998q;
        this.f25999r = uVar.f25999r;
        this.f26000s = uVar.f26000s;
        this.f26001t = uVar.f26001t;
        this.f26007z = new ArrayList(uVar.f26007z);
        this.A = uVar.A;
        this.B = uVar.B;
        this.C = uVar.C;
        this.D = uVar.D;
        this.f26003v = uVar.f26003v;
        this.f26004w = uVar.f26004w;
        this.f26005x = uVar.f26005x;
        this.f26006y = uVar.f26006y;
        this.f26002u = uVar.f26002u;
        this.E = uVar.E;
        this.G = uVar.G;
        this.F = new ArrayList(uVar.F);
        this.H = uVar.H;
    }
}
