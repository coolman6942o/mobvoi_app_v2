package fn;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import bp.k;
import bp.n;
import bp.o;
import com.alipay.sdk.app.PayTask;
import com.huawei.hms.scankit.C0559e;
import com.mobvoi.wear.util.LogCleaner;
import com.realsil.sdk.dfu.model.DfuConfig;
import com.realsil.sdk.dfu.model.DfuProgressInfo;
import com.realsil.sdk.dfu.model.Throughput;
import com.unionpay.tsmservice.data.Constant;
import com.yc.pedometer.sdk.BluetoothLeService;
import com.yc.pedometer.update.DfuService;
import en.q;
import en.r;
import gn.c0;
import gn.p;
import gn.u;
import gn.z;
import hn.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import lm.b;
import lm.c;
import wk.a;
/* loaded from: classes2.dex */
public class a implements r {
    private static a Y;
    private ArrayList<Integer> G;
    private ArrayList<Byte> H;
    protected lm.e O;
    private DfuConfig P;
    private cm.d R;
    private en.f V;

    /* renamed from: a  reason: collision with root package name */
    private Context f27091a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences f27092b;

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences.Editor f27093c;

    /* renamed from: d  reason: collision with root package name */
    private com.yc.pedometer.sdk.a f27094d;

    /* renamed from: e  reason: collision with root package name */
    private BluetoothLeService f27095e;

    /* renamed from: h  reason: collision with root package name */
    private q f27098h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f27099i;

    /* renamed from: l  reason: collision with root package name */
    private Handler f27102l;

    /* renamed from: n  reason: collision with root package name */
    private String f27104n;

    /* renamed from: f  reason: collision with root package name */
    private String f27096f = "";

    /* renamed from: g  reason: collision with root package name */
    private int f27097g = 2;

    /* renamed from: j  reason: collision with root package name */
    private BroadcastReceiver f27100j = new C0290a();

    /* renamed from: k  reason: collision with root package name */
    public Runnable f27101k = new b();

    /* renamed from: m  reason: collision with root package name */
    private long f27103m = 0;

    /* renamed from: o  reason: collision with root package name */
    int[] f27105o = {0, 1996959894, -301047508, -1727442502, 124634137, 1886057615, -379345611, -1637575261, 249268274, 2044508324, -522852066, -1747789432, 162941995, 2125561021, -407360249, -1866523247, 498536548, 1789927666, -205950648, -2067906082, 450548861, 1843258603, -187386543, -2083289657, 325883990, 1684777152, -43845254, -1973040660, 335633487, 1661365465, -99664541, -1928851979, 997073096, 1281953886, -715111964, -1570279054, 1006888145, 1258607687, -770865667, -1526024853, 901097722, 1119000684, -608450090, -1396901568, 853044451, 1172266101, -589951537, -1412350631, 651767980, 1373503546, -925412992, -1076862698, 565507253, 1454621731, -809855591, -1195530993, 671266974, 1594198024, -972236366, -1324619484, 795835527, 1483230225, -1050600021, -1234817731, 1994146192, 31158534, -1731059524, -271249366, 1907459465, 112637215, -1614814043, -390540237, 2013776290, 251722036, -1777751922, -519137256, 2137656763, 141376813, -1855689577, -429695999, 1802195444, 476864866, -2056965928, -228458418, 1812370925, 453092731, -2113342271, -183516073, 1706088902, 314042704, -1950435094, -54949764, 1658658271, 366619977, -1932296973, -69972891, 1303535960, 984961486, -1547960204, -725929758, 1256170817, 1037604311, -1529756563, -740887301, 1131014506, 879679996, -1385723834, -631195440, 1141124467, 855842277, -1442165665, -586318647, 1342533948, 654459306, -1106571248, -921952122, 1466479909, 544179635, -1184443383, -832445281, 1591671054, 702138776, -1328506846, -942167884, 1504918807, 783551873, -1212326853, -1061524307, -306674912, -1698712650, 62317068, 1957810842, -355121351, -1647151185, 81470997, 1943803523, -480048366, -1805370492, 225274430, 2053790376, -468791541, -1828061283, 167816743, 2097651377, -267414716, -2029476910, 503444072, 1762050814, -144550051, -2140837941, 426522225, 1852507879, -19653770, -1982649376, 282753626, 1742555852, -105259153, -1900089351, 397917763, 1622183637, -690576408, -1580100738, 953729732, 1340076626, -776247311, -1497606297, 1068828381, 1219638859, -670225446, -1358292148, 906185462, 1090812512, -547295293, -1469587627, 829329135, 1181335161, -882789492, -1134132454, 628085408, 1382605366, -871598187, -1156888829, 570562233, 1426400815, -977650754, -1296233688, 733239954, 1555261956, -1026031705, -1244606671, 752459403, 1541320221, -1687895376, -328994266, 1969922972, 40735498, -1677130071, -351390145, 1913087877, 83908371, -1782625662, -491226604, 2075208622, 213261112, -1831694693, -438977011, 2094854071, 198958881, -2032938284, -237706686, 1759359992, 534414190, -2118248755, -155638181, 1873836001, 414664567, -2012718362, -15766928, 1711684554, 285281116, -1889165569, -127750551, 1634467795, 376229701, -1609899400, -686959890, 1308918612, 956543938, -1486412191, -799009033, 1231636301, 1047427035, -1362007478, -640263460, 1088359270, 936918000, -1447252397, -558129467, 1202900863, 817233897, -1111625188, -893730166, 1404277552, 615818150, -1160759803, -841546093, 1423857449, 601450431, -1285129682, -1000256840, 1567103746, 711928724, -1274298825, -1022587231, 1510334235, 755167117};

    /* renamed from: p  reason: collision with root package name */
    private int f27106p = 2;

    /* renamed from: q  reason: collision with root package name */
    private int f27107q = 3;

    /* renamed from: r  reason: collision with root package name */
    private int f27108r = 80;

    /* renamed from: s  reason: collision with root package name */
    private int f27109s = 3;

    /* renamed from: t  reason: collision with root package name */
    private int f27110t = 0;

    /* renamed from: u  reason: collision with root package name */
    private int f27111u = 6;

    /* renamed from: v  reason: collision with root package name */
    private int f27112v = 5;

    /* renamed from: w  reason: collision with root package name */
    private int f27113w = 1;

    /* renamed from: x  reason: collision with root package name */
    private int f27114x = -1;

    /* renamed from: y  reason: collision with root package name */
    public boolean f27115y = false;

    /* renamed from: z  reason: collision with root package name */
    private int f27116z = 240;
    private int A = 0;
    private int B = 0;
    private int C = 0;
    private int D = 20;
    private int E = 0;
    private int F = 0;
    private boolean I = false;
    private boolean J = false;
    private boolean K = false;
    private Runnable L = new e();
    private int M = 0;
    private byte[] N = {78, 70, -8, -59, 9, 85, 84, 69, 95, 82, 75, 12, -47, -10, 16, -5, 31, 103, 99, -33, Byte.MIN_VALUE, 122, 126, 112, -106, 13, 76, -45, 17, -114, 96, 26};
    private boolean Q = false;
    private boolean S = false;
    private boolean T = false;
    private final c.b U = new f();
    private Runnable W = new g();
    private final k X = new h();

