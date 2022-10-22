package com.bumptech.glide.load.engine;

import java.nio.ByteBuffer;
import java.security.MessageDigest;
import n5.g;
import n5.k;
import q4.b;
import q4.e;
/* compiled from: ResourceCacheKey.java */
/* loaded from: classes.dex */
final class t implements b {

    /* renamed from: j  reason: collision with root package name */
    private static final g<Class<?>, byte[]> f8045j = new g<>(50);

    /* renamed from: b  reason: collision with root package name */
    private final u4.b f8046b;

    /* renamed from: c  reason: collision with root package name */
    private final b f8047c;

    /* renamed from: d  reason: collision with root package name */
    private final b f8048d;

    /* renamed from: e  reason: collision with root package name */
    private final int f8049e;

    /* renamed from: f  reason: collision with root package name */
    private final int f8050f;

    /* renamed from: g  reason: collision with root package name */
    private final Class<?> f8051g;

    /* renamed from: h  reason: collision with root package name */
    private final e f8052h;

    /* renamed from: i  reason: collision with root package name */
    private final q4.g<?> f8053i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(u4.b bVar, b bVar2, b bVar3, int i10, int i11, q4.g<?> gVar, Class<?> cls, e eVar) {
        this.f8046b = bVar;
        this.f8047c = bVar2;
        this.f8048d = bVar3;
        this.f8049e = i10;
        this.f8050f = i11;
        this.f8053i = gVar;
        this.f8051g = cls;
        this.f8052h = eVar;
    }

    private byte[] c() {
        g<Class<?>, byte[]> gVar = f8045j;
        byte[] g10 = gVar.g(this.f8051g);
        if (g10 != null) {
            return g10;
        }
        byte[] bytes = this.f8051g.getName().getBytes(b.f32922a);
        gVar.k(this.f8051g, bytes);
        return bytes;
    }

    @Override // q4.b
    public void b(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f8046b.c(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f8049e).putInt(this.f8050f).array();
        this.f8048d.b(messageDigest);
        this.f8047c.b(messageDigest);
        messageDigest.update(bArr);
        q4.g<?> gVar = this.f8053i;
        if (gVar != null) {
            gVar.b(messageDigest);
        }
        this.f8052h.b(messageDigest);
        messageDigest.update(c());
        this.f8046b.d(bArr);
    }

    @Override // q4.b
    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.f8050f == tVar.f8050f && this.f8049e == tVar.f8049e && k.c(this.f8053i, tVar.f8053i) && this.f8051g.equals(tVar.f8051g) && this.f8047c.equals(tVar.f8047c) && this.f8048d.equals(tVar.f8048d) && this.f8052h.equals(tVar.f8052h);
    }

    @Override // q4.b
    public int hashCode() {
        int hashCode = (((((this.f8047c.hashCode() * 31) + this.f8048d.hashCode()) * 31) + this.f8049e) * 31) + this.f8050f;
        q4.g<?> gVar = this.f8053i;
        if (gVar != null) {
            hashCode = (hashCode * 31) + gVar.hashCode();
        }
        return (((hashCode * 31) + this.f8051g.hashCode()) * 31) + this.f8052h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f8047c + ", signature=" + this.f8048d + ", width=" + this.f8049e + ", height=" + this.f8050f + ", decodedResourceClass=" + this.f8051g + ", transformation='" + this.f8053i + "', options=" + this.f8052h + '}';
    }
}
