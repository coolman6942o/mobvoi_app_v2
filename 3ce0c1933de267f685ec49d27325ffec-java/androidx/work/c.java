package androidx.work;

import android.net.Uri;
import java.util.HashSet;
import java.util.Set;
/* compiled from: ContentUriTriggers.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Set<a> f4736a = new HashSet();

    /* compiled from: ContentUriTriggers.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f4737a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f4738b;

        a(Uri uri, boolean z10) {
            this.f4737a = uri;
            this.f4738b = z10;
        }

        public Uri a() {
            return this.f4737a;
        }

        public boolean b() {
            return this.f4738b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4738b == aVar.f4738b && this.f4737a.equals(aVar.f4737a);
        }

        public int hashCode() {
            return (this.f4737a.hashCode() * 31) + (this.f4738b ? 1 : 0);
        }
    }

    public void a(Uri uri, boolean z10) {
        this.f4736a.add(new a(uri, z10));
    }

    public Set<a> b() {
        return this.f4736a;
    }

    public int c() {
        return this.f4736a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return this.f4736a.equals(((c) obj).f4736a);
    }

    public int hashCode() {
        return this.f4736a.hashCode();
    }
}
