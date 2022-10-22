package com.paypal.android.sdk.payments;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.paypal.android.sdk.v2;
import com.paypal.android.sdk.y1;
import java.math.BigDecimal;
/* loaded from: classes2.dex */
public final class PayPalPayment implements Parcelable {
    public static final Parcelable.Creator CREATOR = new s0();

    /* renamed from: a  reason: collision with root package name */
    private BigDecimal f21565a;

    /* renamed from: b  reason: collision with root package name */
    private String f21566b;

    /* renamed from: c  reason: collision with root package name */
    private String f21567c;

    /* renamed from: d  reason: collision with root package name */
    private String f21568d;

    /* renamed from: e  reason: collision with root package name */
    private PayPalPaymentDetails f21569e;

    /* renamed from: f  reason: collision with root package name */
    private String f21570f;

    /* renamed from: g  reason: collision with root package name */
    private PayPalItem[] f21571g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f21572h;

    /* renamed from: i  reason: collision with root package name */
    private ShippingAddress f21573i;

    /* renamed from: j  reason: collision with root package name */
    private String f21574j;

    /* renamed from: k  reason: collision with root package name */
    private String f21575k;

    /* renamed from: l  reason: collision with root package name */
    private String f21576l;

    /* renamed from: m  reason: collision with root package name */
    private String f21577m;

    private PayPalPayment(Parcel parcel) {
        this.f21566b = parcel.readString();
        try {
            this.f21565a = new BigDecimal(parcel.readString());
        } catch (NumberFormatException unused) {
        }
        this.f21567c = parcel.readString();
        this.f21570f = parcel.readString();
        this.f21568d = parcel.readString();
        this.f21569e = (PayPalPaymentDetails) parcel.readParcelable(PayPalPaymentDetails.class.getClassLoader());
        int readInt = parcel.readInt();
        if (readInt > 0) {
            PayPalItem[] payPalItemArr = new PayPalItem[readInt];
            this.f21571g = payPalItemArr;
            parcel.readTypedArray(payPalItemArr, PayPalItem.CREATOR);
        }
        this.f21573i = (ShippingAddress) parcel.readParcelable(ShippingAddress.class.getClassLoader());
        this.f21572h = parcel.readInt() != 1 ? false : true;
        this.f21574j = parcel.readString();
        this.f21575k = parcel.readString();
        this.f21576l = parcel.readString();
        this.f21577m = parcel.readString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ PayPalPayment(Parcel parcel, byte b10) {
        this(parcel);
    }

    public PayPalPayment(BigDecimal bigDecimal, String str, String str2, String str3) {
        this.f21565a = bigDecimal;
        this.f21566b = str;
        this.f21567c = str2;
        this.f21570f = str3;
        this.f21569e = null;
        this.f21568d = null;
        toString();
    }

    private static void b(boolean z10, String str) {
        if (!z10) {
            Log.e("paypal.sdk", str + " is invalid.  Please see the docs.");
        }
    }

    private static boolean c(String str, String str2, int i10) {
        if (!y1.m(str) || str.length() <= i10) {
            return true;
        }
        Log.e("paypal.sdk", str2 + " is too long (max " + i10 + ")");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BigDecimal a() {
        return this.f21565a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String d() {
        return this.f21567c;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String e() {
        return this.f21570f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String f() {
        return this.f21566b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String g() {
        return this.f21568d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String h() {
        return this.f21577m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final PayPalPaymentDetails i() {
        return this.f21569e;
    }

    public final ShippingAddress j() {
        return this.f21573i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final PayPalItem[] k() {
        return this.f21571g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String l() {
        return this.f21574j;
    }

    public final boolean m() {
        return this.f21572h;
    }

    public final boolean o() {
        return !this.f21572h && this.f21573i == null;
    }

    public final boolean p() {
        boolean z10;
        boolean f10 = v2.f(this.f21566b);
        boolean g10 = v2.g(this.f21565a, this.f21566b, true);
        boolean z11 = !TextUtils.isEmpty(this.f21567c);
        boolean z12 = y1.m(this.f21570f) && (this.f21570f.equals("sale") || this.f21570f.equals("authorize") || this.f21570f.equals("order"));
        PayPalPaymentDetails payPalPaymentDetails = this.f21569e;
        boolean d10 = payPalPaymentDetails == null ? true : payPalPaymentDetails.d();
        boolean p10 = y1.i(this.f21568d) ? true : y1.p(this.f21568d);
        PayPalItem[] payPalItemArr = this.f21571g;
        if (!(payPalItemArr == null || payPalItemArr.length == 0)) {
            for (PayPalItem payPalItem : payPalItemArr) {
                if (!payPalItem.f()) {
                    z10 = false;
                    break;
                }
            }
        }
        z10 = true;
        boolean c10 = c(this.f21574j, "invoiceNumber", 256);
        if (!c(this.f21575k, "custom", 256)) {
            c10 = false;
        }
        if (!c(this.f21576l, "softDescriptor", 22)) {
            c10 = false;
        }
        b(f10, "currencyCode");
        b(g10, "amount");
        b(z11, "shortDescription");
        b(z12, "paymentIntent");
        b(d10, "details");
        b(p10, "bnCode");
        b(z10, "items");
        return f10 && g10 && z11 && d10 && z12 && p10 && z10 && c10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String r() {
        return this.f21575k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String s() {
        return this.f21576l;
    }

    public final String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = this.f21567c;
        BigDecimal bigDecimal = this.f21565a;
        objArr[1] = bigDecimal != null ? bigDecimal.toString() : null;
        objArr[2] = this.f21566b;
        objArr[3] = this.f21570f;
        return String.format("PayPalPayment: {%s: $%s %s, %s}", objArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f21566b);
        parcel.writeString(this.f21565a.toString());
        parcel.writeString(this.f21567c);
        parcel.writeString(this.f21570f);
        parcel.writeString(this.f21568d);
        parcel.writeParcelable(this.f21569e, 0);
        PayPalItem[] payPalItemArr = this.f21571g;
        if (payPalItemArr != null) {
            parcel.writeInt(payPalItemArr.length);
            parcel.writeTypedArray(this.f21571g, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.f21573i, 0);
        parcel.writeInt(this.f21572h ? 1 : 0);
        parcel.writeString(this.f21574j);
        parcel.writeString(this.f21575k);
        parcel.writeString(this.f21576l);
        parcel.writeString(this.f21577m);
    }
}
