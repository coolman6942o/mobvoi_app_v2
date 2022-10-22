package en;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import bn.i;
import cn.f;
import cn.s;
import com.google.gson.e;
import com.huawei.agconnect.exception.AGCServerException;
import com.mobvoi.wear.location.FusedLocationConstants;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.yc.pedometer.dial.OnlineDialUtil;
import com.yc.pedometer.sdk.BluetoothLeService;
import dn.n;
import gn.c;
import gn.c0;
import gn.d0;
import gn.p;
import gn.u;
import gn.z;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;
import java.util.UUID;
/* loaded from: classes2.dex */
public class q {
    private static BluetoothGatt T;
    private static q U;
    private static b V;
    public static int W;
    private byte A;
    private String[] D;
    private List<Integer> J;
    private byte O;

    /* renamed from: a  reason: collision with root package name */
    private Context f26201a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f26202b;

    /* renamed from: c  reason: collision with root package name */
    private BluetoothLeService f26203c;

    /* renamed from: d  reason: collision with root package name */
    private e f26204d;

    /* renamed from: e  reason: collision with root package name */
    private i f26205e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f26206f;

    /* renamed from: n  reason: collision with root package name */
    private int f26214n;

    /* renamed from: q  reason: collision with root package name */
    private n f26217q;

    /* renamed from: r  reason: collision with root package name */
    private TimerTask f26218r;

    /* renamed from: g  reason: collision with root package name */
    private boolean f26207g = true;

    /* renamed from: h  reason: collision with root package name */
    public Handler f26208h = new a();

    /* renamed from: i  reason: collision with root package name */
    public int f26209i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f26210j = 0;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f26211k = null;

    /* renamed from: l  reason: collision with root package name */
    public boolean f26212l = false;

    /* renamed from: m  reason: collision with root package name */
    private int f26213m = AGCServerException.UNKNOW_EXCEPTION;

    /* renamed from: o  reason: collision with root package name */
    private int f26215o = 0;

    /* renamed from: p  reason: collision with root package name */
    private int f26216p = 0;

    /* renamed from: s  reason: collision with root package name */
    public int f26219s = 0;

    /* renamed from: t  reason: collision with root package name */
    private byte[] f26220t = null;

    /* renamed from: u  reason: collision with root package name */
    public boolean f26221u = false;

    /* renamed from: v  reason: collision with root package name */
    cn.n f26222v = null;

    /* renamed from: w  reason: collision with root package name */
    public int f26223w = 0;

    /* renamed from: x  reason: collision with root package name */
    public int f26224x = 0;

    /* renamed from: y  reason: collision with root package name */
    private byte[] f26225y = null;

    /* renamed from: z  reason: collision with root package name */
    public boolean f26226z = false;
    public boolean B = false;
    private int C = 0;
    public int E = 0;
    private byte[] F = null;
    public boolean G = false;
    private int H = 1;
    private int I = 1;
    public int K = 0;
    public int L = 0;
    private byte[] M = null;
    public boolean N = false;
    public int P = 0;
    private int Q = 240;
    private boolean R = false;
    private List<f> S = new ArrayList();

