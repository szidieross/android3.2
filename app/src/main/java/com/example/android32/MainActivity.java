package com.example.android32;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Product> productList = new ArrayList<>();
    private EditText code, name, price;
    private TextView productsTextView;
    private Button cancel, add, show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        code = findViewById(R.id.codeInput);
        name = findViewById(R.id.nameInput);
        price = findViewById(R.id.priceInput);
        cancel = findViewById(R.id.cancel);
        add = findViewById(R.id.add);
        show=findViewById(R.id.show);
        productsTextView = findViewById(R.id.products);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearField();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProduct();
            }
        });

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateProducts();
            }
        });
    }

    private void clearField() {
        code.setText("");
        name.setText("");
        price.setText("");
    }

    private void addProduct() {
        String codeText = code.getText().toString();
        String nameText = name.getText().toString();
        double priceText;

        try {
            priceText = Double.parseDouble(price.getText().toString());
        }catch(NumberFormatException e){
            priceText=0.0;
        }

        Product product = new Product(codeText, nameText, priceText);

        productList.add(product);
//        updateProducts();

        clearField();
    }

    private void updateProducts(){
        String productsText = "";
        for (Product product : productList) {
            productsText += "Code: " + product.getCode() + " - ";
            productsText += "Name: " + product.getName() + " - ";
            productsText += "Price: $" + product.getPrice() + "\n";
        }
        productsTextView.setText(productsText);
    }
}