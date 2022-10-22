package q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import x2.c;
import x2.d;
import x2.h;
import z2.b;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ List<b> f32910a = new ArrayList();

    public void a(b bVar) {
        this.f32910a.add(bVar);
    }

    public byte[] b(byte[] bArr) {
        byte[][] c10;
        z2.a b10 = b.a().b();
        if (bArr == null || bArr.length < 5) {
            if (b10 != null) {
                b10.c(a.class.getName(), d.c("讠氊辞溮旭\uff00诪汌支挾乌呚沖", 4));
            }
            return null;
        } else if (this.f32910a.size() < 1) {
            return null;
        } else {
            for (b bVar : this.f32910a) {
                if (bVar != null) {
                    if (bVar.b() == bArr[0] && bVar.d() == bArr[1]) {
                        byte[] copyOfRange = Arrays.copyOfRange(bArr, 5, bArr.length);
                        for (byte[] bArr2 : bVar.c()) {
                            if (Arrays.equals(bArr2, copyOfRange)) {
                                if (b10 != null) {
                                    b10.a(a.class.getName(), h.e("m+1#菱厉盜\u0010\u0003\u0007＆", 5, 121) + c.c(bArr2));
                                }
                                return bArr2;
                            }
                        }
                        continue;
                    }
                }
            }
            return null;
        }
    }
}
