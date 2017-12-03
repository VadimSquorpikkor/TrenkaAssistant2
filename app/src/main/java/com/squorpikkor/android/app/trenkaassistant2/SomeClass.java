package com.squorpikkor.android.app.trenkaassistant2;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by VadimSquorpikkor on 02.09.2017.
 * Class just for experiments. It's useless in final app version
 */

public class SomeClass implements ICanSave {
    String param1 = "A";
    int param2 = 0;
    ArrayList<SomeClass_2> list = new ArrayList<>();
    private final String prefName = "SOME_CLASS_";


    Context context;
    SaveLoad saveload;

    SomeClass(Context context) {
        this.context = context;
        saveload = new SaveLoad(context);
    }

    @Override
    public void saveParam() {
        ArrayList<String> list = new ArrayList<>();
        list.add(param1);
        list.add(String.valueOf(param2));
        saveload.saveStringArray(list, "SOME_CLASS");
    }

    /**VERSION_2
     * bad idea -- too many methods in class (and interface)
     * good thing -- method calls from class of interface, not from SaveLoad class*/
    /*public void saveParam() {
        saveload.saveStringArray(getParamList(), "SOME_CLASS");
    }*/

    @Override
    public void loadParam() {
        ArrayList<String> list = saveload.loadStringArray("SOME_CLASS");
        param1 = list.get(0);
        param2 = Integer.parseInt(list.get(1));
    }

    @Override
    public void saveObjList() {
        ArrayList<String> savingList = new ArrayList<>();
        for (SomeClass_2 class_2 : list) {
            savingList.add(class_2.param3);
            savingList.add(String.valueOf(class_2.param4));
        }
        saveload.saveStringArray(savingList, "SOME_CLASS_LIST");
    }

    @Override
    public void loadObjList() {
        ArrayList<String> loadedList = saveload.loadStringArray("SOME_CLASS_LIST");
        list.clear();
        int i = 0;
        for (int k = 0; k < loadedList.size() / 2; k++) {
            list.add(new SomeClass_2());
        }
        for (SomeClass_2 class_2 : list) {
            class_2.param3 = loadedList.get(i);
            i++;
            class_2.param4 = Integer.parseInt(loadedList.get(i));
            i++;
        }
    }

    @Override
    public ArrayList<String> getParamList() {
        ArrayList<String> list = new ArrayList<>();
        list.add(param1);
        list.add(String.valueOf(param2));
        return list;
    }

    /**To add an unique object name for SharedPreferences saving*/
    @Override
    public String getPrefName() {
        return prefName;
    }

    @Override
    public void setParamList(ArrayList<String> list) {
        param1 = list.get(0);
        param2 = Integer.parseInt(list.get(1));
    }

    @Override
    public void createNew() {
//        SomeClass();
    }

    @Override
    public void createInstance() {

    }
}
