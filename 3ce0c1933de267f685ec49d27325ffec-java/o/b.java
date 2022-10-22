package o;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.SparseArray;
import androidx.core.app.e;
import java.util.ArrayList;
import o.a;
/* compiled from: CustomTabsIntent.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final Intent f31349a;

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f31350b;

    /* compiled from: CustomTabsIntent.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: c  reason: collision with root package name */
        private ArrayList<Bundle> f31353c;

        /* renamed from: d  reason: collision with root package name */
        private Bundle f31354d;

        /* renamed from: e  reason: collision with root package name */
        private ArrayList<Bundle> f31355e;

        /* renamed from: f  reason: collision with root package name */
        private SparseArray<Bundle> f31356f;

        /* renamed from: g  reason: collision with root package name */
        private Bundle f31357g;

        /* renamed from: a  reason: collision with root package name */
        private final Intent f31351a = new Intent("android.intent.action.VIEW");

        /* renamed from: b  reason: collision with root package name */
        private final a.C0416a f31352b = new a.C0416a();

        /* renamed from: h  reason: collision with root package name */
        private int f31358h = 0;

        /* renamed from: i  reason: collision with root package name */
        private boolean f31359i = true;

        private void b(IBinder iBinder, PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            e.a(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.f31351a.putExtras(bundle);
        }

        public b a() {
            if (!this.f31351a.hasExtra("android.support.customtabs.extra.SESSION")) {
                b(null, null);
            }
            ArrayList<Bundle> arrayList = this.f31353c;
            if (arrayList != null) {
                this.f31351a.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f31355e;
            if (arrayList2 != null) {
                this.f31351a.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.f31351a.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f31359i);
            this.f31351a.putExtras(this.f31352b.a().a());
            Bundle bundle = this.f31357g;
            if (bundle != null) {
                this.f31351a.putExtras(bundle);
            }
            if (this.f31356f != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f31356f);
                this.f31351a.putExtras(bundle2);
            }
            this.f31351a.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f31358h);
            return new b(this.f31351a, this.f31354d);
        }

        @Deprecated
        public a c(int i10) {
            this.f31352b.b(i10);
            return this;
        }
    }

    b(Intent intent, Bundle bundle) {
        this.f31349a = intent;
        this.f31350b = bundle;
    }

    public void a(Context context, Uri uri) {
        this.f31349a.setData(uri);
        androidx.core.content.b.m(context, this.f31349a, this.f31350b);
    }
}
