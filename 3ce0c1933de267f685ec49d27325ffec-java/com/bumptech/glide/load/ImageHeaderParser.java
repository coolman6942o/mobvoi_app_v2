package com.bumptech.glide.load;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import u4.b;
/* loaded from: classes.dex */
public interface ImageHeaderParser {

    /* loaded from: classes.dex */
    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        UNKNOWN(false);
        
        private final boolean hasAlpha;

        ImageType(boolean z10) {
            this.hasAlpha = z10;
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }
    }

    ImageType a(ByteBuffer byteBuffer) throws IOException;

    int b(InputStream inputStream, b bVar) throws IOException;

    ImageType c(InputStream inputStream) throws IOException;
}
