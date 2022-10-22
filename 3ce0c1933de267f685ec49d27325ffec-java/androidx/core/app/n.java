package androidx.core.app;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.support.v4.app.INotificationSideChannel;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* compiled from: NotificationManagerCompat.java */
/* loaded from: classes.dex */
public final class n {

    /* renamed from: d  reason: collision with root package name */
    private static String f2374d;

    /* renamed from: g  reason: collision with root package name */
    private static d f2377g;

    /* renamed from: a  reason: collision with root package name */
    private final Context f2378a;

    /* renamed from: b  reason: collision with root package name */
    private final NotificationManager f2379b;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f2373c = new Object();

    /* renamed from: e  reason: collision with root package name */
    private static Set<String> f2375e = new HashSet();

    /* renamed from: f  reason: collision with root package name */
    private static final Object f2376f = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    public static class a implements e {

        /* renamed from: a  reason: collision with root package name */
        final String f2380a;

        /* renamed from: b  reason: collision with root package name */
        final int f2381b;

        /* renamed from: c  reason: collision with root package name */
        final String f2382c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f2383d = false;

        a(String str, int i10, String str2) {
            this.f2380a = str;
            this.f2381b = i10;
            this.f2382c = str2;
        }

        @Override // androidx.core.app.n.e
        public void a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            if (this.f2383d) {
                iNotificationSideChannel.cancelAll(this.f2380a);
            } else {
                iNotificationSideChannel.cancel(this.f2380a, this.f2381b, this.f2382c);
            }
        }

