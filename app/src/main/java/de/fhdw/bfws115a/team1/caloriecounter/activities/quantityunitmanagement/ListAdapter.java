package de.fhdw.bfws115a.team1.caloriecounter.activities.quantityunitmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import de.fhdw.bfws115a.team1.caloriecounter.R;
import de.fhdw.bfws115a.team1.caloriecounter.database.DatabaseUnit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Florian Obladen.
 */

public class ListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

    /* Member variables */
    private Data mData;
    private ApplicationLogic mApplicationLogic;
    private final Context mContext;
    private final ArrayList<DatabaseUnit> mQuantityUnitEntities;

    public ListAdapter(Data data, ApplicationLogic applicationLogic) {
        mData = data;
        mApplicationLogic = applicationLogic;

        mContext = mData.getActivity().getApplicationContext();
        mQuantityUnitEntities = mData.getQuantityUnits();
    }

    /**
     * Counts the number of quantity unit entities.
     *
     * @return The size of the ArrayList which contains quantity unit entities.
     */
    @Override
    public int getCount() {
        return mQuantityUnitEntities.size();
    }

    /**
     * Gets the selected quantity unit entity from an ArrayList.
     *
     * @param i The position of the quantity unit entity which should be retrieved.
     * @return The quantity unit entity.
     */
    @Override
    public Object getItem(int i) {
        return mQuantityUnitEntities.get(i);
    }

    /**
     * Gets a specific quantity unit entity item ID.
     *
     * @param i The position of the quantity unit entity which ID should be retrieved.
     * @return The ID.
     */
    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * Never used in our application.
     * @param adapterView
     * @param view
     * @param i
     * @param l
     */
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListViewHolder listViewHolder;
        DatabaseUnit databaseUnit;
        databaseUnit = (DatabaseUnit) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.quantityunitmanagement_listrow, parent, false);
            listViewHolder = new ListViewHolder(convertView, mApplicationLogic);
            convertView.setTag(listViewHolder);
        } else {
            listViewHolder = (ListViewHolder) convertView.getTag();
        }

        listViewHolder.setDatabaseUnit(databaseUnit);
        listViewHolder.getNameText().setText(String.format("%s", databaseUnit.getName()));

        if (Arrays.asList(mContext.getResources().getStringArray(R.array.undeletable_units)).contains(databaseUnit.getName())) {
            listViewHolder.getDeleteImage().setVisibility(View.INVISIBLE);
        } else {
            listViewHolder.getDeleteImage().setVisibility(View.VISIBLE);
        }
        return convertView;
    }
}