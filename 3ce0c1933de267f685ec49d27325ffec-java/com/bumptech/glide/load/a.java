package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.l;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import u4.b;
/* compiled from: ImageHeaderParserUtils.java */
/* loaded from: classes.dex */
public final class a {
    public static int a(List<ImageHeaderParser> list, InputStream inputStream, b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new l(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                int b10 = list.get(i10).b(inputStream, bVar);
                if (b10 != -1) {
                    return b10;
                }
                inputStream.reset();
            } finally {
                inputStream.reset();
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType b(List<ImageHeaderParser> list, InputStream inputStream, b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new l(inputStream, bVar);
        }
        inputStream.mark(5242880);
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            try {
                ImageHeaderParser.ImageType c10 = list.get(i10).c(inputStream);
                if (c10 != ImageHeaderParser.ImageType.UNKNOWN) {
                    return c10;
                }
                inputStream.reset();
            } finally {
                inputStream.reset();
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static ImageHeaderParser.ImageType c(List<ImageHeaderParser> list, ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int size = list.size();
        for (int i10 = 0; i10 < size; i10++) {
            ImageHeaderParser.ImageType a10 = list.get(i10).a(byteBuffer);
            if (a10 != ImageHeaderParser.ImageType.UNKNOWN) {
                return a10;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }
}
