package com.mxdl.customview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class AtlasFragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    List<String> listdata;
    AtlasAdpter atlasAdpter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view==null){
            view=inflater.inflate(R.layout.layout_atlasfragment,container,false);
        }
        recyclerView=view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),4));
        listdata=new ArrayList<>();
        listdata.add("http://img3.redocn.com/tupian/20160202/dianyinghaibaosheji_5851219.jpg");
        listdata.add("http://www.heiguang.com/uploadfile/2016/0119/20160119033850482.jpg");
        listdata.add("http://rizhao.dzwww.com/yl/201909/W020190925611617058053.jpg");
        listdata.add("http://i0.sinaimg.cn/ent/m/c/2014-08-09/U105P28T3D4188993F326DT20140809030234.jpg");
        listdata.add("http://photo.16pic.com/00/03/04/16pic_304452_b.jpg");
        listdata.add("http://img21.mtime.cn/CMS/News/2010/06/18/181656.89747211.jpg");
        listdata.add("http://b-ssl.duitang.com/uploads/item/201804/18/20180418214848_xufti.jpg");
        listdata.add("http://img4.cache.netease.com/ent/2015/9/8/20150908161735da45c_550.jpg");
        listdata.add("http://img.sccnn.com/bimg/337/48817.jpg");
        listdata.add("http://img3.redocn.com/tupian/20160202/dianyinghaibaosheji_5851219.jpg");
        listdata.add("http://www.heiguang.com/uploadfile/2016/0119/20160119033850482.jpg");
        listdata.add("http://rizhao.dzwww.com/yl/201909/W020190925611617058053.jpg");
        listdata.add("http://i0.sinaimg.cn/ent/m/c/2014-08-09/U105P28T3D4188993F326DT20140809030234.jpg");
        listdata.add("http://photo.16pic.com/00/03/04/16pic_304452_b.jpg");
        listdata.add("http://img21.mtime.cn/CMS/News/2010/06/18/181656.89747211.jpg");
        listdata.add("http://b-ssl.duitang.com/uploads/item/201804/18/20180418214848_xufti.jpg");
        listdata.add("http://img4.cache.netease.com/ent/2015/9/8/20150908161735da45c_550.jpg");
        listdata.add("http://img.sccnn.com/bimg/337/48817.jpg");
        atlasAdpter=new AtlasAdpter(R.layout.layout_adpter_iamge,listdata);
        recyclerView.setAdapter(atlasAdpter);
        return view;

    }
}
