package androidx.lifecycle;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import androidx.savedstate.SavedStateRegistry;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* compiled from: SavedStateHandle.java */
/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: e  reason: collision with root package name */
    private static final Class[] f3283e;

    /* renamed from: a  reason: collision with root package name */
    final Map<String, Object> f3284a;

    /* renamed from: b  reason: collision with root package name */
    final Map<String, SavedStateRegistry.b> f3285b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Object> f3286c;

    /* renamed from: d  reason: collision with root package name */
    private final SavedStateRegistry.b f3287d;

    /* compiled from: SavedStateHandle.java */
    /* loaded from: classes.dex */
    class a implements SavedStateRegistry.b {
        a() {
        }

        @Override // androidx.savedstate.SavedStateRegistry.b
        public Bundle a() {
            for (Map.Entry entry : new HashMap(b0.this.f3285b).entrySet()) {
                b0.this.c((String) entry.getKey(), ((SavedStateRegistry.b) entry.getValue()).a());
            }
            Set<String> keySet = b0.this.f3284a.keySet();
            ArrayList<? extends Parcelable> arrayList = new ArrayList<>(keySet.size());
            ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>(arrayList.size());
            for (String str : keySet) {
                arrayList.add(str);
                arrayList2.add(b0.this.f3284a.get(str));
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("keys", arrayList);
            bundle.putParcelableArrayList("values", arrayList2);
            return bundle;
        }
    }

    static {
        Class[] clsArr = new Class[29];
        clsArr[0] = Boolean.TYPE;
        clsArr[1] = boolean[].class;
        clsArr[2] = Double.TYPE;
        clsArr[3] = double[].class;
        Class<SizeF> cls = Integer.TYPE;
        clsArr[4] = cls;
        clsArr[5] = int[].class;
        clsArr[6] = Long.TYPE;
        clsArr[7] = long[].class;
        clsArr[8] = String.class;
        clsArr[9] = String[].class;
        clsArr[10] = Binder.class;
        clsArr[11] = Bundle.class;
        clsArr[12] = Byte.TYPE;
        clsArr[13] = byte[].class;
        clsArr[14] = Character.TYPE;
        clsArr[15] = char[].class;
        clsArr[16] = CharSequence.class;
        clsArr[17] = CharSequence[].class;
        clsArr[18] = ArrayList.class;
        clsArr[19] = Float.TYPE;
        clsArr[20] = float[].class;
        clsArr[21] = Parcelable.class;
        clsArr[22] = Parcelable[].class;
        clsArr[23] = Serializable.class;
        clsArr[24] = Short.TYPE;
        clsArr[25] = short[].class;
        clsArr[26] = SparseArray.class;
        int i10 = Build.VERSION.SDK_INT;
        clsArr[27] = i10 >= 21 ? Size.class : cls;
        if (i10 >= 21) {
            cls = SizeF.class;
        }
        clsArr[28] = cls;
        f3283e = clsArr;
    }

    public b0(Map<String, Object> map) {
        this.f3285b = new HashMap();
        this.f3286c = new HashMap();
        this.f3287d = new a();
        this.f3284a = new HashMap(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b0 a(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return new b0();
        }
        HashMap hashMap = new HashMap();
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                hashMap.put(str, bundle2.get(str));
            }
        }
        if (bundle == null) {
            return new b0(hashMap);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        for (int i10 = 0; i10 < parcelableArrayList.size(); i10++) {
            hashMap.put((String) parcelableArrayList.get(i10), parcelableArrayList2.get(i10));
        }
        return new b0(hashMap);
    }

    private static void d(Object obj) {
        if (obj != null) {
            for (Class cls : f3283e) {
                if (cls.isInstance(obj)) {
                    return;
                }
            }
            throw new IllegalArgumentException("Can't put value with type " + obj.getClass() + " into saved state");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SavedStateRegistry.b b() {
        return this.f3287d;
    }

    public <T> void c(String str, T t10) {
        d(t10);
        w wVar = (w) this.f3286c.get(str);
        if (wVar != null) {
            wVar.o(t10);
        } else {
            this.f3284a.put(str, t10);
        }
    }

    public b0() {
        this.f3285b = new HashMap();
        this.f3286c = new HashMap();
        this.f3287d = new a();
        this.f3284a = new HashMap();
    }
}
