package fm;

import android.content.Context;
import android.text.TextUtils;
import com.realsil.sdk.dfu.exception.LoadFileException;
import com.realsil.sdk.dfu.model.ImageVersionInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import lm.d;
import nl.c;
/* loaded from: classes2.dex */
public class b extends zl.a {

    /* loaded from: classes2.dex */
    public static class a implements Comparator<wl.a> {
        /* renamed from: a */
        public int compare(wl.a aVar, wl.a aVar2) {
            return aVar2.C - aVar.C;
        }
    }

    /* renamed from: fm.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0289b implements Comparator<wl.a> {
        /* renamed from: a */
        public int compare(wl.a aVar, wl.a aVar2) {
            return aVar2.C - aVar.C;
        }
    }

    public static int g(int i10, int i11, int i12, int i13, int i14) {
        int i15;
        il.b.j(String.format(Locale.US, "checkVersion: version1=%08X(%d) %s, version2=%08X(%d) %s", Integer.valueOf(i10), Integer.valueOf(i10), d.b(i11, i10, i14), Integer.valueOf(i12), Integer.valueOf(i12), d.b(i13, i12, i14)));
        if (i11 <= 0) {
            i15 = c.a(i12, i13, i14);
        } else if (i14 == 1) {
            int i16 = i10 & 255;
            int i17 = i12 & 255;
            if (i16 > i17) {
                return 1;
            }
            if (i16 == i17) {
                int i18 = (i10 >> 8) & 255;
                int i19 = (i12 >> 8) & 255;
                if (i18 > i19) {
                    return 1;
                }
                if (i18 == i19) {
                    int i20 = (i10 >> 16) & 255;
                    int i21 = (i12 >> 16) & 255;
                    if (i20 > i21) {
                        return 1;
                    }
                    if (i20 == i21) {
                        i10 = (i10 >> 24) & 255;
                        i15 = (i12 >> 24) & 255;
                    }
                }
            }
            return -1;
        } else if (i14 == 515) {
            int i22 = (i10 >> 8) & 255;
            int i23 = (i12 >> 8) & 255;
            if (i22 > i23) {
                return 1;
            }
            if (i22 == i23) {
                int i24 = i10 & 255;
                int i25 = i12 & 255;
                if (i24 > i25) {
                    return 1;
                }
                if (i24 == i25) {
                    return 0;
                }
            }
            return -1;
        } else if (i14 == 2) {
            int i26 = (i10 >> 24) & 255;
            int i27 = (i12 >> 24) & 255;
            if (i26 > i27) {
                return 1;
            }
            if (i26 == i27) {
                int i28 = (i10 >> 16) & 255;
                int i29 = (i12 >> 16) & 255;
                if (i28 > i29) {
                    return 1;
                }
                if (i28 == i29) {
                    int i30 = (i10 >> 8) & 255;
                    int i31 = (i12 >> 8) & 255;
                    if (i30 > i31) {
                        return 1;
                    }
                    if (i30 == i31) {
                        i10 &= 255;
                        i15 = i12 & 255;
                    }
                }
            }
            return -1;
        } else if (i14 == 3) {
            int i32 = i10 & 15;
            int i33 = i12 & 15;
            if (i32 > i33) {
                return 1;
            }
            if (i32 == i33) {
                int i34 = (i10 >> 4) & 255;
                int i35 = (i12 >> 4) & 255;
                if (i34 > i35) {
                    return 1;
                }
                if (i34 == i35) {
                    int i36 = (i10 >> 12) & 32767;
                    int i37 = (i12 >> 12) & 32767;
                    if (i36 > i37) {
                        return 1;
                    }
                    if (i36 == i37) {
                        i10 = (i10 >> 27) & 31;
                        i15 = (i12 >> 27) & 31;
                    }
                }
            }
            return -1;
        } else if (i14 == 5) {
            int i38 = i10 & 15;
            int i39 = i12 & 15;
            if (i38 > i39) {
                return 1;
            }
            if (i38 == i39) {
                int i40 = (i10 >> 4) & 255;
                int i41 = (i12 >> 4) & 255;
                if (i40 > i41) {
                    return 1;
                }
                if (i40 == i41) {
                    int i42 = (i10 >> 12) & 511;
                    int i43 = (i12 >> 12) & 511;
                    if (i42 > i43) {
                        return 1;
                    }
                    if (i42 == i43) {
                        i10 = (i10 >> 21) & 32767;
                        i15 = (i12 >> 21) & 32767;
                    }
                }
            }
            return -1;
        } else {
            if (!(i14 == 4 || i14 == 7 || i14 != 514)) {
                int i44 = (i10 >> 8) & 255;
                int i45 = (i12 >> 8) & 255;
                if (i44 > i45) {
                    return 1;
                }
                if (i44 == i45) {
                    int i46 = i10 & 255;
                    int i47 = i12 & 255;
                    if (i46 > i47) {
                        return 1;
                    }
                    if (i46 == i47) {
                        int i48 = (i10 >> 24) & 255;
                        int i49 = (i12 >> 24) & 255;
                        if (i48 > i49) {
                            return 1;
                        }
                        if (i48 == i49) {
                            int i50 = (i10 >> 16) & 255;
                            int i51 = (i12 >> 16) & 255;
                            if (i50 > i51) {
                                return 1;
                            }
                            if (i50 == i51) {
                                return 0;
                            }
                        }
                    }
                }
                return -1;
            }
            return ol.b.b(i10, i12);
        }
        return ol.b.b(i10, i15);
    }

    public static int o(int i10, wl.a aVar, cm.d dVar) {
        if (dVar == null) {
            return 1;
        }
        int Q = aVar.Q();
        int i11 = dVar.f6004j;
        if (i11 == 4 || i11 == 6 || i11 == 7 || i11 == 8 || i11 == 13) {
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
            boolean z10 = zl.a.f37626a;
            il.b.k(z10, "not support section size check for ic:" + dVar.f6004j);
        }
        return 1;
    }

    public static int p(wl.a aVar, cm.d dVar) {
        if (dVar == null) {
            return 1;
        }
        int w10 = aVar.w();
        int Q = aVar.Q();
        ul.a aVar2 = null;
        int i10 = dVar.f6004j;
        if (i10 == 4 || i10 == 6 || i10 == 7 || i10 == 8 || i10 == 13) {
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
            boolean z10 = zl.a.f37626a;
            il.b.k(z10, "not support section size check for ic:" + dVar.f6004j);
        }
        return 1;
    }

    public static cm.a q(ul.c cVar) {
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
                cm.d f10 = cVar.f();
                boolean v10 = cVar.v();
                boolean q5 = cVar.q();
                int h10 = cVar.h();
                cm.a aVar = new cm.a();
                aVar.f5978a = d10;
                aVar.f5979b = d.c(d10);
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
                    if (!q5 || zl.a.c(aVar.f5983f, h10)) {
                        z10 = false;
                        for (int i11 = 0; i11 < 16; i11++) {
                            int n10 = zl.a.n(i11, f10.L, f10.O);
                            aVar.f5987j = n10 < 16 ? aVar.f5987j | 1 : aVar.f5987j | 2;
                            if (!ul.a.c(b11, n10)) {
                                il.b.j("image file disable: bitNumber=" + n10);
                            } else {
                                vl.a v11 = i10.v(n10);
                                wl.a e11 = v11 != null ? v11.e(a10, aVar.f5983f) : null;
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
                        il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(aVar.f5983f)));
                        aVar.f5986i = false;
                        aVar.f5985h = 4101;
                        return aVar;
                    }
                } else {
                    try {
                        wl.a k10 = zl.a.k(a10, aVar.f5983f, d10, 0L);
                        if (k10 != null) {
                            arrayList2.add(k10);
                            aVar.f5983f = k10.I();
                            aVar.f5984g = k10.T();
                            if (!q5 || zl.a.c(aVar.f5983f, h10)) {
                                if (v10 && 1 != zl.a.f(k10, f10)) {
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

    /* JADX WARN: Code restructure failed: missing block: B:182:0x044b, code lost:
        if (r6 == p(r1, r4)) goto L183;
     */
    /* JADX WARN: Removed duplicated region for block: B:66:0x019e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x02df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static cm.a r(ul.c cVar) {
        boolean z10;
        ArrayList arrayList;
        int i10;
        boolean z11;
        boolean z12;
        ql.a aVar;
        boolean z13;
        boolean z14;
        Iterator<vl.a> it;
        ArrayList arrayList2;
        ql.a aVar2;
        boolean z15;
        boolean z16;
        int i11;
        ArrayList arrayList3;
        int i12;
        int i13;
        String str;
        boolean z17;
        int i14;
        int i15;
        int i16;
        vl.a v10;
        cVar.a();
        int h10 = cVar.h();
        String d10 = cVar.d();
        String e10 = cVar.e();
        int b10 = cVar.b();
        cm.d f10 = cVar.f();
        boolean v11 = cVar.v();
        boolean q5 = cVar.q();
        boolean s10 = cVar.s();
        int k10 = cVar.k();
        cm.a a10 = zl.a.a(d10, e10);
        Locale locale = Locale.US;
        il.b.j(String.format(locale, "fileIndicator=0x%08X, filePath=%s, versionCheckEnabled=%b, sectionSizeCheckEnabled=%b", Integer.valueOf(b10), d10, Boolean.valueOf(v11), Boolean.valueOf(s10)));
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList<wl.a> arrayList6 = new ArrayList();
        int i17 = f10 != null ? f10.f6005k : 1;
        a10.f5983f = h10;
        a10.f5988k = cVar.k();
        il.b.j(String.format(locale, "device >> specVersion=%d, icType=0x%02X", Integer.valueOf(i17), Integer.valueOf(h10)));
        ql.a n10 = pl.b.n(cVar);
        if (n10 != null) {
            a10.f5982e = true;
            a10.f5983f = n10.u();
            a10.f5989l = n10.E(0);
            a10.f5991n = n10.E(1);
            a10.f5987j = 0;
            if (!q5 || zl.a.c(a10.f5983f, h10)) {
                if (!s10 || (!((i16 = a10.f5983f) == 4 || i16 == 6 || i16 == 7 || i16 == 8 || i16 == 13 || i16 == 10) || (v10 = n10.v(2)) == null)) {
                    z12 = true;
                    z11 = false;
                } else {
                    wl.a f11 = v10.f(a10.f5983f);
                    if (f11 == null || 1 == o(2, f11, f10)) {
                        z12 = true;
                    } else {
                        il.b.l("pre verify failed");
                        z12 = false;
                    }
                    z11 = true;
                }
                if (z12) {
                    Iterator<vl.a> it2 = n10.E(k10).iterator();
                    z14 = false;
                    z13 = false;
                    while (it2.hasNext()) {
                        vl.a next = it2.next();
                        int g10 = next.g();
                        if (!ul.a.c(b10, g10)) {
                            il.b.j("prohibit upgrade image_id=" + next.f35837j);
                            it = it2;
                        } else {
                            wl.a f12 = next.f(a10.f5983f);
                            if (f12 == null) {
                                boolean z18 = zl.a.f37626a;
                                StringBuilder sb2 = new StringBuilder();
                                it = it2;
                                sb2.append("invalid stream: ");
                                sb2.append(next.toString());
                                il.b.k(z18, sb2.toString());
                            } else {
                                it2 = it2;
                                int w10 = f12.w();
                                b10 = b10;
                                if (w10 != 513) {
                                    if (w10 == 517) {
                                        i15 = 3;
                                        f12.C = 3;
                                        z13 = true;
                                    } else if (w10 == 519) {
                                        i15 = 3;
                                    } else if (w10 != 768) {
                                        switch (w10) {
                                            case 61441:
                                            case 61442:
                                            case 61443:
                                            case 61444:
                                            case 61445:
                                            case 61446:
                                            case 61447:
                                            case 61448:
                                                f12.C = 0;
                                                break;
                                            default:
                                                i14 = 1;
                                                f12.C = i14;
                                                break;
                                        }
                                        if (v11 || f10 == null) {
                                            z16 = z14;
                                            aVar2 = n10;
                                            arrayList2 = arrayList4;
                                            z15 = z13;
                                        } else {
                                            ul.a a11 = ul.a.a(ul.a.f35469l, g10);
                                            int i18 = a11 != null ? a11.f35475f : 1;
                                            ImageVersionInfo q10 = f10.q(f12.O());
                                            z16 = z14;
                                            if (q10 != null) {
                                                z15 = z13;
                                                if (q10.d() == -1) {
                                                    aVar2 = n10;
                                                    il.b.k(zl.a.f37626a, String.format("invalid active version:0x%04X, no need to check", Integer.valueOf(q10.d())));
                                                    f12.m0(1);
                                                    arrayList2 = arrayList4;
                                                    i13 = 1;
                                                } else {
                                                    aVar2 = n10;
                                                    int g11 = g(f12.f36312l, f12.f36308h, q10.d(), f10.f6005k, i18);
                                                    arrayList2 = arrayList4;
                                                    i13 = 1;
                                                    il.b.j(String.format(Locale.US, "compare active image, bitNumber=%d, compare=%d ", Integer.valueOf(next.f35830c), Integer.valueOf(g11)));
                                                    f12.m0(g11);
                                                }
                                            } else {
                                                aVar2 = n10;
                                                arrayList2 = arrayList4;
                                                z15 = z13;
                                                i13 = 1;
                                                il.b.k(zl.a.f37626a, String.format("not find active image, imageId=0x%04X", Integer.valueOf(f12.O())));
                                                f12.m0(1);
                                            }
                                            ImageVersionInfo x10 = f10.x(f12.O());
                                            if (x10 == null) {
                                                z17 = zl.a.f37626a;
                                                Object[] objArr = new Object[i13];
                                                objArr[0] = Integer.valueOf(f12.O());
                                                str = String.format("not find inactive image, imageId=0x%04X", objArr);
                                            } else if (x10.d() == -1) {
                                                z17 = zl.a.f37626a;
                                                Object[] objArr2 = new Object[i13];
                                                objArr2[0] = Integer.valueOf(x10.d());
                                                str = String.format("invalid inactive version:0x%04X, no need to check", objArr2);
                                            } else {
                                                int g12 = g(f12.f36312l, f12.f36308h, x10.d(), f10.f6005k, i18);
                                                il.b.j(String.format(Locale.US, "compare inactive image, bitNumber=%d, compare=%d ", Integer.valueOf(next.f35830c), Integer.valueOf(g12)));
                                                f12.o0(g12);
                                            }
                                            il.b.k(z17, str);
                                            f12.o0(i13);
                                        }
                                        if (zl.a.f37626a) {
                                            il.b.j(f12.toString());
                                        }
                                        arrayList5.add(f12);
                                        if (s10) {
                                            if (z11) {
                                                il.b.c("preVerify OTA_HEADER_FILE ok, need to check section size");
                                            } else {
                                                i11 = 1;
                                                if (1 != o(g10, f12, f10)) {
                                                    a10.f5986i = false;
                                                    i12 = LoadFileException.ERROR_SECTION_SIZE_CHECK_FAILED;
                                                }
                                                if (v11 || f12.v() == i11) {
                                                    arrayList6.add(f12);
                                                    arrayList3 = arrayList2;
                                                    arrayList3.add(next);
                                                } else {
                                                    arrayList3 = arrayList2;
                                                }
                                                arrayList4 = arrayList3;
                                                z14 = z16;
                                                z13 = z15;
                                                n10 = aVar2;
                                            }
                                        }
                                        i11 = 1;
                                        if (v11) {
                                        }
                                        arrayList6.add(f12);
                                        arrayList3 = arrayList2;
                                        arrayList3.add(next);
                                        arrayList4 = arrayList3;
                                        z14 = z16;
                                        z13 = z15;
                                        n10 = aVar2;
                                    }
                                    f12.C = i15;
                                    z14 = true;
                                    if (v11) {
                                    }
                                    z16 = z14;
                                    aVar2 = n10;
                                    arrayList2 = arrayList4;
                                    z15 = z13;
                                    if (zl.a.f37626a) {
                                    }
                                    arrayList5.add(f12);
                                    if (s10) {
                                    }
                                    i11 = 1;
                                    if (v11) {
                                    }
                                    arrayList6.add(f12);
                                    arrayList3 = arrayList2;
                                    arrayList3.add(next);
                                    arrayList4 = arrayList3;
                                    z14 = z16;
                                    z13 = z15;
                                    n10 = aVar2;
                                }
                                i14 = 3;
                                f12.C = i14;
                                if (v11) {
                                }
                                z16 = z14;
                                aVar2 = n10;
                                arrayList2 = arrayList4;
                                z15 = z13;
                                if (zl.a.f37626a) {
                                }
                                arrayList5.add(f12);
                                if (s10) {
                                }
                                i11 = 1;
                                if (v11) {
                                }
                                arrayList6.add(f12);
                                arrayList3 = arrayList2;
                                arrayList3.add(next);
                                arrayList4 = arrayList3;
                                z14 = z16;
                                z13 = z15;
                                n10 = aVar2;
                            }
                        }
                        it2 = it;
                    }
                    aVar = n10;
                    arrayList = arrayList4;
                } else {
                    aVar = n10;
                    arrayList = arrayList4;
                    z14 = false;
                    z13 = false;
                }
                Collections.sort(arrayList5, new a());
                if (v11 && (z13 || z14)) {
                    ArrayList arrayList7 = new ArrayList();
                    ArrayList arrayList8 = new ArrayList();
                    ArrayList arrayList9 = new ArrayList();
                    if (arrayList6.size() > 0) {
                        for (wl.a aVar3 : arrayList6) {
                            int w11 = aVar3.w();
                            if (w11 != 513) {
                                if (w11 != 517) {
                                    if (!(w11 == 519 || w11 == 768)) {
                                    }
                                } else if (z13) {
                                    arrayList7.add(aVar3);
                                }
                                arrayList9.add(aVar3);
                            } else if (z13) {
                                arrayList7.add(aVar3);
                            } else if (z14) {
                                arrayList8.add(aVar3);
                            } else {
                                arrayList9.add(aVar3);
                            }
                        }
                    }
                    arrayList6 = new ArrayList();
                    if (arrayList7.size() == 2) {
                        arrayList6.addAll(arrayList7);
                    }
                    if (arrayList8.size() == 3) {
                        arrayList6.addAll(arrayList8);
                    }
                    if (arrayList9.size() > 0) {
                        arrayList6.addAll(arrayList9);
                    }
                }
                Collections.sort(arrayList6, new C0289b());
                try {
                    aVar.close();
                } catch (IOException e11) {
                    il.b.l(e11.toString());
                }
            } else {
                il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                a10.f5986i = false;
                i12 = 4101;
            }
            a10.f5985h = i12;
            return a10;
        }
        arrayList = arrayList4;
        try {
            wl.a l10 = zl.a.l(a10.f5983f, d10, 0L);
            if (l10 != null) {
                arrayList5.add(l10);
                a10.f5983f = l10.I();
                a10.f5984g = l10.T();
                if (cVar.u()) {
                    int w12 = l10.w();
                    if (w12 == 517) {
                        throw new LoadFileException("PRE_SYSTEM not support single", LoadFileException.ERROR_PACK_INCORRECT_FORMAT);
                    } else if (w12 != 519) {
                        switch (w12) {
                            case 61441:
                            case 61442:
                            case 61443:
                            case 61444:
                            case 61445:
                            case 61446:
                            case 61447:
                            case 61448:
                                if (l10.f36308h != 255) {
                                    break;
                                } else {
                                    throw new LoadFileException(String.format("USER_DATA(0x%04X) not support RTK OTA policy", Integer.valueOf(l10.w())), LoadFileException.ERROR_PACK_INCORRECT_FORMAT);
                                }
                        }
                        l10.C = 0;
                    } else {
                        throw new LoadFileException("PRE_UPPER_STACK not support single", LoadFileException.ERROR_PACK_INCORRECT_FORMAT);
                    }
                }
                if (!q5 || zl.a.c(a10.f5983f, h10)) {
                    if (v11) {
                        i10 = 1;
                        if (1 != zl.a.f(l10, f10)) {
                            z10 = true;
                            a10.f5990m = arrayList5;
                            a10.f5993p = arrayList6;
                            a10.f5992o = arrayList;
                            if (v11 && z10 && arrayList6.size() <= 0) {
                                a10.f5986i = false;
                                a10.f5985h = LoadFileException.ERROR_VERSION_CHECK_LOW;
                            }
                            return a10;
                        }
                    } else {
                        i10 = 1;
                    }
                    if (s10) {
                    }
                    arrayList6.add(l10);
                } else {
                    il.b.l(String.format("ic conflict: 0x%02X, 0x%02X", Integer.valueOf(h10), Integer.valueOf(a10.f5983f)));
                    a10.f5986i = false;
                    a10.f5985h = 4101;
                    return a10;
                }
            }
        } catch (IOException e12) {
            throw new LoadFileException(e12.getMessage(), 4097);
        }
        z10 = false;
        a10.f5990m = arrayList5;
        a10.f5993p = arrayList6;
        a10.f5992o = arrayList;
        if (v11) {
            a10.f5986i = false;
            a10.f5985h = LoadFileException.ERROR_VERSION_CHECK_LOW;
        }
        return a10;
    }
}