    /* renamed from: fn.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0290a extends BroadcastReceiver {
        C0290a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Message message;
            String action = intent.getAction();
            u.d("stringBuilder", "action=" + action);
            if (action.equals("img_download_finish_action")) {
                u.d("Updates", "收到升级广播   isRKPlatform = " + a.this.f27099i);
                if (Environment.getExternalStorageState().equals("mounted")) {
                    String str = a.this.f27091a.getExternalFilesDir(null) + "/" + fn.c.f27135j;
                    u.d("Updates", "imgDir =" + str);
                    a.this.j0(str);
                    return;
                }
                Toast.makeText(a.this.f27091a, "SDCard Exception", 0).show();
                return;
            }
            if (action.equals("img_download_fail_action")) {
                message = new Message();
                message.what = 101;
                if (a.this.f27102l == null) {
                    return;
                }
            } else if (action.equals("send_device_info_action")) {
                a.this.f0(BluetoothLeService.f24600m1);
                return;
            } else if (action.equals("bluetooth.le.ACTION_GATT_FAILURE_daydaybandsdk")) {
                if (!a.this.f27099i && !a.this.f27092b.getBoolean("bluetooth_reboot_success_key", false)) {
                    gn.q.f27585d = false;
                    message = new Message();
                    message.what = 102;
                    a.this.K = false;
                    message.obj = Boolean.valueOf(a.this.K);
                    if (a.this.f27102l == null) {
                        return;
                    }
                } else {
                    return;
                }
            } else if (action.equals("change_device_feature_success_action")) {
                boolean a10 = gn.e.a();
                a.this.f27093c.putBoolean("bluetooth_reboot_success_key", a10);
                a.this.f27093c.commit();
                u.d("Updates", "重启蓝牙 reBoot =" + a10);
                if (a10 && a.this.f27102l != null) {
                    a.this.f27102l.postDelayed(a.this.L, 5000L);
                    return;
                }
                return;
            } else if (action.equals("bluetooth_reboot_success_action")) {
                a.this.o();
                return;
            } else if (action.equals("device_feature_is_invalid")) {
                message = new Message();
                message.what = 102;
                a.this.K = false;
                message.obj = Boolean.valueOf(a.this.K);
                if (a.this.f27102l == null) {
                    return;
                }
            } else if (action.equals(gn.q.f27594m)) {
                a.this.G();
                if (a.this.f27102l != null) {
                    a.this.f27102l.postDelayed(a.this.f27101k, PayTask.f6879j);
                }
                u.d("onBtImgUpdate", "收到广播，准备开始第二次升级");
                return;
            } else {
                return;
            }
            a.this.f27102l.sendMessage(message);
        }
    }

    /* loaded from: classes2.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.u();
            if (a.this.f27102l != null) {
                a.this.f27102l.removeCallbacks(a.this.f27101k);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements a.AbstractC0303a {
        c() {
        }

        @Override // hn.a.AbstractC0303a
        public void a(ArrayList<String> arrayList, ArrayList<String> arrayList2, String str, String str2, String str3, String str4, String str5, String str6, int i10, boolean z10) {
            u.a("onBtImgUpdate", "固件升级回调信息--msg =" + str + ",forceupdate =" + str2 + "，description =" + str3 + ",time =" + str4 + "，versionname =" + str5 + "，btname =" + str6 + "status =" + i10 + ",hasnew =" + z10);
            if (i10 != 200) {
                Message message = new Message();
                message.what = 200;
                if (a.this.f27102l != null) {
                    a.this.f27102l.sendMessage(message);
                }
                a.this.V.g(201, "");
            } else if (!z10) {
                a.this.V.g(202, str3);
            } else {
                gn.q.f27584c = str5;
                if (arrayList2 != null) {
                    for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                        u.a("onBtImgUpdate", "addresses[" + i11 + "]=" + arrayList2.get(i11));
                        if (!arrayList2.get(i11).equals("")) {
                            gn.q.f27583b = arrayList2.get(i11);
                            a.this.f27093c.putString("ble_img_download_addr", gn.q.f27583b);
                            a.this.f27093c.commit();
                            u.a("onBtImgUpdate", "BLE_time =" + str4 + ",versionname =" + str5 + ",imgDownLaodAddresses =" + gn.q.f27583b);
                        }
                    }
                } else {
                    u.a("onBtImgUpdate", "onBtVersionUpdate  kong");
                }
                a.this.V.g(202, "");
            }
        }

        @Override // hn.a.AbstractC0303a
        public void b(ArrayList<String> arrayList, ArrayList<String> arrayList2, String str, String str2, String str3, String str4, String str5, String str6, int i10, boolean z10) {
            u.d("onBtImgUpdate", "path升级回调信息--status=" + i10 + ",patchServiceVersionCode=" + str6 + ",hasnew=" + z10 + ",description=" + str3 + ",addresses=" + arrayList2);
            gn.q.f27589h = str6;
            if (!z.v(a.this.f27091a).j()) {
                gn.q.f27589h = "00000";
            }
            if (arrayList2 != null) {
                for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                    if (!arrayList2.get(i11).equals("")) {
                        gn.q.f27588g = arrayList2.get(i11);
                        a.this.f27093c.putString("ble_patch_download_addr", gn.q.f27588g);
                        a.this.f27093c.commit();
                    }
                }
            }
            String string = a.this.f27092b.getString("ble_patch_download_addr", "");
            u.d("onBtImgUpdate", "回调得到的patch升级地址=" + string);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f27120a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f27121b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f27122c;

        d(String str, File file, int i10) {
            this.f27120a = str;
            this.f27121b = file;
            this.f27122c = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                new fn.c(a.this.f27091a, this.f27120a, this.f27121b, this.f27122c).a();
            } catch (Exception e10) {
                Message message = new Message();
                message.what = 101;
                if (a.this.f27102l != null) {
                    a.this.f27102l.sendMessage(message);
                }
                u.b("Updates", e10.toString());
            }
        }
    }

    /* loaded from: classes2.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean a10 = gn.e.a();
            u.d("zznkey", "reBoot =" + a10);
            boolean e10 = a.this.f27094d.e(z.v(a.this.f27091a).w());
            u.d("Updates", "重连蓝牙 connectResute =" + e10);
            if (a.this.f27102l != null) {
                a.this.f27102l.removeCallbacks(a.this.L);
            }
        }
    }

    /* loaded from: classes2.dex */
    class f extends c.b {
        f() {
        }

        @Override // lm.c.b
        public void a(int i10, int i11) {
            super.a(i10, i11);
            u.d("Updates", "8762C---onError--type=" + i10 + ",code=" + i11 + ",RKUpdateProgressIs100=" + a.this.Q);
            if (a.this.Q) {
                a.this.Q = false;
                a.this.U();
                return;
            }
            a.this.T();
        }

        @Override // lm.c.b
        public void b(int i10, Throughput throughput) {
            super.b(i10, throughput);
            u.d("Updates", "8762C---onProcessStateChanged--state=" + i10 + ",cothroughputde=" + throughput);
            if (i10 != 258) {
                return;
            }
            if (!gn.q.f27590i || gn.q.f27593l == 2) {
                a.this.U();
            }
        }

        @Override // lm.c.b
        public void c(DfuProgressInfo dfuProgressInfo) {
            super.c(dfuProgressInfo);
            int m10 = dfuProgressInfo.m();
            u.d("Updates", "8762C---onProgressChanged--dfuProgressInfo=" + dfuProgressInfo + ",progress=" + m10);
            if (gn.q.f27590i) {
                int i10 = gn.q.f27593l;
                m10 = i10 == 1 ? m10 / 2 : i10 == 2 ? (m10 / 2) + 50 : 0;
            }
            Message message = new Message();
            message.what = 103;
            if (m10 > 100) {
                m10 = 100;
            }
            if (m10 == 100) {
                a.this.Q = true;
            }
            message.arg1 = m10;
            if (a.this.f27102l != null) {
                a.this.f27102l.sendMessage(message);
            }
        }

