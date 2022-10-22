package i1;

import android.database.Cursor;
import android.database.SQLException;
import android.os.CancellationSignal;
import android.util.Pair;
import java.io.Closeable;
import java.util.List;
/* compiled from: SupportSQLiteDatabase.java */
/* loaded from: classes.dex */
public interface b extends Closeable {
    Cursor D(e eVar, CancellationSignal cancellationSignal);

    void L();

    void M(String str, Object[] objArr) throws SQLException;

    void N();

    Cursor U(String str);

    void Y();

    String a();

    Cursor f0(e eVar);

    void g();

    boolean isOpen();

    List<Pair<String, String>> j();

    void l(String str) throws SQLException;

    boolean q0();

    f s(String str);

    boolean x0();
}
