package c8;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.a;
import h6.n;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5606a;

    /* renamed from: b  reason: collision with root package name */
    private String f5607b;

    /* renamed from: c  reason: collision with root package name */
    private String f5608c;

    /* renamed from: d  reason: collision with root package name */
    private int f5609d;

    /* renamed from: e  reason: collision with root package name */
    private int f5610e = 0;

    public b(Context context) {
        this.f5606a = context;
    }

    public static String a(a aVar) {
        String d10 = aVar.e().d();
        if (d10 != null) {
            return d10;
        }
        String c10 = aVar.e().c();
        if (!c10.startsWith("1:")) {
            return c10;
        }
        String[] split = c10.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public static String b(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) ((digest[0] & 15) + 112);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    private final synchronized void d() {
        PackageInfo e10 = e(this.f5606a.getPackageName());
        if (e10 != null) {
            this.f5607b = Integer.toString(e10.versionCode);
            this.f5608c = e10.versionName;
        }
    }

    private final PackageInfo e(String str) {
        try {
            return this.f5606a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            String valueOf = String.valueOf(e10);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 23);
            sb2.append("Failed to find package ");
            sb2.append(valueOf);
            Log.w("FirebaseInstanceId", sb2.toString());
            return null;
        }
    }

    public final synchronized int c() {
        PackageInfo e10;
        if (this.f5609d == 0 && (e10 = e("com.google.android.gms")) != null) {
            this.f5609d = e10.versionCode;
        }
        return this.f5609d;
    }

    public final synchronized int f() {
        int i10 = this.f5610e;
        if (i10 != 0) {
            return i10;
        }
        PackageManager packageManager = this.f5606a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!n.i()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f5610e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
            Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
            if (n.i()) {
                this.f5610e = 2;
            } else {
                this.f5610e = 1;
            }
            return this.f5610e;
        }
        this.f5610e = 2;
        return 2;
    }

    public final synchronized String g() {
        if (this.f5607b == null) {
            d();
        }
        return this.f5607b;
    }

    public final synchronized String h() {
        if (this.f5608c == null) {
            d();
        }
        return this.f5608c;
    }
}
