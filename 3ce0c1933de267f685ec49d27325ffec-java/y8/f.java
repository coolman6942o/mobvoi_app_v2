package y8;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.a;
/* compiled from: AI013x0xDecoder.java */
/* loaded from: classes.dex */
abstract class f extends i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public f(a aVar) {
        super(aVar);
    }

    @Override // y8.j
    public String d() throws NotFoundException {
        if (c().g() == 60) {
            StringBuilder sb2 = new StringBuilder();
            f(sb2, 5);
            j(sb2, 45, 15);
            return sb2.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
