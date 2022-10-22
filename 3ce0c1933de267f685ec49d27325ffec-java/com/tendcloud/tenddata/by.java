package com.tendcloud.tenddata;

import android.util.EventLogTags;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;
import org.json.JSONObject;
/* compiled from: td */
/* loaded from: classes2.dex */
public class by {

    /* renamed from: d  reason: collision with root package name */
    static byte[] f22777d;

    /* renamed from: a  reason: collision with root package name */
    static HashMap<String, String> f22774a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    static HashMap<String, String> f22775b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    static String f22776c = "utf-8";

    /* renamed from: e  reason: collision with root package name */
    private static volatile by f22778e = null;

    static {
        try {
            v.a().register(a());
        } catch (Throwable unused) {
        }
    }

    private by() {
        String c10 = u.c(ab.f22568h.getPackageName());
        if (ab.f22568h == null || c10 == null) {
            f22777d = ab.class.getSimpleName().getBytes();
        } else {
            f22777d = c10.getBytes();
        }
    }

    public TreeSet<bz> a(a aVar) {
        int size;
        Throwable th2;
        TreeSet treeSet = new TreeSet();
        TreeSet<bz> treeSet2 = null;
        try {
            treeSet2 = ca.a().a(aVar, 100, (String) null);
            if (treeSet2 != null && treeSet2.size() > 0) {
                Iterator<bz> it = treeSet2.iterator();
                while (it.hasNext()) {
                    bz next = it.next();
                    try {
                        next.writeData(u.b(next.c(), f22777d));
                    } catch (Throwable unused) {
                    }
                }
                treeSet.addAll(treeSet2);
                treeSet2.clear();
            }
            size = treeSet2 == null ? 0 : treeSet2.size();
        } catch (Throwable th3) {
            bf.postSDKError(th3);
        }
        synchronized (EventLogTags.class) {
            if (size < 100) {
                try {
                    TreeSet<bz> a10 = ca.a().a(aVar, 100 - size, aVar.getRootFolder());
                    if (a10 != null) {
                        try {
                            if (a10.size() > 0) {
                                Iterator<bz> it2 = a10.iterator();
                                while (it2.hasNext()) {
                                    bz next2 = it2.next();
                                    try {
                                        byte[] b10 = al.b(next2.c());
                                        if (!(b10 == null || b10.length == 0)) {
                                            next2.writeData(b10);
                                        }
                                    } catch (Throwable unused2) {
                                    }
                                }
                            }
                        } catch (Throwable th4) {
                            th2 = th4;
                            throw th2;
                        }
                    }
                    treeSet2 = a10;
                } catch (Throwable th5) {
                    th2 = th5;
                }
            }
            if (treeSet.size() > 0 && treeSet2 != null) {
                treeSet2.addAll(treeSet);
            }
            return treeSet2;
        }
    }

    public final synchronized void onTDEBEventDataStore(bi biVar) {
        if (biVar != null) {
            try {
                if (biVar.f22731a.getMessageFormat().equals(a.MF_JSON)) {
                    if (biVar.f22731a != null) {
                        ce ceVar = new ce(biVar.f22732b, biVar.f22733c);
                        ceVar.setData(biVar.f22734d);
                        JSONObject jSONObject = null;
                        if (!biVar.f22731a.name().equals("BG")) {
                            jSONObject = ct.a().a(ceVar, true, biVar.f22731a, biVar.f22735e);
                        }
                        if (jSONObject != null) {
                            ca.a().a(new bz(al.a(jSONObject.toString().getBytes())), biVar);
                        }
                    }
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
    }

    public void sendMessageFaild(a aVar) {
        try {
            ca.a().clearDataCache(aVar);
        } catch (Throwable unused) {
        }
    }

    public void sendMessageSuccess(a aVar) {
        try {
            ca.a().confirmRead(aVar);
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    public static by a() {
        if (f22778e == null) {
            synchronized (by.class) {
                if (f22778e == null) {
                    f22778e = new by();
                }
            }
        }
        return f22778e;
    }
}
