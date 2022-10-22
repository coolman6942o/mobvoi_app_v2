package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.paypal.android.sdk.y1;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class ShippingAddress implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    private String f21648a;

    /* renamed from: b  reason: collision with root package name */
    private String f21649b;

    /* renamed from: c  reason: collision with root package name */
    private String f21650c;

    /* renamed from: d  reason: collision with root package name */
    private String f21651d;

    /* renamed from: e  reason: collision with root package name */
    private String f21652e;

    /* renamed from: f  reason: collision with root package name */
    private String f21653f;

    /* renamed from: g  reason: collision with root package name */
    private String f21654g;

    /* renamed from: h  reason: collision with root package name */
    private static final String f21647h = ShippingAddress.class.getSimpleName();
    public static final Parcelable.Creator CREATOR = new a3();

    public ShippingAddress() {
    }

    private ShippingAddress(Parcel parcel) {
        this.f21648a = parcel.readString();
        this.f21649b = parcel.readString();
        this.f21650c = parcel.readString();
        this.f21651d = parcel.readString();
        this.f21652e = parcel.readString();
        this.f21653f = parcel.readString();
        this.f21654g = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ShippingAddress(Parcel parcel, byte b10) {
        this(parcel);
    }

    private static boolean a(String str) {
        return y1.m(str);
    }

    private static boolean b(String str, String str2) {
        if (y1.i(str)) {
            return y1.i(str2);
        }
        if (y1.i(str2)) {
            return false;
        }
        return str.trim().equals(str2.trim());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean c(JSONObject jSONObject) {
        return b(jSONObject.optString("recipient_name"), this.f21648a) && b(jSONObject.optString("line1"), this.f21649b) && b(jSONObject.optString("line2"), this.f21650c) && b(jSONObject.optString("city"), this.f21651d) && b(jSONObject.optString("state"), this.f21652e) && b(jSONObject.optString("country_code"), this.f21654g) && b(jSONObject.optString("postal_code"), this.f21653f);
    }

    public final JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.accumulate("recipient_name", this.f21648a);
            jSONObject.accumulate("line1", this.f21649b);
            jSONObject.accumulate("city", this.f21651d);
            jSONObject.accumulate("country_code", this.f21654g);
            if (a(this.f21650c)) {
                jSONObject.accumulate("line2", this.f21650c);
            }
            if (a(this.f21652e)) {
                jSONObject.accumulate("state", this.f21652e);
            }
            if (a(this.f21653f)) {
                jSONObject.accumulate("postal_code", this.f21653f);
            }
        } catch (JSONException e10) {
            Log.e(f21647h, e10.getMessage());
        }
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f21648a);
        parcel.writeString(this.f21649b);
        parcel.writeString(this.f21650c);
        parcel.writeString(this.f21651d);
        parcel.writeString(this.f21652e);
        parcel.writeString(this.f21653f);
        parcel.writeString(this.f21654g);
    }
}
