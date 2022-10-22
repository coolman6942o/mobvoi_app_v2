package okhttp3;

import java.io.IOException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: Protocol.kt */
/* loaded from: classes3.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");
    
    public static final a Companion = new a(null);
    private final String protocol;

    /* compiled from: Protocol.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final Protocol a(String protocol) throws IOException {
            i.f(protocol, "protocol");
            Protocol protocol2 = Protocol.HTTP_1_0;
            if (!i.b(protocol, protocol2.protocol)) {
                protocol2 = Protocol.HTTP_1_1;
                if (!i.b(protocol, protocol2.protocol)) {
                    protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
                    if (!i.b(protocol, protocol2.protocol)) {
                        protocol2 = Protocol.HTTP_2;
                        if (!i.b(protocol, protocol2.protocol)) {
                            protocol2 = Protocol.SPDY_3;
                            if (!i.b(protocol, protocol2.protocol)) {
                                protocol2 = Protocol.QUIC;
                                if (!i.b(protocol, protocol2.protocol)) {
                                    throw new IOException("Unexpected protocol: " + protocol);
                                }
                            }
                        }
                    }
                }
            }
            return protocol2;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    Protocol(String str) {
        this.protocol = str;
    }

    public static final Protocol get(String str) throws IOException {
        return Companion.a(str);
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
