package km;

import android.content.Context;
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
public class e extends a {
    public static int o(int i10, wl.a aVar, d dVar) {
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
                                b.j("version validate ok: " + Q);
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

    public static cm.a q(c cVar) {
        boolean z10;
        int i10;
        int i11;
        Context a10 = cVar.a();
        int h10 = cVar.h();
        String d10 = cVar.d();
        String e10 = cVar.e();
        int b10 = cVar.b();
        d f10 = cVar.f();
        boolean v10 = cVar.v();
        boolean q5 = cVar.q();
        cm.a d11 = a.d(d10, e10);
        d11.f5988k = cVar.k();
        if (a10 != null) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i12 = f10 != null ? f10.f6005k : 1;
            Locale locale = Locale.US;
            b.j(String.format(locale, "device >> otaVersion=%d, primaryIcType=0x%02X", Integer.valueOf(i12), Integer.valueOf(h10)));
            b.j(String.format(locale, "fileIndicator=0x%08X, filePath=%s, versionCheckEnabled=%b", Integer.valueOf(b10), d10, Boolean.valueOf(v10)));
            ql.a i13 = pl.b.i(cVar);
            if (i13 == null) {
                try {
                    wl.a k10 = a.k(a10, h10, d10, 0L);
                    if (k10 != null) {
                        arrayList2.add(k10);
                        d11.f5983f = k10.I();
                        d11.f5984g = k10.T();
                        if (!q5 || a.c(d11.f5983f, h10)) {
                            if (v10 && 1 != a.f(k10, f10)) {
                                z10 = true;
                            }
                            arrayList3.add(k10);
                        } else {
                            b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(d11.f5983f)));
                            d11.f5986i = false;
                            d11.f5985h = 4101;
                            return d11;
                        }
                    }
                    z10 = false;
                } catch (IOException e11) {
                    e11.printStackTrace();
                    throw new LoadFileException(e11.getMessage(), 4097);
                }
            } else if (i12 > 1) {
                d11.f5982e = true;
                d11.f5983f = i13.u();
                d11.f5989l = i13.E(0);
                d11.f5991n = i13.E(1);
                if (!q5 || a.c(d11.f5983f, h10)) {
                    boolean z11 = false;
                    for (int i14 = 0; i14 < 16; i14++) {
                        int n10 = a.n(i14, f10.L, f10.O);
                        if (n10 < 16) {
                            i11 = d11.f5987j;
                            i10 = 1;
                        } else {
                            i11 = d11.f5987j;
                            i10 = 2;
                        }
                        d11.f5987j = i11 | i10;
                        if (!ul.a.c(b10, n10)) {
                            b.j("image file disable: bitNumber=" + n10);
                        } else {
                            vl.a v11 = i13.v(n10);
                            wl.a e12 = v11 != null ? v11.e(a10, d11.f5983f) : null;
                            if (e12 != null) {
                                arrayList2.add(e12);
                                if (!v10 || 1 == a.e(n10, e12, f10)) {
                                    arrayList3.add(e12);
                                    arrayList.add(v11);
                                } else {
                                    z11 = true;
                                }
                            }
                        }
                    }
                    try {
                        i13.close();
                    } catch (IOException e13) {
                        b.e(e13.toString());
                    }
                    z10 = z11;
                } else {
                    b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(d11.f5983f)));
                    d11.f5986i = false;
                    d11.f5985h = 4101;
                    return d11;
                }
            } else {
                throw new LoadFileException("not support pack file", 4107);
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

    /* JADX WARN: Code restructure failed: missing block: B:78:0x01b3, code lost:
        if (1 == p(r0, r4)) goto L79;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static cm.a r(c cVar) {
        boolean z10;
        byte[] bArr;
        boolean z11;
        boolean z12;
        boolean z13;
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
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        cm.a a10 = a.a(d10, e10);
        a10.f5988k = cVar.k();
        ql.a n10 = pl.b.n(cVar);
        if (n10 != null) {
            b.k(a.f37626a, n10.toString());
            a10.f5982e = true;
            a10.f5983f = n10.u();
            a10.f5989l = n10.E(0);
            a10.f5991n = n10.E(1);
            if (!q5 || a.c(a10.f5983f, h10)) {
                if (!s10 || (v10 = n10.v(a.n(2, f10.L, f10.O))) == null) {
                    z12 = true;
                    z11 = false;
                } else {
                    wl.a f11 = v10.f(a10.f5983f);
                    if (f11 == null || 1 == o(2, f11, f10)) {
                        z12 = true;
                        z11 = true;
                    } else {
                        z11 = true;
                        z12 = false;
                    }
                }
                if (z12) {
                    z13 = false;
                    for (int i10 = 0; i10 < 16; i10++) {
                        int n11 = a.n(i10, f10.L, f10.O);
                        a10.f5987j = n11 < 16 ? a10.f5987j | 1 : a10.f5987j | 2;
                        vl.a v12 = n10.v(n11);
                        wl.a f12 = v12 != null ? v12.f(a10.f5983f) : null;
                        if (f12 != null) {
                            arrayList2.add(f12);
                            if (!ul.a.c(b10, n11)) {
                                b.j("image file disable: bitNumber=" + n11);
                            } else if (!v11 || 1 == a.e(i10, f12, f10)) {
                                if (s10) {
                                    if (z11) {
                                        b.c("preVerify OTA_HEADER_FILE ok, no need to check section size");
                                    } else if (1 != o(i10, f12, f10)) {
                                        a10.f5986i = false;
                                        a10.f5985h = LoadFileException.ERROR_SECTION_SIZE_CHECK_FAILED;
                                        return a10;
                                    }
                                }
                                arrayList3.add(f12);
                                arrayList.add(v12);
                            } else {
                                z13 = true;
                            }
                        }
                    }
                } else {
                    b.l("pre verify failed");
                    z13 = false;
                }
                try {
                    n10.close();
                } catch (IOException e11) {
                    b.e(e11.toString());
                }
                z10 = z13;
            } else {
                b.c(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                a10.f5986i = false;
                a10.f5985h = 4101;
                return a10;
            }
        } else {
            try {
                wl.a l10 = a.l(h10, d10, 0L);
                if (l10 != null) {
                    l10.h0();
                    bArr = l10.W();
                    try {
                        l10.close();
                    } catch (Exception e12) {
                        b.e(e12.toString());
                    }
                } else {
                    bArr = null;
                }
                wl.a l11 = a.l(h10, d10, 0L);
                if (l11 != null) {
                    l11.r0(bArr);
                    arrayList2.add(l11);
                    a10.f5983f = l11.I();
                    a10.f5984g = l11.T();
                    if (q5 && !a.c(a10.f5983f, h10)) {
                        b.c(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                        a10.f5986i = false;
                        a10.f5985h = 4101;
                        return a10;
                    } else if (!v11 || 1 == a.f(l11, f10)) {
                        if (s10) {
                        }
                        arrayList3.add(l11);
                    } else {
                        z10 = true;
                    }
                }
                z10 = false;
            } catch (IOException e13) {
                e13.printStackTrace();
                throw new LoadFileException(e13.getMessage(), 4097);
            }
        }
        a10.f5990m = arrayList2;
        a10.f5993p = arrayList3;
        a10.f5992o = arrayList;
        if (v11 && z10 && arrayList3.size() < 1) {
            a10.f5986i = false;
            a10.f5985h = LoadFileException.ERROR_VERSION_CHECK_LOW;
        }
        return a10;
    }
}
