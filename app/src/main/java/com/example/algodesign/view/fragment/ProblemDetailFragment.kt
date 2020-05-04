package com.example.algodesign.view.fragment

import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.algodesign.databinding.FragmentProblemDetailBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProblemDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProblemDetailFragment : Fragment() {
    lateinit var binding: FragmentProblemDetailBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProblemDetailBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url = ProblemDetailFragmentArgs.fromBundle(arguments).problemUrl
        binding.apply {
            progressCircular.visibility = View.VISIBLE
            toolbar.title = "Problem Solution"
            (activity as AppCompatActivity).let {
                it.setSupportActionBar(toolbar)
                it.supportActionBar?.setDisplayHomeAsUpEnabled(true);
                it.supportActionBar?.setDisplayShowHomeEnabled(true);
            }

            webview.settings.javaScriptEnabled = true
            webview.webViewClient = object : WebViewClient(){

                override fun onPageFinished(view: WebView?, url: String?) {
                    progressCircular.visibility = View.GONE
                    super.onPageFinished(view, url)
                }
            }

            webview.settings.allowFileAccessFromFileURLs = true;
            webview.settings.allowUniversalAccessFromFileURLs = true;
            val cookieManager =  CookieManager .getInstance()
            cookieManager.setAcceptCookie ( true )
            cookieManager.setAcceptThirdPartyCookies (webview, true )

            // Extension of header. It seems that it can be expanded with a function called HashMap
            val extraHeaders =  HashMap < String , String > ()
            extraHeaders [ " User-Agent " ] =  " Mozilla / 5.0 (Linux; U; Android 2.2.1; en-us; Nexus One Build / FRG83) AppleWebKit / 533.1 (KHTML, like Gecko) Version / 4.0 Mobile Safari / 533.1 "
            webview.loadUrl ( url , extraHeaders)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProblemDetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProblemDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
