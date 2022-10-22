package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* compiled from: ParticleSystem.java */
/* loaded from: classes2.dex */
public class Bc {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f14453a = new Object();

    /* renamed from: d  reason: collision with root package name */
    private int f14456d;

    /* renamed from: e  reason: collision with root package name */
    private long f14457e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14458f;

    /* renamed from: g  reason: collision with root package name */
    private float f14459g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f14460h;

    /* renamed from: i  reason: collision with root package name */
    private int f14461i;

    /* renamed from: j  reason: collision with root package name */
    private int f14462j;

    /* renamed from: k  reason: collision with root package name */
    private int f14463k;

    /* renamed from: l  reason: collision with root package name */
    private int f14464l;

    /* renamed from: m  reason: collision with root package name */
    private int f14465m;

    /* renamed from: o  reason: collision with root package name */
    private Path f14467o;

    /* renamed from: p  reason: collision with root package name */
    private PathMeasure f14468p;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<zc> f14454b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<zc> f14455c = new ArrayList<>();

    /* renamed from: n  reason: collision with root package name */
    private boolean f14466n = false;

    /* renamed from: q  reason: collision with root package name */
    private Ec f14469q = new Ec();

    /* renamed from: r  reason: collision with root package name */
    private Gc f14470r = new Gc();

    public Bc(int i10, long j10) {
        a(i10, j10);
        a((Bitmap) null);
    }

    private void b(long j10) {
        PathMeasure pathMeasure;
        zc remove = this.f14454b.remove(0);
        this.f14470r.a(remove);
        if (!this.f14466n || (pathMeasure = this.f14468p) == null) {
            remove.a(this.f14457e, a(this.f14463k, this.f14462j), a(this.f14465m, this.f14464l), j10, this.f14469q);
        } else {
            float[] b10 = b(0.0f, pathMeasure.getLength());
            remove.a(this.f14457e, (int) b10[0], (int) b10[1], j10, this.f14469q);
        }
        synchronized (f14453a) {
            this.f14455c.add(remove);
            this.f14461i++;
        }
    }

    private void c() {
        ArrayList arrayList;
        synchronized (f14453a) {
            arrayList = new ArrayList(this.f14455c);
        }
        this.f14454b.addAll(arrayList);
    }

    public Bc a(float f10, float f11) {
        a(new Hc(f10, f11));
        return this;
    }

    private void a(Fc fc2) {
        if (this.f14470r == null) {
            this.f14470r = new Gc();
        }
        this.f14470r.a(fc2);
    }

    public Bc a(int i10, int i11, long j10, long j11, Interpolator interpolator) {
        a(new Dc(i10, i11, j10, j11, interpolator));
        return this;
    }

    private void a(Cc cc2) {
        if (this.f14469q == null) {
            this.f14469q = new Ec();
        }
        this.f14469q.a(cc2);
    }

    private void a(int i10, long j10) {
        this.f14460h = new int[2];
        this.f14456d = i10;
        this.f14457e = j10;
    }

    private void a(Bitmap bitmap) {
        for (int i10 = 0; i10 < this.f14456d; i10++) {
            this.f14454b.add(new zc(bitmap));
        }
    }

    public void a(Rect rect, int i10) {
        a(rect);
        a(i10);
    }

    private float[] b(float f10, float f11) {
        float f12;
        if (Float.compare(f10, f11) <= 0) {
            f12 = Ic.a(f11 - f10) + f10;
        } else {
            f12 = f11 + Ic.a(f10 - f11);
        }
        if (this.f14468p == null) {
            this.f14468p = new PathMeasure(this.f14467o, true);
        }
        this.f14468p.getPosTan(f12, r5, null);
        float f13 = r5[0];
        int[] iArr = this.f14460h;
        float[] fArr = {f13 - iArr[0], fArr[1] - iArr[1]};
        return fArr;
    }

    private void a(int i10) {
        synchronized (f14453a) {
            this.f14461i = 0;
        }
        this.f14459g = i10 / 1000.0f;
        this.f14458f = true;
    }

    private void a(Rect rect) {
        int i10 = rect.left - this.f14460h[0];
        this.f14463k = i10;
        this.f14462j = i10 + rect.width();
        int i11 = rect.top - this.f14460h[1];
        this.f14465m = i11;
        this.f14464l = i11 + rect.height();
    }

    public List<zc> b() {
        List<zc> unmodifiableList;
        synchronized (f14453a) {
            unmodifiableList = Collections.unmodifiableList(this.f14455c);
        }
        return unmodifiableList;
    }

    private int a(int i10, int i11) {
        if (i10 == i11) {
            return i10;
        }
        if (i10 < i11) {
            return Ic.a(i11 - i10) + i10;
        }
        return Ic.a(i10 - i11) + i11;
    }

    public void a(long j10) {
        boolean z10 = this.f14458f;
        float f10 = this.f14459g * ((float) j10);
        ArrayList arrayList = new ArrayList();
        synchronized (f14453a) {
            while (z10) {
                if (this.f14454b.isEmpty() || this.f14461i >= f10) {
                    break;
                }
                b(j10);
            }
            Iterator<zc> it = this.f14455c.iterator();
            while (it.hasNext()) {
                zc next = it.next();
                if (!next.a(j10)) {
                    it.remove();
                    arrayList.add(next);
                }
            }
        }
        this.f14454b.addAll(arrayList);
    }

    public void a() {
        c();
    }
}
