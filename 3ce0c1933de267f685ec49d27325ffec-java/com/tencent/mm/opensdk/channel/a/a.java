package com.tencent.mm.opensdk.channel.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.opensdk.constants.Build;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.utils.Log;
import com.tencent.mm.opensdk.utils.d;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: com.tencent.mm.opensdk.channel.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0252a {

        /* renamed from: a  reason: collision with root package name */
        public String f22454a;
        public String action;

        /* renamed from: b  reason: collision with root package name */
        public long f22455b;
        public Bundle bundle;
        public String content;
    }

    public static boolean a(Context context, C0252a aVar) {
        String str;
        if (context == null) {
            str = "send fail, invalid argument";
        } else if (d.b(aVar.action)) {
            str = "send fail, action is null";
        } else {
            String str2 = null;
            if (!d.b(aVar.f22454a)) {
                str2 = aVar.f22454a + ".permission.MM_MESSAGE";
            }
            Intent intent = new Intent(aVar.action);
            Bundle bundle = aVar.bundle;
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            String packageName = context.getPackageName();
            intent.putExtra(ConstantsAPI.SDK_VERSION, Build.SDK_INT);
            intent.putExtra(ConstantsAPI.APP_PACKAGE, packageName);
            intent.putExtra(ConstantsAPI.CONTENT, aVar.content);
            intent.putExtra(ConstantsAPI.APP_SUPORT_CONTENT_TYPE, aVar.f22455b);
            intent.putExtra(ConstantsAPI.CHECK_SUM, b.a(aVar.content, Build.SDK_INT, packageName));
            context.sendBroadcast(intent, str2);
            Log.d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str2);
            return true;
        }
        Log.e("MicroMsg.SDK.MMessage", str);
        return false;
    }
}
