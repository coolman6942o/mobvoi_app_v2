package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
/* loaded from: classes.dex */
public class Group extends a {
    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.a
    public void i(ConstraintLayout constraintLayout) {
        h(constraintLayout);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.a
    public void m(AttributeSet attributeSet) {
        super.m(attributeSet);
        this.f1840e = false;
    }

    @Override // androidx.constraintlayout.widget.a
    public void o(ConstraintLayout constraintLayout) {
        ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
        bVar.f1817q0.b1(0);
        bVar.f1817q0.C0(0);
    }

    @Override // androidx.constraintlayout.widget.a, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        g();
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
}
