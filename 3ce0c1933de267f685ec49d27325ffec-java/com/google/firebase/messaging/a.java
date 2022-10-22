package com.google.firebase.messaging;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.k;
import androidx.core.content.b;
import com.google.firebase.iid.l;
import com.mobvoi.wear.common.base.Constants;
import h6.n;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes.dex */
final class a {

    /* renamed from: f  reason: collision with root package name */
    private static a f12538f;

    /* renamed from: a  reason: collision with root package name */
    private final Context f12539a;

    /* renamed from: b  reason: collision with root package name */
    private Bundle f12540b;

    /* renamed from: c  reason: collision with root package name */
    private Method f12541c;

    /* renamed from: d  reason: collision with root package name */
    private Method f12542d;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicInteger f12543e = new AtomicInteger((int) SystemClock.elapsedRealtime());

    private a(Context context) {
        this.f12539a = context.getApplicationContext();
    }

    @TargetApi(26)
    private final Notification a(CharSequence charSequence, String str, int i10, Integer num, Uri uri, PendingIntent pendingIntent, PendingIntent pendingIntent2, String str2) {
        Notification.Builder smallIcon = new Notification.Builder(this.f12539a).setAutoCancel(true).setSmallIcon(i10);
        if (!TextUtils.isEmpty(charSequence)) {
            smallIcon.setContentTitle(charSequence);
        }
        if (!TextUtils.isEmpty(str)) {
            smallIcon.setContentText(str);
            smallIcon.setStyle(new Notification.BigTextStyle().bigText(str));
        }
        if (num != null) {
            smallIcon.setColor(num.intValue());
        }
        if (uri != null) {
            smallIcon.setSound(uri);
        }
        if (pendingIntent != null) {
            smallIcon.setContentIntent(pendingIntent);
        }
        if (pendingIntent2 != null) {
            smallIcon.setDeleteIntent(pendingIntent2);
        }
        if (str2 != null) {
            if (this.f12541c == null) {
                this.f12541c = n("setChannelId");
            }
            if (this.f12541c == null) {
                this.f12541c = n("setChannel");
            }
            Method method = this.f12541c;
            if (method == null) {
                Log.e("FirebaseMessaging", "Error while setting the notification channel");
            } else {
                try {
                    method.invoke(smallIcon, str2);
                } catch (IllegalAccessException | IllegalArgumentException | SecurityException | InvocationTargetException e10) {
                    Log.e("FirebaseMessaging", "Error while setting the notification channel", e10);
                }
            }
        }
        return smallIcon.build();
    }

    static String b(Bundle bundle, String str) {
        String string = bundle.getString(str);
        return string == null ? bundle.getString(str.replace("gcm.n.", "gcm.notification.")) : string;
    }

    private static void c(Intent intent, Bundle bundle) {
        for (String str : bundle.keySet()) {
            if (str.startsWith("google.c.a.") || str.equals(Constants.WatchfaceMarket.MARKET_ENTER_FROM)) {
                intent.putExtra(str, bundle.getString(str));
            }
        }
    }

    private final Bundle d() {
        Bundle bundle;
        Bundle bundle2 = this.f12540b;
        if (bundle2 != null) {
            return bundle2;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = this.f12539a.getPackageManager().getApplicationInfo(this.f12539a.getPackageName(), 128);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
            return Bundle.EMPTY;
        }
        this.f12540b = bundle;
        return bundle;
    }

