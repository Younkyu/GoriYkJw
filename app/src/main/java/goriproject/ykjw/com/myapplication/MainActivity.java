package goriproject.ykjw.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tsengvn.typekit.TypekitContextWrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import goriproject.ykjw.com.myapplication.domain.Main_list_item;

import static goriproject.ykjw.com.myapplication.Statics.datas;
import static goriproject.ykjw.com.myapplication.Statics.useremail;
import static goriproject.ykjw.com.myapplication.Statics.userid;
import static goriproject.ykjw.com.myapplication.Statics.username;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher, NavigationView.OnNavigationItemSelectedListener {

    int location_menu_count = 0;
    int category_menu_count = 0;
    ImageButton img,img2;
    ImageView mainimg;
    static List<Main_list_item> datas2 = new ArrayList<>();
    static MainListAdapter rca;
    EditText editText;
    RecyclerView rv;
    ConstraintLayout location_menu, category_menu;
    Button btn_location_all, btn_campus_all, btn_campus_korea, btn_campus_yeonse,btn_campus_seoul,btn_campus_hongik,
            btn_location_jamsil,btn_location_sadang,btn_location_sinchon,btn_location_gangnam;
    Button btn_category_all, btn_campus_kunkuk, btn_campus_busan,btn_campus_ihwa,btn_campus_hanyang,
            btn_campus_jungang, btn_location_jongro,btn_location_habjung,btn_location_yongsan,btn_location_hehwa, btn_location_mokdong;
    Button btn_category_music, btn_category_helth,btn_category_other,btn_campus_other,btn_location_other,btn_category_language,
            btn_category_cumputer, btn_category_sports, btn_category_major;
    TextView tv_location, tv_category;

    DrawerLayout drawer;
    NavigationView navigationView;

    @Override
    protected void onResume() {
        super.onResume();

        if(datas2.size() == 0) {
            TutorLoader.loadData();
            sortTop(datas);
            //Toast.makeText(this, TutorLoader.datasRealy.size(), Toast.LENGTH_SHORT).show();

        }
        if(TalentLoader.talent_datas.size() ==0) {
            TalentLoader.loadData();
        }

        rca.notifyDataSetChanged();

        if(userid != null) {
            navigationView = (NavigationView) findViewById(R.id.nav_view);
            // get menu from navigationView
            Menu menu = navigationView.getMenu();
            // find MenuItem you want to change
            MenuItem logoutitem = menu.findItem(R.id.menu_signinout);
            logoutitem.setTitle(R.string.logoutitem);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView  = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        location_menu = (ConstraintLayout)findViewById(R.id.location_menu);
        category_menu = (ConstraintLayout)findViewById(R.id.category_menu);
        editText = (EditText)findViewById(R.id.editText);
        tv_location = (TextView)findViewById(R.id.tv_location);
        tv_category = (TextView)findViewById(R.id.tv_category);

        editText.addTextChangedListener(this);

        //1. recycler 뷰 가져오기
        rv = (RecyclerView) findViewById(R.id.rv);

        //2. 아답터생성하기
        rca = new MainListAdapter(datas2, R.layout.main_list_item,this);

        //3. 리사이클러 뷰에 아답터 세팅하기
        rv.setAdapter(rca);

        //4. 리사이클러 뷰 매니저 등록하기(뷰의 모양을 결정 : 그리드, 일반리스트, 비대칭그리드)
        rv.setLayoutManager(new LinearLayoutManager(this));

        img = (ImageButton) findViewById(R.id.imageButton);
        img2 = (ImageButton) findViewById(R.id.imageButton2);
        mainimg = (ImageView)findViewById(R.id.mainImage);

        Glide.with(this).load(R.drawable.main_img).thumbnail(0.1f).into(mainimg);

        button_connect();

    }

    public void button_connect() {
        btn_location_all = (Button)findViewById(R.id.btn_location_all);
        btn_campus_all = (Button)findViewById(R.id.btn_campus_all);
        btn_campus_seoul = (Button)findViewById(R.id.btn_campus_seoul);
        btn_campus_korea = (Button)findViewById(R.id.btn_campus_korea);
        btn_campus_yeonse = (Button)findViewById(R.id.btn_campus_yeonse);
        btn_campus_hongik = (Button)findViewById(R.id.btn_campus_hongik);
        btn_campus_kunkuk = (Button)findViewById(R.id.btn_campus_kunkuk);
        btn_campus_busan = (Button)findViewById(R.id.btn_campus_busan);
        btn_campus_ihwa = (Button)findViewById(R.id.btn_campus_ihwa);
        btn_campus_jungang = (Button)findViewById(R.id.btn_campus_jungang);
        btn_campus_hanyang = (Button)findViewById(R.id.btn_campus_hanyang);
        btn_campus_other = (Button)findViewById(R.id.btn_campus_others);

        btn_location_gangnam = (Button)findViewById(R.id.btn_location_gangnam);
        btn_location_sadang = (Button)findViewById(R.id.btn_location_sadang);
        btn_location_sinchon = (Button)findViewById(R.id.btn_location_sinchon);
        btn_location_jamsil = (Button)findViewById(R.id.btn_location_jamsil);
        btn_location_jongro = (Button)findViewById(R.id.btn_location_jongro);
        btn_location_habjung = (Button)findViewById(R.id.btn_location_hapjung);
        btn_location_hehwa = (Button)findViewById(R.id.btn_location_hehwa);
        btn_location_yongsan = (Button)findViewById(R.id.btn_location_youngsan);
        btn_location_mokdong = (Button)findViewById(R.id.btn_location_mokdong);
        btn_location_other = (Button)findViewById(R.id.btn_location_other);

        btn_category_all = (Button)findViewById(R.id.btn_category_all);
        btn_category_major = (Button)findViewById(R.id.btn_category_major);
        btn_category_music = (Button)findViewById(R.id.btn_category_music);
        btn_category_cumputer = (Button)findViewById(R.id.btn_category_computer);
        btn_category_language = (Button)findViewById(R.id.btn_category_language);
        btn_category_sports = (Button)findViewById(R.id.btn_category_sports);
        btn_category_helth = (Button)findViewById(R.id.btn_category_helth);
        btn_category_other = (Button)findViewById(R.id.btn_category_other);


        btn_location_all.setOnClickListener(this);
        btn_campus_all.setOnClickListener(this);
        btn_campus_seoul.setOnClickListener(this);
        btn_campus_korea.setOnClickListener(this);
        btn_campus_yeonse.setOnClickListener(this);
        btn_campus_hongik.setOnClickListener(this);
        btn_campus_kunkuk.setOnClickListener(this);
        btn_campus_busan.setOnClickListener(this);
        btn_campus_ihwa.setOnClickListener(this);
        btn_campus_jungang.setOnClickListener(this);
        btn_campus_hanyang.setOnClickListener(this);
        btn_campus_other.setOnClickListener(this);

        btn_location_gangnam.setOnClickListener(this);
        btn_location_sadang.setOnClickListener(this);
        btn_location_sinchon.setOnClickListener(this);
        btn_location_jamsil.setOnClickListener(this);
        btn_location_jongro.setOnClickListener(this);
        btn_location_habjung.setOnClickListener(this);
        btn_location_hehwa.setOnClickListener(this);
        btn_location_yongsan.setOnClickListener(this);
        btn_location_mokdong.setOnClickListener(this);
        btn_location_other.setOnClickListener(this);

        btn_category_all.setOnClickListener(this);
        btn_category_major.setOnClickListener(this);
        btn_category_music.setOnClickListener(this);
        btn_category_cumputer.setOnClickListener(this);
        btn_category_language.setOnClickListener(this);
        btn_category_sports.setOnClickListener(this);
        btn_category_helth.setOnClickListener(this);
        btn_category_other.setOnClickListener(this);

    }


    public void location_click(View view) {

        if(category_menu_count%2 == 1) {
            category_click(view);
        }

        if(location_menu_count%2 == 0) {
            // 이동 애니메이션
            Animation animation = new TranslateAnimation(0,0,-100,0);
            // 나타났다 사라짐 애니메이션
            Animation animation1 = new AlphaAnimation(0,1);
            //속도조절
            animation.setDuration(300);
            animation1.setDuration(300);
            location_menu.setAnimation(animation);
            location_menu.setAnimation(animation1);
            location_menu.setVisibility(view.VISIBLE);
            img.setImageResource(R.drawable.arrow_down_select);
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            location_menu_count++;
        } else {
            location_menu.setVisibility(view.GONE);
            img.setImageResource(R.drawable.arrow_down);
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            location_menu_count++;
        }
    }


    public void category_click(View view) {

        if(location_menu_count%2 == 1) {
            location_click(view);
        }

        if (category_menu_count % 2 == 0) {
            // 이동 애니메이션
            Animation animation = new TranslateAnimation(0, 0, -100, 0);
            // 나타났다 사라짐 애니메이션
            Animation animation1 = new AlphaAnimation(0, 1);
            //속도조절
            animation.setDuration(300);
            animation1.setDuration(300);
            category_menu.setAnimation(animation);
            category_menu.setAnimation(animation1);
            category_menu.setVisibility(view.VISIBLE);
            img2.setImageResource(R.drawable.arrow_down_select);
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            category_menu_count++;
        } else {
            category_menu.setVisibility(view.GONE);
            img2.setImageResource(R.drawable.arrow_down);
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            category_menu_count++;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_Sign_inout) {
            drawer.openDrawer(GravityCompat.END);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View v) {
        String keword = "";

        switch (v.getId()) {
            case R.id.btn_campus_all :
                keword = "";
                location_search(keword);
                break;
            case R.id.btn_campus_seoul :
                keword = "서울대";
                location_search(keword);
                break;
            case R.id.btn_campus_hongik :
                keword = "홍익대";
                location_search(keword);
                break;
            case R.id.btn_campus_yeonse :
                keword = "연세대";
                location_search(keword);
                break;
            case R.id.btn_campus_korea :
                keword = "고려대";
                location_search(keword);
                break;
            case R.id.btn_campus_hanyang :
                keword = "한양대";
                location_search(keword);
                break;
            case R.id.btn_campus_jungang :
                keword = "중앙대";
                location_search(keword);
                break;
            case R.id.btn_campus_ihwa :
                keword = "이화여대";
                location_search(keword);
                break;
            case R.id.btn_campus_kunkuk :
                keword = "건국대";
                location_search(keword);
                break;
            case R.id.btn_campus_busan :
                keword = "부산대";
                location_search(keword);
                break;
            case R.id.btn_campus_others :
                keword = "학교기타";
                location_search(keword);
                break;
            case R.id.btn_location_all :
                keword = "";
                location_search(keword);
                break;
            case R.id.btn_location_jamsil :
                keword = "잠실";
                location_search(keword);
                break;
            case R.id.btn_location_gangnam :
                keword = "강남";
                location_search(keword);
                break;
            case R.id.btn_location_sinchon :
                keword = "신촌";
                location_search(keword);
                break;
            case R.id.btn_location_hehwa :
                keword = "혜화";
                location_search(keword);
                break;
            case R.id.btn_location_hapjung :
                keword = "합정";
                location_search(keword);
                break;
            case R.id.btn_location_youngsan :
                keword = "용산";
                location_search(keword);
                break;
            case R.id.btn_location_jongro :
                keword = "종로";
                location_search(keword);
                break;
            case R.id.btn_location_mokdong :
                keword = "목동";
                location_search(keword);
                break;
            case R.id.btn_location_sadang :
                keword = "사당";
                location_search(keword);
                break;
            case R.id.btn_location_other :
                keword = "지역기타";
                location_search(keword);
                break;
            case R.id.btn_category_all :
                keword = "";
                category_search(keword);
                break;
            case R.id.btn_category_music :
                keword = "음악/미술";
                category_search(keword);
                break;
            case R.id.btn_category_major :
                keword = "전공/취업";
                category_search(keword);
                break;
            case R.id.btn_category_sports :
                keword = "스포츠";
                category_search(keword);
                break;
            case R.id.btn_category_language :
                keword = "외국어";
                category_search(keword);
                break;
            case R.id.btn_category_computer :
                keword = "컴퓨터";
                category_search(keword);
                break;
            case R.id.btn_category_helth :
                keword = "헬스/뷰티";
                category_search(keword);
                break;
            case R.id.btn_category_other :
                keword = "카테고리기타";
                category_search(keword);
                break;
        }
    }



    public void location_search(String keword) {
        datas2.clear();
        String location,category;
        location = keword;

        if(!tv_category.getText().toString().equals("전체 카테고리")) {
            category = tv_category.getText().toString();
        }else {
            category = "";
        }

        for (Main_list_item item : datas) {
                for(String tt : item.getRegions()) {
                    if(tt.contains(location)) {
                        if(item.getCategory().contains(category)) {
                            datas2.add(item);
                            break;
                        }
                    }
                }
            }

        if(datas2.size() == 0) {
            Toast.makeText(MainActivity.this, "아직 조건에 맞는 클래스가 없습니다.", Toast.LENGTH_LONG).show();
            location_menu.setVisibility(View.GONE);
            category_menu.setVisibility(View.GONE);
            img.setImageResource(R.drawable.arrow_down);
            location_menu_count++;
            datas2.addAll(datas);
        } else {
            Toast.makeText(MainActivity.this, "조건에 맞는 강의는 " + datas2.size() +"개입니다.", Toast.LENGTH_LONG).show();
            location_menu.setVisibility(View.GONE);
            category_menu.setVisibility(View.GONE);
            if(keword.equals("")) {
                tv_location.setText("전체 지역");
            }else {
                tv_location.setText(keword);
            }
            img.setImageResource(R.drawable.arrow_down);
            location_menu_count++;
        }
        rca.notifyDataSetChanged();
    }

    public void category_search(String keword) {
        datas2.clear();

        String location,category;

        if(!tv_location.getText().toString().equals("전체 지역")) {
            location = tv_location.getText().toString();
        }else {
            location = "";
        }

        category = keword;

        for (Main_list_item item : datas) {
                for(String tt : item.getRegions()) {
                    if(tt.contains(location)) {
                        if(item.getCategory().contains(category)) {
                                datas2.add(item);
                        }
                    }
                }
            }

        if(datas2.size() == 0) {
            Toast.makeText(MainActivity.this, "아직 조건에 맞는 클래스가 없습니다.", Toast.LENGTH_LONG).show();
            location_menu.setVisibility(View.GONE);
            category_menu.setVisibility(View.GONE);
            img2.setImageResource(R.drawable.arrow_down);
            category_menu_count++;
            datas2.addAll(datas);
        } else {
            Toast.makeText(MainActivity.this, "조건에 맞는 강의는 " + datas2.size() +"개입니다.", Toast.LENGTH_LONG).show();
            location_menu.setVisibility(View.GONE);
            category_menu.setVisibility(View.GONE);
            if(keword.equals("")) {
                tv_category.setText("전체 카테고리");
            }else {
                tv_category.setText(keword);
            }
            img2.setImageResource(R.drawable.arrow_down);
            category_menu_count++;
        }
        rca.notifyDataSetChanged();
    }


    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String searchText = editText.getText().toString();
        text_search(searchText);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    public void text_search(String searchText) {
        datas2.clear();

        String location,category;

        if(!tv_location.getText().toString().equals("전체 지역")) {
            location = tv_location.getText().toString();
        }else {
            location = "";
        }

        if(!tv_category.getText().toString().equals("전체 카테고리")) {
            category = tv_category.getText().toString();
        }else {
            category = "";
        }

        if (searchText.length() == 0) {
            datas2.addAll(datas);
        } else {
            for (Main_list_item item : datas) {
                for(String tt : item.getRegions()) {
                    if(tt.contains(location)) {
                        if(item.getCategory().contains(category)) {
                            if (item.getTitle().contains(searchText)) {
                                datas2.add(item);
                            } else if (item.getTutor().getName().contains(searchText)) {
                                datas2.add(item);
                            }
                        }
                    }
                }
            }
        }
        rca.notifyDataSetChanged();
    }


    // 여기는 소트 부분인데 지금은 나중에 rating이 들어오면 수정할 예정
    // 단순한 String,int리스트가 아닌 객체에 대한 정렬을 해야할 경우에 사용
    public void sortTop(List<Main_list_item> datas2) {
        Collections.sort(datas2, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //사용하려는 객체로 파싱해줌
                Main_list_item no1 = (Main_list_item)o1;
                Main_list_item no2 = (Main_list_item)o2;

                //-1과 1의 위치를 조정하면 오름차순/내림차순을 조절할 수 있다.
                if(Integer.parseInt(no1.getAverage_rate().trim()) >Integer.parseInt(no2.getAverage_rate().trim())) {
                    return -1;
                } else if (Integer.parseInt(no1.getAverage_rate().trim()) == Integer.parseInt(no2.getAverage_rate().trim())){
                    return 0;
                } else {
                    return 1;
                }
            }
        });
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();
        Intent intent;
        if (id == R.id.menu_introduce_gori) {
            intent= new Intent(MainActivity.this, IntroduceGoriActivity.class);
            startActivity(intent);
            //TODO 고리소개 페이지로드
        } else if (id == R.id.menu_signinout) {
            if(userid != null) {
                userid = null;
                username = null;
                useremail = null;
                item.setTitle("로그인");
                Toast.makeText(MainActivity.this, "정상적으로 로그아웃 되었습니다.", Toast.LENGTH_SHORT).show();
            }else {
                intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
            }

        } else if (id == R.id.menu_mypage) {
            //TODO 마이페이지 고
        } else if (id == R.id.menu_tutor_go) {
            // 아직 구현할 생각 없음
            Toast.makeText(MainActivity.this, "튜터등록은 웹사이트에서 해주세요!", Toast.LENGTH_LONG).show();
        }

        drawer.closeDrawer(GravityCompat.END);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(TypekitContextWrapper.wrap(newBase));
    }

    public static void rcanoti() {
        rca.notifyDataSetChanged();
    }
}

