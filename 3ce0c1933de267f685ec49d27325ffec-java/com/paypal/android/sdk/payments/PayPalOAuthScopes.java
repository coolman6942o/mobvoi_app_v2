package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.paypal.android.sdk.ak;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes2.dex */
public final class PayPalOAuthScopes implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    private final List f21564a;

    /* renamed from: b  reason: collision with root package name */
    public static final String f21563b = ak.FUTURE_PAYMENTS.a();
    public static final Parcelable.Creator CREATOR = new r0();

    static {
        ak.PROFILE.a();
        ak.PAYPAL_ATTRIBUTES.a();
        ak.EMAIL.a();
        ak.ADDRESS.a();
        ak.PHONE.a();
        ak.OPENID.a();
    }

    public PayPalOAuthScopes() {
        this.f21564a = new ArrayList();
    }

    private PayPalOAuthScopes(Parcel parcel) {
        this.f21564a = new ArrayList();
        int readInt = parcel.readInt();
        for (int i10 = 0; i10 < readInt; i10++) {
            this.f21564a.add(parcel.readString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ PayPalOAuthScopes(Parcel parcel, byte b10) {
        this(parcel);
    }

    public PayPalOAuthScopes(Set set) {
        this();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            this.f21564a.add((String) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List a() {
        return this.f21564a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String b() {
        return TextUtils.join(" ", this.f21564a);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return String.format(PayPalOAuthScopes.class.getSimpleName() + ": {%s}", this.f21564a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f21564a.size());
        for (int i11 = 0; i11 < this.f21564a.size(); i11++) {
            parcel.writeString((String) this.f21564a.get(i11));
        }
    }
}
