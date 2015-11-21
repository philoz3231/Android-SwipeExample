package junho.swipeviewswithtabs;

/**
 * Created by Junho on 2015-11-22.
 */
public class Home_item {
    int home_profileImage;
    String home_insightText;
    int home_urlImage;
    String home_urlWriter;
    String home_urltitleText;
    String home_likeNum;

    Home_item( int home_profileImage,  String home_insightText,  int home_urlImage, String home_urlWriter, String home_urltitleText, String home_likeNum){
        this.home_profileImage = home_profileImage;
        this.home_insightText = home_insightText;
        this.home_urlImage = home_urlImage;
        this.home_urlWriter = home_urlWriter;
        this.home_urltitleText = home_urltitleText;
        this.home_likeNum = home_likeNum;
    }
    int getHomeProfileImage(){
        return this.home_profileImage;
    }
    String getHomeInsightText(){
        return this.home_insightText;
    }
    int getHomeUrlImage(){
        return this.home_urlImage;
    }

    String getHomeUrlWriter(){
        return this.home_urlWriter;
    }

    String getHomeUrltitleText(){
        return this.home_urltitleText;
    }

    String getHomeLikeNum(){
        return this.home_likeNum;
    }
}
