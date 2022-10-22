package com.bumptech.glide.load.engine;

import java.security.MessageDigest;
import java.util.Map;
import n5.j;
import q4.b;
import q4.e;
import q4.g;
/* compiled from: EngineKey.java */
/* loaded from: classes.dex */
class m implements b {

    /* renamed from: b  reason: collision with root package name */
    private final Object f8009b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8010c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8011d;

    /* renamed from: e  reason: collision with root package name */
    private final Class<?> f8012e;

    /* renamed from: f  reason: collision with root package name */
    private final Class<?> f8013f;

    /* renamed from: g  reason: collision with root package name */
    private final b f8014g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<Class<?>, g<?>> f8015h;

    /* renamed from: i  reason: collision with root package name */
    private final e f8016i;

    /* renamed from: j  reason: collision with root package name */
    private int f8017j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(Object obj, b bVar, int i10, int i11, Map<Class<?>, g<?>> map, Class<?> cls, Class<?> cls2, e eVar) {
        this.f8009b = j.d(obj);
        this.f8014g = (b) j.e(bVar, "Signature must not be null");
        this.f8010c = i10;
        this.f8011d = i11;
        this.f8015h = (Map) j.d(map);
        this.f8012e = (Class) j.e(cls, "Resource class must not be null");
        this.f8013f = (Class) j.e(cls2, "Transcode class must not be null");
        this.f8016i = (e) j.d(eVar);
    }

    @Override // q4.b
    public void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // q4.b
    public boolean equals(Object obj) {
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return this.f8009b.equals(mVar.f8009b) && this.f8014g.equals(mVar.f8014g) && this.f8011d == mVar.f8011d && this.f8010c == mVar.f8010c && this.f8015h.equals(mVar.f8015h) && this.f8012e.equals(mVar.f8012e) && this.f8013f.equals(mVar.f8013f) && this.f8016i.equals(mVar.f8016i);
    }

    @Override // q4.b
    public int hashCode() {
        if (this.f8017j == 0) {
            int hashCode = this.f8009b.hashCode();
            this.f8017j = hashCode;
            int hashCode2 = (hashCode * 31) + this.f8014g.hashCode();
            this.f8017j = hashCode2;
            int i10 = (hashCode2 * 31) + this.f8010c;
            this.f8017j = i10;
            int i11 = (i10 * 31) + this.f8011d;
            this.f8017j = i11;
            int hashCode3 = (i11 * 31) + this.f8015h.hashCode();
            this.f8017j = hashCode3;
            int hashCode4 = (hashCode3 * 31) + this.f8012e.hashCode();
            this.f8017j = hashCode4;
            int hashCode5 = (hashCode4 * 31) + this.f8013f.hashCode();
            this.f8017j = hashCode5;
            this.f8017j = (hashCode5 * 31) + this.f8016i.hashCode();
        }
        return this.f8017j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f8009b + ", width=" + this.f8010c + ", height=" + this.f8011d + ", resourceClass=" + this.f8012e + ", transcodeClass=" + this.f8013f + ", signature=" + this.f8014g + ", hashCode=" + this.f8017j + ", transformations=" + this.f8015h + ", options=" + this.f8016i + '}';
    }
}
