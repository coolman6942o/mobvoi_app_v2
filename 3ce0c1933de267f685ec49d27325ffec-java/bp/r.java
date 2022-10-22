package bp;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.preference.PreferenceManager;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LegacyButtonlessDfuImpl.java */
/* loaded from: classes3.dex */
public class r extends a {

    /* renamed from: x  reason: collision with root package name */
    private BluetoothGattCharacteristic f5500x;

    /* renamed from: y  reason: collision with root package name */
    private int f5501y;

    /* renamed from: z  reason: collision with root package name */
    protected static UUID f5499z = s.F;
    protected static UUID A = s.G;
    protected static UUID B = s.I;
    private static final byte[] C = {1, 4};

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(Intent intent, g gVar) {
        super(intent, gVar);
    }

    private String C(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 5 ? i10 != 6 ? i10 != 7 ? i10 != 8 ? "Unknown version" : "Bootloader from SDK 9.0 or newer. Signature supported" : "Bootloader from SDK 8.0 or newer. SHA-256 used instead of CRC-16 in the Init Packet" : "Bootloader from SDK 8.0 or newer. Bond sharing supported" : "Bootloader from SDK 7.0 or newer. No bond sharing" : "Application with Legacy buttonless update from SDK 7.0 or newer" : "Bootloader from SDK 6.1 or older";
    }

    private int D(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        if (!this.f5412h) {
            throw new DeviceDisconnectedException("Unable to read version number: device disconnected");
        } else if (this.f5411g) {
            throw new UploadAbortedException();
        } else if (bluetoothGattCharacteristic == null) {
            return 0;
        } else {
            this.f5416l = null;
            this.f5415k = 0;
            q("Reading DFU version number...");
            this.f5418n.A(1, "Reading DFU version number...");
            bluetoothGattCharacteristic.setValue((byte[]) null);
            g gVar = this.f5418n;
            gVar.A(0, "gatt.readCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
            bluetoothGatt.readCharacteristic(bluetoothGattCharacteristic);
            try {
                synchronized (this.f5405a) {
                    while (true) {
                        if (((this.f5413i && bluetoothGattCharacteristic.getValue() != null) || !this.f5412h || this.f5415k != 0 || this.f5411g) && !this.f5410f) {
                            break;
                        }
                        this.f5413i = false;
                        this.f5405a.wait();
                    }
                }
            } catch (InterruptedException e10) {
                p("Sleeping interrupted", e10);
            }
            if (this.f5415k != 0) {
                throw new DfuException("Unable to read version number", this.f5415k);
            } else if (this.f5412h) {
                return bluetoothGattCharacteristic.getIntValue(18, 0).intValue();
            } else {
                throw new DeviceDisconnectedException("Unable to read version number: device disconnected");
            }
        }
    }

    @Override // bp.l
    public boolean f(Intent intent, BluetoothGatt bluetoothGatt) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        BluetoothGattCharacteristic characteristic;
        int i10;
        BluetoothGattService service = bluetoothGatt.getService(f5499z);
        if (service == null || (characteristic = service.getCharacteristic(A)) == null || characteristic.getDescriptor(c.f5403u) == null) {
            return false;
        }
        this.f5500x = characteristic;
        this.f5419o.p(-2);
        this.f5418n.H(1000);
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(B);
        if (characteristic2 != null) {
            i10 = D(bluetoothGatt, characteristic2);
            this.f5501y = i10;
            int i11 = i10 & 15;
            int i12 = i10 >> 8;
            q("Version number read: " + i12 + "." + i11 + " -> " + C(i10));
            g gVar = this.f5418n;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Version number read: ");
            sb2.append(i12);
            sb2.append(".");
            sb2.append(i11);
            gVar.A(10, sb2.toString());
        } else {
            q("No DFU Version characteristic found -> " + C(0));
            this.f5418n.A(10, "DFU Version characteristic not found");
            i10 = 0;
        }
        boolean z10 = PreferenceManager.getDefaultSharedPreferences(this.f5418n).getBoolean("settings_assume_dfu_mode", false);
        if (intent.hasExtra("no.nordicsemi.android.dfu.extra.EXTRA_FORCE_DFU")) {
            z10 = intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_FORCE_DFU", false);
        }
        boolean z11 = bluetoothGatt.getServices().size() > 3;
        if (i10 == 0 && z11) {
            q("Additional services found -> Bootloader from SDK 6.1. Updating SD and BL supported, extended init packet not supported");
        }
        return i10 == 1 || (!z10 && i10 == 0 && z11);
    }

    @Override // bp.l
    public void h(Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        r("Application with legacy buttonless update found");
        this.f5418n.A(15, "Application with buttonless update found");
        boolean z10 = true;
        this.f5418n.A(1, "Jumping to the DFU Bootloader...");
        l(this.f5500x, 1);
        this.f5418n.A(10, "Notifications enabled");
        this.f5418n.H(1000);
        this.f5419o.p(-3);
        q("Sending Start DFU command (Op Code = 1, Upload Mode = 4)");
        z(this.f5500x, C, true);
        this.f5418n.A(10, "Jump to bootloader sent (Op Code = 1, Upload Mode = 4)");
        this.f5418n.I();
        this.f5418n.A(5, "Disconnected by the remote device");
        BluetoothGatt bluetoothGatt = this.f5408d;
        BluetoothGattService service = bluetoothGatt.getService(c.f5401s);
        this.f5418n.x(bluetoothGatt, !((service == null || service.getCharacteristic(c.f5402t) == null) ? false : true));
        this.f5418n.j(bluetoothGatt);
        q("Starting service that will connect to the DFU bootloader");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        if (this.f5501y != 0) {
            z10 = false;
        }
        x(intent2, z10);
    }
}
