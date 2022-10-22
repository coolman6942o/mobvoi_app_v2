package ej;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;
import bn.f;
import bn.h;
import bn.m;
import bn.n;
import bn.t;
import com.google.gson.e;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.mcuwatch.bean.DialZipBean;
import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import en.o;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import nj.q;
import org.json.JSONObject;
import rx.c;
import sh.k;
import yp.g;
/* compiled from: CustomWatchDownloadManager.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: f  reason: collision with root package name */
    private static final String f26100f = "d";

    /* renamed from: g  reason: collision with root package name */
    private static d f26101g;

    /* renamed from: a  reason: collision with root package name */
    private List<bn.d> f26102a;

    /* renamed from: b  reason: collision with root package name */
    private List<DialZipBean> f26103b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final String f26104c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f26105d;

    /* renamed from: e  reason: collision with root package name */
    private rx.subjects.d<List<bn.d>, List<bn.d>> f26106e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CustomWatchDownloadManager.java */
    /* loaded from: classes2.dex */
    public class a extends com.google.gson.reflect.a<List<DialZipBean>> {
        a(d dVar) {
        }
    }

    private d() {
        Application e10 = b.e();
        this.f26105d = e10;
        this.f26104c = e10.getFilesDir().getAbsolutePath() + File.separator + "DialCustom";
    }

    private boolean d(int i10) {
        String d10 = this.f26103b.get(i10).d();
        String str = this.f26104c;
        String replace = this.f26103b.get(i10).c().replace(MessageProxyConstants.NODE_ID_ANY, "x");
        String str2 = "DialCustom_" + replace + "_" + this.f26103b.get(i10).e() + ".zip";
        String str3 = "DialCustom_" + replace + "_" + this.f26103b.get(i10).e();
        int e10 = e(d10, str + "/", str2);
        if (e10 == -1) {
            Toast.makeText(this.f26105d, k.M0, 0).show();
        } else {
            try {
                t.a(str + "/" + str2, str + "/" + str3);
                bn.d dVar = new bn.d();
                dVar.q(this.f26103b.get(i10).e());
                dVar.w(this.f26103b.get(i10).g());
                dVar.l(this.f26103b.get(i10).c());
                dVar.m(this.f26103b.get(i10).d());
                dVar.u(this.f26103b.get(i10).f());
                dVar.k(this.f26103b.get(i10).b());
                dVar.j(m.o().h(str + "/" + str3));
                dVar.n(str + "/" + str3);
                dVar.v(1);
                this.f26102a.add(dVar);
                Collections.sort(this.f26102a);
                o.b(this.f26105d).v(dVar);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return e10 != -1;
    }

    public static d g() {
        synchronized (d.class) {
            if (f26101g == null) {
                f26101g = new d();
            }
        }
        return f26101g;
    }

    private String h() {
        int l10 = q.g().l();
        return (l10 == 2 || l10 == 3) ? "320*360" : l10 != 4 ? "240*240" : "360*360";
    }

    private boolean i(int i10) {
        if (!o.b(this.f26105d).c(this.f26103b.get(i10).e())) {
            return d(i10);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean j(Map map, Integer num) {
        Exception e10;
        JSONObject jSONObject;
        int i10;
        int i11 = 0;
        try {
            jSONObject = new JSONObject(new h().a("https://www.ute-tech.com.cn/ci-yc/index.php/api/client/getWatchZips", map));
            i10 = jSONObject.getInt("flag");
            com.mobvoi.android.common.utils.k.a(f26100f, "flag: " + i10);
        } catch (Exception e11) {
            e10 = e11;
        }
        if (i10 < 0) {
            return Boolean.FALSE;
        }
        List<DialZipBean> list = (List) new e().k(jSONObject.getJSONArray("list").toString(), new a(this).getType());
        Collections.sort(list);
        this.f26103b = list;
        boolean z10 = false;
        while (i11 < this.f26103b.size()) {
            try {
                z10 = i(i11);
                i11++;
            } catch (Exception e12) {
                e10 = e12;
                i11 = z10;
                e10.printStackTrace();
                z10 = i11;
                return Boolean.valueOf(z10);
            }
        }
        return Boolean.valueOf(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(Boolean bool) {
        String str = f26100f;
        com.mobvoi.android.common.utils.k.a(str, "success: " + bool);
        if (bool.booleanValue()) {
            this.f26106e.onNext(this.f26102a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(Throwable th2) {
        String str = f26100f;
        com.mobvoi.android.common.utils.k.a(str, " startLoadServerWatchface throwable = " + th2);
    }

    private void m() {
        String h10 = h();
        int i10 = q.g().r() ? 2 : 1;
        if (n(String.valueOf(i10), h10)) {
            p(h10, i10);
        } else if (this.f26106e.m0()) {
            this.f26106e.onNext(this.f26102a);
        }
    }

    private boolean n(String str, String str2) {
        bn.d dVar = new bn.d();
        if ((!str.equals("2") || !str2.equals("240*240")) && ((!str.equals("1") || !str2.equals("240*240")) && (!str.equals("1") || !str2.equals("320*360")))) {
            List<bn.d> f10 = o.b(this.f26105d).f(str, str2);
            if (f10 == null || f10.size() == 0) {
                return true;
            }
            for (int i10 = 0; i10 < f10.size(); i10++) {
                bn.d dVar2 = f10.get(i10);
                dVar2.j(m.o().h(f10.get(i10).e()));
                this.f26102a.add(dVar2);
            }
            Collections.sort(this.f26102a);
            return false;
        }
        m.o().y(str, str2);
        dVar.q("0");
        dVar.v(0);
        dVar.w(str);
        dVar.j(m.o().g(this.f26105d));
        this.f26102a.add(dVar);
        return false;
    }

    private void p(String str, int i10) {
        String s10 = new e().s(n.b(this.f26105d).c(gn.b.b(this.f26105d).a(), str, i10));
        final HashMap hashMap = new HashMap();
        hashMap.put("content", s10);
        c.A(0).Z(cq.a.c()).D(new g() { // from class: ej.c
            @Override // yp.g
            public final Object call(Object obj) {
                Boolean j10;
                j10 = d.this.j(hashMap, (Integer) obj);
                return j10;
            }
        }).H(xp.a.b()).Y(new yp.b() { // from class: ej.a
            @Override // yp.b
            public final void call(Object obj) {
                d.this.k((Boolean) obj);
            }
        }, b.f26097a);
    }

    public int e(String str, String str2, String str3) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.connect();
            int contentLength = httpURLConnection.getContentLength();
            String str4 = f26100f;
            com.mobvoi.android.common.utils.k.a(str4, "file length---->" + contentLength);
            f fVar = new f();
            if (fVar.b(str2 + str3)) {
                fVar.a(str2 + str3);
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            File file = new File(str2 + str3);
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    bufferedInputStream.close();
                    fileOutputStream.close();
                    return 0;
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
            return -1;
        }
    }

    public c<List<bn.d>> f() {
        rx.subjects.b o02 = rx.subjects.b.o0();
        this.f26106e = o02;
        return o02;
    }

    public void o() {
        this.f26102a = new ArrayList();
        m();
    }
}
