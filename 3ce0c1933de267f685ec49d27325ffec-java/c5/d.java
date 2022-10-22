package c5;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.b;
import java.util.List;
import q4.e;
import t4.c;
/* compiled from: ResourceDrawableDecoder.java */
/* loaded from: classes.dex */
public class d implements b<Uri, Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f5579a;

    public d(Context context) {
        this.f5579a = context.getApplicationContext();
    }

    private Context d(Uri uri, String str) {
        if (str.equals(this.f5579a.getPackageName())) {
            return this.f5579a;
        }
        try {
            return this.f5579a.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            if (str.contains(this.f5579a.getPackageName())) {
                return this.f5579a;
            }
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e10);
        }
    }

    private int e(Uri uri) {
        try {
            return Integer.parseInt(uri.getPathSegments().get(0));
        } catch (NumberFormatException e10) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri, e10);
        }
    }

    private int f(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        String authority = uri.getAuthority();
        String str = pathSegments.get(0);
        String str2 = pathSegments.get(1);
        int identifier = context.getResources().getIdentifier(str2, str, authority);
        if (identifier == 0) {
            identifier = Resources.getSystem().getIdentifier(str2, str, "android");
        }
        if (identifier != 0) {
            return identifier;
        }
        throw new IllegalArgumentException("Failed to find resource id for: " + uri);
    }

    private int g(Context context, Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            return f(context, uri);
        }
        if (pathSegments.size() == 1) {
            return e(uri);
        }
        throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
    }

    /* renamed from: c */
    public c<Drawable> a(Uri uri, int i10, int i11, e eVar) {
        Context d10 = d(uri, uri.getAuthority());
        return c.f(a.b(this.f5579a, d10, g(d10, uri)));
    }

    /* renamed from: h */
    public boolean b(Uri uri, e eVar) {
        return uri.getScheme().equals("android.resource");
    }
}
