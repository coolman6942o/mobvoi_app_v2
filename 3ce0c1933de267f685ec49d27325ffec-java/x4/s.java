package x4;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.InputStream;
import q4.e;
import x4.n;
/* compiled from: ResourceLoader.java */
/* loaded from: classes.dex */
public class s<Data> implements n<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f36427a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f36428b;

    /* compiled from: ResourceLoader.java */
    /* loaded from: classes.dex */
    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f36429a;

        public a(Resources resources) {
            this.f36429a = resources;
        }

        @Override // x4.o
        public n<Integer, AssetFileDescriptor> b(r rVar) {
            return new s(this.f36429a, rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* loaded from: classes.dex */
    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f36430a;

        public b(Resources resources) {
            this.f36430a = resources;
        }

        @Override // x4.o
        public n<Integer, ParcelFileDescriptor> b(r rVar) {
            return new s(this.f36430a, rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* loaded from: classes.dex */
    public static class c implements o<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f36431a;

        public c(Resources resources) {
            this.f36431a = resources;
        }

        @Override // x4.o
        public n<Integer, InputStream> b(r rVar) {
            return new s(this.f36431a, rVar.d(Uri.class, InputStream.class));
        }
    }

    /* compiled from: ResourceLoader.java */
    /* loaded from: classes.dex */
    public static class d implements o<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f36432a;

        public d(Resources resources) {
            this.f36432a = resources;
        }

        @Override // x4.o
        public n<Integer, Uri> b(r rVar) {
            return new s(this.f36432a, v.c());
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f36428b = resources;
        this.f36427a = nVar;
    }

    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f36428b.getResourcePackageName(num.intValue()) + '/' + this.f36428b.getResourceTypeName(num.intValue()) + '/' + this.f36428b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e10) {
            if (!Log.isLoggable("ResourceLoader", 5)) {
                return null;
            }
            Log.w("ResourceLoader", "Received invalid resource id: " + num, e10);
            return null;
        }
    }

    /* renamed from: c */
    public n.a<Data> b(Integer num, int i10, int i11, e eVar) {
        Uri d10 = d(num);
        if (d10 == null) {
            return null;
        }
        return this.f36427a.b(d10, i10, i11, eVar);
    }

    /* renamed from: e */
    public boolean a(Integer num) {
        return true;
    }
}
