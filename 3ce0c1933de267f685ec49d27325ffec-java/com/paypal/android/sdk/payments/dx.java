package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import com.paypal.android.sdk.l3;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dx implements Parcelable {
    public static final Parcelable.Creator CREATOR = new z2();

    /* renamed from: a  reason: collision with root package name */
    private JSONArray f21704a;

    /* renamed from: b  reason: collision with root package name */
    private ShippingAddress f21705b;

    /* renamed from: c  reason: collision with root package name */
    private int f21706c;

    /* renamed from: d  reason: collision with root package name */
    private int f21707d;

    /* renamed from: e  reason: collision with root package name */
    private JSONObject f21708e;

    /* renamed from: f  reason: collision with root package name */
    private JSONArray f21709f;

    /* renamed from: g  reason: collision with root package name */
    private int f21710g;

    /* renamed from: h  reason: collision with root package name */
    private String f21711h;

    /* renamed from: i  reason: collision with root package name */
    private String f21712i;

    public dx(Parcel parcel) {
        this.f21706c = -1;
        this.f21710g = -1;
        if (parcel != null) {
            try {
                String readString = parcel.readString();
                if (readString != null) {
                    this.f21704a = new JSONArray(readString);
                } else {
                    this.f21704a = null;
                }
            } catch (JSONException unused) {
                this.f21704a = null;
            }
            this.f21705b = (ShippingAddress) parcel.readParcelable(ShippingAddress.class.getClassLoader());
            try {
                String readString2 = parcel.readString();
                if (readString2 != null) {
                    this.f21708e = new JSONObject(readString2);
                } else {
                    this.f21708e = null;
                }
            } catch (JSONException unused2) {
                this.f21708e = null;
            }
            try {
                String readString3 = parcel.readString();
                if (readString3 != null) {
                    this.f21709f = new JSONArray(readString3);
                } else {
                    this.f21709f = null;
                }
            } catch (JSONException unused3) {
                this.f21709f = null;
            }
            this.f21711h = parcel.readString();
            this.f21712i = parcel.readString();
            this.f21710g = parcel.readInt();
            this.f21706c = parcel.readInt();
            this.f21707d = parcel.readInt();
        }
    }

    public dx(l3 l3Var, ShippingAddress shippingAddress) {
        this.f21706c = -1;
        this.f21710g = -1;
        this.f21704a = l3Var.J();
        this.f21708e = l3Var.K();
        this.f21709f = l3Var.L();
        this.f21711h = l3Var.H();
        this.f21712i = l3Var.I();
        this.f21705b = shippingAddress;
        if (shippingAddress != null) {
            this.f21706c = 0;
            this.f21707d = a(shippingAddress, this.f21704a);
            return;
        }
        this.f21706c = b(this.f21704a);
        this.f21707d = -1;
    }

    private static int a(ShippingAddress shippingAddress, JSONArray jSONArray) {
        if (shippingAddress == null || jSONArray == null) {
            return -1;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            if (shippingAddress.c(jSONArray.optJSONObject(i10))) {
                return i10;
            }
        }
        return -1;
    }

    private static int b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return -1;
        }
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            if (jSONArray.optJSONObject(i10).optBoolean("default_address", false)) {
                return i10;
            }
        }
        return 0;
    }

    public final JSONArray c() {
        return this.f21704a;
    }

    public final void d(int i10) {
        this.f21710g = i10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final ShippingAddress e() {
        return this.f21705b;
    }

    public final void f(int i10) {
        this.f21706c = i10;
    }

    public final JSONObject g() {
        return this.f21708e;
    }

    public final JSONArray h() {
        return this.f21709f;
    }

    public final String i() {
        return this.f21711h;
    }

    public final String j() {
        return this.f21712i;
    }

    public final int k() {
        int i10 = this.f21710g;
        if (i10 < 0) {
            return 0;
        }
        return i10;
    }

    public final int l() {
        int i10 = this.f21706c;
        if (i10 < 0) {
            return 0;
        }
        return i10;
    }

    public final int m() {
        return this.f21707d;
    }

    public final boolean o() {
        return this.f21710g != -1;
    }

    public final boolean p() {
        return this.f21706c != -1;
    }

    public final JSONObject r() {
        int i10 = this.f21710g;
        if (i10 <= 0) {
            return null;
        }
        return this.f21709f.optJSONObject(i10 - 1);
    }

    public final JSONObject s() {
        int i10 = this.f21706c;
        if (i10 < 0) {
            return null;
        }
        ShippingAddress shippingAddress = this.f21705b;
        if (shippingAddress != null) {
            if (i10 == 0) {
                i10 = this.f21707d;
                if (i10 < 0) {
                    return shippingAddress.d();
                }
            } else {
                i10--;
                int i11 = this.f21707d;
                if (i11 >= 0 && i10 >= i11) {
                    i10++;
                }
            }
        }
        return this.f21704a.optJSONObject(i10);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        JSONArray jSONArray = this.f21704a;
        String str = null;
        parcel.writeString(jSONArray != null ? jSONArray.toString() : null);
        parcel.writeParcelable(this.f21705b, 0);
        JSONObject jSONObject = this.f21708e;
        parcel.writeString(jSONObject != null ? jSONObject.toString() : null);
        JSONArray jSONArray2 = this.f21709f;
        if (jSONArray2 != null) {
            str = jSONArray2.toString();
        }
        parcel.writeString(str);
        parcel.writeString(this.f21711h);
        parcel.writeString(this.f21712i);
        parcel.writeInt(this.f21710g);
        parcel.writeInt(this.f21706c);
        parcel.writeInt(this.f21707d);
    }
}
