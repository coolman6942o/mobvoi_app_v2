package h1;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import i1.b;
import i1.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
/* compiled from: DBUtil.java */
/* loaded from: classes.dex */
public class c {
    /* JADX WARN: Finally extract failed */
    public static void a(b bVar) {
        ArrayList<String> arrayList = new ArrayList();
        Cursor U = bVar.U("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (U.moveToNext()) {
            try {
                arrayList.add(U.getString(0));
            } catch (Throwable th2) {
                U.close();
                throw th2;
            }
        }
        U.close();
        for (String str : arrayList) {
            if (str.startsWith("room_fts_content_sync_")) {
                bVar.l("DROP TRIGGER IF EXISTS " + str);
            }
        }
    }

    public static Cursor b(RoomDatabase roomDatabase, e eVar, boolean z10, CancellationSignal cancellationSignal) {
        Cursor z11 = roomDatabase.z(eVar, cancellationSignal);
        if (!z10 || !(z11 instanceof AbstractWindowedCursor)) {
            return z11;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) z11;
        int count = abstractWindowedCursor.getCount();
        return (Build.VERSION.SDK_INT < 23 || (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count) ? b.a(abstractWindowedCursor) : z11;
    }

    public static int c(File file) throws IOException {
        FileChannel fileChannel = null;
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            FileChannel channel = new FileInputStream(file).getChannel();
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(allocate) == 4) {
                allocate.rewind();
                int i10 = allocate.getInt();
                channel.close();
                return i10;
            }
            throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
        } catch (Throwable th2) {
            if (0 != 0) {
                fileChannel.close();
            }
            throw th2;
        }
    }
}
