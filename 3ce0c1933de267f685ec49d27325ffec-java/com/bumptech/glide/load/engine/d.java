package com.bumptech.glide.load.engine;

import java.security.MessageDigest;
import q4.b;
/* compiled from: DataCacheKey.java */
/* loaded from: classes.dex */
final class d implements b {

    /* renamed from: b  reason: collision with root package name */
    private final b f7886b;

    /* renamed from: c  reason: collision with root package name */
    private final b f7887c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, b bVar2) {
        this.f7886b = bVar;
        this.f7887c = bVar2;
    }

    @Override // q4.b
    public void b(MessageDigest messageDigest) {
        this.f7886b.b(messageDigest);
        this.f7887c.b(messageDigest);
    }

    @Override // q4.b
    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f7886b.equals(dVar.f7886b) && this.f7887c.equals(dVar.f7887c);
    }

    @Override // q4.b
    public int hashCode() {
        return (this.f7886b.hashCode() * 31) + this.f7887c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f7886b + ", signature=" + this.f7887c + '}';
    }
}
