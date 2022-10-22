package n1;

import android.annotation.SuppressLint;
import android.view.View;
/* compiled from: ViewUtilsApi22.java */
/* loaded from: classes.dex */
class f0 extends e0 {

    /* renamed from: h  reason: collision with root package name */
    private static boolean f30903h = true;

    @Override // n1.i0
    @SuppressLint({"NewApi"})
    public void e(View view, int i10, int i11, int i12, int i13) {
        if (f30903h) {
            try {
                view.setLeftTopRightBottom(i10, i11, i12, i13);
            } catch (NoSuchMethodError unused) {
                f30903h = false;
            }
        }
    }
}
