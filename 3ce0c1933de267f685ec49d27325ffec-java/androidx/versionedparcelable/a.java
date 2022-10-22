package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;
import java.lang.reflect.Method;
/* compiled from: VersionedParcelParcel.java */
/* loaded from: classes.dex */
class a extends VersionedParcel {

    /* renamed from: d  reason: collision with root package name */
    private final SparseIntArray f4540d;

    /* renamed from: e  reason: collision with root package name */
    private final Parcel f4541e;

    /* renamed from: f  reason: collision with root package name */
    private final int f4542f;

    /* renamed from: g  reason: collision with root package name */
    private final int f4543g;

    /* renamed from: h  reason: collision with root package name */
    private final String f4544h;

    /* renamed from: i  reason: collision with root package name */
    private int f4545i;

    /* renamed from: j  reason: collision with root package name */
    private int f4546j;

    /* renamed from: k  reason: collision with root package name */
    private int f4547k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new androidx.collection.a(), new androidx.collection.a(), new androidx.collection.a());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void A(byte[] bArr) {
        if (bArr != null) {
            this.f4541e.writeInt(bArr.length);
            this.f4541e.writeByteArray(bArr);
            return;
        }
        this.f4541e.writeInt(-1);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected void C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f4541e, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void E(int i10) {
        this.f4541e.writeInt(i10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void G(Parcelable parcelable) {
        this.f4541e.writeParcelable(parcelable, 0);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void I(String str) {
        this.f4541e.writeString(str);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void a() {
        int i10 = this.f4545i;
        if (i10 >= 0) {
            int i11 = this.f4540d.get(i10);
            int dataPosition = this.f4541e.dataPosition();
            this.f4541e.setDataPosition(i11);
            this.f4541e.writeInt(dataPosition - i11);
            this.f4541e.setDataPosition(dataPosition);
        }
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected VersionedParcel b() {
        Parcel parcel = this.f4541e;
        int dataPosition = parcel.dataPosition();
        int i10 = this.f4546j;
        if (i10 == this.f4542f) {
            i10 = this.f4543g;
        }
        int i11 = i10;
        return new a(parcel, dataPosition, i11, this.f4544h + "  ", this.f4537a, this.f4538b, this.f4539c);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean g() {
        return this.f4541e.readInt() != 0;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public byte[] i() {
        int readInt = this.f4541e.readInt();
        if (readInt < 0) {
            return null;
        }
        byte[] bArr = new byte[readInt];
        this.f4541e.readByteArray(bArr);
        return bArr;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    protected CharSequence k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f4541e);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public boolean m(int i10) {
        while (this.f4546j < this.f4543g) {
            int i11 = this.f4547k;
            if (i11 == i10) {
                return true;
            }
            if (String.valueOf(i11).compareTo(String.valueOf(i10)) > 0) {
                return false;
            }
            this.f4541e.setDataPosition(this.f4546j);
            int readInt = this.f4541e.readInt();
            this.f4547k = this.f4541e.readInt();
            this.f4546j += readInt;
        }
        return this.f4547k == i10;
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public int o() {
        return this.f4541e.readInt();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public <T extends Parcelable> T q() {
        return (T) this.f4541e.readParcelable(a.class.getClassLoader());
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public String s() {
        return this.f4541e.readString();
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void w(int i10) {
        a();
        this.f4545i = i10;
        this.f4540d.put(i10, this.f4541e.dataPosition());
        E(0);
        E(i10);
    }

    @Override // androidx.versionedparcelable.VersionedParcel
    public void y(boolean z10) {
        this.f4541e.writeInt(z10 ? 1 : 0);
    }

    private a(Parcel parcel, int i10, int i11, String str, androidx.collection.a<String, Method> aVar, androidx.collection.a<String, Method> aVar2, androidx.collection.a<String, Class> aVar3) {
        super(aVar, aVar2, aVar3);
        this.f4540d = new SparseIntArray();
        this.f4545i = -1;
        this.f4546j = 0;
        this.f4547k = -1;
        this.f4541e = parcel;
        this.f4542f = i10;
        this.f4543g = i11;
        this.f4546j = i10;
        this.f4544h = str;
    }
}
