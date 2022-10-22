package androidx.appcompat.widget;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.d0;
import androidx.core.view.f0;
import com.alipay.sdk.app.PayTask;
/* compiled from: TooltipCompatHandler.java */
/* loaded from: classes.dex */
class b1 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {

    /* renamed from: j  reason: collision with root package name */
    private static b1 f1098j;

    /* renamed from: k  reason: collision with root package name */
    private static b1 f1099k;

    /* renamed from: a  reason: collision with root package name */
    private final View f1100a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f1101b;

    /* renamed from: c  reason: collision with root package name */
    private final int f1102c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f1103d = new a();

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f1104e = new b();

    /* renamed from: f  reason: collision with root package name */
    private int f1105f;

    /* renamed from: g  reason: collision with root package name */
    private int f1106g;

    /* renamed from: h  reason: collision with root package name */
    private c1 f1107h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1108i;

    /* compiled from: TooltipCompatHandler.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b1.this.g(false);
        }
    }

    /* compiled from: TooltipCompatHandler.java */
    /* loaded from: classes.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b1.this.c();
        }
    }

    private b1(View view, CharSequence charSequence) {
        this.f1100a = view;
        this.f1101b = charSequence;
        this.f1102c = f0.c(ViewConfiguration.get(view.getContext()));
        b();
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    private void a() {
        this.f1100a.removeCallbacks(this.f1103d);
    }

    private void b() {
        this.f1105f = Integer.MAX_VALUE;
        this.f1106g = Integer.MAX_VALUE;
    }

    private void d() {
        this.f1100a.postDelayed(this.f1103d, ViewConfiguration.getLongPressTimeout());
    }

    private static void e(b1 b1Var) {
        b1 b1Var2 = f1098j;
        if (b1Var2 != null) {
            b1Var2.a();
        }
        f1098j = b1Var;
        if (b1Var != null) {
            b1Var.d();
        }
    }

    public static void f(View view, CharSequence charSequence) {
        b1 b1Var = f1098j;
        if (b1Var != null && b1Var.f1100a == view) {
            e(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            b1 b1Var2 = f1099k;
            if (b1Var2 != null && b1Var2.f1100a == view) {
                b1Var2.c();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new b1(view, charSequence);
    }

    private boolean h(MotionEvent motionEvent) {
        int x10 = (int) motionEvent.getX();
        int y10 = (int) motionEvent.getY();
        if (Math.abs(x10 - this.f1105f) <= this.f1102c && Math.abs(y10 - this.f1106g) <= this.f1102c) {
            return false;
        }
        this.f1105f = x10;
        this.f1106g = y10;
        return true;
    }

    void c() {
        if (f1099k == this) {
            f1099k = null;
            c1 c1Var = this.f1107h;
            if (c1Var != null) {
                c1Var.c();
                this.f1107h = null;
                b();
                this.f1100a.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (f1098j == this) {
            e(null);
        }
        this.f1100a.removeCallbacks(this.f1104e);
    }

    void g(boolean z10) {
        long j10;
        int i10;
        long j11;
        if (d0.W(this.f1100a)) {
            e(null);
            b1 b1Var = f1099k;
            if (b1Var != null) {
                b1Var.c();
            }
            f1099k = this;
            this.f1108i = z10;
            c1 c1Var = new c1(this.f1100a.getContext());
            this.f1107h = c1Var;
            c1Var.e(this.f1100a, this.f1105f, this.f1106g, this.f1108i, this.f1101b);
            this.f1100a.addOnAttachStateChangeListener(this);
            if (this.f1108i) {
                j10 = 2500;
            } else {
                if ((d0.Q(this.f1100a) & 1) == 1) {
                    j11 = PayTask.f6879j;
                    i10 = ViewConfiguration.getLongPressTimeout();
                } else {
                    j11 = 15000;
                    i10 = ViewConfiguration.getLongPressTimeout();
                }
                j10 = j11 - i10;
            }
            this.f1100a.removeCallbacks(this.f1104e);
            this.f1100a.postDelayed(this.f1104e, j10);
        }
    }

    @Override // android.view.View.OnHoverListener
    public boolean onHover(View view, MotionEvent motionEvent) {
        if (this.f1107h != null && this.f1108i) {
            return false;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f1100a.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                b();
                c();
            }
        } else if (this.f1100a.isEnabled() && this.f1107h == null && h(motionEvent)) {
            e(this);
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.f1105f = view.getWidth() / 2;
        this.f1106g = view.getHeight() / 2;
        g(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        c();
    }
}
