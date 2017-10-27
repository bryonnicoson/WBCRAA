package com.example.bryon.wishbonecaninerescue;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bryon.wishbonecaninerescue.model.Dog;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DogListAdapter extends ArrayAdapter<Dog> {

    static class ViewHolder {
        ImageView ivImage;
        TextView tvName;
        TextView tvSize;
        TextView tvAge;
//        ImageView ivSex;
        TextView tvSex;
        TextView tvBreed;
//        ImageView ivVaccinated;
//        TextView tvVaccinated;
//        ImageView ivAltered;
//        TextView tvAltered;
//        ImageView ivHouseTrained;
//        TextView tvHouseTrained;


    }

    public DogListAdapter(Context context, ArrayList<Dog> dogs) {
        super(context, 0, dogs);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        Dog dog = getItem(position);

        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.dog_card, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.ivImage = (ImageView) view.findViewById(R.id.dog_photo);
            viewHolder.tvName = (TextView) view.findViewById(R.id.dog_name);
            viewHolder.tvSize = (TextView) view.findViewById(R.id.dog_size);
            viewHolder.tvAge = (TextView) view.findViewById(R.id.dog_age);
            viewHolder.tvSex = (TextView) view.findViewById(R.id.dog_sex);
//            viewHolder.ivSex = (ImageView) view.findViewById(R.id.dog_sex);
            viewHolder.tvBreed = (TextView) view.findViewById(R.id.dog_breed);
//            viewHolder.ivVaccinated = (ImageView) view.findViewById(R.id.list_iv_vaccinated);
//            viewHolder.tvVaccinated = (TextView) view.findViewById(R.id.list_tv_vaccinated);
//            viewHolder.ivAltered = (ImageView) view.findViewById(R.id.list_iv_altered);
//            viewHolder.tvAltered = (TextView) view.findViewById(R.id.list_tv_altered);
//            viewHolder.ivHouseTrained = (ImageView) view.findViewById(R.id.list_iv_housetrained);
//            viewHolder.tvHouseTrained = (TextView) view.findViewById(R.id.list_tv_housetrained);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Picasso.with(getContext()).load(dog.images.get(0)).resize(200,200).into(viewHolder.ivImage);
        viewHolder.tvName.setText(dog.name);
        viewHolder.tvSize.setText(dog.size);
        viewHolder.tvAge.setText(dog.age);
        viewHolder.tvSex.setText(dog.sex);
        viewHolder.tvBreed.setText(dog.breed);

        // if hasShots, housetrained, altered, add imageview checkedbox and textview string
//        if (dog.hasShots) {
//            viewHolder.ivVaccinated.setImageResource(R.drawable.checked36);
//            viewHolder.tvVaccinated.setText("vaccinated");
//        }
//
//        if (dog.altered) {
//            viewHolder.ivAltered.setImageResource(R.drawable.checked36);
//            if (dog.sex.equals("Male")) {
//                viewHolder.tvAltered.setText("neutered");
//            } else {
//                viewHolder.tvAltered.setText("spayed");
//            }
//        }
//
//        if (dog.housetrained) {
//            viewHolder.ivHouseTrained.setImageResource(R.drawable.checked36);
//            viewHolder.tvHouseTrained.setText("house-trained");
//        }

//        if (dog.sex.equals("Male"))
//            viewHolder.ivSex.setImageResource(R.drawable.male);
//        else
//            viewHolder.ivSex.setImageResource(R.drawable.female);

        return view;
    }
}
