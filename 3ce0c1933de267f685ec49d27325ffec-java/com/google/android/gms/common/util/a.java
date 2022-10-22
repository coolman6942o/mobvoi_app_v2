package com.google.android.gms.common.util;

import android.os.Process;
import android.os.StrictMode;
import h6.k;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f9036a;

    /* renamed from: b  reason: collision with root package name */
    private static int f9037b;

    public static String a() {
        if (f9036a == null) {
            if (f9037b == 0) {
                f9037b = Process.myPid();
            }
            f9036a = b(f9037b);
        }
        return f9036a;
    }

    private static String b(int i10) {
        BufferedReader bufferedReader;
        Throwable th2;
        String str = null;
        if (i10 <= 0) {
            return null;
        }
        try {
            StringBuilder sb2 = new StringBuilder(25);
            sb2.append("/proc/");
            sb2.append(i10);
            sb2.append("/cmdline");
            bufferedReader = c(sb2.toString());
            try {
                str = bufferedReader.readLine().trim();
                k.a(bufferedReader);
            } catch (IOException unused) {
                k.a(bufferedReader);
                return str;
            } catch (Throwable th3) {
                th2 = th3;
                k.a(bufferedReader);
                throw th2;
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th4) {
            th2 = th4;
            bufferedReader = null;
        }
        return str;
    }

    private static BufferedReader c(String str) throws IOException {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return new BufferedReader(new FileReader(str));
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
