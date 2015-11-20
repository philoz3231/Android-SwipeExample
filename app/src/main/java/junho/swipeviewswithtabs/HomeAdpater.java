package junho.swipeviewswithtabs;

import android.content.Context;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class HomeAdpater extends ArrayAdapter<String>{

    HomeAdpater(Context context, String[] foods){
        super(context, R.layout.list_home_row, foods);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater homeInflater = LayoutInflater.from(getContext());
        View homeView = homeInflater.inflate(R.layout.list_home_row, parent, false);

        String singleFoodItem = getItem(position);
        TextView homeNameText = (TextView) homeView.findViewById(R.id.homeNameText);
        ImageView homeImage = (ImageView) homeView.findViewById(R.id.homeImage);

        homeNameText.setText(singleFoodItem);
        homeImage.setImageResource(R.drawable.mainpage_image);

        return homeView;
    }
}
