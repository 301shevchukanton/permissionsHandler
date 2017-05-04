package com.example.antonshevchuk.permissionshandler.extension

import android.view.View
import com.jakewharton.rxbinding.view.RxView
import hu.akarnokd.rxjava.interop.RxJavaInterop
import io.reactivex.Observable

/**
 * Created by AntonShevchuk on 04.05.2017.
 */

val View.click: Observable<Any>
	get() = RxJavaInterop.toV2Observable(RxView.clicks(this).map { Any() })