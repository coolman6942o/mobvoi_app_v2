package com.paypal.android.sdk;

import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.PhoneNumberUtils;
import com.unionpay.tsmservice.data.Constant;
import java.util.HashMap;
import java.util.Locale;
/* loaded from: classes2.dex */
public class es implements Parcelable {
    public static final Parcelable.Creator CREATOR = new d3();

    /* renamed from: c  reason: collision with root package name */
    private static HashMap f21189c;

    /* renamed from: a  reason: collision with root package name */
    private ef f21190a;

    /* renamed from: b  reason: collision with root package name */
    private String f21191b;

    static {
        HashMap hashMap = new HashMap();
        f21189c = hashMap;
        hashMap.put("US", "1");
        f21189c.put("CA", "1");
        f21189c.put("GB", "44");
        f21189c.put("FR", "33");
        f21189c.put("IT", "39");
        f21189c.put("ES", "34");
        f21189c.put("AU", "61");
        f21189c.put("MY", Constant.TRANS_TYPE_LOAD);
        f21189c.put("SG", "65");
        f21189c.put("AR", "54");
        f21189c.put("UK", "44");
        f21189c.put("ZA", "27");
        f21189c.put("GR", "30");
        f21189c.put("NL", "31");
        f21189c.put("BE", "32");
        f21189c.put("SG", "65");
        f21189c.put("PT", "351");
        f21189c.put("LU", "352");
        f21189c.put("IE", "353");
        f21189c.put("IS", "354");
        f21189c.put("MT", "356");
        f21189c.put("CY", "357");
        f21189c.put("FI", "358");
        f21189c.put("HU", "36");
        f21189c.put("LT", "370");
        f21189c.put("LV", "371");
        f21189c.put("EE", "372");
        f21189c.put("SI", "386");
        f21189c.put("CH", "41");
        f21189c.put("CZ", "420");
        f21189c.put("SK", "421");
        f21189c.put("AT", "43");
        f21189c.put("DK", "45");
        f21189c.put("SE", "46");
        f21189c.put("NO", "47");
        f21189c.put("PL", "48");
        f21189c.put("DE", "49");
        f21189c.put("MX", "52");
        f21189c.put("BR", "55");
        f21189c.put("NZ", "64");
        f21189c.put("TH", "66");
        f21189c.put("JP", "81");
        f21189c.put("KR", "82");
        f21189c.put("HK", "852");
        f21189c.put("CN", "86");
        f21189c.put("TW", "886");
        f21189c.put("TR", "90");
        f21189c.put("IN", "91");
        f21189c.put("IL", "972");
        f21189c.put("MC", "377");
        f21189c.put("CR", "506");
        f21189c.put("CL", "56");
        f21189c.put("VE", "58");
        f21189c.put("EC", "593");
        f21189c.put("UY", "598");
    }

    public es(Parcel parcel) {
        this.f21190a = (ef) parcel.readParcelable(ef.class.getClassLoader());
        this.f21191b = parcel.readString();
    }

    public es(c3 c3Var, ef efVar, String str) {
        d(efVar, c3Var.a(b3.e(str)));
    }

    public es(c3 c3Var, String str) {
        d(c3Var.d(), c3Var.a(b3.e(str)));
    }

    public static es a(c3 c3Var, String str) {
        String[] split = str.split("[|]");
        if (split.length == 2) {
            return new es(c3Var, new ef(split[0]), split[1]);
        }
        throw new el("");
    }

    private void d(ef efVar, String str) {
        this.f21190a = efVar;
        this.f21191b = str;
    }

    public final String b() {
        return this.f21191b;
    }

    public final String c(c3 c3Var) {
        return c3Var.b().equals(Locale.US) ? PhoneNumberUtils.formatNumber(this.f21191b) : this.f21191b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.f21190a.a() + "|" + this.f21191b;
    }

    public final String f() {
        return (String) f21189c.get(this.f21190a.a());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f21190a, 0);
        parcel.writeString(this.f21191b);
    }
}
