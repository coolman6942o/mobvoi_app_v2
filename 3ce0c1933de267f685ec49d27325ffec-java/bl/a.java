package bl;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import il.b;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
@TargetApi(18)
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static a f5202d;

    /* renamed from: a  reason: collision with root package name */
    public BluetoothManager f5203a;

    /* renamed from: b  reason: collision with root package name */
    public BluetoothAdapter f5204b;

    /* renamed from: c  reason: collision with root package name */
    public Context f5205c;

    static {
        UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    }

    public a(Context context) {
        this.f5205c = context;
        new HashMap();
        new HashMap();
        new HashMap();
        new CopyOnWriteArrayList();
        a();
    }

    public static a b() {
        return f5202d;
    }

    public static synchronized void c(Context context) {
        synchronized (a.class) {
            if (f5202d == null) {
                synchronized (a.class) {
                    if (f5202d == null) {
                        f5202d = new a(context.getApplicationContext());
                    }
                }
            }
        }
    }

    public final boolean a() {
        String str;
        if (this.f5203a == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) this.f5205c.getSystemService("bluetooth");
            this.f5203a = bluetoothManager;
            if (bluetoothManager == null) {
                str = "BLUETOOTH_SERVICE not supported.";
                b.l(str);
                return false;
            }
        }
        if (this.f5204b == null) {
            BluetoothAdapter adapter = this.f5203a.getAdapter();
            this.f5204b = adapter;
            if (adapter == null) {
                str = "BluetoothAdapter is not supported";
                b.l(str);
                return false;
            }
        }
        b.c("initialize success");
        return true;
    }
}
