package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m0 implements Iterator<String> {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<String> f9498a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ zzer f9499b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m0(zzer zzerVar) {
        Bundle bundle;
        this.f9499b = zzerVar;
        bundle = zzerVar.f9887a;
        this.f9498a = bundle.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9498a.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.f9498a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
