package com.mobvoi.feedback.bean;

import com.mobvoi.android.common.json.JsonBean;
import h8.c;
import java.io.Serializable;
import java.util.List;
/* loaded from: classes2.dex */
public class FeedBackBean implements JsonBean, Serializable {
    private List<Content> content;
    private String product;
    @c("smarthome_content")
    private List<Content> smarthome;
    @c("tichome_content")
    private List<Content> tichome;
    @c("tichome_fox_content")
    private List<Content> tichomeFox;
    @c("tichome_mini_content")
    private List<Content> tichomeMini;
    @c("tichome_mini2_content")
    private List<Content> tichomeMini2;
    @c("tickids_content")
    private List<Content> tickids;
    @c("ticpods_content")
    private List<Content> ticpods;
    @c("ticpods_2_pro_content")
    private List<Content> ticpods2Pro;
    @c("ticpods_2_standard_content")
    private List<Content> ticpods2Standard;
    @c("ticwatch_android_content")
    private List<Content> ticwatchAndroid;
    @c("ticwatch_ios_content")
    private List<Content> ticwatchIos;
    @c("ticwatch_tw_content")
    private List<Content> ticwear;

    public List<Content> getContent() {
        return this.content;
    }

    public String getProduct() {
        return this.product;
    }

    public List<Content> getSmarthome() {
        return this.smarthome;
    }

    public List<Content> getTichome() {
        return this.tichome;
    }

    public List<Content> getTichomeFox() {
        return this.tichomeFox;
    }

    public List<Content> getTichomeMini() {
        return this.tichomeMini;
    }

    public List<Content> getTichomeMini2() {
        return this.tichomeMini2;
    }

    public List<Content> getTickids() {
        return this.tickids;
    }

    public List<Content> getTicpods() {
        return this.ticpods;
    }

    public List<Content> getTicpods2Pro() {
        return this.ticpods2Pro;
    }

    public List<Content> getTicpods2Standard() {
        return this.ticpods2Standard;
    }

    public List<Content> getTicwatchAndroid() {
        return this.ticwatchAndroid;
    }

    public List<Content> getTicwatchIos() {
        return this.ticwatchIos;
    }

    public List<Content> getTicwear() {
        return this.ticwear;
    }

    public void setContent(List<Content> list) {
        this.content = list;
    }

    public void setProduct(String str) {
        this.product = str;
    }

    public void setSmarthome(List<Content> list) {
        this.smarthome = list;
    }

    public void setTichome(List<Content> list) {
        this.tichome = list;
    }

    public void setTichomeFox(List<Content> list) {
        this.tichomeMini = list;
    }

    public void setTichomeMini(List<Content> list) {
        this.tichomeMini = list;
    }

    public void setTichomeMini2(List<Content> list) {
        this.tichomeMini2 = list;
    }

    public void setTicpods(List<Content> list) {
        this.ticpods = list;
    }

    public void setTicpods2Pro(List<Content> list) {
        this.ticpods2Pro = list;
    }

    public void setTicpods2Standard(List<Content> list) {
        this.ticpods2Standard = list;
    }

    public void setTicwatchAndroid(List<Content> list) {
        this.ticwatchAndroid = list;
    }

    public void setTicwatchIos(List<Content> list) {
        this.ticwatchIos = list;
    }

    public void setTicwear(List<Content> list) {
        this.ticwear = list;
    }
}
