package com.example.epokafcm.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.epokafcm.databinding.FragmentDashboardBinding
import com.example.epokafcm.utils.HttpRequestConfig
import java.io.File

//val dotenv = dotenv{
//    directory = "assets"
//    filename = "env"
//}

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val username = dotenv["API_ENDPOINT_USERNAME"]
//        val password = dotenv["API_ENDPOINT_PASSWORD"]
//        val auth = "Basic " + Base64.encodeToString("$username:$password".toByteArray(), Base64.NO_WRAP)

        val config = HttpRequestConfig(
            url = "http://172.236.203.173:8000/timetable/",
            method = "GET",
//            headers = mapOf("Authorization" to auth)
        )

        val currentWorkingDirectory = System.getProperty("user.dir")


//        CoroutineScope(Dispatchers.Main).launch {
//            try {
//                val response = sendHttpRequest(config)
//                val textView: TextView = binding.textDashboard
//                textView.text = response
//            } catch (e: Exception) {
//                val textView: TextView = binding.textDashboard
//                textView.text = e.message
//            }
//        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}