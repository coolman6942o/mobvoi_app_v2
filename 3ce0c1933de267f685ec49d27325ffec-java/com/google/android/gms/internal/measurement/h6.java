package com.google.android.gms.internal.measurement;

import com.realsil.sdk.dfu.DfuException;
import java.io.IOException;
/* loaded from: classes.dex */
public final class h6 extends i<h6> {
    private static volatile h6[] N;

    /* renamed from: c  reason: collision with root package name */
    public Integer f9326c = null;

    /* renamed from: d  reason: collision with root package name */
    public e6[] f9327d = e6.h();

    /* renamed from: e  reason: collision with root package name */
    public j6[] f9328e = j6.h();

    /* renamed from: f  reason: collision with root package name */
    public Long f9329f = null;

    /* renamed from: g  reason: collision with root package name */
    public Long f9330g = null;

    /* renamed from: h  reason: collision with root package name */
    public Long f9331h = null;

    /* renamed from: i  reason: collision with root package name */
    public Long f9332i = null;

    /* renamed from: j  reason: collision with root package name */
    public Long f9333j = null;

    /* renamed from: k  reason: collision with root package name */
    public String f9334k = null;

    /* renamed from: l  reason: collision with root package name */
    public String f9335l = null;

    /* renamed from: m  reason: collision with root package name */
    public String f9336m = null;

    /* renamed from: n  reason: collision with root package name */
    public String f9337n = null;

    /* renamed from: o  reason: collision with root package name */
    public Integer f9338o = null;

    /* renamed from: p  reason: collision with root package name */
    public String f9339p = null;

    /* renamed from: q  reason: collision with root package name */
    public String f9340q = null;

    /* renamed from: r  reason: collision with root package name */
    public String f9341r = null;

    /* renamed from: s  reason: collision with root package name */
    public Long f9342s = null;

    /* renamed from: t  reason: collision with root package name */
    public Long f9343t = null;

    /* renamed from: u  reason: collision with root package name */
    public String f9344u = null;

    /* renamed from: v  reason: collision with root package name */
    public Boolean f9345v = null;

    /* renamed from: w  reason: collision with root package name */
    public String f9346w = null;

    /* renamed from: x  reason: collision with root package name */
    public Long f9347x = null;

    /* renamed from: y  reason: collision with root package name */
    public Integer f9348y = null;

    /* renamed from: z  reason: collision with root package name */
    public String f9349z = null;
    public String A = null;
    public Boolean B = null;
    public d6[] C = d6.h();
    public String D = null;
    public Integer E = null;
    private Integer F = null;
    private Integer G = null;
    public String H = null;
    public Long I = null;
    public Long J = null;
    public String K = null;
    private String L = null;
    public Integer M = null;

    public h6() {
        this.f9353b = null;
        this.f9521a = -1;
    }

