package androidx.preference;

import a0.i;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.preference.Preference;
/* loaded from: classes.dex */
public class ListPreference extends DialogPreference {

    /* renamed from: v  reason: collision with root package name */
    private CharSequence[] f3582v;

    /* renamed from: w  reason: collision with root package name */
    private CharSequence[] f3583w;

    /* renamed from: x  reason: collision with root package name */
    private String f3584x;

    /* renamed from: y  reason: collision with root package name */
    private String f3585y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f3586z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        String f3587a;

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
            this.f3587a = parcel.readString();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f3587a);
        }
    }

    /* loaded from: classes.dex */
    public static final class a implements Preference.e<ListPreference> {

        /* renamed from: a  reason: collision with root package name */
        private static a f3588a;

        private a() {
        }

        public static a b() {
            if (f3588a == null) {
                f3588a = new a();
            }
            return f3588a;
        }

        /* renamed from: c */
        public CharSequence a(ListPreference listPreference) {
            if (TextUtils.isEmpty(listPreference.M())) {
                return listPreference.c().getString(f.a_res_0x7f140c11);
            }
            return listPreference.M();
        }
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f3693w, i10, i11);
        this.f3582v = i.q(obtainStyledAttributes, g.f3699z, g.f3695x);
        this.f3583w = i.q(obtainStyledAttributes, g.A, g.f3697y);
        int i12 = g.B;
        if (i.b(obtainStyledAttributes, i12, i12, false)) {
            H(a.b());
        }
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.H, i10, i11);
        this.f3585y = i.o(obtainStyledAttributes2, g.f3680p0, g.P);
        obtainStyledAttributes2.recycle();
    }

    private int P() {
        return K(this.f3584x);
    }

    @Override // androidx.preference.Preference
    protected Object A(TypedArray typedArray, int i10) {
        return typedArray.getString(i10);
    }

    public int K(String str) {
        CharSequence[] charSequenceArr;
        if (str == null || (charSequenceArr = this.f3583w) == null) {
            return -1;
        }
        for (int length = charSequenceArr.length - 1; length >= 0; length--) {
            if (this.f3583w[length].equals(str)) {
                return length;
            }
        }
        return -1;
    }

    public CharSequence[] L() {
        return this.f3582v;
    }

    public CharSequence M() {
        CharSequence[] charSequenceArr;
        int P = P();
        if (P < 0 || (charSequenceArr = this.f3582v) == null) {
            return null;
        }
        return charSequenceArr[P];
    }

    public CharSequence[] N() {
        return this.f3583w;
    }

    public String O() {
        return this.f3584x;
    }

    public void Q(String str) {
        boolean z10 = !TextUtils.equals(this.f3584x, str);
        if (z10 || !this.f3586z) {
            this.f3584x = str;
            this.f3586z = true;
            G(str);
            if (z10) {
                w();
            }
        }
    }

    @Override // androidx.preference.Preference
    public CharSequence l() {
        if (m() != null) {
            return m().a(this);
        }
        CharSequence M = M();
        CharSequence l10 = super.l();
        String str = this.f3585y;
        if (str == null) {
            return l10;
        }
        Object[] objArr = new Object[1];
        if (M == null) {
            M = "";
        }
        objArr[0] = M;
        String format = String.format(str, objArr);
        if (TextUtils.equals(format, l10)) {
            return l10;
        }
        Log.w("ListPreference", "Setting a summary with a String formatting marker is no longer supported. You should use a SummaryProvider instead.");
        return format;
    }

    public ListPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public ListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, c.f3637b, 16842897));
    }
}
