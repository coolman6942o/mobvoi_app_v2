package com.paypal.android.sdk;

import android.text.TextUtils;
/* loaded from: classes2.dex */
public final class f2 {

    /* renamed from: c  reason: collision with root package name */
    private static /* synthetic */ boolean f21226c = true;

    /* renamed from: a  reason: collision with root package name */
    private a f21227a;

    /* renamed from: b  reason: collision with root package name */
    private String f21228b;

    public f2(a aVar, String str) {
        if (f21226c || aVar != null) {
            this.f21227a = aVar;
            this.f21228b = "com.paypal.android.sdk.encr." + str + ".";
            return;
        }
        throw new AssertionError();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final dj a() {
        es a10;
        dj djVar;
        String a11 = this.f21227a.a(this.f21228b + "loginPhoneNumber");
        if (a11 != null) {
            try {
                a10 = es.a(a2.a(), a11);
            } catch (el unused) {
            }
            String a12 = this.f21227a.a(this.f21228b + "loginEmail");
            String a13 = this.f21227a.a(this.f21228b + "loginTypePrevious");
            djVar = new dj(a12, a10, !TextUtils.isEmpty(a13) ? null : dl.valueOf(a13));
            if (!djVar.g()) {
                return djVar;
            }
            return null;
        }
        a10 = null;
        String a122 = this.f21227a.a(this.f21228b + "loginEmail");
        String a132 = this.f21227a.a(this.f21228b + "loginTypePrevious");
        djVar = new dj(a122, a10, !TextUtils.isEmpty(a132) ? null : dl.valueOf(a132));
        if (!djVar.g()) {
        }
    }

    public final dq b(String str) {
        a aVar = this.f21227a;
        String a10 = aVar.a(this.f21228b + "tokenizedRedactedCardNumber");
        a aVar2 = this.f21227a;
        String a11 = aVar2.a(this.f21228b + "token");
        a aVar3 = this.f21227a;
        String a12 = aVar3.a(this.f21228b + "tokenPayerID");
        a aVar4 = this.f21227a;
        String a13 = aVar4.a(this.f21228b + "tokenValidUntil");
        a aVar5 = this.f21227a;
        String a14 = aVar5.a(this.f21228b + "tokenizedCardType");
        a aVar6 = this.f21227a;
        String a15 = aVar6.a(this.f21228b + "tokenizedCardExpiryMonth");
        int parseInt = a15 != null ? Integer.parseInt(a15) : 0;
        a aVar7 = this.f21227a;
        String a16 = aVar7.a(this.f21228b + "tokenizedCardExpiryYear");
        int parseInt2 = a16 != null ? Integer.parseInt(a16) : 0;
        a aVar8 = this.f21227a;
        String g10 = aVar8.g(aVar8.a(this.f21228b + "tokenClientId"));
        if (!y1.i(g10) && g10.equals(str)) {
            dq dqVar = new dq(a11, a12, a13, a10, a14, parseInt, parseInt2);
            if (dqVar.d()) {
                return dqVar;
            }
        }
        return null;
    }

    public final void c(dj djVar) {
        String str = null;
        String e10 = djVar.a() != null ? djVar.a().e() : null;
        a aVar = this.f21227a;
        aVar.b(this.f21228b + "loginPhoneNumber", e10);
        a aVar2 = this.f21227a;
        aVar2.b(this.f21228b + "loginEmail", djVar.e());
        if (djVar.f() != null) {
            str = djVar.f().toString();
        }
        a aVar3 = this.f21227a;
        aVar3.b(this.f21228b + "loginTypePrevious", str);
    }

    public final void d(dq dqVar, String str) {
        a aVar = this.f21227a;
        aVar.b(this.f21228b + "token", dqVar.h());
        a aVar2 = this.f21227a;
        aVar2.b(this.f21228b + "tokenPayerID", dqVar.a());
        String str2 = null;
        String format = dqVar.e() != null ? new eu().format(dqVar.e()) : null;
        a aVar3 = this.f21227a;
        aVar3.b(this.f21228b + "tokenValidUntil", format);
        a aVar4 = this.f21227a;
        aVar4.b(this.f21228b + "tokenizedRedactedCardNumber", dqVar.g());
        if (dqVar.k() != null) {
            str2 = dqVar.k().toString();
        }
        a aVar5 = this.f21227a;
        aVar5.b(this.f21228b + "tokenizedCardType", str2);
        a aVar6 = this.f21227a;
        aVar6.b(this.f21228b + "tokenizedCardExpiryMonth", String.valueOf(dqVar.i()));
        a aVar7 = this.f21227a;
        aVar7.b(this.f21228b + "tokenizedCardExpiryYear", String.valueOf(dqVar.j()));
        a aVar8 = this.f21227a;
        aVar8.b(this.f21228b + "tokenClientId", this.f21227a.e(str));
    }

    public final void e() {
        c(new dj());
    }

    public final void f() {
        d(new dq(), null);
    }
}
