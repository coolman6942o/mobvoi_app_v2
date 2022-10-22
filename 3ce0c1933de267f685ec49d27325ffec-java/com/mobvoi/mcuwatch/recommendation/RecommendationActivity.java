package com.mobvoi.mcuwatch.recommendation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.cardiex.arty.lite.models.coach.Advice;
import com.cardiex.arty.lite.models.coach.Content;
import com.mobvoi.mcuwatch.recommendation.adapter.RecommendationAdapter;
import io.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import qo.l;
import sh.k;
import zh.j;
/* compiled from: RecommendationActivity.kt */
/* loaded from: classes2.dex */
public final class RecommendationActivity extends wi.c<j> {

    /* renamed from: g  reason: collision with root package name */
    public static final b f19255g = new b(null);

    /* renamed from: c  reason: collision with root package name */
    private Advice f19256c;

    /* renamed from: d  reason: collision with root package name */
    private final d f19257d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<ji.a> f19258e = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    private RecommendationAdapter f19259f;

    /* compiled from: RecommendationActivity.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class a extends FunctionReferenceImpl implements l<LayoutInflater, j> {
        public static final a INSTANCE = new a();

        a() {
            super(1, j.class, "inflate", "inflate(Landroid/view/LayoutInflater;)Lcom/mobvoi/mcuwatch/databinding/ActivityRecommendationBinding;", 0);
        }

        /* renamed from: g */
        public final j invoke(LayoutInflater p02) {
            i.f(p02, "p0");
            return j.d(p02);
        }
    }

    /* compiled from: RecommendationActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(f fVar) {
            this();
        }

        public final void a(Context context, Advice data) {
            i.f(context, "context");
            i.f(data, "data");
            Intent intent = new Intent(context, RecommendationActivity.class);
            Bundle bundle = new Bundle();
            bundle.putParcelable("recommend_key", data);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }

    /* compiled from: RecommendationActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements qo.a<RecommendationActivity> {
        c() {
            super(0);
        }

        /* renamed from: a */
        public final RecommendationActivity invoke() {
            return RecommendationActivity.this;
        }
    }

    public RecommendationActivity() {
        super(a.INSTANCE);
        d a10;
        a10 = io.f.a(new c());
        this.f19257d = a10;
    }

    private final RecommendationActivity K() {
        return (RecommendationActivity) this.f19257d.getValue();
    }

    public final void L() {
        String id2;
        List U;
        Bundle extras = getIntent().getExtras();
        Advice advice = (Advice) (extras == null ? null : extras.get("recommend_key"));
        this.f19256c = advice;
        if (advice != null) {
            i.d(advice);
            if (advice.getDetails() != null) {
                Advice advice2 = this.f19256c;
                i.d(advice2);
                List<Content> details = advice2.getDetails();
                i.d(details);
                if (!details.isEmpty()) {
                    this.f19258e.clear();
                    Advice advice3 = this.f19256c;
                    i.d(advice3);
                    List<Content> details2 = advice3.getDetails();
                    i.d(details2);
                    U = u.U(details2);
                    Iterator it = U.iterator();
                    while (it.hasNext()) {
                        Content content = (Content) it.next();
                        it = it;
                        this.f19258e.add(new ji.a(content.getAction(), content.getArtyComponent(), content.getArtyGraph(), content.getArtyScore(), content.getBin(), content.getIcon(), content.getImage(), content.getQuestion(), content.getType(), content.getValue(), content.getVideo()));
                    }
                }
            }
        }
        Advice advice4 = this.f19256c;
        if (advice4 != null && (id2 = advice4.getId()) != null) {
            ad.a.f168a.l(id2);
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.f34748q;
    }

    public final void initView() {
        setTitle(k.I);
        H().f37549b.setLayoutManager(new LinearLayoutManager(K()));
        RecommendationAdapter recommendationAdapter = new RecommendationAdapter(K(), this.f19258e);
        this.f19259f = recommendationAdapter;
        recommendationAdapter.bindToRecyclerView(H().f37549b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        L();
        initView();
    }
}
