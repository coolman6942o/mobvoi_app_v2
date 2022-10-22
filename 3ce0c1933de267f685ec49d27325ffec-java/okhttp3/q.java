package okhttp3;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: Dns.kt */
/* loaded from: classes3.dex */
public interface q {

    /* renamed from: a  reason: collision with root package name */
    public static final q f32261a = new a.C0442a();

    /* compiled from: Dns.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* compiled from: Dns.kt */
        /* renamed from: okhttp3.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        private static final class C0442a implements q {
            @Override // okhttp3.q
            public List<InetAddress> a(String hostname) {
                List<InetAddress> D;
                i.f(hostname, "hostname");
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(hostname);
                    i.e(allByName, "InetAddress.getAllByName(hostname)");
                    D = kotlin.collections.i.D(allByName);
                    return D;
                } catch (NullPointerException e10) {
                    UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + hostname);
                    unknownHostException.initCause(e10);
                    throw unknownHostException;
                }
            }
        }

        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    List<InetAddress> a(String str) throws UnknownHostException;
}
