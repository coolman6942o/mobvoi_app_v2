package ch;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.mobvoi.companion.base.settings.a;
import com.mobvoi.fitness.core.data.pojo.SportDataType;
import ef.f0;
import fg.q;
import fg.s;
import fg.t;
import java.util.ArrayList;
import java.util.List;
import lf.c;
/* compiled from: HealthSwimTypeAdapter.java */
/* loaded from: classes2.dex */
public class b extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    private List<f0> f5897a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private Context f5898b;

    /* renamed from: c  reason: collision with root package name */
    private View.OnClickListener f5899c;

    public b(Context context, List<f0> list, View.OnClickListener onClickListener) {
        this.f5898b = context;
        this.f5899c = onClickListener;
        f0 f0Var = new f0(1.0f, 0, 0);
        f0 f0Var2 = new f0(1.0f, 1, 0);
        f0 f0Var3 = new f0(1.0f, 2, 0);
        f0 f0Var4 = new f0(1.0f, 3, 0);
        f0 f0Var5 = new f0(1.0f, 4, 0);
        for (f0 f0Var6 : list) {
            int i10 = f0Var6.f25936a;
            if (i10 == 0) {
                f0Var.f25937b += f0Var6.f25937b;
            } else if (i10 == 1) {
                f0Var2.f25937b += f0Var6.f25937b;
            } else if (i10 == 2) {
                f0Var3.f25937b += f0Var6.f25937b;
            } else if (i10 == 3) {
                f0Var4.f25937b += f0Var6.f25937b;
            } else if (i10 == 4) {
                f0Var5.f25937b += f0Var6.f25937b;
            }
        }
        this.f5897a.clear();
        if (f0Var2.f25937b > 0) {
            this.f5897a.add(f0Var2);
        }
        if (f0Var3.f25937b > 0) {
            this.f5897a.add(f0Var3);
        }
        if (f0Var4.f25937b > 0) {
            this.f5897a.add(f0Var4);
        }
        if (f0Var5.f25937b > 0) {
            this.f5897a.add(f0Var5);
        }
        if (f0Var.f25937b > 0) {
            this.f5897a.add(f0Var);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f5897a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return Integer.valueOf(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"DefaultLocale"})
    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f5898b).inflate(t.J, (ViewGroup) null, false);
            TextView textView = (TextView) view.findViewById(s.F4);
            TextView textView2 = (TextView) view.findViewById(s.G4);
            int i11 = this.f5897a.get(i10).f25936a;
            if (i11 != 0 || this.f5899c == null) {
                textView.setText(lf.b.g(this.f5898b, i11));
                textView2.setText(String.format("%d%s", Integer.valueOf(this.f5897a.get(i10).f25937b), c.a(this.f5898b.getResources(), !a.isUnitMetric(this.f5898b), SportDataType.SwimDistance)));
            } else {
                textView.setText(lf.b.g(this.f5898b, i11));
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, q.f26631v2, 0);
                textView.setOnClickListener(this.f5899c);
            }
        }
        return view;
    }
}
