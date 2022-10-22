package yd;

import android.content.SharedPreferences;
import android.util.Base64;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/* compiled from: PreferencesUtil.java */
/* loaded from: classes2.dex */
public class i {

    /* renamed from: d  reason: collision with root package name */
    public static i f37012d;

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f37013a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f37014b = null;

    /* renamed from: c  reason: collision with root package name */
    private Object f37015c;

    public i() {
        this.f37013a = null;
        this.f37013a = b.e().getSharedPreferences("vpa_sp", 0);
    }

    public static i a() {
        if (f37012d == null) {
            synchronized (i.class) {
                if (f37012d == null) {
                    f37012d = new i();
                }
            }
        }
        return f37012d;
    }

    public Object b(String str) {
        try {
            this.f37015c = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(this.f37013a.getString(str, "").getBytes(), 0))).readObject();
            k.a(i.class.getSimpleName(), "Get object success");
            return this.f37015c;
        } catch (Exception unused) {
            k.d(i.class.getSimpleName(), "Get object is error");
            return null;
        }
    }

    public Object c(String str, Object obj) {
        if (obj == null) {
            return b(str);
        }
        String simpleName = obj.getClass().getSimpleName();
        if ("String".equals(simpleName)) {
            return this.f37013a.getString(str, (String) obj);
        }
        if ("Integer".equals(simpleName)) {
            return Integer.valueOf(this.f37013a.getInt(str, ((Integer) obj).intValue()));
        }
        if ("Boolean".equals(simpleName)) {
            return Boolean.valueOf(this.f37013a.getBoolean(str, ((Boolean) obj).booleanValue()));
        }
        if ("Float".equals(simpleName)) {
            return Float.valueOf(this.f37013a.getFloat(str, ((Float) obj).floatValue()));
        }
        if ("Long".equals(simpleName)) {
            return Long.valueOf(this.f37013a.getLong(str, ((Long) obj).longValue()));
        }
        return b(str);
    }

    public synchronized void d(String str, Object obj) {
        if (this.f37014b == null) {
            this.f37014b = this.f37013a.edit();
        }
        String simpleName = obj.getClass().getSimpleName();
        if ("String".equals(simpleName)) {
            this.f37014b.putString(str, (String) obj);
        } else if ("Integer".equals(simpleName)) {
            this.f37014b.putInt(str, ((Integer) obj).intValue());
        } else if ("Boolean".equals(simpleName)) {
            this.f37014b.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if ("Float".equals(simpleName)) {
            this.f37014b.putFloat(str, ((Float) obj).floatValue());
        } else if ("Long".equals(simpleName)) {
            this.f37014b.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Serializable) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
                this.f37014b.putString(str, Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                k.a(i.class.getSimpleName(), "save object success");
            } catch (IOException e10) {
                e10.printStackTrace();
                k.d(i.class.getSimpleName(), "save object error");
            }
        } else {
            throw new IllegalArgumentException(obj.getClass().getName() + " must implements Serializable!");
        }
        this.f37014b.commit();
    }
}
