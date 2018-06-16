package com.kapil.rxrvtrack;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kapilbakshi on 16/06/18.
 */


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PersonViewHolder> {

    private List<Person> personsList;

    public RecyclerViewAdapter(List<Person> personsList) {
        this.personsList = personsList;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        return new PersonViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(PersonViewHolder holder, final int position) {
        Person person = getItem(position);
        holder.personNoTextView.setText(person.getPhoneNo());
        holder.personNameTextView.setText(person.getName());


    }

    @Override
    public int getItemCount() {
        return personsList.size();
    }

    public Person getItem(int position) {
        return personsList.get(position);
    }

    class PersonViewHolder extends RecyclerView.ViewHolder {

        private TextView personNameTextView;

        private TextView personNoTextView;

        PersonViewHolder(View rowView) {
            super(rowView);
            personNameTextView = (TextView) rowView.findViewById(R.id.person_name_tv);
            personNoTextView = (TextView) rowView.findViewById(R.id.person_no_tv);
        }

    }

}
