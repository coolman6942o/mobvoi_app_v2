package androidx.constraintlayout.motion.widget;

import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.j;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.a;
/* compiled from: MotionHelper.java */
/* loaded from: classes.dex */
public class h extends a implements j.d {

    /* renamed from: j  reason: collision with root package name */
    private boolean f1700j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1701k;

    /* renamed from: l  reason: collision with root package name */
    private float f1702l;

    /* renamed from: m  reason: collision with root package name */
    protected View[] f1703m;

    @Override // androidx.constraintlayout.motion.widget.j.d
    public void a(j jVar, int i10, int i11, float f10) {
    }

    @Override // androidx.constraintlayout.motion.widget.j.d
    public void b(j jVar, int i10, int i11) {
    }

    @Override // androidx.constraintlayout.motion.widget.j.d
    public void c(j jVar, int i10) {
    }

    public float getProgress() {
        return this.f1702l;
    }

    @Override // androidx.constraintlayout.widget.a
    protected void m(AttributeSet attributeSet) {
        super.m(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.constraintlayout.widget.h.H5);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == androidx.constraintlayout.widget.h.J5) {
                    this.f1700j = obtainStyledAttributes.getBoolean(index, this.f1700j);
                } else if (index == androidx.constraintlayout.widget.h.I5) {
                    this.f1701k = obtainStyledAttributes.getBoolean(index, this.f1701k);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public void setProgress(float f10) {
        this.f1702l = f10;
        int i10 = 0;
        if (this.f1837b > 0) {
            this.f1703m = l((ConstraintLayout) getParent());
            while (i10 < this.f1837b) {
                x(this.f1703m[i10], f10);
                i10++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i10 < childCount) {
            View childAt = viewGroup.getChildAt(i10);
            if (!(childAt instanceof h)) {
                x(childAt, f10);
            }
            i10++;
        }
    }

    public boolean t() {
        return false;
    }

    public boolean u() {
        return this.f1701k;
    }

    public boolean v() {
        return this.f1700j;
    }

    public void w(Canvas canvas) {
    }

    public void x(View view, float f10) {
    }
}
