package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.util.Log;
import com.huawei.hms.common.Preconditions;
import com.huawei.hms.feature.dynamic.DynamicModule;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.scankit.util.a;
import java.lang.reflect.InvocationTargetException;
/* compiled from: RemoteViewInitializer.java */
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static volatile Context f14003a;

    public static void a(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        context.getClassLoader().loadClass("com.huawei.hms.feature.DynamicModuleInitializer").getDeclaredMethod("initializeModule", Context.class).invoke(null, context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteCreator b(Context context) {
        Preconditions.checkNotNull(context);
        try {
            Context d10 = d(context);
            if (d10 == null) {
                return null;
            }
            Object newInstance = d10.getClassLoader().loadClass("com.huawei.hms.scankit.Creator").newInstance();
            if (newInstance instanceof IBinder) {
                return IRemoteCreator.Stub.asInterface((IBinder) newInstance);
            }
            return null;
        } catch (ClassNotFoundException unused) {
            a.b("exception", "ClassNotFoundException");
            return null;
        } catch (IllegalAccessException unused2) {
            a.b("exception", "IllegalAccessException");
            return null;
        } catch (InstantiationException unused3) {
            a.b("exception", "InstantiationException");
            return null;
        } catch (NoSuchMethodException unused4) {
            a.b("exception", "NoSuchMethodException");
            return null;
        } catch (InvocationTargetException unused5) {
            a.b("exception", "InvocationTargetException");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IRemoteCreator c(Context context) {
        Preconditions.checkNotNull(context);
        try {
            Object newInstance = context.getClassLoader().loadClass("com.huawei.hms.scankit.Creator").newInstance();
            if (newInstance instanceof IBinder) {
                return IRemoteCreator.Stub.asInterface((IBinder) newInstance);
            }
        } catch (ClassNotFoundException unused) {
            a.b("exception", "ClassNotFoundException");
        } catch (IllegalAccessException unused2) {
            a.b("exception", "IllegalAccessException");
        } catch (InstantiationException unused3) {
            a.b("exception", "InvocationTargetException");
        }
        return null;
    }

    public static Context d(Context context) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Log.i("ScankitSDK", "ScankitSDK Version: SCANLITE1.3.2.300");
        a(context);
        if (f14003a != null) {
            Log.i("ScankitSDK", "context has been inited");
            return f14003a;
        }
        try {
            int remoteVersion = DynamicModule.getRemoteVersion(context.getApplicationContext(), "huawei_module_scankit");
            int e10 = e(context);
            if (e10 > remoteVersion) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("local Version is Higher");
                sb2.append(e10);
                Log.i("ScankitSDK", sb2.toString());
                a(context);
                return context;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("use remote scankit");
            sb3.append(remoteVersion);
            Log.i("ScankitSDK", sb3.toString());
            f14003a = DynamicModule.load(context.getApplicationContext(), DynamicModule.PREFER_REMOTE, "huawei_module_scankit").getModuleContext();
            return f14003a;
        } catch (DynamicModule.LoadingException unused) {
            a(context);
            Log.w("ScankitSDK", "Remote Load exception");
            return context;
        } catch (ClassNotFoundException unused2) {
            Log.e("ScankitSDK", "ClassNotFoundException exception");
            a(context);
            return context;
        } catch (IllegalAccessException unused3) {
            Log.e("ScankitSDK", "IllegalAccessException exception");
            a(context);
            return context;
        } catch (NoSuchMethodException unused4) {
            Log.e("ScankitSDK", "NoSuchMethodException exception");
            a(context);
            return context;
        } catch (RuntimeException unused5) {
            Log.e("ScankitSDK", "other RuntimeException exception");
            a(context);
            return context;
        } catch (InvocationTargetException unused6) {
            Log.e("ScankitSDK", "InvocationTargetException exception");
            a(context);
            return context;
        } catch (Exception unused7) {
            Log.e("ScankitSDK", "Exception exception");
            a(context);
            return context;
        } catch (Throwable unused8) {
            Log.e("ScankitSDK", "Throwable exception");
            a(context);
            return context;
        }
    }

    private static int e(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getInt("huawei_module_scankit_local", -1);
        } catch (PackageManager.NameNotFoundException unused) {
            a.b("exception", "NameNotFoundException");
            return -1;
        }
    }
}
