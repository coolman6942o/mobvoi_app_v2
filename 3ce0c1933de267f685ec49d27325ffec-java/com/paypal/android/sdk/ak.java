package com.paypal.android.sdk;

import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.util.Collection;
import java.util.HashSet;
/* loaded from: classes2.dex */
public enum ak {
    FUTURE_PAYMENTS("https://uri.paypal.com/services/payments/futurepayments", false),
    PROFILE("profile", true),
    PAYPAL_ATTRIBUTES("https://uri.paypal.com/services/paypalattributes", true),
    OPENID("openid", true),
    EMAIL("email", true),
    ADDRESS("address", true),
    PHONE(SharedWearInfoHelper.PhoneInfo.TABLE, true);
    

    /* renamed from: h  reason: collision with root package name */
    public static final Collection f20985h = new HashSet() { // from class: com.paypal.android.sdk.l
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            ak[] values;
            boolean z10;
            for (ak akVar : ak.values()) {
                z10 = akVar.f20989k;
                if (z10) {
                    add(akVar.a());
                }
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    public static final Collection f20986i = new HashSet() { // from class: com.paypal.android.sdk.m
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            for (ak akVar : ak.values()) {
                add(akVar.a());
            }
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private String f20988j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f20989k;

    ak(String str, boolean z10) {
        this.f20988j = str;
        this.f20989k = z10;
    }

    public final String a() {
        return this.f20988j;
    }
}
