package s0;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.d0;
import java.util.ArrayList;
import s0.a;
import s0.b;
/* compiled from: DynamicAnimation.java */
/* loaded from: classes.dex */
public abstract class b<T extends b<T>> implements a.b {

    /* renamed from: m  reason: collision with root package name */
    public static final r f34244m = new i("scaleX");

    /* renamed from: n  reason: collision with root package name */
    public static final r f34245n = new j("scaleY");

    /* renamed from: o  reason: collision with root package name */
    public static final r f34246o = new k("rotation");

    /* renamed from: p  reason: collision with root package name */
    public static final r f34247p = new l("rotationX");

    /* renamed from: q  reason: collision with root package name */
    public static final r f34248q = new m("rotationY");

    /* renamed from: r  reason: collision with root package name */
    public static final r f34249r = new c("alpha");

    /* renamed from: d  reason: collision with root package name */
    final Object f34253d;

    /* renamed from: e  reason: collision with root package name */
    final s0.c f34254e;

    /* renamed from: j  reason: collision with root package name */
    private float f34259j;

    /* renamed from: a  reason: collision with root package name */
    float f34250a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    float f34251b = Float.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    boolean f34252c = false;

    /* renamed from: f  reason: collision with root package name */
    boolean f34255f = false;

    /* renamed from: g  reason: collision with root package name */
    float f34256g = Float.MAX_VALUE;

    /* renamed from: h  reason: collision with root package name */
    float f34257h = -Float.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    private long f34258i = 0;

    /* renamed from: k  reason: collision with root package name */
    private final ArrayList<p> f34260k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private final ArrayList<q> f34261l = new ArrayList<>();

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    static class a extends r {
        a(String str) {
            super(str, null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getY();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setY(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* renamed from: s0.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0492b extends r {
        C0492b(String str) {
            super(str, null);
        }

        /* renamed from: c */
        public float a(View view) {
            return d0.R(view);
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            d0.P0(view, f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    static class c extends r {
        c(String str) {
            super(str, null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getAlpha();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setAlpha(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    static class d extends r {
        d(String str) {
            super(str, null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getScrollX();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setScrollX((int) f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    static class e extends r {
        e(String str) {
            super(str, null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getScrollY();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setScrollY((int) f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    static class f extends r {
        f(String str) {
            super(str, null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getTranslationX();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setTranslationX(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    static class g extends r {
        g(String str) {
            super(str, null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getTranslationY();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setTranslationY(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    static class h extends r {
        h(String str) {
            super(str, null);
        }

        /* renamed from: c */
        public float a(View view) {
            return d0.O(view);
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            d0.N0(view, f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    static class i extends r {
        i(String str) {
            super(str, null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getScaleX();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setScaleX(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    static class j extends r {
        j(String str) {
            super(str, null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getScaleY();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setScaleY(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    static class k extends r {
        k(String str) {
            super(str, null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getRotation();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setRotation(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    static class l extends r {
        l(String str) {
            super(str, null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getRotationX();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setRotationX(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    static class m extends r {
        m(String str) {
            super(str, null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getRotationY();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setRotationY(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    static class n extends r {
        n(String str) {
            super(str, null);
        }

        /* renamed from: c */
        public float a(View view) {
            return view.getX();
        }

        /* renamed from: d */
        public void b(View view, float f10) {
            view.setX(f10);
        }
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    static class o {

        /* renamed from: a  reason: collision with root package name */
        float f34262a;

        /* renamed from: b  reason: collision with root package name */
        float f34263b;
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public interface p {
        void a(b bVar, boolean z10, float f10, float f11);
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public interface q {
        void a(b bVar, float f10, float f11);
    }

    /* compiled from: DynamicAnimation.java */
    /* loaded from: classes.dex */
    public static abstract class r extends s0.c<View> {
        /* synthetic */ r(String str, f fVar) {
            this(str);
        }

        private r(String str) {
            super(str);
        }
    }

    static {
        new f("translationX");
        new g("translationY");
        new h("translationZ");
        new n("x");
        new a("y");
        new C0492b("z");
        new d("scrollX");
        new e("scrollY");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <K> b(K k10, s0.c<K> cVar) {
        this.f34253d = k10;
        this.f34254e = cVar;
        if (cVar == f34246o || cVar == f34247p || cVar == f34248q) {
            this.f34259j = 0.1f;
        } else if (cVar == f34249r) {
            this.f34259j = 0.00390625f;
        } else if (cVar == f34244m || cVar == f34245n) {
            this.f34259j = 0.00390625f;
        } else {
            this.f34259j = 1.0f;
        }
    }

    private void b(boolean z10) {
        this.f34255f = false;
        s0.a.d().g(this);
        this.f34258i = 0L;
        this.f34252c = false;
        for (int i10 = 0; i10 < this.f34260k.size(); i10++) {
            if (this.f34260k.get(i10) != null) {
                this.f34260k.get(i10).a(this, z10, this.f34251b, this.f34250a);
            }
        }
        f(this.f34260k);
    }

    private float c() {
        return this.f34254e.a(this.f34253d);
    }

    private static <T> void f(ArrayList<T> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void j() {
        if (!this.f34255f) {
            this.f34255f = true;
            if (!this.f34252c) {
                this.f34251b = c();
            }
            float f10 = this.f34251b;
            if (f10 > this.f34256g || f10 < this.f34257h) {
                throw new IllegalArgumentException("Starting value need to be in between min value and max value");
            }
            s0.a.d().a(this, 0L);
        }
    }

    @Override // s0.a.b
    public boolean a(long j10) {
        long j11 = this.f34258i;
        if (j11 == 0) {
            this.f34258i = j10;
            g(this.f34251b);
            return false;
        }
        this.f34258i = j10;
        boolean k10 = k(j10 - j11);
        float min = Math.min(this.f34251b, this.f34256g);
        this.f34251b = min;
        float max = Math.max(min, this.f34257h);
        this.f34251b = max;
        g(max);
        if (k10) {
            b(false);
        }
        return k10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.f34259j * 0.75f;
    }

    public boolean e() {
        return this.f34255f;
    }

    void g(float f10) {
        this.f34254e.b(this.f34253d, f10);
        for (int i10 = 0; i10 < this.f34261l.size(); i10++) {
            if (this.f34261l.get(i10) != null) {
                this.f34261l.get(i10).a(this, this.f34251b, this.f34250a);
            }
        }
        f(this.f34261l);
    }

    public T h(float f10) {
        this.f34251b = f10;
        this.f34252c = true;
        return this;
    }

    public void i() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        } else if (!this.f34255f) {
            j();
        }
    }

    abstract boolean k(long j10);
}
