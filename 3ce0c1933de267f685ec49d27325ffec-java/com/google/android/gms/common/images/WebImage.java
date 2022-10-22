package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Locale;
/* loaded from: classes.dex */
public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f8856a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f8857b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8858c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8859d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebImage(int i10, Uri uri, int i11, int i12) {
        this.f8856a = i10;
        this.f8857b = uri;
        this.f8858c = i11;
        this.f8859d = i12;
    }

    public final int G0() {
        return this.f8859d;
    }

    public final Uri H0() {
        return this.f8857b;
    }

    public final int I0() {
        return this.f8858c;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            if (h.a(this.f8857b, webImage.f8857b) && this.f8858c == webImage.f8858c && this.f8859d == webImage.f8859d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return h.b(this.f8857b, Integer.valueOf(this.f8858c), Integer.valueOf(this.f8859d));
    }

    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", Integer.valueOf(this.f8858c), Integer.valueOf(this.f8859d), this.f8857b.toString());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8856a);
        a.r(parcel, 2, H0(), i10, false);
        a.l(parcel, 3, I0());
        a.l(parcel, 4, G0());
        a.b(parcel, a10);
    }
}
