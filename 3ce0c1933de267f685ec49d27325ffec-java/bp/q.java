package bp;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExperimentalButtonlessDfuImpl.java */
/* loaded from: classes3.dex */
public class q extends d {
    protected static final UUID A;
    protected static UUID B;
    protected static UUID C;

    /* renamed from: z  reason: collision with root package name */
    protected static final UUID f5497z;

    /* renamed from: y  reason: collision with root package name */
    private BluetoothGattCharacteristic f5498y;

    static {
        UUID uuid = new UUID(-8196551313441075360L, -6937650605005804976L);
        f5497z = uuid;
        UUID uuid2 = new UUID(-8196551313441075360L, -6937650605005804976L);
        A = uuid2;
        B = uuid;
        C = uuid2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Intent intent, g gVar) {
        super(intent, gVar);
    }

    @Override // bp.d
    protected BluetoothGattCharacteristic C() {
        return this.f5498y;
    }

    @Override // bp.d
    protected int D() {
        return 1;
    }

    @Override // bp.d
    protected boolean F() {
        return true;
    }

    @Override // bp.l
    public boolean f(Intent intent, BluetoothGatt bluetoothGatt) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = bluetoothGatt.getService(B);
        if (service == null || (characteristic = service.getCharacteristic(C)) == null || characteristic.getDescriptor(c.f5403u) == null) {
            return false;
        }
        this.f5498y = characteristic;
        return true;
    }

    @Override // bp.d, bp.l
    public void h(Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        q("Experimental buttonless service found -> SDK 12.x");
        super.h(intent);
    }
}
