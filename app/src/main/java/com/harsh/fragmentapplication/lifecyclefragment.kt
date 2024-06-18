package com.harsh.fragmentapplication

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [lifecyclefragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class lifecyclefragment : Fragment(), ActivityInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var mainActivity: MainActivity
    var btnIncrement : Button? = null
    var btnDecrement : Button? = null
    var btnResult : Button? = null
    var btnRed : Button?=null
   var llFragment : LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        mainActivity.activityInterface = this
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lifecyclefragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Toast.makeText(requireContext(), "this is onView created", Toast.LENGTH_SHORT).show()
        btnIncrement = view.findViewById(R.id.btnIncrement)
        btnDecrement = view.findViewById(R.id.btnDecrement)
        btnResult = view.findViewById(R.id.btnResult)
        btnRed = view.findViewById(R.id.btnRed)
        llFragment=view.findViewById(R.id.llFragment)
        btnIncrement?.setOnClickListener {
            mainActivity.btnIncrement()
        }
        btnDecrement?.setOnClickListener {
            mainActivity.btnDecrement()
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(requireContext(), "this is onStart created", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(requireContext(), "this is onResume created", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(requireContext(), "this is onPause created", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(requireContext(), "this is onStop created", Toast.LENGTH_SHORT).show()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Toast.makeText(requireContext(), "this is onSaveInstanceState created", Toast.LENGTH_SHORT)
            .show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Toast.makeText(requireContext(), "this is onAttach created", Toast.LENGTH_SHORT).show()
    }


    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(requireContext(), "this is onDestroy created", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Toast.makeText(requireContext(), "this is onDestroy view created", Toast.LENGTH_SHORT)
            .show()
    }

    override fun onDetach() {
        super.onDetach()
        Toast.makeText(requireContext(), "this is onDetach created", Toast.LENGTH_SHORT).show()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        Toast.makeText(requireContext(), "this is onViewStateRestored created", Toast.LENGTH_SHORT)
            .show()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment lifecyclefragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            lifecyclefragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun changeColor(number: Int) {
    when(number){
        1-> llFragment?.setBackgroundColor(ContextCompat.getColor(requireContext(),R.color.red))
    }
    }
}
