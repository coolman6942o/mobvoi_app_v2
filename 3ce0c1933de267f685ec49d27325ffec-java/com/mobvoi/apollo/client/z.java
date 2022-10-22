package com.mobvoi.apollo.client;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Build;
import com.mobvoi.android.common.utils.k;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.i;
import ma.b;
import rx.a;
/* compiled from: ClassicBluetoothBond.kt */
/* loaded from: classes2.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15561a;

    public z(Context context) {
        i.f(context, "context");
        this.f15561a = context;
        b.c().f(context);
    }

    private final void f(final BluetoothDevice bluetoothDevice, final Runnable runnable) {
        a.c(new a.j() { // from class: com.mobvoi.apollo.client.w
            @Override // yp.b
            public final void call(rx.b bVar) {
                z.g(z.this, bluetoothDevice, runnable, bVar);
            }
        }).j(cq.a.c()).i(x.f15559a, y.f15560a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(z this$0, BluetoothDevice device, Runnable runnable, rx.b bVar) {
        UUID uuid;
        i.f(this$0, "this$0");
        i.f(device, "$device");
        i.f(runnable, "$runnable");
        BluetoothSocket bluetoothSocket = null;
        try {
            k.a("ClassicBluetoothBond", "start connect classic BT to bond");
            if (Build.VERSION.SDK_INT <= 30 || androidx.core.content.b.a(this$0.f15561a, "android.permission.BLUETOOTH_CONNECT") == 0) {
                uuid = a0.f15462a;
                device.createRfcommSocketToServiceRecord(uuid).connect();
                k.a("ClassicBluetoothBond", "connected classic BT and bonded");
                Thread.sleep(800L);
                runnable.run();
                bVar.onCompleted();
                return;
            }
            k.a("ClassicBluetoothBond", "not BLUETOOTH_CONNECT Permission");
            bVar.onCompleted();
        } catch (IOException e10) {
            if (0 != 0) {
                try {
                    bluetoothSocket.close();
                } catch (IOException unused) {
                }
            }
            bVar.onError(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Throwable th2) {
        th2.printStackTrace();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(BluetoothDevice device) {
        i.f(device, "$device");
        b.c().g(device, 100);
        b.c().d(device);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object n(BluetoothDevice btDevice) {
        i.f(btDevice, "$btDevice");
        if (b.c().b(btDevice)) {
            b.c().e(btDevice);
            Thread.sleep(500L);
        }
        b.c().g(btDevice, 0);
        Thread.sleep(1000L);
        Method declaredMethod = btDevice.getClass().getDeclaredMethod("removeBond", new Class[0]);
        declaredMethod.setAccessible(true);
        return declaredMethod.invoke(btDevice, new Object[0]);
    }

    public final void j(final BluetoothDevice device) {
        i.f(device, "device");
        if (l(device)) {
            k.a("ClassicBluetoothBond", device + " HFP is connected");
            return;
        }
        f(device, new Runnable() { // from class: com.mobvoi.apollo.client.u
            @Override // java.lang.Runnable
            public final void run() {
                z.k(device);
            }
        });
    }

    public final boolean l(BluetoothDevice device) {
        i.f(device, "device");
        return b.c().b(device);
    }

    public final void m(final BluetoothDevice btDevice) {
        i.f(btDevice, "btDevice");
        a.e(new Callable() { // from class: com.mobvoi.apollo.client.v
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Object n10;
                n10 = z.n(btDevice);
                return n10;
            }
        }).j(cq.a.c()).h();
    }
}
