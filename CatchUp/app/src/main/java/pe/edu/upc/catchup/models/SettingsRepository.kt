package pe.edu.upc.catchup.models

import android.content.Context
import android.preference.PreferenceManager

class SettingsRepository(val context: Context) {
    companion object {
        val didShowOnboarding = "didShowOnboarding"
    }

    val preferences = PreferenceManager
            .getDefaultSharedPreferences(context)

    var didShowOnboarding: Boolean = preferences
            .getBoolean(
                    SettingsRepository.didShowOnboarding,
                    false)
    set(value) = preferences.edit().putBoolean(
            SettingsRepository.didShowOnboarding, value)
            .apply()

    var shouldShowOnboarding: Boolean = !didShowOnboarding
    set(value) {
        didShowOnboarding = !value
    }

}