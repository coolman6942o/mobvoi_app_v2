package com.paypal.android.sdk;

import android.os.Environment;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* loaded from: classes2.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private boolean f21855a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f21856b;

    /* renamed from: c  reason: collision with root package name */
    private File f21857c;

    public q() {
        this.f21855a = false;
        this.f21856b = false;
        String externalStorageState = Environment.getExternalStorageState();
        externalStorageState.hashCode();
        if (externalStorageState.equals("mounted")) {
            this.f21856b = true;
            this.f21855a = true;
        } else if (!externalStorageState.equals("mounted_ro")) {
            this.f21856b = false;
            this.f21855a = false;
        } else {
            this.f21855a = true;
            this.f21856b = false;
        }
        this.f21857c = Environment.getExternalStorageDirectory();
    }

    public final void a(String str) {
        this.f21857c = new File(str);
    }

    public final void b(String str, byte[] bArr) {
        Throwable th2;
        if (this.f21855a && this.f21856b) {
            FileOutputStream fileOutputStream = null;
            try {
                if (this.f21857c.mkdirs() || this.f21857c.isDirectory()) {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(new File(this.f21857c, str));
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream = fileOutputStream2;
                    } catch (Throwable th3) {
                        th2 = th3;
                        fileOutputStream = fileOutputStream2;
                        y1.f(fileOutputStream);
                        throw th2;
                    }
                }
                y1.f(fileOutputStream);
            } catch (Throwable th4) {
                th2 = th4;
            }
        }
    }

    public final String c(String str) {
        Throwable th2;
        byte[] bArr = new byte[1024];
        if (this.f21856b) {
            FileInputStream fileInputStream = null;
            try {
                FileInputStream fileInputStream2 = new FileInputStream(new File(this.f21857c, str));
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    for (int read = fileInputStream2.read(bArr, 0, 1024); read != -1; read = fileInputStream2.read(bArr, 0, 1024)) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    y1.f(fileInputStream2);
                } catch (IOException unused) {
                    fileInputStream = fileInputStream2;
                    y1.f(fileInputStream);
                    return "";
                } catch (Throwable th3) {
                    th2 = th3;
                    fileInputStream = fileInputStream2;
                    y1.f(fileInputStream);
                    throw th2;
                }
            } catch (IOException unused2) {
            } catch (Throwable th4) {
                th2 = th4;
            }
        }
        return new String(bArr, "UTF-8");
    }
}
