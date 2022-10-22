package bp;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import bp.c;
import java.io.IOException;
import java.util.UUID;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.HexFileValidationException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseCustomDfuImpl.java */
/* loaded from: classes3.dex */
public abstract class b extends c {
    protected boolean A;

    /* renamed from: w  reason: collision with root package name */
    private boolean f5396w;

    /* renamed from: x  reason: collision with root package name */
    protected boolean f5397x;

    /* renamed from: y  reason: collision with root package name */
    protected int f5398y;

    /* renamed from: z  reason: collision with root package name */
    protected int f5399z;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: BaseCustomDfuImpl.java */
    /* loaded from: classes3.dex */
    public class a extends c.a {
        /* JADX INFO: Access modifiers changed from: protected */
        public a() {
            super();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void f(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            g gVar = b.this.f5418n;
            gVar.A(5, "Notification received from " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + b(bluetoothGattCharacteristic));
            b.this.f5416l = bluetoothGattCharacteristic.getValue();
            b.this.f5397x = false;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void g(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            b bVar = b.this;
            if (!bVar.f5397x) {
                f(bluetoothGatt, bluetoothGattCharacteristic);
                return;
            }
            BluetoothGattCharacteristic characteristic = bluetoothGatt.getService(bVar.E()).getCharacteristic(b.this.F());
            try {
                b bVar2 = b.this;
                bVar2.f5399z = 0;
                bVar2.y();
                b bVar3 = b.this;
                if (!bVar3.f5411g && bVar3.f5415k == 0 && !bVar3.A && !bVar3.f5414j) {
                    boolean j10 = bVar3.f5419o.j();
                    boolean l10 = b.this.f5419o.l();
                    if (!j10 && !l10) {
                        int b10 = b.this.f5419o.b();
                        b bVar4 = b.this;
                        byte[] bArr = bVar4.f5417m;
                        if (b10 < bArr.length) {
                            bArr = new byte[b10];
                        }
                        b.this.J(bluetoothGatt, characteristic, bArr, bVar4.f5406b.read(bArr));
                        return;
                    }
                    b bVar5 = b.this;
                    bVar5.f5397x = false;
                    bVar5.s();
                    return;
                }
                bVar3.f5397x = false;
                bVar3.f5418n.A(15, "Upload terminated");
            } catch (HexFileValidationException unused) {
                b.this.o("Invalid HEX file");
                b.this.f5415k = 4099;
            } catch (IOException e10) {
                b.this.p("Error while reading the input stream", e10);
                b.this.f5415k = 4100;
            }
        }

        protected void h(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            boolean z10 = true;
            if (i10 != 0) {
                b bVar = b.this;
                if (bVar.f5414j) {
                    bVar.f5413i = true;
                } else {
                    bVar.o("Characteristic write error: " + i10);
                    b.this.f5415k = i10 | 16384;
                }
            } else if (!bluetoothGattCharacteristic.getUuid().equals(b.this.F())) {
                b.this.f5418n.A(5, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + b(bluetoothGattCharacteristic));
                b.this.f5413i = true;
            } else if (b.this.f5396w) {
                b.this.f5418n.A(5, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + b(bluetoothGattCharacteristic));
                b.this.f5396w = false;
            } else {
                b bVar2 = b.this;
                if (bVar2.f5397x) {
                    bVar2.f5419o.a(bluetoothGattCharacteristic.getValue().length);
                    b bVar3 = b.this;
                    int i11 = bVar3.f5399z + 1;
                    bVar3.f5399z = i11;
                    int i12 = bVar3.f5398y;
                    if (i12 <= 0 || i11 < i12) {
                        z10 = false;
                    }
                    boolean j10 = bVar3.f5419o.j();
                    boolean l10 = b.this.f5419o.l();
                    if (!z10) {
                        if (j10 || l10) {
                            b bVar4 = b.this;
                            bVar4.f5397x = false;
                            bVar4.s();
                            return;
                        }
                        try {
                            b.this.y();
                            b bVar5 = b.this;
                            if (!bVar5.f5411g && bVar5.f5415k == 0 && !bVar5.A && !bVar5.f5414j) {
                                int b10 = bVar5.f5419o.b();
                                b bVar6 = b.this;
                                byte[] bArr = bVar6.f5417m;
                                if (b10 < bArr.length) {
                                    bArr = new byte[b10];
                                }
                                b.this.J(bluetoothGatt, bluetoothGattCharacteristic, bArr, bVar6.f5406b.read(bArr));
                                return;
                            }
                            bVar5.f5397x = false;
                            bVar5.f5418n.A(15, "Upload terminated");
                            b.this.s();
                            return;
                        } catch (HexFileValidationException unused) {
                            b.this.o("Invalid HEX file");
                            b.this.f5415k = 4099;
                        } catch (IOException e10) {
                            b.this.p("Error while reading the input stream", e10);
                            b.this.f5415k = 4100;
                        }
                    } else {
                        return;
                    }
                } else {
                    h(bluetoothGatt, bluetoothGattCharacteristic, i10);
                }
            }
            b.this.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Intent intent, g gVar) {
        super(intent, gVar);
        boolean z10 = true;
        int i10 = 0;
        int i11 = 12;
        if (intent.hasExtra("no.nordicsemi.android.dfu.extra.EXTRA_PRN_ENABLED")) {
            boolean booleanExtra = intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_PRN_ENABLED", Build.VERSION.SDK_INT >= 23 ? false : z10);
            int intExtra = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PRN_VALUE", 12);
            if (intExtra >= 0 && intExtra <= 65535) {
                i11 = intExtra;
            }
            this.f5398y = booleanExtra ? i11 : i10;
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(gVar);
        boolean z11 = defaultSharedPreferences.getBoolean("settings_packet_receipt_notification_enabled", Build.VERSION.SDK_INT >= 23 ? false : z10);
        try {
            int parseInt = Integer.parseInt(defaultSharedPreferences.getString("settings_number_of_packets", String.valueOf(12)));
            if (parseInt >= 0 && parseInt <= 65535) {
                i11 = parseInt;
            }
        } catch (NumberFormatException unused) {
        }
        this.f5398y = z11 ? i11 : i10;
    }

    private void I(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i10) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        if (!this.f5411g) {
            if (bArr.length != i10) {
                byte[] bArr2 = new byte[i10];
                System.arraycopy(bArr, 0, bArr2, 0, i10);
                bArr = bArr2;
            }
            this.f5416l = null;
            this.f5415k = 0;
            this.f5396w = true;
            bluetoothGattCharacteristic.setWriteType(1);
            bluetoothGattCharacteristic.setValue(bArr);
            q("Sending init packet (Value = " + t(bArr) + ")");
            g gVar = this.f5418n;
            gVar.A(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
            g gVar2 = this.f5418n;
            gVar2.A(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
            this.f5408d.writeCharacteristic(bluetoothGattCharacteristic);
            try {
                synchronized (this.f5405a) {
                    while (true) {
                        if ((!this.f5396w || !this.f5412h || this.f5415k != 0) && !this.f5410f) {
                            break;
                        }
                        this.f5405a.wait();
                    }
                }
            } catch (InterruptedException e10) {
                p("Sleeping interrupted", e10);
            }
            if (this.f5415k != 0) {
                throw new DfuException("Unable to write Init DFU Parameters", this.f5415k);
            } else if (!this.f5412h) {
                throw new DeviceDisconnectedException("Unable to write Init DFU Parameters: device disconnected");
            }
        } else {
            throw new UploadAbortedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr, int i10) {
        if (i10 > 0) {
            if (bArr.length != i10) {
                byte[] bArr2 = new byte[i10];
                System.arraycopy(bArr, 0, bArr2, 0, i10);
                bArr = bArr2;
            }
            bluetoothGattCharacteristic.setWriteType(1);
            bluetoothGattCharacteristic.setValue(bArr);
            bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(Intent intent, boolean z10) {
        boolean z11;
        boolean z12 = false;
        boolean booleanExtra = intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_KEEP_BOND", false);
        this.f5418n.x(this.f5408d, z10 || !booleanExtra);
        this.f5418n.j(this.f5408d);
        if (this.f5408d.getDevice().getBondState() == 12) {
            boolean booleanExtra2 = intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_RESTORE_BOND", false);
            if (booleanExtra2 || !booleanExtra) {
                v();
                this.f5418n.H(2000);
                z11 = true;
            } else {
                z11 = false;
            }
            if (!booleanExtra2 || (this.f5409e & 4) <= 0) {
                z12 = z11;
            } else {
                j();
            }
        }
        if (this.f5419o.k()) {
            if (!z12) {
                this.f5418n.H(1400);
            }
            this.f5419o.p(-6);
            return;
        }
        q("Starting service that will upload application");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        intent2.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE", "application/zip");
        intent2.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE", 4);
        intent2.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT", this.f5419o.e() + 1);
        intent2.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL", this.f5419o.h());
        x(intent2, true);
    }

    protected abstract UUID E();

    protected abstract UUID F();

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(BluetoothGattCharacteristic bluetoothGattCharacteristic) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        if (!this.f5411g) {
            this.f5416l = null;
            this.f5415k = 0;
            this.f5397x = true;
            this.f5399z = 0;
            byte[] bArr = this.f5417m;
            try {
                int read = this.f5406b.read(bArr);
                g gVar = this.f5418n;
                gVar.A(1, "Sending firmware to characteristic " + bluetoothGattCharacteristic.getUuid() + "...");
                J(this.f5408d, bluetoothGattCharacteristic, bArr, read);
                try {
                    synchronized (this.f5405a) {
                        while (true) {
                            if ((!this.f5397x || this.f5416l != null || !this.f5412h || this.f5415k != 0) && !this.f5410f) {
                                break;
                            }
                            this.f5405a.wait();
                        }
                    }
                } catch (InterruptedException e10) {
                    p("Sleeping interrupted", e10);
                }
                if (this.f5415k != 0) {
                    throw new DfuException("Uploading Firmware Image failed", this.f5415k);
                } else if (!this.f5412h) {
                    throw new DeviceDisconnectedException("Uploading Firmware Image failed: device disconnected");
                }
            } catch (HexFileValidationException unused) {
                throw new DfuException("HEX file not valid", 4099);
            } catch (IOException unused2) {
                throw new DfuException("Error while reading file", 4100);
            }
        } else {
            throw new UploadAbortedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void H(BluetoothGattCharacteristic bluetoothGattCharacteristic, CRC32 crc32) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        try {
            byte[] bArr = this.f5417m;
            while (true) {
                int read = this.f5407c.read(bArr, 0, bArr.length);
                if (read != -1) {
                    I(bluetoothGattCharacteristic, bArr, read);
                    if (crc32 != null) {
                        crc32.update(bArr, 0, read);
                    }
                } else {
                    return;
                }
            }
        } catch (IOException e10) {
            p("Error while reading Init packet file", e10);
            throw new DfuException("Error while reading Init packet file", 4098);
        }
    }
}
