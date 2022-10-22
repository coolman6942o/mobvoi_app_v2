package va;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import com.mobvoi.wear.lpa.LpaConstants;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
/* compiled from: SPHelper.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Context f35706a;

    /* renamed from: b  reason: collision with root package name */
    public static String f35707b;

    public static void a() {
        if (f35706a == null) {
            throw new IllegalStateException("context has not been initialed");
        }
    }

    public static int b(String str, int i10) {
        a();
        ContentResolver contentResolver = f35706a.getContentResolver();
        String type = contentResolver.getType(Uri.parse("content://" + f35707b + ".sphelper/int/" + str));
        return (type == null || type.equals(LpaConstants.VALUE_NULL)) ? i10 : Integer.parseInt(type);
    }

    public static void c(Application application) {
        f35706a = application.getApplicationContext();
        f35707b = application.getPackageName();
    }

    public static synchronized void d(String str, Integer num) {
        synchronized (a.class) {
            a();
            ContentResolver contentResolver = f35706a.getContentResolver();
            Uri parse = Uri.parse("content://" + f35707b + ".sphelper/int/" + str);
            ContentValues contentValues = new ContentValues();
            contentValues.put(HealthDataProviderContracts.NAME_VALUE, num);
            contentResolver.update(parse, contentValues, null, null);
        }
    }
}
