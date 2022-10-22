package h2;
/* loaded from: classes.dex */
public class b implements g {
    @Override // h2.g
    public byte[] a(String str) {
        if (str == null) {
            return null;
        }
        return str.getBytes();
    }

    @Override // h2.g
    public String b(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        return new String(bArr);
    }
}
