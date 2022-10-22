package com.chad.library.adapter.base;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.animation.AlphaInAnimation;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.chad.library.adapter.base.animation.ScaleInAnimation;
import com.chad.library.adapter.base.animation.SlideInBottomAnimation;
import com.chad.library.adapter.base.animation.SlideInLeftAnimation;
import com.chad.library.adapter.base.animation.SlideInRightAnimation;
import com.chad.library.adapter.base.entity.IExpandable;
import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.chad.library.adapter.base.loadmore.SimpleLoadMoreView;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
/* loaded from: classes.dex */
public abstract class BaseQuickAdapter<T, K extends BaseViewHolder> extends RecyclerView.Adapter<K> {
    public static final int ALPHAIN = 1;
    public static final int EMPTY_VIEW = 1365;
    public static final int FOOTER_VIEW = 819;
    public static final int HEADER_VIEW = 273;
    public static final int LOADING_VIEW = 546;
    public static final int SCALEIN = 2;
    public static final int SLIDEIN_BOTTOM = 3;
    public static final int SLIDEIN_LEFT = 4;
    public static final int SLIDEIN_RIGHT = 5;
    protected static final String TAG = "BaseQuickAdapter";
    private boolean footerViewAsFlow;
    private boolean headerViewAsFlow;
    protected Context mContext;
    private BaseAnimation mCustomAnimation;
    protected List<T> mData;
    private int mDuration;
    private FrameLayout mEmptyLayout;
    private boolean mEnableLoadMoreEndClick;
    private boolean mFirstOnlyEnable;
    private boolean mFootAndEmptyEnable;
    private LinearLayout mFooterLayout;
    private boolean mHeadAndEmptyEnable;
    private LinearLayout mHeaderLayout;
    private Interpolator mInterpolator;
    private boolean mIsUseEmpty;
    private int mLastPosition;
    protected LayoutInflater mLayoutInflater;
    protected int mLayoutResId;
    private boolean mLoadMoreEnable;
    private LoadMoreView mLoadMoreView;
    private boolean mLoading;
    private MultiTypeDelegate<T> mMultiTypeDelegate;
    private boolean mNextLoadEnable;
    private OnItemChildClickListener mOnItemChildClickListener;
    private OnItemChildLongClickListener mOnItemChildLongClickListener;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    private boolean mOpenAnimationEnable;
    private int mPreLoadNumber;
    private RecyclerView mRecyclerView;
    private RequestLoadMoreListener mRequestLoadMoreListener;
    private BaseAnimation mSelectAnimation;
    private SpanSizeLookup mSpanSizeLookup;
    private int mStartUpFetchPosition;
    private boolean mUpFetchEnable;
    private UpFetchListener mUpFetchListener;
    private boolean mUpFetching;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface AnimationType {
    }

    /* loaded from: classes.dex */
    public interface OnItemChildClickListener {
        void onItemChildClick(BaseQuickAdapter baseQuickAdapter, View view, int i10);
    }

