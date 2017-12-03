package com.squorpikkor.android.app.trenkaassistant2;

import android.content.Context;
import android.content.SharedPreferences;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by VadimSquorpikkor on 22.08.2017.
 *
 */

class SaveLoad{

    private final String SAVE_FIELD = "setting";
    private Context context;

    private SharedPreferences preferences;

    SaveLoad(Context context) {
        this.context = context;
    }


    /**
     * Для случаев, когда не нужен контекст
     * */
    SaveLoad() {
    }

    /**
     * Можно было бы, конечно, сделать методы без перегрузки, т.е. сохранять
     * всЁ в одном методе, а не разбивать на два, но так как есть будет
     * удобнее для использования класса в будущем для более гибкого использования методов,
     * для композиции и т.д.
     * Прикол методов: ссылка всегда одна, но она ссылается на разны объекты
     * //Прикол методов: ссылка каждый раз создается заново -- она существует только в теле метода(старый вариант)//
     * P.S. Другой вариант класса -- можно было бы использовать коллекцию для хранения ссылок
     */

    /*public void saveDoubleStringObj(ArrayList<Double> dList, ArrayList<String> sList, String prefName) {
        preferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        saveDoubleArray(dList, preferences);
        saveStringArray(sList, preferences);
    }

    public ArrayList<ArrayList<Double>, ArrayList<String>> loadDouble
    */

    public void saveStringArray(ArrayList<String> list, String prefName) {
        preferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        saveStringArray(list, preferences);
    }

    public ArrayList<String> loadStringArray(String prefName) {
        preferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        return loadStringArray(preferences);
    }

    void saveDoubleArray(ArrayList<Double> list, String prefName) {
        preferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        saveDoubleArray(list, preferences);
    }

    ArrayList<Double> loadDoubleArray(String prefName) {
        preferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        return loadDoubleArray(preferences);
    }

    void saveDouble(double d, String prefName) {
        preferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        saveDouble(d, preferences);
    }

    double loadDouble(String prefName) {
        preferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        return loadDouble(preferences);
    }

    void saveString(String s, String prefName) {
        preferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        saveString(s, preferences);
    }

    String loadString(String prefName) {
        preferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        return loadString(preferences);
    }

    void saveInteger(int i, String prefName) {
        preferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        saveInteger(i, preferences);
    }

    int loadInteger(String prefName) {
        preferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        return loadInteger(preferences);
    }

    /**PRIVATE METHODS************************************/

    private void saveStringArray(ArrayList<String> list, SharedPreferences sPref) {//It should be own class, for better composition -- it can be using in another classes
        int count = 0;
        SharedPreferences.Editor editor = sPref.edit();
        editor.clear();//For save less variables than before, if do not clear, it will load old variables, from old session
        for (String s : list) {
            editor.putString(SAVE_FIELD + count, s);
            count++;
        }
        editor.apply();
    }

    private ArrayList<String> loadStringArray(SharedPreferences sPref) {
        ArrayList<String> list = new ArrayList<>();
//        list.clear();
        int count = 0;
        while (sPref.contains(SAVE_FIELD + count)) {
            //list.add(SAVE_FIELD + count);
            String s = sPref.getString(SAVE_FIELD + count, "");
            list.add(s);
            count++;
        }
        return list;
    }

    private void saveDoubleArray(ArrayList<Double> list, SharedPreferences sPref) {
        int count = 0;
        SharedPreferences.Editor editor = sPref.edit();
        editor.clear();//For save less variables than before, if do not clear, it will load old variables, from old session
        for (Double d : list) {
            editor.putFloat(SAVE_FIELD + count, Float.parseFloat(d.toString()));
            count++;
        }
        editor.apply();
    }

    private ArrayList<Double> loadDoubleArray(SharedPreferences sPref) {
        ArrayList<Double> list = new ArrayList<>();
        int count = 0;
        while (sPref.contains(SAVE_FIELD + count)) {
            double d = sPref.getFloat(SAVE_FIELD + count, (float) 0);
            list.add(d);
            count++;
        }
        return list;
    }

    private void saveDouble(double d, SharedPreferences sPref) {
        SharedPreferences.Editor editor = sPref.edit();
        editor.putFloat(SAVE_FIELD, (float)d);
        editor.apply();
    }

    private double loadDouble(SharedPreferences sPref) {
        double d = 55;
        if (sPref.contains(SAVE_FIELD)) {
            d = sPref.getFloat(SAVE_FIELD, 0);
        }
        return d;
    }

    private void saveString(String s, SharedPreferences sPref) {
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString(SAVE_FIELD, s);
        editor.apply();
    }

    private String loadString(SharedPreferences sPref) {
        String s = "";
        if (sPref.contains(SAVE_FIELD)) {
            s = sPref.getString(SAVE_FIELD, "");
        }
        return s;
    }

    private void saveInteger(int i, SharedPreferences sPref) {
        SharedPreferences.Editor editor = sPref.edit();
        editor.putInt(SAVE_FIELD, i);
        editor.apply();
    }

    private int loadInteger(SharedPreferences sPref) {
        int i = 0;
        if (sPref.contains(SAVE_FIELD)) {
            i = sPref.getInt(SAVE_FIELD, 0);
        }
        return i;
    }

