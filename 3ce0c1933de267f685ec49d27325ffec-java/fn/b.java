package fn;

import gn.u;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
/* loaded from: classes2.dex */
public class b extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private File f27128a;

    /* renamed from: b  reason: collision with root package name */
    private URL f27129b;

    /* renamed from: c  reason: collision with root package name */
    private int f27130c;

    /* renamed from: d  reason: collision with root package name */
    private int f27131d;

    /* renamed from: e  reason: collision with root package name */
    private int f27132e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f27133f = false;

    /* renamed from: g  reason: collision with root package name */
    private c f27134g;

    public b(c cVar, URL url, File file, int i10, int i11, int i12) {
        this.f27131d = -1;
        this.f27129b = url;
        this.f27128a = file;
        this.f27130c = i10;
        this.f27134g = cVar;
        this.f27131d = i12;
        this.f27132e = i11;
    }

    private static void b(String str) {
        u.d("DownloadThread", str);
    }

    public long a() {
        return this.f27132e;
    }

    public boolean c() {
        return this.f27133f;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.f27132e < this.f27130c) {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) this.f27129b.openConnection();
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setRequestProperty("Accept", "image/gif, image/jpeg, image/pjpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, */*");
                httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                httpURLConnection.setRequestProperty("Referer", this.f27129b.toString());
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                int i10 = this.f27130c;
                int i11 = this.f27131d;
                int i12 = ((i11 - 1) * i10) + this.f27132e;
                int i13 = (i10 * i11) - 1;
                httpURLConnection.setRequestProperty("Range", "bytes=" + i12 + "-" + i13);
                httpURLConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.2; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                InputStream inputStream = httpURLConnection.getInputStream();
                byte[] bArr = new byte[1024];
                b("Thread " + this.f27131d + " start download from position " + i12);
                RandomAccessFile randomAccessFile = new RandomAccessFile(this.f27128a, "rwd");
                randomAccessFile.seek((long) i12);
                while (true) {
                    int read = inputStream.read(bArr, 0, 1024);
                    if (read != -1) {
                        randomAccessFile.write(bArr, 0, read);
                        int i14 = this.f27132e + read;
                        this.f27132e = i14;
                        this.f27134g.d(this.f27131d, i14);
                        this.f27134g.c(read);
                    } else {
                        randomAccessFile.close();
                        inputStream.close();
                        b("Thread " + this.f27131d + " download finish");
                        this.f27133f = true;
                        return;
                    }
                }
            } catch (Exception e10) {
                this.f27132e = -1;
                b("Thread " + this.f27131d + ":" + e10);
            }
        }
    }
}
