package com.mobvoi.wear.log;

import android.util.Log;
/* loaded from: classes2.dex */
public class L {
    private static boolean DEBUG = false;
    private static boolean V = Log.isLoggable("tic", 2);
    private static String TAG = "tic";
    private static boolean D = Log.isLoggable(TAG, 3);
    private static boolean A = Log.isLoggable(TAG, 7);
    private static boolean E = Log.isLoggable(TAG, 6);
    private static boolean I = Log.isLoggable(TAG, 4);
    private static boolean W = Log.isLoggable(TAG, 5);

    public static void d(Throwable th2) {
        log(3, th2, null, new Object[0]);
    }

    public static void e(Throwable th2) {
        log(6, th2, null, new Object[0]);
    }

    public static void i(Throwable th2) {
        log(4, th2, null, new Object[0]);
    }

    private static void initTagLoggable() {
        V = Log.isLoggable(TAG, 2);
        D = Log.isLoggable(TAG, 3);
        A = Log.isLoggable(TAG, 7);
        E = Log.isLoggable(TAG, 6);
        I = Log.isLoggable(TAG, 4);
        W = Log.isLoggable(TAG, 5);
    }

    private static boolean isLoggable(int i10) {
        switch (i10) {
            case 2:
                return V;
            case 3:
                return D;
            case 4:
                return I;
            case 5:
                return W;
            case 6:
                return E;
            case 7:
                return A;
            default:
                return false;
        }
    }

    private static void log(int i10, Throwable th2, Object obj, Object... objArr) {
        String format;
        if (i10 == 6 || DEBUG || isLoggable(i10)) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
            String className = stackTraceElement.getClassName();
            String substring = className.substring(className.lastIndexOf(".") + 1);
            int lineNumber = stackTraceElement.getLineNumber();
            String methodName = stackTraceElement.getMethodName();
            String str = substring + ":" + lineNumber;
            StringBuilder sb2 = new StringBuilder();
            if (!DEBUG) {
                sb2.append(className + "#");
            }
            sb2.append(methodName);
            sb2.append("(): ");
            if (obj != null) {
                if (objArr != null) {
                    try {
                        if (objArr.length != 0) {
                            format = String.format((String) obj, objArr);
                            sb2.append(format);
                        }
                    } catch (Exception unused) {
                        sb2.append(obj.toString());
                    }
                }
                format = obj.toString();
                sb2.append(format);
            }
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        if (i10 != 5) {
                            if (i10 == 6) {
                                if (th2 != null) {
                                    Log.e(str, sb2.toString(), th2);
                                } else {
                                    Log.e(str, sb2.toString());
                                }
                            }
                        } else if (th2 != null) {
                            Log.w(str, sb2.toString(), th2);
                        } else {
                            Log.w(str, sb2.toString());
                        }
                    } else if (th2 != null) {
                        Log.i(str, sb2.toString(), th2);
                    } else {
                        Log.i(str, sb2.toString());
                    }
                } else if (th2 != null) {
                    Log.d(str, sb2.toString(), th2);
                } else {
                    Log.d(str, sb2.toString());
                }
            } else if (th2 != null) {
                Log.v(str, sb2.toString(), th2);
            } else {
                Log.v(str, sb2.toString());
            }
        }
    }

    public static void setDebugEnabled(boolean z10) {
        DEBUG = z10;
    }

    public static void setTag(String str) {
        TAG = str;
        initTagLoggable();
    }

    public static void v(Throwable th2) {
        log(2, th2, null, new Object[0]);
    }

    public static void w(Throwable th2) {
        log(5, th2, null, new Object[0]);
    }

    public static void d(Object obj, Object... objArr) {
        log(3, null, obj, objArr);
    }

    public static void e(Object obj, Object... objArr) {
        log(6, null, obj, objArr);
    }

    public static void i(Object obj, Object... objArr) {
        log(4, null, obj, objArr);
    }

    public static void v(Object obj, Object... objArr) {
        log(2, null, obj, objArr);
    }

    public static void w(Object obj, Object... objArr) {
        log(5, null, obj, objArr);
    }

    public static void d(Throwable th2, Object obj, Object... objArr) {
        log(3, th2, obj, objArr);
    }

    public static void e(Throwable th2, Object obj, Object... objArr) {
        log(6, th2, obj, objArr);
    }

    public static void i(Throwable th2, Object obj, Object... objArr) {
        log(4, th2, obj, objArr);
    }

    public static void v(Throwable th2, Object obj, Object... objArr) {
        log(2, th2, obj, objArr);
    }

    public static void w(Throwable th2, Object obj, Object... objArr) {
        log(5, th2, obj, objArr);
    }
}
