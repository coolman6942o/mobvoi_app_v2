package com.huawei.hms.framework.network.grs.c;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.unionpay.tsmservice.data.Constant;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f13896a = "f";

    /* renamed from: b  reason: collision with root package name */
    private Map<String, List<String>> f13897b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f13898c;

    /* renamed from: d  reason: collision with root package name */
    private int f13899d;

    /* renamed from: e  reason: collision with root package name */
    private long f13900e;

    /* renamed from: f  reason: collision with root package name */
    private long f13901f;

    /* renamed from: g  reason: collision with root package name */
    private long f13902g;

    /* renamed from: h  reason: collision with root package name */
    private String f13903h;

    /* renamed from: i  reason: collision with root package name */
    private int f13904i;

    /* renamed from: j  reason: collision with root package name */
    private int f13905j;

    /* renamed from: k  reason: collision with root package name */
    private String f13906k;

    /* renamed from: l  reason: collision with root package name */
    private String f13907l;

    /* renamed from: m  reason: collision with root package name */
    private String f13908m;

    /* renamed from: n  reason: collision with root package name */
    private long f13909n;

    /* renamed from: o  reason: collision with root package name */
    private Exception f13910o;

    /* renamed from: p  reason: collision with root package name */
    private String f13911p;

    /* renamed from: q  reason: collision with root package name */
    private int f13912q;

    public f(int i10, Map<String, List<String>> map, byte[] bArr, long j10) {
        this.f13899d = 0;
        this.f13904i = 2;
        this.f13905j = 9001;
        this.f13906k = "";
        this.f13907l = "";
        this.f13908m = "";
        this.f13909n = 0L;
        this.f13899d = i10;
        this.f13897b = map;
        this.f13898c = ByteBuffer.wrap(bArr).array();
        this.f13900e = j10;
        q();
    }

    public f(Exception exc, long j10) {
        this.f13899d = 0;
        this.f13904i = 2;
        this.f13905j = 9001;
        this.f13906k = "";
        this.f13907l = "";
        this.f13908m = "";
        this.f13909n = 0L;
        this.f13910o = exc;
        this.f13900e = j10;
    }

    private void a(Map<String, String> map) {
        long j10;
        NumberFormatException e10;
        if (map == null || map.size() <= 0) {
            Logger.w(f13896a, "getExpireTime {headers == null} or {headers.size() <= 0}");
            return;
        }
        if (map.containsKey("Cache-Control")) {
            String str = map.get("Cache-Control");
            if (!TextUtils.isEmpty(str) && str.contains("max-age=")) {
                try {
                    j10 = Long.parseLong(str.substring(str.indexOf("max-age=") + 8));
                } catch (NumberFormatException e11) {
                    e10 = e11;
                    j10 = 0;
                }
                try {
                    Logger.v(f13896a, "Cache-Control value{%s}", Long.valueOf(j10));
                } catch (NumberFormatException e12) {
                    e10 = e12;
                    Logger.w(f13896a, "getExpireTime addHeadersToResult NumberFormatException", e10);
                    if (j10 > 0) {
                    }
                    j10 = 86400;
                    long j11 = j10 * 1000;
                    Logger.v(f13896a, "convert expireTime{%s}", Long.valueOf(j11));
                    b(String.valueOf(j11 + System.currentTimeMillis()));
                }
            }
            j10 = 0;
        } else {
            if (map.containsKey("Expires")) {
                String str2 = map.get("Expires");
                Logger.v(f13896a, "expires is{%s}", str2);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
                String str3 = null;
                if (map.containsKey("Date")) {
                    str3 = map.get("Date");
                }
                try {
                    j10 = (simpleDateFormat.parse(str2).getTime() - (TextUtils.isEmpty(str3) ? new Date() : simpleDateFormat.parse(str3)).getTime()) / 1000;
                } catch (ParseException e13) {
                    Logger.w(f13896a, "getExpireTime ParseException.", e13);
                }
            } else {
                Logger.i(f13896a, "response headers neither contains Cache-Control nor Expires.");
            }
            j10 = 0;
        }
        if (j10 > 0 || j10 > 2592000) {
            j10 = 86400;
        }
        long j112 = j10 * 1000;
        Logger.v(f13896a, "convert expireTime{%s}", Long.valueOf(j112));
        b(String.valueOf(j112 + System.currentTimeMillis()));
    }

    private void b(int i10) {
        this.f13905j = i10;
    }

    private void b(String str) {
        this.f13908m = str;
    }

    private void b(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            Logger.w(f13896a, "getExpireTime {headers == null} or {headers.size() <= 0}");
            return;
        }
        long j10 = 0;
        if (map.containsKey("Retry-After")) {
            String str = map.get("Retry-After");
            if (!TextUtils.isEmpty(str)) {
                try {
                    j10 = Long.parseLong(str);
                } catch (NumberFormatException e10) {
                    Logger.w(f13896a, "getRetryAfter addHeadersToResult NumberFormatException", e10);
                }
            }
        }
        long j11 = j10 * 1000;
        Logger.v(f13896a, "convert retry-afterTime{%s}", Long.valueOf(j11));
        c(j11);
    }

    private void c(int i10) {
        this.f13904i = i10;
    }

    private void c(long j10) {
        this.f13909n = j10;
    }

    private void c(String str) {
        this.f13906k = str;
    }

    private void d(String str) {
        this.f13907l = str;
    }

    private void e(String str) {
        this.f13903h = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0088 A[Catch: JSONException -> 0x0096, TryCatch #0 {JSONException -> 0x0096, blocks: (B:6:0x001a, B:9:0x002f, B:12:0x0036, B:13:0x003b, B:15:0x003f, B:16:0x0042, B:19:0x004a, B:26:0x005a, B:28:0x0063, B:30:0x006a, B:32:0x0073, B:33:0x0077, B:34:0x007b, B:36:0x0088, B:38:0x008e, B:39:0x0092), top: B:43:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void n() {
        boolean z10;
        String str = "isSuccess";
        if (!m()) {
            Logger.i(f13896a, "GRSSDK parse server body all failed.");
            c(2);
            return;
        }
        try {
            String byte2Str = StringUtils.byte2Str(this.f13898c);
            JSONObject jSONObject = new JSONObject(byte2Str);
            int i10 = -1;
            if (!jSONObject.has(str)) {
                if (jSONObject.has(Constant.KEY_RESULT_CODE)) {
                    str = Constant.KEY_RESULT_CODE;
                } else {
                    Logger.e(f13896a, "sth. wrong because server errorcode's key.");
                    c(i10);
                    z10 = i10 != 0 && byte2Str.contains(SharedWearInfoHelper.TaskInfo.KEY_SERVICES);
                    String str2 = "";
                    if (i10 != 1 || z10) {
                        e(jSONObject.getJSONObject(SharedWearInfoHelper.TaskInfo.KEY_SERVICES).toString());
                        if (!z10) {
                            if (jSONObject.has("errorList")) {
                                str2 = jSONObject.getString("errorList");
                            }
                            d(str2);
                            return;
                        }
                        return;
                    }
                    c(2);
                    b(jSONObject.has("errorCode") ? jSONObject.getInt("errorCode") : 9001);
                    if (jSONObject.has("errorDesc")) {
                        str2 = jSONObject.getString("errorDesc");
                    }
                    c(str2);
                    return;
                }
            }
            i10 = jSONObject.getInt(str);
            c(i10);
            if (i10 != 0) {
            }
            String str22 = "";
            if (i10 != 1) {
            }
            e(jSONObject.getJSONObject(SharedWearInfoHelper.TaskInfo.KEY_SERVICES).toString());
            if (!z10) {
            }
        } catch (JSONException e10) {
            Logger.w(f13896a, "GrsResponse GrsResponse(String result) JSONException", e10);
            c(2);
        }
    }

    private void o() {
        if (m() || l()) {
            Map<String, String> p10 = p();
            try {
                if (m()) {
                    a(p10);
                }
                if (l()) {
                    b(p10);
                }
            } catch (JSONException e10) {
                Logger.w(f13896a, "parseHeader catch JSONException", e10);
            }
        }
    }

    private Map<String, String> p() {
        HashMap hashMap = new HashMap(16);
        Map<String, List<String>> map = this.f13897b;
        if (map == null || map.size() <= 0) {
            Logger.v(f13896a, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return hashMap;
        }
        for (Map.Entry<String, List<String>> entry : this.f13897b.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().get(0));
        }
        return hashMap;
    }

    private void q() {
        o();
        n();
    }

    public String a() {
        return this.f13908m;
    }

    public void a(int i10) {
        this.f13912q = i10;
    }

    public void a(long j10) {
        this.f13902g = j10;
    }

    public void a(String str) {
        this.f13911p = str;
    }

    public int b() {
        return this.f13899d;
    }

    public void b(long j10) {
        this.f13901f = j10;
    }

    public int c() {
        return this.f13905j;
    }

    public Exception d() {
        return this.f13910o;
    }

    public int e() {
        return this.f13904i;
    }

    public long f() {
        return this.f13902g;
    }

    public long g() {
        return this.f13901f;
    }

    public long h() {
        return this.f13900e;
    }

    public String i() {
        return this.f13903h;
    }

    public long j() {
        return this.f13909n;
    }

    public String k() {
        return this.f13911p;
    }

    public boolean l() {
        return this.f13899d == 503;
    }

    public boolean m() {
        return this.f13899d == 200;
    }
}
