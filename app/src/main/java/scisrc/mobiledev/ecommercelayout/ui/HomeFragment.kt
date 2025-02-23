package scisrc.mobiledev.ecommercelayout.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import scisrc.mobiledev.ecommercelayout.R
import scisrc.mobiledev.ecommercelayout.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var productAdapter: ProductAdapter
    private lateinit var promoAdapter: ProductAdapter

    private val productList = mutableListOf<Product>()
    private val promoList = mutableListOf<Product>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 🔹 ตั้งค่า RecyclerView สำหรับสินค้าแนะนำ
        binding.recyclerViewProducts.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        productAdapter = ProductAdapter(productList)
        binding.recyclerViewProducts.adapter = productAdapter

        // 🔹 ตั้งค่า RecyclerView สำหรับโปรโมชั่น
        binding.recyclerViewPromos.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        promoAdapter = ProductAdapter(promoList)
        binding.recyclerViewPromos.adapter = promoAdapter

        // 🔹 โหลดข้อมูล
        loadProducts()
        loadPromotions()
    }

    private fun loadProducts() {
        productList.add(Product("ScooterONE", "25,000 บาท", R.drawable.scooter1, "scooter"))
        productList.add(Product("ScooterTWO", "45,000 บาท", R.drawable.scooter2, "scooter"))
        productList.add(Product("CarOld", "700,000 บาท", R.drawable.car1, "car"))
        productList.add(Product("Mini", "3,200,000 บาท", R.drawable.car2, "car"))
        productAdapter.notifyDataSetChanged()
    }

    private fun loadPromotions() {
        promoList.add(Product("ScooterONE", "ลดเหลือ 20,000 บาท", R.drawable.scooter1, "scooter"))
        promoList.add(Product("ScooterTWO", "ลดเหลือ 39,000 บาท", R.drawable.scooter2, "scooter"))
        promoList.add(Product("CarOld", "ลดเหลือ 680,000 บาท", R.drawable.car1, "car"))
        promoList.add(Product("Mini", "ลดเหลือ 3,100,000 บาท", R.drawable.car2, "car"))
        promoAdapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
