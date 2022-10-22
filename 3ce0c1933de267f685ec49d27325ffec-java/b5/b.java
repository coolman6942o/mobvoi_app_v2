package b5;

import n5.j;
import t4.c;
/* compiled from: BytesResource.java */
/* loaded from: classes.dex */
public class b implements c<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f5040a;

    public b(byte[] bArr) {
        this.f5040a = (byte[]) j.d(bArr);
    }

    /* renamed from: a */
    public byte[] get() {
        return this.f5040a;
    }

    @Override // t4.c
    public void b() {
    }

    @Override // t4.c
    public int c() {
        return this.f5040a.length;
    }

    @Override // t4.c
    public Class<byte[]> d() {
        return byte[].class;
    }
}
