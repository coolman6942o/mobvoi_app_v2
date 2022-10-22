package bp;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import com.realsil.sdk.dfu.exception.LoadFileException;
import fp.c;
import java.util.Locale;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
/* compiled from: ButtonlessDfuImpl.java */
/* loaded from: classes3.dex */
abstract class d extends a {

    /* renamed from: x  reason: collision with root package name */
    private static final byte[] f5424x = {1};

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Intent intent, g gVar) {
        super(intent, gVar);
    }

    private int E(byte[] bArr, int i10) throws UnknownResponseException {
        if (bArr != null && bArr.length >= 3 && bArr[0] == 32 && bArr[1] == i10 && (bArr[2] == 1 || bArr[2] == 2 || bArr[2] == 4)) {
            return bArr[2];
        }
        throw new UnknownResponseException("Invalid response received", bArr, 32, i10);
    }

    protected abstract BluetoothGattCharacteristic C();

    protected abstract int D();

    protected abstract boolean F();

    @Override // bp.l
    public void h(Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        byte[] bArr;
        this.f5419o.p(-2);
        this.f5418n.H(1000);
        BluetoothGatt bluetoothGatt = this.f5408d;
        this.f5418n.A(15, "Application with buttonless update found");
        this.f5418n.A(1, "Jumping to the DFU Bootloader...");
        BluetoothGattCharacteristic C = C();
        int D = D();
        l(C, D());
        g gVar = this.f5418n;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(D == 2 ? "Indications" : "Notifications");
        sb2.append(" enabled");
        gVar.A(10, sb2.toString());
        this.f5418n.H(1000);
        try {
            this.f5419o.p(-3);
            q("Sending Enter Bootloader (Op Code = 1)");
            z(C, f5424x, true);
            this.f5418n.A(10, "Enter bootloader sent (Op Code = 1)");
            try {
                bArr = u();
            } catch (DeviceDisconnectedException unused) {
                bArr = this.f5416l;
            }
            if (bArr != null) {
                int E = E(bArr, 1);
                q("Response received (Op Code = " + ((int) bArr[1]) + ", Status = " + E + ")");
                g gVar2 = this.f5418n;
                gVar2.A(10, "Response received (Op Code = " + ((int) bArr[1]) + ", Status = " + E + ")");
                if (E == 1) {
                    this.f5418n.I();
                } else {
                    throw new RemoteDfuException("Device returned error after sending Enter Bootloader", E);
                }
            } else {
                q("Device disconnected before receiving notification");
            }
            this.f5418n.A(5, "Disconnected by the remote device");
            A(intent, false, F());
        } catch (RemoteDfuException e10) {
            int errorNumber = e10.getErrorNumber() | 2048;
            o(e10.getMessage());
            this.f5418n.A(20, String.format(Locale.US, "Remote DFU error: %s", c.b(errorNumber)));
            this.f5418n.D(bluetoothGatt, errorNumber | 8192);
        } catch (UnknownResponseException e11) {
            o(e11.getMessage());
            this.f5418n.A(20, e11.getMessage());
            this.f5418n.D(bluetoothGatt, LoadFileException.ERROR_VERSION_CHECK_LOW);
        }
    }
}
