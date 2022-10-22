package vk;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.framework.common.ContainerUtils;
import com.mobvoi.wear.providers.OtaColumn;
import com.pingplusplus.android.e;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: g  reason: collision with root package name */
    private static String[] f35794g = {"app_id", "device_id", "enter_time", "sdk_type", "sdk_version", "system", "system_version"};

    /* renamed from: b  reason: collision with root package name */
    public String f35796b;

    /* renamed from: c  reason: collision with root package name */
    public Long f35797c;

    /* renamed from: e  reason: collision with root package name */
    public String f35799e;

    /* renamed from: a  reason: collision with root package name */
    public String f35795a = Build.MODEL + "," + Build.VERSION.RELEASE;

    /* renamed from: f  reason: collision with root package name */
    public List<String> f35800f = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public Map<String, Integer> f35798d = new HashMap();

    public b(Context context) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("systemVersion=");
        sb2.append(this.f35795a);
        c.b(sb2.toString());
        String h10 = i.e(context).h();
        this.f35796b = h10;
        c.b(h10);
        k();
    }

    private void c(String str) {
        this.f35800f.add(str);
    }

    private void f(String str) {
        if (this.f35799e == null) {
            this.f35799e = str;
        }
        Integer num = 1;
        if (this.f35798d.containsKey(str)) {
            num = Integer.valueOf(num.intValue() + this.f35798d.get(str).intValue());
        }
        this.f35798d.put(str, num);
    }

    private Object g(String str) {
        try {
            return b.class.getDeclaredField(str).get(this);
        } catch (Exception e10) {
            c.a(e10);
            return null;
        }
    }

    private String j() {
        c.b(h());
        c.b(e());
        return i.i(h());
    }

    private static long k() {
        return new Date().getTime() / 1000;
    }

    private String[] l() {
        Field[] declaredFields = b.class.getDeclaredFields();
        ArrayList arrayList = new ArrayList();
        for (Field field : declaredFields) {
            if (Modifier.isPublic(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field.getName());
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public Map<String, Object> a() {
        String[] l10;
        HashMap hashMap = new HashMap();
        for (String str : l()) {
            Object g10 = g(str);
            if (g10 != null) {
                hashMap.put(i.b(str), g10);
            }
        }
        return hashMap;
    }

    public void b(e eVar) {
        Integer num = eVar.f22093c;
    }

    public void d(JSONObject jSONObject) {
        try {
            c(jSONObject.getString("id"));
            f(jSONObject.getString("channel"));
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        String str = null;
        try {
            str = jSONObject.getString(OtaColumn.COLUMN_APP);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        if (str == null) {
            try {
                jSONObject.getJSONObject(OtaColumn.COLUMN_APP).getString("id");
            } catch (JSONException e12) {
                e12.printStackTrace();
            }
        }
    }

    public String e() {
        return new JSONObject(a()).toString();
    }

    public String h() {
        String[] strArr;
        Map<String, Object> a10 = a();
        StringBuilder sb2 = new StringBuilder();
        for (String str : f35794g) {
            if (sb2.length() != 0) {
                sb2.append(ContainerUtils.FIELD_DELIMITER);
            }
            sb2.append(str);
            sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb2.append(a10.get(str) == null ? "" : a10.get(str));
        }
        return sb2.toString();
    }

    public void i() {
        this.f35797c = Long.valueOf(k());
    }

    public void m() {
        if (this.f35797c == null) {
            i();
        }
        HashMap hashMap = new HashMap();
        if (j() != null) {
            hashMap.put("X-Pingpp-Report-Token", j());
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(a());
        i.d().f("https://statistics.pingxx.com/report", arrayList, hashMap);
    }
}
