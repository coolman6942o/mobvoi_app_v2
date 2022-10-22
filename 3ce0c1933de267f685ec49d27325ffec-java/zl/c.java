package zl;

import android.content.Context;
import android.text.TextUtils;
import cm.a;
import cm.d;
import com.realsil.sdk.dfu.exception.LoadFileException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;
import jl.b;
/* loaded from: classes2.dex */
public class c extends a {
    /* JADX WARN: Removed duplicated region for block: B:67:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a o(ul.c cVar) {
        int i10;
        int i11;
        boolean z10;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList<vl.a> x10;
        String str;
        ArrayList<vl.a> arrayList3;
        ArrayList arrayList4;
        boolean z11;
        wl.a aVar;
        String str2;
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
            String b11 = b.b(d10);
            if (b11 == null || !b11.equalsIgnoreCase(e10)) {
                il.b.l("the file suffix is not right, suffix=" + b11);
                throw new LoadFileException("invalid suffix", 4099);
            }
            try {
                InputStream open = a10.getAssets().open(d10);
                a aVar2 = new a();
                aVar2.f5978a = d10;
                aVar2.f5979b = lm.d.c(d10);
                ArrayList arrayList5 = new ArrayList();
                ArrayList arrayList6 = new ArrayList();
                ArrayList arrayList7 = new ArrayList();
                if (f10 != null) {
                    i10 = f10.f6005k;
                    i11 = f10.f6004j;
                    aVar2.f5983f = i11;
                } else {
                    aVar2.f5983f = h10;
                    i11 = h10;
                    i10 = 0;
                }
                Locale locale = Locale.US;
                il.b.j(String.format(locale, "device >> otaVersion=%d, icType=0x%02X", Integer.valueOf(i10), Integer.valueOf(i11)));
                il.b.j(String.format(locale, "fileIndicator=0x%08X, filePath=%s, versionCheckEnabled=%b", Integer.valueOf(b10), d10, Boolean.valueOf(v10)));
                int i12 = i10;
                ql.a d11 = ql.a.d(a10, d10, open, 0L);
                if (d11 == null) {
                    arrayList = arrayList5;
                    try {
                        wl.a k10 = a.k(a10, aVar2.f5983f, d10, 0L);
                        if (k10 != null) {
                            arrayList6.add(k10);
                            aVar2.f5983f = k10.I();
                            aVar2.f5984g = k10.T();
                            if (!q5 || a.c(aVar2.f5983f, h10)) {
                                if (v10 && 1 != a.f(k10, f10)) {
                                    z10 = true;
                                }
                                arrayList7.add(k10);
                            } else {
                                il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(aVar2.f5983f)));
                                aVar2.f5986i = false;
                                aVar2.f5985h = 4101;
                                return aVar2;
                            }
                        }
                        z10 = false;
                    } catch (IOException e11) {
                        il.b.l(e11.toString());
                        throw new LoadFileException(e11.getMessage(), 4097);
                    }
                } else if (d11.I()) {
                    aVar2.f5982e = true;
                    aVar2.f5983f = d11.u();
                    aVar2.f5989l = d11.E(0);
                    aVar2.f5991n = d11.E(1);
                    aVar2.f5987j = 0;
                    if (!q5 || a.c(aVar2.f5983f, h10)) {
                        String str3 = "image file disable: bitNumber=";
                        int i13 = 16;
                        if (i12 == 0) {
                            ArrayList<vl.a> x11 = d11.x();
                            if (x11 == null || x11.size() <= 0) {
                                arrayList2 = arrayList5;
                                z10 = false;
                                try {
                                    d11.close();
                                } catch (IOException e12) {
                                    il.b.l(e12.toString());
                                }
                                arrayList = arrayList2;
                            } else {
                                int i14 = 0;
                                z10 = false;
                                while (i14 < x11.size()) {
                                    vl.a aVar3 = x11.get(i14);
                                    int i15 = aVar3.f35830c;
                                    int i16 = aVar2.f5987j;
                                    aVar2.f5987j = i15 < i13 ? i16 | 1 : i16 | 2;
                                    if (!ul.a.c(b10, i15)) {
                                        il.b.j(str3 + i15);
                                    } else {
                                        wl.a e13 = aVar3.e(a10, aVar2.f5983f);
                                        if (e13 != null) {
                                            arrayList6.add(e13);
                                            arrayList3 = x11;
                                            if (aVar2.f5983f > 3) {
                                                aVar = e13;
                                            } else if (!cVar.p()) {
                                                aVar = e13;
                                                z11 = z10;
                                                if (i15 == 2) {
                                                    str2 = "ignore app ban1 image, non-dualbank only alllow update app bank0 image";
                                                    il.b.c(str2);
                                                    arrayList4 = arrayList5;
                                                    z10 = z11;
                                                    i14++;
                                                    arrayList5 = arrayList4;
                                                    x11 = arrayList3;
                                                    i13 = 16;
                                                }
                                                if (v10) {
                                                }
                                                arrayList7.add(aVar);
                                                arrayList4 = arrayList5;
                                                arrayList4.add(aVar3);
                                                z10 = z11;
                                                i14++;
                                                arrayList5 = arrayList4;
                                                x11 = arrayList3;
                                                i13 = 16;
                                            } else if (i15 == 1) {
                                                aVar = e13;
                                                if (!(f10 == null || f10.f6007m == 0)) {
                                                    il.b.c("ignore subfile, appFreeBank=" + f10.f6007m);
                                                    z11 = z10;
                                                    arrayList4 = arrayList5;
                                                    z10 = z11;
                                                    i14++;
                                                    arrayList5 = arrayList4;
                                                    x11 = arrayList3;
                                                    i13 = 16;
                                                }
                                            } else {
                                                aVar = e13;
                                                if (i15 == 2 && f10 != null) {
                                                    z11 = z10;
                                                    if (f10.f6007m != 1) {
                                                        str2 = "ignore subfile, appFreeBank=" + f10.f6007m;
                                                        il.b.c(str2);
                                                        arrayList4 = arrayList5;
                                                        z10 = z11;
                                                        i14++;
                                                        arrayList5 = arrayList4;
                                                        x11 = arrayList3;
                                                        i13 = 16;
                                                    }
                                                    if (v10 || 1 == a.e(i15, aVar, f10)) {
                                                        arrayList7.add(aVar);
                                                        arrayList4 = arrayList5;
                                                        arrayList4.add(aVar3);
                                                        z10 = z11;
                                                        i14++;
                                                        arrayList5 = arrayList4;
                                                        x11 = arrayList3;
                                                        i13 = 16;
                                                    } else {
                                                        arrayList4 = arrayList5;
                                                        z10 = true;
                                                        i14++;
                                                        arrayList5 = arrayList4;
                                                        x11 = arrayList3;
                                                        i13 = 16;
                                                    }
                                                }
                                            }
                                            z11 = z10;
                                            if (v10) {
                                            }
                                            arrayList7.add(aVar);
                                            arrayList4 = arrayList5;
                                            arrayList4.add(aVar3);
                                            z10 = z11;
                                            i14++;
                                            arrayList5 = arrayList4;
                                            x11 = arrayList3;
                                            i13 = 16;
                                        }
                                    }
                                    arrayList3 = x11;
                                    z11 = z10;
                                    arrayList4 = arrayList5;
                                    z10 = z11;
                                    i14++;
                                    arrayList5 = arrayList4;
                                    x11 = arrayList3;
                                    i13 = 16;
                                }
                                arrayList2 = arrayList5;
                                d11.close();
                                arrayList = arrayList2;
                            }
                        } else {
                            arrayList2 = arrayList5;
                            if (i12 == 1) {
                                int i17 = 0;
                                z10 = false;
                                for (int i18 = 16; i17 < i18; i18 = 16) {
                                    int n10 = a.n(i17, f10.L, f10.O);
                                    if (n10 < i18) {
                                        aVar2.f5987j |= 1;
                                    } else {
                                        aVar2.f5987j |= 2;
                                    }
                                    if (!ul.a.c(b10, n10)) {
                                        il.b.j(str3 + n10);
                                    } else {
                                        vl.a v11 = d11.v(n10);
                                        wl.a e14 = v11 != null ? v11.e(a10, aVar2.f5983f) : null;
                                        if (e14 != null) {
                                            arrayList6.add(e14);
                                            if (!v10 || 1 == a.e(n10, e14, f10)) {
                                                arrayList7.add(e14);
                                                arrayList2.add(v11);
                                            } else {
                                                z10 = true;
                                            }
                                        }
                                    }
                                    i17++;
                                }
                            } else {
                                if (i12 == 2 && (x10 = d11.x()) != null && x10.size() > 0) {
                                    int i19 = 0;
                                    z10 = false;
                                    while (i19 < x10.size()) {
                                        vl.a aVar4 = x10.get(i19);
                                        int i20 = aVar4.f35830c;
                                        aVar2.f5987j = i20 < 16 ? aVar2.f5987j | 1 : aVar2.f5987j | 2;
                                        if (!ul.a.c(b10, i20)) {
                                            il.b.j(str3 + i20);
                                        } else {
                                            wl.a e15 = aVar4.e(a10, aVar2.f5983f);
                                            if (e15 != null) {
                                                arrayList6.add(e15);
                                                if (v10) {
                                                    str = str3;
                                                    if (1 != a.e(i20, e15, f10)) {
                                                        z10 = true;
                                                        i19++;
                                                        str3 = str;
                                                    }
                                                } else {
                                                    str = str3;
                                                }
                                                arrayList7.add(e15);
                                                arrayList2.add(aVar4);
                                                i19++;
                                                str3 = str;
                                            }
                                        }
                                        str = str3;
                                        i19++;
                                        str3 = str;
                                    }
                                }
                                z10 = false;
                            }
                            d11.close();
                            arrayList = arrayList2;
                        }
                    } else {
                        il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(aVar2.f5983f)));
                        aVar2.f5986i = false;
                        aVar2.f5985h = 4101;
                        return aVar2;
                    }
                } else {
                    il.b.l("pack for MP can not be OTA");
                    throw new LoadFileException("not support pack file.", LoadFileException.ERROR_PACK_MP_NOT_SUPPORTED);
                }
                aVar2.f5990m = arrayList6;
                aVar2.f5993p = arrayList7;
                aVar2.f5992o = arrayList;
                if (v10 && z10 && arrayList7.size() < 1) {
                    aVar2.f5986i = false;
                    aVar2.f5985h = LoadFileException.ERROR_VERSION_CHECK_LOW;
                }
                return aVar2;
            } catch (IOException e16) {
                il.b.l(e16.toString());
                return null;
            }
        } else {
            throw new LoadFileException("invalid path", 4098);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:22|(7:26|(10:29|(1:31)(1:32)|33|(1:35)(2:36|(8:38|(2:40|(2:42|(1:(5:47|65|66|154|67))(2:48|(3:51|(5:53|57|66|154|67)|(4:63|66|154|67)(3:62|155|67))))(7:54|(5:56|57|66|154|67)|(1:60)|63|66|154|67))|58|(0)|63|66|154|67))|64|65|66|154|67|27)|153|68|150|119|122)|118|150|119|122) */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0253, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0254, code lost:
        il.b.l(r0.toString());
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a p(ul.c cVar) {
        boolean z10;
        boolean z11;
        ArrayList<vl.a> x10;
        ArrayList<vl.a> arrayList;
        boolean z12;
        String str;
        int i10;
        cVar.a();
        int h10 = cVar.h();
        String d10 = cVar.d();
        String e10 = cVar.e();
        int b10 = cVar.b();
        d f10 = cVar.f();
        boolean v10 = cVar.v();
        boolean q5 = cVar.q();
        a a10 = a.a(d10, e10);
        a10.f5988k = cVar.k();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int i11 = f10 != null ? f10.f6005k : 0;
        a10.f5983f = h10;
        if (pl.b.d(cVar) != null) {
            il.b.l("not support multi pack file");
            a10.f5986i = false;
            a10.f5981d = 4;
            i10 = 4103;
        } else {
            ql.a h11 = ql.a.h(d10);
            int i12 = 1;
            if (h11 == null) {
                a10.f5981d = 1;
                a10.f5987j = 0;
                try {
                    wl.a l10 = a.l(h10, d10, 0L);
                    if (l10 != null) {
                        arrayList3.add(l10);
                        a10.f5983f = l10.I();
                        a10.f5984g = l10.T();
                        if (q5 && !a.c(a10.f5983f, h10)) {
                            il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                            a10.f5986i = false;
                            a10.f5985h = 4101;
                            return a10;
                        } else if (!v10 || 1 == a.f(l10, f10)) {
                            arrayList4.add(l10);
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
                    int i13 = 16;
                    if (i11 == 0) {
                        ArrayList<vl.a> x11 = h11.x();
                        if (x11 != null && x11.size() > 0) {
                            int i14 = 0;
                            boolean z13 = false;
                            while (i14 < x11.size()) {
                                vl.a aVar = x11.get(i14);
                                int i15 = aVar.f35830c;
                                a10.f5987j = i15 < i13 ? a10.f5987j | i12 : a10.f5987j | 2;
                                if (!ul.a.c(b10, i15)) {
                                    il.b.j("image file disable: bitNumber=" + i15);
                                } else {
                                    wl.a f11 = aVar.f(a10.f5983f);
                                    if (f11 != null) {
                                        arrayList3.add(f11);
                                        arrayList = x11;
                                        if (a10.f5983f <= 3) {
                                            if (!cVar.p()) {
                                                z12 = z13;
                                                if (i15 == 2) {
                                                    str = "ignore app ban1 image, non-dualbank only alllow update app bank0 image";
                                                    il.b.c(str);
                                                    z13 = z12;
                                                    i14++;
                                                    x11 = arrayList;
                                                    i13 = 16;
                                                    i12 = 1;
                                                }
                                                if (v10) {
                                                }
                                                arrayList4.add(f11);
                                                arrayList2.add(aVar);
                                                z13 = z12;
                                                i14++;
                                                x11 = arrayList;
                                                i13 = 16;
                                                i12 = 1;
                                            } else if (i15 == 1) {
                                                if (!(f10 == null || f10.f6007m == 0)) {
                                                    il.b.c("ignore subfile, appFreeBank=" + f10.f6007m);
                                                    z12 = z13;
                                                    z13 = z12;
                                                    i14++;
                                                    x11 = arrayList;
                                                    i13 = 16;
                                                    i12 = 1;
                                                }
                                            } else if (i15 == 2 && f10 != null) {
                                                z12 = z13;
                                                if (f10.f6007m != 1) {
                                                    str = "ignore subfile, appFreeBank=" + f10.f6007m;
                                                    il.b.c(str);
                                                    z13 = z12;
                                                    i14++;
                                                    x11 = arrayList;
                                                    i13 = 16;
                                                    i12 = 1;
                                                }
                                                if (v10 || 1 == a.e(i15, f11, f10)) {
                                                    arrayList4.add(f11);
                                                    arrayList2.add(aVar);
                                                    z13 = z12;
                                                    i14++;
                                                    x11 = arrayList;
                                                    i13 = 16;
                                                    i12 = 1;
                                                } else {
                                                    z13 = true;
                                                    i14++;
                                                    x11 = arrayList;
                                                    i13 = 16;
                                                    i12 = 1;
                                                }
                                            }
                                        }
                                        z12 = z13;
                                        if (v10) {
                                        }
                                        arrayList4.add(f11);
                                        arrayList2.add(aVar);
                                        z13 = z12;
                                        i14++;
                                        x11 = arrayList;
                                        i13 = 16;
                                        i12 = 1;
                                    }
                                }
                                arrayList = x11;
                                z12 = z13;
                                z13 = z12;
                                i14++;
                                x11 = arrayList;
                                i13 = 16;
                                i12 = 1;
                            }
                            z11 = z13;
                            h11.close();
                            z10 = z11;
                        }
                        z11 = false;
                        h11.close();
                        z10 = z11;
                    } else {
                        int i16 = 1;
                        if (i11 == 1) {
                            int i17 = 0;
                            z11 = false;
                            while (i17 < 16) {
                                int n10 = a.n(i17, f10.L, f10.O);
                                if (n10 < 16) {
                                    a10.f5987j |= i16;
                                } else {
                                    a10.f5987j |= 2;
                                }
                                if (!ul.a.c(b10, n10)) {
                                    il.b.j("image file disable: bitNumber=" + n10);
                                } else {
                                    vl.a v11 = h11.v(n10);
                                    wl.a f12 = v11 != null ? v11.f(a10.f5983f) : null;
                                    if (f12 != null) {
                                        arrayList3.add(f12);
                                        if (!v10 || 1 == a.e(n10, f12, f10)) {
                                            arrayList4.add(f12);
                                            arrayList2.add(v11);
                                        } else {
                                            z11 = true;
                                        }
                                    }
                                }
                                i17++;
                                i16 = 1;
                            }
                        } else {
                            if (i11 == 2 && (x10 = h11.x()) != null && x10.size() > 0) {
                                z11 = false;
                                for (int i18 = 0; i18 < x10.size(); i18++) {
                                    vl.a aVar2 = x10.get(i18);
                                    int i19 = aVar2.f35830c;
                                    int i20 = a10.f5987j;
                                    a10.f5987j = i19 < 16 ? i20 | 1 : i20 | 2;
                                    if (!ul.a.c(b10, i19)) {
                                        il.b.j("image file disable: bitNumber=" + i19);
                                    } else {
                                        wl.a f13 = aVar2.f(a10.f5983f);
                                        if (f13 != null) {
                                            arrayList3.add(f13);
                                            if (!v10 || 1 == a.e(i19, f13, f10)) {
                                                arrayList4.add(f13);
                                                arrayList2.add(aVar2);
                                            } else {
                                                z11 = true;
                                            }
                                        }
                                    }
                                }
                            }
                            z11 = false;
                        }
                        h11.close();
                        z10 = z11;
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
            a10.f5990m = arrayList3;
            a10.f5993p = arrayList4;
            a10.f5992o = arrayList2;
            if (v10 && z10 && arrayList4.size() < 1) {
                a10.f5986i = false;
                a10.f5985h = LoadFileException.ERROR_VERSION_CHECK_LOW;
            }
            return a10;
        }
        a10.f5985h = i10;
        return a10;
    }
}
