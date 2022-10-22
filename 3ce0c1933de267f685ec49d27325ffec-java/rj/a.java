package rj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.record.h;
import com.mobvoi.record.i;
import com.mobvoi.record.view.audiowave.AudioWaveView;
import p1.b;
/* compiled from: RecordDialogParagraphChangeBinding.java */
/* loaded from: classes2.dex */
public final class a implements p1.a {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f33524a;

    /* renamed from: b  reason: collision with root package name */
    public final AudioWaveView f33525b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f33526c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f33527d;

    /* renamed from: e  reason: collision with root package name */
    public final EditText f33528e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageButton f33529f;

    private a(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, AudioWaveView audioWaveView, TextView textView, TextView textView2, LinearLayout linearLayout, EditText editText, ImageButton imageButton) {
        this.f33524a = relativeLayout;
        this.f33525b = audioWaveView;
        this.f33526c = textView;
        this.f33527d = textView2;
        this.f33528e = editText;
        this.f33529f = imageButton;
    }

    public static a b(View view) {
        int i10 = h.f20595h;
        RelativeLayout relativeLayout = (RelativeLayout) b.a(view, i10);
        if (relativeLayout != null) {
            i10 = h.f20598i;
            AudioWaveView audioWaveView = (AudioWaveView) b.a(view, i10);
            if (audioWaveView != null) {
                i10 = h.f20602k;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null) {
                    i10 = h.f20612p;
                    TextView textView2 = (TextView) b.a(view, i10);
                    if (textView2 != null) {
                        i10 = h.f20618s;
                        LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
                        if (linearLayout != null) {
                            i10 = h.f20628x;
                            EditText editText = (EditText) b.a(view, i10);
                            if (editText != null) {
                                i10 = h.B;
                                ImageButton imageButton = (ImageButton) b.a(view, i10);
                                if (imageButton != null) {
                                    return new a((RelativeLayout) view, relativeLayout, audioWaveView, textView, textView2, linearLayout, editText, imageButton);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static a d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static a e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.f20640g, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public RelativeLayout a() {
        return this.f33524a;
    }
}
