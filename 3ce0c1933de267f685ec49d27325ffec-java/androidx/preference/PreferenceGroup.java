package androidx.preference;

import a0.i;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import androidx.collection.f;
import androidx.preference.Preference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {

    /* renamed from: u  reason: collision with root package name */
    final f<String, Long> f3611u;

    /* renamed from: v  reason: collision with root package name */
    private List<Preference> f3612v;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f3613a;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.f3613a = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f3613a);
        }
    }

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                PreferenceGroup.this.f3611u.clear();
            }
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        this.f3611u = new f<>();
        new Handler();
        new a();
        this.f3612v = new ArrayList();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f3686s0, i10, i11);
        int i12 = g.f3690u0;
        i.b(obtainStyledAttributes, i12, i12, true);
        int i13 = g.f3688t0;
        if (obtainStyledAttributes.hasValue(i13)) {
            M(i.d(obtainStyledAttributes, i13, i13, Integer.MAX_VALUE));
        }
        obtainStyledAttributes.recycle();
    }

    public Preference K(int i10) {
        return this.f3612v.get(i10);
    }

    public int L() {
        return this.f3612v.size();
    }

    public void M(int i10) {
        if (i10 != Integer.MAX_VALUE && !q()) {
            Log.e("PreferenceGroup", getClass().getSimpleName() + " should have a key defined if it contains an expandable preference");
        }
    }

    @Override // androidx.preference.Preference
    public void x(boolean z10) {
        super.x(z10);
        int L = L();
        for (int i10 = 0; i10 < L; i10++) {
            K(i10).B(this, z10);
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
