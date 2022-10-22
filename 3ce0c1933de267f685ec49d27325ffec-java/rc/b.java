package rc;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.companion.R;
import com.mobvoi.companion.health.viewholder.ArtyCardViewHolder;
import com.mobvoi.companion.setting.CompanionSetting;
import java.util.ArrayList;
import java.util.Objects;
import kotlin.collections.m;
import kotlin.jvm.internal.i;
/* compiled from: ImageViewPagerAdapter.kt */
/* loaded from: classes2.dex */
public final class b extends RecyclerView.Adapter<a> {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayList<Integer> f33489a;

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<Integer> f33490b;

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<Integer> f33491c;

    /* compiled from: ImageViewPagerAdapter.kt */
    /* loaded from: classes2.dex */
    public static final class a extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private final View f33492a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            i.f(view, "view");
            this.f33492a = view;
        }

        public final View a() {
            return this.f33492a;
        }
    }

    public b() {
        ArrayList<Integer> c10;
        ArrayList<Integer> c11;
        ArrayList<Integer> c12;
        c10 = m.c(Integer.valueOf(R.drawable.arty_tile_right_one), Integer.valueOf(R.drawable.arty_tile_right_two), Integer.valueOf(R.drawable.arty_tile_right_three));
        this.f33489a = c10;
        c11 = m.c(Integer.valueOf(R.drawable.arty_tile_left_one), Integer.valueOf(R.drawable.arty_tile_left_two), Integer.valueOf(R.drawable.arty_tile_left_three));
        this.f33490b = c11;
        c12 = m.c(Integer.valueOf(R.string.arty_tips_one), Integer.valueOf(R.string.arty_tips_two), Integer.valueOf(R.string.arty_tips_three), Integer.valueOf(R.string.arty_tips_four));
        this.f33491c = c12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(View view) {
        if (!CompanionSetting.isArtyAuthorize()) {
            b1.a.b(view.getContext()).d(new Intent("com.mobvoi.ACTION_SHOW_ARTY_AUTH"));
        } else if (CompanionSetting.getArtyGuidePageShowFinished()) {
            view.getContext().startActivity(new Intent(ArtyCardViewHolder.ACTION_ARTY_CENTER));
        } else {
            view.getContext().startActivity(new Intent("com.mobvoi.arty.action.START_ARTY_WELCOME"));
        }
    }

    /* renamed from: d */
    public void onBindViewHolder(a holder, int i10) {
        i.f(holder, "holder");
        ImageView imageView = (ImageView) holder.a().findViewById(R.id.iv_arty_right_bg);
        if (i10 == 3) {
            imageView.setVisibility(8);
        } else {
            imageView.setVisibility(0);
            Integer num = this.f33489a.get(i10);
            i.e(num, "artyTileRightList[position]");
            imageView.setBackgroundResource(num.intValue());
        }
        ImageView imageView2 = (ImageView) holder.a().findViewById(R.id.iv_arty_left_bg);
        if (i10 == 3) {
            imageView2.setVisibility(8);
        } else {
            imageView2.setVisibility(0);
            Integer num2 = this.f33490b.get(i10);
            i.e(num2, "artyTileLeftList[position]");
            imageView2.setBackgroundResource(num2.intValue());
            ViewGroup.LayoutParams layoutParams = imageView2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            if (i10 == 1) {
                ((ViewGroup.MarginLayoutParams) bVar).leftMargin = (int) imageView2.getResources().getDimension(R.dimen.arty_tile_left_bg_two_margin_left);
                ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = 0;
                holder.itemView.requestLayout();
            } else if (i10 == 2) {
                ((ViewGroup.MarginLayoutParams) bVar).leftMargin = (int) imageView2.getResources().getDimension(R.dimen.arty_tile_left_bg_three_margin_left);
                ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = (int) imageView2.getResources().getDimension(R.dimen.arty_tile_left_bg_three_margin_bottom);
                holder.itemView.requestLayout();
            }
        }
        Integer num3 = this.f33491c.get(i10);
        i.e(num3, "artyTileTipsList[position]");
        ((TextView) holder.a().findViewById(R.id.arty_tips_view)).setText(num3.intValue());
        TextView textView = (TextView) holder.a().findViewById(R.id.tv_arty_start);
        if (i10 == 3) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
        }
        ImageView imageView3 = (ImageView) holder.a().findViewById(R.id.arty_start_btn);
        if (i10 == 3) {
            imageView3.setVisibility(0);
            imageView3.setOnClickListener(rc.a.f33488a);
            return;
        }
        imageView3.setVisibility(8);
    }

    /* renamed from: f */
    public a onCreateViewHolder(ViewGroup parent, int i10) {
        i.f(parent, "parent");
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_arty_tips_viewpager, parent, false);
        i.e(inflate, "from(parent.context).inflate(R.layout.item_arty_tips_viewpager,parent,false)");
        return new a(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f33491c.size();
    }
}
