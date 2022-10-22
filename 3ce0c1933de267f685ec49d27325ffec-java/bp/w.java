package bp;

import android.content.Intent;
import android.os.ParcelUuid;
import android.os.Parcelable;
import java.util.UUID;
/* compiled from: UuidHelper.java */
/* loaded from: classes3.dex */
class w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Intent intent) {
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_LEGACY_DFU");
        if (parcelableArrayExtra == null || parcelableArrayExtra.length != 4) {
            UUID uuid = s.F;
            s.J = uuid;
            UUID uuid2 = s.G;
            s.K = uuid2;
            s.L = s.H;
            UUID uuid3 = s.I;
            s.M = uuid3;
            r.f5499z = uuid;
            r.A = uuid2;
            r.B = uuid3;
        } else {
            s.J = parcelableArrayExtra[0] != null ? ((ParcelUuid) parcelableArrayExtra[0]).getUuid() : s.F;
            s.K = parcelableArrayExtra[1] != null ? ((ParcelUuid) parcelableArrayExtra[1]).getUuid() : s.G;
            s.L = parcelableArrayExtra[2] != null ? ((ParcelUuid) parcelableArrayExtra[2]).getUuid() : s.H;
            s.M = parcelableArrayExtra[3] != null ? ((ParcelUuid) parcelableArrayExtra[3]).getUuid() : s.I;
            r.f5499z = s.J;
            r.A = s.K;
            r.B = s.M;
        }
        Parcelable[] parcelableArrayExtra2 = intent.getParcelableArrayExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_SECURE_DFU");
        if (parcelableArrayExtra2 == null || parcelableArrayExtra2.length != 3) {
            v.H = v.E;
            v.I = v.F;
            v.J = v.G;
        } else {
            v.H = parcelableArrayExtra2[0] != null ? ((ParcelUuid) parcelableArrayExtra2[0]).getUuid() : v.E;
            v.I = parcelableArrayExtra2[1] != null ? ((ParcelUuid) parcelableArrayExtra2[1]).getUuid() : v.F;
            v.J = parcelableArrayExtra2[2] != null ? ((ParcelUuid) parcelableArrayExtra2[2]).getUuid() : v.G;
        }
        Parcelable[] parcelableArrayExtra3 = intent.getParcelableArrayExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_EXPERIMENTAL_BUTTONLESS_DFU");
        if (parcelableArrayExtra3 == null || parcelableArrayExtra3.length != 2) {
            q.B = q.f5497z;
            q.C = q.A;
        } else {
            q.B = parcelableArrayExtra3[0] != null ? ((ParcelUuid) parcelableArrayExtra3[0]).getUuid() : q.f5497z;
            q.C = parcelableArrayExtra3[1] != null ? ((ParcelUuid) parcelableArrayExtra3[1]).getUuid() : q.A;
        }
        Parcelable[] parcelableArrayExtra4 = intent.getParcelableArrayExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITHOUT_BOND_SHARING");
        if (parcelableArrayExtra4 == null || parcelableArrayExtra4.length != 2) {
            f.B = f.f5427z;
            f.C = f.A;
        } else {
            f.B = parcelableArrayExtra4[0] != null ? ((ParcelUuid) parcelableArrayExtra4[0]).getUuid() : f.f5427z;
            f.C = parcelableArrayExtra4[1] != null ? ((ParcelUuid) parcelableArrayExtra4[1]).getUuid() : f.A;
        }
        Parcelable[] parcelableArrayExtra5 = intent.getParcelableArrayExtra("no.nordicsemi.android.dfu.extra.EXTRA_CUSTOM_UUIDS_FOR_BUTTONLESS_DFU_WITH_BOND_SHARING");
        if (parcelableArrayExtra5 == null || parcelableArrayExtra5.length != 2) {
            e.B = e.f5425z;
            e.C = e.A;
            return;
        }
        e.B = parcelableArrayExtra5[0] != null ? ((ParcelUuid) parcelableArrayExtra5[0]).getUuid() : e.f5425z;
        e.C = parcelableArrayExtra5[1] != null ? ((ParcelUuid) parcelableArrayExtra5[1]).getUuid() : e.A;
    }
}
