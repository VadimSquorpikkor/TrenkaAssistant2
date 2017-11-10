package com.squorpikkor.android.app.trenkaassistant2;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by VadimSquorpikkor on 02.09.2017.
 *
 */

public class SaveLoadObjList<T> {

    private Context context;
    private SaveLoad saveLoad = new SaveLoad(context);

    SaveLoadObjList(Context context) {
        this.context = context;
    }

    public void saveObjList(ArrayList<ICanSave> list) {
        ArrayList<String> savingList = new ArrayList<>();
        for (ICanSave iCanSave: list) {
            iCanSave.saveParam();
        }
        saveLoad.saveStringArray(savingList, "SOME_CLASS_LIST");

    }

    public void loadObjList(ArrayList<SomeClass_2> list) {
        ArrayList<String> loadedList = saveLoad.loadStringArray("SOME_CLASS_LIST");
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

    public void saveParam(ArrayList<String> list) {
        saveLoad.saveStringArray(list, "SOME_CLASS");
    }

    public void loadParam(String param1, int param2) {
        ArrayList<String> list = saveLoad.loadStringArray("SOME_CLASS");
        param1 = list.get(0);
        param2 = Integer.parseInt(list.get(1));
    }
}
