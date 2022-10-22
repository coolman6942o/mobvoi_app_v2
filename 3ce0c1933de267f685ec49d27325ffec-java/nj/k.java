package nj;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.r;
import fi.a;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/* compiled from: McuStringUtil.java */
/* loaded from: classes2.dex */
public class k extends r {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f31276a = false;

    public static String d(String str) {
        int indexOf;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int length = str.length();
        int indexOf2 = str.indexOf("[");
        return (indexOf2 == -1 || !str.startsWith("[") || (indexOf = str.indexOf("]")) == -1 || str.substring(indexOf2 + 1, indexOf).contains("[")) ? str : str.substring(indexOf + 1, length);
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (r.c(charAt)) {
                sb2.append(charAt);
            } else {
                sb2.append(" ");
            }
        }
        return sb2.toString();
    }

    @SuppressLint({"SwitchIntDef"})
    public static String f(Context context, a aVar) {
        int c10 = aVar.c();
        if (c10 == 0) {
            return context.getString(sh.k.G3);
        }
        if (c10 == 1) {
            return context.getString(sh.k.B3);
        }
        if (c10 != 2) {
            return context.getString(sh.k.f34895y0);
        }
        return context.getString(sh.k.C3);
    }

    public static InputStream g(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            return httpURLConnection.getInputStream();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
