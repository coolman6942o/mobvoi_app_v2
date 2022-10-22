package pk;

import android.location.Location;
import android.os.Handler;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.l;
import com.mobvoi.ticwear.youngwatch.data.PacketProfile;
import com.tendcloud.tenddata.ab;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import yg.f;
/* compiled from: MeasureDataParseImpl.java */
/* loaded from: classes2.dex */
public class c0 {

    /* renamed from: a  reason: collision with root package name */
    private final Map<PacketProfile, j> f32782a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f32783b = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: c  reason: collision with root package name */
    private final Executor f32784c = Executors.newSingleThreadExecutor();

    /* renamed from: d  reason: collision with root package name */
    private final Executor f32785d = Executors.newSingleThreadExecutor();

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f32786e = a0.f32777a;

    /* renamed from: f  reason: collision with root package name */
    private final Runnable f32787f = b0.f32779a;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f32788g = l.a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MeasureDataParseImpl.java */
    /* loaded from: classes2.dex */
    public static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Object f32789a;

        /* renamed from: b  reason: collision with root package name */
        private final j f32790b;

        @Override // java.lang.Runnable
        public void run() {
            this.f32790b.a(this.f32789a);
        }

        private b(Object obj, j jVar) {
            this.f32789a = obj;
            this.f32790b = jVar;
        }
    }

    public c0() {
        EnumMap enumMap = new EnumMap(PacketProfile.class);
        this.f32782a = enumMap;
        e f10 = e.f();
        com.mobvoi.health.common.data.db.a c10 = f10.c();
        f10.b();
        f10.e();
        xe.b d10 = f10.d();
        w0 w0Var = new w0(d10, c10);
        t0 t0Var = new t0(d10);
        enumMap.put((EnumMap) PacketProfile.HEART_RATE_DATA, (PacketProfile) new t(c10));
        enumMap.put((EnumMap) PacketProfile.TEMPERATURE_DATA, (PacketProfile) new d1(c10));
        enumMap.put((EnumMap) PacketProfile.BLOOD_OXYGEN_DATA, (PacketProfile) new f0(c10));
        enumMap.put((EnumMap) PacketProfile.RUNNING_HEART_RATE_DATA, (PacketProfile) w0Var);
        enumMap.put((EnumMap) PacketProfile.SPORTS_HEART_RATE_DATA, (PacketProfile) w0Var);
        enumMap.put((EnumMap) PacketProfile.DAILY_MEASUREMENT_DATA, (PacketProfile) new a1(c10));
        enumMap.put((EnumMap) PacketProfile.SPORTS_STATUS_DATA, (PacketProfile) new o(d10));
        enumMap.put((EnumMap) PacketProfile.RUNNING_CALORIE_DATA, (PacketProfile) t0Var);
        enumMap.put((EnumMap) PacketProfile.SPORTS_CALORIE_DATA, (PacketProfile) t0Var);
        enumMap.put((EnumMap) PacketProfile.SLEEP_DATA, (PacketProfile) new n0());
        enumMap.put((EnumMap) PacketProfile.ARTY_INFO_DATA, (PacketProfile) new d(c10));
    }

    private boolean d(PacketProfile packetProfile, Object obj) {
        if (!PacketProfile.UNKNOWN.equals(packetProfile)) {
            return false;
        }
        if (!(obj instanceof List)) {
            return true;
        }
        List list = (List) obj;
        return list.isEmpty() || !(list.get(0) instanceof Location);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e() {
        f.X().K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f() {
        ig.b.J().A();
    }

    private void g(j jVar) {
        if (jVar instanceof p) {
            this.f32788g.removeCallbacks(this.f32786e);
            this.f32788g.postDelayed(this.f32786e, ab.Y);
            return;
        }
        this.f32788g.removeCallbacks(this.f32787f);
        this.f32788g.postDelayed(this.f32787f, ab.Y);
    }

    public void c(Object obj, PacketProfile packetProfile) {
        j jVar = this.f32782a.get(packetProfile);
        if (jVar != null) {
            k.c("MeasureDataParseImpl", "Handle data %s , type is %s", obj, packetProfile);
            b bVar = new b(obj, jVar);
            if (jVar instanceof p) {
                if (!d(packetProfile, obj)) {
                    this.f32784c.execute(bVar);
                }
            } else if (jVar instanceof q0) {
                this.f32785d.execute(bVar);
            } else {
                this.f32783b.execute(bVar);
            }
            g(jVar);
            return;
        }
        k.c("MeasureDataParseImpl", "Can't handle %s , type is %s", obj, packetProfile);
    }
}
