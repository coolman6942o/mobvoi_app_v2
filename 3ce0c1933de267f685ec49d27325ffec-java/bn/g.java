package bn;

import com.yc.pedometer.dial.OnlineDialUtil;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes2.dex */
public class g {
    public static int a(String str, String str2, String str3) {
        String str4;
        StringBuilder sb2;
        IOException iOException;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.connect();
            int contentLength = httpURLConnection.getContentLength();
            System.out.println("file length---->" + contentLength);
            f fVar = new f();
            if (fVar.b(str2 + str3)) {
                fVar.a(str2 + str3);
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            File file = new File(str2 + str3);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            int i10 = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    i10 += read;
                    fileOutputStream.write(bArr, 0, read);
                    OnlineDialUtil.b("下载了-------> " + ((i10 * 100) / contentLength) + "%\n");
                } else {
                    bufferedInputStream.close();
                    fileOutputStream.close();
                    return 0;
                }
            }
        } catch (MalformedURLException e10) {
            e10.printStackTrace();
            str4 = "MalformedURLException =";
            iOException = e10;
            sb2 = new StringBuilder();
            sb2.append(str4);
            sb2.append(iOException);
            OnlineDialUtil.b(sb2.toString());
            return -1;
        } catch (IOException e11) {
            e11.printStackTrace();
            str4 = "IOException =";
            iOException = e11;
            sb2 = new StringBuilder();
            sb2.append(str4);
            sb2.append(iOException);
            OnlineDialUtil.b(sb2.toString());
            return -1;
        }
    }
}
