package androidx.room;

import android.content.Context;
import android.util.Log;
import androidx.room.RoomDatabase;
import h1.a;
import h1.d;
import i1.b;
import i1.c;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Callable;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SQLiteCopyOpenHelper.java */
/* loaded from: classes.dex */
public class j0 implements c, j {

    /* renamed from: a  reason: collision with root package name */
    private final Context f4258a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4259b;

    /* renamed from: c  reason: collision with root package name */
    private final File f4260c;

    /* renamed from: d  reason: collision with root package name */
    private final Callable<InputStream> f4261d;

    /* renamed from: e  reason: collision with root package name */
    private final int f4262e;

    /* renamed from: f  reason: collision with root package name */
    private final c f4263f;

    /* renamed from: g  reason: collision with root package name */
    private i f4264g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4265h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(Context context, String str, File file, Callable<InputStream> callable, int i10, c cVar) {
        this.f4258a = context;
        this.f4259b = str;
        this.f4260c = file;
        this.f4261d = callable;
        this.f4262e = i10;
        this.f4263f = cVar;
    }

    private void c(File file, boolean z10) throws IOException {
        ReadableByteChannel readableByteChannel;
        if (this.f4259b != null) {
            readableByteChannel = Channels.newChannel(this.f4258a.getAssets().open(this.f4259b));
        } else if (this.f4260c != null) {
            readableByteChannel = new FileInputStream(this.f4260c).getChannel();
        } else {
            Callable<InputStream> callable = this.f4261d;
            if (callable != null) {
                try {
                    readableByteChannel = Channels.newChannel(callable.call());
                } catch (Exception e10) {
                    throw new IOException("inputStreamCallable exception on call", e10);
                }
            } else {
                throw new IllegalStateException("copyFromAssetPath, copyFromFile and copyFromInputStream are all null!");
            }
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f4258a.getCacheDir());
        createTempFile.deleteOnExit();
        d.a(readableByteChannel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
            d(createTempFile, z10);
            if (!createTempFile.renameTo(file)) {
                throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
            }
            return;
        }
        throw new IOException("Failed to create directories for " + file.getAbsolutePath());
    }

    private void d(File file, boolean z10) {
        i iVar = this.f4264g;
        if (iVar != null) {
            RoomDatabase.d dVar = iVar.f4234f;
        }
    }

    private void i(boolean z10) {
        String databaseName = getDatabaseName();
        File databasePath = this.f4258a.getDatabasePath(databaseName);
        i iVar = this.f4264g;
        a aVar = new a(databaseName, this.f4258a.getFilesDir(), iVar == null || iVar.f4240l);
        try {
            aVar.b();
            if (!databasePath.exists()) {
                try {
                    c(databasePath, z10);
                    aVar.c();
                    return;
                } catch (IOException e10) {
                    throw new RuntimeException("Unable to copy database file.", e10);
                }
            } else if (this.f4264g == null) {
                aVar.c();
                return;
            } else {
                try {
                    int c10 = h1.c.c(databasePath);
                    int i10 = this.f4262e;
                    if (c10 == i10) {
                        aVar.c();
                        return;
                    } else if (this.f4264g.a(c10, i10)) {
                        aVar.c();
                        return;
                    } else {
                        if (this.f4258a.deleteDatabase(databaseName)) {
                            try {
                                c(databasePath, z10);
                            } catch (IOException e11) {
                                Log.w("ROOM", "Unable to copy database file.", e11);
                            }
                        } else {
                            Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                        }
                        aVar.c();
                        return;
                    }
                } catch (IOException e12) {
                    Log.w("ROOM", "Unable to read database version.", e12);
                    aVar.c();
                    return;
                }
            }
        } catch (Throwable th2) {
            aVar.c();
            throw th2;
        }
        aVar.c();
        throw th2;
    }

    @Override // i1.c
    public synchronized b S() {
        if (!this.f4265h) {
            i(true);
            this.f4265h = true;
        }
        return this.f4263f.S();
    }

    @Override // i1.c, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f4263f.close();
        this.f4265h = false;
    }

    @Override // i1.c
    public String getDatabaseName() {
        return this.f4263f.getDatabaseName();
    }

    @Override // androidx.room.j
    public c getDelegate() {
        return this.f4263f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(i iVar) {
        this.f4264g = iVar;
    }

    @Override // i1.c
    public void setWriteAheadLoggingEnabled(boolean z10) {
        this.f4263f.setWriteAheadLoggingEnabled(z10);
    }
}
