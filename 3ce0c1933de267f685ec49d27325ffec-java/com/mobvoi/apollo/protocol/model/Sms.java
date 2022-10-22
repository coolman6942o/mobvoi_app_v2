package com.mobvoi.apollo.protocol.model;

import com.mobvoi.android.common.json.JsonBean;
import kotlin.jvm.internal.i;
/* compiled from: Sms.kt */
/* loaded from: classes2.dex */
public final class Sms implements JsonBean {
    private final String name;
    private final String num;
    private final String text;

    public Sms(String str, String num, String text) {
        i.f(num, "num");
        i.f(text, "text");
        this.name = str;
        this.num = num;
        this.text = text;
    }

    public static /* synthetic */ Sms copy$default(Sms sms, String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = sms.name;
        }
        if ((i10 & 2) != 0) {
            str2 = sms.num;
        }
        if ((i10 & 4) != 0) {
            str3 = sms.text;
        }
        return sms.copy(str, str2, str3);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.num;
    }

    public final String component3() {
        return this.text;
    }

    public final Sms copy(String str, String num, String text) {
        i.f(num, "num");
        i.f(text, "text");
        return new Sms(str, num, text);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Sms)) {
            return false;
        }
        Sms sms = (Sms) obj;
        return i.b(this.name, sms.name) && i.b(this.num, sms.num) && i.b(this.text, sms.text);
    }

    public final String getName() {
        return this.name;
    }

    public final String getNum() {
        return this.num;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.name;
        return ((((str == null ? 0 : str.hashCode()) * 31) + this.num.hashCode()) * 31) + this.text.hashCode();
    }

    public String toString() {
        return "Sms(name=" + ((Object) this.name) + ", num=" + this.num + ", text=" + this.text + ')';
    }
}
