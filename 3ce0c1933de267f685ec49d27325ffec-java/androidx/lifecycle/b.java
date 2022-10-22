package androidx.lifecycle;

import android.annotation.SuppressLint;
import android.app.Application;
/* compiled from: AndroidViewModel.java */
/* loaded from: classes.dex */
public class b extends f0 {
    @SuppressLint({"StaticFieldLeak"})
    private Application mApplication;

    public b(Application application) {
        this.mApplication = application;
    }

    public <T extends Application> T getApplication() {
        return (T) this.mApplication;
    }
}
