package com.example.recyclerview123;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
class CustomAdapter implements ListAdapter {
    ArrayList<SubjectData> arrayList;
    Context context;
    public CustomAdapter(Context context, ArrayList<SubjectData> arrayList) {
        this.arrayList=arrayList;
        this.context=context;
    }
    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }
    @Override
    public boolean isEnabled(int position) {
        return true;
    }
    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
    }
    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
    }
    @Override
    public int getCount() {
        return arrayList.size();
    }
    @Override
    public Object getItem(int position) {
        return position;
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public boolean hasStableIds() {
        return false;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SubjectData subjectData=arrayList.get(position);
        if(convertView==null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView=layoutInflater.inflate(R.layout.list_row, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            TextView tittle=convertView.findViewById(R.id.title);
            TextView tittle2=convertView.findViewById(R.id.title2);
            TextView tittle3=convertView.findViewById(R.id.title3);
            TextView tittle4=convertView.findViewById(R.id.title4);
            TextView tittle5=convertView.findViewById(R.id.title5);
            TextView tittle6=convertView.findViewById(R.id.title6);
            TextView tittle7=convertView.findViewById(R.id.title7);
            TextView tittle8=convertView.findViewById(R.id.title8);
            TextView tittle9=convertView.findViewById(R.id.title9);





            ImageView imag=convertView.findViewById(R.id.list_image);
            ImageView imag1=convertView.findViewById(R.id.list_image1);
            tittle.setText(subjectData.SubjectName);
            tittle2.setText(subjectData.SubjectName2);
            tittle3.setText(subjectData.SubjectName3);
            tittle4.setText(subjectData.SubjectName4);
            tittle5.setText(subjectData.SubjectName5);
            tittle6.setText(subjectData.SubjectName6);
            tittle7.setText(subjectData.SubjectName7);
            tittle8.setText(subjectData.SubjectName8);
            tittle9.setText(subjectData.SubjectName9);




         Picasso.with(context)
                    .load(subjectData.Image)
                    .into(imag);
       /*   Picasso.with(context)
                    .load(subjectData.Image1)
                    .into(imag1);
*/
        }
        return convertView;
    }
    @Override
    public int getItemViewType(int position) {
        return position;
    }
    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }
    @Override
    public boolean isEmpty() {
        return false;
    }
}