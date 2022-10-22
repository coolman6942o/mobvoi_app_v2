package c4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes.dex */
public final class b {
    /* JADX WARN: Can't wrap try/catch for region: R(2:(3:32|7|(1:9)(0))|26) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(String str, String str2) {
        Throwable th2;
        File file;
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            file = new File(str, str2);
        } catch (IOException unused) {
        } catch (Throwable th3) {
            th2 = th3;
        }
        if (!file.exists()) {
            return null;
        }
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
        while (true) {
            try {
                String readLine = bufferedReader2.readLine();
                if (readLine != null) {
                    sb2.append(readLine);
                }
            } catch (IOException unused2) {
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    bufferedReader2 = bufferedReader;
                    break;
                    bufferedReader2.close();
                }
                return sb2.toString();
            } catch (Throwable th4) {
                th2 = th4;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Throwable unused3) {
                    }
                }
                throw th2;
            }
            break;
        }
        bufferedReader2.close();
        return sb2.toString();
    }
}
