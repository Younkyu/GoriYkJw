package goriproject.ykjw.com.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


public class Apply_1Fragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    Button btn_next2;

    LinearLayout btn1layout, btn2layout;

    ApplyActivity activity;

    public void setActivity(ApplyActivity activity){
        this.activity = activity;
    }


    public Apply_1Fragment() {

    }



    public static Apply_1Fragment newInstance(String param1, String param2) {
        Apply_1Fragment fragment = new Apply_1Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_apply_1, container, false);

        btn_next2 = (Button)view.findViewById(R.id.btn_next2);
        btn_next2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.goAp2();
            }
        });

        btn1layout = (LinearLayout)view.findViewById(R.id.li_apply1_btnlayout1);
        btn2layout = (LinearLayout)view.findViewById(R.id.li_apply1_btnlayout2);

        Button btn = new Button(getContext());
        btn.setText("신촌");
        btn.setWidth(70);
        btn.setHeight(30);
        btn.setBackgroundResource(R.drawable.custom_button);

        btn1layout.addView(btn);


        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }


}
