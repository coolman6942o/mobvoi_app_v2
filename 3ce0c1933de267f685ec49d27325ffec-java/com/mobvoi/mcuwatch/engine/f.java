package com.mobvoi.mcuwatch.engine;

import android.util.Log;
import android.widget.Toast;
import cn.n;
import cn.s;
import com.mobvoi.android.common.utils.a;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.mcuwatch.bean.AlarmBean;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import gn.p;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.i;
/* compiled from: Extensions.kt */
/* loaded from: classes2.dex */
public final class f {
    public static final void A(u uVar, boolean z10, int i10, int i11) {
        i.f(uVar, "<this>");
        if (p.h(b.e(), 1)) {
            uVar.N().u0(z10, i10, i11);
        }
    }

    public static final void B(u uVar, boolean z10, int i10) {
        i.f(uVar, "<this>");
        uVar.N().F0(z10, i10);
    }

    public static final void C(u uVar, boolean z10, float f10, float f11) {
        i.f(uVar, "<this>");
        uVar.N().H0(z10, f10, f11);
    }

    public static final void D(u uVar) {
        i.f(uVar, "<this>");
        uVar.N().K0();
    }

    public static final void E(u uVar, boolean z10, int i10) {
        i.f(uVar, "<this>");
        uVar.N().J0(z10, i10);
    }

    public static final void F(u uVar) {
        i.f(uVar, "<this>");
        uVar.N().L0();
    }

    public static final void G(u uVar) {
        i.f(uVar, "<this>");
        uVar.N().y0();
    }

    public static final void H(u uVar) {
        i.f(uVar, "<this>");
        if (p.h(b.e(), 1)) {
            String n10 = i.n(q.d(b.e(), "sync_mcu_fitness", "sport_mode_mills", "20200603"), "0000");
            uVar.N().I0(n10);
            Log.d("UTEBleEngine", i.n("同步运动模式的回调 syncTime = ", n10));
            return;
        }
        Toast.makeText(b.e(), "手表不支持多运动心率功能", 0).show();
    }

    public static final void I(u uVar) {
        i.f(uVar, "<this>");
        uVar.N().A0();
    }

    public static final void J(u uVar) {
        i.f(uVar, "<this>");
        uVar.N().M();
    }

    public static final void K(u uVar) {
        i.f(uVar, "<this>");
        uVar.N().C0();
    }

    public static final void L(u uVar, boolean z10, int i10) {
        i.f(uVar, "<this>");
        uVar.N().O0(z10, i10);
    }

    public static final void M(u uVar, n weather) {
        i.f(uVar, "<this>");
        i.f(weather, "weather");
        uVar.N().N0(weather);
    }

    public static final void N(u uVar, byte[] bArr, int i10) {
        i.f(uVar, "<this>");
        i.f(bArr, "byte");
        uVar.N().R0(bArr, i10);
    }

    public static final void a(u uVar) {
        i.f(uVar, "<this>");
        uVar.N().Z();
    }

    public static final void b(u uVar, s info) {
        i.f(uVar, "<this>");
        i.f(info, "info");
        if (p.d(b.e(), 2)) {
            uVar.N().w(info);
        }
    }

    public static final void c(u uVar, int i10) {
        i.f(uVar, "<this>");
        if (uVar.S()) {
            uVar.N().u(i10);
        }
    }

    public static final void d(u uVar) {
        i.f(uVar, "<this>");
        uVar.N().y();
    }

    public static final void e(u uVar) {
        i.f(uVar, "<this>");
        uVar.N().z(5);
    }

    public static final void f(u uVar, int i10, byte[] bArr) {
        i.f(uVar, "<this>");
        i.f(bArr, "byte");
        int length = bArr.length;
        ByteBuffer allocate = ByteBuffer.allocate(length + 9);
        allocate.put((byte) -90);
        allocate.putInt(i10);
        allocate.putInt(length);
        allocate.put(bArr);
        byte[] array = allocate.array();
        Log.d("UTEBleEngine", i.n("sendPackageBin start offset = ", Integer.valueOf(i10)));
        Log.d("UTEBleEngine", a.f(array));
        uVar.N().R0(array, 0);
    }

    public static final void g(u uVar) {
        i.f(uVar, "<this>");
        ByteBuffer allocate = ByteBuffer.allocate(8);
        allocate.put((byte) -89);
        allocate.putShort((short) 0);
        allocate.put((byte) 0);
        allocate.putInt(0);
        byte[] array = allocate.array();
        Log.d("UTEBleEngine", a.f(array));
        uVar.N().R0(array, 1);
    }

    public static final void h(u uVar, int i10, Byte b10) {
        i.f(uVar, "<this>");
        Log.d("UTEBleEngine", i.n("notificationStart fileSize = ", Integer.valueOf(i10)));
        ByteBuffer allocate = ByteBuffer.allocate(15);
        allocate.put((byte) -91);
        allocate.putShort((short) 0);
        allocate.putInt(i10);
        if (b10 != null) {
            allocate.put(b10.byteValue());
        }
        byte[] array = allocate.array();
        Log.d("UTEBleEngine", a.f(array));
        uVar.N().R0(array, 1);
    }

