package com.mobvoi.companion.health.viewholder;

import android.content.Context;
import android.content.Intent;
import com.mobvoi.companion.browser.BasicBrowserActivity;
import com.unionpay.tsmservice.data.Constant;
import kotlin.jvm.internal.i;
/* compiled from: HealthCardReportViewHolder.kt */
/* loaded from: classes2.dex */
public final class g {
    public static final void a(Context context, String url) {
        i.f(context, "<this>");
        i.f(url, "url");
        Intent intent = new Intent("com.mobvoi.action.OPEN_BROWSER_SHARE");
        intent.putExtra("url", url);
        intent.putExtra(Constant.KEY_PARAMS, true);
        intent.putExtra(BasicBrowserActivity.KEY_FLAG_GOBACK, false);
        intent.setPackage(context.getPackageName());
        intent.setFlags(268435456);
        if (intent.resolveActivity(context.getPackageManager()) != null) {
            context.startActivity(intent);
        }
    }
}
