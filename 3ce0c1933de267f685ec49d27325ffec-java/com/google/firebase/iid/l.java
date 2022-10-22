package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import androidx.collection.f;
import com.huawei.agconnect.exception.AGCServerException;
import java.util.ArrayDeque;
import java.util.Queue;
import y0.a;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: e  reason: collision with root package name */
    private static l f12496e;

    /* renamed from: a  reason: collision with root package name */
    private final f<String, String> f12497a = new f<>();

    /* renamed from: b  reason: collision with root package name */
    private Boolean f12498b = null;

    /* renamed from: c  reason: collision with root package name */
    final Queue<Intent> f12499c = new ArrayDeque();

    /* renamed from: d  reason: collision with root package name */
    private final Queue<Intent> f12500d = new ArrayDeque();

    private l() {
    }

    public static PendingIntent b(Context context, int i10, Intent intent, int i11) {
        Intent intent2 = new Intent(context, FirebaseInstanceIdReceiver.class);
        intent2.setAction("com.google.firebase.MESSAGING_EVENT");
        intent2.putExtra("wrapped_intent", intent);
        return PendingIntent.getBroadcast(context, i10, intent2, 1073741824);
    }

    public static synchronized l c() {
        l lVar;
        synchronized (l.class) {
            if (f12496e == null) {
                f12496e = new l();
            }
            lVar = f12496e;
        }
        return lVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00d4 A[Catch: IllegalStateException -> 0x0109, SecurityException -> 0x012d, TryCatch #4 {IllegalStateException -> 0x0109, SecurityException -> 0x012d, blocks: (B:41:0x00d0, B:43:0x00d4, B:46:0x00dd, B:47:0x00e3, B:49:0x00eb, B:50:0x00f0, B:52:0x00fd), top: B:68:0x00d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00eb A[Catch: IllegalStateException -> 0x0109, SecurityException -> 0x012d, TryCatch #4 {IllegalStateException -> 0x0109, SecurityException -> 0x012d, blocks: (B:41:0x00d0, B:43:0x00d4, B:46:0x00dd, B:47:0x00e3, B:49:0x00eb, B:50:0x00f0, B:52:0x00fd), top: B:68:0x00d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f0 A[Catch: IllegalStateException -> 0x0109, SecurityException -> 0x012d, TryCatch #4 {IllegalStateException -> 0x0109, SecurityException -> 0x012d, blocks: (B:41:0x00d0, B:43:0x00d4, B:46:0x00dd, B:47:0x00e3, B:49:0x00eb, B:50:0x00f0, B:52:0x00fd), top: B:68:0x00d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fd A[Catch: IllegalStateException -> 0x0109, SecurityException -> 0x012d, TRY_LEAVE, TryCatch #4 {IllegalStateException -> 0x0109, SecurityException -> 0x012d, blocks: (B:41:0x00d0, B:43:0x00d4, B:46:0x00dd, B:47:0x00e3, B:49:0x00eb, B:50:0x00f0, B:52:0x00fd), top: B:68:0x00d0 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0107 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int e(Context context, Intent intent) {
        String str;
        ComponentName componentName;
        ServiceInfo serviceInfo;
        String str2;
        synchronized (this.f12497a) {
            str = this.f12497a.get(intent.getAction());
        }
        boolean z10 = false;
        try {
            if (str == null) {
                ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
                if (resolveService == null || (serviceInfo = resolveService.serviceInfo) == null) {
                    Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
                } else if (!context.getPackageName().equals(serviceInfo.packageName) || (str2 = serviceInfo.name) == null) {
                    String str3 = serviceInfo.packageName;
                    String str4 = serviceInfo.name;
                    StringBuilder sb2 = new StringBuilder(String.valueOf(str3).length() + 94 + String.valueOf(str4).length());
                    sb2.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
                    sb2.append(str3);
                    sb2.append("/");
                    sb2.append(str4);
                    Log.e("FirebaseInstanceId", sb2.toString());
                } else {
                    if (str2.startsWith(".")) {
                        String valueOf = String.valueOf(context.getPackageName());
                        if (str2.length() != 0) {
                            str = valueOf.concat(str2);
                            synchronized (this.f12497a) {
                                this.f12497a.put(intent.getAction(), str);
                            }
                        } else {
                            str2 = new String(valueOf);
                        }
                    }
                    str = str2;
                    synchronized (this.f12497a) {
                    }
                }
                if (this.f12498b == null) {
                    if (context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
                        z10 = true;
                    }
                    this.f12498b = Boolean.valueOf(z10);
                }
                if (!this.f12498b.booleanValue()) {
                    componentName = a.d(context, intent);
                } else {
                    componentName = context.startService(intent);
                    Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
                }
                if (componentName == null) {
                    return -1;
                }
                Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
                return 404;
            }
            if (this.f12498b == null) {
            }
            if (!this.f12498b.booleanValue()) {
            }
            if (componentName == null) {
            }
        } catch (IllegalStateException e10) {
            String valueOf2 = String.valueOf(e10);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 45);
            sb3.append("Failed to start service while in background: ");
            sb3.append(valueOf2);
            Log.e("FirebaseInstanceId", sb3.toString());
            return 402;
        } catch (SecurityException e11) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e11);
            return AGCServerException.TOKEN_INVALID;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf3 = String.valueOf(str);
            Log.d("FirebaseInstanceId", valueOf3.length() != 0 ? "Restricting intent to a specific service: ".concat(valueOf3) : new String("Restricting intent to a specific service: "));
        }
        intent.setClassName(context.getPackageName(), str);
    }

    public final int a(Context context, String str, Intent intent) {
        Queue<Intent> queue;
        str.hashCode();
        if (str.equals("com.google.firebase.INSTANCE_ID_EVENT")) {
            queue = this.f12499c;
        } else if (!str.equals("com.google.firebase.MESSAGING_EVENT")) {
            Log.w("FirebaseInstanceId", str.length() != 0 ? "Unknown service action: ".concat(str) : new String("Unknown service action: "));
            return AGCServerException.UNKNOW_EXCEPTION;
        } else {
            queue = this.f12500d;
        }
        queue.offer(intent);
        Intent intent2 = new Intent(str);
        intent2.setPackage(context.getPackageName());
        return e(context, intent2);
    }

    public final Intent d() {
        return this.f12500d.poll();
    }
}
