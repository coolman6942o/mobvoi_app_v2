package okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/* loaded from: classes3.dex */
public final class n {
    public static final r a(File file) throws FileNotFoundException {
        return o.b(file);
    }

    public static final r b() {
        return p.a();
    }

    public static final d c(r rVar) {
        return p.b(rVar);
    }

    public static final e d(t tVar) {
        return p.c(tVar);
    }

    public static final boolean e(AssertionError assertionError) {
        return o.c(assertionError);
    }

    public static final r f(File file) throws FileNotFoundException {
        return o.g(file, false, 1, null);
    }

    public static final r g(File file, boolean z10) throws FileNotFoundException {
        return o.d(file, z10);
    }

    public static final r h(OutputStream outputStream) {
        return o.e(outputStream);
    }

    public static final r i(Socket socket) throws IOException {
        return o.f(socket);
    }

    public static final t k(File file) throws FileNotFoundException {
        return o.h(file);
    }

    public static final t l(InputStream inputStream) {
        return o.i(inputStream);
    }

    public static final t m(Socket socket) throws IOException {
        return o.j(socket);
    }
}
