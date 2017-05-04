package com.example.antonshevchuk.permissionshandler.stub_model

import android.Manifest
import com.example.antonshevchuk.permissionshandler.permissions_handler.IPermissionsHandler
import com.example.antonshevchuk.permissionshandler.stub_view.View

/**
 * Created by AntonShevchuk on 04.05.2017.
 */
class ModelImpl(val permissionsHandler: IPermissionsHandler) : Model {
	override fun onDestroy() {
		this.view = null
	}

	private var view : View? = null

	override fun onCreate(view: View) {
		this.view = view
	}

	override fun doSomethingAwesome() {
		permissionsHandler.requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, {
			view?.render("WRITE_EXTERNAL_STORAGE granted")
		}, {
			view?.render("WRITE_EXTERNAL_STORAGE denied")
		})

		permissionsHandler.requestPermission(Manifest.permission.READ_CONTACTS, {
			view?.render("READ_CONTACTS granted")
		}, {
			view?.render("READ_CONTACTS denied")
		})

		permissionsHandler.requestPermission(Manifest.permission.ACCESS_WIFI_STATE, {
			view?.render("ACCESS_WIFI_STATE granted")
		}, {
			view?.render("ACCESS_WIFI_STATE denied")
		})
	}
}