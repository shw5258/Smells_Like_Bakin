package com.example.song.smellslikebakin;



import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ListFragment extends Fragment {

    public interface OnRecipeSelectedInterface {
        void onListRecipeSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        //ListFragment Activity를 OnRecipeSelectedInterface로 cast한다.
        //getActivity로 반환되는 것은 이 클래스의 인스턴스자기자신이다.
        //이게 Adapter생성자의 변수로 들어가고 후에 클릭리스너가 붙는다.
        OnRecipeSelectedInterface listener = (OnRecipeSelectedInterface) getActivity();
        //우리는 view를 view holder에 붙이려고 하므로 viewgroup에 붙이는것은 false설정한다.
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRecyclerVeiw);
        ListAdapter listAdapter = new ListAdapter(listener);
        //recycler view에 adapter를 붙여준다
        recyclerView.setAdapter(listAdapter);
        /*LinearLayoutManager생성자에 Context형 변수를 넣어야 하지만 getContext()는
         API23부터 가능하기에 minSDK가 19인 이 앱에는 getActivity()가 최선이다.
         */
        //list가 어떤 유형으로 보여질지 설정한다.(Linear)
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }
}
