package com.share4happy.webservice_async;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.share4happy.webservice_async.model.Location;
import java.util.List;

public class LocationAdapter extends ArrayAdapter<Location> {
    Activity context;
    int resource;
    List<Location> locations;
    public LocationAdapter(Activity context, int resource,List<Location>locations)
    {
        super(context,resource,locations);
        this.context=context;
        this.resource=resource;
        this.locations=locations;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=this.context.getLayoutInflater();
        View row=inflater.inflate(this.resource,null);
        //Hiển thị một số trường chọn lọc
        TextView name=row.findViewById(R.id.name);
        TextView death=row.findViewById(R.id.death);
        TextView cases=row.findViewById(R.id.cases);
        TextView casesToday=row.findViewById(R.id.casesToday);

        Location location=locations.get(position);
        //Muốn hiển thị bao trường dữ liệu thì tùy bạn nhé
        name.setText(""+location.getName());
        death.setText(""+location.getDeath());
        cases.setText(""+location.getCases());
        casesToday.setText("+"+location.getCasesToday());
        return row;
    }
}
