package androidx.work;

import android.annotation.SuppressLint;
import com.huawei.hms.mlsdk.common.internal.client.event.MonitorResult;
/* compiled from: Operation.java */
/* loaded from: classes.dex */
public interface m {
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: a  reason: collision with root package name */
    public static final b.c f4893a = new b.c();
    @SuppressLint({"SyntheticAccessor"})

    /* renamed from: b  reason: collision with root package name */
    public static final b.C0059b f4894b = new b.C0059b();

    /* compiled from: Operation.java */
    /* loaded from: classes.dex */
    public static abstract class b {

        /* compiled from: Operation.java */
        /* loaded from: classes.dex */
        public static final class a extends b {

            /* renamed from: a  reason: collision with root package name */
            private final Throwable f4895a;

            public a(Throwable th2) {
                this.f4895a = th2;
            }

            public Throwable a() {
                return this.f4895a;
            }

            public String toString() {
                return String.format("FAILURE (%s)", this.f4895a.getMessage());
            }
        }

        /* compiled from: Operation.java */
        /* renamed from: androidx.work.m$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0059b extends b {
            public String toString() {
                return "IN_PROGRESS";
            }

            private C0059b() {
            }
        }

        /* compiled from: Operation.java */
        /* loaded from: classes.dex */
        public static final class c extends b {
            public String toString() {
                return MonitorResult.SUCCESS;
            }

            private c() {
            }
        }

        b() {
        }
    }
}
