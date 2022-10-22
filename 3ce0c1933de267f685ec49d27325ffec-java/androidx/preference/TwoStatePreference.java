package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.preference.Preference;
/* loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {

    /* renamed from: u  reason: collision with root package name */
    protected boolean f3630u;

    /* renamed from: v  reason: collision with root package name */
    private CharSequence f3631v;

    /* renamed from: w  reason: collision with root package name */
    private CharSequence f3632w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f3633x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f3634y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        boolean f3635a;

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
            this.f3635a = parcel.readInt() != 1 ? false : true;
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f3635a ? 1 : 0);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }

    @Override // androidx.preference.Preference
    protected Object A(TypedArray typedArray, int i10) {
        return Boolean.valueOf(typedArray.getBoolean(i10, false));
    }

    @Override // androidx.preference.Preference
    public boolean I() {
        return (this.f3634y ? this.f3630u : !this.f3630u) || super.I();
    }

    public boolean K() {
        return this.f3630u;
    }

    public void L(boolean z10) {
        boolean z11 = this.f3630u != z10;
        if (z11 || !this.f3633x) {
            this.f3630u = z10;
            this.f3633x = true;
            E(z10);
            if (z11) {
                x(I());
                w();
            }
        }
    }

    public void M(boolean z10) {
        this.f3634y = z10;
    }

    public void N(CharSequence charSequence) {
        this.f3632w = charSequence;
        if (!K()) {
            w();
        }
    }

    public void O(CharSequence charSequence) {
        this.f3631v = charSequence;
        if (K()) {
            w();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void P(View view) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            boolean z10 = true;
            int i10 = 0;
            if (!this.f3630u || TextUtils.isEmpty(this.f3631v)) {
                if (!this.f3630u && !TextUtils.isEmpty(this.f3632w)) {
                    textView.setText(this.f3632w);
                }
                if (z10) {
                    CharSequence l10 = l();
                    if (!TextUtils.isEmpty(l10)) {
                        textView.setText(l10);
                        z10 = false;
                    }
                }
                i10 = 8;
                if (z10) {
                }
                if (i10 == textView.getVisibility()) {
                    textView.setVisibility(i10);
                    return;
                }
                return;
            }
            textView.setText(this.f3631v);
            z10 = false;
            if (z10) {
            }
            i10 = 8;
            if (z10) {
            }
            if (i10 == textView.getVisibility()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.preference.Preference
    public void y() {
        super.y();
        boolean z10 = !K();
        if (a(Boolean.valueOf(z10))) {
            L(z10);
        }
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
