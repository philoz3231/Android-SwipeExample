package junho.swipeviewswithtabs;

import android.util.Log;
import android.widget.Toast;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Junho on 2015-12-29.
 */
public class RetainedAppData {
    protected final String TAG = getClass().getSimpleName();
    public urlListData mData; // urlList data received, private에서 public으로 일단 바꿈
    private GetUrlListRestAdapter mGetUrlListRestAdapter; //REST Adapter
    private Callback<urlListData> mUrlListDataCallback = new Callback<urlListData>(){
        @Override
        public void success(urlListData data, Response response){
            Log.d(TAG, "retain data success" + data.toString());
            mData = data;
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
