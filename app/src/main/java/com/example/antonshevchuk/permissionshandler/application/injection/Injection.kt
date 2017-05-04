package com.example.antonshevchuk.permissionshandler.application.injection

import android.content.Context
import com.example.antonshevchuk.permissionshandler.application.injection.component.ApplicationComponent
import com.example.antonshevchuk.permissionshandler.application.injection.component.DaggerApplicationComponent
import com.example.antonshevchuk.permissionshandler.application.injection.module.ApplicationModule


/**
 * Created by AntonShevchuk on 04.05.2017.
 */
class Injection(context: Context) {

	private val applicationComponent: ApplicationComponent = DaggerApplicationComponent.builder()
			.applicationModule(ApplicationModule(context))
			.build()

	fun applicationComponent(): ApplicationComponent = applicationComponent


}