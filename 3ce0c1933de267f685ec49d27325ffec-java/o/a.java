package o;

import android.os.Bundle;
/* compiled from: CustomTabColorSchemeParams.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f31341a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f31342b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f31343c;

    /* renamed from: d  reason: collision with root package name */
    public final Integer f31344d;

    /* compiled from: CustomTabColorSchemeParams.java */
    /* renamed from: o.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0416a {

        /* renamed from: a  reason: collision with root package name */
        private Integer f31345a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f31346b;

        /* renamed from: c  reason: collision with root package name */
        private Integer f31347c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f31348d;

        public a a() {
            return new a(this.f31345a, this.f31346b, this.f31347c, this.f31348d);
        }

        public C0416a b(int i10) {
            this.f31345a = Integer.valueOf(i10 | (-16777216));
            return this;
        }
    }

    a(Integer num, Integer num2, Integer num3, Integer num4) {
        this.f31341a = num;
        this.f31342b = num2;
        this.f31343c = num3;
        this.f31344d = num4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f31341a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f31342b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f31343c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f31344d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
