package kotlinx.coroutines;

import com.huawei.hms.ml.camera.CameraConfig;
import java.util.concurrent.atomic.AtomicLong;
import kotlinx.coroutines.internal.x;
/* compiled from: Debug.kt */
/* loaded from: classes3.dex */
public final class n0 {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f30258a = false;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f30259b;

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f30260c;

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicLong f30261d;

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
        if (r0.equals(com.huawei.hms.ml.camera.CameraConfig.CAMERA_FOCUS_AUTO) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r0.equals("on") != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
        if (r0.equals("") != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0042, code lost:
        r0 = true;
     */
    static {
        boolean z10;
        String d10 = x.d("kotlinx.coroutines.debug");
        boolean z11 = false;
        if (d10 != null) {
            int hashCode = d10.hashCode();
            if (hashCode != 0) {
                if (hashCode != 3551) {
                    if (hashCode != 109935) {
                        if (hashCode == 3005871) {
                        }
                    } else if (d10.equals(CameraConfig.CAMERA_TORCH_OFF)) {
                        z10 = false;
                    }
                }
                throw new IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + ((Object) d10) + '\'').toString());
            }
            f30259b = z10;
            if (z10 && x.e("kotlinx.coroutines.stacktrace.recovery", true)) {
                z11 = true;
            }
            f30260c = z11;
            f30261d = new AtomicLong(0L);
        }
        z10 = a();
        f30259b = z10;
        if (z10) {
            z11 = true;
        }
        f30260c = z11;
        f30261d = new AtomicLong(0L);
    }

    public static final boolean a() {
        return f30258a;
    }

    public static final AtomicLong b() {
        return f30261d;
    }

    public static final boolean c() {
        return f30259b;
    }

    public static final boolean d() {
        return f30260c;
    }
}
