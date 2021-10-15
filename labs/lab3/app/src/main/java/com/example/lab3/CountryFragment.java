package com.example.lab3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CountryFragment extends Fragment {

    private int pageNumber;
    private Country[] Countries = new Country[] {
        new Country(R.drawable.usa, R.string.UsaText),
        new Country(R.drawable.england, R.string.EnglandText),
        new Country(R.drawable.italy, R.string.ItalyText)
    };

    public static CountryFragment newInstance(int page) {
        CountryFragment fragment = new CountryFragment();
        Bundle args = new Bundle();
        args.putInt("page", page);
        fragment.setArguments(args);
        return fragment;
    }

    public CountryFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments() != null ? getArguments().getInt("page") : 1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Country country = Countries[pageNumber];

        View result = inflater.inflate(R.layout.fragment_country, container, false);
        TextView info = (TextView) result.findViewById(R.id.Info);
        ImageView image = (ImageView) result.findViewById(R.id.Image);
        TextView pageNum = (TextView) result.findViewById(R.id.PageNum);

        info.setText(country.TextRef);
        image.setImageResource(country.ImageSrc);
        pageNum.setText(Integer.toString(pageNumber + 1));
        return result;
    }
}