    /* loaded from: classes2.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 2) {
                q qVar = q.this;
                int i11 = qVar.f26209i + 1;
                qVar.f26209i = i11;
                qVar.d0(i11);
                int i12 = 0;
                if (q.this.f26214n > 0) {
                    q qVar2 = q.this;
                    i12 = (qVar2.f26209i * 100) / qVar2.f26214n;
                }
                if (q.this.f26217q != null) {
                    q.this.f26217q.a(i12);
                }
                OnlineDialUtil.b("progress = " + i12 + ",current =" + q.this.f26209i + ",totalCount =" + q.this.f26214n);
            } else if (i10 == 3) {
                q qVar3 = q.this;
                qVar3.p(qVar3.L);
            } else if (i10 == 4) {
                q.this.n(gn.n.d(q.this.f26201a).f(z.v(q.this.f26201a).k()));
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class b {
        private b() {
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public q(Context context) {
        this.f26206f = false;
        this.f26201a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(gn.q.f27582a, 0);
        this.f26202b = sharedPreferences;
        sharedPreferences.edit();
        this.f26205e = i.d(this.f26201a);
        V = new b(null);
        this.f26206f = l();
    }

    private void A() {
        byte[] bArr = {-81, -3};
        U0(bArr);
        for (int i10 = 0; i10 < 2; i10++) {
            String.format("%02X", Byte.valueOf(bArr[i10]));
        }
    }

    public static q B(Context context) {
        if (U == null) {
            U = new q(context);
        }
        return U;
    }

    private void E() {
        byte[] bArr = {-59, -3};
        U0(bArr);
        for (int i10 = 0; i10 < 2; i10++) {
            String.format("%02X", Byte.valueOf(bArr[i10]));
        }
    }

    public static byte[] F(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        byte[] bytes = str.getBytes();
        for (int i10 = 0; i10 < length; i10++) {
            int i11 = i10 * 2;
            bArr[i10] = a(bytes[i11], bytes[i11 + 1]);
        }
        return bArr;
    }

    private void G() {
        U0(new byte[]{-58, -3});
    }

    private void J() {
        U0(new byte[]{38, 3, 0});
    }

    private static byte a(byte b10, byte b11) {
        return (byte) (((byte) (Byte.decode("0x" + new String(new byte[]{b10})).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{b11})).byteValue());
    }

    private int b(int i10) {
        return i10 < 0 ? Math.abs(i10) | 128 : i10;
    }

    private void d() {
        TimerTask timerTask = this.f26218r;
        if (timerTask != null) {
            timerTask.cancel();
        }
    }

    private void e(String str, int i10, int i11) {
        u.d("languageKey", "sendBandLanguageToBle body =" + str);
        gn.n d10 = gn.n.d(this.f26201a);
        String o10 = d10.o(str);
        byte[] k10 = d10.k(o10, i10, i11);
        u.d("languageKey", "body =" + str + "，dataString = " + o10 + ",data =" + k10);
        if (k10 != null) {
            this.F = k10;
            this.E = 0;
            this.G = false;
            Y(0);
        }
    }

    private boolean f(long j10) {
        long currentTimeMillis = System.currentTimeMillis();
        while (System.currentTimeMillis() - currentTimeMillis < j10) {
            if (x()) {
                u.d("sendTextKey", "设备忙，等待");
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            } else {
                u.d("sendTextKey", "设备不忙");
                return false;
            }
        }
        return true;
    }

    private boolean g(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        int i10;
        BluetoothGatt bluetoothGatt = T;
        if (bluetoothGatt == null) {
            u.f("WriteCharaToBLE", "BluetoothAdapter not initialized");
            return true;
        }
        boolean writeCharacteristic = bluetoothGatt.writeCharacteristic(bluetoothGattCharacteristic);
        e eVar = this.f26204d;
        if (writeCharacteristic) {
            if (eVar != null) {
                i10 = 148;
                eVar.j(true, i10);
            }
            u.f("WriteCharaToBLE", "----------->writeCharacteristic result =" + writeCharacteristic);
            return writeCharacteristic;
        }
        if (eVar != null) {
            i10 = com.bjleisen.iface.sdk.a.f7612e;
            eVar.j(true, i10);
        }
        u.f("WriteCharaToBLE", "----------->writeCharacteristic result =" + writeCharacteristic);
        return writeCharacteristic;
    }

    private int h(String str) {
        if (str == null || str.length() <= 0 || str.contains("100")) {
            return 1;
        }
        if (str.contains("101") || str.contains("102") || str.contains("103")) {
            return 2;
        }
        if (str.contains("104")) {
            return 3;
        }
        if (str.contains("300") || str.contains("301")) {
            return 4;
        }
        if (str.contains("302") || str.contains("303") || str.contains("304")) {
            return 5;
        }
        if (str.contains("404") || str.contains("405") || str.contains("406")) {
            return 6;
        }
        if (str.contains("305") || str.contains("309")) {
            return 7;
        }
        if (str.contains("306") || str.contains("307") || str.contains("308") || str.contains("310") || str.contains("311") || str.contains("312") || str.contains("313")) {
            return 8;
        }
        if (str.contains("400") || str.contains("401") || str.contains("402") || str.contains("403") || str.contains("407")) {
            return 9;
        }
        if (str.contains("503") || str.contains("504") || str.contains("507") || str.contains("508")) {
            return 10;
        }
        if (str.contains("500") || str.contains("501") || str.contains("502")) {
            return 11;
        }
        return (str.contains("200") || str.contains("201") || str.contains("202") || str.contains("203") || str.contains("204") || str.contains("205") || str.contains("206") || str.contains("207") || str.contains("208") || str.contains("209") || str.contains("210") || str.contains("211") || str.contains("212") || str.contains("213")) ? 12 : 1;
    }

    private List<BluetoothGattService> j() {
        BluetoothGatt bluetoothGatt = T;
        if (bluetoothGatt == null) {
            return null;
        }
        return bluetoothGatt.getServices();
    }

    private boolean l() {
        int i10 = this.f26201a.getApplicationInfo().targetSdkVersion;
        if (i10 <= 30 || Build.VERSION.SDK_INT <= 30) {
            return false;
        }
        u.d("WriteCharaToBLE", "Android 12 ，targetSdkVersion >= 31 ute_sdk_v3.1.6.6 targetSdkVersion =" + i10);
        return true;
    }

    private boolean x() {
        BluetoothGatt bluetoothGatt;
        if (this.f26206f || (bluetoothGatt = T) == null) {
            return false;
        }
        try {
            return ((Boolean) P(bluetoothGatt, "mDeviceBusy")).booleanValue();
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            return false;
        }
    }

    public void A0() {
        B0("");
    }

    public void B0(String str) {
        BluetoothLeService bluetoothLeService = this.f26203c;
        if (bluetoothLeService != null) {
            bluetoothLeService.e1(20000, 92);
        }
        U0(en.b.d(this.f26201a).c(1, str));
    }

    public boolean C() {
        return this.B;
    }

    public void C0() {
        U0(new byte[]{36, -6});
    }

    public boolean D(byte b10) {
        return b10 == this.A;
    }

    public void D0() {
        Calendar calendar = Calendar.getInstance();
        int i10 = calendar.get(1);
        int i11 = calendar.get(2) + 1;
        int i12 = calendar.get(5);
        int i13 = calendar.get(11);
        int i14 = calendar.get(12);
        int i15 = calendar.get(13);
        String valueOf = String.valueOf(i15);
        String valueOf2 = String.valueOf(i14);
        String valueOf3 = String.valueOf(i13);
        String valueOf4 = String.valueOf(i12);
        String valueOf5 = String.valueOf(i11);
        String valueOf6 = String.valueOf(i10);
        if (i15 < 10) {
            valueOf = "0" + i15;
        }
        if (i14 < 10) {
            valueOf2 = "0" + i14;
        }
        if (i13 < 10) {
            valueOf3 = "0" + i13;
        }
        if (i12 < 10) {
            valueOf4 = "0" + i12;
        }
        if (i11 < 10) {
            valueOf5 = "0" + i11;
        }
        String str = valueOf6 + valueOf5 + valueOf4 + valueOf3 + valueOf2 + valueOf;
        int intValue = Integer.valueOf(str.substring(0, 4)).intValue();
        U0(new byte[]{-93, (byte) ((65280 & intValue) >> 8), (byte) (intValue & 255), (byte) (Integer.valueOf(str.substring(4, 6)).intValue() & 255), (byte) (Integer.valueOf(str.substring(6, 8)).intValue() & 255), (byte) (Integer.valueOf(str.substring(8, 10)).intValue() & 255), (byte) (Integer.valueOf(str.substring(10, 12)).intValue() & 255), (byte) (Integer.valueOf(str.substring(12, 14)).intValue() & 255)});
    }

    public void E0(int i10) {
        z.v(this.f26201a).S(i10);
        String[] a10 = c.b(this.f26201a).a(i10);
        this.D = a10;
        if (a10 != null) {
            u.d("languageKey", "sendBandLanguageToBle bandLanguageArray.length =" + this.D.length);
            S(0);
        }
    }

    public void F0(boolean z10, int i10) {
        byte[] bArr = new byte[5];
        bArr[0] = 59;
        bArr[1] = 3;
        if (z10) {
            bArr[2] = 1;
        } else {
            bArr[2] = 0;
        }
        bArr[3] = (byte) ((65280 & i10) >> 8);
        bArr[4] = (byte) (i10 & 255);
        U0(bArr);
    }

    public void G0() {
        V0(new byte[]{40, 12});
    }

    public void H(BluetoothGatt bluetoothGatt) {
        T = bluetoothGatt;
    }

    public void H0(boolean z10, float f10, float f11) {
        int i10 = (int) (f10 * 100.0f);
        int i11 = (int) (f11 * 100.0f);
        byte[] bArr = new byte[7];
        bArr[0] = 36;
        bArr[1] = 6;
        if (z10) {
            bArr[2] = 1;
        } else {
            bArr[2] = 0;
        }
        bArr[3] = (byte) ((i10 & 65280) >> 8);
        bArr[4] = (byte) (i10 & 255);
        bArr[5] = (byte) ((65280 & i11) >> 8);
        bArr[6] = (byte) (i11 & 255);
        U0(bArr);
    }

    public void I(BluetoothLeService bluetoothLeService) {
        this.f26203c = bluetoothLeService;
        u.d("sendTextKey", "WriteCommandToBLE mBluetoothLeService =" + bluetoothLeService);
    }

    public void I0(String str) {
        U0(en.b.d(this.f26201a).c(9, str));
    }

    public void J0(boolean z10, int i10) {
        byte[] bArr = new byte[5];
        bArr[0] = 52;
        bArr[1] = 3;
        if (z10) {
            bArr[2] = 1;
        } else {
            bArr[2] = 0;
        }
        bArr[3] = (byte) ((65280 & i10) >> 8);
        bArr[4] = (byte) (i10 & 255);
        U0(bArr);
    }

    public void K(boolean z10) {
        byte[] bArr = new byte[2];
        if (z10) {
            bArr[0] = -9;
            bArr[1] = 1;
        } else {
            bArr[0] = -9;
            bArr[1] = 2;
        }
        U0(bArr);
    }

    public void K0() {
        U0(new byte[]{52, -6});
    }

    public void L() {
        U0(new byte[]{38, 2});
    }

    public void L0() {
        M0("");
    }

    public void M() {
        U0(new byte[]{-81, -86});
    }

    public void M0(String str) {
        int i10;
        BluetoothLeService bluetoothLeService;
        if (this.f26203c != null) {
            if (p.f(this.f26201a, 16384)) {
                bluetoothLeService = this.f26203c;
                i10 = 95;
            } else {
                bluetoothLeService = this.f26203c;
                i10 = 94;
            }
            bluetoothLeService.e1(20000, i10);
        }
        U0(en.b.d(this.f26201a).c(3, str));
    }

    public void N() {
        U0(new byte[]{-18, -86});
    }

    public void N0(cn.n nVar) {
        int length;
        this.f26222v = nVar;
        int i10 = 0;
        this.f26223w = 0;
        String y10 = nVar.y();
        int v10 = nVar.v();
        int w10 = nVar.w();
        int x10 = nVar.x();
        int u10 = nVar.u();
        int t10 = nVar.t();
        String a10 = nVar.a();
        int h10 = h(y10);
        int b10 = b(v10);
        int b11 = b(w10);
        int b12 = b(x10);
        byte[] bArr = new byte[19];
        bArr[0] = -53;
        bArr[1] = 1;
        bArr[2] = (byte) (h10 & 255);
        bArr[3] = 0;
        bArr[4] = (byte) (b10 & 255);
        bArr[5] = (byte) (b11 & 255);
        bArr[6] = (byte) (b12 & 255);
        bArr[7] = (byte) ((u10 & 65280) >> 8);
        bArr[8] = (byte) (u10 & 255);
        bArr[9] = (byte) ((65280 & t10) >> 8);
        bArr[10] = (byte) (t10 & 255);
        if (!TextUtils.isEmpty(a10)) {
            try {
                byte[] bytes = a10.getBytes("GB2312");
                if (bytes != null) {
                    byte[] g10 = gn.n.d(this.f26201a).g(gn.n.d(this.f26201a).c(bytes), 1);
                    if (g10 != null && (length = g10.length) > 0) {
                        if (length > 8) {
                            while (i10 < 8) {
                                bArr[i10 + 11] = g10[i10];
                                i10++;
                            }
                        } else {
                            while (i10 < length) {
                                bArr[i10 + 11] = g10[i10];
                                i10++;
                            }
                        }
                    }
                }
            } catch (UnsupportedEncodingException e10) {
                e10.printStackTrace();
            }
        }
        U0(bArr);
    }

    public void O() {
        U0(new byte[]{38, 1});
    }

    public void O0(boolean z10, int i10) {
        byte[] bArr = new byte[5];
        bArr[0] = 36;
        bArr[1] = 3;
        if (z10) {
            bArr[2] = 1;
        } else {
            bArr[2] = 0;
        }
        bArr[3] = (byte) ((65280 & i10) >> 8);
        bArr[4] = (byte) (i10 & 255);
        U0(bArr);
    }

    public Object P(Object obj, String str) {
        Field declaredField = obj.getClass().getDeclaredField(str);
        declaredField.setAccessible(true);
        return declaredField.get(obj);
    }

    public void P0(int i10) {
        cn.n nVar = this.f26222v;
        if (nVar == null) {
            return;
        }
        if (i10 == 1) {
            U0(new byte[]{-53, 2, (byte) (h(nVar.j()) & 255), 0, (byte) (b(nVar.h()) & 255), (byte) (b(nVar.i()) & 255), (byte) (h(nVar.s()) & 255), 0, (byte) (b(nVar.q()) & 255), (byte) (b(nVar.r()) & 255), (byte) (h(nVar.g()) & 255), 0, (byte) (b(nVar.e()) & 255), (byte) (b(nVar.f()) & 255), (byte) (h(nVar.d()) & 255), 0, (byte) (b(nVar.b()) & 255), (byte) (b(nVar.c()) & 255)});
        } else if (i10 == 2) {
            U0(new byte[]{-53, 3, (byte) (h(nVar.p()) & 255), 0, (byte) (b(nVar.n()) & 255), (byte) (b(nVar.o()) & 255), (byte) (h(nVar.m()) & 255), 0, (byte) (b(nVar.k()) & 255), (byte) (b(nVar.l()) & 255)});
        }
    }

    public void Q() {
        U0(new byte[]{2, 10});
    }

    public void Q0() {
        synchronized (V) {
            d();
            V.notifyAll();
        }
    }

    public void R(int i10) {
        U0(new byte[]{-81, -85, (byte) (i10 & 255)});
    }

    public void R0(byte[] bArr, int i10) {
        if (bArr == null) {
            u.f("sendTextKey", "universalInterface  data =" + bArr);
            return;
        }
        this.C = i10;
        this.f26225y = bArr;
        this.f26224x = 0;
        this.A = (byte) 0;
        if (p.d(this.f26201a, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT)) {
            this.f26210j = z.v(this.f26201a).x();
            u.f("sendTextKey", "universalInterface  maxcommunicationLength =" + this.f26210j);
            T0(this.f26224x);
            return;
        }
        S0(this.f26224x);
    }

    public void S(int i10) {
        e(this.D[i10], z.v(this.f26201a).i(), i10 + 1);
    }

    public void S0(int i10) {
        if (i10 == 0) {
            if (this.C == 1) {
                t0(false);
            } else {
                t0(true);
            }
            this.f26226z = false;
        }
        byte[] bArr = this.f26225y;
        int length = bArr.length;
        if (length > 108) {
            length = 108;
        }
        int i11 = length % 18;
        if (i10 < length / 18) {
            byte[] bArr2 = new byte[20];
            bArr2[0] = -10;
            bArr2[1] = (byte) (i10 & 255);
            this.A = (byte) (this.A ^ bArr2[1]);
            int i12 = i10 * 18;
            for (int i13 = i12; i13 < 18 + i12; i13++) {
                int i14 = (i13 - i12) + 2;
                bArr2[i14] = bArr[i13];
                this.A = (byte) (bArr2[i14] ^ this.A);
            }
            U0(bArr2);
            if (i11 != 0) {
                return;
            }
        } else if (this.f26226z) {
            o0(this.A);
            this.f26226z = false;
        } else if (i11 != 0) {
            byte[] bArr3 = new byte[i11 + 2];
            bArr3[0] = -10;
            bArr3[1] = (byte) (i10 & 255);
            this.A = (byte) (this.A ^ bArr3[1]);
            int i15 = i10 * 18;
            for (int i16 = i15 + 0; i16 < length; i16++) {
                int i17 = (i16 - i15) + 2;
                bArr3[i17] = bArr[i16];
                this.A = (byte) (bArr3[i17] ^ this.A);
            }
            U0(bArr3);
        }
        this.f26226z = true;
    }

    public void T() {
        V0(new byte[]{55, -4, -3});
    }

    public void T0(int i10) {
        String str;
        if (i10 == 0) {
            if (this.C == 1) {
                t0(false);
                str = "ble到sdk流程开始";
            } else {
                t0(true);
                str = "sdk到ble流程开始";
            }
            u.a("sendTextKey", str);
            this.f26226z = false;
        }
        byte[] bArr = this.f26225y;
        int i11 = this.f26210j - 3;
        int length = bArr.length;
        int i12 = length % i11;
        if (i10 < length / i11) {
            byte[] bArr2 = new byte[i11 + 3];
            bArr2[0] = -10;
            bArr2[1] = (byte) ((i10 & 65280) >> 8);
            bArr2[2] = (byte) (i10 & 255);
            byte b10 = (byte) (this.A ^ bArr2[1]);
            this.A = b10;
            this.A = (byte) (b10 ^ bArr2[2]);
            int i13 = i10 * i11;
            for (int i14 = i13; i14 < i11 + i13; i14++) {
                int i15 = (i14 - i13) + 3;
                bArr2[i15] = bArr[i14];
                this.A = (byte) (bArr2[i15] ^ this.A);
            }
            V0(bArr2);
            if (i12 != 0) {
                return;
            }
        } else if (this.f26226z) {
            p0(this.A);
            this.f26226z = false;
        } else if (i12 != 0) {
            byte[] bArr3 = new byte[i12 + 3];
            bArr3[0] = -10;
            bArr3[1] = (byte) ((i10 & 65280) >> 8);
            bArr3[2] = (byte) (i10 & 255);
            byte b11 = (byte) (this.A ^ bArr3[1]);
            this.A = b11;
            this.A = (byte) (b11 ^ bArr3[2]);
            int i16 = i11 * i10;
            for (int i17 = i16; i17 < length; i17++) {
                int i18 = (i17 - i16) + 3;
                bArr3[i18] = bArr[i17];
                this.A = (byte) (bArr3[i18] ^ this.A);
            }
            V0(bArr3);
        }
        this.f26226z = true;
    }

    public void U() {
        u.d("WriteCharaToBLE", "发送第一条");
        u.d("WriteCharaToBLE", "list=" + new e().s(this.S) + ",size=" + this.S.size());
        this.P = 0;
        this.Q = z.v(this.f26201a).x();
        c0();
    }

    public void U0(byte[] bArr) {
        List<BluetoothGattService> j10 = j();
        if (j10 != null) {
            for (int i10 = 0; i10 < j10.size(); i10++) {
                BluetoothGattService bluetoothGattService = j10.get(i10);
                int size = bluetoothGattService.getCharacteristics().size();
                for (int i11 = 0; i11 < size; i11++) {
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristics().get(i11);
                    if (bluetoothGattCharacteristic.getUuid().toString().equals(UUID.fromString(c0.f27525a).toString())) {
                        boolean f10 = f(1000L);
                        u.d("sendTextKey", "APK--->BLE isBusy = " + f10);
                        if (!f10) {
                            bluetoothGattCharacteristic.setValue(bArr);
                            g(bluetoothGattCharacteristic);
                            StringBuilder sb2 = null;
                            if (bArr != null && bArr.length > 0) {
                                sb2 = new StringBuilder(bArr.length);
                                int length = bArr.length;
                                for (int i12 = 0; i12 < length; i12++) {
                                    sb2.append(String.format("%02X", Byte.valueOf(bArr[i12])));
                                }
                            }
                            u.d("sendTextKey", "APK--->BLE = " + ((Object) sb2));
                        }
                    }
                }
            }
            return;
        }
        u.d("sendTextKey", "bluetoothGattServices为空 mICallback =" + this.f26204d);
        e eVar = this.f26204d;
        if (eVar != null) {
            eVar.j(true, 19);
        }
    }

    public void V(boolean z10, boolean z11, boolean z12, int i10, int i11, int i12, int i13) {
        W(z.v(this.f26201a).t(), z10, z11, z12, i10, i11, i12, i13);
    }

    public void V0(byte[] bArr) {
        List<BluetoothGattService> j10 = j();
        if (j10 != null) {
            for (int i10 = 0; i10 < j10.size(); i10++) {
                BluetoothGattService bluetoothGattService = j10.get(i10);
                int size = bluetoothGattService.getCharacteristics().size();
                for (int i11 = 0; i11 < size; i11++) {
                    BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristics().get(i11);
                    if (bluetoothGattCharacteristic.getUuid().toString().equals(UUID.fromString(c0.f27527c).toString())) {
                        boolean f10 = f(1000L);
                        u.d("sendTextKey", "APK--->BLE isBusy5 = " + f10);
                        if (!f10) {
                            bluetoothGattCharacteristic.setValue(bArr);
                            if (!g(bluetoothGattCharacteristic)) {
                                try {
                                    Thread.sleep(20L);
                                    u.d("sendTextKey", "APK--->BLE 写不成功，延时 20ms 重新写 isWrite2 =" + g(bluetoothGattCharacteristic));
                                } catch (InterruptedException e10) {
                                    e10.printStackTrace();
                                }
                            }
                            StringBuilder sb2 = null;
                            if (bArr != null && bArr.length > 0) {
                                sb2 = new StringBuilder(bArr.length);
                                int length = bArr.length;
                                for (int i12 = 0; i12 < length; i12++) {
                                    sb2.append(String.format("%02X", Byte.valueOf(bArr[i12])));
                                }
                            }
                            u.d("sendTextKey", "APK--->BLE5 = " + ((Object) sb2));
                        }
                    }
                }
            }
            return;
        }
        u.d("stringBuilder", "bluetoothGattServices为空  19");
    }

    public void W(boolean z10, boolean z11, boolean z12, boolean z13, int i10, int i11, int i12, int i13) {
        z.v(this.f26201a).u0(z10);
        z.v(this.f26201a).q0(z12);
        z.v(this.f26201a).p0(z11);
        z.v(this.f26201a).r0(z13);
        z.v(this.f26201a).n0(i10);
        z.v(this.f26201a).o0(i11);
        z.v(this.f26201a).s0(i12);
        z.v(this.f26201a).t0(i13);
        boolean[] zArr = {z10, z11, z12};
        int[] iArr = {0, 0, 0, 0};
        for (int i14 = 0; i14 < 3; i14++) {
            iArr[i14] = zArr[i14] ? 1 : 0;
        }
        int i15 = (iArr[0] * 8) + (iArr[1] * 4) + (iArr[2] * 2) + iArr[3];
        u.a("WriteCharaToBLE", "a =" + i15);
        byte[] bArr = new byte[7];
        bArr[0] = -41;
        bArr[1] = (byte) i15;
        bArr[2] = (byte) (i10 & 255);
        bArr[3] = (byte) (i11 & 255);
        bArr[4] = (byte) (i12 & 255);
        bArr[5] = (byte) (i13 & 255);
        if (z13) {
            bArr[6] = 1;
        } else {
            bArr[6] = 0;
        }
        U0(bArr);
    }

    public void X(int i10) {
        U0(new byte[]{-85, 0, 0, 0, 1, (byte) i10, 2, 1});
    }

    public void Y(int i10) {
        u.d("languageKey", "sendLanguageSectionKey  languageTextData =" + this.F + "，isSendFDLanguage =" + this.G + ",i=" + i10);
        byte[] bArr = this.F;
        if (bArr != null) {
            if (i10 == 0) {
                this.G = false;
            }
            int length = bArr.length;
            u.d("languageKey", "sendLanguageSectionKey  length =" + length);
            int i11 = length / 18;
            int i12 = length % 18;
            u.d("languageKey", "length=" + length + ",sendCount =" + i11 + "，lastCount = " + i12);
            if (i10 < i11) {
                byte[] bArr2 = new byte[20];
                bArr2[0] = -81;
                bArr2[1] = (byte) (i10 & 255);
                int i13 = i10 * 18;
                for (int i14 = i13; i14 < 18 + i13; i14++) {
                    bArr2[(i14 - i13) + 2] = bArr[i14];
                }
                U0(bArr2);
                if (i12 == 0) {
                    this.G = true;
                }
                for (int i15 = 0; i15 < 20; i15++) {
                    String.format("%02X", Byte.valueOf(bArr2[i15]));
                }
                return;
            }
            u.d("languageKey", "isSendFDLanguage = " + this.G);
            if (this.G) {
                A();
                this.G = false;
            } else if (i12 != 0) {
                int i16 = i12 + 2;
                byte[] bArr3 = new byte[i16];
                bArr3[0] = -81;
                bArr3[1] = (byte) (i10 & 255);
                int i17 = i10 * 18;
                for (int i18 = i17 + 0; i18 < length; i18++) {
                    bArr3[(i18 - i17) + 2] = bArr[i18];
                }
                U0(bArr3);
                if (i16 > 0) {
                    new StringBuilder(i16);
                    for (int i19 = 0; i19 < i16; i19++) {
                        String.format("%02X", Byte.valueOf(bArr3[i19]));
                    }
                }
            }
            this.G = true;
        }
    }

    public void Z() {
        U0(new byte[]{-63, 4});
    }

    public void a0(byte[] bArr) {
        OnlineDialUtil.b("data =" + bArr.length);
        this.f26209i = 0;
        this.f26211k = bArr;
        this.f26212l = false;
        this.f26215o = 0;
        this.f26216p = 0;
        this.f26210j = z.v(this.f26201a).x();
        d0(this.f26209i);
    }

    public void b0(int i10) {
        U0(new byte[]{-85, 0, 0, 0, 1, (byte) i10, 0, 0});
    }

    public void c0() {
        int i10;
        int i11;
        int i12 = this.P;
        int i13 = (this.Q - 3) / 37;
        u.d("WriteCharaToBLE", "每次发送多少个联系人=" + i13);
        int size = this.S.size();
        int i14 = size / i13;
        int i15 = size % i13;
        u.d("WriteCharaToBLE", "sendCount=" + i14 + ",lastCount=" + i15 + ",section=" + i12);
        if (i12 < i14) {
            byte[] bArr = new byte[this.Q];
            bArr[0] = 55;
            bArr[1] = -5;
            bArr[2] = (byte) (i13 & 255);
            int i16 = i13 * i12;
            int i17 = 0;
            for (int i18 = i16; i18 < i13 * (i12 + 1); i18++) {
                int i19 = i17 + 1;
                if (i18 == i16) {
                    i19 += 2;
                }
                String b10 = this.S.get(i18).b();
                String a10 = this.S.get(i18).a();
                i16 = i16;
                int length = b10.length();
                i12 = i12;
                int length2 = a10.length();
                i13 = i13;
                u.d("WriteCharaToBLE", "导入数据 phone=" + b10 + ",name=" + a10 + ",phoneLength=" + length + ",nameLength=" + length2);
                if (length > 15) {
                    i11 = 0;
                    b10 = b10.substring(0, 15);
                } else {
                    i11 = 0;
                }
                if (length2 > 10) {
                    a10 = a10.substring(i11, 10);
                }
                String m10 = gn.n.d(this.f26201a).m(b10);
                String o10 = gn.n.d(this.f26201a).o(a10);
                u.d("WriteCharaToBLE", "phoneS=" + m10);
                u.d("WriteCharaToBLE", "nameS=" + o10);
                byte[] j10 = gn.n.d(this.f26201a).j(m10);
                byte[] j11 = gn.n.d(this.f26201a).j(o10);
                int length3 = j10.length;
                int length4 = j11.length;
                bArr[i19] = 55;
                int i20 = i19 + 1;
                bArr[i20] = -5;
                int i21 = i20 + 1;
                bArr[i21] = (byte) (length3 & 255);
                i17 = i21 + 1;
                bArr[i17] = (byte) (length4 & 255);
                for (byte b11 : j10) {
                    i17++;
                    bArr[i17] = b11;
                }
                for (byte b12 : j11) {
                    i17++;
                    bArr[i17] = b12;
                }
            }
            if (i15 == 0) {
                this.R = true;
            }
            this.P++;
            V0(bArr);
            return;
        }
        u.d("WriteCharaToBLE", "准备发尾数 isSendContactFinish=" + this.R + ",lastCount=" + i15);
        if (this.R) {
            T();
            this.R = false;
        } else if (i15 != 0) {
            byte[] bArr2 = new byte[this.Q];
            bArr2[0] = 55;
            int i22 = 1;
            bArr2[1] = -5;
            bArr2[2] = (byte) (i15 & 255);
            int i23 = i14 * i13;
            int i24 = 0;
            while (i23 < size) {
                int i25 = i24 + i22;
                if (i23 == i13 * i12) {
                    i25 += 2;
                }
                String b13 = this.S.get(i23).b();
                String a11 = this.S.get(i23).a();
                int length5 = b13.length();
                int length6 = a11.length();
                size = size;
                u.d("WriteCharaToBLE", "导入数据 phone=" + b13 + ",name=" + a11 + ",phoneLength=" + length5 + ",nameLength=" + length6);
                if (length5 > 15) {
                    i10 = 0;
                    b13 = b13.substring(0, 15);
                } else {
                    i10 = 0;
                }
                if (length6 > 10) {
                    a11 = a11.substring(i10, 10);
                }
                String m11 = gn.n.d(this.f26201a).m(b13);
                String o11 = gn.n.d(this.f26201a).o(a11);
                u.d("WriteCharaToBLE", "phoneS=" + m11);
                u.d("WriteCharaToBLE", "nameS=" + o11);
                byte[] j12 = gn.n.d(this.f26201a).j(m11);
                byte[] j13 = gn.n.d(this.f26201a).j(o11);
                int length7 = j12.length;
                int length8 = j13.length;
                bArr2[i25] = 55;
                int i26 = i25 + 1;
                bArr2[i26] = -5;
                int i27 = i26 + 1;
                bArr2[i27] = (byte) (length7 & 255);
                int i28 = i27 + 1;
                bArr2[i28] = (byte) (length8 & 255);
                int i29 = i28;
                for (byte b14 : j12) {
                    i29++;
                    bArr2[i29] = b14;
                }
                i24 = i29;
                for (byte b15 : j13) {
                    i24++;
                    bArr2[i24] = b15;
                }
                i23++;
                i22 = 1;
            }
            this.P++;
            this.R = true;
            V0(bArr2);
        }
    }

    public void d0(int i10) {
        int i11;
        Handler handler;
        long j10;
        int i12;
        byte[] bArr = this.f26211k;
        if (bArr != null) {
            int i13 = this.f26210j - 3;
            int length = bArr.length;
            int i14 = length / i13;
            int i15 = length % i13;
            if (i10 == 0) {
                this.f26212l = false;
                if (i15 == 0) {
                    this.f26214n = i14;
                } else {
                    this.f26214n = i14 + 1;
                }
            }
            if (i10 < i14) {
                byte[] bArr2 = new byte[i13 + 3];
                bArr2[0] = 39;
                bArr2[1] = (byte) ((i10 & 65280) >> 8);
                bArr2[2] = (byte) (i10 & 255);
                int i16 = i13 * i10;
                int i17 = i16;
                while (true) {
                    i11 = (i10 + 1) * i13;
                    if (i17 >= i11) {
                        break;
                    }
                    bArr2[(i17 - i16) + 3] = bArr[i17];
                    i17++;
                }
                V0(bArr2);
                Message message = new Message();
                message.what = 2;
                if (i10 == i14 - 1 && i15 == 0) {
                    this.f26212l = true;
                    OnlineDialUtil.b("0最后一条延迟" + this.f26213m + "ms, section =" + i10);
                    handler = this.f26208h;
                    i12 = this.f26213m;
                } else {
                    int i18 = i11 / 4096;
                    this.f26216p = i18;
                    if (this.f26215o != i18) {
                        this.f26215o = i18;
                        OnlineDialUtil.b("等待BLE返回260304,section =" + i10);
                        this.f26205e.e(1);
                        return;
                    } else if (i10 > 0 && i10 % 10 == 0) {
                        OnlineDialUtil.b("延迟 " + OnlineDialUtil.f24597c + " ms,section =" + i10);
                        handler = this.f26208h;
                        i12 = OnlineDialUtil.f24597c;
                    } else if (this.f26206f) {
                        handler = this.f26208h;
                        j10 = 10;
                        handler.sendMessageDelayed(message, j10);
                        return;
                    } else {
                        this.f26208h.sendMessage(message);
                        return;
                    }
                }
                j10 = i12;
                handler.sendMessageDelayed(message, j10);
                return;
            }
            OnlineDialUtil.b("isSendFinisCommand = " + this.f26212l);
            if (this.f26212l) {
                J();
                this.f26212l = false;
                this.f26208h.removeMessages(2);
            } else if (i15 != 0) {
                byte[] bArr3 = new byte[i15 + 3];
                bArr3[0] = 39;
                bArr3[1] = (byte) ((i10 & 65280) >> 8);
                bArr3[2] = (byte) (i10 & 255);
                int i19 = i13 * i10;
                for (int i20 = i19; i20 < length; i20++) {
                    bArr3[(i20 - i19) + 3] = bArr[i20];
                }
                V0(bArr3);
                Message message2 = new Message();
                message2.what = 2;
                OnlineDialUtil.b("1最后一条延迟" + this.f26213m + "ms, section =" + i10);
                this.f26208h.sendMessageDelayed(message2, (long) this.f26213m);
            }
            this.f26212l = true;
        }
    }

    public void e0(int i10, int i11, int i12, int i13, int i14, int i15, boolean z10) {
        byte[] bArr;
        if (p.f(this.f26201a, 16)) {
            bArr = new byte[12];
            bArr[7] = (byte) (i12 & 255);
            bArr[8] = (byte) (i13 & 255);
            bArr[9] = (byte) (i14 & 255);
            bArr[10] = (byte) (i15 & 255);
            if (z10) {
                bArr[11] = 1;
            } else {
                bArr[11] = 0;
            }
        } else {
            bArr = new byte[7];
        }
        bArr[0] = -45;
        if (i10 == 1) {
            bArr[1] = 1;
        } else {
            bArr[1] = 0;
        }
        bArr[2] = (byte) (i11 & 255);
        bArr[3] = 2;
        bArr[4] = 3;
        bArr[5] = 1;
        bArr[6] = 0;
        U0(bArr);
    }

    public void f0(int i10, int i11, int i12, int i13, boolean z10, boolean z11, int i14, boolean z12, int i15, boolean z13, boolean z14, int i16, int i17, boolean z15) {
        int i18 = i10;
        u.d("WriteCharaToBLE", "height =" + i10 + ",weight =" + i11);
        int i19 = (int) (((double) i18) * 0.418d);
        z v10 = z.v(this.f26201a);
        v10.C0(i10 + "");
        z v11 = z.v(this.f26201a);
        v11.E0(i11 + "");
        z v12 = z.v(this.f26201a);
        v12.D0(i19 + "");
        z.v(this.f26201a).A0(i15);
        byte[] bArr = new byte[19];
        bArr[0] = -87;
        bArr[1] = 0;
        if (!p.f(this.f26201a, 4096)) {
            i18 = i19;
        }
        bArr[2] = (byte) (i18 & 255);
        bArr[4] = (byte) (i11 & 255);
        bArr[3] = (byte) ((i11 & 65280) >> 8);
        bArr[5] = (byte) (i12 & 255);
        bArr[9] = (byte) (i13 & 255);
        bArr[8] = (byte) ((65280 & i13) >> 8);
        bArr[7] = (byte) ((16711680 & i13) >> 16);
        bArr[6] = (byte) (((-16777216) & i13) >> 24);
        if (z10) {
            bArr[10] = 1;
        } else {
            bArr[10] = 0;
        }
        if (z11) {
            bArr[11] = (byte) i14;
        } else {
            bArr[11] = -2;
        }
        bArr[12] = 0;
        bArr[13] = (byte) (i15 & 255);
        if (z12) {
            bArr[14] = 1;
            z.v(this.f26201a).B0(true);
        } else {
            bArr[14] = 2;
            z.v(this.f26201a).B0(false);
        }
        if (p.f(this.f26201a, 4)) {
            if (z13) {
                bArr[15] = 1;
            } else {
                bArr[15] = 0;
            }
        }
        if (p.h(this.f26201a, 1024)) {
            if (z15) {
                bArr[16] = 2;
            } else {
                bArr[16] = 1;
            }
        }
        if (p.h(this.f26201a, 4096)) {
            if (i17 == 0) {
                bArr[17] = 1;
            } else if (i17 == 1) {
                bArr[17] = 2;
            }
        }
        if (p.e(this.f26201a, 2048)) {
            if (z14) {
                bArr[18] = (byte) i16;
            } else {
                bArr[18] = 0;
            }
        }
        U0(bArr);
    }

    public void g0(int i10) {
        u.d("sendTextKey", "sendTextSectionKey  textData =" + this.f26220t + "，isSendFD =" + this.f26221u + ",i=" + i10);
        byte[] bArr = this.f26220t;
        if (bArr != null) {
            if (i10 == 0) {
                this.f26221u = false;
            }
            int length = bArr.length;
            u.d("sendTextKey", "sendTextSectionKey  length =" + length);
            if (length > 162) {
                length = 162;
            }
            int i11 = length / 18;
            int i12 = length % 18;
            u.d("sendTextKey", "length=" + length + ",sendCount =" + i11 + "，lastCount = " + i12);
            if (i10 < i11) {
                byte[] bArr2 = new byte[20];
                bArr2[0] = -59;
                bArr2[1] = (byte) (i10 & 255);
                int i13 = i10 * 18;
                for (int i14 = i13; i14 < 18 + i13; i14++) {
                    bArr2[(i14 - i13) + 2] = bArr[i14];
                }
                U0(bArr2);
                if (i12 == 0) {
                    this.f26221u = true;
                }
                for (int i15 = 0; i15 < 20; i15++) {
                    String.format("%02X", Byte.valueOf(bArr2[i15]));
                }
                return;
            }
            u.d("sendTextKey", "isSendFD = " + this.f26221u);
            if (this.f26221u) {
                E();
                this.f26221u = false;
            } else if (i12 != 0) {
                int i16 = i12 + 2;
                byte[] bArr3 = new byte[i16];
                bArr3[0] = -59;
                bArr3[1] = (byte) (i10 & 255);
                int i17 = i10 * 18;
                for (int i18 = i17 + 0; i18 < length; i18++) {
                    bArr3[(i18 - i17) + 2] = bArr[i18];
                }
                U0(bArr3);
                if (i16 > 0) {
                    new StringBuilder(i16);
                    for (int i19 = 0; i19 < i16; i19++) {
                        String.format("%02X", Byte.valueOf(bArr3[i19]));
                    }
                }
            }
            this.f26221u = true;
        }
    }

    public void h0(int i10) {
        byte[] bArr = this.f26220t;
        if (bArr != null) {
            if (i10 == 0) {
                this.f26221u = false;
            }
            int length = bArr.length;
            if (length > 32) {
                length = 32;
            }
            int i11 = length / 18;
            int i12 = length % 18;
            u.d("sendTextKey", "length=" + length + ",sendCount =" + i11 + "，lastCount = " + i12);
            if (i10 < i11) {
                byte[] bArr2 = new byte[20];
                bArr2[0] = -58;
                bArr2[1] = (byte) (i10 & 255);
                int i13 = i10 * 18;
                for (int i14 = i13; i14 < 18 + i13; i14++) {
                    bArr2[(i14 - i13) + 2] = bArr[i14];
                }
                U0(bArr2);
                if (i12 == 0) {
                    this.f26221u = true;
                }
                StringBuilder sb2 = new StringBuilder(20);
                for (int i15 = 0; i15 < 20; i15++) {
                    sb2.append(String.format("%02X", Byte.valueOf(bArr2[i15])));
                }
                u.d("sendTextKey", "APK--->BLE1 = " + ((Object) sb2) + ",i=" + i10);
                return;
            }
            if (this.f26221u) {
                this.f26221u = false;
                G();
            } else if (i12 != 0) {
                int i16 = i12 + 2;
                byte[] bArr3 = new byte[i16];
                bArr3[0] = -58;
                bArr3[1] = (byte) (i10 & 255);
                int i17 = i10 * 18;
                for (int i18 = i17 + 0; i18 < length; i18++) {
                    bArr3[(i18 - i17) + 2] = bArr[i18];
                }
                U0(bArr3);
                StringBuilder sb3 = null;
                if (i16 > 0) {
                    sb3 = new StringBuilder(i16);
                    for (int i19 = 0; i19 < i16; i19++) {
                        sb3.append(String.format("%02X", Byte.valueOf(bArr3[i19])));
                    }
                }
                u.d("sendTextKey", "APK--->BLE2 = " + ((Object) sb3));
            }
            this.f26221u = true;
        }
    }

    public void i0(String str, int i10) {
        String str2;
        u.d("sendTextKey", "sendTextKey body =" + str);
        gn.n d10 = gn.n.d(this.f26201a);
        if (p.c(this.f26201a, 4)) {
            str2 = d10.o(str);
        } else {
            byte[] bArr = null;
            try {
                bArr = str.getBytes("GB2312");
            } catch (UnsupportedEncodingException e10) {
                e10.printStackTrace();
            }
            str2 = d10.c(bArr);
        }
        byte[] h10 = d10.h(str2, i10);
        u.d("sendTextKey", "body =" + str + "，dataString = " + str2 + ",data =" + h10 + ",messageType =" + i10);
        if (h10 != null) {
            this.f26220t = h10;
            this.f26219s = 0;
            this.f26221u = false;
            g0(0);
        }
    }

    public void j0(String str, int i10) {
        String str2;
        u.d("sendTextKey", "sendTextKey6 body =" + str);
        if (str == null || str.equals("")) {
            str = "unkown";
        }
        u.a("sendTextKey", "转化后body=" + str);
        gn.n d10 = gn.n.d(this.f26201a);
        if (p.c(this.f26201a, 4)) {
            str2 = d10.o(str);
        } else {
            byte[] bArr = null;
            try {
                bArr = str.getBytes("GB2312");
            } catch (UnsupportedEncodingException e10) {
                e10.printStackTrace();
            }
            str2 = d10.c(bArr);
        }
        byte[] i11 = d10.i(str2, i10);
        u.d("sendTextKey", "body =" + str + "，dataString = " + str2 + ",data =" + i11);
        if (i11 != null) {
            this.f26220t = i11;
            this.f26219s = 0;
            this.f26221u = false;
            h0(0);
        }
    }

    public void k0() {
        U0(new byte[]{-94});
    }

    public void l0() {
        U0(new byte[]{-95});
    }

    public void m(boolean z10) {
        byte[] bArr = new byte[3];
        bArr[0] = 62;
        bArr[1] = 0;
        if (z10) {
            bArr[2] = -3;
        } else {
            bArr[2] = -1;
        }
        V0(bArr);
    }

    public void m0(int i10, byte b10, int i11, int i12, boolean z10, int i13) {
        if (b10 == 0) {
            b10 = 62;
        }
        byte b11 = (byte) i11;
        byte b12 = (byte) i12;
        if (i10 != 0) {
            byte[] bArr = new byte[9];
            if (!z10) {
                bArr[0] = -85;
                bArr[1] = b10;
                bArr[2] = b11;
                bArr[3] = b12;
                bArr[4] = 0;
                bArr[5] = 0;
                bArr[6] = 0;
            } else if (b10 == 0) {
                bArr[0] = -85;
                bArr[1] = b10;
                bArr[2] = b11;
                bArr[3] = b12;
                bArr[4] = 2;
                bArr[5] = 0;
                bArr[6] = 0;
            } else {
                bArr[0] = -85;
                bArr[1] = b10;
                bArr[2] = b11;
                bArr[3] = b12;
                bArr[4] = 2;
                bArr[5] = (byte) (i13 & 255);
                bArr[6] = 2;
            }
            bArr[7] = 0;
            bArr[8] = (byte) (i10 & 255);
            U0(bArr);
        }
    }

    public void n(byte[] bArr) {
        if (bArr == null) {
            u.f("WriteCharaToBLE", "cSBpSendCalibrationCO  data =" + bArr);
            return;
        }
        this.M = bArr;
        this.L = 0;
        this.O = (byte) 0;
        this.f26210j = z.v(this.f26201a).x();
        p(this.L);
    }

    public void n0(int i10, int i11) {
        byte[] bArr = new byte[3];
        bArr[0] = -96;
        if (i10 == 2) {
            bArr[1] = 2;
            z.v(this.f26201a).y0(false);
        } else {
            bArr[1] = 1;
            z.v(this.f26201a).y0(true);
        }
        if (i11 == 2) {
            bArr[2] = 2;
        } else {
            bArr[2] = 1;
        }
        U0(bArr);
    }

    public void o(byte b10) {
        V0(new byte[]{62, 1, -3, b10});
    }

    public void o0(byte b10) {
        U0(new byte[]{-10, -3, b10});
    }

    public void p(int i10) {
        if (i10 == 0) {
            this.O = (byte) 0;
            this.N = false;
        }
        byte[] bArr = this.M;
        int i11 = this.f26210j - 4;
        int length = bArr.length;
        int i12 = length % i11;
        if (i10 < length / i11) {
            byte[] bArr2 = new byte[i11 + 4];
            bArr2[0] = 62;
            bArr2[1] = 1;
            bArr2[2] = -6;
            bArr2[3] = (byte) (i10 & 255);
            int i13 = i10 * i11;
            for (int i14 = i13; i14 < i11 + i13; i14++) {
                int i15 = (i14 - i13) + 4;
                bArr2[i15] = bArr[i14];
                this.O = (byte) (bArr2[i15] ^ this.O);
            }
            V0(bArr2);
            if (i12 != 0) {
                return;
            }
        } else if (this.N) {
            o(this.O);
            this.N = false;
        } else if (i12 != 0) {
            byte[] bArr3 = new byte[i12 + 4];
            bArr3[0] = 62;
            bArr3[1] = 1;
            bArr3[2] = -6;
            bArr3[3] = (byte) (i10 & 255);
            int i16 = i11 * i10;
            for (int i17 = i16; i17 < length; i17++) {
                int i18 = (i17 - i16) + 4;
                bArr3[i18] = bArr[i17];
                this.O = (byte) (bArr3[i18] ^ this.O);
            }
            V0(bArr3);
        }
        this.N = true;
    }

    public void p0(byte b10) {
        V0(new byte[]{-10, -1, -3, b10});
    }

    public void q(int i10) {
        byte[] bArr = new byte[2];
        bArr[0] = -18;
        if (i10 == 1) {
            bArr[1] = 1;
        } else if (i10 == 2) {
            bArr[1] = 2;
        } else {
            return;
        }
        U0(bArr);
    }

    public void q0(int i10) {
        U0(new byte[]{-10, (byte) i10});
    }

    public void r() {
        String string = this.f26202b.getString("device_feature_key", "");
        if (!string.equals("") && string.length() == 8) {
            String substring = string.substring(string.length() - 2, string.length());
            if (substring.equals("01")) {
                q(1);
            } else if (substring.equals("02")) {
                q(2);
            }
        }
    }

    public void r0(int i10) {
        V0(new byte[]{-10, (byte) ((i10 & 65280) >> 8), (byte) (i10 & 255)});
    }

    public void s() {
        if (this.f26207g) {
            D0();
        }
    }

    public void s0(e eVar) {
        this.f26204d = eVar;
    }

    public void t(int i10) {
        int size = this.J.size();
        int c10 = z.v(this.f26201a).c();
        int b10 = z.v(this.f26201a).b();
        if (size < c10 || size > b10) {
            u.d("sendTextKey", "运动列表个数不在手环支持范围内");
            return;
        }
        int i11 = size / 15;
        int i12 = size % 15;
        u.d("sendTextKey", "sendCount=" + i11 + ",lastCount=" + i12 + ",supList=" + new e().s(this.J));
        int i13 = 0;
        if (i11 == 0) {
            byte[] bArr = new byte[i12 + 5];
            bArr[0] = -3;
            bArr[1] = 85;
            bArr[2] = 0;
            bArr[4] = (byte) (size & 255);
            bArr[3] = (byte) ((size & 65280) >> 8);
            while (i13 < i12) {
                int intValue = this.J.get(i13).intValue();
                u.d("sendTextKey", "num=" + intValue);
                bArr[i13 + 5] = (byte) (intValue & 255);
                i13++;
            }
            U0(bArr);
            return;
        }
        u.d("sendTextKey", "i=" + i10);
        if (i10 < i11) {
            byte[] bArr2 = new byte[20];
            bArr2[0] = -3;
            bArr2[1] = 85;
            bArr2[2] = (byte) (i10 & 255);
            bArr2[4] = (byte) (size & 255);
            bArr2[3] = (byte) ((size & 65280) >> 8);
            int i14 = i10 * 15;
            int i15 = i14;
            for (int i16 = 15; i15 < i16 + i14; i16 = 15) {
                int intValue2 = this.J.get(i15).intValue();
                u.d("sendTextKey", "num=" + intValue2);
                bArr2[(i15 - i14) + 5] = (byte) (intValue2 & 255);
                i15++;
            }
            U0(bArr2);
            return;
        }
        byte[] bArr3 = new byte[i12 + 3];
        bArr3[0] = -3;
        bArr3[1] = 85;
        bArr3[2] = (byte) (i10 & 255);
        while (i13 < i12) {
            int intValue3 = this.J.get((15 * i10) + i13).intValue();
            u.d("sendTextKey", "num=" + intValue3);
            bArr3[i13 + 3] = (byte) (intValue3 & 255);
            i13++;
        }
        U0(bArr3);
    }

    public void t0(boolean z10) {
        this.B = z10;
    }

    public void u(int i10) {
        if (p.d(this.f26201a, 1)) {
            U0(new byte[]{-47, 12, (byte) (i10 & 255)});
        }
    }

    public void u0(boolean z10, int i10, int i11) {
        this.H = i10;
        this.I = i11;
        byte[] bArr = new byte[4];
        bArr[0] = -3;
        if (z10) {
            bArr[1] = 17;
        } else {
            bArr[1] = 0;
        }
        bArr[2] = (byte) (i10 & 255);
        if (i11 <= 0 || i11 > 255) {
            bArr[3] = 1;
        } else {
            bArr[3] = (byte) (255 & i11);
        }
        U0(bArr);
    }

    public void v(int i10, int i11, float f10, int i12, float f11, boolean z10, boolean z11) {
        String b10;
        if (!p.d(this.f26201a, 2)) {
            Log.i("WriteCharaToBLE", "不支持运动控制同步");
            return;
        }
        String u10 = z.v(this.f26201a).u();
        int intValue = Integer.valueOf(d0.b((((u10.length() <= 2 || !u10.contains("V")) ? 0 : Integer.valueOf(gn.n.d(this.f26201a).n(u10.substring(u10.indexOf("V") + 1))).intValue()) >= 1090 || !p.g(this.f26201a, 2048) || z10) ? f11 : d0.c(f11)).split("\\.")[0]).intValue();
        int intValue2 = (int) (((Integer.valueOf(b10.split("\\.")[1]).intValue() / 100.0f) * 60.0f) % 60.0f);
        if ((intValue * 60) + intValue2 > 5999.0f) {
            intValue2 = 0;
            intValue = 0;
        }
        int i13 = i11 / 3600;
        int i14 = i11 % 3600;
        int i15 = i14 / 60;
        int i16 = i14 % 60;
        String str = d0.b(f10 / 1000.0f) + "";
        int intValue3 = d0.a(str.split("\\.")[0]).intValue();
        int intValue4 = d0.a(str.split("\\.")[1]).intValue();
        byte[] bArr = z11 ? new byte[13] : new byte[7];
        bArr[0] = -3;
        if (i10 == 22) {
            bArr[1] = 34;
        } else if (i10 == 33) {
            bArr[1] = 51;
        } else if (i10 == 44) {
            bArr[1] = 68;
        }
        bArr[2] = (byte) (this.H & 255);
        int i17 = this.I;
        if (i17 <= 0 || i17 > 255) {
            bArr[3] = 1;
        } else {
            bArr[3] = (byte) (i17 & 255);
        }
        bArr[4] = (byte) (i13 & 255);
        bArr[5] = (byte) (i15 & 255);
        bArr[6] = (byte) (i16 & 255);
        if (z11) {
            bArr[7] = (byte) ((65280 & i12) >> 8);
            bArr[8] = (byte) (i12 & 255);
            bArr[9] = (byte) (intValue3 & 255);
            bArr[10] = (byte) (intValue4 & 255);
            bArr[11] = (byte) (intValue & 255);
            bArr[12] = (byte) (intValue2 & 255);
        }
        U0(bArr);
    }

    public void v0(boolean z10, String str, int i10, int i11) {
        if (str != null && str.length() == 8) {
            int intValue = Integer.valueOf(str.substring(0, 4)).intValue();
            int intValue2 = Integer.valueOf(str.substring(4, 6)).intValue();
            int intValue3 = Integer.valueOf(str.substring(6, 8)).intValue();
            byte[] bArr = new byte[8];
            bArr[0] = 41;
            if (z10) {
                bArr[1] = 1;
            } else {
                bArr[1] = 0;
            }
            bArr[3] = (byte) (intValue & 255);
            bArr[2] = (byte) ((65280 & intValue) >> 8);
            bArr[4] = (byte) (intValue2 & 255);
            bArr[5] = (byte) (intValue3 & 255);
            bArr[6] = (byte) (i10 & 255);
            bArr[7] = (byte) (i11 & 255);
            U0(bArr);
        }
    }

    public void w(s sVar) {
        v(sVar.e(), sVar.c(), sVar.b(), sVar.a(), sVar.d(), sVar.g(), sVar.f());
    }

    public void w0(n nVar) {
        this.f26217q = nVar;
    }

    public void x0() {
        Handler handler = this.f26208h;
        if (handler != null) {
            this.f26211k = null;
            this.f26215o = 0;
            this.f26216p = 0;
            handler.removeMessages(2);
        }
    }

    public void y() {
        U0(new byte[]{-83});
    }

    public void y0() {
        z0("");
    }

    public void z(int i10) {
        U0(new byte[]{-85, 0, 0, 0, 1, (byte) i10, 7, 1});
    }

    public void z0(String str) {
        BluetoothLeService bluetoothLeService = this.f26203c;
        if (bluetoothLeService != null) {
            bluetoothLeService.e1(FusedLocationConstants.DEFAULT_INTERVAL, 93);
        }
        U0(en.b.d(this.f26201a).c(2, str));
    }
}
