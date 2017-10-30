package com.example.bryon.wishbonecaninerescue;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bryon.wishbonecaninerescue.model.Dog;
import com.example.bryon.wishbonecaninerescue.model.JsonResponse;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class DogFragment extends Fragment {

    private String TAG = this.getClass().getSimpleName();

    private OkHttpClient client = new OkHttpClient();
    public JsonResponse jsonResponse;
    private Gson gson = new Gson();
    public ArrayList<Dog> dogs;
    public AdapterView.OnItemClickListener dogClickListener;
    public Intent detailIntent;

    // to save listview state, declare here
//    public Parcelable dogListViewState;
    public ListView dogListView;
    public DogListAdapter dogListAdapter;

    public static DogFragment newInstance() {
        DogFragment fragment = new DogFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setRetainInstance(true);
        // use activity context
        new DogFetchTask(getActivity()).execute();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dog, container, false);
    }


    private class DogFetchTask extends AsyncTask<String, Void, JsonResponse> {

        private Context mContext;
        public DogFetchTask (Context context) {
            mContext = context;
        }
        @Override
        protected JsonResponse doInBackground(String... params) {
            String url = "https://wishbonecr.herokuapp.com/";
            Request request = new Request.Builder().url(url).build();
            try {
                Response response = client.newCall(request).execute();
                jsonResponse = gson.fromJson(response.body().charStream(), JsonResponse.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return jsonResponse;
        }

        protected void onPostExecute(JsonResponse jsonResponse) {
            dogs = Dog.dogMaker(jsonResponse);
            dogListAdapter = new DogListAdapter(mContext, dogs);
            // fragment view inflated in onCreateView - use getActivity().findViewById(int)
            dogListView = getActivity().findViewById(R.id.dog_card_list_view);
            dogListView.setAdapter(dogListAdapter);

        }
    }
}
