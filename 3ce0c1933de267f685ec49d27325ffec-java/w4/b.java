package w4;

import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;
/* compiled from: RuntimeCompat.java */
/* loaded from: classes.dex */
final class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RuntimeCompat.java */
    /* loaded from: classes.dex */
    public class a implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Pattern f36002a;

        a(Pattern pattern) {
            this.f36002a = pattern;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.f36002a.matcher(str).matches();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        return Build.VERSION.SDK_INT < 17 ? Math.max(b(), availableProcessors) : availableProcessors;
    }

    /* JADX WARN: Finally extract failed */
    private static int b() {
        File[] fileArr;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            fileArr = new File("/sys/devices/system/cpu/").listFiles(new a(Pattern.compile("cpu[0-9]+")));
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        } catch (Throwable th2) {
            try {
                if (Log.isLoggable("GlideRuntimeCompat", 6)) {
                    Log.e("GlideRuntimeCompat", "Failed to calculate accurate cpu count", th2);
                }
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                fileArr = null;
            } catch (Throwable th3) {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
                throw th3;
            }
        }
        return Math.max(1, fileArr != null ? fileArr.length : 0);
    }
}
