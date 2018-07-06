package com.example.vkrishan.roommies;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TabFragment extends Fragment {

    // We will keep reusing this Fragment based on the position.

    int position;
    private TextView TabText;

    public static Fragment getFragmentInstance(int position){

        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);

        TabFragment tf = new TabFragment();
        tf.setArguments(bundle);
        return tf;
    }


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("pos");  //// getArguments() ????
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_tab, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        TextView tv = (TextView)view.findViewById(R.id.textView);
        tv.setText("Fragment"+ (position+1));

    }


}
