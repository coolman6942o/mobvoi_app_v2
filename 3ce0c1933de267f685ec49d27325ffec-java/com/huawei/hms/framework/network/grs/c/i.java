package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.os.SystemClock;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.d.a.a;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;
/* loaded from: classes.dex */
public class i extends b implements Callable<f> {

    /* renamed from: h  reason: collision with root package name */
    private static final String f13917h = "i";

    public i(String str, int i10, a aVar, Context context, String str2, GrsBaseInfo grsBaseInfo) {
        super(str, i10, aVar, context, str2, grsBaseInfo);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b3  */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f call() {
        long j10;
        long j11;
        long j12;
        IOException e10;
        long elapsedRealtime;
        HttpsURLConnection a10;
        byte[] bArr;
        String str = f13917h;
        Logger.i(str, "Get call execute");
        long j13 = 0;
        try {
            elapsedRealtime = SystemClock.elapsedRealtime();
        } catch (IOException e11) {
            e10 = e11;
            j12 = 0;
        }
        try {
            j11 = System.currentTimeMillis();
            a10 = a.a(c(), b(), e());
            bArr = null;
        } catch (IOException e12) {
            e10 = e12;
            j13 = elapsedRealtime;
            j12 = 0;
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            j10 = System.currentTimeMillis();
            Logger.w(f13917h, "RequestCallable run task catch IOException", e10);
            this.f13857a = new f(e10, elapsedRealtime2 - j13);
            j11 = j12;
            this.f13857a.a(c());
            this.f13857a.a(d());
            this.f13857a.b(j11);
            this.f13857a.a(j10);
            if (a() != null) {
            }
            return this.f13857a;
        }
        if (a10 == null) {
            Logger.w(str, "create HttpsURLConnection instance by url return null.");
            return null;
        }
        a10.setRequestMethod("GET");
        a10.connect();
        int responseCode = a10.getResponseCode();
        if (responseCode == 200) {
            InputStream inputStream = a10.getInputStream();
            bArr = IoUtils.toByteArray(inputStream);
            IoUtils.closeSecure(inputStream);
        }
        Map headerFields = a10.getHeaderFields();
        a10.disconnect();
        long elapsedRealtime3 = SystemClock.elapsedRealtime();
        j10 = System.currentTimeMillis();
        this.f13857a = new f(responseCode, headerFields, bArr == null ? new byte[0] : bArr, elapsedRealtime3 - elapsedRealtime);
        this.f13857a.a(c());
        this.f13857a.a(d());
        this.f13857a.b(j11);
        this.f13857a.a(j10);
        if (a() != null) {
            a().a(this.f13857a);
        }
        return this.f13857a;
    }
}
