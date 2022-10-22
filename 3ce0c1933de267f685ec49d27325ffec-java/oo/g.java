package oo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import kotlin.collections.e;
import kotlin.jvm.internal.i;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FileReadWrite.kt */
/* loaded from: classes3.dex */
public class g extends f {
    public static byte[] a(File readBytes) {
        i.f(readBytes, "$this$readBytes");
        FileInputStream fileInputStream = new FileInputStream(readBytes);
        try {
            long length = readBytes.length();
            if (length <= Integer.MAX_VALUE) {
                int i10 = (int) length;
                byte[] bArr = new byte[i10];
                int i11 = i10;
                int i12 = 0;
                while (i11 > 0) {
                    int read = fileInputStream.read(bArr, i12, i11);
                    if (read < 0) {
                        break;
                    }
                    i11 -= read;
                    i12 += read;
                }
                th = null;
                if (i11 > 0) {
                    bArr = Arrays.copyOf(bArr, i12);
                    i.e(bArr, "java.util.Arrays.copyOf(this, newSize)");
                } else {
                    int read2 = fileInputStream.read();
                    if (read2 != -1) {
                        d dVar = new d(8193);
                        dVar.write(read2);
                        a.b(fileInputStream, dVar, 0, 2, th);
                        int size = dVar.size() + i10;
                        if (size >= 0) {
                            byte[] c10 = dVar.c();
                            byte[] copyOf = Arrays.copyOf(bArr, size);
                            i.e(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                            bArr = e.c(c10, copyOf, i10, 0, dVar.size());
                        } else {
                            throw new OutOfMemoryError("File " + readBytes + " is too big to fit in memory.");
                        }
                    }
                }
                return bArr;
            }
            throw new OutOfMemoryError("File " + readBytes + " is too big (" + length + " bytes) to fit in memory.");
        } finally {
            try {
                throw th;
            } finally {
            }
        }
    }
}
