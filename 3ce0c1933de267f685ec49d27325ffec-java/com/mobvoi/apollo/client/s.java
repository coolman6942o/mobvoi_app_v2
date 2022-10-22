package com.mobvoi.apollo.client;

import android.bluetooth.BluetoothDevice;
import com.amap.api.services.core.AMapException;
import com.huawei.agconnect.exception.AGCServerException;
import com.mobvoi.android.common.utils.l;
import com.mobvoi.apollo.client.d;
import com.mobvoi.apollo.client.s;
import com.mobvoi.apollo.protocol.ble.client.ClientState;
import com.realsil.sdk.dfu.DfuException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: BigArrayTransfer.kt */
/* loaded from: classes2.dex */
public final class s {

    /* renamed from: i  reason: collision with root package name */
    public static final a f15538i = new a(null);

    /* renamed from: j  reason: collision with root package name */
    private static boolean f15539j;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f15540a;

    /* renamed from: b  reason: collision with root package name */
    private ea.b f15541b;

    /* renamed from: c  reason: collision with root package name */
    private ea.c f15542c;

    /* renamed from: d  reason: collision with root package name */
    private int f15543d;

    /* renamed from: e  reason: collision with root package name */
    private int f15544e;

    /* renamed from: f  reason: collision with root package name */
    private int f15545f;

    /* renamed from: g  reason: collision with root package name */
    private int f15546g;

    /* renamed from: h  reason: collision with root package name */
    private final c f15547h;

    /* compiled from: BigArrayTransfer.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final boolean a() {
            return s.f15539j;
        }
    }

    /* compiled from: BigArrayTransfer.kt */
    /* loaded from: classes2.dex */
    public static final class b extends c0 {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f15549d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ int f15550e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i10, int i11) {
            super(Integer.valueOf(i11));
            this.f15549d = i10;
            this.f15550e = i11;
        }

        @Override // com.mobvoi.apollo.client.c0
        public void l(int i10) {
            ea.c cVar;
            Integer j10 = j();
            if (j10 != null && j10.intValue() == 259) {
                ea.b bVar = s.this.f15541b;
                if (bVar != null) {
                    bVar.a(i10);
                }
            } else {
                Integer j11 = j();
                if (!(j11 == null || j11.intValue() != 403 || (cVar = s.this.f15542c) == null)) {
                    cVar.a(i10);
                }
            }
            s.this.o();
        }

        @Override // com.mobvoi.apollo.client.c0
        public void m(byte[] bArr) {
            ea.c cVar;
            if (bArr != null) {
                s sVar = s.this;
                int i10 = this.f15549d;
                int i11 = this.f15550e;
                ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
                byte b10 = order.get();
                if (b10 == 0) {
                    sVar.f15544e = order.getInt();
                    sVar.f15543d = sVar.f15540a.length - sVar.f15544e;
                    if (sVar.f15543d > 0) {
                        sVar.n(i10, i11);
                    } else {
                        sVar.o();
                    }
                } else {
                    Integer j10 = j();
                    if (j10 != null && j10.intValue() == 259) {
                        ea.b bVar = sVar.f15541b;
                        if (bVar != null) {
                            bVar.a(b10);
                        }
                    } else {
                        Integer j11 = j();
                        if (!(j11 == null || j11.intValue() != 403 || (cVar = sVar.f15542c) == null)) {
                            cVar.a(b10);
                        }
                    }
                    sVar.o();
                }
            }
        }
    }

    /* compiled from: BigArrayTransfer.kt */
    /* loaded from: classes2.dex */
    public static final class c implements d.b {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(s this$0, int i10) {
            i.f(this$0, "this$0");
            ea.b bVar = this$0.f15541b;
            if (bVar != null) {
                bVar.b(i10);
            }
            ea.c cVar = this$0.f15542c;
            if (cVar != null) {
                cVar.b(i10);
            }
        }

        @Override // com.mobvoi.apollo.client.d.b
        public void a(BluetoothDevice device, ClientState newState) {
            i.f(device, "device");
            i.f(newState, "newState");
            if (newState == ClientState.DISCONNECTED) {
                s.this.o();
            }
        }

        @Override // com.mobvoi.apollo.client.d.b
        public void b(ka.a packet) {
            i.f(packet, "packet");
            if (packet.a() == 404) {
                s.this.o();
            }
        }

        @Override // com.mobvoi.apollo.client.d.b
        public void c() {
            d.b.a.f(this);
        }

        @Override // com.mobvoi.apollo.client.d.b
        public void d(int i10, int i11) {
            final int b10;
            b10 = so.c.b(((((i11 / 100.0f) * s.this.f15545f) + s.this.f15544e) / s.this.f15540a.length) * 100);
            if (s.this.f15546g != b10) {
                s.this.f15546g = b10;
                l a10 = l.a();
                final s sVar = s.this;
                a10.post(new Runnable() { // from class: com.mobvoi.apollo.client.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        s.c.f(s.this, b10);
                    }
                });
            }
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

    public s(byte[] data) {
        i.f(data, "data");
        this.f15540a = data;
        this.f15543d = data.length;
        c cVar = new c();
        this.f15547h = cVar;
        q.f15504a.j(cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(int i10, int i11) {
        int i12 = this.f15543d;
        byte[] bArr = i12 > 4000 ? new byte[AMapException.CODE_AMAP_SHARE_LICENSE_IS_EXPIRED] : new byte[i12];
        int length = bArr.length;
        this.f15545f = length;
        System.arraycopy(this.f15540a, this.f15544e, bArr, 0, length);
        q.f15504a.K(i10, bArr, new b(i10, i11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        f15539j = false;
        this.f15541b = null;
        this.f15542c = null;
        q.f15504a.J(this.f15547h);
    }

    public final void p(ea.b transferListener) {
        i.f(transferListener, "transferListener");
        if (!f15539j) {
            f15539j = true;
            this.f15541b = transferListener;
            n(DfuException.ERROR_GATT_DISCOVER_SERVICE_FAILED, DfuException.ERROR_LOCK_WAIT_INTERRUPTED);
        }
    }

    public final void q(ea.c transferListener) {
        i.f(transferListener, "transferListener");
        if (!f15539j) {
            f15539j = true;
            this.f15542c = transferListener;
            n(402, AGCServerException.AUTHENTICATION_FAILED);
        }
    }
}
