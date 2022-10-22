package com.google.protobuf.nano;

import java.io.IOException;
/* loaded from: classes.dex */
public class InvalidProtocolBufferNanoException extends IOException {
    private static final long serialVersionUID = -1616151763072450476L;

    public InvalidProtocolBufferNanoException(String str) {
        super(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferNanoException a() {
        return new InvalidProtocolBufferNanoException("Protocol message end-group tag did not match expected tag.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferNanoException b() {
        return new InvalidProtocolBufferNanoException("Protocol message contained an invalid tag (zero).");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferNanoException c() {
        return new InvalidProtocolBufferNanoException("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferNanoException d() {
        return new InvalidProtocolBufferNanoException("CodedInputStream encountered a malformed varint.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferNanoException g() {
        return new InvalidProtocolBufferNanoException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferNanoException h() {
        return new InvalidProtocolBufferNanoException("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferNanoException i() {
        return new InvalidProtocolBufferNanoException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }
}
