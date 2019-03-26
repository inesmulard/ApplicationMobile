package com.example.app.recettons;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.app.recettons.R;

import org.json.JSONArray;
import org.json.JSONException;

public class RecetteAdapter extends RecyclerView.Adapter<RecetteAdapter.RecetteHolder> {

    private JSONArray recetteArray;

    public RecetteAdapter(JSONArray array){
        this.recetteArray = array;
    }

    @Override
    public RecetteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_element, parent, false);
        RecetteHolder holder = new RecetteHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecetteHolder holder, int position) {
        try {
            String name = recetteArray.getJSONObject(position).getJSONObject("recipe").getString("label");
            String url = recetteArray.getJSONObject(position).getJSONObject("recipe").getString("url");
            String img =recetteArray.getJSONObject(position).getJSONObject("recipe").getString("image");
            String health = "";
            int i;
            int labelsLength = recetteArray.getJSONObject(position).getJSONObject("recipe").getJSONArray("healthLabels").length();
            for (i = 0; i < labelsLength; i++){
                health += " -- " + recetteArray.getJSONObject(position).getJSONObject("recipe").getJSONArray("healthLabels").get(i).toString();
            }
            holder.changeAll(name,url,img, health);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return recetteArray.length();
    }

    public void setNewRecette(JSONArray array){
        this.recetteArray = array;
        notifyDataSetChanged();
    }

    class RecetteHolder extends RecyclerView.ViewHolder {
        private TextView tv_name, tv_url, tv_health;
        private ImageView iv_image;

        public RecetteHolder(View itemView) {
            super(itemView);
            this.tv_name = itemView.findViewById(R.id.rv_name);
            this.tv_url = itemView.findViewById(R.id.rv_url);
            this.iv_image = itemView.findViewById(R.id.rv_image);
            this.tv_health = itemView.findViewById(R.id.rv_health);
        }

        private void changeAll(String name, String url, String img, String health){
            String link = "See the recipe <a href="+url+"> ici </a>.";
            tv_name.setText(name);
            Glide.with(itemView).load(img).into(iv_image);
            tv_url.setMovementMethod(LinkMovementMethod.getInstance());
            tv_url.setText(Html.fromHtml(link));
            tv_health.setText(health);
        }
    }
}
