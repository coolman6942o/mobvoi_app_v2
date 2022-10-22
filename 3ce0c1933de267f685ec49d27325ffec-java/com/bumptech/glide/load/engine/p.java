package com.bumptech.glide.load.engine;

import java.util.HashMap;
import java.util.Map;
import q4.b;
/* compiled from: Jobs.java */
/* loaded from: classes.dex */
final class p {

    /* renamed from: a  reason: collision with root package name */
    private final Map<b, k<?>> f8025a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<b, k<?>> f8026b = new HashMap();

    private Map<b, k<?>> b(boolean z10) {
        return z10 ? this.f8026b : this.f8025a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k<?> a(b bVar, boolean z10) {
        return b(z10).get(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(b bVar, k<?> kVar) {
        b(kVar.p()).put(bVar, kVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(b bVar, k<?> kVar) {
        Map<b, k<?>> b10 = b(kVar.p());
        if (kVar.equals(b10.get(bVar))) {
            b10.remove(bVar);
        }
    }
}
