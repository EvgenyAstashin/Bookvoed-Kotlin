package com.astashin.bookvoed

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.astashin.bookvoed.di.AppComponent
import com.astashin.bookvoed.di.DaggerAppComponent

class BookvoedApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}

fun AppCompatActivity.bookvoedApp(): BookvoedApplication = application as BookvoedApplication

fun Fragment.bookvoedApp(): BookvoedApplication = activity?.application as BookvoedApplication