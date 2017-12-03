package com.squorpikkor.android.app.trenkaassistant2;

import java.util.ArrayList;

/**
 * Created by VadimSquorpikkor on 02.09.2017.
 *
 */

public interface ICanSave {
    void saveParam();
    void loadParam();
    void saveObjList();
    void loadObjList();
    String getPrefName();
    ArrayList<String> getParamList();
    void setParamList(ArrayList<String> list);
    void createNew();

    void createInstance();

    /**
     * Realization for methods:
     * void saveParam(){
     *
     * }
     *
     */
}