    /* loaded from: classes.dex */
    public interface OnItemChildLongClickListener {
        boolean onItemChildLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i10);
    }

    /* loaded from: classes.dex */
    public interface OnItemClickListener {
        void onItemClick(BaseQuickAdapter baseQuickAdapter, View view, int i10);
    }

    /* loaded from: classes.dex */
    public interface OnItemLongClickListener {
        boolean onItemLongClick(BaseQuickAdapter baseQuickAdapter, View view, int i10);
    }

    /* loaded from: classes.dex */
    public interface RequestLoadMoreListener {
        void onLoadMoreRequested();
    }

    /* loaded from: classes.dex */
    public interface SpanSizeLookup {
        int getSpanSize(GridLayoutManager gridLayoutManager, int i10);
    }

    /* loaded from: classes.dex */
    public interface UpFetchListener {
        void onUpFetch();
    }

    public BaseQuickAdapter(int i10, List<T> list) {
        this.mNextLoadEnable = false;
        this.mLoadMoreEnable = false;
        this.mLoading = false;
        this.mLoadMoreView = new SimpleLoadMoreView();
        this.mEnableLoadMoreEndClick = false;
        this.mFirstOnlyEnable = true;
        this.mOpenAnimationEnable = false;
        this.mInterpolator = new LinearInterpolator();
        this.mDuration = 300;
        this.mLastPosition = -1;
        this.mSelectAnimation = new AlphaInAnimation();
        this.mIsUseEmpty = true;
        this.mStartUpFetchPosition = 1;
        this.mPreLoadNumber = 1;
        this.mData = list == null ? new ArrayList<>() : list;
        if (i10 != 0) {
            this.mLayoutResId = i10;
        }
    }

    private void addAnimation(RecyclerView.b0 b0Var) {
        if (!this.mOpenAnimationEnable) {
            return;
        }
        if (!this.mFirstOnlyEnable || b0Var.getLayoutPosition() > this.mLastPosition) {
            BaseAnimation baseAnimation = this.mCustomAnimation;
            if (baseAnimation == null) {
                baseAnimation = this.mSelectAnimation;
            }
            for (Animator animator : baseAnimation.getAnimators(b0Var.itemView)) {
                startAnim(animator, b0Var.getLayoutPosition());
            }
            this.mLastPosition = b0Var.getLayoutPosition();
        }
    }

    private void autoLoadMore(int i10) {
        if (getLoadMoreViewCount() != 0 && i10 >= getItemCount() - this.mPreLoadNumber && this.mLoadMoreView.getLoadMoreStatus() == 1) {
            this.mLoadMoreView.setLoadMoreStatus(2);
            if (!this.mLoading) {
                this.mLoading = true;
                if (getRecyclerView() != null) {
                    getRecyclerView().post(new Runnable() { // from class: com.chad.library.adapter.base.BaseQuickAdapter.7
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseQuickAdapter.this.mRequestLoadMoreListener.onLoadMoreRequested();
                        }
                    });
                } else {
                    this.mRequestLoadMoreListener.onLoadMoreRequested();
                }
            }
        }
    }

    private void autoUpFetch(int i10) {
        UpFetchListener upFetchListener;
        if (isUpFetchEnable() && !isUpFetching() && i10 <= this.mStartUpFetchPosition && (upFetchListener = this.mUpFetchListener) != null) {
            upFetchListener.onUpFetch();
        }
    }

    private void bindViewClickListener(final BaseViewHolder baseViewHolder) {
        View view;
        if (baseViewHolder != null && (view = baseViewHolder.itemView) != null) {
            if (getOnItemClickListener() != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.BaseQuickAdapter.5
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        BaseQuickAdapter.this.getOnItemClickListener().onItemClick(BaseQuickAdapter.this, view2, baseViewHolder.getLayoutPosition() - BaseQuickAdapter.this.getHeaderLayoutCount());
                    }
                });
            }
            if (getOnItemLongClickListener() != null) {
                view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.chad.library.adapter.base.BaseQuickAdapter.6
                    @Override // android.view.View.OnLongClickListener
                    public boolean onLongClick(View view2) {
                        return BaseQuickAdapter.this.getOnItemLongClickListener().onItemLongClick(BaseQuickAdapter.this, view2, baseViewHolder.getLayoutPosition() - BaseQuickAdapter.this.getHeaderLayoutCount());
                    }
                });
            }
        }
    }

    private void checkNotNull() {
        if (getRecyclerView() == null) {
            throw new RuntimeException("please bind recyclerView first!");
        }
    }

    private void compatibilityDataSizeChanged(int i10) {
        List<T> list = this.mData;
        if ((list == null ? 0 : list.size()) == i10) {
            notifyDataSetChanged();
        }
    }

    private K createGenericKInstance(Class cls, View view) {
        try {
            if (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(View.class);
                declaredConstructor.setAccessible(true);
                return (K) declaredConstructor.newInstance(view);
            }
            Constructor<T> declaredConstructor2 = cls.getDeclaredConstructor(getClass(), View.class);
            declaredConstructor2.setAccessible(true);
            return (K) declaredConstructor2.newInstance(this, view);
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
            return null;
        } catch (InstantiationException e11) {
            e11.printStackTrace();
            return null;
        } catch (NoSuchMethodException e12) {
            e12.printStackTrace();
            return null;
        } catch (InvocationTargetException e13) {
            e13.printStackTrace();
            return null;
        }
    }

    private IExpandable getExpandableItem(int i10) {
        T item = getItem(i10);
        if (isExpandable(item)) {
            return (IExpandable) item;
        }
        return null;
    }

    private int getFooterViewPosition() {
        int i10 = 1;
        if (getEmptyViewCount() != 1) {
            return getHeaderLayoutCount() + this.mData.size();
        }
        if (this.mHeadAndEmptyEnable && getHeaderLayoutCount() != 0) {
            i10 = 2;
        }
        if (this.mFootAndEmptyEnable) {
            return i10;
        }
        return -1;
    }

    private int getHeaderViewPosition() {
        return (getEmptyViewCount() != 1 || this.mHeadAndEmptyEnable) ? 0 : -1;
    }

    private Class getInstancedGenericKClass(Class cls) {
        Type[] actualTypeArguments;
        Type genericSuperclass = cls.getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType)) {
            return null;
        }
        for (Type type : ((ParameterizedType) genericSuperclass).getActualTypeArguments()) {
            if (type instanceof Class) {
                Class cls2 = (Class) type;
                if (BaseViewHolder.class.isAssignableFrom(cls2)) {
                    return cls2;
                }
            }
        }
        return null;
    }

    private int getItemPosition(T t10) {
        List<T> list;
        if (t10 == null || (list = this.mData) == null || list.isEmpty()) {
            return -1;
        }
        return this.mData.indexOf(t10);
    }

    private K getLoadingView(ViewGroup viewGroup) {
        K createBaseViewHolder = createBaseViewHolder(getItemView(this.mLoadMoreView.getLayoutId(), viewGroup));
        createBaseViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.chad.library.adapter.base.BaseQuickAdapter.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (BaseQuickAdapter.this.mLoadMoreView.getLoadMoreStatus() == 3) {
                    BaseQuickAdapter.this.notifyLoadMoreToLoading();
                }
                if (BaseQuickAdapter.this.mEnableLoadMoreEndClick && BaseQuickAdapter.this.mLoadMoreView.getLoadMoreStatus() == 4) {
                    BaseQuickAdapter.this.notifyLoadMoreToLoading();
                }
            }
        });
        return createBaseViewHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getTheBiggestNumber(int[] iArr) {
        int i10 = -1;
        if (!(iArr == null || iArr.length == 0)) {
            for (int i11 : iArr) {
                if (i11 > i10) {
                    i10 = i11;
                }
            }
        }
        return i10;
    }

    private boolean hasSubItems(IExpandable iExpandable) {
        List<T> subItems;
        return (iExpandable == null || (subItems = iExpandable.getSubItems()) == null || subItems.size() <= 0) ? false : true;
    }

    private void openLoadMore(RequestLoadMoreListener requestLoadMoreListener) {
        this.mRequestLoadMoreListener = requestLoadMoreListener;
        this.mNextLoadEnable = true;
        this.mLoadMoreEnable = true;
        this.mLoading = false;
    }

    private int recursiveCollapse(int i10) {
        T item = getItem(i10);
        int i11 = 0;
        if (!isExpandable(item)) {
            return 0;
        }
        IExpandable iExpandable = (IExpandable) item;
        if (iExpandable.isExpanded()) {
            List<T> subItems = iExpandable.getSubItems();
            for (int size = subItems.size() - 1; size >= 0; size--) {
                T t10 = subItems.get(size);
                int itemPosition = getItemPosition(t10);
                if (itemPosition >= 0) {
                    if (t10 instanceof IExpandable) {
                        i11 += recursiveCollapse(itemPosition);
                    }
                    this.mData.remove(itemPosition);
                    i11++;
                }
            }
        }
        return i11;
    }

    private int recursiveExpand(int i10, List list) {
        int size = (i10 + list.size()) - 1;
        int size2 = list.size() - 1;
        int i11 = 0;
        while (size2 >= 0) {
            if (list.get(size2) instanceof IExpandable) {
                IExpandable iExpandable = (IExpandable) list.get(size2);
                if (iExpandable.isExpanded() && hasSubItems(iExpandable)) {
                    List<T> subItems = iExpandable.getSubItems();
                    int i12 = size + 1;
                    this.mData.addAll(i12, subItems);
                    i11 += recursiveExpand(i12, subItems);
                }
            }
            size2--;
            size--;
        }
        return i11;
    }

    private void setRecyclerView(RecyclerView recyclerView) {
        this.mRecyclerView = recyclerView;
    }

    @Deprecated
    public void add(int i10, T t10) {
        addData(i10, (int) t10);
    }

    public void addData(int i10, T t10) {
        this.mData.add(i10, t10);
        notifyItemInserted(i10 + getHeaderLayoutCount());
        compatibilityDataSizeChanged(1);
    }

    public int addFooterView(View view) {
        return addFooterView(view, -1, 1);
    }

    public int addHeaderView(View view) {
        return addHeaderView(view, -1);
    }

    public void bindToRecyclerView(RecyclerView recyclerView) {
        if (getRecyclerView() == null) {
            setRecyclerView(recyclerView);
            getRecyclerView().setAdapter(this);
            return;
        }
        throw new RuntimeException("Don't bind twice");
    }

    public int collapse(int i10, boolean z10, boolean z11) {
        int headerLayoutCount = i10 - getHeaderLayoutCount();
        IExpandable expandableItem = getExpandableItem(headerLayoutCount);
        if (expandableItem == null) {
            return 0;
        }
        int recursiveCollapse = recursiveCollapse(headerLayoutCount);
        expandableItem.setExpanded(false);
        int headerLayoutCount2 = headerLayoutCount + getHeaderLayoutCount();
        if (z11) {
            if (z10) {
                notifyItemChanged(headerLayoutCount2);
                notifyItemRangeRemoved(headerLayoutCount2 + 1, recursiveCollapse);
            } else {
                notifyDataSetChanged();
            }
        }
        return recursiveCollapse;
    }

    protected abstract void convert(K k10, T t10);

    /* JADX INFO: Access modifiers changed from: protected */
    public K createBaseViewHolder(ViewGroup viewGroup, int i10) {
        return createBaseViewHolder(getItemView(i10, viewGroup));
    }

    public void disableLoadMoreIfNotFullPage() {
        checkNotNull();
        disableLoadMoreIfNotFullPage(getRecyclerView());
    }

    public void enableLoadMoreEndClick(boolean z10) {
        this.mEnableLoadMoreEndClick = z10;
    }

    public int expand(int i10, boolean z10, boolean z11) {
        int headerLayoutCount = i10 - getHeaderLayoutCount();
        IExpandable expandableItem = getExpandableItem(headerLayoutCount);
        int i11 = 0;
        if (expandableItem == null) {
            return 0;
        }
        if (!hasSubItems(expandableItem)) {
            expandableItem.setExpanded(false);
            return 0;
        }
        if (!expandableItem.isExpanded()) {
            List<T> subItems = expandableItem.getSubItems();
            int i12 = headerLayoutCount + 1;
            this.mData.addAll(i12, subItems);
            expandableItem.setExpanded(true);
            i11 = recursiveExpand(i12, subItems) + 0 + subItems.size();
        }
        int headerLayoutCount2 = headerLayoutCount + getHeaderLayoutCount();
        if (z11) {
            if (z10) {
                notifyItemChanged(headerLayoutCount2);
                notifyItemRangeInserted(headerLayoutCount2 + 1, i11);
            } else {
                notifyDataSetChanged();
            }
        }
        return i11;
    }

    public int expandAll(int i10, boolean z10, boolean z11) {
        T item;
        int headerLayoutCount = i10 - getHeaderLayoutCount();
        int i11 = headerLayoutCount + 1;
        T item2 = i11 < this.mData.size() ? getItem(i11) : null;
        IExpandable expandableItem = getExpandableItem(headerLayoutCount);
        if (expandableItem == null || !hasSubItems(expandableItem)) {
            return 0;
        }
        int expand = expand(getHeaderLayoutCount() + headerLayoutCount, false, false);
        while (i11 < this.mData.size() && (item = getItem(i11)) != item2) {
            if (isExpandable(item)) {
                expand += expand(getHeaderLayoutCount() + i11, false, false);
            }
            i11++;
        }
        if (z11) {
            if (z10) {
                notifyItemRangeInserted(headerLayoutCount + getHeaderLayoutCount() + 1, expand);
            } else {
                notifyDataSetChanged();
            }
        }
        return expand;
    }

    public List<T> getData() {
        return this.mData;
    }

    protected int getDefItemViewType(int i10) {
        MultiTypeDelegate<T> multiTypeDelegate = this.mMultiTypeDelegate;
        if (multiTypeDelegate != null) {
            return multiTypeDelegate.getDefItemViewType(this.mData, i10);
        }
        return super.getItemViewType(i10);
    }

    public View getEmptyView() {
        return this.mEmptyLayout;
    }

    public int getEmptyViewCount() {
        FrameLayout frameLayout = this.mEmptyLayout;
        return (frameLayout == null || frameLayout.getChildCount() == 0 || !this.mIsUseEmpty || this.mData.size() != 0) ? 0 : 1;
    }

    public LinearLayout getFooterLayout() {
        return this.mFooterLayout;
    }

    public int getFooterLayoutCount() {
        LinearLayout linearLayout = this.mFooterLayout;
        return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
    }

    @Deprecated
    public int getFooterViewsCount() {
        return getFooterLayoutCount();
    }

    public LinearLayout getHeaderLayout() {
        return this.mHeaderLayout;
    }

    public int getHeaderLayoutCount() {
        LinearLayout linearLayout = this.mHeaderLayout;
        return (linearLayout == null || linearLayout.getChildCount() == 0) ? 0 : 1;
    }

    @Deprecated
    public int getHeaderViewsCount() {
        return getHeaderLayoutCount();
    }

    public T getItem(int i10) {
        if (i10 < this.mData.size()) {
            return this.mData.get(i10);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i10 = 1;
        if (getEmptyViewCount() == 1) {
            if (this.mHeadAndEmptyEnable && getHeaderLayoutCount() != 0) {
                i10 = 2;
            }
            return (!this.mFootAndEmptyEnable || getFooterLayoutCount() == 0) ? i10 : i10 + 1;
        }
        return getLoadMoreViewCount() + getHeaderLayoutCount() + this.mData.size() + getFooterLayoutCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View getItemView(int i10, ViewGroup viewGroup) {
        return this.mLayoutInflater.inflate(i10, viewGroup, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        if (getEmptyViewCount() == 1) {
            boolean z10 = this.mHeadAndEmptyEnable && getHeaderLayoutCount() != 0;
            if (i10 != 0) {
                return i10 != 1 ? i10 != 2 ? EMPTY_VIEW : FOOTER_VIEW : z10 ? EMPTY_VIEW : FOOTER_VIEW;
            }
            if (z10) {
                return 273;
            }
            return EMPTY_VIEW;
        }
        int headerLayoutCount = getHeaderLayoutCount();
        if (i10 < headerLayoutCount) {
            return 273;
        }
        int i11 = i10 - headerLayoutCount;
        int size = this.mData.size();
        if (i11 < size) {
            return getDefItemViewType(i11);
        }
        return i11 - size < getFooterLayoutCount() ? FOOTER_VIEW : LOADING_VIEW;
    }

    public int getLoadMoreViewCount() {
        if (this.mRequestLoadMoreListener == null || !this.mLoadMoreEnable) {
            return 0;
        }
        return ((this.mNextLoadEnable || !this.mLoadMoreView.isLoadEndMoreGone()) && this.mData.size() != 0) ? 1 : 0;
    }

    public int getLoadMoreViewPosition() {
        return getHeaderLayoutCount() + this.mData.size() + getFooterLayoutCount();
    }

    public MultiTypeDelegate<T> getMultiTypeDelegate() {
        return this.mMultiTypeDelegate;
    }

    public final OnItemChildClickListener getOnItemChildClickListener() {
        return this.mOnItemChildClickListener;
    }

    public final OnItemChildLongClickListener getOnItemChildLongClickListener() {
        return this.mOnItemChildLongClickListener;
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public final OnItemLongClickListener getOnItemLongClickListener() {
        return this.mOnItemLongClickListener;
    }

    public int getParentPosition(T t10) {
        int itemPosition = getItemPosition(t10);
        if (itemPosition == -1) {
            return -1;
        }
        int level = t10 instanceof IExpandable ? ((IExpandable) t10).getLevel() : Integer.MAX_VALUE;
        if (level == 0) {
            return itemPosition;
        }
        if (level == -1) {
            return -1;
        }
        while (itemPosition >= 0) {
            T t11 = this.mData.get(itemPosition);
            if (t11 instanceof IExpandable) {
                IExpandable iExpandable = (IExpandable) t11;
                if (iExpandable.getLevel() >= 0 && iExpandable.getLevel() < level) {
                    return itemPosition;
                }
            }
            itemPosition--;
        }
        return -1;
    }

    protected RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public View getViewByPosition(int i10, int i11) {
        checkNotNull();
        return getViewByPosition(getRecyclerView(), i10, i11);
    }

    public boolean isExpandable(T t10) {
        return t10 != null && (t10 instanceof IExpandable);
    }

    public void isFirstOnly(boolean z10) {
        this.mFirstOnlyEnable = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isFixedViewType(int i10) {
        return i10 == 1365 || i10 == 273 || i10 == 819 || i10 == 546;
    }

    public boolean isFooterViewAsFlow() {
        return this.footerViewAsFlow;
    }

    public boolean isHeaderViewAsFlow() {
        return this.headerViewAsFlow;
    }

    public boolean isLoadMoreEnable() {
        return this.mLoadMoreEnable;
    }

    public boolean isLoading() {
        return this.mLoading;
    }

    public boolean isUpFetchEnable() {
        return this.mUpFetchEnable;
    }

    public boolean isUpFetching() {
        return this.mUpFetching;
    }

    public void isUseEmpty(boolean z10) {
        this.mIsUseEmpty = z10;
    }

    public void loadMoreComplete() {
        if (getLoadMoreViewCount() != 0) {
            this.mLoading = false;
            this.mNextLoadEnable = true;
            this.mLoadMoreView.setLoadMoreStatus(1);
            notifyItemChanged(getLoadMoreViewPosition());
        }
    }

    public void loadMoreEnd() {
        loadMoreEnd(false);
    }

    public void loadMoreFail() {
        if (getLoadMoreViewCount() != 0) {
            this.mLoading = false;
            this.mLoadMoreView.setLoadMoreStatus(3);
            notifyItemChanged(getLoadMoreViewPosition());
        }
    }

    public void notifyLoadMoreToLoading() {
        if (this.mLoadMoreView.getLoadMoreStatus() != 2) {
            this.mLoadMoreView.setLoadMoreStatus(1);
            notifyItemChanged(getLoadMoreViewPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            final GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.e3(new GridLayoutManager.c() { // from class: com.chad.library.adapter.base.BaseQuickAdapter.4
                @Override // androidx.recyclerview.widget.GridLayoutManager.c
                public int getSpanSize(int i10) {
                    int itemViewType = BaseQuickAdapter.this.getItemViewType(i10);
                    if (itemViewType == 273 && BaseQuickAdapter.this.isHeaderViewAsFlow()) {
                        return 1;
                    }
                    if (itemViewType == 819 && BaseQuickAdapter.this.isFooterViewAsFlow()) {
                        return 1;
                    }
                    if (BaseQuickAdapter.this.mSpanSizeLookup != null) {
                        return BaseQuickAdapter.this.isFixedViewType(itemViewType) ? gridLayoutManager.W2() : BaseQuickAdapter.this.mSpanSizeLookup.getSpanSize(gridLayoutManager, i10 - BaseQuickAdapter.this.getHeaderLayoutCount());
                    }
                    if (BaseQuickAdapter.this.isFixedViewType(itemViewType)) {
                        return gridLayoutManager.W2();
                    }
                    return 1;
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.b0 b0Var, int i10) {
        onBindViewHolder((BaseQuickAdapter<T, K>) ((BaseViewHolder) b0Var), i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public K onCreateDefViewHolder(ViewGroup viewGroup, int i10) {
        int i11 = this.mLayoutResId;
        MultiTypeDelegate<T> multiTypeDelegate = this.mMultiTypeDelegate;
        if (multiTypeDelegate != null) {
            i11 = multiTypeDelegate.getLayoutId(i10);
        }
        return createBaseViewHolder(viewGroup, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.b0 b0Var) {
        onViewAttachedToWindow((BaseQuickAdapter<T, K>) ((BaseViewHolder) b0Var));
    }

    public void openLoadAnimation(int i10) {
        this.mOpenAnimationEnable = true;
        this.mCustomAnimation = null;
        if (i10 == 1) {
            this.mSelectAnimation = new AlphaInAnimation();
        } else if (i10 == 2) {
            this.mSelectAnimation = new ScaleInAnimation();
        } else if (i10 == 3) {
            this.mSelectAnimation = new SlideInBottomAnimation();
        } else if (i10 == 4) {
            this.mSelectAnimation = new SlideInLeftAnimation();
        } else if (i10 == 5) {
            this.mSelectAnimation = new SlideInRightAnimation();
        }
    }

    public void remove(int i10) {
        this.mData.remove(i10);
        int headerLayoutCount = i10 + getHeaderLayoutCount();
        notifyItemRemoved(headerLayoutCount);
        compatibilityDataSizeChanged(0);
        notifyItemRangeChanged(headerLayoutCount, this.mData.size() - headerLayoutCount);
    }

    public void removeAllFooterView() {
        if (getFooterLayoutCount() != 0) {
            this.mFooterLayout.removeAllViews();
            int footerViewPosition = getFooterViewPosition();
            if (footerViewPosition != -1) {
                notifyItemRemoved(footerViewPosition);
            }
        }
    }

    public void removeAllHeaderView() {
        if (getHeaderLayoutCount() != 0) {
            this.mHeaderLayout.removeAllViews();
            int headerViewPosition = getHeaderViewPosition();
            if (headerViewPosition != -1) {
                notifyItemRemoved(headerViewPosition);
            }
        }
    }

    public void removeFooterView(View view) {
        int footerViewPosition;
        if (getFooterLayoutCount() != 0) {
            this.mFooterLayout.removeView(view);
            if (this.mFooterLayout.getChildCount() == 0 && (footerViewPosition = getFooterViewPosition()) != -1) {
                notifyItemRemoved(footerViewPosition);
            }
        }
    }

    public void removeHeaderView(View view) {
        int headerViewPosition;
        if (getHeaderLayoutCount() != 0) {
            this.mHeaderLayout.removeView(view);
            if (this.mHeaderLayout.getChildCount() == 0 && (headerViewPosition = getHeaderViewPosition()) != -1) {
                notifyItemRemoved(headerViewPosition);
            }
        }
    }

    public void replaceData(Collection<? extends T> collection) {
        List<T> list = this.mData;
        if (collection != list) {
            list.clear();
            this.mData.addAll(collection);
        }
        notifyDataSetChanged();
    }

    @Deprecated
    public void setAutoLoadMoreSize(int i10) {
        setPreLoadNumber(i10);
    }

    public void setData(int i10, T t10) {
        this.mData.set(i10, t10);
        notifyItemChanged(i10 + getHeaderLayoutCount());
    }

    public void setDuration(int i10) {
        this.mDuration = i10;
    }

    public void setEmptyView(int i10, ViewGroup viewGroup) {
        setEmptyView(LayoutInflater.from(viewGroup.getContext()).inflate(i10, viewGroup, false));
    }

    public void setEnableLoadMore(boolean z10) {
        int loadMoreViewCount = getLoadMoreViewCount();
        this.mLoadMoreEnable = z10;
        int loadMoreViewCount2 = getLoadMoreViewCount();
        if (loadMoreViewCount == 1) {
            if (loadMoreViewCount2 == 0) {
                notifyItemRemoved(getLoadMoreViewPosition());
            }
        } else if (loadMoreViewCount2 == 1) {
            this.mLoadMoreView.setLoadMoreStatus(1);
            notifyItemInserted(getLoadMoreViewPosition());
        }
    }

    public int setFooterView(View view) {
        return setFooterView(view, 0, 1);
    }

    public void setFooterViewAsFlow(boolean z10) {
        this.footerViewAsFlow = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setFullSpan(RecyclerView.b0 b0Var) {
        if (b0Var.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.c) {
            ((StaggeredGridLayoutManager.c) b0Var.itemView.getLayoutParams()).f(true);
        }
    }

    public void setHeaderAndEmpty(boolean z10) {
        setHeaderFooterEmpty(z10, false);
    }

    public void setHeaderFooterEmpty(boolean z10, boolean z11) {
        this.mHeadAndEmptyEnable = z10;
        this.mFootAndEmptyEnable = z11;
    }

    public int setHeaderView(View view) {
        return setHeaderView(view, 0, 1);
    }

    public void setHeaderViewAsFlow(boolean z10) {
        this.headerViewAsFlow = z10;
    }

    public void setLoadMoreView(LoadMoreView loadMoreView) {
        this.mLoadMoreView = loadMoreView;
    }

    public void setMultiTypeDelegate(MultiTypeDelegate<T> multiTypeDelegate) {
        this.mMultiTypeDelegate = multiTypeDelegate;
    }

    public void setNewData(List<T> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.mData = list;
        if (this.mRequestLoadMoreListener != null) {
            this.mNextLoadEnable = true;
            this.mLoadMoreEnable = true;
            this.mLoading = false;
            this.mLoadMoreView.setLoadMoreStatus(1);
        }
        this.mLastPosition = -1;
        notifyDataSetChanged();
    }

    public void setNotDoAnimationCount(int i10) {
        this.mLastPosition = i10;
    }

    public void setOnItemChildClickListener(OnItemChildClickListener onItemChildClickListener) {
        this.mOnItemChildClickListener = onItemChildClickListener;
    }

    public void setOnItemChildLongClickListener(OnItemChildLongClickListener onItemChildLongClickListener) {
        this.mOnItemChildLongClickListener = onItemChildLongClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    @Deprecated
    public void setOnLoadMoreListener(RequestLoadMoreListener requestLoadMoreListener) {
        openLoadMore(requestLoadMoreListener);
    }

    public void setPreLoadNumber(int i10) {
        if (i10 > 1) {
            this.mPreLoadNumber = i10;
        }
    }

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.mSpanSizeLookup = spanSizeLookup;
    }

    public void setStartUpFetchPosition(int i10) {
        this.mStartUpFetchPosition = i10;
    }

    public void setUpFetchEnable(boolean z10) {
        this.mUpFetchEnable = z10;
    }

    public void setUpFetchListener(UpFetchListener upFetchListener) {
        this.mUpFetchListener = upFetchListener;
    }

    public void setUpFetching(boolean z10) {
        this.mUpFetching = z10;
    }

    protected void startAnim(Animator animator, int i10) {
        animator.setDuration(this.mDuration).start();
        animator.setInterpolator(this.mInterpolator);
    }

    public int addFooterView(View view, int i10) {
        return addFooterView(view, i10, 1);
    }

    public int addHeaderView(View view, int i10) {
        return addHeaderView(view, i10, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public K createBaseViewHolder(View view) {
        K k10;
        Class cls = null;
        for (Class<?> cls2 = getClass(); cls == null && cls2 != null; cls2 = cls2.getSuperclass()) {
            cls = getInstancedGenericKClass(cls2);
        }
        if (cls == null) {
            k10 = (K) new BaseViewHolder(view);
        } else {
            k10 = createGenericKInstance(cls, view);
        }
        return k10 != null ? k10 : (K) new BaseViewHolder(view);
    }

    public void loadMoreEnd(boolean z10) {
        if (getLoadMoreViewCount() != 0) {
            this.mLoading = false;
            this.mNextLoadEnable = false;
            this.mLoadMoreView.setLoadMoreEndGone(z10);
            if (z10) {
                notifyItemRemoved(getLoadMoreViewPosition());
                return;
            }
            this.mLoadMoreView.setLoadMoreStatus(4);
            notifyItemChanged(getLoadMoreViewPosition());
        }
    }

    public void onBindViewHolder(K k10, int i10) {
        autoUpFetch(i10);
        autoLoadMore(i10);
        int itemViewType = k10.getItemViewType();
        if (itemViewType == 0) {
            convert(k10, getItem(i10 - getHeaderLayoutCount()));
        } else if (itemViewType == 273) {
        } else {
            if (itemViewType == 546) {
                this.mLoadMoreView.convert(k10);
            } else if (itemViewType != 819 && itemViewType != 1365) {
                convert(k10, getItem(i10 - getHeaderLayoutCount()));
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public K onCreateViewHolder(ViewGroup viewGroup, int i10) {
        K k10;
        Context context = viewGroup.getContext();
        this.mContext = context;
        this.mLayoutInflater = LayoutInflater.from(context);
        if (i10 == 273) {
            k10 = createBaseViewHolder(this.mHeaderLayout);
        } else if (i10 == 546) {
            k10 = getLoadingView(viewGroup);
        } else if (i10 == 819) {
            k10 = createBaseViewHolder(this.mFooterLayout);
        } else if (i10 != 1365) {
            k10 = onCreateDefViewHolder(viewGroup, i10);
            bindViewClickListener(k10);
        } else {
            k10 = createBaseViewHolder(this.mEmptyLayout);
        }
        k10.setAdapter(this);
        return k10;
    }

    public void onViewAttachedToWindow(K k10) {
        super.onViewAttachedToWindow((BaseQuickAdapter<T, K>) k10);
        int itemViewType = k10.getItemViewType();
        if (itemViewType == 1365 || itemViewType == 273 || itemViewType == 819 || itemViewType == 546) {
            setFullSpan(k10);
        } else {
            addAnimation(k10);
        }
    }

    public int setFooterView(View view, int i10) {
        return setFooterView(view, i10, 1);
    }

    public int setHeaderView(View view, int i10) {
        return setHeaderView(view, i10, 1);
    }

    public void setOnLoadMoreListener(RequestLoadMoreListener requestLoadMoreListener, RecyclerView recyclerView) {
        openLoadMore(requestLoadMoreListener);
        if (getRecyclerView() == null) {
            setRecyclerView(recyclerView);
        }
    }

    public int addFooterView(View view, int i10, int i11) {
        int footerViewPosition;
        if (this.mFooterLayout == null) {
            LinearLayout linearLayout = new LinearLayout(view.getContext());
            this.mFooterLayout = linearLayout;
            if (i11 == 1) {
                linearLayout.setOrientation(1);
                this.mFooterLayout.setLayoutParams(new RecyclerView.o(-1, -2));
            } else {
                linearLayout.setOrientation(0);
                this.mFooterLayout.setLayoutParams(new RecyclerView.o(-2, -1));
            }
        }
        int childCount = this.mFooterLayout.getChildCount();
        if (i10 < 0 || i10 > childCount) {
            i10 = childCount;
        }
        this.mFooterLayout.addView(view, i10);
        if (this.mFooterLayout.getChildCount() == 1 && (footerViewPosition = getFooterViewPosition()) != -1) {
            notifyItemInserted(footerViewPosition);
        }
        return i10;
    }

    public int addHeaderView(View view, int i10, int i11) {
        int headerViewPosition;
        if (this.mHeaderLayout == null) {
            LinearLayout linearLayout = new LinearLayout(view.getContext());
            this.mHeaderLayout = linearLayout;
            if (i11 == 1) {
                linearLayout.setOrientation(1);
                this.mHeaderLayout.setLayoutParams(new RecyclerView.o(-1, -2));
            } else {
                linearLayout.setOrientation(0);
                this.mHeaderLayout.setLayoutParams(new RecyclerView.o(-2, -1));
            }
        }
        int childCount = this.mHeaderLayout.getChildCount();
        if (i10 < 0 || i10 > childCount) {
            i10 = childCount;
        }
        this.mHeaderLayout.addView(view, i10);
        if (this.mHeaderLayout.getChildCount() == 1 && (headerViewPosition = getHeaderViewPosition()) != -1) {
            notifyItemInserted(headerViewPosition);
        }
        return i10;
    }

    public void disableLoadMoreIfNotFullPage(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager;
        setEnableLoadMore(false);
        if (recyclerView != null && (layoutManager = recyclerView.getLayoutManager()) != null) {
            if (layoutManager instanceof LinearLayoutManager) {
                final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                recyclerView.postDelayed(new Runnable() { // from class: com.chad.library.adapter.base.BaseQuickAdapter.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (linearLayoutManager.a2() + 1 != BaseQuickAdapter.this.getItemCount()) {
                            BaseQuickAdapter.this.setEnableLoadMore(true);
                        }
                    }
                }, 50L);
            } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                final StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                recyclerView.postDelayed(new Runnable() { // from class: com.chad.library.adapter.base.BaseQuickAdapter.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int[] iArr = new int[staggeredGridLayoutManager.t2()];
                        staggeredGridLayoutManager.h2(iArr);
                        if (BaseQuickAdapter.this.getTheBiggestNumber(iArr) + 1 != BaseQuickAdapter.this.getItemCount()) {
                            BaseQuickAdapter.this.setEnableLoadMore(true);
                        }
                    }
                }, 50L);
            }
        }
    }

    public View getViewByPosition(RecyclerView recyclerView, int i10, int i11) {
        BaseViewHolder baseViewHolder;
        if (recyclerView == null || (baseViewHolder = (BaseViewHolder) recyclerView.b0(i10)) == null) {
            return null;
        }
        return baseViewHolder.getView(i11);
    }

    public void setEmptyView(int i10) {
        checkNotNull();
        setEmptyView(i10, getRecyclerView());
    }

    public int setFooterView(View view, int i10, int i11) {
        LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout == null || linearLayout.getChildCount() <= i10) {
            return addFooterView(view, i10, i11);
        }
        this.mFooterLayout.removeViewAt(i10);
        this.mFooterLayout.addView(view, i10);
        return i10;
    }

    public int setHeaderView(View view, int i10, int i11) {
        LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout == null || linearLayout.getChildCount() <= i10) {
            return addHeaderView(view, i10, i11);
        }
        this.mHeaderLayout.removeViewAt(i10);
        this.mHeaderLayout.addView(view, i10);
        return i10;
    }

    public void addData(T t10) {
        this.mData.add(t10);
        notifyItemInserted(this.mData.size() + getHeaderLayoutCount());
        compatibilityDataSizeChanged(1);
    }

    public void setEmptyView(View view) {
        boolean z10;
        int i10 = 0;
        if (this.mEmptyLayout == null) {
            this.mEmptyLayout = new FrameLayout(view.getContext());
            RecyclerView.o oVar = new RecyclerView.o(-1, -1);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                ((ViewGroup.MarginLayoutParams) oVar).width = layoutParams.width;
                ((ViewGroup.MarginLayoutParams) oVar).height = layoutParams.height;
            }
            this.mEmptyLayout.setLayoutParams(oVar);
            z10 = true;
        } else {
            z10 = false;
        }
        this.mEmptyLayout.removeAllViews();
        this.mEmptyLayout.addView(view);
        this.mIsUseEmpty = true;
        if (z10 && getEmptyViewCount() == 1) {
            if (this.mHeadAndEmptyEnable && getHeaderLayoutCount() != 0) {
                i10 = 1;
            }
            notifyItemInserted(i10);
        }
    }

    public void addData(int i10, Collection<? extends T> collection) {
        this.mData.addAll(i10, collection);
        notifyItemRangeInserted(i10 + getHeaderLayoutCount(), collection.size());
        compatibilityDataSizeChanged(collection.size());
    }

    public void openLoadAnimation(BaseAnimation baseAnimation) {
        this.mOpenAnimationEnable = true;
        this.mCustomAnimation = baseAnimation;
    }

    public int collapse(int i10) {
        return collapse(i10, true, true);
    }

    public void addData(Collection<? extends T> collection) {
        this.mData.addAll(collection);
        notifyItemRangeInserted((this.mData.size() - collection.size()) + getHeaderLayoutCount(), collection.size());
        compatibilityDataSizeChanged(collection.size());
    }

    public int collapse(int i10, boolean z10) {
        return collapse(i10, z10, true);
    }

    public void openLoadAnimation() {
        this.mOpenAnimationEnable = true;
    }

    public int expandAll(int i10, boolean z10) {
        return expandAll(i10, true, !z10);
    }

    public void expandAll() {
        for (int size = (this.mData.size() - 1) + getHeaderLayoutCount(); size >= getHeaderLayoutCount(); size--) {
            expandAll(size, false, false);
        }
    }

    public int expand(int i10, boolean z10) {
        return expand(i10, z10, true);
    }

    public int expand(int i10) {
        return expand(i10, true, true);
    }

    public BaseQuickAdapter(List<T> list) {
        this(0, list);
    }

    public BaseQuickAdapter(int i10) {
        this(i10, null);
    }
}