    /**
     **************************************************************************************************************
     * for thinking about
     * */

    /*public void saveParam(String param1, int param2) {
        ArrayList<String> list = new ArrayList<>();
        list.add(param1);
        list.add(String.valueOf(param2));
        saveStringArray(list, "SOME_CLASS");
    }

    public void loadParam(String param1, int param2) {
        ArrayList<String> list = loadStringArray("SOME_CLASS");
        param1 = list.get(0);
        param2 = Integer.parseInt(list.get(1));
    }

    public void saveObjList(ArrayList<SomeClass_2> list) {
        ArrayList<String> savingList = new ArrayList<>();
        for (SomeClass_2 class_2 : list) {
            savingList.add(class_2.param3);
            savingList.add(String.valueOf(class_2.param4));
        }
        saveStringArray(savingList, "SOME_CLASS_LIST");

    }

    public void loadObjList(ArrayList<SomeClass_2> list) {
        ArrayList<String> loadedList = loadStringArray("SOME_CLASS_LIST");
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
    }*/

    /***********************************************************************************************
     * for thinking about 2
     * */


/**for saving single object. This only one name for Shared Preferences*/
    public void saveParamList(ICanSave iCanSave) {
        saveStringArray(iCanSave.getParamList(), iCanSave.getPrefName());
    }

/**overloading method for saving multiple object of one class -- for saving list of objects
     * just only for saveObjList_VERSION_1 */
    public void saveParamList(ICanSave iCanSave, int count) {
        saveStringArray(iCanSave.getParamList(), iCanSave.getPrefName() + count);
    }

    public void loadParamList(ICanSave iCanSave) {
        iCanSave.setParamList(loadStringArray(iCanSave.getPrefName()));
    }


/**VERSION_1: for saving each object in own file
     * the method lack is -- i don't know how to clear old useless files*/
    /*public void saveObjList(ArrayList<ICanSave> list) {
        int i = 0;
        for (ICanSave iCanSave : list) {
            saveParamList(iCanSave, i);
            i++;
        }
    }*/


/**VERSION_2: for saving every object params in single file
     * thoughts i should add the size of paramList to savingList (in [0] line)
     * that's how i will load the obj list -- first of all
     * i will get the count of parameters to know how to separate
     * the savingList -- there all parameters of all objects in one file together
     * or -- use iCan.getParamList.size()*/
    public void saveObjList(ArrayList<ICanSave> list) {
        ArrayList<String> savingList = new ArrayList<>();
        for (ICanSave iCanSave : list) {
            savingList.addAll(iCanSave.getParamList());
        }
        saveStringArray(savingList, list.get(0).getPrefName() + "_LIST");
    }


/**there's will be          /////wrong!//"this"///////          link in iCanSave place in parameters when this method will be called*/
    public void loadObjList(ArrayList<ICanSave> list, ICanSave iCanSave) {
        ArrayList<String> loadedList = loadStringArray(iCanSave.getPrefName() + "_LIST");
        int paramListSize = iCanSave.getParamList().size();
//        Type listType = new TypeToken<list>(){}.getType();
//        String className =
//        Class cl = Class.forName(className);
        for (int i = 0; i < loadedList.size()/paramListSize; i++) {
//            list.add(new iCanSave.getClass() {
//            list.add(new Class)
        }
    }

    public void loadObjList2(ArrayList<ICanSave> list) {

//        Class cl = list.get(0).getClass();
//        ArrayList<ICanSave> newList = new ArrayList<>();
//        newList.add(cl.newInstance());

//        Class cl = context.getClass();
//        ArrayList<ICanSave> newList = new ArrayList<>();
//        newList.add(cl.newInstance());

        Class cl = list.get(0).getClass();
        ArrayList<ICanSave> newList = new ArrayList<>();
        /*newList.add(cl.getConstructor().newInstance());
*/

    }

    /*public void loadObjList(ArrayList<ICanSave> list, Class<?> clazz) {
        ArrayList<ICanSave> tempList = list;
        list.clear();
        ArrayList<String> loadedList = loadStringArray(tempList.get(0).getPrefName() + "_LIST");
        int paramListSize = tempList.get(0).getParamList().size();
        for (int i = 0; i < loadedList.size()/paramListSize; i++) {
//            list.add(new (tempList.get(0).getClass().getSimpleName()));
            list.add(new clazz());
        }
    }*/

public void loadObjList(ArrayList<SomeClass_2> list) {

    }



    /**for thinking about 3 **********************************************************************/

    public void saveObjList(ICanSave iCanSave) {
        ArrayList<String> savingList = new ArrayList<>();
        
    }

    private <T> ArrayList<T> pushBack(ArrayList<T> list, Class<T> typeKey) throws Exception {
        list.add(typeKey.getConstructor().newInstance());
        return list;
    }

    /*public void loadObjList3(ArrayList<ICanSave> list) {
        ArrayList<String> loadedList = loadStringArray(iCanSave.getPrefName() + "_LIST");
        int paramListSize = iCanSave.getParamList().size();
        for (int i = 0; i < loadedList.size()/paramListSize; i++) {
//            list.add(new iCanSave.getClass() {
//            list.add(new Class)
        }
    }*/


}
