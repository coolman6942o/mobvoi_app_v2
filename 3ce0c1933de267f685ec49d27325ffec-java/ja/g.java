package ja;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.mobvoi.apollo.protocol.ble.client.ClientState;
import com.mobvoi.apollo.protocol.ble.client.a;
import java.util.UUID;
import kotlin.jvm.internal.i;
/* compiled from: BleGattClientBase.kt */
/* loaded from: classes2.dex */
public abstract class g implements a.b {

    /* renamed from: a  reason: collision with root package name */
    private final String f29463a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f29464b;

    /* renamed from: c  reason: collision with root package name */
    private final com.mobvoi.apollo.protocol.ble.client.a f29465c;

    /* renamed from: d  reason: collision with root package name */
    private a f29466d;

    /* compiled from: BleGattClientBase.kt */
    /* loaded from: classes2.dex */
    public interface a {
        void a(BluetoothDevice bluetoothDevice, ClientState clientState);
    }

    public g(String ownerTag, Context context) {
        i.f(ownerTag, "ownerTag");
        i.f(context, "context");
        this.f29463a = ownerTag;
        this.f29464b = context;
        this.f29465c = new com.mobvoi.apollo.protocol.ble.client.a(context, this);
    }

    @Override // com.mobvoi.apollo.protocol.ble.client.a.b
    public void a(BluetoothDevice device, ClientState newState) {
        i.f(device, "device");
        i.f(newState, "newState");
        a aVar = this.f29466d;
        if (aVar != null) {
            aVar.a(device, newState);
        }
    }

    public void f() {
        this.f29465c.A();
    }

    public final boolean g(BluetoothDevice device, a callback) {
        i.f(device, "device");
        i.f(callback, "callback");
        this.f29466d = callback;
        return this.f29465c.B(device);
    }

    public final Context h() {
        return this.f29464b;
    }

    public final void i(UUID serviceUuid, UUID characteristicUUid, byte[] data) {
        i.f(serviceUuid, "serviceUuid");
        i.f(characteristicUUid, "characteristicUUid");
        i.f(data, "data");
        this.f29465c.O(serviceUuid, characteristicUUid, data);
    }
}
