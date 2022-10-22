package com.google.android.gms.common.server.response;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
/* loaded from: classes.dex */
public abstract class FastSafeParcelableJsonResponse extends FastJsonResponse implements SafeParcelable {
    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Object c(String str) {
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public boolean e(String str) {
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!getClass().isInstance(obj)) {
            return false;
        }
        FastJsonResponse fastJsonResponse = (FastJsonResponse) obj;
        for (FastJsonResponse.Field<?, ?> field : a().values()) {
            if (d(field)) {
                if (!fastJsonResponse.d(field) || !b(field).equals(fastJsonResponse.b(field))) {
                    return false;
                }
            } else if (fastJsonResponse.d(field)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i10 = 0;
        for (FastJsonResponse.Field<?, ?> field : a().values()) {
            if (d(field)) {
                i10 = (i10 * 31) + b(field).hashCode();
            }
        }
        return i10;
    }
}
