package com.chad.library.adapter.base;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class BaseViewHolder extends RecyclerView.b0 {
    private BaseQuickAdapter adapter;
    Object associatedObject;
    @Deprecated
    public View convertView;
    private final SparseArray<View> views = new SparseArray<>();
    private final LinkedHashSet<Integer> childClickViewIds = new LinkedHashSet<>();
    private final LinkedHashSet<Integer> itemChildLongClickViewIds = new LinkedHashSet<>();
    private final HashSet<Integer> nestViews = new HashSet<>();

    public BaseViewHolder(View view) {
        super(view);
        this.convertView = view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getClickPosition() {
        if (getLayoutPosition() >= this.adapter.getHeaderLayoutCount()) {
            return getLayoutPosition() - this.adapter.getHeaderLayoutCount();
        }
        return 0;
    }

    public BaseViewHolder addOnClickListener(int i10) {
        this.childClickViewIds.add(Integer.valueOf(i10));
        View view = getView(i10);
        if (view != null) {
            if (!view.isClickable()) {
                view.setClickable(true);
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.BaseViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (BaseViewHolder.this.adapter.getOnItemChildClickListener() != null) {
                        BaseViewHolder.this.adapter.getOnItemChildClickListener().onItemChildClick(BaseViewHolder.this.adapter, view2, BaseViewHolder.this.getClickPosition());
                    }
                }
            });
        }
        return this;
    }

    public BaseViewHolder addOnLongClickListener(int i10) {
        this.itemChildLongClickViewIds.add(Integer.valueOf(i10));
        View view = getView(i10);
        if (view != null) {
            if (!view.isLongClickable()) {
                view.setLongClickable(true);
            }
            view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.BaseViewHolder.2
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view2) {
                    return BaseViewHolder.this.adapter.getOnItemChildLongClickListener() != null && BaseViewHolder.this.adapter.getOnItemChildLongClickListener().onItemChildLongClick(BaseViewHolder.this.adapter, view2, BaseViewHolder.this.getClickPosition());
                }
            });
        }
        return this;
    }

    public Object getAssociatedObject() {
        return this.associatedObject;
    }

    public HashSet<Integer> getChildClickViewIds() {
        return this.childClickViewIds;
    }

    @Deprecated
    public View getConvertView() {
        return this.convertView;
    }

    public HashSet<Integer> getItemChildLongClickViewIds() {
        return this.itemChildLongClickViewIds;
    }

    public Set<Integer> getNestViews() {
        return this.nestViews;
    }

    public <T extends View> T getView(int i10) {
        T t10 = (T) this.views.get(i10);
        if (t10 != null) {
            return t10;
        }
        T t11 = (T) this.itemView.findViewById(i10);
        this.views.put(i10, t11);
        return t11;
    }

    public BaseViewHolder linkify(int i10) {
        Linkify.addLinks((TextView) getView(i10), 15);
        return this;
    }

    public BaseViewHolder setAdapter(int i10, Adapter adapter) {
        ((AdapterView) getView(i10)).setAdapter(adapter);
        return this;
    }

    public BaseViewHolder setAlpha(int i10, float f10) {
        if (Build.VERSION.SDK_INT >= 11) {
            getView(i10).setAlpha(f10);
        } else {
            AlphaAnimation alphaAnimation = new AlphaAnimation(f10, f10);
            alphaAnimation.setDuration(0L);
            alphaAnimation.setFillAfter(true);
            getView(i10).startAnimation(alphaAnimation);
        }
        return this;
    }

    public void setAssociatedObject(Object obj) {
        this.associatedObject = obj;
    }

    public BaseViewHolder setBackgroundColor(int i10, int i11) {
        getView(i10).setBackgroundColor(i11);
        return this;
    }

    public BaseViewHolder setBackgroundRes(int i10, int i11) {
        getView(i10).setBackgroundResource(i11);
        return this;
    }

    public BaseViewHolder setChecked(int i10, boolean z10) {
        View view = getView(i10);
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(z10);
        }
        return this;
    }

    public BaseViewHolder setGone(int i10, boolean z10) {
        getView(i10).setVisibility(z10 ? 0 : 8);
        return this;
    }

    public BaseViewHolder setImageBitmap(int i10, Bitmap bitmap) {
        ((ImageView) getView(i10)).setImageBitmap(bitmap);
        return this;
    }

    public BaseViewHolder setImageDrawable(int i10, Drawable drawable) {
        ((ImageView) getView(i10)).setImageDrawable(drawable);
        return this;
    }

    public BaseViewHolder setImageResource(int i10, int i11) {
        ((ImageView) getView(i10)).setImageResource(i11);
        return this;
    }

    public BaseViewHolder setMax(int i10, int i11) {
        ((ProgressBar) getView(i10)).setMax(i11);
        return this;
    }

    public BaseViewHolder setNestView(int i10) {
        addOnClickListener(i10);
        addOnLongClickListener(i10);
        this.nestViews.add(Integer.valueOf(i10));
        return this;
    }

    public BaseViewHolder setOnCheckedChangeListener(int i10, CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        ((CompoundButton) getView(i10)).setOnCheckedChangeListener(onCheckedChangeListener);
        return this;
    }

    @Deprecated
    public BaseViewHolder setOnClickListener(int i10, View.OnClickListener onClickListener) {
        getView(i10).setOnClickListener(onClickListener);
        return this;
    }

    @Deprecated
    public BaseViewHolder setOnItemClickListener(int i10, AdapterView.OnItemClickListener onItemClickListener) {
        ((AdapterView) getView(i10)).setOnItemClickListener(onItemClickListener);
        return this;
    }

    public BaseViewHolder setOnItemLongClickListener(int i10, AdapterView.OnItemLongClickListener onItemLongClickListener) {
        ((AdapterView) getView(i10)).setOnItemLongClickListener(onItemLongClickListener);
        return this;
    }

    public BaseViewHolder setOnItemSelectedClickListener(int i10, AdapterView.OnItemSelectedListener onItemSelectedListener) {
        ((AdapterView) getView(i10)).setOnItemSelectedListener(onItemSelectedListener);
        return this;
    }

    @Deprecated
    public BaseViewHolder setOnLongClickListener(int i10, View.OnLongClickListener onLongClickListener) {
        getView(i10).setOnLongClickListener(onLongClickListener);
        return this;
    }

    @Deprecated
    public BaseViewHolder setOnTouchListener(int i10, View.OnTouchListener onTouchListener) {
        getView(i10).setOnTouchListener(onTouchListener);
        return this;
    }

    public BaseViewHolder setProgress(int i10, int i11) {
        ((ProgressBar) getView(i10)).setProgress(i11);
        return this;
    }

    public BaseViewHolder setRating(int i10, float f10) {
        ((RatingBar) getView(i10)).setRating(f10);
        return this;
    }

    public BaseViewHolder setTag(int i10, Object obj) {
        getView(i10).setTag(obj);
        return this;
    }

    public BaseViewHolder setText(int i10, CharSequence charSequence) {
        ((TextView) getView(i10)).setText(charSequence);
        return this;
    }

    public BaseViewHolder setTextColor(int i10, int i11) {
        ((TextView) getView(i10)).setTextColor(i11);
        return this;
    }

    public BaseViewHolder setTypeface(int i10, Typeface typeface) {
        TextView textView = (TextView) getView(i10);
        textView.setTypeface(typeface);
        textView.setPaintFlags(textView.getPaintFlags() | 128);
        return this;
    }

    public BaseViewHolder setVisible(int i10, boolean z10) {
        getView(i10).setVisibility(z10 ? 0 : 4);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseViewHolder setAdapter(BaseQuickAdapter baseQuickAdapter) {
        this.adapter = baseQuickAdapter;
        return this;
    }

    public BaseViewHolder setProgress(int i10, int i11, int i12) {
        ProgressBar progressBar = (ProgressBar) getView(i10);
        progressBar.setMax(i12);
        progressBar.setProgress(i11);
        return this;
    }

    public BaseViewHolder setRating(int i10, float f10, int i11) {
        RatingBar ratingBar = (RatingBar) getView(i10);
        ratingBar.setMax(i11);
        ratingBar.setRating(f10);
        return this;
    }

    public BaseViewHolder setTag(int i10, int i11, Object obj) {
        getView(i10).setTag(i11, obj);
        return this;
    }

    public BaseViewHolder setText(int i10, int i11) {
        ((TextView) getView(i10)).setText(i11);
        return this;
    }

    public BaseViewHolder setTypeface(Typeface typeface, int... iArr) {
        for (int i10 : iArr) {
            TextView textView = (TextView) getView(i10);
            textView.setTypeface(typeface);
            textView.setPaintFlags(textView.getPaintFlags() | 128);
        }
        return this;
    }
}
