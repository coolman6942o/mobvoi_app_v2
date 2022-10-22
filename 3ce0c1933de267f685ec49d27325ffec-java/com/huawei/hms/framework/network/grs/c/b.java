package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.net.Uri;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.c.b.c;
import java.util.concurrent.Callable;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    protected f f13857a;

    /* renamed from: b  reason: collision with root package name */
    private String f13858b;

    /* renamed from: c  reason: collision with root package name */
    private com.huawei.hms.framework.network.grs.c.a f13859c;

    /* renamed from: d  reason: collision with root package name */
    private int f13860d;

    /* renamed from: e  reason: collision with root package name */
    private Context f13861e;

    /* renamed from: f  reason: collision with root package name */
    private String f13862f;

    /* renamed from: g  reason: collision with root package name */
    private GrsBaseInfo f13863g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum a {
        GRSPOST,
        GRSGET,
        GRSDEFAULT
    }

    public b(String str, int i10, com.huawei.hms.framework.network.grs.c.a aVar, Context context, String str2, GrsBaseInfo grsBaseInfo) {
        this.f13858b = str;
        this.f13859c = aVar;
        this.f13860d = i10;
        this.f13861e = context;
        this.f13862f = str2;
        this.f13863g = grsBaseInfo;
    }

    private String a(String str) {
        return Uri.parse(str).getPath();
    }

    private a f() {
        if (this.f13858b.isEmpty()) {
            return a.GRSDEFAULT;
        }
        String a10 = a(this.f13858b);
        return a10.contains("1.0") ? a.GRSGET : a10.contains("2.0") ? a.GRSPOST : a.GRSDEFAULT;
    }

    public com.huawei.hms.framework.network.grs.c.a a() {
        return this.f13859c;
    }

    public Callable<f> a(c cVar) {
        if (a.GRSDEFAULT.equals(f())) {
            return null;
        }
        return a.GRSGET.equals(f()) ? new i(this.f13858b, this.f13860d, this.f13859c, this.f13861e, this.f13862f, this.f13863g) : new j(this.f13858b, this.f13860d, this.f13859c, this.f13861e, this.f13862f, this.f13863g, cVar.c());
    }

    public Context b() {
        return this.f13861e;
    }

    public String c() {
        return this.f13858b;
    }

    public int d() {
        return this.f13860d;
    }

    public String e() {
        return this.f13862f;
    }
}
