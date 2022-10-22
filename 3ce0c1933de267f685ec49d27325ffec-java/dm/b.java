package dm;

import android.content.Context;
import android.text.TextUtils;
import cm.d;
import com.realsil.sdk.dfu.exception.LoadFileException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;
import ul.c;
import zl.a;
/* loaded from: classes2.dex */
public class b extends a {
    public static cm.a o(c cVar) {
        int i10;
        int i11;
        boolean z10;
        ArrayList arrayList;
        int i12;
        int i13;
        ArrayList arrayList2;
        Context a10 = cVar.a();
        int h10 = cVar.h();
        String d10 = cVar.d();
        String e10 = cVar.e();
        int b10 = cVar.b();
        d f10 = cVar.f();
        boolean v10 = cVar.v();
        boolean q5 = cVar.q();
        if (a10 == null) {
            throw new LoadFileException("invalid context", 4097);
        } else if (!TextUtils.isEmpty(d10)) {
            String b11 = jl.b.b(d10);
            if (b11 == null || !b11.equalsIgnoreCase(e10)) {
                il.b.l("the file suffix is not right, suffix=" + b11);
                throw new LoadFileException("invalid suffix", 4099);
            }
            try {
                InputStream open = a10.getAssets().open(d10);
                cm.a aVar = new cm.a();
                aVar.f5978a = d10;
                aVar.f5979b = lm.d.c(d10);
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                ArrayList arrayList5 = new ArrayList();
                if (f10 != null) {
                    i10 = f10.f6005k;
                    i11 = f10.f6004j;
                    aVar.f5983f = i11;
                } else {
                    aVar.f5983f = h10;
                    i11 = h10;
                    i10 = 1;
                }
                Locale locale = Locale.US;
                il.b.j(String.format(locale, "device >> otaVersion=%d, icType=0x%02X", Integer.valueOf(i10), Integer.valueOf(i11)));
                il.b.j(String.format(locale, "fileIndicator=0x%08X, filePath=%s, versionCheckEnabled=%b", Integer.valueOf(b10), d10, Boolean.valueOf(v10)));
                ql.a d11 = ql.a.d(a10, d10, open, 0L);
                if (d11 == null) {
                    arrayList = arrayList3;
                    try {
                        wl.a k10 = a.k(a10, aVar.f5983f, d10, 0L);
                        if (k10 != null) {
                            arrayList4.add(k10);
                            aVar.f5983f = k10.I();
                            aVar.f5984g = k10.T();
                            if (!q5 || a.c(aVar.f5983f, h10)) {
                                if (v10 && 1 != a.f(k10, f10)) {
                                    z10 = true;
                                }
                                arrayList5.add(k10);
                            } else {
                                il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(aVar.f5983f)));
                                aVar.f5986i = false;
                                aVar.f5985h = 4101;
                                return aVar;
                            }
                        }
                        z10 = false;
                    } catch (IOException e11) {
                        il.b.l(e11.toString());
                        throw new LoadFileException(e11.getMessage(), 4097);
                    }
                } else if (d11.I()) {
                    aVar.f5982e = true;
                    aVar.f5983f = d11.u();
                    aVar.f5989l = d11.E(0);
                    aVar.f5991n = d11.E(1);
                    aVar.f5987j = 0;
                    if (!q5 || a.c(aVar.f5983f, h10)) {
                        int i14 = 0;
                        boolean z11 = false;
                        while (i14 < 16) {
                            int n10 = a.n(i14, f10.L, f10.O);
                            if (n10 < 16) {
                                i13 = aVar.f5987j;
                                i12 = 1;
                            } else {
                                i13 = aVar.f5987j;
                                i12 = 2;
                            }
                            aVar.f5987j = i13 | i12;
                            if (!ul.a.c(b10, n10)) {
                                il.b.j("image file disable: bitNumber=" + n10);
                            } else {
                                vl.a v11 = d11.v(n10);
                                wl.a e12 = v11 != null ? v11.e(a10, aVar.f5983f) : null;
                                if (e12 != null) {
                                    arrayList4.add(e12);
                                    if (!v10 || 1 == a.e(n10, e12, f10)) {
                                        arrayList5.add(e12);
                                        arrayList2 = arrayList3;
                                        arrayList2.add(v11);
                                    } else {
                                        arrayList2 = arrayList3;
                                        z11 = true;
                                    }
                                    i14++;
                                    arrayList3 = arrayList2;
                                }
                            }
                            arrayList2 = arrayList3;
                            i14++;
                            arrayList3 = arrayList2;
                        }
                        arrayList = arrayList3;
                        try {
                            d11.close();
                        } catch (IOException e13) {
                            il.b.l(e13.toString());
                        }
                        z10 = z11;
                    } else {
                        il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(aVar.f5983f)));
                        aVar.f5986i = false;
                        aVar.f5985h = 4101;
                        return aVar;
                    }
                } else {
                    il.b.l("pack for MP can not be OTA");
                    throw new LoadFileException("not support pack file.", LoadFileException.ERROR_PACK_MP_NOT_SUPPORTED);
                }
                aVar.f5990m = arrayList4;
                aVar.f5993p = arrayList5;
                aVar.f5992o = arrayList;
                if (v10 && z10 && arrayList5.size() < 1) {
                    aVar.f5986i = false;
                    aVar.f5985h = LoadFileException.ERROR_VERSION_CHECK_LOW;
                }
                return aVar;
            } catch (IOException e14) {
                il.b.l(e14.toString());
                return null;
            }
        } else {
            throw new LoadFileException("invalid path", 4098);
        }
    }

    public static cm.a p(c cVar) {
        boolean z10;
        int i10;
        cVar.a();
        int h10 = cVar.h();
        String d10 = cVar.d();
        String e10 = cVar.e();
        int b10 = cVar.b();
        d f10 = cVar.f();
        boolean v10 = cVar.v();
        boolean q5 = cVar.q();
        cm.a a10 = a.a(d10, e10);
        a10.f5988k = cVar.k();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        a10.f5983f = h10;
        if (pl.b.d(cVar) != null) {
            il.b.l("not support multi pack file");
            a10.f5986i = false;
            a10.f5981d = 4;
            i10 = 4103;
        } else {
            ql.a h11 = ql.a.h(d10);
            if (h11 == null) {
                a10.f5981d = 1;
                a10.f5987j = 0;
                try {
                    wl.a l10 = a.l(h10, d10, 0L);
                    if (l10 != null) {
                        arrayList2.add(l10);
                        a10.f5983f = l10.I();
                        a10.f5984g = l10.T();
                        if (q5 && !a.c(a10.f5983f, h10)) {
                            il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                            a10.f5986i = false;
                            a10.f5985h = 4101;
                            return a10;
                        } else if (!v10 || 1 == a.f(l10, f10)) {
                            arrayList3.add(l10);
                        } else {
                            z10 = true;
                        }
                    }
                    z10 = false;
                } catch (IOException e11) {
                    e11.printStackTrace();
                    throw new LoadFileException(e11.getMessage(), 4097);
                }
            } else if (h11.I()) {
                il.b.k(a.f37626a, h11.toString());
                a10.f5981d = 2;
                a10.f5982e = true;
                a10.f5983f = h11.u();
                a10.f5989l = h11.E(0);
                a10.f5991n = h11.E(1);
                a10.f5987j = 0;
                if (!q5 || a.c(a10.f5983f, h10)) {
                    z10 = false;
                    for (int i11 = 0; i11 < 16; i11++) {
                        int n10 = a.n(i11, f10.L, f10.O);
                        a10.f5987j = n10 < 16 ? a10.f5987j | 1 : a10.f5987j | 2;
                        if (!ul.a.c(b10, n10)) {
                            il.b.j("image file disable: bitNumber=" + n10);
                        } else {
                            vl.a v11 = h11.v(n10);
                            wl.a f11 = v11 != null ? v11.f(a10.f5983f) : null;
                            if (f11 != null) {
                                arrayList2.add(f11);
                                if (!v10 || 1 == a.e(n10, f11, f10)) {
                                    arrayList3.add(f11);
                                    arrayList.add(v11);
                                } else {
                                    z10 = true;
                                }
                            }
                        }
                    }
                    try {
                        h11.close();
                    } catch (IOException e12) {
                        il.b.l(e12.toString());
                    }
                } else {
                    il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                    a10.f5986i = false;
                    i10 = 4101;
                }
            } else {
                il.b.l("pack for MP can not be OTA");
                throw new LoadFileException("not support pack file.", LoadFileException.ERROR_PACK_MP_NOT_SUPPORTED);
            }
            a10.f5990m = arrayList2;
            a10.f5993p = arrayList3;
            a10.f5992o = arrayList;
            if (v10 && z10 && arrayList3.size() < 1) {
                a10.f5986i = false;
                a10.f5985h = LoadFileException.ERROR_VERSION_CHECK_LOW;
            }
            return a10;
        }
        a10.f5985h = i10;
        return a10;
    }
}
