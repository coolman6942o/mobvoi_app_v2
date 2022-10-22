package com.laser.tsm.sdk.http;

import java.io.IOException;
import java.net.URI;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
/* loaded from: classes2.dex */
public interface ResponseHandlerInterface {
    Header[] getRequestHeaders();

    URI getRequestURI();

    boolean getUseSynchronousMode();

    void sendCancelMessage();

    void sendFailureMessage(int i10, Header[] headerArr, byte[] bArr, Throwable th2);

    void sendFinishMessage();

    void sendProgressMessage(int i10, int i11);

    void sendResponseMessage(HttpResponse httpResponse) throws IOException;

    void sendRetryMessage(int i10);

    void sendStartMessage();

    void sendSuccessMessage(int i10, Header[] headerArr, byte[] bArr);

    void setRequestHeaders(Header[] headerArr);

    void setRequestURI(URI uri);

    void setUseSynchronousMode(boolean z10);
}
