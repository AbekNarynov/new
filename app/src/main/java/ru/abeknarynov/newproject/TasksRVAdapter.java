package ru.abeknarynov.newproject;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

public class TasksRVAdapter extends RecyclerView.Adapter<TasksRVAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Task item);
    }

    private List<Task> tasks;
    private TasksRVAdapter.OnItemClickListener listener;

    TasksRVAdapter(List<Task> tasks, TasksRVAdapter.OnItemClickListener listener){
        this.tasks = tasks;
        this.listener = listener;
    }

    @Override
    public TasksRVAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_view_task, viewGroup, false);
        return new TasksRVAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksRVAdapter.ViewHolder viewHolder, int position) {
        viewHolder.bind(tasks.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView userId, userName, userSurname, userMiddleName;
        ImageView userPhoto;

        ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.my_tasks_card_view);
            userName = itemView.findViewById(R.id.person_name);
            userSurname = itemView.findViewById(R.id.person_age);
//            userMiddleName = itemView.findViewById(R.id.userMiddleName);
//            userPhoto = itemView.findViewById(R.id.userPhoto);
        }

        void bind(final Task item, final TasksRVAdapter.OnItemClickListener listener) {
            userName.setText(item.name);
            userSurname.setText(item.age);
//            userMiddleName.setText(item.middleName);

//            if (item.image.equals("")) {
//                userPhoto.setImageResource(R.drawable.default_session);
//            } else {
//                TasksRVAdapter.DownloadImageWithURLTask downloadTask = new TasksRVAdapter.DownloadImageWithURLTask(userPhoto);
//                downloadTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, item.image);
//            }

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View view) {
                    listener.onItemClick(item);
                }
            });
        }
    }


//    // *** Загрузка изображения из интернета ***
//    private static class DownloadImageWithURLTask extends AsyncTask<String, Void, Bitmap> {
//        @SuppressLint("StaticFieldLeak")
//        ImageView bmp;
//        DownloadImageWithURLTask(ImageView bmImage) {
//            this.bmp = bmImage;
//        }
//        protected Bitmap doInBackground(String... urls) {
//            String pathToFile = urls[0];
//            Bitmap bitmap = null;
//            try {
//                InputStream in = new java.net.URL(pathToFile).openStream();
//                bitmap = BitmapFactory.decodeStream(in);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return bitmap;
//        }
//        protected void onPostExecute(Bitmap result) {
//            bmp.setImageBitmap(result);
//        }
//    }
}