package androidx.navigation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.UUID;
/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class NavBackStackEntryState implements Parcelable {
    public static final Parcelable.Creator<NavBackStackEntryState> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final UUID f3410a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3411b;

    /* renamed from: c  reason: collision with root package name */
    private final Bundle f3412c;

    /* renamed from: d  reason: collision with root package name */
    private final Bundle f3413d;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<NavBackStackEntryState> {
        a() {
        }

        /* renamed from: a */
        public NavBackStackEntryState createFromParcel(Parcel parcel) {
            return new NavBackStackEntryState(parcel);
        }

        /* renamed from: b */
        public NavBackStackEntryState[] newArray(int i10) {
            return new NavBackStackEntryState[i10];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NavBackStackEntryState(f fVar) {
        this.f3410a = fVar.f3453f;
        this.f3411b = fVar.b().i();
        this.f3412c = fVar.a();
        Bundle bundle = new Bundle();
        this.f3413d = bundle;
        fVar.g(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle a() {
        return this.f3412c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f3411b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle c() {
        return this.f3413d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public UUID d() {
        return this.f3410a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f3410a.toString());
        parcel.writeInt(this.f3411b);
        parcel.writeBundle(this.f3412c);
        parcel.writeBundle(this.f3413d);
    }

    NavBackStackEntryState(Parcel parcel) {
        this.f3410a = UUID.fromString(parcel.readString());
        this.f3411b = parcel.readInt();
        this.f3412c = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
        this.f3413d = parcel.readBundle(NavBackStackEntryState.class.getClassLoader());
    }
}
