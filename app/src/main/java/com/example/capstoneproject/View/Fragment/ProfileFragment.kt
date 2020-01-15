package com.example.capstoneproject.View.Fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.capstoneproject.API.ApiService
import com.example.capstoneproject.API.RestClient
import com.example.capstoneproject.User
import com.example.capstoneproject.R
import com.example.capstoneproject.databinding.ProfileFragmentBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater!!.inflate(R.layout.profile_fragment,container,false)
        val valueAction = this.arguments!!.getInt("userID")
        val binding : ProfileFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.profile_fragment,container,false)
        val service = RestClient.retrofitInstance!!.create(ApiService::class.java)
        var test=service.detailUser(valueAction)
        val llProgressBar:LinearLayout=view.findViewById(R.id.lProgressBar)
        llProgressBar?.visibility = View.VISIBLE
        test.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if(response.body()!=null){
                    var user=response.body() as User
                    binding?.setUser(user)
                }else{
                    Toast.makeText(context,"User null",Toast.LENGTH_LONG).show()
                }
                llProgressBar.visibility = View.GONE
            }
            override fun onFailure(call: Call<User>, t: Throwable) {
                Toast.makeText(context,"Error",Toast.LENGTH_LONG).show()
                llProgressBar.visibility = View.GONE
            }
        })
        return binding.root
    }
    override fun onPause() {
        super.onPause()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }
}