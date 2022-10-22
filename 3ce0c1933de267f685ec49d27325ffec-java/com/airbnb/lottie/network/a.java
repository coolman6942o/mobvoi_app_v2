package com.airbnb.lottie.network;

import android.content.Context;
import j0.d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: NetworkCache.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f6668a;

    public a(Context context) {
        this.f6668a = context.getApplicationContext();
    }

    private static String b(String str, FileExtension fileExtension, boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("lottie_cache_");
        sb2.append(str.replaceAll("\\W+", ""));
        sb2.append(z10 ? fileExtension.tempExtension() : fileExtension.extension);
        return sb2.toString();
    }

    private File c(String str) throws FileNotFoundException {
        File file = new File(d(), b(str, FileExtension.JSON, false));
        if (file.exists()) {
            return file;
        }
        File file2 = new File(d(), b(str, FileExtension.ZIP, false));
        if (file2.exists()) {
            return file2;
        }
        return null;
    }

    private File d() {
        File file = new File(this.f6668a.getCacheDir(), "lottie_network_cache");
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d<FileExtension, InputStream> a(String str) {
        FileExtension fileExtension;
        try {
            File c10 = c(str);
            if (c10 == null) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(c10);
            if (c10.getAbsolutePath().endsWith(".zip")) {
                fileExtension = FileExtension.ZIP;
            } else {
                fileExtension = FileExtension.JSON;
            }
            k3.d.a("Cache hit for " + str + " at " + c10.getAbsolutePath());
            return new d<>(fileExtension, fileInputStream);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, FileExtension fileExtension) {
        File file = new File(d(), b(str, fileExtension, true));
        File file2 = new File(file.getAbsolutePath().replace(".temp", ""));
        boolean renameTo = file.renameTo(file2);
        k3.d.a("Copying temp file to real file (" + file2 + ")");
        if (!renameTo) {
            k3.d.c("Unable to rename cache file " + file.getAbsolutePath() + " to " + file2.getAbsolutePath() + ".");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File f(String str, InputStream inputStream, FileExtension fileExtension) throws IOException {
        File file = new File(d(), b(str, fileExtension, true));
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return file;
                }
            }
        } finally {
            inputStream.close();
        }
    }
}
