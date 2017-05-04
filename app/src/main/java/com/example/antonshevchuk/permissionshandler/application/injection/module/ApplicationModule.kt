package com.example.antonshevchuk.permissionshandler.application.injection.module

import android.content.Context
import com.example.antonshevchuk.permissionshandler.permissions_handler.IPermissionsHandler
import com.example.antonshevchuk.permissionshandler.permissions_handler.PermissionsHandler
import com.example.antonshevchuk.permissionshandler.stub_model.Model
import com.example.antonshevchuk.permissionshandler.stub_model.ModelImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by AntonShevchuk on 04.05.2017.
 */
@Module
class ApplicationModule(private val context: Context) {
	@Singleton
	@Provides
	fun permissionsHandler(): IPermissionsHandler = PermissionsHandler(context)

	@Singleton
	@Provides
	fun model(permissionsHandler: IPermissionsHandler): Model = ModelImpl(permissionsHandler)

	@Provides
	fun context() = context
}