package com.paypal.android.sdk.payments;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.paypal.android.sdk.n0;
import com.paypal.android.sdk.y1;
/* loaded from: classes2.dex */
public final class PayPalConfiguration implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    private String f21537a;

    /* renamed from: b  reason: collision with root package name */
    private String f21538b;

    /* renamed from: c  reason: collision with root package name */
    private String f21539c;

    /* renamed from: d  reason: collision with root package name */
    private String f21540d;

    /* renamed from: e  reason: collision with root package name */
    private String f21541e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f21542f;

    /* renamed from: g  reason: collision with root package name */
    private String f21543g;

    /* renamed from: h  reason: collision with root package name */
    private String f21544h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f21545i;

    /* renamed from: j  reason: collision with root package name */
    private String f21546j;

    /* renamed from: k  reason: collision with root package name */
    private String f21547k;

    /* renamed from: l  reason: collision with root package name */
    private Uri f21548l;

    /* renamed from: m  reason: collision with root package name */
    private Uri f21549m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f21550n;

    /* renamed from: o  reason: collision with root package name */
    private static final String f21536o = PayPalConfiguration.class.getSimpleName();
    public static final Parcelable.Creator CREATOR = new k0();

    public PayPalConfiguration() {
        this.f21545i = c2.w();
        this.f21550n = true;
    }

    private PayPalConfiguration(Parcel parcel) {
        this.f21545i = c2.w();
        boolean z10 = true;
        this.f21550n = true;
        this.f21538b = parcel.readString();
        this.f21537a = parcel.readString();
        this.f21539c = parcel.readString();
        this.f21540d = parcel.readString();
        this.f21541e = parcel.readString();
        this.f21542f = parcel.readByte() == 1;
        this.f21543g = parcel.readString();
        this.f21544h = parcel.readString();
        this.f21545i = parcel.readByte() == 1;
        this.f21546j = parcel.readString();
        this.f21547k = parcel.readString();
        this.f21548l = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f21549m = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f21550n = parcel.readByte() != 1 ? false : z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ PayPalConfiguration(Parcel parcel, byte b10) {
        this(parcel);
    }

    private static void b(boolean z10, String str) {
        if (!z10) {
            String str2 = f21536o;
            Log.e(str2, str + " is invalid.  Please see the docs.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String a() {
        return this.f21537a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String c() {
        if (TextUtils.isEmpty(this.f21538b)) {
            this.f21538b = "live";
            Log.w("paypal.sdk", "defaulting to production environment");
        }
        return this.f21538b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d() {
        return this.f21539c;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final PayPalConfiguration e(String str) {
        this.f21546j = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String f() {
        return this.f21540d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String g() {
        return this.f21541e;
    }

    public final PayPalConfiguration h(String str) {
        this.f21538b = str;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean i() {
        return this.f21542f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String j() {
        return this.f21543g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String k() {
        return this.f21544h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean l() {
        return this.f21545i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean m() {
        return this.f21550n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String o() {
        return this.f21546j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String p() {
        return this.f21547k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Uri r() {
        return this.f21548l;
    }

    public final PayPalConfiguration s(String str) {
        this.f21547k = str;
        return this;
    }

    public final PayPalConfiguration t(Uri uri) {
        this.f21548l = uri;
        return this;
    }

    public final String toString() {
        return String.format(PayPalConfiguration.class.getSimpleName() + ": {environment:%s, client_id:%s, languageOrLocale:%s}", this.f21538b, this.f21546j, this.f21537a);
    }

    public final PayPalConfiguration u(Uri uri) {
        this.f21549m = uri;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Uri v() {
        return this.f21549m;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f21538b);
        parcel.writeString(this.f21537a);
        parcel.writeString(this.f21539c);
        parcel.writeString(this.f21540d);
        parcel.writeString(this.f21541e);
        parcel.writeByte(this.f21542f ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f21543g);
        parcel.writeString(this.f21544h);
        parcel.writeByte(this.f21545i ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f21546j);
        parcel.writeString(this.f21547k);
        parcel.writeParcelable(this.f21548l, 0);
        parcel.writeParcelable(this.f21549m, 0);
        parcel.writeByte(this.f21550n ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean x() {
        boolean z10;
        String str = f21536o;
        boolean j10 = y1.j(str, c(), "environment");
        b(j10, "environment");
        if (!j10) {
            z10 = false;
        } else if (n0.a(c())) {
            z10 = true;
        } else {
            z10 = y1.j(str, this.f21546j, "clientId");
            b(z10, "clientId");
        }
        return j10 && z10;
    }
}
