package n1;

import android.annotation.SuppressLint;
import android.graphics.Matrix;
import android.view.View;
/* compiled from: ViewUtilsApi21.java */
/* loaded from: classes.dex */
class e0 extends d0 {

    /* renamed from: f  reason: collision with root package name */
    private static boolean f30901f = true;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f30902g = true;

    @Override // n1.i0
    @SuppressLint({"NewApi"})
    public void h(View view, Matrix matrix) {
        if (f30901f) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f30901f = false;
            }
        }
    }

    @Override // n1.i0
    @SuppressLint({"NewApi"})
    public void i(View view, Matrix matrix) {
        if (f30902g) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f30902g = false;
            }
        }
    }
}
