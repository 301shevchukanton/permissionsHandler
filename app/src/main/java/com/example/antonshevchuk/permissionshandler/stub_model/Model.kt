package com.example.antonshevchuk.permissionshandler.stub_model

import com.example.antonshevchuk.permissionshandler.stub_view.View

/**
 * Created by AntonShevchuk on 04.05.2017.
 */
interface Model {
	fun doSomethingAwesome()
	fun onCreate(view:View)
	fun onDestroy()
}