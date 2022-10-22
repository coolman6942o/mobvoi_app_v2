package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.util.Log;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class s6 {

    /* renamed from: h  reason: collision with root package name */
    private static final ConcurrentHashMap<Uri, s6> f9659h = new ConcurrentHashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f9660i = {"key", HealthDataProviderContracts.NAME_VALUE};

    /* renamed from: a  reason: collision with root package name */
    private final ContentResolver f9661a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f9662b;

    /* renamed from: e  reason: collision with root package name */
    private volatile Map<String, String> f9665e;

    /* renamed from: d  reason: collision with root package name */
    private final Object f9664d = new Object();

    /* renamed from: f  reason: collision with root package name */
    private final Object f9666f = new Object();

    /* renamed from: g  reason: collision with root package name */
    private final List<u6> f9667g = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private final ContentObserver f9663c = new t6(this, null);

    private s6(ContentResolver contentResolver, Uri uri) {
        this.f9661a = contentResolver;
        this.f9662b = uri;
    }

    public static s6 a(ContentResolver contentResolver, Uri uri) {
        ConcurrentHashMap<Uri, s6> concurrentHashMap = f9659h;
        s6 s6Var = concurrentHashMap.get(uri);
        if (s6Var != null) {
            return s6Var;
        }
        s6 s6Var2 = new s6(contentResolver, uri);
        s6 putIfAbsent = concurrentHashMap.putIfAbsent(uri, s6Var2);
        if (putIfAbsent != null) {
            return putIfAbsent;
        }
        s6Var2.f9661a.registerContentObserver(s6Var2.f9662b, false, s6Var2.f9663c);
        return s6Var2;
    }

    private final Map<String, String> e() {
        try {
            HashMap hashMap = new HashMap();
            Cursor query = this.f9661a.query(this.f9662b, f9660i, null, null, null);
            if (query != null) {
                while (query.moveToNext()) {
                    hashMap.put(query.getString(0), query.getString(1));
                }
                query.close();
            }
            return hashMap;
        } catch (SQLiteException | SecurityException unused) {
            Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        synchronized (this.f9666f) {
            for (u6 u6Var : this.f9667g) {
                u6Var.a();
            }
        }
    }

    public final Map<String, String> c() {
        Map<String, String> e10 = v6.n("gms:phenotype:phenotype_flag:debug_disable_caching", false) ? e() : this.f9665e;
        if (e10 == null) {
            synchronized (this.f9664d) {
                e10 = this.f9665e;
                if (e10 == null) {
                    e10 = e();
                    this.f9665e = e10;
                }
            }
        }
        return e10 != null ? e10 : Collections.emptyMap();
    }

    public final void d() {
        synchronized (this.f9664d) {
            this.f9665e = null;
        }
    }
}
