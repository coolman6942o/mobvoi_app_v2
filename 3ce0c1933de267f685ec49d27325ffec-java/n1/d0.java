package n1;

import android.annotation.SuppressLint;
import android.view.View;
/* compiled from: ViewUtilsApi19.java */
/* loaded from: classes.dex */
class d0 extends i0 {

    /* renamed from: e  reason: collision with root package name */
    private static boolean f30889e = true;

    @Override // n1.i0
    public void a(View view) {
    }

    @Override // n1.i0
    @SuppressLint({"NewApi"})
    public float c(View view) {
        if (f30889e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f30889e = false;
            }
        }
        return view.getAlpha();
    }

    @Override // n1.i0
    public void d(View view) {
    }

    @Override // n1.i0
    @SuppressLint({"NewApi"})
    public void f(View view, float f10) {
        if (f30889e) {
            try {
                view.setTransitionAlpha(f10);
                return;
            } catch (NoSuchMethodError unused) {
                f30889e = false;
            }
        }
        view.setAlpha(f10);
    }
}
