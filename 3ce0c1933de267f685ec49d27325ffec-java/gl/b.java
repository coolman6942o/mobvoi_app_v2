package gl;

import android.content.Context;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public a f27493a;

    public b(Context context, int i10) {
        this.f27493a = a(context, i10);
    }

    public a a(Context context, int i10) {
        if (i10 >= 21) {
            return new d(context);
        }
        if (i10 >= 18) {
            return new c(context);
        }
        return null;
    }

    public boolean b(ScannerParams scannerParams, boolean z10) {
        a aVar = this.f27493a;
        if (!z10) {
            return aVar.a();
        }
        if (aVar.f27489c.isEnabled()) {
            return aVar.b(scannerParams);
        }
        il.b.c("BT Adapter is not enable");
        return false;
    }
}
