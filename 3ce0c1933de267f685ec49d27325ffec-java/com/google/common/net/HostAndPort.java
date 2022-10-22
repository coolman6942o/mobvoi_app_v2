package com.google.common.net;

import com.google.common.base.m;
import com.google.common.base.p;
import com.google.common.base.u;
import java.io.Serializable;
/* loaded from: classes.dex */
public final class HostAndPort implements Serializable {
    private static final int NO_PORT = -1;
    private static final long serialVersionUID = 0;
    private final boolean hasBracketlessColons;
    private final String host;
    private final int port;

    private HostAndPort(String str, int i10, boolean z10) {
        this.host = str;
        this.port = i10;
        this.hasBracketlessColons = z10;
    }

    private static String[] a(String str) {
        p.j(str.charAt(0) == '[', "Bracketed host-port string must start with a bracket: %s", str);
        int indexOf = str.indexOf(58);
        int lastIndexOf = str.lastIndexOf(93);
        p.j(indexOf > -1 && lastIndexOf > indexOf, "Invalid bracketed host/port: %s", str);
        String substring = str.substring(1, lastIndexOf);
        int i10 = lastIndexOf + 1;
        if (i10 == str.length()) {
            return new String[]{substring, ""};
        }
        p.j(str.charAt(i10) == ':', "Only a colon may follow a close bracket: %s", str);
        int i11 = lastIndexOf + 2;
        for (int i12 = i11; i12 < str.length(); i12++) {
            p.j(Character.isDigit(str.charAt(i12)), "Port must be numeric: %s", str);
        }
        return new String[]{substring, str.substring(i11)};
    }

    private static boolean b(int i10) {
        return i10 >= 0 && i10 <= 65535;
    }

    public static HostAndPort fromHost(String str) {
        HostAndPort fromString = fromString(str);
        p.j(!fromString.hasPort(), "Host has a port: %s", str);
        return fromString;
    }

    public static HostAndPort fromParts(String str, int i10) {
        p.f(b(i10), "Port out of range: %s", i10);
        HostAndPort fromString = fromString(str);
        p.j(!fromString.hasPort(), "Host has a port: %s", str);
        return new HostAndPort(fromString.host, i10, fromString.hasBracketlessColons);
    }

    public static HostAndPort fromString(String str) {
        String str2;
        String str3;
        p.o(str);
        int i10 = -1;
        boolean z10 = false;
        if (str.startsWith("[")) {
            String[] a10 = a(str);
            str2 = a10[0];
            str3 = a10[1];
        } else {
            int indexOf = str.indexOf(58);
            if (indexOf >= 0) {
                int i11 = indexOf + 1;
                if (str.indexOf(58, i11) == -1) {
                    str2 = str.substring(0, indexOf);
                    str3 = str.substring(i11);
                }
            }
            if (indexOf >= 0) {
                z10 = true;
            }
            str3 = null;
            str2 = str;
        }
        if (!u.a(str3)) {
            p.j(!str3.startsWith("+"), "Unparseable port number: %s", str);
            try {
                i10 = Integer.parseInt(str3);
                p.j(b(i10), "Port number out of range: %s", str);
            } catch (NumberFormatException unused) {
                throw new IllegalArgumentException(str.length() != 0 ? "Unparseable port number: ".concat(str) : new String("Unparseable port number: "));
            }
        }
        return new HostAndPort(str2, i10, z10);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostAndPort)) {
            return false;
        }
        HostAndPort hostAndPort = (HostAndPort) obj;
        return m.a(this.host, hostAndPort.host) && this.port == hostAndPort.port;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        p.u(hasPort());
        return this.port;
    }

    public int getPortOrDefault(int i10) {
        return hasPort() ? this.port : i10;
    }

    public boolean hasPort() {
        return this.port >= 0;
    }

    public int hashCode() {
        return m.b(this.host, Integer.valueOf(this.port));
    }

    public HostAndPort requireBracketsForIPv6() {
        p.j(!this.hasBracketlessColons, "Possible bracketless IPv6 literal: %s", this.host);
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(this.host.length() + 8);
        if (this.host.indexOf(58) >= 0) {
            sb2.append('[');
            sb2.append(this.host);
            sb2.append(']');
        } else {
            sb2.append(this.host);
        }
        if (hasPort()) {
            sb2.append(':');
            sb2.append(this.port);
        }
        return sb2.toString();
    }

    public HostAndPort withDefaultPort(int i10) {
        p.d(b(i10));
        return hasPort() ? this : new HostAndPort(this.host, i10, this.hasBracketlessColons);
    }
}
