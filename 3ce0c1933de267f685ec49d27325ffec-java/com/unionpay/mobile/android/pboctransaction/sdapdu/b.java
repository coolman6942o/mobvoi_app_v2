package com.unionpay.mobile.android.pboctransaction.sdapdu;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static String[] f23841a;

    /* renamed from: b  reason: collision with root package name */
    public static int f23842b;

    /* renamed from: c  reason: collision with root package name */
    private static ArrayList<String> f23843c = new ArrayList<>();

    public static void a() {
        HashSet<String> b10 = b();
        String[] strArr = new String[b10.size()];
        f23841a = strArr;
        b10.toArray(strArr);
    }

    private static HashSet<String> b() {
        String[] split;
        String[] split2;
        byte[] bArr;
        HashSet<String> hashSet = new HashSet<>();
        String str = "";
        try {
            Process start = new ProcessBuilder(new String[0]).command("mount").redirectErrorStream(true).start();
            start.waitFor();
            InputStream inputStream = start.getInputStream();
            while (inputStream.read(new byte[1024]) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        for (String str2 : str.split("\n")) {
            if (!str2.toLowerCase(Locale.US).contains("asec") && str2.matches("(?i).*vold.*(vfat|ntfs|exfat|fat32|ext3|ext4).*rw.*")) {
                for (String str3 : str2.split(" ")) {
                    if (str3.startsWith("/") && !str3.toLowerCase(Locale.US).contains("vold")) {
                        hashSet.add(str3);
                    }
                }
            }
        }
        return hashSet;
    }
}
