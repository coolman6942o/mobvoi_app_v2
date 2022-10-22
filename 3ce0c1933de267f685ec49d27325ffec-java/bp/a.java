package bp;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import bp.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseButtonlessDfuImpl.java */
/* loaded from: classes3.dex */
public abstract class a extends c {

    /* renamed from: w  reason: collision with root package name */
    private final C0078a f5394w = new C0078a();

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: BaseButtonlessDfuImpl.java */
    /* renamed from: bp.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0078a extends c.a {
        protected C0078a() {
            super();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            g gVar = a.this.f5418n;
            gVar.A(5, "Notification received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + b(bluetoothGattCharacteristic));
            a.this.f5416l = bluetoothGattCharacteristic.getValue();
            a.this.s();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            a aVar = a.this;
            aVar.f5413i = true;
            aVar.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Intent intent, g gVar) {
        super(intent, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void A(Intent intent, boolean z10, boolean z11) {
        boolean booleanExtra = intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND", false);
        this.f5418n.x(this.f5408d, z10 || !booleanExtra);
        this.f5418n.j(this.f5408d);
        if (this.f5408d.getDevice().getBondState() == 12 && (intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND", false) || !booleanExtra)) {
            v();
            this.f5418n.H(2000);
        }
        q("Restarting to bootloader mode");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        x(intent2, z11);
    }

    /* renamed from: B */
    public c.a e() {
        return this.f5394w;
    }
}
