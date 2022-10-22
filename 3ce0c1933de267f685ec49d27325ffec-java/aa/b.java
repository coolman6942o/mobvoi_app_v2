package aa;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.k;
import com.mobvoi.companion.common.analytics.Module;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import java.util.Objects;
import kotlin.jvm.internal.i;
/* compiled from: NotificationCompatHelper.kt */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f163a = new b();

    /* compiled from: NotificationCompatHelper.kt */
    /* loaded from: classes2.dex */
    public static final class a extends k.d {
        private final Context W;
        private final String X;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context ctx, String channelId) {
            super(ctx, channelId);
            i.f(ctx, "ctx");
            i.f(channelId, "channelId");
            this.W = ctx;
            this.X = channelId;
        }

        @Override // androidx.core.app.k.d
        public Notification b() {
            b.f163a.e(this.W, this.X);
            Notification b10 = super.b();
            i.e(b10, "super.build()");
            return b10;
        }
    }

    private b() {
    }

    private final void a(String str, String str2, NotificationManager notificationManager) {
        NotificationChannel notificationChannel = new NotificationChannel(str, i(str), 4);
        notificationChannel.setDescription(f(str));
        notificationChannel.setGroup(str2);
        if (TextUtils.equals(str, SharedWearInfoHelper.TaskInfo.TABLE)) {
            notificationChannel.shouldVibrate();
        }
        notificationManager.createNotificationChannel(notificationChannel);
    }

    private final void b(String str, String str2, NotificationManager notificationManager) {
        NotificationChannel notificationChannel = new NotificationChannel(str, i(str), 2);
        notificationChannel.setDescription(f(str));
        notificationChannel.setGroup(str2);
        notificationManager.createNotificationChannel(notificationChannel);
    }

    private final void c(String str, String str2, NotificationManager notificationManager) {
        if (TextUtils.equals(str, "bluetooth")) {
            b(str, str2, notificationManager);
        } else if (TextUtils.equals(str, SharedWearInfoHelper.TaskInfo.TABLE)) {
            a(str, str2, notificationManager);
        } else {
            NotificationChannel notificationChannel = new NotificationChannel(str, i(str), 3);
            notificationChannel.setDescription(f(str));
            notificationChannel.setGroup(str2);
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }

    private final void d(String str, NotificationManager notificationManager) {
        notificationManager.createNotificationChannelGroup(new NotificationChannelGroup(str, h(str)));
    }

    private final String f(String str) {
        Application e10 = com.mobvoi.android.common.utils.b.e();
        switch (str.hashCode()) {
            case -1419699188:
                if (str.equals("agenda")) {
                    return e10.getString(y9.i.f36836c);
                }
                break;
            case 3452698:
                if (str.equals("push")) {
                    return e10.getString(y9.i.f36851r);
                }
                break;
            case 97619233:
                if (str.equals("forum")) {
                    return e10.getString(y9.i.f36840g);
                }
                break;
            case 1901043637:
                if (str.equals(SharedWearInfoHelper.LocationInfo.TABLE)) {
                    return e10.getString(y9.i.f36847n);
                }
                break;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007c A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0091 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String g(String str) {
        switch (str.hashCode()) {
            case -1419699188:
                return !str.equals("agenda") ? "other" : "general";
            case -1177318867:
                if (!str.equals("account")) {
                }
                break;
            case -791770330:
                if (str.equals(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE)) {
                    return "message";
                }
                break;
            case 3616:
                if (!str.equals("qq")) {
                }
                break;
            case 82233:
                if (!str.equals("SMS")) {
                }
                break;
            case 3045982:
                if (!str.equals("call")) {
                }
                break;
            case 3452698:
                if (!str.equals("push")) {
                }
                break;
            case 3545755:
                if (str.equals("sync")) {
                    return Module.DEVICE;
                }
                break;
            case 3552645:
                if (!str.equals(SharedWearInfoHelper.TaskInfo.TABLE)) {
                }
                break;
            case 97619233:
                if (!str.equals("forum")) {
                }
                break;
            case 103772132:
                if (!str.equals("media")) {
                }
                break;
            case 126586346:
                if (!str.equals("kids_chat")) {
                }
                break;
            case 1901043637:
                if (!str.equals(SharedWearInfoHelper.LocationInfo.TABLE)) {
                }
                break;
            case 1968882350:
                if (!str.equals("bluetooth")) {
                }
                break;
        }
    }

    private final String h(String str) {
        Application e10 = com.mobvoi.android.common.utils.b.e();
        int hashCode = str.hashCode();
        if (hashCode != -1335157162) {
            if (hashCode != -80148248) {
                if (hashCode == 954925063 && str.equals("message")) {
                    String string = e10.getString(y9.i.f36843j);
                    i.e(string, "appContext.getString(R.string.channel_group_message)");
                    return string;
                }
            } else if (str.equals("general")) {
                String string2 = e10.getString(y9.i.f36842i);
                i.e(string2, "appContext.getString(R.string.channel_group_general)");
                return string2;
            }
        } else if (str.equals(Module.DEVICE)) {
            String string3 = e10.getString(y9.i.f36841h);
            i.e(string3, "appContext.getString(R.string.channel_group_device)");
            return string3;
        }
        String string4 = e10.getString(y9.i.f36844k);
        i.e(string4, "appContext.getString(R.string.channel_group_other)");
        return string4;
    }

    private final String i(String str) {
        Application e10 = com.mobvoi.android.common.utils.b.e();
        switch (str.hashCode()) {
            case -1419699188:
                if (str.equals("agenda")) {
                    String string = e10.getString(y9.i.f36835b);
                    i.e(string, "appContext.getString(R.string.channel_agenda)");
                    return string;
                }
                break;
            case -1177318867:
                if (str.equals("account")) {
                    String string2 = e10.getString(y9.i.f36834a);
                    i.e(string2, "appContext.getString(R.string.channel_account)");
                    return string2;
                }
                break;
            case -791770330:
                if (str.equals(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_VALUE)) {
                    String string3 = e10.getString(y9.i.f36856w);
                    i.e(string3, "appContext.getString(R.string.channel_wechat)");
                    return string3;
                }
                break;
            case 3616:
                if (str.equals("qq")) {
                    String string4 = e10.getString(y9.i.f36852s);
                    i.e(string4, "appContext.getString(R.string.channel_qq)");
                    return string4;
                }
                break;
            case 82233:
                if (str.equals("SMS")) {
                    String string5 = e10.getString(y9.i.f36853t);
                    i.e(string5, "appContext.getString(R.string.channel_sms)");
                    return string5;
                }
                break;
            case 3045982:
                if (str.equals("call")) {
                    String string6 = e10.getString(y9.i.f36838e);
                    i.e(string6, "appContext.getString(R.string.channel_call)");
                    return string6;
                }
                break;
            case 3452698:
                if (str.equals("push")) {
                    String string7 = e10.getString(y9.i.f36850q);
                    i.e(string7, "appContext.getString(R.string.channel_push)");
                    return string7;
                }
                break;
            case 3545755:
                if (str.equals("sync")) {
                    String string8 = e10.getString(y9.i.f36854u);
                    i.e(string8, "appContext.getString(R.string.channel_sync)");
                    return string8;
                }
                break;
            case 3552645:
                if (str.equals(SharedWearInfoHelper.TaskInfo.TABLE)) {
                    String string9 = e10.getString(y9.i.f36855v);
                    i.e(string9, "appContext.getString(R.string.channel_task)");
                    return string9;
                }
                break;
            case 97619233:
                if (str.equals("forum")) {
                    String string10 = e10.getString(y9.i.f36839f);
                    i.e(string10, "appContext.getString(R.string.channel_forum)");
                    return string10;
                }
                break;
            case 103772132:
                if (str.equals("media")) {
                    String string11 = e10.getString(y9.i.f36848o);
                    i.e(string11, "appContext.getString(R.string.channel_media)");
                    return string11;
                }
                break;
            case 126586346:
                if (str.equals("kids_chat")) {
                    String string12 = e10.getString(y9.i.f36845l);
                    i.e(string12, "appContext.getString(R.string.channel_kids_chat)");
                    return string12;
                }
                break;
            case 1901043637:
                if (str.equals(SharedWearInfoHelper.LocationInfo.TABLE)) {
                    String string13 = e10.getString(y9.i.f36846m);
                    i.e(string13, "appContext.getString(R.string.channel_location)");
                    return string13;
                }
                break;
            case 1968882350:
                if (str.equals("bluetooth")) {
                    String string14 = e10.getString(y9.i.f36837d);
                    i.e(string14, "appContext.getString(R.string.channel_bluetooth)");
                    return string14;
                }
                break;
        }
        String string15 = e10.getString(y9.i.f36849p);
        i.e(string15, "appContext.getString(R.string.channel_other)");
        return string15;
    }

    public final void e(Context ctx, String id2) {
        i.f(ctx, "ctx");
        i.f(id2, "id");
        if (Build.VERSION.SDK_INT >= 26) {
            String g10 = g(id2);
            Object systemService = ctx.getSystemService("notification");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            NotificationManager notificationManager = (NotificationManager) systemService;
            d(g10, notificationManager);
            c(id2, g10, notificationManager);
        }
    }
}
