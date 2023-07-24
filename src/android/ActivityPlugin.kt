package com.remcos.activityplugin

import android.content.Context
import android.content.Intent
import org.json.JSONArray
import java.net.URL
import org.apache.cordova.CordovaPlugin
import org.apache.cordova.CallbackContext
import org.apache.cordova.PluginResult

class ActivityPlugin : CordovaPlugin() {

    var callbackContext: CallbackContext? = null

    override fun execute(action: String, args: JSONArray, callbackContext: CallbackContext): Boolean {
        this.callbackContext = callbackContext

        if (action == "activityMethod") {
            val message = args.optString(0, "")

            var result: PluginResult
            
            try {
                val intent = Intent(cordova.getContext(), ConnectionActivity::class.java)

                cordova.setActivityResultCallback(this);
                cordova.getActivity().startActivityForResult(intent, 100)
            } catch (e: Exception) {
                result = PluginResult(PluginResult.Status.ERROR, "Error starting the activity: " + e.message)
                callbackContext.sendPluginResult(result)
            }
            
            //Standard Cordova stuff
            result = PluginResult(PluginResult.Status.NO_RESULT)
            result.setKeepCallback(true)
            callbackContext.sendPluginResult(result)
            return true
        }
        
        return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        val result = PluginResult(PluginResult.Status.OK, data.getStringExtra("resultMessage")?:"")
        callbackContext?.sendPluginResult(result)
    }
}

