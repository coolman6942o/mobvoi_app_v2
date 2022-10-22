package h2;

import java.io.UnsupportedEncodingException;
import x2.b;
import x2.f;
/* loaded from: classes.dex */
public class d implements g {
    @Override // h2.g
    public byte[] a(String str) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(f.a("kkm", 4));
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    @Override // h2.g
    public String b(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        try {
            return new String(bArr, b.b(4, "v~l"));
        } catch (UnsupportedEncodingException e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
