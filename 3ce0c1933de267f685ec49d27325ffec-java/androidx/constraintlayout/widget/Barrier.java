package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.a;
/* loaded from: classes.dex */
public class Barrier extends a {

    /* renamed from: j  reason: collision with root package name */
    private int f1751j;

    /* renamed from: k  reason: collision with root package name */
    private int f1752k;

    /* renamed from: l  reason: collision with root package name */
    private a f1753l;

    public Barrier(Context context) {
        super(context);
        super.setVisibility(8);
    }

    private void t(ConstraintWidget constraintWidget, int i10, boolean z10) {
        this.f1752k = i10;
        if (Build.VERSION.SDK_INT < 17) {
            int i11 = this.f1751j;
            if (i11 == 5) {
                this.f1752k = 0;
            } else if (i11 == 6) {
                this.f1752k = 1;
            }
        } else if (z10) {
            int i12 = this.f1751j;
            if (i12 == 5) {
                this.f1752k = 1;
            } else if (i12 == 6) {
                this.f1752k = 0;
            }
        } else {
            int i13 = this.f1751j;
            if (i13 == 5) {
                this.f1752k = 0;
            } else if (i13 == 6) {
                this.f1752k = 1;
            }
        }
        if (constraintWidget instanceof a) {
            ((a) constraintWidget).r1(this.f1752k);
        }
    }

    public boolean getAllowsGoneWidget() {
        return this.f1753l.l1();
    }

    public int getMargin() {
        return this.f1753l.n1();
    }

    public int getType() {
        return this.f1751j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.a
    public void m(AttributeSet attributeSet) {
        super.m(attributeSet);
        this.f1753l = new a();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.T0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == h.f1994c1) {
                    setType(obtainStyledAttributes.getInt(index, 0));
                } else if (index == h.f1986b1) {
                    this.f1753l.q1(obtainStyledAttributes.getBoolean(index, true));
                } else if (index == h.f2002d1) {
                    this.f1753l.s1(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.f1839d = this.f1753l;
        s();
    }

    @Override // androidx.constraintlayout.widget.a
    public void n(ConstraintWidget constraintWidget, boolean z10) {
        t(constraintWidget, this.f1751j, z10);
    }

    public void setAllowsGoneWidget(boolean z10) {
        this.f1753l.q1(z10);
    }

    public void setDpMargin(int i10) {
        a aVar = this.f1753l;
        aVar.s1((int) ((i10 * getResources().getDisplayMetrics().density) + 0.5f));
    }

    public void setMargin(int i10) {
        this.f1753l.s1(i10);
    }

    public void setType(int i10) {
        this.f1751j = i10;
    }

    public Barrier(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setVisibility(8);
    }
}
