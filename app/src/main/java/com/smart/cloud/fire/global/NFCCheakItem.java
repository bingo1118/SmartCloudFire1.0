package com.smart.cloud.fire.global;

/**
 * Created by Rain on 2019/1/15.
 */

public class NFCCheakItem {
    private  int id;
    private String itemname;
    private boolean state;

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