        @Override // lm.c.b
        public void d(int i10) {
            super.d(i10);
            u.d("Updates", "8762C---onStateChanged--state=" + i10);
            if (i10 == 258) {
                a.this.b0();
            } else if (i10 == 527) {
                a aVar = a.this;
                aVar.R = aVar.O.u();
                a.this.S = true;
                u.d("Updates", "8762C---isOtaProcessing=" + a.this.T);
                if (a.this.T) {
                    a aVar2 = a.this;
                    boolean A = aVar2.O.A(aVar2.R, a.this.P);
                    u.d("Updates", "8762C---RET=" + A);
                }
                u.d("Updates", "8762C---mOtaDeviceInfo 3=" + a.this.R);
            }
        }
    }

    /* loaded from: classes2.dex */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f27102l != null) {
                a.this.f27102l.removeCallbacks(a.this.W);
            }
            boolean t10 = a.this.t();
            u.d("Updates", "mDialogUpdateTimeOutRunnable  --deleteFile=" + t10);
        }
    }

    /* loaded from: classes2.dex */
    class h implements k {
        h() {
        }

        @Override // bp.k
        public void a(String str) {
            u.d("Updates", "onDfuProcessStarted: " + str);
            Message message = new Message();
            message.what = 102;
            a.this.K = false;
            message.obj = Boolean.valueOf(a.this.K);
            if (a.this.f27102l != null) {
                a.this.f27102l.sendMessage(message);
            }
        }

        @Override // bp.k
        public void b(String str) {
            u.d("Updates", "onDeviceDisconnected: " + str);
        }

        @Override // bp.k
        public void c(String str) {
            u.d("Updates", "onEnablingDfuMode: " + str);
        }

        @Override // bp.k
        public void d(String str, int i10, int i11, String str2) {
            Message message = new Message();
            message.what = 102;
            a.this.K = false;
            message.obj = Boolean.valueOf(a.this.K);
            if (a.this.f27102l != null) {
                a.this.f27102l.sendMessage(message);
            }
            boolean t10 = a.this.t();
            u.d("Updates", "onError: " + str + ",error=" + i10 + ",errorType=" + i11 + ",message=" + str2 + ",deleteFile=" + t10);
        }

        @Override // bp.k
        public void e(String str, int i10, float f10, float f11, int i11, int i12) {
            u.d("Updates", "onProgressChanged: " + str + "百分比" + i10 + ",speed " + f10 + ",avgSpeed " + f11 + ",currentPart " + i11 + ",partTotal " + i12);
            Message message = new Message();
            message.what = 103;
            message.arg1 = i10;
            if (a.this.f27102l != null) {
                a.this.f27102l.sendMessage(message);
            }
        }

        @Override // bp.k
        public void f(String str) {
            u.d("Updates", "onDeviceConnecting: " + str);
        }

        @Override // bp.k
        public void g(String str) {
            u.d("Updates", "onDfuAborted: " + str);
        }

        @Override // bp.k
        public void h(String str) {
            u.d("Updates", "onFirmwareValidating: " + str);
        }

        @Override // bp.k
        public void i(String str) {
            u.d("Updates", "onDeviceDisconnecting: " + str);
        }

        @Override // bp.k
        public void j(String str) {
            u.d("Updates", "onDeviceConnected: " + str);
        }

        @Override // bp.k
        public void k(String str) {
            boolean t10 = a.this.t();
            Message message = new Message();
            message.what = 102;
            a.this.K = true;
            message.obj = Boolean.valueOf(a.this.K);
            if (a.this.f27102l != null) {
                a.this.f27102l.sendMessage(message);
            }
            try {
                a.this.a0();
            } catch (Exception unused) {
            }
            u.d("Updates", "onDfuCompleted: " + str + "，升级完成！！！deleteFile=" + t10);
        }

        @Override // bp.k
        public void l(String str) {
            u.d("Updates", "onDfuProcessStarting: " + str);
        }
    }

    static {
        UUID.fromString("00006287-3c17-d293-8e48-14fe2e4da212");
    }

    private a(Context context) {
        this.f27099i = false;
        u.a("Updates", "Updates INIT");
        this.f27091a = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences(gn.q.f27582a, 0);
        this.f27092b = sharedPreferences;
        this.f27093c = sharedPreferences.edit();
        boolean E = z.v(this.f27091a).E();
        this.f27099i = E;
        if (E) {
            wk.b.a(this.f27091a, new a.b().b(true).d(true).c("OTA").a());
            kl.b.a(this.f27091a, true);
            G();
        }
        this.f27098h = q.B(this.f27091a);
        com.yc.pedometer.sdk.a h10 = com.yc.pedometer.sdk.a.h(this.f27091a);
        this.f27094d = h10;
        BluetoothLeService g10 = h10.g();
        this.f27095e = g10;
        if (g10 != null) {
            g10.Z0(this);
        }
    }

    public static a A(Context context) {
        u.a("Updates", "Instance =" + Y);
        if (Y == null) {
            Y = new a(context);
        }
        return Y;
    }

    private ArrayList<Integer> D() {
        StringBuilder sb2;
        ArrayList<Integer> arrayList;
        int i10;
        String str = ":";
        if (this.f27104n != null) {
            sb2 = new StringBuilder();
        } else {
            f0(BluetoothLeService.f24600m1);
            sb2 = new StringBuilder();
        }
        sb2.append(this.f27104n);
        sb2.append(str);
        String sb3 = sb2.toString();
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        if (sb3 != null) {
            while (sb3.indexOf(str) != -1) {
                String substring = sb3.substring(sb3.indexOf(str) - 2, sb3.indexOf(str));
                sb3 = sb3.substring(sb3.indexOf(str) + 1);
                str = str;
                if (substring.indexOf("a") == -1 && substring.indexOf("b") == -1 && substring.indexOf("c") == -1 && substring.indexOf(com.huawei.hms.mlkit.common.ha.d.f14069a) == -1 && substring.indexOf(C0559e.f14347a) == -1 && substring.indexOf("f") == -1 && substring.indexOf("A") == -1 && substring.indexOf("B") == -1 && substring.indexOf("C") == -1 && substring.indexOf("D") == -1 && substring.indexOf("E") == -1 && substring.indexOf("F") == -1) {
                    i10 = (Integer.parseInt(substring.substring(0, 1)) << 4) | Integer.parseInt(substring.substring(1, 2));
                    arrayList = arrayList2;
                } else {
                    arrayList = arrayList2;
                    int parseInt = (substring.substring(0, 1).equals("a") || substring.substring(0, 1).equals("A")) ? 160 : (substring.substring(0, 1).equals("b") || substring.substring(0, 1).equals("B")) ? 176 : (substring.substring(0, 1).equals("c") || substring.substring(0, 1).equals("C")) ? 192 : (substring.substring(0, 1).equals(com.huawei.hms.mlkit.common.ha.d.f14069a) || substring.substring(0, 1).equals("D")) ? 208 : (substring.substring(0, 1).equals(C0559e.f14347a) || substring.substring(0, 1).equals("E")) ? 224 : (substring.substring(0, 1).equals("f") || substring.substring(0, 1).equals("F")) ? 240 : Integer.parseInt(substring.substring(0, 1)) << 4;
                    i10 = (substring.substring(1, 2).equals("a") || substring.substring(1, 2).equals("A")) ? parseInt | 10 : (substring.substring(1, 2).equals("b") || substring.substring(1, 2).equals("B")) ? parseInt | 11 : (substring.substring(1, 2).equals("c") || substring.substring(1, 2).equals("C")) ? parseInt | 12 : (substring.substring(1, 2).equals(com.huawei.hms.mlkit.common.ha.d.f14069a) || substring.substring(1, 2).equals("D")) ? parseInt | 13 : (substring.substring(1, 2).equals(C0559e.f14347a) || substring.substring(1, 2).equals("E")) ? parseInt | 14 : (substring.substring(1, 2).equals("f") || substring.substring(1, 2).equals("F")) ? parseInt | 15 : parseInt | Integer.parseInt(substring.substring(1, 2));
                }
                ArrayList<Integer> arrayList3 = arrayList;
                arrayList3.add(Integer.valueOf(i10));
                arrayList2 = arrayList3;
            }
        }
        return arrayList2;
    }

    private void F(String str) {
        boolean E = z.v(this.f27091a).E();
        this.f27099i = E;
        if (E) {
            G();
        }
        boolean g10 = p.g(this.f27091a, 1024);
        u.d("Updates", "initBLEUpDate--isNRF=" + g10 + ",isRKPlatform=" + this.f27099i);
        if (g10) {
            o.a(this.f27091a, this.X);
        }
        hn.a.m(true);
        hn.a.l("https://ute-tech.com.cn/ci-yc/index.php");
        hn.a.i(this.f27091a);
        hn.a.o(new c());
        String str2 = "M04";
        if (str.contains("V")) {
            if (str.length() > 2) {
                str2 = str.substring(0, str.indexOf("V"));
            }
            str = str.substring(str.indexOf("V"), str.length());
            u.a("onBtImgUpdate", "localBleVersion=" + str + ",localBTName =" + str2);
        }
        String str3 = str;
        String str4 = str2;
        String w10 = z.v(this.f27091a).w();
        if (w10.equals("00:00:00:00:00:00")) {
            w10 = "";
        }
        String L = L();
        if (this.f27099i) {
            String y10 = z.v(this.f27091a).y();
            u.d("onBtImgUpdate", "localPatchVersion=" + y10);
            hn.a.j(this.f27091a, str4, y10, false, w10, L);
        }
        hn.a.h(this.f27091a, str4, str3, false, w10, L);
    }

    private boolean H() {
        this.f27103m = this.f27092b.getLong("last_access_server_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = currentTimeMillis - this.f27103m;
        long j11 = j10 / LogCleaner.ONE_HOUR;
        u.d("Updates", "lastTime=" + this.f27103m + ",currentTime=" + currentTimeMillis + ",diff=" + j10 + ",diffHour=" + j11);
        if (j11 < 3) {
            return false;
        }
        this.f27093c.putLong("last_access_server_time", currentTimeMillis);
        this.f27093c.commit();
        return false;
    }

    private boolean I() {
        return this.B + this.A == this.C;
    }

    private boolean J() {
        return this.F + this.E == this.A;
    }

    private String L() {
        String locale = Locale.getDefault().toString();
        u.a("zh_CN", "locale = judgeLanguage =" + locale);
        return locale.contains("zh_CN") ? "" : (locale.contains("zh_TW") || locale.contains("zh_MO") || locale.contains("zh_HK")) ? "zh_rTW" : locale.contains("es_ES") ? "es" : locale.contains("ru_RU") ? "ru" : locale.contains("uk_UA") ? "uk" : locale.contains("fr_CA") ? "fr" : locale.contains("it_IT") ? "it" : locale.contains("de_DE") ? "de" : locale.contains("ja_JP") ? "ja" : locale.contains("ko_KR") ? "ko" : locale.contains("th_TH") ? "th" : locale.contains("pl_PL") ? "pl" : locale.contains("da_DK") ? "da" : "en";
    }

    private void Q() {
        int i10 = this.B + this.A;
        this.B = i10;
        int i11 = this.C - i10;
        int i12 = this.f27116z;
        if (i11 > i12) {
            i11 = i12;
        }
        this.A = i11;
    }

    private void R() {
        int i10 = this.F + this.E;
        this.F = i10;
        int i11 = this.A - i10;
        int i12 = this.D;
        if (i11 > i12) {
            i11 = i12;
        }
        this.E = i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        boolean t10 = t();
        u.b("Updates", "onError: deleteFile=" + t10);
        Message message = new Message();
        message.what = 102;
        this.K = false;
        message.obj = false;
        Handler handler = this.f27102l;
        if (handler != null) {
            handler.sendMessage(message);
        }
        gn.q.f27593l = 0;
        gn.q.f27590i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        boolean t10 = t();
        u.b("Updates", "onSucess: deleteFile=" + t10);
        Message message = new Message();
        message.what = 102;
        this.K = true;
        message.obj = true;
        Handler handler = this.f27102l;
        if (handler != null) {
            handler.sendMessage(message);
        }
        gn.q.f27593l = 0;
        gn.q.f27590i = false;
    }

    private void Y(UUID uuid, UUID uuid2) {
        BluetoothLeService bluetoothLeService = this.f27095e;
        if (bluetoothLeService != null) {
            List<BluetoothGattService> x02 = bluetoothLeService.x0();
            if (x02 == null) {
                u.d("zznkey", "readChara,bluetoothGattServices = null");
                return;
            }
            for (int i10 = 0; i10 < x02.size(); i10++) {
                BluetoothGattService bluetoothGattService = x02.get(i10);
                if (bluetoothGattService.getUuid().toString().equals(uuid.toString())) {
                    int size = bluetoothGattService.getCharacteristics().size();
                    int i11 = 0;
                    while (true) {
                        if (i11 < size) {
                            BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristics().get(i11);
                            if (bluetoothGattCharacteristic.getUuid().toString().equals(uuid2.toString())) {
                                BluetoothLeService bluetoothLeService2 = this.f27095e;
                                if (bluetoothLeService2 != null) {
                                    bluetoothLeService2.V0(bluetoothGattCharacteristic);
                                } else {
                                    u.d("zznkey", "readChara,mBluetoothLeService = null");
                                }
                            } else {
                                i11++;
                            }
                        }
                    }
                }
            }
        } else if (bluetoothLeService == null) {
            u.d("zznkey", "readChara,mBluetoothLeService = null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        Handler handler;
        Runnable runnable = this.W;
        if (runnable != null && (handler = this.f27102l) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    private void d0(String str) {
        if (this.P == null || this.O == null) {
            u.d("Updates", "8762C--- mDfuConfig or mGattDfuAdapter null");
            T();
            return;
        }
        String w10 = z.v(this.f27091a).w();
        this.P.W(w10);
        this.P.X(str);
        this.P.a0(this.N);
        boolean z10 = false;
        this.P.b0(false);
        u.d("Updates", "8762C---是否静默升级=" + gn.q.f27597p);
        if (gn.q.f27597p) {
            this.P.Y(16);
        } else {
            this.P.Y(0);
        }
        u.d("Updates", "8762C---imgDir=" + str + ",lastAddr =" + w10 + ",mGattDfuAdapter=" + this.O + ",mDfuConfig=" + this.P + ",isRKOtaPrepared=" + this.S);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("8762C---mOtaDeviceInfo =");
        sb2.append(this.R);
        u.d("Updates", sb2.toString());
        this.T = true;
        if (this.S) {
            this.T = false;
            z10 = this.O.A(this.R, this.P);
        } else {
            b0();
        }
        u.d("Updates", "8762C---RET=" + z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(BluetoothGatt bluetoothGatt) {
        u.d("Updates", "Gatt=" + bluetoothGatt);
        if (bluetoothGatt != null) {
            this.f27104n = bluetoothGatt.getDevice().getAddress();
        }
    }

    private boolean i0() {
        u.d("zznkey", "setSuotaSettings,Settings=spi:clk=0x00,cs=0x03,mosi=0x06,miso=0x05,blocksize=240");
        this.f27113w = 1;
        this.f27110t = (Integer.parseInt("0") << 4) | Integer.parseInt("0");
        this.f27109s = (Integer.parseInt("0") << 4) | Integer.parseInt(Constant.APPLY_MODE_DECIDED_BY_BANK);
        this.f27111u = (Integer.parseInt("0") << 4) | Integer.parseInt("6");
        this.f27112v = (Integer.parseInt("0") << 4) | Integer.parseInt("5");
        try {
            this.f27116z = Integer.parseInt("240");
            u.d("zznkey", "setSuotaSettings,mSpiClkGpio=" + this.f27110t + ",mSpiCsGpio=" + this.f27109s + ",mSpiMosiGpio=" + this.f27111u + ",mSpiMisoGpio=" + this.f27112v + ",mBlockSize=" + this.f27116z);
            return true;
        } catch (Exception unused) {
            this.f27116z = 240;
            u.d("zznkey", "setSuotaSettings,type=spi,the mBlockSize string is err!");
            return false;
        }
    }

    private void m0(UUID uuid, byte[] bArr, boolean z10) {
        BluetoothLeService bluetoothLeService = this.f27095e;
        if (bluetoothLeService == null) {
            u.d("zznkey", "writeChara,mBluetoothLeService = null");
            return;
        }
        List<BluetoothGattService> x02 = bluetoothLeService.x0();
        if (x02 == null) {
            u.d("zznkey", "writeChara,bluetoothGattServices = null");
            return;
        }
        for (int i10 = 0; i10 < x02.size(); i10++) {
            BluetoothGattService bluetoothGattService = x02.get(i10);
            if (bluetoothGattService.getUuid().toString().equals(c0.f27531g.toString())) {
                int size = bluetoothGattService.getCharacteristics().size();
                int i11 = 0;
                while (true) {
                    if (i11 < size) {
                        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristics().get(i11);
                        if (bluetoothGattCharacteristic.getUuid().toString().equals(uuid.toString())) {
                            BluetoothLeService bluetoothLeService2 = this.f27095e;
                            if (!z10) {
                                bluetoothLeService2.a1(bluetoothGattCharacteristic, true);
                                u.d("zznkey", "suotaServiceWriteCharas,characteristic.getUuid().toString() = " + bluetoothGattCharacteristic.getUuid().toString());
                            } else if (bluetoothLeService2 != null) {
                                bluetoothGattCharacteristic.setValue(bArr);
                                this.f27095e.j1(bluetoothGattCharacteristic);
                            } else {
                                u.d("zznkey", "writeChara,mBluetoothLeService = null");
                            }
                        } else {
                            i11++;
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        boolean z10 = this.f27092b.getBoolean("device_feature_update", false);
        boolean z11 = this.f27092b.getBoolean("device_feature_wechat", false);
        if (z10) {
            e(true);
            gn.q.f27585d = true;
            Message message = new Message();
            message.what = 100;
            this.K = false;
            message.obj = false;
            Handler handler = this.f27102l;
            if (handler != null) {
                handler.sendMessage(message);
                this.f27102l.postDelayed(this.f27101k, PayTask.f6879j);
            }
        } else if (z11) {
            gn.q.f27585d = false;
            Message message2 = new Message();
            message2.what = 102;
            this.K = true;
            message2.obj = true;
            Handler handler2 = this.f27102l;
            if (handler2 != null) {
                handler2.sendMessage(message2);
            }
            e(false);
            boolean t10 = t();
            u.b("Updates", "bluetoothReootOKNext: deleteFile=" + t10);
        }
    }

    private void o0() {
        int i10 = this.E;
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            bArr[i11] = (byte) this.G.get(this.B + this.F + i11).intValue();
        }
        m0(c0.f27536l, bArr, true);
        this.f27114x = 3;
        R();
    }

    private void p0(int i10) {
        m0(c0.f27535k, new byte[]{(byte) (i10 & 255), (byte) ((i10 >> 8) & 255)}, true);
        this.f27114x = 2;
        u.d("zznkey", "writeSuotaDataLen,datalen=" + i10);
    }

    private void q(ArrayList<Integer> arrayList) {
        ArrayList<Integer> D = D();
        for (int i10 = 0; i10 < D.size(); i10++) {
            u.d("zznkey", "bt:" + D.get(i10));
        }
        byte[] bArr = {-1, -1, -1, -1};
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            if (i11 > 1047 && i11 < 1054) {
                arrayList.set(i11, Integer.valueOf(D.get(6 - (i11 - 1047)).intValue()));
            }
            int intValue = arrayList.get(i11).intValue();
            if (i11 > 63) {
                int[] iArr = this.f27105o;
                byte b10 = (byte) intValue;
                byte[] bArr2 = {(byte) ((iArr[((byte) (bArr[0] ^ b10)) & 255] >> 0) & 255), (byte) ((iArr[((byte) (bArr[0] ^ b10)) & 255] >> 8) & 255), (byte) ((iArr[((byte) (bArr[0] ^ b10)) & 255] >> 16) & 255), (byte) ((iArr[((byte) (b10 ^ bArr[0])) & 255] >> 24) & 255)};
                bArr[0] = (byte) (bArr[1] & 255);
                bArr[1] = (byte) (bArr[2] & 255);
                bArr[2] = (byte) (bArr[3] & 255);
                bArr[3] = 0;
                bArr[0] = (byte) ((bArr[0] & 255) ^ ((bArr2[0] & 255) & 255));
                bArr[1] = (byte) ((bArr[1] & 255) ^ ((bArr2[1] & 255) & 255));
                bArr[2] = (byte) ((bArr[2] & 255) ^ ((bArr2[2] & 255) & 255));
                bArr[3] = (byte) ((bArr[3] & 255) ^ ((bArr2[3] & 255) & 255));
            }
        }
        u.d("zznkey", "crc_code=0x" + Integer.toHexString(0));
        bArr[0] = (byte) (((byte) (bArr[0] ^ 255)) & 255);
        bArr[1] = (byte) (((byte) (bArr[1] ^ 255)) & 255);
        bArr[2] = (byte) (((byte) (bArr[2] ^ 255)) & 255);
        bArr[3] = (byte) (((byte) (bArr[3] ^ 255)) & 255);
        u.d("zznkey", "crc_32bit[0]=0x" + Integer.toHexString(bArr[0]));
        u.d("zznkey", "crc_32bit[1]=0x" + Integer.toHexString(bArr[1]));
        u.d("zznkey", "crc_32bit[2]=0x" + Integer.toHexString(bArr[2]));
        u.d("zznkey", "crc_32bit[3]=0x" + Integer.toHexString(bArr[3]));
        for (int i12 = 0; i12 < 4; i12++) {
            arrayList.set(i12 + 8, Integer.valueOf(bArr[i12] & 255));
        }
        byte b11 = 0;
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            b11 = (byte) (b11 ^ ((byte) arrayList.get(i13).intValue()));
        }
        arrayList.add(Integer.valueOf(b11 & 255));
    }

    private void q0() {
        this.f27114x = 4;
        u.d("zznkey", "suotaWriteEnd:mBlockOffset=" + this.B + ",mImageDataLength=" + this.C);
        int i10 = this.C;
        int i11 = (i10 * 100) / i10;
        u.a("onBtImgUpdate", "progress =" + i11);
        m0(c0.f27532h, new byte[]{0, 0, 0, -2}, true);
        u.d("zznkey", "SuotaUpdate Successful !");
        u.d("onSpotaService", "SuotaUpdate Successful !");
        gn.q.f27585d = false;
        this.K = true;
        Message message = new Message();
        message.what = 102;
        message.obj = Boolean.valueOf(this.K);
        Handler handler = this.f27102l;
        if (handler != null) {
            handler.sendMessage(message);
            this.f27102l.postDelayed(this.L, 8000L);
        }
        a0();
        boolean t10 = t();
        u.b("Updates", "suotaWriteEnd: deleteFile=" + t10);
    }

    private void r0() {
        StringBuilder sb2;
        byte b10;
        byte[] bArr = new byte[4];
        this.f27114x = 0;
        int i10 = this.f27113w;
        if (i10 == 0) {
            bArr[3] = 18;
        } else if (i10 == 1) {
            bArr[3] = 19;
        } else {
            bArr[3] = 0;
        }
        bArr[0] = 0;
        bArr[2] = 0;
        bArr[1] = 0;
        String str = "";
        for (int i11 = 3; i11 > -1; i11--) {
            if (bArr[i11] < 16) {
                sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("0");
                b10 = bArr[i11];
            } else {
                sb2 = new StringBuilder();
                sb2.append(str);
                b10 = bArr[i11];
            }
            sb2.append(Integer.toHexString(b10));
            str = sb2.toString();
        }
        u.d("zznkey", "spotaWriteMemDev,mem_dev=0x" + str);
        m0(c0.f27532h, bArr, true);
        u.d("zznkey", "suotaServiceWriteCharas(SPOTA_MEM_DEV_UUID, mem_dev, true)");
    }

    private void s0() {
        StringBuilder sb2;
        byte b10;
        byte[] bArr = new byte[4];
        int i10 = this.f27113w;
        if (i10 == 0) {
            bArr[0] = (byte) this.f27107q;
            bArr[1] = (byte) this.f27106p;
            bArr[2] = (byte) this.f27108r;
            bArr[3] = 0;
        } else if (i10 == 1) {
            bArr[0] = (byte) this.f27110t;
            bArr[1] = (byte) this.f27109s;
            bArr[2] = (byte) this.f27111u;
            bArr[3] = (byte) this.f27112v;
        } else {
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            bArr[3] = 0;
        }
        this.f27114x = 1;
        String str = "";
        for (int i11 = 3; i11 > -1; i11--) {
            if (bArr[i11] < 16) {
                sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append("0");
                b10 = bArr[i11];
            } else {
                sb2 = new StringBuilder();
                sb2.append(str);
                b10 = bArr[i11];
            }
            sb2.append(Integer.toHexString(b10));
            str = sb2.toString();
        }
        u.d("zznkey", "spotaWriteGpioMap,mem_gpio_map=0x" + str);
        m0(c0.f27533i, bArr, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean t() {
        boolean z10 = this.f27092b.getBoolean("already_download_update_firmware", false);
        String string = this.f27092b.getString("img_download_path_sp", "");
        if (z10) {
            File file = new File(string);
            u.d("Updates", "file.isFile()=" + file.isFile());
            u.d("Updates", "file.exists(=" + file.exists());
            if (file.isFile() && file.exists()) {
                this.f27093c.putBoolean("already_download_update_firmware", false);
                this.f27093c.commit();
                return file.delete();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002e, code lost:
        if (r1 == 2) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003e, code lost:
        if (gn.q.f27592k != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
        r1 = r7.f27092b;
        r3 = "ble_patch_download_addr";
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
        r1 = "";
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u() {
        String str;
        u.d("Updates", "downloadImg");
        if (Environment.getExternalStorageState().equals("mounted")) {
            String str2 = "ble_img_download_addr";
            if (!this.f27099i) {
                this.f27096f = this.f27092b.getString(str2, "");
                u.a("Updates", "{downloadImg}imgOnServerAddr=" + this.f27096f);
                if (!this.f27096f.equals("")) {
                    v(this.f27096f, this.f27091a.getExternalFilesDir(null), this.f27097g);
                }
            } else if (gn.q.f27590i) {
                int i10 = gn.q.f27593l;
                if (i10 < 2) {
                    gn.q.f27593l = i10 + 1;
                }
                int i11 = gn.q.f27593l;
                if (i11 != 1) {
                }
                SharedPreferences sharedPreferences = this.f27092b;
                str = sharedPreferences.getString(str2, "");
                u.a("Updates", "下载多少次=" + gn.q.f27593l);
                u.a("Updates", "最终下载地址是=" + str);
                if (str.equals("")) {
                    v(str, this.f27091a.getExternalFilesDir(null), this.f27097g);
                }
            } else {
                if (!gn.q.f27591j) {
                }
                SharedPreferences sharedPreferences2 = this.f27092b;
                str = sharedPreferences2.getString(str2, "");
                u.a("Updates", "下载多少次=" + gn.q.f27593l);
                u.a("Updates", "最终下载地址是=" + str);
                if (str.equals("")) {
                }
            }
        } else {
            Handler handler = this.f27102l;
            if (handler != null) {
                handler.sendEmptyMessage(102);
            }
        }
    }

    private void v(String str, File file, int i10) {
        u.a("Updates", "downloadImg_thread");
        new Thread(new d(str, file, i10)).start();
    }

    private void w0() {
        u.d("Updates", "updateBle");
        u();
        gn.q.f27585d = true;
        Message message = new Message();
        message.what = 100;
        this.K = false;
        message.obj = false;
        Handler handler = this.f27102l;
        if (handler != null) {
            handler.sendMessage(message);
        }
    }

    public String B() {
        String u10 = z.v(this.f27091a).u();
        if (u10.length() > 2 && gn.q.f27584c.length() > 2) {
            String substring = u10.substring(u10.indexOf("V") + 1, u10.length());
            String str = gn.q.f27584c;
            String substring2 = str.substring(str.indexOf("V") + 1, gn.q.f27584c.length());
            int compareTo = substring2.compareTo(substring);
            u.a("MainActivity", "bleHasNew=" + compareTo + ",lacV =" + substring + ",serV =" + substring2);
            if (compareTo > 0) {
                return gn.q.f27584c;
            }
        }
        return "no new version";
    }

    public void G() {
        u.d("Updates", "initRKOTA");
        m();
        g();
    }

    public void Z() {
        u.d("Updates", "  update  registerBroadcastReceiver");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("img_download_finish_action");
        intentFilter.addAction("img_download_fail_action");
        intentFilter.addAction("send_device_info_action");
        intentFilter.addAction("bluetooth.le.ACTION_GATT_FAILURE_daydaybandsdk");
        intentFilter.addAction("change_device_feature_success_action");
        intentFilter.addAction("bluetooth_reboot_success_action");
        intentFilter.addAction("device_feature_is_invalid");
        intentFilter.addAction(gn.q.f27594m);
        this.f27091a.registerReceiver(this.f27100j, intentFilter);
    }

    @Override // en.r
    public void a(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        String str;
        byte[] value = bluetoothGattCharacteristic.getValue();
        int i10 = value[0] & 255;
        u.d("zznkey", "onSpotaServiceStatusChange=0x" + Integer.toHexString(i10));
        Message message = new Message();
        message.what = 103;
        message.arg1 = (this.M * 24000) / this.G.size();
        Handler handler = this.f27102l;
        if (handler != null) {
            handler.sendMessage(message);
        }
        this.M++;
        u.d("zznkey", "mSpotaWriteStatus=" + this.f27114x);
        byte b10 = value[0];
        switch (b10) {
            case 3:
                str = "onSpotaServiceStatusChange=SPOTAR_SRV_EXIT";
                u.d("onSpotaService", str);
                break;
            case 4:
                str = "onSpotaServiceStatusChange=SPOTAR_CRC_ERR";
                u.d("onSpotaService", str);
                break;
            case 5:
                str = "onSpotaServiceStatusChange=SPOTAR_PATCH_LEN_ERR";
                u.d("onSpotaService", str);
                break;
            case 6:
                str = "onSpotaServiceStatusChange=SPOTAR_EXT_MEM_WRITE_ERR";
                u.d("onSpotaService", str);
                break;
            case 7:
                str = "onSpotaServiceStatusChange=SPOTAR_INT_MEM_ERR";
                u.d("onSpotaService", str);
                break;
            case 8:
                str = "onSpotaServiceStatusChange=SPOTAR_INVAL_MEM_TYPE";
                u.d("onSpotaService", str);
                break;
            case 9:
                str = "onSpotaServiceStatusChange=SPOTAR_APP_ERROR";
                u.d("onSpotaService", str);
                break;
            default:
                switch (b10) {
                    case 17:
                        str = "onSpotaServiceStatusChange=SPOTAR_INVAL_IMG_BANK";
                        u.d("onSpotaService", str);
                        break;
                    case 18:
                        str = "onSpotaServiceStatusChange=SPOTAR_INVAL_IMG_HDR";
                        u.d("onSpotaService", str);
                        break;
                    case 19:
                        str = "onSpotaServiceStatusChange=SPOTAR_INVAL_IMG_SIZE";
                        u.d("onSpotaService", str);
                        break;
                    case 20:
                        str = "onSpotaServiceStatusChange=SPOTAR_INVAL_PRODUCT_HDR";
                        u.d("onSpotaService", str);
                        break;
                    case 21:
                        str = "onSpotaServiceStatusChange=SPOTAR_SAME_IMG_ERR";
                        u.d("onSpotaService", str);
                        break;
                    case 22:
                        str = "onSpotaServiceStatusChange=SPOTAR_EXT_MEM_READ_ERR";
                        u.d("onSpotaService", str);
                        break;
                }
        }
        if (i10 != 16 && i10 == 2 && this.f27114x == 3) {
            Q();
            if (!I()) {
                this.I = false;
                this.F = 0;
                int i11 = this.A - 0;
                int i12 = this.D;
                if (i11 > i12) {
                    i11 = i12;
                }
                this.E = i11;
                u.d("zznkey", "onSuotaServiceStatusChange mBlockLength=" + this.A + ",mBlockOffset=" + this.B);
                o0();
            } else if (!this.J) {
                this.J = true;
                p0(this.A);
            } else {
                Y(c0.f27531g, c0.f27534j);
            }
        }
    }

    @Override // en.r
    public void b(int i10) {
    }

    public void b0() {
        u.d("Updates", "8762C---rkConnectDevice CON=" + z.v(this.f27091a).j());
        if (z.v(this.f27091a).j()) {
            b.C0389b c10 = new b.C0389b().a(z.v(this.f27091a).w()).c(3);
            lm.e eVar = this.O;
            if (eVar != null) {
                boolean c11 = eVar.c(c10.b());
                u.d("Updates", "8762C---connectDevice RE=" + c11);
            }
        }
    }

    @Override // en.r
    public void c(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        if (bluetoothGattCharacteristic.getUuid().equals(c0.f27534j)) {
            byte[] value = bluetoothGattCharacteristic.getValue();
            for (int i10 = 0; i10 < value.length; i10++) {
                u.d("zznkey", "read:SPOTA_MEM_INFO_UUID, characteristic.getValue().[" + i10 + "]=" + Integer.toHexString(value[i10] & 255));
                q0();
            }
        }
    }

    public void c0() {
        lm.e eVar = this.O;
        if (eVar != null) {
            eVar.d();
        }
    }

    @Override // en.r
    public void d(int i10) {
        String str;
        u.d("zznkey", "status=" + i10);
        if (i10 == 0) {
            int i11 = this.f27114x;
            if (i11 == 0) {
                s0();
                return;
            } else if (i11 == 1) {
                p0(this.f27116z);
                this.B = 0;
                int size = this.G.size();
                this.C = size;
                int i12 = size - this.B;
                int i13 = this.f27116z;
                if (i12 > i13) {
                    i12 = i13;
                }
                this.A = i12;
                return;
            } else if (i11 == 2) {
                this.F = 0;
                int i14 = this.A - 0;
                int i15 = this.D;
                if (i14 > i15) {
                    i14 = i15;
                }
                this.E = i14;
                this.I = false;
                o0();
                str = "onCharacteristicWriteStatus mBlockLength=" + this.A + ",mBlockOffset=" + this.B;
            } else if (i11 == 3 && !this.I) {
                if (J()) {
                    this.I = true;
                }
                o0();
                return;
            } else {
                return;
            }
        } else {
            str = "status!=statusstatus" + i10;
        }
        u.d("zznkey", str);
    }

    public void e(boolean z10) {
        String str;
        String str2;
        String str3;
        u.d("Updates", "OpenOrCloseSuotaNotif ,isWrite = " + z10);
        BluetoothLeService bluetoothLeService = this.f27095e;
        if (bluetoothLeService == null) {
            str3 = "writeChara,mBluetoothLeService = null";
        } else {
            List<BluetoothGattService> x02 = bluetoothLeService.x0();
            if (x02 == null) {
                str3 = "writeChara,bluetoothGattServices = null";
            } else {
                for (int i10 = 0; i10 < x02.size(); i10++) {
                    BluetoothGattService bluetoothGattService = x02.get(i10);
                    if (bluetoothGattService.getUuid().toString().equals(c0.f27531g.toString())) {
                        int size = bluetoothGattService.getCharacteristics().size();
                        int i11 = 0;
                        while (true) {
                            if (i11 >= size) {
                                break;
                            }
                            BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristics().get(i11);
                            if (bluetoothGattCharacteristic.getUuid().toString().equals(c0.f27537m.toString())) {
                                BluetoothLeService bluetoothLeService2 = this.f27095e;
                                if (z10) {
                                    bluetoothLeService2.a1(bluetoothGattCharacteristic, true);
                                    str2 = "open suota notify";
                                } else {
                                    bluetoothLeService2.a1(bluetoothGattCharacteristic, false);
                                    str2 = "close suota notify";
                                }
                                u.f("maomao", str2);
                            } else {
                                i11++;
                            }
                        }
                    }
                    if (bluetoothGattService.getUuid().toString().equals(c0.f27529e)) {
                        int size2 = bluetoothGattService.getCharacteristics().size();
                        int i12 = 0;
                        while (true) {
                            if (i12 < size2) {
                                BluetoothGattCharacteristic bluetoothGattCharacteristic2 = bluetoothGattService.getCharacteristics().get(i12);
                                if (bluetoothGattCharacteristic2.getUuid().toString().equals(c0.f27526b)) {
                                    BluetoothLeService bluetoothLeService3 = this.f27095e;
                                    if (!z10) {
                                        bluetoothLeService3.a1(bluetoothGattCharacteristic2, true);
                                        str = "open pedometer notify";
                                    } else {
                                        bluetoothLeService3.a1(bluetoothGattCharacteristic2, false);
                                        str = "close pedometer notify";
                                    }
                                    u.f("maomao", str);
                                } else {
                                    i12++;
                                }
                            }
                        }
                    }
                }
                return;
            }
        }
        u.d("zznkey", str3);
    }

    protected DfuConfig g() {
        u.d("Updates", "getDfuConfig mDfuConfig=" + this.P);
        if (this.P == null) {
            this.P = new DfuConfig();
        }
        u.d("Updates", "getDfuConfig mDfuConfig 2=" + this.P);
        return this.P;
    }

    public void g0(Handler handler) {
        this.f27102l = handler;
    }

    public void h0(en.f fVar) {
        this.V = fVar;
    }

    public void j0(String str) {
        Handler handler;
        long j10;
        Runnable runnable;
        this.f27093c.putBoolean("already_download_update_firmware", true);
        this.f27093c.putString("img_download_path_sp", str);
        this.f27093c.commit();
        boolean g10 = p.g(this.f27091a, 1024);
        this.f27099i = z.v(this.f27091a).E();
        u.d("Updates", "kaishi shengji isNRF =" + g10 + ",isRKPlatform=" + this.f27099i + ",path=" + str);
        if (this.f27099i) {
            d0(str);
            return;
        }
        if (g10) {
            String u10 = z.v(this.f27091a).u();
            String substring = (!u10.contains("V") || u10.length() <= 2) ? "M04" : u10.substring(0, u10.indexOf("V"));
            String w10 = z.v(this.f27091a).w();
            if (w10.equals("00:00:00:00:00:00")) {
                w10 = "";
            }
            u.d("MyDeviceActivity", "NRF--蓝牙名=" + substring + ",addr =" + w10);
            n c10 = new n(w10).b(substring).c(true);
            c10.d(true);
            c10.e(null, str);
            c10.f(this.f27091a, DfuService.class);
            handler = this.f27102l;
            if (handler != null) {
                runnable = this.W;
                j10 = 360000;
            } else {
                return;
            }
        } else {
            gn.q.f27585d = true;
            l0(str);
            if (this.f27115y) {
                n0();
                handler = this.f27102l;
                if (handler != null) {
                    runnable = this.W;
                    j10 = 120000;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
        handler.postDelayed(runnable, j10);
    }

    public int k(String str) {
        if (H()) {
            return 2;
        }
        F(str);
        return 4;
    }

    public void k0() {
        u.d("Updates", "startUpdateBLE--isRKPlatform=" + this.f27099i);
        if (this.f27099i) {
            Message message = new Message();
            message.what = 100;
            this.K = false;
            e(true);
            gn.q.f27585d = true;
            message.obj = Boolean.valueOf(this.K);
            Handler handler = this.f27102l;
            if (handler != null) {
                handler.sendMessage(message);
                this.f27102l.postDelayed(this.f27101k, PayTask.f6879j);
                return;
            }
            return;
        }
        boolean z10 = this.f27092b.getBoolean("device_feature_update", false);
        u.d("Updates", "isDeviceFeartureUpdate=" + z10);
        if (z10) {
            String string = this.f27092b.getString("device_feature_key", "");
            u.d("Updates", "deviceFearture=" + string);
            if (!string.equals("") && string.length() == 8) {
                String substring = string.substring(string.length() - 2, string.length());
                if (substring.equals("01")) {
                    this.f27098h.q(1);
                } else if (substring.equals("02")) {
                    this.f27098h.q(2);
                }
                gn.q.f27585d = true;
                Message message2 = new Message();
                message2.what = 100;
                this.K = false;
                message2.obj = false;
                Handler handler2 = this.f27102l;
                if (handler2 != null) {
                    handler2.sendMessage(message2);
                    return;
                }
                return;
            }
            return;
        }
        e(true);
        w0();
    }

    public void l0(String str) {
        this.M = 0;
        File file = new File(str);
        u.d("zznkey", "readSuotaImageData,file=" + file);
        this.G = new ArrayList<>();
        this.H = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArr = new byte[1];
            while (fileInputStream.read(bArr) != -1) {
                this.G.add(Integer.valueOf(bArr[0] & 255));
                this.H.add(Byte.valueOf(bArr[0]));
            }
            fileInputStream.close();
            q(this.G);
            u.d("zznkey", "readSuotaImageData,imageData.size()=" + this.G.size());
            if (!i0()) {
                Toast.makeText(this.f27091a, "The configuration file does not exist or is invalid!!", 1).show();
            } else {
                this.f27115y = true;
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    protected lm.e m() {
        u.d("Updates", "getGattDfuAdapter mGattDfuAdapter=" + this.O);
        if (this.O == null) {
            lm.e R = lm.e.R(this.f27091a);
            this.O = R;
            R.w(this.U);
        }
        u.d("Updates", "getGattDfuAdapter mGattDfuAdapter2=" + this.O);
        return this.O;
    }

    public void n0() {
        this.J = false;
        r0();
    }

    public void r() {
        e(false);
        this.f27093c.putLong("last_access_server_time", this.f27103m);
        this.f27093c.commit();
    }

    public void v0() {
        u.d("Updates", "  update  unRegisterBroadcastReceiver");
        try {
            this.f27091a.unregisterReceiver(this.f27100j);
        } catch (Exception unused) {
        }
        o.b(this.f27091a, this.X);
        a0();
    }

    public int z(String str) {
        int i10;
        u.a("compare", "localVersionName=" + str + ",SERVER.bleVersionName=" + gn.q.f27584c);
        String y10 = z.v(this.f27091a).y();
        String str2 = gn.q.f27589h;
        if ((str.length() > 2 && gn.q.f27584c.length() > 2) || (y10.length() > 2 && str2.length() > 2)) {
            if (str.length() <= 2 || gn.q.f27584c.length() <= 2) {
                i10 = 0;
            } else {
                String substring = str.substring(str.indexOf("V") + 1, str.length());
                String str3 = gn.q.f27584c;
                String substring2 = str3.substring(str3.indexOf("V") + 1, gn.q.f27584c.length());
                i10 = substring2.compareTo(substring);
                u.a("compare", "bleHasNew=" + i10 + ",lacV =" + substring + ",serV =" + substring2 + ",isRKPlatform=" + this.f27099i);
            }
            if (this.f27099i) {
                gn.q.f27593l = 0;
                int compareTo = (y10.length() <= 2 || str2.length() <= 2) ? 0 : str2.compareTo(y10);
                u.a("onBtImgUpdate", "servicePatchVersionCode=" + str2 + ",localPatchVersionCode =" + y10);
                if (i10 <= 0 || compareTo <= 0) {
                    gn.q.f27590i = false;
                } else {
                    gn.q.f27590i = true;
                    u.d("onBtImgUpdate", "比较版本这里，两个都有更新--BleAndPatchAllHasNews=" + gn.q.f27590i);
                }
                if (i10 > 0) {
                    gn.q.f27591j = true;
                } else {
                    gn.q.f27591j = false;
                }
                if (compareTo > 0) {
                    gn.q.f27592k = true;
                } else {
                    gn.q.f27592k = false;
                }
                u.d("onBtImgUpdate", "比较版本这里bleHasNew=" + i10 + ",patchHasNew=" + compareTo);
                return (i10 > 0 || compareTo > 0) ? 1 : 3;
            } else if (i10 > 0) {
                return 1;
            }
        }
        return 3;
    }
}
