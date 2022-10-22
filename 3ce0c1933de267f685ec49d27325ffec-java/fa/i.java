package fa;

import com.google.gson.e;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.l;
import com.mobvoi.apollo.client.r;
import com.mobvoi.apollo.protocol.model.EsimInfo;
import ja.g;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Objects;
import ka.c;
import kotlin.text.d;
import la.a;
import rx.c;
import rx.i;
/* compiled from: PairHelper.kt */
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    private final g f26383a;

    /* renamed from: b  reason: collision with root package name */
    private final r f26384b;

    /* renamed from: c  reason: collision with root package name */
    private String f26385c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f26386d = new Runnable() { // from class: fa.d
        @Override // java.lang.Runnable
        public final void run() {
            i.m(i.this);
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f26387e = new Runnable() { // from class: fa.e
        @Override // java.lang.Runnable
        public final void run() {
            i.n(i.this);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private rx.i<? super Boolean> f26388f;

    /* renamed from: g  reason: collision with root package name */
    private rx.i<? super Boolean> f26389g;

    public i(g bleGatt, r prefs) {
        kotlin.jvm.internal.i.f(bleGatt, "bleGatt");
        kotlin.jvm.internal.i.f(prefs, "prefs");
        this.f26383a = bleGatt;
        this.f26384b = prefs;
    }

    private final void g(boolean z10, String str) {
        Charset charset = d.f30092a;
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str.getBytes(charset);
        kotlin.jvm.internal.i.e(bytes, "(this as java.lang.String).getBytes(charset)");
        byte[] array = ByteBuffer.allocate(bytes.length + 2).order(ByteOrder.LITTLE_ENDIAN).put(!z10 ? 1 : 0 ? (byte) 1 : (byte) 0).put((byte) bytes.length).put(bytes).array();
        g gVar = this.f26383a;
        a aVar = a.f30445a;
        gVar.i(aVar.a(), aVar.b(), c.f29837a.a(32, array));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(i this$0, boolean z10, rx.i iVar) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.f26388f = iVar;
        l.a().postDelayed(this$0.f26386d, 2000L);
        if (z10) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            this$0.f26385c = valueOf;
            if (valueOf != null) {
                this$0.g(true, valueOf);
            } else {
                kotlin.jvm.internal.i.u("tempPairKey");
                throw null;
            }
        } else {
            String j10 = this$0.f26384b.j();
            this$0.f26385c = j10;
            if (j10 != null) {
                this$0.g(false, j10);
            } else {
                kotlin.jvm.internal.i.u("tempPairKey");
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final rx.c i(boolean z10, i this$0, Boolean it) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.e(it, "it");
        if (!it.booleanValue() || !z10) {
            return rx.c.A(it);
        }
        return this$0.j();
    }

    private final rx.c<Boolean> j() {
        rx.c<Boolean> i02 = rx.c.i0(new c.a() { // from class: fa.f
            @Override // yp.b
            public final void call(Object obj) {
                i.k(i.this, (i) obj);
            }
        });
        kotlin.jvm.internal.i.e(i02, "unsafeCreate {\n            eidSubscriber = it\n            MainHandler.getInstance().postDelayed(queryEidTimeoutTask, 5000)\n            bleGatt.sendData(Constants.GATT_SERVICE,\n                Constants.READ_DATA_CHARACTERISTIC,\n                PacketComposer.createPacket(Constants.COMMAND_LPA_QUERY_EID, null))\n        }");
        return i02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(i this$0, rx.i iVar) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.f26389g = iVar;
        l.a().postDelayed(this$0.f26387e, 5000L);
        g gVar = this$0.f26383a;
        a aVar = a.f30445a;
        gVar.i(aVar.a(), aVar.b(), ka.c.f29837a.a(336, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(i this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        rx.i<? super Boolean> iVar = this$0.f26388f;
        if (iVar != null) {
            if (iVar != null) {
                iVar.onNext(Boolean.TRUE);
            }
            rx.i<? super Boolean> iVar2 = this$0.f26388f;
            if (iVar2 != null) {
                iVar2.onCompleted();
            }
            this$0.f26388f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(i this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        rx.i<? super Boolean> iVar = this$0.f26389g;
        if (iVar != null) {
            if (iVar != null) {
                iVar.onNext(Boolean.FALSE);
            }
            rx.i<? super Boolean> iVar2 = this$0.f26389g;
            if (iVar2 != null) {
                iVar2.onCompleted();
            }
            this$0.f26389g = null;
        }
    }

    public final rx.c<Boolean> f() {
        final boolean n10 = this.f26384b.n();
        rx.c<Boolean> v10 = rx.c.i0(new c.a() { // from class: fa.g
            @Override // yp.b
            public final void call(Object obj) {
                i.h(i.this, n10, (i) obj);
            }
        }).v(new yp.g() { // from class: fa.h
            @Override // yp.g
            public final Object call(Object obj) {
                rx.c i10;
                i10 = i.i(n10, this, (Boolean) obj);
                return i10;
            }
        });
        kotlin.jvm.internal.i.e(v10, "unsafeCreate<Boolean> {\n            pairSubscriber = it\n            MainHandler.getInstance().postDelayed(pairTimeoutTask, 2000)\n            if (isNewPair) {\n                tempPairKey = System.currentTimeMillis().toString()\n                checkPair(true, tempPairKey)\n            } else {\n                tempPairKey = prefs.pairKey\n                checkPair(false, tempPairKey)\n            }\n        }.flatMap {\n            if (it && isNewPair) {\n                getDeviceId()\n            } else {\n                Observable.just(it)\n            }\n        }");
        return v10;
    }

    public final void l(ka.a packet) {
        EsimInfo esimInfo;
        kotlin.jvm.internal.i.f(packet, "packet");
        if (this.f26388f != null || this.f26389g != null) {
            int a10 = packet.a();
            boolean z10 = true;
            boolean z11 = false;
            if (a10 == 33) {
                l.a().removeCallbacks(this.f26386d);
                byte[] c10 = packet.c();
                if (c10 == null || c10[0] >= 1) {
                    z10 = false;
                }
                if (z10) {
                    this.f26384b.w(false);
                    r rVar = this.f26384b;
                    String str = this.f26385c;
                    if (str != null) {
                        rVar.y(str);
                        rx.i<? super Boolean> iVar = this.f26388f;
                        if (iVar != null) {
                            iVar.onNext(Boolean.TRUE);
                        }
                    } else {
                        kotlin.jvm.internal.i.u("tempPairKey");
                        throw null;
                    }
                } else {
                    rx.i<? super Boolean> iVar2 = this.f26388f;
                    if (iVar2 != null) {
                        iVar2.onNext(Boolean.FALSE);
                    }
                }
                rx.i<? super Boolean> iVar3 = this.f26388f;
                if (iVar3 != null) {
                    iVar3.onCompleted();
                }
                this.f26388f = null;
            } else if (a10 == 338) {
                l.a().removeCallbacks(this.f26387e);
                byte[] c11 = packet.c();
                if (c11 != null) {
                    try {
                        esimInfo = (EsimInfo) new e().j(new String(c11, d.f30092a), EsimInfo.class);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        esimInfo = null;
                    }
                    if (esimInfo != null) {
                        this.f26384b.v(esimInfo.getImei());
                        r rVar2 = this.f26384b;
                        String eid = esimInfo.getEid();
                        if (eid == null) {
                            eid = "";
                        }
                        rVar2.u(eid);
                    } else {
                        z10 = false;
                    }
                    z11 = z10;
                }
                rx.i<? super Boolean> iVar4 = this.f26389g;
                if (iVar4 != null) {
                    iVar4.onNext(Boolean.valueOf(z11));
                }
                rx.i<? super Boolean> iVar5 = this.f26389g;
                if (iVar5 != null) {
                    iVar5.onCompleted();
                }
                this.f26389g = null;
                if (!z11) {
                    k.q("PairHelper", "无法获取IMEI、eid, 连接失败");
                }
            }
        }
    }
}
