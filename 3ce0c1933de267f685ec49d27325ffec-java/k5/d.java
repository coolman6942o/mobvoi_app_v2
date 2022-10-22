package k5;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.bumptech.glide.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import n5.j;
/* compiled from: CustomViewTarget.java */
/* loaded from: classes.dex */
public abstract class d<T extends View, Z> implements i<Z> {

    /* renamed from: f  reason: collision with root package name */
    private static final int f29758f = f.f7843a;

    /* renamed from: a  reason: collision with root package name */
    private final a f29759a;

    /* renamed from: b  reason: collision with root package name */
    protected final T f29760b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnAttachStateChangeListener f29761c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f29762d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f29763e;

    /* compiled from: CustomViewTarget.java */
    /* loaded from: classes.dex */
    static final class a {

        /* renamed from: e  reason: collision with root package name */
        static Integer f29764e;

        /* renamed from: a  reason: collision with root package name */
        private final View f29765a;

        /* renamed from: b  reason: collision with root package name */
        private final List<h> f29766b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        boolean f29767c;

        /* renamed from: d  reason: collision with root package name */
        private ViewTreeObserver$OnPreDrawListenerC0361a f29768d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: CustomViewTarget.java */
        /* renamed from: k5.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class ViewTreeObserver$OnPreDrawListenerC0361a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f29769a;

            ViewTreeObserver$OnPreDrawListenerC0361a(a aVar) {
                this.f29769a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f29769a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        a(View view) {
            this.f29765a = view;
        }

        private static int c(Context context) {
            if (f29764e == null) {
                Display defaultDisplay = ((WindowManager) j.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f29764e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f29764e.intValue();
        }

        private int e(int i10, int i11, int i12) {
            int i13 = i11 - i12;
            if (i13 > 0) {
                return i13;
            }
            if (this.f29767c && this.f29765a.isLayoutRequested()) {
                return 0;
            }
            int i14 = i10 - i12;
            if (i14 > 0) {
                return i14;
            }
            if (this.f29765a.isLayoutRequested() || i11 != -2) {
                return 0;
            }
            if (Log.isLoggable("CustomViewTarget", 4)) {
                Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f29765a.getContext());
        }

        private int f() {
            int paddingTop = this.f29765a.getPaddingTop() + this.f29765a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f29765a.getLayoutParams();
            return e(this.f29765a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.f29765a.getPaddingLeft() + this.f29765a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f29765a.getLayoutParams();
            return e(this.f29765a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i10) {
            return i10 > 0 || i10 == Integer.MIN_VALUE;
        }

        private boolean i(int i10, int i11) {
            return h(i10) && h(i11);
        }

        private void j(int i10, int i11) {
            Iterator it = new ArrayList(this.f29766b).iterator();
            while (it.hasNext()) {
                ((h) it.next()).g(i10, i11);
            }
        }

        void a() {
            if (!this.f29766b.isEmpty()) {
                int g10 = g();
                int f10 = f();
                if (i(g10, f10)) {
                    j(g10, f10);
                    b();
                }
            }
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f29765a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f29768d);
            }
            this.f29768d = null;
            this.f29766b.clear();
        }

        void d(h hVar) {
            int g10 = g();
            int f10 = f();
            if (i(g10, f10)) {
                hVar.g(g10, f10);
                return;
            }
            if (!this.f29766b.contains(hVar)) {
                this.f29766b.add(hVar);
            }
            if (this.f29768d == null) {
                ViewTreeObserver viewTreeObserver = this.f29765a.getViewTreeObserver();
                ViewTreeObserver$OnPreDrawListenerC0361a aVar = new ViewTreeObserver$OnPreDrawListenerC0361a(this);
                this.f29768d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        void k(h hVar) {
            this.f29766b.remove(hVar);
        }
    }

    public d(T t10) {
        this.f29760b = (T) j.d(t10);
        this.f29759a = new a(t10);
    }

    private Object i() {
        return this.f29760b.getTag(f29758f);
    }

    private void j() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f29761c;
        if (onAttachStateChangeListener != null && !this.f29763e) {
            this.f29760b.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f29763e = true;
        }
    }

    private void k() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f29761c;
        if (onAttachStateChangeListener != null && this.f29763e) {
            this.f29760b.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f29763e = false;
        }
    }

    private void n(Object obj) {
        this.f29760b.setTag(f29758f, obj);
    }

    @Override // k5.i
    public final void b(h hVar) {
        this.f29759a.k(hVar);
    }

    @Override // k5.i
    public final void d(j5.a aVar) {
        n(aVar);
    }

    @Override // k5.i
    public final void e(Drawable drawable) {
        j();
        m(drawable);
    }

    @Override // k5.i
    public final j5.a f() {
        Object i10 = i();
        if (i10 == null) {
            return null;
        }
        if (i10 instanceof j5.a) {
            return (j5.a) i10;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    @Override // k5.i
    public final void g(Drawable drawable) {
        this.f29759a.b();
        l(drawable);
        if (!this.f29762d) {
            k();
        }
    }

    @Override // k5.i
    public final void h(h hVar) {
        this.f29759a.d(hVar);
    }

    protected abstract void l(Drawable drawable);

    protected void m(Drawable drawable) {
    }

    @Override // g5.i
    public void onDestroy() {
    }

    @Override // g5.i
    public void onStart() {
    }

    @Override // g5.i
    public void onStop() {
    }

    public String toString() {
        return "Target for: " + this.f29760b;
    }
}
