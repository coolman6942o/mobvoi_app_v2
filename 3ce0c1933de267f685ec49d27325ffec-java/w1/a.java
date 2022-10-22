package w1;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.work.k;
import com.mobvoi.wear.permission.PermissionConstant;
/* compiled from: BatteryChargingTracker.java */
/* loaded from: classes.dex */
public class a extends c<Boolean> {

    /* renamed from: i  reason: collision with root package name */
    private static final String f35922i = k.f("BatteryChrgTracker");

    public a(Context context, a2.a aVar) {
        super(context, aVar);
    }

    private boolean j(Intent intent) {
        if (Build.VERSION.SDK_INT >= 23) {
            int intExtra = intent.getIntExtra(PermissionConstant.Columns.STATUS, -1);
            if (intExtra == 2 || intExtra == 5) {
                return true;
            }
        } else if (intent.getIntExtra("plugged", 0) != 0) {
            return true;
        }
        return false;
    }

    @Override // w1.c
    public IntentFilter g() {
        IntentFilter intentFilter = new IntentFilter();
        if (Build.VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.CHARGING");
            intentFilter.addAction("android.os.action.DISCHARGING");
        } else {
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        return intentFilter;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (r6.equals("android.os.action.DISCHARGING") == false) goto L7;
     */
    @Override // w1.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(Context context, Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            char c10 = 1;
            k.c().a(f35922i, String.format("Received %s", action), new Throwable[0]);
            c10 = 65535;
            switch (action.hashCode()) {
                case -1886648615:
                    if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -54942926:
                    break;
                case 948344062:
                    if (action.equals("android.os.action.CHARGING")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 1019184907:
                    if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                        c10 = 3;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                    d(Boolean.FALSE);
                    return;
                case 1:
                    d(Boolean.FALSE);
                    return;
                case 2:
                    d(Boolean.TRUE);
                    return;
                case 3:
                    d(Boolean.TRUE);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: i */
    public Boolean b() {
        Intent registerReceiver = this.f35929b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return Boolean.valueOf(j(registerReceiver));
        }
        k.c().b(f35922i, "getInitialState - null intent received", new Throwable[0]);
        return null;
    }
}
