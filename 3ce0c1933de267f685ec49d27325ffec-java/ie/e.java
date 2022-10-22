package ie;

import android.app.Application;
import android.preference.PreferenceManager;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.android.common.utils.f;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.be.common.ConstantProto;
import com.mobvoi.be.ticassistant.DeviceInfoProto;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import qk.c;
import yp.g;
/* compiled from: UserInfoCollector.java */
/* loaded from: classes2.dex */
public class e {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UserInfoCollector.java */
    /* loaded from: classes2.dex */
    public static class a extends IllegalArgumentException {
        a(String str) {
            super(str);
        }
    }

    private static ConstantProto.DeviceType e(String str) {
        str.hashCode();
        if (str.equals("android_wear")) {
            return ConstantProto.DeviceType.TIC_WATCH;
        }
        if (str.equals("ticlite_mcu")) {
            return ConstantProto.DeviceType.TIC_BAND;
        }
        throw new a("Type not support: " + str);
    }

    private static String f(Map<String, List<c>> map) {
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, List<c>> entry : map.entrySet()) {
            sb2.append(entry.getKey());
            for (c cVar : entry.getValue()) {
                sb2.append(cVar.getId());
                sb2.append(cVar.getModel());
            }
        }
        try {
            return f.k(sb2.toString());
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return "";
        }
    }

    private static String g() {
        return PreferenceManager.getDefaultSharedPreferences(b.e()).getString("device_sig", "");
    }

    private static long h() {
        return PreferenceManager.getDefaultSharedPreferences(b.e()).getLong("device_upload_time", 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String i(Map map) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(h());
        boolean z10 = true;
        if ((calendar.get(5) == Calendar.getInstance().get(5)) && g().equals(f(map))) {
            z10 = false;
        }
        if (z10) {
            return "";
        }
        throw new IllegalStateException("No need to sync.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ rx.c j(Map map, String str) {
        Application e10 = b.e();
        DeviceInfoProto.BindDataCollection.b newBuilder = DeviceInfoProto.BindDataCollection.newBuilder();
        newBuilder.y(ke.a.a());
        newBuilder.s(com.mobvoi.android.common.utils.e.e(e10));
        newBuilder.q(DeviceInfoProto.BindDataCollection.Channel.CHINA);
        for (Map.Entry entry : map.entrySet()) {
            ConstantProto.DeviceType e11 = e((String) entry.getKey());
            for (c cVar : (List) entry.getValue()) {
                DeviceInfoProto.DeviceWwidData.b newBuilder2 = DeviceInfoProto.DeviceWwidData.newBuilder();
                newBuilder2.n(cVar.getId());
                newBuilder2.r(cVar.getModel());
                newBuilder2.o(e11);
                newBuilder.a(newBuilder2.build());
            }
        }
        return ob.a.c().a(newBuilder.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void k(Map map, DeviceInfoProto.DeviceInfoResponse deviceInfoResponse) {
        Object[] objArr = new Object[1];
        objArr[0] = deviceInfoResponse == null ? "empty response" : Boolean.valueOf(deviceInfoResponse.getOk());
        k.c("UserInfoCollector", "Finish upload devices info: %s", objArr);
        if (deviceInfoResponse != null && deviceInfoResponse.getOk()) {
            n(System.currentTimeMillis());
            m(f(map));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(Throwable th2) {
        k.f("UserInfoCollector", "Error upload devices info: %s", th2.getMessage());
        boolean z10 = th2 instanceof a;
    }

    private static void m(String str) {
        PreferenceManager.getDefaultSharedPreferences(b.e()).edit().putString("device_sig", str).apply();
    }

    private static void n(long j10) {
        PreferenceManager.getDefaultSharedPreferences(b.e()).edit().putLong("device_upload_time", j10).apply();
    }

    public static void o(final Map<String, List<c>> map) {
        rx.c.x(new Callable() { // from class: ie.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String i10;
                i10 = e.i(map);
                return i10;
            }
        }).v(new g() { // from class: ie.d
            @Override // yp.g
            public final Object call(Object obj) {
                rx.c j10;
                j10 = e.j(map, (String) obj);
                return j10;
            }
        }).Z(cq.a.c()).Y(new yp.b() { // from class: ie.b
            @Override // yp.b
            public final void call(Object obj) {
                e.k(map, (DeviceInfoProto.DeviceInfoResponse) obj);
            }
        }, c.f28239a);
    }
}
