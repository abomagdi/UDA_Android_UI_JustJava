/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

 package com.example.andriod.justjava;



         import android.content.Intent;
         import android.net.Uri;
         import android.os.Bundle;
         import android.support.v7.app.AppCompatActivity;
         import android.util.Log;
         import android.view.View;
         import android.widget.CheckBox;
         import android.widget.EditText;
         import android.widget.TextView;
         import java.text.NumberFormat;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity  = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = quantity * 5;
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean hasChocolate = chocolateCheckBox.isChecked();
        EditText name = (EditText) findViewById(R.id.name_field);
        String cusname = name.getText().toString();
        String options = "Add whipped cream: "+hasWhippedCream;
        String options2 = "Add chocolate: "+hasChocolate;
        String Qunatity = "Quantity: "+quantity;
        String message = "Total: $" + price;
        String message2 = "Thank you!";
        String princeMessage = "Free";
//        display(quantity);
//        displayPrice(quantity * 5);
//        Log.v("MainActivity", "Has Whipped Cream: "+hasWhippedCream);
        String displayMessageTotal = "Name: "+ cusname + "\n" + options + "\n" + options2 + "\n" + Qunatity + "\n" + message + "\n" + message2;
        displayMessage(displayMessageTotal);
//        Intent intent = new Intent(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse("geo:47.6, -122.3"));
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, "hello@world.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava Order for "+cusname);
        intent.putExtra(Intent.EXTRA_TEXT, displayMessageTotal);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    public void increment(View view) {
        quantity += 1;
        display(quantity);
        displayPrice(quantity * 5);
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    public void decrement(View view) {
        quantity -= 1;
        if(quantity < 0){
            quantity = 0;
        }
        display(quantity);
        displayPrice(quantity * 5);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        String message = "Total: ";
        String message2 = "Thank you!";
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}