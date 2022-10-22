package aa;

import android.widget.Toast;
import com.mobvoi.android.common.utils.b;
/* compiled from: ToastUtils.java */
/* loaded from: classes2.dex */
public class c {
    public static void a(int i10) {
        Toast.makeText(b.e(), i10, 1).show();
    }

    public static void b(String str) {
        Toast.makeText(b.e(), str, 1).show();
    }

    public static void c(int i10) {
        Toast.makeText(b.e(), i10, 0).show();
    }

    public static void d(String str) {
        Toast.makeText(b.e(), str, 0).show();
    }
}
