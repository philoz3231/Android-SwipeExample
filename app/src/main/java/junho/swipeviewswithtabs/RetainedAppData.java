package junho.swipeviewswithtabs;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Junho on 2015-12-29.
 */
public class RetainedAppData {
    protected final String TAG = getClass().getSimpleName();
    protected List<urlListData> mDatas;
    private GetUrlListRestAdapter mGetUrlListRestAdapter; //REST Adapter
    private Callback<MainServerData<List<urlListData>>> mUrlListDataCallback = new Callback<MainServerData<List<urlListData>>>(){

        @Override
        public void success(MainServerData<List<urlListData>> data, Response response){
            Log.d(TAG, data.message);
            mDatas = data.object;
            //Log.d(TAG, urlListDatas.get(0).toString());

            urlListDataControlloer.urlListSources = (ArrayList<urlListData>)mDatas;

        }
        @Override
        public void failure(RetrofitError error) {
            Log.d(TAG, "failure: " + error);
        }
    };

    // Method to test Async. call
    public void runRetrofitTestAsync (final int usrKey, int startNum, int urlNum) {

       //이미 데이터를 받아오는지 Progress flag를 만들어 판단
        /*
        if (mInProgress.get()) {
            Toast.makeText(getApplicationContext(), "Weather fetch in progress.",
                    Toast.LENGTH_LONG).show();
            return;
        }
        */

        // Get the Adapter
        if (mGetUrlListRestAdapter == null)
            mGetUrlListRestAdapter = new GetUrlListRestAdapter();
        mGetUrlListRestAdapter.testUrlListApi(usrKey, startNum, urlNum, mUrlListDataCallback); // Call Async API
    }
}

