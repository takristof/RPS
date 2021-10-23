package hu.takatskristof;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btn_rock, btn_paper, btn_scissors;
    private ImageView jatekosKep, randomKep;
    private TextView eredmeny, textViewCustom;
    private int randomTipp;
    private int sajatPont, gepPont;
    private Random random;
    private AlertDialog.Builder alertBuilder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ujJatek();
        btn_rock.setOnClickListener(view -> {
            randomTipp = random.nextInt(3);
            if(randomTipp == 1){
                gepPont++;
                randomKep.setImageResource(R.drawable.paper);
                textViewCustom.setText("A gép nyert!");
            } else if(randomTipp == 2){
                sajatPont++;
                randomKep.setImageResource(R.drawable.scissors);
                textViewCustom.setText("Te nyertél!");
            } else {
                randomKep.setImageResource(R.drawable.rock);
                textViewCustom.setText("Döntetlen!");
            }
            eredmeny.setText("Játékos: "+sajatPont+" Gép: "+gepPont);
            jatekosKep.setImageResource(R.drawable.rock);
            nyertes();

        });
        btn_paper.setOnClickListener(view -> {
            randomTipp = random.nextInt(3);
            if(randomTipp == 2){
                gepPont++;
                randomKep.setImageResource(R.drawable.scissors);
                textViewCustom.setText("A gép nyert!");
            } else if(randomTipp == 0){
                sajatPont++;
                randomKep.setImageResource(R.drawable.rock);
                textViewCustom.setText("Te nyertél!");
            } else {
                randomKep.setImageResource(R.drawable.paper);
                textViewCustom.setText("Döntetlen!");
            }
            eredmeny.setText("Játékos: "+sajatPont+" Gép: "+gepPont);
            jatekosKep.setImageResource(R.drawable.paper);
            nyertes();
        });
        btn_scissors.setOnClickListener(view -> {
            randomTipp = random.nextInt(3);
            if(randomTipp == 0){
                gepPont++;
                randomKep.setImageResource(R.drawable.rock);
                textViewCustom.setText("A gép nyert!");
            } else if(randomTipp == 1){
                sajatPont++;
                randomKep.setImageResource(R.drawable.paper);
                textViewCustom.setText("Te nyertél!");
            } else {
                randomKep.setImageResource(R.drawable.scissors);
                textViewCustom.setText("Döntetlen!");
            }
            eredmeny.setText("Játékos: "+sajatPont+" Gép: "+gepPont);
            jatekosKep.setImageResource(R.drawable.scissors);
            nyertes();
        });
    }

    private void ujJatek() {
        sajatPont = 0;
        gepPont = 0;
        eredmeny.setText("Játékos: "+sajatPont+" Gép: "+gepPont);
    }
    private void init(){
        btn_rock = findViewById(R.id.btn_rock);
        btn_paper = findViewById(R.id.btn_paper);
        btn_scissors = findViewById(R.id.btn_scissors);
        jatekosKep = findViewById(R.id.jatekosKep);
        randomKep = findViewById(R.id.randomKep);
        sajatPont = 0;
        gepPont = 0;
        eredmeny = findViewById(R.id.eredmeny);
        random = new Random();
        alertBuilder = new AlertDialog.Builder(this);
        CreateAlertDialog();
    }
    private void nyertes(){
        if(sajatPont == 3){
            alertBuilder.setTitle("Győztél!");
            alertBuilder.create();
            alertBuilder.show();
        } else if (gepPont == 3){
            alertBuilder.setTitle("VesztettélA!");
            alertBuilder.create();
            alertBuilder.show();
        }
    }


    private void CreateAlertDialog(){
        alertBuilder.setMessage("Szeretne új játékot?");
        alertBuilder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {finish();}
        });
        alertBuilder.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ujJatek();
                closeContextMenu();
            }
        });
        alertBuilder.setCancelable(false);
    }

}