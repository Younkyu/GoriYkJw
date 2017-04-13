package goriproject.ykjw.com.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import goriproject.ykjw.com.myapplication.domain.Results;


/**
 * A simple {@link Fragment} subclass.
 */
public class Second_ThreeFragment extends Fragment {
    private Talent talent;
    Results item;

    public Second_ThreeFragment() {
        // Required empty public constructor
    }
    public void setTalent(Talent talenta, Results item) {
        // Required empty public constructor
        talent = talenta;
        this.item = item;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_three, container, false);
    }

}
