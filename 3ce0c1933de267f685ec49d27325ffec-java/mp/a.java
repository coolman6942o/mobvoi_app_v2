package mp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import okio.n;
import okio.o;
import okio.r;
import okio.t;
/* compiled from: FileSystem.kt */
/* loaded from: classes3.dex */
public interface a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30844a = new C0401a.C0402a();

    /* compiled from: FileSystem.kt */
    /* renamed from: mp.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0401a {

        /* compiled from: FileSystem.kt */
        /* renamed from: mp.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        private static final class C0402a implements a {
            @Override // mp.a
            public t a(File file) throws FileNotFoundException {
                i.f(file, "file");
                return n.k(file);
            }

            @Override // mp.a
            public r b(File file) throws FileNotFoundException {
                i.f(file, "file");
                try {
                    return o.g(file, false, 1, null);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return o.g(file, false, 1, null);
                }
            }

            @Override // mp.a
            public void c(File directory) throws IOException {
                i.f(directory, "directory");
                File[] listFiles = directory.listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        i.e(file, "file");
                        if (file.isDirectory()) {
                            c(file);
                        }
                        if (!file.delete()) {
                            throw new IOException("failed to delete " + file);
                        }
                    }
                    return;
                }
                throw new IOException("not a readable directory: " + directory);
            }

            @Override // mp.a
            public boolean d(File file) {
                i.f(file, "file");
                return file.exists();
            }

            @Override // mp.a
            public void e(File from, File to2) throws IOException {
                i.f(from, "from");
                i.f(to2, "to");
                f(to2);
                if (!from.renameTo(to2)) {
                    throw new IOException("failed to rename " + from + " to " + to2);
                }
            }

            @Override // mp.a
            public void f(File file) throws IOException {
                i.f(file, "file");
                if (!file.delete() && file.exists()) {
                    throw new IOException("failed to delete " + file);
                }
            }

            @Override // mp.a
            public r g(File file) throws FileNotFoundException {
                i.f(file, "file");
                try {
                    return n.a(file);
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    return n.a(file);
                }
            }

            @Override // mp.a
            public long h(File file) {
                i.f(file, "file");
                return file.length();
            }

            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private C0401a() {
        }

        public /* synthetic */ C0401a(f fVar) {
            this();
        }
    }

    static {
        new C0401a(null);
    }

    t a(File file) throws FileNotFoundException;

    r b(File file) throws FileNotFoundException;

    void c(File file) throws IOException;

    boolean d(File file);

    void e(File file, File file2) throws IOException;

    void f(File file) throws IOException;

    r g(File file) throws FileNotFoundException;

    long h(File file);
}
