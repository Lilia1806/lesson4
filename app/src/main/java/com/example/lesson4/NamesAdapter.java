package com.example.lesson4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.lang.invoke.ConstantCallSite;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.NamesViewHilder> {

    private OnClickItemCat onClickItemCat;
    private ArrayList<CatModel> listCat = null;

    public void setOnClickItemCat(OnClickItemCat onClickItemCat) {
        this.onClickItemCat = onClickItemCat;
    }

    public void setListCat(ArrayList<CatModel> listCat) {
        this.listCat = listCat;
        notifyDataSetChanged();
    }

    @NonNull
    @Override

    public NamesAdapter.NamesViewHilder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NamesViewHilder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_names, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NamesAdapter.NamesViewHilder holder, int position) {
        holder.onBind(listCat.get(position));
    }

    @Override
    public int getItemCount() {
        return listCat.size();
    }

    public class NamesViewHilder extends RecyclerView.ViewHolder {
        TextView name, code;
        ImageView imageView;
        ConstraintLayout constraintLayout;

        public NamesViewHilder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.txt_name);
            code = itemView.findViewById(R.id.txt_status_code);
            imageView = itemView.findViewById(R.id.image_cat);


        }

        public void onBind(CatModel listCats) {
            URI uri = null;
            try {
                uri = new URI(listCats.getStatusCode());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            String path = uri.getPath();
            String idStr = path.substring(path.lastIndexOf('/') + 1);
            int id = Integer.parseInt(idStr);

            name.setText(listCats.getDescription());
            code.setText(String.valueOf(id));
            Glide.with(imageView.getContext()).load(listCats.getStatusCode()).into(imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickItemCat.listtenerClickItemCat(listCats);
                }
            });
        }
    }
}
