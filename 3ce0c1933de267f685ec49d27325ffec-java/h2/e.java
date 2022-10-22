package h2;

import x2.c;
/* loaded from: classes.dex */
public class e implements g {
    @Override // h2.g
    public byte[] a(String str) {
        if (str == null) {
            return null;
        }
        return c.m(str);
    }

    @Override // h2.g
    public String b(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        return c.c(bArr);
    }
}
