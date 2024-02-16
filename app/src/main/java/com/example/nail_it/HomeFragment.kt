package com.example.nail_it

import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.nail_it.adapter.ImageAdapter
import com.example.nail_it.adapter.ListDataAdapter
import kotlin.math.abs

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var viewPager2: ViewPager2
    private lateinit var handler: Handler

    private lateinit var imageadapter: ImageAdapter

    //RecomendationAdapter
    private lateinit var recomAdapter : ListDataAdapter.ItemListAdapter
    private lateinit var recomRecycler : RecyclerView


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
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        viewPager2 = view.findViewById(R.id.viewpager_slider)

        imageadapter = ImageAdapter(requireContext(), viewPager2)
        viewPager2.adapter = imageadapter

        imageadapter.startAutoScroll()


        //RecomendationList
        val dataList = listOf(
            ListDataAdapter.ItemListAdapter.ItemData(R.drawable.defaultimage, "UI/UX Designer", "INDICO", "Fulltime", true),
            ListDataAdapter.ItemListAdapter.ItemData(R.drawable.defaultimage1, "Game UI/UX Designer", "Alegrium", "Fulltime", true),
            ListDataAdapter.ItemListAdapter.ItemData(R.drawable.defaultimage2, "Front End Developer", "Gojek", "Fulltime", true),
            ListDataAdapter.ItemListAdapter.ItemData(R.drawable.defaultimage3, "Backend Engineer (Laravel)", "DOT Indonesia", "Fulltime", true),
            ListDataAdapter.ItemListAdapter.ItemData(R.drawable.defaultimage4, "Data Scientist", "Ninja Van", "Fulltime", true),


            )

        recomRecycler = view.findViewById(R.id.recyclerRecomendation)
        recomRecycler.addItemDecoration(ItemSpacingDecoration(8))
        recomAdapter = ListDataAdapter.ItemListAdapter(requireContext(), dataList)
        recomRecycler.layoutManager = LinearLayoutManager(requireContext())
        recomRecycler.adapter = recomAdapter


        return view


    }



    override fun onDestroyView() {
        super.onDestroyView()
        imageadapter.stopAutoScroll()
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    class ItemSpacingDecoration(private val spacing: Int) : RecyclerView.ItemDecoration(){

        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            super.getItemOffsets(outRect, view, parent, state)
            outRect.bottom = spacing
        }
    }
}