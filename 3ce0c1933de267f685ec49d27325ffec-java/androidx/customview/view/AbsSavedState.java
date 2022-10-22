package androidx.customview.view;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public abstract class AbsSavedState implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    private final Parcelable f2707a;

    /* renamed from: b  reason: collision with root package name */
    public static final AbsSavedState f2706b = new AbsSavedState() { // from class: androidx.customview.view.AbsSavedState.1
    };
    public static final Parcelable.Creator<AbsSavedState> CREATOR = new a();

    /* loaded from: classes.dex */
    class a implements Parcelable.ClassLoaderCreator<AbsSavedState> {
        a() {
        }

        /* renamed from: a */
        public AbsSavedState createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        /* renamed from: b */
        public AbsSavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbsSavedState.f2706b;
            }
            throw new IllegalStateException("superState must be null");
        }

        /* renamed from: c */
        public AbsSavedState[] newArray(int i10) {
            return new AbsSavedState[i10];
        }
    }

    public final Parcelable a() {
        return this.f2707a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f2707a, i10);
    }

    private AbsSavedState() {
        this.f2707a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbsSavedState(Parcelable parcelable) {
        if (parcelable != null) {
            this.f2707a = parcelable == f2706b ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        this.f2707a = readParcelable == null ? f2706b : readParcelable;
    }
}
