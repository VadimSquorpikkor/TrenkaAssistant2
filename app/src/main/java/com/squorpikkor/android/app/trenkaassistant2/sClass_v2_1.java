package com.squorpikkor.android.app.trenkaassistant2;

/**
 * Created by VadimSquorpikkor on 02.09.2017.
 *
 */

public class sClass_v2_1 implements ICanSave2{

    String param1 = "StringParam";
    int param2 = 11;

    private String prefName= "S";


    SaveLoad saveLoad = new SaveLoad();

    sClass_v2_1 (String prefName) {
        this.prefName = prefName;
        loadMe(); /**Is this useless?**/
    }

    @Override
    public void saveMe() {
        saveLoad.saveString(param1, getPrefName());
    }

    @Override
    public void loadMe() {
        param1 = saveLoad.loadString(getPrefName());

    }

    @Override
    public String getPrefName() {
        return prefName;
    }
}
