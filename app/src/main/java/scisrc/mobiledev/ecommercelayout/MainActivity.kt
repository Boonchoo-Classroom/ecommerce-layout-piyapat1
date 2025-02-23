package scisrc.mobiledev.ecommercelayout

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import scisrc.mobiledev.ecommercelayout.databinding.ActivityMainBinding
import scisrc.mobiledev.ecommercelayout.ui.CartFragment
import scisrc.mobiledev.ecommercelayout.ui.FavoritesFragment
import scisrc.mobiledev.ecommercelayout.ui.HomeFragment
import scisrc.mobiledev.ecommercelayout.ui.ProfileFragment
import scisrc.mobiledev.ecommercelayout.ui.ProductsFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ตั้งค่า Toolbar
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "CAR"
        // ตั้งค่า DrawerLayout
        drawerLayout = binding.drawerLayout
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, binding.toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // ตั้งค่าให้กดเมนูแล้วเปลี่ยนหน้า
        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_home -> replaceFragment(HomeFragment()) // ไปหน้า Home
                R.id.nav_profile -> replaceFragment(ProfileFragment()) // ไปหน้า Profile
                R.id.nav_favorites -> replaceFragment(FavoritesFragment())
                R.id.nav_products -> replaceFragment(ProductsFragment())
                R.id.nav_cart -> replaceFragment(CartFragment())
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // โหลดหน้าแรกเมื่อเปิดแอป
        if (savedInstanceState == null) {
            replaceFragment(HomeFragment())
            binding.navView.setCheckedItem(R.id.nav_home)
        }
    }

    // ฟังก์ชันเปลี่ยน Fragment
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
