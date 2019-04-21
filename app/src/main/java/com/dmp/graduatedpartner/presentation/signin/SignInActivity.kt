package com.dmp.graduatedpartner.presentation.signin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.dmp.graduatedpartner.R
import com.dmp.graduatedpartner.databinding.ActivitySigninBinding
import com.dmp.graduatedpartner.presentation.base.BaseActivity
import com.dmp.graduatedpartner.presentation.score.ScoreActivity
import com.dmp.graduatedpartner.presentation.signin.adapter.SignInViewPagerAdapter
import com.dmp.graduatedpartner.presentation.start.StartActivity
import com.dmp.graduatedpartner.utils.emptyToNull
import kotlinx.android.synthetic.main.activity_signin.*
import org.koin.android.viewmodel.ext.android.viewModel

class SignInActivity : BaseActivity() {
    private val viewModel: SignInViewModel by viewModel()

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivitySigninBinding>(this, R.layout.activity_signin)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.vm = viewModel
        binding.lifecycleOwner = this
        bindView()
    }

    private fun bindView() {
        val viewPagerAdapter = SignInViewPagerAdapter(this@SignInActivity)
        viewpager_signin.adapter = viewPagerAdapter
        viewpager_signin.offscreenPageLimit = viewpager_signin.adapter?.count ?: 0

        viewpager_signin.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                if(position == 2){
                    btn_signin_confirm.visibility = View.VISIBLE
                }
                else{
                    btn_signin_confirm.visibility = View.GONE
                }
            }
        })

        btn_signin_next.setOnClickListener {
            viewpager_signin.currentItem += 1
        }

        btn_signin_confirm.setOnClickListener {
            val userName = viewPagerAdapter.getView(0)?.findViewById<EditText>(R.id.edit_sigin1_name)?.text.emptyToNull()
            val totalSemester =
                (viewPagerAdapter.getView(0)?.findViewById<Spinner>(R.id.spinner_sigin1_school)?.selectedItem as Int?)
            val currentSemester =
                (viewPagerAdapter.getView(0)?.findViewById<Spinner>(R.id.spinner_sigin1_current_grade)?.selectedItem as Int?)
            val totalGrade = viewPagerAdapter.getView(1)?.findViewById<EditText>(R.id.edit_sigin2_total_grade)?.text.emptyToNull()
            val currentGrade = viewPagerAdapter.getView(2)?.findViewById<EditText>(R.id.edit_sigin3_my_grade)?.text.emptyToNull()

            if (userName != null && totalSemester != null && currentSemester != null && totalGrade != null && currentGrade != null) {
                viewModel.setData(
                    userName.toString(),
                    totalSemester,
                    currentSemester,
                    totalGrade.toString().toInt(),
                    currentGrade.toString().toInt()
                )
                startActivity(
                    Intent(
                        this@SignInActivity,
                        ScoreActivity::class.java
                    ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                )
            }
            else{
                Toast.makeText(this@SignInActivity, "기본 폼을 모두 입력해주세요", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun onPressBackButton(view: View) {
        val nextIntent = Intent(
            this@SignInActivity,
            StartActivity::class.java
        ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(nextIntent)
    }
}