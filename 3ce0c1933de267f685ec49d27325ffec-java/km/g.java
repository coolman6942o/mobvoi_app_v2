package km;

import android.content.Context;
import android.util.SparseIntArray;
import cm.d;
import com.realsil.sdk.dfu.exception.LoadFileException;
import com.realsil.sdk.dfu.model.ImageVersionInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import ul.c;
/* loaded from: classes2.dex */
public class g extends zl.a {

    /* loaded from: classes2.dex */
    public static class a implements Comparator<wl.a> {
        /* renamed from: a */
        public int compare(wl.a aVar, wl.a aVar2) {
            return aVar.B - aVar2.B;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Comparator<wl.a> {
        /* renamed from: a */
        public int compare(wl.a aVar, wl.a aVar2) {
            return aVar.B - aVar2.B;
        }
    }

    public static int o(int i10, wl.a aVar, d dVar) {
        if (dVar == null) {
            return 1;
        }
        int Q = aVar.Q();
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
                        il.b.j("section validate ok: " + Q);
                    } else {
                        il.b.l(String.format(Locale.US, "image size is %d exceed the limit of the section size %d", Integer.valueOf(Q), Integer.valueOf(next.c())));
                        return 2;
                    }
                }
            }
        }
        return 1;
    }

    public static int p(wl.a aVar, d dVar) {
        if (dVar == null) {
            return 1;
        }
        int w10 = aVar.w();
        int Q = aVar.Q();
        ul.a aVar2 = null;
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
            il.b.c(aVar2.toString());
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
                            il.b.j("section validate ok: " + Q);
                        } else {
                            il.b.l(String.format(Locale.US, "image size is %d exceed the limit of the section size %d", Integer.valueOf(Q), Integer.valueOf(next2.c())));
                            return 2;
                        }
                    }
                }
            }
        }
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int q(wl.a aVar, d dVar, int i10) {
        int i11;
        ImageVersionInfo x10;
        String format;
        int i12 = aVar.f36312l;
        int i13 = aVar.f36308h;
        ImageVersionInfo q5 = dVar.q(aVar.O());
        int i14 = 1;
        if (q5 != null) {
            if (q5.d() == -1) {
                il.b.j(String.format("invalid active version:0x%04X, no need to check", Integer.valueOf(i12)));
            } else {
                i11 = -1;
                if (zl.a.h(dVar.f6004j, aVar.w(), aVar.O(), i12, i13, dVar.f5995a, q5.d(), dVar.f6005k, i10, dVar.O()) == -1) {
                    format = String.format(Locale.US, "active image: file(%08X)<device(%08X)", Integer.valueOf(i12), Integer.valueOf(q5.d()));
                    il.b.j(format);
                    return i11;
                }
                i14 = 1;
                il.b.k(zl.a.f37626a, String.format("active version validate ok :0x%04X", Integer.valueOf(i12)));
                x10 = dVar.x(aVar.O());
                if (x10 != null) {
                    if (x10.d() == i11) {
                        Object[] objArr = new Object[i14];
                        objArr[0] = Integer.valueOf(i12);
                        il.b.j(String.format("invalid inactive version:0x%04X, no need to check", objArr));
                    } else if (zl.a.h(dVar.f6004j, aVar.w(), aVar.O(), i12, i13, dVar.f5995a, x10.d(), dVar.f6005k, i10, dVar.O()) == i11) {
                        Locale locale = Locale.US;
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = Integer.valueOf(i12);
                        objArr2[i14] = Integer.valueOf(x10.d());
                        format = String.format(locale, "inactive image:  file(%08X)<device(%08X)", objArr2);
                        il.b.j(format);
                        return i11;
                    } else {
                        boolean z10 = zl.a.f37626a;
                        Object[] objArr3 = new Object[i14];
                        objArr3[0] = Integer.valueOf(i12);
                        il.b.k(z10, String.format("inactive version validate ok :0x%04X", objArr3));
                    }
                }
                return i14;
            }
        }
        i11 = -1;
        x10 = dVar.x(aVar.O());
        if (x10 != null) {
        }
        return i14;
    }

    public static cm.a r(c cVar) {
        boolean z10;
        Context a10 = cVar.a();
        int h10 = cVar.h();
        String d10 = cVar.d();
        String e10 = cVar.e();
        int b10 = cVar.b();
        d f10 = cVar.f();
        boolean v10 = cVar.v();
        boolean q5 = cVar.q();
        if (a10 != null) {
            cm.a d11 = zl.a.d(d10, e10);
            d11.f5988k = cVar.k();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            Locale locale = Locale.US;
            il.b.j(String.format(locale, "device >> primaryIcType=0x%02X", Integer.valueOf(h10)));
            il.b.j(String.format(locale, "fileIndicator=0x%08X, filePath=%s, versionCheckEnabled=%b", Integer.valueOf(b10), d10, Boolean.valueOf(v10)));
            ql.a i10 = pl.b.i(cVar);
            if (i10 != null) {
                d11.f5982e = true;
                d11.f5983f = i10.u();
                d11.f5989l = i10.E(0);
                d11.f5991n = i10.E(1);
                if (!q5 || zl.a.c(d11.f5983f, h10)) {
                    z10 = false;
                    for (int i11 = 0; i11 < 16; i11++) {
                        int n10 = zl.a.n(i11, f10.L, f10.O);
                        d11.f5987j = n10 < 16 ? d11.f5987j | 1 : d11.f5987j | 2;
                        if (!ul.a.c(b10, n10)) {
                            il.b.j("image file disable: bitNumber=" + n10);
                        } else {
                            vl.a v11 = i10.v(n10);
                            wl.a e11 = v11 != null ? v11.e(a10, d11.f5983f) : null;
                            if (e11 != null) {
                                arrayList2.add(e11);
                                if (!v10 || 1 == zl.a.e(n10, e11, f10)) {
                                    arrayList3.add(e11);
                                    arrayList.add(v11);
                                } else {
                                    z10 = true;
                                }
                            }
                        }
                    }
                    try {
                        i10.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                        il.b.e(e12.toString());
                    }
                } else {
                    il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(d11.f5983f)));
                    d11.f5986i = false;
                    d11.f5985h = 4101;
                    return d11;
                }
            } else {
                try {
                    wl.a k10 = zl.a.k(a10, h10, d10, 0L);
                    if (k10 != null) {
                        arrayList2.add(k10);
                        d11.f5983f = k10.I();
                        d11.f5984g = k10.T();
                        if (!q5 || zl.a.c(d11.f5983f, h10)) {
                            if (v10 && 1 != zl.a.f(k10, f10)) {
                                z10 = true;
                            }
                            arrayList3.add(k10);
                        } else {
                            il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(d11.f5983f)));
                            d11.f5986i = false;
                            d11.f5985h = 4101;
                            return d11;
                        }
                    }
                    z10 = false;
                } catch (IOException e13) {
                    e13.printStackTrace();
                    throw new LoadFileException(e13.getMessage(), 4097);
                }
            }
            d11.f5990m = arrayList2;
            d11.f5993p = arrayList3;
            d11.f5992o = arrayList;
            if (v10 && z10 && arrayList3.size() < 1) {
                d11.f5986i = false;
                d11.f5985h = LoadFileException.ERROR_VERSION_CHECK_LOW;
            }
            return d11;
        }
        throw new LoadFileException("invalid context", 4097);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0284, code lost:
        r6 = r13.v();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0295, code lost:
        r8 = r13.v();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static cm.a s(c cVar) {
        ql.a aVar;
        boolean z10;
        int i10;
        Iterator<vl.a> it;
        Context context;
        int i11;
        Context a10 = cVar.a();
        int h10 = cVar.h();
        String d10 = cVar.d();
        String e10 = cVar.e();
        int b10 = cVar.b();
        d f10 = cVar.f();
        boolean q5 = cVar.q();
        boolean v10 = cVar.v();
        int k10 = cVar.k();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        cm.a d11 = zl.a.d(d10, e10);
        d11.f5988k = cVar.k();
        try {
            ql.a i12 = pl.b.i(cVar);
            il.b.j(i12.toString());
            d11.f5982e = true;
            d11.f5983f = i12.u();
            d11.f5989l = i12.E(0);
            d11.f5991n = i12.E(1);
            if (q5 && !zl.a.c(d11.f5983f, h10)) {
                il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(d11.f5983f)));
                d11.f5986i = false;
                d11.f5985h = 4101;
                return d11;
            } else if (i12.n(2048) == null) {
                il.b.l("OtaHeader Miss");
                d11.f5986i = false;
                d11.f5985h = LoadFileException.ERROR_INCOMPLETE_MISS_OTA_HEADER;
                return d11;
            } else if (!i12.q(zl.a.m(2, i12.c()), d11.f5988k)) {
                il.b.l("OtaHeader Miss");
                d11.f5986i = false;
                d11.f5985h = LoadFileException.ERROR_INCOMPLETE_MISS_OTA_HEADER;
                return d11;
            } else {
                Iterator<vl.a> it2 = i12.E(k10).iterator();
                int i13 = 0;
                int i14 = 0;
                while (it2.hasNext()) {
                    vl.a next = it2.next();
                    if (!ul.a.c(b10, next.g())) {
                        il.b.j("prohibit upgrade image_id=" + next.f35837j);
                    } else {
                        ul.a a11 = ul.a.a(ul.a.f35468k, next.g());
                        if (a11 != null) {
                            il.b.k(zl.a.f37626a, a11.toString());
                            wl.a e11 = next.e(a10, d11.f5983f);
                            if (e11 == null) {
                                il.b.k(zl.a.f37626a, "not find image: " + a11.f35472c);
                            } else {
                                if (f10 != null) {
                                    ImageVersionInfo q10 = f10.q(e11.O());
                                    context = a10;
                                    it = it2;
                                    if (q10 == null) {
                                        i10 = b10;
                                        z10 = v10;
                                        aVar = i12;
                                        i11 = 1;
                                        il.b.k(zl.a.f37626a, String.format("not find active image, imageId=0x%04X", Integer.valueOf(e11.O())));
                                        e11.m0(1);
                                    } else if (q10.d() == -1) {
                                        i10 = b10;
                                        il.b.k(zl.a.f37626a, String.format("invalid active version:0x%04X, no need to check", Integer.valueOf(q10.d())));
                                        e11.m0(1);
                                        z10 = v10;
                                        aVar = i12;
                                        i11 = 1;
                                    } else {
                                        i10 = b10;
                                        z10 = v10;
                                        aVar = i12;
                                        int h11 = zl.a.h(d11.f5983f, e11.w(), e11.O(), e11.f36312l, e11.f36308h, f10.f5995a, q10.d(), f10.f6005k, a11.f35475f, cVar.p());
                                        i11 = 1;
                                        il.b.j(String.format(Locale.US, "compare active image, bitNumber=%d, compare=%d ", Integer.valueOf(next.f35830c), Integer.valueOf(h11)));
                                        e11.m0(h11);
                                    }
                                    ImageVersionInfo x10 = f10.x(e11.O());
                                    if (x10 == null) {
                                        int i15 = i11;
                                        boolean z11 = zl.a.f37626a;
                                        Object[] objArr = new Object[i15];
                                        objArr[0] = Integer.valueOf(e11.O());
                                        il.b.k(z11, String.format("not find inactive image, imageId=0x%04X", objArr));
                                        e11.o0(i15);
                                    } else if (x10.d() == -1) {
                                        boolean z12 = zl.a.f37626a;
                                        Object[] objArr2 = new Object[i11];
                                        objArr2[0] = Integer.valueOf(x10.d());
                                        il.b.k(z12, String.format("invalid inactive version:0x%04X, no need to check", objArr2));
                                        e11.o0(i11);
                                    } else {
                                        int h12 = zl.a.h(d11.f5983f, e11.w(), e11.O(), e11.f36312l, e11.f36308h, f10.f5995a, x10.d(), f10.f6005k, a11.f35475f, f10.O());
                                        il.b.j(String.format(Locale.US, "compare inactive image, bitNumber=%d, compare=%d ", Integer.valueOf(next.f35830c), Integer.valueOf(h12)));
                                        e11.o0(h12);
                                    }
                                    if (ol.a.a(next.g())) {
                                        if (i13 > 0) {
                                        }
                                    } else if (i14 > 0) {
                                    }
                                } else {
                                    context = a10;
                                    it = it2;
                                    i10 = b10;
                                    z10 = v10;
                                    aVar = i12;
                                }
                                arrayList2.add(e11);
                                arrayList3.add(e11);
                                arrayList.add(next);
                                a10 = context;
                                it2 = it;
                                b10 = i10;
                                v10 = z10;
                                i12 = aVar;
                            }
                        }
                    }
                }
                boolean z13 = v10;
                try {
                    i12.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                    il.b.e(e12.toString());
                }
                if (z13) {
                    il.b.j(String.format(Locale.US, "nonConfigVersionFlag=%d, configVersionFlag=%d", Integer.valueOf(i13), Integer.valueOf(i14)));
                    if (i13 <= 0) {
                        if (i13 != 0) {
                            il.b.l("all code image version must >= active image version");
                            d11.f5986i = false;
                            d11.f5985h = 4114;
                            return d11;
                        } else if (i14 <= 0) {
                            il.b.c("there must be at least one data image version> active image version");
                            d11.f5986i = false;
                            d11.f5985h = 4113;
                            return d11;
                        }
                    }
                }
                d11.f5990m = arrayList2;
                d11.f5993p = arrayList3;
                d11.f5992o = arrayList;
                return d11;
            }
        } catch (LoadFileException e13) {
            d11.f5986i = false;
            d11.f5985h = e13.getErrCode();
            return d11;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x026c, code lost:
        r5 = r2.v();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x027d, code lost:
        r7 = r2.v();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0342, code lost:
        r12 = r5;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0272  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static cm.a t(c cVar) {
        boolean z10;
        boolean z11;
        ql.a aVar;
        boolean z12;
        int i10;
        Iterator<vl.a> it;
        int i11;
        String str;
        int h10 = cVar.h();
        String d10 = cVar.d();
        String e10 = cVar.e();
        int b10 = cVar.b();
        d f10 = cVar.f();
        boolean q5 = cVar.q();
        boolean v10 = cVar.v();
        int k10 = cVar.k();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        cm.a a10 = zl.a.a(d10, e10);
        a10.f5988k = cVar.k();
        try {
            ql.a n10 = pl.b.n(cVar);
            a10.f5982e = true;
            a10.f5983f = n10.u();
            a10.f5989l = n10.E(0);
            a10.f5991n = n10.E(1);
            if (q5 && !zl.a.c(a10.f5983f, h10)) {
                il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                a10.f5986i = false;
                a10.f5985h = 4101;
                return a10;
            } else if (!n10.q(zl.a.m(2, n10.c()), a10.f5988k)) {
                il.b.l("OtaHeader Miss");
                a10.f5986i = false;
                a10.f5985h = LoadFileException.ERROR_INCOMPLETE_MISS_OTA_HEADER;
                return a10;
            } else {
                Iterator<vl.a> it2 = n10.E(k10).iterator();
                int i12 = 0;
                int i13 = 0;
                while (it2.hasNext()) {
                    vl.a next = it2.next();
                    int g10 = next.g();
                    if (!ul.a.c(b10, g10)) {
                        str = "prohibit upgrade image_id=" + next.f35837j;
                    } else {
                        ul.a a11 = ul.a.a(ul.a.f35468k, g10);
                        if (a11 == null) {
                            str = "undefined image";
                        } else {
                            il.b.k(zl.a.f37626a, a11.toString());
                            wl.a f11 = next.f(a10.f5983f);
                            if (f11 == null) {
                                il.b.k(zl.a.f37626a, "invalid stream: " + next.toString());
                            } else {
                                f11.B = ol.b.a(f11.O());
                                if (f10 != null) {
                                    ImageVersionInfo q10 = f10.q(f11.O());
                                    it = it2;
                                    if (q10 == null) {
                                        i10 = b10;
                                        z12 = v10;
                                        aVar = n10;
                                        i11 = 1;
                                        il.b.k(zl.a.f37626a, String.format("not find active image, imageId=0x%04X", Integer.valueOf(f11.O())));
                                        f11.m0(1);
                                    } else if (q10.d() == -1) {
                                        i10 = b10;
                                        i11 = 1;
                                        il.b.k(zl.a.f37626a, String.format("invalid active version:0x%04X, no need to check", Integer.valueOf(q10.d())));
                                        f11.m0(1);
                                        z12 = v10;
                                        aVar = n10;
                                    } else {
                                        i10 = b10;
                                        z12 = v10;
                                        aVar = n10;
                                        int h11 = zl.a.h(a10.f5983f, f11.w(), f11.O(), f11.f36312l, f11.f36308h, f10.f5995a, q10.d(), f10.f6005k, a11.f35475f, cVar.p());
                                        i11 = 1;
                                        il.b.j(String.format(Locale.US, "compare active image, bitNumber=%d, compare=%d ", Integer.valueOf(next.f35830c), Integer.valueOf(h11)));
                                        f11.m0(h11);
                                    }
                                    ImageVersionInfo x10 = f10.x(f11.O());
                                    if (x10 == null) {
                                        boolean z13 = zl.a.f37626a;
                                        Object[] objArr = new Object[i11];
                                        objArr[0] = Integer.valueOf(f11.O());
                                        il.b.k(z13, String.format("not find inactive image, imageId=0x%04X", objArr));
                                    } else if (x10.d() == -1) {
                                        boolean z14 = zl.a.f37626a;
                                        Object[] objArr2 = new Object[i11];
                                        objArr2[0] = Integer.valueOf(x10.d());
                                        il.b.k(z14, String.format("invalid inactive version:0x%04X, no need to check", objArr2));
                                    } else {
                                        int h12 = zl.a.h(a10.f5983f, f11.w(), f11.O(), f11.f36312l, f11.f36308h, f10.f5995a, x10.d(), f10.f6005k, a11.f35475f, cVar.p());
                                        il.b.j(String.format(Locale.US, "compare inactive image, bitNumber=%d, compare=%d ", Integer.valueOf(next.f35830c), Integer.valueOf(h12)));
                                        f11.o0(h12);
                                        if (!ol.a.a(next.g())) {
                                            if (i12 > 0) {
                                            }
                                        } else if (i13 > 0) {
                                        }
                                    }
                                    f11.o0(i11);
                                    if (!ol.a.a(next.g())) {
                                    }
                                } else {
                                    it = it2;
                                    i10 = b10;
                                    z12 = v10;
                                    aVar = n10;
                                }
                                arrayList2.add(f11);
                                arrayList3.add(f11);
                                arrayList.add(next);
                                it2 = it;
                                b10 = i10;
                                v10 = z12;
                                n10 = aVar;
                            }
                        }
                    }
                    il.b.j(str);
                }
                boolean z15 = v10;
                try {
                    n10.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                    il.b.e(e11.toString());
                }
                if (z15) {
                    if (cVar.l() == 0) {
                        il.b.j(String.format(Locale.US, "nonConfigVersionFlag=%d, configVersionFlag=%d", Integer.valueOf(i12), Integer.valueOf(i13)));
                        if (i12 <= 0) {
                            if (i12 != 0) {
                                il.b.l("all code image version must >= active image version");
                                a10.f5986i = false;
                                a10.f5985h = 4114;
                                return a10;
                            } else if (i13 <= 0) {
                                il.b.c("there must be at least one data image version> active image version");
                                a10.f5986i = false;
                                a10.f5985h = 4113;
                                return a10;
                            }
                        }
                    } else {
                        Collections.sort(arrayList2, new a());
                        Iterator it3 = arrayList2.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                z10 = false;
                                break;
                            }
                            wl.a aVar2 = (wl.a) it3.next();
                            if (aVar2.B != 254) {
                                if (aVar2.v() <= 0) {
                                    if (aVar2.v() != 0) {
                                        z10 = false;
                                        il.b.c(String.format(Locale.US, "low version image: 0x%04X", Integer.valueOf(aVar2.O())));
                                        break;
                                    }
                                } else {
                                    z10 = false;
                                    z11 = true;
                                    break;
                                }
                            }
                        }
                        if (!z11) {
                            a10.f5986i = z10;
                            a10.f5985h = 4114;
                            return a10;
                        }
                    }
                }
                a10.f5990m = arrayList2;
                a10.f5993p = arrayList3;
                a10.f5992o = arrayList;
                return a10;
            }
        } catch (LoadFileException e12) {
            a10.f5986i = false;
            a10.f5985h = e12.getErrCode();
            return a10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0267, code lost:
        r4 = r15.v();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0278, code lost:
        r6 = r15.v();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static cm.a u(c cVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i10;
        Iterator<vl.a> it;
        int i11;
        int h10 = cVar.h();
        String d10 = cVar.d();
        String e10 = cVar.e();
        int b10 = cVar.b();
        boolean q5 = cVar.q();
        boolean v10 = cVar.v();
        int k10 = cVar.k();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        cm.a a10 = zl.a.a(d10, e10);
        a10.f5988k = cVar.k();
        try {
            ql.a n10 = pl.b.n(cVar);
            int i12 = 1;
            a10.f5982e = true;
            a10.f5983f = n10.u();
            a10.f5989l = n10.E(0);
            a10.f5991n = n10.E(1);
            if (q5 && !zl.a.c(a10.f5983f, h10)) {
                il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                a10.f5986i = false;
                a10.f5985h = 4101;
                return a10;
            } else if (!n10.q(zl.a.m(2, n10.c()), a10.f5988k)) {
                il.b.l("OtaHeader Miss");
                a10.f5986i = false;
                a10.f5985h = LoadFileException.ERROR_INCOMPLETE_MISS_OTA_HEADER;
                return a10;
            } else {
                Iterator<vl.a> it2 = n10.E(k10).iterator();
                int i13 = 0;
                int i14 = 0;
                boolean z14 = false;
                while (it2.hasNext()) {
                    vl.a next = it2.next();
                    int g10 = next.g();
                    if (!ul.a.c(b10, g10)) {
                        il.b.j("prohibit upgrade image_id=" + next.f35837j);
                    } else {
                        ul.a a11 = ul.a.a(ul.a.f35468k, g10);
                        int i15 = a11 != null ? a11.f35475f : i12;
                        wl.a f10 = next.f(a10.f5983f);
                        if (f10 == null) {
                            il.b.k(zl.a.f37626a, "invalid stream: " + next.toString());
                        } else {
                            if (next.f35836i == 1024) {
                                z14 = true;
                            }
                            f10.B = ol.b.a(f10.O());
                            d f11 = cVar.f();
                            if (f11 != null) {
                                ImageVersionInfo q10 = f11.q(f10.O());
                                it = it2;
                                i10 = b10;
                                if (q10 == null) {
                                    z12 = v10;
                                    z13 = z14;
                                    i11 = 1;
                                    il.b.k(zl.a.f37626a, String.format("not find active image, imageId=0x%04X", Integer.valueOf(f10.O())));
                                    f10.m0(1);
                                } else if (q10.d() == -1) {
                                    z13 = z14;
                                    i11 = 1;
                                    il.b.k(zl.a.f37626a, String.format("invalid active version:0x%04X, no need to check", Integer.valueOf(q10.d())));
                                    f10.m0(1);
                                    z12 = v10;
                                } else {
                                    z13 = z14;
                                    z12 = v10;
                                    int h11 = zl.a.h(a10.f5983f, f10.w(), f10.O(), f10.f36312l, f10.f36308h, f11.f5995a, q10.d(), f11.f6005k, i15, cVar.p());
                                    i11 = 1;
                                    il.b.j(String.format(Locale.US, "compare active image, bitNumber=%d, compare=%d ", Integer.valueOf(next.f35830c), Integer.valueOf(h11)));
                                    f10.m0(h11);
                                }
                                ImageVersionInfo x10 = f11.x(f10.O());
                                if (x10 == null) {
                                    int i16 = i11;
                                    boolean z15 = zl.a.f37626a;
                                    Object[] objArr = new Object[i16];
                                    objArr[0] = Integer.valueOf(f10.O());
                                    il.b.k(z15, String.format("not find inactive image, imageId=0x%04X", objArr));
                                    f10.o0(i16);
                                } else if (x10.d() == -1) {
                                    boolean z16 = zl.a.f37626a;
                                    Object[] objArr2 = new Object[i11];
                                    objArr2[0] = Integer.valueOf(x10.d());
                                    il.b.k(z16, String.format("invalid inactive version:0x%04X, no need to check", objArr2));
                                    f10.o0(i11);
                                } else {
                                    int h12 = zl.a.h(a10.f5983f, f10.w(), f10.O(), f10.f36312l, f10.f36308h, f11.f5995a, x10.d(), f11.f6005k, i15, cVar.p());
                                    il.b.j(String.format(Locale.US, "compare inactive image, bitNumber=%d, compare=%d ", Integer.valueOf(next.f35830c), Integer.valueOf(h12)));
                                    f10.o0(h12);
                                }
                                if (ol.a.a(next.g())) {
                                    if (i13 > 0) {
                                    }
                                } else if (i14 > 0) {
                                }
                            } else {
                                it = it2;
                                i10 = b10;
                                z12 = v10;
                                z13 = z14;
                            }
                            arrayList2.add(f10);
                            arrayList3.add(f10);
                            arrayList.add(next);
                            it2 = it;
                            b10 = i10;
                            z14 = z13;
                            v10 = z12;
                            i12 = 1;
                        }
                    }
                }
                boolean z17 = v10;
                try {
                    n10.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                    il.b.e(e11.toString());
                }
                if (z17) {
                    if (cVar.l() == 0) {
                        il.b.j(String.format(Locale.US, "nonConfigVersionFlag=%d, configVersionFlag=%d", Integer.valueOf(i13), Integer.valueOf(i14)));
                        if (i13 <= 0) {
                            if (i13 != 0) {
                                il.b.l("all code image version must >= active image version");
                                a10.f5986i = false;
                                a10.f5985h = 4114;
                                return a10;
                            } else if (i14 < 0) {
                                il.b.c("there must be at least one data image version >= active image version");
                                a10.f5986i = false;
                                a10.f5985h = 4113;
                                return a10;
                            } else if (i14 == 0 && !z14) {
                                il.b.c("there must be at least one data image version> active image version");
                                a10.f5986i = false;
                                a10.f5985h = 4113;
                                return a10;
                            }
                        }
                    } else {
                        Collections.sort(arrayList2, new b());
                        Iterator it3 = arrayList2.iterator();
                        while (true) {
                            if (!it3.hasNext()) {
                                z10 = false;
                                break;
                            }
                            wl.a aVar = (wl.a) it3.next();
                            if (aVar.B != 254) {
                                if (aVar.v() <= 0) {
                                    if (aVar.v() != 0) {
                                        z10 = false;
                                        il.b.c(String.format(Locale.US, "low version image: 0x%04X", Integer.valueOf(aVar.O())));
                                        break;
                                    }
                                } else {
                                    z10 = false;
                                    z11 = true;
                                    break;
                                }
                            }
                        }
                        z11 = z10;
                        if (!z11) {
                            a10.f5986i = z10;
                            a10.f5985h = 4114;
                            return a10;
                        }
                    }
                }
                a10.f5990m = arrayList2;
                a10.f5993p = arrayList3;
                a10.f5992o = arrayList;
                return a10;
            }
        } catch (LoadFileException e12) {
            a10.f5986i = false;
            a10.f5985h = e12.getErrCode();
            return a10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0284, code lost:
        r4 = r2.v();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0295, code lost:
        r6 = r2.v();
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x028a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static cm.a v(c cVar) {
        ql.a aVar;
        boolean z10;
        SparseIntArray sparseIntArray;
        int i10;
        Iterator<vl.a> it;
        int i11;
        int h10 = cVar.h();
        String d10 = cVar.d();
        String e10 = cVar.e();
        int b10 = cVar.b();
        boolean q5 = cVar.q();
        boolean v10 = cVar.v();
        int k10 = cVar.k();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        cm.a a10 = zl.a.a(d10, e10);
        a10.f5988k = cVar.k();
        try {
            ql.a n10 = pl.b.n(cVar);
            a10.f5982e = true;
            a10.f5983f = n10.u();
            a10.f5989l = n10.E(0);
            a10.f5991n = n10.E(1);
            if (q5 && !zl.a.c(a10.f5983f, h10)) {
                il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                a10.f5986i = false;
                a10.f5985h = 4101;
                return a10;
            } else if (!n10.q(zl.a.m(2, n10.c()), a10.f5988k)) {
                il.b.l("OtaHeader Miss");
                a10.f5986i = false;
                a10.f5985h = LoadFileException.ERROR_INCOMPLETE_MISS_OTA_HEADER;
                return a10;
            } else {
                Iterator<vl.a> it2 = n10.E(k10).iterator();
                int i12 = 0;
                int i13 = 0;
                while (it2.hasNext()) {
                    vl.a next = it2.next();
                    if (!ul.a.c(b10, next.g())) {
                        il.b.j("prohibit upgrade image_id=" + next.f35837j);
                    } else {
                        ul.a a11 = ul.a.a(ul.a.f35468k, next.g());
                        if (a11 != null) {
                            il.b.k(zl.a.f37626a, a11.toString());
                            wl.a f10 = next.f(a10.f5983f);
                            if (f10 == null) {
                                il.b.k(zl.a.f37626a, "not find image: " + a11.f35472c);
                                if (cVar.o() && ol.a.b(next.g())) {
                                    sparseIntArray2.append(a11.f35472c, next.g());
                                }
                            } else {
                                d f11 = cVar.f();
                                if (f11 != null) {
                                    ImageVersionInfo q10 = f11.q(f10.O());
                                    it = it2;
                                    i10 = b10;
                                    if (q10 == null) {
                                        z10 = v10;
                                        sparseIntArray = sparseIntArray2;
                                        aVar = n10;
                                        i11 = 1;
                                        il.b.k(zl.a.f37626a, String.format("not find active image, imageId=0x%04X", Integer.valueOf(f10.O())));
                                        f10.m0(1);
                                    } else if (q10.d() == -1) {
                                        sparseIntArray = sparseIntArray2;
                                        il.b.k(zl.a.f37626a, String.format("invalid active version:0x%04X, no need to check", Integer.valueOf(q10.d())));
                                        f10.m0(1);
                                        z10 = v10;
                                        aVar = n10;
                                        i11 = 1;
                                    } else {
                                        sparseIntArray = sparseIntArray2;
                                        z10 = v10;
                                        aVar = n10;
                                        int h11 = zl.a.h(a10.f5983f, f10.w(), f10.O(), f10.f36312l, f10.f36308h, f11.f5995a, q10.d(), f11.f6005k, a11.f35475f, cVar.p());
                                        i11 = 1;
                                        il.b.j(String.format(Locale.US, "compare active image, bitNumber=%d, compare=%d ", Integer.valueOf(next.f35830c), Integer.valueOf(h11)));
                                        f10.m0(h11);
                                    }
                                    ImageVersionInfo x10 = f11.x(f10.O());
                                    if (x10 == null) {
                                        boolean z11 = zl.a.f37626a;
                                        Object[] objArr = new Object[i11];
                                        objArr[0] = Integer.valueOf(f10.O());
                                        il.b.k(z11, String.format("not find inactive image, imageId=0x%04X", objArr));
                                    } else if (x10.d() == -1) {
                                        boolean z12 = zl.a.f37626a;
                                        Object[] objArr2 = new Object[i11];
                                        objArr2[0] = Integer.valueOf(x10.d());
                                        il.b.k(z12, String.format("invalid inactive version:0x%04X, no need to check", objArr2));
                                    } else {
                                        int h12 = zl.a.h(a10.f5983f, f10.w(), f10.O(), f10.f36312l, f10.f36308h, f11.f5995a, x10.d(), f11.f6005k, a11.f35475f, cVar.p());
                                        il.b.j(String.format(Locale.US, "compare inactive image, bitNumber=%d, compare=%d ", Integer.valueOf(next.f35830c), Integer.valueOf(h12)));
                                        f10.o0(h12);
                                        if (!ol.a.a(next.g())) {
                                            if (i12 > 0) {
                                            }
                                        } else if (i13 > 0) {
                                        }
                                    }
                                    f10.o0(i11);
                                    if (!ol.a.a(next.g())) {
                                    }
                                } else {
                                    it = it2;
                                    i10 = b10;
                                    z10 = v10;
                                    sparseIntArray = sparseIntArray2;
                                    aVar = n10;
                                }
                                arrayList2.add(f10);
                                arrayList3.add(f10);
                                arrayList.add(next);
                                it2 = it;
                                b10 = i10;
                                sparseIntArray2 = sparseIntArray;
                                v10 = z10;
                                n10 = aVar;
                            }
                        }
                    }
                }
                boolean z13 = v10;
                SparseIntArray sparseIntArray3 = sparseIntArray2;
                try {
                    n10.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                    il.b.e(e11.toString());
                }
                if (z13) {
                    il.b.j(String.format(Locale.US, "nonConfigVersionFlag=%d, configVersionFlag=%d", Integer.valueOf(i12), Integer.valueOf(i13)));
                    if (i12 <= 0) {
                        if (i12 != 0) {
                            il.b.l("all code image version must >= active image version");
                            a10.f5986i = false;
                            a10.f5985h = 4114;
                            return a10;
                        } else if (i13 <= 0) {
                            il.b.c("there must be at least one data image version> active image version");
                            a10.f5986i = false;
                            a10.f5985h = 4113;
                            return a10;
                        }
                    }
                }
                a10.f5994q = sparseIntArray3;
                a10.f5990m = arrayList2;
                a10.f5993p = arrayList3;
                a10.f5992o = arrayList;
                return a10;
            }
        } catch (LoadFileException e12) {
            a10.f5986i = false;
            a10.f5985h = e12.getErrCode();
            return a10;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x02ae, code lost:
        r1 = r14.v();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x02bf, code lost:
        r6 = r14.v();
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static cm.a w(c cVar) {
        ql.a aVar;
        boolean z10;
        int i10;
        Iterator<vl.a> it;
        String str;
        int i11;
        int h10 = cVar.h();
        String d10 = cVar.d();
        String e10 = cVar.e();
        int b10 = cVar.b();
        d f10 = cVar.f();
        boolean v10 = cVar.v();
        boolean q5 = cVar.q();
        int k10 = cVar.k();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        cm.a a10 = zl.a.a(d10, e10);
        a10.f5988k = cVar.k();
        try {
            ql.a n10 = pl.b.n(cVar);
            if (n10 == null) {
                try {
                    wl.a l10 = zl.a.l(h10, d10, 0L);
                    if (l10 != null) {
                        arrayList2.add(l10);
                        a10.f5983f = l10.I();
                        a10.f5984g = l10.T();
                        if (q5 && !zl.a.c(a10.f5983f, h10)) {
                            il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                            a10.f5986i = false;
                            a10.f5985h = 4101;
                            return a10;
                        } else if (!v10 || 1 == zl.a.f(l10, f10)) {
                            arrayList3.add(l10);
                        }
                    }
                } catch (IOException e11) {
                    il.b.j(e11.toString());
                }
            } else {
                il.b.j(n10.toString());
                a10.f5982e = true;
                a10.f5983f = n10.u();
                a10.f5989l = n10.E(0);
                a10.f5991n = n10.E(1);
                if (!q5 || zl.a.c(a10.f5983f, h10)) {
                    Iterator<vl.a> it2 = n10.E(k10).iterator();
                    int i12 = 0;
                    int i13 = 0;
                    while (it2.hasNext()) {
                        vl.a next = it2.next();
                        if (!ul.a.c(b10, next.g())) {
                            il.b.j("prohibit upgrade image_id=" + next.f35837j);
                        } else {
                            ul.a a11 = ul.a.a(ul.a.f35468k, next.g());
                            if (a11 != null) {
                                il.b.k(zl.a.f37626a, a11.toString());
                                wl.a f11 = next.f(a10.f5983f);
                                if (f11 == null) {
                                    il.b.k(zl.a.f37626a, "not find image: " + a11.f35472c);
                                } else {
                                    if (f10 != null) {
                                        ImageVersionInfo q10 = f10.q(f11.O());
                                        it = it2;
                                        if (q10 == null) {
                                            i10 = b10;
                                            z10 = v10;
                                            aVar = n10;
                                            i11 = 1;
                                            il.b.k(zl.a.f37626a, String.format("not find active image, imageId=0x%04X", Integer.valueOf(f11.O())));
                                            f11.m0(1);
                                        } else if (q10.d() == -1) {
                                            i10 = b10;
                                            il.b.k(zl.a.f37626a, String.format("invalid active version:0x%04X, no need to check", Integer.valueOf(q10.d())));
                                            f11.m0(1);
                                            z10 = v10;
                                            aVar = n10;
                                            i11 = 1;
                                        } else {
                                            i10 = b10;
                                            z10 = v10;
                                            aVar = n10;
                                            int h11 = zl.a.h(a10.f5983f, f11.w(), f11.O(), f11.f36312l, f11.f36308h, f10.f5995a, q10.d(), f10.f6005k, a11.f35475f, cVar.p());
                                            i11 = 1;
                                            il.b.j(String.format(Locale.US, "compare active image, bitNumber=%d, compare=%d ", Integer.valueOf(next.f35830c), Integer.valueOf(h11)));
                                            f11.m0(h11);
                                        }
                                        ImageVersionInfo x10 = f10.x(f11.O());
                                        if (x10 == null) {
                                            boolean z11 = zl.a.f37626a;
                                            Object[] objArr = new Object[i11];
                                            objArr[0] = Integer.valueOf(f11.O());
                                            il.b.k(z11, String.format("not find inactive image, imageId=0x%04X", objArr));
                                        } else if (x10.d() == -1) {
                                            boolean z12 = zl.a.f37626a;
                                            Object[] objArr2 = new Object[i11];
                                            objArr2[0] = Integer.valueOf(x10.d());
                                            il.b.k(z12, String.format("invalid inactive version:0x%04X, no need to check", objArr2));
                                        } else {
                                            int h12 = zl.a.h(a10.f5983f, f11.w(), f11.O(), f11.f36312l, f11.f36308h, f10.f5995a, x10.d(), f10.f6005k, a11.f35475f, cVar.p());
                                            il.b.j(String.format(Locale.US, "compare inactive image, bitNumber=%d, compare=%d ", Integer.valueOf(next.f35830c), Integer.valueOf(h12)));
                                            f11.o0(h12);
                                            if (!ol.a.a(next.g())) {
                                                if (i12 > 0) {
                                                }
                                            } else if (i13 > 0) {
                                            }
                                        }
                                        f11.o0(i11);
                                        if (!ol.a.a(next.g())) {
                                        }
                                    } else {
                                        it = it2;
                                        i10 = b10;
                                        z10 = v10;
                                        aVar = n10;
                                    }
                                    arrayList2.add(f11);
                                    if (next.g() == 2) {
                                        str = "ignore OTA_HEADER_FILE";
                                    } else if (next.g() == 1) {
                                        str = "ignore SYSTEM_CONFIG_FILE";
                                    } else {
                                        arrayList3.add(f11);
                                        arrayList.add(next);
                                        it2 = it;
                                        b10 = i10;
                                        v10 = z10;
                                        n10 = aVar;
                                    }
                                    il.b.j(str);
                                    it2 = it;
                                    b10 = i10;
                                    v10 = z10;
                                    n10 = aVar;
                                }
                            }
                        }
                    }
                    boolean z13 = v10;
                    try {
                        n10.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                        il.b.e(e12.toString());
                    }
                    if (z13) {
                        il.b.j(String.format(Locale.US, "nonConfigVersionFlag=%d, configVersionFlag=%d", Integer.valueOf(i12), Integer.valueOf(i13)));
                        if (i12 <= 0) {
                            if (i12 != 0) {
                                il.b.l("all code image version must >= active image version");
                                a10.f5986i = false;
                                a10.f5985h = 4114;
                                return a10;
                            } else if (i13 <= 0) {
                                il.b.c("there must be at least one data image version> active image version");
                                a10.f5986i = false;
                                a10.f5985h = 4113;
                                return a10;
                            }
                        }
                    }
                } else {
                    il.b.c(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
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

    public static cm.a x(c cVar) {
        ArrayList arrayList;
        boolean z10;
        int i10;
        int i11;
        int h10 = cVar.h();
        String d10 = cVar.d();
        String e10 = cVar.e();
        int b10 = cVar.b();
        d f10 = cVar.f();
        boolean v10 = cVar.v();
        boolean q5 = cVar.q();
        boolean s10 = cVar.s();
        int k10 = cVar.k();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        cm.a a10 = zl.a.a(d10, e10);
        a10.f5988k = cVar.k();
        try {
            ql.a n10 = pl.b.n(cVar);
            if (n10 != null) {
                a10.f5982e = true;
                a10.f5983f = n10.u();
                a10.f5989l = n10.E(0);
                a10.f5991n = n10.E(1);
                if (!q5 || zl.a.c(a10.f5983f, h10)) {
                    vl.a v11 = n10.v(zl.a.m(2, n10.c()));
                    if (v11 != null) {
                        wl.a f11 = v11.f(a10.f5983f);
                        if (s10 && f11 != null) {
                            if (1 != o(2, f11, f10)) {
                                il.b.l("ota header section size check failed: ");
                                a10.f5986i = false;
                                a10.f5985h = LoadFileException.ERROR_SECTION_SIZE_CHECK_FAILED;
                                return a10;
                            }
                            il.b.c("preVerify OTA_HEADER_FILE ok, no need to check section size");
                            s10 = false;
                        }
                    }
                    z10 = false;
                    for (vl.a aVar : n10.E(k10)) {
                        int g10 = aVar.g();
                        if (!ul.a.c(b10, g10)) {
                            il.b.j("prohibit upgrade image_id=" + aVar.f35837j);
                        } else {
                            ul.a a11 = ul.a.a(ul.a.f35468k, g10);
                            if (a11 != null) {
                                il.b.k(zl.a.f37627b, a11.toString());
                                wl.a f12 = aVar.f(a10.f5983f);
                                if (f12 == null) {
                                    il.b.k(zl.a.f37626a, "not find image: " + aVar.f35837j);
                                } else {
                                    if (v10) {
                                        i11 = 1;
                                        if (1 != q(f12, f10, a11.f35475f)) {
                                            z10 = true;
                                        }
                                    } else {
                                        i11 = 1;
                                    }
                                    if (!s10 || i11 == o(g10, f12, f10)) {
                                        arrayList3.add(f12);
                                        arrayList4.add(f12);
                                        arrayList2.add(aVar);
                                    }
                                }
                            }
                        }
                    }
                    try {
                        n10.close();
                    } catch (IOException e11) {
                        e11.printStackTrace();
                        il.b.e(e11.toString());
                    }
                    arrayList = arrayList2;
                } else {
                    il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                    a10.f5986i = false;
                    a10.f5985h = 4101;
                    return a10;
                }
            } else {
                a10.f5983f = h10;
                byte[] bArr = null;
                arrayList = arrayList2;
                try {
                    wl.a l10 = zl.a.l(h10, d10, 0L);
                    if (l10 != null) {
                        l10.h0();
                        bArr = l10.W();
                        try {
                            l10.close();
                        } catch (Exception e12) {
                            il.b.l(e12.toString());
                        }
                    }
                    wl.a l11 = zl.a.l(h10, d10, 0L);
                    if (l11 != null) {
                        l11.r0(bArr);
                        arrayList3.add(l11);
                        a10.f5983f = l11.I();
                        a10.f5984g = l11.T();
                        if (!q5 || zl.a.c(a10.f5983f, h10)) {
                            if (v10) {
                                i10 = 1;
                                if (1 != zl.a.f(l11, f10)) {
                                    z10 = true;
                                }
                            } else {
                                i10 = 1;
                            }
                            if (s10 && i10 != p(l11, f10)) {
                                a10.f5986i = false;
                                a10.f5985h = LoadFileException.ERROR_SECTION_SIZE_CHECK_FAILED;
                                return a10;
                            }
                            arrayList4.add(l11);
                        } else {
                            il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                            a10.f5986i = false;
                            a10.f5985h = 4101;
                            return a10;
                        }
                    }
                    z10 = false;
                } catch (IOException e13) {
                    e13.printStackTrace();
                    throw new LoadFileException(e13.getMessage(), 4097);
                }
            }
            a10.f5990m = arrayList3;
            a10.f5993p = arrayList4;
            a10.f5992o = arrayList;
            if (v10 && z10 && arrayList4.size() < 1) {
                a10.f5986i = false;
                a10.f5985h = LoadFileException.ERROR_VERSION_CHECK_LOW;
            }
            return a10;
        } catch (LoadFileException e14) {
            a10.f5986i = false;
            a10.f5985h = e14.getErrCode();
            return a10;
        }
    }
}
