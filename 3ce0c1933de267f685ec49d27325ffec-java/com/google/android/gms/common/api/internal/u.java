package com.google.android.gms.common.api.internal;

import b7.b;
import com.google.android.gms.tasks.c;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class u implements b<TResult> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ c f8737a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ s f8738b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(s sVar, c cVar) {
        this.f8738b = sVar;
        this.f8737a = cVar;
    }

    @Override // b7.b
    public final void a(com.google.android.gms.tasks.b<TResult> bVar) {
        Map map;
        map = this.f8738b.f8722b;
        map.remove(this.f8737a);
    }
}
