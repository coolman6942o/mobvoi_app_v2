package com.huawei.hms.mlkit.common.ha;

import java.util.TimerTask;
/* compiled from: HianalyticsOnReportTask.java */
/* loaded from: classes2.dex */
public final class e extends TimerTask {
    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        try {
            c cVar = c.f14068a;
            c.a();
        } catch (Exception unused) {
            b.c("HaLogOnReport", "Failed to report hianalytics data");
        }
    }
}
