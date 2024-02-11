package com.example.stayswift;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference views inside the included layouts
        View hotelInfoLayout = findViewById(R.id.hotelInfoLayout);
        TextView hotelNameTextView = hotelInfoLayout.findViewById(R.id.hotelNameTextView);

        View roomAvailabilityLayout = findViewById(R.id.roomAvailabilityLayout);
        TextView availabilityTextView = roomAvailabilityLayout.findViewById(R.id.availabilityTextView);

        View roomPricesLayout = findViewById(R.id.roomPricesLayout);
        TextView priceTextView = roomPricesLayout.findViewById(R.id.priceTextView);

        View additionalServicesLayout = findViewById(R.id.additionalServicesLayout);

        // Example: Set text for the hotel name TextView
        hotelNameTextView.setText("Example Hotel");

        // Example: Set text for the availability TextView
        availabilityTextView.setText("Available");

        // Example: Set text for the price TextView
        priceTextView.setText("$100 per night");

    }
}
