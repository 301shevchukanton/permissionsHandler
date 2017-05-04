package com.example.antonshevchuk.permissionshandler.permissions_handler

/**
 * Created by AntonShevchuk on 02.05.2017.
 */
data class PermissionRequest(val permissions : Array<String>, val success: () -> Unit, val error: () -> Unit = {})