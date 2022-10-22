package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import kotlin.jvm.internal.i;
import kotlin.text.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmOkio.kt */
/* loaded from: classes3.dex */
public final /* synthetic */ class o {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f32418a = Logger.getLogger("okio.Okio");

    public static final r b(File appendingSink) throws FileNotFoundException {
        i.f(appendingSink, "$this$appendingSink");
        return n.h(new FileOutputStream(appendingSink, true));
    }

    public static final boolean c(AssertionError isAndroidGetsocknameError) {
        i.f(isAndroidGetsocknameError, "$this$isAndroidGetsocknameError");
        if (isAndroidGetsocknameError.getCause() == null) {
            return false;
        }
        String message = isAndroidGetsocknameError.getMessage();
        return message != null ? u.I(message, "getsockname failed", false, 2, null) : false;
    }

    public static final r d(File sink, boolean z10) throws FileNotFoundException {
        i.f(sink, "$this$sink");
        return n.h(new FileOutputStream(sink, z10));
    }

    public static final r e(OutputStream sink) {
        i.f(sink, "$this$sink");
        return new q(sink, new u());
    }

    public static final r f(Socket sink) throws IOException {
        i.f(sink, "$this$sink");
        s sVar = new s(sink);
        OutputStream outputStream = sink.getOutputStream();
        i.e(outputStream, "getOutputStream()");
        return sVar.v(new q(outputStream, sVar));
    }

    public static /* synthetic */ r g(File file, boolean z10, int i10, Object obj) throws FileNotFoundException {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return n.g(file, z10);
    }

    public static final t h(File source) throws FileNotFoundException {
        i.f(source, "$this$source");
        return n.l(new FileInputStream(source));
    }

    public static final t i(InputStream source) {
        i.f(source, "$this$source");
        return new m(source, new u());
    }

    public static final t j(Socket source) throws IOException {
        i.f(source, "$this$source");
        s sVar = new s(source);
        InputStream inputStream = source.getInputStream();
        i.e(inputStream, "getInputStream()");
        return sVar.w(new m(inputStream, sVar));
    }
}