    public static final void i(u uVar, boolean z10) {
        i.f(uVar, "<this>");
        uVar.N().K(z10);
    }

    public static final void j(u uVar) {
        i.f(uVar, "<this>");
        uVar.N().N();
    }

    public static final void k(u uVar, boolean z10, int i10, int i11, int i12, int i13) {
        i.f(uVar, "<this>");
        uVar.N().V(false, false, z10, i10, i11, i12, i13);
    }

    public static final void l(u uVar, int i10) {
        i.f(uVar, "<this>");
        t(uVar, 0, 0, i10, 0, false, false, 0, false, 0, false, false, 0, !com.mobvoi.companion.base.settings.a.isTempCelsius(b.e()) ? 1 : 0, false, 12283, null);
    }

    public static final void m(u uVar, boolean z10, String calendar, int i10, int i11) {
        i.f(uVar, "<this>");
        i.f(calendar, "calendar");
        k.c("UTEBleEngine", "isOpen = %s,calendar = %s,duration = %s,period = %s", Boolean.valueOf(z10), calendar, Integer.valueOf(i10), Integer.valueOf(i11));
        uVar.N().v0(z10, calendar, i10, i11);
    }

    public static final void n(u uVar, int i10) {
        i.f(uVar, "<this>");
        uVar.N().b0(i10);
    }

    public static final void o(u uVar, boolean z10) {
        i.f(uVar, "<this>");
        t(uVar, 0, 0, 0, 0, z10, false, 0, false, 0, false, false, 0, !com.mobvoi.companion.base.settings.a.isTempCelsius(b.e()) ? 1 : 0, false, 12271, null);
    }

    public static final void p(u uVar, int i10, int i11, int i12, int i13, int i14, boolean z10) {
        i.f(uVar, "<this>");
        r(uVar, i10, i11, i12, i13, i14, z10, 0, 64, null);
    }

    public static final void q(u uVar, int i10, int i11, int i12, int i13, int i14, boolean z10, int i15) {
        i.f(uVar, "<this>");
        if (p.c(b.e(), WXMediaMessage.THUMB_LENGTH_LIMIT)) {
            k.a("UTEBleEngine", "IS_SUPPORT_SEDENTARY_REMINDER");
        }
        if (p.f(b.e(), 16)) {
            k.a("UTEBleEngine", "IS_SUPPORT_SIT_TIME_FUNCTION");
        }
        uVar.N().e0(i10, i15, i11, i12, i13, i14, z10);
    }

    public static /* synthetic */ void r(u uVar, int i10, int i11, int i12, int i13, int i14, boolean z10, int i15, int i16, Object obj) {
        q(uVar, i10, i11, i12, i13, i14, z10, (i16 & 64) != 0 ? 60 : i15);
    }

    public static final void s(u uVar, int i10, int i11, int i12, int i13, boolean z10, boolean z11, int i14, boolean z12, int i15, boolean z13, boolean z14, int i16, int i17, boolean z15) {
        i.f(uVar, "<this>");
        uVar.N().f0(i10, i11, i12, i13, z10, z11, i14, z12, i15, z13, z14, i16, i17, z15);
    }

    public static /* synthetic */ void t(u uVar, int i10, int i11, int i12, int i13, boolean z10, boolean z11, int i14, boolean z12, int i15, boolean z13, boolean z14, int i16, int i17, boolean z15, int i18, Object obj) {
        s(uVar, (i18 & 1) != 0 ? n.f19178a.j() : i10, (i18 & 2) != 0 ? n.f19178a.t() : i11, (i18 & 4) != 0 ? n.f19178a.m() : i12, (i18 & 8) != 0 ? 10000 : i13, (i18 & 16) != 0 ? n.f19178a.C() : z10, (i18 & 32) != 0 ? true : z11, (i18 & 64) != 0 ? 150 : i14, (i18 & 128) != 0 ? n.f19178a.i() : z12, (i18 & 256) != 0 ? n.f19178a.b() : i15, (i18 & 512) != 0 ? false : z13, (i18 & 1024) != 0 ? true : z14, (i18 & 2048) != 0 ? 50 : i16, i17, (i18 & 8192) != 0 ? true : z15);
    }

    public static final void u(u uVar, String msgObject, int i10) {
        i.f(uVar, "<this>");
        i.f(msgObject, "msgObject");
        uVar.N().i0(msgObject, i10);
    }

    public static final void v(u uVar) {
        i.f(uVar, "<this>");
        uVar.N().k0();
    }

    public static final void w(u uVar) {
        i.f(uVar, "<this>");
        uVar.N().l0();
    }

    public static final void x(u uVar, int i10, int i11) {
        i.f(uVar, "<this>");
        uVar.N().n0(i10, i11);
    }

    public static final void y(u uVar, AlarmBean alarmBean, byte b10) {
        i.f(uVar, "<this>");
        i.f(alarmBean, "alarmBean");
        uVar.N().m0(alarmBean.whichClock, b10, alarmBean.hour, alarmBean.minute, alarmBean.isOpen, 20);
    }

    public static final void z(u uVar, int i10) {
        i.f(uVar, "<this>");
        if (p.f(b.e(), 8)) {
            uVar.N().E0(i10);
        }
    }
}
