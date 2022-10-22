package sf;

import java.util.HashMap;
/* compiled from: DbDebugTools.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f34412a = false;

    /* renamed from: b  reason: collision with root package name */
    public static C0496a f34413b;

    /* compiled from: DbDebugTools.java */
    /* renamed from: sf.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0496a {

        /* renamed from: a  reason: collision with root package name */
        public String f34414a;

        /* renamed from: b  reason: collision with root package name */
        public String f34415b;

        /* renamed from: c  reason: collision with root package name */
        public String f34416c;

        public C0496a(String str, String str2, String str3, String str4) {
            this.f34414a = str;
            this.f34415b = str2;
            this.f34416c = str4;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("db_user", new C0496a("267717759c0ee45f92d3d48fe3767953", "29785153", "", ""));
        hashMap.put("not_login", new C0496a("", "", "", ""));
        hashMap.put("yc_oversea", new C0496a("9dfe8af14cb34286b51af6eed85d7b3c", "30180578", "", ""));
        hashMap.put("yc_cn", new C0496a("267717759c0ee45f92d3d48fe3767953", "29785153", "", ""));
        f34413b = (C0496a) hashMap.get("db_user");
    }

    public static String a() {
        return f34413b.f34415b;
    }

    public static String b() {
        return f34413b.f34416c;
    }

    public static String c() {
        return f34413b.f34414a;
    }

    public static boolean d() {
        return f34412a;
    }
}
