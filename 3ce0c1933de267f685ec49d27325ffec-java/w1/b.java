package w1;

import a2.a;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.work.k;
import com.mobvoi.wear.permission.PermissionConstant;
/* compiled from: BatteryNotLowTracker.java */
/* loaded from: classes.dex */
public class b extends c<Boolean> {

    /* renamed from: i  reason: collision with root package name */
    private static final String f35923i = k.f("BatteryNotLowTracker");

    public b(Context context, a aVar) {
        super(context, aVar);
    }

    @Override // w1.c
    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.BATTERY_OKAY");
        intentFilter.addAction("android.intent.action.BATTERY_LOW");
        return intentFilter;
    }

    @Override // w1.c
    public void h(Context context, Intent intent) {
        if (intent.getAction() != null) {
            k.c().a(f35923i, String.format("Received %s", intent.getAction()), new Throwable[0]);
            String action = intent.getAction();
            action.hashCode();
            if (action.equals("android.intent.action.BATTERY_OKAY")) {
                d(Boolean.TRUE);
            } else if (action.equals("android.intent.action.BATTERY_LOW")) {
                d(Boolean.FALSE);
            }
        }
    }

    /* renamed from: i */
    public Boolean b() {
        Intent registerReceiver = this.f35929b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z10 = false;
        if (registerReceiver == null) {
            k.c().b(f35923i, "getInitialState - null intent received", new Throwable[0]);
            return null;
        }
        float intExtra = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
        if (registerReceiver.getIntExtra(PermissionConstant.Columns.STATUS, -1) == 1 || intExtra > 0.15f) {
            z10 = true;
        }
        return Boolean.valueOf(z10);
    }
}
