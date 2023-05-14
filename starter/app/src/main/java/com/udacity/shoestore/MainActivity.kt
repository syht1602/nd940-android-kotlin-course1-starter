package com.udacity.shoestore

import android.content.Context
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.screens.shoe_list.ShoeListFragmentDirections
import com.udacity.shoestore.utils.Constants
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.i("MainActivity created !")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        navController = this.findNavController(R.id.nav_host_fragment)
        val topLevelDestinations = setOf(R.id.shoeListFragment, R.id.loginFragment)
        appBarConfiguration = AppBarConfiguration.Builder(topLevelDestinations).build()
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.mainActivityViewModel = viewModel
        viewModel.isFabClick.observe(this) {
            if (it) {
                Timber.i("Fab clicked !")
                if ((navController.currentDestination?.id
                        ?: navController.graph.startDestination) == R.id.shoeListFragment
                ) {
                    navController.navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
                }
                viewModel.onFabClickComplete()
            }
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.shoeListFragment) {
                binding.addFab.show()
            } else {
                binding.addFab.hide()
            }
        }

        viewModel.isLogout.observe(this) {
            if (it == true) {
                val sharedPref = getSharedPreferences(Constants.MY_PREFS, Context.MODE_PRIVATE)
                sharedPref.edit().putBoolean(Constants.IS_LOGIN_IN, false).apply()
                navController.navigate(navController.graph.startDestination)
                viewModel.resetLogoutStatus()
            }
        }
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if (currentFocus != null) {
            val imm = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(this.currentFocus!!.windowToken, 0)
        }
        return super.dispatchTouchEvent(ev)
    }

    override fun onSupportNavigateUp(): Boolean {
        //If comeback to login screen from Welcome screen will do logout
        return if (navController.currentDestination?.id == R.id.welcomeFragment) {
            viewModel.doLogout()
            true
        } else {
            navController.navigateUp() || super.onSupportNavigateUp()
        }
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        //Quit app when back press in the top level of navigation screen
        if (navController.currentDestination?.id == R.id.loginFragment || navController.currentDestination?.id == R.id.shoeListFragment) {
            finish()
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> viewModel.doLogout()
        }
        return super.onOptionsItemSelected(item)
    }
}
