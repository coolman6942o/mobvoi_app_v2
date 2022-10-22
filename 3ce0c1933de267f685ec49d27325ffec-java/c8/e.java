package c8;

import android.content.BroadcastReceiver;
import android.content.Intent;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
final class e {

    /* renamed from: a  reason: collision with root package name */
    final Intent f5619a;

    /* renamed from: b  reason: collision with root package name */
    private final BroadcastReceiver.PendingResult f5620b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5621c = false;

    /* renamed from: d  reason: collision with root package name */
    private final ScheduledFuture<?> f5622d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Intent intent, BroadcastReceiver.PendingResult pendingResult, ScheduledExecutorService scheduledExecutorService) {
        this.f5619a = intent;
        this.f5620b = pendingResult;
        this.f5622d = scheduledExecutorService.schedule(new f(this, intent), 9500L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void a() {
        if (!this.f5621c) {
            this.f5620b.finish();
            this.f5622d.cancel(false);
            this.f5621c = true;
        }
    }
}
