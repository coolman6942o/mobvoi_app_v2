package com.mobvoi.companion.lpa;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.c;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import androidx.fragment.app.w;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.companion.R;
import com.mobvoi.companion.setting.CompanionSetting;
import kotlin.jvm.internal.i;
/* compiled from: SimOpenTutorialModule.kt */
/* loaded from: classes2.dex */
public final class p0 {

    /* compiled from: SimOpenTutorialModule.kt */
    /* loaded from: classes2.dex */
    public static final class a extends BroadcastReceiver {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f17236a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ s f17237b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ f f17238c;

        a(c cVar, s sVar, f fVar) {
            this.f17236a = cVar;
            this.f17237b = sVar;
            this.f17238c = fVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Fragment fragment;
            i.f(context, "context");
            i.f(intent, "intent");
            if (this.f17236a.isShowing()) {
                this.f17236a.dismiss();
            }
            this.f17237b.removeCallbacksAndMessages(null);
            boolean z10 = true;
            if (i.b("stop_show_wait_dialog", intent.getAction())) {
                CompanionSetting.setUnicomProfileEnableStatus(true);
                return;
            }
            if (!i.b("enable_profile_sucess", intent.getAction())) {
                i.b("enable_profile_fail", intent.getAction());
                z10 = false;
            }
            CompanionSetting.setUnicomProfileEnableStatus(z10);
            w l10 = this.f17238c.getSupportFragmentManager().l();
            i.e(l10, "activity.supportFragmentManager.beginTransaction()");
            if (z10) {
                fragment = new e();
            } else {
                fragment = new c();
            }
            l10.s(R.id.fragment, fragment);
            l10.k();
        }
    }

    public final BroadcastReceiver a(f activity, c loadingDialog, s countDownHandler) {
        i.f(activity, "activity");
        i.f(loadingDialog, "loadingDialog");
        i.f(countDownHandler, "countDownHandler");
        return new a(loadingDialog, countDownHandler, activity);
    }

    public final s b(f activity) {
        i.f(activity, "activity");
        return new s(new v(activity));
    }

    public final c c(f activity) {
        i.f(activity, "activity");
        return com.mobvoi.companion.base.m3.f.f16573a.a(activity, R.string.enable_now);
    }
}
