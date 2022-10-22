package qd;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
/* compiled from: PayAnalytics.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static volatile e f32945a;

    private e() {
    }

    private void a(String str, Map map) {
    }

    public static e b() {
        if (f32945a == null) {
            synchronized (e.class) {
                if (f32945a == null) {
                    f32945a = new e();
                }
            }
        }
        return f32945a;
    }

    private void c(String str, long j10, Map map) {
    }

    private void h(String str, String str2, Map map) {
    }

    public void d(String str, String str2, Map map) {
        if (!TextUtils.isEmpty(str)) {
            if (map == null) {
                map = new HashMap();
            }
            map.put("session_id", str);
            a(str2, map);
        }
    }

    public void e(String str, String str2, long j10, Map map) {
        if (!TextUtils.isEmpty(str)) {
            if (map == null) {
                map = new HashMap();
            }
            map.put("session_id", str);
            c(str2, j10, map);
        }
    }

    public void f(String str, String str2, String str3, Map map) {
        if (!TextUtils.isEmpty(str)) {
            if (map == null) {
                map = new HashMap();
            }
            map.put("session_id", str);
            h(str2, str3, map);
        }
    }

    public void g(String str, String str2, Map map) {
        f(str, str2, null, map);
    }
}
