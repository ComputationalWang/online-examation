package com.example.onlineexamination.data.model

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

object SavedPreference {

    const val EMAIL= "email"
    const val GIVENNAME="given name"
    const val DISPLAYNAME="display name"
    const val PROFILEURI = "profile uri"


    private  fun getSharedPreference(ctx: Context?): SharedPreferences? {
        return PreferenceManager.getDefaultSharedPreferences(ctx)
    }

    private fun  editor(context: Context, const:String, string: String){
        getSharedPreference(
            context
        )?.edit()?.putString(const,string)?.apply()
    }

    fun getEmail(context: Context)= getSharedPreference(
        context
    )?.getString(EMAIL,"")

    fun setEmail(context: Context, email: String){
        editor(
            context,
            EMAIL,
            email
        )
    }

    fun getDisplayName(context: Context)= getSharedPreference(
        context
    )?.getString(DISPLAYNAME,"")

    fun setDisplayName(context: Context, displayName: String){
        editor(
            context,
            DISPLAYNAME,
            displayName
        )
    }

    fun setGivenName(context: Context, givenName:String){
        editor(
            context,
            GIVENNAME,
            givenName
        )
    }

    fun getGivenName(context: Context) = getSharedPreference(
        context
    )?.getString(GIVENNAME,"")

    fun setProfileUri(context: Context, profileUri:String){
        editor(
            context,
            PROFILEURI,
            profileUri
        )
    }

    fun getProfileUri(context: Context) = getSharedPreference(
        context
    )?.getString(PROFILEURI,"")

}