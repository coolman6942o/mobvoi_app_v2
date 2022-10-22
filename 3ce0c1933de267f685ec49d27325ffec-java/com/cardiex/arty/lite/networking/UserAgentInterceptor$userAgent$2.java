package com.cardiex.arty.lite.networking;

import android.content.Context;
import kotlin.jvm.internal.Lambda;
import qo.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UserAgentInterceptor.kt */
/* loaded from: classes.dex */
public final class UserAgentInterceptor$userAgent$2 extends Lambda implements a<String> {
    final /* synthetic */ Context $context;
    final /* synthetic */ UserAgentInterceptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAgentInterceptor$userAgent$2(UserAgentInterceptor userAgentInterceptor, Context context) {
        super(0);
        this.this$0 = userAgentInterceptor;
        this.$context = context;
    }

    @Override // qo.a
    public final String invoke() {
        String buildUserAgent;
        buildUserAgent = this.this$0.buildUserAgent(this.$context);
        return buildUserAgent;
    }
}
