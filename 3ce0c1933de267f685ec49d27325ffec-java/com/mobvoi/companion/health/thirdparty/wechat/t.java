package com.mobvoi.companion.health.thirdparty.wechat;

import android.content.Context;
import com.google.gson.e;
import eg.h;
import java.util.HashMap;
/* compiled from: WeChatSportSettings.java */
/* loaded from: classes2.dex */
public class t {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: WeChatSportSettings.java */
    /* loaded from: classes2.dex */
    public class a extends com.google.gson.reflect.a<HashMap<String, String>> {
        a() {
        }
    }

    public static String a(Context context) {
        return (String) h.a(context, "account_info").b("key_device_id", "");
    }

    public static String b(Context context, String str) {
        HashMap<String, String> f10 = f(e(context));
        return f10 == null ? "" : f10.get(str);
    }

    public static boolean c(Context context) {
        return ((Boolean) h.a(context, "account_info").b("key_enabled", Boolean.FALSE)).booleanValue();
    }

    public static String d(Context context) {
        return (String) h.a(context, "account_info").b("key_enabled_device_id", "");
    }

    private static String e(Context context) {
        return (String) h.a(context, "account_info").b("key_device_id_map", "");
    }

    private static HashMap<String, String> f(String str) {
        return (HashMap) new e().k(str, new a().getType());
    }

    private static void g(Context context, String str) {
        h.a(context, "account_info").c("key_device_id_map", str);
    }

    public static void h(Context context, String str) {
        h.a(context, "account_info").c("key_device_id", str);
        k(context, str);
    }

    public static void i(Context context, String str, String str2) {
        HashMap<String, String> f10 = f(e(context));
        if (f10 == null) {
            f10 = new HashMap<>();
        }
        f10.put(str, str2);
        g(context, new e().s(f10));
        k(context, str2);
    }

    public static void j(Context context, boolean z10) {
        h.a(context, "account_info").c("key_enabled", Boolean.valueOf(z10));
    }

    public static void k(Context context, String str) {
        h.a(context, "account_info").c("key_enabled_device_id", str);
    }

    public static void l(Context context, String str) {
        h.a(context, "account_info").c("key_ticket", str);
    }
}
