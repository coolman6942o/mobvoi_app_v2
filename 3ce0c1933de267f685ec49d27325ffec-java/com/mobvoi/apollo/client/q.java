package com.mobvoi.apollo.client;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.agconnect.exception.AGCServerException;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.apollo.client.d;
import com.mobvoi.apollo.db.ApolloDatabase;
import com.mobvoi.apollo.protocol.ble.client.ClientState;
import com.mobvoi.apollo.protocol.model.Contact;
import com.mobvoi.apollo.protocol.model.NotificationData;
import com.mobvoi.apollo.protocol.model.PhoneInfo;
import com.mobvoi.apollo.protocol.model.RoomInfo;
import com.mobvoi.apollo.protocol.model.SkipGsonSerialize;
import com.mobvoi.apollo.protocol.model.Sms;
import com.mobvoi.apollo.protocol.model.WeatherInfo;
import com.realsil.sdk.dfu.DfuException;
import ga.a;
import io.m;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Lambda;
import qo.l;
import rx.c;
import rx.i;
/* compiled from: ApolloHandler.kt */
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes2.dex */
public final class q {

    /* renamed from: b  reason: collision with root package name */
    private static com.mobvoi.apollo.client.d f15505b;

    /* renamed from: c  reason: collision with root package name */
    private static z f15506c;

    /* renamed from: d  reason: collision with root package name */
    private static Context f15507d;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f15509f;

    /* renamed from: g  reason: collision with root package name */
    private static ApolloDatabase f15510g;

    /* renamed from: h  reason: collision with root package name */
    private static final io.d f15511h;

    /* renamed from: j  reason: collision with root package name */
    private static final a f15513j;

    /* renamed from: k  reason: collision with root package name */
    private static final b0 f15514k;

    /* renamed from: a  reason: collision with root package name */
    public static final q f15504a = new q();

    /* renamed from: e  reason: collision with root package name */
    private static final Handler f15508e = new Handler(Looper.getMainLooper());

    /* renamed from: i  reason: collision with root package name */
    private static final ConcurrentHashMap<Integer, c0> f15512i = new ConcurrentHashMap<>();

    /* renamed from: l  reason: collision with root package name */
    private static final e f15515l = new e();

    /* compiled from: ApolloHandler.kt */
    /* loaded from: classes2.dex */
    public static final class a implements d.b {
        a() {
        }

        @Override // com.mobvoi.apollo.client.d.b
        public void a(BluetoothDevice device, ClientState newState) {
            kotlin.jvm.internal.i.f(device, "device");
            kotlin.jvm.internal.i.f(newState, "newState");
            if (newState == ClientState.DISCONNECTED) {
                q qVar = q.f15504a;
                q.f15509f = false;
                qVar.p();
                if (!q.f15512i.isEmpty()) {
                    q.f15508e.removeCallbacksAndMessages(null);
                    for (Map.Entry entry : q.f15512i.entrySet()) {
                        ((c0) entry.getValue()).l(-1);
                    }
                    q.f15512i.clear();
                }
            } else if (newState == ClientState.CONNECTED) {
                q qVar2 = q.f15504a;
                q.f15509f = true;
            }
        }

        @Override // com.mobvoi.apollo.client.d.b
        public void b(ka.a packet) {
            c0 c0Var;
            kotlin.jvm.internal.i.f(packet, "packet");
            if (q.f15508e.hasMessages(packet.a())) {
                q.f15508e.removeMessages(packet.a());
            }
            if (q.f15512i.containsKey(Integer.valueOf(packet.a())) && (c0Var = (c0) q.f15512i.remove(Integer.valueOf(packet.a()))) != null) {
                c0Var.m(packet.c());
            }
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
    }

    /* compiled from: ApolloHandler.kt */
    /* loaded from: classes2.dex */
    public static final class b extends c0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BluetoothDevice f15516c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(BluetoothDevice bluetoothDevice) {
            super(null, 1, null);
            this.f15516c = bluetoothDevice;
        }

