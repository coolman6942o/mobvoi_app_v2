package com.tencent.mm.opensdk.diffdev.a;

import com.tencent.mm.opensdk.utils.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes2.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:116:0x011f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0124 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0129 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0136 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0102 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x00d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v31 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v13, types: [java.net.HttpURLConnection] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str) {
        ByteArrayOutputStream byteArrayOutputStream;
        InputStream inputStream;
        Throwable th2;
        HttpURLConnection httpURLConnection;
        ByteArrayOutputStream byteArrayOutputStream2;
        InputStream inputStream2;
        MalformedURLException e10;
        HttpURLConnection httpURLConnection2;
        ByteArrayOutputStream byteArrayOutputStream3;
        HttpURLConnection httpURLConnection3;
        ByteArrayOutputStream byteArrayOutputStream4;
        InputStream inputStream3;
        IOException e11;
        HttpURLConnection httpURLConnection4;
        ByteArrayOutputStream byteArrayOutputStream5;
        HttpURLConnection httpURLConnection5;
        ByteArrayOutputStream byteArrayOutputStream6;
        InputStream inputStream4;
        Exception e12;
        HttpURLConnection httpURLConnection6;
        ByteArrayOutputStream byteArrayOutputStream7;
        HttpURLConnection httpURLConnection7 = null;
        if (str != 0) {
            try {
                if (str.length() != 0) {
                    try {
                        str = (HttpURLConnection) new URL(str).openConnection();
                        try {
                            if (str == 0) {
                                Log.e("MicroMsg.SDK.NetUtil", "open connection failed.");
                                if (str != 0) {
                                    try {
                                        str.disconnect();
                                    } catch (Throwable unused) {
                                    }
                                }
                                return null;
                            }
                            str.setRequestMethod("GET");
                            str.setConnectTimeout(60000);
                            str.setReadTimeout(60000);
                            if (str.getResponseCode() >= 300) {
                                Log.e("MicroMsg.SDK.NetUtil", "httpURLConnectionGet 300");
                                try {
                                    str.disconnect();
                                } catch (Throwable unused2) {
                                }
                                return null;
                            }
                            InputStream inputStream5 = str.getInputStream();
                            try {
                                ByteArrayOutputStream byteArrayOutputStream8 = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int read = inputStream5.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream8.write(bArr, 0, read);
                                    }
                                    byte[] byteArray = byteArrayOutputStream8.toByteArray();
                                    Log.d("MicroMsg.SDK.NetUtil", "httpGet end");
                                    try {
                                        str.disconnect();
                                    } catch (Throwable unused3) {
                                    }
                                    try {
                                        inputStream5.close();
                                    } catch (Throwable unused4) {
                                    }
                                    try {
                                        byteArrayOutputStream8.close();
                                    } catch (Throwable unused5) {
                                    }
                                    return byteArray;
                                } catch (MalformedURLException e13) {
                                    e10 = e13;
                                    inputStream2 = inputStream5;
                                    byteArrayOutputStream2 = byteArrayOutputStream8;
                                    httpURLConnection = str;
                                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e10.getMessage());
                                    if (httpURLConnection != null) {
                                    }
                                    if (inputStream2 != 0) {
                                    }
                                    if (byteArrayOutputStream2 != null) {
                                    }
                                    return null;
                                } catch (IOException e14) {
                                    e11 = e14;
                                    inputStream3 = inputStream5;
                                    byteArrayOutputStream4 = byteArrayOutputStream8;
                                    httpURLConnection3 = str;
                                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e11.getMessage());
                                    if (httpURLConnection3 != null) {
                                    }
                                    if (inputStream3 != 0) {
                                    }
                                    if (byteArrayOutputStream4 != null) {
                                    }
                                    return null;
                                } catch (Exception e15) {
                                    e12 = e15;
                                    inputStream4 = inputStream5;
                                    byteArrayOutputStream6 = byteArrayOutputStream8;
                                    httpURLConnection5 = str;
                                    Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e12.getMessage());
                                    if (httpURLConnection5 != null) {
                                    }
                                    if (inputStream4 != 0) {
                                    }
                                    if (byteArrayOutputStream6 != null) {
                                    }
                                    return null;
                                } catch (Throwable th3) {
                                    th2 = th3;
                                    httpURLConnection7 = str;
                                    byteArrayOutputStream = byteArrayOutputStream8;
                                    inputStream = inputStream5;
                                    if (httpURLConnection7 != null) {
                                        try {
                                            httpURLConnection7.disconnect();
                                        } catch (Throwable unused6) {
                                        }
                                    }
                                    if (inputStream != null) {
                                        try {
                                            inputStream.close();
                                        } catch (Throwable unused7) {
                                        }
                                    }
                                    if (byteArrayOutputStream != null) {
                                        try {
                                            byteArrayOutputStream.close();
                                        } catch (Throwable unused8) {
                                        }
                                    }
                                    throw th2;
                                }
                            } catch (MalformedURLException e16) {
                                e10 = e16;
                                byteArrayOutputStream2 = null;
                                inputStream2 = inputStream5;
                                httpURLConnection = str;
                            } catch (IOException e17) {
                                e11 = e17;
                                byteArrayOutputStream4 = null;
                                inputStream3 = inputStream5;
                                httpURLConnection3 = str;
                            } catch (Exception e18) {
                                e12 = e18;
                                byteArrayOutputStream6 = null;
                                inputStream4 = inputStream5;
                                httpURLConnection5 = str;
                            } catch (Throwable th4) {
                                th2 = th4;
                                byteArrayOutputStream = null;
                                inputStream = inputStream5;
                                httpURLConnection7 = str;
                                if (httpURLConnection7 != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (byteArrayOutputStream != null) {
                                }
                                throw th2;
                            }
                        } catch (MalformedURLException e19) {
                            e10 = e19;
                            byteArrayOutputStream3 = null;
                            httpURLConnection2 = str;
                            byteArrayOutputStream2 = byteArrayOutputStream3;
                            inputStream2 = byteArrayOutputStream3;
                            httpURLConnection = httpURLConnection2;
                            Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e10.getMessage());
                            if (httpURLConnection != null) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (Throwable unused9) {
                                }
                            }
                            if (inputStream2 != 0) {
                                try {
                                    inputStream2.close();
                                } catch (Throwable unused10) {
                                }
                            }
                            if (byteArrayOutputStream2 != null) {
                                try {
                                    byteArrayOutputStream2.close();
                                } catch (Throwable unused11) {
                                }
                            }
                            return null;
                        } catch (IOException e20) {
                            e11 = e20;
                            byteArrayOutputStream5 = null;
                            httpURLConnection4 = str;
                            byteArrayOutputStream4 = byteArrayOutputStream5;
                            inputStream3 = byteArrayOutputStream5;
                            httpURLConnection3 = httpURLConnection4;
                            Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e11.getMessage());
                            if (httpURLConnection3 != null) {
                                try {
                                    httpURLConnection3.disconnect();
                                } catch (Throwable unused12) {
                                }
                            }
                            if (inputStream3 != 0) {
                                try {
                                    inputStream3.close();
                                } catch (Throwable unused13) {
                                }
                            }
                            if (byteArrayOutputStream4 != null) {
                                try {
                                    byteArrayOutputStream4.close();
                                } catch (Throwable unused14) {
                                }
                            }
                            return null;
                        } catch (Exception e21) {
                            e12 = e21;
                            byteArrayOutputStream7 = null;
                            httpURLConnection6 = str;
                            byteArrayOutputStream6 = byteArrayOutputStream7;
                            inputStream4 = byteArrayOutputStream7;
                            httpURLConnection5 = httpURLConnection6;
                            Log.e("MicroMsg.SDK.NetUtil", "httpGet ex:" + e12.getMessage());
                            if (httpURLConnection5 != null) {
                                try {
                                    httpURLConnection5.disconnect();
                                } catch (Throwable unused15) {
                                }
                            }
                            if (inputStream4 != 0) {
                                try {
                                    inputStream4.close();
                                } catch (Throwable unused16) {
                                }
                            }
                            if (byteArrayOutputStream6 != null) {
                                try {
                                    byteArrayOutputStream6.close();
                                } catch (Throwable unused17) {
                                }
                            }
                            return null;
                        } catch (Throwable th5) {
                            th2 = th5;
                            inputStream = null;
                            byteArrayOutputStream = null;
                        }
                    } catch (MalformedURLException e22) {
                        e10 = e22;
                        httpURLConnection2 = null;
                        byteArrayOutputStream3 = null;
                    } catch (IOException e23) {
                        e11 = e23;
                        httpURLConnection4 = null;
                        byteArrayOutputStream5 = null;
                    } catch (Exception e24) {
                        e12 = e24;
                        httpURLConnection6 = null;
                        byteArrayOutputStream7 = null;
                    } catch (Throwable th6) {
                        th2 = th6;
                        inputStream = null;
                        byteArrayOutputStream = null;
                    }
                }
            } catch (Throwable th7) {
                th2 = th7;
            }
        }
        Log.e("MicroMsg.SDK.NetUtil", "httpGet, url is null");
        return null;
    }
}
