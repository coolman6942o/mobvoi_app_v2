package c8;

import android.content.Intent;
import android.util.Log;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Intent f5623a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ e f5624b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, Intent intent) {
        this.f5624b = eVar;
        this.f5623a = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String action = this.f5623a.getAction();
        StringBuilder sb2 = new StringBuilder(String.valueOf(action).length() + 61);
        sb2.append("Service took too long to process intent: ");
        sb2.append(action);
        sb2.append(" App may get closed.");
        Log.w("EnhancedIntentService", sb2.toString());
        this.f5624b.a();
    }
}
