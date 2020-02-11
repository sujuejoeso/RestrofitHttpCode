package com.joeso.restrofithttpcode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class ListAdapter extends RecyclerView.Adapter<ListAdapter.myViewHolder> {
    Context context;
    List<Employee> responseList;

    public ListAdapter(Context context, List<Employee> data) {
        this.context = context;
        this.responseList = data;
    }

    @Override
    public ListAdapter.myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListAdapter.myViewHolder viewHolder, int position) {
        viewHolder.name.setText(responseList.get(position).getEmployeeName());
        viewHolder.salary.setText(responseList.get(position).getEmployeeSalary());
        viewHolder.age.setText(responseList.get(position).getEmployeeAge());
    }

    @Override
    public int getItemCount() {
        if (responseList != null) {
            return responseList.size();
        }
        return 0;
    }

    public void setEmployeeList(List<Employee> resList) {
        this.responseList = resList;
        notifyDataSetChanged();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView name,salary,age;

        public myViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            salary = (TextView) itemView.findViewById(R.id.salary);
            age = (TextView) itemView.findViewById(R.id.age);
        }
    }
}