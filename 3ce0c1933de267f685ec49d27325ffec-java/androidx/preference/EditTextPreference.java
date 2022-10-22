package androidx.preference;

import a0.i;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.preference.Preference;
/* loaded from: classes.dex */
public class EditTextPreference extends DialogPreference {

    /* renamed from: v  reason: collision with root package name */
    private String f3579v;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        String f3580a;

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
            this.f3580a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f3580a);
        }
    }

    /* loaded from: classes.dex */
    public static final class a implements Preference.e<EditTextPreference> {

        /* renamed from: a  reason: collision with root package name */
        private static a f3581a;

        private a() {
        }

        public static a b() {
            if (f3581a == null) {
                f3581a = new a();
            }
            return f3581a;
        }

        /* renamed from: c */
        public CharSequence a(EditTextPreference editTextPreference) {
            if (TextUtils.isEmpty(editTextPreference.K())) {
                return editTextPreference.c().getString(f.a_res_0x7f140c11);
            }
            return editTextPreference.K();
        }
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f3689u, i10, i11);
        int i12 = g.f3691v;
        if (i.b(obtainStyledAttributes, i12, i12, false)) {
            H(a.b());
        }
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.preference.Preference
    protected Object A(TypedArray typedArray, int i10) {
        return typedArray.getString(i10);
    }

    @Override // androidx.preference.Preference
    public boolean I() {
        return TextUtils.isEmpty(this.f3579v) || super.I();
    }

    public String K() {
        return this.f3579v;
    }

    public EditTextPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public EditTextPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, c.f3639d, 16842898));
    }
}
