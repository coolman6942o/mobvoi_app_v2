package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.d0;
import d7.b;
import d7.d;
import d7.f;
import j7.a;
/* loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements a {

    /* renamed from: a  reason: collision with root package name */
    private TextView f11321a;

    /* renamed from: b  reason: collision with root package name */
    private Button f11322b;

    /* renamed from: c  reason: collision with root package name */
    private int f11323c;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static void d(View view, int i10, int i11) {
        if (d0.Z(view)) {
            d0.H0(view, d0.J(view), i10, d0.I(view), i11);
        } else {
            view.setPadding(view.getPaddingLeft(), i10, view.getPaddingRight(), i11);
        }
    }

    private boolean e(int i10, int i11, int i12) {
        boolean z10;
        if (i10 != getOrientation()) {
            setOrientation(i10);
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f11321a.getPaddingTop() == i11 && this.f11321a.getPaddingBottom() == i12) {
            return z10;
        }
        d(this.f11321a, i11, i12);
        return true;
    }

    @Override // com.google.android.material.snackbar.a
    public void a(int i10, int i11) {
        this.f11321a.setAlpha(0.0f);
        long j10 = i11;
        long j11 = i10;
        this.f11321a.animate().alpha(1.0f).setDuration(j10).setStartDelay(j11).start();
        if (this.f11322b.getVisibility() == 0) {
            this.f11322b.setAlpha(0.0f);
            this.f11322b.animate().alpha(1.0f).setDuration(j10).setStartDelay(j11).start();
        }
    }

    @Override // com.google.android.material.snackbar.a
    public void b(int i10, int i11) {
        this.f11321a.setAlpha(1.0f);
        long j10 = i11;
        long j11 = i10;
        this.f11321a.animate().alpha(0.0f).setDuration(j10).setStartDelay(j11).start();
        if (this.f11322b.getVisibility() == 0) {
            this.f11322b.setAlpha(1.0f);
            this.f11322b.animate().alpha(0.0f).setDuration(j10).setStartDelay(j11).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f10) {
        if (f10 != 1.0f) {
            this.f11322b.setTextColor(a.h(a.d(this, b.f25161q), this.f11322b.getCurrentTextColor(), f10));
        }
    }

    public Button getActionView() {
        return this.f11322b;
    }

    public TextView getMessageView() {
        return this.f11321a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f11321a = (TextView) findViewById(f.f25249d0);
        this.f11322b = (Button) findViewById(f.f25247c0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
        if (e(1, r0, r0 - r1) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0049, code lost:
        if (e(0, r0, r0) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        r3 = true;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.f25206m);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.f25204l);
        boolean z10 = false;
        boolean z11 = this.f11321a.getLayout().getLineCount() > 1;
        if (!z11 || this.f11323c <= 0 || this.f11322b.getMeasuredWidth() <= this.f11323c) {
            if (!z11) {
                dimensionPixelSize = dimensionPixelSize2;
            }
        }
        if (z10) {
            super.onMeasure(i10, i11);
        }
    }

    public void setMaxInlineActionWidth(int i10) {
        this.f11323c = i10;
    }
}
