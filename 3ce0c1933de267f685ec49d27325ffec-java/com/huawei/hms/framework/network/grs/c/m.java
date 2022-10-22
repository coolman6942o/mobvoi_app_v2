package com.huawei.hms.framework.network.grs.c;

import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.c.b.b;
import com.huawei.hms.framework.network.grs.c.b.c;
import com.huawei.hms.framework.network.grs.d.d;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private ExecutorService f13928a = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");

    /* renamed from: b  reason: collision with root package name */
    private Map<String, b> f13929b = new ConcurrentHashMap(16);

    /* renamed from: c  reason: collision with root package name */
    private final Object f13930c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private a f13931d;

    /* JADX INFO: Access modifiers changed from: private */
    public void a(f fVar, com.huawei.hms.framework.network.grs.b bVar) {
        if (bVar == null) {
            return;
        }
        if (fVar == null) {
            Logger.v("RequestController", "GrsResponse is null");
            bVar.a();
            return;
        }
        Logger.v("RequestController", "GrsResponse is not null");
        bVar.a(fVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
        if (r2.a() != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006e, code lost:
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f a(c cVar, String str) {
        Future<f> future;
        String str2;
        Throwable e10;
        String str3;
        Logger.d("RequestController", "request to server with service name is: " + str);
        String grsParasTag = cVar.b().getGrsParasTag(false, true, cVar.a());
        Logger.v("RequestController", "request spUrlKey: " + grsParasTag);
        synchronized (this.f13930c) {
            if (!NetworkUtil.isNetworkAvailable(cVar.a())) {
                return null;
            }
            d.a a10 = d.a(grsParasTag);
            b bVar = this.f13929b.get(grsParasTag);
            try {
                if (bVar != null && bVar.b()) {
                    future = bVar.a();
                    return future.get();
                }
                return future.get();
            } catch (InterruptedException e11) {
                e10 = e11;
                str2 = "RequestController";
                str3 = "when check result, find InterruptedException, check others";
                Logger.w(str2, str3, e10);
                return null;
            } catch (CancellationException e12) {
                e10 = e12;
                str2 = "RequestController";
                str3 = "when check result, find CancellationException, check others";
                Logger.w(str2, str3, e10);
                return null;
            } catch (ExecutionException e13) {
                e10 = e13;
                str2 = "RequestController";
                str3 = "when check result, find ExecutionException, check others";
                Logger.w(str2, str3, e10);
                return null;
            }
            Logger.i("RequestController", "hitGrsRequestBean == null or request block is released.");
            future = this.f13928a.submit(new k(this, cVar, str));
            this.f13929b.put(grsParasTag, new b(future));
        }
    }

    public void a(a aVar) {
        this.f13931d = aVar;
    }

    public void a(c cVar, com.huawei.hms.framework.network.grs.b bVar, String str) {
        this.f13928a.execute(new l(this, cVar, str, bVar));
    }

    public void a(String str) {
        synchronized (this.f13930c) {
            this.f13929b.remove(str);
        }
    }
}
