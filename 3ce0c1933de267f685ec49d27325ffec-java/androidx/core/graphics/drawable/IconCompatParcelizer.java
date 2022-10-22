package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import androidx.versionedparcelable.VersionedParcel;
/* loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(VersionedParcel versionedParcel) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f2452a = versionedParcel.p(iconCompat.f2452a, 1);
        iconCompat.f2454c = versionedParcel.j(iconCompat.f2454c, 2);
        iconCompat.f2455d = versionedParcel.r(iconCompat.f2455d, 3);
        iconCompat.f2456e = versionedParcel.p(iconCompat.f2456e, 4);
        iconCompat.f2457f = versionedParcel.p(iconCompat.f2457f, 5);
        iconCompat.f2458g = (ColorStateList) versionedParcel.r(iconCompat.f2458g, 6);
        iconCompat.f2460i = versionedParcel.t(iconCompat.f2460i, 7);
        iconCompat.f2461j = versionedParcel.t(iconCompat.f2461j, 8);
        iconCompat.r();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(true, true);
        iconCompat.s(versionedParcel.f());
        int i10 = iconCompat.f2452a;
        if (-1 != i10) {
            versionedParcel.F(i10, 1);
        }
        byte[] bArr = iconCompat.f2454c;
        if (bArr != null) {
            versionedParcel.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.f2455d;
        if (parcelable != null) {
            versionedParcel.H(parcelable, 3);
        }
        int i11 = iconCompat.f2456e;
        if (i11 != 0) {
            versionedParcel.F(i11, 4);
        }
        int i12 = iconCompat.f2457f;
        if (i12 != 0) {
            versionedParcel.F(i12, 5);
        }
        ColorStateList colorStateList = iconCompat.f2458g;
        if (colorStateList != null) {
            versionedParcel.H(colorStateList, 6);
        }
        String str = iconCompat.f2460i;
        if (str != null) {
            versionedParcel.J(str, 7);
        }
        String str2 = iconCompat.f2461j;
        if (str2 != null) {
            versionedParcel.J(str2, 8);
        }
    }
}
