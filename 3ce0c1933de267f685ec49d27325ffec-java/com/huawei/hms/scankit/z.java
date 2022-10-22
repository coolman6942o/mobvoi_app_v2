package com.huawei.hms.scankit;

import android.content.Context;
import com.huawei.hms.scankit.util.a;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: MsModel.java */
/* loaded from: classes2.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f15086a = null;

    /* renamed from: b  reason: collision with root package name */
    private static byte[] f15087b = null;

    /* renamed from: c  reason: collision with root package name */
    private static float[] f15088c = null;

    /* renamed from: d  reason: collision with root package name */
    private static int f15089d = 8136;

    public static int a() {
        return f15089d;
    }

    public static void b(Context context, String str) {
        a.c("MsModel", "load model...." + str);
        if (f15086a == null) {
            try {
                InputStream open = context.getAssets().open(str);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("inputStream");
                sb2.append(open);
                a.c("MsModel", sb2.toString());
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                open.close();
                f15086a = bArr;
            } catch (IOException unused) {
                a.b("MsModel", "loadModel IOException");
            } catch (Exception unused2) {
                a.b("MsModel", "loadModel Exception");
            }
        }
    }

    public static byte[] c() {
        return f15086a;
    }

    public static float[] d() {
        return f15088c;
    }

    public static float a(byte[] bArr, int i10) {
        return Float.intBitsToFloat((int) ((bArr[i10 + 3] << 24) | (((int) ((((int) ((bArr[i10 + 0] & 255) | (bArr[i10 + 1] << 8))) & 65535) | (bArr[i10 + 2] << 16))) & 16777215)));
    }

    public static void c(Context context, String str) {
        a.c("MsModel", "ms anrchos...." + str);
        if (f15088c == null) {
            try {
                InputStream open = context.getAssets().open(str);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("2inputStream");
                sb2.append(open);
                a.c("MsModel", sb2.toString());
                int available = open.available();
                byte[] bArr = new byte[available];
                open.read(bArr);
                open.close();
                f15088c = new float[available / 4];
                int i10 = 0;
                while (true) {
                    float[] fArr = f15088c;
                    if (i10 < fArr.length) {
                        fArr[i10] = a(bArr, i10 * 4);
                        i10++;
                    } else {
                        return;
                    }
                }
            } catch (IOException unused) {
                a.b("MsModel", "loadMsAnchors IOException");
            } catch (Exception unused2) {
                a.b("MsModel", "loadMsAnchors Exception");
            }
        }
    }

    public static void a(Context context, String str) {
        a.c("MsModel", "load angle model...." + str);
        if (f15087b == null) {
            try {
                InputStream open = context.getAssets().open(str);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("3inputStream");
                sb2.append(open);
                a.c("MsModel", sb2.toString());
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                open.close();
                f15087b = bArr;
            } catch (IOException unused) {
                a.b("MsModel", "loadAngleModel IOException");
            } catch (Exception unused2) {
                a.b("MsModel", "loadAngleModel Exception");
            }
        }
    }

    public static byte[] b() {
        return f15087b;
    }
}
