package com.google.android.gms.wearable;

import com.google.android.gms.wearable.m;
import java.util.List;
/* loaded from: classes.dex */
final class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ List f10334a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ m.d f10335b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(m.d dVar, List list) {
        this.f10335b = dVar;
        this.f10334a = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        m.this.onConnectedNodes(this.f10334a);
    }
}
