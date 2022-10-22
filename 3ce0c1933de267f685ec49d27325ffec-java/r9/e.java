package r9;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.liulishuo.filedownloader.download.c;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadSecurityException;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import j9.b;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import q9.a;
/* compiled from: FileDownloadUtils.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static int f33479a = 65536;

    /* renamed from: b  reason: collision with root package name */
    private static long f33480b = 2000;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f33481c;

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f33482d = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"([^\"]*)\"");

    /* renamed from: e  reason: collision with root package name */
    private static final Pattern f33483e = Pattern.compile("attachment;\\s*filename\\s*=\\s*(.*)");

    public static String A(String str) {
        return "FileDownloader-" + str;
    }

    public static boolean B(int i10, b bVar) {
        if (i10 == 206 || i10 == 1) {
            return true;
        }
        return "bytes".equals(bVar.f("Accept-Ranges"));
    }

    public static boolean C(int i10, FileDownloadModel fileDownloadModel) {
        return D(i10, fileDownloadModel, null);
    }

    public static boolean D(int i10, FileDownloadModel fileDownloadModel, Boolean bool) {
        if (fileDownloadModel == null) {
            if (c.f33469a) {
                c.a(e.class, "can't continue %d model == null", Integer.valueOf(i10));
            }
            return false;
        } else if (fileDownloadModel.j() != null) {
            return E(i10, fileDownloadModel, fileDownloadModel.j(), bool);
        } else {
            if (c.f33469a) {
                c.a(e.class, "can't continue %d temp path == null", Integer.valueOf(i10));
            }
            return false;
        }
    }

    public static boolean E(int i10, FileDownloadModel fileDownloadModel, String str, Boolean bool) {
        if (str != null) {
            File file = new File(str);
            boolean exists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (exists && !isDirectory) {
                long length = file.length();
                long g10 = fileDownloadModel.g();
                if (fileDownloadModel.a() > 1 || g10 != 0) {
                    long k10 = fileDownloadModel.k();
                    if (length < g10 || (k10 != -1 && (length > k10 || g10 >= k10))) {
                        if (!c.f33469a) {
                            return false;
                        }
                        c.a(e.class, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i10), Long.valueOf(length), Long.valueOf(g10), Long.valueOf(k10));
                        return false;
                    } else if (bool == null || bool.booleanValue() || k10 != length) {
                        return true;
                    } else {
                        if (!c.f33469a) {
                            return false;
                        }
                        c.a(e.class, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i10));
                        return false;
                    }
                } else if (!c.f33469a) {
                    return false;
                } else {
                    c.a(e.class, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i10));
                    return false;
                }
            } else if (!c.f33469a) {
                return false;
            } else {
                c.a(e.class, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i10), Boolean.valueOf(exists), Boolean.valueOf(isDirectory));
                return false;
            }
        } else if (!c.f33469a) {
            return false;
        } else {
            c.a(e.class, "can't continue %d path = null", Integer.valueOf(i10));
            return false;
        }
    }

    public static boolean F(Context context) {
        Boolean bool = f33481c;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z10 = false;
        if (!d.a().f33473d) {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it.next();
                        if (next.pid == myPid) {
                            z10 = next.processName.endsWith(":filedownloader");
                            break;
                        }
                    }
                } else {
                    c.i(e.class, "The running app process info list from ActivityManager is null or empty, maybe current App is not running.", new Object[0]);
                    return false;
                }
            } else {
                c.i(e.class, "fail to get the activity manager!", new Object[0]);
                return false;
            }
        } else {
            z10 = true;
        }
        Boolean valueOf = Boolean.valueOf(z10);
        f33481c = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean G(String str) {
        return true;
    }

    public static boolean H(long j10, long j11) {
        return j10 > ((long) v()) && j11 > w();
    }

    public static boolean I() {
        ConnectivityManager connectivityManager = (ConnectivityManager) b.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            c.i(e.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static void J(Context context) {
        File t10 = t(context);
        try {
            t10.getParentFile().mkdirs();
            t10.createNewFile();
        } catch (IOException e10) {
            e10.printStackTrace();
        }
    }

    public static String K(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb2 = new StringBuilder(digest.length * 2);
            for (byte b10 : digest) {
                int i10 = b10 & 255;
                if (i10 < 16) {
                    sb2.append("0");
                }
                sb2.append(Integer.toHexString(i10));
            }
            return sb2.toString();
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e10);
        } catch (NoSuchAlgorithmException e11) {
            throw new RuntimeException("Huh, MD5 should be supported?", e11);
        }
    }

    public static String L(String str) {
        Matcher matcher;
        if (str == null) {
            return null;
        }
        try {
            matcher = f33482d.matcher(str);
        } catch (IllegalStateException unused) {
        }
        if (matcher.find()) {
            return matcher.group(1);
        }
        Matcher matcher2 = f33483e.matcher(str);
        if (matcher2.find()) {
            return matcher2.group(1);
        }
        return null;
    }

    public static long M(String str) {
        if (!(str == null || str.length() == 0)) {
            try {
                Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(str);
                if (matcher.find()) {
                    return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                }
            } catch (Exception e10) {
                c.c(e.class, e10, "parse content length from content range error", new Object[0]);
            }
        }
        return -1L;
    }

    public static long N(String str) {
        if (str == null) {
            return -1L;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException unused) {
                c.i(e.class, "parse instance length failed with %s", str);
            }
        }
        return -1L;
    }

    public static void O(int i10) throws IllegalAccessException {
        if (F(b.a())) {
            f33479a = i10;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
    }

    public static void P(long j10) throws IllegalAccessException {
        if (F(b.a())) {
            f33480b = j10;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
    }

    public static boolean a(String str) {
        return b.a().checkCallingOrSelfPermission(str) == 0;
    }

    public static long b(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static a c(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("found invalid internal destination path, empty");
        } else if (G(str)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                throw new RuntimeException(n("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
            } else if (file.exists() || file.createNewFile()) {
                return c.i().b(file);
            } else {
                throw new IOException(n("create new file error  %s", file.getAbsolutePath()));
            }
        } else {
            throw new RuntimeException(n("found invalid internal destination filename %s", str));
        }
    }

    public static String d() {
        return n("FileDownloader/%s", "1.7.4");
    }

    public static void e(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void f(String str, String str2) {
        g(str2);
        e(str);
    }

    public static void g(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static long h(int i10, b bVar) {
        long b10 = b(bVar.f("Content-Length"));
        String f10 = bVar.f("Transfer-Encoding");
        if (b10 >= 0) {
            return b10;
        }
        if (!(f10 != null && f10.equals("chunked"))) {
            if (!d.a().f33472c) {
                throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
            } else if (c.f33469a) {
                c.a(e.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i10));
            }
        }
        return -1L;
    }

    public static long i(b bVar) {
        long M = M(s(bVar));
        if (M < 0) {
            return -1L;
        }
        return M;
    }

    public static String j(int i10, b bVar) {
        if (bVar != null) {
            String f10 = bVar.f("Etag");
            if (c.f33469a) {
                c.a(e.class, "etag find %s for task(%d)", f10, Integer.valueOf(i10));
            }
            return f10;
        }
        throw new RuntimeException("connection is null when findEtag");
    }

    public static String k(b bVar, String str) throws FileDownloadSecurityException {
        String L = L(bVar.f("Content-Disposition"));
        if (TextUtils.isEmpty(L)) {
            return o(str);
        }
        if (!L.contains("../")) {
            return L;
        }
        throw new FileDownloadSecurityException(n("The filename [%s] from the response is not allowable, because it contains '../', which can raise the directory traversal vulnerability", L));
    }

    public static long l(b bVar) {
        long m10 = m(bVar);
        if (m10 < 0) {
            c.i(e.class, "don't get instance length fromContent-Range header", new Object[0]);
            m10 = -1;
        }
        if (m10 != 0 || !d.a().f33477h) {
            return m10;
        }
        return -1L;
    }

    public static long m(b bVar) {
        return N(s(bVar));
    }

    public static String n(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    public static String o(String str) {
        return K(str);
    }

    public static String p(String str, String str2) {
        if (str2 == null) {
            throw new IllegalStateException("can't generate real path, the file name is null");
        } else if (str != null) {
            return n("%s%s%s", str, File.separator, str2);
        } else {
            throw new IllegalStateException("can't generate real path, the directory is null");
        }
    }

    public static int q(String str, String str2) {
        return c.i().h().a(str, str2, false);
    }

    public static int r(String str, String str2, boolean z10) {
        return c.i().h().a(str, str2, z10);
    }

    private static String s(b bVar) {
        return bVar.f("Content-Range");
    }

    public static File t(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + "filedownloader", ".old_file_converted");
    }

    public static long u(String str) {
        StatFs statFs = new StatFs(str);
        if (Build.VERSION.SDK_INT >= 18) {
            return statFs.getAvailableBytes();
        }
        return statFs.getAvailableBlocks() * statFs.getBlockSize();
    }

    public static int v() {
        return f33479a;
    }

    public static long w() {
        return f33480b;
    }

    public static String x(String str) {
        int length = str.length();
        int i10 = 2;
        int i11 = (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf != -1 || i11 <= 0) {
            i10 = lastIndexOf;
        }
        if (i10 == -1) {
            return null;
        }
        char charAt = str.charAt(length - 1);
        char c10 = File.separatorChar;
        if (charAt == c10) {
            return null;
        }
        if (str.indexOf(c10) == i10 && str.charAt(i11) == File.separatorChar) {
            return str.substring(0, i10 + 1);
        }
        return str.substring(0, i10);
    }

    public static String y(String str, boolean z10, String str2) {
        if (str == null) {
            return null;
        }
        if (!z10) {
            return str;
        }
        if (str2 == null) {
            return null;
        }
        return p(str, str2);
    }

    public static String z(String str) {
        return n("%s.temp", str);
    }
}
