package com.mobvoi.assistant.account;

import android.text.TextUtils;
import ra.g;
/* loaded from: classes2.dex */
public class AccountConstant {

    /* renamed from: a  reason: collision with root package name */
    private static String f15614a;

    /* renamed from: b  reason: collision with root package name */
    private static String f15615b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f15616c;

    /* renamed from: d  reason: collision with root package name */
    private static g f15617d;

    /* loaded from: classes2.dex */
    public enum Sex {
        MALE,
        FEMALE
    }

    public static String a() {
        return f15614a;
    }

    public static g b() {
        g gVar = f15617d;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalArgumentException("please init common param first");
    }

    public static boolean c() {
        return f15616c;
    }

    public static String d(String str) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            char c10 = 65535;
            switch (str.hashCode()) {
                case -2090751111:
                    if (str.equals("rest_change_pwd")) {
                        c10 = 0;
                        break;
                    }
                    break;
                case -1161142878:
                    if (str.equals("rest_reset_pwd")) {
                        c10 = 1;
                        break;
                    }
                    break;
                case -971779561:
                    if (str.equals("rest_bind_third_party")) {
                        c10 = 2;
                        break;
                    }
                    break;
                case 173405693:
                    if (str.equals("rest_register_third_party")) {
                        c10 = 3;
                        break;
                    }
                    break;
                case 543051506:
                    if (str.equals("rest_sign_up")) {
                        c10 = 4;
                        break;
                    }
                    break;
                case 1986433207:
                    if (str.equals("update_account")) {
                        c10 = 5;
                        break;
                    }
                    break;
            }
            switch (c10) {
                case 0:
                case 1:
                    return "reset_pwd";
                case 2:
                case 3:
                    return "bind";
                case 4:
                    return "register";
                case 5:
                    return "rebind";
            }
        }
        return "";
    }

    public static String e() {
        return f15615b;
    }

    public static void f(g gVar) {
        f15617d = gVar;
    }
}
