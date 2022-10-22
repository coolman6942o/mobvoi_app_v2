package qk;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: DeviceServer.java */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    private static volatile b f33236c;

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, qk.a> f33237a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Comparator<String> f33238b = new a(this);

    /* compiled from: DeviceServer.java */
    /* loaded from: classes2.dex */
    class a implements Comparator<String> {
        a(b bVar) {
        }

        private int b(String str) {
            if (TextUtils.equals("ticlite_mcu", str) || TextUtils.equals("android_wear", str)) {
                return 1;
            }
            return TextUtils.equals("tic_care", str) ? 6 : 4;
        }

        /* renamed from: a */
        public int compare(String str, String str2) {
            return b(str) - b(str2);
        }
    }

    private b() {
    }

    public static b g() {
        if (f33236c == null) {
            synchronized (b.class) {
                if (f33236c == null) {
                    f33236c = new b();
                }
            }
        }
        return f33236c;
    }

    public void a(String str, qk.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(str)) {
            this.f33237a.put(str, aVar);
        }
    }

    public List<qk.a> b() {
        ArrayList arrayList = new ArrayList();
        if (this.f33237a.size() > 0) {
            ArrayList<String> arrayList2 = new ArrayList(this.f33237a.keySet());
            Collections.sort(arrayList2, this.f33238b);
            for (String str : arrayList2) {
                arrayList.add(this.f33237a.get(str));
            }
        }
        return arrayList;
    }

    public List<rk.a> c() {
        return d(false);
    }

    public List<rk.a> d(boolean z10) {
        List<qk.a> b10 = b();
        ArrayList arrayList = new ArrayList();
        if (b10 != null && !b10.isEmpty()) {
            for (int i10 = 0; i10 < b10.size(); i10++) {
                qk.a aVar = b10.get(i10);
                if (!(aVar == null || aVar.b() == null || (z10 && !aVar.e()))) {
                    arrayList.add(aVar.b());
                }
            }
        }
        return arrayList;
    }

    public Map<String, qk.a> e() {
        return this.f33237a;
    }

    public qk.a f(String str) {
        if (!TextUtils.isEmpty(str)) {
            return this.f33237a.get(str);
        }
        return null;
    }

    public boolean h(String str) {
        return this.f33237a.containsKey(str);
    }
}
