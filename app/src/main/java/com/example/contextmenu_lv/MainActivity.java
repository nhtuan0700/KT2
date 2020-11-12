package com.example.contextmenu_lv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.contextmenu_lv.adapter.CustomAdapter;
import com.example.contextmenu_lv.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listview;
    private CustomAdapter customAdapter;
    ArrayList<Contact> listContact;
    Button btn_add;
    public static boolean isActionMode = false;
    public static ArrayList<Contact> contactSeletion = new ArrayList<>();
    public static ActionMode actionMode = null;
    public static final String BUNDLE = "BUNDLE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.listview);
        listContact = new ArrayList<>();

        listContact = new ArrayList<>();
        listContact.add(new Contact("Nguyễn Hữu Tuấn","012321312",R.drawable.thor));
        listContact.add(new Contact("Nguyễn Văn Trí","012321312",R.drawable.image2));
        listContact.add(new Contact("Trịnh Quang Phúc","013142983",R.drawable.image3));
        listContact.add(new Contact("Nguyễn Kim An","013142983",R.drawable.image4));

        customAdapter = new CustomAdapter(this,R.layout.row_item, listContact);

        listview.setAdapter(customAdapter);

        registerForContextMenu(listview);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(MainActivity.this,listContact.get(position).getName(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this,activity_detail.class);
                Bundle bundle = new Bundle();
                bundle.putString("NAME",listContact.get(position).getName());
                bundle.putString("PHONE",listContact.get(position).getPhone());
                bundle.putInt("IMAGE",listContact.get(position).getImage());

                intent.putExtra(BUNDLE,bundle);
                startActivity(intent);
            }
        });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setTitle("Xác nhận xóa");
                builder.setMessage("Bạn có chắc muốn xóa?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//
                            customAdapter.removeItem(listContact);

                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            };
        });
    }

}