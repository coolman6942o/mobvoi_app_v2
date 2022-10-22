package com.tendcloud.tenddata;

import android.util.Log;
/* compiled from: td */
/* loaded from: classes2.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f22893a = true;

    public static void a(String str, Throwable th2) {
        if (f22893a) {
            a(str, 4);
            th2.printStackTrace();
        }
    }

    private static void b(String str, int i10) {
        String a10 = a();
        if (i10 == 2) {
            Log.v(a10, str);
        } else if (i10 == 3) {
            Log.d(a10, str);
        } else if (i10 == 4) {
            Log.i(a10, str);
        } else if (i10 == 5) {
            Log.w(a10, str);
        } else if (i10 == 6) {
            Log.e(a10, str);
        }
    }

    public static void dForDeveloper(String str) {
        if (f22893a) {
            a(str, 3);
        }
    }

    public static void dForInternal(String... strArr) {
    }

    public static void eForDeveloper(String str) {
        if (f22893a) {
            a(str, 6);
        }
    }

    public static void eForInternal(Throwable th2) {
    }

    public static void eForInternal(String... strArr) {
    }

    public static void iForDeveloper(String str) {
        if (f22893a) {
            a(str, 4);
        }
    }

    public static void iForInternal(String... strArr) {
    }

    public static void json(String str) {
    }

    private static void a(String str, int i10) {
        if (str != null) {
            try {
                int length = str.length();
                int i11 = 2000;
                int i12 = 0;
                int i13 = 0;
                while (i12 < 100) {
                    if (length > i11) {
                        b(str.substring(i13, i11), i10);
                        i11 += 2000;
                        i12++;
                        i13 = i11;
                    } else {
                        b(str.substring(i13, length), i10);
                        return;
                    }
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
    }

    private static synchronized String a() {
        synchronized (g.class) {
            try {
                new Exception().getStackTrace()[4].getClassName().lastIndexOf(".");
            } catch (Throwable th2) {
                bf.postSDKError(th2);
                return ab.f22582v;
            }
        }
        return ab.f22582v;
    }
}
