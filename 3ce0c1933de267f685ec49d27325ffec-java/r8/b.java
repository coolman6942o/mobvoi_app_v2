package r8;

import r8.e;
/* compiled from: DataBlock.java */
/* loaded from: classes.dex */
final class b {

    /* renamed from: a  reason: collision with root package name */
    private final int f33444a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f33445b;

    private b(int i10, byte[] bArr) {
        this.f33444a = i10;
        this.f33445b = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b[] b(byte[] bArr, e eVar) {
        e.c d10 = eVar.d();
        e.b[] a10 = d10.a();
        int i10 = 0;
        for (e.b bVar : a10) {
            i10 += bVar.a();
        }
        b[] bVarArr = new b[i10];
        int i11 = 0;
        for (e.b bVar2 : a10) {
            for (int i12 = 0; i12 < bVar2.a(); i12++) {
                int b10 = bVar2.b();
                i11++;
                bVarArr[i11] = new b(b10, new byte[d10.b() + b10]);
            }
        }
        int length = bVarArr[0].f33445b.length - d10.b();
        int i13 = length - 1;
        int i14 = 0;
        for (int i15 = 0; i15 < i13; i15++) {
            for (int i16 = 0; i16 < i11; i16++) {
                i14++;
                bVarArr[i16].f33445b[i15] = bArr[i14];
            }
        }
        boolean z10 = eVar.i() == 24;
        int i17 = z10 ? 8 : i11;
        for (int i18 = 0; i18 < i17; i18++) {
            i14++;
            bVarArr[i18].f33445b[i13] = bArr[i14];
        }
        int length2 = bVarArr[0].f33445b.length;
        while (length < length2) {
            for (int i19 = 0; i19 < i11; i19++) {
                int i20 = z10 ? (i19 + 8) % i11 : i19;
                i14++;
                bVarArr[i20].f33445b[(!z10 || i20 <= 7) ? length : length - 1] = bArr[i14];
            }
            length++;
        }
        if (i14 == bArr.length) {
            return bVarArr;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] a() {
        return this.f33445b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f33444a;
    }
}
