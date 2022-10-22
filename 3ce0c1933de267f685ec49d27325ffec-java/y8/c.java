package y8;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AI01392xDecoder.java */
/* loaded from: classes.dex */
public final class c extends h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        super(aVar);
    }

    @Override // y8.j
    public String d() throws NotFoundException, FormatException {
        if (c().g() >= 48) {
            StringBuilder sb2 = new StringBuilder();
            f(sb2, 8);
            int f10 = b().f(48, 2);
            sb2.append("(392");
            sb2.append(f10);
            sb2.append(')');
            sb2.append(b().c(50, null).b());
            return sb2.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
