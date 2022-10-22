package bh;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.alibaba.fastjson.JSON;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.health.common.data.pojo.SportType;
import java.util.ArrayList;
import java.util.List;
/* compiled from: SportTypeUtil.java */
/* loaded from: classes2.dex */
public class e {
    private static SharedPreferences a() {
        return PreferenceManager.getDefaultSharedPreferences(b.e());
    }

    public static List<SportType> b(String str) {
        String string = a().getString(str, null);
        if (string == null) {
            return new ArrayList();
        }
        return JSON.parseArray(string, SportType.class);
    }

    public static void c(String str, String str2) {
        a().edit().putString(str, str2).apply();
    }
}
