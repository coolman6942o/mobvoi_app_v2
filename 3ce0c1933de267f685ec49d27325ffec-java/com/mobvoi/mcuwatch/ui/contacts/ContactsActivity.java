package com.mobvoi.mcuwatch.ui.contacts;

import aa.b;
import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.core.app.n;
import androidx.lifecycle.g0;
import androidx.lifecycle.x;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.wear.common.base.TicwatchModels;
import com.mobvoi.wear.info.SharedWearInfoHelper;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.l;
import sh.h;
import sh.j;
import sh.k;
/* compiled from: ContactsActivity.kt */
/* loaded from: classes2.dex */
public final class ContactsActivity extends d {

    /* renamed from: b  reason: collision with root package name */
    public static final a f19524b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final io.d f19525a = new g0(l.b(o.class), new ContactsActivity$special$$inlined$viewModels$default$2(this), new ContactsActivity$special$$inlined$viewModels$default$1(this));

    /* compiled from: ContactsActivity.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final void a() {
            Application context = b.e();
            Intent intent = new Intent(context, ContactsActivity.class);
            intent.putExtra("toAdd", true);
            intent.addFlags(268435456);
            if (bd.a.g().j() || Build.VERSION.SDK_INT < 29) {
                context.startActivity(intent);
                return;
            }
            PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
            i.e(context, "context");
            Notification b10 = new b.a(context, SharedWearInfoHelper.TaskInfo.TABLE).u(sh.f.f34582r1).k(TicwatchModels.TICWATCH_GTW_eSIM).j(context.getText(k.C0)).y(10000L).s(1).f("msg").o(activity, true).e(true).b();
            i.e(b10, "Builder(context, ChannelIds.TASK)\n                    .setSmallIcon(R.drawable.pic_watch_lite)\n                    .setContentTitle(TicwatchModels.TICWATCH_GTW_eSIM)\n                    .setContentText(context.getText(R.string.contacts_add_title))\n                    .setTimeoutAfter(10 * 1000)\n                    .setPriority(NotificationCompat.PRIORITY_HIGH)\n                    .setCategory(NotificationCompat.CATEGORY_MESSAGE)\n                    .setFullScreenIntent(fullScreenPendingIntent, true)\n                    .setAutoCancel(true)\n                    .build()");
            n.f(context).h(2395, b10);
        }
    }

    private final o I() {
        return (o) this.f19525a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(ContactsActivity this$0, Integer num) {
        i.f(this$0, "this$0");
        this$0.invalidateOptionsMenu();
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.m_res_0x7f0e0033;
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
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getSupportFragmentManager().l().b(h.A0, new l()).l();
        I().m().i(this, new x() { // from class: com.mobvoi.mcuwatch.ui.contacts.h
            @Override // androidx.lifecycle.x
            public final void a(Object obj) {
                ContactsActivity.J(ContactsActivity.this, (Integer) obj);
            }
        });
        n.f(this).b(2395);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        i.f(menu, "menu");
        getMenuInflater().inflate(j.f34768c, menu);
        menu.findItem(h.f34615b).setActionView(sh.i.T0);
        return super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        i.f(menu, "menu");
        MenuItem findItem = menu.findItem(h.f34615b);
        if (findItem != null) {
            Integer f10 = I().m().f();
            if (f10 != null && f10.intValue() == 0) {
                androidx.appcompat.app.a supportActionBar = getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.t(true);
                }
                androidx.appcompat.app.a supportActionBar2 = getSupportActionBar();
                if (supportActionBar2 != null) {
                    supportActionBar2.u(true);
                }
                findItem.setVisible(true);
            } else if (f10 != null && f10.intValue() == 1) {
                androidx.appcompat.app.a supportActionBar3 = getSupportActionBar();
                if (supportActionBar3 != null) {
                    supportActionBar3.t(true);
                }
                androidx.appcompat.app.a supportActionBar4 = getSupportActionBar();
                if (supportActionBar4 != null) {
                    supportActionBar4.u(true);
                }
                findItem.setVisible(false);
            } else if (f10 != null && f10.intValue() == 2) {
                androidx.appcompat.app.a supportActionBar5 = getSupportActionBar();
                if (supportActionBar5 != null) {
                    supportActionBar5.t(true);
                }
                androidx.appcompat.app.a supportActionBar6 = getSupportActionBar();
                if (supportActionBar6 != null) {
                    supportActionBar6.u(true);
                }
                findItem.setVisible(true);
            } else if (f10 != null && f10.intValue() == 4) {
                androidx.appcompat.app.a supportActionBar7 = getSupportActionBar();
                if (supportActionBar7 != null) {
                    supportActionBar7.t(true);
                }
                androidx.appcompat.app.a supportActionBar8 = getSupportActionBar();
                if (supportActionBar8 != null) {
                    supportActionBar8.u(true);
                }
                findItem.setVisible(true);
            } else if (f10 != null && f10.intValue() == 3) {
                androidx.appcompat.app.a supportActionBar9 = getSupportActionBar();
                if (supportActionBar9 != null) {
                    supportActionBar9.t(false);
                }
                androidx.appcompat.app.a supportActionBar10 = getSupportActionBar();
                if (supportActionBar10 != null) {
                    supportActionBar10.u(false);
                }
                findItem.setVisible(true);
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
