package com.example.stayswift;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare variables for views
    private EditText searchEditText;
    private LinearLayout filterOptionsLayout;
    private LinearLayout hotelListingsLayout;
    private Spinner sortingSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        searchEditText = findViewById(R.id.searchEditText);
        filterOptionsLayout = findViewById(R.id.filterOptionsLayout);
        hotelListingsLayout = findViewById(R.id.hotelListingsLayout);
        sortingSpinner = findViewById(R.id.sortingSpinner);

        // Set up sorting options in the spinner
        ArrayAdapter<CharSequence> sortingAdapter = ArrayAdapter.createFromResource(this,
                R.array.sorting_options, android.R.layout.simple_spinner_item);
        sortingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sortingSpinner.setAdapter(sortingAdapter);

        // Set listener for sorting spinner
        sortingSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Handle sorting option selection
                String selectedOption = parent.getItemAtPosition(position).toString();
                // Perform sorting logic
                // Update UI with sorted hotel listings
                Toast.makeText(MainActivity.this, "Sorting by: " + selectedOption, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        // Set listener for search EditText
        searchEditText.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == android.view.KeyEvent.ACTION_DOWN) &&
                    (keyCode == android.view.KeyEvent.KEYCODE_ENTER)) {
                // Handle search when Enter key is pressed
                String query = searchEditText.getText().toString();
                handleSearch(query);
                return true;
            }
            return false;
        });
    }

    // Method to handle search functionality
    private void handleSearch(String query) {
        // Perform search logic
        if (query != null && !query.isEmpty()) {
            // Show toast with search query
            Toast.makeText(this, "Searching for: " + query, Toast.LENGTH_SHORT).show();
            // Here, you can implement further logic such as querying a backend server or filtering local data
            // For demonstration purposes, let's assume we just update the UI with the search query
            updateUIWithSearchResults(query);
        } else {
            // Show toast indicating empty search query
            Toast.makeText(this, "Please enter a search query", Toast.LENGTH_SHORT).show();
        }
    }

    // Method to update UI with search results
    private void updateUIWithSearchResults(String query) {
        // Example: Update the searchEditText with the search query
        searchEditText.setText(query);
        // Example: Populate hotel listings based on the search query
        // You can call a method here to fetch hotel data and display it in hotelListingsLayout
        populateHotelListingsWithSearchResults(query);
    }

    // Method to populate hotel listings based on search query
    private void populateHotelListingsWithSearchResults(String query) {
        // Example: Fetch hotel data from backend or local database based on the search query
        // Then, update hotelListingsLayout with the retrieved data
    }
}
