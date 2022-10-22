package androidx.work;

import android.os.Build;
import androidx.work.s;
/* compiled from: OneTimeWorkRequest.java */
/* loaded from: classes.dex */
public final class l extends s {

    /* compiled from: OneTimeWorkRequest.java */
    /* loaded from: classes.dex */
    public static final class a extends s.a<a, l> {
        public a(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.f4902c.f36692d = OverwritingInputMerger.class.getName();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: e */
        public l c() {
            if (!this.f4900a || Build.VERSION.SDK_INT < 23 || !this.f4902c.f36698j.h()) {
                return new l(this);
            }
            throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: f */
        public a d() {
            return this;
        }
    }

    l(a aVar) {
        super(aVar.f4901b, aVar.f4902c, aVar.f4903d);
    }

    public static l d(Class<? extends ListenableWorker> cls) {
        return new a(cls).b();
    }
}
