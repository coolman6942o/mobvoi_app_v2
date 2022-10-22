package x4;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import q4.a;
import q4.e;
/* compiled from: ByteBufferEncoder.java */
/* loaded from: classes.dex */
public class c implements a<ByteBuffer> {
    /* renamed from: c */
    public boolean b(ByteBuffer byteBuffer, File file, e eVar) {
        try {
            n5.a.e(byteBuffer, file);
            return true;
        } catch (IOException e10) {
            if (Log.isLoggable("ByteBufferEncoder", 3)) {
                Log.d("ByteBufferEncoder", "Failed to write data", e10);
            }
            return false;
        }
    }
}
