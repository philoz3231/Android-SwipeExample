package junho.swipeviewswithtabs;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;

/**
 * Created by Junho on 2015-12-29.
 */
public class GetUrlListRestAdapter {
    protected final String TAG = getClass().getSimpleName();
    protected  RestAdapter mRestAdapter;
    protected  GetUrlListApi mApi;
    static final String serverEndPoint = "http://54.68.42.138:9000"; // Junho's Server IP

    public GetUrlListRestAdapter(){
        mRestAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(serverEndPoint)
                .build();

        mApi = mRestAdapter.create(GetUrlListApi.class); //create the interface
        Log.d(TAG, "GetUrlListRestAdapter -- created");
    }

    public void testUrlListApi(int usrKey, int startNum, int urlNum, Callback<MainServerData<List<urlListData>>> callback){
        Log.d(TAG, "testUrlListApi for usrKey:" + usrKey + " startNum: " + startNum + " urlNum: " + urlNum);
        mApi.getUrlListFromApi(usrKey, startNum, urlNum, callback);
    }

}
