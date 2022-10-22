package com.mobvoi.wear.util;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/* loaded from: classes2.dex */
public class Compress {
    private static final int BUFFER = 2048;
    private static String TAG = "Compress";
    private File[] mFiles;
    private String mZipFile;

    public Compress(File[] fileArr, String str) {
        this.mFiles = fileArr;
        this.mZipFile = str;
    }

    public void zip() {
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(this.mZipFile)));
            byte[] bArr = new byte[2048];
            for (int i10 = 0; i10 < this.mFiles.length; i10++) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(this.mFiles[i10]), 2048);
                zipOutputStream.putNextEntry(new ZipEntry(this.mFiles[i10].getName()));
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, 2048);
                    if (read != -1) {
                        zipOutputStream.write(bArr, 0, read);
                    }
                }
                bufferedInputStream.close();
            }
            zipOutputStream.close();
        } catch (Exception e10) {
            Log.e(TAG, e10.getMessage(), e10);
        }
    }
}
