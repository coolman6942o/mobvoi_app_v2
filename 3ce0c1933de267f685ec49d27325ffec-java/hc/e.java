package hc;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import androidx.core.app.a;
import androidx.core.content.b;
import androidx.fragment.app.Fragment;
import gc.f;
import java.util.ArrayList;
/* compiled from: PermissionUtils.java */
/* loaded from: classes2.dex */
public class e {
    private static void a(Object obj) {
        if (!(obj instanceof Activity) && !(obj instanceof Fragment)) {
            throw new IllegalArgumentException("The caller must be an Activity or a Fragment: " + obj.getClass().getName());
        }
    }

    public static boolean b(Fragment fragment, int i10, String... strArr) {
        return d(fragment, i10, strArr);
    }

    private static d c(int i10, String... strArr) {
        d dVar = new d();
        dVar.f27808a = i10;
        dVar.f27809b = strArr;
        return dVar;
    }

    private static boolean d(Object obj, int i10, String... strArr) {
        a(obj);
        String[] g10 = g(obj instanceof Fragment ? ((Fragment) obj).getActivity() : (Activity) obj, strArr);
        if (g10.length <= 0) {
            return true;
        }
        e(obj, c(i10, g10));
        return false;
    }

    private static void e(Object obj, d dVar) {
        a(obj);
        f(obj, dVar.f27809b, dVar.f27808a);
    }

    private static void f(Object obj, String[] strArr, int i10) {
        if (obj instanceof Activity) {
            a.s((Activity) obj, strArr, i10);
        } else if (obj instanceof Fragment) {
            ((Fragment) obj).requestPermissions(strArr, i10);
        }
    }

    public static String[] g(Context context, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (b.a(context, str) == -1) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String h(String str) {
        char c10;
        int i10;
        str.hashCode();
        switch (str.hashCode()) {
            case -1921431796:
                if (str.equals("android.permission.READ_CALL_LOG")) {
                    c10 = 0;
                    break;
                }
                c10 = 65535;
                break;
            case -1888586689:
                if (str.equals("android.permission.ACCESS_FINE_LOCATION")) {
                    c10 = 1;
                    break;
                }
                c10 = 65535;
                break;
            case -1674700861:
                if (str.equals("android.permission.ANSWER_PHONE_CALLS")) {
                    c10 = 2;
                    break;
                }
                c10 = 65535;
                break;
            case -895673731:
                if (str.equals("android.permission.RECEIVE_SMS")) {
                    c10 = 3;
                    break;
                }
                c10 = 65535;
                break;
            case -63024214:
                if (str.equals("android.permission.ACCESS_COARSE_LOCATION")) {
                    c10 = 4;
                    break;
                }
                c10 = 65535;
                break;
            case -5573545:
                if (str.equals("android.permission.READ_PHONE_STATE")) {
                    c10 = 5;
                    break;
                }
                c10 = 65535;
                break;
            case 112197485:
                if (str.equals("android.permission.CALL_PHONE")) {
                    c10 = 6;
                    break;
                }
                c10 = 65535;
                break;
            case 463403621:
                if (str.equals("android.permission.CAMERA")) {
                    c10 = 7;
                    break;
                }
                c10 = 65535;
                break;
            case 1365911975:
                if (str.equals("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    c10 = '\b';
                    break;
                }
                c10 = 65535;
                break;
            case 1977429404:
                if (str.equals("android.permission.READ_CONTACTS")) {
                    c10 = '\t';
                    break;
                }
                c10 = 65535;
                break;
            default:
                c10 = 65535;
                break;
        }
        switch (c10) {
            case 0:
                i10 = f.f27366h;
                break;
            case 1:
                i10 = f.f27364f;
                break;
            case 2:
            case 6:
                i10 = f.f27365g;
                break;
            case 3:
                i10 = f.f27371m;
                break;
            case 4:
                i10 = f.f27363e;
                break;
            case 5:
                i10 = f.f27368j;
                break;
            case 7:
                i10 = f.f27370l;
                break;
            case '\b':
                i10 = f.f27369k;
                break;
            case '\t':
                i10 = f.f27367i;
                break;
            default:
                i10 = -1;
                break;
        }
        return i10 != -1 ? com.mobvoi.android.common.utils.b.e().getString(i10) : "";
    }

    public static boolean i(Context context, String... strArr) {
        if (strArr.length < 1) {
            return false;
        }
        for (String str : strArr) {
            if (b.a(context, str) == -1) {
                return false;
            }
        }
        return true;
    }

    public static boolean j(Context context) {
        if (Build.VERSION.SDK_INT >= 29) {
            return true;
        }
        return i(context, "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static boolean k(int[] iArr) {
        if (iArr.length < 1) {
            return false;
        }
        for (int i10 : iArr) {
            if (i10 == -1) {
                return false;
            }
        }
        return true;
    }
}