    static String e(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        return b(bundle, "_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf));
    }

    @TargetApi(26)
    private final boolean f(int i10) {
        if (Build.VERSION.SDK_INT != 26) {
            return true;
        }
        try {
            if (!(this.f12539a.getResources().getDrawable(i10, null) instanceof AdaptiveIconDrawable)) {
                return true;
            }
            StringBuilder sb2 = new StringBuilder(77);
            sb2.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
            sb2.append(i10);
            Log.e("FirebaseMessaging", sb2.toString());
            return false;
        } catch (Resources.NotFoundException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static Object[] g(Bundle bundle, String str) {
        String valueOf = String.valueOf(str);
        String b10 = b(bundle, "_loc_args".length() != 0 ? valueOf.concat("_loc_args") : new String(valueOf));
        if (TextUtils.isEmpty(b10)) {
            return null;
        }
        try {
            JSONArray jSONArray = new JSONArray(b10);
            int length = jSONArray.length();
            String[] strArr = new String[length];
            for (int i10 = 0; i10 < length; i10++) {
                strArr[i10] = jSONArray.opt(i10);
            }
            return strArr;
        } catch (JSONException unused) {
            String valueOf2 = String.valueOf(str);
            String substring = ("_loc_args".length() != 0 ? valueOf2.concat("_loc_args") : new String(valueOf2)).substring(6);
            StringBuilder sb2 = new StringBuilder(String.valueOf(substring).length() + 41 + String.valueOf(b10).length());
            sb2.append("Malformed ");
            sb2.append(substring);
            sb2.append(": ");
            sb2.append(b10);
            sb2.append("  Default value will be used.");
            Log.w("FirebaseMessaging", sb2.toString());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized a h(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f12538f == null) {
                f12538f = new a(context);
            }
            aVar = f12538f;
        }
        return aVar;
    }

    private final String i(Bundle bundle, String str) {
        String b10 = b(bundle, str);
        if (!TextUtils.isEmpty(b10)) {
            return b10;
        }
        String e10 = e(bundle, str);
        if (TextUtils.isEmpty(e10)) {
            return null;
        }
        Resources resources = this.f12539a.getResources();
        int identifier = resources.getIdentifier(e10, "string", this.f12539a.getPackageName());
        if (identifier == 0) {
            String valueOf = String.valueOf(str);
            String substring = ("_loc_key".length() != 0 ? valueOf.concat("_loc_key") : new String(valueOf)).substring(6);
            StringBuilder sb2 = new StringBuilder(String.valueOf(substring).length() + 49 + String.valueOf(e10).length());
            sb2.append(substring);
            sb2.append(" resource not found: ");
            sb2.append(e10);
            sb2.append(" Default value will be used.");
            Log.w("FirebaseMessaging", sb2.toString());
            return null;
        }
        Object[] g10 = g(bundle, str);
        if (g10 == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, g10);
        } catch (MissingFormatArgumentException e11) {
            String arrays = Arrays.toString(g10);
            StringBuilder sb3 = new StringBuilder(String.valueOf(e10).length() + 58 + String.valueOf(arrays).length());
            sb3.append("Missing format argument for ");
            sb3.append(e10);
            sb3.append(": ");
            sb3.append(arrays);
            sb3.append(" Default value will be used.");
            Log.w("FirebaseMessaging", sb3.toString(), e11);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j(Bundle bundle) {
        return "1".equals(b(bundle, "gcm.n.e")) || b(bundle, "gcm.n.icon") != null;
    }

    static Uri k(Bundle bundle) {
        String b10 = b(bundle, "gcm.n.link_android");
        if (TextUtils.isEmpty(b10)) {
            b10 = b(bundle, "gcm.n.link");
        }
        if (!TextUtils.isEmpty(b10)) {
            return Uri.parse(b10);
        }
        return null;
    }

    static String m(Bundle bundle) {
        String b10 = b(bundle, "gcm.n.sound2");
        return TextUtils.isEmpty(b10) ? b(bundle, "gcm.n.sound") : b10;
    }

    @TargetApi(26)
    private static Method n(String str) {
        try {
            return Notification.Builder.class.getMethod(str, String.class);
        } catch (NoSuchMethodException | SecurityException unused) {
            return null;
        }
    }

    private final Integer o(String str) {
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.valueOf(Color.parseColor(str));
            } catch (IllegalArgumentException unused) {
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 54);
                sb2.append("Color ");
                sb2.append(str);
                sb2.append(" not valid. Notification will use default color.");
                Log.w("FirebaseMessaging", sb2.toString());
            }
        }
        int i10 = d().getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i10 != 0) {
            try {
                return Integer.valueOf(b.c(this.f12539a, i10));
            } catch (Resources.NotFoundException unused2) {
                Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
            }
        }
        return null;
    }

