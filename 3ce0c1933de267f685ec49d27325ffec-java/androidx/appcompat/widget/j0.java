package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import j.e;
/* compiled from: ForwardingListener.java */
/* loaded from: classes.dex */
public abstract class j0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final float f1205a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1206b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1207c;

    /* renamed from: d  reason: collision with root package name */
    final View f1208d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f1209e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f1210f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f1211g;

    /* renamed from: h  reason: collision with root package name */
    private int f1212h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f1213i = new int[2];

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ForwardingListener.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = j0.this.f1208d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ForwardingListener.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j0.this.e();
        }
    }

    public j0(View view) {
        this.f1208d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f1205a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f1206b = tapTimeout;
        this.f1207c = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private void a() {
        Runnable runnable = this.f1210f;
        if (runnable != null) {
            this.f1208d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f1209e;
        if (runnable2 != null) {
            this.f1208d.removeCallbacks(runnable2);
        }
    }

    private boolean f(MotionEvent motionEvent) {
        h0 h0Var;
        View view = this.f1208d;
        e b10 = b();
        if (b10 == null || !b10.b() || (h0Var = (h0) b10.k()) == null || !h0Var.isShown()) {
            return false;
        }
        MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        i(view, obtainNoHistory);
        j(h0Var, obtainNoHistory);
        boolean e10 = h0Var.e(obtainNoHistory, this.f1212h);
        obtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return e10 && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0017, code lost:
        if (r1 != 3) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean g(MotionEvent motionEvent) {
        View view = this.f1208d;
        if (!view.isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f1212h);
                    if (findPointerIndex >= 0 && !h(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f1205a)) {
                        a();
                        view.getParent().requestDisallowInterceptTouchEvent(true);
                        return true;
                    }
                }
            }
            a();
        } else {
            this.f1212h = motionEvent.getPointerId(0);
            if (this.f1209e == null) {
                this.f1209e = new a();
            }
            view.postDelayed(this.f1209e, this.f1206b);
            if (this.f1210f == null) {
                this.f1210f = new b();
            }
            view.postDelayed(this.f1210f, this.f1207c);
        }
        return false;
    }

    private static boolean h(View view, float f10, float f11, float f12) {
        float f13 = -f12;
        return f10 >= f13 && f11 >= f13 && f10 < ((float) (view.getRight() - view.getLeft())) + f12 && f11 < ((float) (view.getBottom() - view.getTop())) + f12;
    }

    private boolean i(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1213i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(iArr[0], iArr[1]);
        return true;
    }

    private boolean j(View view, MotionEvent motionEvent) {
        int[] iArr = this.f1213i;
        view.getLocationOnScreen(iArr);
        motionEvent.offsetLocation(-iArr[0], -iArr[1]);
        return true;
    }

    public abstract e b();

    protected abstract boolean c();

    protected boolean d() {
        e b10 = b();
        if (b10 == null || !b10.b()) {
            return true;
        }
        b10.dismiss();
        return true;
    }

    void e() {
        a();
        View view = this.f1208d;
        if (view.isEnabled() && !view.isLongClickable() && c()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(obtain);
            obtain.recycle();
            this.f1211g = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z10;
        boolean z11 = this.f1211g;
        if (z11) {
            z10 = f(motionEvent) || !d();
        } else {
            z10 = g(motionEvent) && c();
            if (z10) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f1208d.onTouchEvent(obtain);
                obtain.recycle();
            }
        }
        this.f1211g = z10;
        return z10 || z11;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f1211g = false;
        this.f1212h = -1;
        Runnable runnable = this.f1209e;
        if (runnable != null) {
            this.f1208d.removeCallbacks(runnable);
        }
    }
}
