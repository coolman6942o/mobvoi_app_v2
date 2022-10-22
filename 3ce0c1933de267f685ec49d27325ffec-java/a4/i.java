package a4;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.app.EnvUtils;
import q3.a;
/* loaded from: classes.dex */
public class i {
    public static String a(Context context) {
        if (EnvUtils.a()) {
            return "https://mobilegw.alipaydev.com/mgw.htm";
        }
        if (context == null) {
            return a.f32919a;
        }
        String str = a.f32919a;
        return TextUtils.isEmpty(str) ? a.f32919a : str;
    }
}
