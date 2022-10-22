package ma;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothProfile;
import android.content.Context;
import com.mobvoi.android.common.utils.k;
import java.lang.reflect.Method;
/* compiled from: ClassicBluetoothManager.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    private static b f30615c;

    /* renamed from: a  reason: collision with root package name */
    private BluetoothAdapter f30616a;

    /* renamed from: b  reason: collision with root package name */
    private BluetoothHeadset f30617b;

    /* compiled from: ClassicBluetoothManager.java */
    /* loaded from: classes2.dex */
    private class a implements BluetoothProfile.ServiceListener {
        private a() {
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceConnected(int i10, BluetoothProfile bluetoothProfile) {
            k.a("ClassicBluetooth_HFP", "onServiceConnected: profile -- " + i10 + "  proxy -- " + bluetoothProfile);
            if (i10 == 1) {
                k.h("ClassicBluetooth_HFP", "connect to hfp server");
                b.this.f30617b = (BluetoothHeadset) bluetoothProfile;
            }
        }

        @Override // android.bluetooth.BluetoothProfile.ServiceListener
        public void onServiceDisconnected(int i10) {
            k.a("ClassicBluetooth_HFP", "onServiceDisconnected: profile -- " + i10);
            if (i10 == 1) {
                k.h("ClassicBluetooth_HFP", "disconnect to hfp server");
                b.this.f30617b = null;
            }
        }

        /* synthetic */ a(b bVar, ma.a aVar) {
            this();
        }
    }

    private b() {
    }

    public static synchronized b c() {
        b bVar;
        synchronized (b.class) {
            if (f30615c == null) {
                f30615c = new b();
            }
            bVar = f30615c;
        }
        return bVar;
    }

    public boolean b(BluetoothDevice bluetoothDevice) {
        k.a("ClassicBluetooth_HFP", "hfpProfile_-->" + this.f30617b);
        BluetoothHeadset bluetoothHeadset = this.f30617b;
        return bluetoothHeadset != null && bluetoothHeadset.getConnectionState(bluetoothDevice) == 2;
    }

    public boolean d(BluetoothDevice bluetoothDevice) {
        boolean z10 = false;
        try {
            Method declaredMethod = this.f30617b.getClass().getDeclaredMethod("connect", BluetoothDevice.class);
            declaredMethod.setAccessible(true);
            z10 = ((Boolean) declaredMethod.invoke(this.f30617b, bluetoothDevice)).booleanValue();
            k.h("ClassicBluetooth_HFP", "hfpConnect: use reflect to connect hfp --> " + z10);
            return z10;
        } catch (Exception e10) {
            k.d("ClassicBluetooth_HFP", "hfpConnect: " + e10.toString());
            return z10;
        }
    }

    public void e(BluetoothDevice bluetoothDevice) {
        try {
            Method declaredMethod = this.f30617b.getClass().getDeclaredMethod("disconnect", BluetoothDevice.class);
            declaredMethod.setAccessible(true);
            boolean booleanValue = ((Boolean) declaredMethod.invoke(this.f30617b, bluetoothDevice)).booleanValue();
            k.h("ClassicBluetooth_HFP", "hfpDisconnect: use reflect to disconnect hfp --> " + booleanValue);
        } catch (Exception e10) {
            k.d("ClassicBluetooth_HFP", "hfpDisconnect: " + e10.toString());
        }
    }

    public void f(Context context) {
        if (this.f30617b == null) {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            this.f30616a = defaultAdapter;
            defaultAdapter.getProfileProxy(context.getApplicationContext(), new a(this, null), 1);
        }
    }

    public void g(BluetoothDevice bluetoothDevice, int i10) {
        if (this.f30617b != null) {
            try {
                boolean booleanValue = ((Boolean) BluetoothHeadset.class.getMethod("setPriority", BluetoothDevice.class, Integer.TYPE).invoke(this.f30617b, bluetoothDevice, Integer.valueOf(i10))).booleanValue();
                k.h("ClassicBluetooth_HFP", "setPriority: use reflect to setPriority hfp --> " + booleanValue);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }
}
