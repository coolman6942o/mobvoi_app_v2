package n1;

import android.graphics.Matrix;
import android.view.View;
/* compiled from: ViewUtilsApi29.java */
/* loaded from: classes.dex */
class h0 extends g0 {
    @Override // n1.d0, n1.i0
    public float c(View view) {
        return view.getTransitionAlpha();
    }

    @Override // n1.f0, n1.i0
    public void e(View view, int i10, int i11, int i12, int i13) {
        view.setLeftTopRightBottom(i10, i11, i12, i13);
    }

    @Override // n1.d0, n1.i0
    public void f(View view, float f10) {
        view.setTransitionAlpha(f10);
    }

    @Override // n1.g0, n1.i0
    public void g(View view, int i10) {
        view.setTransitionVisibility(i10);
    }

    @Override // n1.e0, n1.i0
    public void h(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // n1.e0, n1.i0
    public void i(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
