package com.yc.pedometer.sdk;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.recyclerview.widget.g;
import cn.a0;
import cn.t;
import cn.v;
import com.alipay.sdk.app.PayTask;
import com.bjleisen.iface.sdk.apdu.LeisenIfaceConfig;
import com.huawei.hms.ml.camera.CameraConfig;
import com.yc.pedometer.dial.OnlineDialUtil;
import dn.k;
import dn.l;
import dn.m;
import en.o;
import en.q;
import en.r;
import gn.b0;
import gn.c0;
import gn.n;
import gn.p;
import gn.u;
import gn.w;
import gn.x;
import gn.z;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
/* loaded from: classes2.dex */
public class BluetoothLeService extends Service {

    /* renamed from: l1  reason: collision with root package name */
    private static BluetoothAdapter f24599l1;

    /* renamed from: m1  reason: collision with root package name */
    public static BluetoothGatt f24600m1;
    private m A0;
    private dn.d B;
    private dn.b B0;
    private Object D0;
    private Object F0;
    private int H;
    private z H0;
    private int I;
    private bn.i I0;
    private int J;
    private String K;
    private String L;
    private String M;
    private int N;
    private int N0;
    private int O;
    private int P;
    private int P0;
    private int Q;
    private float R;
    private int R0;
    private int S;
    private int T;
    private dn.e T0;
    private int U;
    private byte[] U0;
    private int V;
    private int W;
    private int W0;
    private int Y0;
    private int Z0;

    /* renamed from: a  reason: collision with root package name */
    private BluetoothManager f24601a;

    /* renamed from: b  reason: collision with root package name */
    private Context f24603b;

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f24605c;

    /* renamed from: d  reason: collision with root package name */
    private SharedPreferences.Editor f24607d;

    /* renamed from: e  reason: collision with root package name */
    private Handler f24609e;

    /* renamed from: g  reason: collision with root package name */
    private q f24613g;

    /* renamed from: h  reason: collision with root package name */
    private en.c f24615h;

    /* renamed from: i  reason: collision with root package name */
    private r f24617i;

    /* renamed from: j  reason: collision with root package name */
    private en.e f24619j;

    /* renamed from: j1  reason: collision with root package name */
    private dn.g f24621j1;

    /* renamed from: k0  reason: collision with root package name */
    private int f24623k0;

    /* renamed from: m0  reason: collision with root package name */
    private int f24628m0;

    /* renamed from: n  reason: collision with root package name */
    private byte[] f24629n;

    /* renamed from: n0  reason: collision with root package name */
    private int f24630n0;

    /* renamed from: o  reason: collision with root package name */
    private int f24631o;

    /* renamed from: o0  reason: collision with root package name */
    private int f24632o0;

    /* renamed from: q  reason: collision with root package name */
    private cn.c f24635q;

    /* renamed from: q0  reason: collision with root package name */
    private byte f24636q0;

    /* renamed from: r  reason: collision with root package name */
    private dn.a f24637r;

    /* renamed from: s  reason: collision with root package name */
    private int f24639s;

    /* renamed from: v  reason: collision with root package name */
    private dn.j f24645v;

    /* renamed from: w  reason: collision with root package name */
    private dn.h f24647w;

    /* renamed from: x  reason: collision with root package name */
    private l f24649x;

    /* renamed from: y  reason: collision with root package name */
    private dn.i f24651y;

    /* renamed from: z  reason: collision with root package name */
    private dn.c f24653z;

    /* renamed from: z0  reason: collision with root package name */
    private k f24654z0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f24611f = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f24622k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f24625l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f24627m = false;

    /* renamed from: p  reason: collision with root package name */
    private List<cn.c> f24633p = new ArrayList();

    /* renamed from: t  reason: collision with root package name */
    private StringBuilder f24641t = new StringBuilder();

    /* renamed from: u  reason: collision with root package name */
    private cn.i f24643u = null;
    private boolean A = true;
    private final IBinder C = new a();
    private final BluetoothGattCallback D = new b();
    private StringBuilder E = new StringBuilder();
    private byte F = 0;
    private boolean G = false;

    /* renamed from: j0  reason: collision with root package name */
    private String[] f24620j0 = new String[100];

    /* renamed from: l0  reason: collision with root package name */
    private List<Integer> f24626l0 = new ArrayList();

    /* renamed from: p0  reason: collision with root package name */
    private StringBuilder f24634p0 = new StringBuilder();

    /* renamed from: r0  reason: collision with root package name */
    private Handler f24638r0 = new d();

    /* renamed from: s0  reason: collision with root package name */
    private Runnable f24640s0 = new e();

    /* renamed from: t0  reason: collision with root package name */
    private int f24642t0 = -1;

    /* renamed from: u0  reason: collision with root package name */
    byte[] f24644u0 = null;

    /* renamed from: v0  reason: collision with root package name */
    private int f24646v0 = -1;

    /* renamed from: w0  reason: collision with root package name */
    private int f24648w0 = 1;

    /* renamed from: x0  reason: collision with root package name */
    private Runnable f24650x0 = new f();

    /* renamed from: y0  reason: collision with root package name */
    List<cn.a> f24652y0 = new ArrayList();
    ArrayList<Integer> C0 = new ArrayList<>();
    private boolean E0 = false;
    private boolean G0 = false;
    private boolean J0 = true;
    String K0 = "";
    private List<en.m> L0 = new ArrayList();
    private en.m M0 = new en.m();
    private List<a0> O0 = new ArrayList();
    private List<cn.k> Q0 = new ArrayList();
    private List<cn.d> S0 = new ArrayList();
    private boolean V0 = false;
    private int X0 = 0;

    /* renamed from: a1  reason: collision with root package name */
    private String f24602a1 = "";

    /* renamed from: b1  reason: collision with root package name */
    private List<cn.e> f24604b1 = new ArrayList();

    /* renamed from: c1  reason: collision with root package name */
    private long f24606c1 = 0;

    /* renamed from: d1  reason: collision with root package name */
    private boolean f24608d1 = false;

    /* renamed from: e1  reason: collision with root package name */
    private int f24610e1 = 0;

    /* renamed from: f1  reason: collision with root package name */
    private dn.f f24612f1 = new j();

    /* renamed from: g1  reason: collision with root package name */
    private int f24614g1 = 0;

    /* renamed from: h1  reason: collision with root package name */
    private int f24616h1 = 0;

    /* renamed from: i1  reason: collision with root package name */
    private int f24618i1 = 0;

    /* renamed from: k1  reason: collision with root package name */
    private List<v> f24624k1 = new ArrayList();

    /* loaded from: classes2.dex */
    public class a extends Binder {
        public a() {
        }

        public BluetoothLeService a() {
            return BluetoothLeService.this;
        }
    }

