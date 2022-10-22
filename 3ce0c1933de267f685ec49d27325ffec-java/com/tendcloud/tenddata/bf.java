package com.tendcloud.tenddata;

import java.util.Map;
/* compiled from: td */
/* loaded from: classes2.dex */
public class bf {
    public static final String a(Throwable th2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(th2.toString());
        sb2.append("\r\n");
        try {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            int i10 = 50;
            if (stackTrace.length <= 50) {
                i10 = stackTrace.length;
            }
            for (int i11 = 0; i11 < i10; i11++) {
                sb2.append("\t");
                sb2.append(stackTrace[i11]);
                sb2.append("\r\n");
            }
            Throwable cause = th2.getCause();
            if (cause != null) {
                a(sb2, stackTrace, cause, 1);
            }
        } catch (Throwable unused) {
        }
        return sb2.toString();
    }

    public static void a(String str, boolean z10, Map<String, Object> map) {
    }

    public static void postSDKError(Throwable th2) {
    }

    private static final void a(StringBuilder sb2, StackTraceElement[] stackTraceElementArr, Throwable th2, int i10) {
        try {
            StackTraceElement[] stackTrace = th2.getStackTrace();
            int length = stackTrace.length - 1;
            for (int length2 = stackTraceElementArr.length - 1; length >= 0 && length2 >= 0 && stackTrace[length].equals(stackTraceElementArr[length2]); length2--) {
                length--;
            }
            if (length > 50) {
                length = 50;
            }
            sb2.append("Caused by : ");
            sb2.append(th2);
            sb2.append("\r\n");
            for (int i11 = 0; i11 <= length; i11++) {
                sb2.append("\t");
                sb2.append(stackTrace[i11]);
                sb2.append("\r\n");
            }
            if (i10 < 5 && th2.getCause() != null) {
                a(sb2, stackTrace, th2, i10 + 1);
            }
        } catch (Throwable unused) {
        }
    }
}