    @TargetApi(26)
    private final String p(String str) {
        String str2;
        if (!n.i()) {
            return null;
        }
        NotificationManager notificationManager = (NotificationManager) this.f12539a.getSystemService(NotificationManager.class);
        try {
            if (this.f12542d == null) {
                this.f12542d = notificationManager.getClass().getMethod("getNotificationChannel", String.class);
            }
            if (!TextUtils.isEmpty(str)) {
                if (this.f12542d.invoke(notificationManager, str) != null) {
                    return str;
                }
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 122);
                sb2.append("Notification Channel requested (");
                sb2.append(str);
                sb2.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
                Log.w("FirebaseMessaging", sb2.toString());
            }
            String string = d().getString("com.google.firebase.messaging.default_notification_channel_id");
            if (TextUtils.isEmpty(string)) {
                str2 = "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.";
            } else if (this.f12542d.invoke(notificationManager, string) != null) {
                return string;
            } else {
                str2 = "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.";
            }
            Log.w("FirebaseMessaging", str2);
            if (this.f12542d.invoke(notificationManager, "fcm_fallback_notification_channel") == null) {
                Class<?> cls = Class.forName("android.app.NotificationChannel");
                notificationManager.getClass().getMethod("createNotificationChannel", cls).invoke(notificationManager, cls.getConstructor(String.class, CharSequence.class, Integer.TYPE).newInstance("fcm_fallback_notification_channel", this.f12539a.getString(g8.b.a_res_0x7f1404c2), 3));
            }
            return "fcm_fallback_notification_channel";
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | InstantiationException | LinkageError | NoSuchMethodException | SecurityException | InvocationTargetException e10) {
            Log.e("FirebaseMessaging", "Error while setting the notification channel", e10);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean l(Bundle bundle) {
        boolean z10;
        int i10;
        Integer o10;
        String m10;
        Uri uri;
        String b10;
        Intent intent;
        PendingIntent pendingIntent;
        PendingIntent pendingIntent2;
        Notification notification;
        String b11;
        if ("1".equals(b(bundle, "gcm.n.noui"))) {
            return true;
        }
        if (!((KeyguardManager) this.f12539a.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (!n.g()) {
                SystemClock.sleep(10L);
            }
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.f12539a.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        if (next.importance == 100) {
                            z10 = true;
                        }
                    }
                }
            }
        }
        z10 = false;
        if (z10) {
            return false;
        }
        CharSequence i11 = i(bundle, "gcm.n.title");
        if (TextUtils.isEmpty(i11)) {
            i11 = this.f12539a.getApplicationInfo().loadLabel(this.f12539a.getPackageManager());
        }
        CharSequence charSequence = i11;
        String i12 = i(bundle, "gcm.n.body");
        String b12 = b(bundle, "gcm.n.icon");
        if (!TextUtils.isEmpty(b12)) {
            Resources resources = this.f12539a.getResources();
            i10 = resources.getIdentifier(b12, "drawable", this.f12539a.getPackageName());
            if (i10 == 0 || !f(i10)) {
                int identifier = resources.getIdentifier(b12, "mipmap", this.f12539a.getPackageName());
                if (identifier == 0 || !f(identifier)) {
                    StringBuilder sb2 = new StringBuilder(String.valueOf(b12).length() + 61);
                    sb2.append("Icon resource ");
                    sb2.append(b12);
                    sb2.append(" not found. Notification will use default icon.");
                    Log.w("FirebaseMessaging", sb2.toString());
                } else {
                    i10 = identifier;
                }
            }
            o10 = o(b(bundle, "gcm.n.color"));
            m10 = m(bundle);
            if (!TextUtils.isEmpty(m10)) {
                uri = null;
            } else if ("default".equals(m10) || this.f12539a.getResources().getIdentifier(m10, "raw", this.f12539a.getPackageName()) == 0) {
                uri = RingtoneManager.getDefaultUri(2);
            } else {
                String packageName = this.f12539a.getPackageName();
                StringBuilder sb3 = new StringBuilder(String.valueOf(packageName).length() + 24 + String.valueOf(m10).length());
                sb3.append("android.resource://");
                sb3.append(packageName);
                sb3.append("/raw/");
                sb3.append(m10);
                uri = Uri.parse(sb3.toString());
            }
            b10 = b(bundle, "gcm.n.click_action");
            if (TextUtils.isEmpty(b10)) {
                intent = new Intent(b10);
                intent.setPackage(this.f12539a.getPackageName());
                intent.setFlags(268435456);
            } else {
                Uri k10 = k(bundle);
                if (k10 != null) {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setPackage(this.f12539a.getPackageName());
                    intent.setData(k10);
                } else {
                    intent = this.f12539a.getPackageManager().getLaunchIntentForPackage(this.f12539a.getPackageName());
                    if (intent == null) {
                        Log.w("FirebaseMessaging", "No activity found to launch app");
                    }
                }
            }
            if (intent != null) {
                pendingIntent = null;
            } else {
                intent.addFlags(67108864);
                Bundle bundle2 = new Bundle(bundle);
                FirebaseMessagingService.k(bundle2);
                intent.putExtras(bundle2);
                for (String str : bundle2.keySet()) {
                    if (str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                        intent.removeExtra(str);
                    }
                }
                pendingIntent = PendingIntent.getActivity(this.f12539a, this.f12543e.incrementAndGet(), intent, 1073741824);
            }
            if (!FirebaseMessagingService.l(bundle)) {
                Intent intent2 = new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN");
                c(intent2, bundle);
                intent2.putExtra("pending_intent", pendingIntent);
                pendingIntent = l.b(this.f12539a, this.f12543e.incrementAndGet(), intent2, 1073741824);
                Intent intent3 = new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS");
                c(intent3, bundle);
                pendingIntent2 = l.b(this.f12539a, this.f12543e.incrementAndGet(), intent3, 1073741824);
            } else {
                pendingIntent2 = null;
            }
            if (n.i() || this.f12539a.getApplicationInfo().targetSdkVersion <= 25) {
                k.d u10 = new k.d(this.f12539a).e(true).u(i10);
                if (!TextUtils.isEmpty(charSequence)) {
                    u10.k(charSequence);
                }
                if (!TextUtils.isEmpty(i12)) {
                    u10.j(i12);
                    u10.w(new k.b().h(i12));
                }
                if (o10 != null) {
                    u10.h(o10.intValue());
                }
                if (uri != null) {
                    u10.v(uri);
                }
                if (pendingIntent != null) {
                    u10.i(pendingIntent);
                }
                if (pendingIntent2 != null) {
                    u10.m(pendingIntent2);
                }
                notification = u10.b();
            } else {
                notification = a(charSequence, i12, i10, o10, uri, pendingIntent, pendingIntent2, p(b(bundle, "gcm.n.android_channel_id")));
            }
            b11 = b(bundle, "gcm.n.tag");
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Showing notification");
            }
            NotificationManager notificationManager = (NotificationManager) this.f12539a.getSystemService("notification");
            if (TextUtils.isEmpty(b11)) {
                long uptimeMillis = SystemClock.uptimeMillis();
                StringBuilder sb4 = new StringBuilder(37);
                sb4.append("FCM-Notification:");
                sb4.append(uptimeMillis);
                b11 = sb4.toString();
            }
            notificationManager.notify(b11, 0, notification);
            return true;
        }
        int i13 = d().getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i13 == 0 || !f(i13)) {
            i13 = this.f12539a.getApplicationInfo().icon;
        }
        if (i13 == 0 || !f(i13)) {
            i13 = 17301651;
        }
        i10 = i13;
        o10 = o(b(bundle, "gcm.n.color"));
        m10 = m(bundle);
        if (!TextUtils.isEmpty(m10)) {
        }
        b10 = b(bundle, "gcm.n.click_action");
        if (TextUtils.isEmpty(b10)) {
        }
        if (intent != null) {
        }
        if (!FirebaseMessagingService.l(bundle)) {
        }
        if (n.i()) {
        }
        k.d u102 = new k.d(this.f12539a).e(true).u(i10);
        if (!TextUtils.isEmpty(charSequence)) {
        }
        if (!TextUtils.isEmpty(i12)) {
        }
        if (o10 != null) {
        }
        if (uri != null) {
        }
        if (pendingIntent != null) {
        }
        if (pendingIntent2 != null) {
        }
        notification = u102.b();
        b11 = b(bundle, "gcm.n.tag");
        if (Log.isLoggable("FirebaseMessaging", 3)) {
        }
        NotificationManager notificationManager2 = (NotificationManager) this.f12539a.getSystemService("notification");
        if (TextUtils.isEmpty(b11)) {
        }
        notificationManager2.notify(b11, 0, notification);
        return true;
    }
}
