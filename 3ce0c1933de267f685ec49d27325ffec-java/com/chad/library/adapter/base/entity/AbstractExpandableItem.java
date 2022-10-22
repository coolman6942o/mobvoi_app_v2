package com.chad.library.adapter.base.entity;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class AbstractExpandableItem<T> implements IExpandable<T> {
    protected boolean mExpandable = false;
    protected List<T> mSubItems;

    public void addSubItem(T t10) {
        if (this.mSubItems == null) {
            this.mSubItems = new ArrayList();
        }
        this.mSubItems.add(t10);
    }

    public boolean contains(T t10) {
        List<T> list = this.mSubItems;
        return list != null && list.contains(t10);
    }

    public T getSubItem(int i10) {
        if (!hasSubItem() || i10 >= this.mSubItems.size()) {
            return null;
        }
        return this.mSubItems.get(i10);
    }

    public int getSubItemPosition(T t10) {
        List<T> list = this.mSubItems;
        if (list != null) {
            return list.indexOf(t10);
        }
        return -1;
    }

    @Override // com.chad.library.adapter.base.entity.IExpandable
    public List<T> getSubItems() {
        return this.mSubItems;
    }

    public boolean hasSubItem() {
        List<T> list = this.mSubItems;
        return list != null && list.size() > 0;
    }

    @Override // com.chad.library.adapter.base.entity.IExpandable
    public boolean isExpanded() {
        return this.mExpandable;
    }

    public boolean removeSubItem(T t10) {
        List<T> list = this.mSubItems;
        return list != null && list.remove(t10);
    }

    @Override // com.chad.library.adapter.base.entity.IExpandable
    public void setExpanded(boolean z10) {
        this.mExpandable = z10;
    }

    public void setSubItems(List<T> list) {
        this.mSubItems = list;
    }

    public boolean removeSubItem(int i10) {
        List<T> list = this.mSubItems;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            return false;
        }
        this.mSubItems.remove(i10);
        return true;
    }

    public void addSubItem(int i10, T t10) {
        List<T> list = this.mSubItems;
        if (list == null || i10 < 0 || i10 >= list.size()) {
            addSubItem(t10);
        } else {
            this.mSubItems.add(i10, t10);
        }
    }
}
