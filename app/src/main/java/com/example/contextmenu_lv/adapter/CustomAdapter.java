package com.example.contextmenu_lv.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.contextmenu_lv.MainActivity;
import com.example.contextmenu_lv.R;
import com.example.contextmenu_lv.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Contact> {
    private Context context;
    private int resource;
    private List<Contact> arrContacts;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Contact> arrContacts) {
        super(context, resource, arrContacts);
        this.context = context;
        this.resource = resource;
        this.arrContacts = arrContacts;
    }

    @Override
    public int getCount() {
        return arrContacts.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Contact getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.row_item,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.imageView = (ImageView) view.findViewById(R.id.image);
            viewHolder.tvName= (TextView) view.findViewById(R.id.tv_name);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        try{
            Contact contact = arrContacts.get(position);
            int image = contact.getImage();
            viewHolder.imageView.setImageResource(image);
            viewHolder.tvName.setText(contact.getName());
        } catch (Exception e) {
        }
        return view;
    }

    public class ViewHolder{
        ImageView imageView;
        TextView tvName;
    }
    public void removeItem(ArrayList<Contact> contacts){
        for (Contact contact : contacts){
            contacts.remove(contact);
        }
        notifyDataSetChanged();
    }
}
