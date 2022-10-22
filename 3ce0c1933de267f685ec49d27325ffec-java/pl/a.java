package pl;

import android.content.Context;
import il.b;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f32867a;

    /* renamed from: b  reason: collision with root package name */
    public long f32868b;

    /* renamed from: c  reason: collision with root package name */
    public int f32869c;

    /* renamed from: d  reason: collision with root package name */
    public int f32870d;

    public a(String str, int i10, int i11, int i12) {
        this.f32867a = str;
        this.f32868b = i10;
        this.f32869c = i11;
        this.f32870d = i12;
    }

    public static a c(String str, int i10, byte[] bArr) {
        a aVar = new a(str, i10, ((bArr[3] << 24) & (-16777216)) | ((bArr[2] << 16) & 16711680) | ((bArr[1] << 8) & 65280) | (bArr[0] & 255), bArr[4] & 1);
        b.j(aVar.toString());
        return aVar;
    }

    public int a() {
        return this.f32870d;
    }

    public InputStream b(Context context) {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(this.f32867a);
            inputStream.skip(this.f32868b);
            return inputStream;
        } catch (FileNotFoundException e10) {
            b.l(String.format(Locale.US, "FileNotFoundException:%s, %d", this.f32867a, Long.valueOf(this.f32868b)));
            e10.printStackTrace();
            return inputStream;
        } catch (IOException e11) {
            e11.printStackTrace();
            return inputStream;
        }
    }

    public InputStream d() {
        FileInputStream fileInputStream;
        FileNotFoundException e10;
        IOException e11;
        try {
            fileInputStream = new FileInputStream(this.f32867a);
            try {
                fileInputStream.skip(this.f32868b);
            } catch (FileNotFoundException e12) {
                e10 = e12;
                b.l(String.format(Locale.US, "FileNotFoundException:%s, %d", this.f32867a, Long.valueOf(this.f32868b)));
                e10.printStackTrace();
                return fileInputStream;
            } catch (IOException e13) {
                e11 = e13;
                e11.printStackTrace();
                return fileInputStream;
            }
        } catch (FileNotFoundException e14) {
            e10 = e14;
            fileInputStream = null;
        } catch (IOException e15) {
            e11 = e15;
            fileInputStream = null;
        }
        return fileInputStream;
    }

    public int e() {
        return this.f32869c;
    }

    public long f() {
        return this.f32868b;
    }

    public String toString() {
        return String.format(Locale.US, "skipOffset=%d, length=0x%02X, budRole=0x%02X", Long.valueOf(this.f32868b), Integer.valueOf(this.f32869c), Integer.valueOf(this.f32870d));
    }
}
