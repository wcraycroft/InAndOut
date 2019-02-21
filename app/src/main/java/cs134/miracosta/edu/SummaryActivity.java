package cs134.miracosta.edu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * This is the controller class for the Summary Activity. This activity is sent order data from
 * the OrderActivity and displays this data to the user. If the startNewOrderButton is clicked,
 * this activity is destroyed.
 */
public class SummaryActivity extends AppCompatActivity {

    // Declarations
    // View declarations
    /** TextView which displays the order's total cost to the user.*/
    private TextView totalTextView;
    /** TextView which displays the order's subtotal to the user.*/
    private TextView subtotalTextView;
    /** TextView which displays the order's number of items to the user.*/
    private TextView itemsTextView;
    /** TextView which displays the order's tax cost to the user.*/
    private TextView taxTextView;

    /**
     * Called when Activity is created. Handles the linking of View objects to controller, receives
     * Intent data and sends it to appropriate View objects.
     * @param savedInstanceState Bundle data saved from past state of the Activity (not used).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        // Link views
        totalTextView = findViewById(R.id.totalTextView);
        subtotalTextView = findViewById(R.id.subtotalTextView);
        itemsTextView = findViewById(R.id.itemsTextView);
        taxTextView = findViewById(R.id.taxTextView);

        // Get Intent from OrderActivity, use data to populate TextViews
        Intent intent = getIntent();

        totalTextView.setText(getString(R.string.order_total, intent.getStringExtra("Total")));
        itemsTextView.setText(getString(R.string.items_ordered, intent.getStringExtra("NumberOfItems")));
        subtotalTextView.setText(getString(R.string.subtotal, intent.getStringExtra("Subtotal")));
        taxTextView.setText(getString(R.string.tax, intent.getStringExtra("TaxRate"),
               intent.getStringExtra("TaxAmount")));
    }

    /**
     * This method is linked to the onClick of startNewOrderButton. It will destroy the current
     * activity, resuming the SummaryActivity.
     * @param v The View calling this method (startNewOrderButton).
     */
    public void closeActivity(View v) {
        this.finish();
    }
}
