package slingge.functionblock.ui.specialEffects;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import slingge.functionblock.R;
import slingge.functionblock.ui.SlinggeActivity;

/**
 * Created by Slingge on 2017/1/11 0011.
 */

public class ListViewActivity extends SlinggeActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.effects_activity_listview);

        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(new ListAdapter(this));
    }

}
