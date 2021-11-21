package com.share4happy.webservice_async;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import com.share4happy.webservice_async.model.Location;
import com.share4happy.webservice_async.model.ModelCommon;
import com.share4happy.webservice_async.model.OverviewInfo;
import com.share4happy.webservice_async.model.Today;
import com.share4happy.webservice_async.model.Total;
import com.share4happy.webservice_async.service.AsyncTaskService;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    TextView txtTotalInternaldeath,txtTotalInternaltreating,txtTotalInternalcases,txtTotalInternalrecovered;
    TextView txtTotalWorlddeath,txtTotalWorldtreating,txtTotalWorldcases,txtTotalWorldrecovered;
    TextView txtTodayInternaldeath,txtTodayInternaltreating,txtTodayInternalcases,txtTodayInternalrecovered;
    TextView txtTodayWorlddeath,txtTodayWorldtreating,txtTodayWorldcases,txtTodayWorldrecovered;

    ListView lsOverviews;
    ListView lsLocations;
    List<OverviewInfo> overviewInfoArrayList=new ArrayList<>();
    List<Location>locationList=new ArrayList<>();

    OverviewAdapter overviewAdapter;
    LocationAdapter locationAdapter;

    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        addEvents();
    }

    private void addControls() {
        txtTotalInternaldeath=findViewById(R.id.deathInternalTotal) ;
        txtTotalInternaltreating=findViewById(R.id.treatingInternalTotal) ;
        txtTotalInternalcases=findViewById(R.id.casesInternalTotal);
        txtTotalInternalrecovered=findViewById(R.id.recoveredInternalTotal);

        txtTotalWorlddeath=findViewById(R.id.deathWorldTotal);
        txtTotalWorldtreating=findViewById(R.id.treatingWorldTotal);
        txtTotalWorldcases=findViewById(R.id.casesWorldTotal);
        txtTotalWorldrecovered=findViewById(R.id.recoveredWorldTotal);

        txtTodayInternaldeath=findViewById(R.id.deathTodayInternal);
        txtTodayInternaltreating=findViewById(R.id.treatingTodayInternal);
        txtTodayInternalcases=findViewById(R.id.casesTodayInternal);
        txtTodayInternalrecovered=findViewById(R.id.recoveredTodayInternal);

        txtTodayWorlddeath=findViewById(R.id.deathTodayWorld);
        txtTodayWorldtreating=findViewById(R.id.treatingTodayWorld);
        txtTodayWorldcases=findViewById(R.id.casesTodayWorld);
        txtTodayWorldrecovered=findViewById(R.id.recoveredTodayWorld);

        lsOverviews=findViewById(R.id.lsoverview);
        lsLocations=findViewById(R.id.lslocations);

        tabHost=findViewById(R.id.tabHost);
        tabHost.setup();

        //Cài đặt cho Tab THEO TỈNH
        TabHost.TabSpec tabLocations = tabHost.newTabSpec("t1");
        tabLocations.setIndicator("Theo tỉnh");
        tabLocations.setContent(R.id.tabLocations);
        tabHost.addTab(tabLocations);

        //Cài đặt cho Tab Hôm nay
        TabHost.TabSpec tabToday = tabHost.newTabSpec("t2");
        tabToday.setIndicator("Hôm nay");
        tabToday.setContent(R.id.tabToday);
        tabHost.addTab(tabToday);

        //Cài đặt cho Tab Tổng quan
        TabHost.TabSpec tabOverview = tabHost.newTabSpec("t3");
        tabOverview.setIndicator("Tổng quan");
        tabOverview.setContent(R.id.tabOverview);
        tabHost.addTab(tabOverview);

        //Cài đặt cho Tab Tổng
        TabHost.TabSpec tabTotal = tabHost.newTabSpec("t4");
        tabTotal.setIndicator("Tổng");
        tabTotal.setContent(R.id.tabTotal);
        tabHost.addTab(tabTotal);
    }

    private void addEvents() {
        try {
            refreshData();
            runAsyncSer();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void refreshData() {
        txtTotalInternaldeath.setText("");
        txtTotalInternaltreating.setText("");
        txtTotalInternalcases.setText("");
        txtTotalInternalrecovered.setText("");

        txtTotalWorlddeath.setText("");
        txtTotalWorldtreating.setText("");
        txtTotalWorldcases.setText("");
        txtTotalWorldrecovered.setText("");

        txtTodayInternaldeath.setText("");
        txtTodayInternaltreating.setText("");
        txtTodayInternalcases.setText("");
        txtTodayInternalrecovered.setText("");

        txtTodayWorlddeath.setText("");
        txtTodayWorldtreating.setText("");
        txtTodayWorldcases.setText("");
        txtTodayWorldrecovered.setText("");

        overviewInfoArrayList=new ArrayList<>();
        lsOverviews.setAdapter(null);

        locationList=new ArrayList<>();
        lsLocations.setAdapter(null);
    }

    private void runAsyncSer() throws ExecutionException, InterruptedException {
        AsyncTaskService asyncTaskService=new AsyncTaskService();
        ModelCommon data;
        data=asyncTaskService.execute().get();

        Today today;
        today=data.getToday();
        Total total;
        total=data.getTotal();


        txtTotalInternaldeath.setText(String.valueOf(total.getInfoInternal().getDeath()));
        txtTotalInternaltreating.setText(String.valueOf(total.getInfoInternal().getTreating()));
        txtTotalInternalcases.setText(String.valueOf(total.getInfoInternal().getCases()));
        txtTotalInternalrecovered.setText(String.valueOf(total.getInfoInternal().getRecovered()));

        txtTotalWorlddeath.setText(String.valueOf(total.getInfoWorld().getDeath()));
        txtTotalWorldtreating.setText(String.valueOf(total.getInfoWorld().getTreating()));
        txtTotalWorldcases.setText(String.valueOf(total.getInfoWorld().getCases()));
        txtTotalWorldrecovered.setText(String.valueOf(total.getInfoWorld().getRecovered()));

        txtTodayInternaldeath.setText(String.valueOf(today.getInfoInternal().getDeath()));
        txtTodayInternaltreating.setText(String.valueOf(today.getInfoInternal().getTreating()));
        txtTodayInternalcases.setText(String.valueOf(today.getInfoInternal().getCases()));
        txtTodayInternalrecovered.setText(String.valueOf(today.getInfoInternal().getRecovered()));

        txtTodayWorlddeath.setText(String.valueOf(today.getInfoWorld().getDeath()));
        txtTodayWorldtreating.setText(String.valueOf(today.getInfoWorld().getTreating()));
        txtTodayWorldcases.setText(String.valueOf(today.getInfoWorld().getCases()));
        txtTodayWorldrecovered.setText(String.valueOf(today.getInfoWorld().getRecovered()));

        overviewInfoArrayList=data.getOverview();
        overviewAdapter=new OverviewAdapter(MainActivity.this,
                R.layout.item_overview,overviewInfoArrayList);
        lsOverviews.setAdapter(overviewAdapter);

        locationList=data.getLocations();
        locationAdapter=new LocationAdapter(MainActivity.this,
                R.layout.item_location,locationList);
        lsLocations.setAdapter(locationAdapter);

        Toast.makeText(MainActivity.this, "Đang load dữ liệu sử dụng Async Task",
                Toast.LENGTH_SHORT).show();
    }
}