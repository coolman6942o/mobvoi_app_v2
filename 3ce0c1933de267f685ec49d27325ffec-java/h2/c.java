package h2;

import x2.d;
/* loaded from: classes.dex */
public class c implements g {
    @Override // h2.g
    public byte[] a(String str) {
        if (str == null) {
            return null;
        }
        return d.f(str);
    }

    @Override // h2.g
    public String b(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        return d.b(bArr);
    }
}