        public String toString() {
            return "CancelTask[packageName:" + this.f2380a + ", id:" + this.f2381b + ", tag:" + this.f2382c + ", all:" + this.f2383d + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    public static class b implements e {

        /* renamed from: a  reason: collision with root package name */
        final String f2384a;

        /* renamed from: b  reason: collision with root package name */
        final int f2385b;

        /* renamed from: c  reason: collision with root package name */
        final String f2386c;

        /* renamed from: d  reason: collision with root package name */
        final Notification f2387d;

        b(String str, int i10, String str2, Notification notification) {
            this.f2384a = str;
            this.f2385b = i10;
            this.f2386c = str2;
            this.f2387d = notification;
        }

        @Override // androidx.core.app.n.e
        public void a(INotificationSideChannel iNotificationSideChannel) throws RemoteException {
            iNotificationSideChannel.notify(this.f2384a, this.f2385b, this.f2386c, this.f2387d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f2384a + ", id:" + this.f2385b + ", tag:" + this.f2386c + "]";
        }
    }

    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    private static class c {

        /* renamed from: a  reason: collision with root package name */
        final ComponentName f2388a;

        /* renamed from: b  reason: collision with root package name */
        final IBinder f2389b;

        c(ComponentName componentName, IBinder iBinder) {
            this.f2388a = componentName;
            this.f2389b = iBinder;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    public static class d implements Handler.Callback, ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        private final Context f2390a;

        /* renamed from: b  reason: collision with root package name */
        private final HandlerThread f2391b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f2392c;

        /* renamed from: d  reason: collision with root package name */
        private final Map<ComponentName, a> f2393d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private Set<String> f2394e = new HashSet();

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: NotificationManagerCompat.java */
        /* loaded from: classes.dex */
        public static class a {

            /* renamed from: a  reason: collision with root package name */
            final ComponentName f2395a;

            /* renamed from: c  reason: collision with root package name */
            INotificationSideChannel f2397c;

            /* renamed from: b  reason: collision with root package name */
            boolean f2396b = false;

            /* renamed from: d  reason: collision with root package name */
            ArrayDeque<e> f2398d = new ArrayDeque<>();

            /* renamed from: e  reason: collision with root package name */
            int f2399e = 0;

            a(ComponentName componentName) {
                this.f2395a = componentName;
            }
        }

        d(Context context) {
            this.f2390a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f2391b = handlerThread;
            handlerThread.start();
            this.f2392c = new Handler(handlerThread.getLooper(), this);
        }

        private boolean a(a aVar) {
            if (aVar.f2396b) {
                return true;
            }
            boolean bindService = this.f2390a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f2395a), this, 33);
            aVar.f2396b = bindService;
            if (bindService) {
                aVar.f2399e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f2395a);
                this.f2390a.unbindService(this);
            }
            return aVar.f2396b;
        }

        private void b(a aVar) {
            if (aVar.f2396b) {
                this.f2390a.unbindService(this);
                aVar.f2396b = false;
            }
            aVar.f2397c = null;
        }

        private void c(e eVar) {
            j();
            for (a aVar : this.f2393d.values()) {
                aVar.f2398d.add(eVar);
                g(aVar);
            }
        }

        private void d(ComponentName componentName) {
            a aVar = this.f2393d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        private void e(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f2393d.get(componentName);
            if (aVar != null) {
                aVar.f2397c = INotificationSideChannel.Stub.asInterface(iBinder);
                aVar.f2399e = 0;
                g(aVar);
            }
        }

        private void f(ComponentName componentName) {
            a aVar = this.f2393d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        private void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f2395a + ", " + aVar.f2398d.size() + " queued tasks");
            }
            if (!aVar.f2398d.isEmpty()) {
                if (!a(aVar) || aVar.f2397c == null) {
                    i(aVar);
                    return;
                }
                while (true) {
                    e peek = aVar.f2398d.peek();
                    if (peek == null) {
                        break;
                    }
                    try {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Sending task " + peek);
                        }
                        peek.a(aVar.f2397c);
                        aVar.f2398d.remove();
                    } catch (DeadObjectException unused) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Remote service has died: " + aVar.f2395a);
                        }
                    } catch (RemoteException e10) {
                        Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f2395a, e10);
                    }
                }
                if (!aVar.f2398d.isEmpty()) {
                    i(aVar);
                }
            }
        }

        private void i(a aVar) {
            if (!this.f2392c.hasMessages(3, aVar.f2395a)) {
                int i10 = aVar.f2399e + 1;
                aVar.f2399e = i10;
                if (i10 > 6) {
                    Log.w("NotifManCompat", "Giving up on delivering " + aVar.f2398d.size() + " tasks to " + aVar.f2395a + " after " + aVar.f2399e + " retries");
                    aVar.f2398d.clear();
                    return;
                }
                int i11 = (1 << (i10 - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i11 + " ms");
                }
                this.f2392c.sendMessageDelayed(this.f2392c.obtainMessage(3, aVar.f2395a), i11);
            }
        }

        private void j() {
            Set<String> g10 = n.g(this.f2390a);
            if (!g10.equals(this.f2394e)) {
                this.f2394e = g10;
                List<ResolveInfo> queryIntentServices = this.f2390a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
                HashSet<ComponentName> hashSet = new HashSet();
                for (ResolveInfo resolveInfo : queryIntentServices) {
                    if (g10.contains(resolveInfo.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                        ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                        if (resolveInfo.serviceInfo.permission != null) {
                            Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                        } else {
                            hashSet.add(componentName);
                        }
                    }
                }
                for (ComponentName componentName2 : hashSet) {
                    if (!this.f2393d.containsKey(componentName2)) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                        }
                        this.f2393d.put(componentName2, new a(componentName2));
                    }
                }
                Iterator<Map.Entry<ComponentName, a>> it = this.f2393d.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<ComponentName, a> next = it.next();
                    if (!hashSet.contains(next.getKey())) {
                        if (Log.isLoggable("NotifManCompat", 3)) {
                            Log.d("NotifManCompat", "Removing listener record for " + next.getKey());
                        }
                        b(next.getValue());
                        it.remove();
                    }
                }
            }
        }

        public void h(e eVar) {
            this.f2392c.obtainMessage(0, eVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 0) {
                c((e) message.obj);
                return true;
            } else if (i10 == 1) {
                c cVar = (c) message.obj;
                e(cVar.f2388a, cVar.f2389b);
                return true;
            } else if (i10 == 2) {
                f((ComponentName) message.obj);
                return true;
            } else if (i10 != 3) {
                return false;
            } else {
                d((ComponentName) message.obj);
                return true;
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f2392c.obtainMessage(1, new c(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f2392c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NotificationManagerCompat.java */
    /* loaded from: classes.dex */
    public interface e {
        void a(INotificationSideChannel iNotificationSideChannel) throws RemoteException;
    }

    private n(Context context) {
        this.f2378a = context;
        this.f2379b = (NotificationManager) context.getSystemService("notification");
    }

    public static n f(Context context) {
        return new n(context);
    }

    public static Set<String> g(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f2373c) {
            if (string != null) {
                if (!string.equals(f2374d)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String str : split) {
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                        if (unflattenFromString != null) {
                            hashSet.add(unflattenFromString.getPackageName());
                        }
                    }
                    f2375e = hashSet;
                    f2374d = string;
                }
            }
            set = f2375e;
        }
        return set;
    }

    private void j(e eVar) {
        synchronized (f2376f) {
            if (f2377g == null) {
                f2377g = new d(this.f2378a.getApplicationContext());
            }
            f2377g.h(eVar);
        }
    }

    private static boolean k(Notification notification) {
        Bundle b10 = k.b(notification);
        return b10 != null && b10.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            return this.f2379b.areNotificationsEnabled();
        }
        if (i10 < 19) {
            return true;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f2378a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f2378a.getApplicationInfo();
        String packageName = this.f2378a.getApplicationContext().getPackageName();
        int i11 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i11), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void b(int i10) {
        c(null, i10);
    }

    public void c(String str, int i10) {
        this.f2379b.cancel(str, i10);
        if (Build.VERSION.SDK_INT <= 19) {
            j(new a(this.f2378a.getPackageName(), i10, str));
        }
    }

    public void d(NotificationChannel notificationChannel) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.f2379b.createNotificationChannel(notificationChannel);
        }
    }

    public void e(j jVar) {
        d(jVar.a());
    }

    public void h(int i10, Notification notification) {
        i(null, i10, notification);
    }

    public void i(String str, int i10, Notification notification) {
        if (k(notification)) {
            j(new b(this.f2378a.getPackageName(), i10, str, notification));
            this.f2379b.cancel(str, i10);
            return;
        }
        this.f2379b.notify(str, i10, notification);
    }
}
