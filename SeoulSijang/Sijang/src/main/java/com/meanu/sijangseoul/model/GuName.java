package com.meanu.sijangseoul.model;

import java.util.ArrayList;
import java.util.List;

public class GuName {
    String guName;
    int current;

    public List<RetroPrice.Mgismulgainfo.row> getList() {
        return list;
    }

    public void setList(List<RetroPrice.Mgismulgainfo.row> list) {
        this.list = list;
    }

    public List<RetroPrice.Mgismulgainfo.row> list = new ArrayList<>();

    public void setGuName(String guName) {
        this.guName = guName;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public GuName(String guName, int current) {
        this.guName = guName;
        this.current = current;
    }


    public String getGuName() {
        return guName;
    }

    public int getCurrent() {
        return current;
    }

}
