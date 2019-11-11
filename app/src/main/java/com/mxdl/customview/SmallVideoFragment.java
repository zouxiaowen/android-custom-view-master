package com.mxdl.customview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class SmallVideoFragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    List<String> list;
    SmallVideoAdpter smallVideoAdpter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view==null){
            view=inflater.inflate(R.layout.layout_smallvideofragment,container,false);
        }
        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        list=new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        smallVideoAdpter=new SmallVideoAdpter(R.layout.layout_smalladpter,list);
        recyclerView.setAdapter(smallVideoAdpter);
        return view;
    }
}
