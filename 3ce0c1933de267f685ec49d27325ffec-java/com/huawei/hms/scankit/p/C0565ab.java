package com.huawei.hms.scankit.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HiAnalyticsLogExecutor.java */
/* renamed from: com.huawei.hms.scankit.p.ab  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C0565ab extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0569bb f14740a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0565ab(C0569bb bbVar, String str) {
        super(str);
        this.f14740a = bbVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.f14740a.d();
    }
}
