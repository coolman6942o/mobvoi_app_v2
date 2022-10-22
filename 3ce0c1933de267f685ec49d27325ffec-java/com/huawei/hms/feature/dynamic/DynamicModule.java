package com.huawei.hms.feature.dynamic;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.huawei.hms.common.util.Logger;
import com.huawei.hms.feature.dynamic.IDynamicInstall;
import com.huawei.hms.feature.dynamic.IDynamicLoader;
import com.huawei.hms.feature.dynamic.a.b;
import com.huawei.hms.feature.dynamic.a.c;
import com.huawei.hms.feature.dynamic.a.d;
import com.huawei.hms.feature.dynamic.a.e;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;
import java.util.Set;
/* loaded from: classes.dex */
public class DynamicModule {

    /* renamed from: b  reason: collision with root package name */
    private static final int f13754b = 256;

    /* renamed from: c  reason: collision with root package name */
    private static final int f13755c = -100;

    /* renamed from: h  reason: collision with root package name */
    private static int f13759h = 0;

    /* renamed from: i  reason: collision with root package name */
    private static final int f13760i = 1;

    /* renamed from: j  reason: collision with root package name */
    private static final int f13761j = 2;

    /* renamed from: g  reason: collision with root package name */
    private Context f13762g;
    public static final VersionPolicy PREFER_REMOTE = new e();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new c();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new d();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new e();

    /* renamed from: a  reason: collision with root package name */
    private static final String f13753a = DynamicModule.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<HashMap<String, Boolean>> f13756d = new ThreadLocal<>();

    /* renamed from: e  reason: collision with root package name */
    private static final ThreadLocal<HashMap<String, String>> f13757e = new ThreadLocal<>();

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadLocal<HashMap<String, IDynamicLoader>> f13758f = new ThreadLocal<>();

    /* loaded from: classes.dex */
    public static class DynamicLoaderClassLoader {

        /* renamed from: a  reason: collision with root package name */
        private static HashMap<String, ClassLoader> f13768a = new HashMap<>();

        public static ClassLoader getsClassLoader(String str) {
            return f13768a.get(str);
        }

        public static void setsClassLoader(String str, ClassLoader classLoader) {
            f13768a.put(str, classLoader);
        }
    }

    /* loaded from: classes.dex */
    public static class LoadingException extends Exception {

        /* renamed from: a  reason: collision with root package name */
        private Bundle f13769a;

        private LoadingException(String str) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, byte b10) {
            this(str);
        }

        private LoadingException(String str, Bundle bundle) {
            super(str);
            this.f13769a = bundle;
        }

        /* synthetic */ LoadingException(String str, Bundle bundle, byte b10) {
            this(str, bundle);
        }

