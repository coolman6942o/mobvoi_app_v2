package dm;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.realsil.sdk.core.bluetooth.scanner.ScannerParams;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import com.realsil.sdk.dfu.DfuException;
import com.realsil.sdk.dfu.exception.OtaException;
import com.realsil.sdk.dfu.model.DfuConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import wl.a;
import xl.b;
/* loaded from: classes2.dex */
public class d extends c {
    public d(Context context, DfuConfig dfuConfig, b bVar) {
        super(context, dfuConfig, bVar);
    }

    public final void A1() {
        this.f36595i = false;
        D(DfuException.ERROR_REMOTE_CRC_ERROR);
        try {
            Thread.sleep(1500L);
        } catch (InterruptedException unused) {
        }
        this.M = new cm.d(this.f36590d, 2);
        q1();
        if (v().f6004j == 5 || v().f6004j == 9 || v().f6004j == 4 || v().f6004j == 6 || v().f6004j == 7 || v().f6004j == 8 || v().f6004j == 13 || v().f6004j == 10 || v().f6004j == 11 || v().f6004j == 12) {
            r1();
        }
        p1();
        if (this.f36587a) {
            il.b.c(v().toString());
        }
        Q();
        List<a> list = this.f36608v;
        if (list != null && list.size() > 0) {
            for (a aVar : this.f36608v) {
                aVar.Q();
            }
        }
        this.f36595i = true;
        il.b.c("Ota Environment prepared.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0206, code lost:
        if (r7.O == 1) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0216, code lost:
        if (r7.O == 1) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0218, code lost:
        w0(r7.f5234s0, r7.I0, r7.f36609w);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0222, code lost:
        F1(r7.f5234s0, r7.I0, r7.f36609w);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean B1() {
        if (!e()) {
            v0(DfuException.ERROR_DFU_ABORTED, true);
            return false;
        } else if (!v().N() || j()) {
            D(521);
            il.b.c(String.format("mOtaWorkMode=0x%04X, ICType=%02X", Integer.valueOf(this.I), Integer.valueOf(v().f6004j)));
            if (this.f36587a) {
                il.b.j(u().toString());
            }
            S(this.f5234s0, this.H0, true);
            if (Build.VERSION.SDK_INT >= 23) {
                W(this.f5234s0, 256);
            }
            n0();
            if (v().f6004j <= 3) {
                this.O = u1();
                if (this.f36587a) {
                    il.b.j("mRemoteOtaFunctionInfo=" + this.O);
                }
                if (this.O == 1) {
                    s1();
                }
            } else {
                if (this.f36587a) {
                    il.b.c("isBufferCheckEnabled=" + v().Q());
                }
                if (!v().Q()) {
                    this.O = 0;
                } else {
                    this.O = t1();
                }
                if (this.f36587a) {
                    il.b.j("mRemoteOtaFunctionInfo=" + this.O);
                }
            }
            if (this.I == 0) {
                r0();
            }
            u().D();
            if (v().f6005k >= 2) {
                b1(u().g());
            }
            e1(u().g());
            if (!t().G()) {
                this.P = 0;
                il.b.c(String.format(Locale.US, "BreakpointResume disable: mImageUpdateOffset=0x%08X(%d)", 0, Integer.valueOf(this.P)));
            }
            if (this.P == 0) {
                q0();
            }
            if (this.P - 12 >= u().i()) {
                il.b.c("Last send reach the bottom");
            } else if (v().f6004j <= 3) {
                if (this.I == 17) {
                    K1(u().g());
                } else {
                    J1(u().g());
                }
                if (this.O == 1) {
                    D1(this.f5234s0, this.I0, this.f36609w);
                } else {
                    E1(this.f5234s0, this.I0, this.f36609w);
                }
            } else if (v().f6004j == 4 || v().f6004j == 6 || v().f6004j == 7 || v().f6004j == 8 || v().f6004j == 13 || v().f6004j == 5 || v().f6004j == 9 || v().f6004j == 10 || v().f6004j == 11 || v().f6004j == 12) {
                I1(u().g());
            } else {
                I1(u().g());
            }
            if (this.I == 18) {
                this.f37632n0[u().h()] = this.f36609w.O();
            }
            u().v();
            B();
            if (this.I == 17) {
                try {
                    Thread.sleep(30L);
                } catch (InterruptedException unused) {
                }
            }
            g1(u().g());
            return true;
        } else {
            d1(4113);
            return false;
        }
    }

    public final int C1(String str, int i10) {
        int i11 = 0;
        while (e()) {
            int O0 = O0(str);
            if (O0 == 0) {
                return 0;
            }
            if ((O0 & (-2049)) != 133) {
                e0(this.f5234s0);
            } else {
                il.b.l("connect fail with GATT_ERROR, do not need disconnect");
            }
            R(this.f5234s0);
            try {
                Thread.sleep(1600L);
            } catch (InterruptedException unused) {
            }
            i11++;
            il.b.c("tryConnectTime=" + i11);
            if (i11 > i10) {
                return O0;
            }
        }
        return DfuException.ERROR_DFU_ABORTED;
    }

    public final void D1(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, a aVar) {
        int i10;
        if (this.f36587a) {
            il.b.c(String.format(Locale.US, "updateImageWithCheckBufferForBee1, packetSize=%d, mCurrentMaxBufferSize=%d", Integer.valueOf(this.K), Integer.valueOf(this.R)));
        }
        this.C = 0;
        this.f36606t = false;
        int i11 = this.K;
        byte[] bArr = new byte[i11];
        byte[] bArr2 = new byte[this.R];
        while (!this.f36606t) {
            if (!this.f36594h) {
                if (this.I != 17) {
                    d(aVar);
                }
                if (this.f36587a) {
                    il.b.j(u().toString());
                }
                try {
                    int read = aVar.read(bArr2);
                    if (u().o() < read) {
                        read = u().o();
                        if (this.f36587a) {
                            il.b.c("Reach the bottom of the image,  checkImageBufferSize: " + read);
                        }
                    }
                    int i12 = read;
                    byte[] bArr3 = new byte[this.R];
                    int i13 = 0;
                    while (true) {
                        int i14 = 0;
                        while (i14 < i12) {
                            int min = Math.min(i11, i12 - i14);
                            System.arraycopy(bArr2, i14, bArr, 0, min);
                            if (v().N() && min >= 16) {
                                System.arraycopy(this.B.a(bArr, 0, 16), 0, bArr, 0, 16);
                            } else if (min <= 0) {
                                il.b.e("Error while reading file with bufferSize= " + min);
                                throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                            }
                            System.arraycopy(bArr, 0, bArr3, i14, min);
                            i14 += min;
                            Y(bluetoothGatt, bluetoothGattCharacteristic, bArr, min, false);
                            O();
                        }
                        if (this.f36588b) {
                            il.b.j("pos: " + i14 + ", checkImageBufferSize: " + i12);
                        }
                        boolean Y0 = Y0(ml.a.a(bArr2, 0, i12));
                        if (!Y0) {
                            u().b(0 - i12);
                            i10 = i13 + 1;
                            il.b.l("check failed, retransBufferCheckTimes: " + i10);
                        } else {
                            i10 = i13;
                        }
                        A0(Y0);
                        if (i10 >= 3) {
                            il.b.l("Error while buffer check, reach max try times: " + i10 + ", MAX_BUFFER_CHECK_RETRANS_TIME: 3");
                            throw new OtaException("Error while buffer check", DfuException.ERROR_BUFFER_CHECK_REACH_MAX_RETRY_TIMES);
                        } else if (Y0) {
                            break;
                        } else {
                            i13 = i10;
                        }
                    }
                } catch (IOException unused) {
                    throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                }
            } else {
                throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
            }
        }
    }

    public final void E1(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, a aVar) {
        int i10;
        l();
        this.C = 0;
        this.f36606t = false;
        int i11 = this.K;
        byte[] bArr = new byte[i11];
        while (!this.f36606t) {
            if (!this.f36594h) {
                if (this.I != 17) {
                    d(aVar);
                }
                if (this.f36587a) {
                    il.b.j(u().toString());
                }
                H();
                try {
                    if (this.I == 17) {
                        int f10 = u().f();
                        if (f10 == 0) {
                            int i12 = this.K;
                            byte[] bArr2 = new byte[i12];
                            aVar.i0(bArr2, i12 - 12);
                            System.arraycopy(aVar.E(), 0, bArr, 0, 12);
                            System.arraycopy(bArr2, 0, bArr, 12, this.K - 12);
                            i10 = this.K;
                        } else {
                            i10 = (f10 % 256 == 0 || (f10 % 256) % 240 != 0) ? aVar.j0(bArr) : aVar.i0(bArr, 16);
                        }
                    } else {
                        i10 = aVar.i0(bArr, i11);
                    }
                    if (u().o() < this.K) {
                        if (this.f36587a) {
                            il.b.j("reach the end of the file, only read some");
                        }
                        i10 = u().o();
                    }
                    int i13 = i10;
                    if (i13 > 0) {
                        if (v().N()) {
                            for (int i14 = i13; i14 > 0; i14 -= 16) {
                                if (i14 >= 16) {
                                    int i15 = i13 - i14;
                                    System.arraycopy(this.B.a(bArr, i15, 16), 0, bArr, i15, 16);
                                    if (v().r() == 0) {
                                        break;
                                    }
                                }
                            }
                        }
                        Y(bluetoothGatt, bluetoothGattCharacteristic, bArr, i13, false);
                        O();
                        k();
                    } else if (u().t()) {
                        il.b.g("image file has already been send over");
                        return;
                    } else {
                        il.b.e("Error while reading file with size: " + i13);
                        throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                    }
                } catch (IOException unused) {
                    throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                }
            } else {
                throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009d A[Catch: IOException -> 0x010f, TryCatch #0 {IOException -> 0x010f, blocks: (B:11:0x0031, B:13:0x003b, B:15:0x0045, B:16:0x005c, B:18:0x0060, B:20:0x0066, B:21:0x006b, B:22:0x0070, B:24:0x0074, B:25:0x008a, B:26:0x008d, B:27:0x0091, B:29:0x009d, B:32:0x00ad, B:34:0x00b7, B:35:0x00bd, B:36:0x00d6, B:37:0x00d7, B:42:0x00e6), top: B:51:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d7 A[Catch: IOException -> 0x010f, TryCatch #0 {IOException -> 0x010f, blocks: (B:11:0x0031, B:13:0x003b, B:15:0x0045, B:16:0x005c, B:18:0x0060, B:20:0x0066, B:21:0x006b, B:22:0x0070, B:24:0x0074, B:25:0x008a, B:26:0x008d, B:27:0x0091, B:29:0x009d, B:32:0x00ad, B:34:0x00b7, B:35:0x00bd, B:36:0x00d6, B:37:0x00d7, B:42:0x00e6), top: B:51:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ad A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void F1(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, a aVar) {
        int i10;
        int i11;
        il.b.k(this.f36587a, "uploadFirmwareImageForBeeUpdate");
        l();
        this.C = 0;
        this.f36606t = false;
        int i12 = this.K;
        byte[] bArr = new byte[i12];
        while (!this.f36606t) {
            if (!this.f36594h) {
                H();
                if (this.f36587a) {
                    il.b.j(u().toString());
                }
                try {
                    if (this.I == 17) {
                        int f10 = u().f();
                        if (f10 == 0) {
                            int i13 = this.K;
                            byte[] bArr2 = new byte[i13];
                            aVar.i0(bArr2, i13 - 12);
                            System.arraycopy(aVar.E(), 0, bArr, 0, 12);
                            System.arraycopy(bArr2, 0, bArr, 12, this.K - 12);
                            i10 = this.K;
                            if (u().o() < this.K) {
                                il.b.j("reach the end of the file, only read some");
                                i10 = u().o();
                            }
                            i11 = i10;
                            if (i11 <= 0) {
                                if (v().N()) {
                                    for (int i14 = i11; i14 > 0; i14 -= 16) {
                                        if (i14 >= 16) {
                                            int i15 = i11 - i14;
                                            System.arraycopy(this.B.a(bArr, i15, 16), 0, bArr, i15, 16);
                                            if (v().r() == 0) {
                                                break;
                                            }
                                        }
                                    }
                                }
                                Y(bluetoothGatt, bluetoothGattCharacteristic, bArr, i11, false);
                                O();
                                k();
                            } else if (u().t()) {
                                il.b.g("image file has already been send over");
                                return;
                            } else {
                                il.b.e("Error while reading file with size: " + i11);
                                throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                            }
                        } else {
                            i10 = (f10 % 256 == 0 || (f10 % 256) % 240 != 0) ? aVar.j0(bArr) : aVar.i0(bArr, 16);
                            if (u().o() < this.K) {
                            }
                            i11 = i10;
                            if (i11 <= 0) {
                            }
                        }
                    } else if (this.P == 0) {
                        int i16 = this.K;
                        byte[] bArr3 = new byte[i16];
                        aVar.i0(bArr3, i16 - 12);
                        System.arraycopy(aVar.E(), 0, bArr, 0, 12);
                        System.arraycopy(bArr3, 0, bArr, 12, this.K - 12);
                        i10 = this.K;
                        if (u().o() < this.K) {
                        }
                        i11 = i10;
                        if (i11 <= 0) {
                        }
                    } else {
                        i10 = aVar.i0(bArr, i12);
                        if (u().o() < this.K) {
                        }
                        i11 = i10;
                        if (i11 <= 0) {
                        }
                    }
                } catch (IOException unused) {
                    throw new OtaException("Error while reading file", DfuException.ERROR_FILE_IO_EXCEPTION);
                }
            } else {
                throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
            }
        }
    }

    public final void G1(String str) {
        if (!this.f36594h) {
            D(DfuException.ERROR_REMOTE_FLASH_ERASE_ERROR);
            int C1 = C1(str, t().B());
            if (C1 != 0) {
                if (C1 == 4128) {
                    throw new OtaException("aborted, connectRemoteDevice failed", C1);
                }
                throw new OtaException("connectOtaRemoteDevice failed", C1);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public final void H1(String str) {
        if (!this.f36594h) {
            D(516);
            int C1 = C1(str, t().B());
            if (C1 != 0) {
                if (C1 != 4128) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new CompatScanFilter.b().c(str).b());
                    ScannerParams k02 = k0();
                    k02.s(arrayList);
                    k02.r(str);
                    L(k02);
                    int C12 = C1(str, t().B());
                    if (C12 != 0) {
                        if (C12 == 4128) {
                            throw new OtaException("aborted, connectRemoteDevice failed", C12);
                        }
                        throw new OtaException("connectRemoteDevice failed", C12);
                    }
                    return;
                }
                throw new OtaException("aborted, connectRemoteDevice failed", C1);
            }
            return;
        }
        throw new OtaException("user aborted", DfuException.ERROR_DFU_ABORTED);
    }

    public final void I1(int i10) {
        String str;
        int i11 = this.P;
        if (i11 == 0) {
            this.P = 12;
            if (this.f36587a) {
                str = String.format(Locale.US, "First Packet, mImageUpdateOffset=0x%08X(%d)", 12, Integer.valueOf(this.P));
                il.b.j(str);
            }
        } else if (this.f36587a) {
            str = String.format(Locale.US, "mImageUpdateOffset=0x%08X(%d)", Integer.valueOf(i11), Integer.valueOf(this.P));
            il.b.j(str);
        }
        H0(i10, this.P);
        int f10 = u().f();
        int i12 = this.P;
        if (f10 != i12 && i12 != -1) {
            il.b.c("mBytesSent != mImageUpdateOffset, reload image bin file");
            Q();
            i(this.P, false);
        }
    }

    public final void J1(int i10) {
        int i11 = this.P;
        if (i11 == 0) {
            i11 = 12;
        }
        H0(i10, i11);
        if (u().f() != this.P) {
            il.b.c("mBytesSent != mImageUpdateOffset, reload image bin file");
            Q();
            i(this.P, false);
        }
        if (this.f36587a) {
            il.b.j(u().toString());
        }
    }

    public final void K1(int i10) {
        H0(i10, this.P);
        if (u().f() != this.P) {
            il.b.c("mBytesSent != mImageUpdateOffset, reload image bin file");
            Q();
            i(this.P, false);
        }
        if (u().f() != 0) {
            u().b(12);
        }
        u().c(12);
        if (this.f36587a) {
            il.b.c(u().toString());
        }
    }

    @Override // xl.a
    public boolean h(boolean z10) {
        if (!super.h(z10)) {
            return false;
        }
        if (this.f36599m != 515) {
            if (this.f36587a) {
                il.b.c("start to re-connect the RCU which going to active image, current state is: " + this.f36599m);
            }
            int C1 = C1(this.E, t().B());
            if (C1 != 0) {
                il.b.l("Something error in OTA process, errorCode: " + C1 + "mProcessState" + this.f36607u);
                v0(C1, true);
                return false;
            }
        }
        if (z10) {
            try {
                o1();
                D(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
            } catch (DfuException e10) {
                il.b.l(e10.toString());
                d1(e10.getErrCode());
            }
        } else {
            if (v1()) {
                I();
            }
            v0(DfuException.ERROR_USER_NOT_ACTIVE_IMAGE_ERROR, false);
        }
        return true;
    }

    @Override // xl.a
    public void q() {
        int y10;
        super.q();
        try {
            setName("ProcessorX0012N");
            il.b.c("ProcessorX0012N running.");
            y10 = y();
        } catch (Exception e10) {
            il.b.l(e10.toString());
            d1(0);
        }
        if (y10 != 0) {
            d1(y10);
            return;
        }
        z1();
        m(this.f36609w);
        if (this.f36587a) {
            il.b.c("GattDfuTaskX0000 stopped");
        }
        if (this.f36607u == 525) {
            D(DfuException.ERROR_LOCK_WAIT_INTERRUPTED);
        }
    }

    public final int w1() {
        if (this.A0 == null) {
            il.b.l("OTA SERVICE not found:" + this.f5243z0.toString());
            return DfuException.ERROR_NO_SERVICE_FOUND_OR_LOSS;
        } else if (this.B0 != null) {
            return 0;
        } else {
            il.b.l("not found OTA_CONTROL_ENTER_OTA_MODE_CHARACTERISTIC : " + g.f25671a.toString());
            return DfuException.ERROR_NO_CHARACTERISTIC_FOUND_OR_LOSS;
        }
    }

    public final boolean x1() {
        if (this.I == 0) {
            if (this.f36596j) {
                if (TextUtils.isEmpty(this.E)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(((v().f6004j == 5 || v().f6004j == 9 || v().f6004j == 4 || v().f6004j == 6 || v().f6004j == 7 || v().f6004j == 8 || v().f6004j == 13 || v().f6004j == 10 || v().f6004j == 11 || v().f6004j == 12) ? new CompatScanFilter.b().f(t().s(), v().u()) : new CompatScanFilter.b().f(t().s(), xl.a.n(this.F))).b());
                    ScannerParams k02 = k0();
                    k02.s(arrayList);
                    U(k02, 31000L);
                }
                G1(this.E);
                if (!this.f36595i) {
                    A1();
                } else {
                    P();
                }
                if (this.f36609w == null) {
                    d1(4097);
                    return false;
                }
            } else {
                H1(this.E);
                int w12 = w1();
                if (w12 == 0) {
                    if (!this.f36595i) {
                        A1();
                    } else {
                        P();
                    }
                    if (this.f36609w == null) {
                        d1(4097);
                        return false;
                    } else if (!y1()) {
                        d1(DfuException.ERROR_ENTER_OTA_MODE_FAILED);
                        return false;
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(((v().f6004j == 5 || v().f6004j == 9 || v().f6004j == 4 || v().f6004j == 6 || v().f6004j == 7 || v().f6004j == 8 || v().f6004j == 13 || v().f6004j == 10 || v().f6004j == 11 || v().f6004j == 12) ? new CompatScanFilter.b().f(t().s(), v().u()) : new CompatScanFilter.b().f(t().s(), xl.a.n(this.F))).b());
                        ScannerParams k03 = k0();
                        k03.s(arrayList2);
                        U(k03, 31000L);
                        G1(this.E);
                    }
                } else {
                    throw new OtaException("load ota service failed", w12);
                }
            }
            p0();
            this.f36596j = true;
            return true;
        }
        H1(this.E);
        p0();
        if (!this.f36595i) {
            A1();
        } else {
            P();
        }
        if (this.f36609w != null) {
            return true;
        }
        d1(4097);
        return false;
    }

    public final boolean y1() {
        boolean z10;
        if (this.B0 == null) {
            return false;
        }
        D(518);
        il.b.c("<< OPCODE_ENTER_OTA_MODE(0x01), enable device to enter OTA mode");
        try {
            z10 = a0(this.B0, g.f25677g, false);
        } catch (DfuException e10) {
            boolean z11 = e10.getErrCode() != 267;
            il.b.e("<< OPCODE_ENTER_OTA_MODE(0x01) failed, ignore it :" + e10.getMessage());
            this.C = 0;
            z10 = z11;
        }
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException unused) {
        }
        if (t().U()) {
            I();
        }
        R(this.f5234s0);
        return z10;
    }

    public final boolean z1() {
        a aVar;
        D(514);
        this.E = this.F;
        this.f36596j = this.I != 0;
        boolean z10 = false;
        while (e()) {
            try {
            } catch (DfuException e10) {
                il.b.l(kl.a.b(this.f36607u) + ", " + e10.toString());
                int errorNumber = e10.getErrorNumber();
                if (errorNumber == 4128) {
                    v0(errorNumber, true);
                } else {
                    if (!(errorNumber == 4097 || errorNumber == 265)) {
                        v1();
                        if (this.I == 0) {
                            I();
                        }
                    }
                    v0(errorNumber, false);
                }
            }
            if (!x1() || !B1()) {
                return false;
            }
            this.f36612z += u().f();
            if (u().u()) {
                il.b.c("no pendding image file to upload.");
                u().x(this.f36612z);
                if (!this.J) {
                    D(523);
                } else {
                    o1();
                    D(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED);
                }
                z10 = true;
            } else {
                il.b.j("has pendding image file to upload");
                if (v().K() == 1) {
                    this.E = this.F;
                    int i10 = this.I;
                    this.f36596j = i10 != 0;
                    this.f36612z = 0;
                    if (i10 == 18) {
                        this.f36595i = false;
                    }
                    o1();
                } else if (v().K() == 3 && (aVar = this.f36610x) != null && D0(aVar, this.f36612z, v().C * 4096)) {
                    il.b.c("make device to enter the ota advertiser mode, and let the app continue update image");
                    int i11 = this.I;
                    if (i11 == 0) {
                        this.E = null;
                    }
                    this.f36596j = true;
                    this.f36612z = 0;
                    if (i11 == 18) {
                        this.f36595i = false;
                    }
                    t0((byte) 1);
                }
                w();
            }
            try {
                Thread.sleep(1000L);
                continue;
            } catch (InterruptedException unused) {
            }
            if (z10) {
                return z10;
            }
        }
        v0(DfuException.ERROR_DFU_ABORTED, true);
        return false;
    }
}
