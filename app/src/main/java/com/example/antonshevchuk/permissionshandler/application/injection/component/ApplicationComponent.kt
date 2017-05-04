package com.example.antonshevchuk.permissionshandler.application.injection.component

import android.content.Context
import com.example.antonshevchuk.permissionshandler.MainActivity
import com.example.antonshevchuk.permissionshandler.application.injection.module.ApplicationModule
import com.example.antonshevchuk.permissionshandler.permissions_handler.IPermissionsHandler
import com.example.antonshevchuk.permissionshandler.stub_model.Model
import dagger.Component
import javax.inject.Singleton

/**
 * Created by AntonShevchuk on 04.05.2017.
 */
@Singleton
@Component(modules = arrayOf(
		ApplicationModule::class))
interface ApplicationComponent {

	fun context(): Context

	fun permissionsHandler(): IPermissionsHandler

	fun model(): Model

	fun inject(mainActivity: MainActivity)
}