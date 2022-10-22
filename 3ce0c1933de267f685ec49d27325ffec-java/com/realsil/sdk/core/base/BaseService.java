package com.realsil.sdk.core.base;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.IBinder;
import androidx.annotation.Keep;
import il.b;
/* loaded from: classes2.dex */
public abstract class BaseService extends Service {

    /* renamed from: a  reason: collision with root package name */
    public DisplayManager f22119a;
    @Keep
    public Context mContext;
    @Keep
    public int notificationId = 1230;

    /* renamed from: b  reason: collision with root package name */
    public final DisplayManager.DisplayListener f22120b = new a(this);

    /* loaded from: classes2.dex */
    public class a implements DisplayManager.DisplayListener {
        public a(BaseService baseService) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i10) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i10) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i10) {
        }
    }

    public String a() {
        return "rtk_channel_id";
    }

    public String b() {
        return "rtk_channel_name";
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        b.j("in onBind()");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mContext = this;
        DisplayManager displayManager = (DisplayManager) getSystemService("display");
        this.f22119a = displayManager;
        if (displayManager != null) {
            displayManager.registerDisplayListener(this.f22120b, null);
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel(a(), b(), 0);
            notificationChannel.setLightColor(-16776961);
            notificationChannel.setLockscreenVisibility(0);
            NotificationManager notificationManager2 = (NotificationManager) getSystemService("notification");
            if (notificationManager2 != null) {
                notificationManager2.createNotificationChannel(notificationChannel);
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        DisplayManager displayManager = this.f22119a;
        if (displayManager != null) {
            displayManager.unregisterDisplayListener(this.f22120b);
        }
        stopForeground(true);
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        b.j("in onRebind()");
        super.onRebind(intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        return 1;
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        b.c("Last client unbound from service");
        return true;
    }
}
