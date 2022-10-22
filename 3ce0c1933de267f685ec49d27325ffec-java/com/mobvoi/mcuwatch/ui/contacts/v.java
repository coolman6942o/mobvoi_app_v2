package com.mobvoi.mcuwatch.ui.contacts;

import kotlin.jvm.internal.i;
import kotlin.text.t;
/* compiled from: PhoneWatcher.kt */
/* loaded from: classes2.dex */
public final class v {
    public static final String a(String str) {
        String z10;
        i.f(str, "<this>");
        z10 = t.z(str, " ", "", false, 4, null);
        return z10;
    }

    public static final String b(String str) {
        i.f(str, "<this>");
        StringBuilder sb2 = new StringBuilder(str);
        if (str.length() > 3) {
            sb2.insert(3, " ");
        } else if (str.length() > 8) {
            sb2.insert(8, " ");
        }
        String sb3 = sb2.toString();
        i.e(sb3, "sb.toString()");
        return sb3;
    }
}
