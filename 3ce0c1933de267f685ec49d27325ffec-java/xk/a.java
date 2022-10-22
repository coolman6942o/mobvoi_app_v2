package xk;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import java.util.UUID;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static final UUID f36583d = UUID.fromString("6A24EEAB-4B65-4693-986B-3C26C352264F");

    /* renamed from: a  reason: collision with root package name */
    public BluetoothDevice f36584a;

    /* renamed from: b  reason: collision with root package name */
    public BluetoothSocket f36585b;

    /* renamed from: c  reason: collision with root package name */
    public UUID f36586c;

    static {
        UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    }

    public a(BluetoothDevice bluetoothDevice, BluetoothSocket bluetoothSocket, UUID uuid, boolean z10) {
        this.f36584a = bluetoothDevice;
        this.f36585b = bluetoothSocket;
        this.f36586c = uuid;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SppConnParameters{\n");
        if (this.f36584a != null) {
            sb2.append("\n\tdevice:");
            sb2.append(fl.a.c(this.f36584a.getAddress(), true));
        }
        if (this.f36586c != null) {
            sb2.append("\n\tuuid:");
            sb2.append(this.f36586c.toString());
        }
        sb2.append("\n\tfreshUuid:");
        sb2.append(false);
        sb2.append("\n}");
        return sb2.toString();
    }
}
