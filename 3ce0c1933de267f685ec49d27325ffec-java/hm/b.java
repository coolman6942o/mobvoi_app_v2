package hm;

import android.content.Context;
import android.text.TextUtils;
import cm.d;
import com.realsil.sdk.dfu.exception.LoadFileException;
import com.realsil.sdk.dfu.model.ImageVersionInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import ul.c;
import zl.a;
/* loaded from: classes2.dex */
public class b extends a {
    public static int o(int i10, wl.a aVar, d dVar) {
        if (dVar == null) {
            return 1;
        }
        int Q = aVar.Q();
        int i11 = dVar.f6004j;
        if (i11 == 4 || i11 == 6 || i11 == 7 || i11 == 8) {
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
                            il.b.j("section size validate ok: " + Q);
                        } else {
                            il.b.l(String.format(Locale.US, "image size is %d exceed the limit of the section size %d", Integer.valueOf(Q), Integer.valueOf(next.c())));
                            return 2;
                        }
                    }
                }
            }
        } else {
            boolean z10 = a.f37626a;
            il.b.k(z10, "not support section size check for ic:" + dVar.f6004j);
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
        int i10 = dVar.f6004j;
        if (i10 == 4 || i10 == 6 || i10 == 7 || i10 == 8) {
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
                                il.b.j("section size validate ok: " + Q);
                            } else {
                                il.b.l(String.format(Locale.US, "image size is %d exceed the limit of the section size %d", Integer.valueOf(Q), Integer.valueOf(next2.c())));
                                return 2;
                            }
                        }
                    }
                }
            }
        } else {
            boolean z10 = a.f37626a;
            il.b.k(z10, "not support section size check for ic:" + dVar.f6004j);
        }
        return 1;
    }

    public static cm.a q(c cVar) {
        boolean z10;
        Context a10 = cVar.a();
        if (a10 != null) {
            String d10 = cVar.d();
            if (!TextUtils.isEmpty(d10)) {
                String e10 = cVar.e();
                String b10 = jl.b.b(d10);
                if (b10 == null || !b10.equalsIgnoreCase(e10)) {
                    il.b.l("the file suffix is not right, suffix=" + b10);
                    throw new LoadFileException("invalid suffix", 4099);
                }
                int b11 = cVar.b();
                d f10 = cVar.f();
                boolean v10 = cVar.v();
                boolean q5 = cVar.q();
                int h10 = cVar.h();
                cm.a aVar = new cm.a();
                aVar.f5978a = d10;
                aVar.f5979b = lm.d.c(d10);
                aVar.f5983f = h10;
                aVar.f5988k = cVar.k();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                il.b.j(String.format(Locale.US, "fileIndicator=0x%08X, filePath=%s, versionCheckEnabled=%b", Integer.valueOf(b11), d10, Boolean.valueOf(v10)));
                ql.a i10 = pl.b.i(cVar);
                if (i10 != null) {
                    aVar.f5982e = true;
                    aVar.f5983f = i10.u();
                    aVar.f5989l = i10.E(0);
                    aVar.f5991n = i10.E(1);
                    if (!q5 || a.c(aVar.f5983f, h10)) {
                        z10 = false;
                        for (int i11 = 0; i11 < 16; i11++) {
                            int n10 = a.n(i11, f10.L, f10.O);
                            aVar.f5987j = n10 < 16 ? aVar.f5987j | 1 : aVar.f5987j | 2;
                            if (!ul.a.c(b11, n10)) {
                                il.b.j("image file disable: bitNumber=" + n10);
                            } else {
                                vl.a v11 = i10.v(n10);
                                wl.a e11 = v11 != null ? v11.e(a10, aVar.f5983f) : null;
                                if (e11 != null) {
                                    arrayList2.add(e11);
                                    if (!v10 || 1 == a.e(n10, e11, f10)) {
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
                        il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(aVar.f5983f)));
                        aVar.f5986i = false;
                        aVar.f5985h = 4101;
                        return aVar;
                    }
                } else {
                    try {
                        wl.a k10 = a.k(a10, aVar.f5983f, d10, 0L);
                        if (k10 != null) {
                            arrayList2.add(k10);
                            aVar.f5983f = k10.I();
                            aVar.f5984g = k10.T();
                            if (!q5 || a.c(aVar.f5983f, h10)) {
                                if (v10 && 1 != a.f(k10, f10)) {
                                    z10 = true;
                                }
                                arrayList3.add(k10);
                            } else {
                                il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(aVar.f5983f)));
                                aVar.f5986i = false;
                                aVar.f5985h = 4101;
                                return aVar;
                            }
                        }
                        z10 = false;
                    } catch (IOException e13) {
                        e13.printStackTrace();
                        throw new LoadFileException(e13.getMessage(), 4097);
                    }
                }
                aVar.f5990m = arrayList2;
                aVar.f5993p = arrayList3;
                aVar.f5992o = arrayList;
                if (v10 && z10 && arrayList3.size() < 1) {
                    aVar.f5986i = false;
                    aVar.f5985h = LoadFileException.ERROR_VERSION_CHECK_LOW;
                }
                return aVar;
            }
            throw new LoadFileException("invalid path", 4098);
        }
        throw new LoadFileException("invalid context", 4097);
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x01f0, code lost:
        if (r3 == p(r1, r4)) goto L90;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static cm.a r(c cVar) {
        ArrayList arrayList;
        boolean z10;
        int i10;
        boolean z11;
        boolean z12;
        boolean z13;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
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
        cm.a a10 = a.a(d10, e10);
        Locale locale = Locale.US;
        il.b.j(String.format(locale, "fileIndicator=0x%08X, filePath=%s, versionCheckEnabled=%b, sectionSizeCheckEnabled=%b", Integer.valueOf(b10), d10, Boolean.valueOf(v11), Boolean.valueOf(s10)));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int i16 = f10 != null ? f10.f6005k : 1;
        a10.f5983f = h10;
        a10.f5988k = cVar.k();
        il.b.j(String.format(locale, "device >> specVersion=%d, icType=0x%02X", Integer.valueOf(i16), Integer.valueOf(h10)));
        ql.a n10 = pl.b.n(cVar);
        if (n10 != null) {
            a10.f5982e = true;
            a10.f5983f = n10.u();
            a10.f5989l = n10.E(0);
            a10.f5991n = n10.E(1);
            a10.f5987j = 0;
            if (!q5 || a.c(a10.f5983f, h10)) {
                if (!s10 || (!((i15 = a10.f5983f) == 4 || i15 == 6 || i15 == 7 || i15 == 8 || i15 == 10) || (v10 = n10.v(2)) == null)) {
                    z11 = false;
                    z12 = true;
                } else {
                    wl.a f11 = v10.f(a10.f5983f);
                    z12 = f11 == null || 1 == o(2, f11, f10);
                    z11 = true;
                }
                if (z12) {
                    boolean z14 = false;
                    int i17 = 0;
                    while (i17 < 16) {
                        int n11 = a.n(i17, f10.L, f10.O);
                        if (n11 < 16) {
                            i12 = a10.f5987j;
                            i11 = 1;
                        } else {
                            i12 = a10.f5987j;
                            i11 = 2;
                        }
                        a10.f5987j = i12 | i11;
                        if (!ul.a.c(b10, n11)) {
                            il.b.j("image file disable: bitNumber=" + n11);
                        } else {
                            vl.a v12 = n10.v(n11);
                            wl.a f12 = v12 != null ? v12.f(a10.f5983f) : null;
                            if (f12 != null) {
                                arrayList3.add(f12);
                                if (v11) {
                                    i13 = b10;
                                    i14 = 1;
                                    if (1 != a.e(n11, f12, f10)) {
                                        z14 = true;
                                        i17++;
                                        b10 = i13;
                                    }
                                } else {
                                    i13 = b10;
                                    i14 = 1;
                                }
                                if (s10) {
                                    if (z11) {
                                        il.b.c("preVerify OTA_HEADER_FILE ok, need to check section size");
                                    } else if (i14 != o(n11, f12, f10)) {
                                        a10.f5986i = false;
                                        a10.f5985h = LoadFileException.ERROR_SECTION_SIZE_CHECK_FAILED;
                                        return a10;
                                    }
                                }
                                arrayList4.add(f12);
                                arrayList2.add(v12);
                                i17++;
                                b10 = i13;
                            }
                        }
                        i13 = b10;
                        i17++;
                        b10 = i13;
                    }
                    z13 = z14;
                } else {
                    il.b.l("pre verify failed");
                    z13 = false;
                }
                try {
                    n10.close();
                } catch (IOException e11) {
                    e11.printStackTrace();
                    il.b.e(e11.toString());
                }
                z10 = z13;
                arrayList = arrayList2;
            } else {
                il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                a10.f5986i = false;
                a10.f5985h = 4101;
                return a10;
            }
        } else {
            try {
                arrayList = arrayList2;
                wl.a l10 = a.l(a10.f5983f, d10, 0L);
                if (l10 != null) {
                    arrayList3.add(l10);
                    a10.f5983f = l10.I();
                    a10.f5984g = l10.T();
                    if (!q5 || a.c(a10.f5983f, h10)) {
                        if (v11) {
                            i10 = 1;
                            if (1 != a.f(l10, f10)) {
                                z10 = true;
                            }
                        } else {
                            i10 = 1;
                        }
                        if (s10) {
                        }
                        arrayList4.add(l10);
                    } else {
                        il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                        a10.f5986i = false;
                        a10.f5985h = 4101;
                        return a10;
                    }
                }
                z10 = false;
            } catch (IOException e12) {
                e12.printStackTrace();
                throw new LoadFileException(e12.getMessage(), 4097);
            }
        }
        a10.f5990m = arrayList3;
        a10.f5993p = arrayList4;
        a10.f5992o = arrayList;
        if (v11 && z10 && arrayList4.size() < 1) {
            a10.f5986i = false;
            a10.f5985h = LoadFileException.ERROR_VERSION_CHECK_LOW;
        }
        return a10;
    }
}
