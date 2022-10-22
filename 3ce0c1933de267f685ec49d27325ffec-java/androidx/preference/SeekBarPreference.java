package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;
/* loaded from: classes.dex */
public class SeekBarPreference extends Preference {
    private TextView A;
    boolean B;
    boolean C;

    /* renamed from: u  reason: collision with root package name */
    int f3615u;

    /* renamed from: v  reason: collision with root package name */
    int f3616v;

    /* renamed from: w  reason: collision with root package name */
    private int f3617w;

    /* renamed from: x  reason: collision with root package name */
    private int f3618x;

    /* renamed from: y  reason: collision with root package name */
    boolean f3619y;

    /* renamed from: z  reason: collision with root package name */
    SeekBar f3620z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        int f3621a;

        /* renamed from: b  reason: collision with root package name */
        int f3622b;

        /* renamed from: c  reason: collision with root package name */
        int f3623c;

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
            this.f3621a = parcel.readInt();
            this.f3622b = parcel.readInt();
            this.f3623c = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeInt(this.f3621a);
            parcel.writeInt(this.f3622b);
            parcel.writeInt(this.f3623c);
        }
    }

    /* loaded from: classes.dex */
    class a implements SeekBar.OnSeekBarChangeListener {
        a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i10, boolean z10) {
            if (z10) {
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (seekBarPreference.C || !seekBarPreference.f3619y) {
                    seekBarPreference.N(seekBar);
                    return;
                }
            }
            SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
            seekBarPreference2.O(i10 + seekBarPreference2.f3616v);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f3619y = true;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBarPreference.this.f3619y = false;
            int progress = seekBar.getProgress();
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if (progress + seekBarPreference.f3616v != seekBarPreference.f3615u) {
                seekBarPreference.N(seekBar);
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements View.OnKeyListener {
        b() {
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i10, KeyEvent keyEvent) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            SeekBarPreference seekBarPreference = SeekBarPreference.this;
            if ((!seekBarPreference.B && (i10 == 21 || i10 == 22)) || i10 == 23 || i10 == 66) {
                return false;
            }
            SeekBar seekBar = seekBarPreference.f3620z;
            if (seekBar != null) {
                return seekBar.onKeyDown(i10, keyEvent);
            }
            Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
            return false;
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        new a();
        new b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.f3698y0, i10, i11);
        this.f3616v = obtainStyledAttributes.getInt(g.B0, 0);
        K(obtainStyledAttributes.getInt(g.f3700z0, 100));
        L(obtainStyledAttributes.getInt(g.C0, 0));
        this.B = obtainStyledAttributes.getBoolean(g.A0, true);
        obtainStyledAttributes.getBoolean(g.D0, false);
        this.C = obtainStyledAttributes.getBoolean(g.E0, false);
        obtainStyledAttributes.recycle();
    }

    private void M(int i10, boolean z10) {
        int i11 = this.f3616v;
        if (i10 < i11) {
            i10 = i11;
        }
        int i12 = this.f3617w;
        if (i10 > i12) {
            i10 = i12;
        }
        if (i10 != this.f3615u) {
            this.f3615u = i10;
            O(i10);
            F(i10);
            if (z10) {
                w();
            }
        }
    }

    @Override // androidx.preference.Preference
    protected Object A(TypedArray typedArray, int i10) {
        return Integer.valueOf(typedArray.getInt(i10, 0));
    }

    public final void K(int i10) {
        int i11 = this.f3616v;
        if (i10 < i11) {
            i10 = i11;
        }
        if (i10 != this.f3617w) {
            this.f3617w = i10;
            w();
        }
    }

    public final void L(int i10) {
        if (i10 != this.f3618x) {
            this.f3618x = Math.min(this.f3617w - this.f3616v, Math.abs(i10));
            w();
        }
    }

    void N(SeekBar seekBar) {
        int progress = this.f3616v + seekBar.getProgress();
        if (progress == this.f3615u) {
            return;
        }
        if (a(Integer.valueOf(progress))) {
            M(progress, false);
            return;
        }
        seekBar.setProgress(this.f3615u - this.f3616v);
        O(this.f3615u);
    }

    void O(int i10) {
        TextView textView = this.A;
        if (textView != null) {
            textView.setText(String.valueOf(i10));
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, c.f3643h);
    }
}
