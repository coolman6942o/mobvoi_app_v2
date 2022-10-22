package bp;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import bp.b;
import bp.c;
import com.realsil.sdk.dfu.exception.LoadFileException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.UUID;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.internal.exception.DeviceDisconnectedException;
import no.nordicsemi.android.dfu.internal.exception.DfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuException;
import no.nordicsemi.android.dfu.internal.exception.RemoteDfuExtendedErrorException;
import no.nordicsemi.android.dfu.internal.exception.UnknownResponseException;
import no.nordicsemi.android.dfu.internal.exception.UploadAbortedException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SecureDfuImpl.java */
/* loaded from: classes3.dex */
public class v extends bp.b {
    protected static final UUID E;
    protected static final UUID F;
    protected static final UUID G;
    protected static UUID H;
    protected static UUID I;
    protected static UUID J;
    private static final byte[] K = {1, 1, 0, 0, 0, 0};
    private static final byte[] L = {1, 2, 0, 0, 0, 0};
    private static final byte[] M = {2, 0, 0};
    private static final byte[] N = {3};
    private static final byte[] O = {4};
    private static final byte[] P = {6, 0};
    private BluetoothGattCharacteristic B;
    private BluetoothGattCharacteristic C;
    private final d D = new d();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SecureDfuImpl.java */
    /* loaded from: classes3.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        protected int f5504a;

        /* renamed from: b  reason: collision with root package name */
        protected int f5505b;

