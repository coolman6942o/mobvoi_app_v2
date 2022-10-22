package com.mobvoi.android.common.provider;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.ContentObserver;
import android.net.Uri;
import com.mobvoi.android.common.utils.k;
/* compiled from: InfoProviderHelper.java */
/* loaded from: classes2.dex */
public abstract class b {
    private static final String TAG = "InfoProviderHelper";
    protected Context mAppContext;
    protected String mAuthority;
    protected a mInfoClient;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.mAppContext = applicationContext;
        this.mAuthority = str;
        this.mInfoClient = new a(applicationContext, str);
    }

    public Uri getUriFor(String str, String str2) {
        return this.mInfoClient.g(str, str2);
    }

    public boolean isProviderExist() {
        return isProviderExist(this.mAppContext, this.mAuthority);
    }

    public b registerObserver(String str, String str2, ContentObserver contentObserver) {
        this.mInfoClient.p(str, str2, contentObserver);
        return this;
    }

    public b unregisterObserver(ContentObserver contentObserver) {
        this.mInfoClient.r(contentObserver);
        return this;
    }

    public static boolean isProviderExist(Context context, String str) {
        ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(str, 0);
        k.c(TAG, "Provider: %s", resolveContentProvider);
        return resolveContentProvider != null;
    }

    public b registerObserver(Uri uri, ContentObserver contentObserver) {
        this.mInfoClient.o(uri, contentObserver);
        return this;
    }
}
