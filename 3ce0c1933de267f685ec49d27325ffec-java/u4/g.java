package u4;
/* compiled from: ByteArrayAdapter.java */
/* loaded from: classes.dex */
public final class g implements a<byte[]> {
    @Override // u4.a
    public int a() {
        return 1;
    }

    @Override // u4.a
    public String b() {
        return "ByteArrayPool";
    }

    /* renamed from: d */
    public int c(byte[] bArr) {
        return bArr.length;
    }

    /* renamed from: e */
    public byte[] newArray(int i10) {
        return new byte[i10];
    }
}
