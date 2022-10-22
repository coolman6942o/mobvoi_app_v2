package km;

import android.util.SparseIntArray;
import cm.d;
import com.realsil.sdk.dfu.exception.LoadFileException;
import com.realsil.sdk.dfu.model.ImageVersionInfo;
import il.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import ul.c;
import zl.a;
/* loaded from: classes2.dex */
public class f extends a {
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0120 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int o(int i10, wl.a aVar, d dVar) {
        int i11;
        int i12;
        ImageVersionInfo w10;
        String str;
        String format;
        ul.a a10 = ul.a.a(ul.a.f35468k, i10);
        if (a10 == null) {
            return 1;
        }
        b.j(a10.toString());
        int i13 = aVar.f36312l;
        int i14 = aVar.f36308h;
        ImageVersionInfo p10 = dVar.p(i10);
        int i15 = 3;
        if (p10 != null) {
            if (p10.d() == -1) {
                b.j(String.format("invalid active version:0x%04X, no need to check", Integer.valueOf(i13)));
            } else {
                i12 = -1;
                i11 = i14;
                if (a.h(dVar.f6004j, aVar.w(), aVar.O(), i13, i14, dVar.f5995a, p10.d(), dVar.f6005k, a10.f35475f, dVar.O()) == -1) {
                    format = String.format(Locale.US, "active image: bitNumber=%d, file(%08X)<device(%08X)", Integer.valueOf(i10), Integer.valueOf(i13), Integer.valueOf(p10.d()));
                    b.j(format);
                    return i12;
                }
                i15 = 3;
                b.j(String.format("version validate ok :0x%04X", Integer.valueOf(i13)));
                w10 = dVar.w(i10);
                if (w10 != null) {
                    return 1;
                }
                if (w10.d() == i12) {
                    str = String.format("invalid inactive version:0x%04X, no need to check", Integer.valueOf(i13));
                } else {
                    int i16 = i15;
                    if (a.h(dVar.f6004j, aVar.w(), aVar.O(), i13, i11, dVar.f5995a, w10.d(), dVar.f6005k, a10.f35475f, dVar.O()) == i12) {
                        Locale locale = Locale.US;
                        Object[] objArr = new Object[i16];
                        objArr[0] = Integer.valueOf(i10);
                        objArr[1] = Integer.valueOf(i13);
                        objArr[2] = Integer.valueOf(w10.d());
                        format = String.format(locale, "inactive image: bitNumber=%d, file(%08X)<device(%08X)", objArr);
                        b.j(format);
                        return i12;
                    }
                    str = "version validate ok: " + i13;
                }
                b.j(str);
                return 1;
            }
        }
        i12 = -1;
        i11 = i14;
        w10 = dVar.w(i10);
        if (w10 != null) {
        }
    }

