package task.app.contact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class ShowContact extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ContactAdapter adapter;
    private List<Contact> contact_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_contact);
        DatabaseHandler db = new DatabaseHandler(this);

        // Reading all contacts
        Log.d("Reading1: ", "Reading all contacts..");
        contact_list = db.getAllContacts();
        for (Contact cn : contact_list) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
        GenerateContactList(contact_list);

    }

    public void GenerateContactList(List<Contact>mContactAdapter){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new ContactAdapter(this, mContactAdapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(ShowContact.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