    /* loaded from: classes2.dex */
    class b extends BluetoothGattCallback {
        b() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            if (bluetoothGatt.equals(BluetoothLeService.f24600m1)) {
                if (bluetoothGattCharacteristic.getUuid().equals(c0.f27537m) && gn.q.f27585d && BluetoothLeService.this.f24617i != null) {
                    BluetoothLeService.this.f24617i.a(bluetoothGattCharacteristic);
                }
                byte[] value = bluetoothGattCharacteristic.getValue();
                StringBuilder sb2 = null;
                if (value != null && value.length > 0) {
                    sb2 = new StringBuilder(value.length);
                    int length = value.length;
                    for (int i10 = 0; i10 < length; i10++) {
                        sb2.append(String.format("%02X", Byte.valueOf(value[i10])));
                    }
                }
                if (bluetoothGattCharacteristic.getUuid().equals(UUID.fromString(c0.f27526b))) {
                    u.d("sendTextKey", "ble--->apk4 = " + ((Object) sb2));
                    BluetoothLeService.this.u(sb2, value);
                } else if (bluetoothGattCharacteristic.getUuid().equals(UUID.fromString(c0.f27528d)) && !TextUtils.isEmpty(sb2)) {
                    u.d("sendTextKey", "ble--->apk5 = " + ((Object) sb2));
                    BluetoothLeService.this.H(sb2, value);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            String str;
            StringBuilder sb2;
            byte[] bArr;
            String str2;
            u.d("BluetoothLeService", "----------->onCharacteristicRead status = " + i10 + ",isDeviceBusy =" + BluetoothLeService.this.k0());
            if (bluetoothGatt.equals(BluetoothLeService.f24600m1)) {
                byte[] value = bluetoothGattCharacteristic.getValue();
                StringBuilder sb3 = null;
                if (value != null && value.length > 0) {
                    sb3 = new StringBuilder(value.length);
                    int length = value.length;
                    for (int i11 = 0; i11 < length; i11++) {
                        sb3.append(String.format("%02X", Byte.valueOf(value[i11])));
                    }
                    u.f("ellison1", "------------->onCharacteristicRead : " + sb3.toString());
                }
                if (i10 == 0) {
                    if (gn.q.f27585d && BluetoothLeService.this.f24617i != null) {
                        BluetoothLeService.this.f24617i.c(bluetoothGattCharacteristic);
                    }
                    if (bluetoothGattCharacteristic.getUuid().equals(c0.f27542r)) {
                        byte[] value2 = bluetoothGattCharacteristic.getValue();
                        if (value2.length == 4) {
                            str2 = BluetoothLeService.this.N(value2);
                        } else {
                            ByteBuffer wrap = ByteBuffer.wrap(value2);
                            wrap.order(ByteOrder.LITTLE_ENDIAN);
                            str2 = String.valueOf((int) wrap.getShort(0));
                        }
                        z.v(BluetoothLeService.this.f24603b).z0(str2);
                        u.d("BluetoothLeService", "gsj--old patch version: " + str2);
                        BluetoothLeService.this.w(false);
                    }
                    if (bluetoothGattCharacteristic.getUuid().equals(UUID.fromString(c0.f27525a))) {
                        u.d("BluetoothLeService", "读取支持的功能 stringBuilder =" + ((Object) sb3));
                        if (sb3 != null) {
                            int length2 = sb3.toString().length();
                            if (length2 == 40) {
                                int i12 = length2 - 6;
                                String substring = sb3.toString().substring(i12, length2);
                                int i13 = length2 - 12;
                                String substring2 = sb3.toString().substring(i13, i12);
                                int i14 = length2 - 18;
                                String substring3 = sb3.toString().substring(i14, i13);
                                int i15 = length2 - 24;
                                String substring4 = sb3.toString().substring(i15, i14);
                                int i16 = length2 - 30;
                                String substring5 = sb3.toString().substring(i16, i15);
                                String substring6 = sb3.toString().substring(length2 - 36, i16);
                                String substring7 = sb3.toString().substring(0, 4);
                                int e10 = n.d(BluetoothLeService.this.f24603b).e(substring);
                                int e11 = n.d(BluetoothLeService.this.f24603b).e(substring2);
                                int e12 = n.d(BluetoothLeService.this.f24603b).e(substring3);
                                int e13 = n.d(BluetoothLeService.this.f24603b).e(substring4);
                                int e14 = n.d(BluetoothLeService.this.f24603b).e(substring5);
                                bArr = value;
                                int e15 = n.d(BluetoothLeService.this.f24603b).e(substring6);
                                sb2 = sb3;
                                int e16 = n.d(BluetoothLeService.this.f24603b).e(substring7);
                                u.d("BluetoothLeService", "读取支持的功能 特征值返回,functionList1=" + e10 + ",functionList2 =" + e11 + ",functionList3 =" + e12 + ",functionList4 =" + e13 + ",functionList5 =" + e14 + ",functionList6 =" + e15 + ",sb1 =" + substring + ",sb2 =" + substring2 + ",sb3 =" + substring3 + ",sb4 =" + substring4 + ",sb5 =" + substring5 + ",sb6 =" + substring6);
                                z.v(BluetoothLeService.this.f24603b).c0(e10);
                                z.v(BluetoothLeService.this.f24603b).d0(e11);
                                z.v(BluetoothLeService.this.f24603b).e0(e12);
                                z.v(BluetoothLeService.this.f24603b).f0(e13);
                                z.v(BluetoothLeService.this.f24603b).g0(e14);
                                z.v(BluetoothLeService.this.f24603b).h0(e15);
                                z.v(BluetoothLeService.this.f24603b).i0(e16);
                                BluetoothLeService bluetoothLeService = BluetoothLeService.this;
                                bluetoothLeService.f24627m = p.c(bluetoothLeService.f24603b, 1024);
                                BluetoothLeService bluetoothLeService2 = BluetoothLeService.this;
                                bluetoothLeService2.f24625l = p.c(bluetoothLeService2.f24603b, 256);
                            } else {
                                bArr = value;
                                sb2 = sb3;
                            }
                            BluetoothLeService.this.w(false);
                        } else {
                            bArr = value;
                            sb2 = sb3;
                        }
                        if (BluetoothLeService.this.f24619j != null) {
                            BluetoothLeService.this.f24619j.j(true, 137);
                        }
                    } else {
                        bArr = value;
                        sb2 = sb3;
                    }
                    if (bluetoothGattCharacteristic.getUuid().equals(UUID.fromString(c0.f27527c))) {
                        u.d("BluetoothLeService", " 特征值返回555,stringBuilder =" + ((Object) sb2));
                        if (bArr != null) {
                            byte[] bArr2 = bArr;
                            if (bArr2.length > 1) {
                                int i17 = ((bArr2[0] << 8) & 65280) | (bArr2[1] & 255);
                                z.v(BluetoothLeService.this.f24603b).x0(i17);
                                str = " 特征值返回555,maxcommunicationLength =" + i17;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (bluetoothGattCharacteristic.getUuid().equals(c0.f27542r)) {
                    str = "read patch version 2 ";
                } else {
                    BluetoothLeService.this.G0();
                    BluetoothGatt bluetoothGatt2 = BluetoothLeService.f24600m1;
                    if (bluetoothGatt2 != null) {
                        bluetoothGatt2.disconnect();
                    }
                    BluetoothLeService.this.H0.b0(false);
                    BluetoothLeService.this.X0();
                    bluetoothGatt.close();
                    if (BluetoothLeService.this.f24619j != null) {
                        BluetoothLeService.this.f24619j.j(true, 19);
                    }
                    BluetoothLeService.this.sendBroadcast(new Intent("bluetooth.le.ACTION_GATT_FAILURE_daydaybandsdk"));
                    return;
                }
                u.d("BluetoothLeService", str);
                BluetoothLeService.this.w(false);
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i10) {
            int i11;
            en.e eVar;
            String str;
            q qVar;
            String str2;
            u.f("sendTextKey", "------------->onCharacteristicWrite status: " + i10 + ",isDeviceBusy =" + BluetoothLeService.this.k0());
            if (bluetoothGatt.equals(BluetoothLeService.f24600m1)) {
                if (gn.q.f27585d && BluetoothLeService.this.f24617i != null) {
                    BluetoothLeService.this.f24617i.d(i10);
                }
                if (BluetoothLeService.this.f24619j != null) {
                    BluetoothLeService.this.f24619j.d(i10);
                }
                byte[] value = bluetoothGattCharacteristic.getValue();
                if (value != null && value.length > 0) {
                    StringBuilder sb2 = new StringBuilder(value.length);
                    int length = value.length;
                    for (int i12 = 0; i12 < length; i12++) {
                        sb2.append(String.format("%02X", Byte.valueOf(value[i12])));
                    }
                    BluetoothLeService.this.t(sb2.toString(), value);
                }
                if (BluetoothLeService.this.f24622k) {
                    int i13 = BluetoothLeService.this.f24642t0;
                    if (i13 != 0) {
                        if (i13 != 1) {
                            if (i13 != 2) {
                                if (i13 != 3) {
                                    if (i13 != 8) {
                                        if (i13 != 9) {
                                            switch (i13) {
                                                case 13:
                                                    BluetoothLeService.this.f24613g.f26219s++;
                                                    u.a("sendTextKey", "mWriteChara.NOsection=" + BluetoothLeService.this.f24613g.f26219s);
                                                    BluetoothLeService.this.f24613g.g0(BluetoothLeService.this.f24613g.f26219s);
                                                    break;
                                                case 15:
                                                    BluetoothLeService.this.f24613g.f26219s = 0;
                                                    BluetoothLeService.this.f24613g.f26221u = false;
                                                    BluetoothLeService.this.f24613g.g0(BluetoothLeService.this.f24613g.f26219s);
                                                    break;
                                                case 16:
                                                    if (BluetoothLeService.this.f24619j != null) {
                                                        eVar = BluetoothLeService.this.f24619j;
                                                        i11 = 10;
                                                        eVar.j(true, i11);
                                                        break;
                                                    }
                                                    break;
                                                case 17:
                                                    if (BluetoothLeService.this.f24619j != null) {
                                                        eVar = BluetoothLeService.this.f24619j;
                                                        i11 = 26;
                                                        eVar.j(true, i11);
                                                        break;
                                                    }
                                                    break;
                                                case 18:
                                                    if (BluetoothLeService.this.f24619j != null) {
                                                        eVar = BluetoothLeService.this.f24619j;
                                                        i11 = 27;
                                                        eVar.j(true, i11);
                                                        break;
                                                    }
                                                    break;
                                                case 19:
                                                    if (BluetoothLeService.this.f24619j != null) {
                                                        eVar = BluetoothLeService.this.f24619j;
                                                        i11 = 29;
                                                        eVar.j(true, i11);
                                                        break;
                                                    }
                                                    break;
                                                case 20:
                                                    if (BluetoothLeService.this.f24619j != null) {
                                                        eVar = BluetoothLeService.this.f24619j;
                                                        i11 = 30;
                                                        eVar.j(true, i11);
                                                        break;
                                                    }
                                                    break;
                                                case 21:
                                                    if (BluetoothLeService.this.f24619j != null) {
                                                        eVar = BluetoothLeService.this.f24619j;
                                                        i11 = 31;
                                                        eVar.j(true, i11);
                                                        break;
                                                    }
                                                    break;
                                                case 22:
                                                    BluetoothLeService.this.f24642t0 = -1;
                                                    u.d("onBtImgUpdate", "发送B2FA这里--BleAndPatchAllHasNews=" + gn.q.f27590i + ",updateCount=" + gn.q.f27593l);
                                                    if (!gn.q.f27590i) {
                                                        if (BluetoothLeService.this.f24619j != null) {
                                                            BluetoothLeService.this.f24619j.j(true, 6);
                                                            break;
                                                        }
                                                    } else {
                                                        int i14 = gn.q.f27593l;
                                                        if (i14 == 1) {
                                                            BluetoothLeService.this.sendBroadcast(new Intent(gn.q.f27594m));
                                                            str = "发送广播，准备开始第二次升级";
                                                        } else if (i14 == 2) {
                                                            str = "第二次升级成功，开始同步所有数据";
                                                        }
                                                        u.d("onBtImgUpdate", str);
                                                        break;
                                                    }
                                                    break;
                                                case 23:
                                                    if (BluetoothLeService.this.f24619j != null) {
                                                        eVar = BluetoothLeService.this.f24619j;
                                                        i11 = 25;
                                                        eVar.j(true, i11);
                                                        break;
                                                    }
                                                    break;
                                                case 24:
                                                    if (BluetoothLeService.this.f24619j != null) {
                                                        eVar = BluetoothLeService.this.f24619j;
                                                        i11 = 35;
                                                        eVar.j(true, i11);
                                                        break;
                                                    }
                                                    break;
                                                case 25:
                                                    if (BluetoothLeService.this.f24619j != null) {
                                                        eVar = BluetoothLeService.this.f24619j;
                                                        i11 = 38;
                                                        eVar.j(true, i11);
                                                        break;
                                                    }
                                                    break;
                                                case 26:
                                                    BluetoothLeService.this.f24613g.P0(BluetoothLeService.this.f24613g.f26223w);
                                                    break;
                                                case 27:
                                                    BluetoothLeService.this.f24613g.S0(BluetoothLeService.this.f24613g.f26224x);
                                                    break;
                                                case 28:
                                                    BluetoothLeService.this.f24613g.q0(BluetoothLeService.this.f24613g.f26224x);
                                                    break;
                                                case 29:
                                                    BluetoothLeService.this.f24613g.o0(BluetoothLeService.this.f24636q0);
                                                    BluetoothLeService.this.f24636q0 = (byte) 0;
                                                    break;
                                                case 30:
                                                    BluetoothLeService.this.f24613g.E++;
                                                    BluetoothLeService.this.f24613g.Y(BluetoothLeService.this.f24613g.E);
                                                    break;
                                                case 31:
                                                    BluetoothLeService bluetoothLeService = BluetoothLeService.this;
                                                    bluetoothLeService.g(true, bluetoothLeService.f24648w0);
                                                    break;
                                                case 32:
                                                    BluetoothLeService bluetoothLeService2 = BluetoothLeService.this;
                                                    bluetoothLeService2.g(false, bluetoothLeService2.f24648w0);
                                                    break;
                                                case 33:
                                                    if (BluetoothLeService.this.f24619j != null) {
                                                        BluetoothLeService.this.f24619j.l(true, 85, BluetoothLeService.this.f24644u0);
                                                        break;
                                                    }
                                                    break;
                                                case 34:
                                                    if (BluetoothLeService.this.f24619j != null) {
                                                        BluetoothLeService.this.f24619j.l(true, 84, BluetoothLeService.this.f24644u0);
                                                        break;
                                                    }
                                                    break;
                                                case 35:
                                                    String I = z.v(BluetoothLeService.this.f24603b).I();
                                                    String b10 = gn.i.b(BluetoothLeService.this.f24603b, I);
                                                    if (b10 == null) {
                                                        qVar = BluetoothLeService.this.f24613g;
                                                        str2 = "" + I;
                                                    } else {
                                                        str2 = b10 + "";
                                                        qVar = BluetoothLeService.this.f24613g;
                                                    }
                                                    qVar.j0(str2, 3);
                                                    break;
                                                case 36:
                                                    BluetoothLeService.this.f24613g.f26219s++;
                                                    BluetoothLeService.this.f24613g.h0(BluetoothLeService.this.f24613g.f26219s);
                                                    break;
                                                case 37:
                                                    BluetoothLeService.this.f24613g.T0(BluetoothLeService.this.f24613g.f26224x);
                                                    break;
                                                case 38:
                                                    BluetoothLeService.this.f24613g.r0(BluetoothLeService.this.f24613g.f26224x);
                                                    break;
                                                case 39:
                                                    BluetoothLeService.this.f24613g.p0(BluetoothLeService.this.f24636q0);
                                                    BluetoothLeService.this.f24636q0 = (byte) 0;
                                                    break;
                                                case 40:
                                                    BluetoothLeService.this.f24613g.K++;
                                                    u.a("sendTextKey", "mWriteChara.NOsectionSports=" + BluetoothLeService.this.f24613g.K);
                                                    BluetoothLeService.this.f24613g.t(BluetoothLeService.this.f24613g.K);
                                                    break;
                                            }
                                        } else if (BluetoothLeService.this.f24619j != null) {
                                            eVar = BluetoothLeService.this.f24619j;
                                            i11 = 36;
                                            eVar.j(true, i11);
                                        }
                                    } else if (BluetoothLeService.this.f24619j != null) {
                                        eVar = BluetoothLeService.this.f24619j;
                                        i11 = 37;
                                        eVar.j(true, i11);
                                    }
                                } else if (BluetoothLeService.this.f24619j != null) {
                                    BluetoothLeService.this.f24619j.j(true, 9);
                                }
                            } else if (BluetoothLeService.this.f24619j != null) {
                                BluetoothLeService.this.f24619j.j(true, 8);
                            }
                        } else if (BluetoothLeService.this.f24619j != null) {
                            eVar = BluetoothLeService.this.f24619j;
                            i11 = 7;
                            eVar.j(true, i11);
                        }
                    } else if (BluetoothLeService.this.f24619j != null) {
                        BluetoothLeService.this.f24619j.j(true, 6);
                    }
                    BluetoothLeService.this.f24642t0 = -1;
                }
                super.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, i10);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i10, int i11) {
            Intent intent;
            BluetoothLeService bluetoothLeService;
            BluetoothLeService.this.T();
            u.d("BluetoothLeService", "----------->onConnectionStateChange status: " + i10 + ",newState=" + i11);
            u.d("BluetoothLeService", "------------->onConnectionStateChange mBluetoothGatt =" + BluetoothLeService.f24600m1 + ",gatt =" + bluetoothGatt);
            if (bluetoothGatt.equals(BluetoothLeService.f24600m1)) {
                BluetoothLeService.this.I0.c();
                BluetoothLeService.this.G0();
                u.d("BluetoothLeService", "----------->onConnectionStateChange gatt 一致 ");
                if (i10 != 0) {
                    BluetoothLeService.this.H0.b0(false);
                    BluetoothLeService.this.X0();
                    bluetoothGatt.close();
                    if (BluetoothLeService.this.f24619j != null) {
                        BluetoothLeService.this.f24619j.j(true, 19);
                    }
                    bluetoothLeService = BluetoothLeService.this;
                    intent = new Intent("bluetooth.le.ACTION_GATT_FAILURE_daydaybandsdk");
                } else if (i11 == 2) {
                    BluetoothLeService.this.f24611f = false;
                    u.d("BluetoothLeService", "准备执行 myDiscoverServices");
                    Message message = new Message();
                    message.what = 11;
                    message.arg1 = 1;
                    BluetoothLeService.this.f24638r0.sendMessageDelayed(message, 1600L);
                    return;
                } else if (i11 == 0) {
                    u.d("BluetoothLeService", "----------->mBluetoothGatt=" + BluetoothLeService.f24600m1);
                    BluetoothLeService.this.X0();
                    bluetoothGatt.close();
                    BluetoothLeService.this.H0.b0(false);
                    if (BluetoothLeService.this.f24619j != null) {
                        BluetoothLeService.this.f24619j.j(true, 19);
                    }
                    bluetoothLeService = BluetoothLeService.this;
                    intent = new Intent("bluetooth.le.ACTION_GATT_FAILURE_daydaybandsdk");
                } else {
                    return;
                }
                bluetoothLeService.sendBroadcast(intent);
                BluetoothLeService.this.f24613g.x0();
            } else {
                u.d("BluetoothLeService", "----------->onConnectionStateChange gatt 不一致 ");
                BluetoothLeService.this.H0.b0(false);
                bluetoothGatt.close();
                BluetoothLeService.this.X0();
                String w10 = z.v(BluetoothLeService.this.f24603b).w();
                if (w10.equals("00:00:00:00:00:00") || !BluetoothLeService.this.A) {
                    BluetoothLeService.this.sendBroadcast(new Intent("bluetooth.le.ACTION_GATT_FAILURE_daydaybandsdk"));
                    if (BluetoothLeService.this.f24619j != null) {
                        BluetoothLeService.this.f24619j.j(true, 19);
                    }
                } else {
                    BluetoothLeService.this.V(w10);
                }
            }
            BluetoothLeService.this.f24638r0.removeMessages(12);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorRead(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            if (bluetoothGatt.equals(BluetoothLeService.f24600m1)) {
                byte[] value = bluetoothGattDescriptor.getValue();
                if (value != null && value.length > 0) {
                    new StringBuilder(value.length);
                    int length = value.length;
                    for (int i11 = 0; i11 < length; i11++) {
                        String.format("%02X ", Byte.valueOf(value[i11]));
                    }
                }
                super.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, i10);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onDescriptorWrite(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int i10) {
            super.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, i10);
            u.d("BluetoothLeService", "----------->onDescriptorWrite status = " + i10 + ",isDeviceBusy =" + BluetoothLeService.this.k0());
            if (i10 != 0) {
                BluetoothLeService.this.G0();
                BluetoothGatt bluetoothGatt2 = BluetoothLeService.f24600m1;
                if (bluetoothGatt2 != null) {
                    bluetoothGatt2.disconnect();
                }
                BluetoothLeService.this.H0.b0(false);
                bluetoothGatt.close();
                BluetoothLeService.this.X0();
                u.c("设置通知返回失败  gatt.close  gatt=" + ((Object) null));
                if (BluetoothLeService.this.f24619j != null) {
                    BluetoothLeService.this.f24619j.j(true, 19);
                }
                BluetoothLeService.this.sendBroadcast(new Intent("bluetooth.le.ACTION_GATT_FAILURE_daydaybandsdk"));
            } else if (BluetoothLeService.this.f24608d1) {
                BluetoothLeService.this.w(false);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReadRemoteRssi(BluetoothGatt bluetoothGatt, int i10, int i11) {
            if (bluetoothGatt.equals(BluetoothLeService.f24600m1)) {
                if (gn.q.f27585d && BluetoothLeService.this.f24617i != null) {
                    BluetoothLeService.this.f24617i.b(i10);
                }
                if (BluetoothLeService.this.f24609e != null) {
                    Bundle bundle = new Bundle();
                    Message obtain = Message.obtain(BluetoothLeService.this.f24609e, 10);
                    bundle.putInt("RSSI", i10);
                    bundle.putInt("RSSI_STATUS", i11);
                    obtain.setData(bundle);
                    obtain.sendToTarget();
                }
                super.onReadRemoteRssi(bluetoothGatt, i10, i11);
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onReliableWriteCompleted(BluetoothGatt bluetoothGatt, int i10) {
            super.onReliableWriteCompleted(bluetoothGatt, i10);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i10) {
            String str;
            u.d("BluetoothLeService", "------------->onServicesDiscovered status: " + i10);
            u.d("BluetoothLeService", "------------->onServicesDiscovered mBluetoothGatt =" + BluetoothLeService.f24600m1 + ",gatt =" + bluetoothGatt);
            if (bluetoothGatt.equals(BluetoothLeService.f24600m1)) {
                u.d("BluetoothLeService", "------------->onServicesDiscovered gatt一致");
                z.v(BluetoothLeService.this.f24603b).H0(false);
                BluetoothLeService.this.f24625l = false;
                BluetoothLeService.this.f24627m = false;
                gn.q.f27597p = false;
                if (i10 == 0) {
                    BluetoothLeService.this.f24611f = true;
                    BluetoothLeService.this.f24638r0.removeMessages(12);
                    BluetoothLeService.f24600m1 = bluetoothGatt;
                    u.f("BluetoothLeService", "onServicesDiscovered mBluetoothGatt =" + BluetoothLeService.f24600m1);
                    BluetoothLeService.this.f24613g.H(BluetoothLeService.f24600m1);
                    String w10 = z.v(BluetoothLeService.this.f24603b).w();
                    String address = bluetoothGatt.getDevice().getAddress();
                    if (!w10.equals(address)) {
                        gn.q.f27584c = "";
                        z.v(BluetoothLeService.this.f24603b).w0(address);
                        BluetoothLeService.this.f24607d.putLong("last_access_server_time", 0L);
                        BluetoothLeService.this.f24607d.putString("b2fd_calendar_sp", "20100101");
                        BluetoothLeService.this.f24607d.putString("last_rate_calendar_sp", "20100101");
                        z.v(BluetoothLeService.this.f24603b).F0(0);
                        z.v(BluetoothLeService.this.f24603b).G0(0);
                        o.b(BluetoothLeService.this.f24603b).d();
                        z.v(BluetoothLeService.this.f24603b).J();
                        z.v(BluetoothLeService.this.f24603b).a();
                    }
                    List<BluetoothGattService> x02 = BluetoothLeService.this.x0();
                    BluetoothLeService.this.f24622k = false;
                    gn.q.f27595n = false;
                    u.d("BluetoothLeService", "发现服务  bluetoothGattServices =" + x02);
                    if (x02 != null) {
                        int size = x02.size();
                        u.d("BluetoothLeService", "发现服务  bluetoothGattServices.size() =" + size);
                        if (size < 1) {
                            BluetoothGatt bluetoothGatt2 = BluetoothLeService.f24600m1;
                            if (bluetoothGatt2 != null) {
                                bluetoothGatt2.disconnect();
                            }
                            BluetoothLeService.this.X0();
                            BluetoothLeService.this.H0.b0(false);
                            bluetoothGatt.close();
                            if (BluetoothLeService.this.f24619j != null) {
                                BluetoothLeService.this.f24619j.j(true, 19);
                            }
                            BluetoothLeService.this.sendBroadcast(new Intent("bluetooth.le.ACTION_GATT_FAILURE_daydaybandsdk"));
                            str = "发现服务失败  bluetoothGattServices.size()=" + size;
                        } else {
                            for (int i11 = 0; i11 < x02.size(); i11++) {
                                String uuid = x02.get(i11).getUuid().toString();
                                if (uuid.equals(c0.f27541q.toString())) {
                                    BluetoothLeService.this.f24622k = true;
                                    gn.q.f27595n = true;
                                    z.v(BluetoothLeService.this.f24603b).H0(true);
                                }
                                if (uuid.equals(c0.f27538n.toString())) {
                                    u.d("BluetoothLeService", "静默升级服务");
                                    gn.q.f27597p = true;
                                }
                            }
                            u.d("stringBuilder", "isRKPlatform =" + BluetoothLeService.this.f24622k);
                            w.g("发现服务 ：" + (System.currentTimeMillis() - BluetoothLeService.this.f24606c1));
                            BluetoothLeService.this.f24638r0.sendEmptyMessage(7);
                            return;
                        }
                    } else {
                        BluetoothGatt bluetoothGatt3 = BluetoothLeService.f24600m1;
                        if (bluetoothGatt3 != null) {
                            bluetoothGatt3.disconnect();
                        }
                        BluetoothLeService.this.X0();
                        BluetoothLeService.this.H0.b0(false);
                        bluetoothGatt.close();
                        if (BluetoothLeService.this.f24619j != null) {
                            BluetoothLeService.this.f24619j.j(true, 19);
                        }
                        BluetoothLeService.this.sendBroadcast(new Intent("bluetooth.le.ACTION_GATT_FAILURE_daydaybandsdk"));
                        str = "bluetoothGattServices==null,发现服务失败  gatt.close  gatt=" + ((Object) null);
                    }
                    u.d("BluetoothLeService", str);
                    return;
                }
                BluetoothLeService.this.H0.b0(false);
                BluetoothLeService.this.X0();
                bluetoothGatt.close();
                if (BluetoothLeService.this.f24619j != null) {
                    BluetoothLeService.this.f24619j.j(true, 19);
                }
                BluetoothLeService.this.sendBroadcast(new Intent("bluetooth.le.ACTION_GATT_FAILURE_daydaybandsdk"));
                return;
            }
            u.d("BluetoothLeService", "----------->onServicesDiscovered gatt 不一致 ");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            BluetoothLeService.this.f24613g.s();
        }
    }

    /* loaded from: classes2.dex */
    class d extends Handler {
        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i10 = message.what;
            if (i10 != 7) {
                switch (i10) {
                    case 10:
                        BluetoothLeService.this.C0();
                        return;
                    case 11:
                        if (message.arg1 == 1) {
                            BluetoothLeService.this.n0();
                            return;
                        } else {
                            BluetoothLeService.this.t0();
                            return;
                        }
                    case 12:
                        BluetoothLeService.this.z0();
                        return;
                    default:
                        return;
                }
            } else {
                BluetoothGatt bluetoothGatt = BluetoothLeService.f24600m1;
                if (bluetoothGatt != null) {
                    BluetoothLeService.this.v(bluetoothGatt.getServices());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BluetoothLeService.f24600m1 != null) {
                if (!p.d(BluetoothLeService.this.f24603b, 4)) {
                    BluetoothLeService.this.H0.b0(true);
                    BluetoothLeService.this.sendBroadcast(new Intent("send_device_info_action"));
                    if (BluetoothLeService.this.f24619j != null) {
                        BluetoothLeService.this.f24619j.j(true, 20);
                    }
                    BluetoothLeService.this.sendBroadcast(new Intent("action_gatt_connect_daydaybandsdk"));
                    BluetoothLeService.this.f24613g.s();
                    fn.a.A(BluetoothLeService.this.f24603b).b0();
                } else if (BluetoothLeService.this.f24619j != null) {
                    BluetoothLeService.this.f24619j.j(true, 141);
                }
            }
            BluetoothLeService.this.f24638r0.removeCallbacks(BluetoothLeService.this.f24640s0);
        }
    }

    /* loaded from: classes2.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            q qVar;
            String str;
            u.a("sendKey", "mContentStatus = " + BluetoothLeService.this.f24646v0);
            switch (BluetoothLeService.this.f24646v0) {
                case 1:
                    BluetoothLeService.this.f24613g.X(5);
                    break;
                case 2:
                    BluetoothLeService.this.f24613g.b0(1);
                    break;
                case 4:
                    BluetoothLeService.this.f24613g.f26219s++;
                    BluetoothLeService.this.f24613g.g0(BluetoothLeService.this.f24613g.f26219s);
                    BluetoothLeService.this.f24642t0 = -1;
                    break;
                case 5:
                    BluetoothLeService.this.f24613g.f26219s = 0;
                    BluetoothLeService.this.f24613g.f26221u = false;
                    BluetoothLeService.this.f24613g.g0(BluetoothLeService.this.f24613g.f26219s);
                    BluetoothLeService.this.f24642t0 = -1;
                    break;
                case 6:
                    String I = z.v(BluetoothLeService.this.f24603b).I();
                    String b10 = gn.i.b(BluetoothLeService.this.f24603b, I);
                    if (b10 == null) {
                        qVar = BluetoothLeService.this.f24613g;
                        str = "" + I;
                    } else {
                        str = b10 + "";
                        qVar = BluetoothLeService.this.f24613g;
                    }
                    qVar.j0(str, 3);
                    break;
                case 7:
                    BluetoothLeService.this.f24613g.f26219s++;
                    BluetoothLeService.this.f24613g.h0(BluetoothLeService.this.f24613g.f26219s);
                    BluetoothLeService.this.f24642t0 = -1;
                    break;
                case 8:
                    BluetoothLeService.this.f24613g.P0(BluetoothLeService.this.f24613g.f26223w);
                    BluetoothLeService.this.f24642t0 = -1;
                    BluetoothLeService.this.f24646v0 = -1;
                    break;
                case 9:
                    BluetoothLeService.this.f24613g.S0(BluetoothLeService.this.f24613g.f26224x);
                    BluetoothLeService.this.f24646v0 = -1;
                    break;
                case 10:
                    BluetoothLeService.this.f24613g.q0(BluetoothLeService.this.f24613g.f26224x);
                    BluetoothLeService.this.f24646v0 = -1;
                    break;
                case 11:
                    BluetoothLeService.this.f24613g.o0(BluetoothLeService.this.f24636q0);
                    BluetoothLeService.this.f24636q0 = (byte) 0;
                    BluetoothLeService.this.f24646v0 = -1;
                    break;
                case 12:
                    BluetoothLeService.this.f24613g.E++;
                    BluetoothLeService.this.f24613g.Y(BluetoothLeService.this.f24613g.E);
                    BluetoothLeService.this.f24642t0 = -1;
                    break;
                case 13:
                    BluetoothLeService bluetoothLeService = BluetoothLeService.this;
                    bluetoothLeService.g(true, bluetoothLeService.f24648w0);
                    BluetoothLeService.this.f24642t0 = -1;
                    break;
                case 14:
                    BluetoothLeService bluetoothLeService2 = BluetoothLeService.this;
                    bluetoothLeService2.g(false, bluetoothLeService2.f24648w0);
                    BluetoothLeService.this.f24642t0 = -1;
                    break;
                case 15:
                    BluetoothLeService.this.f24613g.T0(BluetoothLeService.this.f24613g.f26224x);
                    BluetoothLeService.this.f24646v0 = -1;
                    break;
                case 16:
                    BluetoothLeService.this.f24613g.r0(BluetoothLeService.this.f24613g.f26224x);
                    BluetoothLeService.this.f24646v0 = -1;
                    break;
                case 17:
                    BluetoothLeService.this.f24613g.p0(BluetoothLeService.this.f24636q0);
                    BluetoothLeService.this.f24636q0 = (byte) 0;
                    BluetoothLeService.this.f24646v0 = -1;
                    break;
                case 18:
                    BluetoothLeService.this.f24613g.K++;
                    BluetoothLeService.this.f24613g.t(BluetoothLeService.this.f24613g.K);
                    BluetoothLeService.this.f24642t0 = -1;
                    break;
                case 19:
                    BluetoothLeService.this.f24613g.U();
                    BluetoothLeService.this.f24642t0 = -1;
                    break;
                case 20:
                    BluetoothLeService.this.f24613g.c0();
                    BluetoothLeService.this.f24642t0 = -1;
                    break;
            }
            BluetoothLeService.this.f24638r0.removeCallbacks(BluetoothLeService.this.f24650x0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f24661a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f24662b;

        g(int i10, int i11) {
            this.f24661a = i10;
            this.f24662b = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            u.a("sendTextKey", "设置超时同步数据等待时间 =" + this.f24661a + ",type =" + this.f24662b);
            synchronized (BluetoothLeService.this.D0) {
                try {
                    BluetoothLeService.this.E0 = true;
                    BluetoothLeService.this.D0.wait(this.f24661a);
                    u.a("sendTextKey", "同步数据等待完成 isSyncTimeOut = " + BluetoothLeService.this.E0 + ",type =" + this.f24662b);
                    if (BluetoothLeService.this.f24619j != null && BluetoothLeService.this.E0) {
                        BluetoothLeService.this.f24619j.j(true, this.f24662b);
                    }
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class h implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f24664a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f24665b;

        h(int i10, int i11) {
            this.f24664a = i10;
            this.f24665b = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            u.a("BluetoothLeService", "设置超时连接等待时间 =" + this.f24664a + ",type =" + this.f24665b);
            synchronized (BluetoothLeService.this.F0) {
                try {
                    BluetoothLeService.this.G0 = true;
                    BluetoothLeService.this.F0.wait(this.f24664a);
                    u.a("BluetoothLeService", "连接等待完成 isConnectTimeOut = " + BluetoothLeService.this.G0 + ",type =" + this.f24665b);
                    if (BluetoothLeService.this.f24619j != null && BluetoothLeService.this.G0) {
                        BluetoothLeService.this.f24619j.j(true, this.f24665b);
                    }
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    class i extends BroadcastReceiver {
        i() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.bluetooth.adapter.action.STATE_CHANGED") && intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE) == 10) {
                z.v(BluetoothLeService.this.f24603b).b0(false);
            }
        }
    }

    /* loaded from: classes2.dex */
    class j implements dn.f {
        j() {
        }

        @Override // dn.f
        public void a(int i10) {
            BluetoothLeService.m1(BluetoothLeService.this);
            w.g("通知指令 " + i10 + " 超时了 " + BluetoothLeService.this.f24610e1 + " 次");
            if (BluetoothLeService.this.f24610e1 == 1) {
                BluetoothLeService.this.n(i10);
                return;
            }
            BluetoothLeService.this.f24610e1 = 0;
            w.g("notifyCommandType = " + i10);
            BluetoothLeService.this.w(false);
        }
    }

    public BluetoothLeService() {
        new i();
    }

    private boolean A(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z10) {
        boolean z11;
        BluetoothGattDescriptor descriptor;
        BluetoothGattDescriptor descriptor2;
        BluetoothGattDescriptor descriptor3;
        if (f24599l1 == null || bluetoothGatt == null) {
            w.g("BluetoothAdapter not initialized");
            return false;
        }
        boolean characteristicNotification = bluetoothGatt.setCharacteristicNotification(bluetoothGattCharacteristic, z10);
        if (!c0.f27540p.equals(bluetoothGattCharacteristic.getUuid()) || (descriptor3 = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(c0.f27539o))) == null || y(PayTask.f6879j)) {
            z11 = false;
        } else {
            descriptor3.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            z11 = bluetoothGatt.writeDescriptor(descriptor3);
        }
        if ((UUID.fromString(c0.f27526b).equals(bluetoothGattCharacteristic.getUuid()) || UUID.fromString(c0.f27528d).equals(bluetoothGattCharacteristic.getUuid())) && (descriptor2 = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(c0.f27539o))) != null && !y(PayTask.f6879j)) {
            descriptor2.setValue(z10 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : new byte[]{0, 0});
            z11 = bluetoothGatt.writeDescriptor(descriptor2);
        }
        if (c0.f27537m.equals(bluetoothGattCharacteristic.getUuid()) && (descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString(c0.f27539o))) != null && !y(PayTask.f6879j)) {
            descriptor.setValue(z10 ? BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE : new byte[]{0, 0});
            z11 = bluetoothGatt.writeDescriptor(descriptor);
        }
        w.g("setCharacteristicNotification registerNotify = " + characteristicNotification + ",writeResult =" + z11);
        return characteristicNotification && z11;
    }

    private void A0(StringBuilder sb2, byte[] bArr) {
        int i10;
        int i11;
        en.e eVar;
        if (sb2.toString().length() >= 6) {
            String substring = sb2.toString().substring(2, 6);
            if (this.f24613g.C()) {
                if (substring.equals("FFFD")) {
                    if (this.f24613g.D(bArr[3])) {
                        u.a("sendTextKey", "sdk发送数据到ble完成，并且校验成功，返回状态给客户 ");
                        eVar = this.f24619j;
                        if (eVar != null) {
                            i11 = 66;
                        } else {
                            return;
                        }
                    } else {
                        u.a("sendTextKey", "sdk发送数据到ble完成，但是校验失败，返回状态给客户 ");
                        eVar = this.f24619j;
                        if (eVar != null) {
                            i11 = 67;
                        } else {
                            return;
                        }
                    }
                    eVar.l(true, i11, null);
                    return;
                } else if (bArr.length == 3) {
                    this.f24613g.f26224x = (((bArr[1] << 8) & 65280) | (bArr[2] & 255)) + 1;
                    i10 = 15;
                } else {
                    return;
                }
            } else if (substring.equals("FFFD")) {
                if (this.f24636q0 == bArr[3]) {
                    byte[] F = q.F(this.f24634p0.toString());
                    u.a("sendTextKey", "ble发送数据到sdk完成，并且校验成功，返回数据给客户");
                    en.e eVar2 = this.f24619j;
                    if (eVar2 != null) {
                        eVar2.l(true, 68, F);
                    }
                } else {
                    u.a("sendTextKey", "ble发送数据到sdk完成，但是校验失败，返回状态给客户 ");
                    en.e eVar3 = this.f24619j;
                    if (eVar3 != null) {
                        eVar3.l(true, 69, null);
                    }
                }
                this.f24636q0 = (byte) 0;
                this.f24634p0 = new StringBuilder();
                return;
            } else if (bArr.length > 3) {
                if (sb2.length() >= 6) {
                    this.f24634p0.append(sb2.substring(6, sb2.length()));
                }
                for (int i12 = 1; i12 < bArr.length; i12++) {
                    this.f24636q0 = (byte) (this.f24636q0 ^ bArr[i12]);
                }
                this.f24613g.f26224x = ((bArr[1] << 8) & 65280) | (bArr[2] & 255);
                i10 = 16;
            } else {
                return;
            }
            this.f24646v0 = i10;
            this.f24638r0.postDelayed(this.f24650x0, 20L);
        }
    }

    private int C() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(11) * 60) + calendar.get(12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        I0();
    }

    private void D0(StringBuilder sb2, byte[] bArr) {
        OnlineDialUtil.b("在线表盘:" + ((Object) sb2));
        int i10 = bArr[1] & 255;
        if (i10 == 1) {
            OnlineDialUtil.b("获取手环的表盘配置");
            OnlineDialUtil.j().k(sb2, bArr, this.H0);
            this.f24647w.H(0);
        } else if (i10 == 2) {
            OnlineDialUtil.b("准备开始发送表盘数据");
            this.f24647w.H(1);
        } else if (i10 == 3) {
            int i11 = bArr[2] & 255;
            if (i11 == 0) {
                this.f24647w.H(2);
                return;
            }
            if (i11 == 1) {
                this.f24647w.H(3);
            } else if (i11 == 2) {
                this.f24647w.H(4);
            } else if (i11 == 3) {
                this.f24613g.f26209i = ((bArr[4] & 255) | ((bArr[3] << 8) & 65280)) - 1;
                OnlineDialUtil.b("断点序号，重发 NOsectionOnline =" + (this.f24613g.f26209i + 1));
                return;
            } else if (i11 == 4) {
                this.I0.c();
                OnlineDialUtil.b("发送数据段OK，发下一段");
                this.f24613g.f26208h.removeMessages(2);
                Message message = new Message();
                this.f24613g.getClass();
                message.what = 2;
                this.f24613g.f26208h.sendMessageDelayed(message, OnlineDialUtil.f24597c);
                return;
            } else {
                return;
            }
            this.f24613g.x0();
        }
    }

    private void G(String str, StringBuilder sb2, byte[] bArr) {
        switch (bArr[1] & 255) {
            case g.f.DEFAULT_SWIPE_ANIMATION_DURATION /* 250 */:
                this.f24646v0 = 19;
                this.f24638r0.postDelayed(this.f24650x0, 200L);
                this.f24618i1 = 0;
                dn.g gVar = this.f24621j1;
                if (gVar != null) {
                    gVar.a(0, 0);
                    return;
                }
                return;
            case 251:
                this.f24646v0 = 20;
                this.f24638r0.postDelayed(this.f24650x0, 200L);
                dn.g gVar2 = this.f24621j1;
                if (gVar2 != null) {
                    int i10 = this.f24618i1 + 1;
                    this.f24618i1 = i10;
                    gVar2.a(2, i10);
                    return;
                }
                return;
            case 252:
                int i11 = this.f24618i1 + 1;
                this.f24618i1 = i11;
                dn.g gVar3 = this.f24621j1;
                if (gVar3 != null) {
                    gVar3.a(1, i11);
                }
                this.f24618i1 = 0;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        this.f24638r0.removeMessages(10);
        w.e().d();
        w.e().i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(StringBuilder sb2, byte[] bArr) {
        String substring = sb2.toString().substring(0, 2);
        if (substring.equals("32")) {
            s(substring, sb2, bArr);
        } else if (substring.equals("34")) {
            Q(substring, sb2, bArr);
        } else if (substring.equals("28")) {
            o0(sb2, bArr);
        } else if (substring.equals("F6")) {
            A0(sb2, bArr);
        } else if (substring.equals("3E")) {
            M0(sb2, bArr);
        } else if (substring.equals("3F")) {
            J0(sb2, bArr);
        }
    }

    private void H0(StringBuilder sb2, byte[] bArr) {
        int length;
        if (sb2 != null && (length = sb2.toString().length()) == 40) {
            int i10 = length - 6;
            String substring = sb2.toString().substring(i10, length);
            String substring2 = sb2.toString().substring(length - 12, i10);
            int e10 = n.d(this.f24603b).e(substring);
            int e11 = n.d(this.f24603b).e(substring2);
            z.v(this.f24603b).F0(e10);
            z.v(this.f24603b).G0(e11);
        }
        en.e eVar = this.f24619j;
        if (eVar != null) {
            eVar.j(true, 127);
        }
    }

    private void I(List<cn.a> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            o.b(this.f24603b).p(list.get(i10));
        }
    }

    private void I0() {
        int i10;
        w.e().d();
        this.J0 = false;
        List<Integer> f10 = w.e().f();
        if (f10 == null || f10.size() <= 0) {
            w.g("没有待执行的通知指令");
        } else {
            try {
                i10 = f10.get(0).intValue();
            } catch (Exception e10) {
                w.g("正在执行的通知命令 Exception = " + e10);
                i10 = 0;
            }
            w.g("正在执行的通知命令 = " + i10);
            n(i10);
            w.e().h();
        }
        List<Integer> f11 = w.e().f();
        if (f11 != null && f11.size() == 0) {
            this.f24638r0.postDelayed(this.f24640s0, 0);
            long currentTimeMillis = System.currentTimeMillis() - this.f24606c1;
            this.f24614g1++;
            this.f24608d1 = false;
            w.g("设置通知读特征值完成 ：" + currentTimeMillis + ",connectSuccessCount =" + this.f24614g1);
        }
    }

    private void J(byte[] bArr) {
        en.e eVar;
        boolean z10 = true;
        int i10 = bArr[1] & 255;
        if (i10 == 0) {
            eVar = this.f24619j;
            if (eVar == null) {
                return;
            }
        } else if (i10 == 17 && (eVar = this.f24619j) != null) {
            z10 = false;
        } else {
            return;
        }
        eVar.j(z10, 136);
    }

    private void J0(StringBuilder sb2, byte[] bArr) {
        int i10;
        en.e eVar;
        if ((bArr[2] & 255) == 0 || (bArr[2] & 255) == 1) {
            int i11 = bArr[1] & 255;
            if (i11 == 1) {
                eVar = this.f24619j;
                if (eVar != null) {
                    i10 = 202;
                } else {
                    return;
                }
            } else if (i11 == 2) {
                eVar = this.f24619j;
                if (eVar != null) {
                    i10 = 201;
                } else {
                    return;
                }
            } else if (i11 == 3) {
                eVar = this.f24619j;
                if (eVar != null) {
                    i10 = 200;
                } else {
                    return;
                }
            } else if (i11 == 4) {
                eVar = this.f24619j;
                if (eVar != null) {
                    i10 = 199;
                } else {
                    return;
                }
            } else if (i11 == 5 && (eVar = this.f24619j) != null) {
                i10 = 203;
            } else {
                return;
            }
        } else if ((bArr[2] & 255) != 2 || (bArr[1] & 255) != 1) {
            return;
        } else {
            if (bArr.length == 5 && (bArr[3] & 255) == 250) {
                p0(this.f24624k1);
                ArrayList arrayList = new ArrayList();
                this.f24624k1 = arrayList;
                arrayList.clear();
                eVar = this.f24619j;
                if (eVar != null) {
                    i10 = 205;
                } else {
                    return;
                }
            } else {
                String a10 = gn.a0.b().a(bArr);
                for (int i12 = 0; i12 < bArr.length - 7; i12 += 4) {
                    int i13 = bArr[i12 + 7] & 255;
                    int i14 = bArr[i12 + 8] & 255;
                    int i15 = ((bArr[i12 + 9] << 8) & 65280) | (bArr[i12 + 10] & 255);
                    String c10 = gn.a0.b().c(a10, i13, i14);
                    String d10 = gn.a0.b().d(a10, i13, i14, i15);
                    u.c("standing history calendar=" + a10 + ",startTime=" + c10 + ",endTime=" + d10 + ",duration=" + i15);
                    this.f24624k1.add(new v(a10, c10, d10, i15));
                }
                eVar = this.f24619j;
                if (eVar != null) {
                    i10 = 204;
                } else {
                    return;
                }
            }
        }
        eVar.j(true, i10);
    }

    private void M0(StringBuilder sb2, byte[] bArr) {
        int i10;
        en.e eVar;
        dn.d dVar;
        String str;
        Message message;
        int i11 = bArr[1] & 255;
        if (i11 != 17) {
            if (i11 == 170) {
                u.c("查询模块是否需要进行血压标定");
                int i12 = bArr[2] & 255;
                if (i12 == 0) {
                    u.c("模块不需要进行标定");
                    dn.d dVar2 = this.B;
                    if (dVar2 != null) {
                        dVar2.a(4, null);
                    }
                } else if (i12 == 1) {
                    u.c("模块需要进行标定");
                    dn.d dVar3 = this.B;
                    if (dVar3 != null) {
                        dVar3.a(3, null);
                    }
                }
                eVar = this.f24619j;
                if (eVar != null) {
                    i10 = 191;
                } else {
                    return;
                }
            } else if (i11 == 255) {
                int i13 = bArr[2] & 255;
                if ((i13 == 1 || i13 == 2 || i13 == 3) && (dVar = this.B) != null) {
                    dVar.a(10, null);
                    return;
                }
                return;
            } else if (i11 != 0) {
                if (i11 == 1) {
                    u.c("BLE应答返回指令,发下一段");
                    int i14 = bArr[2] & 255;
                    if (i14 == 250) {
                        int i15 = bArr[3] & 255;
                        u.c("BLE应答返回指令 COSn =" + i15);
                        this.f24613g.L = i15 + 1;
                        message = new Message();
                        this.f24613g.getClass();
                        message.what = 3;
                    } else if (i14 == 253) {
                        u.c("APP下发CO数据结束指令，校验成功");
                        dn.d dVar4 = this.B;
                        if (dVar4 != null) {
                            dVar4.a(7, null);
                            return;
                        }
                        return;
                    } else if (i14 == 255) {
                        this.f24613g.L = 0;
                        int i16 = this.X0 + 1;
                        this.X0 = i16;
                        if (i16 == 3) {
                            u.c("APP下发CO数据结束指令，校验失败，发出失败回调");
                            dn.d dVar5 = this.B;
                            if (dVar5 != null) {
                                dVar5.a(8, null);
                            }
                            this.X0 = 0;
                            return;
                        }
                        u.c("APP下发CO数据结束指令，校验失败，重发 times = " + this.X0);
                        message = new Message();
                        this.f24613g.getClass();
                        message.what = 4;
                    } else {
                        return;
                    }
                    this.f24613g.f26208h.sendMessageDelayed(message, OnlineDialUtil.f24597c);
                    return;
                } else if (i11 == 2) {
                    dn.d dVar6 = this.B;
                    if (dVar6 != null) {
                        dVar6.a(11, null);
                    }
                    eVar = this.f24619j;
                    if (eVar != null) {
                        i10 = 193;
                    } else {
                        return;
                    }
                } else if (i11 == 3) {
                    dn.d dVar7 = this.B;
                    if (dVar7 != null) {
                        dVar7.a(12, null);
                    }
                    eVar = this.f24619j;
                    if (eVar != null) {
                        i10 = 196;
                    } else {
                        return;
                    }
                } else if (i11 == 4) {
                    dn.d dVar8 = this.B;
                    if (dVar8 != null) {
                        dVar8.a(13, null);
                    }
                    eVar = this.f24619j;
                    if (eVar != null) {
                        i10 = 198;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } else if (bArr.length == 2) {
                u.c("开始标定指令成功");
                this.f24604b1 = new ArrayList();
                this.Z0 = 0;
                this.f24602a1 = "";
                this.W0 = 0;
                dn.d dVar9 = this.B;
                if (dVar9 != null) {
                    dVar9.a(1, null);
                }
                eVar = this.f24619j;
                if (eVar != null) {
                    i10 = 192;
                } else {
                    return;
                }
            } else {
                int i17 = bArr[2] & 255;
                if (i17 == 250) {
                    for (int i18 = 5; i18 < bArr.length; i18++) {
                        this.W0 ^= bArr[i18];
                    }
                    this.Y0 = bArr[3] & 255;
                    u.c("pmSn =" + this.Y0 + ",bleSn =" + (bArr[4] & 255));
                    if (this.Z0 == this.Y0) {
                        str = this.f24602a1 + sb2.substring(10, sb2.length());
                    } else {
                        String str2 = this.f24602a1;
                        this.f24604b1.add(new cn.e(str2, str2.length() / 2));
                        str = sb2.substring(10, sb2.length());
                    }
                    this.f24602a1 = str;
                    this.Z0 = this.Y0;
                    return;
                } else if (i17 == 253) {
                    if (bArr.length == 3) {
                        dn.d dVar10 = this.B;
                        if (dVar10 != null) {
                            dVar10.a(9, this.f24604b1);
                            return;
                        }
                        return;
                    }
                    int i19 = bArr[3] & 255;
                    u.c("csbp bleCrc =" + i19 + ",csbpCRC =" + (this.W0 & 255));
                    String str3 = this.f24602a1;
                    this.f24604b1.add(new cn.e(str3, str3.length() / 2));
                    if (i19 == (this.W0 & 255)) {
                        u.c("csbp,检验成功");
                        dn.d dVar11 = this.B;
                        if (dVar11 != null) {
                            dVar11.a(5, this.f24604b1);
                        }
                        this.W0 = 0;
                        this.Z0 = 0;
                        this.f24602a1 = "";
                        this.f24604b1 = new ArrayList();
                        this.f24613g.m(true);
                        eVar = this.f24619j;
                        if (eVar != null) {
                            i10 = 194;
                        } else {
                            return;
                        }
                    } else {
                        u.c("csbp,检验失败");
                        dn.d dVar12 = this.B;
                        if (dVar12 != null) {
                            dVar12.a(6, this.f24604b1);
                        }
                        this.W0 = 0;
                        this.Z0 = 0;
                        this.f24602a1 = "";
                        this.f24604b1 = new ArrayList();
                        this.f24613g.m(false);
                        eVar = this.f24619j;
                        if (eVar != null) {
                            i10 = 195;
                        } else {
                            return;
                        }
                    }
                } else {
                    return;
                }
            }
            eVar.j(true, i10);
            return;
        }
        u.c("标定过程中设备返回实时血压波形");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String N(byte[] bArr) {
        int i10 = ((bArr[3] << 24) & (-16777216)) | (bArr[0] & 255) | ((bArr[1] << 8) & 65280) | ((bArr[2] << 16) & 16711680);
        return String.valueOf((i10 >> 12) & 32767) + String.valueOf((i10 >> 27) & 31);
    }

    private void O() {
        Context applicationContext = getApplicationContext();
        this.f24603b = applicationContext;
        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(gn.q.f27582a, 0);
        this.f24605c = sharedPreferences;
        this.f24607d = sharedPreferences.edit();
        z v10 = z.v(this.f24603b);
        this.H0 = v10;
        v10.b0(false);
        this.I0 = bn.i.d(this.f24603b);
        this.f24613g = q.B(this.f24603b);
        this.f24615h = en.c.y(this.f24603b);
        this.D0 = new Object();
        this.F0 = new Object();
        this.f24613g.I(this);
        w.e();
    }

    private void O0(StringBuilder sb2, byte[] bArr) {
        en.e eVar;
        int i10;
        if ((bArr[1] & 255) == 250) {
            u.c("musicControlCRC=" + q.W + ",CRC=" + ((int) bArr[2]));
            if (q.W == bArr[2]) {
                u.c("歌曲名校验成功");
                eVar = this.f24619j;
                if (eVar != null) {
                    i10 = 186;
                    eVar.j(true, i10);
                }
                q.W = 0;
            }
            u.c("歌曲名校验失败");
            eVar = this.f24619j;
            if (eVar != null) {
                i10 = 187;
                eVar.j(true, i10);
            }
            q.W = 0;
        }
    }

    private void Q(String str, StringBuilder sb2, byte[] bArr) {
        int i10;
        en.e eVar;
        if (str.equals("34")) {
            int i11 = bArr[1] & 255;
            int i12 = 0;
            if (i11 != 0) {
                if (i11 != 17) {
                    if (i11 == 170) {
                        x.a("查询当前BLE测试血氧的状态");
                        en.e eVar2 = this.f24619j;
                        if (eVar2 == null || bArr.length <= 2) {
                            return;
                        }
                        if ((bArr[2] & 255) != 17) {
                            eVar2.j(false, 122);
                            return;
                        } else {
                            eVar2.j(true, 122);
                            return;
                        }
                    } else if (i11 != 250) {
                        if (i11 != 253) {
                            if (i11 == 3) {
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i10 = 125;
                                } else {
                                    return;
                                }
                            } else if (i11 == 4) {
                                b0.a("设置血氧自动测试时间段");
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i10 = 126;
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else if (bArr.length == 2) {
                            en.e eVar3 = this.f24619j;
                            if (eVar3 != null) {
                                eVar3.j(true, 121);
                            }
                            dn.i iVar = this.f24651y;
                            if (iVar != null) {
                                iVar.a(4, null);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    } else if ((bArr[2] & 255) == 253) {
                        int i13 = bArr[3] & 255;
                        x.a("同步完成，并给出检验结果 bleCrc =" + i13 + ",oxygenCRC =" + (this.P0 & 255));
                        if (i13 == (this.P0 & 255)) {
                            this.P0 = 0;
                            x.a("同步完成,检验成功,保存数据");
                            b0(this.Q0);
                            ArrayList arrayList = new ArrayList();
                            this.Q0 = arrayList;
                            arrayList.clear();
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i10 = 124;
                            } else {
                                return;
                            }
                        } else {
                            b0.a("同步完成,检验失败，重新同步");
                            this.P0 = 0;
                            ArrayList arrayList2 = new ArrayList();
                            this.Q0 = arrayList2;
                            arrayList2.clear();
                            this.f24613g.K0();
                            return;
                        }
                    } else {
                        for (int i14 = 2; i14 < bArr.length; i14++) {
                            this.P0 ^= bArr[i14];
                        }
                        String c10 = x.e().c(bArr);
                        int d10 = x.e().d(bArr);
                        if (d10 == 0) {
                            d10 = 24;
                            c10 = l(c10);
                        }
                        int i15 = d10 * 60;
                        while (i12 < bArr.length - 8) {
                            int i16 = i12 + 8;
                            if ((bArr[i16] & 255) != 255) {
                                x.a("FA i =" + i12 + ",oxygenValue=" + (bArr[i16] & 255));
                                int i17 = i15 - ((11 - i12) * 10);
                                int b10 = x.e().b(bArr[i16] & 255);
                                if (b10 > 0) {
                                    String f10 = b0.h().f(c10, i17);
                                    this.Q0.add(new cn.k(c10, f10, i17, b10));
                                    x.a("calendar =" + c10 + ",startDate =" + f10 + ",time =" + i17 + ",oxygenValue =" + b10);
                                }
                            }
                            i12++;
                        }
                        eVar = this.f24619j;
                        if (eVar != null) {
                            i10 = 123;
                        } else {
                            return;
                        }
                    }
                } else if (bArr.length == 2) {
                    x.a("打开BLE血氧测试");
                    dn.i iVar2 = this.f24651y;
                    if (iVar2 != null) {
                        iVar2.a(2, null);
                    }
                    eVar = this.f24619j;
                    if (eVar != null) {
                        i10 = 120;
                    } else {
                        return;
                    }
                } else {
                    int i18 = bArr[3] & 255;
                    x.a("实时 状态 =" + (bArr[2] & 255) + ",oxygenValue =" + i18);
                    if ((bArr[2] & 255) == 0) {
                        i12 = i18;
                    }
                    int b11 = x.e().b(i12);
                    cn.k kVar = new cn.k();
                    if (b11 > 0) {
                        String b12 = gn.h.b();
                        int f11 = gn.h.f();
                        String e10 = gn.h.e(b12, f11);
                        kVar.f(b12);
                        kVar.i(f11);
                        kVar.h(e10);
                        kVar.g(b11);
                    }
                    dn.i iVar3 = this.f24651y;
                    if (iVar3 != null) {
                        iVar3.a(3, kVar);
                        return;
                    }
                    return;
                }
                eVar.j(true, i10);
                return;
            }
            if (bArr.length == 2) {
                x.a("关闭BLE血氧测试");
                dn.i iVar4 = this.f24651y;
                if (iVar4 != null) {
                    iVar4.a(0, null);
                }
            } else {
                int i19 = bArr[3] & 255;
                x.a("结束 状态 =" + (bArr[2] & 255) + ",oxygenValue =" + i19);
                if ((bArr[2] & 255) == 0) {
                    i12 = i19;
                }
                int b13 = x.e().b(i12);
                cn.k kVar2 = new cn.k();
                if (b13 > 0) {
                    String b14 = gn.h.b();
                    int f12 = gn.h.f();
                    String e11 = gn.h.e(b14, f12);
                    kVar2.f(b14);
                    kVar2.i(f12);
                    kVar2.h(e11);
                    kVar2.g(b13);
                }
                dn.i iVar5 = this.f24651y;
                if (iVar5 != null) {
                    iVar5.a(1, kVar2);
                }
            }
            en.e eVar4 = this.f24619j;
            if (eVar4 != null) {
                eVar4.j(true, 121);
            }
        }
    }

    private void R(StringBuilder sb2, byte[] bArr) {
        int i10;
        dn.a aVar;
        dn.a aVar2;
        dn.a aVar3;
        en.e eVar;
        int i11;
        int i12 = bArr[1] & 255;
        if (i12 != 0) {
            if (i12 == 1) {
                gn.f.d("人体成分:测试过程中，从佩戴变为脱手");
                aVar = this.f24637r;
                if (aVar != null) {
                    i10 = 162;
                } else {
                    return;
                }
            } else if (i12 == 2) {
                gn.f.d("人体成分:测试过程中，从脱手变为佩戴");
                aVar = this.f24637r;
                if (aVar != null) {
                    i10 = 163;
                } else {
                    return;
                }
            } else if (i12 == 17) {
                if (bArr.length >= 8) {
                    int i13 = bArr[7] & 255;
                    if (i13 == 0) {
                        gn.f.d("人体成分:手机控制设备只设置参数");
                        aVar3 = this.f24637r;
                        aVar3.a(false, 160, "");
                        return;
                    } else if (i13 == 17) {
                        gn.f.d("人体成分:手机控制设备开始测试2");
                        aVar2 = this.f24637r;
                        if (aVar2 == null) {
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    gn.f.d("人体成分:手机控制设备开始测试1");
                    aVar2 = this.f24637r;
                    if (aVar2 == null) {
                        return;
                    }
                }
                aVar2.a(true, 160, "");
                return;
            } else if (i12 == 170) {
                gn.f.d("人体成分:查询当前设备测试状");
                int i14 = bArr[2] & 255;
                if (i14 == 0) {
                    gn.f.d("人体成分:表示不测试");
                    aVar3 = this.f24637r;
                    if (aVar3 == null) {
                        return;
                    }
                    aVar3.a(false, 160, "");
                    return;
                } else if (i14 == 17) {
                    gn.f.d("人体成分:表示正在测试");
                    aVar2 = this.f24637r;
                    if (aVar2 == null) {
                        return;
                    }
                    aVar2.a(true, 160, "");
                    return;
                } else {
                    return;
                }
            } else if (i12 == 250) {
                if (sb2.toString().length() == 6) {
                    int i15 = bArr[2] & 255;
                    gn.f.d("同步完成，并给出检验结果 bleCrc =" + i15 + ",tempBodyCRC =" + (this.f24631o & 255));
                    if (i15 == (this.f24631o & 255)) {
                        this.f24631o = 0;
                        gn.f.n().a(this.f24603b, this.f24633p);
                        ArrayList arrayList = new ArrayList();
                        this.f24633p = arrayList;
                        arrayList.clear();
                        eVar = this.f24619j;
                        if (eVar != null) {
                            i11 = 158;
                        } else {
                            return;
                        }
                    } else {
                        gn.f.d("同步完成，并给出检验结果 检验失败");
                        this.f24631o = 0;
                        ArrayList arrayList2 = new ArrayList();
                        this.f24633p = arrayList2;
                        arrayList2.clear();
                        eVar = this.f24619j;
                        if (eVar != null) {
                            i11 = 159;
                        } else {
                            return;
                        }
                    }
                } else {
                    for (byte b10 : bArr) {
                        this.f24631o ^= b10;
                    }
                    int i16 = bArr[2] & 255;
                    if (i16 == 1) {
                        gn.f.d("人体成分:同步人体成分历史数据---第1段");
                        this.f24629n = bArr;
                        cn.c cVar = new cn.c();
                        this.f24635q = cVar;
                        cVar.c(this.f24629n);
                    } else if (i16 == 2) {
                        gn.f.d("人体成分:同步人体成分历史数据---第2段");
                        this.f24635q.d(bArr);
                        this.f24633p.add(this.f24635q);
                    }
                    eVar = this.f24619j;
                    if (eVar != null) {
                        i11 = 157;
                    } else {
                        return;
                    }
                }
                eVar.j(true, i11);
                return;
            } else if (i12 == 253) {
                gn.f.d("人体成分:设备测试脱手并结束");
                dn.a aVar4 = this.f24637r;
                if (aVar4 != null) {
                    aVar4.a(false, 161, "");
                    return;
                }
                return;
            } else {
                return;
            }
            aVar.a(false, i10, "");
            return;
        }
        gn.f.d("人体成分:结束测试");
        int i17 = bArr[2] & 255;
        if (i17 == 1) {
            gn.f.d("人体成分:结束测试数据---第1段");
            this.f24629n = bArr;
        } else if (i17 == 2) {
            gn.f.d("人体成分:结束测试数据---第2段");
            cn.b b11 = gn.f.n().b(this.f24603b, this.f24629n, bArr);
            dn.a aVar5 = this.f24637r;
            if (aVar5 != null) {
                aVar5.a(b11.d(), 161, b11.b());
            }
        }
    }

    private synchronized void S(List<cn.d> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!TextUtils.isEmpty(list.get(i10).c())) {
                o.b(this.f24603b).u(list.get(i10));
            }
        }
    }

    private String X(byte[] bArr) {
        int i10 = bArr[4] & 255;
        int i11 = bArr[3] & 255;
        int i12 = (bArr[2] & 255) | ((bArr[1] << 8) & 65280);
        String valueOf = String.valueOf(i10);
        String valueOf2 = String.valueOf(i11);
        if (i10 < 10) {
            valueOf = "0" + i10;
        }
        if (i11 < 10) {
            valueOf2 = "0" + i11;
        }
        return String.valueOf(i12) + valueOf2 + valueOf;
    }

    private void Z(String str, StringBuilder sb2, byte[] bArr) {
        en.e eVar;
        int i10;
        int i11;
        String str2;
        en.e eVar2;
        int i12;
        a0 a0Var;
        float f10;
        float f11;
        char c10;
        float f12;
        float f13;
        float f14;
        if (str.equals("24")) {
            boolean z10 = true;
            int i13 = bArr[1] & 255;
            int i14 = 0;
            if (i13 != 1) {
                int i15 = 2;
                if (i13 == 250) {
                    for (int i16 = 2; i16 < bArr.length; i16++) {
                        this.N0 ^= bArr[i16];
                    }
                    String e10 = b0.h().e(bArr);
                    int g10 = b0.h().g(bArr) * 60;
                    while (i14 < bArr.length - 7) {
                        if ((bArr[i14 + 7] & 255) == 255 && (bArr[i14 + 8] & 255) == 255) {
                            str2 = "FA i =" + i14 + ",FFFF";
                        } else {
                            float m10 = b0.h().m(i15, (((bArr[i11] << 8) & 65280) | (bArr[i14 + 8] & 255)) / 100.0f);
                            int i17 = ((i14 / 2) * 10) + g10;
                            String f15 = b0.h().f(e10, i17);
                            this.O0.add(new a0(0, e10, f15, i17 * 60, m10));
                            str2 = "FA i =" + i14 + ",calendar =" + e10 + ",startDate =" + f15 + ",minute =" + i17 + ",bodyTemperature =" + m10;
                        }
                        b0.a(str2);
                        i14 += 2;
                        i15 = 2;
                    }
                    eVar = this.f24619j;
                    if (eVar != null) {
                        i10 = 111;
                    } else {
                        return;
                    }
                } else if (i13 != 253) {
                    switch (i13) {
                        case 3:
                            b0.a("设置自动测试开或关");
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i10 = 107;
                                break;
                            } else {
                                return;
                            }
                        case 4:
                            b0.a("设置自动测试时间段");
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i10 = 106;
                                break;
                            } else {
                                return;
                            }
                        case 5:
                            b0.a("删除历史数据");
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i10 = 108;
                                break;
                            } else {
                                return;
                            }
                        case 6:
                            b0.a("设置最高和最低报警温度,BLE返回值了 mICallback =" + this.f24619j);
                            b0.a("设置最高和最低报警温度,maxAlarm =" + b0.h().i(bArr) + ",minAlarm =" + b0.h().j(bArr));
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i10 = 109;
                                break;
                            } else {
                                return;
                            }
                        case 7:
                            b0.a("设置采集体温原始数据开关OK");
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i10 = 113;
                                break;
                            } else {
                                return;
                            }
                        case 8:
                            b0.a("设置采集体温原始数据开关");
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i10 = 114;
                                break;
                            } else {
                                return;
                            }
                        case 9:
                            int i18 = bArr[2] & 255;
                            b0.a("查询采集体温原始数据开关状态，0表示关闭，1表示打开 =" + i18);
                            eVar2 = this.f24619j;
                            if (eVar2 != null) {
                                if (i18 != 1) {
                                    z10 = false;
                                }
                                i12 = 115;
                                eVar2.j(z10, i12);
                                return;
                            }
                            return;
                        case 10:
                            b0.a("达到设定警报值持续1分钟后自动发送");
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i10 = 116;
                                break;
                            } else {
                                return;
                            }
                        case 11:
                            int i19 = bArr[2] & 255;
                            b0.a("手环端切换了温度单位为:" + i19);
                            eVar2 = this.f24619j;
                            if (eVar2 != null) {
                                if (i19 != 0) {
                                    z10 = false;
                                }
                                i12 = 117;
                                eVar2.j(z10, i12);
                                return;
                            }
                            return;
                        default:
                            switch (i13) {
                                case 240:
                                    String e11 = b0.h().e(bArr);
                                    String l10 = b0.h().l(bArr);
                                    int k10 = b0.h().k(bArr);
                                    float d10 = b0.h().d(false, bArr);
                                    b0.a("F0 calendar =" + e11 + ",startDate =" + l10 + ",secondTime =" + k10 + ",bodyTemperature =" + d10);
                                    if ((bArr[9] & 255) == 255 && (bArr[10] & 255) == 255) {
                                        b0.a("F0 =,FFFF");
                                        f10 = 0.0f;
                                    } else {
                                        f10 = d10;
                                    }
                                    if (this.f24649x != null) {
                                        a0Var = new a0(0, e11, l10, k10, f10);
                                        break;
                                    } else {
                                        return;
                                    }
                                case 241:
                                    String e12 = b0.h().e(bArr);
                                    String l11 = b0.h().l(bArr);
                                    int k11 = b0.h().k(bArr);
                                    float d11 = b0.h().d(true, bArr);
                                    float c11 = b0.h().c(bArr);
                                    b0.a("F1 calendar =" + e12 + ",startDate =" + l11 + ",secondTime =" + k11 + ",bodyTemperature =" + d11 + ",bodySurfaceTemperature =" + c11);
                                    if ((bArr[11] & 255) == 255 && (bArr[12] & 255) == 255) {
                                        b0.a("F1 bodyTemperature =,FFFF");
                                        c10 = '\t';
                                        f11 = 0.0f;
                                    } else {
                                        f11 = d11;
                                        c10 = '\t';
                                    }
                                    if ((bArr[c10] & 255) == 255 && (bArr[10] & 255) == 255) {
                                        b0.a("F1 bodySurfaceTemperature =,FFFF");
                                        f12 = 0.0f;
                                    } else {
                                        f12 = c11;
                                    }
                                    if (this.f24649x != null) {
                                        a0Var = new a0(1, e12, l11, k11, f12, f11, 0.0f);
                                        break;
                                    } else {
                                        return;
                                    }
                                    break;
                                case 242:
                                    String e13 = b0.h().e(bArr);
                                    String l12 = b0.h().l(bArr);
                                    int k12 = b0.h().k(bArr);
                                    float b10 = b0.h().b(bArr);
                                    float c12 = b0.h().c(bArr);
                                    b0.a("F2 calendar =" + e13 + ",startDate =" + l12 + ",secondTime =" + k12 + ",ambientTemperature =" + b10 + ",bodySurfaceTemperature =" + c12);
                                    if ((bArr[11] & 255) == 255 && (bArr[12] & 255) == 255) {
                                        b0.a("F2 ambientTemperature =,FFFF");
                                        f13 = 0.0f;
                                    } else {
                                        f13 = b10;
                                    }
                                    if ((bArr[9] & 255) == 255 && (bArr[10] & 255) == 255) {
                                        b0.a("F2 bodySurfaceTemperature =,FFFF");
                                        f14 = 0.0f;
                                    } else {
                                        f14 = c12;
                                    }
                                    if (this.f24649x != null) {
                                        a0Var = new a0(2, e13, l12, k12, f14, 0.0f, f13);
                                        break;
                                    } else {
                                        return;
                                    }
                                    break;
                                default:
                                    return;
                            }
                            this.f24649x.a(a0Var);
                            return;
                    }
                } else if (bArr.length == 2) {
                    b0.a("体温测试超时");
                    l lVar = this.f24649x;
                    if (lVar != null) {
                        lVar.b(null);
                    }
                    eVar = this.f24619j;
                    if (eVar == null) {
                        return;
                    }
                } else {
                    int i20 = bArr[2] & 255;
                    b0.a("同步完成，并给出检验结果 bleCrc =" + i20 + ",tempTemperatureCRC =" + (this.N0 & 255));
                    if (i20 == (this.N0 & 255)) {
                        this.N0 = 0;
                        b0.a("同步完成,检验成功,保存数据");
                        v0(this.O0);
                        ArrayList arrayList = new ArrayList();
                        this.O0 = arrayList;
                        arrayList.clear();
                        eVar = this.f24619j;
                        if (eVar != null) {
                            i10 = 110;
                        } else {
                            return;
                        }
                    } else {
                        b0.a("同步完成,检验失败，重新同步");
                        this.N0 = 0;
                        ArrayList arrayList2 = new ArrayList();
                        this.O0 = arrayList2;
                        arrayList2.clear();
                        eVar = this.f24619j;
                        if (eVar != null) {
                            i10 = 112;
                        } else {
                            return;
                        }
                    }
                }
                eVar.j(true, i10);
            }
            String e14 = b0.h().e(bArr);
            String l13 = b0.h().l(bArr);
            int k13 = b0.h().k(bArr);
            float d12 = b0.h().d(false, bArr);
            if ((bArr[9] & 255) == 255 && (bArr[10] & 255) == 255) {
                b0.a("FA 01 =,FFFF");
                d12 = 0.0f;
            }
            b0.a("01 calendar =" + e14 + ",startDate =" + l13 + ",secondTime =" + k13 + ",bodyTemperature =" + d12);
            a0 a0Var2 = new a0(0, e14, l13, k13, d12);
            if (!((bArr[9] & 255) == 255 && (bArr[10] & 255) == 255)) {
                o.b(this.f24603b).F(a0Var2);
            }
            l lVar2 = this.f24649x;
            if (lVar2 != null) {
                lVar2.b(a0Var2);
            }
            eVar = this.f24619j;
            if (eVar == null) {
                return;
            }
            i10 = 105;
            eVar.j(true, i10);
        }
    }

    private void a0(StringBuilder sb2, byte[] bArr) {
        en.e eVar;
        int i10;
        int i11 = bArr[1] & 255;
        int i12 = 0;
        if (i11 != 0) {
            if (i11 != 17) {
                if (i11 == 170) {
                    gn.g.a("查询当前BLE测试呼吸率的状态");
                    en.e eVar2 = this.f24619j;
                    if (eVar2 == null || bArr.length <= 2) {
                        return;
                    }
                    if ((bArr[2] & 255) != 17) {
                        eVar2.j(false, 131);
                        return;
                    } else {
                        eVar2.j(true, 131);
                        return;
                    }
                } else if (i11 != 250) {
                    if (i11 != 253) {
                        if (i11 == 3) {
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i10 = 134;
                            } else {
                                return;
                            }
                        } else if (i11 == 4) {
                            b0.a("设置呼吸率自动测试时间段");
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i10 = 135;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (bArr.length == 2) {
                        en.e eVar3 = this.f24619j;
                        if (eVar3 != null) {
                            eVar3.j(true, 130);
                        }
                        dn.c cVar = this.f24653z;
                        if (cVar != null) {
                            cVar.a(4, null);
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                } else if ((bArr[2] & 255) == 253) {
                    int i13 = bArr[3] & 255;
                    gn.g.a("同步完成，并给出检验结果 bleCrc =" + i13 + ",breatheCRC =" + (this.R0 & 255));
                    if (i13 == (this.R0 & 255)) {
                        this.R0 = 0;
                        gn.g.a("同步完成,检验成功,保存数据");
                        S(this.S0);
                        ArrayList arrayList = new ArrayList();
                        this.S0 = arrayList;
                        arrayList.clear();
                        eVar = this.f24619j;
                        if (eVar != null) {
                            i10 = 133;
                        } else {
                            return;
                        }
                    } else {
                        b0.a("同步完成,检验失败，重新同步");
                        this.R0 = 0;
                        ArrayList arrayList2 = new ArrayList();
                        this.S0 = arrayList2;
                        arrayList2.clear();
                        eVar = this.f24619j;
                        if (eVar != null) {
                            i10 = 174;
                        } else {
                            return;
                        }
                    }
                } else {
                    for (int i14 = 2; i14 < bArr.length; i14++) {
                        this.R0 ^= bArr[i14];
                    }
                    String b10 = gn.g.d().b(bArr);
                    int c10 = gn.g.d().c(bArr);
                    if (c10 == 0) {
                        c10 = 24;
                        b10 = l(b10);
                    }
                    int i15 = c10 * 60;
                    while (i12 < bArr.length - 8) {
                        int i16 = i12 + 8;
                        if ((bArr[i16] & 255) != 255) {
                            gn.g.a("FA i =" + i12 + ",breatheValue=" + (bArr[i16] & 255));
                            int i17 = bArr[i16] & 255;
                            int i18 = i15 - ((11 - i12) * 10);
                            String f10 = b0.h().f(b10, i18);
                            this.S0.add(new cn.d(b10, f10, i18, i17));
                            gn.g.a("calendar =" + b10 + ",startDate =" + f10 + ",time =" + i18 + ",breatheValue =" + i17);
                        }
                        i12++;
                    }
                    eVar = this.f24619j;
                    if (eVar != null) {
                        i10 = 132;
                    } else {
                        return;
                    }
                }
            } else if (bArr.length == 2) {
                gn.g.a("打开BLE呼吸率测试");
                dn.c cVar2 = this.f24653z;
                if (cVar2 != null) {
                    cVar2.a(2, null);
                }
                eVar = this.f24619j;
                if (eVar != null) {
                    i10 = 129;
                } else {
                    return;
                }
            } else {
                int i19 = bArr[2] & 255;
                int i20 = bArr[3] & 255;
                gn.g.a("实时 breatheValueStatus =" + i19 + ",breatheValue =" + i20);
                if (i19 == 0) {
                    i12 = i20;
                }
                cn.d dVar = new cn.d();
                String b11 = gn.h.b();
                int f11 = gn.h.f();
                String e10 = gn.h.e(b11, f11);
                dVar.h(b11);
                dVar.j(f11);
                dVar.i(e10);
                dVar.f(i12);
                dn.c cVar3 = this.f24653z;
                if (cVar3 != null) {
                    cVar3.a(3, dVar);
                    return;
                }
                return;
            }
            eVar.j(true, i10);
            return;
        }
        if (bArr.length == 2) {
            gn.g.a("关闭BLE呼吸率测试");
            dn.c cVar4 = this.f24653z;
            if (cVar4 != null) {
                cVar4.a(0, null);
            }
        } else {
            int i21 = bArr[2] & 255;
            int i22 = bArr[3] & 255;
            gn.g.a("结束 breatheValueStatus =" + i21 + ",breatheValue =" + i22);
            if (i21 == 0) {
                i12 = i22;
            }
            cn.d dVar2 = new cn.d();
            String b12 = gn.h.b();
            int f12 = gn.h.f();
            String e11 = gn.h.e(b12, f12);
            dVar2.h(b12);
            dVar2.j(f12);
            dVar2.i(e11);
            dVar2.f(i12);
            dVar2.g(i21);
            dn.c cVar5 = this.f24653z;
            if (cVar5 != null) {
                cVar5.a(1, dVar2);
            }
        }
        en.e eVar4 = this.f24619j;
        if (eVar4 != null) {
            eVar4.j(true, 130);
        }
    }

    private synchronized void b0(List<cn.k> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!TextUtils.isEmpty(list.get(i10).b())) {
                o.b(this.f24603b).x(list.get(i10));
            }
        }
    }

    private boolean c0() {
        return this.f24603b.getApplicationInfo().targetSdkVersion > 30 && Build.VERSION.SDK_INT > 30;
    }

    public static void d() {
        BluetoothGatt bluetoothGatt = f24600m1;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
            f24600m1 = null;
        }
    }

    private int g0(byte[] bArr) {
        return ((bArr[5] << 8) & 65280) | (bArr[6] & 255);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void i0(StringBuilder sb2, byte[] bArr) {
        int i10;
        en.e eVar;
        cn.g gVar;
        if (bArr != null && bArr.length >= 4 && sb2.toString().startsWith("4A4C59")) {
            new cn.g();
            int i11 = bArr[3] & 255;
            if (i11 == 17) {
                gVar = new cn.g();
                gVar.j(bArr[4] & 255);
                gVar.f(bArr[5] & 255);
                gVar.l(bArr[6] & 255);
                gVar.c(bArr[7] & 255);
                eVar = this.f24619j;
                if (eVar != null) {
                    i10 = 138;
                } else {
                    return;
                }
            } else if (i11 == 34) {
                int i12 = bArr[4] & 255;
                gVar = new cn.g();
                gVar.i(i12);
                if (i12 == 1) {
                    gVar.k(bArr[5] & 255);
                } else if (i12 == 2) {
                    gVar.d(bArr[5] & 255);
                    gVar.e(bArr[6] & 255);
                } else if (i12 == 3) {
                    gVar.m(bArr[5] & 255);
                } else {
                    if (i12 == 4) {
                        float m10 = b0.h().m(2, (((bArr[5] << 8) & 65280) | (bArr[6] & 255)) / 100.0f);
                        float m11 = b0.h().m(2, ((bArr[8] & 255) | (65280 & (bArr[7] << 8))) / 100.0f);
                        gVar.a(m10);
                        gVar.b(m11);
                    }
                    eVar = this.f24619j;
                    if (eVar == null) {
                        i10 = 140;
                    } else {
                        return;
                    }
                }
                gVar.g(gn.h.c(0));
                gVar.h(C());
                eVar = this.f24619j;
                if (eVar == null) {
                }
            } else if (i11 == 170) {
                gVar = new cn.g();
                gVar.j(bArr[4] & 255);
                gVar.f(bArr[5] & 255);
                gVar.l(bArr[6] & 255);
                gVar.c(bArr[7] & 255);
                eVar = this.f24619j;
                if (eVar != null) {
                    i10 = 139;
                } else {
                    return;
                }
            } else {
                return;
            }
            eVar.k(true, i10, gVar);
        }
    }

    private synchronized void j0(List<en.m> list) {
        int i10 = 6;
        int i11 = 0;
        while (i11 < list.size()) {
            byte[] f10 = n.d(this.f24603b).f(list.get(i11).c());
            if (f10 != null) {
                int length = f10.length / i10;
                u.d("sleep_data", "data.length =" + f10.length + ",sectionCount =" + length);
                StringBuffer stringBuffer = new StringBuffer();
                int i12 = 0;
                int i13 = 0;
                while (i12 < length) {
                    int i14 = i10 * i12;
                    int i15 = ((f10[i14] & 255) * 60) + (f10[i14 + 1] & 255);
                    int i16 = ((f10[i14 + 4] << 8) & 65280) | (f10[i14 + 5] & 255);
                    int i17 = (i15 + i16) % 1440;
                    int i18 = (f10[i14 + 2] & 255) - 1;
                    if (i12 != 0) {
                        stringBuffer.append(",");
                    }
                    stringBuffer.append("[");
                    stringBuffer.append("\"" + i15 + "\"");
                    stringBuffer.append(",");
                    stringBuffer.append("\"" + i17 + "\"");
                    stringBuffer.append(",");
                    stringBuffer.append("\"" + i18 + "\"");
                    stringBuffer.append("]");
                    if (i16 >= 0) {
                        i13 += i16;
                    }
                    u.d("sleep_data", "startTime =" + i15 + ",endTime =" + i17 + ",duration =" + i16 + ",sleepStatus =" + i18);
                    i12++;
                    i10 = 6;
                }
                String str = "[" + stringBuffer.toString() + "]";
                if (!TextUtils.isEmpty(list.get(i11).a())) {
                    u.d("sleep_data", "统一保存睡眠数据 bandAlgorithmSleepDate =" + list.get(i11).a() + ",sleepTotalTime =" + i13);
                    o.b(this.f24603b).A(list.get(i11).a(), i13, str);
                }
            }
            i11++;
            i10 = 6;
        }
        this.L0.clear();
        this.L0 = new ArrayList();
        this.L0 = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean k0() {
        int i10 = this.f24603b.getApplicationInfo().targetSdkVersion;
        if (c0()) {
            u.d("BluetoothLeService", "Android 12 设备不忙");
            return false;
        }
        BluetoothGatt bluetoothGatt = f24600m1;
        if (bluetoothGatt == null) {
            return false;
        }
        try {
            return ((Boolean) W0(bluetoothGatt, "mDeviceBusy")).booleanValue();
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
            return false;
        } catch (NoSuchFieldException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    private String l(String str) {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        try {
            date = new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT, Locale.US).parse(str);
        } catch (ParseException e10) {
            e10.printStackTrace();
        }
        calendar.setTime(date);
        calendar.set(5, calendar.get(5) - 1);
        return new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT, Locale.US).format(calendar.getTime());
    }

    private void m() {
        if (f24600m1 != null) {
            X0();
        }
    }

    private String m0(byte[] bArr) {
        int i10 = bArr[5] & 255;
        int i11 = bArr[4] & 255;
        int i12 = (bArr[3] & 255) | ((bArr[2] << 8) & 65280);
        String valueOf = String.valueOf(i10);
        String valueOf2 = String.valueOf(i11);
        if (i10 < 10) {
            valueOf = "0" + i10;
        }
        if (i11 < 10) {
            valueOf2 = "0" + i11;
        }
        return i12 + valueOf2 + valueOf;
    }

    static /* synthetic */ int m1(BluetoothLeService bluetoothLeService) {
        int i10 = bluetoothLeService.f24610e1;
        bluetoothLeService.f24610e1 = i10 + 1;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i10) {
        boolean z10;
        String str;
        StringBuilder sb2;
        BluetoothGattService service;
        BluetoothGattService service2;
        BluetoothGatt bluetoothGatt;
        BluetoothGattService service3;
        BluetoothGattService service4;
        BluetoothGattService service5;
        if (i10 != -1) {
            w.e().j(i10);
        }
        if (i10 == 1) {
            BluetoothGatt bluetoothGatt2 = f24600m1;
            if (bluetoothGatt2 != null && (service = bluetoothGatt2.getService(UUID.fromString(c0.f27529e))) != null) {
                z10 = A(f24600m1, service.getCharacteristic(UUID.fromString(c0.f27526b)), true);
                sb2 = new StringBuilder();
                str = "notifySet1 = ";
            } else {
                return;
            }
        } else if (i10 == 2) {
            BluetoothGatt bluetoothGatt3 = f24600m1;
            if (bluetoothGatt3 != null && (service2 = bluetoothGatt3.getService(UUID.fromString(c0.f27530f))) != null) {
                z10 = A(f24600m1, service2.getCharacteristic(UUID.fromString(c0.f27528d)), true);
                sb2 = new StringBuilder();
                str = "notifySet2 = ";
            } else {
                return;
            }
        } else if (i10 != 3) {
            switch (i10) {
                case 11:
                    BluetoothGatt bluetoothGatt4 = f24600m1;
                    if (bluetoothGatt4 != null && (service3 = bluetoothGatt4.getService(UUID.fromString(c0.f27529e))) != null) {
                        z10 = V0(service3.getCharacteristic(UUID.fromString(c0.f27525a)));
                        sb2 = new StringBuilder();
                        str = "notifyRead1 = ";
                        break;
                    } else {
                        return;
                    }
                    break;
                case 12:
                    BluetoothGatt bluetoothGatt5 = f24600m1;
                    if (bluetoothGatt5 != null && (service4 = bluetoothGatt5.getService(UUID.fromString(c0.f27530f))) != null) {
                        z10 = V0(service4.getCharacteristic(UUID.fromString(c0.f27527c)));
                        sb2 = new StringBuilder();
                        str = "notifyRead2 = ";
                        break;
                    } else {
                        return;
                    }
                case 13:
                    BluetoothGatt bluetoothGatt6 = f24600m1;
                    if (bluetoothGatt6 != null && (service5 = bluetoothGatt6.getService(c0.f27541q)) != null) {
                        z10 = V0(service5.getCharacteristic(c0.f27542r));
                        sb2 = new StringBuilder();
                        str = "notifyRead3 = ";
                        break;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        } else {
            BluetoothGatt bluetoothGatt7 = f24600m1;
            if (bluetoothGatt7 != null) {
                for (BluetoothGattService bluetoothGattService : bluetoothGatt7.getServices()) {
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                        if (bluetoothGattCharacteristic.getUuid().equals(c0.f27537m) && (bluetoothGatt = f24600m1) != null) {
                            boolean A = A(bluetoothGatt, bluetoothGattCharacteristic, true);
                            w.g("notifySet3 = " + A);
                        }
                    }
                }
                return;
            }
            return;
        }
        sb2.append(str);
        sb2.append(z10);
        w.g(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        boolean z10;
        BluetoothGatt bluetoothGatt = f24600m1;
        if (bluetoothGatt != null) {
            z10 = bluetoothGatt.discoverServices();
            u.d("BluetoothLeService", "执行了1 isDiscoverServices =" + z10);
        } else {
            z10 = false;
        }
        if (z10) {
            this.f24638r0.sendEmptyMessageDelayed(12, 4000L);
            return;
        }
        Message message = new Message();
        message.what = 11;
        message.arg1 = 2;
        this.f24638r0.sendMessageDelayed(message, 1000L);
    }

    private void o(cn.i iVar) {
        o.b(this.f24603b).w(iVar.b(), iVar.c(), iVar.l(), iVar.d(), iVar.f(), iVar.j(), iVar.h(), iVar.e(), iVar.i(), iVar.m(), iVar.k());
    }

    private void o0(StringBuilder sb2, byte[] bArr) {
        String str;
        en.e eVar;
        int i10;
        dn.e eVar2;
        int i11 = bArr[1] & 255;
        if (i11 != 253) {
            switch (i11) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    this.f24641t.append(sb2.substring(4));
                    dn.e eVar3 = this.T0;
                    if (eVar3 != null) {
                        eVar3.a(true, 171, sb2.substring(4));
                        return;
                    }
                    return;
                case 10:
                    gn.l.d("心电:结束测试");
                    if (bArr[2] == 0) {
                        gn.l.d("心电:结束测试,数据无效,本次数据不保存");
                        dn.e eVar4 = this.T0;
                        if (eVar4 != null) {
                            eVar4.a(false, 170, "");
                        }
                    } else if (bArr[2] == 17) {
                        gn.l.d("心电:结束测试,数据有效");
                        cn.i b10 = gn.l.n(this.f24603b).b(bArr);
                        this.f24643u = b10;
                        cn.i iVar = new cn.i(b10, this.f24641t.toString());
                        if (this.V0) {
                            o(iVar);
                            this.V0 = false;
                        }
                        dn.e eVar5 = this.T0;
                        if (eVar5 != null) {
                            eVar5.a(true, 170, iVar.c());
                        }
                    }
                    this.f24641t = new StringBuilder();
                    return;
                case 11:
                    en.e eVar6 = this.f24619j;
                    if (eVar6 != null) {
                        eVar6.j(true, 164);
                    }
                    this.f24641t = new StringBuilder();
                    if (sb2.substring(4).equals("FFFFFFFFFFFFFFFFFFFFFFFFFF")) {
                        gn.l.d("心电:没有测试数据结果，B2~B14全为0xFF");
                        en.e eVar7 = this.f24619j;
                        if (eVar7 != null) {
                            eVar7.j(true, 165);
                            return;
                        }
                        return;
                    }
                    boolean f10 = gn.l.n(this.f24603b).f(bArr, o.b(this.f24603b).g(" DESC"));
                    gn.l.d("该心电数据是否存在于数据库 resule=" + f10);
                    if (!f10) {
                        this.V0 = true;
                        this.U0 = bArr;
                        this.f24613g.G0();
                        en.e eVar8 = this.f24619j;
                        if (eVar8 != null) {
                            eVar8.j(true, 166);
                            return;
                        }
                        return;
                    }
                    eVar = this.f24619j;
                    if (eVar == null) {
                        return;
                    }
                    eVar.j(true, 165);
                    return;
                default:
                    switch (i11) {
                        case 13:
                            gn.l.d("心电测试过程中，从佩戴变为脱手");
                            eVar2 = this.T0;
                            if (eVar2 != null) {
                                i10 = 172;
                                break;
                            } else {
                                return;
                            }
                        case 14:
                            gn.l.d("心电测试过程中，从脱手变为佩戴");
                            eVar2 = this.T0;
                            if (eVar2 != null) {
                                i10 = 173;
                                break;
                            } else {
                                return;
                            }
                        case 15:
                            gn.l.d("获取心电采样频率");
                            en.e eVar9 = this.f24619j;
                            if (eVar9 != null) {
                                eVar9.j(true, 167);
                            }
                            int i12 = ((bArr[2] << 8) & 65280) | (bArr[3] & 255);
                            int i13 = bArr[4] & 255;
                            gn.l.f27575e = i12 * i13;
                            str = "获取心电采样频率 hz=" + i12 + ",filterTime=" + i13 + ",ecgFilterCnt=" + gn.l.f27575e;
                            gn.l.d(str);
                        case 16:
                            this.V0 = true;
                            gn.l.d("心电:手机控制设备开始测试   mEcgTestStatusListener=" + this.T0);
                            eVar2 = this.T0;
                            if (eVar2 != null) {
                                i10 = 169;
                                break;
                            } else {
                                return;
                            }
                        case 17:
                            int i14 = bArr[2] & 255;
                            gn.l.d("心电实时心率 ecgRate=" + i14 + ",ecgRealTimeRateListener=" + this.f24645v);
                            dn.j jVar = this.f24645v;
                            if (jVar != null) {
                                jVar.a(i14);
                                return;
                            }
                            return;
                        default:
                            switch (i11) {
                                case 48:
                                case 49:
                                case 50:
                                case 51:
                                case 52:
                                case 53:
                                case 54:
                                case 55:
                                case 56:
                                case 57:
                                    en.e eVar10 = this.f24619j;
                                    if (eVar10 != null) {
                                        eVar10.j(true, 164);
                                    }
                                    this.f24641t.append(sb2.substring(4));
                                    for (byte b11 : bArr) {
                                        this.f24639s ^= b11;
                                    }
                                    gn.l.n(this.f24603b).j(sb2.substring(4));
                                    return;
                                default:
                                    return;
                            }
                    }
                    eVar2.a(true, i10, "");
                    return;
            }
        } else if (sb2.toString().length() == 6) {
            gn.l.d("心电同步完成，");
            cn.i a10 = gn.l.n(this.f24603b).a(this.U0);
            this.f24643u = a10;
            if (a10 != null) {
                cn.i iVar2 = new cn.i(a10, this.f24641t.toString());
                if (this.V0) {
                    o(iVar2);
                    this.V0 = false;
                }
                gn.l.d("心电同步完成，并给出检验结果 bleCrc =" + (bArr[2] & 255) + ",tempEcgCRC =" + (this.f24639s & 255));
                this.f24639s = 0;
                eVar = this.f24619j;
                if (eVar == null) {
                    return;
                }
                eVar.j(true, 165);
                return;
            }
            str = "心电无历史数据";
            gn.l.d(str);
        }
    }

    private void p0(List<v> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!TextUtils.isEmpty(list.get(i10).b())) {
                o.b(this.f24603b).C(list.get(i10));
            }
        }
    }

    private void s(String str, StringBuilder sb2, byte[] bArr) {
        if (str.equals("31")) {
            int i10 = bArr[1] & 255;
            if (i10 == 1) {
                if (!TextUtils.isEmpty(this.K0)) {
                    this.M0.g(this.K0);
                    this.L0.add(this.M0);
                    this.K0 = "";
                }
                en.m mVar = new en.m();
                this.M0 = mVar;
                mVar.f(m0(bArr));
                u.d("sleep_data", "mCalendar =" + m0(bArr) + ",bandAlgorithmSleepCount =" + (bArr[6] & 255));
                en.e eVar = this.f24619j;
                if (eVar != null) {
                    eVar.j(true, 4);
                }
            } else if (i10 == 2) {
                if (!TextUtils.isEmpty(this.K0)) {
                    this.M0.g(this.K0);
                    this.L0.add(this.M0);
                    this.K0 = "";
                }
                j0(this.L0);
                en.e eVar2 = this.f24619j;
                if (eVar2 != null) {
                    eVar2.j(true, 5);
                }
                U();
            }
        } else if (str.equals("32")) {
            this.K0 += sb2.substring(2, sb2.toString().length());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str, byte[] bArr) {
        int i10;
        en.e eVar;
        if (str.startsWith("AB")) {
            if (str.startsWith("AB00") && (eVar = this.f24619j) != null) {
                i10 = 152;
            } else {
                return;
            }
        } else if (str.startsWith("DF") && (eVar = this.f24619j) != null) {
            i10 = 153;
        } else {
            return;
        }
        eVar.j(true, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        boolean z10;
        BluetoothGatt bluetoothGatt = f24600m1;
        if (bluetoothGatt != null) {
            z10 = bluetoothGatt.discoverServices();
            u.d("BluetoothLeService", "执行了2 isDiscoverServices =" + z10);
        } else {
            z10 = false;
        }
        if (z10) {
            this.f24638r0.sendEmptyMessageDelayed(12, 4000L);
            return;
        }
        BluetoothGatt bluetoothGatt2 = f24600m1;
        if (bluetoothGatt2 != null) {
            bluetoothGatt2.disconnect();
        }
        X0();
        String w10 = z.v(this.f24603b).w();
        if (w10.equals("00:00:00:00:00:00") || !this.A) {
            this.H0.b0(false);
            sendBroadcast(new Intent("bluetooth.le.ACTION_GATT_FAILURE_daydaybandsdk"));
            en.e eVar = this.f24619j;
            if (eVar != null) {
                eVar.j(true, 19);
                return;
            }
            return;
        }
        V(w10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02fd, code lost:
        if (r1.equals("EEFEE701") != false) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:731:0x0cb0, code lost:
        if (r35.f24622k != false) goto L744;
     */
    /* JADX WARN: Code restructure failed: missing block: B:732:0x0cb3, code lost:
        r1 = 13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:743:0x0d02, code lost:
        if (r35.f24622k != false) goto L744;
     */
    /* JADX WARN: Code restructure failed: missing block: B:744:0x0d04, code lost:
        r1 = 31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(StringBuilder sb2, byte[] bArr) {
        String str;
        String str2;
        boolean z10;
        en.e eVar;
        String str3;
        int i10;
        int i11;
        boolean z11;
        en.e eVar2;
        cn.u uVar;
        int i12;
        int i13;
        int i14;
        boolean z12;
        en.e eVar3;
        int i15;
        int i16;
        int i17;
        boolean z13;
        en.e eVar4;
        StringBuilder sb3;
        int i18;
        List<Integer> list;
        byte b10;
        en.e eVar5;
        int i19;
        int i20;
        int i21;
        String str4;
        String str5;
        int i22;
        int i23;
        Intent intent;
        SharedPreferences.Editor editor;
        String str6;
        Intent intent2;
        en.e eVar6;
        int i24 = 0;
        String substring = sb2.toString().substring(0, 2);
        String substring2 = sb2.toString().length() < 4 ? "" : sb2.toString().substring(0, 4);
        int length = sb2.toString().length();
        if (sb2.length() > 2) {
            str2 = sb2.toString().substring(2, 4);
            str = length == 8 ? sb2.toString().substring(0, length - 2) : "";
        } else {
            str2 = "";
            str = str2;
        }
        if (substring.equals("BF")) {
            this.f24613g.Q0();
            if (length == 4) {
                if (sb2.toString().equals("BFFE")) {
                    en.e eVar7 = this.f24619j;
                    if (eVar7 != null) {
                        eVar7.l(true, 32, null);
                    }
                } else if (sb2.toString().equals("BFFF") && (eVar6 = this.f24619j) != null) {
                    eVar6.l(true, 33, null);
                }
            }
        }
        if (!str2.equals("06") || substring.equals("BF") || substring.equals("C5") || substring.equals("C6") || substring.equals("F6") || substring.equals("D7") || substring.equals("FD") || substring.equals("24")) {
            int i25 = 17;
            if (substring.equals("B1")) {
                this.f24615h.X(bArr, this.f24625l);
                eVar = this.f24619j;
                if (eVar == null) {
                    return;
                }
            } else if (substring.equals("B2")) {
                this.f24615h.W(bArr, substring2, sb2, this.f24625l);
                if (!substring2.equals("B2FD")) {
                    eVar = this.f24619j;
                    if (eVar != null) {
                        z10 = true;
                        i24 = 1;
                        eVar.j(z10, i24);
                    }
                    return;
                }
                U();
                eVar = this.f24619j;
                if (eVar != null) {
                    i24 = 2;
                } else {
                    return;
                }
            } else {
                if (substring.equals("B4")) {
                    eVar = this.f24619j;
                    if (eVar != null) {
                        z10 = true;
                        i24 = 3;
                    } else {
                        return;
                    }
                } else if (substring.equals("B3")) {
                    this.f24615h.U(bArr, substring2, sb2, this.f24627m);
                    if (substring2.equals("B3FD")) {
                        U();
                        eVar = this.f24619j;
                        if (eVar != null) {
                            i24 = 5;
                        } else {
                            return;
                        }
                    } else {
                        eVar = this.f24619j;
                        if (eVar != null) {
                            i24 = 4;
                        } else {
                            return;
                        }
                    }
                } else if (substring.equals("A3")) {
                    boolean z14 = this.f24605c.getBoolean("bluetooth_reboot_success_key", false);
                    boolean E = z.v(this.f24603b).E();
                    this.f24622k = E;
                    if (z14) {
                        sendBroadcast(new Intent("bluetooth_reboot_success_action"));
                        this.f24607d.putBoolean("bluetooth_reboot_success_key", false);
                        this.f24607d.commit();
                        return;
                    } else if (E && gn.q.f27590i && gn.q.f27593l == 1) {
                        i20 = 22;
                        this.f24642t0 = i20;
                        return;
                    } else if (E) {
                        this.f24642t0 = 0;
                        return;
                    } else {
                        eVar = this.f24619j;
                        if (eVar != null) {
                            z10 = true;
                            i24 = 6;
                        } else {
                            return;
                        }
                    }
                } else {
                    if (substring.equals("A1")) {
                        String x10 = this.f24615h.x(sb2.toString());
                        if (this.f24622k) {
                            this.f24642t0 = 1;
                        } else {
                            en.e eVar8 = this.f24619j;
                            if (eVar8 != null) {
                                eVar8.j(true, 7);
                            }
                        }
                        intent = new Intent(gn.q.f27587f);
                        intent.putExtra("get_ble_version", x10);
                    } else if (substring.equals("A9")) {
                        if (this.f24622k) {
                            this.f24642t0 = 2;
                            return;
                        }
                        eVar = this.f24619j;
                        if (eVar != null) {
                            z10 = true;
                            i24 = 8;
                        } else {
                            return;
                        }
                    } else if (substring.equals("EE")) {
                        String sb4 = sb2.toString();
                        int length2 = sb4.length();
                        if (length2 == 4) {
                            if (sb4.equals("EE01")) {
                                intent2 = new Intent("change_device_feature_success_action");
                            } else if (sb4.equals("EE02")) {
                                intent2 = new Intent("change_device_feature_success_action");
                            } else if (sb4.equals("EEFF")) {
                                this.f24613g.r();
                                return;
                            } else if (sb4.equals("EE1F") || sb4.equals("EE2F")) {
                                intent2 = new Intent("device_feature_is_invalid");
                            } else {
                                return;
                            }
                            sendBroadcast(intent2);
                            return;
                        } else if (length2 == 8) {
                            this.f24607d.putString("device_feature_key", sb4);
                            this.f24607d.putBoolean("device_feature_message", false);
                            this.f24607d.putBoolean("device_feature_wechat", false);
                            this.f24607d.putBoolean("device_feature_update", false);
                            this.f24607d.commit();
                            if (sb4.equals("EED20002")) {
                                editor = this.f24607d;
                                str6 = "device_feature_message";
                            } else {
                                if (!sb4.equals("EEFEE702")) {
                                    if (sb4.equals("EED2E702")) {
                                        this.f24607d.putBoolean("device_feature_message", true);
                                    } else if (sb4.equals("EEFEF501")) {
                                        editor = this.f24607d;
                                        str6 = "device_feature_update";
                                    }
                                }
                                editor = this.f24607d;
                                str6 = "device_feature_wechat";
                            }
                            editor.putBoolean(str6, true);
                            this.f24607d.commit();
                            return;
                        } else {
                            return;
                        }
                    } else if (substring.equals("AA")) {
                        if (this.f24622k) {
                            this.f24642t0 = 3;
                        } else {
                            en.e eVar9 = this.f24619j;
                            if (eVar9 != null) {
                                eVar9.j(true, 9);
                            }
                        }
                        this.f24615h.w(bArr);
                        return;
                    } else if (substring.equals("A2")) {
                        int v10 = this.f24615h.v(bArr);
                        Log.i("BluetoothLeService", "read battery=" + v10);
                        z.v(this.f24603b).a0(v10);
                        if (this.f24622k) {
                            this.f24642t0 = 16;
                        } else {
                            en.e eVar10 = this.f24619j;
                            if (eVar10 != null) {
                                eVar10.j(true, 10);
                            }
                        }
                        intent = new Intent(gn.q.f27586e);
                        intent.putExtra("get_ble_battery", v10);
                    } else if (substring.equals("C1")) {
                        int i26 = bArr[1] & 255;
                        if (i26 == 1) {
                            eVar = this.f24619j;
                            if (eVar != null) {
                                z10 = true;
                                i24 = 12;
                            } else {
                                return;
                            }
                        } else if (i26 == 2) {
                            eVar = this.f24619j;
                            if (eVar != null) {
                                z10 = true;
                                i24 = 13;
                            } else {
                                return;
                            }
                        } else if (i26 == 3) {
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i24 = 14;
                            } else {
                                return;
                            }
                        } else if (i26 == 4 && (eVar = this.f24619j) != null) {
                            i24 = 15;
                        } else {
                            return;
                        }
                    } else if (substring.equals("C3")) {
                        int i27 = bArr[1] & 255;
                        if (i27 == 1) {
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i24 = 16;
                            } else {
                                return;
                            }
                        } else if (i27 == 2 && (eVar = this.f24619j) != null) {
                            i24 = 17;
                        } else {
                            return;
                        }
                    } else if (substring.equals("C4")) {
                        int i28 = bArr[1] & 255;
                        if (i28 == 1) {
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i24 = 57;
                            } else {
                                return;
                            }
                        } else if (i28 == 2) {
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i24 = 21;
                            } else {
                                return;
                            }
                        } else if (i28 == 3 && (eVar = this.f24619j) != null) {
                            i24 = 58;
                        } else {
                            return;
                        }
                    } else if (substring.equals("D1")) {
                        switch (bArr[1] & 255) {
                            case 1:
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i24 = 63;
                                    break;
                                } else {
                                    return;
                                }
                            case 2:
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i24 = 59;
                                    break;
                                } else {
                                    return;
                                }
                            case 3:
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i24 = 60;
                                    break;
                                } else {
                                    return;
                                }
                            case 4:
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i24 = 64;
                                    break;
                                } else {
                                    return;
                                }
                            case 5:
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i24 = 61;
                                    break;
                                } else {
                                    return;
                                }
                            case 6:
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i24 = 65;
                                    break;
                                } else {
                                    return;
                                }
                            case 7:
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i24 = 52;
                                    break;
                                } else {
                                    return;
                                }
                            case 8:
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i24 = 53;
                                    break;
                                } else {
                                    return;
                                }
                            case 9:
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i24 = 54;
                                    break;
                                } else {
                                    return;
                                }
                            case 10:
                                eVar = this.f24619j;
                                if (eVar == null) {
                                    return;
                                }
                                if (bArr.length == 2) {
                                    i24 = 62;
                                    break;
                                } else if (bArr.length == 3) {
                                    if ((bArr[2] & 255) == 1) {
                                        i24 = 182;
                                        break;
                                    } else if ((bArr[2] & 255) == 0) {
                                        i24 = 183;
                                        break;
                                    } else {
                                        return;
                                    }
                                } else if (bArr.length == 4) {
                                    if ((bArr[3] & 255) == 0) {
                                        i24 = 184;
                                        break;
                                    } else if ((bArr[3] & 255) == 253) {
                                        i24 = 185;
                                        break;
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            case 11:
                            case 16:
                            default:
                                return;
                            case 12:
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i24 = 128;
                                    break;
                                } else {
                                    return;
                                }
                            case 13:
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i24 = 155;
                                    break;
                                } else {
                                    return;
                                }
                            case 14:
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i24 = 156;
                                    break;
                                } else {
                                    return;
                                }
                            case 15:
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i24 = CameraConfig.CAMERA_THIRD_DEGREE;
                                    break;
                                } else {
                                    return;
                                }
                            case 17:
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i24 = 181;
                                    break;
                                } else {
                                    return;
                                }
                            case 18:
                                if (bArr.length == 3) {
                                    int i29 = bArr[2] & 255;
                                    if (i29 == 0) {
                                        eVar = this.f24619j;
                                        if (eVar != null) {
                                            i24 = 190;
                                            break;
                                        } else {
                                            return;
                                        }
                                    } else if (i29 == 1) {
                                        eVar = this.f24619j;
                                        if (eVar != null) {
                                            i24 = 189;
                                            break;
                                        } else {
                                            return;
                                        }
                                    } else if (i29 == 2 && (eVar = this.f24619j) != null) {
                                        i24 = 188;
                                        break;
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                                break;
                        }
                    } else if (substring.equals("D3")) {
                        int i30 = bArr[1] & 255;
                        if (i30 == 0) {
                            if (!this.f24622k) {
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i24 = 26;
                                } else {
                                    return;
                                }
                            }
                            this.f24642t0 = i25;
                            return;
                        } else if (i30 == 1) {
                            if (this.f24622k) {
                                i20 = 23;
                                this.f24642t0 = i20;
                                return;
                            }
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i24 = 25;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } else if (substring.equals("D4")) {
                        int i31 = bArr[1] & 255;
                        if (i31 == 0) {
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i24 = 151;
                            } else {
                                return;
                            }
                        } else if (i31 == 1 && (eVar = this.f24619j) != null) {
                            i24 = 150;
                        } else {
                            return;
                        }
                    } else if (substring.equals("E5")) {
                        if (substring2.equals("E5FD")) {
                            eVar = this.f24619j;
                            if (eVar != null) {
                                z10 = true;
                                i24 = 24;
                            } else {
                                return;
                            }
                        } else if (sb2.toString().equals("E511")) {
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i24 = 79;
                            } else {
                                return;
                            }
                        } else {
                            if (sb2.toString().equals("E500")) {
                                eVar = this.f24619j;
                                if (eVar == null) {
                                    return;
                                }
                            } else if (sb2.toString().length() != 8 || !sb2.toString().startsWith("E500") || sb2.toString().startsWith("E50000")) {
                                this.f24615h.P(bArr);
                                return;
                            } else {
                                eVar = this.f24619j;
                                if (eVar == null) {
                                    return;
                                }
                            }
                            i24 = 80;
                        }
                    } else if (substring.equals("E6")) {
                        if (substring2.equals("E6FD")) {
                            U();
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i24 = 23;
                            } else {
                                return;
                            }
                        } else {
                            this.f24615h.O(bArr);
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i24 = 22;
                            } else {
                                return;
                            }
                        }
                    } else if (substring.equals("F7")) {
                        if (substring2.equals("F7FD")) {
                            U();
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i24 = 82;
                            } else {
                                return;
                            }
                        } else if (substring2.equals("F701")) {
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i24 = 175;
                            } else {
                                return;
                            }
                        } else if (substring2.equals("F702")) {
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i24 = 176;
                            } else {
                                return;
                            }
                        } else if (substring2.equals("F703")) {
                            this.f24615h.N(bArr);
                            return;
                        } else if (substring2.equals("F704")) {
                            this.f24615h.L(bArr);
                            return;
                        } else {
                            this.f24615h.M(bArr);
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i24 = 81;
                            } else {
                                return;
                            }
                        }
                    } else if (substring.equals("AB")) {
                        int i32 = bArr[1] & 255;
                        if (i32 != 1) {
                            if (i32 != 2) {
                                if (i32 == 3) {
                                    if (this.f24622k) {
                                        i20 = 21;
                                        this.f24642t0 = i20;
                                        return;
                                    }
                                    eVar = this.f24619j;
                                    if (eVar != null) {
                                        i24 = 31;
                                    } else {
                                        return;
                                    }
                                } else {
                                    return;
                                }
                            } else if (this.f24622k) {
                                i20 = 20;
                                this.f24642t0 = i20;
                                return;
                            } else {
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i24 = 30;
                                } else {
                                    return;
                                }
                            }
                        } else if (this.f24622k) {
                            i20 = 19;
                            this.f24642t0 = i20;
                            return;
                        } else {
                            eVar = this.f24619j;
                            if (eVar != null) {
                                i24 = 29;
                            } else {
                                return;
                            }
                        }
                    } else {
                        i25 = 18;
                        if (substring.equals("A0")) {
                            int i33 = bArr[1] & 255;
                            if (i33 == 1 || i33 == 2) {
                                if (!this.f24622k) {
                                    eVar = this.f24619j;
                                    if (eVar != null) {
                                        i24 = 27;
                                    } else {
                                        return;
                                    }
                                }
                                this.f24642t0 = i25;
                                return;
                            }
                            return;
                        } else if (substring.equals("BA")) {
                            if ((bArr[1] & 255) == 1) {
                                this.f24615h.z(bArr);
                                if (!this.f24622k) {
                                    eVar = this.f24619j;
                                    if (eVar != null) {
                                        i24 = 35;
                                    } else {
                                        return;
                                    }
                                }
                                i20 = 24;
                                this.f24642t0 = i20;
                                return;
                            }
                            return;
                        } else if (!substring.equals("BB")) {
                            if (substring.equals("C5")) {
                                if (sb2.toString().length() >= 4) {
                                    String substring3 = sb2.toString().substring(2, 4);
                                    if (substring3.equals("FD")) {
                                        if (this.f24622k) {
                                            int i34 = bArr[2] & 255;
                                            if (i34 == 0) {
                                                this.f24642t0 = 8;
                                                str3 = "C5FD";
                                            } else {
                                                i23 = (i34 != 3 || !p.g(this.f24603b, 2048)) ? 9 : 35;
                                            }
                                        } else {
                                            int i35 = bArr[2] & 255;
                                            if (i35 == 0) {
                                                this.f24646v0 = 1;
                                            } else if (i35 == 3) {
                                                this.f24646v0 = 6;
                                            } else {
                                                this.f24646v0 = 2;
                                            }
                                            this.f24638r0.postDelayed(this.f24650x0, 20L);
                                            i23 = -1;
                                        }
                                        this.f24642t0 = i23;
                                        str3 = "C5FD";
                                    } else if (substring3.equals("FF")) {
                                        if (this.f24622k) {
                                            this.f24642t0 = 15;
                                        } else {
                                            this.f24646v0 = 5;
                                            this.f24638r0.postDelayed(this.f24650x0, 20L);
                                        }
                                        str3 = "C5FF";
                                    } else {
                                        if (this.f24622k) {
                                            this.f24642t0 = 13;
                                        } else {
                                            this.f24646v0 = 4;
                                            this.f24638r0.postDelayed(this.f24650x0, 20L);
                                        }
                                        str3 = "C5序号";
                                    }
                                } else {
                                    return;
                                }
                            } else if (!substring.equals("C6")) {
                                if (substring.equals("D5")) {
                                    int i36 = bArr[1] & 255;
                                    u.a("CustomPasswordDialog", "mRssiHandler =" + this.f24609e);
                                    if (i36 == 255) {
                                        u.a("CustomPasswordDialog", "表示验证失败或者设置密码失败，并且蓝牙端自动断开，需要重新验证密码。");
                                        eVar = this.f24619j;
                                        if (eVar != null) {
                                            i24 = 43;
                                        } else {
                                            return;
                                        }
                                    } else if (i36 == 2) {
                                        u.a("CustomPasswordDialog", "表示蓝牙端为初始化状态，需要第一次设置密码，弹出对话框设置密码 ");
                                        eVar = this.f24619j;
                                        if (eVar != null) {
                                            i24 = 40;
                                        } else {
                                            return;
                                        }
                                    } else if (i36 == 3) {
                                        u.a("CustomPasswordDialog", "表示蓝牙端已经设置过密码，需要输入密码验证，弹出对话框输入4位密码");
                                        eVar = this.f24619j;
                                        if (eVar != null) {
                                            i24 = 41;
                                        } else {
                                            return;
                                        }
                                    } else if (i36 == 4) {
                                        u.a("CustomPasswordDialog", "表示验证成功或者设置密码成功,开始同步时间");
                                        eVar = this.f24619j;
                                        if (eVar != null) {
                                            i24 = 42;
                                        } else {
                                            return;
                                        }
                                    } else {
                                        return;
                                    }
                                } else if (substring.equals("C7")) {
                                    u.d("stringBuilder", "C7--recevice=" + substring2);
                                    if (substring2.equals("C7FD")) {
                                        eVar = this.f24619j;
                                        if (eVar != null) {
                                            i24 = 48;
                                        } else {
                                            return;
                                        }
                                    } else if (substring2.equals("C711")) {
                                        eVar = this.f24619j;
                                        if (eVar != null) {
                                            i24 = 50;
                                        } else {
                                            return;
                                        }
                                    } else if (substring2.equals("C7FF")) {
                                        eVar = this.f24619j;
                                        if (eVar != null) {
                                            i24 = 49;
                                        } else {
                                            return;
                                        }
                                    } else {
                                        if (substring2.equals("C700") && sb2.toString().length() == 4) {
                                            eVar = this.f24619j;
                                            if (eVar == null) {
                                                return;
                                            }
                                        } else if (sb2.toString().startsWith("C70000")) {
                                            this.f24615h.l(bArr);
                                            return;
                                        } else {
                                            eVar = this.f24619j;
                                            if (eVar == null) {
                                                return;
                                            }
                                        }
                                        i24 = 91;
                                    }
                                } else if (substring.equals("C8")) {
                                    if (substring2.equals("C8FD")) {
                                        U();
                                        eVar = this.f24619j;
                                        if (eVar != null) {
                                            i24 = 47;
                                        } else {
                                            return;
                                        }
                                    } else {
                                        en.e eVar11 = this.f24619j;
                                        if (eVar11 != null) {
                                            eVar11.j(true, 46);
                                        }
                                        this.f24615h.k(bArr);
                                        return;
                                    }
                                } else if (substring.equals("D9")) {
                                    int i37 = bArr[1] & 255;
                                    int i38 = bArr[2] & 255;
                                    int length3 = sb2.toString().length();
                                    if (length3 != 8 || !sb2.toString().substring(length3 - 2, length3).equals("FD")) {
                                        String substring4 = sb2.toString().substring(6, length3);
                                        en.e eVar12 = this.f24619j;
                                        if (eVar12 != null) {
                                            eVar12.f(true, i37, i38, substring4);
                                            return;
                                        }
                                        return;
                                    }
                                    en.e eVar13 = this.f24619j;
                                    if (eVar13 != null) {
                                        eVar13.f(false, i37, i38, "");
                                        return;
                                    }
                                    return;
                                } else if (substring.equals("DE")) {
                                    int length4 = sb2.toString().length();
                                    if (length4 == 8) {
                                        int i39 = bArr[1] & 255;
                                        int i40 = bArr[2] & 255;
                                        int i41 = bArr[3] & 255;
                                        en.e eVar14 = this.f24619j;
                                        if (eVar14 != null) {
                                            eVar14.c(true, i39, i40, i41);
                                            return;
                                        }
                                        return;
                                    } else if (length4 == 6) {
                                        int i42 = bArr[1] & 255;
                                        int i43 = bArr[2] & 255;
                                        en.e eVar15 = this.f24619j;
                                        if (eVar15 != null) {
                                            eVar15.m(true, i42, i43);
                                            return;
                                        }
                                        return;
                                    } else {
                                        return;
                                    }
                                } else if (substring.equals("CB")) {
                                    int i44 = bArr[1] & 255;
                                    u.a("sendTextKey", "sevenDayWeatherNo =" + i44 + ",isRKPlatform =" + this.f24622k + ",sevenDayWeatherNo=" + i44);
                                    if (this.f24622k) {
                                        if (i44 < 3 && i44 > 0) {
                                            this.f24613g.f26223w = i44;
                                            i20 = 26;
                                            this.f24642t0 = i20;
                                            return;
                                        } else if (i44 != 3 || (eVar = this.f24619j) == null) {
                                            return;
                                        }
                                    } else if (i44 < 3 && i44 > 0) {
                                        this.f24613g.f26223w = i44;
                                        i21 = 8;
                                        this.f24646v0 = i21;
                                        this.f24638r0.postDelayed(this.f24650x0, 20L);
                                        return;
                                    } else if (i44 != 3 || (eVar = this.f24619j) == null) {
                                        return;
                                    }
                                    i24 = 51;
                                } else if (substring.equals("CA")) {
                                    eVar = this.f24619j;
                                    if (eVar != null) {
                                        i24 = 73;
                                    } else {
                                        return;
                                    }
                                } else if (substring.equals("B7")) {
                                    u.a("BluetoothLeService", "endPoint =" + substring2);
                                    if (!substring2.equals("B7FD")) {
                                        en.e eVar16 = this.f24619j;
                                        if (eVar16 != null) {
                                            eVar16.j(true, 44);
                                        }
                                        this.f24615h.Y(bArr, substring2);
                                        return;
                                    }
                                    U();
                                    eVar = this.f24619j;
                                    if (eVar != null) {
                                        i24 = 45;
                                    } else {
                                        return;
                                    }
                                } else if (substring.equals("B9")) {
                                    if (!substring2.equals("B9FD")) {
                                        this.f24615h.T(bArr, substring2);
                                        eVar = this.f24619j;
                                        if (eVar != null) {
                                            i24 = 55;
                                        } else {
                                            return;
                                        }
                                    } else {
                                        U();
                                        en.e eVar17 = this.f24619j;
                                        if (eVar17 != null) {
                                            eVar17.j(true, 56);
                                        }
                                        u.a("stringBuilder", "同步跳绳完成");
                                        return;
                                    }
                                } else if (substring.equals("BC")) {
                                    return;
                                } else {
                                    if (substring.equals("CC")) {
                                        String X = X(bArr);
                                        int g02 = g0(bArr);
                                        en.e eVar18 = this.f24619j;
                                        if (eVar18 != null) {
                                            eVar18.b(true, X, g02, 1);
                                            return;
                                        }
                                        return;
                                    } else if (substring.equals("CD")) {
                                        if (!substring2.equals("CDFD")) {
                                            String X2 = X(bArr);
                                            int g03 = g0(bArr);
                                            en.e eVar19 = this.f24619j;
                                            if (eVar19 != null) {
                                                eVar19.b(true, X2, g03, 2);
                                                return;
                                            }
                                            return;
                                        }
                                        return;
                                    } else if (substring.equals("F6")) {
                                        u0(sb2, bArr);
                                        return;
                                    } else if (substring.equals("F5")) {
                                        R0(bArr);
                                        return;
                                    } else if (substring.equals("F3")) {
                                        if (!substring2.equals("F3FD")) {
                                            this.f24615h.Q(bArr, substring2);
                                            eVar = this.f24619j;
                                            if (eVar != null) {
                                                i24 = 74;
                                            } else {
                                                return;
                                            }
                                        } else {
                                            u.d("stringBuilder", "同步骑行完成");
                                            U();
                                            eVar = this.f24619j;
                                            if (eVar != null) {
                                                i24 = 75;
                                            } else {
                                                return;
                                            }
                                        }
                                    } else if (substring.equals("F4")) {
                                        if (substring2.equals("F4FD")) {
                                            u.d("stringBuilder", "同步球类运动完成");
                                            U();
                                            eVar = this.f24619j;
                                            if (eVar != null) {
                                                i24 = 77;
                                            } else {
                                                return;
                                            }
                                        } else if (sb2.length() == 32 || bArr.length == 16) {
                                            this.f24615h.V(bArr);
                                            eVar = this.f24619j;
                                            if (eVar != null) {
                                                i24 = 76;
                                            } else {
                                                return;
                                            }
                                        } else {
                                            return;
                                        }
                                    } else if (substring.equals("FB")) {
                                        int i45 = bArr[1] & 255;
                                        if (i45 == 0) {
                                            str5 = "心率检测校准结束";
                                        } else if (i45 == 1) {
                                            str5 = "心率检测校准开始";
                                        } else if (i45 == 253) {
                                            str5 = "清除心率检测校准";
                                        } else {
                                            return;
                                        }
                                        u.d("RateCalibration", str5);
                                        this.f24654z0.a(i45);
                                        return;
                                    } else if (substring.equals("FC")) {
                                        int i46 = bArr[1] & 255;
                                        if (i46 == 0) {
                                            str4 = "抬手亮屏校准结束";
                                        } else if (i46 == 1) {
                                            str4 = "抬手亮屏校准开始";
                                        } else if (i46 == 253) {
                                            str4 = "清除抬手亮屏校准参数";
                                        } else if (i46 == 255) {
                                            str4 = "抬手亮屏校准失败";
                                        } else {
                                            return;
                                        }
                                        u.d("RateCalibration", str4);
                                        this.A0.a(i46);
                                        return;
                                    } else if (substring.equals("AF")) {
                                        int i47 = bArr[1] & 255;
                                        if (substring2.equals("AFAA")) {
                                            Log.i("languageKey", "查询设备语言时返回语言编号 =" + (bArr[2] & 255));
                                            int length5 = sb2.toString().length();
                                            if (length5 == 40) {
                                                int i48 = length5 - 6;
                                                String substring5 = sb2.toString().substring(i48, length5);
                                                String substring6 = sb2.toString().substring(length5 - 12, i48);
                                                int i49 = length - 18;
                                                String substring7 = sb2.toString().substring(i49, length - 12);
                                                int i50 = length - 24;
                                                String substring8 = sb2.toString().substring(i50, i49);
                                                String substring9 = sb2.toString().substring(length - 30, i50);
                                                int e10 = n.d(this.f24603b).e(substring5);
                                                int e11 = n.d(this.f24603b).e(substring6);
                                                int e12 = n.d(this.f24603b).e(substring7);
                                                int e13 = n.d(this.f24603b).e(substring8);
                                                int e14 = n.d(this.f24603b).e(substring9);
                                                Log.i("languageKey", "查询设备语言时返回语言编号 display1 =" + e10 + ",display2 =" + e11);
                                                z.v(this.f24603b).N(e10);
                                                z.v(this.f24603b).O(e11);
                                                z.v(this.f24603b).P(e12);
                                                z.v(this.f24603b).Q(e13);
                                                z.v(this.f24603b).R(e14);
                                            }
                                            z.v(this.f24603b).K(bArr[2] & 255);
                                            eVar = this.f24619j;
                                            if (eVar != null) {
                                                i24 = 147;
                                            } else {
                                                return;
                                            }
                                        } else if (substring2.equals("AFAB")) {
                                            eVar = this.f24619j;
                                            if (eVar != null) {
                                                i24 = 78;
                                            } else {
                                                return;
                                            }
                                        } else if (i47 == 253) {
                                            this.f24648w0 = bArr[2] & 255;
                                            u.d("languageKey", "AFFD结束  界面编号currentBandPage =" + this.f24648w0);
                                        } else if (i47 == 255) {
                                            u.d("languageKey", "1接收数据失败或数据不对则返回值0xAFFF。重发 currentBandPage =" + this.f24648w0);
                                            if (this.f24622k) {
                                                i20 = 32;
                                                this.f24642t0 = i20;
                                                return;
                                            }
                                            i21 = 14;
                                            this.f24646v0 = i21;
                                            this.f24638r0.postDelayed(this.f24650x0, 20L);
                                            return;
                                        } else if (bArr.length == 3 && (bArr[2] & 255) == 255) {
                                            this.f24648w0 = bArr[1] & 255;
                                            u.d("languageKey", "手环界面不存在，BLE直接返回：0xAF+手环界面编号+0xFF  currentBandPage =" + this.f24648w0);
                                        } else {
                                            u.d("languageKey", "AF序号 =" + (bArr[1] & 255));
                                            if (this.f24622k) {
                                                i20 = 30;
                                                this.f24642t0 = i20;
                                                return;
                                            }
                                            i21 = 12;
                                            this.f24646v0 = i21;
                                            this.f24638r0.postDelayed(this.f24650x0, 20L);
                                            return;
                                        }
                                    } else if (substring.equals("F9")) {
                                        dn.b bVar = this.B0;
                                        if (bVar != null) {
                                            bVar.a(sb2, bArr);
                                            return;
                                        }
                                        return;
                                    } else {
                                        if (substring.equals("F1")) {
                                            if ((bArr[1] & 255) != 250) {
                                                en.e eVar20 = this.f24619j;
                                                if (eVar20 != null) {
                                                    eVar20.l(false, 83, null);
                                                    return;
                                                }
                                                return;
                                            }
                                            eVar5 = this.f24619j;
                                            if (eVar5 != null) {
                                                i19 = 83;
                                            } else {
                                                return;
                                            }
                                        } else if (substring.equals("D7")) {
                                            int i51 = bArr.length > 6 ? 255 & bArr[6] : 0;
                                            if (i51 != 0) {
                                                if (i51 != 1) {
                                                    return;
                                                }
                                                if (this.f24622k) {
                                                    this.f24644u0 = bArr;
                                                    i20 = 34;
                                                } else {
                                                    en.e eVar21 = this.f24619j;
                                                    if (eVar21 != null) {
                                                        eVar21.l(true, 84, bArr);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else if (this.f24622k) {
                                                this.f24644u0 = bArr;
                                                i20 = 33;
                                            } else {
                                                eVar5 = this.f24619j;
                                                if (eVar5 != null) {
                                                    i19 = 85;
                                                } else {
                                                    return;
                                                }
                                            }
                                            this.f24642t0 = i20;
                                            return;
                                        } else if (substring.equals("FD")) {
                                            gn.v.a("isSportsModesSyncing =" + this.G + ",mICallback=" + this.f24619j);
                                            gn.v w10 = gn.v.w(this.f24603b);
                                            if ((bArr.length == 4 || bArr.length == 13) && !this.G && (bArr[1] & 255) != 119) {
                                                int i52 = bArr[1] & 255;
                                                if (i52 == 0) {
                                                    en.e eVar22 = this.f24619j;
                                                    if (eVar22 != null) {
                                                        eVar22.i(true, 86, 0, bArr[2] & 255, null);
                                                    }
                                                    sb3 = new StringBuilder();
                                                    sb3.append("控制关闭 =");
                                                    b10 = bArr[2];
                                                } else if (i52 != 17) {
                                                    if (i52 == 34) {
                                                        gn.v.a("运动暂停 =" + (bArr[2] & 255));
                                                        eVar4 = this.f24619j;
                                                        if (eVar4 != null) {
                                                            i15 = bArr[2] & 255;
                                                            z13 = true;
                                                            i17 = 86;
                                                            i16 = 2;
                                                        } else {
                                                            return;
                                                        }
                                                    } else if (i52 == 51) {
                                                        gn.v.a("运动继续 =" + (bArr[2] & 255));
                                                        eVar4 = this.f24619j;
                                                        if (eVar4 != null) {
                                                            i15 = bArr[2] & 255;
                                                            z13 = true;
                                                            i17 = 86;
                                                            i16 = 3;
                                                        } else {
                                                            return;
                                                        }
                                                    } else if (i52 == 68) {
                                                        gn.v.a("实时运动 =" + (bArr[2] & 255));
                                                        eVar4 = this.f24619j;
                                                        if (eVar4 != null) {
                                                            i15 = bArr[2] & 255;
                                                            z13 = true;
                                                            i17 = 86;
                                                            i16 = 4;
                                                        } else {
                                                            return;
                                                        }
                                                    } else if (i52 != 170) {
                                                        return;
                                                    } else {
                                                        if (bArr[2] == 17) {
                                                            en.e eVar23 = this.f24619j;
                                                            if (eVar23 != null) {
                                                                eVar23.i(true, 87, 1, bArr[3] & 255, null);
                                                            }
                                                            sb3 = new StringBuilder();
                                                            sb3.append("查询开 =");
                                                            b10 = bArr[3];
                                                        } else if (bArr[2] == 0) {
                                                            en.e eVar24 = this.f24619j;
                                                            if (eVar24 != null) {
                                                                eVar24.i(true, 87, 0, bArr[3] & 255, null);
                                                            }
                                                            sb3 = new StringBuilder();
                                                            sb3.append("查询关 =");
                                                            b10 = bArr[3];
                                                        } else if (bArr[2] == 34) {
                                                            gn.v.a("查询暂停 =" + (bArr[3] & 255));
                                                            eVar3 = this.f24619j;
                                                            if (eVar3 != null) {
                                                                i12 = bArr[3] & 255;
                                                                z12 = true;
                                                                i14 = 87;
                                                                i13 = 2;
                                                                uVar = null;
                                                                eVar3.i(z12, i14, i13, i12, uVar);
                                                                return;
                                                            }
                                                            return;
                                                        } else {
                                                            return;
                                                        }
                                                    }
                                                    eVar4.i(z13, i17, i16, i15, null);
                                                    return;
                                                } else {
                                                    en.e eVar25 = this.f24619j;
                                                    if (eVar25 != null) {
                                                        eVar25.i(true, 86, 1, bArr[2] & 255, null);
                                                    }
                                                    sb3 = new StringBuilder();
                                                    sb3.append("控制打开 =");
                                                    b10 = bArr[2];
                                                }
                                                i18 = b10 & 255;
                                            } else if (bArr.length == 3 && (bArr[1] & 255) == 253) {
                                                if ((bArr[1] & 255) == 253) {
                                                    gn.v.a("结束字段 currentSportsModes =" + this.I + ",sportsModesList.length =" + this.f24620j0.length);
                                                    this.G = false;
                                                    if (this.L.contains("00000000000") || this.M.contains("00000000000")) {
                                                        gn.v.a("数据为0  return");
                                                        en.e eVar26 = this.f24619j;
                                                        if (eVar26 != null) {
                                                            eVar26.i(true, 88, 0, this.I, null);
                                                            return;
                                                        }
                                                        return;
                                                    }
                                                    String y10 = w10.y(this.f24620j0);
                                                    gn.v.a("完成 bleAllRate =" + y10);
                                                    o.b(this.f24603b).B(new cn.u(this.I, this.J, this.K, this.L, this.M, this.N, this.O, this.P, this.Q, this.R, this.S, this.T, this.U, this.V, this.W * 10, y10));
                                                    byte[] f10 = n.d(this.f24603b).f(y10);
                                                    if (f10 != null) {
                                                        for (int i53 = 0; i53 < f10.length; i53++) {
                                                            gn.v.a("心率值 =" + (f10[i53] & 255));
                                                        }
                                                    } else {
                                                        gn.v.a("数据为空了 !!!");
                                                    }
                                                    en.e eVar27 = this.f24619j;
                                                    if (eVar27 != null) {
                                                        eVar27.i(true, 88, 0, this.I, null);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            } else if (bArr.length == 10 && (bArr[1] & 255) == 250) {
                                                en.e eVar28 = this.f24619j;
                                                if (eVar28 != null) {
                                                    eVar28.i(true, 90, 0, w10.D(bArr), null);
                                                    return;
                                                }
                                                return;
                                            } else if ((bArr[1] & 255) == 85) {
                                                if ((bArr[2] & 255) == 253) {
                                                    eVar4 = this.f24619j;
                                                    if (eVar4 != null) {
                                                        z13 = true;
                                                        i17 = 177;
                                                        i16 = 0;
                                                        i15 = 0;
                                                        eVar4.i(z13, i17, i16, i15, null);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                if (this.f24622k) {
                                                    this.f24642t0 = 40;
                                                } else {
                                                    this.f24646v0 = 18;
                                                    this.f24638r0.postDelayed(this.f24650x0, 20L);
                                                }
                                                sb3 = new StringBuilder();
                                                sb3.append("FD55序号 ");
                                                b10 = bArr[2];
                                                i18 = b10 & 255;
                                            } else if ((bArr[1] & 255) == 102) {
                                                int i54 = 255 & bArr[2];
                                                if (i54 == 0) {
                                                    int length6 = sb2.toString().length();
                                                    if (length6 == 40) {
                                                        int i55 = length6 - 6;
                                                        String substring10 = sb2.toString().substring(i55, length6);
                                                        String substring11 = sb2.toString().substring(length6 - 12, i55);
                                                        int i56 = length - 18;
                                                        String substring12 = sb2.toString().substring(i56, length - 12);
                                                        int i57 = length - 24;
                                                        String substring13 = sb2.toString().substring(i57, i56);
                                                        String substring14 = sb2.toString().substring(length - 30, i57);
                                                        int e15 = n.d(this.f24603b).e(substring10);
                                                        int e16 = n.d(this.f24603b).e(substring11);
                                                        int e17 = n.d(this.f24603b).e(substring12);
                                                        int e18 = n.d(this.f24603b).e(substring13);
                                                        int e19 = n.d(this.f24603b).e(substring14);
                                                        gn.v.a("查询手环支持的运动列表 = " + sb2.toString() + ",sb1 =" + substring10 + ",sb2 =" + substring11 + ",sb3 =" + substring12 + ",sb4 =" + substring13 + ",sb5 =" + substring14 + ",display1 =" + e15 + ",display2 =" + e16 + ",display3 =" + e17 + ",display4 =" + e18 + ",display5 =" + e19);
                                                        z.v(this.f24603b).V(e15);
                                                        z.v(this.f24603b).W(e16);
                                                        z.v(this.f24603b).X(e17);
                                                        z.v(this.f24603b).Y(e18);
                                                        z.v(this.f24603b).Z(e19);
                                                        return;
                                                    }
                                                    return;
                                                } else if (i54 == 170) {
                                                    this.f24628m0 = w10.v(bArr);
                                                    this.f24630n0 = w10.u(bArr);
                                                    this.f24632o0 = w10.x(bArr);
                                                    z.v(this.f24603b).M(this.f24628m0);
                                                    z.v(this.f24603b).L(this.f24630n0);
                                                    z.v(this.f24603b).U(this.f24632o0);
                                                    sb3 = new StringBuilder();
                                                    sb3.append("手环显示运动个数 min =");
                                                    sb3.append(this.f24628m0);
                                                    sb3.append(",max=");
                                                    sb3.append(this.f24630n0);
                                                    sb3.append(",supportMax=");
                                                    i18 = this.f24632o0;
                                                } else if (i54 == 253) {
                                                    gn.v.a("FD66 指令结束" + sb2.toString());
                                                    uVar = new cn.u(new t(this.f24628m0, this.f24630n0, this.f24632o0));
                                                    eVar3 = this.f24619j;
                                                    if (eVar3 != null) {
                                                        z12 = true;
                                                        i14 = 178;
                                                        i13 = 0;
                                                        i12 = 0;
                                                        eVar3.i(z12, i14, i13, i12, uVar);
                                                        return;
                                                    }
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else if ((bArr[1] & 255) == 119) {
                                                int i58 = 255 & bArr[2];
                                                if (i58 == 0) {
                                                    list = w10.t(bArr, true);
                                                } else if (i58 != 253) {
                                                    list = w10.t(bArr, false);
                                                } else {
                                                    gn.v.a("FD77 指令结束 " + sb2.toString());
                                                    cn.u uVar2 = new cn.u(new t(this.f24626l0));
                                                    en.e eVar29 = this.f24619j;
                                                    if (eVar29 != null) {
                                                        eVar29.i(true, 179, 0, 0, uVar2);
                                                    }
                                                    this.f24626l0 = new ArrayList();
                                                    return;
                                                }
                                                this.f24626l0.addAll(list);
                                                return;
                                            } else {
                                                int A = w10.A(bArr);
                                                this.H = A;
                                                if (A == 0) {
                                                    this.G = true;
                                                    this.I = w10.q(bArr);
                                                    this.J = w10.z(bArr);
                                                    this.K = w10.B(bArr);
                                                    this.L = w10.C(bArr);
                                                    this.M = w10.s(bArr, sb2.toString());
                                                    this.N = w10.E(bArr, sb2.toString());
                                                    int i59 = this.J;
                                                    this.f24620j0 = new String[i59 % 17 == 0 ? i59 / 17 : (i59 / 17) + 1];
                                                    sb3 = new StringBuilder();
                                                    sb3.append("serialNumber =");
                                                    sb3.append(this.H);
                                                    sb3.append(",currentSportsModes =");
                                                    sb3.append(this.I);
                                                    sb3.append(",sportsModesRateCount =");
                                                    sb3.append(this.J);
                                                    sb3.append(",startDateTime =");
                                                    sb3.append(this.L);
                                                    sb3.append(",endDateTime =");
                                                    sb3.append(this.M);
                                                    sb3.append(",validExerciseTime=");
                                                    sb3.append(this.N);
                                                    sb3.append(",sportsModescalendar=");
                                                    sb3.append(this.K);
                                                    gn.v.a(sb3.toString());
                                                    return;
                                                } else if (A == 1) {
                                                    this.O = w10.n(bArr);
                                                    this.P = w10.j(bArr);
                                                    this.Q = w10.h(bArr);
                                                    this.R = w10.l(bArr);
                                                    this.S = w10.d(bArr);
                                                    this.T = w10.e(bArr);
                                                    this.U = w10.f(bArr);
                                                    this.V = w10.b(bArr);
                                                    this.W = w10.p(bArr);
                                                    sb3 = new StringBuilder();
                                                    sb3.append("bleStepCount =");
                                                    sb3.append(this.O);
                                                    sb3.append(",bleSportsCount =");
                                                    sb3.append(this.P);
                                                    sb3.append(",bleSportsCalories =");
                                                    sb3.append(this.Q);
                                                    sb3.append(",bleSportsDistance =");
                                                    sb3.append(this.R);
                                                    sb3.append(",bleAverageRate =");
                                                    sb3.append(this.S);
                                                    sb3.append(",bleMaxRate =");
                                                    sb3.append(this.T);
                                                    sb3.append(",bleMinRate =");
                                                    sb3.append(this.U);
                                                    sb3.append(",bleAveragePace =");
                                                    sb3.append(this.V);
                                                    sb3.append(",bleTimeInterval =");
                                                    i18 = this.W;
                                                } else {
                                                    boolean z15 = this.G;
                                                    if (z15) {
                                                        gn.v.a("同步中间字段 serialNumber =" + this.H + ",," + sb2.toString().substring(6));
                                                        this.f24620j0[this.H - 2] = sb2.toString().substring(6);
                                                        return;
                                                    } else if (!z15 && bArr.length == 14) {
                                                        gn.v.a("实时数据 stringBuilder =" + ((Object) sb2));
                                                        this.I = w10.r(bArr);
                                                        this.f24623k0 = w10.g(bArr);
                                                        this.Q = w10.i(bArr);
                                                        this.V = w10.c(bArr);
                                                        this.O = w10.o(bArr);
                                                        this.P = w10.k(bArr);
                                                        float m10 = w10.m(bArr);
                                                        this.R = m10;
                                                        cn.u uVar3 = new cn.u(this.I, this.f24623k0, this.Q, this.V, this.O, this.P, m10);
                                                        gn.v.a("实时数据  currentSportsModes =" + this.I + ",bleRateReal =" + this.f24623k0 + ",bleSportsCalories =" + this.Q + ",bleAveragePace =" + this.V + ",bleStepCount =" + this.O + ",bleSportsCount =" + this.P + ",bleSportsDistance =" + this.R);
                                                        en.e eVar30 = this.f24619j;
                                                        if (eVar30 != null) {
                                                            eVar30.i(true, 89, 1, this.I, uVar3);
                                                            return;
                                                        }
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                }
                                            }
                                            sb3.append(i18);
                                            gn.v.a(sb3.toString());
                                            return;
                                        } else {
                                            int i60 = 0;
                                            if (substring.equals("BD")) {
                                                gn.r f11 = gn.r.f(this.f24603b);
                                                gn.r.a("心率耳机返回");
                                                int i61 = bArr[1] & 255;
                                                if (i61 == 170) {
                                                    int i62 = bArr[2] & 255;
                                                    if (i62 != 0) {
                                                        i60 = 1;
                                                    }
                                                    en.e eVar31 = this.f24619j;
                                                    if (eVar31 != null) {
                                                        eVar31.a(true, 102, i60, i62, null);
                                                        return;
                                                    }
                                                    return;
                                                } else if (i61 != 0) {
                                                    if (i61 == 1) {
                                                        gn.r.a("心率耳机 开始某项运动 mode=" + (bArr[2] & 255));
                                                        eVar2 = this.f24619j;
                                                        if (eVar2 != null) {
                                                            i10 = bArr[2] & 255;
                                                            z11 = true;
                                                            i11 = 102;
                                                        } else {
                                                            return;
                                                        }
                                                    } else if (i61 == 2) {
                                                        gn.r.a("心率耳机 心率时间间隔 interval=" + (bArr[2] & 255));
                                                        eVar2 = this.f24619j;
                                                        if (eVar2 != null) {
                                                            i10 = bArr[2] & 255;
                                                            z11 = true;
                                                            i11 = 103;
                                                        } else {
                                                            return;
                                                        }
                                                    } else if (i61 == 3 || i61 == 4) {
                                                        int i63 = f11.i(bArr);
                                                        int h10 = f11.h(bArr);
                                                        int b11 = f11.b(bArr);
                                                        int g10 = f11.g(bArr);
                                                        int j10 = f11.j(bArr);
                                                        int c10 = f11.c(bArr);
                                                        float d10 = f11.d(bArr);
                                                        int e20 = f11.e(bArr);
                                                        gn.r.a("心率耳机 上报上来的实时数据 sportMode=" + i63 + ",rateValue=" + h10 + ",calories=" + b11 + ",pace=" + g10 + ",stepCount=" + j10 + ",count=" + c10 + ",distance=" + d10 + ",durationTime=" + e20);
                                                        cn.j jVar = new cn.j(i63, h10, b11, g10, j10, c10, d10, e20);
                                                        en.e eVar32 = this.f24619j;
                                                        if (eVar32 != null) {
                                                            eVar32.a(true, 104, 1, i63, jVar);
                                                            return;
                                                        }
                                                        return;
                                                    } else {
                                                        return;
                                                    }
                                                    eVar2.a(z11, i11, 1, i10, null);
                                                    return;
                                                } else {
                                                    gn.r.a("心率耳机 结束运动");
                                                    en.e eVar33 = this.f24619j;
                                                    if (eVar33 != null) {
                                                        eVar33.a(true, 102, 0, 0, null);
                                                        return;
                                                    }
                                                    return;
                                                }
                                            } else if (substring.equals("29")) {
                                                eVar = this.f24619j;
                                                if (eVar != null) {
                                                    i24 = 154;
                                                } else {
                                                    return;
                                                }
                                            } else if (substring.equals("26")) {
                                                D0(sb2, bArr);
                                                return;
                                            } else if (substring.equals("31")) {
                                                s(substring, sb2, bArr);
                                                return;
                                            } else if (substring.equals("24")) {
                                                Z(substring, sb2, bArr);
                                                return;
                                            } else if (substring.equals("BE")) {
                                                x(bArr);
                                                return;
                                            } else if (substring.equals("34")) {
                                                Q(substring, sb2, bArr);
                                                return;
                                            } else if (substring.equals("DB")) {
                                                H0(sb2, bArr);
                                                return;
                                            } else if (substring.equals("3B")) {
                                                a0(sb2, bArr);
                                                return;
                                            } else if (substring.equals("33")) {
                                                if (sb2.toString().equals("330401")) {
                                                    this.f24638r0.postDelayed(new c(), 500L);
                                                    this.H0.b0(true);
                                                    sendBroadcast(new Intent("send_device_info_action"));
                                                    en.e eVar34 = this.f24619j;
                                                    if (eVar34 != null) {
                                                        eVar34.j(true, 20);
                                                    }
                                                    sendBroadcast(new Intent("action_gatt_connect_daydaybandsdk"));
                                                    fn.a.A(this.f24603b).b0();
                                                    eVar = this.f24619j;
                                                    if (eVar != null) {
                                                        i24 = 142;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (sb2.toString().equals("330402")) {
                                                    eVar = this.f24619j;
                                                    if (eVar != null) {
                                                        i24 = 143;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (sb2.toString().equals("330403")) {
                                                    eVar = this.f24619j;
                                                    if (eVar != null) {
                                                        i24 = 144;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (sb2.toString().equals("330404")) {
                                                    eVar = this.f24619j;
                                                    if (eVar != null) {
                                                        i24 = 145;
                                                    } else {
                                                        return;
                                                    }
                                                } else if (sb2.toString().equals("330405") && (eVar = this.f24619j) != null) {
                                                    i24 = 146;
                                                } else {
                                                    return;
                                                }
                                            } else if (substring.equals("3D")) {
                                                J(bArr);
                                                return;
                                            } else if (substring.equals("4A")) {
                                                i0(sb2, bArr);
                                                return;
                                            } else if (substring.equals("E9")) {
                                                R(sb2, bArr);
                                                return;
                                            } else if (substring.equals("3A")) {
                                                O0(sb2, bArr);
                                                return;
                                            } else if (substring.equals("37")) {
                                                G(substring, sb2, bArr);
                                                return;
                                            } else if (substring.equals("3F")) {
                                                J0(sb2, bArr);
                                                return;
                                            } else {
                                                return;
                                            }
                                        }
                                        eVar5.l(true, i19, bArr);
                                        return;
                                    }
                                }
                                z10 = true;
                            } else if (sb2.toString().length() >= 4) {
                                String substring15 = sb2.toString().substring(2, 4);
                                if (substring15.equals("FD")) {
                                    if ((bArr[2] & 255) == 3) {
                                        if (p.g(this.f24603b, 2048)) {
                                            i22 = 9;
                                        } else {
                                            this.f24646v0 = 2;
                                            this.f24638r0.postDelayed(this.f24650x0, 20L);
                                            i22 = -1;
                                        }
                                        this.f24642t0 = i22;
                                    }
                                    str3 = "C6FD";
                                } else if (substring15.equals("FF")) {
                                    if ((bArr[2] & 255) == 0) {
                                        if (p.g(this.f24603b, 2048)) {
                                            this.f24642t0 = 35;
                                        } else {
                                            this.f24646v0 = 6;
                                            this.f24638r0.postDelayed(this.f24650x0, 20L);
                                        }
                                    }
                                    str3 = "C6FF";
                                } else {
                                    if (p.g(this.f24603b, 2048)) {
                                        this.f24642t0 = 36;
                                    } else {
                                        this.f24646v0 = 7;
                                        this.f24638r0.postDelayed(this.f24650x0, 20L);
                                    }
                                    str3 = "C6序号";
                                }
                            } else {
                                return;
                            }
                            u.d("sendTextKey", str3);
                            return;
                        } else if ((bArr[1] & 255) == 1) {
                            if (!this.f24622k) {
                                eVar = this.f24619j;
                                if (eVar != null) {
                                    i24 = 38;
                                } else {
                                    return;
                                }
                            }
                            i20 = 24;
                            this.f24642t0 = i20;
                            return;
                        } else {
                            return;
                        }
                    }
                    sendBroadcast(intent);
                    return;
                }
                eVar.j(z10, i24);
            }
            z10 = true;
            eVar.j(z10, i24);
        } else if (str.equals("0406FD")) {
            byte[] F = q.F(this.E.toString());
            this.E = new StringBuilder();
            for (byte b12 : F) {
                this.F = (byte) (this.F ^ b12);
            }
            if (this.F == bArr[bArr.length - 1]) {
                this.F = (byte) 0;
                en.e eVar35 = this.f24619j;
                if (eVar35 != null) {
                    eVar35.l(true, 34, F);
                    return;
                }
                return;
            }
            this.f24613g.Q();
            this.F = (byte) 0;
        } else if (sb2.length() >= 6) {
            this.E.append(sb2.substring(6, sb2.length()));
        }
    }

    private void u0(StringBuilder sb2, byte[] bArr) {
        int i10;
        int i11;
        int i12;
        en.e eVar;
        if (sb2.toString().length() >= 4) {
            String substring = sb2.toString().substring(2, 4);
            if (this.f24613g.C()) {
                if (substring.equals("FD")) {
                    this.f24613g.t0(false);
                    if (this.f24613g.D(bArr[2])) {
                        u.a("sendTextKey", "sdk发送数据到ble完成，并且校验成功，返回状态给客户 ");
                        eVar = this.f24619j;
                        if (eVar != null) {
                            i12 = 66;
                        } else {
                            return;
                        }
                    } else {
                        u.a("sendTextKey", "sdk发送数据到ble完成，但是校验失败，返回状态给客户 ");
                        eVar = this.f24619j;
                        if (eVar != null) {
                            i12 = 67;
                        } else {
                            return;
                        }
                    }
                    eVar.l(true, i12, null);
                } else if (bArr.length == 2) {
                    this.f24613g.f26224x = (bArr[1] & 255) + 1;
                    if (this.f24622k) {
                        i11 = 27;
                        this.f24642t0 = i11;
                        return;
                    }
                    i10 = 9;
                    this.f24646v0 = i10;
                    this.f24638r0.postDelayed(this.f24650x0, 20L);
                }
            } else if (substring.equals("FD")) {
                if (this.f24636q0 == bArr[2]) {
                    byte[] F = q.F(this.f24634p0.toString());
                    u.a("sendTextKey", "ble发送数据到sdk完成，并且校验成功，返回数据给客户");
                    en.e eVar2 = this.f24619j;
                    if (eVar2 != null) {
                        eVar2.l(true, 68, F);
                    }
                } else {
                    u.a("sendTextKey", "ble发送数据到sdk完成，但是校验失败，返回状态给客户 ");
                    en.e eVar3 = this.f24619j;
                    if (eVar3 != null) {
                        eVar3.l(true, 69, null);
                    }
                }
                this.f24636q0 = (byte) 0;
                this.f24634p0 = new StringBuilder();
            } else if (bArr.length > 2) {
                if (sb2.length() >= 4) {
                    this.f24634p0.append(sb2.substring(4, sb2.length()));
                }
                for (int i13 = 1; i13 < bArr.length; i13++) {
                    this.f24636q0 = (byte) (this.f24636q0 ^ bArr[i13]);
                }
                this.f24613g.f26224x = bArr[1] & 255;
                if (this.f24622k) {
                    i11 = 28;
                    this.f24642t0 = i11;
                    return;
                }
                i10 = 10;
                this.f24646v0 = i10;
                this.f24638r0.postDelayed(this.f24650x0, 20L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(List<BluetoothGattService> list) {
        List<Integer> f10;
        int i10;
        int i11;
        if (list != null) {
            G0();
            for (BluetoothGattService bluetoothGattService : list) {
                for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                    UUID uuid = bluetoothGattCharacteristic.getUuid();
                    if (UUID.fromString(c0.f27526b).equals(uuid)) {
                        f10 = w.e().f();
                        i10 = 1;
                    } else {
                        if (UUID.fromString(c0.f27528d).equals(uuid)) {
                            f10 = w.e().f();
                            i11 = 2;
                        } else if (c0.f27537m.equals(uuid)) {
                            f10 = w.e().f();
                            i11 = 3;
                        } else if (UUID.fromString(c0.f27525a).equals(uuid)) {
                            f10 = w.e().f();
                            i11 = 11;
                        } else if (UUID.fromString(c0.f27527c).equals(uuid)) {
                            f10 = w.e().f();
                            i11 = 12;
                        } else if (c0.f27542r.equals(uuid)) {
                            f10 = w.e().f();
                            i11 = 13;
                        }
                        i10 = Integer.valueOf(i11);
                    }
                    f10.add(i10);
                }
            }
            w.e().f().add(-1);
            w.e().k(this.f24612f1);
            w.e().b();
            this.f24608d1 = true;
            w(false);
        }
    }

    private synchronized void v0(List<a0> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (!TextUtils.isEmpty(list.get(i10).e())) {
                o.b(this.f24603b).F(list.get(i10));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z10) {
        if (this.f24622k) {
            this.f24638r0.sendEmptyMessage(10);
        } else {
            this.f24638r0.sendEmptyMessageDelayed(10, 50L);
        }
    }

    private void x(byte[] bArr) {
        int i10 = bArr[1] & 255;
        if (i10 == 1) {
            b0.a("手环支持设置的快捷开关");
            if (this.f24619j != null) {
                byte[] bArr2 = new byte[bArr.length - 2];
                System.arraycopy(bArr, 2, bArr2, 0, bArr.length - 2);
                this.f24619j.l(true, 118, bArr2);
            }
        } else if (i10 == 2) {
            b0.a("手环快捷开关的状态");
            if (this.f24619j != null) {
                byte[] bArr3 = new byte[bArr.length - 2];
                System.arraycopy(bArr, 2, bArr3, 0, bArr.length - 2);
                this.f24619j.l(true, 119, bArr3);
            }
        }
    }

    private boolean y(long j10) {
        this.J0 = true;
        long currentTimeMillis = System.currentTimeMillis();
        while (this.J0 && System.currentTimeMillis() - currentTimeMillis < j10) {
            if (k0()) {
                u.d("BluetoothLeService", "设备忙，等待");
                try {
                    Thread.sleep(50L);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            } else {
                u.d("BluetoothLeService", "设备不忙");
                return false;
            }
        }
        return true;
    }

    private boolean z(BluetoothGatt bluetoothGatt) {
        if (bluetoothGatt != null) {
            try {
                Method method = bluetoothGatt.getClass().getMethod("refresh", new Class[0]);
                if (method != null) {
                    return ((Boolean) method.invoke(bluetoothGatt, new Object[0])).booleanValue();
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        this.f24638r0.removeMessages(12);
        u.d("BluetoothLeService", "4秒钟后 runnableFourSecondNoFoundServer  isFindService=" + this.f24611f);
        if (!this.f24611f) {
            this.f24616h1++;
            w.g("没发现服务  serviceNotFoundCount =" + this.f24616h1);
            u.d("BluetoothLeService", "4秒钟后没发现服务，tempGatt.disconnect()  mBluetoothGatt =" + f24600m1);
            BluetoothGatt bluetoothGatt = f24600m1;
            if (bluetoothGatt != null) {
                bluetoothGatt.disconnect();
            }
            X0();
            this.H0.b0(false);
            sendBroadcast(new Intent("bluetooth.le.ACTION_GATT_FAILURE_daydaybandsdk"));
            en.e eVar = this.f24619j;
            if (eVar != null) {
                eVar.j(true, 19);
            }
        }
    }

    public boolean E0() {
        String str;
        if (this.f24601a == null) {
            BluetoothManager bluetoothManager = (BluetoothManager) getSystemService("bluetooth");
            this.f24601a = bluetoothManager;
            if (bluetoothManager == null) {
                str = "Unable to initialize BluetoothManager.";
                u.b("BluetoothLeService", str);
                return false;
            }
        }
        BluetoothAdapter adapter = this.f24601a.getAdapter();
        f24599l1 = adapter;
        if (adapter != null) {
            return true;
        }
        str = "Unable to obtain a BluetoothAdapter.";
        u.b("BluetoothLeService", str);
        return false;
    }

    public void R0(byte[] bArr) {
        en.e eVar;
        int i10;
        int i11 = bArr[1] & 255;
        gn.a g10 = gn.a.g();
        if (i11 == 1) {
            String b10 = gn.h.b();
            int C = C();
            int b11 = g10.b(bArr);
            int i12 = g10.i(bArr);
            g10.j("calendarOnce =" + b10 + ",timeOnce =" + C + ",airPressureOnce =" + b11 + ",temperatureOnce =" + i12);
            o.b(this.f24603b).p(new cn.a(b10, C, b11, i12));
            en.e eVar2 = this.f24619j;
            if (eVar2 != null) {
                eVar2.j(true, 70);
            }
        } else if (i11 == 2) {
            String d10 = g10.d(bArr);
            int f10 = g10.f(bArr);
            int a10 = g10.a(bArr);
            int h10 = g10.h(bArr);
            this.f24652y0.add(new cn.a(d10, f10, a10, h10));
            g10.j("calendar =" + d10 + ",time =" + f10 + ",airPressureHistory =" + a10 + ",temperatureHistory =" + h10);
            g10.l(bArr);
        } else if (i11 == 253) {
            int c10 = g10.c(bArr);
            int e10 = g10.e();
            g10.j("bleCrc =" + c10 + ",sdkCrc =" + e10);
            if (c10 == e10) {
                g10.j("气压数据校验成功,存储数据");
                List<cn.a> list = this.f24652y0;
                if (list != null) {
                    I(list);
                }
                eVar = this.f24619j;
                if (eVar != null) {
                    i10 = 71;
                    eVar.j(true, i10);
                }
                g10.k(0);
                this.f24652y0 = new ArrayList();
            }
            g10.j("气压数据校验失败，不存储数据");
            eVar = this.f24619j;
            if (eVar != null) {
                i10 = 72;
                eVar.j(true, i10);
            }
            g10.k(0);
            this.f24652y0 = new ArrayList();
        }
    }

    public void T() {
        synchronized (this.F0) {
            this.G0 = false;
            this.F0.notify();
            u.a("BluetoothLeService", "连接不超时");
        }
    }

    public void U() {
        synchronized (this.D0) {
            this.E0 = false;
            this.D0.notify();
            u.a("sendTextKey", "同步数据不超时");
        }
    }

    public boolean V(String str) {
        return W(str, false);
    }

    public boolean V0(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        String str;
        w.g("readCharacteristic---读特征值");
        boolean z10 = false;
        if (f24599l1 == null || f24600m1 == null) {
            str = "readCharacteristic BluetoothAdapter not initialized";
        } else {
            if (bluetoothGattCharacteristic != null) {
                w.g("readCharacteristic characteristic.toString =" + bluetoothGattCharacteristic.getUuid());
                if (!y(PayTask.f6879j)) {
                    try {
                        z10 = f24600m1.readCharacteristic(bluetoothGattCharacteristic);
                    } catch (Exception e10) {
                        w.g("readCharacteristic Exception =" + e10);
                    }
                }
            }
            str = "readCharacteristic cc =" + z10;
        }
        w.g(str);
        return z10;
    }

    public boolean W(String str, boolean z10) {
        u.f("BluetoothLeService", "connect  address =" + str);
        BluetoothAdapter bluetoothAdapter = f24599l1;
        if (bluetoothAdapter == null || str == null) {
            u.f("BluetoothLeService", "BluetoothAdapter not initialized or unspecified address.");
            return false;
        } else if (!bluetoothAdapter.isEnabled()) {
            u.d("BluetoothLeService", "手机蓝牙未打开");
            return false;
        } else {
            u.a("BluetoothLeService", "postDelayed mBluetoothGatt111=" + f24600m1);
            BluetoothGatt bluetoothGatt = f24600m1;
            if (bluetoothGatt != null) {
                z(bluetoothGatt);
                BluetoothGatt bluetoothGatt2 = f24600m1;
                if (bluetoothGatt2 != null) {
                    bluetoothGatt2.close();
                    f24600m1 = null;
                }
                this.f24613g.H(null);
            }
            u.a("BluetoothLeService", "postDelayed mBluetoothGatt222=" + f24600m1);
            BluetoothDevice remoteDevice = f24599l1.getRemoteDevice(str);
            if (remoteDevice == null) {
                u.f("BluetoothLeService", "postDelayed Device not  found.  Unable to connect.");
                return false;
            }
            T();
            if (!z10) {
                b1(35000, 101);
            }
            this.f24606c1 = System.currentTimeMillis();
            f24600m1 = Build.VERSION.SDK_INT >= 23 ? remoteDevice.connectGatt(this.f24603b, z10, this.D, 2) : remoteDevice.connectGatt(this.f24603b, z10, this.D);
            u.f("BluetoothLeService", "device.connectGatt mBluetoothGatt =" + f24600m1);
            return true;
        }
    }

    public Object W0(Object obj, String str) {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public void X0() {
        BluetoothGatt bluetoothGatt = f24600m1;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
            f24600m1 = null;
            this.f24613g.H(null);
        }
    }

    public void Z0(r rVar) {
        this.f24617i = rVar;
    }

    public void a1(BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z10) {
        A(f24600m1, bluetoothGattCharacteristic, z10);
    }

    public void b1(int i10, int i11) {
        new Thread(new h(i10, i11)).start();
    }

    public void c1(en.e eVar) {
        this.f24619j = eVar;
        q qVar = this.f24613g;
        if (qVar != null) {
            qVar.s0(eVar);
        }
    }

    public void d1(dn.h hVar) {
        this.f24647w = hVar;
    }

    public void e1(int i10, int i11) {
        new Thread(new g(i10, i11)).start();
    }

    public void f0() {
        if (f24599l1 == null || f24600m1 == null) {
            u.f("BluetoothLeService", "BluetoothAdapter not initialized");
            return;
        }
        u.f("BluetoothLeService", "disconnect mBluetoothGatt =" + f24600m1);
        if (!f24599l1.isEnabled()) {
            u.d("BluetoothLeService", "手机蓝牙未打开");
            return;
        }
        BluetoothGatt bluetoothGatt = f24600m1;
        if (bluetoothGatt != null) {
            bluetoothGatt.disconnect();
        }
    }

    public void g(boolean z10, int i10) {
        if (!z10) {
            i10--;
            if (i10 < 0 || i10 >= 20) {
                return;
            }
        } else if (i10 >= 15) {
            u.d("languageKey", "前15个界面语言设置完成 bandPage=" + i10);
            if (i10 == 15) {
                boolean f10 = p.f(this.f24603b, 32);
                boolean f11 = p.f(this.f24603b, 256);
                boolean f12 = p.f(this.f24603b, 512);
                boolean f13 = p.f(this.f24603b, 1024);
                boolean f14 = p.f(this.f24603b, 2048);
                u.d("languageKey", "isSupportBandFindPhone =" + f10 + ",isSupportRide =" + f11 + ",isSupportTableTennis =" + f12 + ",isSupportBadminton =" + f13 + ",isSupportTennis =" + f14);
                ArrayList<Integer> arrayList = new ArrayList<>();
                this.C0 = arrayList;
                if (f10) {
                    arrayList.add(16);
                }
                if (f11) {
                    this.C0.add(17);
                }
                if (f12) {
                    this.C0.add(18);
                }
                if (f13) {
                    this.C0.add(19);
                }
                if (f14) {
                    this.C0.add(20);
                }
                boolean h10 = p.h(this.f24603b, 16384);
                boolean g10 = p.g(this.f24603b, 1024);
                boolean e10 = p.e(this.f24603b, 8388608);
                if (h10 || g10) {
                    for (int i11 = 21; i11 <= 50; i11++) {
                        this.C0.add(Integer.valueOf(i11));
                    }
                }
                if (e10) {
                    for (int i12 = 51; i12 <= 89; i12++) {
                        this.C0.add(Integer.valueOf(i12));
                    }
                }
            }
            int size = this.C0.size();
            u.d("languageKey", "ohterFiveInterfaceLength =" + size);
            if (size > 0) {
                this.f24613g.S(this.C0.get(0).intValue() - 1);
                this.C0.remove(0);
                return;
            }
            this.f24642t0 = -1;
            u.d("languageKey", "所有界面设置完成 bandPage =" + i10);
            en.e eVar = this.f24619j;
            if (eVar != null) {
                eVar.j(true, 78);
                return;
            }
            return;
        }
        this.f24613g.S(i10);
    }

    public boolean j1(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        String str;
        BluetoothGatt bluetoothGatt;
        boolean z10 = false;
        if (f24599l1 == null || (bluetoothGatt = f24600m1) == null) {
            str = "BluetoothAdapter not initialized";
        } else {
            if (bluetoothGattCharacteristic != null) {
                z10 = bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
            }
            str = "----------->writeCharacteristic result =" + z10;
        }
        u.f("BluetoothLeService", str);
        return z10;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.C;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        O();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        m();
        return super.onUnbind(intent);
    }

    public List<BluetoothGattService> x0() {
        BluetoothGatt bluetoothGatt = f24600m1;
        if (bluetoothGatt == null) {
            return null;
        }
        return bluetoothGatt.getServices();
    }
}
