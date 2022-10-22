package com.mobvoi.companion.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.ui.ScoringDialogActivity;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: AlarmReceiver.kt */
/* loaded from: classes2.dex */
public final class AlarmReceiver extends BroadcastReceiver {

    /* compiled from: AlarmReceiver.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        i.f(context, "context");
        i.f(intent, "intent");
        k.d("AlarmReceiver", "checkShowAppShare onReceive ");
        if (bd.a.g().j()) {
            ScoringDialogActivity.f17627b.a(context, !com.mobvoi.companion.base.settings.a.isOversea());
        }
    }
}
