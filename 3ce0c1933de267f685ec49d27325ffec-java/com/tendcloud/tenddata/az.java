package com.tendcloud.tenddata;

import android.util.Log;
import com.tendcloud.tenddata.zz;
import java.lang.Thread;
import java.util.HashMap;
import java.util.TreeMap;
/* compiled from: td */
/* loaded from: classes2.dex */
public class az {

    /* renamed from: a  reason: collision with root package name */
    private static volatile az f22719a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: td */
    /* loaded from: classes2.dex */
    public static class a implements Thread.UncaughtExceptionHandler {
        private Thread.UncaughtExceptionHandler appDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();

        a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th2) {
            if (ab.f22566f) {
                az.a(th2, String.valueOf(System.currentTimeMillis()), com.tendcloud.tenddata.a.UNIVERSAL, true);
                Log.w(ab.f22582v, "UncaughtException in Thread " + thread.getName(), th2);
            }
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.appDefaultHandler;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th2);
            }
        }
    }

    static {
        try {
            v.a().register(a());
        } catch (Throwable unused) {
        }
    }

    private az() {
        b();
    }

    public static az a() {
        if (f22719a == null) {
            synchronized (az.class) {
                if (f22719a == null) {
                    f22719a = new az();
                }
            }
        }
        return f22719a;
    }

    private static void b() {
        try {
            Thread.setDefaultUncaughtExceptionHandler(new a());
        } catch (Throwable unused) {
        }
    }

    public final void onTDEBEventError(zz.a aVar) {
        if (aVar != null) {
            try {
                HashMap<String, Object> hashMap = aVar.paraMap;
                if (hashMap != null && Integer.parseInt(String.valueOf(hashMap.get("apiType"))) == 3) {
                    a(aVar.paraMap);
                }
            } catch (Throwable unused) {
            }
        }
    }

    void a(HashMap<String, Object> hashMap) {
        try {
            com.tendcloud.tenddata.a aVar = (com.tendcloud.tenddata.a) hashMap.get("service");
            if (hashMap.containsKey("throwable") && hashMap.containsKey("occurTime")) {
                a((Throwable) hashMap.get("throwable"), String.valueOf(hashMap.get("occurTime")), aVar, false);
            }
        } catch (Throwable unused) {
        }
    }

    static void a(Throwable th2, String str, com.tendcloud.tenddata.a aVar, boolean z10) {
        if (ab.f22568h != null) {
            try {
                long currentTimeMillis = str.trim().isEmpty() ? System.currentTimeMillis() : Long.parseLong(str);
                if (z10 && ab.I) {
                    h.c(currentTimeMillis, aVar);
                }
            } catch (Throwable unused) {
            }
            Throwable th3 = th2;
            while (th3.getCause() != null) {
                try {
                    th3 = th3.getCause();
                } catch (Throwable unused2) {
                    return;
                }
            }
            StackTraceElement[] stackTrace = th3.getStackTrace();
            String packageName = ab.f22568h.getPackageName();
            int i10 = 0;
            for (int i11 = 0; i10 < 3 && i11 < stackTrace.length; i11++) {
                String className = stackTrace[i11].getClassName();
                if ((!className.startsWith("java.") || packageName.startsWith("java.")) && ((!className.startsWith("javax.") || packageName.startsWith("javax.")) && ((!className.startsWith("android.") || packageName.startsWith("android.")) && (!className.startsWith("com.android.") || packageName.startsWith("com.android."))))) {
                    stackTrace[i11].toString();
                    i10++;
                }
            }
            bi biVar = new bi();
            biVar.f22732b = "apm";
            biVar.f22733c = "error";
            TreeMap treeMap = new TreeMap();
            treeMap.put("msg", a(th2));
            treeMap.put("type", th3.getClass().getName());
            biVar.f22734d = treeMap;
            biVar.f22731a = com.tendcloud.tenddata.a.UNIVERSAL;
            v.a().post(biVar);
        }
    }

    private static final String a(Throwable th2) {
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
                sb2.append("\tat ");
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
