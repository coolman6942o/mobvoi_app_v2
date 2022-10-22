package okio;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmOkio.kt */
/* loaded from: classes3.dex */
public final class s extends a {

    /* renamed from: l  reason: collision with root package name */
    private final Socket f32421l;

    public s(Socket socket) {
        i.f(socket, "socket");
        this.f32421l = socket;
    }

    @Override // okio.a
    protected IOException t(IOException iOException) {
        SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
        if (iOException != null) {
            socketTimeoutException.initCause(iOException);
        }
        return socketTimeoutException;
    }

    @Override // okio.a
    protected void x() {
        Logger logger;
        Logger logger2;
        try {
            this.f32421l.close();
        } catch (AssertionError e10) {
            if (n.e(e10)) {
                logger2 = o.f32418a;
                Level level = Level.WARNING;
                logger2.log(level, "Failed to close timed out socket " + this.f32421l, (Throwable) e10);
                return;
            }
            throw e10;
        } catch (Exception e11) {
            logger = o.f32418a;
            Level level2 = Level.WARNING;
            logger.log(level2, "Failed to close timed out socket " + this.f32421l, (Throwable) e11);
        }
    }
}
