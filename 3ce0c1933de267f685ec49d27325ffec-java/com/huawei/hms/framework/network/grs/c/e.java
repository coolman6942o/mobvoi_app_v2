package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.b.b;
import com.huawei.hms.framework.network.grs.c.b.c;
import com.huawei.hms.framework.network.grs.c.b.d;
import com.huawei.hms.framework.network.grs.d.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
/* loaded from: classes.dex */
public class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13883a = "e";

    /* renamed from: b  reason: collision with root package name */
    private GrsBaseInfo f13884b;

    /* renamed from: c  reason: collision with root package name */
    private Context f13885c;

    /* renamed from: d  reason: collision with root package name */
    private a f13886d;

    /* renamed from: e  reason: collision with root package name */
    private f f13887e;

    /* renamed from: k  reason: collision with root package name */
    private d f13893k;

    /* renamed from: l  reason: collision with root package name */
    private c f13894l;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList<Future<f>> f13888f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<f> f13889g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private JSONArray f13890h = new JSONArray();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<String> f13891i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<String> f13892j = new ArrayList<>();

    /* renamed from: m  reason: collision with root package name */
    private long f13895m = 1;

    public e(c cVar, a aVar) {
        this.f13894l = cVar;
        this.f13884b = cVar.b();
        this.f13885c = cVar.a();
        this.f13886d = aVar;
        b();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008f A[LOOP:0: B:3:0x0005->B:33:0x008f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0087 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private f a(ExecutorService executorService, ArrayList<String> arrayList, String str) {
        ExecutionException e10;
        InterruptedException e11;
        f fVar;
        f fVar2 = null;
        int i10 = 0;
        while (true) {
            if (i10 >= arrayList.size()) {
                break;
            }
            String str2 = arrayList.get(i10);
            boolean z10 = true;
            if (!TextUtils.isEmpty(str2)) {
                Future<f> submit = executorService.submit(new b(str2, i10, this, this.f13885c, str, this.f13884b).a(this.f13894l));
                this.f13888f.add(submit);
                try {
                    fVar = submit.get(this.f13895m, TimeUnit.SECONDS);
                } catch (InterruptedException e12) {
                    e11 = e12;
                } catch (CancellationException unused) {
                } catch (ExecutionException e13) {
                    e10 = e13;
                } catch (TimeoutException unused2) {
                }
                if (fVar != null) {
                    try {
                    } catch (InterruptedException e14) {
                        e11 = e14;
                        fVar2 = fVar;
                        Logger.w(f13883a, "the current thread was interrupted while waiting", e11);
                        if (z10) {
                        }
                    } catch (CancellationException unused3) {
                        fVar2 = fVar;
                        Logger.i(f13883a, "{requestServer} the computation was cancelled");
                        if (z10) {
                        }
                    } catch (ExecutionException e15) {
                        e10 = e15;
                        fVar2 = fVar;
                        Logger.w(f13883a, "the computation threw an ExecutionException", e10);
                        z10 = false;
                        if (z10) {
                        }
                    } catch (TimeoutException unused4) {
                        fVar2 = fVar;
                        Logger.w(f13883a, "the wait timed out");
                        z10 = false;
                        if (z10) {
                        }
                    }
                    if (fVar.m()) {
                        Logger.i(f13883a, "grs request return body is not null and is OK.");
                        fVar2 = fVar;
                        if (z10) {
                            Logger.v(f13883a, "needBreak is true so need break current circulation");
                            break;
                        }
                        i10++;
                    }
                }
                z10 = false;
                fVar2 = fVar;
                if (z10) {
                }
            }
            z10 = false;
            if (z10) {
            }
        }
        return b(fVar2);
    }

    private f b(f fVar) {
        String str;
        String str2;
        Throwable e10;
        int size = this.f13888f.size();
        for (int i10 = 0; i10 < size && (fVar == null || !fVar.m()); i10++) {
            try {
                fVar = this.f13888f.get(i10).get(40000L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e11) {
                e10 = e11;
                str2 = f13883a;
                str = "{checkResponse} when check result, find InterruptedException, check others";
                Logger.w(str2, str, e10);
            } catch (CancellationException unused) {
                Logger.i(f13883a, "{checkResponse} when check result, find CancellationException, check others");
            } catch (ExecutionException e12) {
                e10 = e12;
                str2 = f13883a;
                str = "{checkResponse} when check result, find ExecutionException, check others";
                Logger.w(str2, str, e10);
            } catch (TimeoutException unused2) {
                Logger.w(f13883a, "{checkResponse} when check result, find TimeoutException, cancel current request task");
                if (!this.f13888f.get(i10).isCancelled()) {
                    this.f13888f.get(i10).cancel(true);
                }
            }
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f b(ExecutorService executorService, String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        f a10 = a(executorService, this.f13892j, str);
        int b10 = a10 == null ? 0 : a10.b();
        String str2 = f13883a;
        Logger.v(str2, "use 2.0 interface return http's code is：{%s}", Integer.valueOf(b10));
        if (b10 == 404 || b10 == 401) {
            if (!TextUtils.isEmpty(c()) || !TextUtils.isEmpty(this.f13884b.getAppName())) {
                this.f13888f.clear();
                Logger.i(str2, "this env has not deploy new interface,so use old interface.");
                a10 = a(executorService, this.f13891i, str);
            } else {
                Logger.i(str2, "request grs server use 1.0 API must set appName,please check.");
                return null;
            }
        }
        h.a(this.f13889g, SystemClock.elapsedRealtime() - elapsedRealtime, this.f13890h, this.f13885c);
        return a10;
    }

    private void b() {
        d a10 = com.huawei.hms.framework.network.grs.c.a.a.a(this.f13885c);
        if (a10 == null) {
            Logger.w(f13883a, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        a(a10);
        List<String> a11 = a10.a();
        if (a11 == null || a11.size() <= 0) {
            Logger.v(f13883a, "maybe grs_base_url config with [],please check.");
        } else if (a11.size() <= 10) {
            String c10 = a10.c();
            String b10 = a10.b();
            if (a11.size() > 0) {
                for (String str : a11) {
                    if (!str.startsWith("https://")) {
                        Logger.w(f13883a, "grs server just support https scheme url,please check.");
                    } else {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(str);
                        Locale locale = Locale.ROOT;
                        Object[] objArr = new Object[1];
                        objArr[0] = TextUtils.isEmpty(c()) ? this.f13884b.getAppName() : c();
                        sb2.append(String.format(locale, c10, objArr));
                        String grsReqParamJoint = this.f13884b.getGrsReqParamJoint(false, false, "1.0", this.f13885c);
                        if (!TextUtils.isEmpty(grsReqParamJoint)) {
                            sb2.append("?");
                            sb2.append(grsReqParamJoint);
                        }
                        this.f13891i.add(sb2.toString());
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(str);
                        sb3.append(b10);
                        String grsReqParamJoint2 = this.f13884b.getGrsReqParamJoint(false, false, c(), this.f13885c);
                        if (!TextUtils.isEmpty(grsReqParamJoint2)) {
                            sb3.append("?");
                            sb3.append(grsReqParamJoint2);
                        }
                        this.f13892j.add(sb3.toString());
                    }
                }
            }
            Logger.v(f13883a, "request to GRS server url is{%s} and {%s}", this.f13891i, this.f13892j);
        } else {
            throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
        }
    }

    private String c() {
        b a10 = b.a(this.f13885c.getPackageName(), this.f13884b);
        com.huawei.hms.framework.network.grs.local.model.a a11 = a10 != null ? a10.a() : null;
        if (a11 == null) {
            return "";
        }
        String a12 = a11.a();
        Logger.v(f13883a, "get appName from local assets is{%s}", a12);
        return a12;
    }

    public d a() {
        return this.f13893k;
    }

    public f a(ExecutorService executorService, String str) {
        String str2;
        Throwable e10;
        String str3;
        if (this.f13891i == null || this.f13892j == null) {
            return null;
        }
        try {
            d a10 = a();
            return (f) executorService.submit(new d(this, executorService, str)).get(a10 != null ? a10.d() : 10, TimeUnit.SECONDS);
        } catch (InterruptedException e11) {
            e10 = e11;
            str2 = f13883a;
            str3 = "{submitExcutorTaskWithTimeout} the current thread was interrupted while waiting";
            Logger.w(str2, str3, e10);
            return null;
        } catch (CancellationException unused) {
            Logger.i(f13883a, "{submitExcutorTaskWithTimeout} the computation was cancelled");
            return null;
        } catch (ExecutionException e12) {
            e10 = e12;
            str2 = f13883a;
            str3 = "{submitExcutorTaskWithTimeout} the computation threw an ExecutionException";
            Logger.w(str2, str3, e10);
            return null;
        } catch (TimeoutException unused2) {
            Logger.w(f13883a, "{submitExcutorTaskWithTimeout} the wait timed out");
            return null;
        } catch (Exception e13) {
            e10 = e13;
            str2 = f13883a;
            str3 = "{submitExcutorTaskWithTimeout} catch Exception";
            Logger.w(str2, str3, e10);
            return null;
        }
    }

    public void a(d dVar) {
        this.f13893k = dVar;
    }

    @Override // com.huawei.hms.framework.network.grs.c.a
    public synchronized void a(f fVar) {
        this.f13889g.add(fVar);
        f fVar2 = this.f13887e;
        if (fVar2 == null || !fVar2.m()) {
            if (fVar.l()) {
                Logger.i(f13883a, "GRS server open 503 limiting strategy.");
                com.huawei.hms.framework.network.grs.d.d.a(this.f13884b.getGrsParasKey(false, true, this.f13885c), new d.a(fVar.j(), SystemClock.elapsedRealtime()));
            } else if (!fVar.m()) {
                Logger.v(f13883a, "grsResponseResult has exception so need return");
            } else {
                this.f13887e = fVar;
                this.f13886d.a(this.f13884b, fVar, this.f13885c, this.f13894l);
                for (int i10 = 0; i10 < this.f13888f.size(); i10++) {
                    if (!this.f13891i.get(i10).equals(fVar.k()) && !this.f13892j.get(i10).equals(fVar.k()) && !this.f13888f.get(i10).isCancelled()) {
                        Logger.i(f13883a, "future cancel");
                        this.f13888f.get(i10).cancel(true);
                    }
                }
            }
        } else {
            Logger.v(f13883a, "grsResponseResult is ok");
        }
    }
}
