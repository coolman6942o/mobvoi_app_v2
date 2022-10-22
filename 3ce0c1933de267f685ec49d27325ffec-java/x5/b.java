package x5;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import b6.i;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
/* loaded from: classes.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    private static final Lock f36447c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    private static b f36448d;

    /* renamed from: a  reason: collision with root package name */
    private final Lock f36449a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f36450b;

    private b(Context context) {
        this.f36450b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static b b(Context context) {
        i.k(context);
        Lock lock = f36447c;
        lock.lock();
        try {
            if (f36448d == null) {
                f36448d = new b(context.getApplicationContext());
            }
            b bVar = f36448d;
            lock.unlock();
            return bVar;
        } catch (Throwable th2) {
            f36447c.unlock();
            throw th2;
        }
    }

    private final void g(String str, String str2) {
        this.f36449a.lock();
        try {
            this.f36450b.edit().putString(str, str2).apply();
        } finally {
            this.f36449a.unlock();
        }
    }

    private static String h(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(":");
        sb2.append(str2);
        return sb2.toString();
    }

    private final GoogleSignInAccount i(String str) {
        String k10;
        if (!TextUtils.isEmpty(str) && (k10 = k(h("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.O0(k10);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private final GoogleSignInOptions j(String str) {
        String k10;
        if (!TextUtils.isEmpty(str) && (k10 = k(h("googleSignInOptions", str))) != null) {
            try {
                return GoogleSignInOptions.O0(k10);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    private final String k(String str) {
        this.f36449a.lock();
        try {
            return this.f36450b.getString(str, null);
        } finally {
            this.f36449a.unlock();
        }
    }

    private final void m(String str) {
        this.f36449a.lock();
        try {
            this.f36450b.edit().remove(str).apply();
        } finally {
            this.f36449a.unlock();
        }
    }

    public void a() {
        this.f36449a.lock();
        try {
            this.f36450b.edit().clear().apply();
        } finally {
            this.f36449a.unlock();
        }
    }

    public GoogleSignInAccount c() {
        return i(k("defaultGoogleSignInAccount"));
    }

    public GoogleSignInOptions d() {
        return j(k("defaultGoogleSignInAccount"));
    }

    public String e() {
        return k("refreshToken");
    }

    public void f(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        i.k(googleSignInAccount);
        i.k(googleSignInOptions);
        g("defaultGoogleSignInAccount", googleSignInAccount.Q0());
        i.k(googleSignInAccount);
        i.k(googleSignInOptions);
        String Q0 = googleSignInAccount.Q0();
        g(h("googleSignInAccount", Q0), googleSignInAccount.R0());
        g(h("googleSignInOptions", Q0), googleSignInOptions.U0());
    }

    public final void l() {
        String k10 = k("defaultGoogleSignInAccount");
        m("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(k10)) {
            m(h("googleSignInAccount", k10));
            m(h("googleSignInOptions", k10));
        }
    }
}
