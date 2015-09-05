package com.mangoshine.mangocards.ui;

import android.app.Activity;
import android.os.Bundle;
import butterknife.ButterKnife;
import com.mangoshine.mangocards.R;

public class LoginActivity extends Activity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);
  }
}
