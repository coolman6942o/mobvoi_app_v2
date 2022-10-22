package com.mobvoi.apollo.client;

import android.app.Notification;
import android.app.Service;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.j;
import androidx.core.app.k;
import androidx.core.app.n;
import com.mobvoi.apollo.client.d;
import com.mobvoi.apollo.protocol.ble.client.ClientState;
import com.mobvoi.wear.common.base.TicwatchModels;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: ApolloClientService.kt */
/* loaded from: classes2.dex */
public final class ApolloClientService extends Service implements d.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f15458a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private static int f15459b;

    /* compiled from: ApolloClientService.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        private final void d(Context context, int i10) {
            Intent intent = new Intent(context, ApolloClientService.class);
            intent.putExtra("apollo_command", i10);
            if (Build.VERSION.SDK_INT < 26) {
                context.startService(intent);
            } else {
                context.startForegroundService(intent);
            }
        }

        public final void a(Context context) {
            i.f(context, "context");
            d(context, 1);
        }

        public final void b(int i10) {
            ApolloClientService.f15459b = i10;
        }

        public final void c(Context context) {
            i.f(context, "context");
            d(context, 0);
        }
    }

    /* compiled from: ApolloClientService.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f15460a;

        static {
            int[] iArr = new int[ClientState.values().length];
            iArr[ClientState.CONNECTING.ordinal()] = 1;
            iArr[ClientState.CONNECTED.ordinal()] = 2;
            iArr[ClientState.DISCONNECTED.ordinal()] = 3;
            f15460a = iArr;
        }
    }

    public ApolloClientService() {
        ClientState clientState = ClientState.DISCONNECTED;
    }

    private final void f(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            j a10 = new j.a("MQTT", 3).b("MQTT").a();
            i.e(a10, "Builder(channelId, NotificationManager.IMPORTANCE_DEFAULT)\n                .setName(channelId).build()");
            n.f(this).e(a10);
            Notification b10 = new k.d(this, "MQTT").u(f15459b).k(TicwatchModels.TICWATCH_GTW_eSIM).j(str).l(-1).b();
            i.e(b10, "Builder(this, channelId)\n                .setSmallIcon(smallIcon)\n                .setContentTitle(\"TicWatch GTW eSIM\")\n                .setContentText(content)\n                .setDefaults(Notification.DEFAULT_ALL)\n                .build()");
            startForeground(3128, b10);
            com.mobvoi.android.common.utils.k.a("AndroidClientCompat", "start Foreground Notification");
        }
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void a(BluetoothDevice device, ClientState newState) {
        i.f(device, "device");
        i.f(newState, "newState");
        int i10 = b.f15460a[newState.ordinal()];
        if (i10 == 1) {
            f("蓝牙连接中");
        } else if (i10 == 2) {
            f("蓝牙已连接");
        } else if (i10 == 3) {
            f("已断开蓝牙");
        }
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void b(ka.a aVar) {
        d.b.a.b(this, aVar);
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void c() {
        d.b.a.f(this);
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void d(int i10, int i11) {
        d.b.a.e(this, i10, i11);
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void i(boolean z10) {
        d.b.a.c(this, z10);
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void k(BluetoothDevice bluetoothDevice, da.a aVar) {
        d.b.a.a(this, bluetoothDevice, aVar);
    }

    @Override // com.mobvoi.apollo.client.d.b
    public void m() {
        d.b.a.d(this);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        q.f15504a.j(this);
        f("蓝牙连接中");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (intent != null && intent.getIntExtra("apollo_command", -1) == 1) {
            stopSelf();
        }
        return super.onStartCommand(intent, i10, i11);
    }
}
