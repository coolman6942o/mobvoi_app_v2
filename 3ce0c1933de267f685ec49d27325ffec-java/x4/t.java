package x4;

import android.util.Log;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import q4.a;
import q4.e;
import u4.b;
/* compiled from: StreamEncoder.java */
/* loaded from: classes.dex */
public class t implements a<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final b f36433a;

    public t(b bVar) {
        this.f36433a = bVar;
    }

    /* renamed from: c */
    public boolean b(InputStream inputStream, File file, e eVar) {
        Throwable th2;
        IOException e10;
        byte[] bArr = (byte[]) this.f36433a.e(WXMediaMessage.THUMB_LENGTH_LIMIT, byte[].class);
        boolean z10 = false;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    while (true) {
                        try {
                            int read = inputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            fileOutputStream2.write(bArr, 0, read);
                        } catch (IOException e11) {
                            e10 = e11;
                            fileOutputStream = fileOutputStream2;
                            if (Log.isLoggable("StreamEncoder", 3)) {
                                Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e10);
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            this.f36433a.d(bArr);
                            return z10;
                        } catch (Throwable th3) {
                            th2 = th3;
                            fileOutputStream = fileOutputStream2;
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                            }
                            this.f36433a.d(bArr);
                            throw th2;
                        }
                    }
                    fileOutputStream2.close();
                    z10 = true;
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            } catch (IOException e12) {
                e10 = e12;
            }
            this.f36433a.d(bArr);
            return z10;
        } catch (Throwable th4) {
            th2 = th4;
        }
    }
}
