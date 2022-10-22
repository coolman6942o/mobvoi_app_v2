package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.paypal.android.sdk.v2;
import com.paypal.android.sdk.y1;
import java.math.BigDecimal;
/* loaded from: classes2.dex */
public final class PayPalItem implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    private final String f21558a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f21559b;

    /* renamed from: c  reason: collision with root package name */
    private final BigDecimal f21560c;

    /* renamed from: d  reason: collision with root package name */
    private final String f21561d;

    /* renamed from: e  reason: collision with root package name */
    private final String f21562e;

    /* renamed from: f  reason: collision with root package name */
    private static final String f21557f = PayPalItem.class.getSimpleName();
    public static final Parcelable.Creator CREATOR = new q0();

    private PayPalItem(Parcel parcel) {
        this.f21558a = parcel.readString();
        this.f21559b = Integer.valueOf(parcel.readInt());
        try {
            this.f21560c = new BigDecimal(parcel.readString());
            this.f21561d = parcel.readString();
            this.f21562e = parcel.readString();
        } catch (NumberFormatException e10) {
            Log.e(f21557f, "bad price", e10);
            throw new RuntimeException(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ PayPalItem(Parcel parcel, byte b10) {
        this(parcel);
    }

    public final String a() {
        return this.f21561d;
    }

    public final String b() {
        return this.f21558a;
    }

    public final BigDecimal c() {
        return this.f21560c;
    }

    public final Integer d() {
        return this.f21559b;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f21562e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PayPalItem)) {
            return false;
        }
        PayPalItem payPalItem = (PayPalItem) obj;
        String b10 = b();
        String b11 = payPalItem.b();
        if (b10 != null ? !b10.equals(b11) : b11 != null) {
            return false;
        }
        Integer d10 = d();
        Integer d11 = payPalItem.d();
        if (d10 != null ? !d10.equals(d11) : d11 != null) {
            return false;
        }
        BigDecimal c10 = c();
        BigDecimal c11 = payPalItem.c();
        if (c10 != null ? !c10.equals(c11) : c11 != null) {
            return false;
        }
        String a10 = a();
        String a11 = payPalItem.a();
        if (a10 != null ? !a10.equals(a11) : a11 != null) {
            return false;
        }
        String e10 = e();
        String e11 = payPalItem.e();
        return e10 != null ? e10.equals(e11) : e11 == null;
    }

    public final boolean f() {
        String str;
        if (this.f21559b.intValue() <= 0) {
            str = "item.quantity must be a positive integer.";
        } else if (!v2.f(this.f21561d)) {
            str = "item.currency field is required, and must be a supported currency.";
        } else if (y1.i(this.f21558a)) {
            str = "item.name field is required.";
        } else if (v2.g(this.f21560c, this.f21561d, false)) {
            return true;
        } else {
            str = "item.price field is required.";
        }
        Log.e("paypal.sdk", str);
        return false;
    }

    public final int hashCode() {
        String b10 = b();
        int i10 = 43;
        int hashCode = b10 == null ? 43 : b10.hashCode();
        Integer d10 = d();
        int hashCode2 = ((hashCode + 59) * 59) + (d10 == null ? 43 : d10.hashCode());
        BigDecimal c10 = c();
        int hashCode3 = (hashCode2 * 59) + (c10 == null ? 43 : c10.hashCode());
        String a10 = a();
        int hashCode4 = (hashCode3 * 59) + (a10 == null ? 43 : a10.hashCode());
        String e10 = e();
        int i11 = hashCode4 * 59;
        if (e10 != null) {
            i10 = e10.hashCode();
        }
        return i11 + i10;
    }

    public final String toString() {
        return "PayPalItem(name=" + b() + ", quantity=" + d() + ", price=" + c() + ", currency=" + a() + ", sku=" + e() + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f21558a);
        parcel.writeInt(this.f21559b.intValue());
        parcel.writeString(this.f21560c.toString());
        parcel.writeString(this.f21561d);
        parcel.writeString(this.f21562e);
    }
}
