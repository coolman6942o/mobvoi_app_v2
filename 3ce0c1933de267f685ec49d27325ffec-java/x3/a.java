package x3;

import android.text.TextUtils;
import com.mobvoi.wear.contacts.ContactConstant;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import y3.b;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public com.alipay.sdk.protocol.a f36357a;

    /* renamed from: b  reason: collision with root package name */
    public String[] f36358b;

    public a(String str, com.alipay.sdk.protocol.a aVar) {
        this.f36357a = aVar;
    }

    public static List<a> b(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        if (jSONObject == null) {
            return arrayList;
        }
        String[] d10 = d(jSONObject.optString(ContactConstant.CallsRecordKeys.NAME, ""));
        for (int i10 = 0; i10 < d10.length; i10++) {
            com.alipay.sdk.protocol.a a10 = com.alipay.sdk.protocol.a.a(d10[i10]);
            if (a10 != com.alipay.sdk.protocol.a.None) {
                a aVar = new a(d10[i10], a10);
                aVar.f36358b = e(d10[i10]);
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    public static void c(a aVar) {
        String[] f10 = aVar.f();
        if (f10.length == 3 && TextUtils.equals("tid", f10[0])) {
            z3.a a10 = z3.a.a(b.e().c());
            if (!TextUtils.isEmpty(f10[1]) && !TextUtils.isEmpty(f10[2])) {
                a10.b(f10[1], f10[2]);
            }
        }
    }

    public static String[] d(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.split(";");
        }
        return null;
    }

    public static String[] e(String str) {
        ArrayList arrayList = new ArrayList();
        int indexOf = str.indexOf(40);
        int lastIndexOf = str.lastIndexOf(41);
        if (indexOf == -1 || lastIndexOf == -1 || lastIndexOf <= indexOf) {
            return null;
        }
        for (String str2 : str.substring(indexOf + 1, lastIndexOf).split("' *, *'", -1)) {
            arrayList.add(str2.trim().replaceAll("'", "").replaceAll("\"", ""));
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public com.alipay.sdk.protocol.a a() {
        return this.f36357a;
    }

    public String[] f() {
        return this.f36358b;
    }
}
