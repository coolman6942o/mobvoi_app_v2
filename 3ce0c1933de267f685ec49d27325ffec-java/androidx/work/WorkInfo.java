package androidx.work;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
/* loaded from: classes.dex */
public final class WorkInfo {

    /* renamed from: a  reason: collision with root package name */
    private UUID f4678a;

    /* renamed from: b  reason: collision with root package name */
    private State f4679b;

    /* renamed from: c  reason: collision with root package name */
    private d f4680c;

    /* renamed from: d  reason: collision with root package name */
    private Set<String> f4681d;

    /* renamed from: e  reason: collision with root package name */
    private d f4682e;

    /* renamed from: f  reason: collision with root package name */
    private int f4683f;

    /* loaded from: classes.dex */
    public enum State {
        ENQUEUED,
        RUNNING,
        SUCCEEDED,
        FAILED,
        BLOCKED,
        CANCELLED;

        public boolean isFinished() {
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
        }
    }

    public WorkInfo(UUID uuid, State state, d dVar, List<String> list, d dVar2, int i10) {
        this.f4678a = uuid;
        this.f4679b = state;
        this.f4680c = dVar;
        this.f4681d = new HashSet(list);
        this.f4682e = dVar2;
        this.f4683f = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || WorkInfo.class != obj.getClass()) {
            return false;
        }
        WorkInfo workInfo = (WorkInfo) obj;
        if (this.f4683f == workInfo.f4683f && this.f4678a.equals(workInfo.f4678a) && this.f4679b == workInfo.f4679b && this.f4680c.equals(workInfo.f4680c) && this.f4681d.equals(workInfo.f4681d)) {
            return this.f4682e.equals(workInfo.f4682e);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.f4678a.hashCode() * 31) + this.f4679b.hashCode()) * 31) + this.f4680c.hashCode()) * 31) + this.f4681d.hashCode()) * 31) + this.f4682e.hashCode()) * 31) + this.f4683f;
    }

    public String toString() {
        return "WorkInfo{mId='" + this.f4678a + "', mState=" + this.f4679b + ", mOutputData=" + this.f4680c + ", mTags=" + this.f4681d + ", mProgress=" + this.f4682e + '}';
    }
}
