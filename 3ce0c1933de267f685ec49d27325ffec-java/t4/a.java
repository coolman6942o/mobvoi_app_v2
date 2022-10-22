package t4;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
/* compiled from: DiskCacheStrategy.java */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f35049a = new b();

    /* renamed from: b  reason: collision with root package name */
    public static final a f35050b = new c();

    /* renamed from: c  reason: collision with root package name */
    public static final a f35051c = new d();

    /* renamed from: d  reason: collision with root package name */
    public static final a f35052d = new e();

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: t4.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0500a extends a {
        C0500a() {
        }

        @Override // t4.a
        public boolean a() {
            return true;
        }

        @Override // t4.a
        public boolean b() {
            return true;
        }

        @Override // t4.a
        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // t4.a
        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* loaded from: classes.dex */
    class b extends a {
        b() {
        }

        @Override // t4.a
        public boolean a() {
            return false;
        }

        @Override // t4.a
        public boolean b() {
            return false;
        }

        @Override // t4.a
        public boolean c(DataSource dataSource) {
            return false;
        }

        @Override // t4.a
        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* loaded from: classes.dex */
    class c extends a {
        c() {
        }

        @Override // t4.a
        public boolean a() {
            return true;
        }

        @Override // t4.a
        public boolean b() {
            return false;
        }

        @Override // t4.a
        public boolean c(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        @Override // t4.a
        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* loaded from: classes.dex */
    class d extends a {
        d() {
        }

        @Override // t4.a
        public boolean a() {
            return false;
        }

        @Override // t4.a
        public boolean b() {
            return true;
        }

        @Override // t4.a
        public boolean c(DataSource dataSource) {
            return false;
        }

        @Override // t4.a
        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* loaded from: classes.dex */
    class e extends a {
        e() {
        }

        @Override // t4.a
        public boolean a() {
            return true;
        }

        @Override // t4.a
        public boolean b() {
            return true;
        }

        @Override // t4.a
        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // t4.a
        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z10 && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    }

    static {
        new C0500a();
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(DataSource dataSource);

    public abstract boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy);
}
