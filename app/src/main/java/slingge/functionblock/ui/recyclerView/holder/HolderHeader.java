package slingge.functionblock.ui.recyclerView.holder;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import slingge.functionblock.R;

/**
 * RecyclerView的HeaderView
 * Created by Slingge on 2017/1/9 0009.
 */

public class HolderHeader extends RelativeLayout {
    public HolderHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public HolderHeader(Context context) {
        super(context);
    }

    public HolderHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init(Context context) {
        inflate(context, R.layout.sample_header, this);

    }


}
