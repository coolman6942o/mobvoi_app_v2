package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
/* compiled from: Constraints.java */
/* loaded from: classes.dex */
public class d extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    c f1963a;

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2);
    }

    /* renamed from: b */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public c getConstraintSet() {
        if (this.f1963a == null) {
            this.f1963a = new c();
        }
        this.f1963a.h(this);
        return this.f1963a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.b(layoutParams);
    }

    /* compiled from: Constraints.java */
    /* loaded from: classes.dex */
    public static class a extends ConstraintLayout.b {
        public float A0;
        public float B0;
        public float C0;
        public float D0;

        /* renamed from: r0  reason: collision with root package name */
        public float f1964r0;

        /* renamed from: s0  reason: collision with root package name */
        public boolean f1965s0;

        /* renamed from: t0  reason: collision with root package name */
        public float f1966t0;

        /* renamed from: u0  reason: collision with root package name */
        public float f1967u0;

        /* renamed from: v0  reason: collision with root package name */
        public float f1968v0;

        /* renamed from: w0  reason: collision with root package name */
        public float f1969w0;

        /* renamed from: x0  reason: collision with root package name */
        public float f1970x0;

        /* renamed from: y0  reason: collision with root package name */
        public float f1971y0;

        /* renamed from: z0  reason: collision with root package name */
        public float f1972z0;

        public a(int i10, int i11) {
            super(i10, i11);
            this.f1964r0 = 1.0f;
            this.f1965s0 = false;
            this.f1966t0 = 0.0f;
            this.f1967u0 = 0.0f;
            this.f1968v0 = 0.0f;
            this.f1969w0 = 0.0f;
            this.f1970x0 = 1.0f;
            this.f1971y0 = 1.0f;
            this.f1972z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1964r0 = 1.0f;
            this.f1965s0 = false;
            this.f1966t0 = 0.0f;
            this.f1967u0 = 0.0f;
            this.f1968v0 = 0.0f;
            this.f1969w0 = 0.0f;
            this.f1970x0 = 1.0f;
            this.f1971y0 = 1.0f;
            this.f1972z0 = 0.0f;
            this.A0 = 0.0f;
            this.B0 = 0.0f;
            this.C0 = 0.0f;
            this.D0 = 0.0f;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, h.O3);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == h.P3) {
                    this.f1964r0 = obtainStyledAttributes.getFloat(index, this.f1964r0);
                } else if (index == h.f1981a4) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        this.f1966t0 = obtainStyledAttributes.getFloat(index, this.f1966t0);
                        this.f1965s0 = true;
                    }
                } else if (index == h.X3) {
                    this.f1968v0 = obtainStyledAttributes.getFloat(index, this.f1968v0);
                } else if (index == h.Y3) {
                    this.f1969w0 = obtainStyledAttributes.getFloat(index, this.f1969w0);
                } else if (index == h.W3) {
                    this.f1967u0 = obtainStyledAttributes.getFloat(index, this.f1967u0);
                } else if (index == h.U3) {
                    this.f1970x0 = obtainStyledAttributes.getFloat(index, this.f1970x0);
                } else if (index == h.V3) {
                    this.f1971y0 = obtainStyledAttributes.getFloat(index, this.f1971y0);
                } else if (index == h.Q3) {
                    this.f1972z0 = obtainStyledAttributes.getFloat(index, this.f1972z0);
                } else if (index == h.R3) {
                    this.A0 = obtainStyledAttributes.getFloat(index, this.A0);
                } else if (index == h.S3) {
                    this.B0 = obtainStyledAttributes.getFloat(index, this.B0);
                } else if (index == h.T3) {
                    this.C0 = obtainStyledAttributes.getFloat(index, this.C0);
                } else if (index == h.Z3 && Build.VERSION.SDK_INT >= 21) {
                    this.D0 = obtainStyledAttributes.getFloat(index, this.D0);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }
}
