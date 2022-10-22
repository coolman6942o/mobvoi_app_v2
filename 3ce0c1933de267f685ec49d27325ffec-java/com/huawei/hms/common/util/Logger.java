package com.huawei.hms.common.util;

import android.annotation.SuppressLint;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.mobvoi.wear.lpa.LpaConstants;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Locale;
import org.json.JSONException;
/* loaded from: classes.dex */
public class Logger {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f13722a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final String f13723b = "Logger";

    /* renamed from: c  reason: collision with root package name */
    private static final String f13724c = "|";

    /* renamed from: d  reason: collision with root package name */
    private static final int f13725d = 8;

    /* renamed from: e  reason: collision with root package name */
    private static final int f13726e = 20;

    /* renamed from: f  reason: collision with root package name */
    private static final String f13727f = "dynamic-api_";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends Throwable {

        /* renamed from: b  reason: collision with root package name */
        private static final long f13728b = 7129050843360571879L;

        /* renamed from: a  reason: collision with root package name */
        String f13729a;

        /* renamed from: c  reason: collision with root package name */
        private Throwable f13730c;

        /* renamed from: d  reason: collision with root package name */
        private Throwable f13731d;

        private a(Throwable th2) {
            this.f13731d = th2;
        }

        /* synthetic */ a(Throwable th2, byte b10) {
            this(th2);
        }

        private void a(String str) {
            this.f13729a = str;
        }

        private void a(Throwable th2) {
            this.f13730c = th2;
        }

        @Override // java.lang.Throwable
        public final Throwable getCause() {
            Throwable th2 = this.f13730c;
            if (th2 == this) {
                return null;
            }
            return th2;
        }

        @Override // java.lang.Throwable
        public final String getMessage() {
            return this.f13729a;
        }

        @Override // java.lang.Throwable
        public final String toString() {
            Throwable th2 = this.f13731d;
            if (th2 == null) {
                return "";
            }
            String name = th2.getClass().getName();
            if (this.f13729a == null) {
                return name;
            }
            String str = name + ": ";
            if (this.f13729a.startsWith(str)) {
                return this.f13729a;
            }
            return str + this.f13729a;
        }
    }

    private static int a(int i10, String str, String str2) {
        return Log.println(i10, a(str), a(str2, 7));
    }

    private static String a(int i10) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length <= i10) {
            return "";
        }
        StackTraceElement stackTraceElement = stackTrace[i10];
        return Process.myPid() + "-" + Process.myTid() + f13724c + stackTraceElement.getFileName() + f13724c + stackTraceElement.getClassName() + f13724c + stackTraceElement.getMethodName() + f13724c + stackTraceElement.getLineNumber();
    }

    private static String a(String str) {
        return f13727f.concat(String.valueOf(str));
    }

    private static String a(String str, int i10) {
        if (TextUtils.isEmpty(str)) {
            return a(i10);
        }
        return a(i10) + f13724c + str;
    }

    private static Throwable a(Throwable th2) {
        if (isLoggable(3)) {
            return th2;
        }
        if (th2 == null) {
            return null;
        }
        int i10 = 20;
        if ((th2 instanceof IOException) || (th2 instanceof JSONException)) {
            i10 = 8;
        }
        a aVar = new a(th2, (byte) 0);
        StackTraceElement[] stackTrace = aVar.getStackTrace();
        if (stackTrace.length > i10) {
            aVar.setStackTrace((StackTraceElement[]) Arrays.copyOf(stackTrace, i10));
        } else {
            aVar.setStackTrace(stackTrace);
        }
        aVar.f13729a = anonymizeMessage(th2.getMessage());
        Throwable cause = th2.getCause();
        a aVar2 = aVar;
        while (cause != null) {
            a aVar3 = new a(cause, (byte) 0);
            aVar3.f13729a = anonymizeMessage(cause.getMessage());
            aVar2.f13730c = aVar3;
            cause = cause.getCause();
            aVar2 = aVar3;
        }
        return aVar;
    }

    public static String anonymizeMessage(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        for (int i10 = 0; i10 < charArray.length; i10++) {
            if (i10 % 2 == 1) {
                charArray[i10] = '*';
            }
        }
        return new String(charArray);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, Object obj) {
        println(3, str, obj);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void d(String str, String str2, Object... objArr) {
        println(3, str, str2, objArr);
    }

    public static void e(String str, Object obj) {
        println(6, str, obj);
    }

    public static void e(String str, String str2, Throwable th2) {
        Log.e(a(str), a(str2, 5), a(th2));
    }

    public static void e(String str, String str2, Object... objArr) {
        println(6, str, str2, objArr);
    }

    public static String format(String str, Object... objArr) {
        return str == null ? "" : String.format(Locale.ROOT, str, objArr);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, Object obj) {
        println(4, str, obj);
    }

    @SuppressLint({"LogTagMismatch"})
    public static void i(String str, String str2, Object... objArr) {
        println(4, str, str2, objArr);
    }

    public static boolean isLoggable(int i10) {
        return Log.isLoggable(f13727f, i10);
    }

    public static void println(int i10, String str, Object obj) {
        if (i10 >= 3 && isLoggable(i10)) {
            a(i10, str, obj == null ? LpaConstants.VALUE_NULL : obj.toString());
        }
    }

    public static void println(int i10, String str, String str2, Object... objArr) {
        if (i10 >= 3) {
            if (str2 == null) {
                Log.w(f13723b, "format is null, not log");
                return;
            }
            try {
                if (isLoggable(i10)) {
                    a(i10, str, format(str2, objArr));
                }
            } catch (IllegalFormatException e10) {
                w(f13723b, "log format error".concat(str2), e10);
            }
        }
    }

    public static void v(String str, Object obj) {
        println(2, str, obj);
    }

    public static void v(String str, String str2, Object... objArr) {
        println(2, str, str2, objArr);
    }

    public static void w(String str, Object obj) {
        println(5, str, obj);
    }

    public static void w(String str, String str2, Throwable th2) {
        Log.w(a(str), a(str2, 5), a(th2));
    }

    public static void w(String str, String str2, Object... objArr) {
        println(5, str, str2, objArr);
    }
}
