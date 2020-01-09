package com.example.capstoneproject.View.Activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.capstoneproject.Base.BaseActivity
import com.example.capstoneproject.R
import com.example.capstoneproject.View.Fragment.BottomSheetFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.bottom_sheet.view.*


class TestActivity : BaseActivity(), View.OnClickListener {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        initView()
    }

    private fun initView() {
        buttonSlideUp.setOnClickListener(this)
        buttonBottomSheetDialog.setOnClickListener(this)
        buttonBottomSheetDialogFragment.setOnClickListener(this)
        textViewFacebook.setOnClickListener {
            Toast.makeText(this,"Facebook",Toast.LENGTH_SHORT).show()
        }
        textViewTwitter.setOnClickListener {
            Toast.makeText(this,"Twitter",Toast.LENGTH_SHORT).show()
        }
        textViewInstagram.setOnClickListener {
            Toast.makeText(this,"Instagram",Toast.LENGTH_SHORT).show()
        }
        textViewLinkedin.setOnClickListener {
            Toast.makeText(this,"Linkedin",Toast.LENGTH_SHORT).show()
        }
        bottomSheetBehavior = BottomSheetBehavior.from<ConstraintLayout>(bottomSheet)
        bottomSheetBehavior.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when (newState) {
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        buttonSlideUp.text = "Slide Up"
                    }
                    BottomSheetBehavior.STATE_HIDDEN -> {

                    }
                    BottomSheetBehavior.STATE_EXPANDED -> {
                        buttonSlideUp.text = "Slide Down"
                    }
                    BottomSheetBehavior.STATE_DRAGGING -> {

                    }
                    BottomSheetBehavior.STATE_SETTLING -> {

                    }
                }
            }
        })
    }

    override fun onClick(clickView: View?) {
        when (clickView) {
            buttonSlideUp -> {
                slideUpDownBottomSheet()
            }
            buttonBottomSheetDialogFragment -> {
                showBottomSheetDialogFragment()
            }
            buttonBottomSheetDialog -> {
                showBottomSheetDialog()
            }
        }
    }

    private fun slideUpDownBottomSheet() {
        if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            buttonSlideUp.text = "Slide Down"
        } else {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED;
            buttonSlideUp.text = "Slide Up"
        }
    }

    private fun showBottomSheetDialog() {
        val view = layoutInflater.inflate(R.layout.bottom_sheet, null)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)
        view.textViewFacebook.setOnClickListener {
            Toast.makeText(this, "Facebook", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }
        view.textViewTwitter.setOnClickListener {
            Toast.makeText(this, "Twitter", Toast.LENGTH_SHORT).show()
        }
        view.textViewInstagram.setOnClickListener {
            Toast.makeText(this, "Instagram", Toast.LENGTH_SHORT).show()
        }
        view.textViewLinkedin.setOnClickListener {
            Toast.makeText(this, "Linkedin", Toast.LENGTH_SHORT).show()
        }
        dialog.show()
    }

    private fun showBottomSheetDialogFragment() {
        val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }
}
