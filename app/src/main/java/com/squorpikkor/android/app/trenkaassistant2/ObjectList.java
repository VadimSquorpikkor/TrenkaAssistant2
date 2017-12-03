package com.squorpikkor.android.app.trenkaassistant2;

import java.util.ArrayList;

/**
 * Created by VadimSquorpikkor on 02.09.2017.
 *
 */

public class ObjectList<T> {
    ArrayList<T> innerList = new ArrayList<>();
    private String prefName;
    ObjectList(String prefName) {
        this.prefName = prefName;
        /** ? loadMe(); */
    }

    void add(T t) {
        innerList.add(t);
    }

    T get(int position) {
        return innerList.get(position);
    }

    void save() {

    }

    void load() {

    }
}