    public static int p(wl.a aVar, d dVar) {
        if (dVar == null) {
            return 1;
        }
        int w10 = aVar.w();
        int Q = aVar.Q();
        ul.a aVar2 = null;
        int i10 = dVar.f6004j;
        if (i10 == 4 || i10 == 6 || i10 == 7 || i10 == 8 || i10 == 10) {
            Iterator<ul.a> it = ul.a.f35468k.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ul.a next = it.next();
                if (next.f35473d == w10) {
                    if (next.f35474e) {
                        aVar2 = next;
                    }
                }
            }
            if (aVar2 != null) {
                b.c(aVar2.toString());
                List<ImageVersionInfo> v10 = dVar.v();
                if (v10 != null && v10.size() > 0) {
                    Iterator<ImageVersionInfo> it2 = v10.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        ImageVersionInfo next2 = it2.next();
                        if (next2.a() == aVar2.f35470a) {
                            if (next2.c() <= 0 || Q <= next2.c()) {
                                b.j("section size validate ok: " + Q);
                            } else {
                                b.l(String.format(Locale.US, "image size is %d exceed the limit of the section size %d", Integer.valueOf(Q), Integer.valueOf(next2.c())));
                                return 2;
                            }
                        }
                    }
                }
            }
        } else {
            boolean z10 = a.f37626a;
            b.k(z10, "not support section size check for ic:" + dVar.f6004j);
        }
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x01f3, code lost:
        if (r1 == p(r2, r4)) goto L80;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static cm.a q(c cVar) {
        ArrayList arrayList;
        int i10;
        boolean z10;
        boolean z11;
        int i11;
        Iterator<vl.a> it;
        int i12;
        vl.a v10;
        cVar.a();
        int h10 = cVar.h();
        String d10 = cVar.d();
        String e10 = cVar.e();
        int b10 = cVar.b();
        d f10 = cVar.f();
        boolean v11 = cVar.v();
        boolean q5 = cVar.q();
        boolean s10 = cVar.s();
        b.j(String.format(Locale.US, "device >> otaVersion=%d, preferredIcType=0x%02X", Integer.valueOf(f10 != null ? f10.f6005k : 1), Integer.valueOf(h10)));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        cm.a a10 = a.a(d10, e10);
        a10.f5988k = cVar.k();
        ql.a n10 = pl.b.n(cVar);
        if (n10 != null) {
            a10.f5982e = true;
            a10.f5983f = n10.u();
            a10.f5989l = n10.E(0);
            a10.f5991n = n10.E(1);
            if (!q5 || a.c(a10.f5983f, h10)) {
                if (!s10 || (v10 = n10.v(a.m(2, n10.c()))) == null) {
                    z11 = true;
                    z10 = false;
                } else {
                    wl.a f11 = v10.f(a10.f5983f);
                    if (f11 == null || 1 == s(2, f11, f10)) {
                        z11 = true;
                        z10 = true;
                    } else {
                        z10 = true;
                        z11 = false;
                    }
                }
                if (z11) {
                    Iterator<vl.a> it2 = n10.E(cVar.k()).iterator();
                    i11 = 0;
                    while (it2.hasNext()) {
                        vl.a next = it2.next();
                        int g10 = next.g();
                        if (!ul.a.c(b10, g10)) {
                            b.j("prohibit upgrade image_id=" + next.f35837j);
                        } else {
                            wl.a f12 = next.f(a10.f5983f);
                            if (f12 == null) {
                                b.k(a.f37626a, "invalid stream: " + next.toString());
                            } else {
                                if (v11) {
                                    it = it2;
                                    i12 = 1;
                                    if (1 != o(g10, f12, f10)) {
                                        i11 = 1;
                                        it2 = it;
                                    }
                                } else {
                                    it = it2;
                                    i12 = 1;
                                }
                                if (s10) {
                                    if (z10) {
                                        b.c("preVerify OTA_HEADER_FILE ok, no need to check section size");
                                    } else if (i12 != s(g10, f12, f10)) {
                                        a10.f5986i = false;
                                        a10.f5985h = LoadFileException.ERROR_SECTION_SIZE_CHECK_FAILED;
                                        return a10;
                                    }
                                }
                                arrayList4.add(f12);
                                arrayList2.add(next);
                                it2 = it;
                            }
                        }
                        it = it2;
                        it2 = it;
                    }
                } else {
                    b.l("pre verify failed");
                    i11 = 0;
                }
                try {
                    n10.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                    b.e(e11.toString());
                }
                i10 = i11;
                arrayList = arrayList4;
            } else {
                b.c(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                a10.f5986i = false;
                a10.f5985h = 4101;
                return a10;
            }
        } else {
            byte[] bArr = null;
            try {
                arrayList = arrayList4;
                wl.a l10 = a.l(a10.f5983f, d10, 0L);
                if (l10 != null) {
                    l10.h0();
                    bArr = l10.W();
                    try {
                        l10.close();
                    } catch (Exception e12) {
                        b.e(e12.toString());
                    }
                }
                wl.a l11 = a.l(h10, d10, 0L);
                if (l11 != null) {
                    l11.r0(bArr);
                    arrayList3.add(l11);
                    a10.f5983f = l11.I();
                    a10.f5984g = l11.T();
                    if (!q5 || a.c(a10.f5983f, h10)) {
                        if (v11) {
                            i10 = 1;
                            if (1 != a.f(l11, f10)) {
                            }
                        } else {
                            i10 = 1;
                        }
                        if (s10) {
                        }
                        arrayList.add(l11);
                    } else {
                        b.c(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                        a10.f5986i = false;
                        a10.f5985h = 4101;
                        return a10;
                    }
                }
                i10 = 0;
            } catch (IOException e13) {
                e13.printStackTrace();
                throw new LoadFileException(e13.getMessage(), 4097);
            }
        }
        a10.f5990m = arrayList3;
        a10.f5993p = arrayList;
        a10.f5992o = arrayList2;
        if (v11 && i10 != 0 && arrayList.size() < 1) {
            a10.f5986i = false;
            a10.f5985h = LoadFileException.ERROR_VERSION_CHECK_LOW;
        }
        return a10;
    }

    public static boolean r(int i10) {
        return i10 == 5 || i10 == 21 || i10 == 4 || i10 == 20 || i10 == 2 || i10 == 18 || i10 == 7 || i10 == 23 || i10 == 6 || i10 == 22;
    }

    public static int s(int i10, wl.a aVar, d dVar) {
        if (dVar == null) {
            return 1;
        }
        int Q = aVar.Q();
        int i11 = dVar.f6004j;
        if (i11 == 4 || i11 == 6 || i11 == 7 || i11 == 8 || i11 == 10) {
            List<ImageVersionInfo> v10 = dVar.v();
            if (v10 != null && v10.size() > 0) {
                Iterator<ImageVersionInfo> it = v10.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ImageVersionInfo next = it.next();
                    if (next.a() == i10) {
                        if (next.c() <= 0 || Q <= next.c()) {
                            b.j("section size validate ok: " + Q);
                        } else {
                            b.l(String.format(Locale.US, "image size is %d exceed the limit of the section size %d", Integer.valueOf(Q), Integer.valueOf(next.c())));
                            return 2;
                        }
                    }
                }
            }
        } else {
            boolean z10 = a.f37626a;
            b.k(z10, "not support section size check for ic:" + dVar.f6004j);
        }
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0278, code lost:
        r5 = r12.v();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0289, code lost:
        r14 = r12.v();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static cm.a t(c cVar) {
        Iterator<vl.a> it;
        ArrayList arrayList;
        ql.a aVar;
        boolean z10;
        SparseIntArray sparseIntArray;
        int i10;
        char c10;
        int i11;
        int h10 = cVar.h();
        String d10 = cVar.d();
        String e10 = cVar.e();
        int b10 = cVar.b();
        d f10 = cVar.f();
        boolean q5 = cVar.q();
        boolean v10 = cVar.v();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        cm.a a10 = a.a(d10, e10);
        a10.f5983f = h10;
        a10.f5988k = cVar.k();
        try {
            ql.a n10 = pl.b.n(cVar);
            b.j(n10.toString());
            a10.f5982e = true;
            a10.f5983f = n10.u();
            a10.f5989l = n10.E(0);
            a10.f5991n = n10.E(1);
            if (q5 && !a.c(a10.f5983f, h10)) {
                b.c(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                a10.f5986i = false;
                a10.f5985h = 4101;
                return a10;
            } else if (!n10.q(a.m(2, n10.c()), a10.f5988k)) {
                b.l("OtaHeader Miss");
                a10.f5986i = false;
                a10.f5985h = LoadFileException.ERROR_INCOMPLETE_MISS_OTA_HEADER;
                return a10;
            } else {
                Iterator<vl.a> it2 = n10.E(cVar.k()).iterator();
                int i12 = 0;
                int i13 = 0;
                while (it2.hasNext()) {
                    vl.a next = it2.next();
                    int g10 = next.g();
                    if (!ul.a.c(b10, g10)) {
                        b.j("prohibit upgrade image_id=" + next.f35837j);
                    } else {
                        ul.a a11 = ul.a.a(ul.a.f35468k, g10);
                        if (a11 != null) {
                            wl.a f11 = next.f(a10.f5983f);
                            if (f11 == null) {
                                boolean z11 = a.f37626a;
                                StringBuilder sb2 = new StringBuilder();
                                it = it2;
                                sb2.append("not find image: ");
                                sb2.append(a11.toString());
                                b.k(z11, sb2.toString());
                                if (cVar.o() && ol.a.b(g10)) {
                                    sparseIntArray2.append(a11.f35472c, g10);
                                }
                                it2 = it;
                            } else {
                                it2 = it2;
                                if (f10 != null) {
                                    ImageVersionInfo q10 = f10.q(f11.O());
                                    i10 = b10;
                                    if (q10 != null) {
                                        sparseIntArray = sparseIntArray2;
                                        if (q10.d() == -1) {
                                            b.j(String.format("invalid active version:0x%04X, no need to check", Integer.valueOf(q10.d())));
                                            f11.m0(1);
                                            z10 = v10;
                                            arrayList = arrayList2;
                                            i11 = 1;
                                            aVar = n10;
                                        } else {
                                            z10 = v10;
                                            aVar = n10;
                                            arrayList = arrayList2;
                                            int h11 = a.h(a10.f5983f, f11.w(), f11.O(), f11.f36312l, f11.f36308h, f10.f5995a, q10.d(), f10.f6005k, a11.f35475f, cVar.p());
                                            b.j(String.format(Locale.US, "compare active image, bitNumber=%d, compare=%d ", Integer.valueOf(g10), Integer.valueOf(h11)));
                                            f11.m0(h11);
                                            i11 = 1;
                                        }
                                    } else {
                                        z10 = v10;
                                        arrayList = arrayList2;
                                        sparseIntArray = sparseIntArray2;
                                        aVar = n10;
                                        b.c("not find active image, bitNumber=" + g10);
                                        i11 = 1;
                                        f11.m0(1);
                                    }
                                    ImageVersionInfo x10 = f10.x(f11.O());
                                    if (x10 == null) {
                                        c10 = 2;
                                        b.c("not find inactive image, bitNumber=" + g10);
                                        i11 = 1;
                                        f11.o0(1);
                                    } else if (x10.d() == -1) {
                                        Object[] objArr = new Object[i11];
                                        objArr[0] = Integer.valueOf(x10.d());
                                        b.j(String.format("invalid inactive version:0x%04X, no need to check", objArr));
                                        f11.o0(i11);
                                        c10 = 2;
                                    } else {
                                        int h12 = a.h(a10.f5983f, f11.w(), f11.O(), f11.f36312l, f11.f36308h, f10.f5995a, x10.d(), f10.f6005k, a11.f35475f, cVar.p());
                                        c10 = 2;
                                        b.j(String.format(Locale.US, "compare inactive image, bitNumber=%d, compare=%d ", Integer.valueOf(g10), Integer.valueOf(h12)));
                                        f11.o0(h12);
                                        i11 = 1;
                                    }
                                    if (r(g10)) {
                                        if (i12 > 0) {
                                        }
                                    } else if (i13 > 0) {
                                    }
                                } else {
                                    i10 = b10;
                                    z10 = v10;
                                    arrayList = arrayList2;
                                    sparseIntArray = sparseIntArray2;
                                    aVar = n10;
                                    i11 = 1;
                                    c10 = 2;
                                }
                                arrayList3.add(f11);
                                arrayList4.add(f11);
                                ArrayList arrayList5 = arrayList;
                                arrayList5.add(next);
                                arrayList2 = arrayList5;
                                b10 = i10;
                                sparseIntArray2 = sparseIntArray;
                                v10 = z10;
                                n10 = aVar;
                            }
                        }
                    }
                    it = it2;
                    it2 = it;
                }
                boolean z12 = v10;
                ArrayList arrayList6 = arrayList2;
                SparseIntArray sparseIntArray3 = sparseIntArray2;
                try {
                    n10.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                    b.e(e11.toString());
                }
                if (z12 && i12 <= 0) {
                    if (i12 != 0) {
                        b.c("all code image version must >= active image version");
                        a10.f5986i = false;
                        a10.f5985h = 4114;
                        return a10;
                    } else if (i13 <= 0) {
                        b.c("there must be at least one data image version> active image version");
                        a10.f5986i = false;
                        a10.f5985h = 4113;
                        return a10;
                    }
                }
                a10.f5994q = sparseIntArray3;
                a10.f5990m = arrayList3;
                a10.f5993p = arrayList4;
                a10.f5992o = arrayList6;
                return a10;
            }
        } catch (LoadFileException e12) {
            a10.f5986i = false;
            a10.f5985h = e12.getErrCode();
            return a10;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static cm.a u(c cVar) {
        int i10;
        boolean z10;
        ql.a aVar;
        int i11;
        Iterator<vl.a> it;
        char c10;
        int i12;
        String str;
        String str2;
        int h10 = cVar.h();
        String d10 = cVar.d();
        String e10 = cVar.e();
        int b10 = cVar.b();
        d f10 = cVar.f();
        boolean v10 = cVar.v();
        boolean q5 = cVar.q();
        int i13 = 1;
        b.j(String.format(Locale.US, "device >> preferredIcType=%d, icType=0x%02X", Integer.valueOf(f10 != null ? f10.f6005k : 1), Integer.valueOf(h10)));
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        cm.a a10 = a.a(d10, e10);
        a10.f5988k = cVar.k();
        try {
            ql.a n10 = pl.b.n(cVar);
            if (n10 == null) {
                try {
                    wl.a l10 = a.l(h10, d10, 0L);
                    if (l10 != null) {
                        arrayList2.add(l10);
                        a10.f5983f = l10.I();
                        a10.f5984g = l10.T();
                        if (q5 && !a.c(a10.f5983f, h10)) {
                            b.c(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                            a10.f5986i = false;
                            a10.f5985h = 4101;
                            return a10;
                        } else if (!v10 || 1 == a.f(l10, f10)) {
                            arrayList3.add(l10);
                        }
                    }
                } catch (IOException e11) {
                    e11.printStackTrace();
                }
            } else {
                b.j(n10.toString());
                a10.f5982e = true;
                a10.f5983f = n10.u();
                a10.f5989l = n10.E(0);
                a10.f5991n = n10.E(1);
                if (!q5 || a.c(a10.f5983f, h10)) {
                    Iterator<vl.a> it2 = n10.E(cVar.k()).iterator();
                    int i14 = 0;
                    int i15 = 0;
                    while (it2.hasNext()) {
                        vl.a next = it2.next();
                        int g10 = next.g();
                        if (!ul.a.c(b10, g10)) {
                            str2 = "prohibit upgrade image_id=" + next.f35837j;
                        } else {
                            ul.a a11 = ul.a.a(ul.a.f35468k, g10);
                            if (a11 == null) {
                                str2 = "undefined image";
                            } else {
                                b.k(a.f37626a, a11.toString());
                                wl.a f11 = next.f(a10.f5983f);
                                if (f11 == null) {
                                    b.k(a.f37626a, "invalid stream: " + next.toString());
                                    it = it2;
                                    i11 = b10;
                                    z10 = v10;
                                    i10 = i15;
                                    aVar = n10;
                                    i12 = 1;
                                    c10 = 2;
                                    i13 = i12;
                                    it2 = it;
                                    b10 = i11;
                                    n10 = aVar;
                                    v10 = z10;
                                    i15 = i10;
                                } else {
                                    if (f10 != null) {
                                        ImageVersionInfo q10 = f10.q(f11.O());
                                        it = it2;
                                        i11 = b10;
                                        if (q10 == null) {
                                            z10 = v10;
                                            i10 = i15;
                                            aVar = n10;
                                            b.c("not find active image, bitNumber=" + g10);
                                            i12 = 1;
                                            f11.m0(1);
                                        } else if (q10.d() == -1) {
                                            b.j(String.format("invalid active version:0x%04X, no need to check", Integer.valueOf(q10.d())));
                                            f11.m0(1);
                                            i12 = 1;
                                            z10 = v10;
                                            i10 = i15;
                                            aVar = n10;
                                        } else {
                                            aVar = n10;
                                            z10 = v10;
                                            i10 = i15;
                                            int h11 = a.h(a10.f5983f, f11.w(), f11.O(), f11.f36312l, f11.f36308h, f10.f5995a, q10.d(), f10.f6005k, a11.f35475f, cVar.p());
                                            b.c(String.format(Locale.US, "compare active image, bitNumber=%d, compare=%d ", Integer.valueOf(g10), Integer.valueOf(h11)));
                                            f11.m0(h11);
                                            i12 = 1;
                                        }
                                        ImageVersionInfo x10 = f10.x(f11.O());
                                        if (x10 == null) {
                                            b.d(a.f37626a, "not find inactive image, bitNumber=" + g10);
                                            i12 = 1;
                                        } else if (x10.d() == -1) {
                                            Object[] objArr = new Object[i12];
                                            objArr[0] = Integer.valueOf(x10.d());
                                            b.j(String.format("invalid inactive version:0x%04X, no need to check", objArr));
                                        } else {
                                            int h12 = a.h(a10.f5983f, f11.w(), f11.O(), f11.f36312l, f11.f36308h, f10.f5995a, x10.d(), f10.f6005k, a11.f35475f, cVar.p());
                                            b.j(String.format(Locale.US, "compare inactive image, bitNumber=%d, compare=%d ", Integer.valueOf(g10), Integer.valueOf(h12)));
                                            f11.o0(h12);
                                        }
                                        f11.o0(i12);
                                        arrayList2.add(f11);
                                        c10 = 2;
                                        if (g10 != 2) {
                                            str = "ignore OTA_HEADER_FILE";
                                        } else if (g10 == i12) {
                                            str = "ignore SYSTEM_CONFIG_FILE";
                                        } else {
                                            arrayList3.add(f11);
                                            arrayList.add(next);
                                            if (r(g10)) {
                                                if (i14 <= 0 ? i14 == 0 : f11.v() < 0) {
                                                    i14 = f11.v();
                                                }
                                            } else if (i10 <= 0 ? i10 == 0 : f11.v() < 0) {
                                                i15 = f11.v();
                                                i13 = i12;
                                                it2 = it;
                                                b10 = i11;
                                                n10 = aVar;
                                                v10 = z10;
                                            }
                                            i13 = i12;
                                            it2 = it;
                                            b10 = i11;
                                            n10 = aVar;
                                            v10 = z10;
                                            i15 = i10;
                                        }
                                        b.j(str);
                                        i13 = i12;
                                        it2 = it;
                                        b10 = i11;
                                        n10 = aVar;
                                        v10 = z10;
                                        i15 = i10;
                                    } else {
                                        it = it2;
                                        i11 = b10;
                                        z10 = v10;
                                        i10 = i15;
                                        aVar = n10;
                                    }
                                    i12 = 1;
                                    arrayList2.add(f11);
                                    c10 = 2;
                                    if (g10 != 2) {
                                    }
                                    b.j(str);
                                    i13 = i12;
                                    it2 = it;
                                    b10 = i11;
                                    n10 = aVar;
                                    v10 = z10;
                                    i15 = i10;
                                }
                            }
                        }
                        b.j(str2);
                        it = it2;
                        i11 = b10;
                        z10 = v10;
                        i10 = i15;
                        i12 = i13;
                        aVar = n10;
                        c10 = 2;
                        i13 = i12;
                        it2 = it;
                        b10 = i11;
                        n10 = aVar;
                        v10 = z10;
                        i15 = i10;
                    }
                    int i16 = i15;
                    ql.a aVar2 = n10;
                    if (v10 && i14 <= 0) {
                        if (i14 != 0) {
                            b.c("all code image version must >= active image version");
                            a10.f5986i = false;
                            a10.f5985h = 4114;
                            return a10;
                        } else if (i16 <= 0) {
                            b.c("there must be at least one data image version> active image version");
                            a10.f5986i = false;
                            a10.f5985h = 4113;
                            return a10;
                        }
                    }
                    try {
                        aVar2.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                        b.e(e12.toString());
                    }
                } else {
                    b.c(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                    a10.f5986i = false;
                    a10.f5985h = 4101;
                    return a10;
                }
            }
            a10.f5990m = arrayList2;
            a10.f5993p = arrayList3;
            a10.f5992o = arrayList;
            return a10;
        } catch (LoadFileException e13) {
            a10.f5986i = false;
            a10.f5985h = e13.getErrCode();
            return a10;
        }
    }
}
