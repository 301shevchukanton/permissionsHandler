package com.example.antonshevchuk.permissionshandler.application

import android.app.Application
import com.example.antonshevchuk.permissionshandler.application.injection.Injection


/**
 * Created by AntonShevchuk on 04.05.2017.
 */
class App : Application() {
	companion object {
		lateinit var INSTANCE: App
			private set
	}

	lateinit var injection: Injection
		private set

	override fun onCreate() {
		super.onCreate()
		INSTANCE = this
		initInjection()
	}

	private fun initInjection() {
		injection = Injection(this)
	}
}