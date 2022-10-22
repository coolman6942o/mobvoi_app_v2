package h7;

import android.animation.TypeEvaluator;
import android.graphics.drawable.Drawable;
import android.util.Property;
/* compiled from: CircularRevealWidget.java */
/* loaded from: classes.dex */
public interface d {

    /* compiled from: CircularRevealWidget.java */
    /* loaded from: classes.dex */
    public static class b implements TypeEvaluator<e> {

        /* renamed from: b  reason: collision with root package name */
        public static final TypeEvaluator<e> f27745b = new b();

        /* renamed from: a  reason: collision with root package name */
        private final e f27746a = new e();

        /* renamed from: a */
        public e evaluate(float f10, e eVar, e eVar2) {
            this.f27746a.a(p7.a.c(eVar.f27749a, eVar2.f27749a, f10), p7.a.c(eVar.f27750b, eVar2.f27750b, f10), p7.a.c(eVar.f27751c, eVar2.f27751c, f10));
            return this.f27746a;
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* loaded from: classes.dex */
    public static class c extends Property<d, e> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<d, e> f27747a = new c("circularReveal");

        private c(String str) {
            super(e.class, str);
        }

        /* renamed from: a */
        public e get(d dVar) {
            return dVar.getRevealInfo();
        }

        /* renamed from: b */
        public void set(d dVar, e eVar) {
            dVar.setRevealInfo(eVar);
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* renamed from: h7.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0299d extends Property<d, Integer> {

        /* renamed from: a  reason: collision with root package name */
        public static final Property<d, Integer> f27748a = new C0299d("circularRevealScrimColor");

        private C0299d(String str) {
            super(Integer.class, str);
        }

        /* renamed from: a */
        public Integer get(d dVar) {
            return Integer.valueOf(dVar.getCircularRevealScrimColor());
        }

        /* renamed from: b */
        public void set(d dVar, Integer num) {
            dVar.setCircularRevealScrimColor(num.intValue());
        }
    }

    /* compiled from: CircularRevealWidget.java */
    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public float f27749a;

        /* renamed from: b  reason: collision with root package name */
        public float f27750b;

        /* renamed from: c  reason: collision with root package name */
        public float f27751c;

        public void a(float f10, float f11, float f12) {
            this.f27749a = f10;
            this.f27750b = f11;
            this.f27751c = f12;
        }

        private e() {
        }

        public e(float f10, float f11, float f12) {
            this.f27749a = f10;
            this.f27750b = f11;
            this.f27751c = f12;
        }
    }

    void a();

    void b();

    int getCircularRevealScrimColor();

    e getRevealInfo();

    void setCircularRevealOverlayDrawable(Drawable drawable);

    void setCircularRevealScrimColor(int i10);

    void setRevealInfo(e eVar);
}
