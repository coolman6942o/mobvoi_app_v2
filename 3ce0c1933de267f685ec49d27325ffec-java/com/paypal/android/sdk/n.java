package com.paypal.android.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import java.util.List;
/* loaded from: classes2.dex */
public class n extends k {
    /* JADX INFO: Access modifiers changed from: protected */
    public static Intent c(String str, String str2) {
        Intent intent = new Intent(str);
        intent.setComponent(ComponentName.unflattenFromString(str2));
        intent.setPackage("com.paypal.android.p2pmobile");
        return intent;
    }

    public final boolean d(Context context, String str, String str2) {
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(c(str, str2), 0);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    public final boolean e(Context context, boolean z10) {
        return a(context, z10, "com.paypal.android.p2pmobile", "O=Paypal", "O=Paypal", 34172764);
    }
}
