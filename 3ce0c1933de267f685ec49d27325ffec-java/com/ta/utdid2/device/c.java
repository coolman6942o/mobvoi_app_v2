package com.ta.utdid2.device;

import android.content.Context;
import android.os.Binder;
import android.provider.Settings;
import android.text.TextUtils;
import com.ta.utdid2.a.a.b;
import com.ta.utdid2.a.a.d;
import com.ta.utdid2.a.a.e;
import com.ta.utdid2.a.a.f;
import com.ta.utdid2.a.a.g;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static c f22447a;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f22448e = new Object();

    /* renamed from: k  reason: collision with root package name */
    public static final String f22449k = ".UTSystemConfig" + File.separator + "Global";

    /* renamed from: a  reason: collision with other field name */
    public com.ta.utdid2.b.a.c f20a;

    /* renamed from: a  reason: collision with other field name */
    public d f21a;

    /* renamed from: b  reason: collision with root package name */
    public com.ta.utdid2.b.a.c f22450b;

    /* renamed from: i  reason: collision with root package name */
    public String f22452i;

    /* renamed from: j  reason: collision with root package name */
    public String f22453j;
    public Context mContext;

    /* renamed from: h  reason: collision with root package name */
    public String f22451h = null;

    /* renamed from: b  reason: collision with other field name */
    public Pattern f22b = Pattern.compile("[^0-9a-zA-Z=/+]+");

    public c(Context context) {
        this.mContext = null;
        this.f21a = null;
        this.f22452i = "xx_utdid_key";
        this.f22453j = "xx_utdid_domain";
        this.f20a = null;
        this.f22450b = null;
        this.mContext = context;
        this.f22450b = new com.ta.utdid2.b.a.c(context, f22449k, "Alvin2", false, true);
        this.f20a = new com.ta.utdid2.b.a.c(context, ".DataStorage", "ContextData", false, true);
        this.f21a = new d();
        this.f22452i = String.format("K_%d", Integer.valueOf(g.a(this.f22452i)));
        this.f22453j = String.format("D_%d", Integer.valueOf(g.a(this.f22453j)));
    }

    public static c a(Context context) {
        if (context != null && f22447a == null) {
            synchronized (f22448e) {
                if (f22447a == null) {
                    c cVar = new c(context);
                    f22447a = cVar;
                    cVar.c();
                }
            }
        }
        return f22447a;
    }

    private boolean b(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.f22b.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    private void c() {
        com.ta.utdid2.b.a.c cVar = this.f22450b;
        if (cVar != null) {
            if (g.m22a(cVar.getString("UTDID2"))) {
                String string = this.f22450b.getString("UTDID");
                if (!g.m22a(string)) {
                    f(string);
                }
            }
            boolean z10 = false;
            boolean z11 = true;
            if (!g.m22a(this.f22450b.getString("DID"))) {
                this.f22450b.remove("DID");
                z10 = true;
            }
            if (!g.m22a(this.f22450b.getString("EI"))) {
                this.f22450b.remove("EI");
                z10 = true;
            }
            if (!g.m22a(this.f22450b.getString("SI"))) {
                this.f22450b.remove("SI");
            } else {
                z11 = z10;
            }
            if (z11) {
                this.f22450b.commit();
            }
        }
    }

    private void f(String str) {
        com.ta.utdid2.b.a.c cVar;
        if (b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() == 24 && (cVar = this.f22450b) != null) {
                cVar.putString("UTDID2", str);
                this.f22450b.commit();
            }
        }
    }

    private void g(String str) {
        com.ta.utdid2.b.a.c cVar;
        if (str != null && (cVar = this.f20a) != null && !str.equals(cVar.getString(this.f22452i))) {
            this.f20a.putString(this.f22452i, str);
            this.f20a.commit();
        }
    }

    private void h(String str) {
        if (f() && b(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length()) {
                String str2 = null;
                try {
                    str2 = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception unused) {
                }
                if (!b(str2)) {
                    try {
                        Settings.System.putString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk", str);
                    } catch (Exception unused2) {
                    }
                }
            }
        }
    }

    private void i(String str) {
        String str2;
        try {
            str2 = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception unused) {
            str2 = null;
        }
        if (!str.equals(str2)) {
            try {
                Settings.System.putString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp", str);
            } catch (Exception unused2) {
            }
        }
    }

    private void j(String str) {
        if (f() && str != null) {
            i(str);
        }
    }

    public synchronized String getValue() {
        String str = this.f22451h;
        if (str != null) {
            return str;
        }
        return h();
    }

    public synchronized String i() {
        String str;
        String string;
        try {
            string = Settings.System.getString(this.mContext.getContentResolver(), "mqBRboGZkQPcAkyk");
        } catch (Exception unused) {
        }
        if (b(string)) {
            return string;
        }
        e eVar = new e();
        boolean z10 = false;
        try {
            str = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception unused2) {
            str = null;
        }
        if (!g.m22a(str)) {
            String e10 = eVar.e(str);
            if (b(e10)) {
                h(e10);
                return e10;
            }
            String d10 = eVar.d(str);
            if (b(d10)) {
                String c10 = this.f21a.c(d10);
                if (!g.m22a(c10)) {
                    j(c10);
                    try {
                        str = Settings.System.getString(this.mContext.getContentResolver(), "dxCRMxhQkdGePGnp");
                    } catch (Exception unused3) {
                    }
                }
            }
            String d11 = this.f21a.d(str);
            if (b(d11)) {
                this.f22451h = d11;
                f(d11);
                g(str);
                h(this.f22451h);
                return this.f22451h;
            }
        } else {
            z10 = true;
        }
        String g10 = g();
        if (b(g10)) {
            String c11 = this.f21a.c(g10);
            if (z10) {
                j(c11);
            }
            h(g10);
            g(c11);
            this.f22451h = g10;
            return g10;
        }
        String string2 = this.f20a.getString(this.f22452i);
        if (!g.m22a(string2)) {
            String d12 = eVar.d(string2);
            if (!b(d12)) {
                d12 = this.f21a.d(string2);
            }
            if (b(d12)) {
                String c12 = this.f21a.c(d12);
                if (!g.m22a(d12)) {
                    this.f22451h = d12;
                    if (z10) {
                        j(c12);
                    }
                    f(this.f22451h);
                    return this.f22451h;
                }
            }
        }
        return null;
    }

    public static String b(byte[] bArr) throws Exception {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(f.a(new byte[]{69, 114, 116, -33, 125, -54, -31, 86, -11, 11, -78, -96, -17, -99, 64, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, -39, 33, -80, -68, -78, -117, 53, 30, -122, 64, -104, 74, -49, 106, 85, -38, -93}), mac.getAlgorithm()));
        return b.encodeToString(mac.doFinal(bArr), 2);
    }

    private String g() {
        com.ta.utdid2.b.a.c cVar = this.f22450b;
        if (cVar == null) {
            return null;
        }
        String string = cVar.getString("UTDID2");
        if (g.m22a(string) || this.f21a.c(string) == null) {
            return null;
        }
        return string;
    }

    private boolean f() {
        return this.mContext.checkPermission("android.permission.WRITE_SETTINGS", Binder.getCallingPid(), Binder.getCallingUid()) == 0;
    }

    public synchronized String h() {
        String i10 = i();
        this.f22451h = i10;
        if (!TextUtils.isEmpty(i10)) {
            return this.f22451h;
        }
        try {
            byte[] c10 = m26c();
            if (c10 != null) {
                String encodeToString = b.encodeToString(c10, 2);
                this.f22451h = encodeToString;
                f(encodeToString);
                String c11 = this.f21a.c(c10);
                if (c11 != null) {
                    j(c11);
                    g(c11);
                }
                return this.f22451h;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return null;
    }

    /* renamed from: c  reason: collision with other method in class */
    private byte[] m26c() throws Exception {
        String str;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int nextInt = new Random().nextInt();
        byte[] bytes = d.getBytes((int) (System.currentTimeMillis() / 1000));
        byte[] bytes2 = d.getBytes(nextInt);
        byteArrayOutputStream.write(bytes, 0, 4);
        byteArrayOutputStream.write(bytes2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            str = e.a(this.mContext);
        } catch (Exception unused) {
            str = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(d.getBytes(g.a(str)), 0, 4);
        byteArrayOutputStream.write(d.getBytes(g.a(b(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }
}
