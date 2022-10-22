package ci;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.TelephonyManager;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import hc.e;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: PhoneDeviceInfoManager.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    private static final IntentFilter f5905c = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");

    /* renamed from: d  reason: collision with root package name */
    private static volatile b f5906d;

    /* renamed from: a  reason: collision with root package name */
    private final List<AbstractC0085b> f5907a = new CopyOnWriteArrayList();

    /* renamed from: b  reason: collision with root package name */
    private BroadcastReceiver f5908b = new a();

    /* compiled from: PhoneDeviceInfoManager.java */
    /* loaded from: classes2.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            k.c("DeviceBluetoothManager", "onReceive %s", intent);
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
            if (intExtra == 12) {
                b.this.c(true);
            } else if (intExtra == 10) {
                b.this.c(false);
            }
        }
    }

    /* compiled from: PhoneDeviceInfoManager.java */
    /* renamed from: ci.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface AbstractC0085b {
        void y(boolean z10);
    }

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z10) {
        for (AbstractC0085b bVar : this.f5907a) {
            bVar.y(z10);
        }
    }

    private static Context d() {
        return com.mobvoi.android.common.utils.b.e();
    }

    public static b e() {
        if (f5906d == null) {
            synchronized (b.class) {
                if (f5906d == null) {
                    f5906d = new b();
                }
            }
        }
        return f5906d;
    }

    public void b(AbstractC0085b bVar) {
        if (!this.f5907a.contains(bVar)) {
            if (this.f5907a.isEmpty()) {
                d().registerReceiver(this.f5908b, f5905c);
            }
            this.f5907a.add(bVar);
        }
    }

    public void f() {
        if (e.i(d(), "android.permission.READ_PHONE_STATE") && !com.mobvoi.mcuwatch.engine.e.b().a()) {
            ((TelephonyManager) d().getSystemService(SharedWearInfoHelper.PhoneInfo.TABLE)).listen(com.mobvoi.mcuwatch.engine.e.b(), 32);
            com.mobvoi.mcuwatch.engine.e.b().c(true);
        }
    }

    public void g(AbstractC0085b bVar) {
        if (this.f5907a.contains(bVar)) {
            this.f5907a.remove(bVar);
        }
        if (this.f5907a.isEmpty()) {
            d().unregisterReceiver(this.f5908b);
        }
    }
}
