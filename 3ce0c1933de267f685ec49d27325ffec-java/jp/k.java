package jp;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import okhttp3.Protocol;
/* compiled from: StatusLine.kt */
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: d  reason: collision with root package name */
    public static final a f29676d = new a(null);

    /* renamed from: a  reason: collision with root package name */
    public final Protocol f29677a;

    /* renamed from: b  reason: collision with root package name */
    public final int f29678b;

    /* renamed from: c  reason: collision with root package name */
    public final String f29679c;

    /* compiled from: StatusLine.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final k a(String statusLine) throws IOException {
            boolean D;
            Protocol protocol;
            String str;
            boolean D2;
            i.f(statusLine, "statusLine");
            D = t.D(statusLine, "HTTP/1.", false, 2, null);
            int i10 = 9;
            if (!D) {
                D2 = t.D(statusLine, "ICY ", false, 2, null);
                if (D2) {
                    protocol = Protocol.HTTP_1_0;
                    i10 = 4;
                } else {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
            } else if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            } else {
                int charAt = statusLine.charAt(7) - '0';
                if (charAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else if (charAt == 1) {
                    protocol = Protocol.HTTP_1_1;
                } else {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
            }
            int i11 = i10 + 3;
            if (statusLine.length() >= i11) {
                try {
                    String substring = statusLine.substring(i10, i11);
                    i.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    int parseInt = Integer.parseInt(substring);
                    if (statusLine.length() <= i11) {
                        str = "";
                    } else if (statusLine.charAt(i11) == ' ') {
                        str = statusLine.substring(i10 + 4);
                        i.e(str, "(this as java.lang.String).substring(startIndex)");
                    } else {
                        throw new ProtocolException("Unexpected status line: " + statusLine);
                    }
                    return new k(protocol, parseInt, str);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
            } else {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public k(Protocol protocol, int i10, String message) {
        i.f(protocol, "protocol");
        i.f(message, "message");
        this.f29677a = protocol;
        this.f29678b = i10;
        this.f29679c = message;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f29677a == Protocol.HTTP_1_0) {
            sb2.append("HTTP/1.0");
        } else {
            sb2.append("HTTP/1.1");
        }
        sb2.append(' ');
        sb2.append(this.f29678b);
        sb2.append(' ');
        sb2.append(this.f29679c);
        String sb3 = sb2.toString();
        i.e(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }
}
