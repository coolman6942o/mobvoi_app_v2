package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.mobvoi.wear.common.base.Constants;
import g8.c;
import java.util.Map;
/* loaded from: classes.dex */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    Bundle f12536a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, String> f12537b;

    public RemoteMessage(Bundle bundle) {
        this.f12536a = bundle;
    }

    public final Map<String, String> G0() {
        if (this.f12537b == null) {
            this.f12537b = new a();
            for (String str : this.f12536a.keySet()) {
                Object obj = this.f12536a.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals(Constants.WatchfaceMarket.MARKET_ENTER_FROM) && !str.equals("message_type") && !str.equals("collapse_key")) {
                        this.f12537b.put(str, str2);
                    }
                }
            }
        }
        return this.f12537b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c6.a.a(parcel);
        c6.a.d(parcel, 2, this.f12536a, false);
        c6.a.b(parcel, a10);
    }
}
