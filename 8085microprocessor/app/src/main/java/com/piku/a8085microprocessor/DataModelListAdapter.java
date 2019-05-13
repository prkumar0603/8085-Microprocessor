package com.piku.a8085microprocessor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class DataModelListAdapter extends ArrayAdapter<DataModel> {
    private static final String TAG = "GroupsListAdapter";
    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    //viewholder for smooth hold
    static class ViewHolder{
        TextView name;
    }


    public DataModelListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<DataModel> objects) {
        super(context, resource, objects);
        this.mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //get the names info
        String name = getItem(position).getName();

        //create the model object with info
        DataModel model = new DataModel(name);

        //create the viee result for showing the animation
        final View result;

        //ViewHoder object
        ViewHolder holder;

        if(convertView == null)
        {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource,parent,false);

            holder = new ViewHolder();
            holder.name = convertView.findViewById(R.id.textview);

            result = convertView;

            convertView.setTag(holder);
        }

        else{
            holder = (ViewHolder)convertView.getTag();
            result = convertView;
        }

        Animation animation = AnimationUtils.loadAnimation(mContext,
                (position > lastPosition)? R.anim.load_down_anim : R.anim.load_up_anim );
        result.startAnimation(animation);
        lastPosition = position;

        holder.name.setText(name);

        return convertView;
    }



}
