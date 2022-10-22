package com.mobvoi.assistant.data.network.model;

import com.mobvoi.android.common.json.JsonBean;
import h8.c;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class SceneItem implements JsonBean, Serializable {
    @c("voice_commands")
    private String[] VoiceCommand;
    private String desc;
    private String icon;
    private String name;
    private String type;

    public String getDesc() {
        return this.desc;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String[] getVoiceCommand() {
        return this.VoiceCommand;
    }

    public void setDesc(String str) {
        this.desc = str;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setVoiceCommand(String[] strArr) {
        this.VoiceCommand = strArr;
    }
}
