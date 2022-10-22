package y8;

import com.google.zxing.common.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AI01320xDecoder.java */
/* loaded from: classes.dex */
public final class b extends f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        super(aVar);
    }

    @Override // y8.i
    protected void h(StringBuilder sb2, int i10) {
        if (i10 < 10000) {
            sb2.append("(3202)");
        } else {
            sb2.append("(3203)");
        }
    }

    @Override // y8.i
    protected int i(int i10) {
        return i10 < 10000 ? i10 : i10 - 10000;
    }
}
