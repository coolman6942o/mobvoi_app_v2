package w1;

import a2.a;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.k;
/* compiled from: StorageNotLowTracker.java */
/* loaded from: classes.dex */
public class f extends c<Boolean> {

    /* renamed from: i  reason: collision with root package name */
    private static final String f35941i = k.f("StorageNotLowTracker");

    public f(Context context, a aVar) {
        super(context, aVar);
    }

    @Override // w1.c
    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_OK");
        intentFilter.addAction("android.intent.action.DEVICE_STORAGE_LOW");
        return intentFilter;
    }

    @Override // w1.c
    public void h(Context context, Intent intent) {
        if (intent.getAction() != null) {
            k.c().a(f35941i, String.format("Received %s", intent.getAction()), new Throwable[0]);
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                d(Boolean.FALSE);
            } else if (action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                d(Boolean.TRUE);
            }
        }
    }

    /* renamed from: i */
    public Boolean b() {
        Intent registerReceiver = this.f35929b.registerReceiver(null, g());
        if (registerReceiver == null || registerReceiver.getAction() == null) {
            return Boolean.TRUE;
        }
        String action = registerReceiver.getAction();
        action.hashCode();
        if (action.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
            return Boolean.FALSE;
        }
        if (!action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
            return null;
        }
        return Boolean.TRUE;
    }
}
