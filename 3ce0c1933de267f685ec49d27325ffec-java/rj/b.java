package rj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.record.h;
import com.mobvoi.record.i;
import p1.a;
/* compiled from: RecordFragmentFullTextBinding.java */
/* loaded from: classes2.dex */
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f33530a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f33531b;

    /* renamed from: c  reason: collision with root package name */
    public final i f33532c;

    /* renamed from: d  reason: collision with root package name */
    public final Group f33533d;

    /* renamed from: e  reason: collision with root package name */
    public final RecyclerView f33534e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f33535f;

    private b(FrameLayout frameLayout, Button button, i iVar, Group group, RecyclerView recyclerView, TextView textView) {
        this.f33530a = frameLayout;
        this.f33531b = button;
        this.f33532c = iVar;
        this.f33533d = group;
        this.f33534e = recyclerView;
        this.f33535f = textView;
    }

    public static b b(View view) {
        View a10;
        int i10 = h.f20608n;
        Button button = (Button) p1.b.a(view, i10);
        if (!(button == null || (a10 = p1.b.a(view, (i10 = h.O))) == null)) {
            i b10 = i.b(a10);
            i10 = h.f20587e0;
            Group group = (Group) p1.b.a(view, i10);
            if (group != null) {
                i10 = h.f20603k0;
                RecyclerView recyclerView = (RecyclerView) p1.b.a(view, i10);
                if (recyclerView != null) {
                    i10 = h.U0;
                    TextView textView = (TextView) p1.b.a(view, i10);
                    if (textView != null) {
                        return new b((FrameLayout) view, button, b10, group, recyclerView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.f20642i, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public FrameLayout a() {
        return this.f33530a;
    }
}
