package kc;

import android.util.Log;
import com.alibaba.fastjson.JSON;
import java.util.List;
/* compiled from: JSONUtil.java */
/* loaded from: classes2.dex */
public class c {
    public static final <T> List<T> a(String str, Class<T> cls) {
        try {
            return JSON.parseArray(str, cls);
        } catch (Exception unused) {
            Log.e("JSONUtil", String.format("Failed to parse json string to array.", new Object[0]));
            return null;
        }
    }

    public static final <T> T b(String str, Class<T> cls) {
        try {
            return (T) JSON.parseObject(str, cls);
        } catch (Exception e10) {
            Log.e("JSONUtil", "Fail to parse the string " + str + "\n" + e10.getMessage(), e10);
            return null;
        }
    }

    public static final <T> String c(T t10) {
        try {
            return JSON.toJSONString(t10);
        } catch (Exception e10) {
            Log.e("JSONUtil", e10.getMessage(), e10);
            return "";
        }
    }
}
