package vk;

import android.util.Log;
import com.mobvoi.wear.lpa.LpaConstants;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f35801a = false;

    /* renamed from: b  reason: collision with root package name */
    private static String f35802b = "PING++";

    /* renamed from: c  reason: collision with root package name */
    private static boolean f35803c = false;

    public static void a(Exception exc) {
        if (f35803c) {
            if (exc != null) {
                exc.printStackTrace();
            }
        } else if (f35801a && exc != null && exc.getMessage() != null) {
            Log.d(f35802b, exc.getMessage());
        }
    }

    public static void b(String str) {
        if (f35803c) {
            if (str == null) {
                str = LpaConstants.VALUE_NULL;
            }
            Log.d("pingpp_debug", str);
        }
    }

    public static void c(String str) {
        if (f35801a) {
            String str2 = f35802b;
            if (str == null) {
                str = LpaConstants.VALUE_NULL;
            }
            Log.d(str2, str);
        }
    }
}
