package b6;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.f;
import h6.i;
import j6.c;
import y5.b;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final f<String, String> f5060a = new f<>();

    public static String a(Context context) {
        String packageName = context.getPackageName();
        try {
            return c.a(context).c(packageName).toString();
        } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            String str = context.getApplicationInfo().name;
            return TextUtils.isEmpty(str) ? packageName : str;
        }
    }

    public static String b(Context context) {
        return context.getResources().getString(b.f36765g);
    }

    public static String c(Context context, int i10) {
        Resources resources = context.getResources();
        if (i10 == 1) {
            return resources.getString(b.f36762d);
        }
        if (i10 == 2) {
            return resources.getString(b.f36768j);
        }
        if (i10 != 3) {
            return resources.getString(17039370);
        }
        return resources.getString(b.f36759a);
    }

    public static String d(Context context, int i10) {
        Resources resources = context.getResources();
        String a10 = a(context);
        if (i10 == 1) {
            return resources.getString(b.f36763e, a10);
        }
        if (i10 == 2) {
            return i.d(context) ? resources.getString(b.f36772n) : resources.getString(b.f36769k, a10);
        }
        if (i10 == 3) {
            return resources.getString(b.f36760b, a10);
        }
        if (i10 == 5) {
            return i(context, "common_google_play_services_invalid_account_text", a10);
        }
        if (i10 == 7) {
            return i(context, "common_google_play_services_network_error_text", a10);
        }
        if (i10 == 9) {
            return resources.getString(b.f36767i, a10);
        }
        if (i10 == 20) {
            return i(context, "common_google_play_services_restricted_profile_text", a10);
        }
        switch (i10) {
            case 16:
                return i(context, "common_google_play_services_api_unavailable_text", a10);
            case 17:
                return i(context, "common_google_play_services_sign_in_failed_text", a10);
            case 18:
                return resources.getString(b.f36771m, a10);
            default:
                return resources.getString(z5.b.f37287a, a10);
        }
    }

    public static String e(Context context, int i10) {
        if (i10 == 6) {
            return i(context, "common_google_play_services_resolution_required_text", a(context));
        }
        return d(context, i10);
    }

    public static String f(Context context, int i10) {
        String str;
        if (i10 == 6) {
            str = h(context, "common_google_play_services_resolution_required_title");
        } else {
            str = g(context, i10);
        }
        return str == null ? context.getResources().getString(b.f36766h) : str;
    }

    public static String g(Context context, int i10) {
        Resources resources = context.getResources();
        switch (i10) {
            case 1:
                return resources.getString(b.f36764f);
            case 2:
                return resources.getString(b.f36770l);
            case 3:
                return resources.getString(b.f36761c);
            case 4:
            case 6:
            case 18:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return h(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return h(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return null;
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 12:
            case 13:
            case 14:
            case 15:
            case 19:
            default:
                StringBuilder sb2 = new StringBuilder(33);
                sb2.append("Unexpected error code ");
                sb2.append(i10);
                Log.e("GoogleApiAvailability", sb2.toString());
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return h(context, "common_google_play_services_sign_in_failed_title");
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return h(context, "common_google_play_services_restricted_profile_title");
        }
    }

    private static String h(Context context, String str) {
        f<String, String> fVar = f5060a;
        synchronized (fVar) {
            String str2 = fVar.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources e10 = com.google.android.gms.common.d.e(context);
            if (e10 == null) {
                return null;
            }
            int identifier = e10.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf.length() != 0 ? "Missing resource: ".concat(valueOf) : new String("Missing resource: "));
                return null;
            }
            String string = e10.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                String valueOf2 = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf2.length() != 0 ? "Got empty resource: ".concat(valueOf2) : new String("Got empty resource: "));
                return null;
            }
            fVar.put(str, string);
            return string;
        }
    }

    private static String i(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String h10 = h(context, str);
        if (h10 == null) {
            h10 = resources.getString(z5.b.f37287a);
        }
        return String.format(resources.getConfiguration().locale, h10, str2);
    }
}
