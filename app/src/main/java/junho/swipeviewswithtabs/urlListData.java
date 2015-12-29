package junho.swipeviewswithtabs;

import java.util.List;

/**
 * Created by Junho on 2015-12-29.
 */
public class urlListData implements Cloneable {
    public int urlKey;
    public int boxKey;
    public String url;
    public String urlTitle;
    public int urlWriterUsrKey;
    public String urlWriterUsrName;
    public String urlDate;
    public String urlThumbnail;
    public int liked;
    public int hidden;
    public int readLater;
    public int likedNum;
    //public List<TagListData> urlTags;
    @Override
    public String toString(){
        return "urlKey="+ urlKey +", url="+ url +", urlTitle="+ urlTitle + "\n"
                +"urlWriterUsrName="+ urlWriterUsrName +", urlDate="+ urlDate +", urlThumbnail"+ urlThumbnail + "\n"
                + (liked ==0?"False":"True") + ", likedNum=" + likedNum;
    }
    @Override
    public urlListData clone() {
        try {
            return (urlListData) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return new urlListData();
        }
    }

    public String getUrlTitle(){
        return urlTitle;
    }

   /* public String getTag(int i)
    {
        return urlTags.get(i).tag;
    }*/

}
