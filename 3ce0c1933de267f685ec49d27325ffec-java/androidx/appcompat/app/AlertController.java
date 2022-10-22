package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.d0;
import androidx.core.widget.NestedScrollView;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import d.j;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;

    /* renamed from: a  reason: collision with root package name */
    private final Context f355a;

    /* renamed from: b  reason: collision with root package name */
    final androidx.appcompat.app.g f356b;

    /* renamed from: c  reason: collision with root package name */
    private final Window f357c;

    /* renamed from: d  reason: collision with root package name */
    private final int f358d;

    /* renamed from: e  reason: collision with root package name */
    private CharSequence f359e;

    /* renamed from: f  reason: collision with root package name */
    private CharSequence f360f;

    /* renamed from: g  reason: collision with root package name */
    ListView f361g;

    /* renamed from: h  reason: collision with root package name */
    private View f362h;

    /* renamed from: i  reason: collision with root package name */
    private int f363i;

    /* renamed from: j  reason: collision with root package name */
    private int f364j;

    /* renamed from: k  reason: collision with root package name */
    private int f365k;

    /* renamed from: l  reason: collision with root package name */
    private int f366l;

    /* renamed from: m  reason: collision with root package name */
    private int f367m;

    /* renamed from: o  reason: collision with root package name */
    Button f369o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f370p;

    /* renamed from: q  reason: collision with root package name */
    Message f371q;

    /* renamed from: r  reason: collision with root package name */
    private Drawable f372r;

    /* renamed from: s  reason: collision with root package name */
    Button f373s;

    /* renamed from: t  reason: collision with root package name */
    private CharSequence f374t;

    /* renamed from: u  reason: collision with root package name */
    Message f375u;

    /* renamed from: v  reason: collision with root package name */
    private Drawable f376v;

    /* renamed from: w  reason: collision with root package name */
    Button f377w;

    /* renamed from: x  reason: collision with root package name */
    private CharSequence f378x;

    /* renamed from: y  reason: collision with root package name */
    Message f379y;

    /* renamed from: z  reason: collision with root package name */
    private Drawable f380z;

    /* renamed from: n  reason: collision with root package name */
    private boolean f368n = false;
    private int B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new a();

    /* loaded from: classes.dex */
    public static class RecycleListView extends ListView {

        /* renamed from: a  reason: collision with root package name */
        private final int f381a;

        /* renamed from: b  reason: collision with root package name */
        private final int f382b;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f24882f2);
            this.f382b = obtainStyledAttributes.getDimensionPixelOffset(j.f24887g2, -1);
            this.f381a = obtainStyledAttributes.getDimensionPixelOffset(j.f24892h2, -1);
        }

        public void a(boolean z10, boolean z11) {
            if (!z11 || !z10) {
                setPadding(getPaddingLeft(), z10 ? getPaddingTop() : this.f381a, getPaddingRight(), z11 ? getPaddingBottom() : this.f382b);
            }
        }
    }

    /* loaded from: classes.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message message;
            Message message2;
            Message message3;
            Message message4;
            AlertController alertController = AlertController.this;
            if (view == alertController.f369o && (message4 = alertController.f371q) != null) {
                message = Message.obtain(message4);
            } else if (view != alertController.f373s || (message3 = alertController.f375u) == null) {
                message = (view != alertController.f377w || (message2 = alertController.f379y) == null) ? null : Message.obtain(message2);
            } else {
                message = Message.obtain(message3);
            }
            if (message != null) {
                message.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f356b).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements NestedScrollView.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f384a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f385b;

        b(AlertController alertController, View view, View view2) {
            this.f384a = view;
            this.f385b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.b
        public void w(NestedScrollView nestedScrollView, int i10, int i11, int i12, int i13) {
            AlertController.f(nestedScrollView, this.f384a, this.f385b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f386a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f387b;

        c(View view, View view2) {
            this.f386a = view;
            this.f387b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(AlertController.this.A, this.f386a, this.f387b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements AbsListView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f389a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f390b;

        d(AlertController alertController, View view, View view2) {
            this.f389a = view;
            this.f390b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
            AlertController.f(absListView, this.f389a, this.f390b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f391a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ View f392b;

        e(View view, View view2) {
            this.f391a = view;
            this.f392b = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.f(AlertController.this.f361g, this.f391a, this.f392b);
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public e O;

        /* renamed from: a  reason: collision with root package name */
        public final Context f394a;

        /* renamed from: b  reason: collision with root package name */
        public final LayoutInflater f395b;

        /* renamed from: d  reason: collision with root package name */
        public Drawable f397d;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f399f;

        /* renamed from: g  reason: collision with root package name */
        public View f400g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f401h;

        /* renamed from: i  reason: collision with root package name */
        public CharSequence f402i;

        /* renamed from: j  reason: collision with root package name */
        public Drawable f403j;

        /* renamed from: k  reason: collision with root package name */
        public DialogInterface.OnClickListener f404k;

        /* renamed from: l  reason: collision with root package name */
        public CharSequence f405l;

        /* renamed from: m  reason: collision with root package name */
        public Drawable f406m;

        /* renamed from: n  reason: collision with root package name */
        public DialogInterface.OnClickListener f407n;

        /* renamed from: o  reason: collision with root package name */
        public CharSequence f408o;

        /* renamed from: p  reason: collision with root package name */
        public Drawable f409p;

        /* renamed from: q  reason: collision with root package name */
        public DialogInterface.OnClickListener f410q;

        /* renamed from: s  reason: collision with root package name */
        public DialogInterface.OnCancelListener f412s;

        /* renamed from: t  reason: collision with root package name */
        public DialogInterface.OnDismissListener f413t;

        /* renamed from: u  reason: collision with root package name */
        public DialogInterface.OnKeyListener f414u;

        /* renamed from: v  reason: collision with root package name */
        public CharSequence[] f415v;

        /* renamed from: w  reason: collision with root package name */
        public ListAdapter f416w;

        /* renamed from: x  reason: collision with root package name */
        public DialogInterface.OnClickListener f417x;

        /* renamed from: y  reason: collision with root package name */
        public int f418y;

        /* renamed from: z  reason: collision with root package name */
        public View f419z;

        /* renamed from: c  reason: collision with root package name */
        public int f396c = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f398e = 0;
        public boolean E = false;
        public int I = -1;

        /* renamed from: r  reason: collision with root package name */
        public boolean f411r = true;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a extends ArrayAdapter<CharSequence> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RecycleListView f420a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, int i10, int i11, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i10, i11, charSequenceArr);
                this.f420a = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i10, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i10, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i10]) {
                    this.f420a.setItemChecked(i10, true);
                }
                return view2;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class b extends CursorAdapter {

            /* renamed from: a  reason: collision with root package name */
            private final int f422a;

            /* renamed from: b  reason: collision with root package name */
            private final int f423b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ RecycleListView f424c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ AlertController f425d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Context context, Cursor cursor, boolean z10, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z10);
                this.f424c = recycleListView;
                this.f425d = alertController;
                Cursor cursor2 = getCursor();
                this.f422a = cursor2.getColumnIndexOrThrow(f.this.L);
                this.f423b = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f422a));
                RecycleListView recycleListView = this.f424c;
                int position = cursor.getPosition();
                boolean z10 = true;
                if (cursor.getInt(this.f423b) != 1) {
                    z10 = false;
                }
                recycleListView.setItemChecked(position, z10);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f395b.inflate(this.f425d.M, viewGroup, false);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class c implements AdapterView.OnItemClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AlertController f427a;

            c(AlertController alertController) {
                this.f427a = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                f.this.f417x.onClick(this.f427a.f356b, i10);
                if (!f.this.H) {
                    this.f427a.f356b.dismiss();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class d implements AdapterView.OnItemClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ RecycleListView f429a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AlertController f430b;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f429a = recycleListView;
                this.f430b = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i10] = this.f429a.isItemChecked(i10);
                }
                f.this.J.onClick(this.f430b.f356b, i10, this.f429a.isItemChecked(i10));
            }
        }

        /* loaded from: classes.dex */
        public interface e {
            void a(ListView listView);
        }

        public f(Context context) {
            this.f394a = context;
            this.f395b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(AlertController alertController) {
            ListAdapter listAdapter;
            int i10;
            RecycleListView recycleListView = (RecycleListView) this.f395b.inflate(alertController.L, (ViewGroup) null);
            if (!this.G) {
                if (this.H) {
                    i10 = alertController.N;
                } else {
                    i10 = alertController.O;
                }
                int i11 = i10;
                if (this.K != null) {
                    listAdapter = new SimpleCursorAdapter(this.f394a, i11, this.K, new String[]{this.L}, new int[]{16908308});
                } else {
                    listAdapter = this.f416w;
                    if (listAdapter == null) {
                        listAdapter = new h(this.f394a, i11, 16908308, this.f415v);
                    }
                }
            } else if (this.K == null) {
                listAdapter = new a(this.f394a, alertController.M, 16908308, this.f415v, recycleListView);
            } else {
                listAdapter = new b(this.f394a, this.K, false, recycleListView, alertController);
            }
            e eVar = this.O;
            if (eVar != null) {
                eVar.a(recycleListView);
            }
            alertController.H = listAdapter;
            alertController.I = this.I;
            if (this.f417x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f361g = recycleListView;
        }

        public void a(AlertController alertController) {
            View view = this.f400g;
            if (view != null) {
                alertController.l(view);
            } else {
                CharSequence charSequence = this.f399f;
                if (charSequence != null) {
                    alertController.q(charSequence);
                }
                Drawable drawable = this.f397d;
                if (drawable != null) {
                    alertController.n(drawable);
                }
                int i10 = this.f396c;
                if (i10 != 0) {
                    alertController.m(i10);
                }
                int i11 = this.f398e;
                if (i11 != 0) {
                    alertController.m(alertController.c(i11));
                }
            }
            CharSequence charSequence2 = this.f401h;
            if (charSequence2 != null) {
                alertController.o(charSequence2);
            }
            CharSequence charSequence3 = this.f402i;
            if (!(charSequence3 == null && this.f403j == null)) {
                alertController.k(-1, charSequence3, this.f404k, null, this.f403j);
            }
            CharSequence charSequence4 = this.f405l;
            if (!(charSequence4 == null && this.f406m == null)) {
                alertController.k(-2, charSequence4, this.f407n, null, this.f406m);
            }
            CharSequence charSequence5 = this.f408o;
            if (!(charSequence5 == null && this.f409p == null)) {
                alertController.k(-3, charSequence5, this.f410q, null, this.f409p);
            }
            if (!(this.f415v == null && this.K == null && this.f416w == null)) {
                b(alertController);
            }
            View view2 = this.f419z;
            if (view2 == null) {
                int i12 = this.f418y;
                if (i12 != 0) {
                    alertController.r(i12);
                }
            } else if (this.E) {
                alertController.t(view2, this.A, this.B, this.C, this.D);
            } else {
                alertController.s(view2);
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class g extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<DialogInterface> f432a;

        public g(DialogInterface dialogInterface) {
            this.f432a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == -3 || i10 == -2 || i10 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f432a.get(), message.what);
            } else if (i10 == 1) {
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class h extends ArrayAdapter<CharSequence> {
        public h(Context context, int i10, int i11, CharSequence[] charSequenceArr) {
            super(context, i10, i11, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, androidx.appcompat.app.g gVar, Window window) {
        this.f355a = context;
        this.f356b = gVar;
        this.f357c = window;
        this.R = new g(gVar);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, j.D, d.a.f24726n, 0);
        this.J = obtainStyledAttributes.getResourceId(j.E, 0);
        this.K = obtainStyledAttributes.getResourceId(j.G, 0);
        this.L = obtainStyledAttributes.getResourceId(j.I, 0);
        this.M = obtainStyledAttributes.getResourceId(j.J, 0);
        this.N = obtainStyledAttributes.getResourceId(j.L, 0);
        this.O = obtainStyledAttributes.getResourceId(j.H, 0);
        this.P = obtainStyledAttributes.getBoolean(j.K, true);
        this.f358d = obtainStyledAttributes.getDimensionPixelSize(j.F, 0);
        obtainStyledAttributes.recycle();
        gVar.d(1);
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void f(View view, View view2, View view3) {
        int i10 = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i10 = 4;
            }
            view3.setVisibility(i10);
        }
    }

    private ViewGroup i(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int j() {
        int i10 = this.K;
        if (i10 == 0) {
            return this.J;
        }
        return this.Q == 1 ? i10 : this.J;
    }

    private void p(ViewGroup viewGroup, View view, int i10, int i11) {
        View findViewById = this.f357c.findViewById(d.f.f24810v);
        View findViewById2 = this.f357c.findViewById(d.f.f24809u);
        if (Build.VERSION.SDK_INT >= 23) {
            d0.K0(view, i10, i11);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i10 & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 != null && (i10 & 2) == 0) {
            viewGroup.removeView(findViewById2);
            findViewById2 = null;
        }
        if (findViewById != null || findViewById2 != null) {
            if (this.f360f != null) {
                this.A.setOnScrollChangeListener(new b(this, findViewById, findViewById2));
                this.A.post(new c(findViewById, findViewById2));
                return;
            }
            ListView listView = this.f361g;
            if (listView != null) {
                listView.setOnScrollListener(new d(this, findViewById, findViewById2));
                this.f361g.post(new e(findViewById, findViewById2));
                return;
            }
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
            }
        }
    }

    private void u(ViewGroup viewGroup) {
        boolean z10;
        Button button = (Button) viewGroup.findViewById(16908313);
        this.f369o = button;
        button.setOnClickListener(this.S);
        boolean z11 = true;
        if (!TextUtils.isEmpty(this.f370p) || this.f372r != null) {
            this.f369o.setText(this.f370p);
            Drawable drawable = this.f372r;
            if (drawable != null) {
                int i10 = this.f358d;
                drawable.setBounds(0, 0, i10, i10);
                this.f369o.setCompoundDrawables(this.f372r, null, null, null);
            }
            this.f369o.setVisibility(0);
            z10 = true;
        } else {
            this.f369o.setVisibility(8);
            z10 = false;
        }
        Button button2 = (Button) viewGroup.findViewById(16908314);
        this.f373s = button2;
        button2.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.f374t) || this.f376v != null) {
            this.f373s.setText(this.f374t);
            Drawable drawable2 = this.f376v;
            if (drawable2 != null) {
                int i11 = this.f358d;
                drawable2.setBounds(0, 0, i11, i11);
                this.f373s.setCompoundDrawables(this.f376v, null, null, null);
            }
            this.f373s.setVisibility(0);
            z10 |= true;
        } else {
            this.f373s.setVisibility(8);
        }
        Button button3 = (Button) viewGroup.findViewById(16908315);
        this.f377w = button3;
        button3.setOnClickListener(this.S);
        if (!TextUtils.isEmpty(this.f378x) || this.f380z != null) {
            this.f377w.setText(this.f378x);
            Drawable drawable3 = this.f380z;
            if (drawable3 != null) {
                int i12 = this.f358d;
                drawable3.setBounds(0, 0, i12, i12);
                this.f377w.setCompoundDrawables(this.f380z, null, null, null);
            }
            this.f377w.setVisibility(0);
            z10 |= true;
        } else {
            this.f377w.setVisibility(8);
        }
        if (z(this.f355a)) {
            if (z10) {
                b(this.f369o);
            } else if (z10) {
                b(this.f373s);
            } else if (z10) {
                b(this.f377w);
            }
        }
        if (!z10) {
            z11 = false;
        }
        if (!z11) {
            viewGroup.setVisibility(8);
        }
    }

    private void v(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f357c.findViewById(d.f.f24811w);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(16908299);
        this.F = textView;
        if (textView != null) {
            CharSequence charSequence = this.f360f;
            if (charSequence != null) {
                textView.setText(charSequence);
                return;
            }
            textView.setVisibility(8);
            this.A.removeView(this.F);
            if (this.f361g != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.A);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f361g, indexOfChild, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void w(ViewGroup viewGroup) {
        View view = this.f362h;
        boolean z10 = false;
        if (view == null) {
            view = this.f363i != 0 ? LayoutInflater.from(this.f355a).inflate(this.f363i, viewGroup, false) : null;
        }
        if (view != null) {
            z10 = true;
        }
        if (!z10 || !a(view)) {
            this.f357c.setFlags(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT);
        }
        if (z10) {
            FrameLayout frameLayout = (FrameLayout) this.f357c.findViewById(d.f.f24802n);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (this.f368n) {
                frameLayout.setPadding(this.f364j, this.f365k, this.f366l, this.f367m);
            }
            if (this.f361g != null) {
                ((LinearLayout.LayoutParams) ((LinearLayoutCompat.a) viewGroup.getLayoutParams())).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void x(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f357c.findViewById(d.f.O).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f357c.findViewById(16908294);
        if (!(!TextUtils.isEmpty(this.f359e)) || !this.P) {
            this.f357c.findViewById(d.f.O).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f357c.findViewById(d.f.f24798j);
        this.E = textView;
        textView.setText(this.f359e);
        int i10 = this.B;
        if (i10 != 0) {
            this.D.setImageResource(i10);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
            return;
        }
        this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
        this.D.setVisibility(8);
    }

    private void y() {
        ListAdapter listAdapter;
        View findViewById;
        View findViewById2;
        View findViewById3 = this.f357c.findViewById(d.f.f24808t);
        int i10 = d.f.P;
        View findViewById4 = findViewById3.findViewById(i10);
        int i11 = d.f.f24801m;
        View findViewById5 = findViewById3.findViewById(i11);
        int i12 = d.f.f24799k;
        View findViewById6 = findViewById3.findViewById(i12);
        ViewGroup viewGroup = (ViewGroup) findViewById3.findViewById(d.f.f24803o);
        w(viewGroup);
        View findViewById7 = viewGroup.findViewById(i10);
        View findViewById8 = viewGroup.findViewById(i11);
        View findViewById9 = viewGroup.findViewById(i12);
        ViewGroup i13 = i(findViewById7, findViewById4);
        ViewGroup i14 = i(findViewById8, findViewById5);
        ViewGroup i15 = i(findViewById9, findViewById6);
        v(i14);
        u(i15);
        x(i13);
        int i16 = 0;
        Object[] objArr = viewGroup.getVisibility() != 8 ? 1 : null;
        boolean z10 = (i13 == null || i13.getVisibility() == 8) ? false : true;
        boolean z11 = (i15 == null || i15.getVisibility() == 8) ? false : true;
        if (!(z11 || i14 == null || (findViewById2 = i14.findViewById(d.f.K)) == null)) {
            findViewById2.setVisibility(0);
        }
        if (z10) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View view = null;
            if (!(this.f360f == null && this.f361g == null)) {
                view = i13.findViewById(d.f.N);
            }
            if (view != null) {
                view.setVisibility(0);
            }
        } else if (!(i14 == null || (findViewById = i14.findViewById(d.f.L)) == null)) {
            findViewById.setVisibility(0);
        }
        ListView listView = this.f361g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z10, z11);
        }
        if (objArr == null) {
            View view2 = this.f361g;
            if (view2 == null) {
                view2 = this.A;
            }
            if (view2 != null) {
                if (z11) {
                    i16 = 2;
                }
                int i17 = z10 ? 1 : 0;
                char c10 = z10 ? 1 : 0;
                p(i14, view2, i17 | i16, 3);
            }
        }
        ListView listView2 = this.f361g;
        if (listView2 != null && (listAdapter = this.H) != null) {
            listView2.setAdapter(listAdapter);
            int i18 = this.I;
            if (i18 > -1) {
                listView2.setItemChecked(i18, true);
                listView2.setSelection(i18);
            }
        }
    }

    private static boolean z(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(d.a.f24725m, typedValue, true);
        return typedValue.data != 0;
    }

    public int c(int i10) {
        TypedValue typedValue = new TypedValue();
        this.f355a.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView d() {
        return this.f361g;
    }

    public void e() {
        this.f356b.setContentView(j());
        y();
    }

    public boolean g(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public boolean h(int i10, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public void k(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i10, onClickListener);
        }
        if (i10 == -3) {
            this.f378x = charSequence;
            this.f379y = message;
            this.f380z = drawable;
        } else if (i10 == -2) {
            this.f374t = charSequence;
            this.f375u = message;
            this.f376v = drawable;
        } else if (i10 == -1) {
            this.f370p = charSequence;
            this.f371q = message;
            this.f372r = drawable;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void l(View view) {
        this.G = view;
    }

    public void m(int i10) {
        this.C = null;
        this.B = i10;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (i10 != 0) {
            imageView.setVisibility(0);
            this.D.setImageResource(this.B);
            return;
        }
        imageView.setVisibility(8);
    }

    public void n(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        if (drawable != null) {
            imageView.setVisibility(0);
            this.D.setImageDrawable(drawable);
            return;
        }
        imageView.setVisibility(8);
    }

    public void o(CharSequence charSequence) {
        this.f360f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void q(CharSequence charSequence) {
        this.f359e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(int i10) {
        this.f362h = null;
        this.f363i = i10;
        this.f368n = false;
    }

    public void s(View view) {
        this.f362h = view;
        this.f363i = 0;
        this.f368n = false;
    }

    public void t(View view, int i10, int i11, int i12, int i13) {
        this.f362h = view;
        this.f363i = 0;
        this.f368n = true;
        this.f364j = i10;
        this.f365k = i11;
        this.f366l = i12;
        this.f367m = i13;
    }
}
