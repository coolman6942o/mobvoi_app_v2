package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import androidx.work.k;
import androidx.work.l;
import androidx.work.r;
/* loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f4816a = k.f("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            k.c().a(f4816a, "Requesting diagnostics", new Throwable[0]);
            try {
                r.c(context).a(l.d(DiagnosticsWorker.class));
            } catch (IllegalStateException e10) {
                k.c().b(f4816a, "WorkManager is not initialized", e10);
            }
        }
    }
}
