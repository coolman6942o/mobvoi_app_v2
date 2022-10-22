package rj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.mobvoi.record.h;
import com.mobvoi.record.i;
import com.mobvoi.record.view.audiowave.AudioWaveView;
import p1.a;
import p1.b;
/* compiled from: RecordFragmentRecordDetailBinding.java */
/* loaded from: classes2.dex */
public final class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f33555a;

    /* renamed from: b  reason: collision with root package name */
    public final AudioWaveView f33556b;

    /* renamed from: c  reason: collision with root package name */
    public final DrawerLayout f33557c;

    /* renamed from: d  reason: collision with root package name */
    public final Group f33558d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageButton f33559e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f33560f;

    /* renamed from: g  reason: collision with root package name */
    public final LinearLayout f33561g;

    /* renamed from: h  reason: collision with root package name */
    public final RecyclerView f33562h;

    /* renamed from: i  reason: collision with root package name */
    public final SwipeRefreshLayout f33563i;

    /* renamed from: j  reason: collision with root package name */
    public final Toolbar f33564j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f33565k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f33566l;

    /* renamed from: m  reason: collision with root package name */
    public final TextView f33567m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f33568n;

    /* renamed from: o  reason: collision with root package name */
    public final TextView f33569o;

    /* renamed from: p  reason: collision with root package name */
    public final TextView f33570p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f33571q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f33572r;

    private d(LinearLayout linearLayout, AudioWaveView audioWaveView, DrawerLayout drawerLayout, FrameLayout frameLayout, Group group, HorizontalScrollView horizontalScrollView, ImageButton imageButton, ConstraintLayout constraintLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, RecyclerView recyclerView, SwipeRefreshLayout swipeRefreshLayout, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8) {
        this.f33555a = linearLayout;
        this.f33556b = audioWaveView;
        this.f33557c = drawerLayout;
        this.f33558d = group;
        this.f33559e = imageButton;
        this.f33560f = linearLayout2;
        this.f33561g = linearLayout4;
        this.f33562h = recyclerView;
        this.f33563i = swipeRefreshLayout;
        this.f33564j = toolbar;
        this.f33565k = textView;
        this.f33566l = textView2;
        this.f33567m = textView3;
        this.f33568n = textView4;
        this.f33569o = textView5;
        this.f33570p = textView6;
        this.f33571q = textView7;
        this.f33572r = textView8;
    }

    public static d b(View view) {
        int i10 = h.f20598i;
        AudioWaveView audioWaveView = (AudioWaveView) b.a(view, i10);
        if (audioWaveView != null) {
            i10 = h.f20620t;
            DrawerLayout drawerLayout = (DrawerLayout) b.a(view, i10);
            if (drawerLayout != null) {
                i10 = h.f20630y;
                FrameLayout frameLayout = (FrameLayout) b.a(view, i10);
                if (frameLayout != null) {
                    i10 = h.f20632z;
                    Group group = (Group) b.a(view, i10);
                    if (group != null) {
                        i10 = h.A;
                        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) b.a(view, i10);
                        if (horizontalScrollView != null) {
                            i10 = h.B;
                            ImageButton imageButton = (ImageButton) b.a(view, i10);
                            if (imageButton != null) {
                                i10 = h.P;
                                ConstraintLayout constraintLayout = (ConstraintLayout) b.a(view, i10);
                                if (constraintLayout != null) {
                                    i10 = h.f20575a0;
                                    LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
                                    if (linearLayout != null) {
                                        i10 = h.f20578b0;
                                        LinearLayout linearLayout2 = (LinearLayout) b.a(view, i10);
                                        if (linearLayout2 != null) {
                                            i10 = h.f20581c0;
                                            LinearLayout linearLayout3 = (LinearLayout) b.a(view, i10);
                                            if (linearLayout3 != null) {
                                                i10 = h.f20601j0;
                                                RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
                                                if (recyclerView != null) {
                                                    i10 = h.f20611o0;
                                                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) b.a(view, i10);
                                                    if (swipeRefreshLayout != null) {
                                                        i10 = h.f20615q0;
                                                        Toolbar toolbar = (Toolbar) b.a(view, i10);
                                                        if (toolbar != null) {
                                                            i10 = h.f20631y0;
                                                            TextView textView = (TextView) b.a(view, i10);
                                                            if (textView != null) {
                                                                i10 = h.B0;
                                                                TextView textView2 = (TextView) b.a(view, i10);
                                                                if (textView2 != null) {
                                                                    i10 = h.C0;
                                                                    TextView textView3 = (TextView) b.a(view, i10);
                                                                    if (textView3 != null) {
                                                                        i10 = h.E0;
                                                                        TextView textView4 = (TextView) b.a(view, i10);
                                                                        if (textView4 != null) {
                                                                            i10 = h.R0;
                                                                            TextView textView5 = (TextView) b.a(view, i10);
                                                                            if (textView5 != null) {
                                                                                i10 = h.f20579b1;
                                                                                TextView textView6 = (TextView) b.a(view, i10);
                                                                                if (textView6 != null) {
                                                                                    i10 = h.f20585d1;
                                                                                    TextView textView7 = (TextView) b.a(view, i10);
                                                                                    if (textView7 != null) {
                                                                                        i10 = h.f20594g1;
                                                                                        TextView textView8 = (TextView) b.a(view, i10);
                                                                                        if (textView8 != null) {
                                                                                            return new d((LinearLayout) view, audioWaveView, drawerLayout, frameLayout, group, horizontalScrollView, imageButton, constraintLayout, linearLayout, linearLayout2, linearLayout3, recyclerView, swipeRefreshLayout, toolbar, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.f20644k, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f33555a;
    }
}
