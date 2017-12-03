package com.squorpikkor.android.app.trenkaassistant2;

import java.util.ArrayList;

/**
 * Created by VadimSquorpikkor on 02.09.2017.
 *
 */

public class ObjectList<T extends ICanSave3> {
    private ArrayList<T> innerList = new ArrayList<>();
    private String prefName;
    private SaveLoad saveLoad = new SaveLoad();
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

    public void save() {
        ArrayList<String> saveList = new ArrayList<>();
        saveList.add(String.valueOf(innerList.get(0).getParamList().size()));/**
         In first yacheika i will save the size of param list -- when i will load paramList i will know its size
         that's how i can separate parameters of each other (its all saving together)**/

        /**
         * Good idea -- when saving the list is to save THE NAME OF CLASS (with Class methods -- i mean reflection)
         * then when loading the list use this name to create an object
         *
         * on save: Class c = myObject.getClass();
                    String s = c.getName();
         *
         * on load: String className = list.get(1);
         * Class c = Class.forName(className);
         * return c.newInstance();
         * **/
        for (T t : innerList) {
            saveList.addAll(t.getParamList());
        }
        saveLoad.saveStringArray(saveList, prefName);
    }

    public void load() throws InstantiationException, IllegalAccessException {
        ArrayList<String> loadedList = saveLoad.loadStringArray(prefName);
        int paramListSize = Integer.parseInt(loadedList.get(0));
        innerList.clear();
        for (String s : loadedList.subList(1, loadedList.size() - 1)) {
            innerList.add(newInstance());

        }

    }


    private Class<T> clazz;
    public ObjectList(Class<T> claz) {
        this.clazz = claz;
    }


    private T newInstance() throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

//    Class refClass = T.class;
}
