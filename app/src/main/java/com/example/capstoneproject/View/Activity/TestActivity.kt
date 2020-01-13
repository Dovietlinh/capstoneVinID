package com.example.capstoneproject.View.Activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.capstoneproject.Base.BaseActivity
import com.example.capstoneproject.R
import com.example.capstoneproject.View.Fragment.HomeFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_test.*
import kotlinx.android.synthetic.main.bottom_sheet.*
import android.os.CountDownTimer
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.capstoneproject.Model.Answer
import com.example.capstoneproject.Model.AnswerUser
import com.example.capstoneproject.Model.Question
import com.example.capstoneproject.Model.RequestUser
import com.example.capstoneproject.View.Adapter.AdapterQuestion
import com.example.capstoneproject.View.Dialog


class TestActivity : BaseActivity(), View.OnClickListener {

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<LinearLayout>
    private var adapterQuestion: AdapterQuestion? = null
    private var myRecyclerView: RecyclerView? = null
    private var txtQuestion: TextView? = null
    private var txtIndexQuestion: TextView? = null
    private var rdA:RadioButton?=null
    private var rdB:RadioButton?=null
    private var rdC:RadioButton?=null
    private var rdD:RadioButton?=null
    private var dialog = Dialog()
    private var indexQuestion=0
    lateinit var listQuestion:List<Question>
    lateinit var requestUser:RequestUser
    var listAnswerUser: MutableList<AnswerUser> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        setSupportActionBar(findViewById(R.id.toolbarExam))
        initView()
        val idExam = intent.getIntExtra("idExam", -1)
        requestUser.examID=idExam

        loadQuestion(listQuestion[indexQuestion], indexQuestion+1)
        var list: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        loadDataList(list)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        radioGroup?.setOnCheckedChangeListener { group, checkedId ->
            val answerID=listQuestion[indexQuestion].answerList as List<Answer>
            if (R.id.chooseA == checkedId){
                listAnswerUser[indexQuestion].answerID=answerID[0].id
            }
            else if (R.id.chooseB == checkedId){
                listAnswerUser[indexQuestion].answerID=answerID[1].id
            }
            else if (R.id.chooseC == checkedId){
                listAnswerUser[indexQuestion].answerID=answerID[2].id
            }
            else{
                listAnswerUser[indexQuestion].answerID=answerID[3].id
            }
        }

    }

    private fun loadQuestion(question: Question, index: Int) {
        val listAnswer=question.answerList as List<Answer>
        txtIndexQuestion!!.text=(indexQuestion+1).toString()+"/"+listQuestion.size
        txtQuestion!!.text = "Question " + index + " :" + question.content

        rdA!!.text = listAnswer[0].content
        rdB!!.text = listAnswer[1].content
        rdC!!.text = listAnswer[2].content
        rdD!!.text = listAnswer[3].content
    }

    private fun loadDataList(questionList: List<Int>?) {
        myRecyclerView = findViewById(R.id.recyclerListQuestion)
        adapterQuestion = AdapterQuestion(
            questionList!!,
            this@TestActivity
        )
        val numberOfCollumn = 3

        val layoutManager = GridLayoutManager(this@TestActivity, numberOfCollumn)
        myRecyclerView!!.layoutManager = layoutManager
        myRecyclerView!!.adapter = adapterQuestion
    }

    private fun initView() {
        txtQuestion = this.findViewById(R.id.txtQuestion)
        listQuestion = intent.getSerializableExtra("listQuestion") as List<Question>
        for(it in listQuestion){
            val answerUser=AnswerUser(it.id as Int,-1,-1)
            listAnswerUser!!.add(answerUser)
        }
        rdA = this.findViewById(R.id.chooseA)
        rdB = this.findViewById(R.id.chooseB)
        rdC = this.findViewById(R.id.chooseC)
        rdD = this.findViewById(R.id.chooseD)
        txtIndexQuestion=this.findViewById(R.id.buttonBottomSheetDialog)
        coundown(10000)
        buttonBottomSheetDialog.setOnClickListener(this)
        bottomSheetBehavior = BottomSheetBehavior.from<LinearLayout>(bottomSheet)
        bottomSheetBehavior.setBottomSheetCallback(object :
            BottomSheetBehavior.BottomSheetCallback() {
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
            buttonBottomSheetDialog -> {
                showBottomSheetDialog()
            }
            hidenBottomSheet -> {
                bottomSheetBehavior.isHideable
            }
        }
    }

    fun nextQ(view: View) {
        indexQuestion++
        if(indexQuestion>=listQuestion.size){
            indexQuestion=0
        }
        txtIndexQuestion!!.text=(indexQuestion+1).toString()+"/"+listQuestion.size
        val checkChoose = listAnswerUser[indexQuestion].answerID
        val listAnswer=listQuestion[indexQuestion].answerList as List<Answer>
        var choice=0
        val size=listAnswer.size-1
        for(i in 0 .. size step 1){
            val a=listAnswer[i].id
            val b=checkChoose
            if(listAnswer[i].id==checkChoose){
                choice=i
                break
            }
        }
        txtQuestion!!.text = "Question " + (indexQuestion+1) + " :" + listQuestion[indexQuestion].content
        rdA!!.text = listAnswer[0].content
        rdB!!.text = listAnswer[1].content
        rdC!!.text = listAnswer[2].content
//        rdD!!.text = listAnswer[3].content
        if(choice==0){
            rdA!!.isChecked=true
        }else if(choice==1){
            rdB!!.isChecked=true
        }else if(choice==2){
            rdC!!.isChecked=true
        }else{
            rdD!!.isChecked=true
        }
    }

    private fun showBottomSheetDialog() {
        val view = layoutInflater.inflate(R.layout.bottom_sheet, null)
        val dialog = BottomSheetDialog(this)
        dialog.setContentView(view)
//        view.textViewFacebook.setOnClickListener {
//            dialog.dismiss()
//        }
        dialog.show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.top_bar_exam, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.finish -> {
                val homeFragment = HomeFragment()
                val manager = supportFragmentManager
                val transaction = manager.beginTransaction()
                transaction.replace(R.id.fragment_container, homeFragment)
                transaction.addToBackStack(null)
                transaction.commit()
                return true
            }
            R.id.lamlai -> {
                val intent = intent
                finish()
                startActivity(intent)
                return true
            }
            R.id.finish -> {
                requestUser.listAnswerUser=listAnswerUser
                txtTimer.setText("Done!")
                val layout: Int = R.layout.dialog_success
                val viewGroup = findViewById<ViewGroup>(android.R.id.content)
                dialog.showCustomDialog(viewGroup, this@TestActivity, layout,requestUser)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun coundown(timeCountDown: Long) {
        object : CountDownTimer(timeCountDown, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                txtTimer.setText("" + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                requestUser.listAnswerUser=listAnswerUser
                txtTimer.setText("Done!")
                val layout: Int = R.layout.dialog_success
//                findViewById<TextView>()
                val viewGroup = findViewById<ViewGroup>(android.R.id.content)
                dialog.showCustomDialog(viewGroup, this@TestActivity, layout,requestUser)
            }

        }.start()
    }

}
