package com.example.bpl;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<User> {
    public ListAdapter(Context context, ArrayList<User> userArrayList){
        super(context, R.layout.list_item, userArrayList);
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User user = getItem(position);
        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent,false);
        }

        ImageView imageView = convertView.findViewById(R.id.profileimg1);
        TextView name = convertView.findViewById(R.id.list1);
        TextView email = convertView.findViewById(R.id.email1);
        TextView contact = convertView.findViewById(R.id.contact1);
        imageView.setImageResource(user.imageId);
        name.setText(user.name);
        email.setText(user.email);
        contact.setText(user.phone);

        return convertView;
    }
}
