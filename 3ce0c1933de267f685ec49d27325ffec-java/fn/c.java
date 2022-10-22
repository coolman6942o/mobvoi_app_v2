package fn;

import android.content.Context;
import android.content.Intent;
import gn.u;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: j  reason: collision with root package name */
    public static String f27135j = "";

    /* renamed from: a  reason: collision with root package name */
    private Context f27136a;

    /* renamed from: b  reason: collision with root package name */
    private d f27137b;

    /* renamed from: d  reason: collision with root package name */
    private int f27139d;

    /* renamed from: e  reason: collision with root package name */
    private b[] f27140e;

    /* renamed from: f  reason: collision with root package name */
    private File f27141f;

    /* renamed from: h  reason: collision with root package name */
    private int f27143h;

    /* renamed from: i  reason: collision with root package name */
    private String f27144i;

    /* renamed from: c  reason: collision with root package name */
    private int f27138c = 0;

    /* renamed from: g  reason: collision with root package name */
    private final Map<Integer, Integer> f27142g = new ConcurrentHashMap();

    public c(Context context, String str, File file, int i10) {
        int i11 = 0;
        this.f27139d = 0;
        try {
            this.f27136a = context;
            this.f27144i = str;
            this.f27137b = new d(context);
            URL url = new URL(this.f27144i);
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f27140e = new b[i10];
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
            httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
            httpURLConnection.setRequestProperty("Referer", str);
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            httpURLConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
            httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            httpURLConnection.connect();
            g(httpURLConnection);
            if (httpURLConnection.getResponseCode() == 200) {
                this.f27139d = httpURLConnection.getContentLength();
                u.d("FileDownloader", "fileSize  ==" + this.f27139d);
                if (this.f27139d > 0) {
                    String b10 = b(httpURLConnection);
                    f27135j = b10;
                    this.f27141f = new File(file, b10);
                    u.a("download", "filename =" + b10);
                    Map<Integer, Integer> c10 = this.f27137b.c(str);
                    if (c10.size() > 0) {
                        for (Map.Entry<Integer, Integer> entry : c10.entrySet()) {
                            this.f27142g.put(entry.getKey(), entry.getValue());
                        }
                    }
                    if (this.f27142g.size() == this.f27140e.length) {
                        while (i11 < this.f27140e.length) {
                            i11++;
                            this.f27138c += this.f27142g.get(Integer.valueOf(i11)).intValue();
                        }
                    }
                    int i12 = this.f27139d;
                    b[] bVarArr = this.f27140e;
                    this.f27143h = i12 % bVarArr.length == 0 ? i12 / bVarArr.length : (i12 / bVarArr.length) + 1;
                    return;
                }
                throw new RuntimeException("Unkown file size ");
            }
            throw new RuntimeException("server no response ");
        } catch (Exception e10) {
            e(e10.toString());
        }
    }

    private static void e(String str) {
        u.d("FileDownloader", str);
    }

    public static Map<String, String> f(HttpURLConnection httpURLConnection) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i10 = 0;
        while (true) {
            String headerField = httpURLConnection.getHeaderField(i10);
            if (headerField == null) {
                return linkedHashMap;
            }
            linkedHashMap.put(httpURLConnection.getHeaderFieldKey(i10), headerField);
            i10++;
        }
    }

    public static void g(HttpURLConnection httpURLConnection) {
        for (Map.Entry<String, String> entry : f(httpURLConnection).entrySet()) {
            e((entry.getKey() != null ? entry.getKey() + ":" : "") + entry.getValue());
        }
    }

    public int a() {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(this.f27141f, "rw");
            int i10 = this.f27139d;
            if (i10 > 0) {
                randomAccessFile.setLength(i10);
            }
            randomAccessFile.close();
            URL url = new URL(this.f27144i);
            if (this.f27142g.size() != this.f27140e.length) {
                this.f27142g.clear();
                int i11 = 0;
                while (i11 < this.f27140e.length) {
                    i11++;
                    this.f27142g.put(Integer.valueOf(i11), 0);
                }
            }
            int i12 = 0;
            while (i12 < this.f27140e.length) {
                int i13 = i12 + 1;
                if (this.f27142g.get(Integer.valueOf(i13)).intValue() >= this.f27143h || this.f27138c >= this.f27139d) {
                    this.f27140e[i12] = null;
                } else {
                    this.f27140e[i12] = new b(this, url, this.f27141f, this.f27143h, this.f27142g.get(Integer.valueOf(i13)).intValue(), i13);
                    this.f27140e[i12].setPriority(7);
                    this.f27140e[i12].start();
                }
                i12 = i13;
            }
            this.f27137b.b(this.f27144i, this.f27142g);
            boolean z10 = true;
            while (z10) {
                Thread.sleep(900L);
                z10 = false;
                int i14 = 0;
                while (true) {
                    b[] bVarArr = this.f27140e;
                    if (i14 < bVarArr.length) {
                        if (bVarArr[i14] != null && !bVarArr[i14].c()) {
                            if (this.f27140e[i14].a() == -1) {
                                int i15 = i14 + 1;
                                this.f27140e[i14] = new b(this, url, this.f27141f, this.f27143h, this.f27142g.get(Integer.valueOf(i15)).intValue(), i15);
                                this.f27140e[i14].setPriority(7);
                                this.f27140e[i14].start();
                            }
                            z10 = true;
                        }
                        i14++;
                    }
                }
            }
            this.f27137b.a(this.f27144i);
            this.f27136a.sendBroadcast(new Intent("img_download_finish_action"));
            u.d("DownloadThread", "下载成功");
            return this.f27138c;
        } catch (Exception e10) {
            e(e10.toString());
            u.d("DownloadThread", "下载失败  Exception =" + e10.toString());
            this.f27136a.sendBroadcast(new Intent("img_download_fail_action"));
            throw new Exception("file download fail");
        }
    }

    public String b(HttpURLConnection httpURLConnection) {
        String str = this.f27144i;
        String substring = str.substring(str.lastIndexOf(47) + 1);
        if (substring != null && !"".equals(substring.trim())) {
            return substring;
        }
        int i10 = 0;
        while (true) {
            String headerField = httpURLConnection.getHeaderField(i10);
            if (headerField == null) {
                return UUID.randomUUID() + ".tmp";
            }
            if ("content-disposition".equals(httpURLConnection.getHeaderFieldKey(i10).toLowerCase())) {
                Matcher matcher = Pattern.compile(".*filename=(.*)").matcher(headerField.toLowerCase());
                if (matcher.find()) {
                    return matcher.group(1);
                }
            }
            i10++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void c(int i10) {
        this.f27138c += i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void d(int i10, int i11) {
        this.f27142g.put(Integer.valueOf(i10), Integer.valueOf(i11));
        this.f27137b.d(this.f27144i, this.f27142g);
    }
}
