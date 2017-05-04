package com.example.antonshevchuk.permissionshandler.permissions_handler

import android.app.Activity

/**
 * Created by AntonShevchuk on 04.05.2017.
 */
interface IPermissionsHandler {
	fun checkPermission(permission: String, success: () -> Unit, error: () -> Unit = {})
	fun onStart(activity: Activity)
	fun requestPermission(permission: String, success: () -> Unit, error: () -> Unit = {})
	fun onRequestPermissionsResult(requestCode: Int,
	                               permissions: List<String>,
	                               grantResults: List<Int>)
}