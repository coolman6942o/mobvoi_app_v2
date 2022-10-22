package com.huawei.hms.ml.scan;

import com.huawei.hms.scankit.util.b;
/* loaded from: classes2.dex */
public class HmsScanAnalyzerOptions {
    public final int mode;
    public final boolean photoMode;

    /* loaded from: classes2.dex */
    public static class Creator {
        private int type = 0;
        private boolean photoMode = false;

        public HmsScanAnalyzerOptions create() {
            return new HmsScanAnalyzerOptions(this.type, this.photoMode);
        }

        public Creator setHmsScanTypes(int i10, int... iArr) {
            int a10 = b.a(i10);
            this.type = a10;
            if (iArr != null && iArr.length > 0) {
                this.type = b.b(a10);
                for (int i11 : iArr) {
                    this.type = b.b(i11) | this.type;
                }
            }
            return this;
        }

        public Creator setPhotoMode(boolean z10) {
            this.photoMode = z10;
            return this;
        }
    }

    public boolean equals(Object obj) {
        return obj == this;
    }

    public int hashCode() {
        return super.hashCode();
    }

    private HmsScanAnalyzerOptions(int i10, boolean z10) {
        this.mode = i10;
        this.photoMode = z10;
    }
}
