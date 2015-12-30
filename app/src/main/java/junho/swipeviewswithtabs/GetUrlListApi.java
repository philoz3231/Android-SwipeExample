package junho.swipeviewswithtabs;


import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;


/**
 * Created by Junho on 2015-12-29.
 */
public interface GetUrlListApi {
    @GET("/urlList/AllList/{usrKey}/{startNum}/{urlNum}")
   void getUrlListFromApi(@Path("usrKey") int usrKey, @Path("startNum") int startNum,
                                        @Path("urlNum") int urlNum, Callback<MainServerData<List<urlListData>>> callback);

}
