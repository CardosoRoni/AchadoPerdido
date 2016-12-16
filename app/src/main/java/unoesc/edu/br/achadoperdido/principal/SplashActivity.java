package unoesc.edu.br.achadoperdido.principal;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import unoesc.edu.br.achadoperdido.R;
import unoesc.edu.br.achadoperdido.sqlite.BancoDados;
import static unoesc.edu.br.achadoperdido.sqlite.BancoDados.db;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        db = BancoDados.getDB(this);

            StartAnimations();
        }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        LinearLayout l = (LinearLayout) findViewById(R.id.main_layout);
        if (l != null) {
            l.clearAnimation();
            l.startAnimation(anim);
        }


        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        ImageView iv = (ImageView) findViewById(R.id.splash);
        if (iv != null) {
            iv.clearAnimation();
            iv.startAnimation(anim);
        }

        int SPLASH_DISPLAY_LENGTH = 5000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
        /* Create an Intent that will start the Menu-Activity. */
                Intent intent = new Intent(SplashActivity.this, PrincipalActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                SplashActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
