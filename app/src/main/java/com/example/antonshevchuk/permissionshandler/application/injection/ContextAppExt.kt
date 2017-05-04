package com.example.antonshevchuk.permissionshandler.application.injection

import android.content.Context
import com.example.antonshevchuk.permissionshandler.application.App

/**
 * Created by AntonShevchuk on 04.05.2017.
 */
val Context.app: App
    get() = App.INSTANCE