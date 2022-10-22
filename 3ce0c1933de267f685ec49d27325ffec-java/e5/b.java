package e5;

import android.graphics.Bitmap;
import p4.a;
import u4.e;
/* compiled from: GifBitmapProvider.java */
/* loaded from: classes.dex */
public final class b implements a.AbstractC0451a {

    /* renamed from: a  reason: collision with root package name */
    private final e f25785a;

    /* renamed from: b  reason: collision with root package name */
    private final u4.b f25786b;

    public b(e eVar, u4.b bVar) {
        this.f25785a = eVar;
        this.f25786b = bVar;
    }

    @Override // p4.a.AbstractC0451a
    public Bitmap a(int i10, int i11, Bitmap.Config config) {
        return this.f25785a.e(i10, i11, config);
    }

    @Override // p4.a.AbstractC0451a
    public int[] b(int i10) {
        u4.b bVar = this.f25786b;
        if (bVar == null) {
            return new int[i10];
        }
        return (int[]) bVar.e(i10, int[].class);
    }

    @Override // p4.a.AbstractC0451a
    public void c(Bitmap bitmap) {
        this.f25785a.c(bitmap);
    }

    @Override // p4.a.AbstractC0451a
    public void d(byte[] bArr) {
        u4.b bVar = this.f25786b;
        if (bVar != null) {
            bVar.d(bArr);
        }
    }

    @Override // p4.a.AbstractC0451a
    public byte[] e(int i10) {
        u4.b bVar = this.f25786b;
        if (bVar == null) {
            return new byte[i10];
        }
        return (byte[]) bVar.e(i10, byte[].class);
    }

    @Override // p4.a.AbstractC0451a
    public void f(int[] iArr) {
        u4.b bVar = this.f25786b;
        if (bVar != null) {
            bVar.d(iArr);
        }
    }
}
