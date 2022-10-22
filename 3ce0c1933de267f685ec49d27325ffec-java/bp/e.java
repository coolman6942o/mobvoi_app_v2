package bp;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import com.realsil.sdk.dfu.exception.LoadFileException;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ButtonlessDfuWithBondSharingImpl.java */
/* loaded from: classes3.dex */
public class e extends d {
    protected static final UUID A;
    protected static UUID B;
    protected static UUID C;

    /* renamed from: z  reason: collision with root package name */
    protected static final UUID f5425z;

    /* renamed from: y  reason: collision with root package name */
    private BluetoothGattCharacteristic f5426y;

    static {
        UUID uuid = v.E;
        f5425z = uuid;
        UUID uuid2 = new UUID(-8157989228746813600L, -6937650605005804976L);
        A = uuid2;
        B = uuid;
        C = uuid2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(Intent intent, g gVar) {
        super(intent, gVar);
    }

    @Override // bp.d
    protected BluetoothGattCharacteristic C() {
        return this.f5426y;
    }

    @Override // bp.d
    protected int D() {
        return 2;
    }

    @Override // bp.d
    protected boolean F() {
        return false;
    }

    @Override // bp.l
    public boolean f(Intent intent, BluetoothGatt bluetoothGatt) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = bluetoothGatt.getService(B);
        if (service == null || (characteristic = service.getCharacteristic(C)) == null || characteristic.getDescriptor(c.f5403u) == null) {
            return false;
        }
        this.f5426y = characteristic;
        return true;
    }

    @Override // bp.d, bp.l
    public void h(Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        q("Buttonless service with bond sharing found -> SDK 14 or newer");
        if (!m()) {
            r("Device is not paired, cancelling DFU");
            this.f5418n.A(15, "Device is not bonded");
            this.f5418n.D(this.f5408d, LoadFileException.ERROR_PACK_EMPTY);
            return;
        }
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND", true);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND", false);
        super.h(intent);
    }
}
