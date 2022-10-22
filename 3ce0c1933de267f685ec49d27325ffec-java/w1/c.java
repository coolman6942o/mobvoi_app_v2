package w1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.k;
/* compiled from: BroadcastReceiverConstraintTracker.java */
/* loaded from: classes.dex */
public abstract class c<T> extends d<T> {

    /* renamed from: h  reason: collision with root package name */
    private static final String f35924h = k.f("BrdcstRcvrCnstrntTrckr");

    /* renamed from: g  reason: collision with root package name */
    private final BroadcastReceiver f35925g = new a();

    /* compiled from: BroadcastReceiverConstraintTracker.java */
    /* loaded from: classes.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent != null) {
                c.this.h(context, intent);
            }
        }
    }

    public c(Context context, a2.a aVar) {
        super(context, aVar);
    }

    @Override // w1.d
    public void e() {
        k.c().a(f35924h, String.format("%s: registering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f35929b.registerReceiver(this.f35925g, g());
    }

    @Override // w1.d
    public void f() {
        k.c().a(f35924h, String.format("%s: unregistering receiver", getClass().getSimpleName()), new Throwable[0]);
        this.f35929b.unregisterReceiver(this.f35925g);
    }

    public abstract IntentFilter g();

    public abstract void h(Context context, Intent intent);
}
