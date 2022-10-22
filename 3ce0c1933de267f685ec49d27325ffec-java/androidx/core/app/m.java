package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.app.k;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NotificationCompatJellybean.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f2370a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static Field f2371b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f2372c;

    public static SparseArray<Bundle> a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i10 = 0; i10 < size; i10++) {
            Bundle bundle = list.get(i10);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i10, bundle);
            }
        }
        return sparseArray;
    }

    private static p b(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("allowedDataTypes");
        HashSet hashSet = new HashSet();
        if (stringArrayList != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        return new p(bundle.getString("resultKey"), bundle.getCharSequence("label"), bundle.getCharSequenceArray("choices"), bundle.getBoolean("allowFreeFormInput"), 0, bundle.getBundle("extras"), hashSet);
    }

    private static p[] c(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return null;
        }
        p[] pVarArr = new p[bundleArr.length];
        for (int i10 = 0; i10 < bundleArr.length; i10++) {
            pVarArr[i10] = b(bundleArr[i10]);
        }
        return pVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k.a d(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("extras");
        boolean z10 = false;
        if (bundle2 != null) {
            z10 = bundle2.getBoolean("android.support.allowGeneratedReplies", false);
        }
        return new k.a(bundle.getInt("icon"), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable("actionIntent"), bundle.getBundle("extras"), c(e(bundle, "remoteInputs")), c(e(bundle, "dataOnlyRemoteInputs")), z10, bundle.getInt("semanticAction"), bundle.getBoolean("showsUserInterface"), false);
    }

    private static Bundle[] e(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Bundle[]) || parcelableArray == null) {
            return (Bundle[]) parcelableArray;
        }
        Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
        bundle.putParcelableArray(str, bundleArr);
        return bundleArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle f(k.a aVar) {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat e10 = aVar.e();
        bundle2.putInt("icon", e10 != null ? e10.i() : 0);
        bundle2.putCharSequence("title", aVar.i());
        bundle2.putParcelable("actionIntent", aVar.a());
        if (aVar.d() != null) {
            bundle = new Bundle(aVar.d());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", i(aVar.f()));
        bundle2.putBoolean("showsUserInterface", aVar.h());
        bundle2.putInt("semanticAction", aVar.g());
        return bundle2;
    }

    public static Bundle g(Notification notification) {
        synchronized (f2370a) {
            if (f2372c) {
                return null;
            }
            try {
                if (f2371b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f2372c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f2371b = declaredField;
                }
                Bundle bundle = (Bundle) f2371b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f2371b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e10) {
                Log.e("NotificationCompat", "Unable to access notification extras", e10);
                f2372c = true;
                return null;
            } catch (NoSuchFieldException e11) {
                Log.e("NotificationCompat", "Unable to access notification extras", e11);
                f2372c = true;
                return null;
            }
        }
    }

    private static Bundle h(p pVar) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", pVar.i());
        bundle.putCharSequence("label", pVar.h());
        bundle.putCharSequenceArray("choices", pVar.e());
        bundle.putBoolean("allowFreeFormInput", pVar.c());
        bundle.putBundle("extras", pVar.g());
        Set<String> d10 = pVar.d();
        if (d10 != null && !d10.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(d10.size());
            for (String str : d10) {
                arrayList.add(str);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    private static Bundle[] i(p[] pVarArr) {
        if (pVarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[pVarArr.length];
        for (int i10 = 0; i10 < pVarArr.length; i10++) {
            bundleArr[i10] = h(pVarArr[i10]);
        }
        return bundleArr;
    }

    public static Bundle j(Notification.Builder builder, k.a aVar) {
        IconCompat e10 = aVar.e();
        builder.addAction(e10 != null ? e10.i() : 0, aVar.i(), aVar.a());
        Bundle bundle = new Bundle(aVar.d());
        if (aVar.f() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", i(aVar.f()));
        }
        if (aVar.c() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", i(aVar.c()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        return bundle;
    }
}
