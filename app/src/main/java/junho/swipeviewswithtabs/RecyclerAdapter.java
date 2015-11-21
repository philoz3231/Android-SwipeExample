package junho.swipeviewswithtabs;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Junho on 2015-11-22.
 */

    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
        Context context;
        List<Home_item> items;
        int item_layout;

        public RecyclerAdapter(Context context, List<Home_item> items, int item_layout) {
            this.context=context;
            this.items=items;
            this.item_layout=item_layout;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, null);
            return new ViewHolder(v);
        }

        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final Home_item item = items.get(position);
            Drawable profileImageDrawable = context.getResources().getDrawable(item.getHomeProfileImage());
            holder.home_profileImage.setBackground(profileImageDrawable);
            holder.home_insightText.setText(item.getHomeInsightText());
            Drawable urlImageDrawble = context.getResources().getDrawable(item.getHomeUrlImage());
            holder.home_urlImage.setBackground(urlImageDrawble);
            holder.home_urlWriter.setText(item.getHomeUrlWriter());
            holder.home_urltitleText.setText(item.getHomeUrltitleText());
            holder.home_likeNum.setText(item.getHomeLikeNum());

            holder.cardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, item.getHomeUrltitleText(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        //////이 어댑터를 사용하는 recyclerView와 연결(왜 쓰는지는 잘 모르겠음)
        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }

        @Override
        public int getItemCount() {
            return this.items.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            ImageView home_profileImage;
            TextView home_insightText;
            ImageView home_urlImage;
            TextView home_urlWriter;
            TextView home_urltitleText;
            TextView home_likeNum;
            CardView cardview;

            public ViewHolder(View itemView) {
                super(itemView);
                home_profileImage = (ImageView)itemView.findViewById(R.id.home_profileImage);
                home_insightText = (TextView)itemView.findViewById(R.id.home_urltitleText);
                home_urlImage = (ImageView)itemView.findViewById(R.id.home_urlImage);
                home_urltitleText = (TextView)itemView.findViewById(R.id.home_urltitleText);
                home_urlWriter = (TextView)itemView.findViewById(R.id.home_urlWriter);
                home_likeNum = (TextView)itemView.findViewById(R.id.home_likeNum);
                cardview = (CardView)itemView.findViewById(R.id.cardview);
            }
        }
}
