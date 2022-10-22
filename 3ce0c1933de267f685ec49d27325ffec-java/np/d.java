package np;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import kotlin.jvm.internal.i;
/* compiled from: AndroidLog.kt */
/* loaded from: classes3.dex */
public final class d extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public static final d f31321a = new d();

    private d() {
    }

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord record) {
        int b10;
        i.f(record, "record");
        c cVar = c.f31320c;
        String loggerName = record.getLoggerName();
        i.e(loggerName, "record.loggerName");
        b10 = e.b(record);
        String message = record.getMessage();
        i.e(message, "record.message");
        cVar.a(loggerName, b10, message, record.getThrown());
    }
}
