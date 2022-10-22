package com.huawei.hms.scankit.p;

import android.util.SparseArray;
import com.huawei.hms.scankit.p.Ta;
import java.util.concurrent.atomic.AtomicInteger;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HaLog60001.java */
/* loaded from: classes2.dex */
public class Va extends SparseArray<AtomicInteger> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Ta.b.C0181b f14701a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Va(Ta.b.C0181b bVar) {
        this.f14701a = bVar;
        put(0, new AtomicInteger());
    }
}
