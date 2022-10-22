package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import java.io.File;
/* compiled from: HardwareConfigState.java */
/* loaded from: classes.dex */
public final class j {

    /* renamed from: d  reason: collision with root package name */
    private static final File f8096d = new File("/proc/self/fd");

    /* renamed from: e  reason: collision with root package name */
    private static volatile int f8097e = 700;

    /* renamed from: f  reason: collision with root package name */
    private static volatile int f8098f = 128;

    /* renamed from: g  reason: collision with root package name */
    private static volatile j f8099g;

    /* renamed from: b  reason: collision with root package name */
    private int f8101b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8102c = true;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f8100a = d();

    j() {
    }

    public static j a() {
        if (f8099g == null) {
            synchronized (j.class) {
                if (f8099g == null) {
                    f8099g = new j();
                }
            }
        }
        return f8099g;
    }

    private synchronized boolean b() {
        boolean z10 = true;
        int i10 = this.f8101b + 1;
        this.f8101b = i10;
        if (i10 >= 50) {
            this.f8101b = 0;
            int length = f8096d.list().length;
            if (length >= f8097e) {
                z10 = false;
            }
            this.f8102c = z10;
            if (!z10 && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + f8097e);
            }
        }
        return this.f8102c;
    }

    private static boolean d() {
        String str = Build.MODEL;
        if (str == null || str.length() < 7) {
            return true;
        }
        String substring = str.substring(0, 7);
        substring.hashCode();
        char c10 = 65535;
        switch (substring.hashCode()) {
            case -1398613787:
                if (substring.equals("SM-A520")) {
                    c10 = 0;
                    break;
                }
                break;
            case -1398431166:
                if (substring.equals("SM-G930")) {
                    c10 = 1;
                    break;
                }
                break;
            case -1398431161:
                if (substring.equals("SM-G935")) {
                    c10 = 2;
                    break;
                }
                break;
            case -1398431073:
                if (substring.equals("SM-G960")) {
                    c10 = 3;
                    break;
                }
                break;
            case -1398431068:
                if (substring.equals("SM-G965")) {
                    c10 = 4;
                    break;
                }
                break;
            case -1398343746:
                if (substring.equals("SM-J720")) {
                    c10 = 5;
                    break;
                }
                break;
            case -1398222624:
                if (substring.equals("SM-N935")) {
                    c10 = 6;
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return Build.VERSION.SDK_INT != 26;
            default:
                return true;
        }
    }

    public boolean c(int i10, int i11, boolean z10, boolean z11) {
        return z10 && this.f8100a && Build.VERSION.SDK_INT >= 26 && !z11 && i10 >= f8098f && i11 >= f8098f && b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(26)
    public boolean e(int i10, int i11, BitmapFactory.Options options, boolean z10, boolean z11) {
        boolean c10 = c(i10, i11, z10, z11);
        if (c10) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return c10;
    }
}
