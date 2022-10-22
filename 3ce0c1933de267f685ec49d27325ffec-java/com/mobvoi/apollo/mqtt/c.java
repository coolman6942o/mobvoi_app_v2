package com.mobvoi.apollo.mqtt;

import com.mobvoi.apollo.mqtt.a;
import kotlin.jvm.internal.i;
/* compiled from: Config.kt */
/* loaded from: classes2.dex */
public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private String f15578a = "";

    public String a() {
        return this.f15578a;
    }

    public String b() {
        return a.C0192a.a(this);
    }

    public String c() {
        return i.n("/ticwatch_falcon/", a());
    }

    public String d() {
        return a.C0192a.b(this);
    }

    public void e(String str) {
        i.f(str, "<set-?>");
        this.f15578a = str;
    }
}
