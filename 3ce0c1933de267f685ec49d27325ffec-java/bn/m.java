package bn;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.alibaba.fastjson.parser.JSONLexer;
import en.q;
import gn.z;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class m {

    /* renamed from: o  reason: collision with root package name */
    private static m f5316o;

    /* renamed from: l  reason: collision with root package name */
    private o f5328l;

    /* renamed from: a  reason: collision with root package name */
    private String f5317a = "dial_1_circle_240x240";

    /* renamed from: b  reason: collision with root package name */
    private String f5318b = "dial_2_square_240x240";

    /* renamed from: c  reason: collision with root package name */
    private String f5319c = "dial_10001_square_320x360";

    /* renamed from: d  reason: collision with root package name */
    private String f5320d = "dial_1_circle_240x240";

    /* renamed from: e  reason: collision with root package name */
    private String f5321e = "";

    /* renamed from: f  reason: collision with root package name */
    private int f5322f = 0;

    /* renamed from: g  reason: collision with root package name */
    private String f5323g = "2";

    /* renamed from: h  reason: collision with root package name */
    private int f5324h = 0;

    /* renamed from: i  reason: collision with root package name */
    private Bitmap f5325i = null;

    /* renamed from: j  reason: collision with root package name */
    private int f5326j = 16777215;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5327k = false;

    /* renamed from: m  reason: collision with root package name */
    private byte[] f5329m = new byte[0];

    /* renamed from: n  reason: collision with root package name */
    private List<bn.b> f5330n = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements Comparator<File> {
        a() {
        }

        /* renamed from: a */
        public int compare(File file, File file2) {
            if (file.isDirectory() && file2.isFile()) {
                return -1;
            }
            if (file.isFile() && file2.isDirectory()) {
                return 1;
            }
            if ((file.getName().endsWith(".png") || file.getName().endsWith(".PNG")) && (file2.getName().endsWith(".png") || file2.getName().endsWith(".PNG"))) {
                String substring = file.getName().substring(0, file.getName().length() - 4);
                String substring2 = file2.getName().substring(0, file2.getName().length() - 4);
                if (m.this.u(substring) && m.this.u(substring2)) {
                    return Integer.parseInt(substring) - Integer.parseInt(substring2);
                }
            }
            return file.getName().compareTo(file2.getName());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements Comparator<String> {
        b() {
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            if ((str.endsWith(".png") || str.endsWith(".PNG")) && (str2.endsWith(".png") || str2.endsWith(".PNG"))) {
                String substring = str.substring(0, str.length() - 4);
                String substring2 = str2.substring(0, str2.length() - 4);
                if (m.this.u(substring) && m.this.u(substring2)) {
                    return Integer.parseInt(substring) - Integer.parseInt(substring2);
                }
            }
            return str.compareTo(str2);
        }
    }

    private void A(Bitmap bitmap) {
        this.f5325i = bitmap;
    }

    private void D(boolean z10) {
        this.f5327k = z10;
    }

    private void F(o oVar) {
        this.f5328l = oVar;
    }

    private File[] G(File[] fileArr) {
        Collections.sort(Arrays.asList(fileArr), new a());
        return fileArr;
    }

    private String[] H(String[] strArr) {
        Collections.sort(Arrays.asList(strArr), new b());
        return strArr;
    }

    private q a(q qVar) {
        if (qVar != null) {
            List<j> a10 = qVar.a();
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < a10.size() - 1; i10++) {
                for (int size = a10.size() - 1; size > i10; size--) {
                    if (Arrays.equals(a10.get(size).b(), a10.get(i10).b())) {
                        arrayList.add(new e(a10.get(i10).c(), a10.get(size).c()));
                        a10.remove(size);
                    }
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i11 = 0; i11 < a10.size(); i11++) {
                arrayList2.add(Integer.valueOf(a10.get(i11).c()));
            }
            int size2 = ((qVar.c().size() + 1) * 24) + 2;
            for (int i12 = 0; i12 < qVar.c().size(); i12++) {
                int l10 = p.y().l(qVar.c().get(i12).e());
                if (arrayList2.contains(Integer.valueOf(l10))) {
                    byte[] c10 = qVar.c().get(i12).c();
                    System.arraycopy(p.y().o(p.y().B(size2)), 0, qVar.b().get(i12).b(), 4, c10.length);
                    qVar.c().get(i12).i(p.y().o(p.y().B(size2)));
                    size2 += p.y().p(c10);
                } else {
                    int i13 = 0;
                    while (true) {
                        if (i13 >= arrayList.size()) {
                            break;
                        } else if (l10 == ((e) arrayList.get(i13)).b()) {
                            int i14 = 0;
                            while (true) {
                                if (i14 >= qVar.c().size()) {
                                    break;
                                } else if (((e) arrayList.get(i13)).a() == p.y().l(qVar.c().get(i14).e())) {
                                    System.arraycopy(qVar.c().get(i14).c(), 0, qVar.b().get(i12).b(), 4, 4);
                                    qVar.c().get(i12).i(qVar.c().get(i14).c());
                                    break;
                                } else {
                                    i14++;
                                }
                            }
                        } else {
                            i13++;
                        }
                    }
                }
            }
        }
        return qVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:181:0x0749  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0768  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0777  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x07a8  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0916  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0955  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x096a  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0972  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] d(Context context, Bitmap bitmap, boolean z10, int i10, boolean z11) {
        int i11;
        int i12;
        int i13;
        AssetManager assetManager;
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i14;
        j jVar;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        k kVar;
        String[] strArr;
        int i15;
        String str2;
        int i16;
        int i17;
        byte[] bArr;
        byte[] bArr2;
        byte[] bArr3;
        int i18;
        int i19;
        int i20;
        bn.b s10;
        int i21;
        int i22;
        char c10;
        int i23;
        int i24;
        int i25;
        int i26;
        char c11;
        int G = z.v(context).G();
        int F = z.v(context).F();
        Bitmap l10 = bitmap == null ? l(context) : bitmap;
        String str3 = "DialCustom/" + this.f5320d;
        AssetManager assets = context.getResources().getAssets();
        String[] list = assets.list(str3);
        q qVar = new q();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        while (true) {
            ArrayList arrayList10 = arrayList9;
            if (i29 < list.length) {
                byte[] bArr4 = new byte[0];
                k kVar2 = new k();
                qVar = qVar;
                l lVar = new l();
                ArrayList arrayList11 = arrayList7;
                j jVar2 = new j();
                String str4 = list[i29];
                char c12 = 65535;
                ArrayList arrayList12 = arrayList8;
                switch (str4.hashCode()) {
                    case -2076896158:
                        if (str4.equals("timeday1")) {
                            c11 = 16;
                            c12 = c11;
                            break;
                        }
                        break;
                    case -2076896157:
                        if (str4.equals("timeday2")) {
                            c11 = 17;
                            c12 = c11;
                            break;
                        }
                        break;
                    case -2076763599:
                        if (str4.equals("timehour")) {
                            c11 = 18;
                            c12 = c11;
                            break;
                        }
                        break;
                    case -2076620692:
                        if (str4.equals("timemin1")) {
                            c11 = 22;
                            c12 = c11;
                            break;
                        }
                        break;
                    case -2076620691:
                        if (str4.equals("timemin2")) {
                            c11 = 23;
                            c12 = c11;
                            break;
                        }
                        break;
                    case -1893555910:
                        if (str4.equals("stepnum")) {
                            c11 = '\b';
                            c12 = c11;
                            break;
                        }
                        break;
                    case -1553608662:
                        if (str4.equals("day2month")) {
                            c11 = 3;
                            c12 = c11;
                            break;
                        }
                        break;
                    case -1332194002:
                        if (str4.equals("background")) {
                            c11 = 1;
                            c12 = c11;
                            break;
                        }
                        break;
                    case -1313922641:
                        if (str4.equals("timeday")) {
                            c11 = 15;
                            c12 = c11;
                            break;
                        }
                        break;
                    case -1313913755:
                        if (str4.equals("timemin")) {
                            c11 = 21;
                            c12 = c11;
                            break;
                        }
                        break;
                    case -914129323:
                        if (str4.equals("iconbluetooth")) {
                            c11 = 5;
                            c12 = c11;
                            break;
                        }
                        break;
                    case -736993595:
                        if (str4.equals("iconstep")) {
                            c11 = 6;
                            c12 = c11;
                            break;
                        }
                        break;
                    case -331239923:
                        if (str4.equals("battery")) {
                            c11 = 2;
                            c12 = c11;
                            break;
                        }
                        break;
                    case -318184504:
                        if (str4.equals("preview")) {
                            c11 = 7;
                            c12 = c11;
                            break;
                        }
                        break;
                    case -278000284:
                        if (str4.equals("stepproccess")) {
                            c11 = 14;
                            c12 = c11;
                            break;
                        }
                        break;
                    case -246168380:
                        if (str4.equals("hour2min")) {
                            c11 = 4;
                            c12 = c11;
                            break;
                        }
                        break;
                    case 2998057:
                        if (str4.equals("ampm")) {
                            c11 = 0;
                            c12 = c11;
                            break;
                        }
                        break;
                    case 3645428:
                        if (str4.equals("week")) {
                            c11 = 27;
                            c12 = c11;
                            break;
                        }
                        break;
                    case 44837920:
                        if (str4.equals("timehour1")) {
                            c11 = 19;
                            c12 = c11;
                            break;
                        }
                        break;
                    case 44837921:
                        if (str4.equals("timehour2")) {
                            c11 = 20;
                            c12 = c11;
                            break;
                        }
                        break;
                    case 49448915:
                        if (str4.equals("timemonth")) {
                            c11 = 24;
                            c12 = c11;
                            break;
                        }
                        break;
                    case 201103807:
                        if (str4.equals("hearticon")) {
                            c11 = 28;
                            c12 = c11;
                            break;
                        }
                        break;
                    case 201269937:
                        if (str4.equals("heartnum1")) {
                            c11 = 29;
                            c12 = c11;
                            break;
                        }
                        break;
                    case 201269938:
                        if (str4.equals("heartnum2")) {
                            c11 = 30;
                            c12 = c11;
                            break;
                        }
                        break;
                    case 201269939:
                        if (str4.equals("heartnum3")) {
                            c11 = 31;
                            c12 = c11;
                            break;
                        }
                        break;
                    case 1429308983:
                        if (str4.equals("stepnum1")) {
                            c11 = '\t';
                            c12 = c11;
                            break;
                        }
                        break;
                    case 1429308984:
                        if (str4.equals("stepnum2")) {
                            c11 = '\n';
                            c12 = c11;
                            break;
                        }
                        break;
                    case 1429308985:
                        if (str4.equals("stepnum3")) {
                            c11 = 11;
                            c12 = c11;
                            break;
                        }
                        break;
                    case 1429308986:
                        if (str4.equals("stepnum4")) {
                            c11 = '\f';
                            c12 = c11;
                            break;
                        }
                        break;
                    case 1429308987:
                        if (str4.equals("stepnum5")) {
                            c11 = '\r';
                            c12 = c11;
                            break;
                        }
                        break;
                    case 1532916414:
                        if (str4.equals("timemonth1")) {
                            c11 = 25;
                            c12 = c11;
                            break;
                        }
                        break;
                    case 1532916415:
                        if (str4.equals("timemonth2")) {
                            c11 = JSONLexer.EOI;
                            c12 = c11;
                            break;
                        }
                        break;
                }
                switch (c12) {
                    case 0:
                        i24 = i28;
                        kVar2.l(p.y().k(p.y().A(16)));
                        lVar.e(16);
                        i23 = 16;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 1:
                        kVar2.l(p.y().k(p.y().A(17)));
                        lVar.e(17);
                        i24 = 1;
                        i23 = 17;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 2:
                        i25 = i28;
                        i26 = 8;
                        kVar2.l(p.y().k(p.y().A(8)));
                        lVar.e(i26);
                        i23 = i26;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 3:
                        i25 = i28;
                        i26 = 14;
                        kVar2.l(p.y().k(p.y().A(14)));
                        lVar.e(i26);
                        i23 = i26;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 4:
                        i25 = i28;
                        i26 = 7;
                        kVar2.l(p.y().k(p.y().A(7)));
                        lVar.e(i26);
                        i23 = i26;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 5:
                        i25 = i28;
                        i26 = 9;
                        kVar2.l(p.y().k(p.y().A(9)));
                        lVar.e(i26);
                        i23 = i26;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 6:
                        i25 = i28;
                        i26 = 24;
                        kVar2.l(p.y().k(p.y().A(24)));
                        lVar.e(i26);
                        i23 = i26;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 7:
                        i24 = i28;
                        kVar2.l(p.y().k(p.y().A(10)));
                        lVar.e(10);
                        i23 = 10;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case '\b':
                        i25 = i28;
                        i26 = 25;
                        kVar2.l(p.y().k(p.y().A(25)));
                        lVar.e(i26);
                        i23 = i26;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case '\t':
                        i25 = i28;
                        i26 = 38;
                        kVar2.l(p.y().k(p.y().A(38)));
                        lVar.e(i26);
                        i23 = i26;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case '\n':
                        i25 = i28;
                        kVar2.l(p.y().k(p.y().A(39)));
                        lVar.e(39);
                        i23 = 39;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 11:
                        i25 = i28;
                        kVar2.l(p.y().k(p.y().A(40)));
                        lVar.e(40);
                        i23 = 40;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case '\f':
                        i25 = i28;
                        kVar2.l(p.y().k(p.y().A(41)));
                        lVar.e(41);
                        i23 = 41;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case '\r':
                        i25 = i28;
                        i26 = 42;
                        kVar2.l(p.y().k(p.y().A(42)));
                        lVar.e(i26);
                        i23 = i26;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 14:
                        i25 = i28;
                        kVar2.l(p.y().k(p.y().A(32)));
                        lVar.e(32);
                        i23 = 32;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 15:
                        i25 = i28;
                        i26 = 13;
                        kVar2.l(p.y().k(p.y().A(13)));
                        lVar.e(i26);
                        i23 = i26;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 16:
                        i25 = i28;
                        kVar2.l(p.y().k(p.y().A(65)));
                        lVar.e(65);
                        i23 = 65;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 17:
                        i25 = i28;
                        kVar2.l(p.y().k(p.y().A(66)));
                        lVar.e(66);
                        i23 = 66;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 18:
                        i25 = i28;
                        i26 = 4;
                        kVar2.l(p.y().k(p.y().A(4)));
                        lVar.e(i26);
                        i23 = i26;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 19:
                        i25 = i28;
                        i26 = 57;
                        kVar2.l(p.y().k(p.y().A(57)));
                        lVar.e(i26);
                        i23 = i26;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 20:
                        i25 = i28;
                        kVar2.l(p.y().k(p.y().A(58)));
                        lVar.e(58);
                        i23 = 58;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 21:
                        i25 = i28;
                        i26 = 5;
                        kVar2.l(p.y().k(p.y().A(5)));
                        lVar.e(i26);
                        i23 = i26;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 22:
                        i25 = i28;
                        kVar2.l(p.y().k(p.y().A(59)));
                        lVar.e(59);
                        i23 = 59;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 23:
                        i25 = i28;
                        kVar2.l(p.y().k(p.y().A(60)));
                        lVar.e(60);
                        i23 = 60;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 24:
                        i25 = i28;
                        i26 = 11;
                        kVar2.l(p.y().k(p.y().A(11)));
                        lVar.e(i26);
                        i23 = i26;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 25:
                        i25 = i28;
                        kVar2.l(p.y().k(p.y().A(63)));
                        lVar.e(63);
                        i23 = 63;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 26:
                        i25 = i28;
                        kVar2.l(p.y().k(p.y().A(64)));
                        lVar.e(64);
                        i23 = 64;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 27:
                        i25 = i28;
                        i26 = 15;
                        kVar2.l(p.y().k(p.y().A(15)));
                        lVar.e(i26);
                        i23 = i26;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 28:
                        i24 = i28;
                        kVar2.l(p.y().k(p.y().A(18)));
                        lVar.e(18);
                        i23 = 18;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 29:
                        i25 = i28;
                        kVar2.l(p.y().k(p.y().A(35)));
                        lVar.e(35);
                        i23 = 35;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 30:
                        i25 = i28;
                        kVar2.l(p.y().k(p.y().A(36)));
                        lVar.e(36);
                        i23 = 36;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    case 31:
                        i25 = i28;
                        kVar2.l(p.y().k(p.y().A(37)));
                        lVar.e(37);
                        i23 = 37;
                        i24 = i25;
                        jVar2.e(i23);
                        i11 = i24;
                        break;
                    default:
                        i11 = i28;
                        break;
                }
                bn.b s11 = s(lVar.c());
                if (s11 == null || s11.d()) {
                    String str5 = str3 + "/" + list[i29];
                    String[] H = H(assets.list(str5));
                    j jVar3 = jVar2;
                    str = str3;
                    assetManager = assets;
                    int i30 = 0;
                    int i31 = 0;
                    int i32 = 0;
                    int i33 = 0;
                    int i34 = 0;
                    while (i30 < H.length) {
                        i27 = i27;
                        if (H[i30].endsWith("txt") || H[i30].endsWith("TXT")) {
                            String replaceAll = H[i30].replaceAll("config_", "").replaceAll(".txt", "");
                            p.a("all2 =" + replaceAll + "," + list[i29]);
                            if (!replaceAll.contains("scalepreview_") || !list[i29].equals("preview")) {
                                i20 = i29;
                                if (replaceAll.contains("_")) {
                                    String[] split = replaceAll.split("_");
                                    String str6 = split[0];
                                    if (str6.contains("x")) {
                                        String str7 = str6.split("x")[0];
                                        String[] split2 = str6.split("x");
                                        c10 = 1;
                                        String str8 = split2[1];
                                        i33 = Integer.parseInt(str7);
                                        i34 = Integer.parseInt(str8);
                                    } else {
                                        c10 = 1;
                                    }
                                    String str9 = split[c10];
                                    p.a("xy =" + str9);
                                    if (str9.contains("x")) {
                                        String str10 = str9.split("x")[0];
                                        String str11 = str9.split("x")[1];
                                        i31 = Integer.parseInt(str10);
                                        i32 = Integer.parseInt(str11);
                                        int i35 = i31;
                                        int i36 = i32;
                                        int i37 = i33;
                                        int i38 = i34;
                                        p.a("width =" + i37 + ",height =" + i38 + ",xx =" + i35 + ",yy =" + i36);
                                        s10 = s(lVar.c());
                                        if (s10 != null) {
                                            if (s10.b() >= 0) {
                                                i22 = i35;
                                                if (s10.b() <= G - i37) {
                                                    i35 = s10.b();
                                                    if (s10.c() < 0) {
                                                        i21 = i36;
                                                        if (s10.c() <= F - i38) {
                                                            i36 = s10.c();
                                                            p.a("新的width =" + i37 + ",height =" + i38 + ",xx =" + i35 + ",yy =" + i36);
                                                        }
                                                    } else {
                                                        i21 = i36;
                                                    }
                                                    i36 = i21;
                                                    p.a("新的width =" + i37 + ",height =" + i38 + ",xx =" + i35 + ",yy =" + i36);
                                                }
                                            } else {
                                                i22 = i35;
                                            }
                                            i35 = i22;
                                            if (s10.c() < 0) {
                                            }
                                            i36 = i21;
                                            p.a("新的width =" + i37 + ",height =" + i38 + ",xx =" + i35 + ",yy =" + i36);
                                        }
                                        kVar2.j(p.y().k(p.y().A(i37)));
                                        kVar2.h(p.y().k(p.y().A(i38)));
                                        kVar2.m(p.y().k(p.y().A(i35)));
                                        kVar2.n(p.y().k(p.y().A(i36)));
                                        i31 = i35;
                                        kVar2.g(p.y().k(p.y().A(0)));
                                        kVar2.k(p.y().F());
                                        i34 = i38;
                                        i32 = i36;
                                        i33 = i37;
                                        i30++;
                                        i29 = i20;
                                    }
                                }
                                int i352 = i31;
                                int i362 = i32;
                                int i372 = i33;
                                int i382 = i34;
                                p.a("width =" + i372 + ",height =" + i382 + ",xx =" + i352 + ",yy =" + i362);
                                s10 = s(lVar.c());
                                if (s10 != null) {
                                }
                                kVar2.j(p.y().k(p.y().A(i372)));
                                kVar2.h(p.y().k(p.y().A(i382)));
                                kVar2.m(p.y().k(p.y().A(i352)));
                                kVar2.n(p.y().k(p.y().A(i362)));
                                i31 = i352;
                                kVar2.g(p.y().k(p.y().A(0)));
                                kVar2.k(p.y().F());
                                i34 = i382;
                                i32 = i362;
                                i33 = i372;
                                i30++;
                                i29 = i20;
                            } else {
                                String replaceAll2 = replaceAll.replaceAll("scalepreview_", "");
                                if (replaceAll2.contains("_")) {
                                    String[] split3 = replaceAll2.split("_");
                                    if (split3.length >= 3) {
                                        i20 = i29;
                                        F(new o(Float.parseFloat(split3[0]), Float.parseFloat(split3[1]), Float.parseFloat(split3[2])));
                                        i30++;
                                        i29 = i20;
                                    }
                                }
                            }
                        }
                        i20 = i29;
                        i30++;
                        i29 = i20;
                    }
                    i13 = i27;
                    i12 = i29;
                    int i39 = 0;
                    int i40 = 0;
                    int i41 = 0;
                    while (i40 < H.length) {
                        if ((H[i40].endsWith("png") || H[i40].endsWith("PNG") || H[i40].endsWith("bmp") || H[i40].endsWith("BMP") || H[i40].endsWith("jpg") || H[i40].endsWith("JPG")) && !H[i40].equals("preview_bg.png") && !H[i40].equals("preview_bg.PNG")) {
                            i39++;
                            String str12 = str5 + "/" + H[i40];
                            if (lVar.c() == 17) {
                                bArr3 = p.y().e(l10, i31, i32);
                            } else if (lVar.c() == 10) {
                                bArr3 = p.y().h(p.y().G(context, str12));
                            } else {
                                strArr = H;
                                kVar = kVar2;
                                arrayList6 = arrayList10;
                                str2 = str5;
                                bArr2 = bArr4;
                                arrayList5 = arrayList12;
                                i18 = 1;
                                i15 = i40;
                                arrayList4 = arrayList11;
                                jVar = jVar3;
                                bArr3 = p.y().f(l10, p.y().G(context, str12), i31, i32, z10, i10);
                                if (!z11) {
                                    int c13 = lVar.c();
                                    if ((c13 < i18 || c13 > 3) && (c13 < 35 || c13 > 37)) {
                                        if ((c13 < 38 || c13 > 42) && ((c13 < 43 || c13 > 46) && (c13 < 52 || c13 > 56))) {
                                            if (c13 < 57 || c13 > 70) {
                                                i19 = i18;
                                                if (i19 != 0) {
                                                    i17 = i33;
                                                    i16 = i34;
                                                    bArr3 = p.y().E(p.y().d(bArr3, i17, i16));
                                                } else {
                                                    i17 = i33;
                                                    i16 = i34;
                                                }
                                                i41 += bArr3.length;
                                            }
                                            i19 = 0;
                                            if (i19 != 0) {
                                            }
                                            i41 += bArr3.length;
                                        }
                                    }
                                    i19 = 0;
                                    if (i19 != 0) {
                                    }
                                    i41 += bArr3.length;
                                } else {
                                    i17 = i33;
                                    i16 = i34;
                                }
                                byte[] bArr5 = bArr2;
                                bArr = new byte[bArr5.length + bArr3.length];
                                System.arraycopy(bArr5, 0, bArr, 0, bArr5.length);
                                System.arraycopy(bArr3, 0, bArr, bArr5.length, bArr3.length);
                                i13 += bArr3.length;
                            }
                            strArr = H;
                            kVar = kVar2;
                            bArr2 = bArr4;
                            i15 = i40;
                            arrayList6 = arrayList10;
                            arrayList4 = arrayList11;
                            arrayList5 = arrayList12;
                            jVar = jVar3;
                            i18 = 1;
                            str2 = str5;
                            if (!z11) {
                            }
                            byte[] bArr52 = bArr2;
                            bArr = new byte[bArr52.length + bArr3.length];
                            System.arraycopy(bArr52, 0, bArr, 0, bArr52.length);
                            System.arraycopy(bArr3, 0, bArr, bArr52.length, bArr3.length);
                            i13 += bArr3.length;
                        } else {
                            strArr = H;
                            kVar = kVar2;
                            bArr = bArr4;
                            i15 = i40;
                            arrayList6 = arrayList10;
                            i17 = i33;
                            arrayList4 = arrayList11;
                            arrayList5 = arrayList12;
                            i16 = i34;
                            jVar = jVar3;
                            str2 = str5;
                        }
                        i40 = i15 + 1;
                        i33 = i17;
                        i34 = i16;
                        str5 = str2;
                        kVar2 = kVar;
                        arrayList10 = arrayList6;
                        arrayList12 = arrayList5;
                        arrayList11 = arrayList4;
                        jVar3 = jVar;
                        bArr4 = bArr;
                        H = strArr;
                    }
                    k kVar3 = kVar2;
                    byte[] bArr6 = bArr4;
                    arrayList2 = arrayList10;
                    int i42 = i33;
                    arrayList3 = arrayList11;
                    arrayList = arrayList12;
                    int i43 = i34;
                    j jVar4 = jVar3;
                    kVar3.f(p.y().z(i39));
                    if (!z11) {
                        i14 = 2;
                        i41 = i42 * i43 * 2 * i39;
                    } else {
                        i14 = 2;
                    }
                    int i44 = i41;
                    byte[] o10 = p.y().o(p.y().B(i44));
                    p.a("picCount =" + i39 + ",dataLength =" + i44 + ",addr = " + p.y().m(o10));
                    kVar3.i(o10);
                    arrayList2.add(kVar3);
                    byte[] bArr7 = new byte[24];
                    byte[] bArr8 = kVar3.f5305a;
                    System.arraycopy(bArr8, 0, bArr7, 0, bArr8.length);
                    byte[] bArr9 = kVar3.f5306b;
                    System.arraycopy(bArr9, 0, bArr7, i14, bArr9.length);
                    byte[] bArr10 = kVar3.f5307c;
                    System.arraycopy(bArr10, 0, bArr7, 4, bArr10.length);
                    byte[] bArr11 = kVar3.f5308d;
                    System.arraycopy(bArr11, 0, bArr7, 8, bArr11.length);
                    byte[] bArr12 = kVar3.f5309e;
                    System.arraycopy(bArr12, 0, bArr7, 10, bArr12.length);
                    byte[] bArr13 = kVar3.f5310f;
                    System.arraycopy(bArr13, 0, bArr7, 12, bArr13.length);
                    byte[] bArr14 = kVar3.f5311g;
                    System.arraycopy(bArr14, 0, bArr7, 14, bArr14.length);
                    byte[] bArr15 = kVar3.f5312h;
                    System.arraycopy(bArr15, 0, bArr7, 16, bArr15.length);
                    byte[] bArr16 = kVar3.f5313i;
                    System.arraycopy(bArr16, 0, bArr7, 17, bArr16.length);
                    lVar.d(bArr7);
                    arrayList3.add(lVar);
                    jVar4.d(bArr6);
                    arrayList.add(jVar4);
                } else {
                    p.a("不显示类型 =" + lVar.c());
                    i13 = i27;
                    i12 = i29;
                    str = str3;
                    assetManager = assets;
                    arrayList2 = arrayList10;
                    arrayList3 = arrayList11;
                    arrayList = arrayList12;
                }
                i29 = i12 + 1;
                arrayList7 = arrayList3;
                arrayList9 = arrayList2;
                arrayList8 = arrayList;
                str3 = str;
                assets = assetManager;
                i27 = i13;
                i28 = i11;
            } else {
                int i45 = i28;
                ArrayList arrayList13 = arrayList8;
                ArrayList arrayList14 = arrayList7;
                q qVar2 = qVar;
                s sVar = new s();
                sVar.i(p.y().c());
                sVar.b(p.y().o(p.y().B((list.length * 24) + i27)));
                sVar.f(p.y().k(p.y().A(G)));
                sVar.e(p.y().k(p.y().A(F)));
                sVar.h(p.y().z(this.f5324h));
                sVar.c(p.y().z(i45));
                sVar.d(p.y().z(255));
                sVar.g(p.y().O());
                sVar.a(p.y().o(p.y().B(805233808)));
                qVar2.j(sVar);
                byte[] bArr17 = new byte[24];
                byte[] bArr18 = sVar.f5348a;
                System.arraycopy(bArr18, 0, bArr17, 0, bArr18.length);
                byte[] bArr19 = sVar.f5349b;
                System.arraycopy(bArr19, 0, bArr17, 4, bArr19.length);
                byte[] bArr20 = sVar.f5350c;
                System.arraycopy(bArr20, 0, bArr17, 8, bArr20.length);
                byte[] bArr21 = sVar.f5351d;
                System.arraycopy(bArr21, 0, bArr17, 12, bArr21.length);
                byte[] bArr22 = sVar.f5352e;
                System.arraycopy(bArr22, 0, bArr17, 14, bArr22.length);
                byte[] bArr23 = sVar.f5353f;
                System.arraycopy(bArr23, 0, bArr17, 16, bArr23.length);
                byte[] bArr24 = sVar.f5354g;
                System.arraycopy(bArr24, 0, bArr17, 17, bArr24.length);
                byte[] bArr25 = sVar.f5355h;
                System.arraycopy(bArr25, 0, bArr17, 18, bArr25.length);
                byte[] bArr26 = sVar.f5356i;
                System.arraycopy(bArr26, 0, bArr17, 19, bArr26.length);
                qVar2.j(sVar);
                qVar2.i(bArr17);
                Collections.sort(arrayList10);
                Collections.sort(arrayList14);
                Collections.sort(arrayList13);
                qVar2.h(arrayList10);
                qVar2.g(arrayList14);
                qVar2.f(arrayList13);
                byte[] M = p.y().M(a(qVar2));
                sVar.b(p.y().o(p.y().B(M.length - 24)));
                byte[] bArr27 = sVar.f5349b;
                System.arraycopy(bArr27, 0, M, 4, bArr27.length);
                byte[] o11 = p.y().o(p.y().B(p.y().N(M)));
                sVar.a(o11);
                System.arraycopy(o11, 0, M, 8, o11.length);
                if (z11) {
                    M[19] = (byte) z.v(context).r();
                }
                return M;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:225:0x08a3  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x08df  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x08f2  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x08f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private byte[] e(Context context, Bitmap bitmap, boolean z10, int i10, boolean z11) {
        int i11;
        Bitmap bitmap2;
        int i12;
        int i13;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i14;
        l lVar;
        k kVar;
        j jVar;
        Bitmap bitmap3;
        File[] fileArr;
        int i15;
        int i16;
        int i17;
        int i18;
        byte[] bArr;
        int i19;
        boolean z12;
        int i20;
        int i21;
        int i22;
        char c10;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        char c11;
        int G = z.v(context).G();
        int F = z.v(context).F();
        Bitmap l10 = bitmap == null ? l(context) : bitmap;
        File[] n10 = n(this.f5321e);
        q qVar = new q();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        int i29 = 0;
        int i30 = 0;
        int i31 = 0;
        int i32 = 0;
        while (i32 < n10.length) {
            byte[] bArr2 = new byte[i29];
            k kVar2 = new k();
            l lVar2 = new l();
            j jVar2 = new j();
            String name = n10[i32].getName();
            char c12 = 65535;
            qVar = qVar;
            switch (name.hashCode()) {
                case -2076896158:
                    if (name.equals("timeday1")) {
                        c11 = 16;
                        c12 = c11;
                        break;
                    }
                    break;
                case -2076896157:
                    if (name.equals("timeday2")) {
                        c11 = 17;
                        c12 = c11;
                        break;
                    }
                    break;
                case -2076763599:
                    if (name.equals("timehour")) {
                        c11 = 18;
                        c12 = c11;
                        break;
                    }
                    break;
                case -2076620692:
                    if (name.equals("timemin1")) {
                        c11 = 22;
                        c12 = c11;
                        break;
                    }
                    break;
                case -2076620691:
                    if (name.equals("timemin2")) {
                        c11 = 23;
                        c12 = c11;
                        break;
                    }
                    break;
                case -1893555910:
                    if (name.equals("stepnum")) {
                        c11 = '\b';
                        c12 = c11;
                        break;
                    }
                    break;
                case -1553608662:
                    if (name.equals("day2month")) {
                        c11 = 3;
                        c12 = c11;
                        break;
                    }
                    break;
                case -1332194002:
                    if (name.equals("background")) {
                        c11 = 1;
                        c12 = c11;
                        break;
                    }
                    break;
                case -1313922641:
                    if (name.equals("timeday")) {
                        c11 = 15;
                        c12 = c11;
                        break;
                    }
                    break;
                case -1313913755:
                    if (name.equals("timemin")) {
                        c11 = 21;
                        c12 = c11;
                        break;
                    }
                    break;
                case -914129323:
                    if (name.equals("iconbluetooth")) {
                        c11 = 5;
                        c12 = c11;
                        break;
                    }
                    break;
                case -736993595:
                    if (name.equals("iconstep")) {
                        c11 = 6;
                        c12 = c11;
                        break;
                    }
                    break;
                case -331239923:
                    if (name.equals("battery")) {
                        c11 = 2;
                        c12 = c11;
                        break;
                    }
                    break;
                case -318184504:
                    if (name.equals("preview")) {
                        c11 = 7;
                        c12 = c11;
                        break;
                    }
                    break;
                case -278000284:
                    if (name.equals("stepproccess")) {
                        c11 = 14;
                        c12 = c11;
                        break;
                    }
                    break;
                case -246168380:
                    if (name.equals("hour2min")) {
                        c11 = 4;
                        c12 = c11;
                        break;
                    }
                    break;
                case 2998057:
                    if (name.equals("ampm")) {
                        c11 = 0;
                        c12 = c11;
                        break;
                    }
                    break;
                case 3645428:
                    if (name.equals("week")) {
                        c11 = 27;
                        c12 = c11;
                        break;
                    }
                    break;
                case 44837920:
                    if (name.equals("timehour1")) {
                        c11 = 19;
                        c12 = c11;
                        break;
                    }
                    break;
                case 44837921:
                    if (name.equals("timehour2")) {
                        c11 = 20;
                        c12 = c11;
                        break;
                    }
                    break;
                case 49448915:
                    if (name.equals("timemonth")) {
                        c11 = 24;
                        c12 = c11;
                        break;
                    }
                    break;
                case 201103807:
                    if (name.equals("hearticon")) {
                        c11 = 28;
                        c12 = c11;
                        break;
                    }
                    break;
                case 201269937:
                    if (name.equals("heartnum1")) {
                        c11 = 29;
                        c12 = c11;
                        break;
                    }
                    break;
                case 201269938:
                    if (name.equals("heartnum2")) {
                        c11 = 30;
                        c12 = c11;
                        break;
                    }
                    break;
                case 201269939:
                    if (name.equals("heartnum3")) {
                        c11 = 31;
                        c12 = c11;
                        break;
                    }
                    break;
                case 1429308983:
                    if (name.equals("stepnum1")) {
                        c11 = '\t';
                        c12 = c11;
                        break;
                    }
                    break;
                case 1429308984:
                    if (name.equals("stepnum2")) {
                        c11 = '\n';
                        c12 = c11;
                        break;
                    }
                    break;
                case 1429308985:
                    if (name.equals("stepnum3")) {
                        c11 = 11;
                        c12 = c11;
                        break;
                    }
                    break;
                case 1429308986:
                    if (name.equals("stepnum4")) {
                        c11 = '\f';
                        c12 = c11;
                        break;
                    }
                    break;
                case 1429308987:
                    if (name.equals("stepnum5")) {
                        c11 = '\r';
                        c12 = c11;
                        break;
                    }
                    break;
                case 1532916414:
                    if (name.equals("timemonth1")) {
                        c11 = 25;
                        c12 = c11;
                        break;
                    }
                    break;
                case 1532916415:
                    if (name.equals("timemonth2")) {
                        c11 = JSONLexer.EOI;
                        c12 = c11;
                        break;
                    }
                    break;
            }
            switch (c12) {
                case 0:
                    i25 = i31;
                    kVar2.l(p.y().k(p.y().A(16)));
                    lVar2.e(16);
                    i24 = 16;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 1:
                    kVar2.l(p.y().k(p.y().A(17)));
                    lVar2.e(17);
                    i25 = 1;
                    i24 = 17;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 2:
                    i26 = i31;
                    i27 = 8;
                    kVar2.l(p.y().k(p.y().A(8)));
                    lVar2.e(i27);
                    i24 = i27;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 3:
                    i26 = i31;
                    i27 = 14;
                    kVar2.l(p.y().k(p.y().A(14)));
                    lVar2.e(i27);
                    i24 = i27;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 4:
                    i26 = i31;
                    i27 = 7;
                    kVar2.l(p.y().k(p.y().A(7)));
                    lVar2.e(i27);
                    i24 = i27;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 5:
                    i26 = i31;
                    i27 = 9;
                    kVar2.l(p.y().k(p.y().A(9)));
                    lVar2.e(i27);
                    i24 = i27;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 6:
                    i26 = i31;
                    i27 = 24;
                    kVar2.l(p.y().k(p.y().A(24)));
                    lVar2.e(i27);
                    i24 = i27;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 7:
                    i25 = i31;
                    kVar2.l(p.y().k(p.y().A(10)));
                    lVar2.e(10);
                    i24 = 10;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case '\b':
                    i26 = i31;
                    i27 = 25;
                    kVar2.l(p.y().k(p.y().A(25)));
                    lVar2.e(i27);
                    i24 = i27;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case '\t':
                    i26 = i31;
                    i27 = 38;
                    kVar2.l(p.y().k(p.y().A(38)));
                    lVar2.e(i27);
                    i24 = i27;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case '\n':
                    i26 = i31;
                    kVar2.l(p.y().k(p.y().A(39)));
                    i28 = 39;
                    lVar2.e(i28);
                    i24 = i28;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 11:
                    i26 = i31;
                    kVar2.l(p.y().k(p.y().A(40)));
                    i28 = 40;
                    lVar2.e(i28);
                    i24 = i28;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case '\f':
                    i26 = i31;
                    kVar2.l(p.y().k(p.y().A(41)));
                    i28 = 41;
                    lVar2.e(i28);
                    i24 = i28;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case '\r':
                    i26 = i31;
                    i27 = 42;
                    kVar2.l(p.y().k(p.y().A(42)));
                    lVar2.e(i27);
                    i24 = i27;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 14:
                    i26 = i31;
                    kVar2.l(p.y().k(p.y().A(32)));
                    i28 = 32;
                    lVar2.e(i28);
                    i24 = i28;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 15:
                    i26 = i31;
                    i27 = 13;
                    kVar2.l(p.y().k(p.y().A(13)));
                    lVar2.e(i27);
                    i24 = i27;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 16:
                    i26 = i31;
                    kVar2.l(p.y().k(p.y().A(65)));
                    i28 = 65;
                    lVar2.e(i28);
                    i24 = i28;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 17:
                    i26 = i31;
                    kVar2.l(p.y().k(p.y().A(66)));
                    i28 = 66;
                    lVar2.e(i28);
                    i24 = i28;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 18:
                    i26 = i31;
                    i27 = 4;
                    kVar2.l(p.y().k(p.y().A(4)));
                    lVar2.e(i27);
                    i24 = i27;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 19:
                    i25 = i31;
                    kVar2.l(p.y().k(p.y().A(57)));
                    lVar2.e(57);
                    i24 = 57;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 20:
                    i26 = i31;
                    kVar2.l(p.y().k(p.y().A(58)));
                    i28 = 58;
                    lVar2.e(i28);
                    i24 = i28;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 21:
                    i26 = i31;
                    i27 = 5;
                    kVar2.l(p.y().k(p.y().A(5)));
                    lVar2.e(i27);
                    i24 = i27;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 22:
                    i26 = i31;
                    kVar2.l(p.y().k(p.y().A(59)));
                    i28 = 59;
                    lVar2.e(i28);
                    i24 = i28;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 23:
                    i26 = i31;
                    kVar2.l(p.y().k(p.y().A(60)));
                    i28 = 60;
                    lVar2.e(i28);
                    i24 = i28;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 24:
                    i26 = i31;
                    i27 = 11;
                    kVar2.l(p.y().k(p.y().A(11)));
                    lVar2.e(i27);
                    i24 = i27;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 25:
                    i26 = i31;
                    kVar2.l(p.y().k(p.y().A(63)));
                    i28 = 63;
                    lVar2.e(i28);
                    i24 = i28;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 26:
                    i26 = i31;
                    kVar2.l(p.y().k(p.y().A(64)));
                    i28 = 64;
                    lVar2.e(i28);
                    i24 = i28;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 27:
                    i26 = i31;
                    i27 = 15;
                    kVar2.l(p.y().k(p.y().A(15)));
                    lVar2.e(i27);
                    i24 = i27;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 28:
                    i25 = i31;
                    kVar2.l(p.y().k(p.y().A(18)));
                    lVar2.e(18);
                    i24 = 18;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 29:
                    i26 = i31;
                    kVar2.l(p.y().k(p.y().A(35)));
                    i28 = 35;
                    lVar2.e(i28);
                    i24 = i28;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 30:
                    i26 = i31;
                    kVar2.l(p.y().k(p.y().A(36)));
                    i28 = 36;
                    lVar2.e(i28);
                    i24 = i28;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                case 31:
                    i26 = i31;
                    kVar2.l(p.y().k(p.y().A(37)));
                    i28 = 37;
                    lVar2.e(i28);
                    i24 = i28;
                    i25 = i26;
                    jVar2.e(i24);
                    i11 = i25;
                    break;
                default:
                    i11 = i31;
                    break;
            }
            bn.b s10 = s(lVar2.c());
            if (s10 == null || s10.d()) {
                File[] G2 = G(n10[i32].listFiles());
                j jVar3 = jVar2;
                arrayList = arrayList4;
                arrayList2 = arrayList5;
                arrayList3 = arrayList6;
                int i33 = 0;
                int i34 = 0;
                int i35 = 0;
                int i36 = 0;
                int i37 = 0;
                while (i33 < G2.length) {
                    i30 = i30;
                    if (G2[i33].getName().endsWith("txt") || G2[i33].getName().endsWith("TXT")) {
                        i21 = i34;
                        String replaceAll = G2[i33].getName().replaceAll("config_", "").replaceAll(".txt", "");
                        p.a("all2 =" + replaceAll + "," + n10[i32]);
                        if (!replaceAll.contains("scalepreview_") || !n10[i32].getName().equals("preview")) {
                            i20 = i32;
                            if (replaceAll.contains("_")) {
                                String[] split = replaceAll.split("_");
                                String str = split[0];
                                if (str.contains("x")) {
                                    String str2 = str.split("x")[0];
                                    String[] split2 = str.split("x");
                                    c10 = 1;
                                    String str3 = split2[1];
                                    i22 = Integer.parseInt(str2);
                                    i23 = Integer.parseInt(str3);
                                } else {
                                    c10 = 1;
                                    i23 = i36;
                                    i22 = i21;
                                }
                                String str4 = split[c10];
                                StringBuilder sb2 = new StringBuilder();
                                i36 = i23;
                                sb2.append("xy =");
                                sb2.append(str4);
                                p.a(sb2.toString());
                                if (str4.contains("x")) {
                                    String str5 = str4.split("x")[0];
                                    String str6 = str4.split("x")[1];
                                    i35 = Integer.parseInt(str5);
                                    i37 = Integer.parseInt(str6);
                                }
                                i34 = i22;
                            } else {
                                i34 = i21;
                            }
                            p.a("width =" + i34 + ",height =" + i36 + ",xx =" + i35 + ",yy =" + i37);
                            bn.b s11 = s(lVar2.c());
                            if (s11 != null) {
                                if (s11.b() >= 0 && s11.b() <= G - i34) {
                                    i35 = s11.b();
                                }
                                if (s11.c() >= 0 && s11.c() <= F - i36) {
                                    i37 = s11.c();
                                }
                                p.a("新的width =" + i34 + ",height =" + i36 + ",xx =" + i35 + ",yy =" + i37);
                            }
                            kVar2.j(p.y().k(p.y().A(i34)));
                            kVar2.h(p.y().k(p.y().A(i36)));
                            kVar2.m(p.y().k(p.y().A(i35)));
                            kVar2.n(p.y().k(p.y().A(i37)));
                            kVar2.g(p.y().k(p.y().A(0)));
                            kVar2.k(p.y().F());
                            i33++;
                            i32 = i20;
                        } else {
                            String replaceAll2 = replaceAll.replaceAll("scalepreview_", "");
                            if (replaceAll2.contains("_")) {
                                String[] split3 = replaceAll2.split("_");
                                if (split3.length >= 3) {
                                    i20 = i32;
                                    F(new o(Float.parseFloat(split3[0]), Float.parseFloat(split3[1]), Float.parseFloat(split3[2])));
                                }
                            }
                            i20 = i32;
                        }
                    } else {
                        i20 = i32;
                        i21 = i34;
                    }
                    i34 = i21;
                    i33++;
                    i32 = i20;
                }
                i12 = i30;
                int i38 = i32;
                int i39 = i34;
                int i40 = 0;
                int i41 = 0;
                int i42 = 0;
                int i43 = 0;
                while (i42 < G2.length) {
                    if ((G2[i42].getName().endsWith("png") || G2[i42].getName().endsWith("PNG") || G2[i42].getName().endsWith("bmp") || G2[i42].getName().endsWith("BMP") || G2[i42].getName().endsWith("jpg") || G2[i42].getName().endsWith("JPG")) && !G2[i42].getName().equals("preview_bg.png") && !G2[i42].getName().equals("preview_bg.PNG")) {
                        i41++;
                        if (lVar2.c() == 17) {
                            bArr = p.y().e(l10, i35, i37);
                        } else if (lVar2.c() == 10) {
                            bArr = p.y().h(p.y().H(G2[i42].getAbsolutePath()));
                        } else {
                            Bitmap bitmap4 = l10;
                            bitmap3 = l10;
                            fileArr = G2;
                            i19 = 38;
                            i15 = i42;
                            jVar = jVar3;
                            lVar = lVar2;
                            i16 = i38;
                            kVar = kVar2;
                            bArr = p.y().f(bitmap4, p.y().H(G2[i42].getAbsolutePath()), i35, i37, z10, i10);
                            if (!z11) {
                                int c13 = lVar.c();
                                if ((c13 < 1 || c13 > 3) && (c13 < 35 || c13 > 37)) {
                                    if ((c13 < i19 || c13 > 42) && ((c13 < 43 || c13 > 46) && (c13 < 52 || c13 > 56))) {
                                        if (c13 < 57 || c13 > 70) {
                                            z12 = true;
                                            if (z12) {
                                                i17 = i39;
                                                bArr = p.y().E(p.y().d(bArr, i17, i36));
                                            } else {
                                                i17 = i39;
                                            }
                                            i43 += bArr.length;
                                        }
                                        z12 = false;
                                        if (z12) {
                                        }
                                        i43 += bArr.length;
                                    }
                                }
                                z12 = false;
                                if (z12) {
                                }
                                i43 += bArr.length;
                            } else {
                                i17 = i39;
                            }
                            byte[] bArr3 = new byte[bArr2.length + bArr.length];
                            i18 = 0;
                            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                            System.arraycopy(bArr, 0, bArr3, bArr2.length, bArr.length);
                            i12 += bArr.length;
                            bArr2 = bArr3;
                        }
                        bitmap3 = l10;
                        fileArr = G2;
                        i15 = i42;
                        lVar = lVar2;
                        kVar = kVar2;
                        jVar = jVar3;
                        i16 = i38;
                        i19 = 38;
                        if (!z11) {
                        }
                        byte[] bArr32 = new byte[bArr2.length + bArr.length];
                        i18 = 0;
                        System.arraycopy(bArr2, 0, bArr32, 0, bArr2.length);
                        System.arraycopy(bArr, 0, bArr32, bArr2.length, bArr.length);
                        i12 += bArr.length;
                        bArr2 = bArr32;
                    } else {
                        bitmap3 = l10;
                        fileArr = G2;
                        i15 = i42;
                        lVar = lVar2;
                        kVar = kVar2;
                        i17 = i39;
                        jVar = jVar3;
                        i16 = i38;
                        i18 = 0;
                    }
                    i42 = i15 + 1;
                    lVar2 = lVar;
                    i39 = i17;
                    i38 = i16;
                    G2 = fileArr;
                    jVar3 = jVar;
                    kVar2 = kVar;
                    i40 = i18;
                    l10 = bitmap3;
                }
                bitmap2 = l10;
                l lVar3 = lVar2;
                i14 = i40;
                k kVar3 = kVar2;
                int i44 = i39;
                j jVar4 = jVar3;
                i13 = i38;
                kVar3.f(p.y().z(i41));
                if (!z11) {
                    i43 = i44 * i36 * 2 * i41;
                }
                int i45 = i43;
                byte[] o10 = p.y().o(p.y().B(i45));
                p.a("picCount =" + i41 + ",dataLength =" + i45 + ",addr = " + p.y().m(o10));
                kVar3.i(o10);
                arrayList3.add(kVar3);
                byte[] bArr4 = new byte[24];
                byte[] bArr5 = kVar3.f5305a;
                System.arraycopy(bArr5, i14, bArr4, i14, bArr5.length);
                byte[] bArr6 = kVar3.f5306b;
                System.arraycopy(bArr6, i14, bArr4, 2, bArr6.length);
                byte[] bArr7 = kVar3.f5307c;
                System.arraycopy(bArr7, i14, bArr4, 4, bArr7.length);
                byte[] bArr8 = kVar3.f5308d;
                System.arraycopy(bArr8, i14, bArr4, 8, bArr8.length);
                byte[] bArr9 = kVar3.f5309e;
                System.arraycopy(bArr9, i14, bArr4, 10, bArr9.length);
                byte[] bArr10 = kVar3.f5310f;
                System.arraycopy(bArr10, i14, bArr4, 12, bArr10.length);
                byte[] bArr11 = kVar3.f5311g;
                System.arraycopy(bArr11, i14, bArr4, 14, bArr11.length);
                byte[] bArr12 = kVar3.f5312h;
                System.arraycopy(bArr12, i14, bArr4, 16, bArr12.length);
                byte[] bArr13 = kVar3.f5313i;
                System.arraycopy(bArr13, i14, bArr4, 17, bArr13.length);
                lVar3.d(bArr4);
                arrayList.add(lVar3);
                jVar4.d(bArr2);
                arrayList2.add(jVar4);
            } else {
                p.a("不显示类型 =" + lVar2.c());
                bitmap2 = l10;
                i12 = i30;
                i13 = i32;
                arrayList = arrayList4;
                arrayList2 = arrayList5;
                arrayList3 = arrayList6;
                i14 = 0;
            }
            i32 = i13 + 1;
            i29 = i14;
            arrayList6 = arrayList3;
            arrayList5 = arrayList2;
            arrayList4 = arrayList;
            i30 = i12;
            l10 = bitmap2;
            i31 = i11;
        }
        int i46 = i30;
        int i47 = i29;
        q qVar2 = qVar;
        ArrayList arrayList7 = arrayList4;
        ArrayList arrayList8 = arrayList5;
        ArrayList arrayList9 = arrayList6;
        s sVar = new s();
        sVar.i(p.y().c());
        sVar.b(p.y().o(p.y().B((n10.length * 24) + i46)));
        sVar.f(p.y().k(p.y().A(G)));
        sVar.e(p.y().k(p.y().A(F)));
        sVar.h(p.y().z(this.f5324h));
        sVar.c(p.y().z(i31));
        sVar.d(p.y().z(255));
        sVar.g(p.y().O());
        sVar.a(p.y().o(p.y().B(805233808)));
        qVar2.j(sVar);
        byte[] bArr14 = new byte[24];
        byte[] bArr15 = sVar.f5348a;
        System.arraycopy(bArr15, i47, bArr14, i47, bArr15.length);
        byte[] bArr16 = sVar.f5349b;
        System.arraycopy(bArr16, i47, bArr14, 4, bArr16.length);
        byte[] bArr17 = sVar.f5350c;
        System.arraycopy(bArr17, i47, bArr14, 8, bArr17.length);
        byte[] bArr18 = sVar.f5351d;
        System.arraycopy(bArr18, i47, bArr14, 12, bArr18.length);
        byte[] bArr19 = sVar.f5352e;
        System.arraycopy(bArr19, i47, bArr14, 14, bArr19.length);
        byte[] bArr20 = sVar.f5353f;
        System.arraycopy(bArr20, i47, bArr14, 16, bArr20.length);
        byte[] bArr21 = sVar.f5354g;
        System.arraycopy(bArr21, i47, bArr14, 17, bArr21.length);
        byte[] bArr22 = sVar.f5355h;
        System.arraycopy(bArr22, i47, bArr14, 18, bArr22.length);
        byte[] bArr23 = sVar.f5356i;
        System.arraycopy(bArr23, i47, bArr14, 19, bArr23.length);
        qVar2.j(sVar);
        qVar2.i(bArr14);
        Collections.sort(arrayList9);
        Collections.sort(arrayList7);
        Collections.sort(arrayList8);
        qVar2.h(arrayList9);
        qVar2.g(arrayList7);
        qVar2.f(arrayList8);
        byte[] M = p.y().M(a(qVar2));
        sVar.b(p.y().o(p.y().B(M.length - 24)));
        byte[] bArr24 = sVar.f5349b;
        System.arraycopy(bArr24, i47, M, 4, bArr24.length);
        byte[] o11 = p.y().o(p.y().B(p.y().N(M)));
        sVar.a(o11);
        System.arraycopy(o11, i47, M, 8, o11.length);
        if (z11) {
            M[19] = (byte) z.v(context).r();
        }
        return M;
    }

    private int f() {
        return this.f5326j;
    }

    private Bitmap i(Context context) {
        Throwable th2;
        String str = "DialCustom/" + this.f5320d;
        AssetManager assets = context.getResources().getAssets();
        String[] list = assets.list(str);
        InputStream inputStream = null;
        Bitmap bitmap = null;
        for (int i10 = 0; i10 < list.length; i10++) {
            String str2 = list[i10];
            str2.hashCode();
            if (str2.equals("background")) {
                String str3 = str + "/" + list[i10];
                String[] list2 = assets.list(str3);
                for (int i11 = 0; i11 < list2.length; i11++) {
                    if ((list2[i11].endsWith("png") || list2[i11].endsWith("PNG") || list2[i11].endsWith("bmp") || list2[i11].endsWith("BMP") || list2[i11].endsWith("jpg") || list2[i11].endsWith("JPG")) && (list2[i11].equals("1.png") || list2[i11].equals("1.PNG") || list2[i11].equals("01.png") || list2[i11].equals("01.PNG"))) {
                        try {
                            InputStream open = assets.open(str3 + "/" + list2[i11]);
                            try {
                                Bitmap decodeStream = BitmapFactory.decodeStream(open);
                                decodeStream.copyPixelsToBuffer(ByteBuffer.allocate(decodeStream.getByteCount()));
                                if (open != null) {
                                    open.close();
                                }
                                bitmap = decodeStream;
                            } catch (Throwable th3) {
                                th2 = th3;
                                inputStream = open;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                        }
                    }
                }
                continue;
            }
        }
        return bitmap;
    }

    private Bitmap j() {
        return this.f5325i;
    }

    private Bitmap k(String str) {
        File[] n10 = n(str);
        Bitmap bitmap = null;
        for (int i10 = 0; i10 < n10.length; i10++) {
            String name = n10[i10].getName();
            name.hashCode();
            if (name.equals("background")) {
                File[] listFiles = n10[i10].listFiles();
                for (int i11 = 0; i11 < listFiles.length; i11++) {
                    if ((listFiles[i11].getName().endsWith("png") || listFiles[i11].getName().endsWith("PNG") || listFiles[i11].getName().endsWith("bmp") || listFiles[i11].getName().endsWith("BMP") || listFiles[i11].getName().endsWith("jpg") || listFiles[i11].getName().endsWith("JPG")) && (listFiles[i11].getName().equals("1.png") || listFiles[i11].getName().equals("1.PNG") || listFiles[i11].getName().equals("01.png") || listFiles[i11].getName().equals("01.PNG"))) {
                        bitmap = p.y().H(listFiles[i11].getAbsolutePath());
                    }
                }
            }
        }
        return bitmap;
    }

    private File[] n(String str) {
        File[] listFiles = new File(str).listFiles();
        for (int i10 = 0; i10 < listFiles.length; i10++) {
            int i11 = 0;
            while (true) {
                if (i11 >= listFiles.length) {
                    break;
                } else if (listFiles[i11].getName().startsWith("dial_")) {
                    listFiles = listFiles[i11].listFiles();
                    break;
                } else {
                    i11++;
                }
            }
        }
        return listFiles;
    }

    public static m o() {
        if (f5316o == null) {
            f5316o = new m();
        }
        return f5316o;
    }

    private bn.b s(int i10) {
        List<bn.b> list = this.f5330n;
        if (!(list == null || list.size() == 0)) {
            for (bn.b bVar : this.f5330n) {
                if (i10 == bVar.a()) {
                    return bVar;
                }
            }
        }
        return null;
    }

    private boolean t() {
        return this.f5327k;
    }

    private ArrayList<bn.a> v(byte[] bArr) {
        int i10;
        int i11;
        int i12;
        bn.a aVar;
        ArrayList<bn.a> arrayList = new ArrayList<>();
        int i13 = 0;
        while (true) {
            i10 = 24;
            i11 = 8;
            if (i13 >= bArr.length / 24) {
                i13 = 0;
                break;
            }
            int i14 = i13 * 24;
            if (((bArr[i14 + 1] & 255) | ((bArr[i14] << 8) & 65280)) == 0 && i13 > 1) {
                break;
            }
            i13++;
        }
        int i15 = 0;
        while (i15 < i13) {
            byte[] bArr2 = new byte[i10];
            int i16 = i15 * 24;
            if (i15 == 0) {
                System.arraycopy(bArr, i16, bArr2, 0, i10);
                s sVar = new s();
                byte[] bArr3 = sVar.f5348a;
                System.arraycopy(bArr2, 0, bArr3, 0, bArr3.length);
                byte[] bArr4 = sVar.f5349b;
                System.arraycopy(bArr2, 4, bArr4, 0, bArr4.length);
                byte[] bArr5 = sVar.f5350c;
                System.arraycopy(bArr2, i11, bArr5, 0, bArr5.length);
                byte[] bArr6 = sVar.f5351d;
                System.arraycopy(bArr2, 12, bArr6, 0, bArr6.length);
                byte[] bArr7 = sVar.f5352e;
                System.arraycopy(bArr2, 14, bArr7, 0, bArr7.length);
                byte[] bArr8 = sVar.f5353f;
                System.arraycopy(bArr2, 16, bArr8, 0, bArr8.length);
                byte[] bArr9 = sVar.f5354g;
                System.arraycopy(bArr2, 17, bArr9, 0, bArr9.length);
                byte[] bArr10 = sVar.f5355h;
                System.arraycopy(bArr2, 18, bArr10, 0, bArr10.length);
                byte[] bArr11 = sVar.f5356i;
                System.arraycopy(bArr2, 19, bArr11, 0, bArr11.length);
                p.y().j(sVar.f5353f);
                p.y().l(sVar.f5351d);
                p.y().l(sVar.f5352e);
                i12 = i11;
            } else {
                System.arraycopy(bArr, i16, bArr2, 0, i10);
                k kVar = new k();
                byte[] bArr12 = kVar.f5305a;
                System.arraycopy(bArr2, 0, bArr12, 0, bArr12.length);
                byte[] bArr13 = kVar.f5306b;
                System.arraycopy(bArr2, 2, bArr13, 0, bArr13.length);
                byte[] bArr14 = kVar.f5307c;
                System.arraycopy(bArr2, 4, bArr14, 0, bArr14.length);
                byte[] bArr15 = kVar.f5308d;
                System.arraycopy(bArr2, i11, bArr15, 0, bArr15.length);
                byte[] bArr16 = kVar.f5309e;
                System.arraycopy(bArr2, 10, bArr16, 0, bArr16.length);
                byte[] bArr17 = kVar.f5310f;
                System.arraycopy(bArr2, 12, bArr17, 0, bArr17.length);
                byte[] bArr18 = kVar.f5311g;
                System.arraycopy(bArr2, 14, bArr18, 0, bArr18.length);
                byte[] bArr19 = kVar.f5312h;
                System.arraycopy(bArr2, 16, bArr19, 0, bArr19.length);
                byte[] bArr20 = kVar.f5313i;
                System.arraycopy(bArr2, 17, bArr20, 0, bArr20.length);
                int l10 = p.y().l(kVar.f5305a);
                int l11 = p.y().l(kVar.f5306b);
                int l12 = p.y().l(kVar.f5308d);
                int l13 = p.y().l(kVar.f5309e);
                int l14 = p.y().l(kVar.f5310f);
                int p10 = p.y().p(kVar.f5307c);
                int i17 = l11 * l12 * 2;
                byte[] bArr21 = new byte[i17];
                if (l10 == 4) {
                    i12 = 8;
                    System.arraycopy(bArr, (i17 * 3) + p10, bArr21, 0, i17);
                    arrayList.add(new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14));
                    System.arraycopy(bArr, p10 + (i17 * 11), bArr21, 0, i17);
                    aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13 + l11, l14);
                } else if (l10 != 5) {
                    i12 = 8;
                    if (l10 == 8) {
                        System.arraycopy(bArr, p10 + (i17 * 4), bArr21, 0, i17);
                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                    } else if (l10 == 11) {
                        System.arraycopy(bArr, (i17 * 3) + p10, bArr21, 0, i17);
                        arrayList.add(new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14));
                        System.arraycopy(bArr, p10 + (i17 * 5), bArr21, 0, i17);
                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13 + l11, l14);
                    } else if (l10 == 13) {
                        System.arraycopy(bArr, (i17 * 5) + p10, bArr21, 0, i17);
                        arrayList.add(new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14));
                        System.arraycopy(bArr, p10 + (i17 * 10), bArr21, 0, i17);
                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13 + l11, l14);
                    } else if (l10 == 25) {
                        System.arraycopy(bArr, (i17 * 5) + p10, bArr21, 0, i17);
                        arrayList.add(new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14));
                        System.arraycopy(bArr, (i17 * 6) + p10, bArr21, 0, i17);
                        arrayList.add(new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13 + l11, l14));
                        int i18 = p10 + (i17 * 3);
                        System.arraycopy(bArr, i18, bArr21, 0, i17);
                        arrayList.add(new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13 + (l11 * 2), l14));
                        System.arraycopy(bArr, i18, bArr21, 0, i17);
                        arrayList.add(new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13 + (l11 * 3), l14));
                        System.arraycopy(bArr, i18, bArr21, 0, i17);
                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13 + (l11 * 4), l14);
                    } else if (l10 != 32) {
                        switch (l10) {
                            case 15:
                                System.arraycopy(bArr, p10 + (i17 * 10), bArr21, 0, i17);
                                aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                break;
                            case 16:
                                System.arraycopy(bArr, p10 + (i17 * 2), bArr21, 0, i17);
                                aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                break;
                            case 17:
                                System.arraycopy(bArr, p10, bArr21, 0, i17);
                                aVar = new bn.a(l10, p.y().w(bArr21, l11, l12), l11, l12, l13, l14);
                                break;
                            case 18:
                                System.arraycopy(bArr, p10, bArr21, 0, i17);
                                aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                break;
                            default:
                                switch (l10) {
                                    case 35:
                                        System.arraycopy(bArr, p10 + (i17 * 4), bArr21, 0, i17);
                                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                        break;
                                    case 36:
                                        System.arraycopy(bArr, p10 + (i17 * 3), bArr21, 0, i17);
                                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                        break;
                                    case 37:
                                        System.arraycopy(bArr, p10 + (i17 * 5), bArr21, 0, i17);
                                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                        break;
                                    case 38:
                                        System.arraycopy(bArr, p10 + (i17 * 5), bArr21, 0, i17);
                                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                        break;
                                    case 39:
                                        System.arraycopy(bArr, p10 + (i17 * 6), bArr21, 0, i17);
                                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                        break;
                                    case 40:
                                        System.arraycopy(bArr, p10 + (i17 * 3), bArr21, 0, i17);
                                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                        break;
                                    case 41:
                                        System.arraycopy(bArr, p10 + (i17 * 3), bArr21, 0, i17);
                                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                        break;
                                    case 42:
                                        System.arraycopy(bArr, p10 + (i17 * 3), bArr21, 0, i17);
                                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                        break;
                                    default:
                                        switch (l10) {
                                            case 57:
                                                System.arraycopy(bArr, p10 + (i17 * 3), bArr21, 0, i17);
                                                aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                                break;
                                            case 58:
                                                System.arraycopy(bArr, p10 + (i17 * 11), bArr21, 0, i17);
                                                aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                                break;
                                            case 59:
                                                System.arraycopy(bArr, p10 + (i17 * 6), bArr21, 0, i17);
                                                aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                                break;
                                            case 60:
                                                System.arraycopy(bArr, p10 + (i17 * 5), bArr21, 0, i17);
                                                aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                                break;
                                            default:
                                                switch (l10) {
                                                    case 63:
                                                        System.arraycopy(bArr, p10 + (i17 * 3), bArr21, 0, i17);
                                                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                                        break;
                                                    case 64:
                                                        System.arraycopy(bArr, p10 + (i17 * 5), bArr21, 0, i17);
                                                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                                        break;
                                                    case 65:
                                                        System.arraycopy(bArr, p10 + (i17 * 5), bArr21, 0, i17);
                                                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                                        break;
                                                    case 66:
                                                        System.arraycopy(bArr, p10 + (i17 * 10), bArr21, 0, i17);
                                                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                                        break;
                                                    default:
                                                        System.arraycopy(bArr, p10, bArr21, 0, i17);
                                                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                                                        break;
                                                }
                                        }
                                }
                        }
                    } else {
                        System.arraycopy(bArr, p10 + (i17 * 8), bArr21, 0, i17);
                        aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14);
                    }
                } else {
                    i12 = 8;
                    System.arraycopy(bArr, (i17 * 6) + p10, bArr21, 0, i17);
                    arrayList.add(new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13, l14));
                    System.arraycopy(bArr, p10 + (i17 * 5), bArr21, 0, i17);
                    aVar = new bn.a(l10, p.y().v(bArr21, l11, l12), l11, l12, l13 + l11, l14);
                }
                arrayList.add(aVar);
            }
            i15++;
            i11 = i12;
            i10 = 24;
        }
        return arrayList;
    }

    private void z(int i10) {
        this.f5326j = i10;
    }

    public void B(String str) {
        this.f5323g = str;
    }

    public void C(String str) {
        this.f5321e = str;
    }

    public void E(int i10) {
        this.f5322f = i10;
        p.a("dialType =" + this.f5323g + ",pathStatus =" + i10 + ",folderDial =" + this.f5321e);
    }

    public boolean I(Context context) {
        byte[] bArr = this.f5329m;
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        q.B(context).a0(this.f5329m);
        p.a("最终发送的2 =" + this.f5329m.length);
        this.f5329m = new byte[0];
        return true;
    }

    public Bitmap b(Context context, Bitmap bitmap, boolean z10, int i10) {
        A(bitmap);
        D(z10);
        z(i10);
        byte[] bArr = new byte[0];
        if (this.f5322f == 0) {
            try {
                bArr = d(context, bitmap, z10, i10, false);
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        } else {
            bArr = e(context, bitmap, z10, i10, false);
        }
        return p.y().C(v(bArr));
    }

    public boolean c(Context context, Bitmap bitmap) {
        byte[] bArr = new byte[0];
        boolean z10 = z.v(context).r() >= 2;
        if (this.f5322f == 0) {
            try {
                bArr = d(context, j(), t(), f(), z10);
            } catch (IOException e10) {
                e10.printStackTrace();
            }
        } else {
            bArr = e(context, j(), t(), f(), z10);
        }
        if (bitmap == null) {
            bitmap = m(context);
        }
        if (bArr == null || bArr.length <= 0 || bitmap == null) {
            return false;
        }
        byte[] s10 = p.y().s(context, bArr, p.y().r(context, bitmap, this.f5322f, this.f5321e), z10);
        this.f5329m = s10;
        p.a("最终发送的1 =" + s10.length);
        return true;
    }

    public Bitmap g(Context context) {
        Throwable th2;
        String str = "DialCustom/" + this.f5320d;
        AssetManager assets = context.getResources().getAssets();
        String[] list = assets.list(str);
        InputStream inputStream = null;
        F(null);
        Bitmap bitmap = null;
        for (int i10 = 0; i10 < list.length; i10++) {
            String str2 = list[i10];
            str2.hashCode();
            if (str2.equals("preview")) {
                String str3 = str + "/" + list[i10];
                String[] list2 = assets.list(str3);
                for (int i11 = 0; i11 < list2.length; i11++) {
                    if (list2[i11].endsWith("png") || list2[i11].endsWith("PNG") || list2[i11].endsWith("bmp") || list2[i11].endsWith("BMP") || list2[i11].endsWith("jpg") || list2[i11].endsWith("JPG")) {
                        if (list2[i11].equals("1.png") || list2[i11].equals("1.PNG") || list2[i11].equals("01.png") || list2[i11].equals("01.PNG")) {
                            try {
                                InputStream open = assets.open(str3 + "/" + list2[i11]);
                                try {
                                    Bitmap decodeStream = BitmapFactory.decodeStream(open);
                                    decodeStream.copyPixelsToBuffer(ByteBuffer.allocate(decodeStream.getByteCount()));
                                    if (open != null) {
                                        open.close();
                                    }
                                    bitmap = decodeStream;
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    inputStream = open;
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    throw th2;
                                }
                            } catch (Throwable th4) {
                                th2 = th4;
                            }
                        }
                    } else if (list2[i11].endsWith("txt") || list2[i11].endsWith("TXT")) {
                        String replaceAll = list2[i11].replaceAll("config_", "").replaceAll(".txt", "");
                        p.a("all2 =" + replaceAll + "," + list[i10]);
                        if (replaceAll.contains("scalepreview_")) {
                            String replaceAll2 = replaceAll.replaceAll("scalepreview_", "");
                            if (replaceAll2.contains("_")) {
                                String[] split = replaceAll2.split("_");
                                if (split.length >= 3) {
                                    F(new o(Float.parseFloat(split[0]), Float.parseFloat(split[1]), Float.parseFloat(split[2])));
                                }
                            }
                        }
                    }
                }
                continue;
            }
        }
        o r10 = r();
        if (r10 == null) {
            return bitmap;
        }
        if (r10.b() > 0.0f) {
            bitmap = p.y().L(bitmap, r10.b(), r10.b());
        }
        return p.y().P(bitmap, r10.c() / bitmap.getWidth(), r10.a() / bitmap.getHeight());
    }

    public Bitmap h(String str) {
        File[] n10 = n(str);
        Bitmap bitmap = null;
        F(null);
        for (int i10 = 0; i10 < n10.length; i10++) {
            String name = n10[i10].getName();
            name.hashCode();
            if (name.equals("preview")) {
                File[] listFiles = n10[i10].listFiles();
                for (int i11 = 0; i11 < listFiles.length; i11++) {
                    if (listFiles[i11].getName().endsWith("png") || listFiles[i11].getName().endsWith("PNG") || listFiles[i11].getName().endsWith("bmp") || listFiles[i11].getName().endsWith("BMP") || listFiles[i11].getName().endsWith("jpg") || listFiles[i11].getName().endsWith("JPG")) {
                        if (listFiles[i11].getName().equals("1.png") || listFiles[i11].getName().equals("1.PNG") || listFiles[i11].getName().equals("01.png") || listFiles[i11].getName().equals("01.PNG")) {
                            bitmap = p.y().H(listFiles[i11].getAbsolutePath());
                        }
                    } else if (listFiles[i11].getName().endsWith("txt") || listFiles[i11].getName().endsWith("TXT")) {
                        String replaceAll = listFiles[i11].getName().replaceAll("config_", "").replaceAll(".txt", "");
                        p.a("all2 =" + replaceAll + "," + n10[i10]);
                        if (replaceAll.contains("scalepreview_")) {
                            String replaceAll2 = replaceAll.replaceAll("scalepreview_", "");
                            if (replaceAll2.contains("_")) {
                                String[] split = replaceAll2.split("_");
                                if (split.length >= 3) {
                                    F(new o(Float.parseFloat(split[0]), Float.parseFloat(split[1]), Float.parseFloat(split[2])));
                                }
                            }
                        }
                    }
                }
            }
        }
        o r10 = r();
        if (r10 == null) {
            return bitmap;
        }
        if (r10.b() > 0.0f) {
            bitmap = p.y().L(bitmap, r10.b(), r10.b());
        }
        return p.y().P(bitmap, r10.c() / bitmap.getWidth(), r10.a() / bitmap.getHeight());
    }

    public Bitmap l(Context context) {
        if (this.f5322f == 1) {
            return this.f5323g.equals("2") ? p.y().K(k(this.f5321e)) : k(this.f5321e);
        }
        try {
            return this.f5323g.equals("2") ? p.y().K(i(context)) : i(context);
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public Bitmap m(Context context) {
        if (this.f5322f == 1) {
            return h(this.f5321e);
        }
        try {
            return g(context);
        } catch (IOException e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public Bitmap p(Context context) {
        Throwable th2;
        String str = "DialCustom/" + this.f5320d;
        AssetManager assets = context.getResources().getAssets();
        String[] list = assets.list(str);
        InputStream inputStream = null;
        Bitmap bitmap = null;
        for (int i10 = 0; i10 < list.length; i10++) {
            String str2 = list[i10];
            str2.hashCode();
            if (str2.equals("preview")) {
                String str3 = str + "/" + list[i10];
                String[] list2 = assets.list(str3);
                for (int i11 = 0; i11 < list2.length; i11++) {
                    if ((list2[i11].endsWith("png") || list2[i11].endsWith("PNG") || list2[i11].endsWith("bmp") || list2[i11].endsWith("BMP") || list2[i11].endsWith("jpg") || list2[i11].endsWith("JPG")) && (list2[i11].equals("preview_bg.png") || list2[i11].equals("preview_bg.PNG"))) {
                        try {
                            InputStream open = assets.open(str3 + "/" + list2[i11]);
                            try {
                                Bitmap decodeStream = BitmapFactory.decodeStream(open);
                                decodeStream.copyPixelsToBuffer(ByteBuffer.allocate(decodeStream.getByteCount()));
                                if (open != null) {
                                    open.close();
                                }
                                bitmap = decodeStream;
                            } catch (Throwable th3) {
                                th2 = th3;
                                inputStream = open;
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                throw th2;
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                        }
                    }
                }
                continue;
            }
        }
        return bitmap;
    }

    public Bitmap q(String str) {
        File[] n10 = n(str);
        Bitmap bitmap = null;
        for (int i10 = 0; i10 < n10.length; i10++) {
            String name = n10[i10].getName();
            name.hashCode();
            if (name.equals("preview")) {
                File[] listFiles = n10[i10].listFiles();
                for (int i11 = 0; i11 < listFiles.length; i11++) {
                    if ((listFiles[i11].getName().endsWith("png") || listFiles[i11].getName().endsWith("PNG") || listFiles[i11].getName().endsWith("bmp") || listFiles[i11].getName().endsWith("BMP") || listFiles[i11].getName().endsWith("jpg") || listFiles[i11].getName().endsWith("JPG")) && (listFiles[i11].getName().equals("preview_bg.png") || listFiles[i11].getName().equals("preview_bg.PNG"))) {
                        bitmap = p.y().H(listFiles[i11].getAbsolutePath());
                    }
                }
            }
        }
        return bitmap;
    }

    public o r() {
        return this.f5328l;
    }

    public boolean u(String str) {
        return Pattern.compile("[0-9]*").matcher(str).matches();
    }

    public void w() {
        this.f5330n = new ArrayList();
    }

    public void x() {
        this.f5325i = null;
        this.f5326j = 16777215;
        this.f5327k = false;
    }

    public void y(String str, String str2) {
        this.f5320d = (!str.equals("1") || !str2.equals("240*240")) ? ((!str.equals("2") || !str2.equals("240*240")) && str.equals("1") && str2.equals("320*360")) ? this.f5319c : this.f5317a : this.f5318b;
    }
}
