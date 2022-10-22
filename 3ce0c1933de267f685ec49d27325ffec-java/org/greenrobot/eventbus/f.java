package org.greenrobot.eventbus;

import android.util.Log;
import java.io.PrintStream;
import java.util.logging.Level;
/* compiled from: Logger.java */
/* loaded from: classes3.dex */
public interface f {

    /* compiled from: Logger.java */
    /* loaded from: classes3.dex */
    public static class a implements f {

        /* renamed from: b  reason: collision with root package name */
        static final boolean f32482b;

        /* renamed from: a  reason: collision with root package name */
        private final String f32483a;

        static {
            boolean z10;
            try {
                Class.forName("android.util.Log");
                z10 = true;
            } catch (ClassNotFoundException unused) {
                z10 = false;
            }
            f32482b = z10;
        }

        public a(String str) {
            this.f32483a = str;
        }

        public static boolean c() {
            return f32482b;
        }

        @Override // org.greenrobot.eventbus.f
        public void a(Level level, String str) {
            if (level != Level.OFF) {
                Log.println(d(level), this.f32483a, str);
            }
        }

        @Override // org.greenrobot.eventbus.f
        public void b(Level level, String str, Throwable th2) {
            if (level != Level.OFF) {
                int d10 = d(level);
                String str2 = this.f32483a;
                Log.println(d10, str2, str + "\n" + Log.getStackTraceString(th2));
            }
        }

        protected int d(Level level) {
            int intValue = level.intValue();
            if (intValue < 800) {
                return intValue < 500 ? 2 : 3;
            }
            if (intValue < 900) {
                return 4;
            }
            return intValue < 1000 ? 5 : 6;
        }
    }

    /* compiled from: Logger.java */
    /* loaded from: classes3.dex */
    public static class b implements f {
        @Override // org.greenrobot.eventbus.f
        public void a(Level level, String str) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
        }

        @Override // org.greenrobot.eventbus.f
        public void b(Level level, String str, Throwable th2) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
            th2.printStackTrace(System.out);
        }
    }

    void a(Level level, String str);

    void b(Level level, String str, Throwable th2);
}
