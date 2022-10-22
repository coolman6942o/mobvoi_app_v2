package com.tendcloud.tenddata;

import java.net.InetAddress;
import java.net.URL;
import java.util.HashMap;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class ad {

    /* renamed from: a  reason: collision with root package name */
    private static volatile HashMap<String, ad> f22588a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static final String f22589b = "TD_IP_CACHE";

    /* renamed from: c  reason: collision with root package name */
    private String f22590c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f22591d = null;

    /* renamed from: e  reason: collision with root package name */
    private String f22592e = null;

    /* renamed from: f  reason: collision with root package name */
    private String f22593f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f22594g = null;

    /* compiled from: td */
    /* loaded from: classes2.dex */
    public static class a {
        static final int resolvedIp = 1;
        static final int savedIp = 3;
        static final int staticIp = 4;
        static final int successIp = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static URL a(URL url, String str) {
        return m.b() ? url : new URL(url.getProtocol(), str, url.getPort(), url.getFile());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void b(String str, String str2) {
        synchronized (ad.class) {
            if (!u.b(str) && !f22588a.containsKey(str)) {
                if (f22588a != null) {
                    try {
                        ad adVar = new ad();
                        adVar.f22594g = str;
                        adVar.f22590c = str2;
                        adVar.f22592e = o.b(ab.f22568h, f22589b, u.e(str), (String) null);
                        adVar.f22591d = b(adVar.f22594g);
                        f22588a.put(adVar.f22594g, adVar);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str) {
        String a10 = a(str, 1);
        if (a10 != null && !a10.equalsIgnoreCase(a(str, 3)) && ab.f22568h != null) {
            o.a(ab.f22568h, f22589b, u.e(str), a(str, 1));
            a(str, a(str, 1), 3);
        }
    }

    static void a(String str, String str2) {
        if (ab.f22568h != null) {
            o.a(ab.f22568h, f22589b, u.e(str), str2);
            a(str, str2, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        try {
            return InetAddress.getByName(str).getHostAddress();
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(String str, String str2, int i10) {
        synchronized (ad.class) {
            if (!u.b(str) && f22588a.containsKey(str)) {
                if (f22588a != null) {
                    ad adVar = f22588a.get(str);
                    if (i10 == 1) {
                        adVar.f22591d = str2;
                    } else if (i10 == 2) {
                        adVar.f22593f = str2;
                    } else if (i10 == 3) {
                        adVar.f22592e = str2;
                    } else if (i10 == 4) {
                        adVar.f22590c = str2;
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized String a(String str, int i10) {
        synchronized (ad.class) {
            if (!u.b(str) && f22588a.containsKey(str)) {
                if (f22588a == null) {
                    return null;
                }
                ad adVar = f22588a.get(str);
                if (adVar == null) {
                    return null;
                }
                if (i10 == 1) {
                    return adVar.f22591d;
                } else if (i10 == 2) {
                    return adVar.f22593f;
                } else if (i10 == 3) {
                    return adVar.f22592e;
                } else if (i10 != 4) {
                    return null;
                } else {
                    return adVar.f22590c;
                }
            }
            return null;
        }
    }
}
