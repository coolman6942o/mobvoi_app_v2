package qp;

import java.io.EOFException;
import kotlin.jvm.internal.i;
import okio.c;
import vo.f;
/* compiled from: utf8.kt */
/* loaded from: classes3.dex */
public final class a {
    public static final boolean a(c isProbablyUtf8) {
        long g10;
        i.f(isProbablyUtf8, "$this$isProbablyUtf8");
        try {
            c cVar = new c();
            g10 = f.g(isProbablyUtf8.i0(), 64L);
            isProbablyUtf8.o(cVar, 0L, g10);
            for (int i10 = 0; i10 < 16; i10++) {
                if (cVar.B()) {
                    return true;
                }
                int g02 = cVar.g0();
                if (Character.isISOControl(g02) && !Character.isWhitespace(g02)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
