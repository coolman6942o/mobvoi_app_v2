package com.google.android.gms.wearable;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.m;
/* loaded from: classes.dex */
final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ DataHolder f10326a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ m.d f10327b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(m.d dVar, DataHolder dataHolder) {
        this.f10327b = dVar;
        this.f10326a = dataHolder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        e eVar = new e(this.f10326a);
        try {
            m.this.onDataChanged(eVar);
        } finally {
            eVar.release();
        }
    }
}
