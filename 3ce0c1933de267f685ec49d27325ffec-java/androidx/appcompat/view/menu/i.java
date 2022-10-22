package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.j;
import androidx.core.view.d0;
import androidx.core.view.f;
import d.d;
/* compiled from: MenuPopupHelper.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final Context f756a;

    /* renamed from: b  reason: collision with root package name */
    private final e f757b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f758c;

    /* renamed from: d  reason: collision with root package name */
    private final int f759d;

    /* renamed from: e  reason: collision with root package name */
    private final int f760e;

    /* renamed from: f  reason: collision with root package name */
    private View f761f;

    /* renamed from: g  reason: collision with root package name */
    private int f762g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f763h;

    /* renamed from: i  reason: collision with root package name */
    private j.a f764i;

    /* renamed from: j  reason: collision with root package name */
    private h f765j;

    /* renamed from: k  reason: collision with root package name */
    private PopupWindow.OnDismissListener f766k;

    /* renamed from: l  reason: collision with root package name */
    private final PopupWindow.OnDismissListener f767l;

    /* compiled from: MenuPopupHelper.java */
    /* loaded from: classes.dex */
    class a implements PopupWindow.OnDismissListener {
        a() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            i.this.e();
        }
    }

    public i(Context context, e eVar, View view, boolean z10, int i10) {
        this(context, eVar, view, z10, i10, 0);
    }

    private h a() {
        h hVar;
        Display defaultDisplay = ((WindowManager) this.f756a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        if (Math.min(point.x, point.y) >= this.f756a.getResources().getDimensionPixelSize(d.f24750c)) {
            hVar = new b(this.f756a, this.f761f, this.f759d, this.f760e, this.f758c);
        } else {
            hVar = new l(this.f756a, this.f757b, this.f761f, this.f759d, this.f760e, this.f758c);
        }
        hVar.n(this.f757b);
        hVar.w(this.f767l);
        hVar.r(this.f761f);
        hVar.h(this.f764i);
        hVar.t(this.f763h);
        hVar.u(this.f762g);
        return hVar;
    }

    private void l(int i10, int i11, boolean z10, boolean z11) {
        h c10 = c();
        c10.x(z11);
        if (z10) {
            if ((f.b(this.f762g, d0.E(this.f761f)) & 7) == 5) {
                i10 -= this.f761f.getWidth();
            }
            c10.v(i10);
            c10.y(i11);
            int i12 = (int) ((this.f756a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            c10.s(new Rect(i10 - i12, i11 - i12, i10 + i12, i11 + i12));
        }
        c10.a();
    }

    public void b() {
        if (d()) {
            this.f765j.dismiss();
        }
    }

    public h c() {
        if (this.f765j == null) {
            this.f765j = a();
        }
        return this.f765j;
    }

    public boolean d() {
        h hVar = this.f765j;
        return hVar != null && hVar.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        this.f765j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f766k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void f(View view) {
        this.f761f = view;
    }

    public void g(boolean z10) {
        this.f763h = z10;
        h hVar = this.f765j;
        if (hVar != null) {
            hVar.t(z10);
        }
    }

    public void h(int i10) {
        this.f762g = i10;
    }

    public void i(PopupWindow.OnDismissListener onDismissListener) {
        this.f766k = onDismissListener;
    }

    public void j(j.a aVar) {
        this.f764i = aVar;
        h hVar = this.f765j;
        if (hVar != null) {
            hVar.h(aVar);
        }
    }

    public void k() {
        if (!m()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean m() {
        if (d()) {
            return true;
        }
        if (this.f761f == null) {
            return false;
        }
        l(0, 0, false, false);
        return true;
    }

    public boolean n(int i10, int i11) {
        if (d()) {
            return true;
        }
        if (this.f761f == null) {
            return false;
        }
        l(i10, i11, true, true);
        return true;
    }

    public i(Context context, e eVar, View view, boolean z10, int i10, int i11) {
        this.f762g = 8388611;
        this.f767l = new a();
        this.f756a = context;
        this.f757b = eVar;
        this.f761f = view;
        this.f758c = z10;
        this.f759d = i10;
        this.f760e = i11;
    }
}
