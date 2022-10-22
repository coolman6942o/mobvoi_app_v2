package b4;

import android.app.Activity;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public abstract class c extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public Activity f4994a;

    /* renamed from: b  reason: collision with root package name */
    public final String f4995b;

    public c(Activity activity, String str) {
        super(activity);
        this.f4994a = activity;
        this.f4995b = str;
    }

    public static void j(WebView webView) {
        if (webView != null) {
            try {
                webView.resumeTimers();
            } catch (Throwable unused) {
            }
        }
    }

    public void k(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            CookieSyncManager.createInstance(this.f4994a.getApplicationContext()).sync();
            CookieManager.getInstance().setCookie(str, str2);
            CookieSyncManager.getInstance().sync();
        }
    }

    public boolean l() {
        return "v1".equals(this.f4995b);
    }

    public abstract boolean m();

    public abstract void n();
}
