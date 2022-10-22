package op;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import kotlin.collections.l;
/* compiled from: NullProxySelector.kt */
/* loaded from: classes3.dex */
public final class a extends ProxySelector {

    /* renamed from: a  reason: collision with root package name */
    public static final a f32432a = new a();

    private a() {
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        List<Proxy> b10;
        if (uri != null) {
            b10 = l.b(Proxy.NO_PROXY);
            return b10;
        }
        throw new IllegalArgumentException("uri must not be null".toString());
    }
}
