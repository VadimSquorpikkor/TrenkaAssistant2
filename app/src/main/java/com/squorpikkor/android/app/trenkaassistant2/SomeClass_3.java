package com.squorpikkor.android.app.trenkaassistant2;

import java.util.ArrayList;

/**
 * Created by VadimSquorpikkor on 02.09.2017.
 *
 */

public class SomeClass_3 implements ICanSave3{
    String param1 = "";
    int param2 = 0;
    double param3 = 0;

    SomeClass_3() {
    }

    SomeClass_3(String param1, int param2, double param3) {
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
    }

    @Override
    public ArrayList<String> getParamList() {
        ArrayList<String> list = new ArrayList<>();
        list.add(param1);
        list.add(String.valueOf(param2));
        return list;
    }

    @Override
    public void setParamList(ArrayList<String> list) {
        param1 = list.get(0);
        param2 = Integer.parseInt(list.get(1));
    }


}
