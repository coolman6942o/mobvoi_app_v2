package com.tendcloud.tenddata;

import com.mobvoi.wear.common.base.Constants;
import com.mobvoi.wear.contacts.ContactConstant;
import com.tendcloud.tenddata.zz;
import java.util.HashMap;
import java.util.TreeMap;
/* compiled from: td */
/* loaded from: classes2.dex */
public class be {

    /* renamed from: a  reason: collision with root package name */
    private static volatile be f22726a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, Object> f22727b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: td */
    /* loaded from: classes2.dex */
    public final class a {
        private String pageName;
        private String refer;
        private long startTime;

        private String getPageName() {
            return this.pageName;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getRefer() {
            return this.refer;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long getStartTime() {
            return this.startTime;
        }

        public String toString() {
            return "pageName: " + this.pageName + "\nfrom: " + this.refer + "\nstartTime: " + this.startTime;
        }

        private a(long j10, String str, String str2) {
            this.startTime = 0L;
            this.refer = "";
            this.pageName = "";
            this.startTime = j10;
            this.refer = str;
            this.pageName = str2;
        }
    }

    static {
        try {
            v.a().register(a());
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    private be() {
    }

    public static be a() {
        if (f22726a == null) {
            synchronized (bg.class) {
                if (f22726a == null) {
                    f22726a = new be();
                }
            }
        }
        return f22726a;
    }

    public final void onTDEBEventPage(zz.a aVar) {
        if (aVar != null) {
            try {
                HashMap<String, Object> hashMap = aVar.paraMap;
                if (hashMap != null) {
                    int parseInt = Integer.parseInt(String.valueOf(hashMap.get("apiType")));
                    if ((parseInt == 4 || parseInt == 5) && !String.valueOf(aVar.paraMap.get("occurTime")).trim().isEmpty()) {
                        a(aVar.paraMap);
                    }
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
    }

    private void a(HashMap<String, Object> hashMap) {
        try {
            int parseInt = Integer.parseInt(String.valueOf(hashMap.get("apiType")));
            com.tendcloud.tenddata.a aVar = (com.tendcloud.tenddata.a) hashMap.get("service");
            if (parseInt == 4) {
                String str = ab.H;
                if (str == null) {
                    str = h.d();
                }
                a(Long.parseLong(String.valueOf(hashMap.get("occurTime"))), String.valueOf(hashMap.get("pageName")), str, aVar);
            } else if (parseInt == 5) {
                a(String.valueOf(hashMap.get("pageName")), aVar);
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0045 A[Catch: all -> 0x009c, TRY_LEAVE, TryCatch #0 {all -> 0x009c, blocks: (B:7:0x0010, B:9:0x0016, B:10:0x0031, B:12:0x0045), top: B:16:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void a(long j10, String str, String str2, com.tendcloud.tenddata.a aVar) {
        zz.f23041c = true;
        if (!this.f22727b.containsKey(str)) {
            if (str2 != null) {
                try {
                    if (!str2.isEmpty()) {
                        g.iForDeveloper("onPageBegin being called!  pagename: " + str + ", refer: " + str2);
                        if (str == null) {
                            a aVar2 = new a(j10, str2, str);
                            this.f22727b.put(str, aVar2);
                            bi biVar = new bi();
                            biVar.f22732b = "page";
                            biVar.f22733c = "enter";
                            TreeMap treeMap = new TreeMap();
                            treeMap.put("startTime", Long.valueOf(aVar2.startTime));
                            treeMap.put("duration", 0);
                            treeMap.put(ContactConstant.CallsRecordKeys.NAME, aVar2.pageName);
                            treeMap.put(Constants.WatchfaceMarket.MARKET_ENTER_FROM, aVar2.refer);
                            biVar.f22734d = treeMap;
                            biVar.f22731a = aVar;
                            v.a().post(biVar);
                            return;
                        }
                        return;
                    }
                } catch (Throwable th2) {
                    bf.postSDKError(th2);
                    return;
                }
            }
            g.iForDeveloper("onPageBegin being called!  pagename: " + str);
            if (str == null) {
            }
        }
    }

    private final void a(String str, com.tendcloud.tenddata.a aVar) {
        if (this.f22727b.containsKey(str)) {
            try {
                g.iForDeveloper("onPageEnd being called! pageName: " + str);
                a aVar2 = (a) this.f22727b.remove(str);
                if (aVar2 != null) {
                    bi biVar = new bi();
                    biVar.f22732b = "page";
                    biVar.f22733c = "leave";
                    double currentTimeMillis = (System.currentTimeMillis() - aVar2.getStartTime()) / 1000.0d;
                    long round = Math.round(currentTimeMillis);
                    TreeMap treeMap = new TreeMap();
                    treeMap.put("startTime", Long.valueOf(aVar2.getStartTime()));
                    treeMap.put(ContactConstant.CallsRecordKeys.NAME, str);
                    treeMap.put(Constants.WatchfaceMarket.MARKET_ENTER_FROM, aVar2.getRefer());
                    treeMap.put("duration", Long.valueOf(round));
                    treeMap.put("duration", Long.valueOf((long) Math.ceil(currentTimeMillis)));
                    biVar.f22734d = treeMap;
                    biVar.f22731a = aVar;
                    v.a().post(biVar);
                }
                if (ab.G) {
                    h.setLastActivity(str);
                }
                ab.H = str;
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
    }
}
