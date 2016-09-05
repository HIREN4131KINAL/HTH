package com.example.hirenamaliyar.attendenceemployee;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ShowAllData extends AppCompatActivity {
    //recycler list view
    RecyclerView rv;

    public ArrayList<HashMap<String, String>> emloyee_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_data);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        rv = (RecyclerView) findViewById(R.id.rv);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        rv.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(mLayoutManager);
        // seting custom adapter
//getting sql database values
        GettingSqlData gettingSqlData = new GettingSqlData(this);

        //Arralist is saving data from sql lite database
        emloyee_info = gettingSqlData.getResults();

        Log.e("onCreate: ", emloyee_info + "");

        // seting custom adapter
        if (emloyee_info != null) {
            rv.setAdapter(new MyAdapter(emloyee_info));
        } else {
            Toast.makeText(ShowAllData.this, "Arraylist is empty", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // adapter class for Fragment home
    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private ArrayList<HashMap<String, String>> mDataset;

        public MyAdapter(ArrayList<HashMap<String, String>> Employee_info) {
            mDataset = Employee_info;
        }

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            private TextView tv_fullname, tv_contact, tv_designation;
            // private RelativeLayout rel_layout;

            public ViewHolder(View itemView) {
                super(itemView);

                tv_fullname = (TextView) itemView.findViewById(R.id.tv_fullname);
                tv_contact = (TextView) itemView.findViewById(R.id.tv_contact);
                tv_designation = (TextView) itemView.findViewById(R.id.tv_designation);
                // rel_layout = (RelativeLayout) itemView.findViewById(R.id.rel_layout);
            }
        }

        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_show_all_data, parent, false);
            // set the view's size, margins, paddings and layout parameters
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(MyAdapter.ViewHolder holder, final int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element


            final String FullName = mDataset.get(position).get("name");
            final String ContactNo = mDataset.get(position).get("phone_number");
            final String Designation = mDataset.get(position).get("designation");
            Log.e("onBindViewHolder: ", FullName + "");

            holder.tv_fullname.setText(FullName);
            holder.tv_contact.setText(ContactNo);
            holder.tv_designation.setText(Designation);

            //    holder.total_papers.setText(Paper_count);

          /*  holder.rel_layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    BranchName = branchList.get(position).get(TAG_BRANCH);
                    Log.d("onItemClick: ", BranchName);
                    Intent i = new Intent(getActivity(), Activity_Semester.class);
                    i.putExtra("branch_name", BranchName);
                    startActivity(i);

                }
            });*/

        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }


    }
}
