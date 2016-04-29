package com.example.song.smellslikebakin;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListFragment.OnRecipeSelectedInterface {
    public static final String LIST_FRAGMENT = "list_fragment";
    public static final String VEIWPAGER_FRAGMENT = "viewpager_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TAG로 객체를 찾아서 list_fragment를 반환한다.
        ListFragment savedFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag(LIST_FRAGMENT);
        /*
        화면을 회전시킬 때에도 onCreate()가 다시 호출되므로 그때에는 Fragment를 다시
        만들지 않아야 한다.(if statement)
         */
        if(savedFragment == null) {

            //리스트 프레그먼트를 만들자
            ListFragment fragment = new ListFragment();
        /*    프래그먼트관리자는 프래그를 이동시키는것을 중계한다.
            getSupportFragmentManager()는 static으로 Activity Class에서 호출된다.
            하지만 FragmentController Class 에서 정의되었다.
            그 이상은 내부API로 감추어져있다.*/
        /*
        FragmentController의 목적
        Provides integration points with a FragmentManager for a fragment host.
        It is the responsibility of the host to take care of the Fragment's lifecycle.
        The methods provided by FragmentController are for that purpose.
         */
            FragmentManager fragmentManager = getSupportFragmentManager();
            //fragment이동은 이것이 맡는다.
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //Add a fragment to the activity state. This fragment may optionally also have its view (if Fragment.onCreateView returns non-null) inserted into a container view of the activity.
            fragmentTransaction.add(R.id.placeHolder, fragment, LIST_FRAGMENT);
            //commit하기 전에는 이동하지 않는다.
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onListRecipeSelected(int index) {
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        ViewPagerFragment fragment = new ViewPagerFragment();
        fragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeHolder, fragment, VEIWPAGER_FRAGMENT);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
