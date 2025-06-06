//package com.example.newbieq.ui.home
//
//import android.os.Bundle
//import androidx.activity.viewModels
//import androidx.appcompat.widget.SearchView
//import androidx.lifecycle.Observer
//import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.newbieq.R
//import com.example.newbieq.databinding.ActivityHomeBinding
//import com.example.newbieq.BaseActivity
//
//class HomeActivity : BaseActivity() {
//
//    private lateinit var binding: ActivityHomeBinding
//    private lateinit var itemAdapter: ItemAdapter
//    private lateinit var categoryAdapter: CategoryAdapter
//
//    // Using ViewModel with activityViewModels delegate to fetch data
//    private val homeViewModel: HomeViewModel by viewModels()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding = ActivityHomeBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // Setup Category Adapter
//        val categories = listOf("Books", "Furniture", "Electronics", "Clothing", "Other") // Example categories
//        categoryAdapter = CategoryAdapter(categories) { selectedCategory ->
//            (selectedCategory) // Implement this function to filter items
//        }
//
//        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        binding.categoryRecyclerView.adapter = categoryAdapter
//
//
//        // Sample image URLs for the carousel
//        val carouselImages = listOf(
//            R.drawable.bird,
//            R.drawable.bird,
//            R.drawable.bird
//        )
//        // Setup Image Carousel (ViewPager)
//        val carouselAdapter = ImageCarouselAdapter(carouselImages)
//        binding.viewPager.adapter = carouselAdapter
//
//        // Initialize RecyclerView and Adapter
//        itemAdapter = ItemAdapter(emptyList())
//        // Set GridLayoutManager with 2 items per row
//        val layoutManager = GridLayoutManager(this, 2)  // 2 items per row
//        binding.recyclerView.layoutManager = layoutManager
//        binding.recyclerView.adapter = itemAdapter
//
//        // Observe LiveData from HomeViewModel
//        homeViewModel.items.observe(this, Observer { items ->
//            // Update RecyclerView when data changes
//            itemAdapter.updateItems(items)
//        })
//
//        // Fetch items when the activity is created
//        homeViewModel.fetchItems()
//
//        // Search functionality (filter items as user types)
//        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                return false
//            }
//
//            override fun onQueryTextChange(newText: String?): Boolean {
//                homeViewModel.filterItems(newText ?: "")
//                return true
//            }
//        })
//    }
//}


package com.example.newbieq.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newbieq.R
import com.example.newbieq.databinding.FragmentHomeBinding // Use FragmentHomeBinding

class HomeFragment : Fragment(R.layout.fragment_home) { // Changed to HomeFragment

    private lateinit var binding: FragmentHomeBinding
    private lateinit var itemAdapter: HomeItemAdapter
    private lateinit var categoryAdapter: CategoryAdapter

    // Using ViewModel with fragmentViewModels delegate to fetch data
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Setup Category Adapter
        val categories = listOf("Books", "Furniture", "Electronics", "Clothing", "Other") // Example categories
        categoryAdapter = CategoryAdapter(categories) { selectedCategory ->
            // Implement category selection logic, e.g., filter items based on selected category
        }

        // Set up the category RecyclerView
        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.categoryRecyclerView.adapter = categoryAdapter

        // Sample image URLs for the carousel
        val carouselImages = listOf(
            R.drawable.slider_image_1,
            R.drawable.slider_image_2,
            R.drawable.slider_image_3
        )
        // Setup Image Carousel (ViewPager)
        val carouselAdapter = ImageCarouselAdapter(carouselImages)
        binding.viewPager.adapter = carouselAdapter

        // Initialize RecyclerView and Adapter for items
        itemAdapter = HomeItemAdapter(emptyList()) // Empty list initially
        val layoutManager = GridLayoutManager(requireContext(), 2)  // 2 items per row
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.adapter = itemAdapter

        // Observe LiveData from HomeViewModel
        homeViewModel.items.observe(viewLifecycleOwner, Observer { items ->
            // Update RecyclerView when data changes
            itemAdapter.updateItems(items)
        })

        // Fetch items when the fragment is created
        homeViewModel.fetchItems()

        // Search functionality (filter items as user types)
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                homeViewModel.filterItems(newText ?: "")
                return true
            }
        })
    }
}