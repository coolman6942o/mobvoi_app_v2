package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class PayPalAuthorization implements Parcelable {
    public static final Parcelable.Creator CREATOR = new j0();

    /* renamed from: a  reason: collision with root package name */
    private final String f21533a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21534b;

    /* renamed from: c  reason: collision with root package name */
    private final String f21535c;

    private PayPalAuthorization(Parcel parcel) {
        this.f21533a = parcel.readString();
        this.f21534b = parcel.readString();
        this.f21535c = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ PayPalAuthorization(Parcel parcel, byte b10) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PayPalAuthorization(String str, String str2, String str3) {
        this.f21533a = str;
        this.f21534b = str2;
        this.f21535c = null;
    }

    public final String a() {
        return this.f21534b;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("environment", this.f21533a);
            jSONObject2.put("paypal_sdk_version", "2.15.1");
            jSONObject2.put("platform", "Android");
            jSONObject2.put("product_name", "PayPal-Android-SDK");
            jSONObject.put("client", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("code", this.f21534b);
            jSONObject.put("response", jSONObject3);
            jSONObject.put("response_type", "authorization_code");
            return jSONObject;
        } catch (JSONException e10) {
            Log.e("paypal.sdk", "Error encoding JSON", e10);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f21533a);
        parcel.writeString(this.f21534b);
        parcel.writeString(this.f21535c);
    }
}
