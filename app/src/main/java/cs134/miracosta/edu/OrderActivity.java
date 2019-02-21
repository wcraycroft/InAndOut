package cs134.miracosta.edu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

import cs134.miracosta.edu.Model.Order;

/**
 * This is the controller class for the Order Activity. This activity allows the user to enter
 * a whole number of various menu items. When the placeOrderButton is pressed, the data will be sent
 * to the model, and the calculated totals will be sent to the Summary Activity via Intent.
 */
public class OrderActivity extends AppCompatActivity {

    // Declarations
    // View declarations
    /** EditText which receives user input for number of Double Doubles*/
    private EditText doubleEditText;
    /** EditText which receives user input for number of Cheeseburgers*/
    private EditText cheeseburgerEditText;
    /** EditText which receives user input for number of French Fries*/
    private EditText friesEditText;
    /** EditText which receives user input for number of Shakes*/
    private EditText shakesEditText;
    /** EditText which receives user input for number of Small Drinks*/
    private EditText smallEditText;
    /** EditText which receives user input for number of Medium Drinks*/
    private EditText mediumEditText;
    /** EditText which receives user input for number of Large Drinks*/
    private EditText largeEditText;

    // Model declaration
    /** Reference to the Order class used to calculate subtotal, tax and total.*/
    private Order thisOrder;
    // Formatter instantiation
    /** Instances of NumberFormat class used for currency and percentages*/
    NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.getDefault());
    NumberFormat percentage = NumberFormat.getPercentInstance(Locale.getDefault());

    /**
     * Called when Activity is created. Handles the linking of View objects to controller and
     * instantiates the model.
     * @param savedInstanceState Bundle data saved from past state of the Activity (not used).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Link controlled variables to View
        doubleEditText = findViewById(R.id.doubleEditText);
        cheeseburgerEditText = findViewById(R.id.cheeseburgerEditText);
        friesEditText = findViewById(R.id.friesEditText);
        shakesEditText = findViewById(R.id.shakesEditText);
        smallEditText = findViewById(R.id.smallEditText);
        mediumEditText = findViewById(R.id.mediumEditText);
        largeEditText = findViewById(R.id.largeEditText);

        // Instantiate Order to default values (0)
        thisOrder = new Order();
    }

    /**
     * This method is linked to the onClick of placeOrderButton. It will update the model, then
     * send the calculated data to a new Summary Activity via Intent.
     * @param v The View calling this method (placeOrderButton).
     */
    public void switchToSummaryActivity(View v) {

        // Send data from EditTexts to model
        // If EditText is empty, set item number to 0 (in case field was used in previous order)
        if (!doubleEditText.getText().toString().equals("")) {
            thisOrder.setDoubleDoubles(Integer.parseInt(doubleEditText.getText().toString()));
        } else {
            thisOrder.setDoubleDoubles(0);
        }
        if (!cheeseburgerEditText.getText().toString().equals("")) {
            thisOrder.setCheeseburgers(Integer.parseInt(cheeseburgerEditText.getText().toString()));
        }else {
            thisOrder.setCheeseburgers(0);
        }
        if (!friesEditText.getText().toString().equals("")) {
            thisOrder.setFrenchFries(Integer.parseInt(friesEditText.getText().toString()));
        }else {
            thisOrder.setFrenchFries(0);
        }
        if (!shakesEditText.getText().toString().equals("")) {
            thisOrder.setShakes(Integer.parseInt(shakesEditText.getText().toString()));
        }else {
            thisOrder.setShakes(0);
        }
        if (!smallEditText.getText().toString().equals("")) {
            thisOrder.setSmallDrinks(Integer.parseInt(smallEditText.getText().toString()));
        }else {
            thisOrder.setSmallDrinks(0);
        }
        if (!mediumEditText.getText().toString().equals("")) {
            thisOrder.setMediumDrinks(Integer.parseInt(mediumEditText.getText().toString()));
        }else {
            thisOrder.setMediumDrinks(0);
        }
        if (!largeEditText.getText().toString().equals("")) {
            thisOrder.setLargeDrinks(Integer.parseInt(largeEditText.getText().toString()));
        }else {
            thisOrder.setLargeDrinks(0);
        }

        // Send calculated data from model to Summary Activity Intent
        Intent summaryIntent = new Intent(this, SummaryActivity.class);
        summaryIntent.putExtra("Subtotal", currency.format(thisOrder.calculateSubtotal()));
        summaryIntent.putExtra("TaxAmount", currency.format(thisOrder.calculateTax()));
        summaryIntent.putExtra("Total", currency.format(thisOrder.calculateTotal()));
        summaryIntent.putExtra("NumberOfItems", Integer.toString(thisOrder.getNumberItemsOrdered()));
        summaryIntent.putExtra("TaxRate", percentage.format(Order.TAX_RATE));

        // Start Summary Activity
        if (thisOrder.getNumberItemsOrdered() > 0) {
            startActivity(summaryIntent);
        } else {
            Toast.makeText(this, getString(R.string.no_items_toast), Toast.LENGTH_LONG).show();
        }



    }
}
