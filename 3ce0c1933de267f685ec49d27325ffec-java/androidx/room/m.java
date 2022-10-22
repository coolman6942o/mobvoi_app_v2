package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;
/* compiled from: InvalidationLiveDataContainer.java */
/* loaded from: classes.dex */
class m {

    /* renamed from: a  reason: collision with root package name */
    final Set<LiveData> f4279a = Collections.newSetFromMap(new IdentityHashMap());

    /* renamed from: b  reason: collision with root package name */
    private final RoomDatabase f4280b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(RoomDatabase roomDatabase) {
        this.f4280b = roomDatabase;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T> LiveData<T> a(String[] strArr, boolean z10, Callable<T> callable) {
        return new i0(this.f4280b, this, z10, callable, strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(LiveData liveData) {
        this.f4279a.add(liveData);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(LiveData liveData) {
        this.f4279a.remove(liveData);
    }
}
