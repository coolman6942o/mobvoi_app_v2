package bn;

import com.huawei.hms.framework.common.ContainerUtils;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private String f5295a = "utf-8";

    /* renamed from: b  reason: collision with root package name */
    private String f5296b = null;

    /* renamed from: c  reason: collision with root package name */
    private Integer f5297c = null;

    private URLConnection b(URL url) {
        Integer num;
        String str = this.f5296b;
        return (str == null || (num = this.f5297c) == null) ? url.openConnection() : url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, num.intValue())));
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(String str, Map map) {
        Throwable th2;
        InputStream inputStream;
        BufferedReader bufferedReader;
        OutputStream outputStream;
        InputStreamReader inputStreamReader;
        StringBuffer stringBuffer = new StringBuffer();
        if (map != null) {
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                String str3 = map.get(str2) != null ? (String) map.get(str2) : "";
                stringBuffer.append(str2);
                stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
                stringBuffer.append(str3);
                if (it.hasNext()) {
                    stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                }
            }
        }
        System.out.println("POST parameter : " + stringBuffer.toString());
        HttpURLConnection httpURLConnection = (HttpURLConnection) b(new URL(str));
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Accept-Charset", this.f5295a);
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(stringBuffer.length()));
        StringBuffer stringBuffer2 = new StringBuffer();
        OutputStreamWriter outputStreamWriter = null;
        try {
            outputStream = httpURLConnection.getOutputStream();
            try {
                OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(outputStream);
                try {
                    outputStreamWriter2.write(stringBuffer.toString());
                    outputStreamWriter2.flush();
                    if (httpURLConnection.getResponseCode() < 300) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            inputStreamReader = new InputStreamReader(inputStream);
                            try {
                                bufferedReader = new BufferedReader(inputStreamReader);
                                while (true) {
                                    try {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        }
                                        stringBuffer2.append(readLine);
                                    } catch (Throwable th3) {
                                        th2 = th3;
                                        outputStreamWriter = outputStreamWriter2;
                                        if (outputStreamWriter != null) {
                                        }
                                        if (outputStream != null) {
                                        }
                                        if (bufferedReader != null) {
                                        }
                                        if (inputStreamReader != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        throw th2;
                                    }
                                }
                                outputStreamWriter2.close();
                                if (outputStream != null) {
                                    outputStream.close();
                                }
                                bufferedReader.close();
                                inputStreamReader.close();
                                if (inputStream != null) {
                                    inputStream.close();
                                }
                                return stringBuffer2.toString();
                            } catch (Throwable th4) {
                                th2 = th4;
                                bufferedReader = null;
                            }
                        } catch (Throwable th5) {
                            th2 = th5;
                            inputStreamReader = null;
                            bufferedReader = null;
                            outputStreamWriter = outputStreamWriter2;
                            if (outputStreamWriter != null) {
                                outputStreamWriter.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            throw th2;
                        }
                    } else {
                        throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
                    }
                } catch (Throwable th6) {
                    th2 = th6;
                    inputStream = null;
                }
            } catch (Throwable th7) {
                th2 = th7;
                inputStream = null;
                inputStreamReader = null;
                bufferedReader = null;
                if (outputStreamWriter != null) {
                }
                if (outputStream != null) {
                }
                if (bufferedReader != null) {
                }
                if (inputStreamReader != null) {
                }
                if (inputStream != null) {
                }
                throw th2;
            }
        } catch (Throwable th8) {
            th2 = th8;
            outputStream = null;
        }
    }
}
