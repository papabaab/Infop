package com.example.infopapp.ui.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.infopapp.R;
import com.example.infopapp.ui.dashboard.fragments.PaymentsFragment;
import com.example.infopapp.ui.dashboard.fragments.thisStudentResumeFragment;
import com.example.infopapp.ui.dashboard.fragments.portfolios.PortFoliosFragment;

import static com.example.infopapp.ui.account.ConnectToAccountActivity.USERTYPE;
import static com.example.infopapp.utils.StringConstants.GUEST;
import static com.example.infopapp.utils.StringConstants.INSTRUCTOR;
import static com.example.infopapp.utils.StringConstants.STAFF;
import static com.example.infopapp.utils.StringConstants.STUDENT;

public class DashActivity extends AppCompatActivity {

    private thisStudentResumeFragment thisStudentResumeFragment;
    private PaymentsFragment paymentsFragment;
    private PortFoliosFragment portFoliosFragment;
    private FragmentManager manager;

    private ImageView resumeRect, paymentsRectImage, gradesRectImage, eventsRectImage;

    private TextView userRectTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash);
        setTitle(getText(R.string.dashboard));

        manager = getSupportFragmentManager();

        thisStudentResumeFragment = new thisStudentResumeFragment();
        paymentsFragment = new PaymentsFragment();
        portFoliosFragment = new PortFoliosFragment();

        resumeRect = findViewById(R.id.resume_rect);
        paymentsRectImage = findViewById(R.id.payment_rect);
        gradesRectImage = findViewById(R.id.grades_rect);
        eventsRectImage = findViewById(R.id.events_rect);
        userRectTv = findViewById(R.id.user_rect_text_view);

        if (USERTYPE != null) {
            switch (USERTYPE){
                case STUDENT:
                    userRectTv.setText(getText(R.string.talent_resume));
                    break;
                case STAFF:
                    userRectTv.setText(getText(R.string.portfolios));
                    break;
                case INSTRUCTOR:
                    //todo instructor dashboard
                    break;
                case GUEST:
                    //TODO guest dashboard
                    break;
                    default:
                        userRectTv.setText(getText(R.string.talent_resume));
            }
        }

        resumeRect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivityFromType();
            }
        });

    }

    private void goToThisFragment(Fragment fragment) {
        FragmentTransaction ts = manager.beginTransaction();
        ts.replace(R.id.activity_test_container, fragment);
        ts.commit();
    }

    private void goToActivityFromType(){
        if(USERTYPE!= null){
            switch (USERTYPE){
                case STUDENT:
                    goToThisFragment(thisStudentResumeFragment);
                    break;
                case STAFF:
                    goToThisFragment(portFoliosFragment);
                    break;
                case INSTRUCTOR:
                    break;
                case GUEST:
                    break;
                    default:
                        break;
            }
        }

    }
}
