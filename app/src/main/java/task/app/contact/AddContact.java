package task.app.contact;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContact extends AppCompatActivity {

    EditText ETName, ETPhone;
    Button AddContact;
    DatabaseHandler db;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        ETName = (EditText) findViewById(R.id.etName);
        ETPhone = (EditText) findViewById(R.id.etPhone);
        AddContact = (Button) findViewById(R.id.buAddButton);
        db = new DatabaseHandler(this);
        context=this;
        AddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = ETName.getText().toString();
                String Phone = ETPhone.getText().toString();
                // Inserting Contacts
                Log.d("Insert: ", "Inserting ..");
                db.addContact(new Contact(Name, Phone));
                Toast.makeText(context,"Contact added successfully",Toast.LENGTH_LONG).show();
            }
        });


        }
}
