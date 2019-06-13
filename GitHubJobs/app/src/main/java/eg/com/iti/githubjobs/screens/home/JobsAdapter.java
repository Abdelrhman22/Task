package eg.com.iti.githubjobs.screens.home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import eg.com.iti.githubjobs.R;

public class JobsAdapter extends RecyclerView.Adapter<JobsAdapter.ViewHolder>  implements View.OnClickListener{

    ArrayList<JobPojo> arrayList;
    Context context;
    MainActivity mainActivity;

    JobPojo pojo=new JobPojo();

    public JobsAdapter(ArrayList<JobPojo> arrayList, Context context, MainActivity mainActivity)
    {
        this.arrayList=arrayList;
        this.context=context;
        this.mainActivity=mainActivity;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.layout_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        pojo=arrayList.get(position);
        viewHolder.bindItem(pojo);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View v) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        ImageView imagviewJob;
        TextView txtJobTitle,txtCompanyName,txtDate;
        Button btnFavourite;


        public ViewHolder(View itemView) {
            super(itemView);
            imagviewJob=itemView.findViewById(R.id.imagviewJob);
            txtJobTitle=itemView.findViewById(R.id.txtJobTitle);
            txtCompanyName=itemView.findViewById(R.id.txtCompanyName);
            txtDate=itemView.findViewById(R.id.txtDate);
            btnFavourite=itemView.findViewById(R.id.btnFavourite);
        }
        public void bindItem(JobPojo item)
        {
            Picasso.get().load(item.getCompany_logo()).into(imagviewJob);
            txtJobTitle.setText(item.getTitle());
            txtCompanyName.setText(item.getCompany());
            txtDate.setText(item.getCreated_at());
        }
        @Override
        public void onClick(View v) {

        }
    }
}
