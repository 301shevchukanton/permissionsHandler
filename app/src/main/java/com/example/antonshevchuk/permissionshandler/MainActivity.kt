package com.example.antonshevchuk.permissionshandler

import android.Manifest
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.antonshevchuk.permissionshandler.application.injection.app
import com.example.antonshevchuk.permissionshandler.extension.click
import com.example.antonshevchuk.permissionshandler.permissions_handler.IPermissionsHandler
import com.example.antonshevchuk.permissionshandler.stub_model.Model
import com.example.antonshevchuk.permissionshandler.stub_view.View
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), View {

	@Inject
	lateinit var permissionsHandler: IPermissionsHandler
	@Inject
	lateinit var model: Model

	override fun onStart() {
		super.onStart()
		permissionsHandler.onStart(this)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		app.injection.applicationComponent().inject(this)
		setContentView(R.layout.activity_main)
		model.onCreate(this)
		btnCheckPermission
				.click
				.subscribe {
					permissionsHandler.checkPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE, {
						Toast.makeText(this, "WRITE_EXTERNAL_STORAGE permission granted", Toast.LENGTH_LONG).show()
					}, {
						Toast.makeText(this, "WRITE_EXTERNAL_STORAGE permission denied", Toast.LENGTH_LONG).show()

					})
				}
		btnRequestPermission
				.click
				.subscribe {
					model.doSomethingAwesome()
				}
	}

	override fun onDestroy() {
		super.onDestroy()
		model.onDestroy()
	}

	override fun render(result: String) {
		Toast.makeText(this, result, Toast.LENGTH_LONG).show()
	}

	override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults)
		permissionsHandler.onRequestPermissionsResult(requestCode, permissions.toList(), grantResults.toList())
	}
}
