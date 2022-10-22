package ep;

import android.os.Build;
/* compiled from: BootloaderScannerFactory.java */
/* loaded from: classes3.dex */
public class b {
    public static a a() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new d();
        }
        return new c();
    }
}
