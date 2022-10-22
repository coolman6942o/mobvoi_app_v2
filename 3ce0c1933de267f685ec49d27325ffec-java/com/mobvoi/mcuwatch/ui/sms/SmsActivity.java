package com.mobvoi.mcuwatch.ui.sms;

import aa.b;
import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.n;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import sh.d;
import sh.h;
import sh.j;
import sh.k;
import wi.e;
/* compiled from: SmsActivity.kt */
/* loaded from: classes2.dex */
public final class SmsActivity extends e<m> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f20218b = new a(null);

    /* compiled from: SmsActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a() {
            Application context = b.e();
            Intent intent = new Intent(context, SmsActivity.class);
            intent.addFlags(268435456);
            if (bd.a.g().j() || Build.VERSION.SDK_INT < 29) {
                context.startActivity(intent);
                return;
            }
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
            i.e(context, "context");
            Notification b10 = new b.a(context, SharedWearInfoHelper.TaskInfo.TABLE).u(sh.f.f34582r1).k(TicwatchModels.TICWATCH_GTW_eSIM).j(context.getText(k.H1)).y(10000L).s(1).f("msg").o(activity, true).e(true).b();
            i.e(b10, "Builder(context, ChannelIds.TASK)\n                    .setSmallIcon(R.drawable.pic_watch_lite)\n                    .setContentTitle(TicwatchModels.TICWATCH_GTW_eSIM)\n                    .setContentText(context.getText(R.string.new_sms_edit))\n                    .setTimeoutAfter(10 * 1000)\n                    .setPriority(NotificationCompat.PRIORITY_HIGH)\n                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)\n                    .setFullScreenIntent(fullScreenPendingIntent, true)\n                    .setAutoCancel(true)\n                    .build()");
            n.f(context).h(2397, b10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(SmsActivity this$0, View view) {
        i.f(this$0, "this$0");
        this$0.onBackPressed();
    }

    @Override // wi.e
    protected Class<m> I() {
        return m.class;
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.G;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getSupportFragmentManager().n0() > 0) {
            getSupportFragmentManager().W0();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.e, com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Toolbar toolbar = getToolbar();
        if (toolbar != null) {
            toolbar.setNavigationIcon((Drawable) null);
        }
        View inflate = getLayoutInflater().inflate(sh.i.T0, (ViewGroup) getToolbar(), false);
        Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) inflate;
        textView.setText(k.f34848p0);
        textView.setTextColor(textView.getContext().getColor(d.G));
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.sms.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmsActivity.M(SmsActivity.this, view);
            }
        });
        Toolbar toolbar2 = getToolbar();
        if (toolbar2 != null) {
            toolbar2.addView(textView);
        }
        getSupportFragmentManager().l().b(h.A0, new d()).j();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        i.f(menu, "menu");
        getMenuInflater().inflate(j.f34768c, menu);
        menu.findItem(h.f34615b).setActionView(sh.i.T0);
        return super.onCreateOptionsMenu(menu);
    }
}
