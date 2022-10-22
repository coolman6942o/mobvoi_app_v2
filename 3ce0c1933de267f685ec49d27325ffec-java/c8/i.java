package c8;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import g6.a;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
/* loaded from: classes.dex */
public final class i implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5628a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f5629b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f5630c;

    /* renamed from: d  reason: collision with root package name */
    private final Queue<e> f5631d;

    /* renamed from: e  reason: collision with root package name */
    private g f5632e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f5633f;

    public i(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0));
    }

    private i(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f5631d = new ArrayDeque();
        this.f5633f = false;
        Context applicationContext = context.getApplicationContext();
        this.f5628a = applicationContext;
        this.f5629b = new Intent(str).setPackage(applicationContext.getPackageName());
        this.f5630c = scheduledExecutorService;
    }

    private final synchronized void b() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "flush queue called");
        }
        while (!this.f5631d.isEmpty()) {
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "found intent to be delivered");
            }
            g gVar = this.f5632e;
            if (gVar == null || !gVar.isBinderAlive()) {
                if (Log.isLoggable("EnhancedIntentService", 3)) {
                    boolean z10 = !this.f5633f;
                    StringBuilder sb2 = new StringBuilder(39);
                    sb2.append("binder is dead. start connection? ");
                    sb2.append(z10);
                    Log.d("EnhancedIntentService", sb2.toString());
                }
                if (!this.f5633f) {
                    this.f5633f = true;
                    try {
                    } catch (SecurityException e10) {
                        Log.e("EnhancedIntentService", "Exception while binding the service", e10);
                    }
                    if (!a.b().a(this.f5628a, this.f5629b, this, 65)) {
                        Log.e("EnhancedIntentService", "binding to the service failed");
                        while (!this.f5631d.isEmpty()) {
                            this.f5631d.poll().a();
                        }
                    } else {
                        return;
                    }
                }
                return;
            }
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                Log.d("EnhancedIntentService", "binder is alive, sending the intent.");
            }
            this.f5632e.b(this.f5631d.poll());
        }
    }

    public final synchronized void a(Intent intent, BroadcastReceiver.PendingResult pendingResult) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
        }
        this.f5631d.add(new e(intent, pendingResult, this.f5630c));
        b();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this) {
            this.f5633f = false;
            this.f5632e = (g) iBinder;
            if (Log.isLoggable("EnhancedIntentService", 3)) {
                String valueOf = String.valueOf(componentName);
                StringBuilder sb2 = new StringBuilder(valueOf.length() + 20);
                sb2.append("onServiceConnected: ");
                sb2.append(valueOf);
                Log.d("EnhancedIntentService", sb2.toString());
            }
            b();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 23);
            sb2.append("onServiceDisconnected: ");
            sb2.append(valueOf);
            Log.d("EnhancedIntentService", sb2.toString());
        }
        b();
    }
}
