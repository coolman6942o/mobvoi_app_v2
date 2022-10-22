package y8;

import com.google.zxing.common.a;
import com.laser.tsm.sdk.AppConfig;
/* compiled from: AI01weightDecoder.java */
/* loaded from: classes.dex */
abstract class i extends h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar) {
        super(aVar);
    }

    protected abstract void h(StringBuilder sb2, int i10);

    protected abstract int i(int i10);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j(StringBuilder sb2, int i10, int i11) {
        int f10 = b().f(i10, i11);
        h(sb2, f10);
        int i12 = i(f10);
        int i13 = AppConfig.STATUS_SUCCESS;
        for (int i14 = 0; i14 < 5; i14++) {
            if (i12 / i13 == 0) {
                sb2.append('0');
            }
            i13 /= 10;
        }
        sb2.append(i12);
    }
}
