package bn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import gn.n;
import gn.u;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public class p {

    /* renamed from: e  reason: collision with root package name */
    private static p f5338e;

    /* renamed from: a  reason: collision with root package name */
    private int f5339a = 16711680;

    /* renamed from: b  reason: collision with root package name */
    private int f5340b = 65280;

    /* renamed from: c  reason: collision with root package name */
    private int f5341c = 255;

    /* renamed from: d  reason: collision with root package name */
    private int[] f5342d = {0, 1996959894, -301047508, -1727442502, 124634137, 1886057615, -379345611, -1637575261, 249268274, 2044508324, -522852066, -1747789432, 162941995, 2125561021, -407360249, -1866523247, 498536548, 1789927666, -205950648, -2067906082, 450548861, 1843258603, -187386543, -2083289657, 325883990, 1684777152, -43845254, -1973040660, 335633487, 1661365465, -99664541, -1928851979, 997073096, 1281953886, -715111964, -1570279054, 1006888145, 1258607687, -770865667, -1526024853, 901097722, 1119000684, -608450090, -1396901568, 853044451, 1172266101, -589951537, -1412350631, 651767980, 1373503546, -925412992, -1076862698, 565507253, 1454621731, -809855591, -1195530993, 671266974, 1594198024, -972236366, -1324619484, 795835527, 1483230225, -1050600021, -1234817731, 1994146192, 31158534, -1731059524, -271249366, 1907459465, 112637215, -1614814043, -390540237, 2013776290, 251722036, -1777751922, -519137256, 2137656763, 141376813, -1855689577, -429695999, 1802195444, 476864866, -2056965928, -228458418, 1812370925, 453092731, -2113342271, -183516073, 1706088902, 314042704, -1950435094, -54949764, 1658658271, 366619977, -1932296973, -69972891, 1303535960, 984961486, -1547960204, -725929758, 1256170817, 1037604311, -1529756563, -740887301, 1131014506, 879679996, -1385723834, -631195440, 1141124467, 855842277, -1442165665, -586318647, 1342533948, 654459306, -1106571248, -921952122, 1466479909, 544179635, -1184443383, -832445281, 1591671054, 702138776, -1328506846, -942167884, 1504918807, 783551873, -1212326853, -1061524307, -306674912, -1698712650, 62317068, 1957810842, -355121351, -1647151185, 81470997, 1943803523, -480048366, -1805370492, 225274430, 2053790376, -468791541, -1828061283, 167816743, 2097651377, -267414716, -2029476910, 503444072, 1762050814, -144550051, -2140837941, 426522225, 1852507879, -19653770, -1982649376, 282753626, 1742555852, -105259153, -1900089351, 397917763, 1622183637, -690576408, -1580100738, 953729732, 1340076626, -776247311, -1497606297, 1068828381, 1219638859, -670225446, -1358292148, 906185462, 1090812512, -547295293, -1469587627, 829329135, 1181335161, -882789492, -1134132454, 628085408, 1382605366, -871598187, -1156888829, 570562233, 1426400815, -977650754, -1296233688, 733239954, 1555261956, -1026031705, -1244606671, 752459403, 1541320221, -1687895376, -328994266, 1969922972, 40735498, -1677130071, -351390145, 1913087877, 83908371, -1782625662, -491226604, 2075208622, 213261112, -1831694693, -438977011, 2094854071, 198958881, -2032938284, -237706686, 1759359992, 534414190, -2118248755, -155638181, 1873836001, 414664567, -2012718362, -15766928, 1711684554, 285281116, -1889165569, -127750551, 1634467795, 376229701, -1609899400, -686959890, 1308918612, 956543938, -1486412191, -799009033, 1231636301, 1047427035, -1362007478, -640263460, 1088359270, 936918000, -1447252397, -558129467, 1202900863, 817233897, -1111625188, -893730166, 1404277552, 615818150, -1160759803, -841546093, 1423857449, 601450431, -1285129682, -1000256840, 1567103746, 711928724, -1274298825, -1022587231, 1510334235, 755167117};

    private Bitmap D(Bitmap bitmap, Bitmap bitmap2, float f10, float f11) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, new Matrix(), null);
        canvas.drawBitmap(bitmap2, f10, f11, (Paint) null);
        return createBitmap;
    }

    private List<j> J(List<j> list) {
        for (int i10 = 0; i10 < list.size() - 1; i10++) {
            for (int size = list.size() - 1; size > i10; size--) {
                if (Arrays.equals(list.get(size).b(), list.get(i10).b())) {
                    list.remove(size);
                }
            }
        }
        return list;
    }

    public static void a(String str) {
        u.a("RGB", str);
    }

    private int b(int i10) {
        return (((this.f5339a & i10) >> 19) << 11) + (((this.f5340b & i10) >> 10) << 5) + (((i10 & this.f5341c) >> 3) << 0);
    }

    private q i(byte[] bArr, boolean z10) {
        int i10;
        int i11;
        q qVar;
        int i12;
        ArrayList arrayList;
        char c10;
        boolean z11;
        int i13;
        boolean z12;
        int i14;
        int i15;
        q qVar2 = new q();
        a(" 解析bin得出readBinStringData.length =" + bArr.length);
        int i16 = 0;
        int i17 = 0;
        while (true) {
            i10 = 24;
            i11 = 8;
            if (i17 >= bArr.length / 24) {
                i17 = 0;
                break;
            }
            int i18 = i17 * 24;
            if (((bArr[i18 + 1] & 255) | ((bArr[i18] << 8) & 65280)) == 0 && i17 > 1) {
                a("跳出循环 count =" + i17);
                break;
            }
            i17++;
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        int i19 = 0;
        int i20 = 0;
        while (i19 < i17) {
            byte[] bArr2 = new byte[i10];
            System.arraycopy(bArr, (i19 * 24) + i16, bArr2, i16, i10);
            if (i19 == 0) {
                qVar2.i(bArr2);
                s sVar = new s();
                byte[] bArr3 = sVar.f5348a;
                System.arraycopy(bArr2, i16, bArr3, i16, bArr3.length);
                byte[] bArr4 = sVar.f5349b;
                System.arraycopy(bArr2, 4, bArr4, i16, bArr4.length);
                byte[] bArr5 = sVar.f5350c;
                System.arraycopy(bArr2, i11, bArr5, i16, bArr5.length);
                byte[] bArr6 = sVar.f5351d;
                System.arraycopy(bArr2, 12, bArr6, i16, bArr6.length);
                byte[] bArr7 = sVar.f5352e;
                System.arraycopy(bArr2, 14, bArr7, i16, bArr7.length);
                byte[] bArr8 = sVar.f5353f;
                System.arraycopy(bArr2, 16, bArr8, i16, bArr8.length);
                byte[] bArr9 = sVar.f5354g;
                System.arraycopy(bArr2, 17, bArr9, i16, bArr9.length);
                byte[] bArr10 = sVar.f5355h;
                System.arraycopy(bArr2, 18, bArr10, i16, bArr10.length);
                byte[] bArr11 = sVar.f5356i;
                System.arraycopy(bArr2, 19, bArr11, i16, bArr11.length);
                qVar2.j(sVar);
                qVar = qVar2;
                i12 = i17;
                arrayList = arrayList2;
                z11 = true;
                c10 = 65280;
                i13 = i16;
            } else {
                k kVar = new k();
                byte[] bArr12 = kVar.f5305a;
                System.arraycopy(bArr2, i16, bArr12, i16, bArr12.length);
                byte[] bArr13 = kVar.f5306b;
                System.arraycopy(bArr2, 2, bArr13, i16, bArr13.length);
                byte[] bArr14 = kVar.f5307c;
                System.arraycopy(bArr2, 4, bArr14, i16, bArr14.length);
                byte[] bArr15 = kVar.f5308d;
                System.arraycopy(bArr2, 8, bArr15, i16, bArr15.length);
                byte[] bArr16 = kVar.f5309e;
                System.arraycopy(bArr2, 10, bArr16, i16, bArr16.length);
                byte[] bArr17 = kVar.f5310f;
                System.arraycopy(bArr2, 12, bArr17, i16, bArr17.length);
                byte[] bArr18 = kVar.f5311g;
                System.arraycopy(bArr2, 14, bArr18, i16, bArr18.length);
                byte[] bArr19 = kVar.f5312h;
                System.arraycopy(bArr2, 16, bArr19, i16, bArr19.length);
                byte[] bArr20 = kVar.f5313i;
                System.arraycopy(bArr2, 17, bArr20, i16, bArr20.length);
                arrayList4.add(kVar);
                arrayList2.add(new l(l(kVar.e()), bArr2));
                c10 = 65280;
                int i21 = (bArr2[2] & 255) | ((bArr2[3] << 8) & 65280);
                int i22 = (bArr2[8] & 255) | ((bArr2[9] << 8) & 65280);
                int i23 = bArr2[16] & 255;
                int i24 = ((bArr2[1] << 8) & 65280) | (bArr2[0] & 255);
                boolean z13 = z10 && (i24 < 1 || i24 > 3) && ((i24 < 35 || i24 > 37) && ((i24 < 38 || i24 > 42) && ((i24 < 43 || i24 > 46) && ((i24 < 52 || i24 > 56) && (i24 < 57 || i24 > 70)))));
                int p10 = p(kVar.f5307c);
                arrayList = arrayList2;
                if (i19 == 1) {
                    int i25 = (i17 * 24) + 2;
                    if (z13) {
                        int i26 = 0;
                        i15 = 0;
                        while (i26 < i23) {
                            byte[] bArr21 = new byte[4];
                            System.arraycopy(bArr, i25 + i15, bArr21, 0, 4);
                            i15 = i26 == 0 ? p(bArr21) + 4 : i15 + p(bArr21) + 4;
                            i26++;
                        }
                    } else {
                        i15 = i21 * i22 * 2 * i23;
                    }
                    byte[] bArr22 = new byte[i15];
                    System.arraycopy(bArr, i25, bArr22, 0, i15);
                    i20 = i25 + i15;
                    arrayList3.add(new j(l(kVar.e()), bArr22));
                    qVar = qVar2;
                    i12 = i17;
                    i13 = 0;
                    z11 = true;
                } else {
                    int i27 = 0;
                    while (true) {
                        i12 = i17;
                        z11 = true;
                        if (i27 >= arrayList4.size() - 1) {
                            qVar = qVar2;
                            z12 = false;
                            break;
                        }
                        qVar = qVar2;
                        if (Arrays.equals(kVar.f5307c, arrayList4.get(i27).c())) {
                            arrayList3.add(arrayList3.get(i27));
                            a("判断地址是否相同，相同不处理 " + i20 + "," + p10 + ",compressPicType =" + i24 + ",k =" + i27);
                            z12 = true;
                            break;
                        }
                        i27++;
                        i17 = i12;
                        qVar2 = qVar;
                    }
                    a("isSameAddr = " + z12);
                    if (!z12) {
                        if (z13) {
                            int i28 = 0;
                            i14 = 0;
                            while (i28 < i23) {
                                byte[] bArr23 = new byte[4];
                                System.arraycopy(bArr, i20 + i14, bArr23, 0, 4);
                                i14 = i28 == 0 ? p(bArr23) + 4 : i14 + p(bArr23) + 4;
                                i28++;
                            }
                        } else {
                            i14 = i21 * i22 * 2 * i23;
                        }
                        byte[] bArr24 = new byte[i14];
                        i13 = 0;
                        System.arraycopy(bArr, i20, bArr24, 0, i14);
                        i20 += i14;
                        arrayList3.add(new j(l(kVar.e()), bArr24));
                    } else {
                        i13 = 0;
                    }
                }
            }
            i19++;
            i16 = i13;
            arrayList2 = arrayList;
            i17 = i12;
            qVar2 = qVar;
            i10 = 24;
            i11 = 8;
        }
        qVar2.h(arrayList4);
        qVar2.g(arrayList2);
        qVar2.f(arrayList3);
        return qVar2;
    }

    private int n(byte[] bArr) {
        return ((bArr[1] & 255) << 8) | (bArr[0] & 255);
    }

    private int q(byte[] bArr) {
        return ((bArr[3] & 255) << 24) | (bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16);
    }

    private byte[] t(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, 0, bArr3, bArr2.length, bArr.length);
        return bArr3;
    }

    private byte[] u(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static p y() {
        if (f5338e == null) {
            f5338e = new p();
        }
        return f5338e;
    }

    public byte[] A(int i10) {
        return new byte[]{(byte) ((i10 >> 8) & 255), (byte) (i10 & 255)};
    }

    public byte[] B(int i10) {
        return new byte[]{(byte) ((i10 >> 24) & 255), (byte) ((i10 >> 16) & 255), (byte) ((i10 >> 8) & 255), (byte) (i10 & 255)};
    }

    public Bitmap C(ArrayList<a> arrayList) {
        Canvas canvas;
        Bitmap bitmap;
        int i10 = 0;
        while (true) {
            if (i10 >= arrayList.size()) {
                bitmap = null;
                canvas = null;
                break;
            } else if (arrayList.get(i10).d() == 17) {
                int c10 = arrayList.get(i10).c();
                int b10 = arrayList.get(i10).b();
                arrayList.get(i10).e();
                arrayList.get(i10).f();
                Bitmap a10 = arrayList.get(i10).a();
                bitmap = Bitmap.createBitmap(c10, b10, arrayList.get(i10).a().getConfig());
                canvas = new Canvas(bitmap);
                canvas.drawBitmap(a10, new Matrix(), null);
                break;
            } else {
                i10++;
            }
        }
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            int d10 = arrayList.get(i11).d();
            if (!(d10 == 17 || d10 == 10)) {
                canvas.drawBitmap(arrayList.get(i11).a(), arrayList.get(i11).e(), arrayList.get(i11).f(), (Paint) null);
            }
        }
        o r10 = m.o().r();
        if (r10 == null || bitmap == null) {
            return bitmap;
        }
        a("previewDial PreviewScaleInfo " + r10.c() + "," + r10.a() + "," + r10.b());
        if (r10.b() > 0.0f) {
            bitmap = L(bitmap, r10.b(), r10.b());
        }
        return P(bitmap, r10.c() / bitmap.getWidth(), r10.a() / bitmap.getHeight());
    }

    public byte[] E(byte[] bArr) {
        byte[] bArr2;
        int i10 = 4;
        int i11 = 8;
        byte b10 = 255;
        int i12 = ((bArr[4] << 8) & 65280) | (bArr[5] & 255);
        int i13 = 2;
        int i14 = (65280 & (bArr[2] << 8)) | (bArr[3] & 255);
        int i15 = i12 * 4;
        int i16 = 0;
        byte[] bArr3 = new byte[0];
        byte[] bArr4 = new byte[0];
        int i17 = 0;
        while (i17 < i12) {
            int i18 = (i17 * i14 * i13) + i11;
            byte[] bArr5 = new byte[i16];
            int i19 = i16;
            int i20 = i19;
            int i21 = i20;
            int i22 = i21;
            int i23 = i22;
            while (i21 < i14) {
                int i24 = i18 + (i22 * 2);
                int i25 = i18 + (i21 * 2);
                if (bArr[i24] == bArr[i25] && bArr[i24 + 1] == bArr[i25 + 1] && i19 != b10) {
                    i19++;
                    i21++;
                    if (i21 != i14) {
                        i16 = 0;
                    }
                }
                if (i20 == 0) {
                    byte[] bArr6 = new byte[i10];
                    bArr6[0] = 1;
                    bArr6[1] = (byte) i19;
                    bArr6[2] = bArr[i24];
                    bArr6[3] = bArr[i24 + 1];
                    bArr2 = bArr6;
                } else if (i20 == i19) {
                    int length = bArr5.length + 2;
                    byte[] bArr7 = new byte[length];
                    System.arraycopy(bArr5, 0, bArr7, 0, bArr5.length);
                    bArr7[0] = (byte) ((bArr7[0] & b10) + 1);
                    bArr7[length - 2] = bArr[i24];
                    bArr7[length - 1] = bArr[i24 + 1];
                    bArr2 = bArr7;
                } else {
                    bArr4 = u(bArr4, bArr5);
                    i23 += bArr5.length;
                    bArr2 = new byte[]{1, (byte) i19, bArr[i24], bArr[i24 + 1]};
                }
                if (i21 == i14) {
                    bArr4 = u(bArr4, bArr2);
                    byte[] o10 = o(B(i15));
                    i23 += bArr2.length;
                    i15 += i23;
                    byte[] bArr8 = new byte[bArr3.length + o10.length];
                    i16 = 0;
                    System.arraycopy(bArr3, 0, bArr8, 0, bArr3.length);
                    System.arraycopy(o10, 0, bArr8, bArr3.length, o10.length);
                    bArr3 = bArr8;
                } else {
                    i16 = 0;
                }
                i20 = i19;
                bArr5 = bArr2;
                i19 = i16;
                i22 = i21;
                i10 = 4;
                b10 = 255;
            }
            i17++;
            i10 = 4;
            i11 = 8;
            i13 = 2;
            b10 = 255;
        }
        byte[] t10 = t(bArr4, bArr3);
        return t(t10, o(B(t10.length)));
    }

    public byte[] F() {
        return new byte[7];
    }

    public Bitmap G(Context context, String str) {
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().getAssets().open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            decodeStream.copyPixelsToBuffer(ByteBuffer.allocate(decodeStream.getByteCount()));
            return decodeStream;
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    public Bitmap H(String str) {
        return BitmapFactory.decodeFile(str);
    }

    public byte[] I(Context context, String str) {
        FileInputStream fileInputStream;
        Throwable th2;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byteArrayOutputStream.flush();
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        fileInputStream.close();
                        return byteArray;
                    }
                }
            } catch (Throwable th3) {
                th2 = th3;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw th2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            fileInputStream = null;
        }
    }

    public Bitmap K(Bitmap bitmap) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-16777216);
            canvas.drawRoundRect(new RectF(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight())), bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, paint);
            return createBitmap;
        } catch (Exception unused) {
            return bitmap;
        }
    }

    public Bitmap L(Bitmap bitmap, float f10, float f11) {
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            RectF rectF = new RectF(new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()));
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-16777216);
            canvas.drawRoundRect(rectF, f10, f11, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), rect, paint);
            return createBitmap;
        } catch (Exception unused) {
            return bitmap;
        }
    }

    public byte[] M(q qVar) {
        if (qVar == null) {
            return null;
        }
        int length = qVar.d().length;
        byte[] bArr = new byte[length];
        System.arraycopy(qVar.d(), 0, bArr, 0, length);
        int i10 = 0;
        while (i10 < qVar.b().size()) {
            byte[] b10 = qVar.b().get(i10).b();
            byte[] bArr2 = new byte[i10 == qVar.b().size() + (-1) ? bArr.length + b10.length + 2 : bArr.length + b10.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            System.arraycopy(b10, 0, bArr2, bArr.length, b10.length);
            i10++;
            bArr = bArr2;
        }
        List<j> J = J(qVar.a());
        int i11 = 0;
        while (i11 < J.size()) {
            byte[] b11 = J.get(i11).b();
            byte[] bArr3 = new byte[bArr.length + b11.length];
            System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
            System.arraycopy(b11, 0, bArr3, bArr.length, b11.length);
            i11++;
            bArr = bArr3;
        }
        return bArr;
    }

    public int N(byte[] bArr) {
        int i10 = -1;
        for (int i11 = 24; i11 < bArr.length; i11++) {
            i10 = (i10 >>> 8) ^ this.f5342d[(bArr[i11] ^ i10) & 255];
        }
        return ~i10;
    }

    public byte[] O() {
        byte[] bArr = new byte[5];
        for (int i10 = 0; i10 < 5; i10++) {
            bArr[i10] = -1;
        }
        return bArr;
    }

    public Bitmap P(Bitmap bitmap, float f10, float f11) {
        Matrix matrix = new Matrix();
        matrix.postScale(f10, f11);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public byte[] c() {
        byte[] bArr = new byte[4];
        for (int i10 = 0; i10 < 4; i10++) {
            bArr[i10] = -1;
        }
        return bArr;
    }

    public byte[] d(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = {48, 16, (byte) ((i10 >> 8) & 255), (byte) (i10 & 255), (byte) ((i11 >> 8) & 255), (byte) (i11 & 255), 1, 27};
        byte[] bArr3 = new byte[bArr.length + 8];
        System.arraycopy(bArr2, 0, bArr3, 0, 8);
        System.arraycopy(bArr, 0, bArr3, 8, bArr.length);
        return bArr3;
    }

    public byte[] e(Bitmap bitmap, int i10, int i11) {
        int i12;
        byte[] bArr = new byte[bitmap.getWidth() * bitmap.getHeight() * 2];
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        RectF rectF = new RectF(0.0f, 0.0f, createBitmap.getWidth(), createBitmap.getHeight());
        paint.setAntiAlias(true);
        int i13 = 0;
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-16777216);
        canvas.drawRoundRect(rectF, 0.0f, 0.0f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        int i14 = 0;
        for (int i15 = 0; i15 < bitmap.getHeight(); i15++) {
            int i16 = i13;
            while (i16 < bitmap.getWidth()) {
                int pixel = bitmap.getPixel(i16, i15);
                int red = Color.red(pixel);
                int green = Color.green(pixel);
                int blue = Color.blue(pixel);
                int alpha = Color.alpha(pixel);
                if (alpha == 0 || alpha == 255) {
                    i12 = i13;
                } else {
                    float f10 = alpha / 255.0f;
                    int pixel2 = createBitmap.getPixel(i10 + i16, i11 + i15);
                    int red2 = Color.red(pixel2);
                    int green2 = Color.green(pixel2);
                    float f11 = 1.0f - f10;
                    i12 = 0;
                    red = Math.max(0, Math.min(255, (int) ((red2 * f11) + (red * f10))));
                    green = Math.max(0, Math.min(255, (int) ((green2 * f11) + (green * f10))));
                    blue = Math.max(0, Math.min(255, (int) ((f11 * Color.blue(pixel2)) + (f10 * blue))));
                    if (red <= 16 && green <= 8 && blue <= 16) {
                        green = 9;
                        red = 17;
                        blue = 17;
                    }
                }
                iArr[i14] = Color.rgb(red, green, blue);
                i14++;
                i16++;
                i13 = i12;
            }
        }
        while (i13 < width) {
            int b10 = b(iArr[i13]);
            int i17 = i13 * 2;
            bArr[i17 + 1] = (byte) (b10 & 255);
            bArr[i17] = (byte) ((b10 >> 8) & 255);
            i13++;
        }
        return bArr;
    }

    public byte[] f(Bitmap bitmap, Bitmap bitmap2, int i10, int i11, boolean z10, int i12) {
        byte[] bArr = new byte[bitmap2.getWidth() * bitmap2.getHeight() * 2];
        int width = bitmap2.getWidth() * bitmap2.getHeight();
        int[] iArr = new int[width];
        int i13 = 0;
        for (int i14 = 0; i14 < bitmap2.getHeight(); i14++) {
            for (int i15 = 0; i15 < bitmap2.getWidth(); i15++) {
                int pixel = bitmap2.getPixel(i15, i14);
                int red = Color.red(pixel);
                int green = Color.green(pixel);
                int blue = Color.blue(pixel);
                int alpha = Color.alpha(pixel);
                if (z10 && (red > 0 || green > 0 || blue > 0)) {
                    red = Color.red(i12);
                    green = Color.green(i12);
                    blue = Color.blue(i12);
                }
                if (alpha != 0 && alpha != 255) {
                    float f10 = alpha / 255.0f;
                    int pixel2 = bitmap.getPixel(i10 + i15, i11 + i14);
                    int red2 = Color.red(pixel2);
                    int green2 = Color.green(pixel2);
                    float f11 = 1.0f - f10;
                    red = Math.max(0, Math.min(255, (int) ((red2 * f11) + (red * f10))));
                    green = Math.max(0, Math.min(255, (int) ((green2 * f11) + (green * f10))));
                    blue = Math.max(0, Math.min(255, (int) ((f11 * Color.blue(pixel2)) + (f10 * blue))));
                    if (red <= 16 && green <= 8 && blue <= 16) {
                        green = 9;
                        red = 17;
                        blue = 17;
                    }
                }
                iArr[i13] = Color.rgb(red, green, blue);
                i13++;
            }
        }
        for (int i16 = 0; i16 < width; i16++) {
            int b10 = b(iArr[i16]);
            int i17 = i16 * 2;
            bArr[i17 + 1] = (byte) (b10 & 255);
            bArr[i17] = (byte) ((b10 >> 8) & 255);
        }
        return bArr;
    }

    public byte[] g(Bitmap bitmap) {
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        byte[] bArr = new byte[width * 2];
        for (int i10 = 0; i10 < width; i10++) {
            int b10 = b(iArr[i10]);
            int i11 = i10 * 2;
            bArr[i11 + 1] = (byte) (b10 & 255);
            bArr[i11] = (byte) ((b10 >> 8) & 255);
        }
        return bArr;
    }

    public byte[] h(Bitmap bitmap) {
        bitmap.copyPixelsToBuffer(ByteBuffer.allocate(bitmap.getByteCount()));
        int width = bitmap.getWidth() * bitmap.getHeight();
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        byte[] bArr = new byte[width * 2];
        for (int i10 = 0; i10 < width; i10++) {
            int b10 = b(iArr[i10]);
            int i11 = i10 * 2;
            bArr[i11 + 1] = (byte) (b10 & 255);
            bArr[i11] = (byte) ((b10 >> 8) & 255);
        }
        return bArr;
    }

    public int j(byte[] bArr) {
        return bArr[0] & 255;
    }

    public byte[] k(byte[] bArr) {
        return A(n(bArr));
    }

    public int l(byte[] bArr) {
        return n(bArr);
    }

    public String m(byte[] bArr) {
        String str = "";
        for (byte b10 : bArr) {
            String hexString = Integer.toHexString(b10 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            str = str + hexString;
        }
        return str;
    }

    public byte[] o(byte[] bArr) {
        return B(q(bArr));
    }

    public int p(byte[] bArr) {
        return q(bArr);
    }

    public Bitmap r(Context context, Bitmap bitmap, int i10, String str) {
        Bitmap bitmap2;
        if (i10 == 1) {
            bitmap2 = m.o().q(str);
        } else {
            try {
                bitmap2 = m.o().p(context);
            } catch (IOException e10) {
                e10.printStackTrace();
                bitmap2 = null;
            }
        }
        if (bitmap2 == null) {
            return bitmap;
        }
        float width = bitmap2.getWidth();
        float height = bitmap2.getHeight();
        return D(bitmap2, bitmap, (width * (1.0f - (bitmap.getWidth() / width))) / 2.0f, (height * (1.0f - (bitmap.getHeight() / height))) / 2.0f);
    }

    public byte[] s(Context context, byte[] bArr, Bitmap bitmap, boolean z10) {
        byte[] g10 = g(bitmap);
        if (z10) {
            g10 = E(d(g10, bitmap.getWidth(), bitmap.getHeight()));
        }
        byte[] l10 = n.d(context).l("0a00f0002e160000f0000000000000000100000000000000");
        q qVar = null;
        if (bArr != null) {
            qVar = i(bArr, z10);
        }
        if (qVar != null) {
            bArr = x(qVar, l10, g10);
        }
        byte[] o10 = o(B(N(bArr)));
        System.arraycopy(o10, 0, bArr, 8, o10.length);
        return bArr;
    }

    public Bitmap v(byte[] bArr, int i10, int i11) {
        int i12 = i10 * i11;
        int[] iArr = new int[i12];
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = i13 * 2;
            int i15 = 255;
            int i16 = ((bArr[i14] & 255) << 8) | (bArr[i14 + 1] & 255);
            int i17 = ((63488 & i16) >> 11) << 3;
            int i18 = ((i16 & 2016) >> 5) << 2;
            int i19 = (i16 & 31) << 3;
            if (i17 <= 0 && i18 <= 0 && i19 <= 0) {
                i15 = 0;
            }
            iArr[i13] = i19 | (i17 << 16) | (i15 << 24) | (i18 << 8);
        }
        return Bitmap.createBitmap(iArr, i10, i11, Bitmap.Config.ARGB_8888);
    }

    public Bitmap w(byte[] bArr, int i10, int i11) {
        Bitmap createBitmap = Bitmap.createBitmap(i10, i11, Bitmap.Config.RGB_565);
        byte[] bArr2 = new byte[bArr.length];
        for (int i12 = 0; i12 < bArr.length; i12++) {
            if (i12 % 2 == 0) {
                bArr2[i12] = bArr[i12 + 1];
            } else {
                bArr2[i12] = bArr[i12 - 1];
            }
        }
        createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(bArr2));
        return createBitmap;
    }

    public byte[] x(q qVar, byte[] bArr, byte[] bArr2) {
        boolean z10;
        int i10;
        int i11;
        int i12;
        int length = bArr.length;
        int length2 = bArr2.length;
        int i13 = 2;
        byte[] bArr3 = new byte[2];
        System.arraycopy(bArr, 0, bArr3, 0, 2);
        int l10 = l(bArr3);
        a(" typeByteNew =" + Arrays.toString(bArr3));
        if (qVar == null) {
            return null;
        }
        int i14 = 0;
        while (true) {
            z10 = true;
            if (i14 >= qVar.c().size()) {
                z10 = false;
                break;
            } else if (Arrays.equals(bArr3, qVar.c().get(i14).e())) {
                length2 -= qVar.a().get(i14).b().length;
                System.arraycopy(o(B(p(qVar.e().f5349b) + length2)), 0, qVar.d(), 4, qVar.e().f5349b.length);
                List<k> c10 = qVar.c();
                List<l> b10 = qVar.b();
                List<j> a10 = qVar.a();
                System.arraycopy(qVar.c().get(i14).c(), 0, bArr, 4, qVar.c().get(i14).c().length);
                System.arraycopy(qVar.c().get(i14).d(), 0, bArr, i13, qVar.c().get(i14).d().length);
                System.arraycopy(qVar.c().get(i14).b(), 0, bArr, 8, qVar.c().get(i14).b().length);
                byte[] c11 = qVar.c().get(i14).c();
                System.arraycopy(o(B(p(c11) + length2)), 0, qVar.b().get(i14).b(), 4, c11.length);
                k kVar = new k();
                byte[] bArr4 = kVar.f5305a;
                System.arraycopy(bArr, 0, bArr4, 0, bArr4.length);
                byte[] bArr5 = kVar.f5306b;
                System.arraycopy(bArr, 2, bArr5, 0, bArr5.length);
                byte[] bArr6 = kVar.f5307c;
                System.arraycopy(bArr, 4, bArr6, 0, bArr6.length);
                byte[] bArr7 = kVar.f5308d;
                System.arraycopy(bArr, 8, bArr7, 0, bArr7.length);
                byte[] bArr8 = kVar.f5309e;
                System.arraycopy(bArr, 10, bArr8, 0, bArr8.length);
                byte[] bArr9 = kVar.f5310f;
                System.arraycopy(bArr, 12, bArr9, 0, bArr9.length);
                byte[] bArr10 = kVar.f5311g;
                System.arraycopy(bArr, 14, bArr10, 0, bArr10.length);
                byte[] bArr11 = kVar.f5312h;
                System.arraycopy(bArr, 16, bArr11, 0, bArr11.length);
                byte[] bArr12 = kVar.f5313i;
                System.arraycopy(bArr, 17, bArr12, 0, bArr12.length);
                c10.set(i14, kVar);
                b10.set(i14, new l(l(kVar.e()), bArr));
                a10.set(i14, new j(l(kVar.e()), bArr2));
                qVar.h(c10);
                qVar.g(b10);
                qVar.f(a10);
                for (int i15 = 0; i15 < qVar.c().size(); i15++) {
                    if (l(qVar.c().get(i15).e()) > l10) {
                        byte[] c12 = qVar.c().get(i15).c();
                        System.arraycopy(o(B(p(c12) + length2)), 0, qVar.b().get(i15).b(), 4, c12.length);
                        qVar.c().get(i15).i(o(B(p(c12) + length2)));
                    }
                }
            } else {
                i14++;
                i13 = 2;
            }
        }
        if (z10) {
            a("已存在相同的类型，替换更新");
            i10 = length2;
        } else {
            a("不存在相同的类型，需要插入");
            System.arraycopy(o(B(p(qVar.e().f5349b) + length + length2)), 0, qVar.d(), 4, qVar.e().f5349b.length);
            List<k> c13 = qVar.c();
            List<l> b11 = qVar.b();
            List<j> a11 = qVar.a();
            int i16 = 0;
            while (true) {
                if (i16 >= qVar.c().size()) {
                    break;
                }
                int l11 = l(qVar.c().get(i16).e());
                a(" type =" + l11);
                if (l11 > l10) {
                    System.arraycopy(qVar.c().get(i16).c(), 0, bArr, 4, qVar.c().get(i16).c().length);
                    k kVar2 = new k();
                    byte[] bArr13 = kVar2.f5305a;
                    System.arraycopy(bArr, 0, bArr13, 0, bArr13.length);
                    byte[] bArr14 = kVar2.f5306b;
                    System.arraycopy(bArr, 2, bArr14, 0, bArr14.length);
                    byte[] bArr15 = kVar2.f5307c;
                    System.arraycopy(bArr, 4, bArr15, 0, bArr15.length);
                    byte[] bArr16 = kVar2.f5308d;
                    System.arraycopy(bArr, 8, bArr16, 0, bArr16.length);
                    byte[] bArr17 = kVar2.f5309e;
                    System.arraycopy(bArr, 10, bArr17, 0, bArr17.length);
                    byte[] bArr18 = kVar2.f5310f;
                    System.arraycopy(bArr, 12, bArr18, 0, bArr18.length);
                    byte[] bArr19 = kVar2.f5311g;
                    System.arraycopy(bArr, 14, bArr19, 0, bArr19.length);
                    byte[] bArr20 = kVar2.f5312h;
                    System.arraycopy(bArr, 16, bArr20, 0, bArr20.length);
                    byte[] bArr21 = kVar2.f5313i;
                    System.arraycopy(bArr, 17, bArr21, 0, bArr21.length);
                    c13.add(i16, kVar2);
                    b11.add(i16, new l(l(kVar2.e()), bArr));
                    a11.add(i16, new j(l(kVar2.e()), bArr2));
                    qVar.h(c13);
                    qVar.g(b11);
                    qVar.f(a11);
                    break;
                }
                if (i16 == qVar.c().size() - 1 && l10 > l11) {
                    a(" 全部比type大，插入到后面的情况");
                    byte[] c14 = qVar.c().get(i16).c();
                    int length3 = qVar.a().get(qVar.a().size() - 1).b().length;
                    i10 = length2;
                    System.arraycopy(o(B(p(c14) + length + length3)), 0, bArr, 4, c14.length);
                    a(" 全部比type大，插入到后面的情况 " + length + "," + length3);
                    k kVar3 = new k();
                    byte[] bArr22 = kVar3.f5305a;
                    i12 = length;
                    System.arraycopy(bArr, 0, bArr22, 0, bArr22.length);
                    byte[] bArr23 = kVar3.f5306b;
                    i11 = l10;
                    System.arraycopy(bArr, 2, bArr23, 0, bArr23.length);
                    byte[] bArr24 = kVar3.f5307c;
                    System.arraycopy(bArr, 4, bArr24, 0, bArr24.length);
                    byte[] bArr25 = kVar3.f5308d;
                    System.arraycopy(bArr, 8, bArr25, 0, bArr25.length);
                    byte[] bArr26 = kVar3.f5309e;
                    System.arraycopy(bArr, 10, bArr26, 0, bArr26.length);
                    byte[] bArr27 = kVar3.f5310f;
                    System.arraycopy(bArr, 12, bArr27, 0, bArr27.length);
                    byte[] bArr28 = kVar3.f5311g;
                    System.arraycopy(bArr, 14, bArr28, 0, bArr28.length);
                    byte[] bArr29 = kVar3.f5312h;
                    System.arraycopy(bArr, 16, bArr29, 0, bArr29.length);
                    byte[] bArr30 = kVar3.f5313i;
                    System.arraycopy(bArr, 17, bArr30, 0, bArr30.length);
                    c13.add(i16, kVar3);
                    b11.add(i16, new l(l(kVar3.e()), bArr));
                    a11.add(new j(l(kVar3.e()), bArr2));
                    qVar.h(c13);
                    qVar.g(b11);
                    qVar.f(a11);
                    a(" 全部比type大，插入到后面的情况 " + Arrays.toString(kVar3.f5307c) + "," + Arrays.toString(c14));
                    break;
                }
                length = length;
                length2 = length2;
                l10 = l10;
                i16++;
            }
            i12 = length;
            i10 = length2;
            i11 = l10;
            int i17 = 0;
            while (i17 < qVar.c().size()) {
                int l12 = l(qVar.c().get(i17).e());
                int i18 = i11;
                if (l12 < i18) {
                    byte[] c15 = qVar.c().get(i17).c();
                    System.arraycopy(o(B(p(c15) + i12)), 0, qVar.b().get(i17).b(), 4, c15.length);
                    qVar.c().get(i17).i(o(B(p(c15) + i12)));
                } else if (l12 > i18) {
                    byte[] c16 = qVar.c().get(i17).c();
                    System.arraycopy(o(B(p(c16) + i12 + i10)), 0, qVar.b().get(i17).b(), 4, c16.length);
                    qVar.c().get(i17).i(o(B(p(c16) + i12 + i10)));
                    i17++;
                    i11 = i18;
                }
                i17++;
                i11 = i18;
            }
        }
        byte[] M = M(qVar);
        a(" 66all.length =" + M.length + "，PicDataConfigNewSize =" + i10);
        return M;
    }

    public byte[] z(int i10) {
        return new byte[]{(byte) (i10 & 255)};
    }
}