        public Bundle getBundle() {
            return this.f13769a;
        }
    }

    /* loaded from: classes.dex */
    public interface VersionPolicy {
        Bundle getModuleInfo(Context context, String str) throws LoadingException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a extends Exception {
        private a(String str) {
            super(str);
        }

        /* synthetic */ a(String str, byte b10) {
            this(str);
        }
    }

    private DynamicModule(Context context) {
        this.f13762g = context;
    }

    public static Set<String> GetInstalledModuleInfo() {
        return c.a().f13815a;
    }

    private static Context a(Context context, String str, Bundle bundle, IDynamicLoader iDynamicLoader) throws LoadingException {
        try {
            IObjectWrapper load = iDynamicLoader.load(ObjectWrapper.wrap(context), str, bundle.getInt(b.f13799j), ObjectWrapper.wrap(bundle));
            if (ObjectWrapper.unwrap(load) == null) {
                Logger.w(f13753a, "Get remote context is null.");
                return null;
            } else if (ObjectWrapper.unwrap(load) instanceof Context) {
                Logger.i(f13753a, "Get context success.");
                return (Context) ObjectWrapper.unwrap(load);
            } else if (!ObjectWrapper.unwrap(load).getClass().getName().equals(LoadingException.class.getName())) {
                return null;
            } else {
                Logger.w(f13753a, "Successfully get the bundle in exception.");
                throw new LoadingException("Failed to load, please check the bundle in exception.", (Bundle) ObjectWrapper.unwrap(load).getClass().getDeclaredMethod("getBundle", new Class[0]).invoke(ObjectWrapper.unwrap(load), new Object[0]), (byte) 0);
            }
        } catch (LoadingException e10) {
            throw e10;
        } catch (Exception e11) {
            Logger.w(f13753a, "Failed to get remote module context.", e11);
            return null;
        }
    }

    private static Bundle a(Context context, String str) throws LoadingException, a {
        try {
            Bundle d10 = d(context, str);
            String string = d10.getString(b.f13805p);
            if (TextUtils.isEmpty(string) || !new File(string).exists()) {
                String str2 = f13753a;
                Logger.w(str2, "The loader_path:" + string + " is not available.");
                throw new LoadingException("The loader_path in queryBundle is empty or not exist.", (byte) 0);
            }
            String str3 = f13753a;
            Logger.i(str3, "Query HMS module:" + str + " info success.");
            return d10;
        } catch (LoadingException e10) {
            throw e10;
        } catch (Exception unused) {
            throw new a("failed to get :" + str + " info.", (byte) 0);
        }
    }

    private static DynamicModule a(Context context, String str, Bundle bundle) throws LoadingException {
        Boolean bool;
        IDynamicLoader iDynamicLoader;
        try {
            synchronized (DynamicModule.class) {
                HashMap<String, Boolean> hashMap = f13756d.get();
                Objects.requireNonNull(hashMap);
                bool = hashMap.get(str);
                HashMap<String, IDynamicLoader> hashMap2 = f13758f.get();
                Objects.requireNonNull(hashMap2);
                iDynamicLoader = hashMap2.get(str);
            }
            if (bool == null || iDynamicLoader == null) {
                throw new LoadingException("The loader for " + str + " was not prepared.", (byte) 0);
            }
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            Context a10 = a(context, str, bundle, iDynamicLoader);
            if (a10 != null) {
                return new DynamicModule(a10);
            }
            throw new LoadingException("Failed to get remote module context: null", (byte) 0);
        } catch (LoadingException e10) {
            throw e10;
        } catch (Exception unused) {
            throw new LoadingException("Load Module Error.", (byte) 0);
        }
    }

    private static IDynamicInstall a(Context context) throws LoadingException {
        int i10;
        int i11;
        String str = null;
        try {
            Bundle a10 = a(context, b.f13793d);
            str = a10.getString(b.f13805p);
            i10 = a10.getInt(b.f13804o);
        } catch (Exception e10) {
            Logger.w(f13753a, "Cannot get remote HMS dynamicLoader.", e10);
            i10 = 0;
        }
        try {
            i11 = getLocalVersion(context, b.f13793d);
        } catch (Exception e11) {
            Logger.w(f13753a, "Cannot find local dynamicLoader fallback.", e11);
            i11 = 0;
        }
        String str2 = f13753a;
        Logger.i(str2, "DynamicLoader remoteHMSVersion:" + i10 + ", hmsLoaderPath:" + str + ", localLoaderVersion:" + i11);
        int i12 = i10 > i11 ? i10 : i11;
        if (i12 <= 10009300) {
            Logger.w(str2, "The current version:" + i12 + " is too low.");
            throw new LoadingException("The loader version:" + i12 + " is too low to support HFF.", (byte) 0);
        } else if (i10 > i11) {
            Logger.i(str2, "Choose hms dynamicLoader: ".concat(String.valueOf(str)));
            f13759h = 1;
            return a(str);
        } else {
            Logger.i(str2, "Choose local dynamicLoader fallback: ");
            f13759h = 2;
            return b(context);
        }
    }

    private static IDynamicInstall a(String str) throws LoadingException {
        if (str != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return IDynamicInstall.Stub.asInterface((IBinder) new com.huawei.hms.feature.dynamic.a.a(str, ClassLoader.getSystemClassLoader()).loadClass(b.f13795f).getConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
                throw new LoadingException("getHMSDynamicInstaller: failed to instantiate dynamic loader:" + e10.getMessage(), (byte) 0);
            }
        }
        throw new LoadingException("Failed to get dynamicLoader path.", (byte) 0);
    }

    private static void a(String str, ClassLoader classLoader) throws LoadingException {
        try {
            f13758f.set(new HashMap<String, IDynamicLoader>(str, (IBinder) classLoader.loadClass(b.f13794e).getConstructor(new Class[0]).newInstance(new Object[0])) { // from class: com.huawei.hms.feature.dynamic.DynamicModule.3

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ String f13766a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ IBinder f13767b;

                {
                    this.f13766a = str;
                    this.f13767b = r2;
                    put(str, IDynamicLoader.Stub.asInterface(r2));
                }
            });
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
            throw new LoadingException("Failed to get loader interface:" + e10.getMessage(), (byte) 0);
        }
    }

    private static Bundle b(Context context, String str) throws LoadingException {
        Method declaredMethod;
        ClassLoader classLoader;
        boolean z10 = true;
        try {
            try {
                Class<?> loadClass = (context.getApplicationContext() == null ? context : context.getApplicationContext()).getClassLoader().loadClass(DynamicLoaderClassLoader.class.getName());
                Method declaredMethod2 = loadClass.getDeclaredMethod("getsClassLoader", String.class);
                declaredMethod = loadClass.getDeclaredMethod("setsClassLoader", String.class, ClassLoader.class);
                classLoader = (ClassLoader) declaredMethod2.invoke(null, str);
            } catch (LoadingException e10) {
                throw e10;
            }
        } catch (Exception e11) {
            Logger.w(f13753a, "failed to load.", e11);
        }
        if (classLoader == null) {
            try {
                String str2 = f13753a;
                Logger.i(str2, "No available cached loader, query remote.");
                Bundle c10 = c(context, str);
                synchronized (DynamicModule.class) {
                    HashMap<String, String> hashMap = f13757e.get();
                    Objects.requireNonNull(hashMap);
                    String str3 = hashMap.get(str);
                    if (TextUtils.isEmpty(str3)) {
                        return c10;
                    }
                    if (Build.VERSION.SDK_INT < 21) {
                        Logger.i(str2, "The android version is below android 5.");
                        b bVar = new b(str3, context.getFilesDir().getAbsolutePath(), ClassLoader.getSystemClassLoader());
                        a(str, bVar);
                        declaredMethod.invoke(null, str, bVar);
                    } else {
                        com.huawei.hms.feature.dynamic.a.a aVar = new com.huawei.hms.feature.dynamic.a.a(str3, ClassLoader.getSystemClassLoader());
                        a(str, aVar);
                        declaredMethod.invoke(null, str, aVar);
                    }
                    f13756d.set(new HashMap<String, Boolean>(str) { // from class: com.huawei.hms.feature.dynamic.DynamicModule.1

                        /* renamed from: a  reason: collision with root package name */
                        final /* synthetic */ String f13763a;

                        {
                            this.f13763a = str;
                            put(str, Boolean.TRUE);
                        }
                    });
                    return c10;
                }
            } catch (a unused) {
            }
        } else if (classLoader != ClassLoader.getSystemClassLoader()) {
            Logger.i(f13753a, "Cached loader is available, ready to use it.");
            try {
                a(str, classLoader);
            } catch (LoadingException e12) {
                Logger.w(f13753a, "Get loader interface failed.", e12);
            }
            HashMap<String, Boolean> hashMap2 = new HashMap<>();
            hashMap2.put(str, Boolean.valueOf(z10));
            f13756d.set(hashMap2);
            return new Bundle();
        }
        z10 = false;
        HashMap<String, Boolean> hashMap22 = new HashMap<>();
        hashMap22.put(str, Boolean.valueOf(z10));
        f13756d.set(hashMap22);
        return new Bundle();
    }

    private static IDynamicInstall b(Context context) throws LoadingException {
        try {
            return (IDynamicInstall) context.getClassLoader().loadClass(b.f13795f).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e10) {
            throw new LoadingException("getLocalLoaderFallback: failed to instantiate dynamic loader: " + e10.getMessage(), (byte) 0);
        }
    }

    private static Bundle c(Context context, String str) throws LoadingException, a {
        try {
            Bundle d10 = d(context, str);
            String string = d10.getString(b.f13805p);
            if (!TextUtils.isEmpty(string) && new File(string).exists()) {
                f13757e.set(new HashMap<String, String>(str, string) { // from class: com.huawei.hms.feature.dynamic.DynamicModule.2

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ String f13764a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ String f13765b;

                    {
                        this.f13764a = str;
                        this.f13765b = string;
                        put(str, string);
                    }
                });
                String str2 = f13753a;
                Logger.i(str2, "Query remote version by module name:" + str + " success.");
                return d10;
            }
            String str3 = f13753a;
            Logger.w(str3, "The loader_path:" + string + " in query bundle is not available,change the module version to:-100");
            d10.putInt(b.f13799j, f13755c);
            return d10;
        } catch (LoadingException e10) {
            throw e10;
        } catch (Exception unused) {
            throw new a("failed to Query remote version.", (byte) 0);
        }
    }

    private static Bundle d(Context context, String str) throws LoadingException, a {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            if (contentResolver != null) {
                Bundle call = contentResolver.call(Uri.parse(b.f13790a), str, (String) null, (Bundle) null);
                if (call != null) {
                    int i10 = call.getInt(b.f13796g);
                    String string = call.getString(b.f13805p);
                    String str2 = f13753a;
                    Logger.i(str2, "bundle info: errorCode:" + i10 + ", moduleVersion:" + call.getInt(b.f13799j) + ", modulePath:" + call.getString(b.f13801l) + ", loader_version:" + call.getInt(b.f13804o) + ", loaderPath:" + string + ", armeabiType:" + call.getInt(b.f13806q));
                    if (i10 == 0) {
                        return call;
                    }
                    Logger.w(str2, "Failed to get " + str + " bundle info, errcode:" + i10);
                    throw new LoadingException("Query " + str + " unavailable, errorCode:" + i10, call, (byte) 0);
                }
                Logger.w(f13753a, "Failed to get bundle info:null.");
                throw new a("Query remote version failed: null bundle info.", (byte) 0);
            }
            throw new a("Query remote version failed: null contentResolver.", (byte) 0);
        } catch (LoadingException e10) {
            throw e10;
        } catch (Exception unused) {
            throw new a("failed to get :" + str + " info.", (byte) 0);
        }
    }

    public static Bundle getLocalModuleInfo(Context context, String str) {
        int localVersion = getLocalVersion(context, str);
        Bundle bundle = new Bundle();
        bundle.putString(b.f13798i, str);
        bundle.putInt(b.f13800k, localVersion);
        return bundle;
    }

    public static int getLocalVersion(Context context, String str) {
        if (context == null || str.length() == 0 || str.length() > 256) {
            Logger.e(f13753a, "Invalid context or moduleName.");
            return 0;
        }
        try {
            String str2 = "com.huawei.hms.feature.dynamic.descriptors." + str + ".ModuleDescriptor";
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            return context.getClassLoader().loadClass(str2).getDeclaredField("MODULE_VERSION").getInt(null);
        } catch (ClassNotFoundException unused) {
            Logger.w(f13753a, "Cannot find the class of module descriptor for ".concat(str));
            return 0;
        } catch (Exception e10) {
            Logger.w(f13753a, "Get local module info failed.", e10);
            return 0;
        }
    }

    public static Bundle getRemoteModuleInfo(Context context, String str) throws LoadingException {
        try {
        } catch (LoadingException e10) {
            throw e10;
        } catch (Exception e11) {
            String str2 = f13753a;
            Logger.w(str2, "Get remote module info for " + str + " failed.", e11);
        }
        synchronized (DynamicModule.class) {
            ThreadLocal<HashMap<String, Boolean>> threadLocal = f13756d;
            if (threadLocal.get() == null || threadLocal.get().get(str) == null || !threadLocal.get().get(str).booleanValue()) {
                Bundle b10 = b(context, str);
                if (b10.getInt(b.f13799j) > 0) {
                    return b10;
                }
            }
            if (threadLocal.get().get(str).booleanValue()) {
                try {
                    return c(context, str);
                } catch (a e12) {
                    Logger.w(f13753a, "Query remote module info in HMS failed.", e12);
                }
            }
            return new Bundle();
        }
    }

    public static int getRemoteVersion(Context context, String str) throws LoadingException {
        try {
            Bundle c10 = c(context, str);
            if (c10 != null && !c10.isEmpty()) {
                return c10.getInt(b.f13799j);
            }
            String str2 = f13753a;
            Logger.w(str2, "Query remote module:" + str + " info failed.");
            throw new LoadingException("Query remote module info failed: null or empty.", (byte) 0);
        } catch (a e10) {
            String str3 = f13753a;
            Logger.w(str3, "Query remote module:" + str + " exception:" + e10);
            return 0;
        }
    }

    public static void install(Context context) {
        if (context == null) {
            Logger.e(f13753a, "The input context is null.");
            return;
        }
        try {
            IDynamicInstall a10 = a(context);
            if (a10 != null) {
                Bundle install = a10.install(ObjectWrapper.wrap(context), new Bundle());
                if (install != null) {
                    c.a().a(install);
                    Logger.i(f13753a, "Install module success.");
                    return;
                }
                throw new LoadingException("Get install info failed: moduleBundle is null.", (byte) 0);
            }
            throw new LoadingException("Get dynamicInstaller failed.", (byte) 0);
        } catch (RemoteException | LoadingException | NullPointerException e10) {
            if (f13759h == 2 || getLocalVersion(context, b.f13793d) <= 0) {
                Logger.w(f13753a, "Install module failed.", e10);
                return;
            }
            String str = f13753a;
            Logger.i(str, "Ready to use local loader-fallback to retry:");
            try {
                Bundle install2 = b(context).install(ObjectWrapper.wrap(context), new Bundle());
                if (install2 != null) {
                    c.a().a(install2);
                    Logger.i(str, "Retry install module with local loader-fallback success.");
                    return;
                }
                throw new LoadingException("Retry: get install info failed: moduleBundle is null.", (byte) 0);
            } catch (RemoteException | LoadingException | NullPointerException e11) {
                Logger.w(f13753a, "Retry failed with local loader-fallback.", e11);
            }
        }
    }

    public static DynamicModule load(Context context, VersionPolicy versionPolicy, String str) throws LoadingException {
        if (context == null || versionPolicy == null || str == null || str.length() == 0 || str.length() > 256) {
            throw new LoadingException("Null param, please check it.", (byte) 0);
        }
        try {
            try {
                Bundle moduleInfo = versionPolicy.getModuleInfo(context, str);
                if (moduleInfo.getInt(b.f13799j) > 0) {
                    try {
                        return a(context, str, moduleInfo);
                    } catch (LoadingException e10) {
                        Logger.w(f13753a, "Failed to load remote module.", e10);
                        if (getLocalVersion(context, str) <= 0) {
                            return null;
                        }
                        Logger.d(f13753a, "Local module version is valid, use local fallback.");
                        return new DynamicModule(context.getApplicationContext());
                    }
                } else if (moduleInfo.getInt(b.f13800k) > 0) {
                    Logger.i(f13753a, "Remote version is invalid, use local context.");
                    return new DynamicModule(context.getApplicationContext());
                } else {
                    throw new LoadingException("Query remote version and local version failed.", (byte) 0);
                }
            } catch (Exception e11) {
                Logger.e(f13753a, "Other exception:".concat(String.valueOf(e11)));
                throw new LoadingException("Load failed.", (byte) 0);
            }
        } catch (LoadingException e12) {
            throw e12;
        }
    }

    public final Context getModuleContext() {
        return this.f13762g;
    }
}
