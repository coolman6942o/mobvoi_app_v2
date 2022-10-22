package pj;

import android.os.AsyncTask;
/* compiled from: DefaultAsyncTaskExecInterface.java */
/* loaded from: classes2.dex */
public final class c implements a {
    @Override // pj.a
    public <T> void a(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        asyncTask.execute(tArr);
    }
}
