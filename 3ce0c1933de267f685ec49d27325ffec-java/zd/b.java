package zd;

import android.content.Context;
import android.content.Intent;
import b1.a;
/* compiled from: DeviceHeadUtlis.java */
/* loaded from: classes2.dex */
public class b {
    public static void a(String str, Context context) {
        Intent intent = new Intent("action_device_change");
        intent.putExtra("device_tag", str);
        a.b(context).d(intent);
    }
}
