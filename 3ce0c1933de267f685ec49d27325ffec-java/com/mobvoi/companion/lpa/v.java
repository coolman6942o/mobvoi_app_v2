package com.mobvoi.companion.lpa;

import android.content.Intent;
import android.os.Message;
import androidx.fragment.app.f;
import b1.a;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.s;
import kotlin.jvm.internal.i;
/* compiled from: SimOpenTutorialFragment.kt */
/* loaded from: classes2.dex */
public final class v implements s.a {

    /* renamed from: a  reason: collision with root package name */
    private final f f17241a;

    public v(f activity) {
        i.f(activity, "activity");
        this.f17241a = activity;
    }

    @Override // com.mobvoi.android.common.utils.s.a
    public void handleMessage(Message msg) {
        i.f(msg, "msg");
        if (msg.what == 0) {
            k.a("SimOpenTurorial", "enable profile waiting out of time, treat as fail");
            if (!this.f17241a.isDestroyed()) {
                a.b(this.f17241a).d(new Intent("enable_profile_fail"));
            }
        }
    }
}
