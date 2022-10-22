package bp;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.SystemClock;
import bp.b;
import com.realsil.sdk.dfu.exception.LoadFileException;
import java.io.InputStream;
import java.util.Locale;
import java.util.UUID;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LegacyDfuImpl.java */
/* loaded from: classes3.dex */
public class s extends b {
    protected static final UUID F;
    protected static final UUID G;
    protected static final UUID H;
    protected static final UUID I;
    protected static UUID J;
    protected static UUID K;
    protected static UUID L;
    protected static UUID M;
    private static final byte[] N = {1, 0};
    private static final byte[] O = {1};
    private static final byte[] P = {2};
    private static final byte[] Q = {2, 0};
    private static final byte[] R = {2, 1};
    private static final byte[] S = {3};
    private static final byte[] T = {4};
    private static final byte[] U = {5};
    private static final byte[] V = {6};
    private static final byte[] W = {8, 0, 0};
    private BluetoothGattCharacteristic B;
    private BluetoothGattCharacteristic C;
    private boolean D;
    private final a E = new a();

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: LegacyDfuImpl.java */
    /* loaded from: classes3.dex */
    public class a extends b.a {
        protected a() {
            super();
        }

        @Override // bp.b.a
        protected void h(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            if (s.this.D) {
                g gVar = s.this.f5418n;
                gVar.A(5, "Data written to " + bluetoothGattCharacteristic.getUuid() + ", value (0x): " + b(bluetoothGattCharacteristic));
                s.this.D = false;
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGattCharacteristic.getIntValue(17, 0).intValue() == 17) {
                s.this.f5419o.m(bluetoothGattCharacteristic.getIntValue(20, 1).intValue());
                g(bluetoothGatt, bluetoothGattCharacteristic);
            } else if (!s.this.A) {
                if (bluetoothGattCharacteristic.getIntValue(17, 2).intValue() != 1) {
                    s.this.A = true;
                }
                f(bluetoothGatt, bluetoothGattCharacteristic);
            }
            s.this.s();
        }
    }

    static {
        UUID uuid = new UUID(23296205844446L, 1523193452336828707L);
        F = uuid;
        UUID uuid2 = new UUID(23300500811742L, 1523193452336828707L);
        G = uuid2;
        UUID uuid3 = new UUID(23304795779038L, 1523193452336828707L);
        H = uuid3;
        UUID uuid4 = new UUID(23313385713630L, 1523193452336828707L);
        I = uuid4;
        J = uuid;
        K = uuid2;
        L = uuid3;
        M = uuid4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(Intent intent, g gVar) {
        super(intent, gVar);
    }

    private int N(byte[] bArr, int i10) throws UnknownResponseException {
        if (bArr != null && bArr.length == 3 && bArr[0] == 16 && bArr[1] == i10 && bArr[2] >= 1 && bArr[2] <= 6) {
            return bArr[2];
        }
        throw new UnknownResponseException("Invalid response received", bArr, 16, i10);
    }

    private int O(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic != null) {
            return bluetoothGattCharacteristic.getIntValue(18, 0).intValue();
        }
        return 0;
    }

    private void P(BluetoothGatt bluetoothGatt, Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        this.f5418n.A(15, "Last upload interrupted. Restarting device...");
        this.f5419o.p(-5);
        q("Sending Reset command (Op Code = 6)");
        T(this.B, V);
        this.f5418n.A(10, "Reset request sent");
        this.f5418n.I();
        this.f5418n.A(5, "Disconnected by the remote device");
        BluetoothGattService service = bluetoothGatt.getService(c.f5401s);
        this.f5418n.x(bluetoothGatt, !((service == null || service.getCharacteristic(c.f5402t) == null) ? false : true));
        this.f5418n.j(bluetoothGatt);
        q("Restarting the service");
        Intent intent2 = new Intent();
        intent2.fillIn(intent, 24);
        x(intent2, false);
    }

    private void Q(byte[] bArr, int i10) {
        bArr[1] = (byte) (i10 & 255);
        bArr[2] = (byte) ((i10 >> 8) & 255);
    }