        private b(v vVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SecureDfuImpl.java */
    /* loaded from: classes3.dex */
    public class c extends b {

        /* renamed from: c  reason: collision with root package name */
        protected int f5506c;

        private c(v vVar) {
            super();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: SecureDfuImpl.java */
    /* loaded from: classes3.dex */
    public class d extends b.a {
        protected d() {
            super();
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGattCharacteristic.getValue() == null || bluetoothGattCharacteristic.getValue().length < 3) {
                v vVar = v.this;
                vVar.o("Empty response: " + b(bluetoothGattCharacteristic));
                v vVar2 = v.this;
                vVar2.f5415k = LoadFileException.ERROR_VERSION_CHECK_LOW;
                vVar2.s();
                return;
            }
            if (bluetoothGattCharacteristic.getIntValue(17, 0).intValue() != 96) {
                v vVar3 = v.this;
                vVar3.o("Invalid response: " + b(bluetoothGattCharacteristic));
                v.this.f5415k = LoadFileException.ERROR_VERSION_CHECK_LOW;
            } else if (bluetoothGattCharacteristic.getIntValue(17, 1).intValue() == 3) {
                int intValue = bluetoothGattCharacteristic.getIntValue(20, 3).intValue();
                if (((int) (((cp.a) v.this.f5406b).q() & 4294967295L)) == bluetoothGattCharacteristic.getIntValue(20, 7).intValue()) {
                    v.this.f5419o.m(intValue);
                } else {
                    v vVar4 = v.this;
                    if (vVar4.f5397x) {
                        vVar4.f5397x = false;
                        vVar4.s();
                        return;
                    }
                }
                g(bluetoothGatt, bluetoothGattCharacteristic);
            } else if (!v.this.A) {
                if (bluetoothGattCharacteristic.getIntValue(17, 2).intValue() != 1) {
                    v.this.A = true;
                }
                f(bluetoothGatt, bluetoothGattCharacteristic);
            }
            v.this.s();
        }
    }

    static {
        UUID uuid = new UUID(279658205548544L, -9223371485494954757L);
        E = uuid;
        UUID uuid2 = new UUID(-8157989241631715488L, -6937650605005804976L);
        F = uuid2;
        UUID uuid3 = new UUID(-8157989237336748192L, -6937650605005804976L);
        G = uuid3;
        H = uuid;
        I = uuid2;
        J = uuid3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Intent intent, g gVar) {
        super(intent, gVar);
    }

    private int L(byte[] bArr, int i10) throws UnknownResponseException {
        if (bArr != null && bArr.length >= 3 && bArr[0] == 96 && bArr[1] == i10 && (bArr[2] == 1 || bArr[2] == 2 || bArr[2] == 3 || bArr[2] == 4 || bArr[2] == 5 || bArr[2] == 7 || bArr[2] == 8 || bArr[2] == 10 || bArr[2] == 11)) {
            return bArr[2];
        }
        throw new UnknownResponseException("Invalid response received", bArr, 96, i10);
    }

    private b M() throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        if (this.f5412h) {
            W(this.B, N);
            byte[] u10 = u();
            int L2 = L(u10, 3);
            if (L2 == 11) {
                throw new RemoteDfuExtendedErrorException("Receiving Checksum failed", u10[3]);
            } else if (L2 == 1) {
                b bVar = new b();
                bVar.f5504a = this.B.getIntValue(20, 3).intValue();
                bVar.f5505b = this.B.getIntValue(20, 7).intValue();
                return bVar;
            } else {
                throw new RemoteDfuException("Receiving Checksum failed", L2);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
    }

    private c N(int i10) throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        if (this.f5412h) {
            byte[] bArr = P;
            bArr[1] = (byte) i10;
            W(this.B, bArr);
            byte[] u10 = u();
            int L2 = L(u10, 6);
            if (L2 == 11) {
                throw new RemoteDfuExtendedErrorException("Selecting object failed", u10[3]);
            } else if (L2 == 1) {
                c cVar = new c();
                cVar.f5506c = this.B.getIntValue(20, 3).intValue();
                cVar.f5504a = this.B.getIntValue(20, 7).intValue();
                cVar.f5505b = this.B.getIntValue(20, 11).intValue();
                return cVar;
            } else {
                throw new RemoteDfuException("Selecting object failed", L2);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to read object info: device disconnected");
        }
    }

    private void O(BluetoothGatt bluetoothGatt) throws RemoteDfuException, DeviceDisconnectedException, DfuException, UploadAbortedException, UnknownResponseException {
        String str;
        int i10;
        String str2;
        boolean z10;
        long j10;
        long j11;
        boolean z11;
        boolean z12;
        String str3;
        int i11 = this.f5398y;
        if (i11 > 0) {
            S(i11);
            this.f5418n.A(10, "Packet Receipt Notif Req (Op Code = 2) sent (Value = " + i11 + ")");
        }
        q("Setting object to Data (Op Code = 6, Type = 2)");
        c N2 = N(2);
        Locale locale = Locale.US;
        q(String.format(locale, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(N2.f5506c), Integer.valueOf(N2.f5504a), Integer.valueOf(N2.f5505b)));
        this.f5418n.A(10, String.format(locale, "Data object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(N2.f5506c), Integer.valueOf(N2.f5504a), Integer.valueOf(N2.f5505b)));
        this.f5419o.o(N2.f5506c);
        int i12 = this.f5420p;
        int i13 = N2.f5506c;
        int i14 = ((i12 + i13) - 1) / i13;
        int i15 = N2.f5504a;
        if (i15 > 0) {
            try {
                int i16 = i15 / i13;
                int i17 = i13 * i16;
                int i18 = i15 - i17;
                if (i18 == 0) {
                    i17 -= i13;
                } else {
                    i13 = i18;
                }
                int i19 = i17;
                if (i19 > 0) {
                    i10 = i16;
                    str = "Packet Receipt Notif Req (Op Code = 2) sent (Value = ";
                    this.f5406b.read(new byte[i19]);
                    this.f5406b.mark(N2.f5506c);
                } else {
                    str = "Packet Receipt Notif Req (Op Code = 2) sent (Value = ";
                    i10 = i16;
                }
                this.f5406b.read(new byte[i13]);
                str2 = ")";
                if (((int) (((cp.a) this.f5406b).q() & 4294967295L)) == N2.f5505b) {
                    q(N2.f5504a + " bytes of data sent before, CRC match");
                    this.f5418n.A(10, N2.f5504a + " bytes of data sent before, CRC match");
                    this.f5419o.n(N2.f5504a);
                    this.f5419o.m(N2.f5504a);
                    if (i13 != N2.f5506c || N2.f5504a >= this.f5420p) {
                        z10 = true;
                    } else {
                        q("Executing data object (Op Code = 4)");
                        U();
                        this.f5418n.A(10, "Data object executed");
                    }
                } else {
                    q(N2.f5504a + " bytes sent before, CRC does not match");
                    this.f5418n.A(15, N2.f5504a + " bytes sent before, CRC does not match");
                    this.f5419o.n(i19);
                    this.f5419o.m(i19);
                    N2.f5504a = N2.f5504a - i13;
                    N2.f5505b = 0;
                    this.f5406b.reset();
                    q("Resuming from byte " + N2.f5504a + "...");
                    this.f5418n.A(10, "Resuming from byte " + N2.f5504a + "...");
                }
                z10 = false;
            } catch (IOException e10) {
                p("Error while reading firmware stream", e10);
                this.f5418n.D(bluetoothGatt, 4100);
                return;
            }
        } else {
            str = "Packet Receipt Notif Req (Op Code = 2) sent (Value = ";
            str2 = ")";
            this.f5419o.n(0);
            z10 = false;
            i10 = 0;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (N2.f5504a < this.f5420p) {
            int i20 = 1;
            while (this.f5419o.b() > 0) {
                if (!z10) {
                    int b10 = this.f5419o.b();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Creating Data object (Op Code = 1, Type = 2, Size = ");
                    sb2.append(b10);
                    sb2.append(") (");
                    int i21 = i10 + 1;
                    sb2.append(i21);
                    z11 = z10;
                    sb2.append("/");
                    sb2.append(i14);
                    sb2.append(str2);
                    q(sb2.toString());
                    T(2, b10);
                    g gVar = this.f5418n;
                    StringBuilder sb3 = new StringBuilder();
                    j11 = elapsedRealtime;
                    sb3.append("Data object (");
                    sb3.append(i21);
                    sb3.append("/");
                    sb3.append(i14);
                    sb3.append(") created");
                    gVar.A(10, sb3.toString());
                    this.f5418n.A(10, "Uploading firmware...");
                } else {
                    j11 = elapsedRealtime;
                    this.f5418n.A(10, "Resuming uploading firmware...");
                    z11 = false;
                }
                try {
                    q("Uploading firmware...");
                    G(this.C);
                    q("Sending Calculate Checksum command (Op Code = 3)");
                    b M2 = M();
                    Locale locale2 = Locale.US;
                    q(String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(M2.f5504a), Integer.valueOf(M2.f5505b)));
                    this.f5418n.A(10, String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(M2.f5504a), Integer.valueOf(M2.f5505b)));
                    int d10 = this.f5419o.d() - M2.f5504a;
                    if (d10 > 0) {
                        r(d10 + " bytes were lost!");
                        this.f5418n.A(15, d10 + " bytes were lost");
                        try {
                            this.f5406b.reset();
                            this.f5406b.read(new byte[N2.f5506c - d10]);
                            this.f5419o.n(M2.f5504a);
                            this.f5398y = 1;
                            S(1);
                            g gVar2 = this.f5418n;
                            StringBuilder sb4 = new StringBuilder();
                            z12 = z11;
                            str3 = str;
                            sb4.append(str3);
                            sb4.append(1);
                            sb4.append(str2);
                            gVar2.A(10, sb4.toString());
                        } catch (IOException e11) {
                            p("Error while reading firmware stream", e11);
                            this.f5418n.D(bluetoothGatt, 4100);
                            return;
                        }
                    } else {
                        z12 = z11;
                        str3 = str;
                    }
                    int q5 = (int) (((cp.a) this.f5406b).q() & 4294967295L);
                    if (q5 != M2.f5505b) {
                        String format = String.format(locale2, "CRC does not match! Expected %08X but found %08X.", Integer.valueOf(q5), Integer.valueOf(M2.f5505b));
                        if (i20 < 3) {
                            i20++;
                            String str4 = format + String.format(locale2, " Retrying...(%d/%d)", Integer.valueOf(i20), 3);
                            q(str4);
                            this.f5418n.A(15, str4);
                            try {
                                this.f5406b.reset();
                                this.f5419o.n(((cp.a) this.f5406b).n());
                            } catch (IOException e12) {
                                p("Error while resetting the firmware stream", e12);
                                this.f5418n.D(bluetoothGatt, 4100);
                                return;
                            }
                        } else {
                            o(format);
                            this.f5418n.A(20, format);
                            this.f5418n.D(bluetoothGatt, LoadFileException.ERROR_SECTION_SIZE_CHECK_FAILED);
                            return;
                        }
                    } else if (d10 > 0) {
                        str = str3;
                        elapsedRealtime = j11;
                        z10 = true;
                    } else {
                        q("Executing data object (Op Code = 4)");
                        V(this.f5419o.j());
                        this.f5418n.A(10, "Data object executed");
                        i10++;
                        this.f5406b.mark(0);
                        i20 = 1;
                    }
                    str = str3;
                    z10 = z12;
                    elapsedRealtime = j11;
                } catch (DeviceDisconnectedException e13) {
                    o("Disconnected while sending data");
                    throw e13;
                }
            }
            j10 = elapsedRealtime;
        } else {
            j10 = elapsedRealtime;
            q("Executing data object (Op Code = 4)");
            V(true);
            this.f5418n.A(10, "Data object executed");
        }
        long elapsedRealtime2 = SystemClock.elapsedRealtime();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("Transfer of ");
        sb5.append(this.f5419o.d() - N2.f5504a);
        sb5.append(" bytes has taken ");
        long j12 = elapsedRealtime2 - j10;
        sb5.append(j12);
        sb5.append(" ms");
        q(sb5.toString());
        this.f5418n.A(10, "Upload completed in " + j12 + " ms");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void P(BluetoothGatt bluetoothGatt, boolean z10) throws RemoteDfuException, DeviceDisconnectedException, DfuException, UploadAbortedException, UnknownResponseException {
        boolean z11;
        boolean z12;
        int i10;
        IOException e10;
        CRC32 crc32 = new CRC32();
        q("Setting object to Command (Op Code = 6, Type = 1)");
        c N2 = N(1);
        Locale locale = Locale.US;
        int i11 = 3;
        q(String.format(locale, "Command object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(N2.f5506c), Integer.valueOf(N2.f5504a), Integer.valueOf(N2.f5505b)));
        this.f5418n.A(10, String.format(locale, "Command object info received (Max size = %d, Offset = %d, CRC = %08X)", Integer.valueOf(N2.f5506c), Integer.valueOf(N2.f5504a), Integer.valueOf(N2.f5505b)));
        int i12 = this.f5421q;
        if (z10 && (i10 = N2.f5504a) > 0 && i10 <= i12) {
            try {
                byte[] bArr = new byte[i10];
                this.f5407c.read(bArr);
                crc32.update(bArr);
            } catch (IOException e11) {
                e10 = e11;
                z12 = false;
                z11 = false;
            }
            if (N2.f5505b == ((int) (crc32.getValue() & 4294967295L))) {
                q("Init packet CRC is the same");
                if (N2.f5504a == this.f5421q) {
                    q("-> Whole Init packet was sent before");
                    try {
                        this.f5418n.A(10, "Received CRC match Init packet");
                        z12 = true;
                        z11 = false;
                    } catch (IOException e12) {
                        e10 = e12;
                        z12 = true;
                        z11 = false;
                        p("Error while reading " + N2.f5504a + " bytes from the init packet stream", e10);
                        try {
                            this.f5407c.reset();
                            crc32.reset();
                            N2.f5504a = 0;
                            if (!z12) {
                            }
                            q("Executing init packet (Op Code = 4)");
                            U();
                            this.f5418n.A(10, "Command object executed");
                        } catch (IOException e13) {
                            p("Error while resetting the init packet stream", e13);
                            this.f5418n.D(bluetoothGatt, 4100);
                            return;
                        }
                    }
                } else {
                    q("-> " + N2.f5504a + " bytes of Init packet were sent before");
                    try {
                        this.f5418n.A(10, "Resuming sending Init packet...");
                        z11 = true;
                        z12 = false;
                    } catch (IOException e14) {
                        e10 = e14;
                        z11 = true;
                        z12 = false;
                        p("Error while reading " + N2.f5504a + " bytes from the init packet stream", e10);
                        this.f5407c.reset();
                        crc32.reset();
                        N2.f5504a = 0;
                        if (!z12) {
                        }
                        q("Executing init packet (Op Code = 4)");
                        U();
                        this.f5418n.A(10, "Command object executed");
                    }
                }
                if (!z12) {
                    S(0);
                    this.f5418n.A(10, "Packet Receipt Notif disabled (Op Code = 2, Value = 0)");
                    int i13 = 1;
                    while (i13 <= i11) {
                        if (!z11) {
                            q("Creating Init packet object (Op Code = 1, Type = 1, Size = " + this.f5421q + ")");
                            T(1, this.f5421q);
                            this.f5418n.A(10, "Command object created");
                        }
                        q("Sending " + (this.f5421q - N2.f5504a) + " bytes of init packet...");
                        H(this.C, crc32);
                        int value = (int) (crc32.getValue() & 4294967295L);
                        g gVar = this.f5418n;
                        Locale locale2 = Locale.US;
                        gVar.A(10, String.format(locale2, "Command object sent (CRC = %08X)", Integer.valueOf(value)));
                        q("Sending Calculate Checksum command (Op Code = 3)");
                        b M2 = M();
                        this.f5418n.A(10, String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(M2.f5504a), Integer.valueOf(M2.f5505b)));
                        q(String.format(locale2, "Checksum received (Offset = %d, CRC = %08X)", Integer.valueOf(M2.f5504a), Integer.valueOf(M2.f5505b)));
                        if (value == M2.f5505b) {
                            break;
                        }
                        i11 = 3;
                        if (i13 < 3) {
                            i13++;
                            q("CRC does not match! Retrying...(" + i13 + "/3)");
                            this.f5418n.A(15, "CRC does not match! Retrying...(" + i13 + "/3)");
                            try {
                                N2.f5504a = 0;
                                N2.f5505b = 0;
                                this.f5407c.reset();
                                crc32.reset();
                                z11 = false;
                            } catch (IOException e15) {
                                p("Error while resetting the init packet stream", e15);
                                this.f5418n.D(bluetoothGatt, 4100);
                                return;
                            }
                        } else {
                            o("CRC does not match!");
                            this.f5418n.A(20, "CRC does not match!");
                            this.f5418n.D(bluetoothGatt, LoadFileException.ERROR_SECTION_SIZE_CHECK_FAILED);
                            return;
                        }
                    }
                }
                q("Executing init packet (Op Code = 4)");
                U();
                this.f5418n.A(10, "Command object executed");
            }
            this.f5407c.reset();
            crc32.reset();
            N2.f5504a = 0;
        }
        z12 = false;
        z11 = false;
        if (!z12) {
        }
        q("Executing init packet (Op Code = 4)");
        U();
        this.f5418n.A(10, "Command object executed");
    }

    private void Q(byte[] bArr, int i10) {
        bArr[1] = (byte) (i10 & 255);
        bArr[2] = (byte) ((i10 >> 8) & 255);
    }

    private void R(byte[] bArr, int i10) {
        bArr[2] = (byte) (i10 & 255);
        bArr[3] = (byte) ((i10 >> 8) & 255);
        bArr[4] = (byte) ((i10 >> 16) & 255);
        bArr[5] = (byte) ((i10 >> 24) & 255);
    }

    private void S(int i10) throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        if (this.f5412h) {
            q("Sending the number of packets before notifications (Op Code = 2, Value = " + i10 + ")");
            byte[] bArr = M;
            Q(bArr, i10);
            W(this.B, bArr);
            byte[] u10 = u();
            int L2 = L(u10, 2);
            if (L2 == 11) {
                throw new RemoteDfuExtendedErrorException("Sending the number of packets failed", u10[3]);
            } else if (L2 != 1) {
                throw new RemoteDfuException("Sending the number of packets failed", L2);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
    }

    private void T(int i10, int i11) throws DeviceDisconnectedException, DfuException, UploadAbortedException, RemoteDfuException, UnknownResponseException {
        if (this.f5412h) {
            byte[] bArr = i10 == 1 ? K : L;
            R(bArr, i11);
            W(this.B, bArr);
            byte[] u10 = u();
            int L2 = L(u10, 1);
            if (L2 == 11) {
                throw new RemoteDfuExtendedErrorException("Creating Command object failed", u10[3]);
            } else if (L2 != 1) {
                throw new RemoteDfuException("Creating Command object failed", L2);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to create object: device disconnected");
        }
    }

    private void U() throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        if (this.f5412h) {
            W(this.B, O);
            byte[] u10 = u();
            int L2 = L(u10, 4);
            if (L2 == 11) {
                throw new RemoteDfuExtendedErrorException("Executing object failed", u10[3]);
            } else if (L2 != 1) {
                throw new RemoteDfuException("Executing object failed", L2);
            }
        } else {
            throw new DeviceDisconnectedException("Unable to read Checksum: device disconnected");
        }
    }

    private void V(boolean z10) throws DfuException, DeviceDisconnectedException, UploadAbortedException, UnknownResponseException, RemoteDfuException {
        try {
            U();
        } catch (RemoteDfuException e10) {
            if (!z10 || e10.getErrorNumber() != 5) {
                throw e10;
            }
            r(e10.getMessage() + ": " + fp.c.a(com.realsil.sdk.dfu.DfuException.ERROR_REMOTE_CRC_ERROR));
            if (this.f5409e == 1) {
                r("Are you sure your new SoftDevice is API compatible with the updated one? If not, update the bootloader as well");
            }
            this.f5418n.A(15, String.format(Locale.US, "Remote DFU error: %s. SD busy? Retrying...", fp.c.a(com.realsil.sdk.dfu.DfuException.ERROR_REMOTE_CRC_ERROR)));
            q("SD busy? Retrying...");
            q("Executing data object (Op Code = 4)");
            U();
        }
    }

    private void W(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) throws DeviceDisconnectedException, DfuException, UploadAbortedException {
        z(bluetoothGattCharacteristic, bArr, false);
    }

    @Override // bp.b
    protected UUID E() {
        return H;
    }

    @Override // bp.b
    protected UUID F() {
        return J;
    }

    /* renamed from: K */
    public c.a e() {
        return this.D;
    }

    @Override // bp.l
    public boolean f(Intent intent, BluetoothGatt bluetoothGatt) {
        BluetoothGattCharacteristic characteristic;
        BluetoothGattService service = bluetoothGatt.getService(H);
        if (service == null || (characteristic = service.getCharacteristic(I)) == null || characteristic.getDescriptor(bp.c.f5403u) == null) {
            return false;
        }
        this.B = characteristic;
        BluetoothGattCharacteristic characteristic2 = service.getCharacteristic(J);
        this.C = characteristic2;
        return characteristic2 != null;
    }

    @Override // bp.c, bp.l
    public boolean g(Intent intent, BluetoothGatt bluetoothGatt, int i10, InputStream inputStream, InputStream inputStream2) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        if (inputStream2 != null) {
            return super.g(intent, bluetoothGatt, i10, inputStream, inputStream2);
        }
        this.f5418n.A(20, "The Init packet is required by this version DFU Bootloader");
        this.f5418n.D(bluetoothGatt, 4107);
        return false;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:36|8|(6:13|(1:16)|34|17|22|37)|14|(0)|34|17|22|37) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0073, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007a, code lost:
        if (r9.f5419o.k() == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
        r9.A = false;
        r("Sending SD+BL failed. Trying to send App only");
        r9.f5418n.A(15, "Invalid system components. Trying to send application");
        r9.f5409e = 4;
        r2 = (cp.a) r9.f5406b;
        r2.E(4);
        r0 = r2.i();
        r9.f5407c = new java.io.ByteArrayInputStream(r0);
        r9.f5421q = r0.length;
        r0 = r2.c();
        r9.f5420p = r0;
        r9.f5419o.i(r0, 2, 2);
        P(r1, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x00ce, code lost:
        throw r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006a A[Catch: RemoteDfuException -> 0x00cf, UnknownResponseException -> 0x0169, UploadAbortedException -> 0x0182, TRY_LEAVE, TryCatch #3 {RemoteDfuException -> 0x00cf, blocks: (B:8:0x0045, B:10:0x005e, B:16:0x006a, B:19:0x0074, B:21:0x007c, B:22:0x00b3, B:23:0x00ce), top: B:36:0x0045 }] */
    @Override // bp.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(Intent intent) throws DfuException, DeviceDisconnectedException, UploadAbortedException {
        RemoteDfuExtendedErrorException remoteDfuExtendedErrorException;
        boolean z10;
        r("Secure DFU bootloader found");
        this.f5419o.p(-2);
        this.f5418n.H(1000);
        BluetoothGatt bluetoothGatt = this.f5408d;
        if (intent.hasExtra("no.nordicsemi.android.dfu.extra.EXTRA_MTU") && Build.VERSION.SDK_INT >= 21) {
            int intExtra = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_MTU", com.realsil.sdk.dfu.DfuException.ERROR_REMOTE_CRC_ERROR);
            q("Requesting MTU = " + intExtra);
            w(intExtra);
        }
        try {
            try {
                l(this.B, 1);
                this.f5418n.A(10, "Notifications enabled");
                this.f5418n.H(1000);
                if (intent.hasExtra("no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_RESUME") && intent.getBooleanExtra("no.nordicsemi.android.dfu.extra.EXTRA_DISABLE_RESUME", false)) {
                    z10 = false;
                    if (!z10) {
                        q("Resume feature disabled. Performing fresh DFU");
                    }
                    P(bluetoothGatt, z10);
                    O(bluetoothGatt);
                    this.f5419o.p(-5);
                    this.f5418n.I();
                    this.f5418n.A(5, "Disconnected by the remote device");
                    D(intent, false);
                }
                z10 = true;
                if (!z10) {
                }
                P(bluetoothGatt, z10);
                O(bluetoothGatt);
                this.f5419o.p(-5);
                this.f5418n.I();
                this.f5418n.A(5, "Disconnected by the remote device");
                D(intent, false);
            } catch (RemoteDfuException e10) {
                int errorNumber = e10.getErrorNumber() | 512;
                o(e10.getMessage() + ": " + fp.c.a(errorNumber));
                this.f5418n.A(20, String.format(Locale.US, "Remote DFU error: %s", fp.c.a(errorNumber)));
                if (e10 instanceof RemoteDfuExtendedErrorException) {
                    int extendedErrorNumber = ((RemoteDfuExtendedErrorException) e10).getExtendedErrorNumber() | 1024;
                    o("Extended Error details: " + fp.c.c(extendedErrorNumber));
                    this.f5418n.A(20, "Details: " + fp.c.c(extendedErrorNumber) + " (Code = " + remoteDfuExtendedErrorException.getExtendedErrorNumber() + ")");
                    this.f5418n.D(bluetoothGatt, extendedErrorNumber | 8192);
                    return;
                }
                this.f5418n.D(bluetoothGatt, errorNumber | 8192);
            }
        } catch (UnknownResponseException e11) {
            o(e11.getMessage());
            this.f5418n.A(20, e11.getMessage());
            this.f5418n.D(bluetoothGatt, LoadFileException.ERROR_VERSION_CHECK_LOW);
        } catch (UploadAbortedException e12) {
            throw e12;
        }
    }
}
