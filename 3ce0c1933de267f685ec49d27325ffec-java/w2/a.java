package w2;

import java.util.ArrayList;
import java.util.List;
import q2.b;
/* loaded from: classes.dex */
public class a implements o2.a {

    /* renamed from: a  reason: collision with root package name */
    /* synthetic */ byte[][] f35947a;

    public a(byte[][] bArr) {
        this.f35947a = null;
        this.f35947a = bArr;
    }

    @Override // o2.a
    public List<b> a() {
        byte[][] bArr;
        if (this.f35947a == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        b bVar = new b();
        bVar.e((byte) 0);
        bVar.f((byte) -92);
        for (byte[] bArr2 : this.f35947a) {
            if (bArr2 != null) {
                bVar.a(bArr2);
            }
        }
        arrayList.add(bVar);
        return arrayList;
    }
}
