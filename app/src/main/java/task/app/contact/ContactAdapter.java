package task.app.contact;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {
    private Context mContext;
    private List<Contact> contactlist;

    public ContactAdapter(Context mContext, List<Contact> contactlist) {
        this.mContext = mContext;
        this.contactlist = contactlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.content_row, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Contact contact = contactlist.get(i);
        myViewHolder.Name.setText(contact.getName());
        myViewHolder.Phone.setText(contact.getPhoneNumber());

    }

    @Override
    public int getItemCount() {
        return contactlist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView Name, Phone;


        public MyViewHolder(View view) {
            super(view);
            Name = (TextView) view.findViewById(R.id.Name);
            Phone = (TextView) view.findViewById(R.id.Phone);

        }
    }
}