    public static h6[] h() {
        if (N == null) {
            synchronized (m.f9497b) {
                if (N == null) {
                    N = new h6[0];
                }
            }
        }
        return N;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final int a() {
        int a10 = super.a();
        Integer num = this.f9326c;
        if (num != null) {
            a10 += h.w(1, num.intValue());
        }
        e6[] e6VarArr = this.f9327d;
        int i10 = 0;
        if (e6VarArr != null && e6VarArr.length > 0) {
            int i11 = 0;
            while (true) {
                e6[] e6VarArr2 = this.f9327d;
                if (i11 >= e6VarArr2.length) {
                    break;
                }
                e6 e6Var = e6VarArr2[i11];
                if (e6Var != null) {
                    a10 += h.o(2, e6Var);
                }
                i11++;
            }
        }
        j6[] j6VarArr = this.f9328e;
        if (j6VarArr != null && j6VarArr.length > 0) {
            int i12 = 0;
            while (true) {
                j6[] j6VarArr2 = this.f9328e;
                if (i12 >= j6VarArr2.length) {
                    break;
                }
                j6 j6Var = j6VarArr2[i12];
                if (j6Var != null) {
                    a10 += h.o(3, j6Var);
                }
                i12++;
            }
        }
        Long l10 = this.f9329f;
        if (l10 != null) {
            a10 += h.t(4, l10.longValue());
        }
        Long l11 = this.f9330g;
        if (l11 != null) {
            a10 += h.t(5, l11.longValue());
        }
        Long l12 = this.f9331h;
        if (l12 != null) {
            a10 += h.t(6, l12.longValue());
        }
        Long l13 = this.f9333j;
        if (l13 != null) {
            a10 += h.t(7, l13.longValue());
        }
        String str = this.f9334k;
        if (str != null) {
            a10 += h.u(8, str);
        }
        String str2 = this.f9335l;
        if (str2 != null) {
            a10 += h.u(9, str2);
        }
        String str3 = this.f9336m;
        if (str3 != null) {
            a10 += h.u(10, str3);
        }
        String str4 = this.f9337n;
        if (str4 != null) {
            a10 += h.u(11, str4);
        }
        Integer num2 = this.f9338o;
        if (num2 != null) {
            a10 += h.w(12, num2.intValue());
        }
        String str5 = this.f9339p;
        if (str5 != null) {
            a10 += h.u(13, str5);
        }
        String str6 = this.f9340q;
        if (str6 != null) {
            a10 += h.u(14, str6);
        }
        String str7 = this.f9341r;
        if (str7 != null) {
            a10 += h.u(16, str7);
        }
        Long l14 = this.f9342s;
        if (l14 != null) {
            a10 += h.t(17, l14.longValue());
        }
        Long l15 = this.f9343t;
        if (l15 != null) {
            a10 += h.t(18, l15.longValue());
        }
        String str8 = this.f9344u;
        if (str8 != null) {
            a10 += h.u(19, str8);
        }
        Boolean bool = this.f9345v;
        if (bool != null) {
            bool.booleanValue();
            a10 += h.l(20) + 1;
        }
        String str9 = this.f9346w;
        if (str9 != null) {
            a10 += h.u(21, str9);
        }
        Long l16 = this.f9347x;
        if (l16 != null) {
            a10 += h.t(22, l16.longValue());
        }
        Integer num3 = this.f9348y;
        if (num3 != null) {
            a10 += h.w(23, num3.intValue());
        }
        String str10 = this.f9349z;
        if (str10 != null) {
            a10 += h.u(24, str10);
        }
        String str11 = this.A;
        if (str11 != null) {
            a10 += h.u(25, str11);
        }
        Long l17 = this.f9332i;
        if (l17 != null) {
            a10 += h.t(26, l17.longValue());
        }
        Boolean bool2 = this.B;
        if (bool2 != null) {
            bool2.booleanValue();
            a10 += h.l(28) + 1;
        }
        d6[] d6VarArr = this.C;
        if (d6VarArr != null && d6VarArr.length > 0) {
            while (true) {
                d6[] d6VarArr2 = this.C;
                if (i10 >= d6VarArr2.length) {
                    break;
                }
                d6 d6Var = d6VarArr2[i10];
                if (d6Var != null) {
                    a10 += h.o(29, d6Var);
                }
                i10++;
            }
        }
        String str12 = this.D;
        if (str12 != null) {
            a10 += h.u(30, str12);
        }
        Integer num4 = this.E;
        if (num4 != null) {
            a10 += h.w(31, num4.intValue());
        }
        Integer num5 = this.F;
        if (num5 != null) {
            a10 += h.w(32, num5.intValue());
        }
        Integer num6 = this.G;
        if (num6 != null) {
            a10 += h.w(33, num6.intValue());
        }
        String str13 = this.H;
        if (str13 != null) {
            a10 += h.u(34, str13);
        }
        Long l18 = this.I;
        if (l18 != null) {
            a10 += h.t(35, l18.longValue());
        }
        Long l19 = this.J;
        if (l19 != null) {
            a10 += h.t(36, l19.longValue());
        }
        String str14 = this.K;
        if (str14 != null) {
            a10 += h.u(37, str14);
        }
        String str15 = this.L;
        if (str15 != null) {
            a10 += h.u(38, str15);
        }
        Integer num7 = this.M;
        return num7 != null ? a10 + h.w(39, num7.intValue()) : a10;
    }

    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final void b(h hVar) throws IOException {
        Integer num = this.f9326c;
        if (num != null) {
            hVar.v(1, num.intValue());
        }
        e6[] e6VarArr = this.f9327d;
        int i10 = 0;
        if (e6VarArr != null && e6VarArr.length > 0) {
            int i11 = 0;
            while (true) {
                e6[] e6VarArr2 = this.f9327d;
                if (i11 >= e6VarArr2.length) {
                    break;
                }
                e6 e6Var = e6VarArr2[i11];
                if (e6Var != null) {
                    hVar.e(2, e6Var);
                }
                i11++;
            }
        }
        j6[] j6VarArr = this.f9328e;
        if (j6VarArr != null && j6VarArr.length > 0) {
            int i12 = 0;
            while (true) {
                j6[] j6VarArr2 = this.f9328e;
                if (i12 >= j6VarArr2.length) {
                    break;
                }
                j6 j6Var = j6VarArr2[i12];
                if (j6Var != null) {
                    hVar.e(3, j6Var);
                }
                i12++;
            }
        }
        Long l10 = this.f9329f;
        if (l10 != null) {
            hVar.q(4, l10.longValue());
        }
        Long l11 = this.f9330g;
        if (l11 != null) {
            hVar.q(5, l11.longValue());
        }
        Long l12 = this.f9331h;
        if (l12 != null) {
            hVar.q(6, l12.longValue());
        }
        Long l13 = this.f9333j;
        if (l13 != null) {
            hVar.q(7, l13.longValue());
        }
        String str = this.f9334k;
        if (str != null) {
            hVar.r(8, str);
        }
        String str2 = this.f9335l;
        if (str2 != null) {
            hVar.r(9, str2);
        }
        String str3 = this.f9336m;
        if (str3 != null) {
            hVar.r(10, str3);
        }
        String str4 = this.f9337n;
        if (str4 != null) {
            hVar.r(11, str4);
        }
        Integer num2 = this.f9338o;
        if (num2 != null) {
            hVar.v(12, num2.intValue());
        }
        String str5 = this.f9339p;
        if (str5 != null) {
            hVar.r(13, str5);
        }
        String str6 = this.f9340q;
        if (str6 != null) {
            hVar.r(14, str6);
        }
        String str7 = this.f9341r;
        if (str7 != null) {
            hVar.r(16, str7);
        }
        Long l14 = this.f9342s;
        if (l14 != null) {
            hVar.q(17, l14.longValue());
        }
        Long l15 = this.f9343t;
        if (l15 != null) {
            hVar.q(18, l15.longValue());
        }
        String str8 = this.f9344u;
        if (str8 != null) {
            hVar.r(19, str8);
        }
        Boolean bool = this.f9345v;
        if (bool != null) {
            hVar.f(20, bool.booleanValue());
        }
        String str9 = this.f9346w;
        if (str9 != null) {
            hVar.r(21, str9);
        }
        Long l16 = this.f9347x;
        if (l16 != null) {
            hVar.q(22, l16.longValue());
        }
        Integer num3 = this.f9348y;
        if (num3 != null) {
            hVar.v(23, num3.intValue());
        }
        String str10 = this.f9349z;
        if (str10 != null) {
            hVar.r(24, str10);
        }
        String str11 = this.A;
        if (str11 != null) {
            hVar.r(25, str11);
        }
        Long l17 = this.f9332i;
        if (l17 != null) {
            hVar.q(26, l17.longValue());
        }
        Boolean bool2 = this.B;
        if (bool2 != null) {
            hVar.f(28, bool2.booleanValue());
        }
        d6[] d6VarArr = this.C;
        if (d6VarArr != null && d6VarArr.length > 0) {
            while (true) {
                d6[] d6VarArr2 = this.C;
                if (i10 >= d6VarArr2.length) {
                    break;
                }
                d6 d6Var = d6VarArr2[i10];
                if (d6Var != null) {
                    hVar.e(29, d6Var);
                }
                i10++;
            }
        }
        String str12 = this.D;
        if (str12 != null) {
            hVar.r(30, str12);
        }
        Integer num4 = this.E;
        if (num4 != null) {
            hVar.v(31, num4.intValue());
        }
        Integer num5 = this.F;
        if (num5 != null) {
            hVar.v(32, num5.intValue());
        }
        Integer num6 = this.G;
        if (num6 != null) {
            hVar.v(33, num6.intValue());
        }
        String str13 = this.H;
        if (str13 != null) {
            hVar.r(34, str13);
        }
        Long l18 = this.I;
        if (l18 != null) {
            hVar.q(35, l18.longValue());
        }
        Long l19 = this.J;
        if (l19 != null) {
            hVar.q(36, l19.longValue());
        }
        String str14 = this.K;
        if (str14 != null) {
            hVar.r(37, str14);
        }
        String str15 = this.L;
        if (str15 != null) {
            hVar.r(38, str15);
        }
        Integer num7 = this.M;
        if (num7 != null) {
            hVar.v(39, num7.intValue());
        }
        super.b(hVar);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final /* synthetic */ n c(g gVar) throws IOException {
        while (true) {
            int n10 = gVar.n();
            switch (n10) {
                case 0:
                    return this;
                case 8:
                    this.f9326c = Integer.valueOf(gVar.p());
                    break;
                case 18:
                    int a10 = q.a(gVar, 18);
                    e6[] e6VarArr = this.f9327d;
                    int length = e6VarArr == null ? 0 : e6VarArr.length;
                    int i10 = a10 + length;
                    e6[] e6VarArr2 = new e6[i10];
                    if (length != 0) {
                        System.arraycopy(e6VarArr, 0, e6VarArr2, 0, length);
                    }
                    while (length < i10 - 1) {
                        e6VarArr2[length] = new e6();
                        gVar.d(e6VarArr2[length]);
                        gVar.n();
                        length++;
                    }
                    e6VarArr2[length] = new e6();
                    gVar.d(e6VarArr2[length]);
                    this.f9327d = e6VarArr2;
                    break;
                case 26:
                    int a11 = q.a(gVar, 26);
                    j6[] j6VarArr = this.f9328e;
                    int length2 = j6VarArr == null ? 0 : j6VarArr.length;
                    int i11 = a11 + length2;
                    j6[] j6VarArr2 = new j6[i11];
                    if (length2 != 0) {
                        System.arraycopy(j6VarArr, 0, j6VarArr2, 0, length2);
                    }
                    while (length2 < i11 - 1) {
                        j6VarArr2[length2] = new j6();
                        gVar.d(j6VarArr2[length2]);
                        gVar.n();
                        length2++;
                    }
                    j6VarArr2[length2] = new j6();
                    gVar.d(j6VarArr2[length2]);
                    this.f9328e = j6VarArr2;
                    break;
                case 32:
                    this.f9329f = Long.valueOf(gVar.q());
                    break;
                case 40:
                    this.f9330g = Long.valueOf(gVar.q());
                    break;
                case 48:
                    this.f9331h = Long.valueOf(gVar.q());
                    break;
                case 56:
                    this.f9333j = Long.valueOf(gVar.q());
                    break;
                case 66:
                    this.f9334k = gVar.b();
                    break;
                case 74:
                    this.f9335l = gVar.b();
                    break;
                case 82:
                    this.f9336m = gVar.b();
                    break;
                case 90:
                    this.f9337n = gVar.b();
                    break;
                case 96:
                    this.f9338o = Integer.valueOf(gVar.p());
                    break;
                case 106:
                    this.f9339p = gVar.b();
                    break;
                case 114:
                    this.f9340q = gVar.b();
                    break;
                case 130:
                    this.f9341r = gVar.b();
                    break;
                case 136:
                    this.f9342s = Long.valueOf(gVar.q());
                    break;
                case 144:
                    this.f9343t = Long.valueOf(gVar.q());
                    break;
                case 154:
                    this.f9344u = gVar.b();
                    break;
                case 160:
                    this.f9345v = Boolean.valueOf(gVar.o());
                    break;
                case 170:
                    this.f9346w = gVar.b();
                    break;
                case 176:
                    this.f9347x = Long.valueOf(gVar.q());
                    break;
                case 184:
                    this.f9348y = Integer.valueOf(gVar.p());
                    break;
                case 194:
                    this.f9349z = gVar.b();
                    break;
                case 202:
                    this.A = gVar.b();
                    break;
                case 208:
                    this.f9332i = Long.valueOf(gVar.q());
                    break;
                case 224:
                    this.B = Boolean.valueOf(gVar.o());
                    break;
                case 234:
                    int a12 = q.a(gVar, 234);
                    d6[] d6VarArr = this.C;
                    int length3 = d6VarArr == null ? 0 : d6VarArr.length;
                    int i12 = a12 + length3;
                    d6[] d6VarArr2 = new d6[i12];
                    if (length3 != 0) {
                        System.arraycopy(d6VarArr, 0, d6VarArr2, 0, length3);
                    }
                    while (length3 < i12 - 1) {
                        d6VarArr2[length3] = new d6();
                        gVar.d(d6VarArr2[length3]);
                        gVar.n();
                        length3++;
                    }
                    d6VarArr2[length3] = new d6();
                    gVar.d(d6VarArr2[length3]);
                    this.C = d6VarArr2;
                    break;
                case 242:
                    this.D = gVar.b();
                    break;
                case 248:
                    this.E = Integer.valueOf(gVar.p());
                    break;
                case 256:
                    this.F = Integer.valueOf(gVar.p());
                    break;
                case DfuException.ERROR_CONNECT_ERROR /* 264 */:
                    this.G = Integer.valueOf(gVar.p());
                    break;
                case DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR /* 274 */:
                    this.H = gVar.b();
                    break;
                case DfuException.ERROR_ENTER_OTA_MODE_FAILED /* 280 */:
                    this.I = Long.valueOf(gVar.q());
                    break;
                case 288:
                    this.J = Long.valueOf(gVar.q());
                    break;
                case 298:
                    this.K = gVar.b();
                    break;
                case 306:
                    this.L = gVar.b();
                    break;
                case 312:
                    this.M = Integer.valueOf(gVar.p());
                    break;
                default:
                    if (super.g(gVar, n10)) {
                        break;
                    } else {
                        return this;
                    }
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h6)) {
            return false;
        }
        h6 h6Var = (h6) obj;
        Integer num = this.f9326c;
        if (num == null) {
            if (h6Var.f9326c != null) {
                return false;
            }
        } else if (!num.equals(h6Var.f9326c)) {
            return false;
        }
        if (!m.b(this.f9327d, h6Var.f9327d) || !m.b(this.f9328e, h6Var.f9328e)) {
            return false;
        }
        Long l10 = this.f9329f;
        if (l10 == null) {
            if (h6Var.f9329f != null) {
                return false;
            }
        } else if (!l10.equals(h6Var.f9329f)) {
            return false;
        }
        Long l11 = this.f9330g;
        if (l11 == null) {
            if (h6Var.f9330g != null) {
                return false;
            }
        } else if (!l11.equals(h6Var.f9330g)) {
            return false;
        }
        Long l12 = this.f9331h;
        if (l12 == null) {
            if (h6Var.f9331h != null) {
                return false;
            }
        } else if (!l12.equals(h6Var.f9331h)) {
            return false;
        }
        Long l13 = this.f9332i;
        if (l13 == null) {
            if (h6Var.f9332i != null) {
                return false;
            }
        } else if (!l13.equals(h6Var.f9332i)) {
            return false;
        }
        Long l14 = this.f9333j;
        if (l14 == null) {
            if (h6Var.f9333j != null) {
                return false;
            }
        } else if (!l14.equals(h6Var.f9333j)) {
            return false;
        }
        String str = this.f9334k;
        if (str == null) {
            if (h6Var.f9334k != null) {
                return false;
            }
        } else if (!str.equals(h6Var.f9334k)) {
            return false;
        }
        String str2 = this.f9335l;
        if (str2 == null) {
            if (h6Var.f9335l != null) {
                return false;
            }
        } else if (!str2.equals(h6Var.f9335l)) {
            return false;
        }
        String str3 = this.f9336m;
        if (str3 == null) {
            if (h6Var.f9336m != null) {
                return false;
            }
        } else if (!str3.equals(h6Var.f9336m)) {
            return false;
        }
        String str4 = this.f9337n;
        if (str4 == null) {
            if (h6Var.f9337n != null) {
                return false;
            }
        } else if (!str4.equals(h6Var.f9337n)) {
            return false;
        }
        Integer num2 = this.f9338o;
        if (num2 == null) {
            if (h6Var.f9338o != null) {
                return false;
            }
        } else if (!num2.equals(h6Var.f9338o)) {
            return false;
        }
        String str5 = this.f9339p;
        if (str5 == null) {
            if (h6Var.f9339p != null) {
                return false;
            }
        } else if (!str5.equals(h6Var.f9339p)) {
            return false;
        }
        String str6 = this.f9340q;
        if (str6 == null) {
            if (h6Var.f9340q != null) {
                return false;
            }
        } else if (!str6.equals(h6Var.f9340q)) {
            return false;
        }
        String str7 = this.f9341r;
        if (str7 == null) {
            if (h6Var.f9341r != null) {
                return false;
            }
        } else if (!str7.equals(h6Var.f9341r)) {
            return false;
        }
        Long l15 = this.f9342s;
        if (l15 == null) {
            if (h6Var.f9342s != null) {
                return false;
            }
        } else if (!l15.equals(h6Var.f9342s)) {
            return false;
        }
        Long l16 = this.f9343t;
        if (l16 == null) {
            if (h6Var.f9343t != null) {
                return false;
            }
        } else if (!l16.equals(h6Var.f9343t)) {
            return false;
        }
        String str8 = this.f9344u;
        if (str8 == null) {
            if (h6Var.f9344u != null) {
                return false;
            }
        } else if (!str8.equals(h6Var.f9344u)) {
            return false;
        }
        Boolean bool = this.f9345v;
        if (bool == null) {
            if (h6Var.f9345v != null) {
                return false;
            }
        } else if (!bool.equals(h6Var.f9345v)) {
            return false;
        }
        String str9 = this.f9346w;
        if (str9 == null) {
            if (h6Var.f9346w != null) {
                return false;
            }
        } else if (!str9.equals(h6Var.f9346w)) {
            return false;
        }
        Long l17 = this.f9347x;
        if (l17 == null) {
            if (h6Var.f9347x != null) {
                return false;
            }
        } else if (!l17.equals(h6Var.f9347x)) {
            return false;
        }
        Integer num3 = this.f9348y;
        if (num3 == null) {
            if (h6Var.f9348y != null) {
                return false;
            }
        } else if (!num3.equals(h6Var.f9348y)) {
            return false;
        }
        String str10 = this.f9349z;
        if (str10 == null) {
            if (h6Var.f9349z != null) {
                return false;
            }
        } else if (!str10.equals(h6Var.f9349z)) {
            return false;
        }
        String str11 = this.A;
        if (str11 == null) {
            if (h6Var.A != null) {
                return false;
            }
        } else if (!str11.equals(h6Var.A)) {
            return false;
        }
        Boolean bool2 = this.B;
        if (bool2 == null) {
            if (h6Var.B != null) {
                return false;
            }
        } else if (!bool2.equals(h6Var.B)) {
            return false;
        }
        if (!m.b(this.C, h6Var.C)) {
            return false;
        }
        String str12 = this.D;
        if (str12 == null) {
            if (h6Var.D != null) {
                return false;
            }
        } else if (!str12.equals(h6Var.D)) {
            return false;
        }
        Integer num4 = this.E;
        if (num4 == null) {
            if (h6Var.E != null) {
                return false;
            }
        } else if (!num4.equals(h6Var.E)) {
            return false;
        }
        Integer num5 = this.F;
        if (num5 == null) {
            if (h6Var.F != null) {
                return false;
            }
        } else if (!num5.equals(h6Var.F)) {
            return false;
        }
        Integer num6 = this.G;
        if (num6 == null) {
            if (h6Var.G != null) {
                return false;
            }
        } else if (!num6.equals(h6Var.G)) {
            return false;
        }
        String str13 = this.H;
        if (str13 == null) {
            if (h6Var.H != null) {
                return false;
            }
        } else if (!str13.equals(h6Var.H)) {
            return false;
        }
        Long l18 = this.I;
        if (l18 == null) {
            if (h6Var.I != null) {
                return false;
            }
        } else if (!l18.equals(h6Var.I)) {
            return false;
        }
        Long l19 = this.J;
        if (l19 == null) {
            if (h6Var.J != null) {
                return false;
            }
        } else if (!l19.equals(h6Var.J)) {
            return false;
        }
        String str14 = this.K;
        if (str14 == null) {
            if (h6Var.K != null) {
                return false;
            }
        } else if (!str14.equals(h6Var.K)) {
            return false;
        }
        String str15 = this.L;
        if (str15 == null) {
            if (h6Var.L != null) {
                return false;
            }
        } else if (!str15.equals(h6Var.L)) {
            return false;
        }
        Integer num7 = this.M;
        if (num7 == null) {
            if (h6Var.M != null) {
                return false;
            }
        } else if (!num7.equals(h6Var.M)) {
            return false;
        }
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            return this.f9353b.equals(h6Var.f9353b);
        }
        k kVar2 = h6Var.f9353b;
        return kVar2 == null || kVar2.b();
    }

    public final int hashCode() {
        int hashCode = (h6.class.getName().hashCode() + 527) * 31;
        Integer num = this.f9326c;
        int i10 = 0;
        int hashCode2 = (((((hashCode + (num == null ? 0 : num.hashCode())) * 31) + m.d(this.f9327d)) * 31) + m.d(this.f9328e)) * 31;
        Long l10 = this.f9329f;
        int hashCode3 = (hashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.f9330g;
        int hashCode4 = (hashCode3 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Long l12 = this.f9331h;
        int hashCode5 = (hashCode4 + (l12 == null ? 0 : l12.hashCode())) * 31;
        Long l13 = this.f9332i;
        int hashCode6 = (hashCode5 + (l13 == null ? 0 : l13.hashCode())) * 31;
        Long l14 = this.f9333j;
        int hashCode7 = (hashCode6 + (l14 == null ? 0 : l14.hashCode())) * 31;
        String str = this.f9334k;
        int hashCode8 = (hashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f9335l;
        int hashCode9 = (hashCode8 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f9336m;
        int hashCode10 = (hashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f9337n;
        int hashCode11 = (hashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num2 = this.f9338o;
        int hashCode12 = (hashCode11 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str5 = this.f9339p;
        int hashCode13 = (hashCode12 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f9340q;
        int hashCode14 = (hashCode13 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f9341r;
        int hashCode15 = (hashCode14 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Long l15 = this.f9342s;
        int hashCode16 = (hashCode15 + (l15 == null ? 0 : l15.hashCode())) * 31;
        Long l16 = this.f9343t;
        int hashCode17 = (hashCode16 + (l16 == null ? 0 : l16.hashCode())) * 31;
        String str8 = this.f9344u;
        int hashCode18 = (hashCode17 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool = this.f9345v;
        int hashCode19 = (hashCode18 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str9 = this.f9346w;
        int hashCode20 = (hashCode19 + (str9 == null ? 0 : str9.hashCode())) * 31;
        Long l17 = this.f9347x;
        int hashCode21 = (hashCode20 + (l17 == null ? 0 : l17.hashCode())) * 31;
        Integer num3 = this.f9348y;
        int hashCode22 = (hashCode21 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str10 = this.f9349z;
        int hashCode23 = (hashCode22 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.A;
        int hashCode24 = (hashCode23 + (str11 == null ? 0 : str11.hashCode())) * 31;
        Boolean bool2 = this.B;
        int hashCode25 = (((hashCode24 + (bool2 == null ? 0 : bool2.hashCode())) * 31) + m.d(this.C)) * 31;
        String str12 = this.D;
        int hashCode26 = (hashCode25 + (str12 == null ? 0 : str12.hashCode())) * 31;
        Integer num4 = this.E;
        int hashCode27 = (hashCode26 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.F;
        int hashCode28 = (hashCode27 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.G;
        int hashCode29 = (hashCode28 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str13 = this.H;
        int hashCode30 = (hashCode29 + (str13 == null ? 0 : str13.hashCode())) * 31;
        Long l18 = this.I;
        int hashCode31 = (hashCode30 + (l18 == null ? 0 : l18.hashCode())) * 31;
        Long l19 = this.J;
        int hashCode32 = (hashCode31 + (l19 == null ? 0 : l19.hashCode())) * 31;
        String str14 = this.K;
        int hashCode33 = (hashCode32 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.L;
        int hashCode34 = (hashCode33 + (str15 == null ? 0 : str15.hashCode())) * 31;
        Integer num7 = this.M;
        int hashCode35 = (hashCode34 + (num7 == null ? 0 : num7.hashCode())) * 31;
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            i10 = this.f9353b.hashCode();
        }
        return hashCode35 + i10;
    }
}
