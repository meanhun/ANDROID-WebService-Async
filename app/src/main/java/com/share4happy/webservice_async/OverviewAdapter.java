package com.share4happy.webservice_async;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.share4happy.webservice_async.model.OverviewInfo;
import java.util.List;

public class OverviewAdapter extends ArrayAdapter<OverviewInfo> {
    Activity context;
    int resource;
    List<OverviewInfo> overviewInfos;
    public OverviewAdapter(Activity context, int resource,List<OverviewInfo>overviewInfos)
    {
        super(context,resource,overviewInfos);
        this.context=context;
        this.resource=resource;
        this.overviewInfos=overviewInfos;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(this.resource,null);
        TextView overviewDate=row.findViewById(R.id.overviewDate);
        TextView overviewDeath=row.findViewById(R.id.overviewDeath);
        TextView overviewTreating=row.findViewById(R.id.overviewTreating);
        TextView overviewCases=row.findViewById(R.id.overviewCases);
        TextView overviewDateRecovered=row.findViewById(R.id.overviewDateRecovered);

        OverviewInfo overviewInfo=overviewInfos.get(position);

        overviewDate.setText(" "+overviewInfo.getDate());
        overviewDeath.setText(" "+overviewInfo.getDeath());
        overviewTreating.setText(" "+overviewInfo.getTreating());
        overviewCases.setText(" "+overviewInfo.getCases());
        overviewDateRecovered.setText(" "+overviewInfo.getRecovered());

        return row;
    }
}
