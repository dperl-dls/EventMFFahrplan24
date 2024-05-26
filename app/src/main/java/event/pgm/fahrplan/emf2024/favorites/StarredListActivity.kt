package event.pgm.fahrplan.emf2024.favorites

import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import info.metadude.android.eventfahrplan.commons.logging.Logging
import event.pgm.fahrplan.emf2024.R
import event.pgm.fahrplan.emf2024.base.AbstractListFragment.OnSessionListClick
import event.pgm.fahrplan.emf2024.base.BaseActivity
import event.pgm.fahrplan.emf2024.details.SessionDetailsActivity
import event.pgm.fahrplan.emf2024.repositories.AppRepository
import event.pgm.fahrplan.emf2024.utils.ConfirmationDialog.OnConfirmationDialogClicked

class StarredListActivity :
    BaseActivity(),
    OnSessionListClick,
    OnConfirmationDialogClicked {

    companion object {

        private const val LOG_TAG = "StarredListActivity"

        fun start(context: Context) {
            val intent = Intent(context, StarredListActivity::class.java)
            context.startActivity(intent)
        }
    }

    private val logging = Logging.get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_list)
        val toolbar = requireViewByIdCompat<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionBarColor = ContextCompat.getColor(this, R.color.colorActionBar)
        supportActionBar!!.setBackgroundDrawable(ColorDrawable(actionBarColor))
        if (savedInstanceState == null) {
            addFragment(R.id.container, StarredListFragment(), StarredListFragment.FRAGMENT_TAG)
        }
    }

    override fun onSessionListClick(sessionId: String) {
        if (AppRepository.updateSelectedSessionId(sessionId)) {
            SessionDetailsActivity.start(this)
        }
    }

    override fun onAccepted(requestCode: Int) {
        val fragment = findFragment(StarredListFragment.FRAGMENT_TAG)
        if (fragment is StarredListFragment) {
            fragment.deleteAllFavorites()
        } else {
            logging.e(LOG_TAG, "StarredListFragment not found")
        }
    }

}
