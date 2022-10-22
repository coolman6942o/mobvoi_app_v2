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
/* compiled from: ViewTarget.java */
@Deprecated
/* loaded from: classes.dex */
public abstract class j<T extends View, Z> extends k5.a<Z> {

    /* renamed from: f  reason: collision with root package name */
    private static int f29771f = f.f7843a;

    /* renamed from: a  reason: collision with root package name */
    protected final T f29772a;

    /* renamed from: b  reason: collision with root package name */
    private final a f29773b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnAttachStateChangeListener f29774c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f29775d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f29776e;

    /* compiled from: ViewTarget.java */
    /* loaded from: classes.dex */
    static final class a {

        /* renamed from: e  reason: collision with root package name */
        static Integer f29777e;

        /* renamed from: a  reason: collision with root package name */
        private final View f29778a;

        /* renamed from: b  reason: collision with root package name */
        private final List<h> f29779b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        boolean f29780c;

        /* renamed from: d  reason: collision with root package name */
        private ViewTreeObserver$OnPreDrawListenerC0362a f29781d;

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: ViewTarget.java */
        /* renamed from: k5.j$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class ViewTreeObserver$OnPreDrawListenerC0362a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f29782a;

            ViewTreeObserver$OnPreDrawListenerC0362a(a aVar) {
                this.f29782a = new WeakReference<>(aVar);
            }

            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = this.f29782a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        a(View view) {
            this.f29778a = view;
        }

        private static int c(Context context) {
            if (f29777e == null) {
                Display defaultDisplay = ((WindowManager) n5.j.d((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f29777e = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f29777e.intValue();
        }

        private int e(int i10, int i11, int i12) {
            int i13 = i11 - i12;
            if (i13 > 0) {
                return i13;
            }
            if (this.f29780c && this.f29778a.isLayoutRequested()) {
                return 0;
            }
            int i14 = i10 - i12;
            if (i14 > 0) {
                return i14;
            }
            if (this.f29778a.isLayoutRequested() || i11 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return c(this.f29778a.getContext());
        }

        private int f() {
            int paddingTop = this.f29778a.getPaddingTop() + this.f29778a.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f29778a.getLayoutParams();
            return e(this.f29778a.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int g() {
            int paddingLeft = this.f29778a.getPaddingLeft() + this.f29778a.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f29778a.getLayoutParams();
            return e(this.f29778a.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        private boolean h(int i10) {
            return i10 > 0 || i10 == Integer.MIN_VALUE;
        }

        private boolean i(int i10, int i11) {
            return h(i10) && h(i11);
        }

        private void j(int i10, int i11) {
            Iterator it = new ArrayList(this.f29779b).iterator();
            while (it.hasNext()) {
                ((h) it.next()).g(i10, i11);
            }
        }

        void a() {
            if (!this.f29779b.isEmpty()) {
                int g10 = g();
                int f10 = f();
                if (i(g10, f10)) {
                    j(g10, f10);
                    b();
                }
            }
        }

        void b() {
            ViewTreeObserver viewTreeObserver = this.f29778a.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f29781d);
            }
            this.f29781d = null;
            this.f29779b.clear();
        }

        void d(h hVar) {
            int g10 = g();
            int f10 = f();
            if (i(g10, f10)) {
                hVar.g(g10, f10);
                return;
            }
            if (!this.f29779b.contains(hVar)) {
                this.f29779b.add(hVar);
            }
            if (this.f29781d == null) {
                ViewTreeObserver viewTreeObserver = this.f29778a.getViewTreeObserver();
                ViewTreeObserver$OnPreDrawListenerC0362a aVar = new ViewTreeObserver$OnPreDrawListenerC0362a(this);
                this.f29781d = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        void k(h hVar) {
            this.f29779b.remove(hVar);
        }
    }

    public j(T t10) {
        this.f29772a = (T) n5.j.d(t10);
        this.f29773b = new a(t10);
    }

    private Object i() {
        return this.f29772a.getTag(f29771f);
    }

    private void j() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f29774c;
        if (onAttachStateChangeListener != null && !this.f29776e) {
            this.f29772a.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f29776e = true;
        }
    }

    private void k() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f29774c;
        if (onAttachStateChangeListener != null && this.f29776e) {
            this.f29772a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f29776e = false;
        }
    }

    private void l(Object obj) {
        this.f29772a.setTag(f29771f, obj);
    }

    @Override // k5.i
    public void b(h hVar) {
        this.f29773b.k(hVar);
    }

    @Override // k5.i
    public void d(j5.a aVar) {
        l(aVar);
    }

    @Override // k5.a, k5.i
    public void e(Drawable drawable) {
        super.e(drawable);
        j();
    }

    @Override // k5.i
    public j5.a f() {
        Object i10 = i();
        if (i10 == null) {
            return null;
        }
        if (i10 instanceof j5.a) {
            return (j5.a) i10;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    @Override // k5.a, k5.i
    public void g(Drawable drawable) {
        super.g(drawable);
        this.f29773b.b();
        if (!this.f29775d) {
            k();
        }
    }

    @Override // k5.i
    public void h(h hVar) {
        this.f29773b.d(hVar);
    }

    public String toString() {
        return "Target for: " + this.f29772a;
    }
}
