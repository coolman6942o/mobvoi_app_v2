package androidx.preference;

import a0.i;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.AbsSavedState;
import android.view.View;
import java.util.List;
/* loaded from: classes.dex */
public class Preference implements Comparable<Preference> {

    /* renamed from: a  reason: collision with root package name */
    private Context f3590a;

    /* renamed from: b  reason: collision with root package name */
    private androidx.preference.b f3591b;

    /* renamed from: c  reason: collision with root package name */
    private c f3592c;

    /* renamed from: d  reason: collision with root package name */
    private d f3593d;

    /* renamed from: e  reason: collision with root package name */
    private int f3594e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f3595f;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f3596g;

    /* renamed from: h  reason: collision with root package name */
    private String f3597h;

    /* renamed from: i  reason: collision with root package name */
    private Intent f3598i;

    /* renamed from: j  reason: collision with root package name */
    private String f3599j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3600k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3601l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f3602m;

    /* renamed from: n  reason: collision with root package name */
    private Object f3603n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f3604o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f3605p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f3606q;

    /* renamed from: r  reason: collision with root package name */
    private b f3607r;

    /* renamed from: s  reason: collision with root package name */
    private List<Preference> f3608s;

    /* renamed from: t  reason: collision with root package name */
    private e f3609t;

    /* loaded from: classes.dex */
    public static class BaseSavedState extends AbsSavedState {
        public static final Parcelable.Creator<BaseSavedState> CREATOR = new a();

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<BaseSavedState> {
            a() {
            }

            /* renamed from: a */
            public BaseSavedState createFromParcel(Parcel parcel) {
                return new BaseSavedState(parcel);
            }

            /* renamed from: b */
            public BaseSavedState[] newArray(int i10) {
                return new BaseSavedState[i10];
            }
        }

