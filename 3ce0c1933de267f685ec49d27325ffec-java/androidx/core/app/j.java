package androidx.core.app;

import android.app.Notification;
import android.app.NotificationChannel;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import j0.h;
/* compiled from: NotificationChannelCompat.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    final String f2282a;

    /* renamed from: b  reason: collision with root package name */
    CharSequence f2283b;

    /* renamed from: c  reason: collision with root package name */
    int f2284c;

    /* renamed from: d  reason: collision with root package name */
    String f2285d;

    /* renamed from: e  reason: collision with root package name */
    String f2286e;

    /* renamed from: h  reason: collision with root package name */
    AudioAttributes f2289h;

    /* renamed from: i  reason: collision with root package name */
    boolean f2290i;

    /* renamed from: k  reason: collision with root package name */
    boolean f2292k;

    /* renamed from: l  reason: collision with root package name */
    long[] f2293l;

    /* renamed from: m  reason: collision with root package name */
    String f2294m;

    /* renamed from: n  reason: collision with root package name */
    String f2295n;

    /* renamed from: f  reason: collision with root package name */
    boolean f2287f = true;

    /* renamed from: g  reason: collision with root package name */
    Uri f2288g = Settings.System.DEFAULT_NOTIFICATION_URI;

    /* renamed from: j  reason: collision with root package name */
    int f2291j = 0;

    /* compiled from: NotificationChannelCompat.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final j f2296a;

        public a(String str, int i10) {
            this.f2296a = new j(str, i10);
        }

        public j a() {
            return this.f2296a;
        }

        public a b(CharSequence charSequence) {
            this.f2296a.f2283b = charSequence;
            return this;
        }
    }

    j(String str, int i10) {
        this.f2282a = (String) h.g(str);
        this.f2284c = i10;
        if (Build.VERSION.SDK_INT >= 21) {
            this.f2289h = Notification.AUDIO_ATTRIBUTES_DEFAULT;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NotificationChannel a() {
        String str;
        String str2;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            return null;
        }
        NotificationChannel notificationChannel = new NotificationChannel(this.f2282a, this.f2283b, this.f2284c);
        notificationChannel.setDescription(this.f2285d);
        notificationChannel.setGroup(this.f2286e);
        notificationChannel.setShowBadge(this.f2287f);
        notificationChannel.setSound(this.f2288g, this.f2289h);
        notificationChannel.enableLights(this.f2290i);
        notificationChannel.setLightColor(this.f2291j);
        notificationChannel.setVibrationPattern(this.f2293l);
        notificationChannel.enableVibration(this.f2292k);
        if (!(i10 < 30 || (str = this.f2294m) == null || (str2 = this.f2295n) == null)) {
            notificationChannel.setConversationId(str, str2);
        }
        return notificationChannel;
    }
}
