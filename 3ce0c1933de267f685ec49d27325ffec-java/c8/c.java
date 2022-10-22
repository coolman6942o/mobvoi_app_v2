package c8;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import i6.b;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import y0.a;
/* loaded from: classes.dex */
public abstract class c extends Service {

    /* renamed from: a  reason: collision with root package name */
    final ExecutorService f5611a;

    /* renamed from: b  reason: collision with root package name */
    private Binder f5612b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f5613c;

    /* renamed from: d  reason: collision with root package name */
    private int f5614d;

    /* renamed from: e  reason: collision with root package name */
    private int f5615e;

    public c() {
        String simpleName = getClass().getSimpleName();
        this.f5611a = Executors.newSingleThreadExecutor(new b(simpleName.length() != 0 ? "Firebase-".concat(simpleName) : new String("Firebase-")));
        this.f5613c = new Object();
        this.f5615e = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Intent intent) {
        if (intent != null) {
            a.c(intent);
        }
        synchronized (this.f5613c) {
            int i10 = this.f5615e - 1;
            this.f5615e = i10;
            if (i10 == 0) {
                stopSelfResult(this.f5614d);
            }
        }
    }

    protected abstract Intent c(Intent intent);

    public boolean d(Intent intent) {
        return false;
    }

    public abstract void e(Intent intent);

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.f5612b == null) {
            this.f5612b = new g(this);
        }
        return this.f5612b;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i10, int i11) {
        synchronized (this.f5613c) {
            this.f5614d = i11;
            this.f5615e++;
        }
        Intent c10 = c(intent);
        if (c10 == null) {
            a(intent);
            return 2;
        } else if (d(c10)) {
            a(intent);
            return 2;
        } else {
            this.f5611a.execute(new d(this, c10, intent));
            return 3;
        }
    }
}
