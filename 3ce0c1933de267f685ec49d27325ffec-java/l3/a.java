package l3;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import com.airbnb.lottie.d;
/* compiled from: Keyframe.java */
/* loaded from: classes.dex */
public class a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final d f30403a;

    /* renamed from: b  reason: collision with root package name */
    public final T f30404b;

    /* renamed from: c  reason: collision with root package name */
    public T f30405c;

    /* renamed from: d  reason: collision with root package name */
    public final Interpolator f30406d;

    /* renamed from: e  reason: collision with root package name */
    public final float f30407e;

    /* renamed from: f  reason: collision with root package name */
    public Float f30408f;

    /* renamed from: g  reason: collision with root package name */
    private float f30409g;

    /* renamed from: h  reason: collision with root package name */
    private float f30410h;

    /* renamed from: i  reason: collision with root package name */
    private int f30411i;

    /* renamed from: j  reason: collision with root package name */
    private int f30412j;

    /* renamed from: k  reason: collision with root package name */
    private float f30413k;

    /* renamed from: l  reason: collision with root package name */
    private float f30414l;

    /* renamed from: m  reason: collision with root package name */
    public PointF f30415m;

    /* renamed from: n  reason: collision with root package name */
    public PointF f30416n;

    public a(d dVar, T t10, T t11, Interpolator interpolator, float f10, Float f11) {
        this.f30409g = -3987645.8f;
        this.f30410h = -3987645.8f;
        this.f30411i = 784923401;
        this.f30412j = 784923401;
        this.f30413k = Float.MIN_VALUE;
        this.f30414l = Float.MIN_VALUE;
        this.f30415m = null;
        this.f30416n = null;
        this.f30403a = dVar;
        this.f30404b = t10;
        this.f30405c = t11;
        this.f30406d = interpolator;
        this.f30407e = f10;
        this.f30408f = f11;
    }

    public boolean a(float f10) {
        return f10 >= e() && f10 < b();
    }

    public float b() {
        if (this.f30403a == null) {
            return 1.0f;
        }
        if (this.f30414l == Float.MIN_VALUE) {
            if (this.f30408f == null) {
                this.f30414l = 1.0f;
            } else {
                this.f30414l = e() + ((this.f30408f.floatValue() - this.f30407e) / this.f30403a.e());
            }
        }
        return this.f30414l;
    }

    public float c() {
        if (this.f30410h == -3987645.8f) {
            this.f30410h = ((Float) this.f30405c).floatValue();
        }
        return this.f30410h;
    }

    public int d() {
        if (this.f30412j == 784923401) {
            this.f30412j = ((Integer) this.f30405c).intValue();
        }
        return this.f30412j;
    }

    public float e() {
        d dVar = this.f30403a;
        if (dVar == null) {
            return 0.0f;
        }
        if (this.f30413k == Float.MIN_VALUE) {
            this.f30413k = (this.f30407e - dVar.o()) / this.f30403a.e();
        }
        return this.f30413k;
    }

    public float f() {
        if (this.f30409g == -3987645.8f) {
            this.f30409g = ((Float) this.f30404b).floatValue();
        }
        return this.f30409g;
    }

    public int g() {
        if (this.f30411i == 784923401) {
            this.f30411i = ((Integer) this.f30404b).intValue();
        }
        return this.f30411i;
    }

    public boolean h() {
        return this.f30406d == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f30404b + ", endValue=" + this.f30405c + ", startFrame=" + this.f30407e + ", endFrame=" + this.f30408f + ", interpolator=" + this.f30406d + '}';
    }

    public a(T t10) {
        this.f30409g = -3987645.8f;
        this.f30410h = -3987645.8f;
        this.f30411i = 784923401;
        this.f30412j = 784923401;
        this.f30413k = Float.MIN_VALUE;
        this.f30414l = Float.MIN_VALUE;
        this.f30415m = null;
        this.f30416n = null;
        this.f30403a = null;
        this.f30404b = t10;
        this.f30405c = t10;
        this.f30406d = null;
        this.f30407e = Float.MIN_VALUE;
        this.f30408f = Float.valueOf(Float.MAX_VALUE);
    }
}
