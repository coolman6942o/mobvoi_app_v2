package yb;

import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.wear.info.WearInfo;
/* compiled from: OverseaDevicePageRecordAdapter.java */
/* loaded from: classes2.dex */
public class a {
    public static boolean a() {
        WearInfo e10 = com.mobvoi.companion.wear.a.f().e();
        if (e10 != null) {
            return q.a(b.e(), "device_page_record", e10.wearDeviceId, false);
        }
        return false;
    }

    public static void b(boolean z10) {
        WearInfo e10 = com.mobvoi.companion.wear.a.f().e();
        if (e10 != null) {
            q.e(b.e(), "device_page_record", e10.wearDeviceId, z10);
        }
    }
}
