package com.mobvoi.mcuwatch.engine;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.google.gson.e;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.l;
import com.mobvoi.apollo.client.ApolloClientService;
import com.mobvoi.apollo.client.d;
import com.mobvoi.apollo.client.q;
import com.mobvoi.apollo.client.r;
import com.mobvoi.apollo.protocol.ble.client.ClientState;
import com.mobvoi.apollo.protocol.model.DataSession;
import com.mobvoi.apollo.protocol.model.DataSet;
import com.mobvoi.apollo.protocol.model.EsimInfo;
import com.mobvoi.apollo.protocol.model.FitnessRecord;
import com.mobvoi.apollo.protocol.model.PhoneInfo;
import com.mobvoi.apollo.protocol.model.Sms;
import com.mobvoi.health.common.data.pojo.ActivityType;
import com.mobvoi.health.common.data.pojo.DataType;
import com.mobvoi.mcuwatch.engine.b;
import com.mobvoi.mcuwatch.pair.service.RingingService;
import com.mobvoi.mcuwatch.ui.contacts.ContactsActivity;
import com.mobvoi.mcuwatch.ui.customview.x;
import com.mobvoi.mcuwatch.ui.sms.SmsActivity;
import com.tendcloud.tenddata.ab;
import io.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.collections.n;
import kotlin.jvm.internal.i;
import yg.f;
/* compiled from: ApolloBleEngine.kt */
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f19145b;

    /* renamed from: c  reason: collision with root package name */
    private static Context f19146c;

    /* renamed from: d  reason: collision with root package name */
    private static a f19147d;

    /* renamed from: a  reason: collision with root package name */
    public static final b f19144a = new b();

    /* renamed from: e  reason: collision with root package name */
    private static final com.mobvoi.apollo.client.fitness.c f19148e = new com.mobvoi.apollo.client.fitness.c();

    /* renamed from: f  reason: collision with root package name */
    private static final c f19149f = new c();

    /* renamed from: g  reason: collision with root package name */
    private static final C0223b f19150g = new C0223b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ApolloBleEngine.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private int f19151a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Looper looper) {
            super(looper);
            i.f(looper, "looper");
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            i.f(msg, "msg");
            int i10 = msg.what;
            if (i10 != 1) {
                if (i10 == 2) {
                    b bVar = b.f19144a;
                    Object obj = msg.obj;
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.collections.List<com.mobvoi.apollo.protocol.model.DataSet>");
                    bVar.o((List) obj);
                } else if (i10 == 3) {
                    b bVar2 = b.f19144a;
                    Object obj2 = msg.obj;
                    Objects.requireNonNull(obj2, "null cannot be cast to non-null type com.mobvoi.apollo.protocol.model.FitnessRecord");
                    bVar2.q((FitnessRecord) obj2);
                } else if (i10 == 4) {
                    b bVar3 = b.f19144a;
                    Object obj3 = msg.obj;
                    Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.collections.List<com.mobvoi.apollo.protocol.model.DataSession>");
                    bVar3.p((List) obj3);
                } else if (i10 == 5) {
                    ig.b.J().A();
                }
            } else if (this.f19151a > 3) {
                this.f19151a = 0;
                k.a("ApolloBleEngine", "dataSource 同步失败");
            } else {
                b.f19144a.s();
                this.f19151a++;
            }
        }
    }

    /* compiled from: ApolloBleEngine.kt */
    /* renamed from: com.mobvoi.mcuwatch.engine.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0223b implements com.mobvoi.apollo.client.fitness.b {
        C0223b() {
        }

        @Override // com.mobvoi.apollo.client.fitness.b
        public void a(FitnessRecord record) {
            i.f(record, "record");
            if (k.j()) {
                k.h("ApolloBleEngine", i.n("GTW FitnessRecord: ", new e().s(record)));
            }
            a aVar = b.f19147d;
            if (aVar != null) {
                aVar.obtainMessage(3, record).sendToTarget();
            } else {
                i.u("workHandler");
                throw null;
            }
        }

        @Override // com.mobvoi.apollo.client.fitness.b
        public boolean b() {
            return true;
        }

        @Override // com.mobvoi.apollo.client.fitness.b
        public void c(List<DataSession> dataSessions) {
            i.f(dataSessions, "dataSessions");
            if (k.j()) {
                k.h("ApolloBleEngine", i.n("GTW DataSessions: ", new e().s(dataSessions)));
            }
            a aVar = b.f19147d;
            if (aVar != null) {
                aVar.obtainMessage(4, dataSessions).sendToTarget();
            } else {
                i.u("workHandler");
                throw null;
            }
        }

        @Override // com.mobvoi.apollo.client.fitness.b
        public void d(List<DataSet> dataSets) {
            i.f(dataSets, "dataSets");
            if (k.j()) {
                k.h("ApolloBleEngine", i.n("GTW DataSets: ", new e().s(dataSets)));
            }
            a aVar = b.f19147d;
            if (aVar != null) {
                aVar.obtainMessage(2, dataSets).sendToTarget();
            } else {
                i.u("workHandler");
                throw null;
            }
        }
    }

    /* compiled from: ApolloBleEngine.kt */
    /* loaded from: classes2.dex */
    public static final class c implements d.b {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(Sms sms) {
            x.a aVar = x.f19697b;
            Context context = b.f19146c;
            if (context != null) {
                i.e(sms, "sms");
                aVar.a(context, sms);
                return;
            }
            i.u("context");
            throw null;
        }

        @Override // com.mobvoi.apollo.client.d.b
        public void a(BluetoothDevice bluetoothDevice, ClientState clientState) {
            d.b.a.g(this, bluetoothDevice, clientState);
        }

        @Override // com.mobvoi.apollo.client.d.b
        public void b(ka.a packet) {
            EsimInfo esimInfo;
            i.f(packet, "packet");
            k.a("ApolloBleEngine", oa.d.f31487a.a(packet.a()));
            int a10 = packet.a();
            if (a10 == 304) {
                byte[] c10 = packet.c();
                byte b10 = 0;
                if (c10 != null) {
                    b10 = c10[0];
                }
                k.a("ApolloBleEngine", i.n("Apollo 电量：", Integer.valueOf(b10)));
                n.f19178a.P(b10);
            } else if (a10 == 338) {
                k.a("ApolloBleEngine", "Apollo watch: COMMAND_LPA_QUERY_EID_RESP received");
                byte[] c11 = packet.c();
                if (c11 != null) {
                    String str = new String(c11, kotlin.text.d.f30092a);
                    k.a("ApolloBleEngine", i.n("Apollo watch: COMMAND_LPA_QUERY_EID_RESP raw data: ", str));
                    try {
                        esimInfo = (EsimInfo) new e().j(str, EsimInfo.class);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                        esimInfo = null;
                    }
                    if (esimInfo != null) {
                        Context context = b.f19146c;
                        if (context != null) {
                            r rVar = new r(context);
                            rVar.v(esimInfo.getImei());
                            String eid = esimInfo.getEid();
                            if (eid == null) {
                                eid = "";
                            }
                            rVar.u(eid);
                            Context context2 = b.f19146c;
                            if (context2 != null) {
                                b1.a b11 = b1.a.b(context2);
                                Intent intent = new Intent("com.mobvoi.baiding.ACTION.APOLLO_ESIM_GET_EID_RESP");
                                intent.putExtra("apollo_esim_extra_imei", esimInfo.getImei());
                                intent.putExtra("apollo_esim_extra_eid", esimInfo.getEid());
                                m mVar = m.f28349a;
                                b11.d(intent);
                                k.a("ApolloBleEngine", "Apollo watch: APOLLO_ESIM_ACTION_GET_EID_RESPONSE has been sent. imei:" + ((Object) esimInfo.getImei()) + " eid:" + ((Object) esimInfo.getEid()));
                                return;
                            }
                            i.u("context");
                            throw null;
                        }
                        i.u("context");
                        throw null;
                    }
                    aa.c.b("手表返回EID不全，可能导致开卡失败");
                }
            } else if (a10 == 352) {
                q.f15504a.k();
            } else if (a10 == 516) {
                ContactsActivity.f19524b.a();
            } else if (a10 == 528 || a10 == 530 || a10 == 532) {
                com.mobvoi.apollo.client.fitness.c cVar = b.f19148e;
                int a11 = packet.a();
                byte[] c12 = packet.c();
                i.d(c12);
                cVar.g(a11, c12);
            } else if (a10 == 1288) {
                Context context3 = b.f19146c;
                if (context3 != null) {
                    b1.a.b(context3).d(new Intent("com.mobvoi.mcuwatch.Apollo_PULL_ACCESS_CARD"));
                } else {
                    i.u("context");
                    throw null;
                }
            } else if (a10 == 320) {
                Context context4 = b.f19146c;
                if (context4 != null) {
                    Intent intent2 = new Intent(context4, RingingService.class);
                    intent2.setAction("action_start");
                    Context context5 = b.f19146c;
                    if (context5 != null) {
                        context5.startService(intent2);
                    } else {
                        i.u("context");
                        throw null;
                    }
                } else {
                    i.u("context");
                    throw null;
                }
            } else if (a10 == 321) {
                Context context6 = b.f19146c;
                if (context6 != null) {
                    Intent intent3 = new Intent(context6, RingingService.class);
                    intent3.setAction("action_stop");
                    Context context7 = b.f19146c;
                    if (context7 != null) {
                        context7.startService(intent3);
                    } else {
                        i.u("context");
                        throw null;
                    }
                } else {
                    i.u("context");
                    throw null;
                }
            } else if (a10 == 386) {
                byte[] c13 = packet.c();
                if (c13 != null) {
                    final Sms sms = (Sms) new e().j(new String(c13, kotlin.text.d.f30092a), Sms.class);
                    l.a().post(new Runnable() { // from class: com.mobvoi.mcuwatch.engine.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.c.f(Sms.this);
                        }
                    });
                }
            } else if (a10 != 387) {
                switch (a10) {
                    case 288:
                    case 289:
                    case 290:
                    case 291:
                        b.f19144a.j(packet.a());
                        return;
                    default:
                        return;
                }
            } else {
                SmsActivity.f20218b.a();
            }
        }

        @Override // com.mobvoi.apollo.client.d.b
        public void c() {
            String d10 = ta.a.d();
            int i10 = 0;
            if (!(d10 == null || d10.length() == 0)) {
                String d11 = ta.a.d();
                i.e(d11, "getAccountId()");
                i10 = Integer.parseInt(d11);
            }
            String x10 = ta.a.x();
            i.e(x10, "getWwid()");
            String s10 = ta.a.s();
            i.e(s10, "getSessionId()");
            q.f15504a.V(new PhoneInfo(x10, s10, i10, System.currentTimeMillis()));
            a aVar = b.f19147d;
            if (aVar != null) {
                aVar.obtainMessage(1).sendToTarget();
            } else {
                i.u("workHandler");
                throw null;
            }
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

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(int i10) {
        bi.b.g().j(i10 != 290 ? i10 != 291 ? 52 : 53 : 54);
    }

    private final String k(String str) {
        return ig.b.J().l(str);
    }

    private final void m() {
        a aVar = f19147d;
        if (aVar != null) {
            aVar.removeMessages(5);
            a aVar2 = f19147d;
            if (aVar2 != null) {
                aVar2.sendEmptyMessageDelayed(5, ab.Y);
            } else {
                i.u("workHandler");
                throw null;
            }
        } else {
            i.u("workHandler");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(List<DataSet> list) {
        int p10;
        if (!(list == null || list.isEmpty())) {
            String x10 = ta.a.x();
            String a10 = r.f15521b.a();
            ArrayList<DataSet.Point> arrayList = new ArrayList();
            for (DataSet dataSet : list) {
                kotlin.collections.r.s(arrayList, dataSet.getPoints());
            }
            p10 = n.p(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(p10);
            for (DataSet.Point point : arrayList) {
                qf.a aVar = new qf.a(DataType.from(point.getDataType()), point.getStartTime(), point.getEndTime(), point.getValue());
                aVar.f33126b = x10;
                aVar.f33125a = a10;
                arrayList2.add(aVar);
            }
            ig.b.J().z().k(arrayList2);
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(List<DataSession> list) {
        String x10 = ta.a.x();
        String a10 = r.f15521b.a();
        for (DataSession dataSession : list) {
            qf.c cVar = new qf.c(ActivityType.from(dataSession.getActivityType()), dataSession.getStartTime(), dataSession.getEndTime());
            cVar.f33133i = dataSession.getSessionId();
            cVar.f33126b = x10;
            cVar.f33125a = a10;
            ig.b.J().C().d(cVar);
        }
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(FitnessRecord fitnessRecord) {
        ah.b a10 = ah.c.a();
        Context context = f19146c;
        if (context != null) {
            final ef.r e10 = df.a.e(nj.a.b(fitnessRecord), a10.a(context), vg.a.a().b() ? 0 : 2);
            l.a().post(new Runnable() { // from class: com.mobvoi.mcuwatch.engine.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.r(ef.r.this);
                }
            });
            return;
        }
        i.u("context");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(ef.r rVar) {
        f.X().t(rVar);
        f.X().M(ab.Y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        String k10 = k(r.f15521b.a());
        if (k10 != null) {
            q.f15504a.N(k10);
            return;
        }
        a aVar = f19147d;
        if (aVar != null) {
            Message obtainMessage = aVar.obtainMessage(1);
            a aVar2 = f19147d;
            if (aVar2 != null) {
                aVar2.sendMessageDelayed(obtainMessage, 2000L);
            } else {
                i.u("workHandler");
                throw null;
            }
        } else {
            i.u("workHandler");
            throw null;
        }
    }

    public final void l(Context context) {
        i.f(context, "context");
        if (!f19145b) {
            Context applicationContext = context.getApplicationContext();
            i.e(applicationContext, "context.applicationContext");
            f19146c = applicationContext;
            q qVar = q.f15504a;
            qVar.z(context);
            qVar.j(f19149f);
            HandlerThread handlerThread = new HandlerThread("QueryWorker");
            handlerThread.start();
            Looper workerLooper = handlerThread.getLooper();
            i.e(workerLooper, "workerLooper");
            f19147d = new a(workerLooper);
            f19145b = true;
            f19148e.i(f19150g);
            ApolloClientService.f15458a.b(sh.f.f34582r1);
        }
    }

    public final void n() {
        Context context = f19146c;
        if (context != null) {
            r rVar = new r(context);
            rVar.r(null);
            rVar.s(null);
            rVar.v("");
            rVar.u("");
            return;
        }
        i.u("context");
        throw null;
    }
}
