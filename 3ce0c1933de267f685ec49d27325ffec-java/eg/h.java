package eg;

import android.content.Context;
import android.content.SharedPreferences;
/* compiled from: Pref.java */
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f26044a;

    private h(SharedPreferences sharedPreferences) {
        this.f26044a = sharedPreferences;
    }

    public static h a(Context context, String str) {
        return new h(context.getSharedPreferences(str, 0));
    }

    public <T> T b(String str, T t10) {
        if (t10 instanceof String) {
            return (T) this.f26044a.getString(str, (String) t10);
        }
        if (t10 instanceof Integer) {
            return (T) Integer.valueOf(this.f26044a.getInt(str, ((Integer) t10).intValue()));
        }
        if (t10 instanceof Float) {
            return (T) Float.valueOf(this.f26044a.getFloat(str, ((Float) t10).floatValue()));
        }
        if (t10 instanceof Long) {
            return (T) Long.valueOf(this.f26044a.getLong(str, ((Long) t10).longValue()));
        }
        if (t10 instanceof Boolean) {
            return (T) Boolean.valueOf(this.f26044a.getBoolean(str, ((Boolean) t10).booleanValue()));
        }
        throw new IllegalArgumentException("Not support value type " + t10.getClass().getName());
    }

    public <T> void c(String str, T t10) {
        if (t10 instanceof String) {
            this.f26044a.edit().putString(str, (String) t10).apply();
        } else if (t10 instanceof Integer) {
            this.f26044a.edit().putInt(str, ((Integer) t10).intValue()).apply();
        } else if (t10 instanceof Float) {
            this.f26044a.edit().putFloat(str, ((Float) t10).floatValue()).apply();
        } else if (t10 instanceof Long) {
            this.f26044a.edit().putLong(str, ((Long) t10).longValue()).apply();
        } else if (t10 instanceof Boolean) {
            this.f26044a.edit().putBoolean(str, ((Boolean) t10).booleanValue()).apply();
        } else {
            throw new IllegalArgumentException("Not support value type " + t10.getClass().getName());
        }
    }
}
