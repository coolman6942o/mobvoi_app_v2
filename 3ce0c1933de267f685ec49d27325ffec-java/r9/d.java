package r9;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/* compiled from: FileDownloadProperties.java */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public final int f33470a;

    /* renamed from: b  reason: collision with root package name */
    public final long f33471b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f33472c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f33473d;

    /* renamed from: e  reason: collision with root package name */
    public final int f33474e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f33475f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f33476g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f33477h;

    /* compiled from: FileDownloadProperties.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static final d f33478a = new d();
    }

    public static d a() {
        return b.f33478a;
    }

    public static int b(int i10) {
        if (i10 > 12) {
            c.i(d.class, "require the count of network thread  is %d, what is more than the max valid count(%d), so adjust to %d auto", Integer.valueOf(i10), 12, 12);
            return 12;
        } else if (i10 >= 1) {
            return i10;
        } else {
            c.i(d.class, "require the count of network thread  is %d, what is less than the min valid count(%d), so adjust to %d auto", Integer.valueOf(i10), 1, 1);
            return 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ad A[Catch: all -> 0x0294, TryCatch #5 {all -> 0x0294, blocks: (B:7:0x0036, B:8:0x003d, B:9:0x0041, B:10:0x0045, B:11:0x0049, B:12:0x004d, B:13:0x0051, B:14:0x0055, B:41:0x00a9, B:43:0x00ad, B:45:0x00b1, B:47:0x00bf), top: B:121:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bf A[Catch: all -> 0x0294, TRY_LEAVE, TryCatch #5 {all -> 0x0294, blocks: (B:7:0x0036, B:8:0x003d, B:9:0x0041, B:10:0x0045, B:11:0x0049, B:12:0x004d, B:13:0x0051, B:14:0x0055, B:41:0x00a9, B:43:0x00ad, B:45:0x00b1, B:47:0x00bf), top: B:121:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01e4  */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private d() {
        InputStream inputStream;
        Throwable th2;
        String str;
        String str2;
        String str3;
        Object obj;
        Object obj2;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Object obj3;
        boolean z10;
        long j10;
        Object obj4;
        int i10;
        ?? r92;
        String str9;
        String str10;
        String str11;
        IOException e10;
        String str12;
        String str13;
        String property;
        if (r9.b.a() != null) {
            long currentTimeMillis = System.currentTimeMillis();
            Properties properties = new Properties();
            try {
                inputStream = r9.b.a().getAssets().open("filedownloader.properties");
                if (inputStream != null) {
                    try {
                        try {
                            properties.load(inputStream);
                            str4 = properties.getProperty("http.lenient");
                        } catch (IOException e11) {
                            e10 = e11;
                            str4 = null;
                            str11 = null;
                            str3 = null;
                            str2 = null;
                            str = null;
                            str10 = null;
                            str9 = null;
                            if (e10 instanceof FileNotFoundException) {
                                str12 = str4;
                                e10.printStackTrace();
                            } else if (c.f33469a) {
                                str12 = str4;
                                c.a(d.class, "not found filedownloader.properties", new Object[0]);
                            } else {
                                str12 = str4;
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e12) {
                                    e12.printStackTrace();
                                }
                            }
                            obj2 = d.class;
                            str8 = str11;
                            str5 = str10;
                            str7 = str9;
                            str4 = str12;
                            str6 = null;
                            obj = "download.max-network-thread-count";
                            if (str4 == null) {
                            }
                            if (str8 == null) {
                            }
                            if (str3 != null) {
                            }
                            if (str2 != null) {
                            }
                            if (str != null) {
                            }
                            if (str5 == null) {
                            }
                            if (str7 == null) {
                            }
                            if (str6 == null) {
                            }
                            if (c.f33469a) {
                            }
                        }
                        try {
                            str11 = properties.getProperty("process.non-separate");
                        } catch (IOException e13) {
                            e10 = e13;
                            str11 = null;
                            str3 = null;
                            str2 = null;
                            str = null;
                            str10 = null;
                            str9 = null;
                            if (e10 instanceof FileNotFoundException) {
                            }
                            if (inputStream != null) {
                            }
                            obj2 = d.class;
                            str8 = str11;
                            str5 = str10;
                            str7 = str9;
                            str4 = str12;
                            str6 = null;
                            obj = "download.max-network-thread-count";
                            if (str4 == null) {
                            }
                            if (str8 == null) {
                            }
                            if (str3 != null) {
                            }
                            if (str2 != null) {
                            }
                            if (str != null) {
                            }
                            if (str5 == null) {
                            }
                            if (str7 == null) {
                            }
                            if (str6 == null) {
                            }
                            if (c.f33469a) {
                            }
                        }
                        try {
                            str3 = properties.getProperty("download.min-progress-step");
                        } catch (IOException e14) {
                            e10 = e14;
                            str3 = null;
                            str2 = null;
                            str = null;
                            str10 = null;
                            str9 = null;
                            if (e10 instanceof FileNotFoundException) {
                            }
                            if (inputStream != null) {
                            }
                            obj2 = d.class;
                            str8 = str11;
                            str5 = str10;
                            str7 = str9;
                            str4 = str12;
                            str6 = null;
                            obj = "download.max-network-thread-count";
                            if (str4 == null) {
                            }
                            if (str8 == null) {
                            }
                            if (str3 != null) {
                            }
                            if (str2 != null) {
                            }
                            if (str != null) {
                            }
                            if (str5 == null) {
                            }
                            if (str7 == null) {
                            }
                            if (str6 == null) {
                            }
                            if (c.f33469a) {
                            }
                        }
                        try {
                            str2 = properties.getProperty("download.min-progress-time");
                        } catch (IOException e15) {
                            e10 = e15;
                            str2 = null;
                            str = null;
                            str10 = null;
                            str9 = null;
                            if (e10 instanceof FileNotFoundException) {
                            }
                            if (inputStream != null) {
                            }
                            obj2 = d.class;
                            str8 = str11;
                            str5 = str10;
                            str7 = str9;
                            str4 = str12;
                            str6 = null;
                            obj = "download.max-network-thread-count";
                            if (str4 == null) {
                            }
                            if (str8 == null) {
                            }
                            if (str3 != null) {
                            }
                            if (str2 != null) {
                            }
                            if (str != null) {
                            }
                            if (str5 == null) {
                            }
                            if (str7 == null) {
                            }
                            if (str6 == null) {
                            }
                            if (c.f33469a) {
                            }
                        }
                        try {
                            str = properties.getProperty("download.max-network-thread-count");
                        } catch (IOException e16) {
                            e10 = e16;
                            str = null;
                            str10 = null;
                            str9 = null;
                            if (e10 instanceof FileNotFoundException) {
                            }
                            if (inputStream != null) {
                            }
                            obj2 = d.class;
                            str8 = str11;
                            str5 = str10;
                            str7 = str9;
                            str4 = str12;
                            str6 = null;
                            obj = "download.max-network-thread-count";
                            if (str4 == null) {
                            }
                            if (str8 == null) {
                            }
                            if (str3 != null) {
                            }
                            if (str2 != null) {
                            }
                            if (str != null) {
                            }
                            if (str5 == null) {
                            }
                            if (str7 == null) {
                            }
                            if (str6 == null) {
                            }
                            if (c.f33469a) {
                            }
                        }
                        try {
                            str10 = properties.getProperty("file.non-pre-allocation");
                        } catch (IOException e17) {
                            e10 = e17;
                            str10 = null;
                            str9 = null;
                            if (e10 instanceof FileNotFoundException) {
                            }
                            if (inputStream != null) {
                            }
                            obj2 = d.class;
                            str8 = str11;
                            str5 = str10;
                            str7 = str9;
                            str4 = str12;
                            str6 = null;
                            obj = "download.max-network-thread-count";
                            if (str4 == null) {
                            }
                            if (str8 == null) {
                            }
                            if (str3 != null) {
                            }
                            if (str2 != null) {
                            }
                            if (str != null) {
                            }
                            if (str5 == null) {
                            }
                            if (str7 == null) {
                            }
                            if (str6 == null) {
                            }
                            if (c.f33469a) {
                            }
                        }
                        try {
                            str9 = properties.getProperty("broadcast.completed");
                        } catch (IOException e18) {
                            e10 = e18;
                            str9 = null;
                            if (e10 instanceof FileNotFoundException) {
                            }
                            if (inputStream != null) {
                            }
                            obj2 = d.class;
                            str8 = str11;
                            str5 = str10;
                            str7 = str9;
                            str4 = str12;
                            str6 = null;
                            obj = "download.max-network-thread-count";
                            if (str4 == null) {
                            }
                            if (str8 == null) {
                            }
                            if (str3 != null) {
                            }
                            if (str2 != null) {
                            }
                            if (str != null) {
                            }
                            if (str5 == null) {
                            }
                            if (str7 == null) {
                            }
                            if (str6 == null) {
                            }
                            if (c.f33469a) {
                            }
                        }
                        try {
                            str13 = str11;
                            property = properties.getProperty("download.trial-connection-head-method");
                        } catch (IOException e19) {
                            e10 = e19;
                            if (e10 instanceof FileNotFoundException) {
                            }
                            if (inputStream != null) {
                            }
                            obj2 = d.class;
                            str8 = str11;
                            str5 = str10;
                            str7 = str9;
                            str4 = str12;
                            str6 = null;
                            obj = "download.max-network-thread-count";
                            if (str4 == null) {
                            }
                            if (str8 == null) {
                            }
                            if (str3 != null) {
                            }
                            if (str2 != null) {
                            }
                            if (str != null) {
                            }
                            if (str5 == null) {
                            }
                            if (str7 == null) {
                            }
                            if (str6 == null) {
                            }
                            if (c.f33469a) {
                            }
                        }
                    } catch (Throwable th3) {
                        th2 = th3;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e20) {
                                e20.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                } else {
                    str4 = null;
                    str13 = null;
                    property = null;
                    str3 = null;
                    str2 = null;
                    str = null;
                    str10 = null;
                    str9 = null;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e21) {
                        e21.printStackTrace();
                    }
                }
                str8 = str13;
                str6 = property;
                str5 = str10;
                obj = "download.max-network-thread-count";
                obj2 = d.class;
                str7 = str9;
            } catch (IOException e22) {
                e10 = e22;
                inputStream = null;
            } catch (Throwable th4) {
                th2 = th4;
                inputStream = null;
            }
            if (str4 == null) {
                obj3 = "http.lenient";
                z10 = false;
                this.f33472c = false;
            } else if (str4.equals("true") || str4.equals("false")) {
                obj3 = "http.lenient";
                z10 = false;
                this.f33472c = str4.equals("true");
            } else {
                throw new IllegalStateException(e.n("the value of '%s' must be '%s' or '%s'", "http.lenient", "true", "false"));
            }
            if (str8 == null) {
                this.f33473d = z10;
            } else if (str8.equals("true") || str8.equals("false")) {
                this.f33473d = str8.equals("true");
            } else {
                Object[] objArr = new Object[3];
                char c10 = z10 ? 1 : 0;
                char c11 = z10 ? 1 : 0;
                objArr[c10] = "process.non-separate";
                objArr[1] = "true";
                objArr[2] = "false";
                throw new IllegalStateException(e.n("the value of '%s' must be '%s' or '%s'", objArr));
            }
            if (str3 != null) {
                int intValue = Integer.valueOf(str3).intValue();
                int i11 = z10 ? 1 : 0;
                int i12 = z10 ? 1 : 0;
                this.f33470a = Math.max(i11, intValue);
            } else {
                this.f33470a = WXMediaMessage.THUMB_LENGTH_LIMIT;
            }
            if (str2 != null) {
                obj4 = "process.non-separate";
                j10 = currentTimeMillis;
                this.f33471b = Math.max(0L, Long.valueOf(str2).longValue());
            } else {
                obj4 = "process.non-separate";
                j10 = currentTimeMillis;
                this.f33471b = 2000L;
            }
            if (str != null) {
                this.f33474e = b(Integer.valueOf(str).intValue());
                i10 = 3;
            } else {
                i10 = 3;
                this.f33474e = 3;
            }
            if (str5 == null) {
                r92 = 0;
                this.f33475f = false;
            } else if (str5.equals("true") || str5.equals("false")) {
                r92 = 0;
                this.f33475f = str5.equals("true");
            } else {
                Object[] objArr2 = new Object[i10];
                objArr2[0] = "file.non-pre-allocation";
                objArr2[1] = "true";
                objArr2[2] = "false";
                throw new IllegalStateException(e.n("the value of '%s' must be '%s' or '%s'", objArr2));
            }
            if (str7 == null) {
                this.f33476g = r92;
            } else if (str7.equals("true") || str7.equals("false")) {
                this.f33476g = str7.equals("true");
            } else {
                Object[] objArr3 = new Object[3];
                objArr3[r92] = "broadcast.completed";
                objArr3[1] = "true";
                objArr3[2] = "false";
                throw new IllegalStateException(e.n("the value of '%s' must be '%s' or '%s'", objArr3));
            }
            if (str6 == null) {
                this.f33477h = r92;
            } else if (str6.equals("true") || str6.equals("false")) {
                this.f33477h = str6.equals("true");
            } else {
                Object[] objArr4 = new Object[3];
                objArr4[r92] = "download.trial-connection-head-method";
                objArr4[1] = "true";
                objArr4[2] = "false";
                throw new IllegalStateException(e.n("the value of '%s' must be '%s' or '%s'", objArr4));
            }
            if (c.f33469a) {
                Object[] objArr5 = new Object[17];
                Long valueOf = Long.valueOf(System.currentTimeMillis() - j10);
                char c12 = r92 == true ? 1 : 0;
                char c13 = r92 == true ? 1 : 0;
                objArr5[c12] = valueOf;
                objArr5[1] = obj3;
                objArr5[2] = Boolean.valueOf(this.f33472c);
                objArr5[3] = obj4;
                objArr5[4] = Boolean.valueOf(this.f33473d);
                objArr5[5] = "download.min-progress-step";
                objArr5[6] = Integer.valueOf(this.f33470a);
                objArr5[7] = "download.min-progress-time";
                objArr5[8] = Long.valueOf(this.f33471b);
                objArr5[9] = obj;
                objArr5[10] = Integer.valueOf(this.f33474e);
                objArr5[11] = "file.non-pre-allocation";
                objArr5[12] = Boolean.valueOf(this.f33475f);
                objArr5[13] = "broadcast.completed";
                objArr5[14] = Boolean.valueOf(this.f33476g);
                objArr5[15] = "download.trial-connection-head-method";
                objArr5[16] = Boolean.valueOf(this.f33477h);
                c.e(obj2, "init properties %d\n load properties: %s=%B; %s=%B; %s=%d; %s=%d; %s=%d; %s=%B; %s=%B; %s=%B", objArr5);
                return;
            }
            return;
        }
        throw new IllegalStateException("Please invoke the 'FileDownloader#setup' before using FileDownloader. If you want to register some components on FileDownloader please invoke the 'FileDownloader#setupOnApplicationOnCreate' on the 'Application#onCreate' first.");
    }
}
