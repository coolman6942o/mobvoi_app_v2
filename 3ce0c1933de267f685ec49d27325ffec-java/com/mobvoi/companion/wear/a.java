package com.mobvoi.companion.wear;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.google.gson.e;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.o;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.companion.TicAppConstants;
import com.mobvoi.wear.info.WearInfo;
import java.util.HashMap;
import java.util.List;
/* compiled from: WearInfoHelper.java */
/* loaded from: classes2.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g  reason: collision with root package name */
    private static volatile a f17832g;

    /* renamed from: c  reason: collision with root package name */
    private String f17835c;

    /* renamed from: d  reason: collision with root package name */
    private WearInfo f17836d;

    /* renamed from: f  reason: collision with root package name */
    private WearInfo f17838f;

    /* renamed from: b  reason: collision with root package name */
    private HashMap<String, WearInfo> f17834b = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private String f17837e = "";

    /* renamed from: a  reason: collision with root package name */
    private Context f17833a = b.e();

    private a() {
    }

    public static a f() {
        if (f17832g == null) {
            synchronized (a.class) {
                if (f17832g == null) {
                    f17832g = new a();
                }
            }
        }
        return f17832g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, WearInfo wearInfo, String str2) {
        k.c("WearInfoHelper", "Add nodes info for %s", str);
        o.c();
        String str3 = wearInfo.wearDeviceId;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str3)) {
            this.f17834b.put(str, wearInfo);
            Context context = this.f17833a;
            q.h(context, TicAppConstants.PREF_WEAR_INFO, "wear_id_" + str, str2);
        }
    }

    public void b(String str) {
        k.c("WearInfoHelper", "change current watch: %s", str);
        o.c();
        if (h().equals(str)) {
            this.f17837e = str;
            this.f17838f = g();
            return;
        }
        this.f17837e = str;
        this.f17838f = c(str);
    }

    public WearInfo c(String str) {
        WearInfo wearInfo;
        WearInfo wearInfo2 = this.f17834b.get(str);
        if (wearInfo2 != null) {
            return wearInfo2;
        }
        String str2 = "wear_id_" + str;
        String d10 = q.d(this.f17833a, TicAppConstants.PREF_WEAR_INFO, str2, null);
        if (d10 == null) {
            return wearInfo2;
        }
        try {
            wearInfo = (WearInfo) new e().j(d10, WearInfo.class);
        } catch (Exception unused) {
        }
        try {
            this.f17834b.put(str2, wearInfo);
            return wearInfo;
        } catch (Exception unused2) {
            wearInfo2 = wearInfo;
            k.s("WearInfoHelper", "Failed to parse wear info from prefs %s: [%s]", str, d10);
            return wearInfo2;
        }
    }

    public String d() {
        String str = this.f17837e;
        if (TextUtils.isEmpty(str)) {
            str = h();
            if (TextUtils.isEmpty(str)) {
                str = WearPairingPool.i().h();
            }
            if (!TextUtils.isEmpty(str)) {
                this.f17837e = str;
            }
        }
        return str;
    }

    public WearInfo e() {
        WearInfo wearInfo = this.f17838f;
        if (wearInfo == null) {
            wearInfo = g();
            if (wearInfo == null) {
                wearInfo = c(WearPairingPool.i().h());
            }
            if (wearInfo != null) {
                this.f17838f = wearInfo;
            }
        }
        return wearInfo;
    }

    public WearInfo g() {
        String d10;
        if (this.f17836d == null && (d10 = q.d(this.f17833a, TicAppConstants.PREF_WEAR_INFO, "ticwear_info", null)) != null) {
            try {
                this.f17836d = (WearInfo) new e().j(d10, WearInfo.class);
            } catch (Exception unused) {
                k.q("WearInfoHelper", "Failed to parse wear info for ticwear");
            }
        }
        return this.f17836d;
    }

    public String h() {
        if (this.f17835c == null) {
            this.f17835c = q.d(this.f17833a, TicAppConstants.PREF_WEAR_INFO, "ticwear_node_id", "");
        }
        return this.f17835c;
    }

    public WearInfo i(String str) {
        if (!TextUtils.isEmpty(str)) {
            return c(str);
        }
        return null;
    }

    public void j(String str) {
        o.c();
        this.f17834b.remove(str);
        Context context = this.f17833a;
        q.i(context, TicAppConstants.PREF_WEAR_INFO, "wear_id_" + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(List<String> list) {
        o.c();
        k.c("WearInfoHelper", "Remove nodes %s", list);
        for (String str : list) {
            j(str);
        }
    }

    public void l(String str, WearInfo wearInfo, String str2) {
        k.c("WearInfoHelper", "Update Ticwear, nodeId: %s, info: %s", str, str2);
        this.f17835c = str;
        this.f17836d = wearInfo;
        q.h(this.f17833a, TicAppConstants.PREF_WEAR_INFO, "ticwear_node_id", str);
        q.h(this.f17833a, TicAppConstants.PREF_WEAR_INFO, "ticwear_info", str2);
    }
}
