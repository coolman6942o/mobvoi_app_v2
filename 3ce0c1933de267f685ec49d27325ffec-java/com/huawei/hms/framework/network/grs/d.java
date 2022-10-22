package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.a.c;
import com.huawei.hms.framework.network.grs.c.m;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13932a = "d";

    /* renamed from: b  reason: collision with root package name */
    private static ExecutorService f13933b = ExecutorsUtils.newCachedThreadPool("GRS_GrsClient-Init");

    /* renamed from: c  reason: collision with root package name */
    private GrsBaseInfo f13934c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13935d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f13936e;

    /* renamed from: f  reason: collision with root package name */
    private Context f13937f;

    /* renamed from: g  reason: collision with root package name */
    private m f13938g;

    /* renamed from: h  reason: collision with root package name */
    private a f13939h;

    /* renamed from: i  reason: collision with root package name */
    private c f13940i;

    /* renamed from: j  reason: collision with root package name */
    private a f13941j;

    /* renamed from: k  reason: collision with root package name */
    private Future<Boolean> f13942k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(Context context, GrsBaseInfo grsBaseInfo) {
        this.f13935d = false;
        Object obj = new Object();
        this.f13936e = obj;
        this.f13937f = context.getApplicationContext();
        a(grsBaseInfo);
        if (!this.f13935d) {
            synchronized (obj) {
                if (!this.f13935d) {
                    GrsBaseInfo grsBaseInfo2 = this.f13934c;
                    this.f13942k = f13933b.submit(new c(this, this.f13937f, grsBaseInfo2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(GrsBaseInfo grsBaseInfo) {
        this.f13935d = false;
        this.f13936e = new Object();
        a(grsBaseInfo);
    }

    private void a(GrsBaseInfo grsBaseInfo) {
        try {
            this.f13934c = grsBaseInfo.clone();
        } catch (CloneNotSupportedException e10) {
            Logger.w(f13932a, "GrsClient catch CloneNotSupportedException", e10);
            this.f13934c = grsBaseInfo.copy();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, ?> map) {
        if (map == null || map.isEmpty()) {
            Logger.v(f13932a, "sp's content is empty.");
            return;
        }
        for (String str : map.keySet()) {
            if (str.endsWith("time")) {
                String a10 = this.f13940i.a(str, "");
                long j10 = 0;
                if (!TextUtils.isEmpty(a10) && a10.matches("\\d+")) {
                    try {
                        j10 = Long.parseLong(a10);
                    } catch (NumberFormatException e10) {
                        Logger.w(f13932a, "convert expire time from String to Long catch NumberFormatException.", e10);
                    }
                }
                if (!a(j10)) {
                    Logger.i(f13932a, "init interface auto clear some invalid sp's data.");
                    this.f13940i.a(str.substring(0, str.length() - 4));
                    this.f13940i.a(str);
                }
            }
        }
    }

    private boolean a(long j10) {
        return System.currentTimeMillis() - j10 <= 604800000;
    }

    private boolean c() {
        try {
            Future<Boolean> future = this.f13942k;
            if (future != null) {
                return future.get(10L, TimeUnit.SECONDS).booleanValue();
            }
            return false;
        } catch (InterruptedException e10) {
            Logger.w(f13932a, "init compute task interrupted.", e10);
            return false;
        } catch (CancellationException unused) {
            Logger.i(f13932a, "init compute task canceled.");
            return false;
        } catch (ExecutionException e11) {
            Logger.w(f13932a, "init compute task failed.", e11);
            return false;
        } catch (TimeoutException unused2) {
            Logger.w(f13932a, "init compute task timed out");
            return false;
        } catch (Exception e12) {
            Logger.w(f13932a, "init compute task occur unknown Exception", e12);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str, String str2) {
        if (this.f13934c == null || str == null || str2 == null) {
            Logger.w(f13932a, "invalid para!");
            return null;
        } else if (c()) {
            return this.f13941j.a(str, str2, this.f13937f);
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, String> a(String str) {
        if (this.f13934c != null && str != null) {
            return c() ? this.f13941j.a(str, this.f13937f) : new HashMap();
        }
        Logger.w(f13932a, "invalid para!");
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        if (c()) {
            String grsParasKey = this.f13934c.getGrsParasKey(false, true, this.f13937f);
            this.f13940i.a(grsParasKey);
            c cVar = this.f13940i;
            cVar.a(grsParasKey + "time");
            this.f13938g.a(grsParasKey);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, IQueryUrlsCallBack iQueryUrlsCallBack) {
        if (iQueryUrlsCallBack == null) {
            Logger.w(f13932a, "IQueryUrlsCallBack is must not null for process continue.");
        } else if (this.f13934c == null || str == null) {
            iQueryUrlsCallBack.onCallBackFail(-6);
        } else if (c()) {
            this.f13941j.a(str, iQueryUrlsCallBack, this.f13937f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2, IQueryUrlCallBack iQueryUrlCallBack) {
        if (iQueryUrlCallBack == null) {
            Logger.w(f13932a, "IQueryUrlCallBack is must not null for process continue.");
        } else if (this.f13934c == null || str == null || str2 == null) {
            iQueryUrlCallBack.onCallBackFail(-6);
        } else if (c()) {
            this.f13941j.a(str, str2, iQueryUrlCallBack, this.f13937f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass() || !(obj instanceof d)) {
            return false;
        }
        return this.f13934c.compare(((d) obj).f13934c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        GrsBaseInfo grsBaseInfo;
        Context context;
        if (!c() || (grsBaseInfo = this.f13934c) == null || (context = this.f13937f) == null) {
            return false;
        }
        this.f13939h.a(grsBaseInfo, context);
        return true;
    }
}