    private void R(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        this.f5416l = null;
        this.f5415k = 0;
        this.D = true;
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(new byte[4]);
        bluetoothGattCharacteristic.setValue(i10, 20, 0);
        g gVar = this.f5418n;
        gVar.A(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
        g gVar2 = this.f5418n;
        gVar2.A(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        this.f5408d.writeCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.f5405a) {
                while (true) {
                    if ((!this.D || !this.f5412h || this.f5415k != 0 || this.f5411g) && !this.f5410f) {
                        break;
                    }
                    this.f5405a.wait();
                }
            }
        } catch (InterruptedException e10) {
            p("Sleeping interrupted", e10);
        }
        if (this.f5411g) {
            throw new UploadAbortedException();
        } else if (this.f5415k != 0) {
            throw new DfuException("Unable to write Image Size", this.f5415k);
        } else if (!this.f5412h) {
            throw new DeviceDisconnectedException("Unable to write Image Size: device disconnected");
        }
    }

    private void S(BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10, int i11, int i12) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        this.f5416l = null;
        this.f5415k = 0;
        this.D = true;
        bluetoothGattCharacteristic.setWriteType(1);
        bluetoothGattCharacteristic.setValue(new byte[12]);
        bluetoothGattCharacteristic.setValue(i10, 20, 0);
        bluetoothGattCharacteristic.setValue(i11, 20, 4);
        bluetoothGattCharacteristic.setValue(i12, 20, 8);
        g gVar = this.f5418n;
        gVar.A(1, "Writing to characteristic " + bluetoothGattCharacteristic.getUuid());
        g gVar2 = this.f5418n;
        gVar2.A(0, "gatt.writeCharacteristic(" + bluetoothGattCharacteristic.getUuid() + ")");
        this.f5408d.writeCharacteristic(bluetoothGattCharacteristic);
        try {
            synchronized (this.f5405a) {
                while (true) {
                    if ((!this.D || !this.f5412h || this.f5415k != 0 || this.f5411g) && !this.f5410f) {
                        break;
                    }
                    this.f5405a.wait();
                }
            }
        } catch (InterruptedException e10) {
            p("Sleeping interrupted", e10);
        }
        if (this.f5411g) {
            throw new UploadAbortedException();
        } else if (this.f5415k != 0) {
            throw new DfuException("Unable to write Image Sizes", this.f5415k);
        } else if (!this.f5412h) {
            throw new DeviceDisconnectedException("Unable to write Image Sizes: device disconnected");
        }
    }

    private void T(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        boolean z10 = false;
        if (bArr[0] == 6 || bArr[0] == 5) {
            z10 = true;
        }
        z(bluetoothGattCharacteristic, bArr, z10);
    }

    @Override // bp.b
    protected UUID E() {
        return J;
    }

    @Override // bp.b
    protected UUID F() {
        return L;
    }

    /* renamed from: M */
    public b.a e() {
        return this.E;
    }

    @Override // bp.l
    public boolean f(Intent intent, BluetoothGatt bluetoothGatt) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = bluetoothGatt.getService(J);
        if (service == null || (characteristic = service.getCharacteristic(K)) == null || characteristic.getDescriptor(c.f5403u) == null) {
            return false;
        }
        this.B = characteristic;
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(L);
        this.C = characteristic2;
        return characteristic2 != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x047d A[Catch: UnknownResponseException -> 0x01e5, UploadAbortedException -> 0x01ed, RemoteDfuException -> 0x0653, TryCatch #2 {RemoteDfuException -> 0x0653, blocks: (B:84:0x0306, B:88:0x0310, B:90:0x03ad, B:95:0x03b5, B:97:0x03b9, B:99:0x03c4, B:100:0x0407, B:101:0x0434, B:104:0x0463, B:105:0x046a, B:107:0x046d, B:113:0x0479, B:115:0x047d, B:116:0x04bb, B:117:0x04da, B:118:0x04ed, B:120:0x054b, B:122:0x05ff, B:126:0x062e, B:127:0x0633, B:128:0x063a, B:129:0x063b, B:130:0x0642, B:132:0x0644, B:133:0x064a, B:134:0x064b, B:135:0x0650, B:136:0x0651, B:137:0x0652), top: B:157:0x0306 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x054b A[Catch: UnknownResponseException -> 0x01e5, UploadAbortedException -> 0x01ed, RemoteDfuException -> 0x0653, TryCatch #2 {RemoteDfuException -> 0x0653, blocks: (B:84:0x0306, B:88:0x0310, B:90:0x03ad, B:95:0x03b5, B:97:0x03b9, B:99:0x03c4, B:100:0x0407, B:101:0x0434, B:104:0x0463, B:105:0x046a, B:107:0x046d, B:113:0x0479, B:115:0x047d, B:116:0x04bb, B:117:0x04da, B:118:0x04ed, B:120:0x054b, B:122:0x05ff, B:126:0x062e, B:127:0x0633, B:128:0x063a, B:129:0x063b, B:130:0x0642, B:132:0x0644, B:133:0x064a, B:134:0x064b, B:135:0x0650, B:136:0x0651, B:137:0x0652), top: B:157:0x0306 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x063b A[Catch: UnknownResponseException -> 0x01e5, UploadAbortedException -> 0x01ed, RemoteDfuException -> 0x0653, TryCatch #2 {RemoteDfuException -> 0x0653, blocks: (B:84:0x0306, B:88:0x0310, B:90:0x03ad, B:95:0x03b5, B:97:0x03b9, B:99:0x03c4, B:100:0x0407, B:101:0x0434, B:104:0x0463, B:105:0x046a, B:107:0x046d, B:113:0x0479, B:115:0x047d, B:116:0x04bb, B:117:0x04da, B:118:0x04ed, B:120:0x054b, B:122:0x05ff, B:126:0x062e, B:127:0x0633, B:128:0x063a, B:129:0x063b, B:130:0x0642, B:132:0x0644, B:133:0x064a, B:134:0x064b, B:135:0x0650, B:136:0x0651, B:137:0x0652), top: B:157:0x0306 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0303 A[Catch: UnknownResponseException -> 0x01e5, UploadAbortedException -> 0x01ed, RemoteDfuException -> 0x0304, TRY_LEAVE, TryCatch #7 {RemoteDfuException -> 0x0304, blocks: (B:66:0x01fc, B:69:0x0205, B:71:0x0209, B:73:0x02f0, B:78:0x02fc, B:79:0x0301, B:80:0x0302, B:81:0x0303), top: B:162:0x01fc }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x03b9 A[Catch: UnknownResponseException -> 0x01e5, UploadAbortedException -> 0x01ed, RemoteDfuException -> 0x0653, TryCatch #2 {RemoteDfuException -> 0x0653, blocks: (B:84:0x0306, B:88:0x0310, B:90:0x03ad, B:95:0x03b5, B:97:0x03b9, B:99:0x03c4, B:100:0x0407, B:101:0x0434, B:104:0x0463, B:105:0x046a, B:107:0x046d, B:113:0x0479, B:115:0x047d, B:116:0x04bb, B:117:0x04da, B:118:0x04ed, B:120:0x054b, B:122:0x05ff, B:126:0x062e, B:127:0x0633, B:128:0x063a, B:129:0x063b, B:130:0x0642, B:132:0x0644, B:133:0x064a, B:134:0x064b, B:135:0x0650, B:136:0x0651, B:137:0x0652), top: B:157:0x0306 }] */
    @Override // bp.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        String str;
        UploadAbortedException e10;
        String str2;
        String str3;
        UnknownResponseException e11;
        String str4;
        String str5;
        String str6;
        RemoteDfuException e12;
        RemoteDfuException e13;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean z10;
        String str7;
        int i18;
        int N2;
        int i19;
        String str8;
        String str9;
        RemoteDfuException e14;
        RemoteDfuException e15;
        byte[] bArr;
        int N3;
        r("Legacy DFU bootloader found");
        this.f5419o.p(-2);
        this.f5418n.H(1000);
        BluetoothGatt bluetoothGatt = this.f5408d;
        int O2 = O(bluetoothGatt.getService(J).getCharacteristic(M));
        if (O2 < 5 || this.f5407c != null) {
            try {
                try {
                    try {
                        l(this.B, 1);
                        this.f5418n.A(10, "Notifications enabled");
                        this.f5418n.H(1000);
                        i10 = this.f5409e;
                        if ((i10 & 1) > 0) {
                            try {
                                i11 = this.f5420p;
                            } catch (RemoteDfuException e16) {
                                e12 = e16;
                                str6 = "Reset request sent";
                                str5 = "Sending Reset command (Op Code = 6)";
                                int errorNumber = e12.getErrorNumber() | 256;
                                o(e12.getMessage() + ": " + fp.b.a(errorNumber));
                                this.f5418n.A(20, String.format(Locale.US, "Remote DFU error: %s", fp.b.a(errorNumber)));
                                q(str5);
                                T(this.B, V);
                                this.f5418n.A(10, str6);
                                this.f5418n.D(bluetoothGatt, errorNumber | 8192);
                                return;
                            }
                        } else {
                            i11 = 0;
                        }
                        int i20 = (i10 & 2) > 0 ? this.f5420p : 0;
                        i12 = i10 & 4;
                        if (i12 > 0) {
                            i14 = i11;
                            i13 = this.f5420p;
                        } else {
                            i14 = i11;
                            i13 = 0;
                        }
                        InputStream inputStream = this.f5406b;
                        i17 = i20;
                        if (inputStream instanceof cp.a) {
                            cp.a aVar = (cp.a) inputStream;
                            if (aVar.v()) {
                                o("Secure DFU is required to upload selected firmware");
                                this.f5418n.A(20, "The device does not support given firmware.");
                                q("Sending Reset command (Op Code = 6)");
                                T(this.B, V);
                                this.f5418n.A(10, "Reset request sent");
                                this.f5418n.D(bluetoothGatt, 4099);
                                return;
                            }
                            int I2 = aVar.I();
                            str6 = "Reset request sent";
                            i17 = aVar.d();
                            i15 = aVar.c();
                            i16 = I2;
                        } else {
                            i16 = i14;
                            i15 = i13;
                            str6 = "Reset request sent";
                        }
                        str5 = "Sending Reset command (Op Code = 6)";
                    } catch (UnknownResponseException e17) {
                        e11 = e17;
                        str3 = "Reset request sent";
                        str4 = "Sending Reset command (Op Code = 6)";
                    } catch (UploadAbortedException e18) {
                        e10 = e18;
                        str = "Reset request sent";
                        str2 = "Sending Reset command (Op Code = 6)";
                    }
                } catch (RemoteDfuException e19) {
                    e13 = e19;
                    str6 = "Reset request sent";
                    str5 = "Sending Reset command (Op Code = 6)";
                }
            } catch (UnknownResponseException e20) {
                e11 = e20;
                str3 = "Reset request sent";
                str4 = "Sending Reset command (Op Code = 6)";
            } catch (UploadAbortedException e21) {
                e10 = e21;
                str = "Reset request sent";
                str2 = "Sending Reset command (Op Code = 6)";
            }
            try {
                try {
                    bArr = N;
                    str8 = "DFU target does not support (SD/BL)+App update";
                } catch (RemoteDfuException e22) {
                    e15 = e22;
                    str8 = "DFU target does not support (SD/BL)+App update";
                }
                try {
                    bArr[1] = (byte) i10;
                    StringBuilder sb2 = new StringBuilder();
                    try {
                        sb2.append("Sending Start DFU command (Op Code = 1, Upload Mode = ");
                        sb2.append(i10);
                        sb2.append(")");
                        q(sb2.toString());
                        T(this.B, bArr);
                        g gVar = this.f5418n;
                        gVar.A(10, "DFU Start sent (Op Code = 1, Upload Mode = " + i10 + ")");
                        q("Sending image size array to DFU Packet (" + i16 + "b, " + i17 + "b, " + i15 + "b)");
                        S(this.C, i16, i17, i15);
                        g gVar2 = this.f5418n;
                        gVar2.A(10, "Firmware image size sent (" + i16 + "b, " + i17 + "b, " + i15 + "b)");
                        byte[] u10 = u();
                        N3 = N(u10, 1);
                        g gVar3 = this.f5418n;
                        gVar3.A(10, "Response received (Op Code = " + ((int) u10[1]) + " Status = " + N3 + ")");
                    } catch (RemoteDfuException e23) {
                        e15 = e23;
                        str9 = "Starting DFU failed";
                    }
                } catch (RemoteDfuException e24) {
                    e15 = e24;
                    str9 = "Starting DFU failed";
                    e14 = e15;
                    try {
                        if (e14.getErrorNumber() != 3) {
                        }
                    } catch (RemoteDfuException e25) {
                        try {
                            if (e25.getErrorNumber() != 3) {
                                throw e25;
                            } else if (i10 == 4) {
                                this.A = false;
                                r("DFU target does not support DFU v.2");
                                this.f5418n.A(15, "DFU target does not support DFU v.2");
                                this.f5418n.A(1, "Switching to DFU v.1");
                                q("Resending Start DFU command (Op Code = 1)");
                                T(this.B, O);
                                this.f5418n.A(10, "DFU Start sent (Op Code = 1)");
                                q("Sending application image size to DFU Packet: " + this.f5420p + " bytes");
                                R(this.C, this.f5420p);
                                g gVar4 = this.f5418n;
                                gVar4.A(10, "Firmware image size sent (" + this.f5420p + " bytes)");
                                byte[] u11 = u();
                                int N4 = N(u11, 1);
                                g gVar5 = this.f5418n;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Response received (Op Code = ");
                                sb3.append((int) u11[1]);
                                str7 = ", Status = ";
                                sb3.append(str7);
                                sb3.append(N4);
                                sb3.append(")");
                                gVar5.A(10, sb3.toString());
                                if (N4 == 2) {
                                    P(bluetoothGatt, intent);
                                    return;
                                } else if (N4 == 1) {
                                    z10 = false;
                                } else {
                                    throw new RemoteDfuException(str9, N4);
                                }
                            } else {
                                throw e25;
                            }
                        } catch (RemoteDfuException e26) {
                            e13 = e26;
                            e12 = e13;
                            int errorNumber2 = e12.getErrorNumber() | 256;
                            o(e12.getMessage() + ": " + fp.b.a(errorNumber2));
                            this.f5418n.A(20, String.format(Locale.US, "Remote DFU error: %s", fp.b.a(errorNumber2)));
                            q(str5);
                            T(this.B, V);
                            this.f5418n.A(10, str6);
                            this.f5418n.D(bluetoothGatt, errorNumber2 | 8192);
                            return;
                        }
                    }
                }
                if (N3 == 2) {
                    try {
                        P(bluetoothGatt, intent);
                    } catch (RemoteDfuException e27) {
                        e14 = e27;
                        str9 = "Starting DFU failed";
                        if (e14.getErrorNumber() != 3) {
                        }
                    }
                } else {
                    if (N3 != 1) {
                        str9 = "Starting DFU failed";
                        try {
                            throw new RemoteDfuException(str9, N3);
                        } catch (RemoteDfuException e28) {
                            e15 = e28;
                            e14 = e15;
                            if (e14.getErrorNumber() != 3) {
                                throw e14;
                            } else if (i12 <= 0 || (i10 & 3) <= 0) {
                                throw e14;
                            } else {
                                this.A = false;
                                String str10 = str8;
                                r(str10);
                                this.f5418n.A(15, str10);
                                int i21 = i10 & (-5);
                                this.f5409e = i21;
                                byte[] bArr2 = N;
                                bArr2[1] = (byte) i21;
                                this.f5419o.q(2);
                                ((cp.a) this.f5406b).E(i21);
                                this.f5418n.A(1, "Sending only SD/BL");
                                q("Resending Start DFU command (Op Code = 1, Upload Mode = " + i21 + ")");
                                T(this.B, bArr2);
                                g gVar6 = this.f5418n;
                                gVar6.A(10, "DFU Start sent (Op Code = 1, Upload Mode = " + i21 + ")");
                                q("Sending image size array to DFU Packet: [" + i16 + "b, " + i17 + "b, 0b]");
                                S(this.C, i16, i17, 0);
                                g gVar7 = this.f5418n;
                                gVar7.A(10, "Firmware image size sent [" + i16 + "b, " + i17 + "b, 0b]");
                                byte[] u12 = u();
                                int N5 = N(u12, 1);
                                g gVar8 = this.f5418n;
                                gVar8.A(10, "Response received (Op Code = " + ((int) u12[1]) + " Status = " + N5 + ")");
                                if (N5 == 2) {
                                    P(bluetoothGatt, intent);
                                    return;
                                }
                                if (N5 != 1) {
                                    throw new RemoteDfuException(str9, N5);
                                }
                                str7 = ", Status = ";
                                z10 = true;
                                if (this.f5407c != null) {
                                }
                                if (!z10) {
                                    i18 = 10;
                                    if (i18 > 0) {
                                    }
                                    q("Sending Receive Firmware Image request (Op Code = 3)");
                                    T(this.B, S);
                                    this.f5418n.A(10, "Receive Firmware Image request sent");
                                    long elapsedRealtime = SystemClock.elapsedRealtime();
                                    this.f5419o.n(0);
                                    q("Uploading firmware...");
                                    this.f5418n.A(10, "Uploading firmware...");
                                    G(this.C);
                                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                                    byte[] u13 = u();
                                    N2 = N(u13, 3);
                                    q("Response received (Op Code = " + ((int) u13[0]) + ", Req Op Code = " + ((int) u13[1]) + str7 + ((int) u13[2]) + ")");
                                    g gVar9 = this.f5418n;
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append("Response received (Op Code = ");
                                    sb4.append((int) u13[1]);
                                    sb4.append(str7);
                                    sb4.append(N2);
                                    sb4.append(")");
                                    gVar9.A(10, sb4.toString());
                                    if (N2 != 1) {
                                    }
                                }
                                i18 = this.f5398y;
                                if (i18 > 0) {
                                }
                                q("Sending Receive Firmware Image request (Op Code = 3)");
                                T(this.B, S);
                                this.f5418n.A(10, "Receive Firmware Image request sent");
                                long elapsedRealtime3 = SystemClock.elapsedRealtime();
                                this.f5419o.n(0);
                                q("Uploading firmware...");
                                this.f5418n.A(10, "Uploading firmware...");
                                G(this.C);
                                long elapsedRealtime22 = SystemClock.elapsedRealtime();
                                byte[] u132 = u();
                                N2 = N(u132, 3);
                                q("Response received (Op Code = " + ((int) u132[0]) + ", Req Op Code = " + ((int) u132[1]) + str7 + ((int) u132[2]) + ")");
                                g gVar92 = this.f5418n;
                                StringBuilder sb42 = new StringBuilder();
                                sb42.append("Response received (Op Code = ");
                                sb42.append((int) u132[1]);
                                sb42.append(str7);
                                sb42.append(N2);
                                sb42.append(")");
                                gVar92.A(10, sb42.toString());
                                if (N2 != 1) {
                                }
                            }
                        }
                    }
                    str7 = ", Status = ";
                    z10 = true;
                    if (this.f5407c != null) {
                        this.f5418n.A(10, "Writing Initialize DFU Parameters...");
                        if (z10) {
                            q("Sending the Initialize DFU Parameters START (Op Code = 2, Value = 0)");
                            T(this.B, Q);
                            q("Sending " + this.f5421q + " bytes of init packet");
                            H(this.C, null);
                            q("Sending the Initialize DFU Parameters COMPLETE (Op Code = 2, Value = 1)");
                            T(this.B, R);
                            this.f5418n.A(10, "Initialize DFU Parameters completed");
                        } else {
                            q("Sending the Initialize DFU Parameters (Op Code = 2)");
                            T(this.B, P);
                            q("Sending " + this.f5421q + " bytes of init packet");
                            H(this.C, null);
                        }
                        byte[] u14 = u();
                        int N6 = N(u14, 2);
                        g gVar10 = this.f5418n;
                        gVar10.A(10, "Response received (Op Code = " + ((int) u14[1]) + str7 + N6 + ")");
                        if (N6 != 1) {
                            throw new RemoteDfuException("Device returned error after sending init packet", N6);
                        }
                    }
                    try {
                        if (!z10 && ((i19 = this.f5398y) <= 0 || i19 > 10)) {
                            i18 = 10;
                            if (i18 > 0) {
                                this.f5398y = i18;
                                q("Sending the number of packets before notifications (Op Code = 8, Value = " + i18 + ")");
                                byte[] bArr3 = W;
                                Q(bArr3, i18);
                                T(this.B, bArr3);
                                g gVar11 = this.f5418n;
                                gVar11.A(10, "Packet Receipt Notif Req (Op Code = 8) sent (Value = " + i18 + ")");
                            }
                            q("Sending Receive Firmware Image request (Op Code = 3)");
                            T(this.B, S);
                            this.f5418n.A(10, "Receive Firmware Image request sent");
                            long elapsedRealtime32 = SystemClock.elapsedRealtime();
                            this.f5419o.n(0);
                            q("Uploading firmware...");
                            this.f5418n.A(10, "Uploading firmware...");
                            G(this.C);
                            long elapsedRealtime222 = SystemClock.elapsedRealtime();
                            byte[] u1322 = u();
                            N2 = N(u1322, 3);
                            q("Response received (Op Code = " + ((int) u1322[0]) + ", Req Op Code = " + ((int) u1322[1]) + str7 + ((int) u1322[2]) + ")");
                            g gVar922 = this.f5418n;
                            StringBuilder sb422 = new StringBuilder();
                            sb422.append("Response received (Op Code = ");
                            sb422.append((int) u1322[1]);
                            sb422.append(str7);
                            sb422.append(N2);
                            sb422.append(")");
                            gVar922.A(10, sb422.toString());
                            if (N2 != 1) {
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append("Transfer of ");
                                sb5.append(this.f5419o.d());
                                sb5.append(" bytes has taken ");
                                long j10 = elapsedRealtime222 - elapsedRealtime32;
                                sb5.append(j10);
                                sb5.append(" ms");
                                q(sb5.toString());
                                g gVar12 = this.f5418n;
                                gVar12.A(10, "Upload completed in " + j10 + " ms");
                                q("Sending Validate request (Op Code = 4)");
                                T(this.B, T);
                                this.f5418n.A(10, "Validate request sent");
                                byte[] u15 = u();
                                int N7 = N(u15, 4);
                                q("Response received (Op Code = " + ((int) u15[0]) + ", Req Op Code = " + ((int) u15[1]) + str7 + ((int) u15[2]) + ")");
                                g gVar13 = this.f5418n;
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("Response received (Op Code = ");
                                sb6.append((int) u15[1]);
                                sb6.append(str7);
                                sb6.append(N7);
                                sb6.append(")");
                                gVar13.A(10, sb6.toString());
                                if (N7 == 1) {
                                    this.f5419o.p(-5);
                                    q("Sending Activate and Reset request (Op Code = 5)");
                                    T(this.B, U);
                                    this.f5418n.A(10, "Activate and Reset request sent");
                                    this.f5418n.I();
                                    this.f5418n.A(5, "Disconnected by the remote device");
                                    D(intent, O2 == 5);
                                    return;
                                }
                                throw new RemoteDfuException("Device returned validation error", N7);
                            }
                            throw new RemoteDfuException("Device returned error after sending file", N2);
                        }
                        q("Uploading firmware...");
                        this.f5418n.A(10, "Uploading firmware...");
                        G(this.C);
                        long elapsedRealtime2222 = SystemClock.elapsedRealtime();
                        byte[] u13222 = u();
                        N2 = N(u13222, 3);
                        q("Response received (Op Code = " + ((int) u13222[0]) + ", Req Op Code = " + ((int) u13222[1]) + str7 + ((int) u13222[2]) + ")");
                        g gVar9222 = this.f5418n;
                        StringBuilder sb4222 = new StringBuilder();
                        sb4222.append("Response received (Op Code = ");
                        sb4222.append((int) u13222[1]);
                        sb4222.append(str7);
                        sb4222.append(N2);
                        sb4222.append(")");
                        gVar9222.A(10, sb4222.toString());
                        if (N2 != 1) {
                        }
                    } catch (DeviceDisconnectedException e29) {
                        o("Disconnected while sending data");
                        throw e29;
                    }
                    i18 = this.f5398y;
                    if (i18 > 0) {
                    }
                    q("Sending Receive Firmware Image request (Op Code = 3)");
                    T(this.B, S);
                    this.f5418n.A(10, "Receive Firmware Image request sent");
                    long elapsedRealtime322 = SystemClock.elapsedRealtime();
                    this.f5419o.n(0);
                }
            } catch (UnknownResponseException e30) {
                e11 = e30;
                str3 = str6;
                str4 = str5;
                o(e11.getMessage());
                this.f5418n.A(20, e11.getMessage());
                q(str4);
                T(this.B, V);
                this.f5418n.A(10, str3);
                this.f5418n.D(bluetoothGatt, LoadFileException.ERROR_VERSION_CHECK_LOW);
            } catch (UploadAbortedException e31) {
                e10 = e31;
                str = str6;
                str2 = str5;
                q(str2);
                this.f5411g = false;
                T(this.B, V);
                this.f5418n.A(10, str);
                throw e10;
            }
        } else {
            r("Init packet not set for the DFU Bootloader version " + O2);
            this.f5418n.A(20, "The Init packet is required by this version DFU Bootloader");
            this.f5418n.D(bluetoothGatt, 4107);
        }
    }
}
