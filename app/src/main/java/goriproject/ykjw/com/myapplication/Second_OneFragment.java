package goriproject.ykjw.com.myapplication;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 */
public class Second_OneFragment extends Fragment {

    LinearLayout ll_one_curiculum;
    View view;
    private Talent talent;

    public Second_OneFragment() {
        // Required empty public constructor
    }
    public void setTalent(Talent talenta) {
        // Required empty public constructor
        talent = talenta;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_second_one, container, false);

        ll_one_curiculum = (LinearLayout)view.findViewById(R.id.ll_one_curiculum);
        for(int i = 0 ; i < 5 ; i ++) {
            LinearLayout li_son = new LinearLayout(getContext());
            li_son.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams p2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            li_son.setLayoutParams(p2);

            LinearLayout li_son2 = new LinearLayout(getContext());
            li_son2.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams p4 = new LinearLayout.LayoutParams(40, ViewGroup.LayoutParams.MATCH_PARENT);
            li_son2.setLayoutParams(p4);

            ImageView iv = new ImageView(getContext());
            Glide.with(getContext()).load(R.drawable.dong2).into(iv);
            LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(40, 40);
            iv.setLayoutParams(p);
            ImageView iv2 = new ImageView(getContext());
            Glide.with(getContext()).load(R.drawable.aaa).into(iv2);
            LinearLayout.LayoutParams p5 = new LinearLayout.LayoutParams(40, ViewGroup.LayoutParams.MATCH_PARENT);
            iv2.setLayoutParams(p5);

            li_son2.addView(iv);
            li_son2.addView(iv2);

            LinearLayout li_son3 = new LinearLayout(getContext());
            li_son3.setOrientation(LinearLayout.VERTICAL);
            LinearLayout.LayoutParams p6 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            li_son3.setLayoutParams(p6);

            TextView tv_curi_hoicha = new TextView(getContext());
            LinearLayout.LayoutParams p9 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tv_curi_hoicha.setLayoutParams(p9);
            tv_curi_hoicha.setTextSize(20);
            tv_curi_hoicha.setPadding(30,0,0,15);
            tv_curi_hoicha.setTextColor(getResources().getColor(R.color.colorAccent));
            tv_curi_hoicha.setText(i+1 + "회차");

            TextView tv_curi = new TextView(getContext());
            tv_curi.setPadding(30,30,30,30);
            LinearLayout.LayoutParams p3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            tv_curi.setTextSize(15);
            tv_curi.setLayoutParams(p3);
            tv_curi.setText("결과물 발표\n" +
                    "\n" +
                    "커리큘럼은 언제든지 변경될 수 있습니다.\n" +
                    "수강생의 상황에 맞게 낭비되는 시간 없이 최적화 될 수 있도록 유연성 있게 구성하려고 합니다.\n");

            ImageView iv3 = new ImageView(getContext());
            Glide.with(getContext()).load(R.drawable.list_dummy).into(iv3);
            LinearLayout.LayoutParams p7 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            iv3.setLayoutParams(p7);

            li_son3.addView(tv_curi_hoicha);
            li_son3.addView(tv_curi);
            li_son3.addView(iv3);

            //li_son.addView(li_son2);
            li_son.addView(li_son3);

            ll_one_curiculum.addView(li_son);
        }

        return view;
    }

}
