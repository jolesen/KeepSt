package com.jnukeepst.keepst.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jnukeepst.keepst.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment {

    //构造函数
    public GameFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

}
