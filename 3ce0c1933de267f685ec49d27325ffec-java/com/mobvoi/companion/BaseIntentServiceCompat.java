package com.mobvoi.companion;

import aa.b;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.k;
import androidx.core.content.b;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: BaseIntentServiceCompat.kt */
/* loaded from: classes2.dex */
public abstract class BaseIntentServiceCompat extends IntentService {
    public static final Companion Companion = new Companion(null);

    /* compiled from: BaseIntentServiceCompat.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final void start(Context ctx, Intent intent) {
            i.f(ctx, "ctx");
            i.f(intent, "intent");
            b.n(ctx, intent);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseIntentServiceCompat(String name) {
        super(name);
        i.f(name, "name");
    }

    public static /* synthetic */ void getChannelId$annotations() {
    }

    public static final void start(Context context, Intent intent) {
        Companion.start(context, intent);
    }

    private final void startForeground() {
        if (Build.VERSION.SDK_INT >= 26) {
            startForeground(getNotificationId(), createNotificationBuilder().b());
        }
    }

    public k.d createNotificationBuilder() {
        k.d j10 = new b.a(this, getChannelId()).u(getIconResId()).k(getContentTitle()).j(getContentText());
        i.e(j10, "Builder(this, channelId)\n                .setSmallIcon(iconResId)\n                .setContentTitle(contentTitle)\n                .setContentText(contentText)");
        return j10;
    }

    public abstract String getChannelId();

    public String getContentText() {
        String string = getString(R.string.sync_during_subtitle);
        i.e(string, "getString(R.string.sync_during_subtitle)");
        return string;
    }

    public String getContentTitle() {
        String a10 = yd.b.a(this);
        i.e(a10, "getApplicationName(this)");
        return a10;
    }

    public int getIconResId() {
        return Build.VERSION.SDK_INT > 20 ? R.drawable.tic : R.drawable.ic_launcher;
    }

    public abstract int getNotificationId();

    @Override // android.app.IntentService, android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        startForeground();
        return super.onStartCommand(intent, i10, i11);
    }
}
