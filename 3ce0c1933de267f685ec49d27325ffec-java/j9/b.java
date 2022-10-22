package j9;

import java.io.IOException;
import java.io.InputStream;
import java.net.ProtocolException;
import java.util.List;
import java.util.Map;
/* compiled from: FileDownloadConnection.java */
/* loaded from: classes2.dex */
public interface b {
    InputStream a() throws IOException;

    Map<String, List<String>> b();

    boolean c(String str, long j10);

    int d() throws IOException;

    void e(String str, String str2);

    void execute() throws IOException;

    String f(String str);

    void g();

    boolean h(String str) throws ProtocolException;

    Map<String, List<String>> i();
}
