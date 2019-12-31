package com.bawei.chenshuaishuai.view;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.chenshuaishuai.R;
import com.bawei.chenshuaishuai.base.BaseActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;

/**
 * @author: asus
 * @date: 19/12/31
 */
public class SecendActivity extends AppCompatActivity {

    private ImageView imm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secend);
        imm = (ImageView) findViewById(R.id.imm);
        Bitmap aa = CodeUtils.createImage("陈帅帅", 400, 400, null);
        imm.setImageBitmap(aa);
        imm.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                CodeUtils.analyzeByImageView(imm, new CodeUtils.AnalyzeCallback() {
                    @Override
                    public void onAnalyzeSuccess(Bitmap mBitmap, String result) {
                        Toast.makeText(SecendActivity.this, result, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnalyzeFailed() {
                        Toast.makeText(SecendActivity.this, "解析失败", Toast.LENGTH_SHORT).show();
                    }
                });


                return false;
            }
        });
    }
}
