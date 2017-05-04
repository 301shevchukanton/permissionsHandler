package com.example.antonshevchuk.permissionshandler.permissions_handler

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import java.util.*


/**
 * Created by AntonShevchuk on 02.05.2017.
 */
class PermissionsHandler(val context: Context) : IPermissionsHandler {

	val permissionsRequest: MutableMap<Int, PermissionRequest> = mutableMapOf()

	var callingActivity: Activity? = null
	var queue: Queue<PermissionRequest> = LinkedList<PermissionRequest>();

	override fun checkPermission(permission: String, success: () -> Unit, error: () -> Unit) {
		val permissionGranted = ContextCompat.checkSelfPermission(context,
				permission)
		if (permissionGranted == PackageManager.PERMISSION_GRANTED) {
			success.invoke()
		} else {
			error.invoke()
		}
	}

	override fun onStart(activity: Activity) {
		callingActivity = activity
	}

	override fun requestPermission(permission: String, success: () -> Unit, error: () -> Unit) {
		if (ContextCompat.checkSelfPermission(context,
				permission) != PackageManager.PERMISSION_GRANTED) {
			val permissionRequest = PermissionRequest(arrayOf(permission), success, error)
			if (queue.isEmpty()) {
				sendPermissionRequest(arrayOf(permission), permissionRequest)
			}
			queue.add(permissionRequest)
		} else {
			success.invoke()
		}

	}

	override fun onRequestPermissionsResult(requestCode: Int,
	                                        permissions: List<String>,
	                                        grantResults: List<Int>) {
		permissionsRequest.get(requestCode)?.let {
			if (grantResults.isNotEmpty()
					&& grantResults[0] == PackageManager.PERMISSION_GRANTED) {
				it.success.invoke()
			} else {
				it.error.invoke()
			}

			queue.remove()
			if (queue.isNotEmpty()) {
				sendPermissionRequest(queue.element().permissions, queue.element())
			}
			permissionsRequest.remove(requestCode)
		}
	}

	private fun sendPermissionRequest(permissions: Array<String>, permissionRequest: PermissionRequest) {
		val currentMapSize = permissionsRequest.size
		permissionsRequest.put(currentMapSize, permissionRequest)
		ActivityCompat.requestPermissions(callingActivity as Activity,
				permissions,
				currentMapSize)
	}
}
