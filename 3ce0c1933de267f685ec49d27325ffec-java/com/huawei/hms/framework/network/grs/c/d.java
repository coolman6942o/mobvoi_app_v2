package com.huawei.hms.framework.network.grs.c;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Callable<f> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ExecutorService f13880a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f13881b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ e f13882c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(e eVar, ExecutorService executorService, String str) {
        this.f13882c = eVar;
        this.f13880a = executorService;
        this.f13881b = str;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Callable
    public f call() {
        f b10;
        b10 = this.f13882c.b(this.f13880a, this.f13881b);
        return b10;
    }
}
