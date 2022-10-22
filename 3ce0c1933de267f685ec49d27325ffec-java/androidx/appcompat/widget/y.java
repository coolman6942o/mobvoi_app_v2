package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.core.graphics.drawable.a;
import androidx.core.view.d0;
import d.j;
/* compiled from: AppCompatSeekBarHelper.java */
/* loaded from: classes.dex */
class y extends t {

    /* renamed from: d  reason: collision with root package name */
    private final SeekBar f1364d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f1365e;

    /* renamed from: f  reason: collision with root package name */
    private ColorStateList f1366f = null;

    /* renamed from: g  reason: collision with root package name */
    private PorterDuff.Mode f1367g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f1368h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1369i = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(SeekBar seekBar) {
        super(seekBar);
        this.f1364d = seekBar;
    }

    private void f() {
        Drawable drawable = this.f1365e;
        if (drawable == null) {
            return;
        }
        if (this.f1368h || this.f1369i) {
            Drawable r10 = a.r(drawable.mutate());
            this.f1365e = r10;
            if (this.f1368h) {
                a.o(r10, this.f1366f);
            }
            if (this.f1369i) {
                a.p(this.f1365e, this.f1367g);
            }
            if (this.f1365e.isStateful()) {
                this.f1365e.setState(this.f1364d.getDrawableState());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.widget.t
    public void c(AttributeSet attributeSet, int i10) {
        super.c(attributeSet, i10);
        Context context = this.f1364d.getContext();
        int[] iArr = j.Q;
        x0 v10 = x0.v(context, attributeSet, iArr, i10, 0);
        SeekBar seekBar = this.f1364d;
        d0.r0(seekBar, seekBar.getContext(), iArr, attributeSet, v10.r(), i10, 0);
        Drawable h10 = v10.h(j.R);
        if (h10 != null) {
            this.f1364d.setThumb(h10);
        }
        j(v10.g(j.S));
        int i11 = j.U;
        if (v10.s(i11)) {
            this.f1367g = g0.e(v10.k(i11, -1), this.f1367g);
            this.f1369i = true;
        }
        int i12 = j.T;
        if (v10.s(i12)) {
            this.f1366f = v10.c(i12);
            this.f1368h = true;
        }
        v10.w();
        f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(Canvas canvas) {
        if (this.f1365e != null) {
            int max = this.f1364d.getMax();
            int i10 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f1365e.getIntrinsicWidth();
                int intrinsicHeight = this.f1365e.getIntrinsicHeight();
                int i11 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i10 = intrinsicHeight / 2;
                }
                this.f1365e.setBounds(-i11, -i10, i11, i10);
                float width = ((this.f1364d.getWidth() - this.f1364d.getPaddingLeft()) - this.f1364d.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(this.f1364d.getPaddingLeft(), this.f1364d.getHeight() / 2);
                for (int i12 = 0; i12 <= max; i12++) {
                    this.f1365e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        Drawable drawable = this.f1365e;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f1364d.getDrawableState())) {
            this.f1364d.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        Drawable drawable = this.f1365e;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    void j(Drawable drawable) {
        Drawable drawable2 = this.f1365e;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f1365e = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f1364d);
            a.m(drawable, d0.E(this.f1364d));
            if (drawable.isStateful()) {
                drawable.setState(this.f1364d.getDrawableState());
            }
            f();
        }
        this.f1364d.invalidate();
    }
}
