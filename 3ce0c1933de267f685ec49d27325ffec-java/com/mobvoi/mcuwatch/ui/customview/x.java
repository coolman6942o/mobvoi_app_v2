package com.mobvoi.mcuwatch.ui.customview;

import aa.b;
import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.n;
import bd.a;
import bn.c;
import com.mobvoi.apollo.client.q;
import com.mobvoi.apollo.protocol.model.Sms;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import sh.h;
import sh.k;
import sh.l;
/* compiled from: ReplySmsDialog.kt */
/* loaded from: classes2.dex */
public final class x extends Dialog {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19697b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final Sms f19698a;

    /* compiled from: ReplySmsDialog.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* compiled from: ReplySmsDialog.kt */
        /* renamed from: com.mobvoi.mcuwatch.ui.customview.x$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0226a implements a.b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Sms f19699a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f19700b;

            C0226a(Sms sms, Context context) {
                this.f19699a = sms;
                this.f19700b = context;
            }

            @Override // bd.a.b
            public void a(Activity activity) {
                i.f(activity, "activity");
                new x(activity, this.f19699a).show();
                bd.a.g().k(this);
                n.f(this.f19700b).b(2396);
            }

            @Override // bd.a.b
            public void b() {
            }
        }

        /* compiled from: ReplySmsDialog.kt */
        /* loaded from: classes2.dex */
        public static final class b implements Application.ActivityLifecycleCallbacks {

            /* renamed from: a  reason: collision with root package name */
            private String f19701a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ PackageManager f19702b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Context f19703c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ Sms f19704d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ Application f19705e;

            b(PackageManager packageManager, Context context, Sms sms, Application application) {
                this.f19702b = packageManager;
                this.f19703c = context;
                this.f19704d = sms;
                this.f19705e = application;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityCreated(Activity activity, Bundle bundle) {
                Object obj;
                i.f(activity, "activity");
                if (this.f19701a == null) {
                    List<ResolveInfo> queryIntentActivities = this.f19702b.queryIntentActivities(new Intent("com.mobvoi.action.DEVICE"), WXMediaMessage.THUMB_LENGTH_LIMIT);
                    i.e(queryIntentActivities, "packageManager.queryIntentActivities(mainIntent, PackageManager.MATCH_DEFAULT_ONLY)");
                    Context context = this.f19703c;
                    Iterator<T> it = queryIntentActivities.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (i.b(((ResolveInfo) obj).activityInfo.packageName, ((Application) context).getPackageName())) {
                            break;
                        }
                    }
                    ResolveInfo resolveInfo = (ResolveInfo) obj;
                    if (resolveInfo != null) {
                        this.f19701a = resolveInfo.activityInfo.name;
                    }
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityDestroyed(Activity activity) {
                i.f(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPaused(Activity activity) {
                i.f(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityResumed(Activity activity) {
                i.f(activity, "activity");
                if (i.b(this.f19701a, activity.getComponentName().getClassName())) {
                    new x(activity, this.f19704d).show();
                    this.f19705e.unregisterActivityLifecycleCallbacks(this);
                }
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
                i.f(activity, "activity");
                i.f(outState, "outState");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStarted(Activity activity) {
                i.f(activity, "activity");
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityStopped(Activity activity) {
                i.f(activity, "activity");
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a(Context context, Sms sms) {
            i.f(context, "context");
            i.f(sms, "sms");
            if (bd.a.g().j()) {
                Activity h10 = bd.a.g().h();
                if (h10 != null) {
                    new x(h10, sms).show();
                }
            } else if (bd.a.g().f().size() > 0) {
                bd.a.g().e(new C0226a(sms, context));
                Activity h11 = bd.a.g().h();
                if (h11 != null) {
                    Intent intent = new Intent();
                    intent.setComponent(h11.getComponentName());
                    intent.addFlags(67108864);
                    intent.addFlags(536870912);
                    if (Build.VERSION.SDK_INT < 29) {
                        h11.startActivity(intent);
                        return;
                    }
                    Notification b10 = new b.a(context, SharedWearInfoHelper.TaskInfo.TABLE).u(sh.f.f34582r1).k(TicwatchModels.TICWATCH_GTW_eSIM).j(context.getText(k.f34815i2)).y(10000L).s(1).f("msg").o(PendingIntent.getActivity(context, 0, intent, 134217728), true).e(true).b();
                    i.e(b10, "Builder(context, ChannelIds.TASK)\n                                .setSmallIcon(R.drawable.pic_watch_lite)\n                                .setContentTitle(TicwatchModels.TICWATCH_GTW_eSIM)\n                                .setContentText(context.getText(R.string.reply_sms))\n                                .setTimeoutAfter(10 * 1000)\n                                .setPriority(NotificationCompat.PRIORITY_HIGH)\n                                .setCategory(NotificationCompat.CATEGORY_MESSAGE)\n                                .setFullScreenIntent(fullScreenPendingIntent, true)\n                                .setAutoCancel(true)\n                                .build()");
                    n.f(context).h(2396, b10);
                }
            } else {
                PackageManager packageManager = context.getPackageManager();
                Objects.requireNonNull(packageManager, "null cannot be cast to non-null type android.content.pm.PackageManager");
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(context.getPackageName());
                if (launchIntentForPackage != null) {
                    Application application = (Application) context;
                    application.registerActivityLifecycleCallbacks(new b(packageManager, context, sms, application));
                    launchIntentForPackage.addFlags(268435456);
                    context.startActivity(launchIntentForPackage);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(Context context, Sms sms) {
        super(context, l.f34906d);
        i.f(context, "context");
        i.f(sms, "sms");
        this.f19698a = sms;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(EditText editText, x this$0, View view) {
        boolean s10;
        i.f(this$0, "this$0");
        String obj = editText.getText().toString();
        if (!(obj.length() == 0)) {
            s10 = t.s(obj);
            if (!s10) {
                q.f15504a.Q(Sms.copy$default(this$0.b(), null, null, obj, 3, null));
                this$0.dismiss();
                return;
            }
        }
        Toast.makeText(this$0.getContext(), k.f34820j2, 0).show();
    }

    public final Sms b() {
        return this.f19698a;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(sh.i.T);
        ((TextView) findViewById(h.f34647h4)).setText(getContext().getString(k.f34825k2, this.f19698a.getNum()));
        final EditText editText = (EditText) findViewById(h.V0);
        ((ImageButton) findViewById(h.b0_res_0x7f0b0136)).setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.customview.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x.c(editText, this, view);
            }
        });
        Window window = getWindow();
        if (window != null) {
            window.setGravity(17);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = c.b(getContext()) - c.a(getContext(), 32);
            window.setAttributes(attributes);
        }
    }
}
