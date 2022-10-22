package com.huawei.hms.scankit;

import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.D;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.m;
import com.huawei.hms.scankit.aiscan.common.o;
import com.huawei.hms.scankit.aiscan.common.r;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.aiscan.common.z;
import com.huawei.hms.scankit.p.C0587g;
import com.huawei.hms.scankit.p.C0595i;
import com.huawei.hms.scankit.p.C0602k;
import com.huawei.hms.scankit.p.C0605l;
import com.huawei.hms.scankit.p.C0634v;
import com.huawei.hms.scankit.p.C0637w;
import com.huawei.hms.scankit.p.Ha;
import com.huawei.hms.scankit.p.Ka;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* compiled from: DecodeProcessor.java */
/* loaded from: classes2.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private m f14404a;

    /* renamed from: b  reason: collision with root package name */
    private C0587g f14405b;

    /* renamed from: c  reason: collision with root package name */
    private C0587g f14406c;

    /* renamed from: d  reason: collision with root package name */
    private C0587g f14407d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f14408e = false;

    /* renamed from: f  reason: collision with root package name */
    private float f14409f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private float f14410g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    private float f14411h = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    private float f14413j = 1.778f;

    /* renamed from: k  reason: collision with root package name */
    private int f14414k = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f14415l = 0;

    /* renamed from: i  reason: collision with root package name */
    public com.huawei.hms.scankit.aiscan.common.l f14412i = new com.huawei.hms.scankit.aiscan.common.l();

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(m mVar) {
        this.f14404a = mVar;
        this.f14405b = new C0587g(new C0602k(this.f14404a));
        this.f14406c = new C0587g(new C0605l(this.f14404a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x a(List<C0634v> list, l lVar) {
        for (C0634v vVar : list) {
            if (Ka.f14564b || vVar.h() > 0.4d) {
                int j10 = (int) vVar.j();
                int k10 = (int) vVar.k();
                if (j10 > lVar.f14404a.c() / 3 && j10 < (lVar.f14404a.c() * 2) / 3 && k10 > lVar.f14404a.a() / 3 && k10 < (lVar.f14404a.a() * 2) / 3) {
                    float a10 = lVar.a(lVar.f14407d);
                    x xVar = new x(1.0f);
                    xVar.a(a10);
                    xVar.a(vVar);
                    return xVar;
                }
            }
        }
        return null;
    }

    public x b(List<BarcodeFormat> list, C0634v vVar) {
        x xVar;
        o oVar = new o();
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0553d.POSSIBLE_FORMATS, list);
        try {
            if (vVar != null) {
                xVar = oVar.a(this.f14405b, this.f14406c, this.f14407d, hashMap, this.f14412i, vVar);
            } else {
                xVar = oVar.a(this.f14405b, this.f14406c, null, hashMap, this.f14412i, null);
            }
            try {
                if (Ka.f14565c || xVar == null || xVar.g() != null || xVar.f() == null || xVar.f().length < 3) {
                    return xVar;
                }
                float b10 = H.b(this.f14404a.c(), this.f14404a.a(), xVar.f());
                if (Math.abs(1.0f - b10) <= 0.001d) {
                    return xVar;
                }
                this.f14411h = b10;
                this.f14408e = true;
                return xVar;
            } catch (C0550a unused) {
                return xVar;
            }
        } catch (C0550a unused2) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00eb A[Catch: a -> 0x00f3, TRY_ENTER, TRY_LEAVE, TryCatch #3 {a -> 0x00f3, blocks: (B:10:0x0037, B:15:0x0055, B:17:0x0063, B:23:0x007d, B:25:0x0088, B:28:0x0091, B:29:0x0096, B:35:0x00eb), top: B:53:0x0037 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public x c(List<BarcodeFormat> list, C0634v vVar) {
        C0587g gVar;
        float f10;
        x xVar;
        int i10;
        o oVar = new o();
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0553d.POSSIBLE_FORMATS, list);
        float f11 = 1.0f;
        x xVar2 = null;
        try {
            if (vVar != null) {
                if (this.f14407d != null) {
                    f10 = Math.min(gVar.e(), this.f14407d.c()) / 800.0f;
                    if (f10 < 1.25f) {
                        f10 = 1.0f;
                    }
                    try {
                        C0587g h10 = this.f14412i.h(this.f14407d, f10);
                        try {
                            try {
                                xVar = oVar.a(h10, hashMap);
                            } catch (C0550a unused) {
                                float i11 = (vVar.i() + 180.0f) % 90.0f;
                                if (Ka.f14565c || vVar.h() <= 0.8d || (i11 >= 3.0f && i11 <= 87.0f)) {
                                    xVar = xVar2;
                                } else {
                                    m c10 = h10.a().c();
                                    float f12 = 0.0f;
                                    if (i10 < 0) {
                                        f12 = i11 * (-2.0f);
                                    } else if (i11 > 87.0f) {
                                        f12 = (90.0f - i11) * 2.0f;
                                    }
                                    xVar = oVar.a(new C0587g(new C0605l(new r(LoadOpencvJNIUtil.imageRotate(c10.b(), c10.a(), c10.c(), c10.a(), c10.c(), f12, 1.0d), c10.c(), c10.a(), 0, 0, c10.c(), c10.a(), false))), hashMap);
                                }
                                xVar2 = xVar;
                                if (xVar2 != null) {
                                }
                                f11 = f10;
                                return a(xVar2, f11, 0, 0);
                            }
                        } catch (C0550a unused2) {
                            if (Ka.f14574l) {
                                xVar2 = oVar.a(this.f14412i.g(this.f14407d, f10), hashMap);
                            }
                            float i112 = (vVar.i() + 180.0f) % 90.0f;
                            if (Ka.f14565c) {
                            }
                            xVar = xVar2;
                            xVar2 = xVar;
                            if (xVar2 != null) {
                            }
                            f11 = f10;
                            return a(xVar2, f11, 0, 0);
                        }
                        xVar2 = xVar;
                    } catch (C0550a unused3) {
                    }
                } else {
                    xVar2 = oVar.a(this.f14405b, hashMap);
                    f10 = 1.0f;
                }
                if (xVar2 != null) {
                    C0637w.a(xVar2.f(), f10, vVar);
                }
                f11 = f10;
            } else {
                int min = Math.min(this.f14405b.e(), this.f14405b.c());
                if (min > 1080) {
                    float f13 = min / 1080.0f;
                    if (f13 >= 1.25f) {
                        f11 = f13;
                    }
                }
                try {
                    xVar2 = oVar.a(this.f14412i.a(this.f14405b, f11), hashMap);
                } catch (C0550a unused4) {
                    xVar2 = oVar.a(this.f14412i.b(this.f14406c, f11), hashMap);
                }
            }
        } catch (C0550a unused5) {
        }
        return a(xVar2, f11, 0, 0);
    }

    public x d(List<BarcodeFormat> list, C0634v vVar) {
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0553d.POSSIBLE_FORMATS, list);
        if (vVar != null) {
            x a10 = a(hashMap, vVar);
            if (a10 != null && a10.g() == null && Ka.f14573k) {
                Ka.f14570h = true;
                a10 = f(list, vVar);
                Ka.f14570h = false;
            }
            if (a10 != null && a10.g() == null && Ka.f14574l) {
                Ka.f14571i = true;
                a10 = a(hashMap, vVar);
                Ka.f14571i = false;
            }
            if ((a10 != null && a10.g() != null) || !Ka.f14575m) {
                return a10;
            }
            Ka.f14572j = true;
            x a11 = a(hashMap, vVar);
            Ka.f14572j = false;
            return a11;
        }
        x a12 = a(hashMap);
        if (a12 != null && a12.g() == null && Ka.f14574l) {
            Ka.f14570h = true;
            a12 = a(hashMap);
            Ka.f14570h = false;
        }
        x xVar = a12;
        if (xVar == null || xVar.g() != null || !Ka.f14575m) {
            return xVar;
        }
        Ka.f14571i = true;
        x a13 = a(hashMap);
        Ka.f14571i = false;
        return a13;
    }

    public x e(List<BarcodeFormat> list, C0634v vVar) {
        m mVar;
        float f10;
        C0587g gVar;
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0553d.POSSIBLE_FORMATS, list);
        try {
            if (vVar != null) {
                mVar = this.f14407d.a().c();
            } else {
                mVar = this.f14404a;
            }
            if (!Ka.f14563a || (this.f14405b.e() <= 800 && this.f14405b.c() <= 800)) {
                f10 = 1.0f;
            } else {
                f10 = (this.f14405b.e() > this.f14405b.c() ? this.f14405b.e() : this.f14405b.c()) / 800.0f;
                mVar = this.f14412i.h(new C0587g(new C0602k(mVar)), f10).a().c();
            }
            m mVar2 = mVar;
            float f11 = f10;
            if (mVar2 != null) {
                if (!Ka.f14563a || Ka.f14564b) {
                    gVar = new C0587g(new C0602k(mVar2));
                } else {
                    C0595i a10 = a(mVar2.b(), mVar2.c(), mVar2.a());
                    gVar = new C0587g(new C0602k(mVar2));
                    gVar.a(a10);
                }
                o oVar = new o();
                try {
                    x a11 = oVar.a(gVar, hashMap);
                    if (a11 == null || a11.g() == null) {
                        throw C0550a.a();
                    }
                    C0637w.a(a11.f(), f11, vVar);
                    return a11;
                } catch (C0550a unused) {
                    return a(oVar, mVar2, gVar, hashMap, f11, vVar);
                }
            } else {
                throw C0550a.a();
            }
        } catch (C0550a unused2) {
            return null;
        }
    }

    public x f(List<BarcodeFormat> list, C0634v vVar) {
        C0587g gVar;
        C0587g gVar2;
        o oVar = new o();
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0553d.POSSIBLE_FORMATS, list);
        float f10 = 1.0f;
        if (vVar == null) {
            if (!Ka.f14563a || (this.f14405b.e() <= 500 && this.f14405b.c() <= 500)) {
                gVar = this.f14405b;
            } else {
                f10 = (this.f14405b.e() > this.f14405b.c() ? this.f14405b.e() : this.f14405b.c()) / 500.0f;
                gVar = this.f14412i.c(this.f14405b, f10);
            }
        } else if (!Ka.f14563a || (gVar2 = this.f14407d) == null || (gVar2.e() <= 500 && this.f14407d.c() <= 500)) {
            gVar = this.f14407d;
        } else {
            f10 = (this.f14407d.e() > this.f14407d.c() ? this.f14407d.e() : this.f14407d.c()) / 500.0f;
            gVar = this.f14412i.g(this.f14407d, f10);
        }
        try {
            x a10 = oVar.a(gVar, hashMap);
            if (a10 == null) {
                return a10;
            }
            try {
                if (a10.g() == null) {
                    return a10;
                }
                C0637w.a(a10.f(), f10, vVar);
                return a10;
            } catch (C0550a unused) {
                return a10;
            }
        } catch (C0550a unused2) {
            return null;
        }
    }

    private C0587g b(C0587g gVar) {
        int e10 = gVar.e();
        int c10 = gVar.c();
        int i10 = (int) (e10 * 0.75d);
        int i11 = (int) (c10 * 0.75d);
        int i12 = (e10 - i10) / 2;
        this.f14414k += i12;
        int i13 = (c10 - i11) / 2;
        this.f14415l += i13;
        return gVar.a(i12, i13, i10, i11);
    }

    public x a(Map<EnumC0553d, Object> map, C0634v vVar) {
        float f10;
        C0587g gVar;
        x xVar;
        x xVar2;
        C0587g gVar2;
        o oVar = new o();
        C0587g gVar3 = this.f14407d;
        if (gVar3 == null) {
            return null;
        }
        Ka.f14566d = true;
        int e10 = gVar3.e() > this.f14407d.c() ? this.f14407d.e() : this.f14407d.c();
        if (!Ka.f14563a || e10 <= 500) {
            gVar = this.f14407d;
            f10 = 1.0f;
        } else {
            float f11 = e10 / 500.0f;
            if (f11 < 1.0f) {
                f11 = 1.0f;
            }
            gVar = this.f14412i.g(this.f14407d, f11);
            f10 = f11;
        }
        try {
            if (Ka.f14572j) {
                gVar = new C0587g(new C0602k(C.a(gVar.a().c())));
            }
            x a10 = oVar.a(gVar, map);
            if (a10 != null) {
                try {
                    if (a10.g() == null && a10.f() != null && a10.f().length >= 3) {
                        xVar = new x(null, null, a10.f(), BarcodeFormat.QR_CODE);
                        try {
                            a10 = a(gVar, map, a10, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d});
                        } catch (C0550a unused) {
                            gVar2 = gVar;
                            xVar2 = a10;
                            x a11 = a(gVar2, xVar2, xVar, oVar, map, f10, vVar);
                            if ((a11 == null || a11.g() == null) && !Ka.f14565c && a11 != null && a11.f() != null && a11.f().length >= 3) {
                                C0637w.a(a11.f(), f10, vVar);
                                float a12 = H.a(this.f14404a.c(), this.f14404a.a(), a11.f());
                                if (Math.abs(1.0f - a12) > 0.001d) {
                                    this.f14409f = a12;
                                    this.f14408e = true;
                                }
                            }
                            return a11;
                        }
                    }
                } catch (C0550a unused2) {
                    xVar = null;
                }
            }
            if (a10 == null || a10.g() == null) {
                throw C0550a.a();
            }
            C0637w.a(a10.f(), f10, vVar);
            return a10;
        } catch (C0550a unused3) {
            xVar = null;
            gVar2 = gVar;
            xVar2 = null;
        }
    }

    private void b(List<C0634v> list) {
        for (C0634v vVar : list) {
            vVar.a(this.f14404a.c(), this.f14404a.a(), this.f14414k, this.f14415l);
            float min = Math.min(Math.abs(vVar.i() % 90.0f), 90.0f - Math.abs(vVar.i() % 90.0f));
            if (vVar.c() * vVar.f() > this.f14404a.a() * 0.9f * this.f14404a.c() && min < 5.0f) {
                vVar.b(this.f14404a.c(), this.f14404a.a());
            }
        }
    }

    public float b() {
        return this.f14409f;
    }

    public float d() {
        return this.f14410g;
    }

    private C0587g c(C0587g gVar) {
        int e10 = gVar.e();
        int c10 = gVar.c();
        if (e10 < c10) {
            if (c10 / e10 <= 1.2d) {
                return gVar;
            }
            int i10 = (int) (e10 * 1.2d);
            int i11 = (c10 - i10) / 2;
            this.f14415l = i11;
            return gVar.a(0, i11, e10, i10);
        } else if (e10 / c10 <= 1.2d) {
            return gVar;
        } else {
            int i12 = (int) (c10 * 1.2d);
            int i13 = (e10 - i12) / 2;
            this.f14414k = i13;
            return gVar.a(i13, 0, i12, c10);
        }
    }

    public float c() {
        return this.f14411h;
    }

    private x a(C0587g gVar, x xVar, x xVar2, o oVar, Map<EnumC0553d, Object> map, float f10, C0634v vVar) {
        try {
            if (Ka.f14563a) {
                gVar.a(a(gVar.d(), gVar.e(), gVar.c()));
                xVar = oVar.a(gVar, map);
                if (xVar != null && xVar.g() == null && xVar.f() != null && xVar.f().length >= 3) {
                    x xVar3 = new x(null, null, xVar.f(), BarcodeFormat.QR_CODE);
                    try {
                        xVar = a(gVar, map, xVar, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d});
                    } catch (C0550a unused) {
                        xVar2 = xVar3;
                        if (xVar == null && (Ka.f14581s || (!Ka.f14565c && Ka.f14574l))) {
                            try {
                                gVar.a(gVar.b().c());
                                x a10 = oVar.a(gVar, map);
                                if (!(a10 == null || a10.g() == null)) {
                                    C0637w.a(a10.f(), f10, vVar);
                                    return a10;
                                }
                            } catch (C0550a unused2) {
                            }
                        }
                        return xVar2;
                    }
                }
                if (!(xVar == null || xVar.g() == null)) {
                    C0637w.a(xVar.f(), f10, vVar);
                    return xVar;
                }
            }
            throw C0550a.a();
        } catch (C0550a unused3) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public x a(Map<EnumC0553d, Object> map) {
        float f10;
        m mVar;
        x xVar;
        x xVar2;
        float a10;
        x a11;
        o oVar = new o();
        m mVar2 = this.f14404a;
        if (!Ka.f14563a || (this.f14405b.e() <= 800 && this.f14405b.c() <= 800)) {
            mVar = mVar2;
            f10 = 1.0f;
        } else {
            float max = Math.max(this.f14405b.e(), this.f14405b.c()) / 800.0f;
            if (Ka.f14565c && (this.f14405b.e() > this.f14405b.c() * this.f14413j || this.f14405b.c() > this.f14405b.e() * this.f14413j)) {
                max = Math.min(this.f14405b.e(), this.f14405b.c()) / 860.0f;
            }
            mVar = this.f14412i.d(this.f14405b, max).a().c();
            f10 = max;
        }
        if (mVar == null) {
            return null;
        }
        C0587g gVar = new C0587g(new C0602k(mVar));
        Ha.a(this.f14404a);
        try {
            if (Ka.f14563a) {
                gVar.a(a(mVar.b(), mVar.c(), mVar.a()));
            }
            a11 = oVar.a(gVar, map);
        } catch (C0550a unused) {
        }
        if (a11 != null && a11.g() != null) {
            return a(a11, f10, 0, 0);
        }
        if (!(a11 == null || a11.f() == null || a11.f().length < 3)) {
            xVar = new x(null, null, a11.f(), BarcodeFormat.QR_CODE);
            xVar2 = xVar != null ? new x(null, null, null, BarcodeFormat.QR_CODE) : xVar;
            if (Ka.f14565c) {
                xVar2 = a(oVar, mVar, xVar2, map, f10, 0, 0);
            }
            if (xVar2 == null && xVar2.g() != null) {
                return xVar2;
            }
            if (!(xVar2 == null || xVar2.f() == null)) {
                xVar = xVar2;
            }
            if (!Ka.f14565c && xVar != null && xVar.f() != null && xVar.f().length >= 3) {
                a(xVar, f10, 0, 0);
                a10 = H.a(this.f14404a.c(), this.f14404a.a(), xVar.f());
                if (Math.abs(1.0f - a10) > 0.001d) {
                    this.f14409f = a10;
                    this.f14408e = true;
                }
            }
            return xVar;
        }
        xVar = null;
        if (xVar != null) {
        }
        if (Ka.f14565c) {
        }
        if (xVar2 == null) {
        }
        if (xVar2 == null) {
            xVar = xVar2;
        }
        if (!Ka.f14565c) {
            a(xVar, f10, 0, 0);
            a10 = H.a(this.f14404a.c(), this.f14404a.a(), xVar.f());
            if (Math.abs(1.0f - a10) > 0.001d) {
            }
        }
        return xVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private x a(o oVar, m mVar, x xVar, Map<EnumC0553d, Object> map, float f10, int i10, int i11) {
        C0587g gVar;
        x a10;
        x a11;
        if (!Ka.f14563a) {
            return null;
        }
        try {
            gVar = new C0587g(new C0602k(mVar));
            try {
                a11 = oVar.a(gVar, map);
            } catch (C0550a unused) {
            }
        } catch (C0550a unused2) {
            gVar = null;
            if (xVar != null) {
            }
            return a(gVar, oVar, mVar, xVar, map, f10);
        }
        if (a11 != null && a11.g() != null) {
            return a(a11, f10, i10, i11);
        }
        if (!(a11 == null || a11.f() == null || a11.f().length < 3)) {
            xVar.b(a11.f());
        }
        if (xVar != null) {
            try {
                if (!(xVar.f() == null || xVar.f().length < 3 || Ka.f14570h || (a10 = a(gVar, map, xVar, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d})) == null || a10.g() == null)) {
                    return a(a10, f10, i10, i11);
                }
            } catch (C0550a unused3) {
            }
        }
        return a(gVar, oVar, mVar, xVar, map, f10);
    }

    private x a(C0587g gVar, o oVar, m mVar, x xVar, Map<EnumC0553d, Object> map, float f10) {
        x xVar2 = null;
        try {
            Ha.a(this.f14404a, xVar);
            if (Ka.f14565c && Ka.f14579q[1]) {
                Ka.f14576n = true;
                xVar2 = oVar.a(this.f14405b, map);
                Ka.f14576n = false;
                if (!(xVar2 == null || xVar2.g() == null)) {
                    return a(xVar2, f10, 0, 0);
                }
            }
        } catch (C0550a unused) {
            Ka.f14576n = false;
        }
        float e10 = gVar.e() / gVar.c();
        if (e10 < 1.0f) {
            e10 = 1.0f / e10;
        }
        if (!Ka.f14570h && !Ka.f14571i) {
            double d10 = e10;
            if (d10 > 1.27d && d10 < 1.272d) {
                Ka.f14578p = true;
                try {
                    x a10 = oVar.a(new C0587g(new C0605l(mVar)), map);
                    if (a10 != null) {
                        try {
                            if (a10.g() != null) {
                                return a(a10, f10, 0, 0);
                            }
                        } catch (C0550a unused2) {
                        }
                    }
                    xVar2 = a10;
                } catch (C0550a unused3) {
                }
                Ka.f14578p = false;
            }
        }
        return xVar2;
    }

    private x a(o oVar, m mVar, C0587g gVar, Map<EnumC0553d, Object> map, float f10, C0634v vVar) throws C0550a {
        x xVar = null;
        if (Ka.f14563a && !Ka.f14564b) {
            try {
                C0587g gVar2 = new C0587g(new C0602k(mVar));
                try {
                    xVar = oVar.a(gVar2, map);
                    if (!(xVar == null || xVar.g() == null)) {
                        C0637w.a(xVar.f(), f10, vVar);
                        return xVar;
                    }
                } catch (C0550a unused) {
                }
                gVar = gVar2;
            } catch (C0550a unused2) {
            }
            if (!(xVar == null || xVar.f() == null || xVar.f().length < 3)) {
                try {
                    xVar = a(gVar, map, xVar, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d});
                    if (!(xVar == null || xVar.g() == null)) {
                        C0637w.a(xVar.f(), f10, vVar);
                        return xVar;
                    }
                } catch (C0550a unused3) {
                }
            }
        }
        C0587g gVar3 = new C0587g(new C0605l(mVar));
        try {
            x a10 = oVar.a(gVar3, map);
            if (a10 == null || a10.g() == null) {
                throw C0550a.a();
            }
            C0637w.a(a10.f(), f10, vVar);
            return a10;
        } catch (C0550a unused4) {
            if (!(!Ka.f14563a || Ka.f14564b || xVar == null || xVar.f() == null || xVar.f().length < 3 || (xVar = a(gVar3, map, xVar, new double[]{0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 1.0d})) == null || xVar.g() == null)) {
                C0637w.a(xVar.f(), f10, vVar);
            }
            return xVar;
        }
    }

    public x a(List<BarcodeFormat> list, C0634v vVar) {
        o oVar = new o();
        HashMap hashMap = new HashMap();
        hashMap.put(EnumC0553d.POSSIBLE_FORMATS, list);
        if (Ka.f14565c) {
            hashMap.put(EnumC0553d.PHOTO_MODE, Boolean.valueOf(Ka.f14565c));
        }
        x xVar = null;
        try {
            if (vVar != null) {
                xVar = oVar.a(this.f14405b, this.f14407d, hashMap, this.f14412i, vVar);
            } else {
                xVar = oVar.a(this.f14405b, (C0587g) null, hashMap, this.f14412i, (C0634v) null);
            }
        } catch (C0550a unused) {
        }
        if (xVar != null || Ka.f14564b || vVar == null || !Ka.f14565c || vVar.h() >= 0.8d) {
            return xVar;
        }
        float i10 = vVar.i() % 180.0f;
        boolean z10 = true;
        boolean z11 = ((double) vVar.c()) > ((double) this.f14405b.c()) * 0.97d && ((i10 < 5.0f && i10 > -5.0f) || i10 < -175.0f || i10 > 175.0f);
        if (vVar.b() <= this.f14405b.e() * 0.97d || ((i10 >= 95.0f || i10 <= 85.0f) && (i10 >= -85.0f || i10 <= -95.0f))) {
            z10 = false;
        }
        if (!z11 && !z10) {
            return xVar;
        }
        this.f14412i.a();
        try {
            return oVar.a(this.f14405b, (C0587g) null, hashMap, this.f14412i, (C0634v) null);
        } catch (C0550a unused2) {
            return xVar;
        }
    }

    public List<C0634v> a(int i10, boolean z10) {
        List<C0634v> list;
        float a10;
        C0587g gVar;
        ArrayList arrayList = new ArrayList();
        if (!Ka.f14563a) {
            return arrayList;
        }
        boolean z11 = Ka.f14564b;
        if (!z11) {
            byte[] c10 = z.c();
            float[] d10 = z.d();
            int a11 = z.a();
            byte[] b10 = z.b();
            LoadOpencvJNIUtil.setModel(c10, c10.length, d10, a11, b10, b10.length);
            C0587g gVar2 = this.f14405b;
            long currentTimeMillis = System.currentTimeMillis() % 10;
            boolean z12 = true;
            boolean z13 = currentTimeMillis % 2 == 0;
            if (currentTimeMillis % 3 != 0) {
                z12 = false;
            }
            if (i10 == 0 && !Ka.f14565c && z13) {
                gVar2 = c(this.f14405b);
            } else if (i10 != 0 || Ka.f14565c || !z12) {
                if (this.f14404a.a() / this.f14404a.c() > 1.35d) {
                    int a12 = (int) (this.f14404a.a() / 1.3f);
                    this.f14415l = 0;
                    this.f14414k = (-(a12 - this.f14404a.c())) / 2;
                    m mVar = this.f14404a;
                    gVar = new C0587g(new C0602k(mVar.b(a12, mVar.a(), -this.f14414k, -this.f14415l)));
                } else if (1.0f / a10 > 1.35d) {
                    int c11 = (int) (this.f14404a.c() / 1.3f);
                    this.f14415l = (-(c11 - this.f14404a.a())) / 2;
                    this.f14414k = 0;
                    m mVar2 = this.f14404a;
                    gVar = new C0587g(new C0602k(mVar2.b(mVar2.c(), c11, -this.f14414k, -this.f14415l)));
                }
                gVar2 = gVar;
            } else {
                gVar2 = b(c(this.f14405b));
            }
            list = C0637w.a(Ka.f14564b, gVar2, i10, z10);
        } else {
            list = C0637w.a(z11, this.f14405b, i10, z10);
        }
        List<C0634v> list2 = list;
        b(list2);
        return list2;
    }

    public void a(C0634v vVar) {
        try {
            if (Ka.f14563a) {
                C0637w.a(Ka.f14564b, this.f14405b, vVar);
                this.f14407d = vVar.f14980l;
            }
        } catch (C0550a unused) {
        }
    }

    private x a(C0587g gVar, Map<EnumC0553d, Object> map, x xVar, double[] dArr) throws C0550a {
        x xVar2;
        if (gVar == null) {
            return null;
        }
        o oVar = new o();
        int[] iArr = {0, 0};
        r rVar = new r(D.a(gVar, map, xVar, iArr, dArr), iArr[0], iArr[1], 0, 0, iArr[0], iArr[1], false);
        try {
            xVar2 = oVar.a(new C0587g(new C0602k(rVar)), map);
            if (xVar2 != null) {
                try {
                    if (xVar2.g() != null) {
                        z[] a10 = D.a(xVar2.f(), gVar.e(), gVar.c(), dArr);
                        xVar2.a();
                        xVar2.b(a10);
                        return xVar2;
                    }
                } catch (C0550a unused) {
                    C0587g gVar2 = new C0587g(new C0605l(rVar));
                    try {
                        x a11 = oVar.a(gVar2, map);
                        if (a11 == null || a11.g() == null) {
                            throw C0550a.a();
                        }
                        z[] a12 = D.a(a11.f(), gVar.e(), gVar.c(), dArr);
                        a11.a();
                        a11.b(a12);
                        return a11;
                    } catch (C0550a unused2) {
                        gVar2.a(a(rVar.b(), rVar.c(), rVar.a()));
                        try {
                            x a13 = oVar.a(gVar2, map);
                            if (a13 == null || a13.g() == null) {
                                throw C0550a.a();
                            }
                            z[] a14 = D.a(a13.f(), gVar.e(), gVar.c(), dArr);
                            a13.a();
                            a13.b(a14);
                            return a13;
                        } catch (C0550a unused3) {
                            return xVar2;
                        }
                    }
                }
            }
            throw C0550a.a();
        } catch (C0550a unused4) {
            xVar2 = xVar;
        }
    }

    private x a(x xVar, float f10, int i10, int i11) {
        if (!(xVar == null || xVar.f().length != 4 || (f10 == 1.0f && i10 == 0 && i11 == 0))) {
            z[] zVarArr = new z[4];
            for (int i12 = 0; i12 < 4; i12++) {
                zVarArr[i12] = new z((xVar.f()[i12].b() * f10) + i10, (xVar.f()[i12].c() * f10) + i11);
            }
            xVar.a();
            xVar.a(zVarArr);
        }
        return xVar;
    }

    public static C0595i a(byte[] bArr, int i10, int i11) throws C0550a {
        byte[] adaptivebinary = LoadOpencvJNIUtil.adaptivebinary(bArr, i11, i10, 45);
        if (adaptivebinary != null) {
            C0595i iVar = new C0595i(i10, i11);
            for (int i12 = 0; i12 < i11; i12++) {
                for (int i13 = 0; i13 < i10; i13++) {
                    if (adaptivebinary[(i12 * i10) + i13] == 0) {
                        iVar.c(i13, i12);
                    }
                }
            }
            return iVar;
        }
        throw C0550a.a();
    }

    public float a(C0587g gVar) {
        byte[] b10 = (gVar == null || (gVar.a() == null && gVar.a().c() == null)) ? null : gVar.a().c().b();
        if (b10 == null) {
            return 1.0f;
        }
        long j10 = 0;
        int e10 = gVar.e();
        int c10 = gVar.c();
        for (int i10 = c10 / 4; i10 < (c10 * 3) / 4; i10++) {
            for (int i11 = e10 / 4; i11 < (e10 * 3) / 4; i11++) {
                j10 += b10[(i10 * e10) + i11] & 255;
            }
        }
        return (float) ((j10 / b10.length) * 4);
    }

    public boolean a() {
        return this.f14408e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
        if (a(r11.f14405b, r0) != false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
        r1 = com.huawei.hms.scankit.p.Ka.f14569g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
        if (r1 <= 4) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0088, code lost:
        com.huawei.hms.scankit.p.Ka.f14569g = r1 + 2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(List<C0634v> list) {
        Iterator<C0634v> it = list.iterator();
        while (it.hasNext()) {
            C0634v next = it.next();
            boolean z10 = next.g() == 1.0f && ((double) next.h()) > 0.7d;
            boolean z11 = next.g() == 1.0f && ((double) next.h()) > 0.4d;
            boolean z12 = next.g() == 2.0f && ((double) next.h()) > 0.7d;
            boolean z13 = next.g() == 3.0f && ((double) next.h()) > 0.7d;
            if (z11 || z12 || z13) {
                Ka.f14569g = 0;
                float b10 = H.b(this.f14404a.c(), this.f14404a.a(), new z[]{new z(next.d(), next.e()), new z(next.d() + next.f(), next.e()), new z(next.d(), next.e() + next.c())});
                if (b10 > 1.001f) {
                    this.f14410g = b10;
                    this.f14408e = true;
                }
            }
        }
        return this.f14408e;
    }

    private static boolean a(C0587g gVar, C0634v vVar) {
        if (Ka.f14563a && !Ka.f14564b) {
            float d10 = vVar.d();
            float e10 = vVar.e();
            float f10 = vVar.f();
            float c10 = vVar.c();
            float f11 = d10 - ((f10 * 0.2f) / 2.0f);
            float f12 = 0.0f;
            if (f11 < 0.0f) {
                f11 = 0.0f;
            }
            float f13 = e10 - ((0.2f * c10) / 2.0f);
            if (f13 >= 0.0f) {
                f12 = f13;
            }
            float f14 = (f10 * 1.2f) + f11;
            if (f14 > gVar.e()) {
                f14 = gVar.e();
            }
            float f15 = (c10 * 1.2f) + f12;
            if (f15 > gVar.c()) {
                f15 = gVar.c();
            }
            float f16 = f14 - f11;
            float f17 = f15 - f12;
            if (f16 < gVar.e() / 2.0f && f17 < gVar.c() / 2.0f) {
                for (C0634v vVar2 : C0637w.a(Ka.f14564b, gVar.a((int) f11, (int) f12, (int) f16, (int) f17), 0, true)) {
                    boolean z10 = vVar2.g() == 1.0f && ((double) vVar2.h()) > 0.5d;
                    boolean z11 = vVar.g() == 2.0f && vVar2.g() == 2.0f && ((double) vVar2.h()) > 0.7d;
                    boolean z12 = vVar.g() == 3.0f && vVar2.g() == 3.0f && ((double) vVar2.h()) > 0.7d;
                    if (z10 || z11) {
                        return true;
                    }
                    if (z12) {
                        return true;
                    }
                }
                return false;
            }
        }
        return true;
    }
}
