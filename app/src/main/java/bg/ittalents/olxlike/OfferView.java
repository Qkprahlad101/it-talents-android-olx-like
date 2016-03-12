package bg.ittalents.olxlike;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import model.Offer;
import model.OfferManager;

public class OfferView extends AppCompatActivity {

    TextView text;

    OfferManager manager = OfferManager.getInstance(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_view);
        Bundle bundle = getIntent().getExtras();
        long id = bundle.getLong("idOffer");
        Offer offer = manager.getOfferByID(id);

        text = (TextView) findViewById(R.id.offer_view_description_text);
        text.setText(offer.getDescription());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_offer:
                startActivity(new Intent(OfferView.this, AddOffer.class));
                break;
            case R.id.action_home:
                startActivity(new Intent(OfferView.this, Home.class));
                break;
            case R.id.action_messages:
                startActivity(new Intent(OfferView.this, MyMessages.class));
                break;
            case R.id.action_profile:
                //TODO да се направи да праща към твоя профил ...
                startActivity(new Intent(OfferView.this, ViewUser.class));
                break;
            case R.id.action_settings:
                startActivity(new Intent(OfferView.this, Settings.class));
                break;
            case R.id.action_logout:
                //TODO да те логаутва...
                break;
            default:
                break;
        }

        return true;
    }
}
