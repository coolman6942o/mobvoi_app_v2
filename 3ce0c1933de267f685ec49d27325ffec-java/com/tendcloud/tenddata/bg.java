package com.tendcloud.tenddata;

import com.tendcloud.tenddata.bh;
import com.tendcloud.tenddata.zz;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.UUID;
/* compiled from: td */
/* loaded from: classes2.dex */
public class bg {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bg f22728a;

    static {
        try {
            v.a().register(a());
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    private bg() {
    }

    private final void b(HashMap<String, Object> hashMap) {
        try {
            a aVar = (a) hashMap.get("service");
            long parseLong = Long.parseLong(String.valueOf(hashMap.get("occurTime")));
            if (hashMap.containsKey("sessionEnd")) {
                a(aVar);
                return;
            }
            if (hashMap.containsKey("pageName")) {
                h.setLastActivity(String.valueOf(hashMap.get("pageName")));
            }
            b(aVar);
            h.c(parseLong, aVar);
            ab.H = null;
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    public final void onTDEBEventSession(zz.a aVar) {
        HashMap<String, Object> hashMap;
        if (aVar != null && (hashMap = aVar.paraMap) != null) {
            try {
                int parseInt = Integer.parseInt(String.valueOf(hashMap.get("apiType")));
                if (parseInt == 10) {
                    a(aVar.paraMap);
                } else if (parseInt == 11) {
                    b(aVar.paraMap);
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
    }

    private final void a(HashMap<String, Object> hashMap) {
        try {
            a aVar = (a) hashMap.get("service");
            long parseLong = Long.parseLong(String.valueOf(hashMap.get("occurTime")));
            long c10 = h.c(aVar);
            long f10 = h.f(aVar);
            if (f10 <= c10) {
                f10 = c10;
            }
            if (parseLong - f10 > ab.Y) {
                a(aVar);
                a(parseLong, aVar);
                h.setLastActivity("");
            } else {
                String a10 = h.a(aVar);
                if (a10 == null) {
                    a(parseLong, aVar);
                    h.setLastActivity("");
                } else {
                    g.iForDeveloper("[" + aVar.name() + "][Session] - Same session as before! Session id is " + a10);
                    cc.a().setSessionId(a10);
                    cc.a().setSessionStartTime(c10);
                }
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(a aVar) {
        bh bhVar = new bh();
        bhVar.f22729a = aVar;
        bhVar.f22730b = bh.a.IMMEDIATELY;
        v.a().post(bhVar);
    }

    private void a(final a aVar) {
        try {
            String a10 = h.a(aVar);
            if (a10 != null && !a10.trim().isEmpty()) {
                long c10 = h.c(aVar);
                long f10 = h.f(aVar) - c10;
                if ((aVar.name().equals("APP") || aVar.name().equals("APP_SQL") || aVar.name().equals("TRACKING") || aVar.name().equals("SDK")) && f10 < 500) {
                    f10 = -1000;
                }
                bi biVar = new bi();
                biVar.f22732b = "session";
                biVar.f22733c = "end";
                TreeMap treeMap = new TreeMap();
                treeMap.put("sessionId", a10);
                treeMap.put("start", Long.valueOf(c10));
                treeMap.put("duration", Long.valueOf(f10 / 1000));
                biVar.f22734d = treeMap;
                biVar.f22731a = aVar;
                biVar.f22736f = new cb() { // from class: com.tendcloud.tenddata.bg.1
                    @Override // com.tendcloud.tenddata.cb
                    public void onStoreFailed() {
                    }

                    @Override // com.tendcloud.tenddata.cb
                    public void onStoreSuccess() {
                        try {
                            bg.this.b(aVar);
                        } catch (Throwable unused) {
                        }
                    }
                };
                v.a().post(biVar);
                h.a((String) null, aVar);
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    private void a(long j10, final a aVar) {
        try {
            g.iForDeveloper("[" + aVar.name() + "][Session] - New session!");
            String uuid = UUID.randomUUID().toString();
            g.iForDeveloper("[" + aVar.name() + "][Session] - Id: " + uuid);
            long f10 = h.f(aVar);
            long j11 = j10 - f10;
            if (0 == f10) {
                j11 = 0;
            }
            h.a(uuid, aVar);
            h.a(j10, aVar);
            h.b(uuid, aVar);
            cc.a().setSessionId(uuid);
            cc.a().setSessionStartTime(j10);
            bi biVar = new bi();
            biVar.f22732b = "session";
            biVar.f22733c = "begin";
            TreeMap treeMap = new TreeMap();
            treeMap.put("sessionId", uuid);
            treeMap.put("interval", Long.valueOf(j11 / 1000));
            biVar.f22734d = treeMap;
            biVar.f22731a = aVar;
            biVar.f22736f = new cb() { // from class: com.tendcloud.tenddata.bg.2
                @Override // com.tendcloud.tenddata.cb
                public void onStoreFailed() {
                }

                @Override // com.tendcloud.tenddata.cb
                public void onStoreSuccess() {
                    try {
                        bg.this.b(aVar);
                    } catch (Throwable unused) {
                    }
                }
            };
            v.a().post(biVar);
            ab.X.set(false);
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    public static bg a() {
        if (f22728a == null) {
            synchronized (bg.class) {
                if (f22728a == null) {
                    f22728a = new bg();
                }
            }
        }
        return f22728a;
    }
}
