package com.google.android.material.progressindicator;

import android.content.Context;
import android.util.AttributeSet;
import d7.b;
import d7.k;
/* loaded from: classes.dex */
public final class CircularProgressIndicator extends a<e> {

    /* renamed from: o  reason: collision with root package name */
    public static final int f11179o = k.f25355t;

    public CircularProgressIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.f25155k);
    }

    private void s() {
        setIndeterminateDrawable(j.s(getContext(), (e) this.f11181a));
        setProgressDrawable(f.u(getContext(), (e) this.f11181a));
    }

    public int getIndicatorDirection() {
        return ((e) this.f11181a).f11225i;
    }

    public int getIndicatorInset() {
        return ((e) this.f11181a).f11224h;
    }

    public int getIndicatorSize() {
        return ((e) this.f11181a).f11223g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public e i(Context context, AttributeSet attributeSet) {
        return new e(context, attributeSet);
    }

    public void setIndicatorDirection(int i10) {
        ((e) this.f11181a).f11225i = i10;
        invalidate();
    }

    public void setIndicatorInset(int i10) {
        S s10 = this.f11181a;
        if (((e) s10).f11224h != i10) {
            ((e) s10).f11224h = i10;
            invalidate();
        }
    }

    public void setIndicatorSize(int i10) {
        int max = Math.max(i10, getTrackThickness() * 2);
        S s10 = this.f11181a;
        if (((e) s10).f11223g != max) {
            ((e) s10).f11223g = max;
            ((e) s10).e();
            invalidate();
        }
    }

    @Override // com.google.android.material.progressindicator.a
    public void setTrackThickness(int i10) {
        super.setTrackThickness(i10);
        ((e) this.f11181a).e();
    }

    public CircularProgressIndicator(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10, f11179o);
        s();
    }
}