        public BaseSavedState(Parcel parcel) {
            super(parcel);
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Preference.this.D(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface b {
        void a(Preference preference);
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(Preference preference, Object obj);
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean a(Preference preference);
    }

    /* loaded from: classes.dex */
    public interface e<T extends Preference> {
        CharSequence a(T t10);
    }

    public Preference(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f3594e = Integer.MAX_VALUE;
        this.f3600k = true;
        this.f3601l = true;
        this.f3602m = true;
        this.f3604o = true;
        this.f3605p = true;
        int i12 = androidx.preference.e.f3647a;
        new a();
        this.f3590a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.H, i10, i11);
        i.n(obtainStyledAttributes, g.f3660f0, g.I, 0);
        this.f3597h = i.o(obtainStyledAttributes, g.f3666i0, g.O);
        this.f3595f = i.p(obtainStyledAttributes, g.f3682q0, g.M);
        this.f3596g = i.p(obtainStyledAttributes, g.f3680p0, g.P);
        this.f3594e = i.d(obtainStyledAttributes, g.f3670k0, g.Q, Integer.MAX_VALUE);
        this.f3599j = i.o(obtainStyledAttributes, g.f3658e0, g.V);
        i.n(obtainStyledAttributes, g.f3668j0, g.L, i12);
        i.n(obtainStyledAttributes, g.f3684r0, g.R, 0);
        this.f3600k = i.b(obtainStyledAttributes, g.f3656d0, g.K, true);
        this.f3601l = i.b(obtainStyledAttributes, g.f3674m0, g.N, true);
        this.f3602m = i.b(obtainStyledAttributes, g.f3672l0, g.J, true);
        i.o(obtainStyledAttributes, g.f3652b0, g.S);
        int i13 = g.Y;
        i.b(obtainStyledAttributes, i13, i13, this.f3601l);
        int i14 = g.Z;
        i.b(obtainStyledAttributes, i14, i14, this.f3601l);
        int i15 = g.f3649a0;
        if (obtainStyledAttributes.hasValue(i15)) {
            this.f3603n = A(obtainStyledAttributes, i15);
        } else {
            int i16 = g.T;
            if (obtainStyledAttributes.hasValue(i16)) {
                this.f3603n = A(obtainStyledAttributes, i16);
            }
        }
        i.b(obtainStyledAttributes, g.f3676n0, g.U, true);
        int i17 = g.f3678o0;
        boolean hasValue = obtainStyledAttributes.hasValue(i17);
        this.f3606q = hasValue;
        if (hasValue) {
            i.b(obtainStyledAttributes, i17, g.W, true);
        }
        i.b(obtainStyledAttributes, g.f3662g0, g.X, false);
        int i18 = g.f3664h0;
        i.b(obtainStyledAttributes, i18, i18, true);
        int i19 = g.f3654c0;
        i.b(obtainStyledAttributes, i19, i19, false);
        obtainStyledAttributes.recycle();
    }

    protected Object A(TypedArray typedArray, int i10) {
        return null;
    }

    public void B(Preference preference, boolean z10) {
        if (this.f3605p == z10) {
            this.f3605p = !z10;
            x(I());
            w();
        }
    }

    public void C() {
        if (u() && v()) {
            y();
            d dVar = this.f3593d;
            if (dVar == null || !dVar.a(this)) {
                k();
                if (this.f3598i != null) {
                    c().startActivity(this.f3598i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(View view) {
        C();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean E(boolean z10) {
        if (!J()) {
            return false;
        }
        if (z10 == g(!z10)) {
            return true;
        }
        j();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean F(int i10) {
        if (!J()) {
            return false;
        }
        if (i10 == h(~i10)) {
            return true;
        }
        j();
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean G(String str) {
        if (!J()) {
            return false;
        }
        if (TextUtils.equals(str, i(null))) {
            return true;
        }
        j();
        throw null;
    }

    public final void H(e eVar) {
        this.f3609t = eVar;
        w();
    }

    public boolean I() {
        return !u();
    }

    protected boolean J() {
        return false;
    }

    public boolean a(Object obj) {
        c cVar = this.f3592c;
        return cVar == null || cVar.a(this, obj);
    }

    /* renamed from: b */
    public int compareTo(Preference preference) {
        int i10 = this.f3594e;
        int i11 = preference.f3594e;
        if (i10 != i11) {
            return i10 - i11;
        }
        CharSequence charSequence = this.f3595f;
        CharSequence charSequence2 = preference.f3595f;
        if (charSequence == charSequence2) {
            return 0;
        }
        if (charSequence == null) {
            return 1;
        }
        if (charSequence2 == null) {
            return -1;
        }
        return charSequence.toString().compareToIgnoreCase(preference.f3595f.toString());
    }

    public Context c() {
        return this.f3590a;
    }

    StringBuilder d() {
        StringBuilder sb2 = new StringBuilder();
        CharSequence n10 = n();
        if (!TextUtils.isEmpty(n10)) {
            sb2.append(n10);
            sb2.append(' ');
        }
        CharSequence l10 = l();
        if (!TextUtils.isEmpty(l10)) {
            sb2.append(l10);
            sb2.append(' ');
        }
        if (sb2.length() > 0) {
            sb2.setLength(sb2.length() - 1);
        }
        return sb2;
    }

    public String e() {
        return this.f3599j;
    }

    public Intent f() {
        return this.f3598i;
    }

    protected boolean g(boolean z10) {
        if (!J()) {
            return z10;
        }
        j();
        throw null;
    }

    protected int h(int i10) {
        if (!J()) {
            return i10;
        }
        j();
        throw null;
    }

    protected String i(String str) {
        if (!J()) {
            return str;
        }
        j();
        throw null;
    }

    public androidx.preference.a j() {
        return null;
    }

    public androidx.preference.b k() {
        return this.f3591b;
    }

    public CharSequence l() {
        if (m() != null) {
            return m().a(this);
        }
        return this.f3596g;
    }

    public final e m() {
        return this.f3609t;
    }

    public CharSequence n() {
        return this.f3595f;
    }

    public boolean q() {
        return !TextUtils.isEmpty(this.f3597h);
    }

    public String toString() {
        return d().toString();
    }

    public boolean u() {
        return this.f3600k && this.f3604o && this.f3605p;
    }

    public boolean v() {
        return this.f3601l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w() {
        b bVar = this.f3607r;
        if (bVar != null) {
            bVar.a(this);
        }
    }

    public void x(boolean z10) {
        List<Preference> list = this.f3608s;
        if (list != null) {
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                list.get(i10).z(this, z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y() {
    }

    public void z(Preference preference, boolean z10) {
        if (this.f3604o == z10) {
            this.f3604o = !z10;
            x(I());
            w();
        }
    }

    public Preference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
    }

    public Preference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, i.a(context, androidx.preference.c.f3642g, 16842894));
    }
}
