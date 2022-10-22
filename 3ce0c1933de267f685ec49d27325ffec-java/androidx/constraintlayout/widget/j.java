package androidx.constraintlayout.widget;

import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.g;
/* compiled from: VirtualLayout.java */
/* loaded from: classes.dex */
public abstract class j extends a {

    /* renamed from: j  reason: collision with root package name */
    private boolean f2168j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2169k;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.a
    public void i(ConstraintLayout constraintLayout) {
        h(constraintLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.a
    public void m(AttributeSet attributeSet) {
        super.m(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, h.T0);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = obtainStyledAttributes.getIndex(i10);
                if (index == h.V0) {
                    this.f2168j = true;
                } else if (index == h.f1978a1) {
                    this.f2169k = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.a, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2168j || this.f2169k) {
            ViewParent parent = getParent();
            if (parent instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) parent;
                int visibility = getVisibility();
                float elevation = Build.VERSION.SDK_INT >= 21 ? getElevation() : 0.0f;
                for (int i10 = 0; i10 < this.f1837b; i10++) {
                    View r10 = constraintLayout.r(this.f1836a[i10]);
                    if (r10 != null) {
                        if (this.f2168j) {
                            r10.setVisibility(visibility);
                        }
                        if (this.f2169k && elevation > 0.0f && Build.VERSION.SDK_INT >= 21) {
                            r10.setTranslationZ(r10.getTranslationZ() + elevation);
                        }
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setElevation(float f10) {
        super.setElevation(f10);
        g();
    }

    @Override // android.view.View
    public void setVisibility(int i10) {
        super.setVisibility(i10);
        g();
    }

    public void t(g gVar, int i10, int i11) {
    }
}
