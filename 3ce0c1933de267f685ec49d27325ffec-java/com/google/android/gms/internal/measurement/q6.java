package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class q6 {

    /* renamed from: f  reason: collision with root package name */
    private static HashMap<String, String> f9623f;

    /* renamed from: k  reason: collision with root package name */
    private static Object f9628k;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f9629l;

    /* renamed from: a  reason: collision with root package name */
    private static final Uri f9618a = Uri.parse("content://com.google.android.gsf.gservices");

    /* renamed from: b  reason: collision with root package name */
    private static final Uri f9619b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f9620c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* renamed from: d  reason: collision with root package name */
    public static final Pattern f9621d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicBoolean f9622e = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    private static final HashMap<String, Boolean> f9624g = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private static final HashMap<String, Integer> f9625h = new HashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private static final HashMap<String, Long> f9626i = new HashMap<>();

    /* renamed from: j  reason: collision with root package name */
    private static final HashMap<String, Float> f9627j = new HashMap<>();

    /* renamed from: m  reason: collision with root package name */
    private static String[] f9630m = new String[0];

    private static <T> T a(HashMap<String, T> hashMap, String str, T t10) {
        synchronized (q6.class) {
            if (!hashMap.containsKey(str)) {
                return null;
            }
            T t11 = hashMap.get(str);
            if (t11 != null) {
                t10 = t11;
            }
            return t10;
        }
    }

    public static String b(ContentResolver contentResolver, String str, String str2) {
        synchronized (q6.class) {
            d(contentResolver);
            Object obj = f9628k;
            String str3 = null;
            if (f9623f.containsKey(str)) {
                String str4 = f9623f.get(str);
                if (str4 != null) {
                    str3 = str4;
                }
                return str3;
            }
            for (String str5 : f9630m) {
                if (str.startsWith(str5)) {
                    if (!f9629l || f9623f.isEmpty()) {
                        f9623f.putAll(c(contentResolver, f9630m));
                        f9629l = true;
                        if (f9623f.containsKey(str)) {
                            String str6 = f9623f.get(str);
                            if (str6 != null) {
                                str3 = str6;
                            }
                            return str3;
                        }
                    }
                    return null;
                }
            }
            Cursor query = contentResolver.query(f9618a, null, null, new String[]{str}, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        String string = query.getString(1);
                        if (string != null && string.equals(null)) {
                            string = null;
                        }
                        e(obj, str, string);
                        if (string != null) {
                            str3 = string;
                        }
                        query.close();
                        return str3;
                    }
                } finally {
                    if (query != null) {
                        query.close();
                    }
                }
            }
            e(obj, str, null);
            return null;
        }
    }

    private static Map<String, String> c(ContentResolver contentResolver, String... strArr) {
        Cursor query = contentResolver.query(f9619b, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (query == null) {
            return treeMap;
        }
        while (query.moveToNext()) {
            try {
                treeMap.put(query.getString(0), query.getString(1));
            } finally {
                query.close();
            }
        }
        return treeMap;
    }

    private static void d(ContentResolver contentResolver) {
        if (f9623f == null) {
            f9622e.set(false);
            f9623f = new HashMap<>();
            f9628k = new Object();
            f9629l = false;
            contentResolver.registerContentObserver(f9618a, true, new r6(null));
        } else if (f9622e.getAndSet(false)) {
            f9623f.clear();
            f9624g.clear();
            f9625h.clear();
            f9626i.clear();
            f9627j.clear();
            f9628k = new Object();
            f9629l = false;
        }
    }

    private static void e(Object obj, String str, String str2) {
        synchronized (q6.class) {
            if (obj == f9628k) {
                f9623f.put(str, str2);
            }
        }
    }

    public static boolean f(ContentResolver contentResolver, String str, boolean z10) {
        Object g10 = g(contentResolver);
        HashMap<String, Boolean> hashMap = f9624g;
        Boolean bool = (Boolean) a(hashMap, str, Boolean.valueOf(z10));
        if (bool != null) {
            return bool.booleanValue();
        }
        String b10 = b(contentResolver, str, null);
        if (b10 != null && !b10.equals("")) {
            if (f9620c.matcher(b10).matches()) {
                z10 = true;
                bool = Boolean.TRUE;
            } else if (f9621d.matcher(b10).matches()) {
                z10 = false;
                bool = Boolean.FALSE;
            } else {
                Log.w("Gservices", "attempt to read gservices key " + str + " (value \"" + b10 + "\") as boolean");
            }
        }
        synchronized (q6.class) {
            if (g10 == f9628k) {
                hashMap.put(str, bool);
                f9623f.remove(str);
            }
        }
        return z10;
    }

    private static Object g(ContentResolver contentResolver) {
        Object obj;
        synchronized (q6.class) {
            d(contentResolver);
            obj = f9628k;
        }
        return obj;
    }
}
