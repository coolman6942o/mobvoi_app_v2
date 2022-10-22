package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.p.Ta;
import com.huawei.hms.scankit.util.a;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HaLog60001.java */
/* loaded from: classes2.dex */
public class Ua extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Ta.b f14692a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ua(Ta.b bVar) {
        this.f14692a = bVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        String str;
        try {
            this.f14692a.f14660c = true;
            this.f14692a.a();
        } catch (Exception unused) {
            str = this.f14692a.f14658a;
            a.b(str, "onLog Exception");
        }
    }
}
