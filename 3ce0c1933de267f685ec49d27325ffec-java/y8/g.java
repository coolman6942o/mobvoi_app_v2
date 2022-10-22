package y8;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AI01AndOtherAIs.java */
/* loaded from: classes.dex */
public final class g extends h {
    /* JADX INFO: Access modifiers changed from: package-private */
    public g(a aVar) {
        super(aVar);
    }

    @Override // y8.j
    public String d() throws NotFoundException, FormatException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(01)");
        int length = sb2.length();
        sb2.append(b().f(4, 4));
        g(sb2, 8, length);
        return b().a(sb2, 48);
    }
}
