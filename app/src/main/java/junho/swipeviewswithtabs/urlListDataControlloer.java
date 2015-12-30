package junho.swipeviewswithtabs;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by junho on 2015-12-30.
 */
public class urlListDataControlloer extends Application {
    private static urlListDataControlloer application;
    public static ArrayList<urlListData> urlListSources = null;

    public static urlListDataControlloer getApplication(){
        return application;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        urlListDataControlloer.application = this;
        initData();
    }

    private void initData(){
      urlListSources = new ArrayList<>();
    }



}
