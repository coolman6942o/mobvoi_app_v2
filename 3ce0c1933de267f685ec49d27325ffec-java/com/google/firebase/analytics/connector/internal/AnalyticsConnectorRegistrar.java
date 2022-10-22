package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import b8.a;
import b8.e;
import b8.f;
import java.util.Collections;
import java.util.List;
@Keep
/* loaded from: classes.dex */
public class AnalyticsConnectorRegistrar implements e {
    @Override // b8.e
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<a<?>> getComponents() {
        return Collections.singletonList(a.a(z7.a.class).a(f.a(com.google.firebase.a.class)).a(f.a(Context.class)).d(a.f12422a).c());
    }
}