        @Override // com.mobvoi.apollo.client.c0
        public void m(byte[] bArr) {
            byte b10 = 0;
            if (bArr != null) {
                if (!(bArr.length == 0)) {
                    b10 = bArr[0];
                }
            }
            if (b10 == 0) {
                z zVar = q.f15506c;
                if (zVar != null) {
                    zVar.j(this.f15516c);
                } else {
                    kotlin.jvm.internal.i.u("classicBluetoothBond");
                    throw null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ApolloHandler.kt */
    /* loaded from: classes2.dex */
    public static final class c extends Lambda implements l<List<? extends Contact>, m> {
        final /* synthetic */ rx.i<? super List<Contact>> $it;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(rx.i<? super List<Contact>> iVar) {
            super(1);
            this.$it = iVar;
        }

        public final void a(List<Contact> contactList) {
            kotlin.jvm.internal.i.f(contactList, "contactList");
            this.$it.onNext(contactList);
            this.$it.onCompleted();
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ m invoke(List<? extends Contact> list) {
            a(list);
            return m.f28349a;
        }
    }

    /* compiled from: ApolloHandler.kt */
    /* loaded from: classes2.dex */
    public static final class d extends c0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l<Boolean, m> f15517c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(l<? super Boolean, m> lVar) {
            super(515);
            this.f15517c = lVar;
        }

        @Override // com.mobvoi.apollo.client.c0
        public void m(byte[] bArr) {
            boolean z10 = false;
            if (bArr != null) {
                if ((!(bArr.length == 0)) && bArr[0] == 0) {
                    z10 = true;
                }
            }
            this.f15517c.invoke(Boolean.valueOf(z10));
        }
    }

    /* compiled from: ApolloHandler.kt */
    /* loaded from: classes2.dex */
    public static final class e extends BroadcastReceiver {
        e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            kotlin.jvm.internal.i.f(context, "context");
            kotlin.jvm.internal.i.f(intent, "intent");
            String action = intent.getAction();
            if (kotlin.jvm.internal.i.b(action, "com.mobvoi.baiding.ACTION.APOLLO_ESIM_GET_EID_REQ")) {
                r rVar = new r(context);
                if (rVar.g().length() == 0) {
                    q.f15504a.F();
                    return;
                }
                String g10 = rVar.g();
                String d10 = rVar.d();
                b1.a b10 = b1.a.b(context);
                Intent intent2 = new Intent("com.mobvoi.baiding.ACTION.APOLLO_ESIM_GET_EID_RESP");
                intent2.putExtra("apollo_esim_extra_imei", g10);
                intent2.putExtra("apollo_esim_extra_eid", d10);
                m mVar = m.f28349a;
                b10.d(intent2);
                k.a("ApolloHandler", "Apollo watch: APOLLO_ESIM_ACTION_GET_EID_RESPONSE has been sent. imei:" + g10 + " eid:" + d10);
            } else if (kotlin.jvm.internal.i.b(action, "com.mobvoi.baiding.ACTION.APOLLO_ESIM_DOWNLOAD_PROFILE_REQ")) {
                String stringExtra = intent.getStringExtra("apollo_esim_extra_activation_code");
                k.a("ApolloHandler", "The activationCode received from broadcast in RemoteService is " + ((Object) stringExtra) + '.');
                if (stringExtra != null) {
                    q.f15504a.w(stringExtra);
                }
            }
        }
    }

    /* compiled from: ApolloHandler.kt */
    /* loaded from: classes2.dex */
    static final class f extends Lambda implements qo.a<com.google.gson.e> {
        public static final f INSTANCE = new f();

        /* compiled from: ApolloHandler.kt */
        /* loaded from: classes2.dex */
        public static final class a implements com.google.gson.b {
            a() {
            }

            @Override // com.google.gson.b
            public boolean a(com.google.gson.c cVar) {
                return (cVar == null ? null : (SkipGsonSerialize) cVar.a(SkipGsonSerialize.class)) != null;
            }

            @Override // com.google.gson.b
            public boolean b(Class<?> cls) {
                return false;
            }
        }

        f() {
            super(0);
        }

        /* renamed from: a */
        public final com.google.gson.e invoke() {
            return new com.google.gson.f().d(new a()).b();
        }
    }

    /* compiled from: ApolloHandler.kt */
    /* loaded from: classes2.dex */
    public static final class g extends c0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l<Boolean, m> f15518c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        g(l<? super Boolean, m> lVar) {
            super(Integer.valueOf((int) AGCServerException.TOKEN_INVALID));
            this.f15518c = lVar;
        }

        @Override // com.mobvoi.apollo.client.c0
        public void m(byte[] bArr) {
            boolean z10 = false;
            if (bArr != null) {
                if ((!(bArr.length == 0)) && bArr[0] == 0) {
                    z10 = true;
                }
            }
            this.f15518c.invoke(Boolean.valueOf(z10));
        }
    }

    /* compiled from: ApolloHandler.kt */
    /* loaded from: classes2.dex */
    public static final class h extends c0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l<List<Contact>, m> f15519c;

        /* compiled from: ApolloHandler.kt */
        /* loaded from: classes2.dex */
        public static final class a extends com.google.gson.reflect.a<List<? extends Contact>> {
            a() {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        h(l<? super List<Contact>, m> lVar) {
            super(null, 1, null);
            this.f15519c = lVar;
        }

        @Override // com.mobvoi.apollo.client.c0
        public void m(byte[] bArr) {
            List<Contact> list;
            if (bArr == null) {
                list = null;
            } else {
                list = (List) q.f15504a.y().k(new String(bArr, kotlin.text.d.f30092a), new a().getType());
            }
            if (list == null) {
                list = kotlin.collections.m.g();
            }
            this.f15519c.invoke(list);
        }
    }

    /* compiled from: ApolloHandler.kt */
    /* loaded from: classes2.dex */
    public static final class i extends c0 {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l<Boolean, m> f15520c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        i(l<? super Boolean, m> lVar) {
            super(515);
            this.f15520c = lVar;
        }

        @Override // com.mobvoi.apollo.client.c0
        public void m(byte[] bArr) {
            boolean z10 = false;
            if (bArr != null) {
                if ((!(bArr.length == 0)) && bArr[0] == 0) {
                    z10 = true;
                }
            }
            this.f15520c.invoke(Boolean.valueOf(z10));
        }
    }

    static {
        io.d a10;
        a10 = io.f.a(f.INSTANCE);
        f15511h = a10;
        a aVar = new a();
        f15513j = aVar;
        b0 b0Var = new b0();
        b0Var.e(aVar);
        f15514k = b0Var;
    }

    private q() {
    }

    private final boolean A(int i10) {
        return (!s.f15538i.a() || i10 == 258 || i10 == 402) ? false : true;
    }

    public static final void I() {
        BluetoothDevice t10 = f15504a.t();
        if (t10 != null) {
            oa.a aVar = oa.a.f31484a;
            Context context = f15507d;
            if (context != null) {
                String address = t10.getAddress();
                kotlin.jvm.internal.i.e(address, "device.address");
                if (aVar.f(context, address)) {
                    z zVar = f15506c;
                    if (zVar != null) {
                        zVar.m(t10);
                    } else {
                        kotlin.jvm.internal.i.u("classicBluetoothBond");
                        throw null;
                    }
                }
            } else {
                kotlin.jvm.internal.i.u("context");
                throw null;
            }
        }
    }

    public static /* synthetic */ void L(q qVar, int i10, byte[] bArr, c0 c0Var, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            bArr = null;
        }
        if ((i11 & 4) != 0) {
            c0Var = null;
        }
        qVar.K(i10, bArr, c0Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(int i10) {
        c0 remove;
        ConcurrentHashMap<Integer, c0> concurrentHashMap = f15512i;
        if (concurrentHashMap.containsKey(Integer.valueOf(i10)) && (remove = concurrentHashMap.remove(Integer.valueOf(i10))) != null) {
            remove.l(-3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(ga.a contactsDao, rx.i iVar) {
        kotlin.jvm.internal.i.f(contactsDao, "$contactsDao");
        if (contactsDao.size() == 0) {
            f15504a.G(new c(iVar));
        } else {
            iVar.onCompleted();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(ga.a contactsDao, List it) {
        kotlin.jvm.internal.i.f(contactsDao, "$contactsDao");
        kotlin.jvm.internal.i.e(it, "it");
        if (!it.isEmpty()) {
            contactsDao.c(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final m q() {
        f15504a.x().F().clear();
        return m.f28349a;
    }

    public static final void v() {
        com.mobvoi.apollo.client.d dVar = f15505b;
        if (dVar != null) {
            dVar.f();
        } else {
            kotlin.jvm.internal.i.u("bleClient");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.google.gson.e y() {
        Object value = f15511h.getValue();
        kotlin.jvm.internal.i.e(value, "<get-gson>(...)");
        return (com.google.gson.e) value;
    }

    public final boolean B() {
        return f15509f;
    }

    public final void C(int i10, ea.a onDialPrepareChange) {
        kotlin.jvm.internal.i.f(onDialPrepareChange, "onDialPrepareChange");
        K(256, oa.c.a(i10), onDialPrepareChange);
    }

    public final void D(RoomInfo roomInfo, l<? super Boolean, m> callback) {
        kotlin.jvm.internal.i.f(roomInfo, "roomInfo");
        kotlin.jvm.internal.i.f(callback, "callback");
        String s10 = y().s(roomInfo);
        kotlin.jvm.internal.i.e(s10, "gson.toJson(roomInfo)");
        byte[] bytes = s10.getBytes(kotlin.text.d.f30092a);
        kotlin.jvm.internal.i.e(bytes, "(this as java.lang.String).getBytes(charset)");
        K(AGCServerException.AUTHENTICATION_INVALID, bytes, new g(callback));
    }

    public final void E() {
        L(this, 304, null, null, 6, null);
    }

    public final void F() {
        L(this, 336, null, null, 6, null);
    }

    public final void G(l<? super List<Contact>, m> callback) {
        kotlin.jvm.internal.i.f(callback, "callback");
        L(this, 512, null, new h(callback), 2, null);
    }

    public final void H() {
        L(this, 5, null, null, 6, null);
    }

    public final void J(d.b listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        f15514k.f(listener);
    }

    public final void K(int i10, byte[] bArr, c0 c0Var) {
        if (A(i10)) {
            if (c0Var != null) {
                c0Var.l(-2);
            }
        } else if (f15509f) {
            if (c0Var != null) {
                ConcurrentHashMap<Integer, c0> concurrentHashMap = f15512i;
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Integer, c0> entry : concurrentHashMap.entrySet()) {
                    if (kotlin.jvm.internal.i.b(entry.getValue(), c0Var)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                    f15512i.remove(entry2.getKey());
                }
                Integer j10 = c0Var.j();
                final int intValue = j10 == null ? i10 : j10.intValue();
                f15512i.put(Integer.valueOf(intValue), c0Var);
                Handler handler = f15508e;
                Message obtain = Message.obtain(handler, new Runnable() { // from class: com.mobvoi.apollo.client.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        q.M(intValue);
                    }
                });
                obtain.what = intValue;
                handler.sendMessageDelayed(obtain, c0Var.k());
            }
            com.mobvoi.apollo.client.d dVar = f15505b;
            if (dVar != null) {
                la.a aVar = la.a.f30445a;
                dVar.i(aVar.a(), aVar.b(), ka.c.f29837a.a(i10, bArr));
                return;
            }
            kotlin.jvm.internal.i.u("bleClient");
            throw null;
        } else if (c0Var != null) {
            c0Var.l(-1);
        }
    }

    public final void N(String dataSource) {
        kotlin.jvm.internal.i.f(dataSource, "dataSource");
        byte[] bytes = dataSource.getBytes(kotlin.text.d.f30092a);
        kotlin.jvm.internal.i.e(bytes, "(this as java.lang.String).getBytes(charset)");
        L(this, 353, bytes, null, 4, null);
    }

    public final void O(NotificationData data) {
        kotlin.jvm.internal.i.f(data, "data");
        String notification = y().s(data);
        if (f15509f) {
            kotlin.jvm.internal.i.e(notification, "notification");
            byte[] bytes = notification.getBytes(kotlin.text.d.f30092a);
            kotlin.jvm.internal.i.e(bytes, "(this as java.lang.String).getBytes(charset)");
            L(this, DfuException.ERROR_READ_PATCH_INFO_ERROR, bytes, null, 4, null);
        }
    }

    public final void P(byte[] data, ea.c otaTransferListener) {
        kotlin.jvm.internal.i.f(data, "data");
        kotlin.jvm.internal.i.f(otaTransferListener, "otaTransferListener");
        new s(data).q(otaTransferListener);
    }

    public final void Q(Sms sms) {
        kotlin.jvm.internal.i.f(sms, "sms");
        String s10 = y().s(sms);
        kotlin.jvm.internal.i.e(s10, "gson.toJson(sms)");
        byte[] bytes = s10.getBytes(kotlin.text.d.f30092a);
        kotlin.jvm.internal.i.e(bytes, "(this as java.lang.String).getBytes(charset)");
        L(this, 385, bytes, null, 4, null);
    }

    public final void R() {
        com.mobvoi.apollo.client.d dVar = f15505b;
        if (dVar != null) {
            dVar.A();
        } else {
            kotlin.jvm.internal.i.u("bleClient");
            throw null;
        }
    }

    public final void S() {
        com.mobvoi.apollo.client.d dVar = f15505b;
        if (dVar != null) {
            dVar.B();
        } else {
            kotlin.jvm.internal.i.u("bleClient");
            throw null;
        }
    }

    public final void T(List<Contact> contacts, l<? super Boolean, m> callback) {
        kotlin.jvm.internal.i.f(contacts, "contacts");
        kotlin.jvm.internal.i.f(callback, "callback");
        String s10 = y().s(contacts);
        kotlin.jvm.internal.i.e(s10, "gson.toJson(contacts)");
        byte[] bytes = s10.getBytes(kotlin.text.d.f30092a);
        kotlin.jvm.internal.i.e(bytes, "(this as java.lang.String).getBytes(charset)");
        K(513, bytes, new i(callback));
    }

    public final void U(double d10, double d11) {
        ByteBuffer order = ByteBuffer.allocate(18).order(ByteOrder.LITTLE_ENDIAN);
        order.put((byte) 0).putDouble(d10).put((byte) 1).putDouble(d11);
        L(this, 17, order.array(), null, 4, null);
    }

    public final void V(PhoneInfo data) {
        kotlin.jvm.internal.i.f(data, "data");
        String s10 = y().s(data);
        kotlin.jvm.internal.i.e(s10, "gson.toJson(data)");
        byte[] bytes = s10.getBytes(kotlin.text.d.f30092a);
        kotlin.jvm.internal.i.e(bytes, "(this as java.lang.String).getBytes(charset)");
        L(this, 352, bytes, null, 4, null);
    }

    public final void W(List<WeatherInfo> weatherList) {
        kotlin.jvm.internal.i.f(weatherList, "weatherList");
        String s10 = y().s(weatherList);
        kotlin.jvm.internal.i.e(s10, "gson.toJson(weatherList)");
        byte[] bytes = s10.getBytes(kotlin.text.d.f30092a);
        kotlin.jvm.internal.i.e(bytes, "(this as java.lang.String).getBytes(charset)");
        L(this, 384, bytes, null, 4, null);
    }

    public final void j(d.b listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        f15514k.e(listener);
    }

    public final void k() {
        BluetoothDevice t10 = t();
        if (t10 != null) {
            z zVar = f15506c;
            if (zVar == null) {
                kotlin.jvm.internal.i.u("classicBluetoothBond");
                throw null;
            } else if (!zVar.l(t10)) {
                L(f15504a, 6, null, new b(t10), 2, null);
            }
        }
    }

    public final void l(byte[] data, ea.b onDialTransferListener) {
        kotlin.jvm.internal.i.f(data, "data");
        kotlin.jvm.internal.i.f(onDialTransferListener, "onDialTransferListener");
        new s(data).p(onDialTransferListener);
    }

    public final void m() {
        final ga.a F = x().F();
        rx.c.i0(new c.a() { // from class: com.mobvoi.apollo.client.o
            @Override // yp.b
            public final void call(Object obj) {
                q.n(a.this, (i) obj);
            }
        }).Z(cq.a.c()).X(new yp.b() { // from class: com.mobvoi.apollo.client.p
            @Override // yp.b
            public final void call(Object obj) {
                q.o(a.this, (List) obj);
            }
        });
    }

    public final void p() {
        rx.c.x(n.f15501a).Z(cq.a.c()).T();
    }

    public final void r() {
        BluetoothDevice t10 = t();
        if (t10 != null) {
            z zVar = f15506c;
            if (zVar != null) {
                zVar.j(t10);
            } else {
                kotlin.jvm.internal.i.u("classicBluetoothBond");
                throw null;
            }
        }
    }

    public final void s(BluetoothDevice bluetoothDevice) {
        com.mobvoi.apollo.client.d dVar = f15505b;
        if (dVar != null) {
            dVar.t(bluetoothDevice);
        } else {
            kotlin.jvm.internal.i.u("bleClient");
            throw null;
        }
    }

    public final BluetoothDevice t() {
        com.mobvoi.apollo.client.d dVar = f15505b;
        if (dVar != null) {
            return dVar.v();
        }
        kotlin.jvm.internal.i.u("bleClient");
        throw null;
    }

    public final void u(String phone, l<? super Boolean, m> callback) {
        kotlin.jvm.internal.i.f(phone, "phone");
        kotlin.jvm.internal.i.f(callback, "callback");
        byte[] bytes = phone.getBytes(kotlin.text.d.f30092a);
        kotlin.jvm.internal.i.e(bytes, "(this as java.lang.String).getBytes(charset)");
        K(514, bytes, new d(callback));
    }

    public final void w(String activationCode) {
        kotlin.jvm.internal.i.f(activationCode, "activationCode");
        byte[] bytes = activationCode.getBytes(kotlin.text.d.f30092a);
        kotlin.jvm.internal.i.e(bytes, "(this as java.lang.String).getBytes(charset)");
        L(this, 337, bytes, null, 4, null);
    }

    public final ApolloDatabase x() {
        ApolloDatabase apolloDatabase = f15510g;
        if (apolloDatabase != null) {
            return apolloDatabase;
        }
        kotlin.jvm.internal.i.u("apolloDatabase");
        throw null;
    }

    public final void z(Context context) {
        kotlin.jvm.internal.i.f(context, "context");
        Context applicationContext = context.getApplicationContext();
        kotlin.jvm.internal.i.e(applicationContext, "context.applicationContext");
        f15507d = applicationContext;
        f15505b = new com.mobvoi.apollo.client.d(context, f15514k);
        f15506c = new z(context);
        ApolloDatabase.a aVar = ApolloDatabase.f15562n;
        Context context2 = f15507d;
        if (context2 != null) {
            f15510g = aVar.a(context2);
            b1.a b10 = b1.a.b(context);
            e eVar = f15515l;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.mobvoi.baiding.ACTION.APOLLO_ESIM_GET_EID_REQ");
            intentFilter.addAction("com.mobvoi.baiding.ACTION.APOLLO_ESIM_DOWNLOAD_PROFILE_REQ");
            m mVar = m.f28349a;
            b10.c(eVar, intentFilter);
            return;
        }
        kotlin.jvm.internal.i.u("context");
        throw null;
    }
}
